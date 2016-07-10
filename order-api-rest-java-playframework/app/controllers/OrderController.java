package controllers;


import java.util.List;

import com.fasterxml.jackson.databind.node.ObjectNode;

import models.Order;
import play.data.Form;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import services.OrderService;
import views.html.index;

public class OrderController  extends Controller{
	static Form<Order> orderForm = Form.form(Order.class);

    /**
     * Add the content-type json to response
     *
     * @param Result httpResponse
     *
     * @return Result
     */
    public Result jsonResult(Result httpResponse) {
        response().setContentType("application/json; charset=utf-8");
        return httpResponse;
    }

    /**
     * Get the index page
     *
     * @return Result
     */
    public Result index() {
        return ok(index.render("Practice of Rest API with Play Framework"));
    }

    /**
     * Get the orders with pagination
     *
     * @param Integer page
     * @param Integer size
     * @param String customerName
     * @return Result
     */
    @Transactional(readOnly = true)
    public Result list(Integer page, Integer size, String customerName) {
    	 ObjectNode result = Json.newObject();
    	if(customerName==null || "".equals(customerName)) {
    		result.put("customerName", "This field is required");
    		return jsonResult(badRequest(result));
    	}
    	
        List<Order> models = OrderService.paginate(page-1, size,customerName);
        Long count = OrderService.count(customerName);
        result.put("data", Json.toJson(models));
        result.put("total", count);
        if (page > 1) result.put("link-prev", routes.OrderController.list(page-1, size,customerName).toString());
        if (page*size < count) result.put("link-next", routes.OrderController.list(page+1, size,customerName).toString());
        result.put("link-self", routes.OrderController.list(page, size,customerName).toString());

        return jsonResult(ok(result));
    }

    /**
     * Get an order by orderId
     *
     * @param Integer orderId
     *
     * @return Result
     */
    @Transactional(readOnly = true)
    public Result get(Integer orderId) {
        Order order = OrderService.find(orderId);
        if (order == null ) {
            ObjectNode result = Json.newObject();
            result.put("error", "Not found " + orderId);
            return jsonResult(notFound(result));
        }
        return jsonResult(ok(Json.toJson(order)));
    }

    /**
     * Create an Order with the data of request
     *
     * @return Result
     */
    @Transactional
    public Result create() {
        Form<Order> order = orderForm.bindFromRequest();
        if (order.hasErrors()) {
            return jsonResult(badRequest(order.errorsAsJson()));
        }
        Order newOrder = OrderService.create(order.get());
        return jsonResult(created(Json.toJson(newOrder)));
    }

    /**
     * Update an Order with the data of request
     *
     * @return Result
     */
    @Transactional
    public Result update() {
        Form<Order> order = orderForm.bindFromRequest();
        if (order.hasErrors()) {
            return jsonResult(badRequest(order.errorsAsJson()));
        }
        Order updatedOrder = OrderService.update(order.get());
        return jsonResult(ok(Json.toJson(updatedOrder)));
    }

    /**
     * Delete an order by orderId
     *
     * @param Integer orderId
     *
     * @return Result
     */
    @Transactional
    public Result delete(Integer orderId) {
        if (OrderService.delete(orderId)) {
            ObjectNode result = Json.newObject();
            result.put("msg", "Deleted " + orderId);
            return jsonResult(ok(result));
        }
        ObjectNode result = Json.newObject();
        result.put("error", "Not found " + orderId);
        return jsonResult(notFound(result));
    }
}
