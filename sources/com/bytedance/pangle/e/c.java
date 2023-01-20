package com.bytedance.pangle.e;

import com.bytedance.pangle.util.g;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class c implements Closeable {
    private final FileInputStream a;
    private a b;

    /* renamed from: c  reason: collision with root package name */
    private b[] f2244c;

    /* renamed from: d  reason: collision with root package name */
    private C0080c[] f2245d;

    /* renamed from: e  reason: collision with root package name */
    private final Map<String, C0080c> f2246e = new HashMap();

    /* loaded from: classes.dex */
    public static class a {
        public final byte[] a;
        public final short b;

        /* renamed from: c  reason: collision with root package name */
        public final short f2247c;

        /* renamed from: d  reason: collision with root package name */
        public final int f2248d;

        /* renamed from: e  reason: collision with root package name */
        public final long f2249e;

        /* renamed from: f  reason: collision with root package name */
        public final long f2250f;

        /* renamed from: g  reason: collision with root package name */
        public final long f2251g;

        /* renamed from: h  reason: collision with root package name */
        public final int f2252h;

        /* renamed from: i  reason: collision with root package name */
        public final short f2253i;

        /* renamed from: j  reason: collision with root package name */
        public final short f2254j;

        /* renamed from: k  reason: collision with root package name */
        public final short f2255k;

        /* renamed from: l  reason: collision with root package name */
        public final short f2256l;

        /* renamed from: m  reason: collision with root package name */
        public final short f2257m;
        public final short n;

        public /* synthetic */ a(FileChannel fileChannel, byte b) {
            this(fileChannel);
        }

        private a(FileChannel fileChannel) {
            byte[] bArr = new byte[16];
            this.a = bArr;
            fileChannel.position(0L);
            fileChannel.read(ByteBuffer.wrap(bArr));
            if (bArr[0] == Byte.MAX_VALUE && bArr[1] == 69 && bArr[2] == 76 && bArr[3] == 70) {
                byte b = bArr[4];
                c.a(b, 2, "bad elf class: " + ((int) bArr[4]));
                byte b2 = bArr[5];
                c.a(b2, 2, "bad elf data encoding: " + ((int) bArr[5]));
                ByteBuffer allocate = ByteBuffer.allocate(bArr[4] == 1 ? 36 : 48);
                allocate.order(bArr[5] == 1 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN);
                c.b(fileChannel, allocate, "failed to read rest part of ehdr.");
                this.b = allocate.getShort();
                this.f2247c = allocate.getShort();
                int i2 = allocate.getInt();
                this.f2248d = i2;
                c.a(i2, 1, "bad elf version: " + i2);
                byte b3 = bArr[4];
                if (b3 == 1) {
                    this.f2249e = allocate.getInt();
                    this.f2250f = allocate.getInt();
                    this.f2251g = allocate.getInt();
                } else if (b3 == 2) {
                    this.f2249e = allocate.getLong();
                    this.f2250f = allocate.getLong();
                    this.f2251g = allocate.getLong();
                } else {
                    throw new IOException("Unexpected elf class: " + ((int) bArr[4]));
                }
                this.f2252h = allocate.getInt();
                this.f2253i = allocate.getShort();
                this.f2254j = allocate.getShort();
                this.f2255k = allocate.getShort();
                this.f2256l = allocate.getShort();
                this.f2257m = allocate.getShort();
                this.n = allocate.getShort();
                return;
            }
            throw new IOException(String.format("bad elf magic: %x %x %x %x.", Byte.valueOf(bArr[0]), Byte.valueOf(bArr[1]), Byte.valueOf(bArr[2]), Byte.valueOf(bArr[3])));
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public final int a;
        public final int b;

        /* renamed from: c  reason: collision with root package name */
        public final long f2258c;

        /* renamed from: d  reason: collision with root package name */
        public final long f2259d;

        /* renamed from: e  reason: collision with root package name */
        public final long f2260e;

        /* renamed from: f  reason: collision with root package name */
        public final long f2261f;

        /* renamed from: g  reason: collision with root package name */
        public final long f2262g;

        /* renamed from: h  reason: collision with root package name */
        public final long f2263h;

        public /* synthetic */ b(ByteBuffer byteBuffer, int i2, byte b) {
            this(byteBuffer, i2);
        }

        private b(ByteBuffer byteBuffer, int i2) {
            if (i2 == 1) {
                this.a = byteBuffer.getInt();
                this.f2258c = byteBuffer.getInt();
                this.f2259d = byteBuffer.getInt();
                this.f2260e = byteBuffer.getInt();
                this.f2261f = byteBuffer.getInt();
                this.f2262g = byteBuffer.getInt();
                this.b = byteBuffer.getInt();
                this.f2263h = byteBuffer.getInt();
            } else if (i2 == 2) {
                this.a = byteBuffer.getInt();
                this.b = byteBuffer.getInt();
                this.f2258c = byteBuffer.getLong();
                this.f2259d = byteBuffer.getLong();
                this.f2260e = byteBuffer.getLong();
                this.f2261f = byteBuffer.getLong();
                this.f2262g = byteBuffer.getLong();
                this.f2263h = byteBuffer.getLong();
            } else {
                throw new IOException("Unexpected elf class: ".concat(String.valueOf(i2)));
            }
        }
    }

    /* renamed from: com.bytedance.pangle.e.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0080c {
        public final int a;
        public final int b;

        /* renamed from: c  reason: collision with root package name */
        public final long f2264c;

        /* renamed from: d  reason: collision with root package name */
        public final long f2265d;

        /* renamed from: e  reason: collision with root package name */
        public final long f2266e;

        /* renamed from: f  reason: collision with root package name */
        public final long f2267f;

        /* renamed from: g  reason: collision with root package name */
        public final int f2268g;

        /* renamed from: h  reason: collision with root package name */
        public final int f2269h;

        /* renamed from: i  reason: collision with root package name */
        public final long f2270i;

        /* renamed from: j  reason: collision with root package name */
        public final long f2271j;

        /* renamed from: k  reason: collision with root package name */
        public String f2272k;

        public /* synthetic */ C0080c(ByteBuffer byteBuffer, int i2, byte b) {
            this(byteBuffer, i2);
        }

        private C0080c(ByteBuffer byteBuffer, int i2) {
            if (i2 == 1) {
                this.a = byteBuffer.getInt();
                this.b = byteBuffer.getInt();
                this.f2264c = byteBuffer.getInt();
                this.f2265d = byteBuffer.getInt();
                this.f2266e = byteBuffer.getInt();
                this.f2267f = byteBuffer.getInt();
                this.f2268g = byteBuffer.getInt();
                this.f2269h = byteBuffer.getInt();
                this.f2270i = byteBuffer.getInt();
                this.f2271j = byteBuffer.getInt();
            } else if (i2 == 2) {
                this.a = byteBuffer.getInt();
                this.b = byteBuffer.getInt();
                this.f2264c = byteBuffer.getLong();
                this.f2265d = byteBuffer.getLong();
                this.f2266e = byteBuffer.getLong();
                this.f2267f = byteBuffer.getLong();
                this.f2268g = byteBuffer.getInt();
                this.f2269h = byteBuffer.getInt();
                this.f2270i = byteBuffer.getLong();
                this.f2271j = byteBuffer.getLong();
            } else {
                throw new IOException("Unexpected elf class: ".concat(String.valueOf(i2)));
            }
            this.f2272k = null;
        }
    }

    private c(File file) {
        C0080c[] c0080cArr;
        C0080c[] c0080cArr2;
        this.b = null;
        this.f2244c = null;
        this.f2245d = null;
        FileInputStream fileInputStream = new FileInputStream(file);
        this.a = fileInputStream;
        FileChannel channel = fileInputStream.getChannel();
        this.b = new a(channel, (byte) 0);
        ByteBuffer allocate = ByteBuffer.allocate(128);
        allocate.limit(this.b.f2254j);
        allocate.order(this.b.a[5] == 1 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN);
        channel.position(this.b.f2250f);
        this.f2244c = new b[this.b.f2255k];
        for (int i2 = 0; i2 < this.f2244c.length; i2++) {
            b(channel, allocate, "failed to read phdr.");
            this.f2244c[i2] = new b(allocate, this.b.a[4], (byte) 0);
        }
        channel.position(this.b.f2251g);
        allocate.limit(this.b.f2256l);
        this.f2245d = new C0080c[this.b.f2257m];
        int i3 = 0;
        while (true) {
            c0080cArr = this.f2245d;
            if (i3 >= c0080cArr.length) {
                break;
            }
            b(channel, allocate, "failed to read shdr.");
            this.f2245d[i3] = new C0080c(allocate, this.b.a[4], (byte) 0);
            i3++;
        }
        short s = this.b.n;
        if (s > 0) {
            C0080c c0080c = c0080cArr[s];
            ByteBuffer allocate2 = ByteBuffer.allocate((int) c0080c.f2267f);
            this.a.getChannel().position(c0080c.f2266e);
            b(this.a.getChannel(), allocate2, "failed to read section: " + c0080c.f2272k);
            for (C0080c c0080c2 : this.f2245d) {
                allocate2.position(c0080c2.a);
                String a2 = a(allocate2);
                c0080c2.f2272k = a2;
                this.f2246e.put(a2, c0080c2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(FileChannel fileChannel, ByteBuffer byteBuffer, String str) {
        byteBuffer.rewind();
        int read = fileChannel.read(byteBuffer);
        if (read == byteBuffer.limit()) {
            byteBuffer.flip();
            return;
        }
        throw new IOException(str + " Rest bytes insufficient, expect to read " + byteBuffer.limit() + " bytes but only " + read + " bytes were read.");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.a.close();
        this.f2246e.clear();
        this.f2244c = null;
        this.f2245d = null;
    }

    public static boolean a(File file) {
        try {
            g.a(new c(file));
            return true;
        } catch (IOException unused) {
            g.a((Closeable) null);
            return false;
        } catch (Throwable th) {
            g.a((Closeable) null);
            throw th;
        }
    }

    private static String a(ByteBuffer byteBuffer) {
        byte[] array = byteBuffer.array();
        int position = byteBuffer.position();
        while (byteBuffer.hasRemaining() && array[byteBuffer.position()] != 0) {
            byteBuffer.position(byteBuffer.position() + 1);
        }
        byteBuffer.position(byteBuffer.position() + 1);
        return new String(array, position, (byteBuffer.position() - position) - 1, Charset.forName("ASCII"));
    }

    public static /* synthetic */ void a(int i2, int i3, String str) {
        if (i2 <= 0 || i2 > i3) {
            throw new IOException(str);
        }
    }
}
