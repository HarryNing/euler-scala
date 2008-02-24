object Euler44 extends Application {
  def pent (n :Int) = n*(3*n-1)/2;
  val pents = Set() ++ List.range(1, 3000).map(pent);
  def find (a :Int, b :Int) :Int = {
    val pa = pent(a);
    val pb = pent(b);
    val d = pb-pa;
    val s = pa+pb;
    if (pents.contains(d) && pents.contains(s)) return d;
    if (a >= b) return find(1, b+1);
    else return find(a+1, b);
  }
  println(find(1, 2));
}