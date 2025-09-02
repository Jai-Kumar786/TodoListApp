/**
 * This is the main entry point for our application.
 * An 'object' in Scala is a singleton instance of a class.
 * It's a common place to put the main method.
 */
object Main {
  /**
   * The main method.
   * @param args Command-line arguments, which we won't use yet.
   * 'Unit' is Scala's way of saying a method returns nothing of interest (like 'void' in other languages).
   */
  def main(args: Array[String]): Unit = {
    // --- Calling the method from the Practice object ---

    // Case 1: An adult user
    // We create an immutable value `greetingForAdult` to hold the result.
    val greetingForAlice = Practice.generatePersonalGreeting("Alice", 30)
    println(greetingForAlice) // Expected output: Hello, Alice! Welcome to the club.

    // Case 2: A minor user
    // We call the same method with different arguments.
    val greetingForBob = Practice.generatePersonalGreeting("Bob", 15)
    println(greetingForBob)   // Expected output: Sorry, Bob, you are not old enough.
  }
}
