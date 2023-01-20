package e.j.a.b.c.q;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.gms.common.images.ImageManager;
import e.j.a.b.c.r.y;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public final class e extends b {

    /* renamed from: h  reason: collision with root package name */
    private WeakReference<ImageManager.a> f10365h;

    public e(ImageManager.a aVar, Uri uri) {
        super(uri, 0);
        e.j.a.b.c.r.d.c(aVar);
        this.f10365h = new WeakReference<>(aVar);
    }

    @Override // e.j.a.b.c.q.b
    public final void d(Drawable drawable, boolean z, boolean z2, boolean z3) {
        ImageManager.a aVar;
        if (z2 || (aVar = this.f10365h.get()) == null) {
            return;
        }
        aVar.a(this.a.a, drawable, z3);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof e) {
            if (this == obj) {
                return true;
            }
            e eVar = (e) obj;
            ImageManager.a aVar = this.f10365h.get();
            ImageManager.a aVar2 = eVar.f10365h.get();
            return aVar2 != null && aVar != null && y.a(aVar2, aVar) && y.a(eVar.a, this.a);
        }
        return false;
    }

    public final int hashCode() {
        return y.b(this.a);
    }
}
