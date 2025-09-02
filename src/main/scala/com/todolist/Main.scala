package com.todolist

import com.todolist.service.TodoService

object Main {

  def main(args: Array[String]): Unit = {
    println("--- To-Do List Application ---")

    // 1. Print the initial state of our tasks
    println("\nInitial Tasks:")
    // The .foreach(println) is a concise way to print each item in a collection on a new line.
    TodoService.initialTasks.foreach(println)

    // 2. Define which task we want to update
    val taskIdToComplete = 2

    // 3. Call our service method to perform the update
    println(s"\nMarking task with ID $taskIdToComplete as done...")
    val updatedTasks = TodoService.markAsDone(TodoService.initialTasks, taskIdToComplete)

    // 4. Print the new, updated list to verify the change
    println("\nUpdated Tasks:")
    updatedTasks.foreach(println)

    // 5. We can also verify that the original list was not changed (the power of immutability)
    println("\nOriginal Tasks (Unchanged):")
    TodoService.initialTasks.foreach(println)
  }
}