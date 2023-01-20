package e.t.u;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntegerRes;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import com.vector.util.Res;
import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a,\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u001a\"\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\t2\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u001a\u0016\u0010\n\u001a\u0004\u0018\u00010\b*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u001a\n\u0010\n\u001a\u00020\b*\u00020\t\u001a\u0014\u0010\u000b\u001a\u00020\u0002*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u001a\u0016\u0010\f\u001a\u0004\u0018\u00010\r*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u001a\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000f*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u001a\n\u0010\u0010\u001a\u00020\u0002*\u00020\u0002\u001a\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u0012*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¨\u0006\u0013"}, d2 = {"toBitmap", "Landroid/graphics/Bitmap;", "", "context", "Landroid/content/Context;", "config", "Landroid/graphics/Bitmap$Config;", "options", "Landroid/graphics/BitmapFactory$Options;", "", "toBitmapOptions", "toColor", "toColorStateList", "Landroid/content/res/ColorStateList;", "toDrawable", "Landroid/graphics/drawable/Drawable;", "toInteger", "toVectorDrawable", "Landroidx/vectordrawable/graphics/drawable/VectorDrawableCompat;", "vector_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class w {
    @k.e.a.e
    public static final Bitmap a(@DrawableRes int i2, @k.e.a.e Context context, @k.e.a.d Bitmap.Config config, @k.e.a.e BitmapFactory.Options options) {
        if (i2 == 0) {
            return null;
        }
        Res res = Res.a;
        if (context == null) {
            return null;
        }
        return res.c(context, i2, config, options);
    }

    @k.e.a.e
    public static final Bitmap b(@k.e.a.d String str, @k.e.a.d Bitmap.Config config, @k.e.a.e BitmapFactory.Options options) {
        return Res.a.d(str, config, options);
    }

    public static /* synthetic */ Bitmap c(int i2, Context context, Bitmap.Config config, BitmapFactory.Options options, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        if ((i3 & 4) != 0) {
            options = null;
        }
        return a(i2, context, config, options);
    }

    public static /* synthetic */ Bitmap d(String str, Bitmap.Config config, BitmapFactory.Options options, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        if ((i2 & 2) != 0) {
            options = null;
        }
        return b(str, config, options);
    }

    @k.e.a.e
    public static final BitmapFactory.Options e(@DrawableRes int i2, @k.e.a.e Context context) {
        if (i2 == 0) {
            return null;
        }
        Res res = Res.a;
        if (context == null) {
            return null;
        }
        return res.i(context, i2);
    }

    @k.e.a.d
    public static final BitmapFactory.Options f(@k.e.a.d String str) {
        return Res.a.j(str);
    }

    public static final int g(@ColorRes int i2, @k.e.a.e Context context) {
        return Res.k(i2);
    }

    @k.e.a.e
    public static final ColorStateList h(@ColorRes int i2, @k.e.a.e Context context) {
        return Res.a.l(i2);
    }

    @k.e.a.e
    public static final Drawable i(@DrawableRes int i2, @k.e.a.e Context context) {
        if (i2 == 0) {
            return null;
        }
        Res res = Res.a;
        if (context == null) {
            return null;
        }
        return res.o(i2, context);
    }

    public static final int j(@IntegerRes int i2) {
        return Res.a.r(i2);
    }

    @k.e.a.e
    public static final VectorDrawableCompat k(@DrawableRes int i2, @k.e.a.e Context context) {
        if (i2 == 0) {
            return null;
        }
        Res res = Res.a;
        if (context == null) {
            return null;
        }
        return res.z(context, i2);
    }
}
