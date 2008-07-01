object Euler71 extends EulerApp {
  case class Frac (numer :Int, denom :Int) {
    def lessThan (o :Frac) = numer*o.denom < o.numer*denom
  }
  val fracs = 7.to(1000000).map(n => Frac(n*3/7, n)).filter(_.lessThan(Frac(3, 7))).toList
  println(fracs.sort(_.lessThan(_)).last)
}
