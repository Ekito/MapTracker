
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.api.templates.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import com.avaje.ebean._
import play.mvc.Http.Context.Implicit._
import views.html._
/**/
object main extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template5[String,Html,Html,Html,Html,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(title: String)(sidebar: Html)(javascript: Html)(css: Html)(content: Html):play.api.templates.Html = {
        _display_ {
def /*10.2*/minified/*10.10*/ = {{ if (play.Play.isProd()) ".min" else "" }};
Seq(format.raw/*1.76*/("""

<!DOCTYPE html>

<html>
<head>
<title>"""),_display_(Seq(/*7.9*/title)),format.raw/*7.14*/("""</title>
<link rel="shortcut icon" type="image/png" href=""""),_display_(Seq(/*8.51*/routes/*8.57*/.Assets.at("images/favicon.png"))),format.raw/*8.89*/("""">

"""),format.raw/*10.54*/("""
<link rel="stylesheet" href=""""),_display_(Seq(/*11.31*/routes/*11.37*/.Assets.at("stylesheets/twitterbootstrap/bootstrap"+ minified + ".css"))),format.raw/*11.108*/("""">
"""),_display_(Seq(/*12.2*/css)),format.raw/*12.5*/("""

<script src=""""),_display_(Seq(/*14.15*/routes/*14.21*/.Assets.at("javascripts/jquery-1.7.1.min.js"))),format.raw/*14.66*/("""" type="text/javascript"></script>
<script src=""""),_display_(Seq(/*15.15*/routes/*15.21*/.Assets.at("javascripts/twitterbootstrap/bootstrap-dropdown.js"))),format.raw/*15.85*/("""" type="text/javascript"></script>
"""),_display_(Seq(/*16.2*/javascript)),format.raw/*16.12*/("""

</head>
<body>
	"""),_display_(Seq(/*20.3*/header())),format.raw/*20.11*/("""

    <div class="container">
    """),_display_(Seq(/*23.6*/if(sidebar != null)/*23.25*/ {_display_(Seq(format.raw/*23.27*/("""
	   <div class="row">
	       <div class="span3">
	           <div class="well sidebar-nav">
	               """),_display_(Seq(/*27.18*/sidebar)),format.raw/*27.25*/("""
	           </div>
	       </div>
	       <div class="span9">
               <div class="well">
                    """),_display_(Seq(/*32.22*/content)),format.raw/*32.29*/("""
               </div>
           </div>
	   </div>
	
	""")))}/*37.4*/else/*37.9*/{_display_(Seq(format.raw/*37.10*/("""
	   """),_display_(Seq(/*38.6*/content)),format.raw/*38.13*/("""
	""")))})),format.raw/*39.3*/("""
	</div>
</body>
</html>
"""))}
    }
    
    def render(title:String,sidebar:Html,javascript:Html,css:Html,content:Html) = apply(title)(sidebar)(javascript)(css)(content)
    
    def f:((String) => (Html) => (Html) => (Html) => (Html) => play.api.templates.Html) = (title) => (sidebar) => (javascript) => (css) => (content) => apply(title)(sidebar)(javascript)(css)(content)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Apr 10 16:45:23 CEST 2012
                    SOURCE: /media/disk/m3system-airman/workspace/maptracker/app/views/main.scala.html
                    HASH: 78684ded19e964423ad37b9ef25c290198c2ff38
                    MATRIX: 774->1|909->223|926->231|997->75|1067->116|1093->121|1182->180|1196->186|1249->218|1281->275|1343->306|1358->312|1452->383|1486->387|1510->390|1557->406|1572->412|1639->457|1719->506|1734->512|1820->576|1886->612|1918->622|1967->641|1997->649|2062->684|2090->703|2125->705|2267->816|2296->823|2445->941|2474->948|2548->1005|2560->1010|2594->1011|2630->1017|2659->1024|2693->1027
                    LINES: 27->1|29->10|29->10|30->1|36->7|36->7|37->8|37->8|37->8|39->10|40->11|40->11|40->11|41->12|41->12|43->14|43->14|43->14|44->15|44->15|44->15|45->16|45->16|49->20|49->20|52->23|52->23|52->23|56->27|56->27|61->32|61->32|66->37|66->37|66->37|67->38|67->38|68->39
                    -- GENERATED --
                */
            