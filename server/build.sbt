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
libraryDependencies += "javax.mail" % "javax.mail-api" % "1.5.5"
libraryDependencies += "javax.mail" % "mail" % "1.4"
libraryDependencies += "com.typesafe.play" % "play-mailer_2.11" % "5.0.0-M1"
libraryDependencies += "io.dropwizard" % "dropwizard-core" % "1.0.0-rc2"
libraryDependencies += "io.dropwizard" % "dropwizard-auth" % "1.0.0-rc2"
libraryDependencies += "io.dropwizard" % "dropwizard-client" % "1.0.0-rc2"
libraryDependencies += "io.dropwizard" % "dropwizard-migrations" % "1.0.0-rc2"
libraryDependencies += "io.dropwizard" % "dropwizard-assets" % "1.0.0-rc2"
libraryDependencies += "io.dropwizard" % "dropwizard-hibernate" % "0.7.0"

libraryDependencies += "org.hibernate" % "hibernate-core" % "5.1.0.Final"
libraryDependencies += "com.nimbusds" % "nimbus-jose-jwt" % "4.16.2"
libraryDependencies += "org.mindrot" % "jbcrypt" % "0.3m"
libraryDependencies += jdbc
