package workshop

import cats.effect._
import cats.implicits._

import scala.concurrent.duration._

object HelloFibers extends internal.IORuntime {

  val printHello: IO[Unit] = for {
    threadId <- IO(Thread.currentThread().getId())
    _        <- IO(println(s"[Thread $threadId] - Hello"))
  } yield ()

  def loop(pause: FiniteDuration): IO[Unit] =
    printHello >> IO.sleep(pause) >> IO.suspend(loop(pause))

}