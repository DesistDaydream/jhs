package e.b.a.p.k.x;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public class f implements e {
    @Override // e.b.a.p.k.x.e
    public void a(int i2) {
    }

    @Override // e.b.a.p.k.x.e
    public void b() {
    }

    @Override // e.b.a.p.k.x.e
    public void c(float f2) {
    }

    @Override // e.b.a.p.k.x.e
    public void d(Bitmap bitmap) {
        bitmap.recycle();
    }

    @Override // e.b.a.p.k.x.e
    public long e() {
        return 0L;
    }

    @Override // e.b.a.p.k.x.e
    @NonNull
    public Bitmap f(int i2, int i3, Bitmap.Config config) {
        return Bitmap.createBitmap(i2, i3, config);
    }

    @Override // e.b.a.p.k.x.e
    @NonNull
    public Bitmap g(int i2, int i3, Bitmap.Config config) {
        return f(i2, i3, config);
    }
}
