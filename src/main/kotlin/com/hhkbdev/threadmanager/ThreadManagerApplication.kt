package com.hhkbdev.threadmanager

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ThreadManagerApplication

fun main(args: Array<String>) {
	runApplication<ThreadManagerApplication>(*args)
}
