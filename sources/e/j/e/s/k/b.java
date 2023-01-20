package e.j.e.s.k;

import e.j.e.e;
import e.j.e.h;
import e.j.e.i;
import e.j.e.j;
import e.j.e.l;
import e.j.e.u.c;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class b extends c {
    private static final Writer p = new a();
    private static final l q = new l("closed");

    /* renamed from: m  reason: collision with root package name */
    private final List<h> f11297m;
    private String n;
    private h o;

    /* loaded from: classes2.dex */
    public class a extends Writer {
        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i2, int i3) {
            throw new AssertionError();
        }
    }

    public b() {
        super(p);
        this.f11297m = new ArrayList();
        this.o = i.a;
    }

    private h K0() {
        List<h> list = this.f11297m;
        return list.get(list.size() - 1);
    }

    private void L0(h hVar) {
        if (this.n != null) {
            if (!hVar.y() || s()) {
                ((j) K0()).B(this.n, hVar);
            }
            this.n = null;
        } else if (this.f11297m.isEmpty()) {
            this.o = hVar;
        } else {
            h K0 = K0();
            if (K0 instanceof e) {
                ((e) K0).B(hVar);
                return;
            }
            throw new IllegalStateException();
        }
    }

    @Override // e.j.e.u.c
    public c C0(double d2) throws IOException {
        if (!F() && (Double.isNaN(d2) || Double.isInfinite(d2))) {
            throw new IllegalArgumentException("JSON forbids NaN and infinities: " + d2);
        }
        L0(new l(Double.valueOf(d2)));
        return this;
    }

    @Override // e.j.e.u.c
    public c D0(long j2) throws IOException {
        L0(new l(Long.valueOf(j2)));
        return this;
    }

    @Override // e.j.e.u.c
    public c E0(Boolean bool) throws IOException {
        if (bool == null) {
            return Y();
        }
        L0(new l(bool));
        return this;
    }

    @Override // e.j.e.u.c
    public c F0(Number number) throws IOException {
        if (number == null) {
            return Y();
        }
        if (!F()) {
            double doubleValue = number.doubleValue();
            if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        L0(new l(number));
        return this;
    }

    @Override // e.j.e.u.c
    public c G0(String str) throws IOException {
        if (str == null) {
            return Y();
        }
        L0(new l(str));
        return this;
    }

    @Override // e.j.e.u.c
    public c H0(boolean z) throws IOException {
        L0(new l(Boolean.valueOf(z)));
        return this;
    }

    public h J0() {
        if (this.f11297m.isEmpty()) {
            return this.o;
        }
        throw new IllegalStateException("Expected one JSON element but was " + this.f11297m);
    }

    @Override // e.j.e.u.c
    public c M(String str) throws IOException {
        Objects.requireNonNull(str, "name == null");
        if (!this.f11297m.isEmpty() && this.n == null) {
            if (K0() instanceof j) {
                this.n = str;
                return this;
            }
            throw new IllegalStateException();
        }
        throw new IllegalStateException();
    }

    @Override // e.j.e.u.c
    public c Y() throws IOException {
        L0(i.a);
        return this;
    }

    @Override // e.j.e.u.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f11297m.isEmpty()) {
            this.f11297m.add(q);
            return;
        }
        throw new IOException("Incomplete document");
    }

    @Override // e.j.e.u.c, java.io.Flushable
    public void flush() throws IOException {
    }

    @Override // e.j.e.u.c
    public c l() throws IOException {
        e eVar = new e();
        L0(eVar);
        this.f11297m.add(eVar);
        return this;
    }

    @Override // e.j.e.u.c
    public c n() throws IOException {
        j jVar = new j();
        L0(jVar);
        this.f11297m.add(jVar);
        return this;
    }

    @Override // e.j.e.u.c
    public c q() throws IOException {
        if (!this.f11297m.isEmpty() && this.n == null) {
            if (K0() instanceof e) {
                List<h> list = this.f11297m;
                list.remove(list.size() - 1);
                return this;
            }
            throw new IllegalStateException();
        }
        throw new IllegalStateException();
    }

    @Override // e.j.e.u.c
    public c r() throws IOException {
        if (!this.f11297m.isEmpty() && this.n == null) {
            if (K0() instanceof j) {
                List<h> list = this.f11297m;
                list.remove(list.size() - 1);
                return this;
            }
            throw new IllegalStateException();
        }
        throw new IllegalStateException();
    }
}
