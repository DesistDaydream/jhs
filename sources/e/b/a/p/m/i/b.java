package e.b.a.p.m.i;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import e.b.a.p.k.s;
import e.b.a.p.m.d.x;
import e.b.a.v.l;

/* loaded from: classes.dex */
public class b implements e<Bitmap, BitmapDrawable> {
    private final Resources a;

    public b(@NonNull Context context) {
        this(context.getResources());
    }

    @Override // e.b.a.p.m.i.e
    @Nullable
    public s<BitmapDrawable> a(@NonNull s<Bitmap> sVar, @NonNull e.b.a.p.f fVar) {
        return x.d(this.a, sVar);
    }

    @Deprecated
    public b(@NonNull Resources resources, e.b.a.p.k.x.e eVar) {
        this(resources);
    }

    public b(@NonNull Resources resources) {
        this.a = (Resources) l.d(resources);
    }
}
