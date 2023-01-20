package com.bytedance.pangle.g;

import android.util.Pair;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
public abstract class s {
    public static Pair<ByteBuffer, Long> a(RandomAccessFile randomAccessFile, int i2) {
        if (i2 >= 0 && i2 <= 65535) {
            long length = randomAccessFile.length();
            if (length < 22) {
                return null;
            }
            ByteBuffer allocate = ByteBuffer.allocate(((int) Math.min(i2, length - 22)) + 22);
            ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
            allocate.order(byteOrder);
            long capacity = length - allocate.capacity();
            randomAccessFile.seek(capacity);
            randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
            int b = b(allocate);
            if (b == -1) {
                return null;
            }
            allocate.position(b);
            ByteBuffer slice = allocate.slice();
            slice.order(byteOrder);
            return Pair.create(slice, Long.valueOf(capacity + b));
        }
        throw new IllegalArgumentException("maxCommentSize: ".concat(String.valueOf(i2)));
    }

    private static int b(ByteBuffer byteBuffer) {
        a(byteBuffer);
        int capacity = byteBuffer.capacity();
        if (capacity < 22) {
            return -1;
        }
        int i2 = capacity - 22;
        int min = Math.min(i2, 65535);
        for (int i3 = 0; i3 <= min; i3++) {
            int i4 = i2 - i3;
            if (byteBuffer.getInt(i4) == 101010256 && (byteBuffer.getShort(i4 + 20) & 65535) == i3) {
                return i4;
            }
        }
        return -1;
    }

    public static void a(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    public static long a(ByteBuffer byteBuffer, int i2) {
        return byteBuffer.getInt(i2) & 4294967295L;
    }
}
