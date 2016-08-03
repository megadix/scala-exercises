import common._

class User(val username: String, var password: String) {
  override def toString: String = s"$username / $password"
}

class ApplicationUser(username: String, password: String, val fullName: String, var address: String = "None",
                      var profession: String = "Unknown")
  extends User(username, password) {

  // example of secondary constructor
  def this(username: String, password: String, fullName: String, address: String, number: Int) = {
    this(username, password, fullName, address + " " + number)
    profession = "Not disclosed"
  }

  override def toString: String = s"${super.toString}, $fullName, $address, profession = ${profession}"
}

object Classes extends App {

  bigTitle("Classes")

  headLine("Concise syntax for class creation")

  val superman = new User("superman", "superpassword")
  println(superman)
  superman.password = "newpassword"
  println(superman)
  // would give error: "reassignment to val"
  // superman.username = "new username"


  headLine("Inheritance")

  val clarkKent = new ApplicationUser("ckent", "34jh3khk34", "Clark Kent", "Some street", "Under cover superhero")
  println(clarkKent)
  clarkKent.address = "A new address"
  println(clarkKent)

  val bobbyBrown = new ApplicationUser("bbrown", "goingdown", "Bobby Brown", "FZ Avenue")
  println(bobbyBrown)

  var jesseJames = new ApplicationUser("jjames", "vcs9dwm568f", "Jesse James", "Some Address", 355)
  println(jesseJames)

}

