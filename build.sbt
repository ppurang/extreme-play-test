import sbt._

name := "play-extreme-test"

organization := "org.bbscala"

scalaVersion := "2.10.2"

scalacOptions := Seq("-unchecked", "-deprecation", "-feature")

resolvers += "spray repo" at "http://repo.spray.io"

resolvers += "spray nightlies" at "http://nightlies.spray.io"

resolvers += "Local Maven Repository" at "file://"+Path.userHome.absolutePath+"/.m2/repository"

libraryDependencies ++= {
  val httpCoreVersion = "4.2.1"
  val httpClientVersion = "4.2.1"
  val scalazVersion = "7.0.0"
  val liftJsonVersion = "2.5"
  val scalaTestVersion = "1.9.1"
  Seq(
    "org.apache.httpcomponents" % "httpcore" % httpCoreVersion,
    "org.apache.httpcomponents" % "httpclient" % httpClientVersion,
      "com.stackmob" %% "newman" % "0.23.0-SNAPSHOT",
      "org.scalaz" %% "scalaz-core" % scalazVersion,
      "org.scalaz" %% "scalaz-effect" % scalazVersion,
      "org.scalaz" %% "scalaz-concurrent" % scalazVersion,
      "io.spray" % "spray-client" % "1.2-M8",
      "com.typesafe.akka" %% "akka-actor" % "2.2.0-RC1",
      "net.liftweb" %% "lift-json-scalaz7" % liftJsonVersion,
      "org.scalatest" %% "scalatest" % scalaTestVersion % "test",
  "org.scalacheck" %% "scalacheck" % "1.10.1" % "test"
     )
}

logBuffered := false

