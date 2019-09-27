logLevel  := Level.Warn

resolvers += "Typesafe repository"      at "http://repo.typesafe.com/typesafe/releases/"

resolvers += "scalaz-bintray"           at "https://dl.bintray.com/scalaz/releases"

resolvers += "Akka Snapshot Repository" at "http://repo.akka.io/snapshots/"

addSbtPlugin("org.irundaia.sbt" % "sbt-sassify" % "1.4.11")

addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.7.3")