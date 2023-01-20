package e.b.a.p.k.a0;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import e.b.a.v.l;

/* loaded from: classes.dex */
public final class d {
    @VisibleForTesting

    /* renamed from: e  reason: collision with root package name */
    public static final Bitmap.Config f9503e = Bitmap.Config.RGB_565;
    private final int a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final Bitmap.Config f9504c;

    /* renamed from: d  reason: collision with root package name */
    private final int f9505d;

    /* loaded from: classes.dex */
    public static class a {
        private final int a;
        private final int b;

        /* renamed from: c  reason: collision with root package name */
        private Bitmap.Config f9506c;

        /* renamed from: d  reason: collision with root package name */
        private int f9507d;

        public a(int i2) {
            this(i2, i2);
        }

        public d a() {
            return new d(this.a, this.b, this.f9506c, this.f9507d);
        }

        public Bitmap.Config b() {
            return this.f9506c;
        }

        public a c(@Nullable Bitmap.Config config) {
            this.f9506c = config;
            return this;
        }

        public a d(int i2) {
            if (i2 > 0) {
                this.f9507d = i2;
                return this;
            }
            throw new IllegalArgumentException("Weight must be > 0");
        }

        public a(int i2, int i3) {
            this.f9507d = 1;
            if (i2 <= 0) {
                throw new IllegalArgumentException("Width must be > 0");
            }
            if (i3 > 0) {
                this.a = i2;
                this.b = i3;
                return;
            }
            throw new IllegalArgumentException("Height must be > 0");
        }
    }

    public d(int i2, int i3, Bitmap.Config config, int i4) {
        this.f9504c = (Bitmap.Config) l.e(config, "Config must not be null");
        this.a = i2;
        this.b = i3;
        this.f9505d = i4;
    }

    public Bitmap.Config a() {
        return this.f9504c;
    }

    public int b() {
        return this.b;
    }

    public int c() {
        return this.f9505d;
    }

    public int d() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof d) {
            d dVar = (d) obj;
            return this.b == dVar.b && this.a == dVar.a && this.f9505d == dVar.f9505d && this.f9504c == dVar.f9504c;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.a * 31) + this.b) * 31) + this.f9504c.hashCode()) * 31) + this.f9505d;
    }

    public String toString() {
        return "PreFillSize{width=" + this.a + ", height=" + this.b + ", config=" + this.f9504c + ", weight=" + this.f9505d + '}';
    }
}
