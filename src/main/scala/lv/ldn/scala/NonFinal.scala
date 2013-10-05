package lv.ldn.scala

import java.util.concurrent.atomic.LongAdder

object NonFinal {
  def mutable {
    var count = 0
    val strings = Seq("a", "b", "c")
    strings.foreach(s => count += 1)
  }

  def atomic {
    val count = new LongAdder
    val strings = Seq("a", "b", "c")
    strings.foreach(s => count.increment())
  }
}
