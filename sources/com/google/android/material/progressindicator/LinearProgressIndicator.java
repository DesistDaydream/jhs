package com.google.android.material.progressindicator;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import e.j.a.c.v.e;
import e.j.a.c.v.i;
import e.j.a.c.v.k;
import e.j.a.c.v.l;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes2.dex */
public final class LinearProgressIndicator extends BaseProgressIndicator<LinearProgressIndicatorSpec> {
    public static final int A = 1;
    public static final int B = 0;
    public static final int C = 1;
    public static final int D = 2;
    public static final int E = 3;
    public static final int y = R.style.Widget_MaterialComponents_LinearProgressIndicator;
    public static final int z = 0;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes2.dex */
    public @interface a {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes2.dex */
    public @interface b {
    }

    public LinearProgressIndicator(@NonNull Context context) {
        this(context, null);
    }

    private void u() {
        setIndeterminateDrawable(i.v(getContext(), (LinearProgressIndicatorSpec) this.a));
        setProgressDrawable(e.x(getContext(), (LinearProgressIndicatorSpec) this.a));
    }

    public int getIndeterminateAnimationType() {
        return ((LinearProgressIndicatorSpec) this.a).f3016g;
    }

    public int getIndicatorDirection() {
        return ((LinearProgressIndicatorSpec) this.a).f3017h;
    }

    @Override // android.view.View
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        S s = this.a;
        LinearProgressIndicatorSpec linearProgressIndicatorSpec = (LinearProgressIndicatorSpec) s;
        boolean z3 = true;
        if (((LinearProgressIndicatorSpec) s).f3017h != 1 && ((ViewCompat.getLayoutDirection(this) != 1 || ((LinearProgressIndicatorSpec) this.a).f3017h != 2) && (ViewCompat.getLayoutDirection(this) != 0 || ((LinearProgressIndicatorSpec) this.a).f3017h != 3))) {
            z3 = false;
        }
        linearProgressIndicatorSpec.f3018i = z3;
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        int paddingLeft = i2 - (getPaddingLeft() + getPaddingRight());
        int paddingTop = i3 - (getPaddingTop() + getPaddingBottom());
        i<LinearProgressIndicatorSpec> indeterminateDrawable = getIndeterminateDrawable();
        if (indeterminateDrawable != null) {
            indeterminateDrawable.setBounds(0, 0, paddingLeft, paddingTop);
        }
        e<LinearProgressIndicatorSpec> progressDrawable = getProgressDrawable();
        if (progressDrawable != null) {
            progressDrawable.setBounds(0, 0, paddingLeft, paddingTop);
        }
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void p(int i2, boolean z2) {
        S s = this.a;
        if (s != 0 && ((LinearProgressIndicatorSpec) s).f3016g == 0 && isIndeterminate()) {
            return;
        }
        super.p(i2, z2);
    }

    public void setIndeterminateAnimationType(int i2) {
        if (((LinearProgressIndicatorSpec) this.a).f3016g == i2) {
            return;
        }
        if (s() && isIndeterminate()) {
            throw new IllegalStateException("Cannot change indeterminate animation type while the progress indicator is show in indeterminate mode.");
        }
        S s = this.a;
        ((LinearProgressIndicatorSpec) s).f3016g = i2;
        ((LinearProgressIndicatorSpec) s).e();
        if (i2 == 0) {
            getIndeterminateDrawable().y(new k((LinearProgressIndicatorSpec) this.a));
        } else {
            getIndeterminateDrawable().y(new l(getContext(), (LinearProgressIndicatorSpec) this.a));
        }
        invalidate();
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setIndicatorColor(@NonNull int... iArr) {
        super.setIndicatorColor(iArr);
        ((LinearProgressIndicatorSpec) this.a).e();
    }

    public void setIndicatorDirection(int i2) {
        S s = this.a;
        ((LinearProgressIndicatorSpec) s).f3017h = i2;
        LinearProgressIndicatorSpec linearProgressIndicatorSpec = (LinearProgressIndicatorSpec) s;
        boolean z2 = true;
        if (i2 != 1 && ((ViewCompat.getLayoutDirection(this) != 1 || ((LinearProgressIndicatorSpec) this.a).f3017h != 2) && (ViewCompat.getLayoutDirection(this) != 0 || i2 != 3))) {
            z2 = false;
        }
        linearProgressIndicatorSpec.f3018i = z2;
        invalidate();
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setTrackCornerRadius(int i2) {
        super.setTrackCornerRadius(i2);
        ((LinearProgressIndicatorSpec) this.a).e();
        invalidate();
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    /* renamed from: t */
    public LinearProgressIndicatorSpec i(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        return new LinearProgressIndicatorSpec(context, attributeSet);
    }

    public LinearProgressIndicator(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.linearProgressIndicatorStyle);
    }

    public LinearProgressIndicator(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2) {
        super(context, attributeSet, i2, y);
        u();
    }
}
