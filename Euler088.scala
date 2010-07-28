import scala.collection.mutable.Map
object Euler88 extends EulerApp {
  def minprodsum (mins :Array[Int], n :Int, p :Int, s :Int, l :Int) {
    val np = p * n
    val k = np - (s+n) + (l+1)
    if (k < mins.length) {
      mins(k) = Math.min(np, mins(k))
      minprodsum(mins, n, np, s+n, l+1)
    }
    if (n > 2) minprodsum(mins, n-1, p, s, l)
  }
  val mins = Array.tabulate(12001)(2*_)
  minprodsum(mins, 12000, 1, 0, 0)
  println(mins.drop(2).toList.removeDuplicates.sum)
}