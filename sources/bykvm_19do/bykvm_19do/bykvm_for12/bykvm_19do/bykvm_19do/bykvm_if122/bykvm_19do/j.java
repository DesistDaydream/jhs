package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* loaded from: classes.dex */
public final class j implements s {
    private final e b;

    /* renamed from: c  reason: collision with root package name */
    private final Inflater f281c;

    /* renamed from: d  reason: collision with root package name */
    private final k f282d;
    private int a = 0;

    /* renamed from: e  reason: collision with root package name */
    private final CRC32 f283e = new CRC32();

    public j(s sVar) {
        if (sVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        Inflater inflater = new Inflater(true);
        this.f281c = inflater;
        e a = l.a(sVar);
        this.b = a;
        this.f282d = new k(a, inflater);
    }

    private void a(c cVar, long j2, long j3) {
        int i2;
        o oVar = cVar.a;
        while (true) {
            long j4 = oVar.f289c - oVar.b;
            if (j2 < j4) {
                break;
            }
            j2 -= j4;
            oVar = oVar.f292f;
        }
        while (j3 > 0) {
            int min = (int) Math.min(oVar.f289c - i2, j3);
            this.f283e.update(oVar.a, (int) (oVar.b + j2), min);
            j3 -= min;
            oVar = oVar.f292f;
            j2 = 0;
        }
    }

    private void a(String str, int i2, int i3) throws IOException {
        if (i3 != i2) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", str, Integer.valueOf(i3), Integer.valueOf(i2)));
        }
    }

    private void h() throws IOException {
        this.b.a(10L);
        byte f2 = this.b.a().f(3L);
        boolean z = ((f2 >> 1) & 1) == 1;
        if (z) {
            a(this.b.a(), 0L, 10L);
        }
        a("ID1ID2", 8075, this.b.readShort());
        this.b.skip(8L);
        if (((f2 >> 2) & 1) == 1) {
            this.b.a(2L);
            if (z) {
                a(this.b.a(), 0L, 2L);
            }
            long c2 = this.b.a().c();
            this.b.a(c2);
            if (z) {
                a(this.b.a(), 0L, c2);
            }
            this.b.skip(c2);
        }
        if (((f2 >> 3) & 1) == 1) {
            long a = this.b.a((byte) 0);
            if (a == -1) {
                throw new EOFException();
            }
            if (z) {
                a(this.b.a(), 0L, a + 1);
            }
            this.b.skip(a + 1);
        }
        if (((f2 >> 4) & 1) == 1) {
            long a2 = this.b.a((byte) 0);
            if (a2 == -1) {
                throw new EOFException();
            }
            if (z) {
                a(this.b.a(), 0L, a2 + 1);
            }
            this.b.skip(a2 + 1);
        }
        if (z) {
            a("FHCRC", this.b.c(), (short) this.f283e.getValue());
            this.f283e.reset();
        }
    }

    private void i() throws IOException {
        a("CRC", this.b.e(), (int) this.f283e.getValue());
        a("ISIZE", this.b.e(), (int) this.f281c.getBytesWritten());
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s
    public long a(c cVar, long j2) throws IOException {
        int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
        if (i2 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j2);
        } else if (i2 == 0) {
            return 0L;
        } else {
            if (this.a == 0) {
                h();
                this.a = 1;
            }
            if (this.a == 1) {
                long j3 = cVar.b;
                long a = this.f282d.a(cVar, j2);
                if (a != -1) {
                    a(cVar, j3, a);
                    return a;
                }
                this.a = 2;
            }
            if (this.a == 2) {
                i();
                this.a = 3;
                if (!this.b.f()) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return -1L;
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s
    public t b() {
        return this.b.b();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f282d.close();
    }
}
