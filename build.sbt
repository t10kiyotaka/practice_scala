name := "scala-fp"

version := "0.1"

scalaVersion := "2.12.7"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % "test"
libraryDependencies += "org.mockito" % "mockito-core" % "2.21.0" % "test"
scalacOptions ++= Seq("-encoding", "UTF-8")