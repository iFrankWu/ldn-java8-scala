package lv.ldn.scala

object NonFinal {
  def mutable {
    var count = 0
    val strings = Seq("a", "b", "c")
    strings.foreach(s => count += 1)
  }

  def atomic {
    val count = new java.util.concurrent.atomic.LongAdder
    val strings = Seq("a", "b", "c")
    strings.foreach(s => count.increment())
  }
}
