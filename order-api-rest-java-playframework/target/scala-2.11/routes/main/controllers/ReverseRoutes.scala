
// @GENERATOR:play-routes-compiler
// @SOURCE:D:/play_workspace/order-api-rest-java-playframework/conf/routes
// @DATE:Sun Jul 10 15:52:04 PDT 2016

import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers {

  // @LINE:18
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:18
    def versioned(file:Asset): Call = {
      implicit val _rrc = new ReverseRouteContext(Map(("path", "/public")))
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[Asset]].unbind("file", file))
    }
  
  }

  // @LINE:6
  class ReverseOrderController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:11
    def create(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "orders")
    }
  
    // @LINE:10
    def get(orderId:Integer): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "orders/" + implicitly[PathBindable[Integer]].unbind("orderId", orderId))
    }
  
    // @LINE:14
    def delete(orderId:Integer): Call = {
      import ReverseRouteContext.empty
      Call("DELETE", _prefix + { _defaultPrefix } + "orders/" + implicitly[PathBindable[Integer]].unbind("orderId", orderId))
    }
  
    // @LINE:12
    def update(): Call = {
    
      () match {
      
        // @LINE:12
        case ()  =>
          import ReverseRouteContext.empty
          Call("PUT", _prefix + { _defaultPrefix } + "orders")
      
      }
    
    }
  
    // @LINE:6
    def index(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix)
    }
  
    // @LINE:9
    def list(page:Integer = 1, size:Integer = 3, customerName:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "orders" + queryString(List(if(page == 1) None else Some(implicitly[QueryStringBindable[Integer]].unbind("page", page)), if(size == 3) None else Some(implicitly[QueryStringBindable[Integer]].unbind("size", size)), Some(implicitly[QueryStringBindable[String]].unbind("customerName", customerName)))))
    }
  
  }


}