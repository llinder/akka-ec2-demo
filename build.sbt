import sbtassembly.Plugin._
import sbtassembly.Plugin.AssemblyKeys._
import spray.revolver.RevolverPlugin.Revolver.{settings => revolverSettings}

revolverSettings

assemblySettings

organization := "io.buddho"

name := "akka-ec2-demo"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.10.4"

jarName in assembly := "akka-ec2-demo.jar"

mainClass in assembly := Some("io.buddho.demo.akka.Main")

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.3.4",
  "com.typesafe.akka" %% "akka-cluster" % "2.3.4",
  "com.github.scopt" %% "scopt" % "3.2.0",
  "com.amazonaws" % "aws-java-sdk" % "1.8.9.1",
  "ch.qos.logback" % "logback-classic" % "1.1.2" % "runtime",
  "org.scalatest" %% "scalatest" % "2.2.1" % "test"
)

resolvers ++= Seq(
  Classpaths.typesafeReleases,
  Resolver.sonatypeRepo("public")
)
    