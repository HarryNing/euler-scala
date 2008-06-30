import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.File;

object EulerGen {
  def main (args :Array[String]) {
    if (args.length == 0) {
      println("Usage: EulerGen N");
      exit(255);
    }

    val n :Int = Integer.valueOf(args(0)).intValue();
    val name = "Euler" + n + ".scala";
    val file = new File(name);
    if (file.exists()) {
      println(name + " already exists.");
      exit(255);
    }

    println("Generating " + name + "...");
    val out = new PrintWriter(new FileWriter(file));
    out.println("object Euler" + n + " extends EulerApp {");
    out.println("  // brilliant solution goes here");
    out.println("}");
    out.close();
  }
}
