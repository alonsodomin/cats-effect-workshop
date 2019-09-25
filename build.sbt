scalaVersion := "2.13.1"

libraryDependencies ++= Seq(
  "org.typelevel" %% "cats-effect" % "2.0.0"
)

initialCommands in console += Seq(
  "import cats._, cats.effect._, cats.implicits._",
  "import scala.concurrent.duration._"
).mkString("\n")

