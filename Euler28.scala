object Euler28 extends Application {
  def spiral (size :Int) :Int = {
    if (size == 1) return 1;
    val smaller = size-2;
    spiral(smaller) + 4*(smaller*smaller) + 10*(smaller+1);
  }
  println(spiral(1001));
}
