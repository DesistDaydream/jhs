package e.b.a.p.m.d;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public class g implements e.b.a.p.k.s<Bitmap>, e.b.a.p.k.o {
    private final Bitmap a;
    private final e.b.a.p.k.x.e b;

    public g(@NonNull Bitmap bitmap, @NonNull e.b.a.p.k.x.e eVar) {
        this.a = (Bitmap) e.b.a.v.l.e(bitmap, "Bitmap must not be null");
        this.b = (e.b.a.p.k.x.e) e.b.a.v.l.e(eVar, "BitmapPool must not be null");
    }

    @Nullable
    public static g d(@Nullable Bitmap bitmap, @NonNull e.b.a.p.k.x.e eVar) {
        if (bitmap == null) {
            return null;
        }
        return new g(bitmap, eVar);
    }

    @Override // e.b.a.p.k.o
    public void a() {
        this.a.prepareToDraw();
    }

    @Override // e.b.a.p.k.s
    @NonNull
    public Class<Bitmap> b() {
        return Bitmap.class;
    }

    @Override // e.b.a.p.k.s
    @NonNull
    /* renamed from: c */
    public Bitmap get() {
        return this.a;
    }

    @Override // e.b.a.p.k.s
    public int getSize() {
        return e.b.a.v.n.h(this.a);
    }

    @Override // e.b.a.p.k.s
    public void recycle() {
        this.b.d(this.a);
    }
}
