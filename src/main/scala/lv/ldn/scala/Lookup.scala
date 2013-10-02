package lv.ldn.scala

object Lookup {
  def scala[K, V](list: List[K], index: Map[K, V]): List[V] = list.flatMap(index.get)
}
