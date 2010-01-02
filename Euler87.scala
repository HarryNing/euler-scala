object Euler87 extends EulerApp {
  val primes = genprimes(7071).filter(_!=0)
  val ns = for (a <- primes; // 7071 = 2rt(50m)
                b <- primes.takeWhile(_ < 368); // 3rt(50m)
                c <- primes.takeWhile(_ < 84); // 4rt(50m)
                n = a*a + b*b*b + c*c*c*c; if (n < 50000000)) yield n
  println(ns.removeDuplicates.length)
}