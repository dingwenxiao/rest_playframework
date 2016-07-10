
// @GENERATOR:play-routes-compiler
// @SOURCE:D:/play_workspace/order-api-rest-java-playframework/conf/routes
// @DATE:Sun Jul 10 15:52:04 PDT 2016

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseOrderController OrderController = new controllers.ReverseOrderController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseOrderController OrderController = new controllers.javascript.ReverseOrderController(RoutesPrefix.byNamePrefix());
  }

}
