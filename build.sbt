scalaVersion := "2.13.1"

libraryDependencies ++= Seq(
  "org.typelevel" %% "cats-effect" % "2.0.0"
)

initialCommands in console += Seq(
  "import cats._, cats.effect._, cats.implicits._",
  "import scala.concurrent.duration._",
  "import scala.concurrent.ExecutionContext",
  "implicit val globalContextShift = IO.contextShift(ExecutionContext.global)",
  "implicit val globalTimer = IO.timer(ExecutionContext.global)"
).mkString("\n")

