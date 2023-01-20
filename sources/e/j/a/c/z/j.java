package e.j.a.c.z;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.core.util.ObjectsCompat;
import com.google.android.material.R;
import e.j.a.c.z.o;
import e.j.a.c.z.p;
import e.j.a.c.z.q;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.BitSet;

/* loaded from: classes2.dex */
public class j extends Drawable implements TintAwareDrawable, s {
    public static final int A = 1;
    public static final int B = 2;
    private static final float x = 0.75f;
    private static final float y = 0.25f;
    public static final int z = 0;
    private d a;
    private final q.i[] b;

    /* renamed from: c  reason: collision with root package name */
    private final q.i[] f11110c;

    /* renamed from: d  reason: collision with root package name */
    private final BitSet f11111d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f11112e;

    /* renamed from: f  reason: collision with root package name */
    private final Matrix f11113f;

    /* renamed from: g  reason: collision with root package name */
    private final Path f11114g;

    /* renamed from: h  reason: collision with root package name */
    private final Path f11115h;

    /* renamed from: i  reason: collision with root package name */
    private final RectF f11116i;

    /* renamed from: j  reason: collision with root package name */
    private final RectF f11117j;

    /* renamed from: k  reason: collision with root package name */
    private final Region f11118k;

    /* renamed from: l  reason: collision with root package name */
    private final Region f11119l;

    /* renamed from: m  reason: collision with root package name */
    private o f11120m;
    private final Paint n;
    private final Paint o;
    private final e.j.a.c.y.b p;
    @NonNull
    private final p.b q;
    private final p r;
    @Nullable
    private PorterDuffColorFilter s;
    @Nullable
    private PorterDuffColorFilter t;
    @NonNull
    private final RectF u;
    private boolean v;
    private static final String w = j.class.getSimpleName();
    private static final Paint C = new Paint(1);

    /* loaded from: classes2.dex */
    public class a implements p.b {
        public a() {
        }

        @Override // e.j.a.c.z.p.b
        public void a(@NonNull q qVar, Matrix matrix, int i2) {
            j.this.f11111d.set(i2, qVar.e());
            j.this.b[i2] = qVar.f(matrix);
        }

        @Override // e.j.a.c.z.p.b
        public void b(@NonNull q qVar, Matrix matrix, int i2) {
            j.this.f11111d.set(i2 + 4, qVar.e());
            j.this.f11110c[i2] = qVar.f(matrix);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements o.c {
        public final /* synthetic */ float a;

        public b(float f2) {
            this.a = f2;
        }

        @Override // e.j.a.c.z.o.c
        @NonNull
        public e.j.a.c.z.d a(@NonNull e.j.a.c.z.d dVar) {
            return dVar instanceof m ? dVar : new e.j.a.c.z.b(this.a, dVar);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface c {
    }

    public /* synthetic */ j(d dVar, a aVar) {
        this(dVar);
    }

    private boolean L0(int[] iArr) {
        boolean z2;
        int color;
        int colorForState;
        int color2;
        int colorForState2;
        if (this.a.f11122d == null || color2 == (colorForState2 = this.a.f11122d.getColorForState(iArr, (color2 = this.n.getColor())))) {
            z2 = false;
        } else {
            this.n.setColor(colorForState2);
            z2 = true;
        }
        if (this.a.f11123e == null || color == (colorForState = this.a.f11123e.getColorForState(iArr, (color = this.o.getColor())))) {
            return z2;
        }
        this.o.setColor(colorForState);
        return true;
    }

    private boolean M0() {
        PorterDuffColorFilter porterDuffColorFilter = this.s;
        PorterDuffColorFilter porterDuffColorFilter2 = this.t;
        d dVar = this.a;
        this.s = k(dVar.f11125g, dVar.f11126h, this.n, true);
        d dVar2 = this.a;
        this.t = k(dVar2.f11124f, dVar2.f11126h, this.o, false);
        d dVar3 = this.a;
        if (dVar3.u) {
            this.p.d(dVar3.f11125g.getColorForState(getState(), 0));
        }
        return (ObjectsCompat.equals(porterDuffColorFilter, this.s) && ObjectsCompat.equals(porterDuffColorFilter2, this.t)) ? false : true;
    }

    private float N() {
        if (X()) {
            return this.o.getStrokeWidth() / 2.0f;
        }
        return 0.0f;
    }

    private void N0() {
        float U = U();
        this.a.r = (int) Math.ceil(0.75f * U);
        this.a.s = (int) Math.ceil(U * 0.25f);
        M0();
        Z();
    }

    private boolean V() {
        d dVar = this.a;
        int i2 = dVar.q;
        return i2 != 1 && dVar.r > 0 && (i2 == 2 || i0());
    }

    private boolean W() {
        Paint.Style style = this.a.v;
        return style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.FILL;
    }

    private boolean X() {
        Paint.Style style = this.a.v;
        return (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.o.getStrokeWidth() > 0.0f;
    }

    private void Z() {
        super.invalidateSelf();
    }

    @Nullable
    private PorterDuffColorFilter f(@NonNull Paint paint, boolean z2) {
        int color;
        int l2;
        if (!z2 || (l2 = l((color = paint.getColor()))) == color) {
            return null;
        }
        return new PorterDuffColorFilter(l2, PorterDuff.Mode.SRC_IN);
    }

    private void f0(@NonNull Canvas canvas) {
        if (V()) {
            canvas.save();
            h0(canvas);
            if (!this.v) {
                o(canvas);
                canvas.restore();
                return;
            }
            int width = (int) (this.u.width() - getBounds().width());
            int height = (int) (this.u.height() - getBounds().height());
            if (width >= 0 && height >= 0) {
                Bitmap createBitmap = Bitmap.createBitmap(((int) this.u.width()) + (this.a.r * 2) + width, ((int) this.u.height()) + (this.a.r * 2) + height, Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(createBitmap);
                float f2 = (getBounds().left - this.a.r) - width;
                float f3 = (getBounds().top - this.a.r) - height;
                canvas2.translate(-f2, -f3);
                o(canvas2);
                canvas.drawBitmap(createBitmap, f2, f3, (Paint) null);
                createBitmap.recycle();
                canvas.restore();
                return;
            }
            throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
        }
    }

    private void g(@NonNull RectF rectF, @NonNull Path path) {
        h(rectF, path);
        if (this.a.f11128j != 1.0f) {
            this.f11113f.reset();
            Matrix matrix = this.f11113f;
            float f2 = this.a.f11128j;
            matrix.setScale(f2, f2, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(this.f11113f);
        }
        path.computeBounds(this.u, true);
    }

    private static int g0(int i2, int i3) {
        return (i2 * (i3 + (i3 >>> 7))) >>> 8;
    }

    private void h0(@NonNull Canvas canvas) {
        int H = H();
        int I = I();
        if (Build.VERSION.SDK_INT < 21 && this.v) {
            Rect clipBounds = canvas.getClipBounds();
            int i2 = this.a.r;
            clipBounds.inset(-i2, -i2);
            clipBounds.offset(H, I);
            canvas.clipRect(clipBounds, Region.Op.REPLACE);
        }
        canvas.translate(H, I);
    }

    private void i() {
        o y2 = getShapeAppearanceModel().y(new b(-N()));
        this.f11120m = y2;
        this.r.d(y2, this.a.f11129k, w(), this.f11115h);
    }

    @NonNull
    private PorterDuffColorFilter j(@NonNull ColorStateList colorStateList, @NonNull PorterDuff.Mode mode, boolean z2) {
        int colorForState = colorStateList.getColorForState(getState(), 0);
        if (z2) {
            colorForState = l(colorForState);
        }
        return new PorterDuffColorFilter(colorForState, mode);
    }

    @NonNull
    private PorterDuffColorFilter k(@Nullable ColorStateList colorStateList, @Nullable PorterDuff.Mode mode, @NonNull Paint paint, boolean z2) {
        if (colorStateList != null && mode != null) {
            return j(colorStateList, mode, z2);
        }
        return f(paint, z2);
    }

    @NonNull
    public static j m(Context context) {
        return n(context, 0.0f);
    }

    @NonNull
    public static j n(Context context, float f2) {
        int c2 = e.j.a.c.l.a.c(context, R.attr.colorSurface, j.class.getSimpleName());
        j jVar = new j();
        jVar.Y(context);
        jVar.n0(ColorStateList.valueOf(c2));
        jVar.m0(f2);
        return jVar;
    }

    private void o(@NonNull Canvas canvas) {
        if (this.f11111d.cardinality() > 0) {
            Log.w(w, "Compatibility shadow requested but can't be drawn for all operations in this shape.");
        }
        if (this.a.s != 0) {
            canvas.drawPath(this.f11114g, this.p.c());
        }
        for (int i2 = 0; i2 < 4; i2++) {
            this.b[i2].b(this.p, this.a.r, canvas);
            this.f11110c[i2].b(this.p, this.a.r, canvas);
        }
        if (this.v) {
            int H = H();
            int I = I();
            canvas.translate(-H, -I);
            canvas.drawPath(this.f11114g, C);
            canvas.translate(H, I);
        }
    }

    private void p(@NonNull Canvas canvas) {
        r(canvas, this.n, this.f11114g, this.a.a, v());
    }

    private void r(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull Path path, @NonNull o oVar, @NonNull RectF rectF) {
        if (oVar.u(rectF)) {
            float a2 = oVar.t().a(rectF) * this.a.f11129k;
            canvas.drawRoundRect(rectF, a2, a2, paint);
            return;
        }
        canvas.drawPath(path, paint);
    }

    private void s(@NonNull Canvas canvas) {
        r(canvas, this.o, this.f11115h, this.f11120m, w());
    }

    @NonNull
    private RectF w() {
        this.f11117j.set(v());
        float N = N();
        this.f11117j.inset(N, N);
        return this.f11117j;
    }

    public Paint.Style A() {
        return this.a.v;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void A0(int i2) {
        d dVar = this.a;
        if (dVar.s != i2) {
            dVar.s = i2;
            Z();
        }
    }

    public float B() {
        return this.a.n;
    }

    @Deprecated
    public void B0(@NonNull r rVar) {
        setShapeAppearanceModel(rVar);
    }

    @Deprecated
    public void C(int i2, int i3, @NonNull Path path) {
        h(new RectF(0.0f, 0.0f, i2, i3), path);
    }

    public void C0(float f2, @ColorInt int i2) {
        H0(f2);
        E0(ColorStateList.valueOf(i2));
    }

    public float D() {
        return this.a.f11128j;
    }

    public void D0(float f2, @Nullable ColorStateList colorStateList) {
        H0(f2);
        E0(colorStateList);
    }

    public int E() {
        return this.a.t;
    }

    public void E0(@Nullable ColorStateList colorStateList) {
        d dVar = this.a;
        if (dVar.f11123e != colorStateList) {
            dVar.f11123e = colorStateList;
            onStateChange(getState());
        }
    }

    public int F() {
        return this.a.q;
    }

    public void F0(@ColorInt int i2) {
        G0(ColorStateList.valueOf(i2));
    }

    @Deprecated
    public int G() {
        return (int) x();
    }

    public void G0(ColorStateList colorStateList) {
        this.a.f11124f = colorStateList;
        M0();
        Z();
    }

    public int H() {
        d dVar = this.a;
        return (int) (dVar.s * Math.sin(Math.toRadians(dVar.t)));
    }

    public void H0(float f2) {
        this.a.f11130l = f2;
        invalidateSelf();
    }

    public int I() {
        d dVar = this.a;
        return (int) (dVar.s * Math.cos(Math.toRadians(dVar.t)));
    }

    public void I0(float f2) {
        d dVar = this.a;
        if (dVar.p != f2) {
            dVar.p = f2;
            N0();
        }
    }

    public int J() {
        return this.a.r;
    }

    public void J0(boolean z2) {
        d dVar = this.a;
        if (dVar.u != z2) {
            dVar.u = z2;
            invalidateSelf();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int K() {
        return this.a.s;
    }

    public void K0(float f2) {
        I0(f2 - x());
    }

    @Nullable
    @Deprecated
    public r L() {
        o shapeAppearanceModel = getShapeAppearanceModel();
        if (shapeAppearanceModel instanceof r) {
            return (r) shapeAppearanceModel;
        }
        return null;
    }

    @Nullable
    public ColorStateList M() {
        return this.a.f11123e;
    }

    @Nullable
    public ColorStateList O() {
        return this.a.f11124f;
    }

    public float P() {
        return this.a.f11130l;
    }

    @Nullable
    public ColorStateList Q() {
        return this.a.f11125g;
    }

    public float R() {
        return this.a.a.r().a(v());
    }

    public float S() {
        return this.a.a.t().a(v());
    }

    public float T() {
        return this.a.p;
    }

    public float U() {
        return x() + T();
    }

    public void Y(Context context) {
        this.a.b = new e.j.a.c.p.a(context);
        N0();
    }

    public boolean a0() {
        e.j.a.c.p.a aVar = this.a.b;
        return aVar != null && aVar.l();
    }

    public boolean b0() {
        return this.a.b != null;
    }

    public boolean c0(int i2, int i3) {
        return getTransparentRegion().contains(i2, i3);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean d0() {
        return this.a.a.u(v());
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        this.n.setColorFilter(this.s);
        int alpha = this.n.getAlpha();
        this.n.setAlpha(g0(alpha, this.a.f11131m));
        this.o.setColorFilter(this.t);
        this.o.setStrokeWidth(this.a.f11130l);
        int alpha2 = this.o.getAlpha();
        this.o.setAlpha(g0(alpha2, this.a.f11131m));
        if (this.f11112e) {
            i();
            g(v(), this.f11114g);
            this.f11112e = false;
        }
        f0(canvas);
        if (W()) {
            p(canvas);
        }
        if (X()) {
            s(canvas);
        }
        this.n.setAlpha(alpha);
        this.o.setAlpha(alpha2);
    }

    @Deprecated
    public boolean e0() {
        int i2 = this.a.q;
        return i2 == 0 || i2 == 2;
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public Drawable.ConstantState getConstantState() {
        return this.a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(@NonNull Outline outline) {
        if (this.a.q == 2) {
            return;
        }
        if (d0()) {
            outline.setRoundRect(getBounds(), R() * this.a.f11129k);
            return;
        }
        g(v(), this.f11114g);
        if (this.f11114g.isConvex() || Build.VERSION.SDK_INT >= 29) {
            try {
                outline.setConvexPath(this.f11114g);
            } catch (IllegalArgumentException unused) {
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@NonNull Rect rect) {
        Rect rect2 = this.a.f11127i;
        if (rect2 != null) {
            rect.set(rect2);
            return true;
        }
        return super.getPadding(rect);
    }

    @Override // e.j.a.c.z.s
    @NonNull
    public o getShapeAppearanceModel() {
        return this.a.a;
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        this.f11118k.set(getBounds());
        g(v(), this.f11114g);
        this.f11119l.setPath(this.f11114g, this.f11118k);
        this.f11118k.op(this.f11119l, Region.Op.DIFFERENCE);
        return this.f11118k;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void h(@NonNull RectF rectF, @NonNull Path path) {
        p pVar = this.r;
        d dVar = this.a;
        pVar.e(dVar.a, dVar.f11129k, rectF, this.q, path);
    }

    public boolean i0() {
        int i2 = Build.VERSION.SDK_INT;
        return i2 < 21 || !(d0() || this.f11114g.isConvex() || i2 >= 29);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        this.f11112e = true;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        ColorStateList colorStateList4;
        return super.isStateful() || ((colorStateList = this.a.f11125g) != null && colorStateList.isStateful()) || (((colorStateList2 = this.a.f11124f) != null && colorStateList2.isStateful()) || (((colorStateList3 = this.a.f11123e) != null && colorStateList3.isStateful()) || ((colorStateList4 = this.a.f11122d) != null && colorStateList4.isStateful())));
    }

    public void j0(float f2) {
        setShapeAppearanceModel(this.a.a.w(f2));
    }

    public void k0(@NonNull e.j.a.c.z.d dVar) {
        setShapeAppearanceModel(this.a.a.x(dVar));
    }

    @ColorInt
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int l(@ColorInt int i2) {
        float U = U() + B();
        e.j.a.c.p.a aVar = this.a.b;
        return aVar != null ? aVar.e(i2, U) : i2;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void l0(boolean z2) {
        this.r.n(z2);
    }

    public void m0(float f2) {
        d dVar = this.a;
        if (dVar.o != f2) {
            dVar.o = f2;
            N0();
        }
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public Drawable mutate() {
        this.a = new d(this.a);
        return this;
    }

    public void n0(@Nullable ColorStateList colorStateList) {
        d dVar = this.a;
        if (dVar.f11122d != colorStateList) {
            dVar.f11122d = colorStateList;
            onStateChange(getState());
        }
    }

    public void o0(float f2) {
        d dVar = this.a;
        if (dVar.f11129k != f2) {
            dVar.f11129k = f2;
            this.f11112e = true;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.f11112e = true;
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.Drawable, e.j.a.c.s.j.b
    public boolean onStateChange(int[] iArr) {
        boolean z2 = L0(iArr) || M0();
        if (z2) {
            invalidateSelf();
        }
        return z2;
    }

    public void p0(int i2, int i3, int i4, int i5) {
        d dVar = this.a;
        if (dVar.f11127i == null) {
            dVar.f11127i = new Rect();
        }
        this.a.f11127i.set(i2, i3, i4, i5);
        invalidateSelf();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void q(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull Path path, @NonNull RectF rectF) {
        r(canvas, paint, path, this.a.a, rectF);
    }

    public void q0(Paint.Style style) {
        this.a.v = style;
        Z();
    }

    public void r0(float f2) {
        d dVar = this.a;
        if (dVar.n != f2) {
            dVar.n = f2;
            N0();
        }
    }

    public void s0(float f2) {
        d dVar = this.a;
        if (dVar.f11128j != f2) {
            dVar.f11128j = f2;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@IntRange(from = 0, to = 255) int i2) {
        d dVar = this.a;
        if (dVar.f11131m != i2) {
            dVar.f11131m = i2;
            Z();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.a.f11121c = colorFilter;
        Z();
    }

    @Override // e.j.a.c.z.s
    public void setShapeAppearanceModel(@NonNull o oVar) {
        this.a.a = oVar;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTint(@ColorInt int i2) {
        setTintList(ColorStateList.valueOf(i2));
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(@Nullable ColorStateList colorStateList) {
        this.a.f11125g = colorStateList;
        M0();
        Z();
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(@Nullable PorterDuff.Mode mode) {
        d dVar = this.a;
        if (dVar.f11126h != mode) {
            dVar.f11126h = mode;
            M0();
            Z();
        }
    }

    public float t() {
        return this.a.a.j().a(v());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void t0(boolean z2) {
        this.v = z2;
    }

    public float u() {
        return this.a.a.l().a(v());
    }

    public void u0(int i2) {
        this.p.d(i2);
        this.a.u = false;
        Z();
    }

    @NonNull
    public RectF v() {
        this.f11116i.set(getBounds());
        return this.f11116i;
    }

    public void v0(int i2) {
        d dVar = this.a;
        if (dVar.t != i2) {
            dVar.t = i2;
            Z();
        }
    }

    public void w0(int i2) {
        d dVar = this.a;
        if (dVar.q != i2) {
            dVar.q = i2;
            Z();
        }
    }

    public float x() {
        return this.a.o;
    }

    @Deprecated
    public void x0(int i2) {
        m0(i2);
    }

    @Nullable
    public ColorStateList y() {
        return this.a.f11122d;
    }

    @Deprecated
    public void y0(boolean z2) {
        w0(!z2 ? 1 : 0);
    }

    public float z() {
        return this.a.f11129k;
    }

    @Deprecated
    public void z0(int i2) {
        this.a.r = i2;
    }

    public j() {
        this(new o());
    }

    public j(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        this(o.e(context, attributeSet, i2, i3).m());
    }

    @Deprecated
    public j(@NonNull r rVar) {
        this((o) rVar);
    }

    public j(@NonNull o oVar) {
        this(new d(oVar, null));
    }

    private j(@NonNull d dVar) {
        this.b = new q.i[4];
        this.f11110c = new q.i[4];
        this.f11111d = new BitSet(8);
        this.f11113f = new Matrix();
        this.f11114g = new Path();
        this.f11115h = new Path();
        this.f11116i = new RectF();
        this.f11117j = new RectF();
        this.f11118k = new Region();
        this.f11119l = new Region();
        Paint paint = new Paint(1);
        this.n = paint;
        Paint paint2 = new Paint(1);
        this.o = paint2;
        this.p = new e.j.a.c.y.b();
        this.r = Looper.getMainLooper().getThread() == Thread.currentThread() ? p.k() : new p();
        this.u = new RectF();
        this.v = true;
        this.a = dVar;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        Paint paint3 = C;
        paint3.setColor(-1);
        paint3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        M0();
        L0(getState());
        this.q = new a();
    }

    /* loaded from: classes2.dex */
    public static final class d extends Drawable.ConstantState {
        @NonNull
        public o a;
        @Nullable
        public e.j.a.c.p.a b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        public ColorFilter f11121c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        public ColorStateList f11122d;
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        public ColorStateList f11123e;
        @Nullable

        /* renamed from: f  reason: collision with root package name */
        public ColorStateList f11124f;
        @Nullable

        /* renamed from: g  reason: collision with root package name */
        public ColorStateList f11125g;
        @Nullable

        /* renamed from: h  reason: collision with root package name */
        public PorterDuff.Mode f11126h;
        @Nullable

        /* renamed from: i  reason: collision with root package name */
        public Rect f11127i;

        /* renamed from: j  reason: collision with root package name */
        public float f11128j;

        /* renamed from: k  reason: collision with root package name */
        public float f11129k;

        /* renamed from: l  reason: collision with root package name */
        public float f11130l;

        /* renamed from: m  reason: collision with root package name */
        public int f11131m;
        public float n;
        public float o;
        public float p;
        public int q;
        public int r;
        public int s;
        public int t;
        public boolean u;
        public Paint.Style v;

        public d(o oVar, e.j.a.c.p.a aVar) {
            this.f11122d = null;
            this.f11123e = null;
            this.f11124f = null;
            this.f11125g = null;
            this.f11126h = PorterDuff.Mode.SRC_IN;
            this.f11127i = null;
            this.f11128j = 1.0f;
            this.f11129k = 1.0f;
            this.f11131m = 255;
            this.n = 0.0f;
            this.o = 0.0f;
            this.p = 0.0f;
            this.q = 0;
            this.r = 0;
            this.s = 0;
            this.t = 0;
            this.u = false;
            this.v = Paint.Style.FILL_AND_STROKE;
            this.a = oVar;
            this.b = aVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            j jVar = new j(this, null);
            jVar.f11112e = true;
            return jVar;
        }

        public d(@NonNull d dVar) {
            this.f11122d = null;
            this.f11123e = null;
            this.f11124f = null;
            this.f11125g = null;
            this.f11126h = PorterDuff.Mode.SRC_IN;
            this.f11127i = null;
            this.f11128j = 1.0f;
            this.f11129k = 1.0f;
            this.f11131m = 255;
            this.n = 0.0f;
            this.o = 0.0f;
            this.p = 0.0f;
            this.q = 0;
            this.r = 0;
            this.s = 0;
            this.t = 0;
            this.u = false;
            this.v = Paint.Style.FILL_AND_STROKE;
            this.a = dVar.a;
            this.b = dVar.b;
            this.f11130l = dVar.f11130l;
            this.f11121c = dVar.f11121c;
            this.f11122d = dVar.f11122d;
            this.f11123e = dVar.f11123e;
            this.f11126h = dVar.f11126h;
            this.f11125g = dVar.f11125g;
            this.f11131m = dVar.f11131m;
            this.f11128j = dVar.f11128j;
            this.s = dVar.s;
            this.q = dVar.q;
            this.u = dVar.u;
            this.f11129k = dVar.f11129k;
            this.n = dVar.n;
            this.o = dVar.o;
            this.p = dVar.p;
            this.r = dVar.r;
            this.t = dVar.t;
            this.f11124f = dVar.f11124f;
            this.v = dVar.v;
            if (dVar.f11127i != null) {
                this.f11127i = new Rect(dVar.f11127i);
            }
        }
    }
}
