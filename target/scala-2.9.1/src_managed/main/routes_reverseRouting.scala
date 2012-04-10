// @SOURCE:/media/disk/m3system-airman/workspace/maptracker/conf/routes
// @HASH:8bc09f5df86e9ff1b5710dcd74880d34a9d486f2
// @DATE:Tue Apr 10 16:45:19 CEST 2012

import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString


// @LINE:15
// @LINE:12
// @LINE:10
// @LINE:8
// @LINE:6
package controllers {

// @LINE:12
// @LINE:10
// @LINE:8
// @LINE:6
class ReverseApplication {
    


 
// @LINE:10
def moveTo() = {
   Call("POST", "/moveTo")
}
                                                        
 
// @LINE:6
def index() = {
   Call("GET", "/")
}
                                                        
 
// @LINE:8
def showMap() = {
   Call("GET", "/map")
}
                                                        
 
// @LINE:12
def mapsocket() = {
   Call("GET", "/mapsocket")
}
                                                        

                      
    
}
                            

// @LINE:15
class ReverseAssets {
    


 
// @LINE:15
def at(file:String) = {
   Call("GET", "/assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                        

                      
    
}
                            
}
                    


// @LINE:15
// @LINE:12
// @LINE:10
// @LINE:8
// @LINE:6
package controllers.javascript {

// @LINE:12
// @LINE:10
// @LINE:8
// @LINE:6
class ReverseApplication {
    


 
// @LINE:10
def moveTo = JavascriptReverseRoute(
   "controllers.Application.moveTo",
   """
      function() {
      return _wA({method:"POST", url:"/moveTo"})
      }
   """
)
                                                        
 
// @LINE:6
def index = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"/"})
      }
   """
)
                                                        
 
// @LINE:8
def showMap = JavascriptReverseRoute(
   "controllers.Application.showMap",
   """
      function() {
      return _wA({method:"GET", url:"/map"})
      }
   """
)
                                                        
 
// @LINE:12
def mapsocket = JavascriptReverseRoute(
   "controllers.Application.mapsocket",
   """
      function() {
      return _wA({method:"GET", url:"/mapsocket"})
      }
   """
)
                                                        

                      
    
}
                            

// @LINE:15
class ReverseAssets {
    


 
// @LINE:15
def at = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"/assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                                                        

                      
    
}
                            
}
                    


// @LINE:15
// @LINE:12
// @LINE:10
// @LINE:8
// @LINE:6
package controllers.ref {

// @LINE:12
// @LINE:10
// @LINE:8
// @LINE:6
class ReverseApplication {
    


 
// @LINE:10
def moveTo() = new play.api.mvc.HandlerRef(
   controllers.Application.moveTo(), HandlerDef(this, "controllers.Application", "moveTo", Seq())
)
                              
 
// @LINE:6
def index() = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Seq())
)
                              
 
// @LINE:8
def showMap() = new play.api.mvc.HandlerRef(
   controllers.Application.showMap(), HandlerDef(this, "controllers.Application", "showMap", Seq())
)
                              
 
// @LINE:12
def mapsocket() = new play.api.mvc.HandlerRef(
   controllers.Application.mapsocket(), HandlerDef(this, "controllers.Application", "mapsocket", Seq())
)
                              

                      
    
}
                            

// @LINE:15
class ReverseAssets {
    


 
// @LINE:15
def at(path:String, file:String) = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]))
)
                              

                      
    
}
                            
}
                    
                