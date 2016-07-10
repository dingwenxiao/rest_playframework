
// @GENERATOR:play-routes-compiler
// @SOURCE:D:/play_workspace/order-api-rest-java-playframework/conf/routes
// @DATE:Sun Jul 10 15:52:04 PDT 2016


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
