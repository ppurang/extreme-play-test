import sbt._

name := "play-extreme-test"

organization := "org.bbscala"

scalaVersion := "2.10.3"

resolvers += "ppurang bintray" at " http://dl.bintray.com/ppurang/maven"

resolvers += "spray repo" at "http://repo.spray.io"

resolvers += "spray nightlies" at "http://nightlies.spray.io"

//resolvers += "Local Maven Repository" at "file://"+Path.userHome.absolutePath+"/.m2/repository"
libraryDependencies ++= {
  val httpCoreVersion = "4.3.1"
  val httpClientVersion = "4.3.1"
  val scalazVersion = "7.0.5"
  val liftJsonVersion = "2.5"
  val scalaTestVersion = "1.9.1"
  Seq(
    "io.argonaut" %% "argonaut" % "6.0.1" withSources(),
    "org.purang.net" %% "asynch" % "0.3.0" withSources(),
    "com.typesafe" % "config" % "1.0.2" withSources(),
    "net.ceedubs" %% "ficus" % "1.0.0" withSources(),
    "org.apache.httpcomponents" % "httpcore" % httpCoreVersion,
    "org.apache.httpcomponents" % "httpclient" % httpClientVersion,
    "com.stackmob" %% "newman" % "1.3.5",
    "org.scalaz" %% "scalaz-core" % scalazVersion withSources(),
    "org.scalaz" %% "scalaz-effect" % scalazVersion withSources(),
    "org.scalaz" %% "scalaz-concurrent" % scalazVersion withSources(),
    "io.spray" % "spray-client" % "1.2.0",
    "com.typesafe.akka" %% "akka-actor" % "2.2.3",
    "net.liftweb" %% "lift-json-scalaz7" % liftJsonVersion,
    "org.scalatest" % "scalatest_2.10" % "2.0" % "test",
    //"org.scalatest" %% "scalatest" % scalaTestVersion % "test",
    "org.scalacheck" %% "scalacheck" % "1.11.1" % "test",
    "org.specs2" %% "specs2" % "2.3.7" % "test",
    "com.nicta" %% "rng" % "1.1" % "test" withSources()
  )
}

logBuffered := false

scalacOptions ++= Seq("-unchecked", "-optimize", "-feature", "-language:_", "-deprecation", "-Xfatal-warnings", "-Xlint",  "-encoding",  "UTF-8", "-target:jvm-1.7", "-Ywarn-adapted-args", "-Ywarn-value-discard", "-Xlog-reflective-calls", "-Yinline-warnings",   "-Yclosure-elim",
  "-Yinline", "-Xverify", "-Ywarn-all")


cancelable := true

fork in (Test,run) := true

//parallelExecution in Test := false