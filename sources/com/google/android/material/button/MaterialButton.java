package com.google.android.material.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import e.j.a.c.z.k;
import e.j.a.c.z.o;
import e.j.a.c.z.s;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* loaded from: classes2.dex */
public class MaterialButton extends AppCompatButton implements Checkable, s {
    public static final int p = 1;
    public static final int q = 2;
    public static final int r = 3;
    public static final int s = 4;
    public static final int t = 16;
    public static final int u = 32;
    private static final String v = "MaterialButton";
    @NonNull
    private final e.j.a.c.g.a a;
    @NonNull
    private final LinkedHashSet<b> b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private c f2804c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private PorterDuff.Mode f2805d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private ColorStateList f2806e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private Drawable f2807f;
    @Px

    /* renamed from: g  reason: collision with root package name */
    private int f2808g;
    @Px

    /* renamed from: h  reason: collision with root package name */
    private int f2809h;
    @Px

    /* renamed from: i  reason: collision with root package name */
    private int f2810i;
    @Px

    /* renamed from: j  reason: collision with root package name */
    private int f2811j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f2812k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f2813l;

    /* renamed from: m  reason: collision with root package name */
    private int f2814m;
    private static final int[] n = {16842911};
    private static final int[] o = {16842912};
    private static final int w = R.style.Widget_MaterialComponents_Button;

    /* loaded from: classes2.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public boolean checked;

        /* loaded from: classes2.dex */
        public static class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            @NonNull
            /* renamed from: a */
            public SavedState createFromParcel(@NonNull Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            @NonNull
            /* renamed from: b */
            public SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            /* renamed from: c */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private void readFromParcel(@NonNull Parcel parcel) {
            this.checked = parcel.readInt() == 1;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.checked ? 1 : 0);
        }

        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                getClass().getClassLoader();
            }
            readFromParcel(parcel);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface a {
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(MaterialButton materialButton, boolean z);
    }

    /* loaded from: classes2.dex */
    public interface c {
        void a(MaterialButton materialButton, boolean z);
    }

    public MaterialButton(@NonNull Context context) {
        this(context, null);
    }

    private boolean d() {
        int i2 = this.f2814m;
        return i2 == 3 || i2 == 4;
    }

    private boolean e() {
        int i2 = this.f2814m;
        return i2 == 1 || i2 == 2;
    }

    private boolean f() {
        int i2 = this.f2814m;
        return i2 == 16 || i2 == 32;
    }

    private boolean g() {
        return ViewCompat.getLayoutDirection(this) == 1;
    }

    @NonNull
    private String getA11yClassName() {
        return (c() ? CompoundButton.class : Button.class).getName();
    }

    private int getTextHeight() {
        TextPaint paint = getPaint();
        String charSequence = getText().toString();
        if (getTransformationMethod() != null) {
            charSequence = getTransformationMethod().getTransformation(charSequence, this).toString();
        }
        Rect rect = new Rect();
        paint.getTextBounds(charSequence, 0, charSequence.length(), rect);
        return Math.min(rect.height(), getLayout().getHeight());
    }

    private int getTextWidth() {
        TextPaint paint = getPaint();
        String charSequence = getText().toString();
        if (getTransformationMethod() != null) {
            charSequence = getTransformationMethod().getTransformation(charSequence, this).toString();
        }
        return Math.min((int) paint.measureText(charSequence), getLayout().getEllipsizedWidth());
    }

    private boolean h() {
        e.j.a.c.g.a aVar = this.a;
        return (aVar == null || aVar.o()) ? false : true;
    }

    private void j() {
        if (e()) {
            TextViewCompat.setCompoundDrawablesRelative(this, this.f2807f, null, null, null);
        } else if (d()) {
            TextViewCompat.setCompoundDrawablesRelative(this, null, null, this.f2807f, null);
        } else if (f()) {
            TextViewCompat.setCompoundDrawablesRelative(this, null, this.f2807f, null, null);
        }
    }

    private void k(boolean z) {
        Drawable drawable = this.f2807f;
        if (drawable != null) {
            Drawable mutate = DrawableCompat.wrap(drawable).mutate();
            this.f2807f = mutate;
            DrawableCompat.setTintList(mutate, this.f2806e);
            PorterDuff.Mode mode = this.f2805d;
            if (mode != null) {
                DrawableCompat.setTintMode(this.f2807f, mode);
            }
            int i2 = this.f2808g;
            if (i2 == 0) {
                i2 = this.f2807f.getIntrinsicWidth();
            }
            int i3 = this.f2808g;
            if (i3 == 0) {
                i3 = this.f2807f.getIntrinsicHeight();
            }
            Drawable drawable2 = this.f2807f;
            int i4 = this.f2809h;
            int i5 = this.f2810i;
            drawable2.setBounds(i4, i5, i2 + i4, i3 + i5);
        }
        if (z) {
            j();
            return;
        }
        Drawable[] compoundDrawablesRelative = TextViewCompat.getCompoundDrawablesRelative(this);
        boolean z2 = false;
        Drawable drawable3 = compoundDrawablesRelative[0];
        Drawable drawable4 = compoundDrawablesRelative[1];
        Drawable drawable5 = compoundDrawablesRelative[2];
        if ((e() && drawable3 != this.f2807f) || ((d() && drawable5 != this.f2807f) || (f() && drawable4 != this.f2807f))) {
            z2 = true;
        }
        if (z2) {
            j();
        }
    }

    private void l(int i2, int i3) {
        if (this.f2807f == null || getLayout() == null) {
            return;
        }
        if (!e() && !d()) {
            if (f()) {
                this.f2809h = 0;
                if (this.f2814m == 16) {
                    this.f2810i = 0;
                    k(false);
                    return;
                }
                int i4 = this.f2808g;
                if (i4 == 0) {
                    i4 = this.f2807f.getIntrinsicHeight();
                }
                int textHeight = (((((i3 - getTextHeight()) - getPaddingTop()) - i4) - this.f2811j) - getPaddingBottom()) / 2;
                if (this.f2810i != textHeight) {
                    this.f2810i = textHeight;
                    k(false);
                    return;
                }
                return;
            }
            return;
        }
        this.f2810i = 0;
        int i5 = this.f2814m;
        if (i5 != 1 && i5 != 3) {
            int i6 = this.f2808g;
            if (i6 == 0) {
                i6 = this.f2807f.getIntrinsicWidth();
            }
            int textWidth = (((((i2 - getTextWidth()) - ViewCompat.getPaddingEnd(this)) - i6) - this.f2811j) - ViewCompat.getPaddingStart(this)) / 2;
            if (g() != (this.f2814m == 4)) {
                textWidth = -textWidth;
            }
            if (this.f2809h != textWidth) {
                this.f2809h = textWidth;
                k(false);
                return;
            }
            return;
        }
        this.f2809h = 0;
        k(false);
    }

    public void a(@NonNull b bVar) {
        this.b.add(bVar);
    }

    public void b() {
        this.b.clear();
    }

    public boolean c() {
        e.j.a.c.g.a aVar = this.a;
        return aVar != null && aVar.p();
    }

    @Override // android.view.View
    @Nullable
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Override // android.view.View
    @Nullable
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    @Px
    public int getCornerRadius() {
        if (h()) {
            return this.a.b();
        }
        return 0;
    }

    public Drawable getIcon() {
        return this.f2807f;
    }

    public int getIconGravity() {
        return this.f2814m;
    }

    @Px
    public int getIconPadding() {
        return this.f2811j;
    }

    @Px
    public int getIconSize() {
        return this.f2808g;
    }

    public ColorStateList getIconTint() {
        return this.f2806e;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f2805d;
    }

    @Dimension
    public int getInsetBottom() {
        return this.a.c();
    }

    @Dimension
    public int getInsetTop() {
        return this.a.d();
    }

    @Nullable
    public ColorStateList getRippleColor() {
        if (h()) {
            return this.a.h();
        }
        return null;
    }

    @Override // e.j.a.c.z.s
    @NonNull
    public o getShapeAppearanceModel() {
        if (h()) {
            return this.a.i();
        }
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ColorStateList getStrokeColor() {
        if (h()) {
            return this.a.j();
        }
        return null;
    }

    @Px
    public int getStrokeWidth() {
        if (h()) {
            return this.a.k();
        }
        return 0;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public ColorStateList getSupportBackgroundTintList() {
        if (h()) {
            return this.a.l();
        }
        return super.getSupportBackgroundTintList();
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (h()) {
            return this.a.m();
        }
        return super.getSupportBackgroundTintMode();
    }

    public void i(@NonNull b bVar) {
        this.b.remove(bVar);
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f2812k;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (h()) {
            k.f(this, this.a.f());
        }
    }

    @Override // android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 2);
        if (c()) {
            Button.mergeDrawableStates(onCreateDrawableState, n);
        }
        if (isChecked()) {
            Button.mergeDrawableStates(onCreateDrawableState, o);
        }
        return onCreateDrawableState;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        accessibilityNodeInfo.setCheckable(c());
        accessibilityNodeInfo.setChecked(isChecked());
        accessibilityNodeInfo.setClickable(isClickable());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        e.j.a.c.g.a aVar;
        super.onLayout(z, i2, i3, i4, i5);
        if (Build.VERSION.SDK_INT != 21 || (aVar = this.a) == null) {
            return;
        }
        aVar.H(i5 - i3, i4 - i2);
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(@Nullable Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setChecked(savedState.checked);
    }

    @Override // android.widget.TextView, android.view.View
    @NonNull
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.checked = this.f2812k;
        return savedState;
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        l(i2, i3);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        super.onTextChanged(charSequence, i2, i3, i4);
        l(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public boolean performClick() {
        toggle();
        return super.performClick();
    }

    @Override // android.view.View
    public void setBackground(@NonNull Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(@ColorInt int i2) {
        if (h()) {
            this.a.r(i2);
        } else {
            super.setBackgroundColor(i2);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundDrawable(@NonNull Drawable drawable) {
        if (h()) {
            if (drawable != getBackground()) {
                Log.w(v, "MaterialButton manages its own background to control elevation, shape, color and states. Consider using backgroundTint, shapeAppearance and other attributes where available. A custom background will ignore these attributes and you should consider handling interaction states such as pressed, focused and disabled");
                this.a.s();
                super.setBackgroundDrawable(drawable);
                return;
            }
            getBackground().setState(drawable.getState());
            return;
        }
        super.setBackgroundDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundResource(@DrawableRes int i2) {
        setBackgroundDrawable(i2 != 0 ? AppCompatResources.getDrawable(getContext(), i2) : null);
    }

    @Override // android.view.View
    public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    @Override // android.view.View
    public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCheckable(boolean z) {
        if (h()) {
            this.a.t(z);
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (c() && isEnabled() && this.f2812k != z) {
            this.f2812k = z;
            refreshDrawableState();
            if (this.f2813l) {
                return;
            }
            this.f2813l = true;
            Iterator<b> it = this.b.iterator();
            while (it.hasNext()) {
                it.next().a(this, this.f2812k);
            }
            this.f2813l = false;
        }
    }

    public void setCornerRadius(@Px int i2) {
        if (h()) {
            this.a.u(i2);
        }
    }

    public void setCornerRadiusResource(@DimenRes int i2) {
        if (h()) {
            setCornerRadius(getResources().getDimensionPixelSize(i2));
        }
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float f2) {
        super.setElevation(f2);
        if (h()) {
            this.a.f().m0(f2);
        }
    }

    public void setIcon(@Nullable Drawable drawable) {
        if (this.f2807f != drawable) {
            this.f2807f = drawable;
            k(true);
            l(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconGravity(int i2) {
        if (this.f2814m != i2) {
            this.f2814m = i2;
            l(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconPadding(@Px int i2) {
        if (this.f2811j != i2) {
            this.f2811j = i2;
            setCompoundDrawablePadding(i2);
        }
    }

    public void setIconResource(@DrawableRes int i2) {
        setIcon(i2 != 0 ? AppCompatResources.getDrawable(getContext(), i2) : null);
    }

    public void setIconSize(@Px int i2) {
        if (i2 >= 0) {
            if (this.f2808g != i2) {
                this.f2808g = i2;
                k(true);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("iconSize cannot be less than 0");
    }

    public void setIconTint(@Nullable ColorStateList colorStateList) {
        if (this.f2806e != colorStateList) {
            this.f2806e = colorStateList;
            k(false);
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.f2805d != mode) {
            this.f2805d = mode;
            k(false);
        }
    }

    public void setIconTintResource(@ColorRes int i2) {
        setIconTint(AppCompatResources.getColorStateList(getContext(), i2));
    }

    public void setInsetBottom(@Dimension int i2) {
        this.a.v(i2);
    }

    public void setInsetTop(@Dimension int i2) {
        this.a.w(i2);
    }

    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setOnPressedChangeListenerInternal(@Nullable c cVar) {
        this.f2804c = cVar;
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        c cVar = this.f2804c;
        if (cVar != null) {
            cVar.a(this, z);
        }
        super.setPressed(z);
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        if (h()) {
            this.a.x(colorStateList);
        }
    }

    public void setRippleColorResource(@ColorRes int i2) {
        if (h()) {
            setRippleColor(AppCompatResources.getColorStateList(getContext(), i2));
        }
    }

    @Override // e.j.a.c.z.s
    public void setShapeAppearanceModel(@NonNull o oVar) {
        if (h()) {
            this.a.y(oVar);
            return;
        }
        throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
    }

    public void setShouldDrawSurfaceColorStroke(boolean z) {
        if (h()) {
            this.a.z(z);
        }
    }

    public void setStrokeColor(@Nullable ColorStateList colorStateList) {
        if (h()) {
            this.a.A(colorStateList);
        }
    }

    public void setStrokeColorResource(@ColorRes int i2) {
        if (h()) {
            setStrokeColor(AppCompatResources.getColorStateList(getContext(), i2));
        }
    }

    public void setStrokeWidth(@Px int i2) {
        if (h()) {
            this.a.B(i2);
        }
    }

    public void setStrokeWidthResource(@DimenRes int i2) {
        if (h()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i2));
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        if (h()) {
            this.a.C(colorStateList);
        } else {
            super.setSupportBackgroundTintList(colorStateList);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        if (h()) {
            this.a.D(mode);
        } else {
            super.setSupportBackgroundTintMode(mode);
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.f2812k);
    }

    public MaterialButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialButtonStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public MaterialButton(@androidx.annotation.NonNull android.content.Context r9, @androidx.annotation.Nullable android.util.AttributeSet r10, int r11) {
        /*
            r8 = this;
            int r6 = com.google.android.material.button.MaterialButton.w
            android.content.Context r9 = e.j.a.c.e0.a.a.c(r9, r10, r11, r6)
            r8.<init>(r9, r10, r11)
            java.util.LinkedHashSet r9 = new java.util.LinkedHashSet
            r9.<init>()
            r8.b = r9
            r9 = 0
            r8.f2812k = r9
            r8.f2813l = r9
            android.content.Context r7 = r8.getContext()
            int[] r2 = com.google.android.material.R.styleable.MaterialButton
            int[] r5 = new int[r9]
            r0 = r7
            r1 = r10
            r3 = r11
            r4 = r6
            android.content.res.TypedArray r0 = e.j.a.c.s.m.j(r0, r1, r2, r3, r4, r5)
            int r1 = com.google.android.material.R.styleable.MaterialButton_iconPadding
            int r1 = r0.getDimensionPixelSize(r1, r9)
            r8.f2811j = r1
            int r1 = com.google.android.material.R.styleable.MaterialButton_iconTintMode
            r2 = -1
            int r1 = r0.getInt(r1, r2)
            android.graphics.PorterDuff$Mode r2 = android.graphics.PorterDuff.Mode.SRC_IN
            android.graphics.PorterDuff$Mode r1 = e.j.a.c.s.t.k(r1, r2)
            r8.f2805d = r1
            android.content.Context r1 = r8.getContext()
            int r2 = com.google.android.material.R.styleable.MaterialButton_iconTint
            android.content.res.ColorStateList r1 = e.j.a.c.w.c.a(r1, r0, r2)
            r8.f2806e = r1
            android.content.Context r1 = r8.getContext()
            int r2 = com.google.android.material.R.styleable.MaterialButton_icon
            android.graphics.drawable.Drawable r1 = e.j.a.c.w.c.d(r1, r0, r2)
            r8.f2807f = r1
            int r1 = com.google.android.material.R.styleable.MaterialButton_iconGravity
            r2 = 1
            int r1 = r0.getInteger(r1, r2)
            r8.f2814m = r1
            int r1 = com.google.android.material.R.styleable.MaterialButton_iconSize
            int r1 = r0.getDimensionPixelSize(r1, r9)
            r8.f2808g = r1
            e.j.a.c.z.o$b r10 = e.j.a.c.z.o.e(r7, r10, r11, r6)
            e.j.a.c.z.o r10 = r10.m()
            e.j.a.c.g.a r11 = new e.j.a.c.g.a
            r11.<init>(r8, r10)
            r8.a = r11
            r11.q(r0)
            r0.recycle()
            int r10 = r8.f2811j
            r8.setCompoundDrawablePadding(r10)
            android.graphics.drawable.Drawable r10 = r8.f2807f
            if (r10 == 0) goto L84
            r9 = 1
        L84:
            r8.k(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.button.MaterialButton.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
