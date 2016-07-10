
// @GENERATOR:play-routes-compiler
// @SOURCE:D:/play_workspace/order-api-rest-java-playframework/conf/routes
// @DATE:Sun Jul 10 15:52:04 PDT 2016

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers.javascript {
  import ReverseRouteContext.empty

  // @LINE:18
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:18
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[Asset]].javascriptUnbind + """)("file", file)})
        }
      """
    )
  
  }

  // @LINE:6
  class ReverseOrderController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:11
    def create: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OrderController.create",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "orders"})
        }
      """
    )
  
    // @LINE:10
    def get: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OrderController.get",
      """
        function(orderId) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "orders/" + (""" + implicitly[PathBindable[Integer]].javascriptUnbind + """)("orderId", orderId)})
        }
      """
    )
  
    // @LINE:14
    def delete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OrderController.delete",
      """
        function(orderId) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "orders/" + (""" + implicitly[PathBindable[Integer]].javascriptUnbind + """)("orderId", orderId)})
        }
      """
    )
  
    // @LINE:12
    def update: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OrderController.update",
      """
        function() {
        
          if (true) {
            return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "orders"})
          }
        
        }
      """
    )
  
    // @LINE:6
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OrderController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
    // @LINE:9
    def list: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.OrderController.list",
      """
        function(page,size,customerName) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "orders" + _qS([(page == null ? null : (""" + implicitly[QueryStringBindable[Integer]].javascriptUnbind + """)("page", page)), (size == null ? null : (""" + implicitly[QueryStringBindable[Integer]].javascriptUnbind + """)("size", size)), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("customerName", customerName)])})
        }
      """
    )
  
  }


}