scalaVersion := "2.13.1"

libraryDependencies ++= Seq(
  "org.typelevel"  %% "cats-effect"  % "2.0.0",
  "dev.profunktor" %% "console4cats" % "0.8.0",
  "org.scalatest"  %% "scalatest"    % "3.0.8" % Test
)

initialCommands in console += Seq(
  "import cats._, cats.effect._, cats.implicits._",
  "import scala.concurrent.duration._"
).mkString("\n")

