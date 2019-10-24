package workshop.simpleapps

import cats.effect.{ExitCode, IO, IOApp}
import cats.effect.Console.io._

object Greeter extends IOApp {

  def run(args: List[String]): IO[ExitCode] = for {
    _    <- putStr("What's your name: ")
    name <- readLn
    _    <- putStrLn(s"Hello, $name!")
  } yield ExitCode.Success

}
