package e.j.a.b.c.q;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.google.android.gms.internal.base.zaj;
import e.j.a.b.c.r.y;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public final class d extends b {

    /* renamed from: h  reason: collision with root package name */
    private WeakReference<ImageView> f10364h;

    public d(ImageView imageView, Uri uri) {
        super(uri, 0);
        e.j.a.b.c.r.d.c(imageView);
        this.f10364h = new WeakReference<>(imageView);
    }

    @Override // e.j.a.b.c.q.b
    public final void d(Drawable drawable, boolean z, boolean z2, boolean z3) {
        ImageView imageView = this.f10364h.get();
        if (imageView != null) {
            boolean z4 = (z2 || z3) ? false : true;
            if (z4 && (imageView instanceof zaj)) {
                int b = zaj.b();
                int i2 = this.f10359c;
                if (i2 != 0 && b == i2) {
                    return;
                }
            }
            boolean e2 = e(z, z2);
            if (e2) {
                Drawable drawable2 = imageView.getDrawable();
                if (drawable2 == null) {
                    drawable2 = null;
                } else if (drawable2 instanceof e.j.a.b.f.a.e) {
                    drawable2 = ((e.j.a.b.f.a.e) drawable2).c();
                }
                drawable = new e.j.a.b.f.a.e(drawable2, drawable);
            }
            imageView.setImageDrawable(drawable);
            if (imageView instanceof zaj) {
                zaj.a(z3 ? this.a.a : null);
                zaj.c(z4 ? this.f10359c : 0);
            }
            if (e2) {
                ((e.j.a.b.f.a.e) drawable).b(250);
            }
        }
    }

    public final boolean equals(Object obj) {
        if (obj instanceof d) {
            if (this == obj) {
                return true;
            }
            ImageView imageView = this.f10364h.get();
            ImageView imageView2 = ((d) obj).f10364h.get();
            return (imageView2 == null || imageView == null || !y.a(imageView2, imageView)) ? false : true;
        }
        return false;
    }

    public final int hashCode() {
        return 0;
    }

    public d(ImageView imageView, int i2) {
        super(null, i2);
        e.j.a.b.c.r.d.c(imageView);
        this.f10364h = new WeakReference<>(imageView);
    }
}
