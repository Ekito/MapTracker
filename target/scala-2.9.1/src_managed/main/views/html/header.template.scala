
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
object header extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.Html] {

    /**/
    def apply():play.api.templates.Html = {
        _display_ {

Seq(format.raw/*1.1*/("""<div class="navbar">
	<div class="navbar-inner">
		<div class="container">
			<a class="brand" href=""""),_display_(Seq(/*4.28*/controllers/*4.39*/.routes.Application.index())),format.raw/*4.66*/("""">MapTracker</a>

			<ul class="nav">
				<li><a href=""""),_display_(Seq(/*7.19*/controllers/*7.30*/.routes.Application.showMap())),format.raw/*7.59*/("""">Map</a></li>
			</ul>

			<ul class="nav pull-right">
                 <li class="dropdown"><a href="#" class="dropdown-toggle"
                     data-toggle="dropdown">Welcome Guest !&nbsp;<span
                         class="caret"></span></a>

                     <ul class="dropdown-menu">
                         <li><a href="#">Settings</a></li>
                         <li class="divider"></li>
                         <li><a href="#">Sign out</a></li>
                     </ul>
                </li>
			</ul>
		</div>
	</div>
</div>
<div class="container">
"""))}
    }
    
    def render() = apply()
    
    def f:(() => play.api.templates.Html) = () => apply()
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Apr 10 16:45:23 CEST 2012
                    SOURCE: /media/disk/m3system-airman/workspace/maptracker/app/views/header.scala.html
                    HASH: 56490785fda8b9cd793432a565585c96e3ed2ad5
                    MATRIX: 815->0|947->102|966->113|1014->140|1100->196|1119->207|1169->236
                    LINES: 30->1|33->4|33->4|33->4|36->7|36->7|36->7
                    -- GENERATED --
                */
            