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
libraryDependencies += "org.hibernate" % "hibernate-core" % "5.1.0.Final"
libraryDependencies += "io.dropwizard" % "dropwizard-hibernate" % "0.7.0"
libraryDependencies += "com.nimbusds" % "nimbus-jose-jwt" % "4.16.2"
libraryDependencies += "org.mindrot" % "jbcrypt" % "0.3m"
libraryDependencies += "com.typesafe.play" % "play-java-ebean_2.11" % "2.4.0-M2"
libraryDependencies += evolutions

libraryDependencies += jdbc

/*

  [warn] There may be incompatibilities among your library dependencies. [warn] Here are some of the libraries that were evicted: [warn] * org.hibernate:hibernate-core:4.3.1.Final -> 5.1.0.Final [warn] * io.dropwizard:dropwizard-core:0.7.0 -> 1.0.0-rc2 [warn] * com.typesafe.play:play-java-jdbc_2.11:2.4.0-M2 -> 2.5.2 [warn] Run 'evicted' to see detailed eviction warnings*/
