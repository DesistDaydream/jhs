package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.r;
import java.util.Objects;

/* loaded from: classes.dex */
public final class y {
    public final s a;
    public final String b;

    /* renamed from: c  reason: collision with root package name */
    public final r f671c;

    /* renamed from: d  reason: collision with root package name */
    public final z f672d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f673e;

    /* renamed from: f  reason: collision with root package name */
    private volatile d f674f;

    /* loaded from: classes.dex */
    public static class a {
        public s a;
        public String b;

        /* renamed from: c  reason: collision with root package name */
        public r.a f675c;

        /* renamed from: d  reason: collision with root package name */
        public z f676d;

        /* renamed from: e  reason: collision with root package name */
        public Object f677e;

        public a() {
            this.b = "GET";
            this.f675c = new r.a();
        }

        public a(y yVar) {
            this.a = yVar.a;
            this.b = yVar.b;
            this.f676d = yVar.f672d;
            this.f677e = yVar.f673e;
            this.f675c = yVar.f671c.a();
        }

        public a a(d dVar) {
            String dVar2 = dVar.toString();
            return dVar2.isEmpty() ? a("Cache-Control") : b("Cache-Control", dVar2);
        }

        public a a(r rVar) {
            this.f675c = rVar.a();
            return this;
        }

        public a a(s sVar) {
            Objects.requireNonNull(sVar, "url == null");
            this.a = sVar;
            return this;
        }

        public a a(z zVar) {
            return a("POST", zVar);
        }

        public a a(Object obj) {
            this.f677e = obj;
            return this;
        }

        public a a(String str) {
            this.f675c.b(str);
            return this;
        }

        public a a(String str, z zVar) {
            Objects.requireNonNull(str, "method == null");
            if (str.length() != 0) {
                if (zVar != null && !bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.f.b(str)) {
                    throw new IllegalArgumentException("method " + str + " must not have a request body.");
                } else if (zVar != null || !bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.f.e(str)) {
                    this.b = str;
                    this.f676d = zVar;
                    return this;
                } else {
                    throw new IllegalArgumentException("method " + str + " must have a request body.");
                }
            }
            throw new IllegalArgumentException("method.length() == 0");
        }

        public a a(String str, String str2) {
            this.f675c.a(str, str2);
            return this;
        }

        public y a() {
            if (this.a != null) {
                return new y(this);
            }
            throw new IllegalStateException("url == null");
        }

        public a b() {
            return a("GET", (z) null);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0048  */
        /* JADX WARN: Removed duplicated region for block: B:13:0x004d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.y.a b(java.lang.String r8) {
            /*
                r7 = this;
                java.lang.String r0 = "url == null"
                java.util.Objects.requireNonNull(r8, r0)
                r2 = 1
                r3 = 0
                r5 = 0
                r6 = 3
                java.lang.String r4 = "ws:"
                r1 = r8
                boolean r0 = r1.regionMatches(r2, r3, r4, r5, r6)
                if (r0 == 0) goto L29
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "http:"
                r0.append(r1)
                r1 = 3
            L1d:
                java.lang.String r8 = r8.substring(r1)
                r0.append(r8)
                java.lang.String r8 = r0.toString()
                goto L42
            L29:
                r1 = 1
                r2 = 0
                r4 = 0
                r5 = 4
                java.lang.String r3 = "wss:"
                r0 = r8
                boolean r0 = r0.regionMatches(r1, r2, r3, r4, r5)
                if (r0 == 0) goto L42
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "https:"
                r0.append(r1)
                r1 = 4
                goto L1d
            L42:
                bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.s r0 = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.s.d(r8)
                if (r0 == 0) goto L4d
                bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.y$a r8 = r7.a(r0)
                return r8
            L4d:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "unexpected url: "
                r1.append(r2)
                r1.append(r8)
                java.lang.String r8 = r1.toString()
                r0.<init>(r8)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.y.a.b(java.lang.String):bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.y$a");
        }

        public a b(String str, String str2) {
            this.f675c.c(str, str2);
            return this;
        }
    }

    public y(a aVar) {
        this.a = aVar.a;
        this.b = aVar.b;
        this.f671c = aVar.f675c.a();
        this.f672d = aVar.f676d;
        Object obj = aVar.f677e;
        this.f673e = obj == null ? this : obj;
    }

    public z a() {
        return this.f672d;
    }

    public String a(String str) {
        return this.f671c.a(str);
    }

    public d b() {
        d dVar = this.f674f;
        if (dVar != null) {
            return dVar;
        }
        d a2 = d.a(this.f671c);
        this.f674f = a2;
        return a2;
    }

    public r c() {
        return this.f671c;
    }

    public boolean d() {
        return this.a.h();
    }

    public String e() {
        return this.b;
    }

    public a f() {
        return new a(this);
    }

    public s g() {
        return this.a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request{method=");
        sb.append(this.b);
        sb.append(", url=");
        sb.append(this.a);
        sb.append(", tag=");
        Object obj = this.f673e;
        if (obj == this) {
            obj = null;
        }
        sb.append(obj);
        sb.append('}');
        return sb.toString();
    }
}
