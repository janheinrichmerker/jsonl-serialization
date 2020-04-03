package dev.reimer.serialization.jsonl

import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.SerialFormat
import kotlinx.serialization.SerializationStrategy

interface SequenceStringFormat : SerialFormat {
    fun <T> stringify(serializer: SerializationStrategy<T>, objects: Sequence<T>): Sequence<String>
    fun <T> parse(deserializer: DeserializationStrategy<T>, strings: Sequence<String>): Sequence<T>
}
