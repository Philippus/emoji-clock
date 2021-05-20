name := "emoji-clock"
organization := "nl.gn0s1s"
startYear := Some(2017)
homepage := Some(url("https://github.com/philippus/emoji-clock"))
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))

developers := List(
  Developer(
    id = "philippus",
    name = "Philippus Baalman",
    email = "",
    url = url("https://github.com/philippus")
  )
)

crossScalaVersions := List("2.12.13", "2.13.6")
scalaVersion := crossScalaVersions.value.last

libraryDependencies ++= Seq(
  "com.lightbend" %% "emoji" % "1.2.3" % Test,
  "org.scalacheck" %% "scalacheck" % "1.15.4" % Test)
