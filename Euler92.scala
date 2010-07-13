object Euler92 {
  def digsq (n :Int, acc :Int) :Int = if (n == 0) acc else digsq(n/10, acc + (n%10)*(n%10))
  val sqcache = scala.collection.mutable.Map(1 -> 1)
  def fixpsq (n :Int) :Int = sqcache.getOrElseUpdate(
    n, if (n == 1 || n == 89) n else fixpsq(digsq(n, 0)))
  def main (args :Array[String]) {
    println((1 to 10000000).foldLeft(0)((s, n) => if (fixpsq(digsq(n, 0)) == 89) s+1 else s))
  }
}
