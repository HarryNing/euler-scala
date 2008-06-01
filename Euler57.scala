object Euler57 extends Application {
  case class Frac (numer :BigInt, denom :BigInt) {
    def add (n :BigInt) = Frac(n * denom + numer, denom)
    def invert = Frac(denom, numer)
    def numheavy = numer.toString.length > denom.toString.length
  }
  def expand (count :BigInt) :Frac = {
    if (count == 0) Frac(1, 2)
    else expand(count-1).add(2).invert
  }
  println(List.range(0, 1000).filter(i => expand(i).add(1).numheavy).length)
}
