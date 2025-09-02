//package com.todolist.service
//
//import com.todolist.model.Task
//
//object TodoService {
//
//  // This is our starting "database" of tasks.
//  // It's an immutable List of Task objects.
//  val initialTasks: List[Task] = List(
//    Task(1, "Install IntelliJ and Scala plugin",   true), // Let's say this one is already done
//    Task(2, "Learn about collections and case classes", false),
//    Task(3, "Complete Day 2 assignment", false),
//    Task(4, "Prepare for Day 3", false)
//  )
//
//  /**
//   * Marks a specific task as done in a list of tasks.
//   * This is a pure function: it does not modify the original list.
//   * Instead, it returns a new list with the change.
//   *
//   * @param tasks The list of tasks to process.
//   * @param id The ID of the task to mark as done.
//   * @return A new List[Task] where the specified task's `isDone` flag is set to true.
//   */
//  def markAsDone(tasks: List[Task], id: Int): List[Task] = {
//    tasks.map(task => {
//      if (task.id == id) {
//        // This is the task we're looking for.
//        // Return a *new* Task object that is a copy of the original,
//        // but with the isDone field set to true.
//        task.copy(isDone = true)
//      } else {
//        // This is not the task we're looking for, so return it unchanged.
//        task
//      }
//    })
//  }
//
//}
package com.todolist.service

import com.todolist.model.{Done, InProgress, Task, Todo}

object TodoService {

  // Our initial data now uses the new TaskStatus ADT.
  val initialTasks: List[Task] = List(
    Task(1, "Organize project structure", Done),
    Task(2, "Learn about Option and Either", InProgress),
    Task(3, "Refactor TodoService", Todo),
    Task(4, "Prepare for Day 4", Todo)
  )

  /**
   * Safely finds a task by its ID from a list of tasks.
   *
   * @param id The ID of the task to find.
   * @param tasks The list of tasks to search within.
   * @return An `Option[Task]`. It will be `Some(task)` if found, or `None` if not.
   * The `find` method on List is perfect for this, as it returns an Option by default.
   */
  def findTaskById(id: Int, tasks: List[Task]): Option[Task] = {
    tasks.find(task => task.id == id)
  }

  /**
   * Marks a specific task as done, handling the case where the task might not exist.
   *
   * @param tasks The list of tasks to process.
   * @param id The ID of the task to mark as done.
   * @return An `Either[String, List[Task]]`.
   * - `Right(updatedList)` on success.
   * - `Left(errorMessage)` on failure (e.g., task not found).
   */
  def markAsDone(tasks: List[Task], id: Int): Either[String, List[Task]] = {
    // First, check if the task we want to modify actually exists.
    findTaskById(id, tasks) match {
      case Some(taskToUpdate) =>
        // The task was found! Now we can map the list and update it.
        val updatedList = tasks.map(task => {
          if (task.id == id) {
            task.copy(status = Done)
          } else {
            task
          }
        })
        Right(updatedList) // Wrap the successful result in a Right.

      case None =>
        // The task was not found. Return a descriptive error message in a Left.
        Left(s"Error: Task with ID $id not found.")
    }
  }
}
