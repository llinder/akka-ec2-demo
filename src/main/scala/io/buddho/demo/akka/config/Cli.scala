package io.buddho.demo.akka.config

import scopt.OptionParser

/**
 * Parse command line arguments
 *
 * Created by Lance Linder on 8/21/14.
 */
object Cli {

  def parse(args: Seq[String]) = new OptionParser[Config]("demo") {
    head("akka-ec2-demo", "0.1.x")
    opt[String]('s', "seed") optional() unbounded() action { (x, c) =>
      c.copy(seeds = c.seeds :+ x) } text "sets cluster seed nodes"
  }.parse(args, Config())

}

case class Config(seeds: List[String] = List())
