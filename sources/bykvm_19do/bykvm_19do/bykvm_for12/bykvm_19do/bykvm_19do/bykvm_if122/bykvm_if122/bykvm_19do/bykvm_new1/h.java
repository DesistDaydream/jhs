package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1;

import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.t;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.d;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public final class h implements Closeable {

    /* renamed from: e  reason: collision with root package name */
    public static final Logger f492e = Logger.getLogger(e.class.getName());
    private final bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e a;
    private final a b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f493c;

    /* renamed from: d  reason: collision with root package name */
    public final d.a f494d;

    /* loaded from: classes.dex */
    public static final class a implements s {
        private final bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e a;
        public int b;

        /* renamed from: c  reason: collision with root package name */
        public byte f495c;

        /* renamed from: d  reason: collision with root package name */
        public int f496d;

        /* renamed from: e  reason: collision with root package name */
        public int f497e;

        /* renamed from: f  reason: collision with root package name */
        public short f498f;

        public a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e eVar) {
            this.a = eVar;
        }

        private void h() throws IOException {
            int i2 = this.f496d;
            int a = h.a(this.a);
            this.f497e = a;
            this.b = a;
            byte readByte = (byte) (this.a.readByte() & 255);
            this.f495c = (byte) (this.a.readByte() & 255);
            Logger logger = h.f492e;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(e.a(true, this.f496d, this.b, readByte, this.f495c));
            }
            int readInt = this.a.readInt() & Integer.MAX_VALUE;
            this.f496d = readInt;
            if (readByte != 9) {
                e.b("%s != TYPE_CONTINUATION", Byte.valueOf(readByte));
                throw null;
            } else if (readInt == i2) {
            } else {
                e.b("TYPE_CONTINUATION streamId changed", new Object[0]);
                throw null;
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s
        public long a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar, long j2) throws IOException {
            while (true) {
                int i2 = this.f497e;
                if (i2 != 0) {
                    long a = this.a.a(cVar, Math.min(j2, i2));
                    if (a != -1) {
                        this.f497e = (int) (this.f497e - a);
                        return a;
                    }
                    return -1L;
                }
                this.a.skip(this.f498f);
                this.f498f = (short) 0;
                if ((this.f495c & 4) != 0) {
                    return -1L;
                }
                h();
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s
        public t b() {
            return this.a.b();
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a();

        void a(int i2, int i3, int i4, boolean z);

        void a(int i2, int i3, List<c> list) throws IOException;

        void a(int i2, long j2);

        void a(int i2, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b bVar);

        void a(int i2, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b bVar, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f fVar);

        void a(boolean z, int i2, int i3);

        void a(boolean z, int i2, int i3, List<c> list);

        void a(boolean z, int i2, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e eVar, int i3) throws IOException;

        void a(boolean z, n nVar);
    }

    public h(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e eVar, boolean z) {
        this.a = eVar;
        this.f493c = z;
        a aVar = new a(eVar);
        this.b = aVar;
        this.f494d = new d.a(4096, aVar);
    }

    public static int a(int i2, byte b2, short s) throws IOException {
        if ((b2 & 8) != 0) {
            i2--;
        }
        if (s <= i2) {
            return (short) (i2 - s);
        }
        e.b("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i2));
        throw null;
    }

    public static int a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e eVar) throws IOException {
        return (eVar.readByte() & 255) | ((eVar.readByte() & 255) << 16) | ((eVar.readByte() & 255) << 8);
    }

    private List<c> a(int i2, short s, byte b2, int i3) throws IOException {
        a aVar = this.b;
        aVar.f497e = i2;
        aVar.b = i2;
        aVar.f498f = s;
        aVar.f495c = b2;
        aVar.f496d = i3;
        this.f494d.c();
        return this.f494d.a();
    }

    private void a(b bVar, int i2) throws IOException {
        int readInt = this.a.readInt();
        bVar.a(i2, readInt & Integer.MAX_VALUE, (this.a.readByte() & 255) + 1, (Integer.MIN_VALUE & readInt) != 0);
    }

    private void a(b bVar, int i2, byte b2, int i3) throws IOException {
        if (i3 == 0) {
            e.b("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
            throw null;
        }
        boolean z = (b2 & 1) != 0;
        if ((b2 & 32) != 0) {
            e.b("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
            throw null;
        }
        short readByte = (b2 & 8) != 0 ? (short) (this.a.readByte() & 255) : (short) 0;
        bVar.a(z, i3, this.a, a(i2, b2, readByte));
        this.a.skip(readByte);
    }

    private void b(b bVar, int i2, byte b2, int i3) throws IOException {
        if (i2 < 8) {
            e.b("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i2));
            throw null;
        } else if (i3 != 0) {
            e.b("TYPE_GOAWAY streamId != 0", new Object[0]);
            throw null;
        } else {
            int readInt = this.a.readInt();
            int readInt2 = this.a.readInt();
            int i4 = i2 - 8;
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b a2 = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b.a(readInt2);
            if (a2 == null) {
                e.b("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(readInt2));
                throw null;
            }
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f fVar = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f.f278e;
            if (i4 > 0) {
                fVar = this.a.b(i4);
            }
            bVar.a(readInt, a2, fVar);
        }
    }

    private void c(b bVar, int i2, byte b2, int i3) throws IOException {
        if (i3 == 0) {
            e.b("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
            throw null;
        }
        boolean z = (b2 & 1) != 0;
        short readByte = (b2 & 8) != 0 ? (short) (this.a.readByte() & 255) : (short) 0;
        if ((b2 & 32) != 0) {
            a(bVar, i3);
            i2 -= 5;
        }
        bVar.a(z, i3, -1, a(a(i2, b2, readByte), readByte, b2, i3));
    }

    private void d(b bVar, int i2, byte b2, int i3) throws IOException {
        if (i2 != 8) {
            e.b("TYPE_PING length != 8: %s", Integer.valueOf(i2));
            throw null;
        } else if (i3 != 0) {
            e.b("TYPE_PING streamId != 0", new Object[0]);
            throw null;
        } else {
            bVar.a((b2 & 1) != 0, this.a.readInt(), this.a.readInt());
        }
    }

    private void e(b bVar, int i2, byte b2, int i3) throws IOException {
        if (i2 != 5) {
            e.b("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i2));
            throw null;
        } else if (i3 != 0) {
            a(bVar, i3);
        } else {
            e.b("TYPE_PRIORITY streamId == 0", new Object[0]);
            throw null;
        }
    }

    private void f(b bVar, int i2, byte b2, int i3) throws IOException {
        if (i3 == 0) {
            e.b("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
            throw null;
        }
        short readByte = (b2 & 8) != 0 ? (short) (this.a.readByte() & 255) : (short) 0;
        bVar.a(i3, this.a.readInt() & Integer.MAX_VALUE, a(a(i2 - 4, b2, readByte), readByte, b2, i3));
    }

    private void g(b bVar, int i2, byte b2, int i3) throws IOException {
        if (i2 != 4) {
            e.b("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i2));
            throw null;
        } else if (i3 == 0) {
            e.b("TYPE_RST_STREAM streamId == 0", new Object[0]);
            throw null;
        } else {
            int readInt = this.a.readInt();
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b a2 = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b.a(readInt);
            if (a2 != null) {
                bVar.a(i3, a2);
            } else {
                e.b("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(readInt));
                throw null;
            }
        }
    }

    private void h(b bVar, int i2, byte b2, int i3) throws IOException {
        if (i3 != 0) {
            e.b("TYPE_SETTINGS streamId != 0", new Object[0]);
            throw null;
        } else if ((b2 & 1) != 0) {
            if (i2 != 0) {
                e.b("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
                throw null;
            }
            bVar.a();
        } else if (i2 % 6 != 0) {
            e.b("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i2));
            throw null;
        } else {
            n nVar = new n();
            for (int i4 = 0; i4 < i2; i4 += 6) {
                short readShort = this.a.readShort();
                int readInt = this.a.readInt();
                if (readShort != 2) {
                    if (readShort == 3) {
                        readShort = 4;
                    } else if (readShort == 4) {
                        readShort = 7;
                        if (readInt < 0) {
                            e.b("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                            throw null;
                        }
                    } else if (readShort == 5 && (readInt < 16384 || readInt > 16777215)) {
                        e.b("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(readInt));
                        throw null;
                    }
                } else if (readInt != 0 && readInt != 1) {
                    e.b("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                    throw null;
                }
                nVar.a(readShort, readInt);
            }
            bVar.a(false, nVar);
        }
    }

    private void i(b bVar, int i2, byte b2, int i3) throws IOException {
        if (i2 != 4) {
            e.b("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i2));
            throw null;
        }
        long readInt = this.a.readInt() & 2147483647L;
        if (readInt != 0) {
            bVar.a(i3, readInt);
        } else {
            e.b("windowSizeIncrement was 0", Long.valueOf(readInt));
            throw null;
        }
    }

    public void a(b bVar) throws IOException {
        if (this.f493c) {
            if (a(true, bVar)) {
                return;
            }
            e.b("Required SETTINGS preface not received", new Object[0]);
            throw null;
        }
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e eVar = this.a;
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f fVar = e.a;
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f b2 = eVar.b(fVar.e());
        Logger logger = f492e;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a("<< CONNECTION %s", b2.b()));
        }
        if (fVar.equals(b2)) {
            return;
        }
        e.b("Expected a connection header but was %s", b2.h());
        throw null;
    }

    public boolean a(boolean z, b bVar) throws IOException {
        try {
            this.a.a(9L);
            int a2 = a(this.a);
            if (a2 < 0 || a2 > 16384) {
                e.b("FRAME_SIZE_ERROR: %s", Integer.valueOf(a2));
                throw null;
            }
            byte readByte = (byte) (this.a.readByte() & 255);
            if (z && readByte != 4) {
                e.b("Expected a SETTINGS frame but was %s", Byte.valueOf(readByte));
                throw null;
            }
            byte readByte2 = (byte) (this.a.readByte() & 255);
            int readInt = this.a.readInt() & Integer.MAX_VALUE;
            Logger logger = f492e;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(e.a(true, readInt, a2, readByte, readByte2));
            }
            switch (readByte) {
                case 0:
                    a(bVar, a2, readByte2, readInt);
                    break;
                case 1:
                    c(bVar, a2, readByte2, readInt);
                    break;
                case 2:
                    e(bVar, a2, readByte2, readInt);
                    break;
                case 3:
                    g(bVar, a2, readByte2, readInt);
                    break;
                case 4:
                    h(bVar, a2, readByte2, readInt);
                    break;
                case 5:
                    f(bVar, a2, readByte2, readInt);
                    break;
                case 6:
                    d(bVar, a2, readByte2, readInt);
                    break;
                case 7:
                    b(bVar, a2, readByte2, readInt);
                    break;
                case 8:
                    i(bVar, a2, readByte2, readInt);
                    break;
                default:
                    this.a.skip(a2);
                    break;
            }
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.a.close();
    }
}
