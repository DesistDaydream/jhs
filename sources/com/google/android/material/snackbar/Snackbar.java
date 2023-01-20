package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R;
import com.google.android.material.snackbar.BaseTransientBottomBar;

/* loaded from: classes2.dex */
public class Snackbar extends BaseTransientBottomBar<Snackbar> {
    private static final int[] N;
    private static final int[] O;
    @Nullable
    private final AccessibilityManager K;
    private boolean L;
    @Nullable
    private BaseTransientBottomBar.t<Snackbar> M;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes2.dex */
    public static final class SnackbarLayout extends BaseTransientBottomBar.SnackbarBaseLayout {
        public SnackbarLayout(Context context) {
            super(context);
        }

        @Override // android.widget.FrameLayout, android.view.View
        public void onMeasure(int i2, int i3) {
            super.onMeasure(i2, i3);
            int childCount = getChildCount();
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (childAt.getLayoutParams().width == -1) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(childAt.getMeasuredHeight(), 1073741824));
                }
            }
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackground(@Nullable Drawable drawable) {
            super.setBackground(drawable);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundDrawable(@Nullable Drawable drawable) {
            super.setBackgroundDrawable(drawable);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
            super.setBackgroundTintList(colorStateList);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
            super.setBackgroundTintMode(mode);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
            super.setOnClickListener(onClickListener);
        }

        public SnackbarLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public final /* synthetic */ View.OnClickListener a;

        public a(View.OnClickListener onClickListener) {
            this.a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.a.onClick(view);
            Snackbar.this.x(1);
        }
    }

    /* loaded from: classes2.dex */
    public static class b extends BaseTransientBottomBar.t<Snackbar> {

        /* renamed from: f  reason: collision with root package name */
        public static final int f3054f = 0;

        /* renamed from: g  reason: collision with root package name */
        public static final int f3055g = 1;

        /* renamed from: h  reason: collision with root package name */
        public static final int f3056h = 2;

        /* renamed from: i  reason: collision with root package name */
        public static final int f3057i = 3;

        /* renamed from: j  reason: collision with root package name */
        public static final int f3058j = 4;

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.t
        /* renamed from: c */
        public void a(Snackbar snackbar, int i2) {
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.t
        /* renamed from: d */
        public void b(Snackbar snackbar) {
        }
    }

    static {
        int i2 = R.attr.snackbarButtonStyle;
        N = new int[]{i2};
        O = new int[]{i2, R.attr.snackbarTextViewStyle};
    }

    private Snackbar(@NonNull Context context, @NonNull ViewGroup viewGroup, @NonNull View view, @NonNull e.j.a.c.b0.a aVar) {
        super(context, viewGroup, view, aVar);
        this.K = (AccessibilityManager) viewGroup.getContext().getSystemService("accessibility");
    }

    @Nullable
    private static ViewGroup m0(View view) {
        ViewGroup viewGroup = null;
        while (!(view instanceof CoordinatorLayout)) {
            if (view instanceof FrameLayout) {
                if (view.getId() == 16908290) {
                    return (ViewGroup) view;
                }
                viewGroup = (ViewGroup) view;
            }
            if (view != null) {
                ViewParent parent = view.getParent();
                if (parent instanceof View) {
                    view = (View) parent;
                    continue;
                } else {
                    view = null;
                    continue;
                }
            }
            if (view == null) {
                return viewGroup;
            }
        }
        return (ViewGroup) view;
    }

    @Deprecated
    public static boolean n0(@NonNull Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(N);
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
        return resourceId != -1;
    }

    private static boolean o0(@NonNull Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(O);
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        int resourceId2 = obtainStyledAttributes.getResourceId(1, -1);
        obtainStyledAttributes.recycle();
        return (resourceId == -1 || resourceId2 == -1) ? false : true;
    }

    @NonNull
    public static Snackbar p0(@NonNull Context context, @NonNull View view, @NonNull CharSequence charSequence, int i2) {
        return s0(context, view, charSequence, i2);
    }

    @NonNull
    public static Snackbar q0(@NonNull View view, @StringRes int i2, int i3) {
        return r0(view, view.getResources().getText(i2), i3);
    }

    @NonNull
    public static Snackbar r0(@NonNull View view, @NonNull CharSequence charSequence, int i2) {
        return s0(null, view, charSequence, i2);
    }

    @NonNull
    private static Snackbar s0(@Nullable Context context, @NonNull View view, @NonNull CharSequence charSequence, int i2) {
        ViewGroup m0 = m0(view);
        if (m0 != null) {
            if (context == null) {
                context = m0.getContext();
            }
            SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) LayoutInflater.from(context).inflate(o0(context) ? R.layout.mtrl_layout_snackbar_include : R.layout.design_layout_snackbar_include, m0, false);
            Snackbar snackbar = new Snackbar(context, m0, snackbarContentLayout, snackbarContentLayout);
            snackbar.D0(charSequence);
            snackbar.Z(i2);
            return snackbar;
        }
        throw new IllegalArgumentException("No suitable parent found from the given view. Please provide a valid view.");
    }

    @NonNull
    @Deprecated
    public Snackbar A0(@Nullable b bVar) {
        BaseTransientBottomBar.t<Snackbar> tVar = this.M;
        if (tVar != null) {
            T(tVar);
        }
        if (bVar != null) {
            s(bVar);
        }
        this.M = bVar;
        return this;
    }

    @NonNull
    public Snackbar B0(@Dimension int i2) {
        ((SnackbarContentLayout) this.f3033c.getChildAt(0)).setMaxInlineActionWidth(i2);
        return this;
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public int C() {
        int C = super.C();
        if (C == -2) {
            return -2;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return this.K.getRecommendedTimeoutMillis(C, (this.L ? 4 : 0) | 1 | 2);
        } else if (this.L && this.K.isTouchExplorationEnabled()) {
            return -2;
        } else {
            return C;
        }
    }

    @NonNull
    public Snackbar C0(@StringRes int i2) {
        return D0(getContext().getText(i2));
    }

    @NonNull
    public Snackbar D0(@NonNull CharSequence charSequence) {
        ((SnackbarContentLayout) this.f3033c.getChildAt(0)).getMessageView().setText(charSequence);
        return this;
    }

    @NonNull
    public Snackbar E0(@ColorInt int i2) {
        ((SnackbarContentLayout) this.f3033c.getChildAt(0)).getMessageView().setTextColor(i2);
        return this;
    }

    @NonNull
    public Snackbar F0(ColorStateList colorStateList) {
        ((SnackbarContentLayout) this.f3033c.getChildAt(0)).getMessageView().setTextColor(colorStateList);
        return this;
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public boolean O() {
        return super.O();
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public void e0() {
        super.e0();
    }

    @NonNull
    public Snackbar t0(@StringRes int i2, View.OnClickListener onClickListener) {
        return u0(getContext().getText(i2), onClickListener);
    }

    @NonNull
    public Snackbar u0(@Nullable CharSequence charSequence, @Nullable View.OnClickListener onClickListener) {
        Button actionView = ((SnackbarContentLayout) this.f3033c.getChildAt(0)).getActionView();
        if (!TextUtils.isEmpty(charSequence) && onClickListener != null) {
            this.L = true;
            actionView.setVisibility(0);
            actionView.setText(charSequence);
            actionView.setOnClickListener(new a(onClickListener));
        } else {
            actionView.setVisibility(8);
            actionView.setOnClickListener(null);
            this.L = false;
        }
        return this;
    }

    @NonNull
    public Snackbar v0(@ColorInt int i2) {
        ((SnackbarContentLayout) this.f3033c.getChildAt(0)).getActionView().setTextColor(i2);
        return this;
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public void w() {
        super.w();
    }

    @NonNull
    public Snackbar w0(ColorStateList colorStateList) {
        ((SnackbarContentLayout) this.f3033c.getChildAt(0)).getActionView().setTextColor(colorStateList);
        return this;
    }

    @NonNull
    public Snackbar x0(@ColorInt int i2) {
        return y0(ColorStateList.valueOf(i2));
    }

    @NonNull
    public Snackbar y0(@Nullable ColorStateList colorStateList) {
        this.f3033c.setBackgroundTintList(colorStateList);
        return this;
    }

    @NonNull
    public Snackbar z0(@Nullable PorterDuff.Mode mode) {
        this.f3033c.setBackgroundTintMode(mode);
        return this;
    }
}
