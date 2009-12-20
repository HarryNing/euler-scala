object Euler82 extends EulerApp {
  val matrix = readlines("matrix.txt").map(_.split(",").map(_.toInt)).transpose
  def iter (accum :List[Int], cur :List[Int]) = {
    var col = accum.zip(cur).map(p => p._1+p._2).toArray
    for (y <- 1 until col.length) col(y) = Math.min(col(y), col(y-1)+cur(y))
    for (y <- (0 until col.length-1).reverse) col(y) = Math.min(col(y), col(y+1)+cur(y))
    col.toList
  }
  println((matrix reduceLeft iter).min)
}
