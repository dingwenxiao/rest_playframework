
// @GENERATOR:play-routes-compiler
// @SOURCE:D:/play_workspace/order-api-rest-java-playframework/conf/routes
// @DATE:Sun Jul 10 15:52:04 PDT 2016

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  OrderController_1: controllers.OrderController,
  // @LINE:18
  Assets_0: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    OrderController_1: controllers.OrderController,
    // @LINE:18
    Assets_0: controllers.Assets
  ) = this(errorHandler, OrderController_1, Assets_0, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, OrderController_1, Assets_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.OrderController.index()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """orders""", """controllers.OrderController.list(page:Integer ?= 1, size:Integer ?= 3, customerName:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """orders/$orderId<[0-9]+>""", """controllers.OrderController.get(orderId:Integer)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """orders""", """controllers.OrderController.create()"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """orders""", """controllers.OrderController.update()"""),
    ("""PATCH""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """orders""", """controllers.OrderController.update()"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """orders/$orderId<[0-9]+>""", """controllers.OrderController.delete(orderId:Integer)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_OrderController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_OrderController_index0_invoker = createInvoker(
    OrderController_1.index(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OrderController",
      "index",
      Nil,
      "GET",
      """ Home page""",
      this.prefix + """"""
    )
  )

  // @LINE:9
  private[this] lazy val controllers_OrderController_list1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("orders")))
  )
  private[this] lazy val controllers_OrderController_list1_invoker = createInvoker(
    OrderController_1.list(fakeValue[Integer], fakeValue[Integer], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OrderController",
      "list",
      Seq(classOf[Integer], classOf[Integer], classOf[String]),
      "GET",
      """ Order Routes API Rest""",
      this.prefix + """orders"""
    )
  )

  // @LINE:10
  private[this] lazy val controllers_OrderController_get2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("orders/"), DynamicPart("orderId", """[0-9]+""",false)))
  )
  private[this] lazy val controllers_OrderController_get2_invoker = createInvoker(
    OrderController_1.get(fakeValue[Integer]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OrderController",
      "get",
      Seq(classOf[Integer]),
      "GET",
      """""",
      this.prefix + """orders/$orderId<[0-9]+>"""
    )
  )

  // @LINE:11
  private[this] lazy val controllers_OrderController_create3_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("orders")))
  )
  private[this] lazy val controllers_OrderController_create3_invoker = createInvoker(
    OrderController_1.create(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OrderController",
      "create",
      Nil,
      "POST",
      """""",
      this.prefix + """orders"""
    )
  )

  // @LINE:12
  private[this] lazy val controllers_OrderController_update4_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("orders")))
  )
  private[this] lazy val controllers_OrderController_update4_invoker = createInvoker(
    OrderController_1.update(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OrderController",
      "update",
      Nil,
      "PUT",
      """""",
      this.prefix + """orders"""
    )
  )

  // @LINE:13
  private[this] lazy val controllers_OrderController_update5_route = Route("PATCH",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("orders")))
  )
  private[this] lazy val controllers_OrderController_update5_invoker = createInvoker(
    OrderController_1.update(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OrderController",
      "update",
      Nil,
      "PATCH",
      """""",
      this.prefix + """orders"""
    )
  )

  // @LINE:14
  private[this] lazy val controllers_OrderController_delete6_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("orders/"), DynamicPart("orderId", """[0-9]+""",false)))
  )
  private[this] lazy val controllers_OrderController_delete6_invoker = createInvoker(
    OrderController_1.delete(fakeValue[Integer]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.OrderController",
      "delete",
      Seq(classOf[Integer]),
      "DELETE",
      """""",
      this.prefix + """orders/$orderId<[0-9]+>"""
    )
  )

  // @LINE:18
  private[this] lazy val controllers_Assets_versioned7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned7_invoker = createInvoker(
    Assets_0.versioned(fakeValue[String], fakeValue[Asset]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      """ Map static resources from the /public folder to the /assets URL path""",
      this.prefix + """assets/$file<.+>"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_OrderController_index0_route(params) =>
      call { 
        controllers_OrderController_index0_invoker.call(OrderController_1.index())
      }
  
    // @LINE:9
    case controllers_OrderController_list1_route(params) =>
      call(params.fromQuery[Integer]("page", Some(1)), params.fromQuery[Integer]("size", Some(3)), params.fromQuery[String]("customerName", None)) { (page, size, customerName) =>
        controllers_OrderController_list1_invoker.call(OrderController_1.list(page, size, customerName))
      }
  
    // @LINE:10
    case controllers_OrderController_get2_route(params) =>
      call(params.fromPath[Integer]("orderId", None)) { (orderId) =>
        controllers_OrderController_get2_invoker.call(OrderController_1.get(orderId))
      }
  
    // @LINE:11
    case controllers_OrderController_create3_route(params) =>
      call { 
        controllers_OrderController_create3_invoker.call(OrderController_1.create())
      }
  
    // @LINE:12
    case controllers_OrderController_update4_route(params) =>
      call { 
        controllers_OrderController_update4_invoker.call(OrderController_1.update())
      }
  
    // @LINE:13
    case controllers_OrderController_update5_route(params) =>
      call { 
        controllers_OrderController_update5_invoker.call(OrderController_1.update())
      }
  
    // @LINE:14
    case controllers_OrderController_delete6_route(params) =>
      call(params.fromPath[Integer]("orderId", None)) { (orderId) =>
        controllers_OrderController_delete6_invoker.call(OrderController_1.delete(orderId))
      }
  
    // @LINE:18
    case controllers_Assets_versioned7_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned7_invoker.call(Assets_0.versioned(path, file))
      }
  }
}