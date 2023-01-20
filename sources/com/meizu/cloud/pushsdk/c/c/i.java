package com.meizu.cloud.pushsdk.c.c;

import com.meizu.cloud.pushsdk.c.c.c;
import com.qiniu.android.http.request.Request;

/* loaded from: classes2.dex */
public class i {
    private final f a;
    private final String b;

    /* renamed from: c  reason: collision with root package name */
    private final c f4764c;

    /* renamed from: d  reason: collision with root package name */
    private final j f4765d;

    /* renamed from: e  reason: collision with root package name */
    private final Object f4766e;

    /* loaded from: classes2.dex */
    public static class a {
        private f a;
        private String b = "GET";

        /* renamed from: c  reason: collision with root package name */
        private c.a f4767c = new c.a();

        /* renamed from: d  reason: collision with root package name */
        private j f4768d;

        /* renamed from: e  reason: collision with root package name */
        private Object f4769e;

        public a a() {
            return a("GET", (j) null);
        }

        public a a(c cVar) {
            this.f4767c = cVar.c();
            return this;
        }

        public a a(f fVar) {
            if (fVar != null) {
                this.a = fVar;
                return this;
            }
            throw new IllegalArgumentException("url == null");
        }

        public a a(j jVar) {
            return a("POST", jVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0045  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x004a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.meizu.cloud.pushsdk.c.c.i.a a(java.lang.String r7) {
            /*
                r6 = this;
                if (r7 == 0) goto L61
                r1 = 1
                r2 = 0
                r4 = 0
                r5 = 3
                java.lang.String r3 = "ws:"
                r0 = r7
                boolean r0 = r0.regionMatches(r1, r2, r3, r4, r5)
                if (r0 == 0) goto L26
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "http:"
                r0.append(r1)
                r1 = 3
            L1a:
                java.lang.String r7 = r7.substring(r1)
                r0.append(r7)
                java.lang.String r7 = r0.toString()
                goto L3f
            L26:
                r1 = 1
                r2 = 0
                r4 = 0
                r5 = 4
                java.lang.String r3 = "wss:"
                r0 = r7
                boolean r0 = r0.regionMatches(r1, r2, r3, r4, r5)
                if (r0 == 0) goto L3f
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "https:"
                r0.append(r1)
                r1 = 4
                goto L1a
            L3f:
                com.meizu.cloud.pushsdk.c.c.f r0 = com.meizu.cloud.pushsdk.c.c.f.c(r7)
                if (r0 == 0) goto L4a
                com.meizu.cloud.pushsdk.c.c.i$a r7 = r6.a(r0)
                return r7
            L4a:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "unexpected url: "
                r1.append(r2)
                r1.append(r7)
                java.lang.String r7 = r1.toString()
                r0.<init>(r7)
                throw r0
            L61:
                java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
                java.lang.String r0 = "url == null"
                r7.<init>(r0)
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.cloud.pushsdk.c.c.i.a.a(java.lang.String):com.meizu.cloud.pushsdk.c.c.i$a");
        }

        public a a(String str, j jVar) {
            if (str == null || str.length() == 0) {
                throw new IllegalArgumentException("method == null || method.length() == 0");
            }
            if (jVar != null && !d.b(str)) {
                throw new IllegalArgumentException("method " + str + " must not have a request body.");
            } else if (jVar != null || !d.a(str)) {
                this.b = str;
                this.f4768d = jVar;
                return this;
            } else {
                throw new IllegalArgumentException("method " + str + " must have a request body.");
            }
        }

        public a a(String str, String str2) {
            this.f4767c.a(str, str2);
            return this;
        }

        public a b() {
            return a(Request.HttpMethodHEAD, (j) null);
        }

        public a b(j jVar) {
            return a("DELETE", jVar);
        }

        public a c(j jVar) {
            return a(Request.HttpMethodPUT, jVar);
        }

        public i c() {
            if (this.a != null) {
                return new i(this);
            }
            throw new IllegalStateException("url == null");
        }

        public a d(j jVar) {
            return a("PATCH", jVar);
        }
    }

    private i(a aVar) {
        this.a = aVar.a;
        this.b = aVar.b;
        this.f4764c = aVar.f4767c.a();
        this.f4765d = aVar.f4768d;
        this.f4766e = aVar.f4769e != null ? aVar.f4769e : this;
    }

    public f a() {
        return this.a;
    }

    public String a(String str) {
        return this.f4764c.a(str);
    }

    public String b() {
        return this.b;
    }

    public int c() {
        if ("POST".equals(b())) {
            return 1;
        }
        if (Request.HttpMethodPUT.equals(b())) {
            return 2;
        }
        if ("DELETE".equals(b())) {
            return 3;
        }
        if (Request.HttpMethodHEAD.equals(b())) {
            return 4;
        }
        return "PATCH".equals(b()) ? 5 : 0;
    }

    public c d() {
        return this.f4764c;
    }

    public j e() {
        return this.f4765d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request{method=");
        sb.append(this.b);
        sb.append(", url=");
        sb.append(this.a);
        sb.append(", tag=");
        Object obj = this.f4766e;
        if (obj == this) {
            obj = null;
        }
        sb.append(obj);
        sb.append('}');
        return sb.toString();
    }
}
