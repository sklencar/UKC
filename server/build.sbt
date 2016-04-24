name := """server"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs
)

libraryDependencies += "org.json" % "json" % "20160212"
libraryDependencies += "org.json"%"org.json"%"chargebee-1.0"
libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.38"
libraryDependencies += "com.google.code.gson" % "gson" % "2.6.2"
libraryDependencies += jdbc
