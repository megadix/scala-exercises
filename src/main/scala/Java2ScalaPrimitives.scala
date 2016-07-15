import common._

// Inspired by "Pragmatic Scala" https://pragprog.com/book/vsscala2/pragmatic-scala

object Java2ScalaPrimitives extends App {

  headLine("Strings")

  println("This is a plain old Java String")
  println

  val someValue = "Simple Value"
  println(s"This is an interpolated string: $someValue")

  case class ComplexClass(name: String)
  def complexInstance = new ComplexClass("Nested value")
  println(s"Use curly braces with complex values: ${complexInstance.name}")
  println

  println(
    """Heredoc (multiline strings) example:
      |line 2
      |line 3 - Note: no need to escape double quotes: "Look ma, no escape"
      |line 4 - Note: usage of .stripMargin at the end of the """""".stripMargin)

  headLine("Ranges - Imperative style")
  println

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
