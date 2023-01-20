package e.j.a.c.j;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.annotation.AnimatorRes;
import androidx.annotation.AttrRes;
import androidx.annotation.BoolRes;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.annotation.XmlRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.ColorUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.core.text.BidiFormatter;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import e.j.a.c.a.h;
import e.j.a.c.s.j;
import e.j.a.c.s.m;
import e.j.a.c.s.t;
import e.j.a.c.w.c;
import e.j.a.c.w.d;
import e.j.a.c.x.b;
import e.j.a.c.z.j;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* loaded from: classes2.dex */
public class a extends j implements TintAwareDrawable, Drawable.Callback, j.b {
    private static final boolean g1 = false;
    private static final String i1 = "http://schemas.android.com/apk/res-auto";
    private static final int j1 = 24;
    @Nullable
    private ColorStateList D;
    @Nullable
    private ColorStateList E;
    private float F;
    private float G;
    private final Paint.FontMetrics G0;
    @Nullable
    private ColorStateList H;
    private final RectF H0;
    private float I;
    private final PointF I0;
    @Nullable
    private ColorStateList J;
    private final Path J0;
    @Nullable
    private CharSequence K;
    @NonNull
    private final e.j.a.c.s.j K0;
    private boolean L;
    @ColorInt
    private int L0;
    @Nullable
    private Drawable M;
    @ColorInt
    private int M0;
    @Nullable
    private ColorStateList N;
    @ColorInt
    private int N0;
    private float O;
    @ColorInt
    private int O0;
    private boolean P;
    @ColorInt
    private int P0;
    private boolean Q;
    @ColorInt
    private int Q0;
    @Nullable
    private Drawable R;
    private boolean R0;
    @Nullable
    private Drawable S;
    @ColorInt
    private int S0;
    @Nullable
    private ColorStateList T;
    private int T0;
    private float U;
    @Nullable
    private ColorFilter U0;
    @Nullable
    private CharSequence V;
    @Nullable
    private PorterDuffColorFilter V0;
    private boolean W;
    @Nullable
    private ColorStateList W0;
    private boolean X;
    @Nullable
    private PorterDuff.Mode X0;
    @Nullable
    private Drawable Y;
    private int[] Y0;
    @Nullable
    private ColorStateList Z;
    private boolean Z0;
    @Nullable
    private h a0;
    @Nullable
    private ColorStateList a1;
    @Nullable
    private h b0;
    @NonNull
    private WeakReference<InterfaceC0364a> b1;
    private float c0;
    private TextUtils.TruncateAt c1;
    private float d0;
    private boolean d1;
    private float e0;
    private int e1;
    private float f0;
    private boolean f1;
    private float g0;
    private float h0;
    private float i0;
    private float j0;
    @NonNull
    private final Context k0;
    private final Paint l0;
    @Nullable
    private final Paint m0;
    private static final int[] h1 = {16842910};
    private static final ShapeDrawable k1 = new ShapeDrawable(new OvalShape());

    /* renamed from: e.j.a.c.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0364a {
        void a();
    }

    private a(@NonNull Context context, AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        super(context, attributeSet, i2, i3);
        this.G = -1.0f;
        this.l0 = new Paint(1);
        this.G0 = new Paint.FontMetrics();
        this.H0 = new RectF();
        this.I0 = new PointF();
        this.J0 = new Path();
        this.T0 = 255;
        this.X0 = PorterDuff.Mode.SRC_IN;
        this.b1 = new WeakReference<>(null);
        Y(context);
        this.k0 = context;
        e.j.a.c.s.j jVar = new e.j.a.c.s.j(this);
        this.K0 = jVar;
        this.K = "";
        jVar.e().density = context.getResources().getDisplayMetrics().density;
        this.m0 = null;
        int[] iArr = h1;
        setState(iArr);
        e3(iArr);
        this.d1 = true;
        if (b.a) {
            k1.setTint(-1);
        }
    }

    private float F1() {
        Drawable drawable = this.R0 ? this.Y : this.M;
        float f2 = this.O;
        if (f2 <= 0.0f && drawable != null) {
            f2 = (float) Math.ceil(t.e(this.k0, 24));
            if (drawable.getIntrinsicHeight() <= f2) {
                return drawable.getIntrinsicHeight();
            }
        }
        return f2;
    }

    private float G1() {
        Drawable drawable = this.R0 ? this.Y : this.M;
        float f2 = this.O;
        return (f2 > 0.0f || drawable == null) ? f2 : drawable.getIntrinsicWidth();
    }

    private boolean I3() {
        return this.X && this.Y != null && this.R0;
    }

    private boolean J3() {
        return this.L && this.M != null;
    }

    private boolean K3() {
        return this.Q && this.R != null;
    }

    private void L3(@Nullable Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    private void M3() {
        this.a1 = this.Z0 ? b.d(this.J) : null;
    }

    @TargetApi(21)
    private void N3() {
        this.S = new RippleDrawable(b.d(M1()), this.R, k1);
    }

    private void O0(@Nullable Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setCallback(this);
        DrawableCompat.setLayoutDirection(drawable, DrawableCompat.getLayoutDirection(this));
        drawable.setLevel(getLevel());
        drawable.setVisible(isVisible(), false);
        if (drawable == this.R) {
            if (drawable.isStateful()) {
                drawable.setState(C1());
            }
            DrawableCompat.setTintList(drawable, this.T);
            return;
        }
        if (drawable.isStateful()) {
            drawable.setState(getState());
        }
        Drawable drawable2 = this.M;
        if (drawable == drawable2 && this.P) {
            DrawableCompat.setTintList(drawable2, this.N);
        }
    }

    private void P0(@NonNull Rect rect, @NonNull RectF rectF) {
        rectF.setEmpty();
        if (J3() || I3()) {
            float f2 = this.c0 + this.d0;
            float G1 = G1();
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                float f3 = rect.left + f2;
                rectF.left = f3;
                rectF.right = f3 + G1;
            } else {
                float f4 = rect.right - f2;
                rectF.right = f4;
                rectF.left = f4 - G1;
            }
            float F1 = F1();
            float exactCenterY = rect.exactCenterY() - (F1 / 2.0f);
            rectF.top = exactCenterY;
            rectF.bottom = exactCenterY + F1;
        }
    }

    private void R0(@NonNull Rect rect, @NonNull RectF rectF) {
        rectF.set(rect);
        if (K3()) {
            float f2 = this.j0 + this.i0 + this.U + this.h0 + this.g0;
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                rectF.right = rect.right - f2;
            } else {
                rectF.left = rect.left + f2;
            }
        }
    }

    private void S0(@NonNull Rect rect, @NonNull RectF rectF) {
        rectF.setEmpty();
        if (K3()) {
            float f2 = this.j0 + this.i0;
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                float f3 = rect.right - f2;
                rectF.right = f3;
                rectF.left = f3 - this.U;
            } else {
                float f4 = rect.left + f2;
                rectF.left = f4;
                rectF.right = f4 + this.U;
            }
            float exactCenterY = rect.exactCenterY();
            float f5 = this.U;
            float f6 = exactCenterY - (f5 / 2.0f);
            rectF.top = f6;
            rectF.bottom = f6 + f5;
        }
    }

    @Nullable
    private ColorFilter S1() {
        ColorFilter colorFilter = this.U0;
        return colorFilter != null ? colorFilter : this.V0;
    }

    private void S2(@Nullable ColorStateList colorStateList) {
        if (this.D != colorStateList) {
            this.D = colorStateList;
            onStateChange(getState());
        }
    }

    private void T0(@NonNull Rect rect, @NonNull RectF rectF) {
        rectF.setEmpty();
        if (K3()) {
            float f2 = this.j0 + this.i0 + this.U + this.h0 + this.g0;
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                float f3 = rect.right;
                rectF.right = f3;
                rectF.left = f3 - f2;
            } else {
                int i2 = rect.left;
                rectF.left = i2;
                rectF.right = i2 + f2;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    private static boolean U1(@Nullable int[] iArr, @AttrRes int i2) {
        if (iArr == null) {
            return false;
        }
        for (int i3 : iArr) {
            if (i3 == i2) {
                return true;
            }
        }
        return false;
    }

    private void V0(@NonNull Rect rect, @NonNull RectF rectF) {
        rectF.setEmpty();
        if (this.K != null) {
            float Q0 = this.c0 + Q0() + this.f0;
            float U0 = this.j0 + U0() + this.g0;
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                rectF.left = rect.left + Q0;
                rectF.right = rect.right - U0;
            } else {
                rectF.left = rect.left + U0;
                rectF.right = rect.right - Q0;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    private float W0() {
        this.K0.e().getFontMetrics(this.G0);
        Paint.FontMetrics fontMetrics = this.G0;
        return (fontMetrics.descent + fontMetrics.ascent) / 2.0f;
    }

    private boolean Y0() {
        return this.X && this.Y != null && this.W;
    }

    @NonNull
    public static a Z0(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        a aVar = new a(context, attributeSet, i2, i3);
        aVar.h2(attributeSet, i2, i3);
        return aVar;
    }

    @NonNull
    public static a a1(@NonNull Context context, @XmlRes int i2) {
        AttributeSet a = e.j.a.c.o.a.a(context, i2, "chip");
        int styleAttribute = a.getStyleAttribute();
        if (styleAttribute == 0) {
            styleAttribute = R.style.Widget_MaterialComponents_Chip_Entry;
        }
        return Z0(context, a, R.attr.chipStandaloneStyle, styleAttribute);
    }

    private void b1(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (I3()) {
            P0(rect, this.H0);
            RectF rectF = this.H0;
            float f2 = rectF.left;
            float f3 = rectF.top;
            canvas.translate(f2, f3);
            this.Y.setBounds(0, 0, (int) this.H0.width(), (int) this.H0.height());
            this.Y.draw(canvas);
            canvas.translate(-f2, -f3);
        }
    }

    private void c1(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (this.f1) {
            return;
        }
        this.l0.setColor(this.M0);
        this.l0.setStyle(Paint.Style.FILL);
        this.l0.setColorFilter(S1());
        this.H0.set(rect);
        canvas.drawRoundRect(this.H0, n1(), n1(), this.l0);
    }

    private void d1(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (J3()) {
            P0(rect, this.H0);
            RectF rectF = this.H0;
            float f2 = rectF.left;
            float f3 = rectF.top;
            canvas.translate(f2, f3);
            this.M.setBounds(0, 0, (int) this.H0.width(), (int) this.H0.height());
            this.M.draw(canvas);
            canvas.translate(-f2, -f3);
        }
    }

    private void e1(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (this.I <= 0.0f || this.f1) {
            return;
        }
        this.l0.setColor(this.O0);
        this.l0.setStyle(Paint.Style.STROKE);
        if (!this.f1) {
            this.l0.setColorFilter(S1());
        }
        RectF rectF = this.H0;
        float f2 = this.I;
        rectF.set(rect.left + (f2 / 2.0f), rect.top + (f2 / 2.0f), rect.right - (f2 / 2.0f), rect.bottom - (f2 / 2.0f));
        float f3 = this.G - (this.I / 2.0f);
        canvas.drawRoundRect(this.H0, f3, f3, this.l0);
    }

    private static boolean e2(@Nullable ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    private void f1(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (this.f1) {
            return;
        }
        this.l0.setColor(this.L0);
        this.l0.setStyle(Paint.Style.FILL);
        this.H0.set(rect);
        canvas.drawRoundRect(this.H0, n1(), n1(), this.l0);
    }

    private static boolean f2(@Nullable Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    private void g1(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (K3()) {
            S0(rect, this.H0);
            RectF rectF = this.H0;
            float f2 = rectF.left;
            float f3 = rectF.top;
            canvas.translate(f2, f3);
            this.R.setBounds(0, 0, (int) this.H0.width(), (int) this.H0.height());
            if (b.a) {
                this.S.setBounds(this.R.getBounds());
                this.S.jumpToCurrentState();
                this.S.draw(canvas);
            } else {
                this.R.draw(canvas);
            }
            canvas.translate(-f2, -f3);
        }
    }

    private static boolean g2(@Nullable d dVar) {
        ColorStateList colorStateList;
        return (dVar == null || (colorStateList = dVar.a) == null || !colorStateList.isStateful()) ? false : true;
    }

    private void h1(@NonNull Canvas canvas, @NonNull Rect rect) {
        this.l0.setColor(this.P0);
        this.l0.setStyle(Paint.Style.FILL);
        this.H0.set(rect);
        if (!this.f1) {
            canvas.drawRoundRect(this.H0, n1(), n1(), this.l0);
            return;
        }
        h(new RectF(rect), this.J0);
        super.q(canvas, this.l0, this.J0, v());
    }

    private void h2(@Nullable AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        TypedArray j2 = m.j(this.k0, attributeSet, R.styleable.Chip, i2, i3, new int[0]);
        this.f1 = j2.hasValue(R.styleable.Chip_shapeAppearance);
        S2(c.a(this.k0, j2, R.styleable.Chip_chipSurfaceColor));
        u2(c.a(this.k0, j2, R.styleable.Chip_chipBackgroundColor));
        K2(j2.getDimension(R.styleable.Chip_chipMinHeight, 0.0f));
        int i4 = R.styleable.Chip_chipCornerRadius;
        if (j2.hasValue(i4)) {
            w2(j2.getDimension(i4, 0.0f));
        }
        O2(c.a(this.k0, j2, R.styleable.Chip_chipStrokeColor));
        Q2(j2.getDimension(R.styleable.Chip_chipStrokeWidth, 0.0f));
        s3(c.a(this.k0, j2, R.styleable.Chip_rippleColor));
        x3(j2.getText(R.styleable.Chip_android_text));
        d f2 = c.f(this.k0, j2, R.styleable.Chip_android_textAppearance);
        f2.n = j2.getDimension(R.styleable.Chip_android_textSize, f2.n);
        y3(f2);
        int i5 = j2.getInt(R.styleable.Chip_android_ellipsize, 0);
        if (i5 == 1) {
            k3(TextUtils.TruncateAt.START);
        } else if (i5 == 2) {
            k3(TextUtils.TruncateAt.MIDDLE);
        } else if (i5 == 3) {
            k3(TextUtils.TruncateAt.END);
        }
        J2(j2.getBoolean(R.styleable.Chip_chipIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue(i1, "chipIconEnabled") != null && attributeSet.getAttributeValue(i1, "chipIconVisible") == null) {
            J2(j2.getBoolean(R.styleable.Chip_chipIconEnabled, false));
        }
        A2(c.d(this.k0, j2, R.styleable.Chip_chipIcon));
        int i6 = R.styleable.Chip_chipIconTint;
        if (j2.hasValue(i6)) {
            G2(c.a(this.k0, j2, i6));
        }
        E2(j2.getDimension(R.styleable.Chip_chipIconSize, -1.0f));
        i3(j2.getBoolean(R.styleable.Chip_closeIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue(i1, "closeIconEnabled") != null && attributeSet.getAttributeValue(i1, "closeIconVisible") == null) {
            i3(j2.getBoolean(R.styleable.Chip_closeIconEnabled, false));
        }
        T2(c.d(this.k0, j2, R.styleable.Chip_closeIcon));
        f3(c.a(this.k0, j2, R.styleable.Chip_closeIconTint));
        a3(j2.getDimension(R.styleable.Chip_closeIconSize, 0.0f));
        k2(j2.getBoolean(R.styleable.Chip_android_checkable, false));
        t2(j2.getBoolean(R.styleable.Chip_checkedIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue(i1, "checkedIconEnabled") != null && attributeSet.getAttributeValue(i1, "checkedIconVisible") == null) {
            t2(j2.getBoolean(R.styleable.Chip_checkedIconEnabled, false));
        }
        m2(c.d(this.k0, j2, R.styleable.Chip_checkedIcon));
        int i7 = R.styleable.Chip_checkedIconTint;
        if (j2.hasValue(i7)) {
            q2(c.a(this.k0, j2, i7));
        }
        v3(h.c(this.k0, j2, R.styleable.Chip_showMotionSpec));
        l3(h.c(this.k0, j2, R.styleable.Chip_hideMotionSpec));
        M2(j2.getDimension(R.styleable.Chip_chipStartPadding, 0.0f));
        p3(j2.getDimension(R.styleable.Chip_iconStartPadding, 0.0f));
        n3(j2.getDimension(R.styleable.Chip_iconEndPadding, 0.0f));
        E3(j2.getDimension(R.styleable.Chip_textStartPadding, 0.0f));
        A3(j2.getDimension(R.styleable.Chip_textEndPadding, 0.0f));
        c3(j2.getDimension(R.styleable.Chip_closeIconStartPadding, 0.0f));
        X2(j2.getDimension(R.styleable.Chip_closeIconEndPadding, 0.0f));
        y2(j2.getDimension(R.styleable.Chip_chipEndPadding, 0.0f));
        r3(j2.getDimensionPixelSize(R.styleable.Chip_android_maxWidth, Integer.MAX_VALUE));
        j2.recycle();
    }

    private void i1(@NonNull Canvas canvas, @NonNull Rect rect) {
        Paint paint = this.m0;
        if (paint != null) {
            paint.setColor(ColorUtils.setAlphaComponent(ViewCompat.MEASURED_STATE_MASK, 127));
            canvas.drawRect(rect, this.m0);
            if (J3() || I3()) {
                P0(rect, this.H0);
                canvas.drawRect(this.H0, this.m0);
            }
            if (this.K != null) {
                canvas.drawLine(rect.left, rect.exactCenterY(), rect.right, rect.exactCenterY(), this.m0);
            }
            if (K3()) {
                S0(rect, this.H0);
                canvas.drawRect(this.H0, this.m0);
            }
            this.m0.setColor(ColorUtils.setAlphaComponent(-65536, 127));
            R0(rect, this.H0);
            canvas.drawRect(this.H0, this.m0);
            this.m0.setColor(ColorUtils.setAlphaComponent(-16711936, 127));
            T0(rect, this.H0);
            canvas.drawRect(this.H0, this.m0);
        }
    }

    private void j1(@NonNull Canvas canvas, @NonNull Rect rect) {
        if (this.K != null) {
            Paint.Align X0 = X0(rect, this.I0);
            V0(rect, this.H0);
            if (this.K0.d() != null) {
                this.K0.e().drawableState = getState();
                this.K0.k(this.k0);
            }
            this.K0.e().setTextAlign(X0);
            int i2 = 0;
            boolean z = Math.round(this.K0.f(O1().toString())) > Math.round(this.H0.width());
            if (z) {
                i2 = canvas.save();
                canvas.clipRect(this.H0);
            }
            CharSequence charSequence = this.K;
            if (z && this.c1 != null) {
                charSequence = TextUtils.ellipsize(charSequence, this.K0.e(), this.H0.width(), this.c1);
            }
            CharSequence charSequence2 = charSequence;
            int length = charSequence2.length();
            PointF pointF = this.I0;
            canvas.drawText(charSequence2, 0, length, pointF.x, pointF.y, this.K0.e());
            if (z) {
                canvas.restoreToCount(i2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0152  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean j2(@androidx.annotation.NonNull int[] r7, @androidx.annotation.NonNull int[] r8) {
        /*
            Method dump skipped, instructions count: 342
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.j.a.c.j.a.j2(int[], int[]):boolean");
    }

    public float A1() {
        return this.U;
    }

    public void A2(@Nullable Drawable drawable) {
        Drawable p1 = p1();
        if (p1 != drawable) {
            float Q0 = Q0();
            this.M = drawable != null ? DrawableCompat.wrap(drawable).mutate() : null;
            float Q02 = Q0();
            L3(p1);
            if (J3()) {
                O0(this.M);
            }
            invalidateSelf();
            if (Q0 != Q02) {
                i2();
            }
        }
    }

    public void A3(float f2) {
        if (this.g0 != f2) {
            this.g0 = f2;
            invalidateSelf();
            i2();
        }
    }

    public float B1() {
        return this.h0;
    }

    @Deprecated
    public void B2(boolean z) {
        J2(z);
    }

    public void B3(@DimenRes int i2) {
        A3(this.k0.getResources().getDimension(i2));
    }

    @NonNull
    public int[] C1() {
        return this.Y0;
    }

    @Deprecated
    public void C2(@BoolRes int i2) {
        I2(i2);
    }

    public void C3(@StringRes int i2) {
        x3(this.k0.getResources().getString(i2));
    }

    @Nullable
    public ColorStateList D1() {
        return this.T;
    }

    public void D2(@DrawableRes int i2) {
        A2(AppCompatResources.getDrawable(this.k0, i2));
    }

    public void D3(@Dimension float f2) {
        d P1 = P1();
        if (P1 != null) {
            P1.n = f2;
            this.K0.e().setTextSize(f2);
            a();
        }
    }

    public void E1(@NonNull RectF rectF) {
        T0(getBounds(), rectF);
    }

    public void E2(float f2) {
        if (this.O != f2) {
            float Q0 = Q0();
            this.O = f2;
            float Q02 = Q0();
            invalidateSelf();
            if (Q0 != Q02) {
                i2();
            }
        }
    }

    public void E3(float f2) {
        if (this.f0 != f2) {
            this.f0 = f2;
            invalidateSelf();
            i2();
        }
    }

    public void F2(@DimenRes int i2) {
        E2(this.k0.getResources().getDimension(i2));
    }

    public void F3(@DimenRes int i2) {
        E3(this.k0.getResources().getDimension(i2));
    }

    public void G2(@Nullable ColorStateList colorStateList) {
        this.P = true;
        if (this.N != colorStateList) {
            this.N = colorStateList;
            if (J3()) {
                DrawableCompat.setTintList(this.M, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void G3(boolean z) {
        if (this.Z0 != z) {
            this.Z0 = z;
            M3();
            onStateChange(getState());
        }
    }

    public TextUtils.TruncateAt H1() {
        return this.c1;
    }

    public void H2(@ColorRes int i2) {
        G2(AppCompatResources.getColorStateList(this.k0, i2));
    }

    public boolean H3() {
        return this.d1;
    }

    @Nullable
    public h I1() {
        return this.b0;
    }

    public void I2(@BoolRes int i2) {
        J2(this.k0.getResources().getBoolean(i2));
    }

    public float J1() {
        return this.e0;
    }

    public void J2(boolean z) {
        if (this.L != z) {
            boolean J3 = J3();
            this.L = z;
            boolean J32 = J3();
            if (J3 != J32) {
                if (J32) {
                    O0(this.M);
                } else {
                    L3(this.M);
                }
                invalidateSelf();
                i2();
            }
        }
    }

    public float K1() {
        return this.d0;
    }

    public void K2(float f2) {
        if (this.F != f2) {
            this.F = f2;
            invalidateSelf();
            i2();
        }
    }

    @Px
    public int L1() {
        return this.e1;
    }

    public void L2(@DimenRes int i2) {
        K2(this.k0.getResources().getDimension(i2));
    }

    @Nullable
    public ColorStateList M1() {
        return this.J;
    }

    public void M2(float f2) {
        if (this.c0 != f2) {
            this.c0 = f2;
            invalidateSelf();
            i2();
        }
    }

    @Nullable
    public h N1() {
        return this.a0;
    }

    public void N2(@DimenRes int i2) {
        M2(this.k0.getResources().getDimension(i2));
    }

    @Nullable
    public CharSequence O1() {
        return this.K;
    }

    public void O2(@Nullable ColorStateList colorStateList) {
        if (this.H != colorStateList) {
            this.H = colorStateList;
            if (this.f1) {
                E0(colorStateList);
            }
            onStateChange(getState());
        }
    }

    @Nullable
    public d P1() {
        return this.K0.d();
    }

    public void P2(@ColorRes int i2) {
        O2(AppCompatResources.getColorStateList(this.k0, i2));
    }

    public float Q0() {
        if (J3() || I3()) {
            return this.d0 + G1() + this.e0;
        }
        return 0.0f;
    }

    public float Q1() {
        return this.g0;
    }

    public void Q2(float f2) {
        if (this.I != f2) {
            this.I = f2;
            this.l0.setStrokeWidth(f2);
            if (this.f1) {
                super.H0(f2);
            }
            invalidateSelf();
        }
    }

    public float R1() {
        return this.f0;
    }

    public void R2(@DimenRes int i2) {
        Q2(this.k0.getResources().getDimension(i2));
    }

    public boolean T1() {
        return this.Z0;
    }

    public void T2(@Nullable Drawable drawable) {
        Drawable x1 = x1();
        if (x1 != drawable) {
            float U0 = U0();
            this.R = drawable != null ? DrawableCompat.wrap(drawable).mutate() : null;
            if (b.a) {
                N3();
            }
            float U02 = U0();
            L3(x1);
            if (K3()) {
                O0(this.R);
            }
            invalidateSelf();
            if (U0 != U02) {
                i2();
            }
        }
    }

    public float U0() {
        if (K3()) {
            return this.h0 + this.U + this.i0;
        }
        return 0.0f;
    }

    public void U2(@Nullable CharSequence charSequence) {
        if (this.V != charSequence) {
            this.V = BidiFormatter.getInstance().unicodeWrap(charSequence);
            invalidateSelf();
        }
    }

    public boolean V1() {
        return this.W;
    }

    @Deprecated
    public void V2(boolean z) {
        i3(z);
    }

    @Deprecated
    public boolean W1() {
        return X1();
    }

    @Deprecated
    public void W2(@BoolRes int i2) {
        h3(i2);
    }

    @NonNull
    public Paint.Align X0(@NonNull Rect rect, @NonNull PointF pointF) {
        pointF.set(0.0f, 0.0f);
        Paint.Align align = Paint.Align.LEFT;
        if (this.K != null) {
            float Q0 = this.c0 + Q0() + this.f0;
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                pointF.x = rect.left + Q0;
                align = Paint.Align.LEFT;
            } else {
                pointF.x = rect.right - Q0;
                align = Paint.Align.RIGHT;
            }
            pointF.y = rect.centerY() - W0();
        }
        return align;
    }

    public boolean X1() {
        return this.X;
    }

    public void X2(float f2) {
        if (this.i0 != f2) {
            this.i0 = f2;
            invalidateSelf();
            if (K3()) {
                i2();
            }
        }
    }

    @Deprecated
    public boolean Y1() {
        return Z1();
    }

    public void Y2(@DimenRes int i2) {
        X2(this.k0.getResources().getDimension(i2));
    }

    public boolean Z1() {
        return this.L;
    }

    public void Z2(@DrawableRes int i2) {
        T2(AppCompatResources.getDrawable(this.k0, i2));
    }

    @Override // e.j.a.c.s.j.b
    public void a() {
        i2();
        invalidateSelf();
    }

    @Deprecated
    public boolean a2() {
        return c2();
    }

    public void a3(float f2) {
        if (this.U != f2) {
            this.U = f2;
            invalidateSelf();
            if (K3()) {
                i2();
            }
        }
    }

    public boolean b2() {
        return f2(this.R);
    }

    public void b3(@DimenRes int i2) {
        a3(this.k0.getResources().getDimension(i2));
    }

    public boolean c2() {
        return this.Q;
    }

    public void c3(float f2) {
        if (this.h0 != f2) {
            this.h0 = f2;
            invalidateSelf();
            if (K3()) {
                i2();
            }
        }
    }

    public boolean d2() {
        return this.f1;
    }

    public void d3(@DimenRes int i2) {
        c3(this.k0.getResources().getDimension(i2));
    }

    @Override // e.j.a.c.z.j, android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Rect bounds = getBounds();
        if (bounds.isEmpty() || getAlpha() == 0) {
            return;
        }
        int i2 = this.T0;
        int a = i2 < 255 ? e.j.a.c.h.a.a(canvas, bounds.left, bounds.top, bounds.right, bounds.bottom, i2) : 0;
        f1(canvas, bounds);
        c1(canvas, bounds);
        if (this.f1) {
            super.draw(canvas);
        }
        e1(canvas, bounds);
        h1(canvas, bounds);
        d1(canvas, bounds);
        b1(canvas, bounds);
        if (this.d1) {
            j1(canvas, bounds);
        }
        g1(canvas, bounds);
        i1(canvas, bounds);
        if (this.T0 < 255) {
            canvas.restoreToCount(a);
        }
    }

    public boolean e3(@NonNull int[] iArr) {
        if (Arrays.equals(this.Y0, iArr)) {
            return false;
        }
        this.Y0 = iArr;
        if (K3()) {
            return j2(getState(), iArr);
        }
        return false;
    }

    public void f3(@Nullable ColorStateList colorStateList) {
        if (this.T != colorStateList) {
            this.T = colorStateList;
            if (K3()) {
                DrawableCompat.setTintList(this.R, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void g3(@ColorRes int i2) {
        f3(AppCompatResources.getColorStateList(this.k0, i2));
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.T0;
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public ColorFilter getColorFilter() {
        return this.U0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.F;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return Math.min(Math.round(this.c0 + Q0() + this.f0 + this.K0.f(O1().toString()) + this.g0 + U0() + this.j0), this.e1);
    }

    @Override // e.j.a.c.z.j, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // e.j.a.c.z.j, android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(@NonNull Outline outline) {
        if (this.f1) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (!bounds.isEmpty()) {
            outline.setRoundRect(bounds, this.G);
        } else {
            outline.setRoundRect(0, 0, getIntrinsicWidth(), getIntrinsicHeight(), this.G);
        }
        outline.setAlpha(getAlpha() / 255.0f);
    }

    public void h3(@BoolRes int i2) {
        i3(this.k0.getResources().getBoolean(i2));
    }

    public void i2() {
        InterfaceC0364a interfaceC0364a = this.b1.get();
        if (interfaceC0364a != null) {
            interfaceC0364a.a();
        }
    }

    public void i3(boolean z) {
        if (this.Q != z) {
            boolean K3 = K3();
            this.Q = z;
            boolean K32 = K3();
            if (K3 != K32) {
                if (K32) {
                    O0(this.R);
                } else {
                    L3(this.R);
                }
                invalidateSelf();
                i2();
            }
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // e.j.a.c.z.j, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return e2(this.D) || e2(this.E) || e2(this.H) || (this.Z0 && e2(this.a1)) || g2(this.K0.d()) || Y0() || f2(this.M) || f2(this.Y) || e2(this.W0);
    }

    public void j3(@Nullable InterfaceC0364a interfaceC0364a) {
        this.b1 = new WeakReference<>(interfaceC0364a);
    }

    @Nullable
    public Drawable k1() {
        return this.Y;
    }

    public void k2(boolean z) {
        if (this.W != z) {
            this.W = z;
            float Q0 = Q0();
            if (!z && this.R0) {
                this.R0 = false;
            }
            float Q02 = Q0();
            invalidateSelf();
            if (Q0 != Q02) {
                i2();
            }
        }
    }

    public void k3(@Nullable TextUtils.TruncateAt truncateAt) {
        this.c1 = truncateAt;
    }

    @Nullable
    public ColorStateList l1() {
        return this.Z;
    }

    public void l2(@BoolRes int i2) {
        k2(this.k0.getResources().getBoolean(i2));
    }

    public void l3(@Nullable h hVar) {
        this.b0 = hVar;
    }

    @Nullable
    public ColorStateList m1() {
        return this.E;
    }

    public void m2(@Nullable Drawable drawable) {
        if (this.Y != drawable) {
            float Q0 = Q0();
            this.Y = drawable;
            float Q02 = Q0();
            L3(this.Y);
            O0(this.Y);
            invalidateSelf();
            if (Q0 != Q02) {
                i2();
            }
        }
    }

    public void m3(@AnimatorRes int i2) {
        l3(h.d(this.k0, i2));
    }

    public float n1() {
        return this.f1 ? R() : this.G;
    }

    @Deprecated
    public void n2(boolean z) {
        t2(z);
    }

    public void n3(float f2) {
        if (this.e0 != f2) {
            float Q0 = Q0();
            this.e0 = f2;
            float Q02 = Q0();
            invalidateSelf();
            if (Q0 != Q02) {
                i2();
            }
        }
    }

    public float o1() {
        return this.j0;
    }

    @Deprecated
    public void o2(@BoolRes int i2) {
        t2(this.k0.getResources().getBoolean(i2));
    }

    public void o3(@DimenRes int i2) {
        n3(this.k0.getResources().getDimension(i2));
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i2) {
        boolean onLayoutDirectionChanged = super.onLayoutDirectionChanged(i2);
        if (J3()) {
            onLayoutDirectionChanged |= DrawableCompat.setLayoutDirection(this.M, i2);
        }
        if (I3()) {
            onLayoutDirectionChanged |= DrawableCompat.setLayoutDirection(this.Y, i2);
        }
        if (K3()) {
            onLayoutDirectionChanged |= DrawableCompat.setLayoutDirection(this.R, i2);
        }
        if (onLayoutDirectionChanged) {
            invalidateSelf();
            return true;
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i2) {
        boolean onLevelChange = super.onLevelChange(i2);
        if (J3()) {
            onLevelChange |= this.M.setLevel(i2);
        }
        if (I3()) {
            onLevelChange |= this.Y.setLevel(i2);
        }
        if (K3()) {
            onLevelChange |= this.R.setLevel(i2);
        }
        if (onLevelChange) {
            invalidateSelf();
        }
        return onLevelChange;
    }

    @Override // e.j.a.c.z.j, android.graphics.drawable.Drawable, e.j.a.c.s.j.b
    public boolean onStateChange(@NonNull int[] iArr) {
        if (this.f1) {
            super.onStateChange(iArr);
        }
        return j2(iArr, C1());
    }

    @Nullable
    public Drawable p1() {
        Drawable drawable = this.M;
        if (drawable != null) {
            return DrawableCompat.unwrap(drawable);
        }
        return null;
    }

    public void p2(@DrawableRes int i2) {
        m2(AppCompatResources.getDrawable(this.k0, i2));
    }

    public void p3(float f2) {
        if (this.d0 != f2) {
            float Q0 = Q0();
            this.d0 = f2;
            float Q02 = Q0();
            invalidateSelf();
            if (Q0 != Q02) {
                i2();
            }
        }
    }

    public float q1() {
        return this.O;
    }

    public void q2(@Nullable ColorStateList colorStateList) {
        if (this.Z != colorStateList) {
            this.Z = colorStateList;
            if (Y0()) {
                DrawableCompat.setTintList(this.Y, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void q3(@DimenRes int i2) {
        p3(this.k0.getResources().getDimension(i2));
    }

    @Nullable
    public ColorStateList r1() {
        return this.N;
    }

    public void r2(@ColorRes int i2) {
        q2(AppCompatResources.getColorStateList(this.k0, i2));
    }

    public void r3(@Px int i2) {
        this.e1 = i2;
    }

    public float s1() {
        return this.F;
    }

    public void s2(@BoolRes int i2) {
        t2(this.k0.getResources().getBoolean(i2));
    }

    public void s3(@Nullable ColorStateList colorStateList) {
        if (this.J != colorStateList) {
            this.J = colorStateList;
            M3();
            onStateChange(getState());
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j2) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j2);
        }
    }

    @Override // e.j.a.c.z.j, android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        if (this.T0 != i2) {
            this.T0 = i2;
            invalidateSelf();
        }
    }

    @Override // e.j.a.c.z.j, android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        if (this.U0 != colorFilter) {
            this.U0 = colorFilter;
            invalidateSelf();
        }
    }

    @Override // e.j.a.c.z.j, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(@Nullable ColorStateList colorStateList) {
        if (this.W0 != colorStateList) {
            this.W0 = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // e.j.a.c.z.j, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(@NonNull PorterDuff.Mode mode) {
        if (this.X0 != mode) {
            this.X0 = mode;
            this.V0 = e.j.a.c.o.a.c(this, this.W0, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (J3()) {
            visible |= this.M.setVisible(z, z2);
        }
        if (I3()) {
            visible |= this.Y.setVisible(z, z2);
        }
        if (K3()) {
            visible |= this.R.setVisible(z, z2);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    public float t1() {
        return this.c0;
    }

    public void t2(boolean z) {
        if (this.X != z) {
            boolean I3 = I3();
            this.X = z;
            boolean I32 = I3();
            if (I3 != I32) {
                if (I32) {
                    O0(this.Y);
                } else {
                    L3(this.Y);
                }
                invalidateSelf();
                i2();
            }
        }
    }

    public void t3(@ColorRes int i2) {
        s3(AppCompatResources.getColorStateList(this.k0, i2));
    }

    @Nullable
    public ColorStateList u1() {
        return this.H;
    }

    public void u2(@Nullable ColorStateList colorStateList) {
        if (this.E != colorStateList) {
            this.E = colorStateList;
            onStateChange(getState());
        }
    }

    public void u3(boolean z) {
        this.d1 = z;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public float v1() {
        return this.I;
    }

    public void v2(@ColorRes int i2) {
        u2(AppCompatResources.getColorStateList(this.k0, i2));
    }

    public void v3(@Nullable h hVar) {
        this.a0 = hVar;
    }

    public void w1(@NonNull RectF rectF) {
        R0(getBounds(), rectF);
    }

    @Deprecated
    public void w2(float f2) {
        if (this.G != f2) {
            this.G = f2;
            setShapeAppearanceModel(getShapeAppearanceModel().w(f2));
        }
    }

    public void w3(@AnimatorRes int i2) {
        v3(h.d(this.k0, i2));
    }

    @Nullable
    public Drawable x1() {
        Drawable drawable = this.R;
        if (drawable != null) {
            return DrawableCompat.unwrap(drawable);
        }
        return null;
    }

    @Deprecated
    public void x2(@DimenRes int i2) {
        w2(this.k0.getResources().getDimension(i2));
    }

    public void x3(@Nullable CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        if (TextUtils.equals(this.K, charSequence)) {
            return;
        }
        this.K = charSequence;
        this.K0.j(true);
        invalidateSelf();
        i2();
    }

    @Nullable
    public CharSequence y1() {
        return this.V;
    }

    public void y2(float f2) {
        if (this.j0 != f2) {
            this.j0 = f2;
            invalidateSelf();
            i2();
        }
    }

    public void y3(@Nullable d dVar) {
        this.K0.i(dVar, this.k0);
    }

    public float z1() {
        return this.i0;
    }

    public void z2(@DimenRes int i2) {
        y2(this.k0.getResources().getDimension(i2));
    }

    public void z3(@StyleRes int i2) {
        y3(new d(this.k0, i2));
    }
}
