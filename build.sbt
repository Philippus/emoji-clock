name := "emoji-clock"
version := "0.1"
startYear := Some(2017)
licenses := Seq("The MIT License (MIT)" -> url("http://opensource.org/licenses/MIT"))

scalaVersion := "2.12.3"

resolvers += Resolver.typesafeIvyRepo("releases")
libraryDependencies ++= Seq(
  "com.lightbend" %% "emoji" % "1.1.1",
  "org.scalacheck" %% "scalacheck" % "1.13.4" % Test)
