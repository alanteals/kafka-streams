package com.allanaste.kafka

import org.apache.kafka.streams.StreamsBuilder
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
class PipeApplication

fun main(args: Array<String>) {

    val builder = StreamsBuilder()
    val source = builder.stream<String, String>("streams-plaintext-input")
    source.to("streams-pipe-output")

    val topology = builder.build()
    println(topology.describe());

    runApplication<PipeApplication>(*args)
}
