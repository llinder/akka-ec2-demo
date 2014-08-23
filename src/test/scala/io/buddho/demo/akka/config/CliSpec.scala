package io.buddho.demo.akka.config

import org.scalatest.{GivenWhenThen, FlatSpec}
import org.scalatest.Matchers._

/**
 * Created by Lance Linder on 8/21/14.
 */
class CliSpec extends FlatSpec with GivenWhenThen {

  "Cli parser" should "parse basic arguments" in {

    Given("valid arguments")
    val args = Seq("--seed", "127.0.0.1:2551", "--seed", "127.0.0.1:2552")

    When("args are parsed")
    val result = Cli.parse(args)

    Then("results should be as expected")
    val conf: Config = result match {
      case Some(c) => c
      case None => assert(false, "configuration failed to parse"); null
    }

    conf.seeds.length should be (2)

  }

}
