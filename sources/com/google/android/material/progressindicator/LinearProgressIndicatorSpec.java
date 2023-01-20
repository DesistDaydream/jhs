package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import com.google.android.material.R;
import e.j.a.c.s.m;
import e.j.a.c.v.b;

/* loaded from: classes2.dex */
public final class LinearProgressIndicatorSpec extends b {

    /* renamed from: g  reason: collision with root package name */
    public int f3016g;

    /* renamed from: h  reason: collision with root package name */
    public int f3017h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f3018i;

    public LinearProgressIndicatorSpec(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.linearProgressIndicatorStyle);
    }

    @Override // e.j.a.c.v.b
    public void e() {
        if (this.f3016g == 0) {
            if (this.b <= 0) {
                if (this.f11008c.length < 3) {
                    throw new IllegalArgumentException("Contiguous indeterminate animation must be used with 3 or more indicator colors.");
                }
                return;
            }
            throw new IllegalArgumentException("Rounded corners are not supported in contiguous indeterminate animation.");
        }
    }

    public LinearProgressIndicatorSpec(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2) {
        this(context, attributeSet, i2, LinearProgressIndicator.y);
    }

    public LinearProgressIndicatorSpec(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        super(context, attributeSet, i2, i3);
        TypedArray j2 = m.j(context, attributeSet, R.styleable.LinearProgressIndicator, R.attr.linearProgressIndicatorStyle, LinearProgressIndicator.y, new int[0]);
        this.f3016g = j2.getInt(R.styleable.LinearProgressIndicator_indeterminateAnimationType, 1);
        this.f3017h = j2.getInt(R.styleable.LinearProgressIndicator_indicatorDirectionLinear, 0);
        j2.recycle();
        e();
        this.f3018i = this.f3017h == 1;
    }
}
