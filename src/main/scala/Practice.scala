object Practice {

  /**
   * Generates a personalized greeting string based on the user's name and age.
   * This method demonstrates several core concepts:
   * - Defining a method with `def`.
   * - Accepting typed parameters (`name: String`, `age: Int`).
   * - Specifying a return type (`: String`).
   * - Using an `if/else` block as an expression to return a value.
   * - Using `s` string interpolation to easily embed variables into a string.
   *
   * @param name The name of the person to greet.
   * @param age The age of the person.
   * @return A greeting string appropriate for their age.
   */
  def generatePersonalGreeting(name: String, age: Int): String = {
    // The if/else block is an EXPRESSION. Its result is what the method returns.
    // There is no need for an explicit `return` keyword.
    if (age >= 18) {
      s"Hello, $name! Welcome to the club."
    } else {
      s"Sorry, $name, you are not old enough."
    }
  }

}
