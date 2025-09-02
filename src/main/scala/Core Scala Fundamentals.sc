// In IntelliJ, you can right-click `src/main/scala` -> New -> Scala Worksheet
// and paste this code there to experiment with it live. A worksheet runs code on the fly.

// 1. Immutability: `val` vs. `var`
// This is the most important concept of the day.

val name = "Alice" // An IMMUTABLE value. Like a final variable in Java or a const in JavaScript.
// name = "Bob"    // This would cause a compile error: "Reassignment to val"

var age = 30      // A MUTABLE variable. Its value can be changed.
age = 31          // This is perfectly fine.

// --- PHILOSOPHY ---
// In functional programming, we strongly prefer immutability.
// Always try to use `val` first. Only use `var` when you have a specific reason to.
// This makes code easier to reason about and less prone to bugs.


// 2. Basic Data Types & Type Inference
// Scala has the standard types you'd expect.

val message: String = "This is a string"
val favoriteNumber: Int = 42
val pi: Double = 3.14159
val isLearning: Boolean = true

// But Scala also has great TYPE INFERENCE. You usually don't need to write the type.
val inferredMessage = "Scala knows this is a String"
val inferredNumber = 42 // Scala knows this is an Int


// 3. Everything is an Expression
// Unlike other languages where `if` is a statement, in Scala it's an expression that returns a value.

val userAge = 20
val status = if (userAge >= 18) {
  "Adult"
} else {
  "Minor"
}
// The `if/else` block itself evaluated to a value ("Adult" in this case),
// which was then assigned to the `status` val.

println(s"The user's status is: $status") // String interpolation with `s` prefix


// 4. Defining Methods with `def`
// Methods (or functions) are the building blocks of our logic.

// Syntax: def methodName(paramName: Type, ...): ReturnType = { body }

/**
 * A simple method that takes two integers and returns their sum.
 * The return type is explicitly declared as `: Int`.
 * The `return` keyword is not needed; the last expression in the body is automatically returned.
 */
def add(x: Int, y: Int): Int = {
  x + y
}

// You can also write it on one line if the body is short:
def subtract(x: Int, y: Int): Int = x - y

// A method that doesn't return a meaningful value has a return type of `Unit`.
def greet(name: String): Unit = {
  println(s"Hello, $name!")
}

// Let's call our methods!
val sum = add(5, 3)
println(s"The sum is: $sum")

val difference = subtract(10, 4)
println(s"The difference is: $difference")

greet("Bob") // This method just performs an action (printing).
