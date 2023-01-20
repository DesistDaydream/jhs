package e.b.a.p.k.x;

import android.graphics.Bitmap;
import androidx.annotation.VisibleForTesting;

/* loaded from: classes.dex */
public class c implements l {
    private final b a = new b();
    private final h<a, Bitmap> b = new h<>();

    @VisibleForTesting
    /* loaded from: classes.dex */
    public static class a implements m {
        private final b a;
        private int b;

        /* renamed from: c  reason: collision with root package name */
        private int f9605c;

        /* renamed from: d  reason: collision with root package name */
        private Bitmap.Config f9606d;

        public a(b bVar) {
            this.a = bVar;
        }

        @Override // e.b.a.p.k.x.m
        public void a() {
            this.a.c(this);
        }

        public void b(int i2, int i3, Bitmap.Config config) {
            this.b = i2;
            this.f9605c = i3;
            this.f9606d = config;
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                return this.b == aVar.b && this.f9605c == aVar.f9605c && this.f9606d == aVar.f9606d;
            }
            return false;
        }

        public int hashCode() {
            int i2 = ((this.b * 31) + this.f9605c) * 31;
            Bitmap.Config config = this.f9606d;
            return i2 + (config != null ? config.hashCode() : 0);
        }

        public String toString() {
            return c.g(this.b, this.f9605c, this.f9606d);
        }
    }

    @VisibleForTesting
    /* loaded from: classes.dex */
    public static class b extends d<a> {
        @Override // e.b.a.p.k.x.d
        /* renamed from: d */
        public a a() {
            return new a(this);
        }

        public a e(int i2, int i3, Bitmap.Config config) {
            a b = b();
            b.b(i2, i3, config);
            return b;
        }
    }

    public static String g(int i2, int i3, Bitmap.Config config) {
        return "[" + i2 + "x" + i3 + "], " + config;
    }

    private static String h(Bitmap bitmap) {
        return g(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }

    @Override // e.b.a.p.k.x.l
    public String a(Bitmap bitmap) {
        return h(bitmap);
    }

    @Override // e.b.a.p.k.x.l
    public Bitmap b() {
        return this.b.f();
    }

    @Override // e.b.a.p.k.x.l
    public String c(int i2, int i3, Bitmap.Config config) {
        return g(i2, i3, config);
    }

    @Override // e.b.a.p.k.x.l
    public void d(Bitmap bitmap) {
        this.b.d(this.a.e(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig()), bitmap);
    }

    @Override // e.b.a.p.k.x.l
    public int e(Bitmap bitmap) {
        return e.b.a.v.n.h(bitmap);
    }

    @Override // e.b.a.p.k.x.l
    public Bitmap f(int i2, int i3, Bitmap.Config config) {
        return this.b.a(this.a.e(i2, i3, config));
    }

    public String toString() {
        return "AttributeStrategy:\n  " + this.b;
    }
}
