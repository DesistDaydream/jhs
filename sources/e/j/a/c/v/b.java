package e.j.a.c.v;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.StyleRes;
import com.google.android.material.R;
import e.j.a.c.s.m;

/* loaded from: classes2.dex */
public abstract class b {
    @Px
    public int a;
    @Px
    public int b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public int[] f11008c = new int[0];
    @ColorInt

    /* renamed from: d  reason: collision with root package name */
    public int f11009d;

    /* renamed from: e  reason: collision with root package name */
    public int f11010e;

    /* renamed from: f  reason: collision with root package name */
    public int f11011f;

    public b(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.mtrl_progress_track_thickness);
        TypedArray j2 = m.j(context, attributeSet, R.styleable.BaseProgressIndicator, i2, i3, new int[0]);
        this.a = e.j.a.c.w.c.c(context, j2, R.styleable.BaseProgressIndicator_trackThickness, dimensionPixelSize);
        this.b = Math.min(e.j.a.c.w.c.c(context, j2, R.styleable.BaseProgressIndicator_trackCornerRadius, 0), this.a / 2);
        this.f11010e = j2.getInt(R.styleable.BaseProgressIndicator_showAnimationBehavior, 0);
        this.f11011f = j2.getInt(R.styleable.BaseProgressIndicator_hideAnimationBehavior, 0);
        c(context, j2);
        d(context, j2);
        j2.recycle();
    }

    private void c(@NonNull Context context, @NonNull TypedArray typedArray) {
        int i2 = R.styleable.BaseProgressIndicator_indicatorColor;
        if (!typedArray.hasValue(i2)) {
            this.f11008c = new int[]{e.j.a.c.l.a.b(context, R.attr.colorPrimary, -1)};
        } else if (typedArray.peekValue(i2).type != 1) {
            this.f11008c = new int[]{typedArray.getColor(i2, -1)};
        } else {
            int[] intArray = context.getResources().getIntArray(typedArray.getResourceId(i2, -1));
            this.f11008c = intArray;
            if (intArray.length == 0) {
                throw new IllegalArgumentException("indicatorColors cannot be empty when indicatorColor is not used.");
            }
        }
    }

    private void d(@NonNull Context context, @NonNull TypedArray typedArray) {
        int i2 = R.styleable.BaseProgressIndicator_trackColor;
        if (typedArray.hasValue(i2)) {
            this.f11009d = typedArray.getColor(i2, -1);
            return;
        }
        this.f11009d = this.f11008c[0];
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{16842803});
        float f2 = obtainStyledAttributes.getFloat(0, 0.2f);
        obtainStyledAttributes.recycle();
        this.f11009d = e.j.a.c.l.a.a(this.f11009d, (int) (f2 * 255.0f));
    }

    public boolean a() {
        return this.f11011f != 0;
    }

    public boolean b() {
        return this.f11010e != 0;
    }

    public abstract void e();
}
