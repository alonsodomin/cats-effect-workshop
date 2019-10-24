package workshop.simpleapps

import cats.effect.{ExitCode, IO, IOApp}
import cats.effect.Console.io._
import cats.implicits._

object HelloWorld extends IOApp {

  def run(args: List[String]): IO[ExitCode] = {
    putStrLn("Hello, World!") >>
    IO.pure(ExitCode.Success)
  }

}
