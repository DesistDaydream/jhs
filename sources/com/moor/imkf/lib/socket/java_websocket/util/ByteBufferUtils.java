package com.moor.imkf.lib.socket.java_websocket.util;

import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public class ByteBufferUtils {
    private ByteBufferUtils() {
    }

    public static ByteBuffer getEmptyByteBuffer() {
        return ByteBuffer.allocate(0);
    }

    public static int transferByteBuffer(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        if (byteBuffer != null && byteBuffer2 != null) {
            int remaining = byteBuffer.remaining();
            int remaining2 = byteBuffer2.remaining();
            if (remaining > remaining2) {
                int min = Math.min(remaining, remaining2);
                byteBuffer.limit(min);
                byteBuffer2.put(byteBuffer);
                return min;
            }
            byteBuffer2.put(byteBuffer);
            return remaining;
        }
        throw new IllegalArgumentException();
    }
}
