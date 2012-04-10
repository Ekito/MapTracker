
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
object map extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.Html] {

    /**/
    def apply():play.api.templates.Html = {
        _display_ {
def /*3.2*/sidebar/*3.9*/:play.api.templates.Html = {_display_(

Seq(format.raw/*3.13*/("""
<h3>Layers</h3>
<form class="form-vertical" id="layersForm">
</form>
""")))};def /*9.2*/css/*9.5*/:play.api.templates.Html = {_display_(

Seq(format.raw/*9.9*/("""
<style TYPE="text/css">
/* A small hack to hide an unwanted dialog box */
div.olLayerGoogleCopyright """),format.raw("""{"""),format.raw/*12.29*/("""
  display: none !important;
"""),format.raw("""}"""),format.raw/*14.2*/("""
</style>
""")))};def /*18.2*/javascript/*18.12*/:play.api.templates.Html = {_display_(

Seq(format.raw/*18.16*/("""

<script src=""""),_display_(Seq(/*20.15*/routes/*20.21*/.Assets.at("openlayers/OpenLayers.js"))),format.raw/*20.59*/("""" type="text/javascript"></script>
<script src=""""),_display_(Seq(/*21.15*/routes/*21.21*/.Assets.at("javascripts/maptracker.js"))),format.raw/*21.60*/("""" type="text/javascript"></script>
<script src=""""),_display_(Seq(/*22.15*/routes/*22.21*/.Assets.at("javascripts/twitterbootstrap/bootstrap-alert.js"))),format.raw/*22.82*/("""" type="text/javascript"></script>
<script src="http://maps.google.com/maps/api/js?v=3.6&amp;sensor=false"></script>
<script type="text/javascript">

$(document).ready(function() """),format.raw("""{"""),format.raw/*26.31*/("""
	
	// hidable alert thanks to Twitter Bootstrap
	$(".alert").alert();
	
	// map initialization
	var map = initMap();
	
	var marker = null;
	
	// open a WebSocket
	var WS = window['MozWebSocket'] ? MozWebSocket : WebSocket
    var mapSocket = new WS(""""),_display_(Seq(/*38.30*/routes/*38.36*/.Application.mapsocket().webSocketURL(request))),format.raw/*38.82*/("""");
	
	mapSocket.onmessage = function(event) """),format.raw("""{"""),format.raw/*40.41*/("""
        var data = JSON.parse(event.data);
        
        marker = moveMaker(map, marker, data.longitude, data.latitude);
        
    """),format.raw("""}"""),format.raw/*45.6*/("""
	
	// if errors on websocket
	var onalert = function(event) """),format.raw("""{"""),format.raw/*48.33*/("""
        $(".alert").removeClass("hide");
    """),format.raw("""}"""),format.raw/*50.6*/(""" 
	
	mapSocket.onerror = onalert;
	mapSocket.onclose = onalert;
    
"""),format.raw("""}"""),format.raw/*55.2*/(""");
</script>
""")))};
Seq(format.raw/*7.2*/("""

"""),format.raw/*16.2*/("""

"""),format.raw/*57.2*/("""

"""),_display_(Seq(/*59.2*/main("Welcome to the MapTracker !")(sidebar)(javascript)(css)/*59.63*/ {_display_(Seq(format.raw/*59.65*/("""

    <h2>Map</h2>
    
    <div class="alert alert-block alert-error fade in hide">
      <a class="close" data-dismiss="alert" href="#">×</a>
      <h4 class="alert-heading">Oh snap! You got an error!</h4>
      <p>The server seems to be down :(</p>
    </div>
    
    <div id="map" style="width: 600px; height: 450px">
    </div>

""")))})),format.raw/*72.2*/("""
"""))}
    }
    
    def render() = apply()
    
    def f:(() => play.api.templates.Html) = () => apply()
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Apr 10 16:45:23 CEST 2012
                    SOURCE: /media/disk/m3system-airman/workspace/maptracker/app/views/map.scala.html
                    HASH: 5151a4ac49cb4a21c61953dc530d9346dfc83ff4
                    MATRIX: 801->3|815->10|877->14|970->88|980->91|1041->95|1191->198|1267->228|1301->242|1320->252|1383->256|1430->272|1445->278|1505->316|1585->365|1600->371|1661->410|1741->459|1756->465|1839->526|2066->706|2349->958|2364->964|2432->1010|2525->1056|2710->1195|2819->1257|2912->1304|3028->1374|3075->85|3104->239|3133->1388|3166->1391|3236->1452|3271->1454|3638->1790
                    LINES: 29->3|29->3|31->3|35->9|35->9|37->9|40->12|42->14|44->18|44->18|46->18|48->20|48->20|48->20|49->21|49->21|49->21|50->22|50->22|50->22|54->26|66->38|66->38|66->38|68->40|73->45|76->48|78->50|83->55|86->7|88->16|90->57|92->59|92->59|92->59|105->72
                    -- GENERATED --
                */
            