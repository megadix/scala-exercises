import common._

// Inspired by "Pragmatic Scala" https://pragprog.com/book/vsscala2/pragmatic-scala

object Java2ScalaPrimitives extends App {

  headLine("Ranges - Imperative style")

  println("Old-school for loop:")

  for (i <- 1 to 5) {
    print(s"$i ")
  }
  println

  println("Use of until:")

  for (i <- 1 until 5) {
    print(s"$i ")
  }
  println

  headLine("Ranges - Functional style")

  println("map() + forEach()")

  (1 to 5)
    .map(i => i * i)
    .foreach(i => print(s"$i "))
  println

  println("foldLeft()")
  val sum = (1 to 5).foldLeft(0) {(a, b) => a + b}
  println(s"Sum: $sum")

}
