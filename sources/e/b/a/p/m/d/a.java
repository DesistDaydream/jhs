package e.b.a.p.m.d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import java.io.IOException;

/* loaded from: classes.dex */
public class a<DataType> implements e.b.a.p.g<DataType, BitmapDrawable> {
    private final e.b.a.p.g<DataType, Bitmap> a;
    private final Resources b;

    public a(Context context, e.b.a.p.g<DataType, Bitmap> gVar) {
        this(context.getResources(), gVar);
    }

    @Override // e.b.a.p.g
    public boolean a(@NonNull DataType datatype, @NonNull e.b.a.p.f fVar) throws IOException {
        return this.a.a(datatype, fVar);
    }

    @Override // e.b.a.p.g
    public e.b.a.p.k.s<BitmapDrawable> b(@NonNull DataType datatype, int i2, int i3, @NonNull e.b.a.p.f fVar) throws IOException {
        return x.d(this.b, this.a.b(datatype, i2, i3, fVar));
    }

    @Deprecated
    public a(Resources resources, e.b.a.p.k.x.e eVar, e.b.a.p.g<DataType, Bitmap> gVar) {
        this(resources, gVar);
    }

    public a(@NonNull Resources resources, @NonNull e.b.a.p.g<DataType, Bitmap> gVar) {
        this.b = (Resources) e.b.a.v.l.d(resources);
        this.a = (e.b.a.p.g) e.b.a.v.l.d(gVar);
    }
}
