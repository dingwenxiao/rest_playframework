import org.junit.*;
import play.test.*;
import services.OrderService;
import play.Application;
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


public class OrderModelTest {
	JndiDatabaseTester databaseTester;
	Application app;

	// Data needed for create the fake
	private static HashMap<String, String> settings() {
		HashMap<String, String> settings = new HashMap<String, String>();
		settings.put("db.default.url", "jdbc:mysql://localhost:3306/play_test");
		settings.put("db.default.username", "root");
		settings.put("db.default.password", "xiaodingwen");
		settings.put("db.default.jndiName", "DefaultDS");
		settings.put("jpa.default", "mySqlPersistenceUnit");
		return (settings);
	}

	@BeforeClass
	public static void createTables() {
		Application fakeApp = Helpers.fakeApplication(settings());
		running(fakeApp, () -> {
			JPA.withTransaction(() -> {
			});
		});
	}

	@Before
	public void initializeData() throws Exception {
		app = Helpers.fakeApplication(settings());
		databaseTester = new JndiDatabaseTester("DefaultDS");
		IDataSet initialDataSet = new FlatXmlDataSetBuilder()
				.build(new FileInputStream("test/resources/orders_dataset_1.xml"));
		databaseTester.setDataSet(initialDataSet);
		databaseTester.onSetup();
	}

	@After
	public void closeDB() throws Exception {
		databaseTester.onTearDown();
	}

	@Test
	public void testOrderExists() {
		running(app, () -> {
			JPA.withTransaction(() -> {
				Order order = OrderService.find(1);
				assertEquals(order.getCustomerName(), "Owen");
			});
		});
	}

	@Test
	public void testOrderNotFound() {
		running(app, () -> {
			JPA.withTransaction(() -> {
				Order order = OrderService.find(8);
				assertNull(order);
			});
		});
	}

	@Test
	public void testQueryOrdersByCustomerName() {
		running(app, () -> {
			JPA.withTransaction(() -> {
				List<Order> orders = OrderService.paginate(0, 5, "John");
				long count = OrderService.count("John");
				assertEquals(4,count);
				Order order1 = new Order();
				order1.setOrderId(3);
				Order order2 = new Order();
				order2.setOrderId(5);
				Order order3 = new Order();
				order3.setOrderId(6);
				Order order4 = new Order();
				order4.setOrderId(7);

				assertTrue(orders.contains(order1));
				assertTrue(orders.contains(order2));
				assertTrue(orders.contains(order3));
				assertTrue(orders.contains(order4));
			});
		});
	}

	@Test
	public void testPlaceOrder() {
		running(app, () -> {
			JPA.withTransaction(() -> {
				Order order = new Order();
				order.setCustomerName("test");
				order.setTotalPrice(22);
				//order.setOrderId(10);
				Order retOrder = OrderService.create(order);
				assertEquals(retOrder, order);
			});
		});
	}

	@Test
	public void testUpdateOrder() {
		running(app, () -> {
			JPA.withTransaction(() -> {
				Order order = new Order();
				order.setCustomerName("Update test");
				order.setTotalPrice(22);
				order.setOrderId(10);
				Order update = OrderService.update(order);
				assertEquals("Update test",update.getCustomerName());
			});
		});
	}

	@Test
	public void testDeleteOrder() {
		running(app, () -> {
			JPA.withTransaction(() -> {
				Order order = new Order();
				order.setCustomerName("Update test");
				order.setTotalPrice(22);
				Order retOrder = OrderService.create(order);
				//order.setOrderId(1);
				assertTrue(OrderService.delete(retOrder.getOrderId()));
				assertFalse(OrderService.delete(retOrder.getOrderId()));
			});
		});
	}
}
