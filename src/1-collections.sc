// Inspired by "Pragmatic Scala" https://pragprog.com/book/vsscala2/pragmatic-scalaobject Session {

/**
  * Return symbol, name and previous close as a tuple
  */
def getData(symbol: String): (String, String, Double) = {
  val url = s"http://finance.yahoo.com/d/quotes.csv?s=$symbol&f=snp"
  val data = io.Source.fromURL(url).mkString
  val row = data.split("\n")(0).split(",")
  (symbol, row(1), row(2).toDouble)
}

val symbols = List("GOOGL", "MSFT", "ORCL", "IBM", "AAPL")

// simple List gymnastics
println(symbols
  .sorted
  .reverse
  .map(_.toLowerCase()))

// Find top closing title

val (topSymbol, topName, topValue) =
  symbols
    // comment to disable parallel retrieval
    .par
    // retrieve data
    .map(symbol => getData(symbol))
    // find max closing value
    .maxBy(data => data._3)

println(s"Top closing value by $topName ($topSymbol): $$ $topValue")

