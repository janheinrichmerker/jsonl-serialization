package dev.reimer.serialization.jsonl

import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.SerialFormat
import kotlinx.serialization.SerializationStrategy
import java.io.File

interface FileFormat : SerialFormat {
    fun <T> save(serializer: SerializationStrategy<T>, objects: Sequence<T>, file: File)
    fun <T, R> load(deserializer: DeserializationStrategy<T>, file: File, block: (Sequence<T>) -> R): R
}
