name := "emoji-clock"
organization := "nl.gn0s1s"
version := "0.3.1"
startYear := Some(2017)
homepage := Some(url("https://github.com/philippus/emoji-clock"))
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))

crossScalaVersions := List("2.12.13", "2.13.5")
scalaVersion := "2.13.5"

bintrayOrganization := Some("gn0s1s")
bintrayRepository := "releases"

resolvers += Resolver.typesafeIvyRepo("releases")
libraryDependencies ++= Seq(
  "com.lightbend" %% "emoji" % "1.2.1" % Test,
  "org.scalacheck" %% "scalacheck" % "1.15.3" % Test)

pomExtra :=
  <scm>
    <url>git@github.com:Philippus/emoji-clock.git</url>
    <connection>scm:git@github.com:Philippus/emoji-clock.git</connection>
  </scm>
  <developers>
    <developer>
      <id>philippus</id>
      <name>Philippus Baalman</name>
      <url>https://github.com/philippus</url>
    </developer>
  </developers>
