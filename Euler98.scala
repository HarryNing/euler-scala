object Euler98 extends EulerApp {
  class Node () {
    var hasChild :Boolean = false
    var hasWord :Boolean = false
    lazy val children = Array.fill(26)(new Node)
    def contains (w :String) :Boolean = {
      if (w.isEmpty) hasWord
      else children(w.head - 'A').contains(w.substring(1))
    }
    def containsPrefix (p :String) :Boolean = {
      if (!hasChild) false
      else if (p.isEmpty) true
      else children(p.head - 'A').containsPrefix(p.substring(1))
    }
    def add (w :String) {
      if (w.isEmpty) hasWord = true
      else {
        hasChild = true
        children(w.head - 'A').add(w.substring(1))
      }
    }
  }
  val root = new Node

  def anagrams (w :String) = {
    def loop (in :String, cur :String) :Option[String] = {
      if (in.isEmpty)
        if (root.contains(cur) && cur > w) Some(cur)
        else None
      else if (!root.containsPrefix(cur)) None
      else (0 until in.length).map(i => loop(in.patch(i, "", 1), cur + in(i))).
                               flatMap(a => a).headOption
    }
    loop(w, "")
  }

  def checksq (w1 :String, w2 :String) = {
    def issq (i :Int) = math.sqrt(i) == math.sqrt(i).toInt
    def wtoi (w :String, c2d :Map[Char,Int]) = w.map(c2d).reduceLeft((r, d) => r*10+d)
    def check (s1 :Int, s2 :Int) =
      if (issq(s1) && issq(s2) && (s1.toString.length == s2.toString.length)) List(math.max(s1, s2))
      else List()
    def loop (cur :String, map :Map[Char,Int], from :Set[Int]) :List[Int] = {
      if (cur.isEmpty) check(wtoi(w1, map), wtoi(w2, map))
      else from.toList.flatMap(i => loop(cur.drop(1), map + (cur.head -> i), from - i))
    }
    loop(w1, Map(), Set() ++ (0 to 9)).foldLeft(0)(math.max)
  }

  override def main (args :Array[String]) {
    val words = readlines("words.txt").map(_ split(",")).head.map(_ replace("\"", ""))
    words.map(root.add(_))
    println((for (w <- words; a <- anagrams(w)) yield checksq(w, a)).reduceLeft(math.max))
  }
}
