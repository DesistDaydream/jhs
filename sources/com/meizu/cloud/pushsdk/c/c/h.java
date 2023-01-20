package com.meizu.cloud.pushsdk.c.c;

import com.moor.imkf.lib.jsoup.helper.HttpConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/* loaded from: classes2.dex */
public final class h extends j {
    public static final g a = g.a("multipart/mixed");
    public static final g b = g.a("multipart/alternative");

    /* renamed from: c  reason: collision with root package name */
    public static final g f4752c = g.a("multipart/digest");

    /* renamed from: d  reason: collision with root package name */
    public static final g f4753d = g.a("multipart/parallel");

    /* renamed from: e  reason: collision with root package name */
    public static final g f4754e = g.a(HttpConnection.MULTIPART_FORM_DATA);

    /* renamed from: f  reason: collision with root package name */
    private static final byte[] f4755f = {58, 32};

    /* renamed from: g  reason: collision with root package name */
    private static final byte[] f4756g = {13, 10};

    /* renamed from: h  reason: collision with root package name */
    private static final byte[] f4757h = {45, 45};

    /* renamed from: i  reason: collision with root package name */
    private final com.meizu.cloud.pushsdk.c.g.e f4758i;

    /* renamed from: j  reason: collision with root package name */
    private final g f4759j;

    /* renamed from: k  reason: collision with root package name */
    private final g f4760k;

    /* renamed from: l  reason: collision with root package name */
    private final List<b> f4761l;

    /* renamed from: m  reason: collision with root package name */
    private long f4762m = -1;

    /* loaded from: classes2.dex */
    public static final class a {
        private final com.meizu.cloud.pushsdk.c.g.e a;
        private g b;

        /* renamed from: c  reason: collision with root package name */
        private final List<b> f4763c;

        public a() {
            this(UUID.randomUUID().toString());
        }

        public a(String str) {
            this.b = h.a;
            this.f4763c = new ArrayList();
            this.a = com.meizu.cloud.pushsdk.c.g.e.a(str);
        }

        public a a(c cVar, j jVar) {
            return a(b.a(cVar, jVar));
        }

        public a a(g gVar) {
            Objects.requireNonNull(gVar, "type == null");
            if ("multipart".equals(gVar.a())) {
                this.b = gVar;
                return this;
            }
            throw new IllegalArgumentException("multipart != " + gVar);
        }

        public a a(b bVar) {
            Objects.requireNonNull(bVar, "part == null");
            this.f4763c.add(bVar);
            return this;
        }

        public h a() {
            if (this.f4763c.isEmpty()) {
                throw new IllegalStateException("Multipart body must have at least one part.");
            }
            return new h(this.a, this.b, this.f4763c);
        }
    }

    /* loaded from: classes2.dex */
    public static final class b {
        private final c a;
        private final j b;

        private b(c cVar, j jVar) {
            this.a = cVar;
            this.b = jVar;
        }

        public static b a(c cVar, j jVar) {
            Objects.requireNonNull(jVar, "body == null");
            if (cVar == null || cVar.a("Content-Type") == null) {
                if (cVar == null || cVar.a("Content-Length") == null) {
                    return new b(cVar, jVar);
                }
                throw new IllegalArgumentException("Unexpected header: Content-Length");
            }
            throw new IllegalArgumentException("Unexpected header: Content-Type");
        }
    }

    public h(com.meizu.cloud.pushsdk.c.g.e eVar, g gVar, List<b> list) {
        this.f4758i = eVar;
        this.f4759j = gVar;
        this.f4760k = g.a(gVar + "; boundary=" + eVar.a());
        this.f4761l = m.a(list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private long a(com.meizu.cloud.pushsdk.c.g.c cVar, boolean z) {
        com.meizu.cloud.pushsdk.c.g.b bVar;
        if (z) {
            cVar = new com.meizu.cloud.pushsdk.c.g.b();
            bVar = cVar;
        } else {
            bVar = 0;
        }
        int size = this.f4761l.size();
        long j2 = 0;
        for (int i2 = 0; i2 < size; i2++) {
            b bVar2 = this.f4761l.get(i2);
            c cVar2 = bVar2.a;
            j jVar = bVar2.b;
            cVar.c(f4757h);
            cVar.b(this.f4758i);
            cVar.c(f4756g);
            if (cVar2 != null) {
                int a2 = cVar2.a();
                for (int i3 = 0; i3 < a2; i3++) {
                    cVar.b(cVar2.a(i3)).c(f4755f).b(cVar2.b(i3)).c(f4756g);
                }
            }
            g a3 = jVar.a();
            if (a3 != null) {
                cVar.b("Content-Type: ").b(a3.toString()).c(f4756g);
            }
            long b2 = jVar.b();
            if (b2 != -1) {
                cVar.b("Content-Length: ").e(b2).c(f4756g);
            } else if (z) {
                bVar.j();
                return -1L;
            }
            byte[] bArr = f4756g;
            cVar.c(bArr);
            if (z) {
                j2 += b2;
            } else {
                jVar.a(cVar);
            }
            cVar.c(bArr);
        }
        byte[] bArr2 = f4757h;
        cVar.c(bArr2);
        cVar.b(this.f4758i);
        cVar.c(bArr2);
        cVar.c(f4756g);
        if (z) {
            long a4 = j2 + bVar.a();
            bVar.j();
            return a4;
        }
        return j2;
    }

    @Override // com.meizu.cloud.pushsdk.c.c.j
    public g a() {
        return this.f4760k;
    }

    @Override // com.meizu.cloud.pushsdk.c.c.j
    public void a(com.meizu.cloud.pushsdk.c.g.c cVar) {
        a(cVar, false);
    }

    @Override // com.meizu.cloud.pushsdk.c.c.j
    public long b() {
        long j2 = this.f4762m;
        if (j2 != -1) {
            return j2;
        }
        long a2 = a((com.meizu.cloud.pushsdk.c.g.c) null, true);
        this.f4762m = a2;
        return a2;
    }
}
