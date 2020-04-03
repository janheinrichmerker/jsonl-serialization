package dev.reimer.serialization.jsonl

import kotlinx.serialization.AbstractSerialFormat
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.SerializationStrategy
import kotlinx.serialization.UnstableDefault
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonBuilder
import kotlinx.serialization.json.JsonConfiguration
import kotlinx.serialization.modules.EmptyModule
import kotlinx.serialization.modules.SerialModule
import kotlinx.serialization.modules.plus
import java.io.File

class JsonL(
    private val json: Json,
    context: SerialModule = EmptyModule
) : AbstractSerialFormat(context + json.context), SequenceStringFormat, FileFormat {

    constructor(
        configuration: JsonConfiguration = JsonConfiguration.Stable,
        context: SerialModule = EmptyModule
    ) : this(Json(configuration), context)

    @UnstableDefault
    constructor(block: JsonBuilder.() -> Unit) : this(Json(block))

    override fun <T> stringify(serializer: SerializationStrategy<T>, objects: Sequence<T>) =
        objects.map { json.stringify(serializer, it) }

    override fun <T> parse(deserializer: DeserializationStrategy<T>, strings: Sequence<String>) =
        strings.map { json.parse(deserializer, it) }

    override fun <T> save(serializer: SerializationStrategy<T>, objects: Sequence<T>, file: File) {
        file.writer().use { writer ->
            stringify(serializer, objects).forEach { line ->
                writer.appendln(line)
            }
        }
    }

    override fun <T, R> load(deserializer: DeserializationStrategy<T>, file: File, block: (Sequence<T>) -> R): R {
        return file.useLines {
            block(parse(deserializer, it))
        }
    }

}