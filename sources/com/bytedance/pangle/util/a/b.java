package com.bytedance.pangle.util.a;

import com.bytedance.pangle.util.f;
import java.io.File;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
public final class b {
    private static String a = "";

    private static ByteBuffer a(ByteBuffer byteBuffer, int i2) {
        if (i2 < 8) {
            throw new IllegalArgumentException("end < start: " + i2 + " < 8");
        }
        int capacity = byteBuffer.capacity();
        if (i2 > byteBuffer.capacity()) {
            throw new IllegalArgumentException("end > capacity: " + i2 + " > " + capacity);
        }
        int limit = byteBuffer.limit();
        int position = byteBuffer.position();
        try {
            byteBuffer.position(0);
            byteBuffer.limit(i2);
            byteBuffer.position(8);
            ByteBuffer slice = byteBuffer.slice();
            slice.order(byteBuffer.order());
            return slice;
        } finally {
            byteBuffer.position(0);
            byteBuffer.limit(limit);
            byteBuffer.position(position);
        }
    }

    public static String[] a(File file) {
        String str;
        ByteBuffer b;
        boolean z;
        String str2;
        String str3 = "";
        try {
            b = b(file);
        } catch (Exception unused) {
            str = "";
        }
        if (b.order() == ByteOrder.LITTLE_ENDIAN) {
            ByteBuffer a2 = a(b, b.capacity() - 24);
            int i2 = 0;
            while (a2.hasRemaining()) {
                i2++;
                if (a2.remaining() >= 8) {
                    long j2 = a2.getLong();
                    if (j2 < 4 || j2 > 2147483647L) {
                        throw new Exception("APK Signing Block entry #" + i2 + " size out of range: " + j2);
                    }
                    int i3 = (int) j2;
                    int position = a2.position() + i3;
                    if (i3 > a2.remaining()) {
                        throw new Exception("APK Signing Block entry #" + i2 + " size out of range: " + i3 + ", available: " + a2.remaining());
                    }
                    int i4 = a2.getInt();
                    if (i4 == -262969152) {
                        str2 = "V3";
                    } else if (i4 == 1896449818) {
                        str2 = "V2";
                    } else {
                        a2.position(position);
                    }
                    a = str2;
                    z = true;
                    break;
                }
                throw new Exception("Insufficient data to read size of APK Signing Block entry #".concat(String.valueOf(i2)));
            }
            z = false;
            if (z) {
                str3 = f.a(b.array());
                str = "";
            } else {
                str = "without v2 & v3 signature.";
            }
            return new String[]{str3, a, str};
        }
        throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x004b A[Catch: all -> 0x018c, TryCatch #0 {all -> 0x018c, blocks: (B:4:0x0008, B:12:0x0024, B:14:0x003a, B:19:0x004b, B:21:0x005d, B:25:0x0075, B:27:0x00a8, B:29:0x00b5, B:33:0x00c9, B:35:0x00d3, B:37:0x00f4, B:40:0x0104, B:41:0x011f, B:42:0x0120, B:43:0x012f, B:44:0x0130, B:45:0x013f, B:46:0x0140, B:47:0x0147, B:48:0x0148, B:49:0x0157, B:50:0x0158, B:51:0x015f, B:52:0x0160, B:53:0x017b, B:54:0x017c, B:55:0x0183, B:56:0x0184, B:57:0x018b, B:7:0x0014, B:10:0x001b), top: B:64:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x017c A[Catch: all -> 0x018c, TryCatch #0 {all -> 0x018c, blocks: (B:4:0x0008, B:12:0x0024, B:14:0x003a, B:19:0x004b, B:21:0x005d, B:25:0x0075, B:27:0x00a8, B:29:0x00b5, B:33:0x00c9, B:35:0x00d3, B:37:0x00f4, B:40:0x0104, B:41:0x011f, B:42:0x0120, B:43:0x012f, B:44:0x0130, B:45:0x013f, B:46:0x0140, B:47:0x0147, B:48:0x0148, B:49:0x0157, B:50:0x0158, B:51:0x015f, B:52:0x0160, B:53:0x017b, B:54:0x017c, B:55:0x0183, B:56:0x0184, B:57:0x018b, B:7:0x0014, B:10:0x001b), top: B:64:0x0008 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.nio.ByteBuffer b(java.io.File r13) {
        /*
            Method dump skipped, instructions count: 406
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.util.a.b.b(java.io.File):java.nio.ByteBuffer");
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0000, code lost:
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String b1663646904216dc(java.lang.String r2) {
        /*
        L0:
            r0 = 73
            r1 = 96
        L4:
            switch(r0) {
                case 72: goto L26;
                case 73: goto L8;
                case 74: goto Lb;
                default: goto L7;
            }
        L7:
            goto L2b
        L8:
            switch(r1) {
                case 94: goto L0;
                case 95: goto L26;
                case 96: goto L26;
                default: goto Lb;
            }
        Lb:
            switch(r1) {
                case 55: goto Lf;
                case 56: goto L26;
                case 57: goto L26;
                default: goto Le;
            }
        Le:
            goto L0
        Lf:
            char[] r2 = r2.toCharArray()
            r0 = 0
        L14:
            int r1 = r2.length
            if (r0 >= r1) goto L20
            char r1 = r2[r0]
            r1 = r1 ^ r0
            char r1 = (char) r1
            r2[r0] = r1
            int r0 = r0 + 1
            goto L14
        L20:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r2)
            return r0
        L26:
            r0 = 74
            r1 = 55
            goto L4
        L2b:
            r0 = 72
            goto L4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.util.a.b.b1663646904216dc(java.lang.String):java.lang.String");
    }
}
