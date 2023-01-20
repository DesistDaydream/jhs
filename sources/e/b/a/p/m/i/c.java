package e.b.a.p.m.i;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import e.b.a.p.k.s;

/* loaded from: classes.dex */
public final class c implements e<Drawable, byte[]> {
    private final e.b.a.p.k.x.e a;
    private final e<Bitmap, byte[]> b;

    /* renamed from: c  reason: collision with root package name */
    private final e<e.b.a.p.m.h.c, byte[]> f9836c;

    public c(@NonNull e.b.a.p.k.x.e eVar, @NonNull e<Bitmap, byte[]> eVar2, @NonNull e<e.b.a.p.m.h.c, byte[]> eVar3) {
        this.a = eVar;
        this.b = eVar2;
        this.f9836c = eVar3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    private static s<e.b.a.p.m.h.c> b(@NonNull s<Drawable> sVar) {
        return sVar;
    }

    @Override // e.b.a.p.m.i.e
    @Nullable
    public s<byte[]> a(@NonNull s<Drawable> sVar, @NonNull e.b.a.p.f fVar) {
        Drawable drawable = sVar.get();
        if (drawable instanceof BitmapDrawable) {
            return this.b.a(e.b.a.p.m.d.g.d(((BitmapDrawable) drawable).getBitmap(), this.a), fVar);
        }
        if (drawable instanceof e.b.a.p.m.h.c) {
            return this.f9836c.a(b(sVar), fVar);
        }
        return null;
    }
}
