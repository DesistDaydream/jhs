package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12;

import android.content.Context;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.g;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.h;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.c;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.f;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.v;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class a {
    private v a;
    private g b;

    /* renamed from: c  reason: collision with root package name */
    private int f218c;

    /* loaded from: classes.dex */
    public static final class b {
        public int a;
        public int b;

        /* renamed from: c  reason: collision with root package name */
        public int f219c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f220d = true;

        public b() {
            new ArrayList();
            this.a = 10000;
            this.b = 10000;
            this.f219c = 10000;
        }

        private static int a(String str, long j2, TimeUnit timeUnit) {
            int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
            if (i2 < 0) {
                throw new IllegalArgumentException(str + " < 0");
            }
            Objects.requireNonNull(timeUnit, "unit == null");
            long millis = timeUnit.toMillis(j2);
            if (millis > 2147483647L) {
                throw new IllegalArgumentException(str + " too large.");
            } else if (millis != 0 || i2 <= 0) {
                return (int) millis;
            } else {
                throw new IllegalArgumentException(str + " too small.");
            }
        }

        public b a(long j2, TimeUnit timeUnit) {
            this.a = a("timeout", j2, timeUnit);
            return this;
        }

        public b a(boolean z) {
            this.f220d = z;
            return this;
        }

        public a a() {
            return new a(this);
        }

        public b b(long j2, TimeUnit timeUnit) {
            this.b = a("timeout", j2, timeUnit);
            return this;
        }

        public b c(long j2, TimeUnit timeUnit) {
            this.f219c = a("timeout", j2, timeUnit);
            return this;
        }
    }

    private a(b bVar) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        v.b b2 = new v.b().a(bVar.a, timeUnit).c(bVar.f219c, timeUnit).b(bVar.b, timeUnit);
        if (bVar.f220d) {
            g gVar = new g();
            this.b = gVar;
            b2.a(gVar);
        }
        this.a = b2.a();
    }

    public static void d() {
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.a(b.EnumC0014b.DEBUG);
    }

    public bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.a a() {
        return new bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.a(this.a);
    }

    public void a(Context context, boolean z, boolean z2, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.b bVar) {
        if (context == null) {
            throw new IllegalArgumentException("tryInitAdTTNet context is null");
        }
        if (bVar == null) {
            throw new IllegalArgumentException("tryInitAdTTNet ITTAdNetDepend is null");
        }
        int c2 = bVar.c();
        this.f218c = c2;
        g gVar = this.b;
        if (gVar != null) {
            gVar.a(c2);
        }
        h.a().a(this.f218c).a(z2);
        h.a().a(this.f218c).a(bVar);
        h.a().a(this.f218c).a(context, f.b(context));
        if (f.c(context) || (!f.b(context) && z)) {
            h.a().a(this.f218c, context).d();
            h.a().a(this.f218c, context).f();
        }
        if (f.b(context)) {
            h.a().a(this.f218c, context).d();
            h.a().a(this.f218c, context).f();
        }
    }

    public v b() {
        return this.a;
    }

    public c c() {
        return new c(this.a);
    }
}
