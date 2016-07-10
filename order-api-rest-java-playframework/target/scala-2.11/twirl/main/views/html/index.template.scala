
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object index_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._

class index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(message: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.19*/("""

"""),_display_(/*3.2*/main(message)/*3.15*/ {_display_(Seq[Any](format.raw/*3.17*/("""
    """),format.raw/*4.5*/("""<h1>"""),_display_(/*4.10*/message),format.raw/*4.17*/("""</h1>
    <hr>
    <p>Welcome to a API REST with Play Framework in JAVA</p>
    <p>For test the API you can use the file extracted from PostMan or use these URIs in your Rest Client</p>
    <table class="table table-bordered table-hover table-condensed">
        <tr>
            <th>Method</th>
            <th>URI</th>
            <th>Data</th>
            <th>HTTP Code</th>
            <th>Response (in JSON)</th>
        </tr>
        <tr>
            <td>GET</td>
            <td>/orders/customerName=John</td>
            <td></td>
            <td>200</td>
            <td>"""),format.raw/*21.17*/("""{"""),format.raw/*21.18*/(""""data": ["""),format.raw/*21.27*/("""{"""),format.raw/*21.28*/(""""orderId": 3,"orderTime": 1467794649000,"totalPrice": 42,"customerName": "John""""),format.raw/*21.107*/("""}"""),format.raw/*21.108*/(""",
        """),format.raw/*22.9*/("""{"""),format.raw/*22.10*/(""""orderId": 5,"orderTime": 1467794649000,"totalPrice": 85,"customerName": "John""""),format.raw/*22.89*/("""}"""),format.raw/*22.90*/(""",
        """),format.raw/*23.9*/("""{"""),format.raw/*23.10*/(""""orderId": 6,"orderTime": 1467794649000,"totalPrice": 85,"customerName": "John""""),format.raw/*23.89*/("""}"""),format.raw/*23.90*/("""],
    "total": 4,
    "link-next": "/orders?page=2&customerName=John",
    "link-self": "/orders?customerName=John""""),format.raw/*26.45*/("""}"""),format.raw/*26.46*/("""
"""),format.raw/*27.1*/("""</td>
        </tr>
        <tr>
            <td>GET</td>
            <td>/orders/1</td>
            <td></td>
            <td>200</td>
            <td>"""),format.raw/*34.17*/("""{"""),format.raw/*34.18*/(""""orderId": 1,"orderTime": 1467794649000,"totalPrice": 22,"customerName": "Owen""""),format.raw/*34.97*/("""}"""),format.raw/*34.98*/("""</td>
        </tr>
        <tr>
            <td>GET</td>
            <td>/orders/8</td>
            <td></td>
            <td>404</td>
            <td>"""),format.raw/*41.17*/("""{"""),format.raw/*41.18*/(""""error":"Not found 8""""),format.raw/*41.39*/("""}"""),format.raw/*41.40*/("""</td>
        </tr>
        <tr>
            <td>POST</td>
            <td>/orders</td>
            <td>"""),format.raw/*46.17*/("""{"""),format.raw/*46.18*/(""""totalPrice": 22, "customerName":"Stephen", orderTime": "2014-10-09 01:44:09""""),format.raw/*46.95*/("""}"""),format.raw/*46.96*/("""</td>
            <td>201</td>
            <td>"""),format.raw/*48.17*/("""{"""),format.raw/*48.18*/(""""orderId": 163,"orderTime": 1412838000000,"totalPrice": 22,"customerName": "Stephen""""),format.raw/*48.102*/("""}"""),format.raw/*48.103*/("""</td>
        </tr>
        <tr>
            <td>POST</td>
            <td>/orders</td>
            <td></td>
            <td>400</td>
            <td>"""),format.raw/*55.17*/("""{"""),format.raw/*55.18*/(""""customerName": ["This field is required"]"""),format.raw/*55.60*/("""}"""),format.raw/*55.61*/("""</td>
        </tr>
        <tr>
            <td>PUT/PATCH</td>
            <td>/orders</td>
            <td>"""),format.raw/*60.17*/("""{"""),format.raw/*60.18*/(""""totalPrice": 22, "customerName":"Stephen", orderTime": "2014-10-09 01:44:09""""),format.raw/*60.95*/("""}"""),format.raw/*60.96*/("""</td>
            <td>200</td>
            <td>"""),format.raw/*62.17*/("""{"""),format.raw/*62.18*/(""""orderId": 164,"orderTime": 1412838000000,"totalPrice": 22,"customerName": "Stephen""""),format.raw/*62.102*/("""}"""),format.raw/*62.103*/("""</td>
        </tr>
        <tr>
            <td>PUT/PATCH</td>
            <td>/orders</td>
            <td></td>
            <td>400</td>
            <td>"""),format.raw/*69.17*/("""{"""),format.raw/*69.18*/(""""customerName": ["This field is required"]"""),format.raw/*69.60*/("""}"""),format.raw/*69.61*/("""</td>
        </tr>
        <tr>
            <td>DELETE</td>
            <td>/orders/1</td>
            <td></td>
            <td>200</td>
            <td>"""),format.raw/*76.17*/("""{"""),format.raw/*76.18*/(""""msg":"Deleted 1""""),format.raw/*76.35*/("""}"""),format.raw/*76.36*/("""</td>
        </tr>
        <tr>
            <td>DELETE</td>
            <td>/orders/0</td>
            <td></td>
            <td>404</td>
            <td>"""),format.raw/*83.17*/("""{"""),format.raw/*83.18*/(""""error":"Not found 0""""),format.raw/*83.39*/("""}"""),format.raw/*83.40*/("""</td>
        </tr>
    </table>
    <hr>
""")))}),format.raw/*87.2*/("""
"""))
      }
    }
  }

  def render(message:String): play.twirl.api.HtmlFormat.Appendable = apply(message)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (message) => apply(message)

  def ref: this.type = this

}


}

/**/
object index extends index_Scope0.index
              /*
                  -- GENERATED --
                  DATE: Sun Jul 10 15:47:25 PDT 2016
                  SOURCE: D:/play_workspace/order-api-rest-java-playframework/app/views/index.scala.html
                  HASH: 68b31600144d9d48bc157fc125b1d7ecf932d51e
                  MATRIX: 745->1|857->18|885->21|906->34|945->36|976->41|1007->46|1034->53|1642->633|1671->634|1708->643|1737->644|1845->723|1875->724|1912->734|1941->735|2048->814|2077->815|2114->825|2143->826|2250->905|2279->906|2423->1022|2452->1023|2480->1024|2660->1176|2689->1177|2796->1256|2825->1257|3005->1409|3034->1410|3083->1431|3112->1432|3244->1536|3273->1537|3378->1614|3407->1615|3482->1662|3511->1663|3624->1747|3654->1748|3833->1899|3862->1900|3932->1942|3961->1943|4098->2052|4127->2053|4232->2130|4261->2131|4336->2178|4365->2179|4478->2263|4508->2264|4692->2420|4721->2421|4791->2463|4820->2464|5003->2619|5032->2620|5077->2637|5106->2638|5289->2793|5318->2794|5367->2815|5396->2816|5469->2859
                  LINES: 27->1|32->1|34->3|34->3|34->3|35->4|35->4|35->4|52->21|52->21|52->21|52->21|52->21|52->21|53->22|53->22|53->22|53->22|54->23|54->23|54->23|54->23|57->26|57->26|58->27|65->34|65->34|65->34|65->34|72->41|72->41|72->41|72->41|77->46|77->46|77->46|77->46|79->48|79->48|79->48|79->48|86->55|86->55|86->55|86->55|91->60|91->60|91->60|91->60|93->62|93->62|93->62|93->62|100->69|100->69|100->69|100->69|107->76|107->76|107->76|107->76|114->83|114->83|114->83|114->83|118->87
                  -- GENERATED --
              */
          