package com.google.android.material.card;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.cardview.widget.CardView;
import com.google.android.material.R;
import e.j.a.c.z.k;
import e.j.a.c.z.o;
import e.j.a.c.z.s;

/* loaded from: classes2.dex */
public class MaterialCardView extends CardView implements Checkable, s {

    /* renamed from: f */
    private static final int[] f2828f = {16842911};

    /* renamed from: g */
    private static final int[] f2829g = {16842912};

    /* renamed from: h */
    private static final int[] f2830h = {R.attr.state_dragged};

    /* renamed from: i */
    private static final int f2831i = R.style.Widget_MaterialComponents_CardView;

    /* renamed from: j */
    private static final String f2832j = "MaterialCardView";

    /* renamed from: k */
    private static final String f2833k = "androidx.cardview.widget.CardView";
    @NonNull
    private final e.j.a.c.i.a a;
    private boolean b;

    /* renamed from: c */
    private boolean f2834c;

    /* renamed from: d */
    private boolean f2835d;

    /* renamed from: e */
    private a f2836e;

    /* loaded from: classes2.dex */
    public interface a {
        void a(MaterialCardView materialCardView, boolean z);
    }

    public MaterialCardView(Context context) {
        this(context, null);
    }

    private void f() {
        if (Build.VERSION.SDK_INT > 26) {
            this.a.j();
        }
    }

    @NonNull
    private RectF getBoundsAsRectF() {
        RectF rectF = new RectF();
        rectF.set(this.a.k().getBounds());
        return rectF;
    }

    public boolean g() {
        e.j.a.c.i.a aVar = this.a;
        return aVar != null && aVar.D();
    }

    @Override // androidx.cardview.widget.CardView
    @NonNull
    public ColorStateList getCardBackgroundColor() {
        return this.a.l();
    }

    @NonNull
    public ColorStateList getCardForegroundColor() {
        return this.a.m();
    }

    public float getCardViewRadius() {
        return super.getRadius();
    }

    @Nullable
    public Drawable getCheckedIcon() {
        return this.a.n();
    }

    @Dimension
    public int getCheckedIconMargin() {
        return this.a.o();
    }

    @Dimension
    public int getCheckedIconSize() {
        return this.a.p();
    }

    @Nullable
    public ColorStateList getCheckedIconTint() {
        return this.a.q();
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingBottom() {
        return this.a.A().bottom;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingLeft() {
        return this.a.A().left;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingRight() {
        return this.a.A().right;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingTop() {
        return this.a.A().top;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getProgress() {
        return this.a.u();
    }

    @Override // androidx.cardview.widget.CardView
    public float getRadius() {
        return this.a.s();
    }

    public ColorStateList getRippleColor() {
        return this.a.v();
    }

    @Override // e.j.a.c.z.s
    @NonNull
    public o getShapeAppearanceModel() {
        return this.a.w();
    }

    @ColorInt
    @Deprecated
    public int getStrokeColor() {
        return this.a.x();
    }

    @Nullable
    public ColorStateList getStrokeColorStateList() {
        return this.a.y();
    }

    @Dimension
    public int getStrokeWidth() {
        return this.a.z();
    }

    public boolean h() {
        return this.f2835d;
    }

    public void i(int i2, int i3, int i4, int i5) {
        super.setContentPadding(i2, i3, i4, i5);
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f2834c;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        k.f(this, this.a.k());
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 3);
        if (g()) {
            FrameLayout.mergeDrawableStates(onCreateDrawableState, f2828f);
        }
        if (isChecked()) {
            FrameLayout.mergeDrawableStates(onCreateDrawableState, f2829g);
        }
        if (h()) {
            FrameLayout.mergeDrawableStates(onCreateDrawableState, f2830h);
        }
        return onCreateDrawableState;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(f2833k);
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(f2833k);
        accessibilityNodeInfo.setCheckable(g());
        accessibilityNodeInfo.setClickable(isClickable());
        accessibilityNodeInfo.setChecked(isChecked());
    }

    @Override // androidx.cardview.widget.CardView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.a.F(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (this.b) {
            if (!this.a.C()) {
                Log.i(f2832j, "Setting a custom background is not supported.");
                this.a.G(true);
            }
            super.setBackgroundDrawable(drawable);
        }
    }

    public void setBackgroundInternal(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(@ColorInt int i2) {
        this.a.H(ColorStateList.valueOf(i2));
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardElevation(float f2) {
        super.setCardElevation(f2);
        this.a.Z();
    }

    public void setCardForegroundColor(@Nullable ColorStateList colorStateList) {
        this.a.I(colorStateList);
    }

    public void setCheckable(boolean z) {
        this.a.J(z);
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (this.f2834c != z) {
            toggle();
        }
    }

    public void setCheckedIcon(@Nullable Drawable drawable) {
        this.a.K(drawable);
    }

    public void setCheckedIconMargin(@Dimension int i2) {
        this.a.L(i2);
    }

    public void setCheckedIconMarginResource(@DimenRes int i2) {
        if (i2 != -1) {
            this.a.L(getResources().getDimensionPixelSize(i2));
        }
    }

    public void setCheckedIconResource(@DrawableRes int i2) {
        this.a.K(AppCompatResources.getDrawable(getContext(), i2));
    }

    public void setCheckedIconSize(@Dimension int i2) {
        this.a.M(i2);
    }

    public void setCheckedIconSizeResource(@DimenRes int i2) {
        if (i2 != 0) {
            this.a.M(getResources().getDimensionPixelSize(i2));
        }
    }

    public void setCheckedIconTint(@Nullable ColorStateList colorStateList) {
        this.a.N(colorStateList);
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        super.setClickable(z);
        e.j.a.c.i.a aVar = this.a;
        if (aVar != null) {
            aVar.X();
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setContentPadding(int i2, int i3, int i4, int i5) {
        this.a.U(i2, i3, i4, i5);
    }

    public void setDragged(boolean z) {
        if (this.f2835d != z) {
            this.f2835d = z;
            refreshDrawableState();
            f();
            invalidate();
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setMaxCardElevation(float f2) {
        super.setMaxCardElevation(f2);
        this.a.b0();
    }

    public void setOnCheckedChangeListener(@Nullable a aVar) {
        this.f2836e = aVar;
    }

    @Override // androidx.cardview.widget.CardView
    public void setPreventCornerOverlap(boolean z) {
        super.setPreventCornerOverlap(z);
        this.a.b0();
        this.a.Y();
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.a.P(f2);
    }

    @Override // androidx.cardview.widget.CardView
    public void setRadius(float f2) {
        super.setRadius(f2);
        this.a.O(f2);
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        this.a.Q(colorStateList);
    }

    public void setRippleColorResource(@ColorRes int i2) {
        this.a.Q(AppCompatResources.getColorStateList(getContext(), i2));
    }

    @Override // e.j.a.c.z.s
    public void setShapeAppearanceModel(@NonNull o oVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            setClipToOutline(oVar.u(getBoundsAsRectF()));
        }
        this.a.R(oVar);
    }

    public void setStrokeColor(@ColorInt int i2) {
        this.a.S(ColorStateList.valueOf(i2));
    }

    public void setStrokeWidth(@Dimension int i2) {
        this.a.T(i2);
    }

    @Override // androidx.cardview.widget.CardView
    public void setUseCompatPadding(boolean z) {
        super.setUseCompatPadding(z);
        this.a.b0();
        this.a.Y();
    }

    @Override // android.widget.Checkable
    public void toggle() {
        if (g() && isEnabled()) {
            this.f2834c = !this.f2834c;
            refreshDrawableState();
            f();
            a aVar = this.f2836e;
            if (aVar != null) {
                aVar.a(this, this.f2834c);
            }
        }
    }

    public MaterialCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialCardViewStyle);
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(@Nullable ColorStateList colorStateList) {
        this.a.H(colorStateList);
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        this.a.S(colorStateList);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public MaterialCardView(android.content.Context r8, android.util.AttributeSet r9, int r10) {
        /*
            r7 = this;
            int r6 = com.google.android.material.card.MaterialCardView.f2831i
            android.content.Context r8 = e.j.a.c.e0.a.a.c(r8, r9, r10, r6)
            r7.<init>(r8, r9, r10)
            r8 = 0
            r7.f2834c = r8
            r7.f2835d = r8
            r0 = 1
            r7.b = r0
            android.content.Context r0 = r7.getContext()
            int[] r2 = com.google.android.material.R.styleable.MaterialCardView
            int[] r5 = new int[r8]
            r1 = r9
            r3 = r10
            r4 = r6
            android.content.res.TypedArray r8 = e.j.a.c.s.m.j(r0, r1, r2, r3, r4, r5)
            e.j.a.c.i.a r0 = new e.j.a.c.i.a
            r0.<init>(r7, r9, r10, r6)
            r7.a = r0
            android.content.res.ColorStateList r9 = super.getCardBackgroundColor()
            r0.H(r9)
            int r9 = super.getContentPaddingLeft()
            int r10 = super.getContentPaddingTop()
            int r1 = super.getContentPaddingRight()
            int r2 = super.getContentPaddingBottom()
            r0.U(r9, r10, r1, r2)
            r0.E(r8)
            r8.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.card.MaterialCardView.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
