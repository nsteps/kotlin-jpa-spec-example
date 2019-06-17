package ru.step.codeexample

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CodeExampleApplication

fun main(args: Array<String>) {
    runApplication<CodeExampleApplication>(*args)
}
