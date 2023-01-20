package com.xiaomi.push;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* loaded from: classes3.dex */
public final class da {

    /* loaded from: classes3.dex */
    public static final class a extends de {
        private boolean a;

        /* renamed from: c  reason: collision with root package name */
        private boolean f8358c;

        /* renamed from: e  reason: collision with root package name */
        private boolean f8360e;

        /* renamed from: g  reason: collision with root package name */
        private boolean f8362g;
        private int b = 0;

        /* renamed from: d  reason: collision with root package name */
        private boolean f8359d = false;

        /* renamed from: f  reason: collision with root package name */
        private int f8361f = 0;

        /* renamed from: h  reason: collision with root package name */
        private boolean f8363h = false;

        /* renamed from: i  reason: collision with root package name */
        private List<String> f8364i = Collections.emptyList();

        /* renamed from: j  reason: collision with root package name */
        private int f8365j = -1;

        public static a a(byte[] bArr) {
            return (a) new a().b(bArr);
        }

        public static a b(ab abVar) {
            return new a().c(abVar);
        }

        public int a() {
            return this.b;
        }

        public a a(int i2) {
            this.a = true;
            this.b = i2;
            return this;
        }

        @Override // com.xiaomi.push.de
        /* renamed from: a */
        public a c(ab abVar) {
            while (true) {
                int a = abVar.a();
                if (a == 0) {
                    return this;
                }
                if (a == 8) {
                    a(abVar.i());
                } else if (a == 16) {
                    a(abVar.f());
                } else if (a == 24) {
                    b(abVar.e());
                } else if (a == 32) {
                    b(abVar.f());
                } else if (a == 42) {
                    a(abVar.g());
                } else if (!a(abVar, a)) {
                    return this;
                }
            }
        }

        public a a(String str) {
            Objects.requireNonNull(str);
            if (this.f8364i.isEmpty()) {
                this.f8364i = new ArrayList();
            }
            this.f8364i.add(str);
            return this;
        }

        public a a(boolean z) {
            this.f8358c = true;
            this.f8359d = z;
            return this;
        }

        @Override // com.xiaomi.push.de
        public void a(bc bcVar) {
            if (b()) {
                bcVar.b(1, a());
            }
            if (d()) {
                bcVar.a(2, c());
            }
            if (f()) {
                bcVar.a(3, e());
            }
            if (h()) {
                bcVar.a(4, g());
            }
            for (String str : i()) {
                bcVar.a(5, str);
            }
        }

        public a b(int i2) {
            this.f8360e = true;
            this.f8361f = i2;
            return this;
        }

        public a b(boolean z) {
            this.f8362g = true;
            this.f8363h = z;
            return this;
        }

        public boolean b() {
            return this.a;
        }

        public boolean c() {
            return this.f8359d;
        }

        public boolean d() {
            return this.f8358c;
        }

        public int e() {
            return this.f8361f;
        }

        public boolean f() {
            return this.f8360e;
        }

        public boolean g() {
            return this.f8363h;
        }

        public boolean h() {
            return this.f8362g;
        }

        public List<String> i() {
            return this.f8364i;
        }

        public int j() {
            return this.f8364i.size();
        }

        @Override // com.xiaomi.push.de
        public int k() {
            if (this.f8365j < 0) {
                l();
            }
            return this.f8365j;
        }

        @Override // com.xiaomi.push.de
        public int l() {
            int i2 = 0;
            int d2 = b() ? bc.d(1, a()) + 0 : 0;
            if (d()) {
                d2 += bc.b(2, c());
            }
            if (f()) {
                d2 += bc.c(3, e());
            }
            if (h()) {
                d2 += bc.b(4, g());
            }
            for (String str : i()) {
                i2 += bc.b(str);
            }
            int size = d2 + i2 + (i().size() * 1);
            this.f8365j = size;
            return size;
        }
    }
}
