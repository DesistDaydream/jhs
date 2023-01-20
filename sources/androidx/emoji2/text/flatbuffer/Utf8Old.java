package androidx.emoji2.text.flatbuffer;

import c.e.a.f.a;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.StandardCharsets;

/* loaded from: classes.dex */
public class Utf8Old extends Utf8 {
    private static final ThreadLocal<Cache> CACHE = ThreadLocal.withInitial(a.a);

    /* loaded from: classes.dex */
    public static class Cache {
        public CharSequence lastInput = null;
        public ByteBuffer lastOutput = null;
        public final CharsetEncoder encoder = StandardCharsets.UTF_8.newEncoder();
        public final CharsetDecoder decoder = StandardCharsets.UTF_8.newDecoder();
    }

    public static /* synthetic */ Cache a() {
        return new Cache();
    }

    @Override // androidx.emoji2.text.flatbuffer.Utf8
    public String decodeUtf8(ByteBuffer byteBuffer, int i2, int i3) {
        CharsetDecoder charsetDecoder = CACHE.get().decoder;
        charsetDecoder.reset();
        ByteBuffer duplicate = byteBuffer.duplicate();
        duplicate.position(i2);
        duplicate.limit(i2 + i3);
        try {
            return charsetDecoder.decode(duplicate).toString();
        } catch (CharacterCodingException e2) {
            throw new IllegalArgumentException("Bad encoding", e2);
        }
    }

    @Override // androidx.emoji2.text.flatbuffer.Utf8
    public void encodeUtf8(CharSequence charSequence, ByteBuffer byteBuffer) {
        Cache cache = CACHE.get();
        if (cache.lastInput != charSequence) {
            encodedLength(charSequence);
        }
        byteBuffer.put(cache.lastOutput);
    }

    @Override // androidx.emoji2.text.flatbuffer.Utf8
    public int encodedLength(CharSequence charSequence) {
        Cache cache = CACHE.get();
        int length = (int) (charSequence.length() * cache.encoder.maxBytesPerChar());
        ByteBuffer byteBuffer = cache.lastOutput;
        if (byteBuffer == null || byteBuffer.capacity() < length) {
            cache.lastOutput = ByteBuffer.allocate(Math.max(128, length));
        }
        cache.lastOutput.clear();
        cache.lastInput = charSequence;
        CoderResult encode = cache.encoder.encode(charSequence instanceof CharBuffer ? (CharBuffer) charSequence : CharBuffer.wrap(charSequence), cache.lastOutput, true);
        if (encode.isError()) {
            try {
                encode.throwException();
            } catch (CharacterCodingException e2) {
                throw new IllegalArgumentException("bad character encoding", e2);
            }
        }
        cache.lastOutput.flip();
        return cache.lastOutput.remaining();
    }
}
