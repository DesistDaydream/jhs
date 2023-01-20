package e.b.a.p.m.d;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.annotation.Nullable;
import java.util.concurrent.locks.Lock;

/* loaded from: classes.dex */
public final class p {
    private static final String a = "DrawableToBitmap";
    private static final e.b.a.p.k.x.e b = new a();

    /* loaded from: classes.dex */
    public class a extends e.b.a.p.k.x.f {
        @Override // e.b.a.p.k.x.f, e.b.a.p.k.x.e
        public void d(Bitmap bitmap) {
        }
    }

    private p() {
    }

    @Nullable
    public static e.b.a.p.k.s<Bitmap> a(e.b.a.p.k.x.e eVar, Drawable drawable, int i2, int i3) {
        Bitmap bitmap;
        Drawable current = drawable.getCurrent();
        boolean z = false;
        if (current instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) current).getBitmap();
        } else if (current instanceof Animatable) {
            bitmap = null;
        } else {
            bitmap = b(eVar, current, i2, i3);
            z = true;
        }
        if (!z) {
            eVar = b;
        }
        return g.d(bitmap, eVar);
    }

    @Nullable
    private static Bitmap b(e.b.a.p.k.x.e eVar, Drawable drawable, int i2, int i3) {
        if (i2 == Integer.MIN_VALUE && drawable.getIntrinsicWidth() <= 0) {
            if (Log.isLoggable(a, 5)) {
                Log.w(a, "Unable to draw " + drawable + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic width");
            }
            return null;
        } else if (i3 == Integer.MIN_VALUE && drawable.getIntrinsicHeight() <= 0) {
            if (Log.isLoggable(a, 5)) {
                Log.w(a, "Unable to draw " + drawable + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic height");
            }
            return null;
        } else {
            if (drawable.getIntrinsicWidth() > 0) {
                i2 = drawable.getIntrinsicWidth();
            }
            if (drawable.getIntrinsicHeight() > 0) {
                i3 = drawable.getIntrinsicHeight();
            }
            Lock i4 = d0.i();
            i4.lock();
            Bitmap f2 = eVar.f(i2, i3, Bitmap.Config.ARGB_8888);
            try {
                Canvas canvas = new Canvas(f2);
                drawable.setBounds(0, 0, i2, i3);
                drawable.draw(canvas);
                canvas.setBitmap(null);
                return f2;
            } finally {
                i4.unlock();
            }
        }
    }
}
