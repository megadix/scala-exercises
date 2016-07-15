import common._

// Inspired by "Pragmatic Scala" https://pragprog.com/book/vsscala2/pragmatic-scala

object FunctionArgumentsResults extends App {

  headLine("Tuples")

  def getData(): (String, Int, Boolean) = {
    return ("Hello", 10, false)
  }

  val data = getData()
  println(data)
  println(s"${data._1}, ${data._2}, ${data._3}")

  headLine("VarArgs")

  def printNames(names: String*) = {
    names.foreach(name => println(s"- $name"))
  }

  printNames("Aldo", "Giovanni", "Giacobbo", "Chupacabra")
  println

  headLine("Default values for parameters")

  def functionWithDefaultParams(name: String, option1: String = "Default 1", option2: String = "Default 2") = {
    println(s"$name, $option1, $option2")
  }

  functionWithDefaultParams("Dimitri", "De Franciscis", "Milano")
  functionWithDefaultParams("Scala", "Minnesota")
  functionWithDefaultParams("JaggiaScript")
  println

  headLine("Named parameters")

  functionWithDefaultParams(option2 = "Milano", option1 = "De Franciscis", name = "Dimitri")
  println

  headLine("Implicit parameters + default value")

  def functionWithImplicitParameters(description: String)(implicit implicitParam: String) = {
    println(s"$description\n$implicitParam")
  }

  def implicitParamTestA() = {
    implicit def implicitParamA = "Value A-1"
    def explicitParamB = "Value A-2"

    functionWithImplicitParameters("No implicit parameter is passed to function - defaults to implicit parameter \"Value A-1\":")
    functionWithImplicitParameters("Explicit parameter \"Value A-2\" is passed to function:")(explicitParamB)
  }

  def implicitParamTestB() = {
    implicit def implicitParamA = "Value B"
    functionWithImplicitParameters("No implicit parameter is passed to function - defaults to implicit parameter \"Value B\":")
  }

  implicitParamTestA()
  implicitParamTestB()

}
