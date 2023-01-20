package com.google.android.material.progressindicator;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import com.google.android.material.R;
import e.j.a.c.v.e;
import e.j.a.c.v.i;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes2.dex */
public final class CircularProgressIndicator extends BaseProgressIndicator<CircularProgressIndicatorSpec> {
    public static final int A = 1;
    public static final int y = R.style.Widget_MaterialComponents_CircularProgressIndicator;
    public static final int z = 0;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes2.dex */
    public @interface a {
    }

    public CircularProgressIndicator(@NonNull Context context) {
        this(context, null);
    }

    private void u() {
        setIndeterminateDrawable(i.u(getContext(), (CircularProgressIndicatorSpec) this.a));
        setProgressDrawable(e.w(getContext(), (CircularProgressIndicatorSpec) this.a));
    }

    public int getIndicatorDirection() {
        return ((CircularProgressIndicatorSpec) this.a).f3015i;
    }

    @Px
    public int getIndicatorInset() {
        return ((CircularProgressIndicatorSpec) this.a).f3014h;
    }

    @Px
    public int getIndicatorSize() {
        return ((CircularProgressIndicatorSpec) this.a).f3013g;
    }

    public void setIndicatorDirection(int i2) {
        ((CircularProgressIndicatorSpec) this.a).f3015i = i2;
        invalidate();
    }

    public void setIndicatorInset(@Px int i2) {
        S s = this.a;
        if (((CircularProgressIndicatorSpec) s).f3014h != i2) {
            ((CircularProgressIndicatorSpec) s).f3014h = i2;
            invalidate();
        }
    }

    public void setIndicatorSize(@Px int i2) {
        int max = Math.max(i2, getTrackThickness() * 2);
        S s = this.a;
        if (((CircularProgressIndicatorSpec) s).f3013g != max) {
            ((CircularProgressIndicatorSpec) s).f3013g = max;
            ((CircularProgressIndicatorSpec) s).e();
            invalidate();
        }
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setTrackThickness(int i2) {
        super.setTrackThickness(i2);
        ((CircularProgressIndicatorSpec) this.a).e();
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    /* renamed from: t */
    public CircularProgressIndicatorSpec i(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        return new CircularProgressIndicatorSpec(context, attributeSet);
    }

    public CircularProgressIndicator(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.circularProgressIndicatorStyle);
    }

    public CircularProgressIndicator(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2) {
        super(context, attributeSet, i2, y);
        u();
    }
}
