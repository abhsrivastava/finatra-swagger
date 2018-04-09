val versions = new {
  val finatra = "17.12.0"
  val logback = "1.2.3"
  val scalatest = "3.0.5"
  val swagger = "1.0.5"
}
val p = (project in file(".")).settings(
  name := "finatra-swagger",
  organization := "com.abhi",
  scalaVersion := "2.12.5",
  libraryDependencies ++= Seq(
    "com.twitter" %% "finatra-http" % versions.finatra,
    "ch.qos.logback" % "logback-classic" % versions.logback,
    "org.scalatest" %% "scalatest" % versions.scalatest,
    "com.jakehschwartz" %% "finatra-swagger" % versions.finatra
  )
)