package presentation.model.serializer

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toPersistentList
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

typealias SerializableImmutableList<T> = @Serializable(with = ImmutableListSerializer::class) ImmutableList<T>

class ImmutableListSerializer<T>(private val dataSerializer: KSerializer<T>) :
    KSerializer<ImmutableList<T>> {

    private val delegateSerializer = ListSerializer(dataSerializer)

    override val descriptor: SerialDescriptor = SerialDescriptor(
        serialName = "kotlinx.serialization.immutable.ImmutableList",
        original = delegateSerializer.descriptor
    )

    override fun serialize(encoder: Encoder, value: ImmutableList<T>) {
        return ListSerializer(dataSerializer).serialize(encoder, value.toList())
    }

    override fun deserialize(decoder: Decoder): ImmutableList<T> {
        return ListSerializer(dataSerializer).deserialize(decoder).toPersistentList()
    }
}
