import sbt._

name := "play-extreme-test"

organization := "org.bbscala"

scalaVersion := "2.10.2"

scalacOptions := Seq("-unchecked", "-deprecation", "-feature", "-language:_")

resolvers += "spray repo" at "http://repo.spray.io"

resolvers += "spray nightlies" at "http://nightlies.spray.io"

resolvers += "Local Maven Repository" at "file://"+Path.userHome.absolutePath+"/.m2/repository"

libraryDependencies ++= {
  val scalazVersion = "7.0.3"
  val liftJsonVersion = "2.5"
  val scalaTestVersion = "1.9.1"
  Seq(
      "com.stackmob" %% "newman" % "1.0.0",
      "org.scalaz" %% "scalaz-core" % scalazVersion,
      "org.scalaz" %% "scalaz-effect" % scalazVersion,
      "org.scalaz" %% "scalaz-concurrent" % scalazVersion,
      "io.spray" % "spray-client" % "1.2-20130822",
      "com.typesafe.akka" %% "akka-actor" % "2.2.0",
      "net.liftweb" %% "lift-json-scalaz7" % liftJsonVersion,
      "org.scalatest" % "scalatest_2.10" % "2.0.M5b" % "test",
      //"org.scalatest" %% "scalatest" % scalaTestVersion % "test",
      "org.scalacheck" %% "scalacheck" % "1.10.1" % "test"
     )
}

logBuffered := false

