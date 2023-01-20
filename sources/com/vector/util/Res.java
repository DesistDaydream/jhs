package com.vector.util;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.NinePatch;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.annotation.AnimRes;
import androidx.annotation.AnyRes;
import androidx.annotation.ArrayRes;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntegerRes;
import androidx.annotation.RawRes;
import androidx.annotation.StringRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import com.effective.android.panel.Constants;
import e.t.o.f;
import h.k2.k;
import java.io.InputStream;
import java.util.Arrays;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u000201B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\u0004J0\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010J&\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010J&\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u0018\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\u0004J\u000e\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0014J\u0012\u0010\u0017\u001a\u00020\u00042\b\b\u0001\u0010\n\u001a\u00020\u0004H\u0007J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\b\u0001\u0010\n\u001a\u00020\u0004J\u001a\u0010\u001a\u001a\u00020\u001b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0001\u0010\n\u001a\u00020\u0004J\u001a\u0010\u001c\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0001\u0010\n\u001a\u00020\u0004J\u001a\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\u0004J\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\b\u0001\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\"J\u0010\u0010#\u001a\u00020\u00042\b\b\u0001\u0010\n\u001a\u00020\u0004J\u001a\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\u0004J\u0010\u0010&\u001a\u00020'2\b\b\u0001\u0010\n\u001a\u00020\u0004J\u001a\u0010(\u001a\u00020\u00142\b\b\u0001\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006J)\u0010(\u001a\u00020\u00142\b\b\u0001\u0010\n\u001a\u00020\u00042\u0012\u0010)\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010*\"\u00020\u0001¢\u0006\u0002\u0010+J%\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00140*2\b\b\u0001\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010-J\u001a\u0010.\u001a\u0004\u0018\u00010/2\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087T¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/vector/util/Res;", "", "()V", "ID_NULL", "", "ensureContext", "Landroid/content/Context;", "context", "getAnim", "Landroid/view/animation/Animation;", "id", "getBitmap", "Landroid/graphics/Bitmap;", "config", "Landroid/graphics/Bitmap$Config;", "options", "Landroid/graphics/BitmapFactory$Options;", "bytes", "", "path", "", "getBitmapOptions", "filePath", "getColor", "getColorStateList", "Landroid/content/res/ColorStateList;", "getDimen", "", "getDimensionPixelSize", "getDrawable", "Landroid/graphics/drawable/Drawable;", "getIdentifier", "name", "type", "Lcom/vector/util/Res$Type;", "getInteger", "getNinePatch", "Landroid/graphics/NinePatch;", "getRaw", "Ljava/io/InputStream;", "getString", "args", "", "(I[Ljava/lang/Object;)Ljava/lang/String;", "getStringArray", "(ILandroid/content/Context;)[Ljava/lang/String;", "getVectorDrawable", "Landroidx/vectordrawable/graphics/drawable/VectorDrawableCompat;", "Android", "Type", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class Res {
    @d
    public static final Res a = new Res();
    @AnyRes
    public static final int b = 0;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/vector/util/Res$Type;", "", "text", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getText", "()Ljava/lang/String;", "ID", "STRING", "DRAWABLE", "MIPMAP", "LAYOUT", "DIMEN", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public enum Type {
        ID("id"),
        STRING("string"),
        DRAWABLE("drawable"),
        MIPMAP("mipmap"),
        LAYOUT("layout"),
        DIMEN(Constants.DIMEN);
        
        @d
        private final String text;

        Type(String str) {
            this.text = str;
        }

        @d
        public final String getText() {
            return this.text;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/vector/util/Res$Android;", "", "()V", "getDimensionPixelSize", "", "id", "getIdentifier", "name", "", "type", "Lcom/vector/util/Res$Type;", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class a {
        @d
        public static final a a = new a();

        private a() {
        }

        public final int a(@DimenRes int i2) {
            if (i2 != 0) {
                return f.a.e().getDimensionPixelSize(i2);
            }
            return 0;
        }

        public final int getIdentifier(@d String str, @d Type type) {
            return f.a.e().getIdentifier(str, type.getText(), Constants.ANDROID);
        }
    }

    private Res() {
    }

    private final Context a(Context context) {
        return context == null ? e.t.a.b() : context;
    }

    public static /* synthetic */ Bitmap f(Res res, Context context, int i2, Bitmap.Config config, BitmapFactory.Options options, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        if ((i3 & 8) != 0) {
            options = null;
        }
        return res.c(context, i2, config, options);
    }

    public static /* synthetic */ Bitmap g(Res res, String str, Bitmap.Config config, BitmapFactory.Options options, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        if ((i2 & 4) != 0) {
            options = null;
        }
        return res.d(str, config, options);
    }

    public static /* synthetic */ Bitmap h(Res res, byte[] bArr, Bitmap.Config config, BitmapFactory.Options options, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        if ((i2 & 4) != 0) {
            options = null;
        }
        return res.e(bArr, config, options);
    }

    @k
    public static final int k(@ColorRes int i2) {
        return ContextCompat.getColor(e.t.a.b(), i2);
    }

    public static /* synthetic */ Drawable q(Res res, int i2, Context context, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            context = e.t.a.b();
        }
        return res.o(i2, context);
    }

    public static /* synthetic */ String w(Res res, int i2, Context context, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            context = e.t.a.b();
        }
        return res.u(i2, context);
    }

    public static /* synthetic */ String[] y(Res res, int i2, Context context, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            context = e.t.a.b();
        }
        return res.x(i2, context);
    }

    @d
    public final Animation b(@AnimRes int i2) throws Resources.NotFoundException {
        return AnimationUtils.loadAnimation(e.t.a.b(), i2);
    }

    @e
    public final Bitmap c(@d Context context, @DrawableRes int i2, @d Bitmap.Config config, @e BitmapFactory.Options options) {
        if (options == null) {
            options = new BitmapFactory.Options();
        }
        options.inPreferredConfig = config;
        return BitmapFactory.decodeResource(context.getResources(), i2, options);
    }

    @e
    public final Bitmap d(@d String str, @d Bitmap.Config config, @e BitmapFactory.Options options) {
        if (options == null) {
            options = new BitmapFactory.Options();
        }
        options.inPreferredConfig = config;
        return BitmapFactory.decodeFile(str, options);
    }

    @e
    public final Bitmap e(@d byte[] bArr, @d Bitmap.Config config, @e BitmapFactory.Options options) {
        if (options == null) {
            options = new BitmapFactory.Options();
        }
        options.inPreferredConfig = config;
        return BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
    }

    public final int getIdentifier(@d String str, @d Type type) {
        return e.t.a.b().getResources().getIdentifier(str, type.getText(), e.t.a.b().getPackageName());
    }

    @d
    public final BitmapFactory.Options i(@d Context context, @DrawableRes int i2) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(context.getResources(), i2, options);
        return options;
    }

    @d
    public final BitmapFactory.Options j(@d String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        return options;
    }

    @e
    public final ColorStateList l(@ColorRes int i2) {
        return ContextCompat.getColorStateList(e.t.a.b(), i2);
    }

    public final float m(@e Context context, @DimenRes int i2) {
        return a(context).getResources().getDimension(i2);
    }

    public final int n(@e Context context, @DimenRes int i2) {
        if (i2 != 0) {
            return a(context).getResources().getDimensionPixelSize(i2);
        }
        return 0;
    }

    @e
    public final Drawable o(@DrawableRes int i2, @d Context context) {
        if (i2 == 0) {
            return null;
        }
        return AppCompatResources.getDrawable(context, i2);
    }

    @e
    public final Drawable p(@d Context context, @DrawableRes int i2) {
        if (i2 == 0) {
            return null;
        }
        return AppCompatResources.getDrawable(context, i2);
    }

    public final int r(@IntegerRes int i2) {
        return e.t.a.b().getResources().getInteger(i2);
    }

    @e
    public final NinePatch s(@d Context context, @DrawableRes int i2) {
        Bitmap f2 = f(this, context, i2, null, null, 12, null);
        if (f2 == null) {
            return null;
        }
        return new NinePatch(f2, f2.getNinePatchChunk(), null);
    }

    @d
    public final InputStream t(@RawRes int i2) {
        return e.t.a.b().getResources().openRawResource(i2);
    }

    @d
    public final String u(@StringRes int i2, @d Context context) {
        return context.getString(i2);
    }

    @d
    public final String v(@StringRes int i2, @d Object... objArr) {
        return e.t.a.b().getString(i2, Arrays.copyOf(objArr, objArr.length));
    }

    @d
    public final String[] x(@ArrayRes int i2, @d Context context) {
        return context.getResources().getStringArray(i2);
    }

    @e
    public final VectorDrawableCompat z(@d Context context, @DrawableRes int i2) {
        return VectorDrawableCompat.create(context.getResources(), i2, null);
    }
}
