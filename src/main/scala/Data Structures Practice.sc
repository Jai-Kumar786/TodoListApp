// Welcome to Day 2! Let's explore Scala's collections.
// You can run this file as a Scala Worksheet in IntelliJ to see the output.

// --- LISTS ---
// A List is an immutable, ordered sequence of elements of the same type.
// "Immutable" means you cannot change a list after it's created.
// Instead, you create a *new* list with the desired changes.

val numbers: List[Int] = List(1, 2, 3, 4, 5)
println(s"Our starting list of numbers: $numbers")

// Adding an element (prepending)
// The `::` operator is called "cons" (construct). It creates a NEW list.
val numbersPlusZero = 0 :: numbers
println(s"After adding 0: $numbersPlusZero")
println(s"The original list is unchanged: $numbers") // Note the original is unaffected!

// --- Common List Operations ---

// 1. Transforming elements with `map`
// `map` applies a function to every element and returns a NEW list with the results.
val doubledNumbers = numbers.map(num => num * 2)
println(s"Numbers doubled using map: $doubledNumbers")

// 2. Filtering elements with `filter`
// `filter` creates a NEW list containing only the elements that satisfy a predicate (a function returning Boolean).
val evenNumbers = numbers.filter(num => num % 2 == 0)
println(s"Even numbers filtered from the list: $evenNumbers")

// 3. Combining map and filter (a very common pattern)
// Let's get the squares of only the odd numbers.
val squaresOfOdds = numbers
  .filter(num => num % 2 != 0) // First, get only the odd numbers -> List(1, 3, 5)
  .map(num => num * num)     // Then, square each of them -> List(1, 9, 25)
println(s"Squares of odd numbers: $squaresOfOdds")


// --- MAPS ---
// A Map is an immutable collection of key-value pairs.
// Great for lookups, like a dictionary.

val userAges: Map[String, Int] = Map(
  "Alice" -> 30,
  "Bob" -> 25,
  "Charlie" -> 35
)
println(s"\nOur map of user ages: $userAges")

// Accessing a value by key
// Using .get returns an `Option` (more on this tomorrow!), which is a safe way to handle missing keys.
val bobsAge = userAges.get("Bob")
println(s"Bob's age (using get): $bobsAge") // Some(25)

val davidsAge = userAges.get("David")
println(s"David's age (using get): $davidsAge") // None, because David isn't in the map.

// Adding a new key-value pair
// This creates a NEW map.
val userAgesWithDavid = userAges + ("David" -> 22)
println(s"Map after adding David: $userAgesWithDavid")
println(s"Original map is unchanged: $userAges")