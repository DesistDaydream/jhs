package e.j.a.c.l;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.core.graphics.ColorUtils;
import e.j.a.c.w.b;

/* loaded from: classes2.dex */
public class a {
    public static final float a = 1.0f;
    public static final float b = 0.54f;

    /* renamed from: c  reason: collision with root package name */
    public static final float f10869c = 0.38f;

    /* renamed from: d  reason: collision with root package name */
    public static final float f10870d = 0.32f;

    /* renamed from: e  reason: collision with root package name */
    public static final float f10871e = 0.12f;

    private a() {
    }

    @ColorInt
    public static int a(@ColorInt int i2, @IntRange(from = 0, to = 255) int i3) {
        return ColorUtils.setAlphaComponent(i2, (Color.alpha(i2) * i3) / 255);
    }

    @ColorInt
    public static int b(@NonNull Context context, @AttrRes int i2, @ColorInt int i3) {
        TypedValue a2 = b.a(context, i2);
        return a2 != null ? a2.data : i3;
    }

    @ColorInt
    public static int c(Context context, @AttrRes int i2, String str) {
        return b.g(context, i2, str);
    }

    @ColorInt
    public static int d(@NonNull View view, @AttrRes int i2) {
        return b.h(view, i2);
    }

    @ColorInt
    public static int e(@NonNull View view, @AttrRes int i2, @ColorInt int i3) {
        return b(view.getContext(), i2, i3);
    }

    public static boolean f(@ColorInt int i2) {
        return i2 != 0 && ColorUtils.calculateLuminance(i2) > 0.5d;
    }

    @ColorInt
    public static int g(@ColorInt int i2, @ColorInt int i3) {
        return ColorUtils.compositeColors(i3, i2);
    }

    @ColorInt
    public static int h(@ColorInt int i2, @ColorInt int i3, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        return g(i2, ColorUtils.setAlphaComponent(i3, Math.round(Color.alpha(i3) * f2)));
    }

    @ColorInt
    public static int i(@NonNull View view, @AttrRes int i2, @AttrRes int i3) {
        return j(view, i2, i3, 1.0f);
    }

    @ColorInt
    public static int j(@NonNull View view, @AttrRes int i2, @AttrRes int i3, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        return h(d(view, i2), d(view, i3), f2);
    }
}
