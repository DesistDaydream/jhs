package e.b.a.p.m.d;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public abstract class h implements e.b.a.p.i<Bitmap> {
    public abstract Bitmap a(@NonNull e.b.a.p.k.x.e eVar, @NonNull Bitmap bitmap, int i2, int i3);

    @Override // e.b.a.p.i
    @NonNull
    public final e.b.a.p.k.s<Bitmap> transform(@NonNull Context context, @NonNull e.b.a.p.k.s<Bitmap> sVar, int i2, int i3) {
        if (e.b.a.v.n.w(i2, i3)) {
            e.b.a.p.k.x.e h2 = e.b.a.c.e(context).h();
            Bitmap bitmap = sVar.get();
            if (i2 == Integer.MIN_VALUE) {
                i2 = bitmap.getWidth();
            }
            if (i3 == Integer.MIN_VALUE) {
                i3 = bitmap.getHeight();
            }
            Bitmap a = a(h2, bitmap, i2, i3);
            return bitmap.equals(a) ? sVar : g.d(a, h2);
        }
        throw new IllegalArgumentException("Cannot apply transformation on width: " + i2 + " or height: " + i3 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
    }
}
