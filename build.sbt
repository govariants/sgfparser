ThisBuild / scalaVersion := "2.13.2"
ThisBuild / organization := "org.govariants"
ThisBuild / name := "sgfparser"
ThisBuild / organizationName := "Go Variants"
ThisBuild / homepage := Some(url("https://github.com/govariants/sgfparser"))
ThisBuild / licenses := List("Apache-2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0"))
ThisBuild / developers := List(
  Developer("m09", "m09", "142691+m09@users.noreply.github.com", url("https://github.com/m09"))
)

val customScalaJSVersion = Option(System.getenv("SCALAJS_VERSION"))

lazy val sgfparser = crossProject(JSPlatform, JVMPlatform)
  .in(file("."))
  .settings(
    scalacOptions ++= Seq(
      "-deprecation",
      "-unchecked",
      "-Xlint",
      "-Xfatal-warnings"
    ),
    libraryDependencies ++= Seq(
      "com.lihaoyi" %%% "fastparse" % "2.3.0"
    )
  )
  .jvmSettings(skip.in(publish) := customScalaJSVersion.isDefined)
