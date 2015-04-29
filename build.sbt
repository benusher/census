val scalaTest = "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test"

lazy val commonSettings = Seq(
  organization := "com.ponchonog",
  version := "0.1.0",
  scalaVersion := "2.11.4"
)

lazy val root = (project in file(".")).
  settings(commonSettings: _*).
  settings(
    name := "census",
    libraryDependencies += scalaTest
  )
