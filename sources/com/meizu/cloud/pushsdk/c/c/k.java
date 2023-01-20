package com.meizu.cloud.pushsdk.c.c;

import com.meizu.cloud.pushsdk.c.c.c;

/* loaded from: classes2.dex */
public class k {
    private final i a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final String f4772c;

    /* renamed from: d  reason: collision with root package name */
    private final c f4773d;

    /* renamed from: e  reason: collision with root package name */
    private final l f4774e;

    /* renamed from: f  reason: collision with root package name */
    private final k f4775f;

    /* renamed from: g  reason: collision with root package name */
    private final k f4776g;

    /* renamed from: h  reason: collision with root package name */
    private final k f4777h;

    /* loaded from: classes2.dex */
    public static class a {
        private i a;

        /* renamed from: c  reason: collision with root package name */
        private String f4778c;

        /* renamed from: e  reason: collision with root package name */
        private l f4780e;

        /* renamed from: f  reason: collision with root package name */
        private k f4781f;

        /* renamed from: g  reason: collision with root package name */
        private k f4782g;

        /* renamed from: h  reason: collision with root package name */
        private k f4783h;
        private int b = -1;

        /* renamed from: d  reason: collision with root package name */
        private c.a f4779d = new c.a();

        public a a(int i2) {
            this.b = i2;
            return this;
        }

        public a a(c cVar) {
            this.f4779d = cVar.c();
            return this;
        }

        public a a(i iVar) {
            this.a = iVar;
            return this;
        }

        public a a(l lVar) {
            this.f4780e = lVar;
            return this;
        }

        public a a(String str) {
            this.f4778c = str;
            return this;
        }

        public k a() {
            if (this.a != null) {
                if (this.b >= 0) {
                    return new k(this);
                }
                throw new IllegalStateException("code < 0: " + this.b);
            }
            throw new IllegalStateException("request == null");
        }
    }

    private k(a aVar) {
        this.a = aVar.a;
        this.b = aVar.b;
        this.f4772c = aVar.f4778c;
        this.f4773d = aVar.f4779d.a();
        this.f4774e = aVar.f4780e;
        this.f4775f = aVar.f4781f;
        this.f4776g = aVar.f4782g;
        this.f4777h = aVar.f4783h;
    }

    public int a() {
        return this.b;
    }

    public l b() {
        return this.f4774e;
    }

    public String toString() {
        return "Response{protocol=, code=" + this.b + ", message=" + this.f4772c + ", url=" + this.a.a() + '}';
    }
}
