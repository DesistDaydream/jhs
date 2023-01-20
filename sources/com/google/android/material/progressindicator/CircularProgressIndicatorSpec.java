package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.StyleRes;
import com.google.android.material.R;
import e.j.a.c.s.m;
import e.j.a.c.v.b;
import e.j.a.c.w.c;

/* loaded from: classes2.dex */
public final class CircularProgressIndicatorSpec extends b {
    @Px

    /* renamed from: g  reason: collision with root package name */
    public int f3013g;
    @Px

    /* renamed from: h  reason: collision with root package name */
    public int f3014h;

    /* renamed from: i  reason: collision with root package name */
    public int f3015i;

    public CircularProgressIndicatorSpec(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.circularProgressIndicatorStyle);
    }

    @Override // e.j.a.c.v.b
    public void e() {
    }

    public CircularProgressIndicatorSpec(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2) {
        this(context, attributeSet, i2, CircularProgressIndicator.y);
    }

    public CircularProgressIndicatorSpec(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        super(context, attributeSet, i2, i3);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.mtrl_progress_circular_size_medium);
        int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(R.dimen.mtrl_progress_circular_inset_medium);
        TypedArray j2 = m.j(context, attributeSet, R.styleable.CircularProgressIndicator, i2, i3, new int[0]);
        this.f3013g = Math.max(c.c(context, j2, R.styleable.CircularProgressIndicator_indicatorSize, dimensionPixelSize), this.a * 2);
        this.f3014h = c.c(context, j2, R.styleable.CircularProgressIndicator_indicatorInset, dimensionPixelSize2);
        this.f3015i = j2.getInt(R.styleable.CircularProgressIndicator_indicatorDirectionCircular, 0);
        j2.recycle();
        e();
    }
}
