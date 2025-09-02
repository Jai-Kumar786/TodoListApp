// A Scala Worksheet to demonstrate Option

// In Java or other languages, a method that might not find a result would return `null`.
def findUserById_unsafe(id: Int): String = {
  if (id == 1) "Alice" else null
}

// val user = findUserById_unsafe(2)
// println(user.toUpperCase()) // This would crash with a NullPointerException!

// --- The Scala Way: `Option` ---
// An Option[A] is a container that can hold either a value of type A or nothing at all.
// It has two possible forms:
// 1. Some(value) - The container has a value.
// 2. None - The container is empty.

def findUserById_safe(id: Int): Option[String] = {
  if (id == 1) Some("Alice") else None
}

val foundUser = findUserById_safe(1)
val missingUser = findUserById_safe(2)

println(s"Result for user 1: $foundUser")
println(s"Result for user 2: $missingUser")

// How do we work with an Option? Using a `match` expression.
// `match` forces you to handle BOTH cases. You can't forget `None`.
println("\n--- Using match to safely get the value ---")
missingUser match {
  case Some(name) => println(s"User found: ${name.toUpperCase}")
  case None       => println("User could not be found.")
}

// You can also use methods like `map` on an Option.
// The operation inside `map` only runs if the Option is a `Some`.
println("\n--- Using map on an Option ---")
val mappedFoundUser = foundUser.map(name => name.toUpperCase)
val mappedMissingUser = missingUser.map(name => name.toUpperCase) // This does nothing

println(s"Mapped result for user 1: $mappedFoundUser")
println(s"Mapped result for user 2: $mappedMissingUser")

// If you need a default value, `getOrElse` is perfect.
println("\n--- Using getOrElse for default values ---")
val userName = missingUser.getOrElse("Guest User")
println(s"The user's name is: $userName")