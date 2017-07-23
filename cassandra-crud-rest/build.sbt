name := """cassandra-crud-rest"""
organization := "com.semantive"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.12.2"

libraryDependencies += guice

libraryDependencies ++= {
  val datastaxDriverVer = "3.3.0"

  Seq(
    "com.datastax.cassandra" % "cassandra-driver-core" % datastaxDriverVer,
    "com.datastax.cassandra" % "cassandra-driver-mapping" % datastaxDriverVer
  )
}
