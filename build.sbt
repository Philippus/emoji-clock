name         := "emoji-clock"
organization := "nl.gn0s1s"
startYear    := Some(2017)
homepage     := Some(url("https://github.com/philippus/emoji-clock"))
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))

developers := List(
  Developer(
    id = "philippus",
    name = "Philippus Baalman",
    email = "",
    url = url("https://github.com/philippus")
  )
)

ThisBuild / versionScheme          := Some("semver-spec")
ThisBuild / versionPolicyIntention := Compatibility.None

Compile / packageBin / packageOptions += Package.ManifestAttributes("Automatic-Module-Name" -> "nl.gn0s1s.emojiclock")

crossScalaVersions := List("2.12.20", "2.13.17")
scalaVersion       := crossScalaVersions.value.last

libraryDependencies ++= Seq(
  "com.lightbend"  %% "emoji"      % "1.3.0"  % Test,
  "org.scalacheck" %% "scalacheck" % "1.19.0" % Test
)
