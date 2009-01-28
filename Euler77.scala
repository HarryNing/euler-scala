object Euler77 extends EulerApp {
  val smap = new scala.collection.mutable.HashMap[Pair[Int, Int],Int]
  def sums (n :Int, max :Int) :Int = smap.getOrElseUpdate((n, max), {
    def isok (n :Int) = n <= max && n > 1 && isprime(n)
    (if (isok(n)) 1 else 0) + 2.to(n-1).filter(isok).map(k => sums(n-k, k)).sum
  })
  println(1.to(100).map(n => (n, sums(n, n))).dropWhile(_._2 < 5000).first._1)
}
