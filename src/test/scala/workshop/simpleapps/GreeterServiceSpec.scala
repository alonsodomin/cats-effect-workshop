package workshop.simpleapps

import cats.data.Chain
import cats.effect._
import cats.effect.concurrent.Ref
import cats.effect.test.TestConsole

import org.scalatest.{FlatSpec, Matchers}

class GreeterServiceSpec extends FlatSpec with Matchers {
  final val TestName = "MyName"

  "GreeterService" should "greet me" in {
    val test = for {
      // Initialise mock Console
      words  <- Ref[IO].of(Chain.empty[String])
      lines  <- Ref[IO].of(Chain.empty[String])
      stderr <- Ref[IO].of(Chain.empty[String])
      inputs <- TestConsole.inputs.sequenceAndDefault[IO](Chain.empty, TestName)

      // Initialise GreetService
      console = TestConsole.make(lines, words, stderr, inputs)
      service = GreetService.withConsole[IO](console)

      // Run the operation
      _ <- service.greetSomeone

      // Collect evidence
      prompt <- words.get
      result <- lines.get
    } yield (prompt, result)

    val (prompted, printed) = test.unsafeRunSync()

    prompted shouldBe Chain.one("What's your name: ")
    printed shouldBe Chain.one(s"Hello, $TestName!")
  }

}
