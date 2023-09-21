package be.darkkraft.memorized.client.data.map;

import be.darkkraft.memorized.client.MemorizedClient;
import org.jetbrains.annotations.NotNull;

import java.nio.ByteBuffer;

/**
 * Provides a client-side implementation of a {@link ClientMemorizedMap} using strings as keys.
 *
 * @param <K> The type of keys maintained by this map (usually {@link String}).
 * @param <V> The type of values that can be stored in this map.
 */
public final class StringMemorizedMap<K, V> extends ClientMemorizedMap<K, V> {

    private final String id;

    /**
     * Constructs a new instance of {@link StringMemorizedMap}.
     *
     * @param client     The {@link MemorizedClient} associated with this map.
     * @param valueClass The class type of the values.
     * @param id         The identifier for this map.
     */
    public StringMemorizedMap(final @NotNull MemorizedClient client, final @NotNull Class<V> valueClass, final @NotNull String id) {
        super(client, valueClass);
        this.id = id;
    }

    /**
     * Default constructor for {@link StringMemorizedMap}.
     *
     * @param valueClass The class type of the values.
     * @param id         The identifier for this map.
     */
    public StringMemorizedMap(final @NotNull Class<V> valueClass, final @NotNull String id) {
        super(valueClass);
        this.id = id;
    }

    /**
     * Writes the identifier of the map to the given {@link ByteBuffer}.
     *
     * @param buffer The {@link ByteBuffer} to write the identifier into.
     * @return The {@link ByteBuffer} with the identifier added.
     */
    @Override
    protected @NotNull ByteBuffer writeId(final @NotNull ByteBuffer buffer) {
        return this.client().getCodecRegistry().encode(buffer.putInt(this.getKeyIdentifier(String.class)), this.id);
    }

}