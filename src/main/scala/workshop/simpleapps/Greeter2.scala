package workshop.simpleapps

import cats.Monad
import cats.effect.Console.implicits._
import cats.effect.{Console, ExitCode, IO, IOApp}
import cats.implicits._

trait GreetService[F[_]] {
  def greetSomeone: F[Unit]
}
object GreetService {
  def apply[F[_]: Monad](implicit console: Console[F]): GreetService[F] = new GreetService[F] {

    import console._

    override def greetSomeone: F[Unit] = for {
      _    <- putStr("What's your name: ")
      name <- readLn
      _    <- putStrLn(s"Hello, $name!")
    } yield ()
  }

  def withConsole[F[_]: Monad](console: Console[F]): GreetService[F] = {
    implicit val theConsole: Console[F] = console
    apply[F]
  }
}

object Greeter2 extends IOApp {
  override def run(args: List[String]): IO[ExitCode] =
    GreetService[IO].greetSomeone.as(ExitCode.Success)
}
