package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import java.io.Closeable;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Objects;

/* loaded from: classes.dex */
public abstract class b0 implements Closeable {

    /* loaded from: classes.dex */
    public static final class a extends b0 {
        public final /* synthetic */ u a;
        public final /* synthetic */ long b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e f328c;

        public a(u uVar, long j2, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e eVar) {
            this.a = uVar;
            this.b = j2;
            this.f328c = eVar;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.b0
        public long i() {
            return this.b;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.b0
        public u j() {
            return this.a;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.b0
        public bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e k() {
            return this.f328c;
        }
    }

    public static b0 a(u uVar, long j2, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e eVar) {
        Objects.requireNonNull(eVar, "source == null");
        return new a(uVar, j2, eVar);
    }

    public static b0 a(u uVar, byte[] bArr) {
        return a(uVar, bArr.length, new bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c().write(bArr));
    }

    private Charset m() {
        u j2 = j();
        return j2 != null ? j2.a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.f548i) : bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.f548i;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(k());
    }

    public abstract long i();

    public abstract u j();

    public abstract bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e k();

    public final String l() throws IOException {
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e k2 = k();
        try {
            String a2 = k2.a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(k2, m()));
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(k2);
            return a2;
        } catch (OutOfMemoryError unused) {
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(k2);
            return null;
        } catch (Throwable th) {
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(k2);
            throw th;
        }
    }
}
