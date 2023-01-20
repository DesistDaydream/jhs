package e.b.a.p.m.d;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public class z implements e.b.a.p.g<Uri, Bitmap> {
    private final e.b.a.p.m.f.e a;
    private final e.b.a.p.k.x.e b;

    public z(e.b.a.p.m.f.e eVar, e.b.a.p.k.x.e eVar2) {
        this.a = eVar;
        this.b = eVar2;
    }

    @Override // e.b.a.p.g
    @Nullable
    /* renamed from: c */
    public e.b.a.p.k.s<Bitmap> b(@NonNull Uri uri, int i2, int i3, @NonNull e.b.a.p.f fVar) {
        e.b.a.p.k.s<Drawable> b = this.a.b(uri, i2, i3, fVar);
        if (b == null) {
            return null;
        }
        return p.a(this.b, b.get(), i2, i3);
    }

    @Override // e.b.a.p.g
    /* renamed from: d */
    public boolean a(@NonNull Uri uri, @NonNull e.b.a.p.f fVar) {
        return "android.resource".equals(uri.getScheme());
    }
}
