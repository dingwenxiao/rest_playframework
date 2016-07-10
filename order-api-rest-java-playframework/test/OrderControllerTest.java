import org.junit.*;
import play.test.*;
import play.Application;
import play.mvc.*;
import static play.test.Helpers.*;
import static org.junit.Assert.*;
import play.db.jpa.*;
import java.util.List;
import models.*;
import org.dbunit.*;
import org.dbunit.dataset.*;
import org.dbunit.dataset.xml.*;
import java.util.HashMap;
import java.io.FileInputStream;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import play.libs.ws.*;
import play.libs.Json;

public class OrderControllerTest {
    int timeout = 4000;
    JndiDatabaseTester databaseTester;
    Application app;
    ObjectNode dataOk;
    ObjectNode dataError1;
    ObjectNode dataError2;

    public OrderControllerTest() {
        dataOk = Json.newObject();
        dataOk.put("customerName", "Owen_xiao");
        dataOk.put("totalPrice", "54");
        dataOk.put("orderTime","2016-07-06 01:44:29");
        
        dataError1 = Json.newObject();
        dataError1.put("customerName", "");

        dataError2 = Json.newObject();
    }

    // Data needed for create the fake
    private static HashMap<String, String> settings() {
        HashMap<String, String> settings = new HashMap<String, String>();
        settings.put("db.default.url", "jdbc:mysql://localhost:3306/play_test");
        settings.put("db.default.username", "root");
        settings.put("db.default.password", "xiaodingwen");
        settings.put("db.default.jndiName", "DefaultDS");
        settings.put("jpa.default", "mySqlPersistenceUnit");
        return(settings);
    }

    @BeforeClass
    public static void createTables() {
        Application fakeApp = Helpers.fakeApplication(settings());
        running (fakeApp, () -> {
            JPA.withTransaction(() -> {});
        });
    }

    @Before
    public void initializeData() throws Exception {
        app = Helpers.fakeApplication(settings());
        databaseTester = new JndiDatabaseTester("DefaultDS");
        IDataSet initialDataSet = new FlatXmlDataSetBuilder().build(new FileInputStream("test/resources/orders_dataset_1.xml"));
        databaseTester.setDataSet(initialDataSet);
        databaseTester.onSetup();
    }

    @After
    public void closeDB() throws Exception {
        databaseTester.onTearDown();
    }

    @Test
    public void testOrderExists() {
        running(testServer(3333, app), () -> {
            WSResponse response = WS
                .url("http://localhost:3333/orders/1")
                .get()
                .get(timeout);

            assertEquals(OK, response.getStatus());
            assertEquals("application/json; charset=utf-8", response.getHeader("Content-Type"));

            JsonNode responseJson = response.asJson();
            assertTrue(responseJson.isObject());
            assertEquals(1,responseJson.get("orderId").asInt());
            assertEquals("\"Owen\"",responseJson.get("customerName").toString());
        });
    }

    @Test
    public void testOrderNotExists() {
        running(testServer(3333, app), () -> {
            WSResponse response = WS
                .url("http://localhost:3333/orders/8")
                .get()
                .get(timeout);

            assertEquals(NOT_FOUND, response.getStatus());
            assertEquals("application/json; charset=utf-8", response.getHeader("Content-Type"));

            JsonNode responseJson = response.asJson();
            assertTrue(responseJson.isObject());
            assertEquals("\"Not found 8\"",responseJson.get("error").toString());
        });
    }

    @Test
    public void testPageOrdersByCustomerName() {
        running(testServer(3333, app), () -> {
            WSResponse response = WS
                .url("http://localhost:3333/orders")
                .setQueryParameter("customerName", "John")
                .get()
                .get(timeout);

            assertEquals(OK, response.getStatus());
            assertEquals("application/json; charset=utf-8", response.getHeader("Content-Type"));

            JsonNode responseJson = response.asJson();
            assertTrue(responseJson.isObject());
            assertTrue(responseJson.get("data").isArray());
            assertEquals(3,responseJson.get("data").size());
            assertEquals(4,responseJson.get("total").asInt());
            assertNotNull(responseJson.get("link-self"));
            assertNotNull(responseJson.get("link-next"));
            assertNull(responseJson.get("link-prev"));
        });
    }

    @Test
    public void testPlaceOrder() {
        running(testServer(3333, app), () -> {
            WSResponse response = WS
                .url("http://localhost:3333/orders")
                .post(dataOk)
                .get(timeout);

            assertEquals(CREATED, response.getStatus());
            assertEquals("application/json; charset=utf-8", response.getHeader("Content-Type"));

            JsonNode responseJson = response.asJson();
            assertTrue(responseJson.isObject());
           // assertEquals(1,responseJson.get("id").asInt());
            assertEquals("\"Owen_xiao\"",responseJson.get("customerName").toString());
        });
    }

    @Test
    public void testPlaceOrderBadRequest1() {
        running(testServer(3333, app), () -> {
            WSResponse response = WS
                .url("http://localhost:3333/orders")
                .post(dataError1)
                .get(timeout);

            assertEquals(BAD_REQUEST, response.getStatus());
            assertEquals("application/json; charset=utf-8", response.getHeader("Content-Type"));

            JsonNode responseJson = response.asJson();
            assertTrue(responseJson.isObject());
            assertEquals( "[\"This field is required\"]",responseJson.get("customerName").toString());
        });
    }

    @Test
    public void testPlaceOrderBadRequest2() {
        running(testServer(3333, app), () -> {
            WSResponse response = WS
                .url("http://localhost:3333/orders")
                .post(dataError2)
                .get(timeout);

            assertEquals(BAD_REQUEST, response.getStatus());
            assertEquals("application/json; charset=utf-8", response.getHeader("Content-Type"));

            JsonNode responseJson = response.asJson();
            assertTrue(responseJson.isObject());
            assertEquals("[\"This field is required\"]",responseJson.get("customerName").toString());
        });
    }

    @Test
    public void testUpdateOrder() {
        running(testServer(3333, app), () -> {
            WSResponse response = WS
                .url("http://localhost:3333/orders")
                .put(dataOk.put("orderId", 1))
                .get(timeout);

            assertEquals(OK, response.getStatus());
            assertEquals("application/json; charset=utf-8", response.getHeader("Content-Type"));

            JsonNode responseJson = response.asJson();
            assertTrue(responseJson.isObject());
            assertEquals(1,responseJson.get("orderId").asInt());
            assertEquals("\"Owen_xiao\"",responseJson.get("customerName").toString());
            assertTrue(Double.valueOf(54.0).compareTo(responseJson.get("totalPrice").asDouble())==0);
            //assertEquals("\"2016-07-06 01:44:29\"",responseJson.get("orderTime").toString());
        });
    }

    @Test
    public void testUpdateOrderBadRequest1() {
        running(testServer(3333, app), () -> {
            WSResponse response = WS
                .url("http://localhost:3333/orders")
                .put(dataError1.put("orderId", 1))
                .get(timeout);

            assertEquals(BAD_REQUEST, response.getStatus());
            assertEquals("application/json; charset=utf-8", response.getHeader("Content-Type"));

            JsonNode responseJson = response.asJson();
            assertTrue(responseJson.isObject());
            assertEquals("[\"This field is required\"]",responseJson.get("customerName").toString());
        });
    }

    @Test
    public void testUpdateOrderBadRequest2() {
        running(testServer(3333, app), () -> {
            WSResponse response = WS
                .url("http://localhost:3333/orders")
                .put(dataError2.put("orderId", 1))
                .get(timeout);

            assertEquals(BAD_REQUEST, response.getStatus());
            assertEquals("application/json; charset=utf-8", response.getHeader("Content-Type"));

            JsonNode responseJson = response.asJson();
            assertTrue(responseJson.isObject());
            assertEquals( "[\"This field is required\"]",responseJson.get("customerName").toString());
        });
    }

    @Test
    public void testDeleteOrder() {
        running(testServer(3333, app), () -> {
            WSResponse response = WS
                .url("http://localhost:3333/orders/1")
                .delete()
                .get(timeout);

            assertEquals(OK, response.getStatus());
            assertEquals("application/json; charset=utf-8", response.getHeader("Content-Type"));

            JsonNode responseJson = response.asJson();
            assertTrue(responseJson.isObject());
            assertEquals("\"Deleted 1\"",responseJson.get("msg").toString());
        });
    }

    @Test
    public void testDeleteOrderNotFound() {
        running(testServer(3333, app), () -> {
            WSResponse response = WS
                .url("http://localhost:3333/orders/8")
                .delete()
                .get(timeout);

            assertEquals(NOT_FOUND, response.getStatus());
            assertEquals("application/json; charset=utf-8", response.getHeader("Content-Type"));

            JsonNode responseJson = response.asJson();
            assertTrue(responseJson.isObject());
            assertEquals("\"Not found 8\"",responseJson.get("error").toString());
        });
    }
}
