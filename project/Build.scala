import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

    val appName         = "maptracker"
    val appVersion      = "1.0-SNAPSHOT"

    val appDependencies = Seq(
        javaCore
    )

    val main = play.Project(appName, appVersion, appDependencies).settings(

      // Twitter Bootstrap v2.0.1 compilation (https://plus.google.com/u/0/108788785914419775677/posts/QgyUF9cXPkv)
      lessEntryPoints <<= (sourceDirectory in Compile)(base => (
                (base / "assets" / "stylesheets" / "twitterbootstrap" / "bootstrap.less") +++
                (base / "assets" / "stylesheets" / "twitterbootstrap" / "responsive.less")
                )),
                
      testOptions in Test ~= { args =>
		  for {
		    arg <- args
		    val ta: Tests.Argument = arg.asInstanceOf[Tests.Argument]
		    val newArg = if(ta.framework == Some(TestFrameworks.JUnit)) ta.copy(args = List.empty[String]) else ta
		  } yield newArg
      }    

    )

}
