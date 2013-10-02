package lv.ldn.scala

import java.net.URL
import concurrent.ExecutionContext.Implicits.global
import concurrent.Future
import language.postfixOps

trait Crawler {
  def download(url: URL): String

  def findLinks(html: String): List[URL]

  def crawl(links: List[URL], consumer: (List[URL]) => Any) {
    val futures = links map { link =>
      Future {
        download(link)
      } map {
        findLinks
      }
    }
    Future.sequence(futures).map(_.flatMap(l => l)).foreach(list => consumer(list))
  }
}
