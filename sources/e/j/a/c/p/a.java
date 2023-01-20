package e.j.a.c.p;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.R;
import e.j.a.c.s.t;
import e.j.a.c.w.b;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: e  reason: collision with root package name */
    private static final float f10924e = 4.5f;

    /* renamed from: f  reason: collision with root package name */
    private static final float f10925f = 2.0f;
    private final boolean a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final int f10926c;

    /* renamed from: d  reason: collision with root package name */
    private final float f10927d;

    public a(@NonNull Context context) {
        this.a = b.b(context, R.attr.elevationOverlayEnabled, false);
        this.b = e.j.a.c.l.a.b(context, R.attr.elevationOverlayColor, 0);
        this.f10926c = e.j.a.c.l.a.b(context, R.attr.colorSurface, 0);
        this.f10927d = context.getResources().getDisplayMetrics().density;
    }

    private boolean m(@ColorInt int i2) {
        return ColorUtils.setAlphaComponent(i2, 255) == this.f10926c;
    }

    public int a(float f2) {
        return Math.round(b(f2) * 255.0f);
    }

    public float b(float f2) {
        float f3 = this.f10927d;
        if (f3 <= 0.0f || f2 <= 0.0f) {
            return 0.0f;
        }
        return Math.min(((((float) Math.log1p(f2 / f3)) * 4.5f) + 2.0f) / 100.0f, 1.0f);
    }

    @ColorInt
    public int c(@ColorInt int i2, float f2) {
        float b = b(f2);
        return ColorUtils.setAlphaComponent(e.j.a.c.l.a.h(ColorUtils.setAlphaComponent(i2, 255), this.b, b), Color.alpha(i2));
    }

    @ColorInt
    public int d(@ColorInt int i2, float f2, @NonNull View view) {
        return c(i2, f2 + i(view));
    }

    @ColorInt
    public int e(@ColorInt int i2, float f2) {
        return (this.a && m(i2)) ? c(i2, f2) : i2;
    }

    @ColorInt
    public int f(@ColorInt int i2, float f2, @NonNull View view) {
        return e(i2, f2 + i(view));
    }

    @ColorInt
    public int g(float f2) {
        return e(this.f10926c, f2);
    }

    @ColorInt
    public int h(float f2, @NonNull View view) {
        return g(f2 + i(view));
    }

    public float i(@NonNull View view) {
        return t.i(view);
    }

    @ColorInt
    public int j() {
        return this.b;
    }

    @ColorInt
    public int k() {
        return this.f10926c;
    }

    public boolean l() {
        return this.a;
    }
}
