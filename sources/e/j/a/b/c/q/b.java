package e.j.a.b.c.q;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import e.j.a.b.f.a.j;

/* loaded from: classes2.dex */
public abstract class b {
    public final c a;

    /* renamed from: c  reason: collision with root package name */
    public int f10359c;
    private int b = 0;

    /* renamed from: d  reason: collision with root package name */
    private boolean f10360d = false;

    /* renamed from: e  reason: collision with root package name */
    private boolean f10361e = true;

    /* renamed from: f  reason: collision with root package name */
    private boolean f10362f = false;

    /* renamed from: g  reason: collision with root package name */
    private boolean f10363g = true;

    public b(Uri uri, int i2) {
        this.f10359c = 0;
        this.a = new c(uri);
        this.f10359c = i2;
    }

    public final void a(Context context, Bitmap bitmap, boolean z) {
        e.j.a.b.c.r.d.c(bitmap);
        d(new BitmapDrawable(context.getResources(), bitmap), z, false, true);
    }

    public final void b(Context context, j jVar) {
        if (this.f10363g) {
            d(null, false, true, false);
        }
    }

    public final void c(Context context, j jVar, boolean z) {
        int i2 = this.f10359c;
        d(i2 != 0 ? context.getResources().getDrawable(i2) : null, z, false, false);
    }

    public abstract void d(Drawable drawable, boolean z, boolean z2, boolean z3);

    public final boolean e(boolean z, boolean z2) {
        return (!this.f10361e || z2 || z) ? false : true;
    }
}
