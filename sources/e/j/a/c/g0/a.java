package e.j.a.c.g0;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.R;
import e.j.a.c.s.j;
import e.j.a.c.s.m;
import e.j.a.c.w.c;
import e.j.a.c.w.d;
import e.j.a.c.z.g;
import e.j.a.c.z.i;
import e.j.a.c.z.j;
import e.j.a.c.z.l;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class a extends j implements j.b {
    @StyleRes
    private static final int U = R.style.Widget_MaterialComponents_Tooltip;
    @AttrRes
    private static final int V = R.attr.tooltipStyle;
    @Nullable
    private CharSequence D;
    @NonNull
    private final Context E;
    @Nullable
    private final Paint.FontMetrics F;
    @NonNull
    private final e.j.a.c.s.j G;
    @NonNull
    private final View.OnLayoutChangeListener H;
    @NonNull
    private final Rect I;
    private int J;
    private int K;
    private int L;
    private int M;
    private int N;
    private int O;
    private float P;
    private float Q;
    private final float R;
    private float S;
    private float T;

    /* renamed from: e.j.a.c.g0.a$a */
    /* loaded from: classes2.dex */
    public class View$OnLayoutChangeListenerC0360a implements View.OnLayoutChangeListener {
        public View$OnLayoutChangeListenerC0360a() {
            a.this = r1;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            a.this.q1(view);
        }
    }

    private a(@NonNull Context context, AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        super(context, attributeSet, i2, i3);
        this.F = new Paint.FontMetrics();
        e.j.a.c.s.j jVar = new e.j.a.c.s.j(this);
        this.G = jVar;
        this.H = new View$OnLayoutChangeListenerC0360a();
        this.I = new Rect();
        this.P = 1.0f;
        this.Q = 1.0f;
        this.R = 0.5f;
        this.S = 0.5f;
        this.T = 1.0f;
        this.E = context;
        jVar.e().density = context.getResources().getDisplayMetrics().density;
        jVar.e().setTextAlign(Paint.Align.CENTER);
    }

    private float P0() {
        int i2;
        if (((this.I.right - getBounds().right) - this.O) - this.M < 0) {
            i2 = ((this.I.right - getBounds().right) - this.O) - this.M;
        } else if (((this.I.left - getBounds().left) - this.O) + this.M <= 0) {
            return 0.0f;
        } else {
            i2 = ((this.I.left - getBounds().left) - this.O) + this.M;
        }
        return i2;
    }

    private float Q0() {
        this.G.e().getFontMetrics(this.F);
        Paint.FontMetrics fontMetrics = this.F;
        return (fontMetrics.descent + fontMetrics.ascent) / 2.0f;
    }

    private float R0(@NonNull Rect rect) {
        return rect.centerY() - Q0();
    }

    @NonNull
    public static a S0(@NonNull Context context) {
        return U0(context, null, V, U);
    }

    @NonNull
    public static a T0(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        return U0(context, attributeSet, V, U);
    }

    @NonNull
    public static a U0(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        a aVar = new a(context, attributeSet, i2, i3);
        aVar.f1(attributeSet, i2, i3);
        return aVar;
    }

    private g V0() {
        float width = ((float) (getBounds().width() - (this.N * Math.sqrt(2.0d)))) / 2.0f;
        return new l(new i(this.N), Math.min(Math.max(-P0(), -width), width));
    }

    private void X0(@NonNull Canvas canvas) {
        if (this.D == null) {
            return;
        }
        Rect bounds = getBounds();
        int R0 = (int) R0(bounds);
        if (this.G.d() != null) {
            this.G.e().drawableState = getState();
            this.G.k(this.E);
            this.G.e().setAlpha((int) (this.T * 255.0f));
        }
        CharSequence charSequence = this.D;
        canvas.drawText(charSequence, 0, charSequence.length(), bounds.centerX(), R0, this.G.e());
    }

    private float e1() {
        CharSequence charSequence = this.D;
        if (charSequence == null) {
            return 0.0f;
        }
        return this.G.f(charSequence.toString());
    }

    private void f1(@Nullable AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        TypedArray j2 = m.j(this.E, attributeSet, R.styleable.Tooltip, i2, i3, new int[0]);
        this.N = this.E.getResources().getDimensionPixelSize(R.dimen.mtrl_tooltip_arrowSize);
        setShapeAppearanceModel(getShapeAppearanceModel().v().t(V0()).m());
        l1(j2.getText(R.styleable.Tooltip_android_text));
        m1(c.f(this.E, j2, R.styleable.Tooltip_android_textAppearance));
        n0(ColorStateList.valueOf(j2.getColor(R.styleable.Tooltip_backgroundTint, e.j.a.c.l.a.g(ColorUtils.setAlphaComponent(e.j.a.c.l.a.c(this.E, 16842801, a.class.getCanonicalName()), 229), ColorUtils.setAlphaComponent(e.j.a.c.l.a.c(this.E, R.attr.colorOnBackground, a.class.getCanonicalName()), 153)))));
        E0(ColorStateList.valueOf(e.j.a.c.l.a.c(this.E, R.attr.colorSurface, a.class.getCanonicalName())));
        this.J = j2.getDimensionPixelSize(R.styleable.Tooltip_android_padding, 0);
        this.K = j2.getDimensionPixelSize(R.styleable.Tooltip_android_minWidth, 0);
        this.L = j2.getDimensionPixelSize(R.styleable.Tooltip_android_minHeight, 0);
        this.M = j2.getDimensionPixelSize(R.styleable.Tooltip_android_layout_margin, 0);
        j2.recycle();
    }

    public void q1(@NonNull View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        this.O = iArr[0];
        view.getWindowVisibleDisplayFrame(this.I);
    }

    public void W0(@Nullable View view) {
        if (view == null) {
            return;
        }
        view.removeOnLayoutChangeListener(this.H);
    }

    public int Y0() {
        return this.M;
    }

    public int Z0() {
        return this.L;
    }

    @Override // e.j.a.c.s.j.b
    public void a() {
        invalidateSelf();
    }

    public int a1() {
        return this.K;
    }

    @Nullable
    public CharSequence b1() {
        return this.D;
    }

    @Nullable
    public d c1() {
        return this.G.d();
    }

    public int d1() {
        return this.J;
    }

    @Override // e.j.a.c.z.j, android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        canvas.save();
        canvas.scale(this.P, this.Q, getBounds().left + (getBounds().width() * 0.5f), getBounds().top + (getBounds().height() * this.S));
        canvas.translate(P0(), (float) (-((this.N * Math.sqrt(2.0d)) - this.N)));
        super.draw(canvas);
        X0(canvas);
        canvas.restore();
    }

    public void g1(@Px int i2) {
        this.M = i2;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) Math.max(this.G.e().getTextSize(), this.L);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (int) Math.max((this.J * 2) + e1(), this.K);
    }

    public void h1(@Px int i2) {
        this.L = i2;
        invalidateSelf();
    }

    public void i1(@Px int i2) {
        this.K = i2;
        invalidateSelf();
    }

    public void j1(@Nullable View view) {
        if (view == null) {
            return;
        }
        q1(view);
        view.addOnLayoutChangeListener(this.H);
    }

    public void k1(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.S = 1.2f;
        this.P = f2;
        this.Q = f2;
        this.T = e.j.a.c.a.a.b(0.0f, 1.0f, 0.19f, 1.0f, f2);
        invalidateSelf();
    }

    public void l1(@Nullable CharSequence charSequence) {
        if (TextUtils.equals(this.D, charSequence)) {
            return;
        }
        this.D = charSequence;
        this.G.j(true);
        invalidateSelf();
    }

    public void m1(@Nullable d dVar) {
        this.G.i(dVar, this.E);
    }

    public void n1(@StyleRes int i2) {
        m1(new d(this.E, i2));
    }

    public void o1(@Px int i2) {
        this.J = i2;
        invalidateSelf();
    }

    @Override // e.j.a.c.z.j, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        setShapeAppearanceModel(getShapeAppearanceModel().v().t(V0()).m());
    }

    @Override // e.j.a.c.z.j, android.graphics.drawable.Drawable, e.j.a.c.s.j.b
    public boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    public void p1(@StringRes int i2) {
        l1(this.E.getResources().getString(i2));
    }
}
