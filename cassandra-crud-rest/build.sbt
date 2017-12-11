name := """cassandra-crud-rest"""
organization := "com.semantive"

version := "1.1-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.12.2"

libraryDependencies += guice

libraryDependencies ++= {
  val datastaxDriverVer = "3.3.0"
  val cassandraUnitVer = "3.3.0.2"

  Seq(
    "com.datastax.cassandra" % "cassandra-driver-core" % datastaxDriverVer,
    "com.datastax.cassandra" % "cassandra-driver-mapping" % datastaxDriverVer,

    "org.cassandraunit" % "cassandra-unit" % cassandraUnitVer % Test
  )
}

javaOptions in Test += s"""-Djava.library.path=${baseDirectory.value / "native"}"""


