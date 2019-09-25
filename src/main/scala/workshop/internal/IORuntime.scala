package workshop.internal

import cats.effect.{IO, ContextShift, Timer}
import scala.concurrent.ExecutionContext

trait IORuntime {
  implicit val globalContextShift: ContextShift[IO] = IO.contextShift(ExecutionContext.global)
  implicit val globalTimer: Timer[IO] = IO.timer(ExecutionContext.global)
}

object IORuntime extends IORuntime