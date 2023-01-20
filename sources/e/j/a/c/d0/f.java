package e.j.a.c.d0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.R;
import com.google.android.material.textfield.TextInputLayout;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class f {
    private static final int A = 0;
    private static final int B = 1;
    private static final int C = 2;
    private static final int v = 217;
    private static final int w = 167;
    public static final int x = 0;
    public static final int y = 1;
    public static final int z = 2;
    private final Context a;
    @NonNull
    private final TextInputLayout b;

    /* renamed from: c  reason: collision with root package name */
    private LinearLayout f10617c;

    /* renamed from: d  reason: collision with root package name */
    private int f10618d;

    /* renamed from: e  reason: collision with root package name */
    private FrameLayout f10619e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private Animator f10620f;

    /* renamed from: g  reason: collision with root package name */
    private final float f10621g;

    /* renamed from: h  reason: collision with root package name */
    private int f10622h;

    /* renamed from: i  reason: collision with root package name */
    private int f10623i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private CharSequence f10624j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f10625k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private TextView f10626l;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private CharSequence f10627m;
    private int n;
    @Nullable
    private ColorStateList o;
    private CharSequence p;
    private boolean q;
    @Nullable
    private TextView r;
    private int s;
    @Nullable
    private ColorStateList t;
    private Typeface u;

    /* loaded from: classes2.dex */
    public class a extends AnimatorListenerAdapter {
        public final /* synthetic */ int a;
        public final /* synthetic */ TextView b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f10628c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ TextView f10629d;

        public a(int i2, TextView textView, int i3, TextView textView2) {
            this.a = i2;
            this.b = textView;
            this.f10628c = i3;
            this.f10629d = textView2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            f.this.f10622h = this.a;
            f.this.f10620f = null;
            TextView textView = this.b;
            if (textView != null) {
                textView.setVisibility(4);
                if (this.f10628c == 1 && f.this.f10626l != null) {
                    f.this.f10626l.setText((CharSequence) null);
                }
            }
            TextView textView2 = this.f10629d;
            if (textView2 != null) {
                textView2.setTranslationY(0.0f);
                this.f10629d.setAlpha(1.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            TextView textView = this.f10629d;
            if (textView != null) {
                textView.setVisibility(0);
            }
        }
    }

    public f(@NonNull TextInputLayout textInputLayout) {
        Context context = textInputLayout.getContext();
        this.a = context;
        this.b = textInputLayout;
        this.f10621g = context.getResources().getDimensionPixelSize(R.dimen.design_textinput_caption_translate_y);
    }

    private boolean A(int i2) {
        return (i2 != 2 || this.r == null || TextUtils.isEmpty(this.p)) ? false : true;
    }

    private void F(int i2, int i3) {
        TextView m2;
        TextView m3;
        if (i2 == i3) {
            return;
        }
        if (i3 != 0 && (m3 = m(i3)) != null) {
            m3.setVisibility(0);
            m3.setAlpha(1.0f);
        }
        if (i2 != 0 && (m2 = m(i2)) != null) {
            m2.setVisibility(4);
            if (i2 == 1) {
                m2.setText((CharSequence) null);
            }
        }
        this.f10622h = i3;
    }

    private void N(@Nullable TextView textView, Typeface typeface) {
        if (textView != null) {
            textView.setTypeface(typeface);
        }
    }

    private void P(@NonNull ViewGroup viewGroup, int i2) {
        if (i2 == 0) {
            viewGroup.setVisibility(8);
        }
    }

    private boolean Q(@Nullable TextView textView, @Nullable CharSequence charSequence) {
        return ViewCompat.isLaidOut(this.b) && this.b.isEnabled() && !(this.f10623i == this.f10622h && textView != null && TextUtils.equals(textView.getText(), charSequence));
    }

    private void T(int i2, int i3, boolean z2) {
        if (i2 == i3) {
            return;
        }
        if (z2) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.f10620f = animatorSet;
            ArrayList arrayList = new ArrayList();
            h(arrayList, this.q, this.r, 2, i2, i3);
            h(arrayList, this.f10625k, this.f10626l, 1, i2, i3);
            e.j.a.c.a.b.a(animatorSet, arrayList);
            animatorSet.addListener(new a(i3, m(i2), i2, m(i3)));
            animatorSet.start();
        } else {
            F(i2, i3);
        }
        this.b.J0();
        this.b.M0(z2);
        this.b.W0();
    }

    private boolean f() {
        return (this.f10617c == null || this.b.getEditText() == null) ? false : true;
    }

    private void h(@NonNull List<Animator> list, boolean z2, @Nullable TextView textView, int i2, int i3, int i4) {
        if (textView == null || !z2) {
            return;
        }
        if (i2 == i4 || i2 == i3) {
            list.add(i(textView, i4 == i2));
            if (i4 == i2) {
                list.add(j(textView));
            }
        }
    }

    private ObjectAnimator i(TextView textView, boolean z2) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, View.ALPHA, z2 ? 1.0f : 0.0f);
        ofFloat.setDuration(167L);
        ofFloat.setInterpolator(e.j.a.c.a.a.a);
        return ofFloat;
    }

    private ObjectAnimator j(TextView textView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, View.TRANSLATION_Y, -this.f10621g, 0.0f);
        ofFloat.setDuration(217L);
        ofFloat.setInterpolator(e.j.a.c.a.a.f10552d);
        return ofFloat;
    }

    @Nullable
    private TextView m(int i2) {
        if (i2 != 1) {
            if (i2 != 2) {
                return null;
            }
            return this.r;
        }
        return this.f10626l;
    }

    private int u(boolean z2, @DimenRes int i2, int i3) {
        return z2 ? this.a.getResources().getDimensionPixelSize(i2) : i3;
    }

    private boolean z(int i2) {
        return (i2 != 1 || this.f10626l == null || TextUtils.isEmpty(this.f10624j)) ? false : true;
    }

    public boolean B(int i2) {
        return i2 == 0 || i2 == 1;
    }

    public boolean C() {
        return this.f10625k;
    }

    public boolean D() {
        return this.q;
    }

    public void E(TextView textView, int i2) {
        FrameLayout frameLayout;
        if (this.f10617c == null) {
            return;
        }
        if (B(i2) && (frameLayout = this.f10619e) != null) {
            frameLayout.removeView(textView);
        } else {
            this.f10617c.removeView(textView);
        }
        int i3 = this.f10618d - 1;
        this.f10618d = i3;
        P(this.f10617c, i3);
    }

    public void G(@Nullable CharSequence charSequence) {
        this.f10627m = charSequence;
        TextView textView = this.f10626l;
        if (textView != null) {
            textView.setContentDescription(charSequence);
        }
    }

    public void H(boolean z2) {
        if (this.f10625k == z2) {
            return;
        }
        g();
        if (z2) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(this.a);
            this.f10626l = appCompatTextView;
            appCompatTextView.setId(R.id.textinput_error);
            if (Build.VERSION.SDK_INT >= 17) {
                this.f10626l.setTextAlignment(5);
            }
            Typeface typeface = this.u;
            if (typeface != null) {
                this.f10626l.setTypeface(typeface);
            }
            I(this.n);
            J(this.o);
            G(this.f10627m);
            this.f10626l.setVisibility(4);
            ViewCompat.setAccessibilityLiveRegion(this.f10626l, 1);
            d(this.f10626l, 0);
        } else {
            x();
            E(this.f10626l, 0);
            this.f10626l = null;
            this.b.J0();
            this.b.W0();
        }
        this.f10625k = z2;
    }

    public void I(@StyleRes int i2) {
        this.n = i2;
        TextView textView = this.f10626l;
        if (textView != null) {
            this.b.v0(textView, i2);
        }
    }

    public void J(@Nullable ColorStateList colorStateList) {
        this.o = colorStateList;
        TextView textView = this.f10626l;
        if (textView == null || colorStateList == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    public void K(@StyleRes int i2) {
        this.s = i2;
        TextView textView = this.r;
        if (textView != null) {
            TextViewCompat.setTextAppearance(textView, i2);
        }
    }

    public void L(boolean z2) {
        if (this.q == z2) {
            return;
        }
        g();
        if (z2) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(this.a);
            this.r = appCompatTextView;
            appCompatTextView.setId(R.id.textinput_helper_text);
            if (Build.VERSION.SDK_INT >= 17) {
                this.r.setTextAlignment(5);
            }
            Typeface typeface = this.u;
            if (typeface != null) {
                this.r.setTypeface(typeface);
            }
            this.r.setVisibility(4);
            ViewCompat.setAccessibilityLiveRegion(this.r, 1);
            K(this.s);
            M(this.t);
            d(this.r, 1);
        } else {
            y();
            E(this.r, 1);
            this.r = null;
            this.b.J0();
            this.b.W0();
        }
        this.q = z2;
    }

    public void M(@Nullable ColorStateList colorStateList) {
        this.t = colorStateList;
        TextView textView = this.r;
        if (textView == null || colorStateList == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    public void O(Typeface typeface) {
        if (typeface != this.u) {
            this.u = typeface;
            N(this.f10626l, typeface);
            N(this.r, typeface);
        }
    }

    public void R(CharSequence charSequence) {
        g();
        this.f10624j = charSequence;
        this.f10626l.setText(charSequence);
        int i2 = this.f10622h;
        if (i2 != 1) {
            this.f10623i = 1;
        }
        T(i2, this.f10623i, Q(this.f10626l, charSequence));
    }

    public void S(CharSequence charSequence) {
        g();
        this.p = charSequence;
        this.r.setText(charSequence);
        int i2 = this.f10622h;
        if (i2 != 2) {
            this.f10623i = 2;
        }
        T(i2, this.f10623i, Q(this.r, charSequence));
    }

    public void d(TextView textView, int i2) {
        if (this.f10617c == null && this.f10619e == null) {
            LinearLayout linearLayout = new LinearLayout(this.a);
            this.f10617c = linearLayout;
            linearLayout.setOrientation(0);
            this.b.addView(this.f10617c, -1, -2);
            this.f10619e = new FrameLayout(this.a);
            this.f10617c.addView(this.f10619e, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (this.b.getEditText() != null) {
                e();
            }
        }
        if (B(i2)) {
            this.f10619e.setVisibility(0);
            this.f10619e.addView(textView);
        } else {
            this.f10617c.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        }
        this.f10617c.setVisibility(0);
        this.f10618d++;
    }

    public void e() {
        if (f()) {
            EditText editText = this.b.getEditText();
            boolean g2 = e.j.a.c.w.c.g(this.a);
            LinearLayout linearLayout = this.f10617c;
            int i2 = R.dimen.material_helper_text_font_1_3_padding_horizontal;
            ViewCompat.setPaddingRelative(linearLayout, u(g2, i2, ViewCompat.getPaddingStart(editText)), u(g2, R.dimen.material_helper_text_font_1_3_padding_top, this.a.getResources().getDimensionPixelSize(R.dimen.material_helper_text_default_padding_top)), u(g2, i2, ViewCompat.getPaddingEnd(editText)), 0);
        }
    }

    public void g() {
        Animator animator = this.f10620f;
        if (animator != null) {
            animator.cancel();
        }
    }

    public boolean k() {
        return z(this.f10622h);
    }

    public boolean l() {
        return z(this.f10623i);
    }

    @Nullable
    public CharSequence n() {
        return this.f10627m;
    }

    @Nullable
    public CharSequence o() {
        return this.f10624j;
    }

    @ColorInt
    public int p() {
        TextView textView = this.f10626l;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    @Nullable
    public ColorStateList q() {
        TextView textView = this.f10626l;
        if (textView != null) {
            return textView.getTextColors();
        }
        return null;
    }

    public CharSequence r() {
        return this.p;
    }

    @Nullable
    public ColorStateList s() {
        TextView textView = this.r;
        if (textView != null) {
            return textView.getTextColors();
        }
        return null;
    }

    @ColorInt
    public int t() {
        TextView textView = this.r;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    public boolean v() {
        return A(this.f10622h);
    }

    public boolean w() {
        return A(this.f10623i);
    }

    public void x() {
        this.f10624j = null;
        g();
        if (this.f10622h == 1) {
            if (this.q && !TextUtils.isEmpty(this.p)) {
                this.f10623i = 2;
            } else {
                this.f10623i = 0;
            }
        }
        T(this.f10622h, this.f10623i, Q(this.f10626l, null));
    }

    public void y() {
        g();
        int i2 = this.f10622h;
        if (i2 == 2) {
            this.f10623i = 0;
        }
        T(i2, this.f10623i, Q(this.r, null));
    }
}
