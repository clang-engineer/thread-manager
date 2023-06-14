package com.hhkbdev.threadmanager.util

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.util.concurrent.TimeUnit

class ThreadManagerTest {
    @Test
    fun testStartTaskAndStopTask() {
        val threadTaskManager = ThreadTaskManager()

        val taskId = threadTaskManager.startTask()

        assertThat(threadTaskManager.isTaskRunning(taskId)).isTrue()
        TimeUnit.SECONDS.sleep(2)

        threadTaskManager.stopTask(taskId)

        assertThat(threadTaskManager.isTaskRunning(taskId)).isFalse()
    }
}