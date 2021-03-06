import common._

// Inspired by "Pragmatic Scala" https://pragprog.com/book/vsscala2/pragmatic-scala

object Collections extends App {

  /**
    * Return symbol, name and previous close as a tuple
    */
  def getData(symbol: String): (String, String, Double) = {
    val url = s"http://finance.yahoo.com/d/quotes.csv?s=$symbol&f=snp"
    println(s"Retrieving quotes for symbol $symbol...")
    val data = io.Source.fromURL(url).mkString
    println(s"...done ($symbol)")
    val row = data.split("\n")(0).split(",")
    (symbol, row(1), row(2).toDouble)
  }

  headLine("List Basics")

  val symbols = List("GOOGL", "MSFT", "ORCL", "IBM", "AAPL")

  println("List of strings:")
  println(symbols)
  println()

  println("Sort, reverse, map (direct):")

  println(symbols
    .sorted
    .reverse
    .map(_.toLowerCase()))
  println()

  println("Sort, reverse, map (function with variable-length arguments):")

  def sortReverseMap(strings: String*): Seq[String] = {
    strings
      .sorted
      .reverse
      .map(_.toLowerCase())
  }

  println(sortReverseMap("GOOGL", "MSFT", "ORCL", "IBM", "AAPL"))
  println()

  /*
   * Sequential version: stock closing values are retrieved sequentially
   */
  def retrieveStockSequential() = {
    headLine("Find top closing title - sequential version")

    val (topSymbol, topName, topValue) =
      symbols
        // retrieve data
        .map(symbol => getData(symbol))
        // find max closing value
        .maxBy(data => data._3)

    println(s"Top closing value by $topName ($topSymbol): $$ $topValue")

  }

  /*
   * Parallel version: just by adding:
   * .par
   * 
   * stock values are retrieved in parallel!
   */
  def retrieveStockParallel() = {
    headLine("Find top closing title - parallel version")

    val (topSymbol, topName, topValue) =
      symbols
        .par
        .map(symbol => getData(symbol))
        .maxBy(data => data._3)

    println(s"Top closing value by $topName ($topSymbol): $$ $topValue")
  }

  retrieveStockSequential()

  retrieveStockParallel()


}
