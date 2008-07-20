object Euler73 extends EulerApp {
  val primes = genprimes(Math.sqrt(10000)).filter(0.!=)
  def iscoprime (denom :Int) = {
    val pfacts = primefacts(primes, denom)
    (numer :Int) => !pfacts.exists(p => (numer%p)==0)
  }
  println(4.to(10000).map(d => (d/3+1).to(d/2).filter(iscoprime(d)).length).sum)
}
