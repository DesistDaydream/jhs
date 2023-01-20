package com.google.android.material.textfield;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.DrawableUtils;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.text.BidiFormatter;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.internal.CheckableImageButton;
import e.j.a.c.z.j;
import e.j.a.c.z.o;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* loaded from: classes2.dex */
public class TextInputLayout extends LinearLayout {
    private static final int f1 = R.style.Widget_Design_TextInputLayout;
    private static final int g1 = 167;
    private static final int h1 = -1;
    private static final int i1 = -1;
    private static final String j1 = "TextInputLayout";
    public static final int k1 = 0;
    public static final int l1 = 1;
    public static final int m1 = 2;
    public static final int n1 = -1;
    public static final int o1 = 0;
    public static final int p1 = 1;
    public static final int q1 = 2;
    public static final int r1 = 3;
    private boolean A;
    private CharSequence B;
    private boolean C;
    @Nullable
    private j D;
    @Nullable
    private j E;
    @NonNull
    private o F;
    private final int G;
    @Nullable
    private Drawable G0;
    private int H;
    private int H0;
    private int I;
    private Drawable I0;
    private int J;
    private View.OnLongClickListener J0;
    private int K;
    private View.OnLongClickListener K0;
    private int L;
    @NonNull
    private final CheckableImageButton L0;
    private int M;
    private ColorStateList M0;
    @ColorInt
    private int N;
    private ColorStateList N0;
    @ColorInt
    private int O;
    private ColorStateList O0;
    private final Rect P;
    @ColorInt
    private int P0;
    private final Rect Q;
    @ColorInt
    private int Q0;
    private final RectF R;
    @ColorInt
    private int R0;
    private Typeface S;
    private ColorStateList S0;
    @NonNull
    private final CheckableImageButton T;
    @ColorInt
    private int T0;
    private ColorStateList U;
    @ColorInt
    private int U0;
    private boolean V;
    @ColorInt
    private int V0;
    private PorterDuff.Mode W;
    @ColorInt
    private int W0;
    @ColorInt
    private int X0;
    private boolean Y0;
    public final e.j.a.c.s.a Z0;
    @NonNull
    private final FrameLayout a;
    private boolean a0;
    private boolean a1;
    @NonNull
    private final LinearLayout b;
    @Nullable
    private Drawable b0;
    private boolean b1;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final LinearLayout f3089c;
    private int c0;
    private ValueAnimator c1;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final FrameLayout f3090d;
    private View.OnLongClickListener d0;
    private boolean d1;

    /* renamed from: e  reason: collision with root package name */
    public EditText f3091e;
    private final LinkedHashSet<h> e0;
    private boolean e1;

    /* renamed from: f  reason: collision with root package name */
    private CharSequence f3092f;
    private int f0;

    /* renamed from: g  reason: collision with root package name */
    private int f3093g;
    private final SparseArray<e.j.a.c.d0.e> g0;

    /* renamed from: h  reason: collision with root package name */
    private int f3094h;
    @NonNull
    private final CheckableImageButton h0;

    /* renamed from: i  reason: collision with root package name */
    private final e.j.a.c.d0.f f3095i;
    private final LinkedHashSet<i> i0;

    /* renamed from: j  reason: collision with root package name */
    public boolean f3096j;
    private ColorStateList j0;

    /* renamed from: k  reason: collision with root package name */
    private int f3097k;
    private boolean k0;

    /* renamed from: l  reason: collision with root package name */
    private boolean f3098l;
    private PorterDuff.Mode l0;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private TextView f3099m;
    private boolean m0;
    private int n;
    private int o;
    private CharSequence p;
    private boolean q;
    private TextView r;
    @Nullable
    private ColorStateList s;
    private int t;
    @Nullable
    private ColorStateList u;
    @Nullable
    private ColorStateList v;
    @Nullable
    private CharSequence w;
    @NonNull
    private final TextView x;
    @Nullable
    private CharSequence y;
    @NonNull
    private final TextView z;

    /* loaded from: classes2.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        @Nullable
        public CharSequence error;
        @Nullable
        public CharSequence helperText;
        @Nullable
        public CharSequence hintText;
        public boolean isEndIconChecked;
        @Nullable
        public CharSequence placeholderText;

        /* loaded from: classes2.dex */
        public static class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            @Nullable
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

        @NonNull
        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + ((Object) this.error) + " hint=" + ((Object) this.hintText) + " helperText=" + ((Object) this.helperText) + " placeholderText=" + ((Object) this.placeholderText) + "}";
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            TextUtils.writeToParcel(this.error, parcel, i2);
            parcel.writeInt(this.isEndIconChecked ? 1 : 0);
            TextUtils.writeToParcel(this.hintText, parcel, i2);
            TextUtils.writeToParcel(this.helperText, parcel, i2);
            TextUtils.writeToParcel(this.placeholderText, parcel, i2);
        }

        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.error = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.isEndIconChecked = parcel.readInt() == 1;
            this.hintText = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.helperText = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.placeholderText = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        }
    }

    /* loaded from: classes2.dex */
    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@NonNull Editable editable) {
            TextInputLayout textInputLayout = TextInputLayout.this;
            textInputLayout.M0(!textInputLayout.e1);
            TextInputLayout textInputLayout2 = TextInputLayout.this;
            if (textInputLayout2.f3096j) {
                textInputLayout2.E0(editable.length());
            }
            if (TextInputLayout.this.q) {
                TextInputLayout.this.Q0(editable.length());
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TextInputLayout.this.h0.performClick();
            TextInputLayout.this.h0.jumpDrawablesToCurrentState();
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TextInputLayout.this.f3091e.requestLayout();
        }
    }

    /* loaded from: classes2.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        public d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            TextInputLayout.this.Z0.u0(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* loaded from: classes2.dex */
    public static class e extends AccessibilityDelegateCompat {
        private final TextInputLayout a;

        public e(@NonNull TextInputLayout textInputLayout) {
            this.a = textInputLayout;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(@NonNull View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            int i2 = Build.VERSION.SDK_INT;
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            EditText editText = this.a.getEditText();
            CharSequence text = editText != null ? editText.getText() : null;
            CharSequence hint = this.a.getHint();
            CharSequence error = this.a.getError();
            CharSequence placeholderText = this.a.getPlaceholderText();
            int counterMaxLength = this.a.getCounterMaxLength();
            CharSequence counterOverflowDescription = this.a.getCounterOverflowDescription();
            boolean z = !TextUtils.isEmpty(text);
            boolean z2 = !TextUtils.isEmpty(hint);
            boolean z3 = !this.a.X();
            boolean z4 = !TextUtils.isEmpty(error);
            boolean z5 = z4 || !TextUtils.isEmpty(counterOverflowDescription);
            String charSequence = z2 ? hint.toString() : "";
            if (z) {
                accessibilityNodeInfoCompat.setText(text);
            } else if (!TextUtils.isEmpty(charSequence)) {
                accessibilityNodeInfoCompat.setText(charSequence);
                if (z3 && placeholderText != null) {
                    accessibilityNodeInfoCompat.setText(charSequence + ", " + ((Object) placeholderText));
                }
            } else if (placeholderText != null) {
                accessibilityNodeInfoCompat.setText(placeholderText);
            }
            if (!TextUtils.isEmpty(charSequence)) {
                if (i2 >= 26) {
                    accessibilityNodeInfoCompat.setHintText(charSequence);
                } else {
                    if (z) {
                        charSequence = ((Object) text) + ", " + charSequence;
                    }
                    accessibilityNodeInfoCompat.setText(charSequence);
                }
                accessibilityNodeInfoCompat.setShowingHintText(!z);
            }
            accessibilityNodeInfoCompat.setMaxTextLength((text == null || text.length() != counterMaxLength) ? -1 : -1);
            if (z5) {
                if (!z4) {
                    error = counterOverflowDescription;
                }
                accessibilityNodeInfoCompat.setError(error);
            }
            if (i2 < 17 || editText == null) {
                return;
            }
            editText.setLabelFor(R.id.textinput_helper_text);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface f {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes2.dex */
    public @interface g {
    }

    /* loaded from: classes2.dex */
    public interface h {
        void a(@NonNull TextInputLayout textInputLayout);
    }

    /* loaded from: classes2.dex */
    public interface i {
        void a(@NonNull TextInputLayout textInputLayout, int i2);
    }

    public TextInputLayout(@NonNull Context context) {
        this(context, null);
    }

    private void A() {
        if (C()) {
            ((e.j.a.c.d0.c) this.D).R0();
        }
    }

    private void A0(boolean z) {
        if (z && getEndIconDrawable() != null) {
            Drawable mutate = DrawableCompat.wrap(getEndIconDrawable()).mutate();
            DrawableCompat.setTint(mutate, this.f3095i.p());
            this.h0.setImageDrawable(mutate);
            return;
        }
        m();
    }

    private void B(boolean z) {
        ValueAnimator valueAnimator = this.c1;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.c1.cancel();
        }
        if (z && this.b1) {
            i(1.0f);
        } else {
            this.Z0.u0(1.0f);
        }
        this.Y0 = false;
        if (C()) {
            f0();
        }
        P0();
        S0();
        V0();
    }

    private void B0() {
        if (this.I == 1) {
            if (e.j.a.c.w.c.h(getContext())) {
                this.J = getResources().getDimensionPixelSize(R.dimen.material_font_2_0_box_collapsed_padding_top);
            } else if (e.j.a.c.w.c.g(getContext())) {
                this.J = getResources().getDimensionPixelSize(R.dimen.material_font_1_3_box_collapsed_padding_top);
            }
        }
    }

    private boolean C() {
        return this.A && !TextUtils.isEmpty(this.B) && (this.D instanceof e.j.a.c.d0.c);
    }

    private void C0(@NonNull Rect rect) {
        j jVar = this.E;
        if (jVar != null) {
            int i2 = rect.bottom;
            jVar.setBounds(rect.left, i2 - this.M, rect.right, i2);
        }
    }

    private void D0() {
        if (this.f3099m != null) {
            EditText editText = this.f3091e;
            E0(editText == null ? 0 : editText.getText().length());
        }
    }

    private void E() {
        Iterator<h> it = this.e0.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
    }

    private void F(int i2) {
        Iterator<i> it = this.i0.iterator();
        while (it.hasNext()) {
            it.next().a(this, i2);
        }
    }

    private static void F0(@NonNull Context context, @NonNull TextView textView, int i2, int i3, boolean z) {
        textView.setContentDescription(context.getString(z ? R.string.character_counter_overflowed_content_description : R.string.character_counter_content_description, Integer.valueOf(i2), Integer.valueOf(i3)));
    }

    private void G(Canvas canvas) {
        j jVar = this.E;
        if (jVar != null) {
            Rect bounds = jVar.getBounds();
            bounds.top = bounds.bottom - this.K;
            this.E.draw(canvas);
        }
    }

    private void G0() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        TextView textView = this.f3099m;
        if (textView != null) {
            v0(textView, this.f3098l ? this.n : this.o);
            if (!this.f3098l && (colorStateList2 = this.u) != null) {
                this.f3099m.setTextColor(colorStateList2);
            }
            if (!this.f3098l || (colorStateList = this.v) == null) {
                return;
            }
            this.f3099m.setTextColor(colorStateList);
        }
    }

    private void H(@NonNull Canvas canvas) {
        if (this.A) {
            this.Z0.m(canvas);
        }
    }

    private void H0() {
        if (!C() || this.Y0 || this.H == this.K) {
            return;
        }
        A();
        f0();
    }

    private void I(boolean z) {
        ValueAnimator valueAnimator = this.c1;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.c1.cancel();
        }
        if (z && this.b1) {
            i(0.0f);
        } else {
            this.Z0.u0(0.0f);
        }
        if (C() && ((e.j.a.c.d0.c) this.D).O0()) {
            A();
        }
        this.Y0 = true;
        M();
        S0();
        V0();
    }

    private boolean I0() {
        boolean z;
        if (this.f3091e == null) {
            return false;
        }
        boolean z2 = true;
        if (x0()) {
            int measuredWidth = this.b.getMeasuredWidth() - this.f3091e.getPaddingLeft();
            if (this.b0 == null || this.c0 != measuredWidth) {
                ColorDrawable colorDrawable = new ColorDrawable();
                this.b0 = colorDrawable;
                this.c0 = measuredWidth;
                colorDrawable.setBounds(0, 0, measuredWidth, 1);
            }
            Drawable[] compoundDrawablesRelative = TextViewCompat.getCompoundDrawablesRelative(this.f3091e);
            Drawable drawable = compoundDrawablesRelative[0];
            Drawable drawable2 = this.b0;
            if (drawable != drawable2) {
                TextViewCompat.setCompoundDrawablesRelative(this.f3091e, drawable2, compoundDrawablesRelative[1], compoundDrawablesRelative[2], compoundDrawablesRelative[3]);
                z = true;
            }
            z = false;
        } else {
            if (this.b0 != null) {
                Drawable[] compoundDrawablesRelative2 = TextViewCompat.getCompoundDrawablesRelative(this.f3091e);
                TextViewCompat.setCompoundDrawablesRelative(this.f3091e, null, compoundDrawablesRelative2[1], compoundDrawablesRelative2[2], compoundDrawablesRelative2[3]);
                this.b0 = null;
                z = true;
            }
            z = false;
        }
        if (w0()) {
            int measuredWidth2 = this.z.getMeasuredWidth() - this.f3091e.getPaddingRight();
            CheckableImageButton endIconToUpdateDummyDrawable = getEndIconToUpdateDummyDrawable();
            if (endIconToUpdateDummyDrawable != null) {
                measuredWidth2 = measuredWidth2 + endIconToUpdateDummyDrawable.getMeasuredWidth() + MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams) endIconToUpdateDummyDrawable.getLayoutParams());
            }
            Drawable[] compoundDrawablesRelative3 = TextViewCompat.getCompoundDrawablesRelative(this.f3091e);
            Drawable drawable3 = this.G0;
            if (drawable3 != null && this.H0 != measuredWidth2) {
                this.H0 = measuredWidth2;
                drawable3.setBounds(0, 0, measuredWidth2, 1);
                TextViewCompat.setCompoundDrawablesRelative(this.f3091e, compoundDrawablesRelative3[0], compoundDrawablesRelative3[1], this.G0, compoundDrawablesRelative3[3]);
            } else {
                if (drawable3 == null) {
                    ColorDrawable colorDrawable2 = new ColorDrawable();
                    this.G0 = colorDrawable2;
                    this.H0 = measuredWidth2;
                    colorDrawable2.setBounds(0, 0, measuredWidth2, 1);
                }
                Drawable drawable4 = compoundDrawablesRelative3[2];
                Drawable drawable5 = this.G0;
                if (drawable4 != drawable5) {
                    this.I0 = compoundDrawablesRelative3[2];
                    TextViewCompat.setCompoundDrawablesRelative(this.f3091e, compoundDrawablesRelative3[0], compoundDrawablesRelative3[1], drawable5, compoundDrawablesRelative3[3]);
                } else {
                    z2 = z;
                }
            }
        } else if (this.G0 == null) {
            return z;
        } else {
            Drawable[] compoundDrawablesRelative4 = TextViewCompat.getCompoundDrawablesRelative(this.f3091e);
            if (compoundDrawablesRelative4[2] == this.G0) {
                TextViewCompat.setCompoundDrawablesRelative(this.f3091e, compoundDrawablesRelative4[0], compoundDrawablesRelative4[1], this.I0, compoundDrawablesRelative4[3]);
            } else {
                z2 = z;
            }
            this.G0 = null;
        }
        return z2;
    }

    private int J(int i2, boolean z) {
        int compoundPaddingLeft = i2 + this.f3091e.getCompoundPaddingLeft();
        return (this.w == null || z) ? compoundPaddingLeft : (compoundPaddingLeft - this.x.getMeasuredWidth()) + this.x.getPaddingLeft();
    }

    private int K(int i2, boolean z) {
        int compoundPaddingRight = i2 - this.f3091e.getCompoundPaddingRight();
        return (this.w == null || !z) ? compoundPaddingRight : compoundPaddingRight + (this.x.getMeasuredWidth() - this.x.getPaddingRight());
    }

    private boolean K0() {
        int max;
        if (this.f3091e != null && this.f3091e.getMeasuredHeight() < (max = Math.max(this.f3089c.getMeasuredHeight(), this.b.getMeasuredHeight()))) {
            this.f3091e.setMinimumHeight(max);
            return true;
        }
        return false;
    }

    private boolean L() {
        return this.f0 != 0;
    }

    private void L0() {
        if (this.I != 1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.a.getLayoutParams();
            int v = v();
            if (v != layoutParams.topMargin) {
                layoutParams.topMargin = v;
                this.a.requestLayout();
            }
        }
    }

    private void M() {
        TextView textView = this.r;
        if (textView == null || !this.q) {
            return;
        }
        textView.setText((CharSequence) null);
        this.r.setVisibility(4);
    }

    private void N0(boolean z, boolean z2) {
        ColorStateList colorStateList;
        TextView textView;
        boolean isEnabled = isEnabled();
        EditText editText = this.f3091e;
        boolean z3 = (editText == null || TextUtils.isEmpty(editText.getText())) ? false : true;
        EditText editText2 = this.f3091e;
        boolean z4 = editText2 != null && editText2.hasFocus();
        boolean l2 = this.f3095i.l();
        ColorStateList colorStateList2 = this.N0;
        if (colorStateList2 != null) {
            this.Z0.f0(colorStateList2);
            this.Z0.p0(this.N0);
        }
        if (!isEnabled) {
            ColorStateList colorStateList3 = this.N0;
            int colorForState = colorStateList3 != null ? colorStateList3.getColorForState(new int[]{-16842910}, this.X0) : this.X0;
            this.Z0.f0(ColorStateList.valueOf(colorForState));
            this.Z0.p0(ColorStateList.valueOf(colorForState));
        } else if (l2) {
            this.Z0.f0(this.f3095i.q());
        } else if (this.f3098l && (textView = this.f3099m) != null) {
            this.Z0.f0(textView.getTextColors());
        } else if (z4 && (colorStateList = this.O0) != null) {
            this.Z0.f0(colorStateList);
        }
        if (!z3 && this.a1 && (!isEnabled() || !z4)) {
            if (z2 || !this.Y0) {
                I(z);
            }
        } else if (z2 || this.Y0) {
            B(z);
        }
    }

    private void O0() {
        EditText editText;
        if (this.r == null || (editText = this.f3091e) == null) {
            return;
        }
        this.r.setGravity(editText.getGravity());
        this.r.setPadding(this.f3091e.getCompoundPaddingLeft(), this.f3091e.getCompoundPaddingTop(), this.f3091e.getCompoundPaddingRight(), this.f3091e.getCompoundPaddingBottom());
    }

    private void P0() {
        EditText editText = this.f3091e;
        Q0(editText == null ? 0 : editText.getText().length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q0(int i2) {
        if (i2 == 0 && !this.Y0) {
            z0();
        } else {
            M();
        }
    }

    private boolean R() {
        return this.L0.getVisibility() == 0;
    }

    private void R0() {
        if (this.f3091e == null) {
            return;
        }
        ViewCompat.setPaddingRelative(this.x, c0() ? 0 : ViewCompat.getPaddingStart(this.f3091e), this.f3091e.getCompoundPaddingTop(), getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding), this.f3091e.getCompoundPaddingBottom());
    }

    private void S0() {
        this.x.setVisibility((this.w == null || X()) ? 8 : 0);
        I0();
    }

    private void T0(boolean z, boolean z2) {
        int defaultColor = this.S0.getDefaultColor();
        int colorForState = this.S0.getColorForState(new int[]{16843623, 16842910}, defaultColor);
        int colorForState2 = this.S0.getColorForState(new int[]{16843518, 16842910}, defaultColor);
        if (z) {
            this.N = colorForState2;
        } else if (z2) {
            this.N = colorForState;
        } else {
            this.N = defaultColor;
        }
    }

    private void U0() {
        if (this.f3091e == null) {
            return;
        }
        ViewCompat.setPaddingRelative(this.z, getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding), this.f3091e.getPaddingTop(), (P() || R()) ? 0 : ViewCompat.getPaddingEnd(this.f3091e), this.f3091e.getPaddingBottom());
    }

    private void V0() {
        int visibility = this.z.getVisibility();
        boolean z = (this.y == null || X()) ? false : true;
        this.z.setVisibility(z ? 0 : 8);
        if (visibility != this.z.getVisibility()) {
            getEndIconDelegate().c(z);
        }
        I0();
    }

    private boolean a0() {
        return this.I == 1 && (Build.VERSION.SDK_INT < 16 || this.f3091e.getMinLines() <= 1);
    }

    private int[] d0(CheckableImageButton checkableImageButton) {
        int[] drawableState = getDrawableState();
        int[] drawableState2 = checkableImageButton.getDrawableState();
        int length = drawableState.length;
        int[] copyOf = Arrays.copyOf(drawableState, drawableState.length + drawableState2.length);
        System.arraycopy(drawableState2, 0, copyOf, length, drawableState2.length);
        return copyOf;
    }

    private void e0() {
        p();
        r0();
        W0();
        B0();
        h();
        if (this.I != 0) {
            L0();
        }
    }

    private void f0() {
        if (C()) {
            RectF rectF = this.R;
            this.Z0.p(rectF, this.f3091e.getWidth(), this.f3091e.getGravity());
            l(rectF);
            int i2 = this.K;
            this.H = i2;
            rectF.top = 0.0f;
            rectF.bottom = i2;
            rectF.offset(-getPaddingLeft(), 0.0f);
            ((e.j.a.c.d0.c) this.D).U0(rectF);
        }
    }

    private void g() {
        TextView textView = this.r;
        if (textView != null) {
            this.a.addView(textView);
            this.r.setVisibility(0);
        }
    }

    private e.j.a.c.d0.e getEndIconDelegate() {
        e.j.a.c.d0.e eVar = this.g0.get(this.f0);
        return eVar != null ? eVar : this.g0.get(0);
    }

    @Nullable
    private CheckableImageButton getEndIconToUpdateDummyDrawable() {
        if (this.L0.getVisibility() == 0) {
            return this.L0;
        }
        if (L() && P()) {
            return this.h0;
        }
        return null;
    }

    private void h() {
        if (this.f3091e == null || this.I != 1) {
            return;
        }
        if (e.j.a.c.w.c.h(getContext())) {
            EditText editText = this.f3091e;
            ViewCompat.setPaddingRelative(editText, ViewCompat.getPaddingStart(editText), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_2_0_padding_top), ViewCompat.getPaddingEnd(this.f3091e), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_2_0_padding_bottom));
        } else if (e.j.a.c.w.c.g(getContext())) {
            EditText editText2 = this.f3091e;
            ViewCompat.setPaddingRelative(editText2, ViewCompat.getPaddingStart(editText2), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_1_3_padding_top), ViewCompat.getPaddingEnd(this.f3091e), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_1_3_padding_bottom));
        }
    }

    private static void h0(@NonNull ViewGroup viewGroup, boolean z) {
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            childAt.setEnabled(z);
            if (childAt instanceof ViewGroup) {
                h0((ViewGroup) childAt, z);
            }
        }
    }

    private void j() {
        j jVar = this.D;
        if (jVar == null) {
            return;
        }
        jVar.setShapeAppearanceModel(this.F);
        if (w()) {
            this.D.C0(this.K, this.N);
        }
        int q = q();
        this.O = q;
        this.D.n0(ColorStateList.valueOf(q));
        if (this.f0 == 3) {
            this.f3091e.getBackground().invalidateSelf();
        }
        k();
        invalidate();
    }

    private void k() {
        if (this.E == null) {
            return;
        }
        if (x()) {
            this.E.n0(ColorStateList.valueOf(this.N));
        }
        invalidate();
    }

    private void k0(CheckableImageButton checkableImageButton, ColorStateList colorStateList) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (checkableImageButton.getDrawable() == null || colorStateList == null || !colorStateList.isStateful()) {
            return;
        }
        int colorForState = colorStateList.getColorForState(d0(checkableImageButton), colorStateList.getDefaultColor());
        Drawable mutate = DrawableCompat.wrap(drawable).mutate();
        DrawableCompat.setTintList(mutate, ColorStateList.valueOf(colorForState));
        checkableImageButton.setImageDrawable(mutate);
    }

    private void l(@NonNull RectF rectF) {
        float f2 = rectF.left;
        int i2 = this.G;
        rectF.left = f2 - i2;
        rectF.right += i2;
    }

    private void m() {
        n(this.h0, this.k0, this.j0, this.m0, this.l0);
    }

    private void n(@NonNull CheckableImageButton checkableImageButton, boolean z, ColorStateList colorStateList, boolean z2, PorterDuff.Mode mode) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (drawable != null && (z || z2)) {
            drawable = DrawableCompat.wrap(drawable).mutate();
            if (z) {
                DrawableCompat.setTintList(drawable, colorStateList);
            }
            if (z2) {
                DrawableCompat.setTintMode(drawable, mode);
            }
        }
        if (checkableImageButton.getDrawable() != drawable) {
            checkableImageButton.setImageDrawable(drawable);
        }
    }

    private void o() {
        n(this.T, this.V, this.U, this.a0, this.W);
    }

    private void o0() {
        TextView textView = this.r;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    private void p() {
        int i2 = this.I;
        if (i2 == 0) {
            this.D = null;
            this.E = null;
        } else if (i2 == 1) {
            this.D = new j(this.F);
            this.E = new j();
        } else if (i2 == 2) {
            if (this.A && !(this.D instanceof e.j.a.c.d0.c)) {
                this.D = new e.j.a.c.d0.c(this.F);
            } else {
                this.D = new j(this.F);
            }
            this.E = null;
        } else {
            throw new IllegalArgumentException(this.I + " is illegal; only @BoxBackgroundMode constants are supported.");
        }
    }

    private int q() {
        return this.I == 1 ? e.j.a.c.l.a.g(e.j.a.c.l.a.e(this, R.attr.colorSurface, 0), this.O) : this.O;
    }

    @NonNull
    private Rect r(@NonNull Rect rect) {
        if (this.f3091e != null) {
            Rect rect2 = this.Q;
            boolean z = ViewCompat.getLayoutDirection(this) == 1;
            rect2.bottom = rect.bottom;
            int i2 = this.I;
            if (i2 == 1) {
                rect2.left = J(rect.left, z);
                rect2.top = rect.top + this.J;
                rect2.right = K(rect.right, z);
                return rect2;
            } else if (i2 != 2) {
                rect2.left = J(rect.left, z);
                rect2.top = getPaddingTop();
                rect2.right = K(rect.right, z);
                return rect2;
            } else {
                rect2.left = rect.left + this.f3091e.getPaddingLeft();
                rect2.top = rect.top - v();
                rect2.right = rect.right - this.f3091e.getPaddingRight();
                return rect2;
            }
        }
        throw new IllegalStateException();
    }

    private void r0() {
        if (y0()) {
            ViewCompat.setBackground(this.f3091e, this.D);
        }
    }

    private int s(@NonNull Rect rect, @NonNull Rect rect2, float f2) {
        if (a0()) {
            return (int) (rect2.top + f2);
        }
        return rect.bottom - this.f3091e.getCompoundPaddingBottom();
    }

    private static void s0(@NonNull CheckableImageButton checkableImageButton, @Nullable View.OnLongClickListener onLongClickListener) {
        boolean hasOnClickListeners = ViewCompat.hasOnClickListeners(checkableImageButton);
        boolean z = false;
        boolean z2 = onLongClickListener != null;
        z = (hasOnClickListeners || z2) ? true : true;
        checkableImageButton.setFocusable(z);
        checkableImageButton.setClickable(hasOnClickListeners);
        checkableImageButton.setPressable(hasOnClickListeners);
        checkableImageButton.setLongClickable(z2);
        ViewCompat.setImportantForAccessibility(checkableImageButton, z ? 1 : 2);
    }

    private void setEditText(EditText editText) {
        if (this.f3091e == null) {
            if (this.f0 != 3 && !(editText instanceof TextInputEditText)) {
                Log.i(j1, "EditText added is not a TextInputEditText. Please switch to using that class instead.");
            }
            this.f3091e = editText;
            setMinWidth(this.f3093g);
            setMaxWidth(this.f3094h);
            e0();
            setTextInputAccessibilityDelegate(new e(this));
            this.Z0.H0(this.f3091e.getTypeface());
            this.Z0.r0(this.f3091e.getTextSize());
            int gravity = this.f3091e.getGravity();
            this.Z0.g0((gravity & (-113)) | 48);
            this.Z0.q0(gravity);
            this.f3091e.addTextChangedListener(new a());
            if (this.N0 == null) {
                this.N0 = this.f3091e.getHintTextColors();
            }
            if (this.A) {
                if (TextUtils.isEmpty(this.B)) {
                    CharSequence hint = this.f3091e.getHint();
                    this.f3092f = hint;
                    setHint(hint);
                    this.f3091e.setHint((CharSequence) null);
                }
                this.C = true;
            }
            if (this.f3099m != null) {
                E0(this.f3091e.getText().length());
            }
            J0();
            this.f3095i.e();
            this.b.bringToFront();
            this.f3089c.bringToFront();
            this.f3090d.bringToFront();
            this.L0.bringToFront();
            E();
            R0();
            U0();
            if (!isEnabled()) {
                editText.setEnabled(false);
            }
            N0(false, true);
            return;
        }
        throw new IllegalArgumentException("We already have an EditText, can only have one");
    }

    private void setErrorIconVisible(boolean z) {
        this.L0.setVisibility(z ? 0 : 8);
        this.f3090d.setVisibility(z ? 8 : 0);
        U0();
        if (L()) {
            return;
        }
        I0();
    }

    private void setHintInternal(CharSequence charSequence) {
        if (TextUtils.equals(charSequence, this.B)) {
            return;
        }
        this.B = charSequence;
        this.Z0.F0(charSequence);
        if (this.Y0) {
            return;
        }
        f0();
    }

    private void setPlaceholderTextEnabled(boolean z) {
        if (this.q == z) {
            return;
        }
        if (z) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
            this.r = appCompatTextView;
            appCompatTextView.setId(R.id.textinput_placeholder);
            ViewCompat.setAccessibilityLiveRegion(this.r, 1);
            setPlaceholderTextAppearance(this.t);
            setPlaceholderTextColor(this.s);
            g();
        } else {
            o0();
            this.r = null;
        }
        this.q = z;
    }

    private int t(@NonNull Rect rect, float f2) {
        if (a0()) {
            return (int) (rect.centerY() - (f2 / 2.0f));
        }
        return rect.top + this.f3091e.getCompoundPaddingTop();
    }

    private static void t0(@NonNull CheckableImageButton checkableImageButton, @Nullable View.OnClickListener onClickListener, @Nullable View.OnLongClickListener onLongClickListener) {
        checkableImageButton.setOnClickListener(onClickListener);
        s0(checkableImageButton, onLongClickListener);
    }

    @NonNull
    private Rect u(@NonNull Rect rect) {
        if (this.f3091e != null) {
            Rect rect2 = this.Q;
            float D = this.Z0.D();
            rect2.left = rect.left + this.f3091e.getCompoundPaddingLeft();
            rect2.top = t(rect, D);
            rect2.right = rect.right - this.f3091e.getCompoundPaddingRight();
            rect2.bottom = s(rect, rect2, D);
            return rect2;
        }
        throw new IllegalStateException();
    }

    private static void u0(@NonNull CheckableImageButton checkableImageButton, @Nullable View.OnLongClickListener onLongClickListener) {
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        s0(checkableImageButton, onLongClickListener);
    }

    private int v() {
        float s;
        if (this.A) {
            int i2 = this.I;
            if (i2 == 0 || i2 == 1) {
                s = this.Z0.s();
            } else if (i2 != 2) {
                return 0;
            } else {
                s = this.Z0.s() / 2.0f;
            }
            return (int) s;
        }
        return 0;
    }

    private boolean w() {
        return this.I == 2 && x();
    }

    private boolean w0() {
        return (this.L0.getVisibility() == 0 || ((L() && P()) || this.y != null)) && this.f3089c.getMeasuredWidth() > 0;
    }

    private boolean x() {
        return this.K > -1 && this.N != 0;
    }

    private boolean x0() {
        return !(getStartIconDrawable() == null && this.w == null) && this.b.getMeasuredWidth() > 0;
    }

    private boolean y0() {
        EditText editText = this.f3091e;
        return (editText == null || this.D == null || editText.getBackground() != null || this.I == 0) ? false : true;
    }

    private void z0() {
        TextView textView = this.r;
        if (textView == null || !this.q) {
            return;
        }
        textView.setText(this.p);
        this.r.setVisibility(0);
        this.r.bringToFront();
    }

    @VisibleForTesting
    public boolean D() {
        return C() && ((e.j.a.c.d0.c) this.D).O0();
    }

    public void E0(int i2) {
        boolean z = this.f3098l;
        int i3 = this.f3097k;
        if (i3 == -1) {
            this.f3099m.setText(String.valueOf(i2));
            this.f3099m.setContentDescription(null);
            this.f3098l = false;
        } else {
            this.f3098l = i2 > i3;
            F0(getContext(), this.f3099m, i2, this.f3097k, this.f3098l);
            if (z != this.f3098l) {
                G0();
            }
            this.f3099m.setText(BidiFormatter.getInstance().unicodeWrap(getContext().getString(R.string.character_counter_pattern, Integer.valueOf(i2), Integer.valueOf(this.f3097k))));
        }
        if (this.f3091e == null || z == this.f3098l) {
            return;
        }
        M0(false);
        W0();
        J0();
    }

    public void J0() {
        Drawable background;
        TextView textView;
        EditText editText = this.f3091e;
        if (editText == null || this.I != 0 || (background = editText.getBackground()) == null) {
            return;
        }
        if (DrawableUtils.canSafelyMutateDrawable(background)) {
            background = background.mutate();
        }
        if (this.f3095i.l()) {
            background.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(this.f3095i.p(), PorterDuff.Mode.SRC_IN));
        } else if (this.f3098l && (textView = this.f3099m) != null) {
            background.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(textView.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        } else {
            DrawableCompat.clearColorFilter(background);
            this.f3091e.refreshDrawableState();
        }
    }

    public void M0(boolean z) {
        N0(z, false);
    }

    public boolean N() {
        return this.f3096j;
    }

    public boolean O() {
        return this.h0.a();
    }

    public boolean P() {
        return this.f3090d.getVisibility() == 0 && this.h0.getVisibility() == 0;
    }

    public boolean Q() {
        return this.f3095i.C();
    }

    public boolean S() {
        return this.a1;
    }

    @VisibleForTesting
    public final boolean T() {
        return this.f3095i.v();
    }

    public boolean U() {
        return this.f3095i.D();
    }

    public boolean V() {
        return this.b1;
    }

    public boolean W() {
        return this.A;
    }

    public void W0() {
        TextView textView;
        EditText editText;
        EditText editText2;
        if (this.D == null || this.I == 0) {
            return;
        }
        boolean z = false;
        boolean z2 = isFocused() || ((editText2 = this.f3091e) != null && editText2.hasFocus());
        boolean z3 = isHovered() || ((editText = this.f3091e) != null && editText.isHovered());
        if (!isEnabled()) {
            this.N = this.X0;
        } else if (this.f3095i.l()) {
            if (this.S0 != null) {
                T0(z2, z3);
            } else {
                this.N = this.f3095i.p();
            }
        } else if (!this.f3098l || (textView = this.f3099m) == null) {
            if (z2) {
                this.N = this.R0;
            } else if (z3) {
                this.N = this.Q0;
            } else {
                this.N = this.P0;
            }
        } else if (this.S0 != null) {
            T0(z2, z3);
        } else {
            this.N = textView.getCurrentTextColor();
        }
        if (getErrorIconDrawable() != null && this.f3095i.C() && this.f3095i.l()) {
            z = true;
        }
        setErrorIconVisible(z);
        j0();
        l0();
        i0();
        if (getEndIconDelegate().d()) {
            A0(this.f3095i.l());
        }
        if (z2 && isEnabled()) {
            this.K = this.M;
        } else {
            this.K = this.L;
        }
        if (this.I == 2) {
            H0();
        }
        if (this.I == 1) {
            if (!isEnabled()) {
                this.O = this.U0;
            } else if (z3 && !z2) {
                this.O = this.W0;
            } else if (z2) {
                this.O = this.V0;
            } else {
                this.O = this.T0;
            }
        }
        j();
    }

    @VisibleForTesting
    public final boolean X() {
        return this.Y0;
    }

    @Deprecated
    public boolean Y() {
        return this.f0 == 1;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean Z() {
        return this.C;
    }

    @Override // android.view.ViewGroup
    public void addView(@NonNull View view, int i2, @NonNull ViewGroup.LayoutParams layoutParams) {
        if (view instanceof EditText) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
            layoutParams2.gravity = (layoutParams2.gravity & (-113)) | 16;
            this.a.addView(view, layoutParams2);
            this.a.setLayoutParams(layoutParams);
            L0();
            setEditText((EditText) view);
            return;
        }
        super.addView(view, i2, layoutParams);
    }

    public boolean b0() {
        return this.T.a();
    }

    public boolean c0() {
        return this.T.getVisibility() == 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    @TargetApi(26)
    public void dispatchProvideAutofillStructure(@NonNull ViewStructure viewStructure, int i2) {
        EditText editText = this.f3091e;
        if (editText == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i2);
            return;
        }
        if (this.f3092f != null) {
            boolean z = this.C;
            this.C = false;
            CharSequence hint = editText.getHint();
            this.f3091e.setHint(this.f3092f);
            try {
                super.dispatchProvideAutofillStructure(viewStructure, i2);
                return;
            } finally {
                this.f3091e.setHint(hint);
                this.C = z;
            }
        }
        viewStructure.setAutofillId(getAutofillId());
        onProvideAutofillStructure(viewStructure, i2);
        onProvideAutofillVirtualStructure(viewStructure, i2);
        viewStructure.setChildCount(this.a.getChildCount());
        for (int i3 = 0; i3 < this.a.getChildCount(); i3++) {
            View childAt = this.a.getChildAt(i3);
            ViewStructure newChild = viewStructure.newChild(i3);
            childAt.dispatchProvideAutofillStructure(newChild, i2);
            if (childAt == this.f3091e) {
                newChild.setHint(getHint());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(@NonNull SparseArray<Parcelable> sparseArray) {
        this.e1 = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.e1 = false;
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
        H(canvas);
        G(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        if (this.d1) {
            return;
        }
        boolean z = true;
        this.d1 = true;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        e.j.a.c.s.a aVar = this.Z0;
        boolean E0 = aVar != null ? aVar.E0(drawableState) | false : false;
        if (this.f3091e != null) {
            M0((ViewCompat.isLaidOut(this) && isEnabled()) ? false : false);
        }
        J0();
        W0();
        if (E0) {
            invalidate();
        }
        this.d1 = false;
    }

    public void e(@NonNull h hVar) {
        this.e0.add(hVar);
        if (this.f3091e != null) {
            hVar.a(this);
        }
    }

    public void f(@NonNull i iVar) {
        this.i0.add(iVar);
    }

    @Deprecated
    public void g0(boolean z) {
        if (this.f0 == 1) {
            this.h0.performClick();
            if (z) {
                this.h0.jumpDrawablesToCurrentState();
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public int getBaseline() {
        EditText editText = this.f3091e;
        if (editText != null) {
            return editText.getBaseline() + getPaddingTop() + v();
        }
        return super.getBaseline();
    }

    @NonNull
    public j getBoxBackground() {
        int i2 = this.I;
        if (i2 != 1 && i2 != 2) {
            throw new IllegalStateException();
        }
        return this.D;
    }

    public int getBoxBackgroundColor() {
        return this.O;
    }

    public int getBoxBackgroundMode() {
        return this.I;
    }

    public float getBoxCornerRadiusBottomEnd() {
        return this.D.t();
    }

    public float getBoxCornerRadiusBottomStart() {
        return this.D.u();
    }

    public float getBoxCornerRadiusTopEnd() {
        return this.D.S();
    }

    public float getBoxCornerRadiusTopStart() {
        return this.D.R();
    }

    public int getBoxStrokeColor() {
        return this.R0;
    }

    @Nullable
    public ColorStateList getBoxStrokeErrorColor() {
        return this.S0;
    }

    public int getBoxStrokeWidth() {
        return this.L;
    }

    public int getBoxStrokeWidthFocused() {
        return this.M;
    }

    public int getCounterMaxLength() {
        return this.f3097k;
    }

    @Nullable
    public CharSequence getCounterOverflowDescription() {
        TextView textView;
        if (this.f3096j && this.f3098l && (textView = this.f3099m) != null) {
            return textView.getContentDescription();
        }
        return null;
    }

    @Nullable
    public ColorStateList getCounterOverflowTextColor() {
        return this.u;
    }

    @Nullable
    public ColorStateList getCounterTextColor() {
        return this.u;
    }

    @Nullable
    public ColorStateList getDefaultHintTextColor() {
        return this.N0;
    }

    @Nullable
    public EditText getEditText() {
        return this.f3091e;
    }

    @Nullable
    public CharSequence getEndIconContentDescription() {
        return this.h0.getContentDescription();
    }

    @Nullable
    public Drawable getEndIconDrawable() {
        return this.h0.getDrawable();
    }

    public int getEndIconMode() {
        return this.f0;
    }

    @NonNull
    public CheckableImageButton getEndIconView() {
        return this.h0;
    }

    @Nullable
    public CharSequence getError() {
        if (this.f3095i.C()) {
            return this.f3095i.o();
        }
        return null;
    }

    @Nullable
    public CharSequence getErrorContentDescription() {
        return this.f3095i.n();
    }

    @ColorInt
    public int getErrorCurrentTextColors() {
        return this.f3095i.p();
    }

    @Nullable
    public Drawable getErrorIconDrawable() {
        return this.L0.getDrawable();
    }

    @VisibleForTesting
    public final int getErrorTextCurrentColor() {
        return this.f3095i.p();
    }

    @Nullable
    public CharSequence getHelperText() {
        if (this.f3095i.D()) {
            return this.f3095i.r();
        }
        return null;
    }

    @ColorInt
    public int getHelperTextCurrentTextColor() {
        return this.f3095i.t();
    }

    @Nullable
    public CharSequence getHint() {
        if (this.A) {
            return this.B;
        }
        return null;
    }

    @VisibleForTesting
    public final float getHintCollapsedTextHeight() {
        return this.Z0.s();
    }

    @VisibleForTesting
    public final int getHintCurrentCollapsedTextColor() {
        return this.Z0.x();
    }

    @Nullable
    public ColorStateList getHintTextColor() {
        return this.O0;
    }

    @Px
    public int getMaxWidth() {
        return this.f3094h;
    }

    @Px
    public int getMinWidth() {
        return this.f3093g;
    }

    @Nullable
    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.h0.getContentDescription();
    }

    @Nullable
    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.h0.getDrawable();
    }

    @Nullable
    public CharSequence getPlaceholderText() {
        if (this.q) {
            return this.p;
        }
        return null;
    }

    @StyleRes
    public int getPlaceholderTextAppearance() {
        return this.t;
    }

    @Nullable
    public ColorStateList getPlaceholderTextColor() {
        return this.s;
    }

    @Nullable
    public CharSequence getPrefixText() {
        return this.w;
    }

    @Nullable
    public ColorStateList getPrefixTextColor() {
        return this.x.getTextColors();
    }

    @NonNull
    public TextView getPrefixTextView() {
        return this.x;
    }

    @Nullable
    public CharSequence getStartIconContentDescription() {
        return this.T.getContentDescription();
    }

    @Nullable
    public Drawable getStartIconDrawable() {
        return this.T.getDrawable();
    }

    @Nullable
    public CharSequence getSuffixText() {
        return this.y;
    }

    @Nullable
    public ColorStateList getSuffixTextColor() {
        return this.z.getTextColors();
    }

    @NonNull
    public TextView getSuffixTextView() {
        return this.z;
    }

    @Nullable
    public Typeface getTypeface() {
        return this.S;
    }

    @VisibleForTesting
    public void i(float f2) {
        if (this.Z0.G() == f2) {
            return;
        }
        if (this.c1 == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.c1 = valueAnimator;
            valueAnimator.setInterpolator(e.j.a.c.a.a.b);
            this.c1.setDuration(167L);
            this.c1.addUpdateListener(new d());
        }
        this.c1.setFloatValues(this.Z0.G(), f2);
        this.c1.start();
    }

    public void i0() {
        k0(this.h0, this.j0);
    }

    public void j0() {
        k0(this.L0, this.M0);
    }

    public void l0() {
        k0(this.T, this.U);
    }

    public void m0(@NonNull h hVar) {
        this.e0.remove(hVar);
    }

    public void n0(@NonNull i iVar) {
        this.i0.remove(iVar);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        EditText editText = this.f3091e;
        if (editText != null) {
            Rect rect = this.P;
            e.j.a.c.s.c.a(this, editText, rect);
            C0(rect);
            if (this.A) {
                this.Z0.r0(this.f3091e.getTextSize());
                int gravity = this.f3091e.getGravity();
                this.Z0.g0((gravity & (-113)) | 48);
                this.Z0.q0(gravity);
                this.Z0.c0(r(rect));
                this.Z0.m0(u(rect));
                this.Z0.Y();
                if (!C() || this.Y0) {
                    return;
                }
                f0();
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        boolean K0 = K0();
        boolean I0 = I0();
        if (K0 || I0) {
            this.f3091e.post(new c());
        }
        O0();
        R0();
        U0();
    }

    @Override // android.view.View
    public void onRestoreInstanceState(@Nullable Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setError(savedState.error);
        if (savedState.isEndIconChecked) {
            this.h0.post(new b());
        }
        setHint(savedState.hintText);
        setHelperText(savedState.helperText);
        setPlaceholderText(savedState.placeholderText);
        requestLayout();
    }

    @Override // android.view.View
    @Nullable
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.f3095i.l()) {
            savedState.error = getError();
        }
        savedState.isEndIconChecked = L() && this.h0.isChecked();
        savedState.hintText = getHint();
        savedState.helperText = getHelperText();
        savedState.placeholderText = getPlaceholderText();
        return savedState;
    }

    public void p0(float f2, float f3, float f4, float f5) {
        j jVar = this.D;
        if (jVar != null && jVar.R() == f2 && this.D.S() == f3 && this.D.u() == f5 && this.D.t() == f4) {
            return;
        }
        this.F = this.F.v().K(f2).P(f3).C(f5).x(f4).m();
        j();
    }

    public void q0(@DimenRes int i2, @DimenRes int i3, @DimenRes int i4, @DimenRes int i5) {
        p0(getContext().getResources().getDimension(i2), getContext().getResources().getDimension(i3), getContext().getResources().getDimension(i5), getContext().getResources().getDimension(i4));
    }

    public void setBoxBackgroundColor(@ColorInt int i2) {
        if (this.O != i2) {
            this.O = i2;
            this.T0 = i2;
            this.V0 = i2;
            this.W0 = i2;
            j();
        }
    }

    public void setBoxBackgroundColorResource(@ColorRes int i2) {
        setBoxBackgroundColor(ContextCompat.getColor(getContext(), i2));
    }

    public void setBoxBackgroundColorStateList(@NonNull ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.T0 = defaultColor;
        this.O = defaultColor;
        this.U0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.V0 = colorStateList.getColorForState(new int[]{16842908, 16842910}, -1);
        this.W0 = colorStateList.getColorForState(new int[]{16843623, 16842910}, -1);
        j();
    }

    public void setBoxBackgroundMode(int i2) {
        if (i2 == this.I) {
            return;
        }
        this.I = i2;
        if (this.f3091e != null) {
            e0();
        }
    }

    public void setBoxStrokeColor(@ColorInt int i2) {
        if (this.R0 != i2) {
            this.R0 = i2;
            W0();
        }
    }

    public void setBoxStrokeColorStateList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.isStateful()) {
            this.P0 = colorStateList.getDefaultColor();
            this.X0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
            this.Q0 = colorStateList.getColorForState(new int[]{16843623, 16842910}, -1);
            this.R0 = colorStateList.getColorForState(new int[]{16842908, 16842910}, -1);
        } else if (this.R0 != colorStateList.getDefaultColor()) {
            this.R0 = colorStateList.getDefaultColor();
        }
        W0();
    }

    public void setBoxStrokeErrorColor(@Nullable ColorStateList colorStateList) {
        if (this.S0 != colorStateList) {
            this.S0 = colorStateList;
            W0();
        }
    }

    public void setBoxStrokeWidth(int i2) {
        this.L = i2;
        W0();
    }

    public void setBoxStrokeWidthFocused(int i2) {
        this.M = i2;
        W0();
    }

    public void setBoxStrokeWidthFocusedResource(@DimenRes int i2) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(i2));
    }

    public void setBoxStrokeWidthResource(@DimenRes int i2) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(i2));
    }

    public void setCounterEnabled(boolean z) {
        if (this.f3096j != z) {
            if (z) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
                this.f3099m = appCompatTextView;
                appCompatTextView.setId(R.id.textinput_counter);
                Typeface typeface = this.S;
                if (typeface != null) {
                    this.f3099m.setTypeface(typeface);
                }
                this.f3099m.setMaxLines(1);
                this.f3095i.d(this.f3099m, 2);
                MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams) this.f3099m.getLayoutParams(), getResources().getDimensionPixelOffset(R.dimen.mtrl_textinput_counter_margin_start));
                G0();
                D0();
            } else {
                this.f3095i.E(this.f3099m, 2);
                this.f3099m = null;
            }
            this.f3096j = z;
        }
    }

    public void setCounterMaxLength(int i2) {
        if (this.f3097k != i2) {
            if (i2 > 0) {
                this.f3097k = i2;
            } else {
                this.f3097k = -1;
            }
            if (this.f3096j) {
                D0();
            }
        }
    }

    public void setCounterOverflowTextAppearance(int i2) {
        if (this.n != i2) {
            this.n = i2;
            G0();
        }
    }

    public void setCounterOverflowTextColor(@Nullable ColorStateList colorStateList) {
        if (this.v != colorStateList) {
            this.v = colorStateList;
            G0();
        }
    }

    public void setCounterTextAppearance(int i2) {
        if (this.o != i2) {
            this.o = i2;
            G0();
        }
    }

    public void setCounterTextColor(@Nullable ColorStateList colorStateList) {
        if (this.u != colorStateList) {
            this.u = colorStateList;
            G0();
        }
    }

    public void setDefaultHintTextColor(@Nullable ColorStateList colorStateList) {
        this.N0 = colorStateList;
        this.O0 = colorStateList;
        if (this.f3091e != null) {
            M0(false);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        h0(this, z);
        super.setEnabled(z);
    }

    public void setEndIconActivated(boolean z) {
        this.h0.setActivated(z);
    }

    public void setEndIconCheckable(boolean z) {
        this.h0.setCheckable(z);
    }

    public void setEndIconContentDescription(@StringRes int i2) {
        setEndIconContentDescription(i2 != 0 ? getResources().getText(i2) : null);
    }

    public void setEndIconDrawable(@DrawableRes int i2) {
        setEndIconDrawable(i2 != 0 ? AppCompatResources.getDrawable(getContext(), i2) : null);
    }

    public void setEndIconMode(int i2) {
        int i3 = this.f0;
        this.f0 = i2;
        F(i3);
        setEndIconVisible(i2 != 0);
        if (getEndIconDelegate().b(this.I)) {
            getEndIconDelegate().a();
            m();
            return;
        }
        throw new IllegalStateException("The current box background mode " + this.I + " is not supported by the end icon mode " + i2);
    }

    public void setEndIconOnClickListener(@Nullable View.OnClickListener onClickListener) {
        t0(this.h0, onClickListener, this.J0);
    }

    public void setEndIconOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        this.J0 = onLongClickListener;
        u0(this.h0, onLongClickListener);
    }

    public void setEndIconTintList(@Nullable ColorStateList colorStateList) {
        if (this.j0 != colorStateList) {
            this.j0 = colorStateList;
            this.k0 = true;
            m();
        }
    }

    public void setEndIconTintMode(@Nullable PorterDuff.Mode mode) {
        if (this.l0 != mode) {
            this.l0 = mode;
            this.m0 = true;
            m();
        }
    }

    public void setEndIconVisible(boolean z) {
        if (P() != z) {
            this.h0.setVisibility(z ? 0 : 8);
            U0();
            I0();
        }
    }

    public void setError(@Nullable CharSequence charSequence) {
        if (!this.f3095i.C()) {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            }
            setErrorEnabled(true);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            this.f3095i.R(charSequence);
        } else {
            this.f3095i.x();
        }
    }

    public void setErrorContentDescription(@Nullable CharSequence charSequence) {
        this.f3095i.G(charSequence);
    }

    public void setErrorEnabled(boolean z) {
        this.f3095i.H(z);
    }

    public void setErrorIconDrawable(@DrawableRes int i2) {
        setErrorIconDrawable(i2 != 0 ? AppCompatResources.getDrawable(getContext(), i2) : null);
        j0();
    }

    public void setErrorIconOnClickListener(@Nullable View.OnClickListener onClickListener) {
        t0(this.L0, onClickListener, this.K0);
    }

    public void setErrorIconOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        this.K0 = onLongClickListener;
        u0(this.L0, onLongClickListener);
    }

    public void setErrorIconTintList(@Nullable ColorStateList colorStateList) {
        this.M0 = colorStateList;
        Drawable drawable = this.L0.getDrawable();
        if (drawable != null) {
            drawable = DrawableCompat.wrap(drawable).mutate();
            DrawableCompat.setTintList(drawable, colorStateList);
        }
        if (this.L0.getDrawable() != drawable) {
            this.L0.setImageDrawable(drawable);
        }
    }

    public void setErrorIconTintMode(@Nullable PorterDuff.Mode mode) {
        Drawable drawable = this.L0.getDrawable();
        if (drawable != null) {
            drawable = DrawableCompat.wrap(drawable).mutate();
            DrawableCompat.setTintMode(drawable, mode);
        }
        if (this.L0.getDrawable() != drawable) {
            this.L0.setImageDrawable(drawable);
        }
    }

    public void setErrorTextAppearance(@StyleRes int i2) {
        this.f3095i.I(i2);
    }

    public void setErrorTextColor(@Nullable ColorStateList colorStateList) {
        this.f3095i.J(colorStateList);
    }

    public void setExpandedHintEnabled(boolean z) {
        if (this.a1 != z) {
            this.a1 = z;
            M0(false);
        }
    }

    public void setHelperText(@Nullable CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            if (U()) {
                setHelperTextEnabled(false);
                return;
            }
            return;
        }
        if (!U()) {
            setHelperTextEnabled(true);
        }
        this.f3095i.S(charSequence);
    }

    public void setHelperTextColor(@Nullable ColorStateList colorStateList) {
        this.f3095i.M(colorStateList);
    }

    public void setHelperTextEnabled(boolean z) {
        this.f3095i.L(z);
    }

    public void setHelperTextTextAppearance(@StyleRes int i2) {
        this.f3095i.K(i2);
    }

    public void setHint(@Nullable CharSequence charSequence) {
        if (this.A) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z) {
        this.b1 = z;
    }

    public void setHintEnabled(boolean z) {
        if (z != this.A) {
            this.A = z;
            if (!z) {
                this.C = false;
                if (!TextUtils.isEmpty(this.B) && TextUtils.isEmpty(this.f3091e.getHint())) {
                    this.f3091e.setHint(this.B);
                }
                setHintInternal(null);
            } else {
                CharSequence hint = this.f3091e.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.B)) {
                        setHint(hint);
                    }
                    this.f3091e.setHint((CharSequence) null);
                }
                this.C = true;
            }
            if (this.f3091e != null) {
                L0();
            }
        }
    }

    public void setHintTextAppearance(@StyleRes int i2) {
        this.Z0.d0(i2);
        this.O0 = this.Z0.q();
        if (this.f3091e != null) {
            M0(false);
            L0();
        }
    }

    public void setHintTextColor(@Nullable ColorStateList colorStateList) {
        if (this.O0 != colorStateList) {
            if (this.N0 == null) {
                this.Z0.f0(colorStateList);
            }
            this.O0 = colorStateList;
            if (this.f3091e != null) {
                M0(false);
            }
        }
    }

    public void setMaxWidth(@Px int i2) {
        this.f3094h = i2;
        EditText editText = this.f3091e;
        if (editText == null || i2 == -1) {
            return;
        }
        editText.setMaxWidth(i2);
    }

    public void setMaxWidthResource(@DimenRes int i2) {
        setMaxWidth(getContext().getResources().getDimensionPixelSize(i2));
    }

    public void setMinWidth(@Px int i2) {
        this.f3093g = i2;
        EditText editText = this.f3091e;
        if (editText == null || i2 == -1) {
            return;
        }
        editText.setMinWidth(i2);
    }

    public void setMinWidthResource(@DimenRes int i2) {
        setMinWidth(getContext().getResources().getDimensionPixelSize(i2));
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(@StringRes int i2) {
        setPasswordVisibilityToggleContentDescription(i2 != 0 ? getResources().getText(i2) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(@DrawableRes int i2) {
        setPasswordVisibilityToggleDrawable(i2 != 0 ? AppCompatResources.getDrawable(getContext(), i2) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z) {
        if (z && this.f0 != 1) {
            setEndIconMode(1);
        } else if (z) {
        } else {
            setEndIconMode(0);
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(@Nullable ColorStateList colorStateList) {
        this.j0 = colorStateList;
        this.k0 = true;
        m();
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(@Nullable PorterDuff.Mode mode) {
        this.l0 = mode;
        this.m0 = true;
        m();
    }

    public void setPlaceholderText(@Nullable CharSequence charSequence) {
        if (this.q && TextUtils.isEmpty(charSequence)) {
            setPlaceholderTextEnabled(false);
        } else {
            if (!this.q) {
                setPlaceholderTextEnabled(true);
            }
            this.p = charSequence;
        }
        P0();
    }

    public void setPlaceholderTextAppearance(@StyleRes int i2) {
        this.t = i2;
        TextView textView = this.r;
        if (textView != null) {
            TextViewCompat.setTextAppearance(textView, i2);
        }
    }

    public void setPlaceholderTextColor(@Nullable ColorStateList colorStateList) {
        if (this.s != colorStateList) {
            this.s = colorStateList;
            TextView textView = this.r;
            if (textView == null || colorStateList == null) {
                return;
            }
            textView.setTextColor(colorStateList);
        }
    }

    public void setPrefixText(@Nullable CharSequence charSequence) {
        this.w = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.x.setText(charSequence);
        S0();
    }

    public void setPrefixTextAppearance(@StyleRes int i2) {
        TextViewCompat.setTextAppearance(this.x, i2);
    }

    public void setPrefixTextColor(@NonNull ColorStateList colorStateList) {
        this.x.setTextColor(colorStateList);
    }

    public void setStartIconCheckable(boolean z) {
        this.T.setCheckable(z);
    }

    public void setStartIconContentDescription(@StringRes int i2) {
        setStartIconContentDescription(i2 != 0 ? getResources().getText(i2) : null);
    }

    public void setStartIconDrawable(@DrawableRes int i2) {
        setStartIconDrawable(i2 != 0 ? AppCompatResources.getDrawable(getContext(), i2) : null);
    }

    public void setStartIconOnClickListener(@Nullable View.OnClickListener onClickListener) {
        t0(this.T, onClickListener, this.d0);
    }

    public void setStartIconOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        this.d0 = onLongClickListener;
        u0(this.T, onLongClickListener);
    }

    public void setStartIconTintList(@Nullable ColorStateList colorStateList) {
        if (this.U != colorStateList) {
            this.U = colorStateList;
            this.V = true;
            o();
        }
    }

    public void setStartIconTintMode(@Nullable PorterDuff.Mode mode) {
        if (this.W != mode) {
            this.W = mode;
            this.a0 = true;
            o();
        }
    }

    public void setStartIconVisible(boolean z) {
        if (c0() != z) {
            this.T.setVisibility(z ? 0 : 8);
            R0();
            I0();
        }
    }

    public void setSuffixText(@Nullable CharSequence charSequence) {
        this.y = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.z.setText(charSequence);
        V0();
    }

    public void setSuffixTextAppearance(@StyleRes int i2) {
        TextViewCompat.setTextAppearance(this.z, i2);
    }

    public void setSuffixTextColor(@NonNull ColorStateList colorStateList) {
        this.z.setTextColor(colorStateList);
    }

    public void setTextInputAccessibilityDelegate(@Nullable e eVar) {
        EditText editText = this.f3091e;
        if (editText != null) {
            ViewCompat.setAccessibilityDelegate(editText, eVar);
        }
    }

    public void setTypeface(@Nullable Typeface typeface) {
        if (typeface != this.S) {
            this.S = typeface;
            this.Z0.H0(typeface);
            this.f3095i.O(typeface);
            TextView textView = this.f3099m;
            if (textView != null) {
                textView.setTypeface(typeface);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0015, code lost:
        if (r3.getTextColors().getDefaultColor() == (-65281)) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void v0(@androidx.annotation.NonNull android.widget.TextView r3, @androidx.annotation.StyleRes int r4) {
        /*
            r2 = this;
            r0 = 1
            androidx.core.widget.TextViewCompat.setTextAppearance(r3, r4)     // Catch: java.lang.Exception -> L1b
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L1b
            r1 = 23
            if (r4 < r1) goto L18
            android.content.res.ColorStateList r4 = r3.getTextColors()     // Catch: java.lang.Exception -> L1b
            int r4 = r4.getDefaultColor()     // Catch: java.lang.Exception -> L1b
            r1 = -65281(0xffffffffffff00ff, float:NaN)
            if (r4 != r1) goto L18
            goto L1c
        L18:
            r4 = 0
            r0 = 0
            goto L1c
        L1b:
        L1c:
            if (r0 == 0) goto L30
            int r4 = com.google.android.material.R.style.TextAppearance_AppCompat_Caption
            androidx.core.widget.TextViewCompat.setTextAppearance(r3, r4)
            android.content.Context r4 = r2.getContext()
            int r0 = com.google.android.material.R.color.design_error
            int r4 = androidx.core.content.ContextCompat.getColor(r4, r0)
            r3.setTextColor(r4)
        L30:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.v0(android.widget.TextView, int):void");
    }

    public void y() {
        this.e0.clear();
    }

    public void z() {
        this.i0.clear();
    }

    public TextInputLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textInputStyle);
    }

    public void setEndIconContentDescription(@Nullable CharSequence charSequence) {
        if (getEndIconContentDescription() != charSequence) {
            this.h0.setContentDescription(charSequence);
        }
    }

    public void setEndIconDrawable(@Nullable Drawable drawable) {
        this.h0.setImageDrawable(drawable);
        i0();
    }

    public void setStartIconContentDescription(@Nullable CharSequence charSequence) {
        if (getStartIconContentDescription() != charSequence) {
            this.T.setContentDescription(charSequence);
        }
    }

    public void setStartIconDrawable(@Nullable Drawable drawable) {
        this.T.setImageDrawable(drawable);
        if (drawable != null) {
            setStartIconVisible(true);
            l0();
            return;
        }
        setStartIconVisible(false);
        setStartIconOnClickListener(null);
        setStartIconOnLongClickListener(null);
        setStartIconContentDescription((CharSequence) null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v158 */
    /* JADX WARN: Type inference failed for: r2v46 */
    /* JADX WARN: Type inference failed for: r2v47, types: [boolean, int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public TextInputLayout(@androidx.annotation.NonNull android.content.Context r24, @androidx.annotation.Nullable android.util.AttributeSet r25, int r26) {
        /*
            Method dump skipped, instructions count: 1578
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void setErrorIconDrawable(@Nullable Drawable drawable) {
        this.L0.setImageDrawable(drawable);
        setErrorIconVisible(drawable != null && this.f3095i.C());
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(@Nullable CharSequence charSequence) {
        this.h0.setContentDescription(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(@Nullable Drawable drawable) {
        this.h0.setImageDrawable(drawable);
    }

    public void setHint(@StringRes int i2) {
        setHint(i2 != 0 ? getResources().getText(i2) : null);
    }
}
