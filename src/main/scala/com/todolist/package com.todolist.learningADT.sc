

// A Scala Worksheet to demonstrate ADTs and Either

// --- Algebraic Data Types (ADTs) ---
// An ADT is a way of creating a type that can only be one of a few specific things.
// We use a `sealed trait` and then `case object`s or `case class`es that extend it.
// "sealed" means all possible extensions must be in this same file.

sealed trait TaskStatus
case object Todo extends TaskStatus
case object InProgress extends TaskStatus
case object Done extends TaskStatus

// Now, a Task's status can *only* be one of these three options.
// A Boolean (`isDone`) could only represent two states. This is more expressive.
case class Task(id: Int, description: String, status: TaskStatus)

val task = Task(1, "Learn ADTs", InProgress)
println(s"Our new task: $task")


// --- Handling Success or Failure with `Either` ---
// Sometimes `None` isn't enough. We want to know *why* something failed.
// `Either[L, R]` represents a value that can be one of two things.
// By convention:
// - Left represents failure (L for Left/Loser).
// - Right represents success (R for Right/Correct).

// Let's create a function that "parses" a user command.
def parseCommand(input: String): Either[String, Int] = {
  if (input.startsWith("complete")) {
    // Try to convert the part after "complete " to an Int
    try {
      val id = input.substring(9).trim.toInt
      Right(id) // Success! Return the ID wrapped in a Right.
    } catch {
      case _: NumberFormatException =>
        Left("Invalid ID provided. It must be a number.") // Failure.
    }
  } else {
    Left("Invalid command. Please use 'complete <id>'.") // Failure.
  }
}

val goodCommand = "completed 2"
val badCommandId = "complete two"
val badCommandSyntax = "delete 2"

val result1 = parseCommand(goodCommand)
val result2 = parseCommand(badCommandId)
val result3 = parseCommand(badCommandSyntax)

println(s"\nParsing '$goodCommand': $result1")
println(s"Parsing '$badCommandId': $result2")
println(s"Parsing '$badCommandSyntax': $result3")

// We can use `match` to work with the result.
println("\n--- Processing the result ---")
result1 match {
  case Right(id)      => println(s"Success! We need to complete task with ID: $id")
  case Left(errorMsg) => println(s"Error: $errorMsg")
}

result2 match {
  case Right(id)      => println(s"Success! We need to complete task with ID: $id")
  case Left(errorMsg) => println(s"Error: $errorMsg")
}
