// @SOURCE:/media/disk/m3system-airman/workspace/maptracker/conf/routes
// @HASH:8bc09f5df86e9ff1b5710dcd74880d34a9d486f2
// @DATE:Tue Apr 10 16:45:19 CEST 2012

import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString

object Routes extends Router.Routes {


// @LINE:6
val controllers_Application_index0 = Route("GET", PathPattern(List(StaticPart("/"))))
                    

// @LINE:8
val controllers_Application_showMap1 = Route("GET", PathPattern(List(StaticPart("/map"))))
                    

// @LINE:10
val controllers_Application_moveTo2 = Route("POST", PathPattern(List(StaticPart("/moveTo"))))
                    

// @LINE:12
val controllers_Application_mapsocket3 = Route("GET", PathPattern(List(StaticPart("/mapsocket"))))
                    

// @LINE:15
val controllers_Assets_at4 = Route("GET", PathPattern(List(StaticPart("/assets/"),DynamicPart("file", """.+"""))))
                    
def documentation = List(("""GET""","""/""","""controllers.Application.index()"""),("""GET""","""/map""","""controllers.Application.showMap()"""),("""POST""","""/moveTo""","""controllers.Application.moveTo()"""),("""GET""","""/mapsocket""","""controllers.Application.mapsocket()"""),("""GET""","""/assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)"""))
             
    
def routes:PartialFunction[RequestHeader,Handler] = {        

// @LINE:6
case controllers_Application_index0(params) => {
   call { 
        invokeHandler(_root_.controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Nil))
   }
}
                    

// @LINE:8
case controllers_Application_showMap1(params) => {
   call { 
        invokeHandler(_root_.controllers.Application.showMap(), HandlerDef(this, "controllers.Application", "showMap", Nil))
   }
}
                    

// @LINE:10
case controllers_Application_moveTo2(params) => {
   call { 
        invokeHandler(_root_.controllers.Application.moveTo(), HandlerDef(this, "controllers.Application", "moveTo", Nil))
   }
}
                    

// @LINE:12
case controllers_Application_mapsocket3(params) => {
   call { 
        invokeHandler(_root_.controllers.Application.mapsocket(), HandlerDef(this, "controllers.Application", "mapsocket", Nil))
   }
}
                    

// @LINE:15
case controllers_Assets_at4(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(_root_.controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String])))
   }
}
                    
}
    
}
                