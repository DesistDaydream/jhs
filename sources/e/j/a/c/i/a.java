package e.j.a.c.i;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.card.MaterialCardView;
import e.j.a.c.w.c;
import e.j.a.c.x.b;
import e.j.a.c.z.e;
import e.j.a.c.z.f;
import e.j.a.c.z.j;
import e.j.a.c.z.n;
import e.j.a.c.z.o;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class a {
    private static final int u = -1;
    private static final float w = 1.5f;
    private static final int x = 2;
    @NonNull
    private final MaterialCardView a;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final j f10845c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final j f10846d;
    @Dimension

    /* renamed from: e  reason: collision with root package name */
    private int f10847e;
    @Dimension

    /* renamed from: f  reason: collision with root package name */
    private int f10848f;
    @Dimension

    /* renamed from: g  reason: collision with root package name */
    private int f10849g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private Drawable f10850h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private Drawable f10851i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private ColorStateList f10852j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private ColorStateList f10853k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private o f10854l;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private ColorStateList f10855m;
    @Nullable
    private Drawable n;
    @Nullable
    private LayerDrawable o;
    @Nullable
    private j p;
    @Nullable
    private j q;
    private boolean s;
    private static final int[] t = {16842912};
    private static final double v = Math.cos(Math.toRadians(45.0d));
    @NonNull
    private final Rect b = new Rect();
    private boolean r = false;

    /* renamed from: e.j.a.c.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0363a extends InsetDrawable {
        public C0363a(Drawable drawable, int i2, int i3, int i4, int i5) {
            super(drawable, i2, i3, i4, i5);
        }

        @Override // android.graphics.drawable.Drawable
        public int getMinimumHeight() {
            return -1;
        }

        @Override // android.graphics.drawable.Drawable
        public int getMinimumWidth() {
            return -1;
        }

        @Override // android.graphics.drawable.InsetDrawable, android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
        public boolean getPadding(Rect rect) {
            return false;
        }
    }

    public a(@NonNull MaterialCardView materialCardView, AttributeSet attributeSet, int i2, @StyleRes int i3) {
        this.a = materialCardView;
        j jVar = new j(materialCardView.getContext(), attributeSet, i2, i3);
        this.f10845c = jVar;
        jVar.Y(materialCardView.getContext());
        jVar.u0(-12303292);
        o.b v2 = jVar.getShapeAppearanceModel().v();
        TypedArray obtainStyledAttributes = materialCardView.getContext().obtainStyledAttributes(attributeSet, R.styleable.CardView, i2, R.style.CardView);
        int i4 = R.styleable.CardView_cardCornerRadius;
        if (obtainStyledAttributes.hasValue(i4)) {
            v2.o(obtainStyledAttributes.getDimension(i4, 0.0f));
        }
        this.f10846d = new j();
        R(v2.m());
        obtainStyledAttributes.recycle();
    }

    @NonNull
    private Drawable B(Drawable drawable) {
        int ceil;
        int i2;
        if ((Build.VERSION.SDK_INT < 21) || this.a.getUseCompatPadding()) {
            int ceil2 = (int) Math.ceil(d());
            ceil = (int) Math.ceil(c());
            i2 = ceil2;
        } else {
            ceil = 0;
            i2 = 0;
        }
        return new C0363a(drawable, ceil, i2, ceil, i2);
    }

    private boolean V() {
        return this.a.getPreventCornerOverlap() && !e();
    }

    private boolean W() {
        return this.a.getPreventCornerOverlap() && e() && this.a.getUseCompatPadding();
    }

    private float a() {
        return Math.max(Math.max(b(this.f10854l.q(), this.f10845c.R()), b(this.f10854l.s(), this.f10845c.S())), Math.max(b(this.f10854l.k(), this.f10845c.u()), b(this.f10854l.i(), this.f10845c.t())));
    }

    private void a0(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 23 && (this.a.getForeground() instanceof InsetDrawable)) {
            ((InsetDrawable) this.a.getForeground()).setDrawable(drawable);
        } else {
            this.a.setForeground(B(drawable));
        }
    }

    private float b(e eVar, float f2) {
        if (eVar instanceof n) {
            return (float) ((1.0d - v) * f2);
        }
        if (eVar instanceof f) {
            return f2 / 2.0f;
        }
        return 0.0f;
    }

    private float c() {
        return this.a.getMaxCardElevation() + (W() ? a() : 0.0f);
    }

    private void c0() {
        Drawable drawable;
        if (b.a && (drawable = this.n) != null) {
            ((RippleDrawable) drawable).setColor(this.f10852j);
            return;
        }
        j jVar = this.p;
        if (jVar != null) {
            jVar.n0(this.f10852j);
        }
    }

    private float d() {
        return (this.a.getMaxCardElevation() * 1.5f) + (W() ? a() : 0.0f);
    }

    private boolean e() {
        return Build.VERSION.SDK_INT >= 21 && this.f10845c.d0();
    }

    @NonNull
    private Drawable f() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable drawable = this.f10851i;
        if (drawable != null) {
            stateListDrawable.addState(t, drawable);
        }
        return stateListDrawable;
    }

    @NonNull
    private Drawable g() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        j i2 = i();
        this.p = i2;
        i2.n0(this.f10852j);
        stateListDrawable.addState(new int[]{16842919}, this.p);
        return stateListDrawable;
    }

    @NonNull
    private Drawable h() {
        if (b.a) {
            this.q = i();
            return new RippleDrawable(this.f10852j, null, this.q);
        }
        return g();
    }

    @NonNull
    private j i() {
        return new j(this.f10854l);
    }

    @NonNull
    private Drawable r() {
        if (this.n == null) {
            this.n = h();
        }
        if (this.o == null) {
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{this.n, this.f10846d, f()});
            this.o = layerDrawable;
            layerDrawable.setId(2, R.id.mtrl_card_checked_layer_id);
        }
        return this.o;
    }

    private float t() {
        if (this.a.getPreventCornerOverlap()) {
            if (Build.VERSION.SDK_INT < 21 || this.a.getUseCompatPadding()) {
                return (float) ((1.0d - v) * this.a.getCardViewRadius());
            }
            return 0.0f;
        }
        return 0.0f;
    }

    @NonNull
    public Rect A() {
        return this.b;
    }

    public boolean C() {
        return this.r;
    }

    public boolean D() {
        return this.s;
    }

    public void E(@NonNull TypedArray typedArray) {
        ColorStateList a = c.a(this.a.getContext(), typedArray, R.styleable.MaterialCardView_strokeColor);
        this.f10855m = a;
        if (a == null) {
            this.f10855m = ColorStateList.valueOf(-1);
        }
        this.f10849g = typedArray.getDimensionPixelSize(R.styleable.MaterialCardView_strokeWidth, 0);
        boolean z = typedArray.getBoolean(R.styleable.MaterialCardView_android_checkable, false);
        this.s = z;
        this.a.setLongClickable(z);
        this.f10853k = c.a(this.a.getContext(), typedArray, R.styleable.MaterialCardView_checkedIconTint);
        K(c.d(this.a.getContext(), typedArray, R.styleable.MaterialCardView_checkedIcon));
        M(typedArray.getDimensionPixelSize(R.styleable.MaterialCardView_checkedIconSize, 0));
        L(typedArray.getDimensionPixelSize(R.styleable.MaterialCardView_checkedIconMargin, 0));
        ColorStateList a2 = c.a(this.a.getContext(), typedArray, R.styleable.MaterialCardView_rippleColor);
        this.f10852j = a2;
        if (a2 == null) {
            this.f10852j = ColorStateList.valueOf(e.j.a.c.l.a.d(this.a, R.attr.colorControlHighlight));
        }
        I(c.a(this.a.getContext(), typedArray, R.styleable.MaterialCardView_cardForegroundColor));
        c0();
        Z();
        d0();
        this.a.setBackgroundInternal(B(this.f10845c));
        Drawable r = this.a.isClickable() ? r() : this.f10846d;
        this.f10850h = r;
        this.a.setForeground(B(r));
    }

    public void F(int i2, int i3) {
        int i4;
        int i5;
        if (this.o != null) {
            int i6 = this.f10847e;
            int i7 = this.f10848f;
            int i8 = (i2 - i6) - i7;
            int i9 = (i3 - i6) - i7;
            if ((Build.VERSION.SDK_INT < 21) || this.a.getUseCompatPadding()) {
                i9 -= (int) Math.ceil(d() * 2.0f);
                i8 -= (int) Math.ceil(c() * 2.0f);
            }
            int i10 = i9;
            int i11 = this.f10847e;
            if (ViewCompat.getLayoutDirection(this.a) == 1) {
                i5 = i8;
                i4 = i11;
            } else {
                i4 = i8;
                i5 = i11;
            }
            this.o.setLayerInset(2, i4, this.f10847e, i5, i10);
        }
    }

    public void G(boolean z) {
        this.r = z;
    }

    public void H(ColorStateList colorStateList) {
        this.f10845c.n0(colorStateList);
    }

    public void I(@Nullable ColorStateList colorStateList) {
        j jVar = this.f10846d;
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        jVar.n0(colorStateList);
    }

    public void J(boolean z) {
        this.s = z;
    }

    public void K(@Nullable Drawable drawable) {
        this.f10851i = drawable;
        if (drawable != null) {
            Drawable wrap = DrawableCompat.wrap(drawable.mutate());
            this.f10851i = wrap;
            DrawableCompat.setTintList(wrap, this.f10853k);
        }
        if (this.o != null) {
            this.o.setDrawableByLayerId(R.id.mtrl_card_checked_layer_id, f());
        }
    }

    public void L(@Dimension int i2) {
        this.f10847e = i2;
    }

    public void M(@Dimension int i2) {
        this.f10848f = i2;
    }

    public void N(@Nullable ColorStateList colorStateList) {
        this.f10853k = colorStateList;
        Drawable drawable = this.f10851i;
        if (drawable != null) {
            DrawableCompat.setTintList(drawable, colorStateList);
        }
    }

    public void O(float f2) {
        R(this.f10854l.w(f2));
        this.f10850h.invalidateSelf();
        if (W() || V()) {
            Y();
        }
        if (W()) {
            b0();
        }
    }

    public void P(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.f10845c.o0(f2);
        j jVar = this.f10846d;
        if (jVar != null) {
            jVar.o0(f2);
        }
        j jVar2 = this.q;
        if (jVar2 != null) {
            jVar2.o0(f2);
        }
    }

    public void Q(@Nullable ColorStateList colorStateList) {
        this.f10852j = colorStateList;
        c0();
    }

    public void R(@NonNull o oVar) {
        this.f10854l = oVar;
        this.f10845c.setShapeAppearanceModel(oVar);
        j jVar = this.f10845c;
        jVar.t0(!jVar.d0());
        j jVar2 = this.f10846d;
        if (jVar2 != null) {
            jVar2.setShapeAppearanceModel(oVar);
        }
        j jVar3 = this.q;
        if (jVar3 != null) {
            jVar3.setShapeAppearanceModel(oVar);
        }
        j jVar4 = this.p;
        if (jVar4 != null) {
            jVar4.setShapeAppearanceModel(oVar);
        }
    }

    public void S(ColorStateList colorStateList) {
        if (this.f10855m == colorStateList) {
            return;
        }
        this.f10855m = colorStateList;
        d0();
    }

    public void T(@Dimension int i2) {
        if (i2 == this.f10849g) {
            return;
        }
        this.f10849g = i2;
        d0();
    }

    public void U(int i2, int i3, int i4, int i5) {
        this.b.set(i2, i3, i4, i5);
        Y();
    }

    public void X() {
        Drawable drawable = this.f10850h;
        Drawable r = this.a.isClickable() ? r() : this.f10846d;
        this.f10850h = r;
        if (drawable != r) {
            a0(r);
        }
    }

    public void Y() {
        int a = (int) ((V() || W() ? a() : 0.0f) - t());
        MaterialCardView materialCardView = this.a;
        Rect rect = this.b;
        materialCardView.i(rect.left + a, rect.top + a, rect.right + a, rect.bottom + a);
    }

    public void Z() {
        this.f10845c.m0(this.a.getCardElevation());
    }

    public void b0() {
        if (!C()) {
            this.a.setBackgroundInternal(B(this.f10845c));
        }
        this.a.setForeground(B(this.f10850h));
    }

    public void d0() {
        this.f10846d.D0(this.f10849g, this.f10855m);
    }

    @RequiresApi(api = 23)
    public void j() {
        Drawable drawable = this.n;
        if (drawable != null) {
            Rect bounds = drawable.getBounds();
            int i2 = bounds.bottom;
            this.n.setBounds(bounds.left, bounds.top, bounds.right, i2 - 1);
            this.n.setBounds(bounds.left, bounds.top, bounds.right, i2);
        }
    }

    @NonNull
    public j k() {
        return this.f10845c;
    }

    public ColorStateList l() {
        return this.f10845c.y();
    }

    public ColorStateList m() {
        return this.f10846d.y();
    }

    @Nullable
    public Drawable n() {
        return this.f10851i;
    }

    @Dimension
    public int o() {
        return this.f10847e;
    }

    @Dimension
    public int p() {
        return this.f10848f;
    }

    @Nullable
    public ColorStateList q() {
        return this.f10853k;
    }

    public float s() {
        return this.f10845c.R();
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float u() {
        return this.f10845c.z();
    }

    @Nullable
    public ColorStateList v() {
        return this.f10852j;
    }

    public o w() {
        return this.f10854l;
    }

    @ColorInt
    public int x() {
        ColorStateList colorStateList = this.f10855m;
        if (colorStateList == null) {
            return -1;
        }
        return colorStateList.getDefaultColor();
    }

    @Nullable
    public ColorStateList y() {
        return this.f10855m;
    }

    @Dimension
    public int z() {
        return this.f10849g;
    }
}
