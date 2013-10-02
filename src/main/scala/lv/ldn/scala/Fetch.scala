package lv.ldn.scala

object Fetch {
  def scala[K, V](locations: List[K], fetcher: Fetcher): List[V] = {
    locations.par.map(fetcher.fetch).toList
  }

  trait Fetcher {
    def fetch[K, V](location: K): V
  }
}
