package com.hhkbdev.threadmanager.util

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.util.concurrent.TimeUnit

class ThreadManagerTest {
    @Test
    fun testStartTaskAndStopTask() {
        val threadManager = ThreadManager()

        val taskId = threadManager.startTask()

        assertThat(threadManager.isTaskRunning(taskId)).isTrue()
        TimeUnit.SECONDS.sleep(2)

        threadManager.stopTask(taskId)

        assertThat(threadManager.isTaskRunning(taskId)).isFalse()
    }
}