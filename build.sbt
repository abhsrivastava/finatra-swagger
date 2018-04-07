val versions = new {
  val finatra = "18.3.0"
  val logback = "1.2.3"
  val scalatest = "3.0.5"
  val swagger = "1.0.5"
}
val p = (project in file(".")).settings(
  name := "finatra-tut",
  organization := "com.abhi",
  scalaVersion := "2.12.5",
  libraryDependencies ++= Seq(
    "com.twitter" %% "finatra-http" % versions.finatra,
    "ch.qos.logback" % "logback-classic" % versions.logback,
    "org.scalatest" %% "scalatest" % versions.scalatest,
    "io.paradoxical" %% "finatra-swagger" % versions.swagger
  )
)