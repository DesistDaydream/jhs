package e.b.a.p.m.d;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public final class e0 implements e.b.a.p.g<Bitmap, Bitmap> {

    /* loaded from: classes.dex */
    public static final class a implements e.b.a.p.k.s<Bitmap> {
        private final Bitmap a;

        public a(@NonNull Bitmap bitmap) {
            this.a = bitmap;
        }

        @Override // e.b.a.p.k.s
        @NonNull
        /* renamed from: a */
        public Bitmap get() {
            return this.a;
        }

        @Override // e.b.a.p.k.s
        @NonNull
        public Class<Bitmap> b() {
            return Bitmap.class;
        }

        @Override // e.b.a.p.k.s
        public int getSize() {
            return e.b.a.v.n.h(this.a);
        }

        @Override // e.b.a.p.k.s
        public void recycle() {
        }
    }

    @Override // e.b.a.p.g
    /* renamed from: c */
    public e.b.a.p.k.s<Bitmap> b(@NonNull Bitmap bitmap, int i2, int i3, @NonNull e.b.a.p.f fVar) {
        return new a(bitmap);
    }

    @Override // e.b.a.p.g
    /* renamed from: d */
    public boolean a(@NonNull Bitmap bitmap, @NonNull e.b.a.p.f fVar) {
        return true;
    }
}
