package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1;

import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.d;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public final class j implements Closeable {

    /* renamed from: g  reason: collision with root package name */
    private static final Logger f518g = Logger.getLogger(e.class.getName());
    private final bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d a;
    private final boolean b;

    /* renamed from: c  reason: collision with root package name */
    private final bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c f519c;

    /* renamed from: d  reason: collision with root package name */
    private int f520d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f521e;

    /* renamed from: f  reason: collision with root package name */
    public final d.b f522f;

    public j(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d dVar, boolean z) {
        this.a = dVar;
        this.b = z;
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar = new bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c();
        this.f519c = cVar;
        this.f522f = new d.b(cVar);
        this.f520d = 16384;
    }

    private static void a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d dVar, int i2) throws IOException {
        dVar.writeByte((i2 >>> 16) & 255);
        dVar.writeByte((i2 >>> 8) & 255);
        dVar.writeByte(i2 & 255);
    }

    private void b(int i2, long j2) throws IOException {
        while (j2 > 0) {
            int min = (int) Math.min(this.f520d, j2);
            long j3 = min;
            j2 -= j3;
            a(i2, min, (byte) 9, j2 == 0 ? (byte) 4 : (byte) 0);
            this.a.b(this.f519c, j3);
        }
    }

    public void a(int i2, byte b, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar, int i3) throws IOException {
        a(i2, i3, (byte) 0, b);
        if (i3 > 0) {
            this.a.b(cVar, i3);
        }
    }

    public void a(int i2, int i3, byte b, byte b2) throws IOException {
        Logger logger = f518g;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(e.a(false, i2, i3, b, b2));
        }
        int i4 = this.f520d;
        if (i3 > i4) {
            e.a("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i4), Integer.valueOf(i3));
            throw null;
        } else if ((Integer.MIN_VALUE & i2) != 0) {
            e.a("reserved bit set: %s", Integer.valueOf(i2));
            throw null;
        } else {
            a(this.a, i3);
            this.a.writeByte(b & 255);
            this.a.writeByte(b2 & 255);
            this.a.writeInt(i2 & Integer.MAX_VALUE);
        }
    }

    public void a(int i2, int i3, List<c> list) throws IOException {
        synchronized (this) {
            if (this.f521e) {
                throw new IOException("closed");
            }
            this.f522f.a(list);
            long o = this.f519c.o();
            int min = (int) Math.min(this.f520d - 4, o);
            long j2 = min;
            int i4 = (o > j2 ? 1 : (o == j2 ? 0 : -1));
            a(i2, min + 4, (byte) 5, i4 == 0 ? (byte) 4 : (byte) 0);
            this.a.writeInt(i3 & Integer.MAX_VALUE);
            this.a.b(this.f519c, j2);
            if (i4 > 0) {
                b(i2, o - j2);
            }
        }
    }

    public void a(int i2, long j2) throws IOException {
        synchronized (this) {
            if (this.f521e) {
                throw new IOException("closed");
            }
            if (j2 == 0 || j2 > 2147483647L) {
                e.a("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j2));
                throw null;
            }
            a(i2, 4, (byte) 8, (byte) 0);
            this.a.writeInt((int) j2);
            this.a.flush();
        }
    }

    public void a(int i2, b bVar) throws IOException {
        synchronized (this) {
            if (this.f521e) {
                throw new IOException("closed");
            }
            if (bVar.a == -1) {
                throw new IllegalArgumentException();
            }
            a(i2, 4, (byte) 3, (byte) 0);
            this.a.writeInt(bVar.a);
            this.a.flush();
        }
    }

    public void a(int i2, b bVar, byte[] bArr) throws IOException {
        synchronized (this) {
            if (this.f521e) {
                throw new IOException("closed");
            }
            if (bVar.a == -1) {
                e.a("errorCode.httpCode == -1", new Object[0]);
                throw null;
            }
            a(0, bArr.length + 8, (byte) 7, (byte) 0);
            this.a.writeInt(i2);
            this.a.writeInt(bVar.a);
            if (bArr.length > 0) {
                this.a.write(bArr);
            }
            this.a.flush();
        }
    }

    public void a(n nVar) throws IOException {
        synchronized (this) {
            if (this.f521e) {
                throw new IOException("closed");
            }
            this.f520d = nVar.c(this.f520d);
            if (nVar.b() != -1) {
                this.f522f.a(nVar.b());
            }
            a(0, 0, (byte) 4, (byte) 1);
            this.a.flush();
        }
    }

    public void a(boolean z, int i2, int i3) throws IOException {
        synchronized (this) {
            if (this.f521e) {
                throw new IOException("closed");
            }
            a(0, 8, (byte) 6, z ? (byte) 1 : (byte) 0);
            this.a.writeInt(i2);
            this.a.writeInt(i3);
            this.a.flush();
        }
    }

    public void a(boolean z, int i2, int i3, List<c> list) throws IOException {
        synchronized (this) {
            if (this.f521e) {
                throw new IOException("closed");
            }
            a(z, i2, list);
        }
    }

    public void a(boolean z, int i2, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar, int i3) throws IOException {
        synchronized (this) {
            if (this.f521e) {
                throw new IOException("closed");
            }
            a(i2, z ? (byte) 1 : (byte) 0, cVar, i3);
        }
    }

    public void a(boolean z, int i2, List<c> list) throws IOException {
        if (this.f521e) {
            throw new IOException("closed");
        }
        this.f522f.a(list);
        long o = this.f519c.o();
        int min = (int) Math.min(this.f520d, o);
        long j2 = min;
        int i3 = (o > j2 ? 1 : (o == j2 ? 0 : -1));
        byte b = i3 == 0 ? (byte) 4 : (byte) 0;
        if (z) {
            b = (byte) (b | 1);
        }
        a(i2, min, (byte) 1, b);
        this.a.b(this.f519c, j2);
        if (i3 > 0) {
            b(i2, o - j2);
        }
    }

    public void b(n nVar) throws IOException {
        synchronized (this) {
            if (this.f521e) {
                throw new IOException("closed");
            }
            int i2 = 0;
            a(0, nVar.d() * 6, (byte) 4, (byte) 0);
            while (i2 < 10) {
                if (nVar.d(i2)) {
                    this.a.writeShort(i2 == 4 ? 3 : i2 == 7 ? 4 : i2);
                    this.a.writeInt(nVar.a(i2));
                }
                i2++;
            }
            this.a.flush();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this) {
            this.f521e = true;
            this.a.close();
        }
    }

    public void flush() throws IOException {
        synchronized (this) {
            if (this.f521e) {
                throw new IOException("closed");
            }
            this.a.flush();
        }
    }

    public void i() throws IOException {
        synchronized (this) {
            if (this.f521e) {
                throw new IOException("closed");
            }
            if (this.b) {
                Logger logger = f518g;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(">> CONNECTION %s", e.a.b()));
                }
                this.a.write(e.a.g());
                this.a.flush();
            }
        }
    }

    public int j() {
        return this.f520d;
    }
}
