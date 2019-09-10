name := "dashing"
version := "1.0"
scalaVersion := "2.12.2"

lazy val `dashing` = (project in file(".")).enablePlugins(PlayScala).settings(
  PlayKeys.playDefaultPort := 1408
)

val libraries: Seq[ModuleID] = Seq(
  jdbc,
  ehcache,
  ws,
  specs2 % Test,
  guice
)

libraryDependencies ++= libraries

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )  

      