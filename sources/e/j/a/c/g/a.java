package e.j.a.c.g;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButton;
import e.j.a.c.s.t;
import e.j.a.c.w.c;
import e.j.a.c.x.b;
import e.j.a.c.z.j;
import e.j.a.c.z.o;
import e.j.a.c.z.s;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class a {
    private static final boolean t;
    private final MaterialButton a;
    @NonNull
    private o b;

    /* renamed from: c */
    private int f10676c;

    /* renamed from: d */
    private int f10677d;

    /* renamed from: e */
    private int f10678e;

    /* renamed from: f */
    private int f10679f;

    /* renamed from: g */
    private int f10680g;

    /* renamed from: h */
    private int f10681h;
    @Nullable

    /* renamed from: i */
    private PorterDuff.Mode f10682i;
    @Nullable

    /* renamed from: j */
    private ColorStateList f10683j;
    @Nullable

    /* renamed from: k */
    private ColorStateList f10684k;
    @Nullable

    /* renamed from: l */
    private ColorStateList f10685l;
    @Nullable

    /* renamed from: m */
    private Drawable f10686m;
    private boolean n = false;
    private boolean o = false;
    private boolean p = false;
    private boolean q;
    private LayerDrawable r;
    private int s;

    static {
        t = Build.VERSION.SDK_INT >= 21;
    }

    public a(MaterialButton materialButton, @NonNull o oVar) {
        this.a = materialButton;
        this.b = oVar;
    }

    private void E(@Dimension int i2, @Dimension int i3) {
        int paddingStart = ViewCompat.getPaddingStart(this.a);
        int paddingTop = this.a.getPaddingTop();
        int paddingEnd = ViewCompat.getPaddingEnd(this.a);
        int paddingBottom = this.a.getPaddingBottom();
        int i4 = this.f10678e;
        int i5 = this.f10679f;
        this.f10679f = i3;
        this.f10678e = i2;
        if (!this.o) {
            F();
        }
        ViewCompat.setPaddingRelative(this.a, paddingStart, (paddingTop + i2) - i4, paddingEnd, (paddingBottom + i3) - i5);
    }

    private void F() {
        this.a.setInternalBackground(a());
        j f2 = f();
        if (f2 != null) {
            f2.m0(this.s);
        }
    }

    private void G(@NonNull o oVar) {
        if (f() != null) {
            f().setShapeAppearanceModel(oVar);
        }
        if (n() != null) {
            n().setShapeAppearanceModel(oVar);
        }
        if (e() != null) {
            e().setShapeAppearanceModel(oVar);
        }
    }

    private void I() {
        j f2 = f();
        j n = n();
        if (f2 != null) {
            f2.D0(this.f10681h, this.f10684k);
            if (n != null) {
                n.C0(this.f10681h, this.n ? e.j.a.c.l.a.d(this.a, R.attr.colorSurface) : 0);
            }
        }
    }

    @NonNull
    private InsetDrawable J(Drawable drawable) {
        return new InsetDrawable(drawable, this.f10676c, this.f10678e, this.f10677d, this.f10679f);
    }

    private Drawable a() {
        j jVar = new j(this.b);
        jVar.Y(this.a.getContext());
        DrawableCompat.setTintList(jVar, this.f10683j);
        PorterDuff.Mode mode = this.f10682i;
        if (mode != null) {
            DrawableCompat.setTintMode(jVar, mode);
        }
        jVar.D0(this.f10681h, this.f10684k);
        j jVar2 = new j(this.b);
        jVar2.setTint(0);
        jVar2.C0(this.f10681h, this.n ? e.j.a.c.l.a.d(this.a, R.attr.colorSurface) : 0);
        if (t) {
            j jVar3 = new j(this.b);
            this.f10686m = jVar3;
            DrawableCompat.setTint(jVar3, -1);
            RippleDrawable rippleDrawable = new RippleDrawable(b.d(this.f10685l), J(new LayerDrawable(new Drawable[]{jVar2, jVar})), this.f10686m);
            this.r = rippleDrawable;
            return rippleDrawable;
        }
        e.j.a.c.x.a aVar = new e.j.a.c.x.a(this.b);
        this.f10686m = aVar;
        DrawableCompat.setTintList(aVar, b.d(this.f10685l));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{jVar2, jVar, this.f10686m});
        this.r = layerDrawable;
        return J(layerDrawable);
    }

    @Nullable
    private j g(boolean z) {
        LayerDrawable layerDrawable = this.r;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        if (t) {
            return (j) ((LayerDrawable) ((InsetDrawable) this.r.getDrawable(0)).getDrawable()).getDrawable(!z ? 1 : 0);
        }
        return (j) this.r.getDrawable(!z ? 1 : 0);
    }

    @Nullable
    private j n() {
        return g(true);
    }

    public void A(@Nullable ColorStateList colorStateList) {
        if (this.f10684k != colorStateList) {
            this.f10684k = colorStateList;
            I();
        }
    }

    public void B(int i2) {
        if (this.f10681h != i2) {
            this.f10681h = i2;
            I();
        }
    }

    public void C(@Nullable ColorStateList colorStateList) {
        if (this.f10683j != colorStateList) {
            this.f10683j = colorStateList;
            if (f() != null) {
                DrawableCompat.setTintList(f(), this.f10683j);
            }
        }
    }

    public void D(@Nullable PorterDuff.Mode mode) {
        if (this.f10682i != mode) {
            this.f10682i = mode;
            if (f() == null || this.f10682i == null) {
                return;
            }
            DrawableCompat.setTintMode(f(), this.f10682i);
        }
    }

    public void H(int i2, int i3) {
        Drawable drawable = this.f10686m;
        if (drawable != null) {
            drawable.setBounds(this.f10676c, this.f10678e, i3 - this.f10677d, i2 - this.f10679f);
        }
    }

    public int b() {
        return this.f10680g;
    }

    public int c() {
        return this.f10679f;
    }

    public int d() {
        return this.f10678e;
    }

    @Nullable
    public s e() {
        LayerDrawable layerDrawable = this.r;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 1) {
            return null;
        }
        if (this.r.getNumberOfLayers() > 2) {
            return (s) this.r.getDrawable(2);
        }
        return (s) this.r.getDrawable(1);
    }

    @Nullable
    public j f() {
        return g(false);
    }

    @Nullable
    public ColorStateList h() {
        return this.f10685l;
    }

    @NonNull
    public o i() {
        return this.b;
    }

    @Nullable
    public ColorStateList j() {
        return this.f10684k;
    }

    public int k() {
        return this.f10681h;
    }

    public ColorStateList l() {
        return this.f10683j;
    }

    public PorterDuff.Mode m() {
        return this.f10682i;
    }

    public boolean o() {
        return this.o;
    }

    public boolean p() {
        return this.q;
    }

    public void q(@NonNull TypedArray typedArray) {
        this.f10676c = typedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetLeft, 0);
        this.f10677d = typedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetRight, 0);
        this.f10678e = typedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetTop, 0);
        this.f10679f = typedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetBottom, 0);
        int i2 = R.styleable.MaterialButton_cornerRadius;
        if (typedArray.hasValue(i2)) {
            int dimensionPixelSize = typedArray.getDimensionPixelSize(i2, -1);
            this.f10680g = dimensionPixelSize;
            y(this.b.w(dimensionPixelSize));
            this.p = true;
        }
        this.f10681h = typedArray.getDimensionPixelSize(R.styleable.MaterialButton_strokeWidth, 0);
        this.f10682i = t.k(typedArray.getInt(R.styleable.MaterialButton_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.f10683j = c.a(this.a.getContext(), typedArray, R.styleable.MaterialButton_backgroundTint);
        this.f10684k = c.a(this.a.getContext(), typedArray, R.styleable.MaterialButton_strokeColor);
        this.f10685l = c.a(this.a.getContext(), typedArray, R.styleable.MaterialButton_rippleColor);
        this.q = typedArray.getBoolean(R.styleable.MaterialButton_android_checkable, false);
        this.s = typedArray.getDimensionPixelSize(R.styleable.MaterialButton_elevation, 0);
        int paddingStart = ViewCompat.getPaddingStart(this.a);
        int paddingTop = this.a.getPaddingTop();
        int paddingEnd = ViewCompat.getPaddingEnd(this.a);
        int paddingBottom = this.a.getPaddingBottom();
        if (typedArray.hasValue(R.styleable.MaterialButton_android_background)) {
            s();
        } else {
            F();
        }
        ViewCompat.setPaddingRelative(this.a, paddingStart + this.f10676c, paddingTop + this.f10678e, paddingEnd + this.f10677d, paddingBottom + this.f10679f);
    }

    public void r(int i2) {
        if (f() != null) {
            f().setTint(i2);
        }
    }

    public void s() {
        this.o = true;
        this.a.setSupportBackgroundTintList(this.f10683j);
        this.a.setSupportBackgroundTintMode(this.f10682i);
    }

    public void t(boolean z) {
        this.q = z;
    }

    public void u(int i2) {
        if (this.p && this.f10680g == i2) {
            return;
        }
        this.f10680g = i2;
        this.p = true;
        y(this.b.w(i2));
    }

    public void v(@Dimension int i2) {
        E(this.f10678e, i2);
    }

    public void w(@Dimension int i2) {
        E(i2, this.f10679f);
    }

    public void x(@Nullable ColorStateList colorStateList) {
        if (this.f10685l != colorStateList) {
            this.f10685l = colorStateList;
            boolean z = t;
            if (z && (this.a.getBackground() instanceof RippleDrawable)) {
                ((RippleDrawable) this.a.getBackground()).setColor(b.d(colorStateList));
            } else if (z || !(this.a.getBackground() instanceof e.j.a.c.x.a)) {
            } else {
                ((e.j.a.c.x.a) this.a.getBackground()).setTintList(b.d(colorStateList));
            }
        }
    }

    public void y(@NonNull o oVar) {
        this.b = oVar;
        G(oVar);
    }

    public void z(boolean z) {
        this.n = z;
        I();
    }
}
