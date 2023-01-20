package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* loaded from: classes.dex */
public final class k implements s {
    private final e a;
    private final Inflater b;

    /* renamed from: c  reason: collision with root package name */
    private int f284c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f285d;

    public k(e eVar, Inflater inflater) {
        if (eVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (inflater == null) {
            throw new IllegalArgumentException("inflater == null");
        }
        this.a = eVar;
        this.b = inflater;
    }

    private void i() throws IOException {
        int i2 = this.f284c;
        if (i2 == 0) {
            return;
        }
        int remaining = i2 - this.b.getRemaining();
        this.f284c -= remaining;
        this.a.skip(remaining);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s
    public long a(c cVar, long j2) throws IOException {
        o b;
        int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
        if (i2 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j2);
        } else if (this.f285d) {
            throw new IllegalStateException("closed");
        } else {
            if (i2 == 0) {
                return 0L;
            }
            while (true) {
                boolean h2 = h();
                try {
                    b = cVar.b(1);
                    int inflate = this.b.inflate(b.a, b.f289c, (int) Math.min(j2, 8192 - b.f289c));
                    if (inflate <= 0) {
                        if (this.b.finished() || this.b.needsDictionary()) {
                            break;
                        } else if (h2) {
                            throw new EOFException("source exhausted prematurely");
                        }
                    } else {
                        b.f289c += inflate;
                        long j3 = inflate;
                        cVar.b += j3;
                        return j3;
                    }
                } catch (DataFormatException e2) {
                    throw new IOException(e2);
                }
            }
            i();
            if (b.b == b.f289c) {
                cVar.a = b.b();
                p.a(b);
            }
            return -1L;
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s
    public t b() {
        return this.a.b();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f285d) {
            return;
        }
        this.b.end();
        this.f285d = true;
        this.a.close();
    }

    public final boolean h() throws IOException {
        if (this.b.needsInput()) {
            i();
            if (this.b.getRemaining() != 0) {
                throw new IllegalStateException("?");
            }
            if (this.a.f()) {
                return true;
            }
            o oVar = this.a.a().a;
            int i2 = oVar.f289c;
            int i3 = oVar.b;
            int i4 = i2 - i3;
            this.f284c = i4;
            this.b.setInput(oVar.a, i3, i4);
        }
        return false;
    }
}
