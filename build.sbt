name := """digmarket-api"""
organization := "com.deepmarket"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.13.1"

libraryDependencies ++= Seq(
  guice,
  ehcache,
  javaWs,
  ws,
  "com.typesafe.play" %% "play-ws" % "2.8.0",
  "org.apache.commons" % "commons-lang3" % "3.9"
)

routesGenerator := InjectedRoutesGenerator