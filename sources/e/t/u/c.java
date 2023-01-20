package e.t.u;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import androidx.annotation.DrawableRes;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.vector.FileSuffix;
import com.vector.ext.BitmapKt;
import com.vector.util.Res;
import h.k2.v.f0;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\u000e\u001a\u00020\u0004J\"\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010J\"\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004J*\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0004J\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0006J \u0010\u0017\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0004J(\u0010\u0017\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004J\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0006J\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\u00062\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0004J \u0010\u0019\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004J\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0004J\u001a\u0010\u001d\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\u000e\u001a\u00020\u0004¨\u0006\u001e"}, d2 = {"Lcom/vector/util/BmpLoader;", "", "()V", "getDrawableId", "", "name", "", "getExifDegree", "path", "getMipmapId", "load", "Landroid/graphics/Bitmap;", "context", "Landroid/content/Context;", "id", "scale", "", "sampleSize", IAdInterListener.AdReqParam.WIDTH, "h", "data", "", "maxPixels", "loadDrawable", "loadMipmap", "loadPath", "suffix", "Lcom/vector/FileSuffix;", "loadPathByPixels", "loadVector", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class c {
    @k.e.a.d
    public static final c a = new c();

    private c() {
    }

    public static /* synthetic */ Bitmap q(c cVar, String str, FileSuffix fileSuffix, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            fileSuffix = null;
        }
        return cVar.p(str, fileSuffix);
    }

    public final int a(@k.e.a.d String str) {
        return Res.a.getIdentifier(str, Res.Type.DRAWABLE);
    }

    public final int b(@k.e.a.d String str) {
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);
            if (attributeInt != 3) {
                if (attributeInt != 6) {
                    return attributeInt != 8 ? 0 : 270;
                }
                return 90;
            }
            return 180;
        } catch (Throwable unused) {
            return 0;
        }
    }

    public final int c(@k.e.a.d String str) {
        return Res.a.getIdentifier(str, Res.Type.MIPMAP);
    }

    @k.e.a.e
    public final Bitmap d(@k.e.a.d Context context, @DrawableRes int i2) {
        return Res.f(Res.a, context, i2, null, null, 12, null);
    }

    @k.e.a.e
    public final Bitmap e(@k.e.a.d Context context, @DrawableRes int i2, float f2) {
        Bitmap d2 = d(context, i2);
        if (d2 == null) {
            return null;
        }
        Bitmap r = BitmapKt.r(d2, f2);
        d2.recycle();
        return r;
    }

    @k.e.a.e
    public final Bitmap f(@k.e.a.d Context context, @DrawableRes int i2, int i3) {
        Res res = Res.a;
        BitmapFactory.Options i4 = res.i(context, i2);
        i4.inSampleSize = i3;
        i4.inJustDecodeBounds = false;
        return Res.f(res, context, i2, null, i4, 4, null);
    }

    @k.e.a.e
    public final Bitmap g(@k.e.a.d Context context, @DrawableRes int i2, int i3, int i4) {
        Res res = Res.a;
        BitmapFactory.Options i5 = res.i(context, i2);
        i5.inSampleSize = e.t.l.e.b(i5, i3, i4);
        i5.inJustDecodeBounds = false;
        return Res.f(res, context, i2, null, i5, 4, null);
    }

    @k.e.a.d
    public final Bitmap h(@k.e.a.d byte[] bArr) {
        return BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
    }

    @k.e.a.d
    public final Bitmap i(@k.e.a.d byte[] bArr, int i2) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        options.inSampleSize = e.t.l.e.a(options, i2);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
    }

    @k.e.a.e
    public final Bitmap j(@k.e.a.d Context context, @k.e.a.d String str) {
        return d(context, a(str));
    }

    @k.e.a.e
    public final Bitmap k(@k.e.a.d Context context, @k.e.a.d String str, int i2) {
        return f(context, a(str), i2);
    }

    @k.e.a.e
    public final Bitmap l(@k.e.a.d Context context, @k.e.a.d String str, int i2, int i3) {
        return g(context, a(str), i2, i3);
    }

    @k.e.a.e
    public final Bitmap m(@k.e.a.d Context context, @k.e.a.d String str) {
        return d(context, c(str));
    }

    @k.e.a.e
    public final Bitmap n(@k.e.a.d String str, int i2) {
        Res res = Res.a;
        BitmapFactory.Options j2 = res.j(str);
        j2.inSampleSize = i2;
        j2.inJustDecodeBounds = false;
        return Res.g(res, str, null, j2, 2, null);
    }

    @k.e.a.e
    public final Bitmap o(@k.e.a.d String str, int i2, int i3) {
        Res res = Res.a;
        BitmapFactory.Options j2 = res.j(str);
        j2.inSampleSize = e.t.l.e.b(j2, i2, i3);
        j2.inJustDecodeBounds = false;
        return Res.g(res, str, null, j2, 2, null);
    }

    @k.e.a.e
    public final Bitmap p(@k.e.a.d String str, @k.e.a.e FileSuffix fileSuffix) {
        return Res.g(Res.a, f0.C(str, fileSuffix == null ? null : fileSuffix.getText()), null, null, 6, null);
    }

    @k.e.a.e
    public final Bitmap r(@k.e.a.d String str, int i2) {
        return n(str, e.t.l.e.a(Res.a.j(str), i2));
    }

    @k.e.a.e
    public final Bitmap s(@k.e.a.d Context context, @DrawableRes int i2) {
        if (Build.VERSION.SDK_INT > 21) {
            Drawable drawable = context.getDrawable(i2);
            if (drawable == null) {
                return null;
            }
            Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return createBitmap;
        }
        return Res.f(Res.a, context, i2, null, null, 12, null);
    }
}
