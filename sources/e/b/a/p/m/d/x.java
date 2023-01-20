package e.b.a.p.m.d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public final class x implements e.b.a.p.k.s<BitmapDrawable>, e.b.a.p.k.o {
    private final Resources a;
    private final e.b.a.p.k.s<Bitmap> b;

    private x(@NonNull Resources resources, @NonNull e.b.a.p.k.s<Bitmap> sVar) {
        this.a = (Resources) e.b.a.v.l.d(resources);
        this.b = (e.b.a.p.k.s) e.b.a.v.l.d(sVar);
    }

    @Nullable
    public static e.b.a.p.k.s<BitmapDrawable> d(@NonNull Resources resources, @Nullable e.b.a.p.k.s<Bitmap> sVar) {
        if (sVar == null) {
            return null;
        }
        return new x(resources, sVar);
    }

    @Deprecated
    public static x e(Context context, Bitmap bitmap) {
        return (x) d(context.getResources(), g.d(bitmap, e.b.a.c.e(context).h()));
    }

    @Deprecated
    public static x f(Resources resources, e.b.a.p.k.x.e eVar, Bitmap bitmap) {
        return (x) d(resources, g.d(bitmap, eVar));
    }

    @Override // e.b.a.p.k.o
    public void a() {
        e.b.a.p.k.s<Bitmap> sVar = this.b;
        if (sVar instanceof e.b.a.p.k.o) {
            ((e.b.a.p.k.o) sVar).a();
        }
    }

    @Override // e.b.a.p.k.s
    @NonNull
    public Class<BitmapDrawable> b() {
        return BitmapDrawable.class;
    }

    @Override // e.b.a.p.k.s
    @NonNull
    /* renamed from: c */
    public BitmapDrawable get() {
        return new BitmapDrawable(this.a, this.b.get());
    }

    @Override // e.b.a.p.k.s
    public int getSize() {
        return this.b.getSize();
    }

    @Override // e.b.a.p.k.s
    public void recycle() {
        this.b.recycle();
    }
}
