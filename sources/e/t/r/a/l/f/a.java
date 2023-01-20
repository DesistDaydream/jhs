package e.t.r.a.l.f;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import e.b.a.p.k.x.e;
import e.b.a.p.m.d.h;
import k.e.a.d;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0004J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004H\u0002¨\u0006\u000b"}, d2 = {"Lcom/vector/network/image/glide/transformation/BaseBitmapTransformation;", "Lcom/bumptech/glide/load/resource/bitmap/BitmapTransformation;", "()V", "getAlphaSafeBitmap", "Landroid/graphics/Bitmap;", "pool", "Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;", "maybeAlphaSafe", "getAlphaSafeConfig", "Landroid/graphics/Bitmap$Config;", "inBitmap", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public abstract class a extends h {
    private final Bitmap.Config c(Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 26 && Bitmap.Config.RGBA_F16 == bitmap.getConfig()) {
            return Bitmap.Config.RGBA_F16;
        }
        return Bitmap.Config.ARGB_8888;
    }

    @d
    public final Bitmap b(@d e eVar, @d Bitmap bitmap) {
        Bitmap.Config c2 = c(bitmap);
        if (c2 == bitmap.getConfig()) {
            return bitmap;
        }
        Bitmap f2 = eVar.f(bitmap.getWidth(), bitmap.getHeight(), c2);
        new Canvas(f2).drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        return f2;
    }
}
