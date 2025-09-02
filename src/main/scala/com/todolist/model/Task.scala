//package com.todolist.model
//
///**
// * This case class represents our data model for a single to-do item.
// *
// * By using a `case class`, Scala automatically provides us with:
// * 1. Immutable fields (`id`, `description`, `isDone` are all `val`s).
// * 2. A useful `toString` method for easy printing.
// * 3. A `copy` method to create modified instances without changing the original.
// * 4. Sensible `equals` and `hashCode` methods for comparisons.
// */
//case class Task(id: Int, description: String, isDone: Boolean)


package com.todolist.model

/**
 * This is our Algebraic Data Type (ADT) for the status of a task.
 *
 * By using a `sealed trait`, we tell the compiler that all possible
 * implementations of TaskStatus are in this file. This allows the compiler
 * to perform "exhaustiveness" checks, warning us if a `match` expression
 * ever misses a case.
 *
 * `case object`s are used because the statuses have no data themselves;
 * they are just singleton values.
 */
sealed trait TaskStatus
case object Todo extends TaskStatus
case object InProgress extends TaskStatus
case object Done extends TaskStatus

case class Task(id: Int, description: String, status: TaskStatus)