package com.hhkbdev.threadmanager.util

import java.util.*
import java.util.concurrent.CompletableFuture
import java.util.concurrent.TimeUnit


class ThreadTaskManager {
    private val runningTasks: MutableMap<String, CompletableFuture<Void>> = mutableMapOf()

    fun startTask(): String {
        val taskId = UUID.randomUUID().toString()

        val future = CompletableFuture.runAsync {
            while (!Thread.currentThread().isInterrupted) {
                println("Task $taskId is running...")
                try {
                    TimeUnit.SECONDS.sleep(1)
                } catch (e: InterruptedException) {
                    Thread.currentThread().interrupt()
                    break
                }
            }
            println("Task $taskId finished.")
        }

        runningTasks[taskId] = future
        println("Task $taskId started.")

        return taskId
    }

    fun stopTask(taskId: String) {
        val future = runningTasks[taskId]
        if (future != null) {
            future.cancel(true)
            runningTasks.remove(taskId)
            println("Task $taskId stopped.")
        } else {
            println("Task $taskId not found.")
        }
    }

    fun isTaskRunning(taskId: String): Boolean {
        val future = runningTasks[taskId]
        return future != null && !future.isDone
    }
}