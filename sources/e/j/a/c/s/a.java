package e.j.a.c.s;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.math.MathUtils;
import androidx.core.text.TextDirectionHeuristicsCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.internal.StaticLayoutBuilderCompat;
import com.tencent.android.tpush.stat.ServiceStat;
import e.j.a.c.w.a;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public final class a {
    private static final boolean j0;
    private static final String k0 = "CollapsingTextHelper";
    private static final String l0 = "…";
    private static final float m0 = 0.5f;
    private static final boolean n0 = false;
    @NonNull
    private static final Paint o0;
    private e.j.a.c.w.a A;
    @Nullable
    private CharSequence B;
    @Nullable
    private CharSequence C;
    private boolean D;
    private boolean F;
    @Nullable
    private Bitmap G;
    private Paint H;
    private float I;
    private float J;
    private int[] K;
    private boolean L;
    @NonNull
    private final TextPaint M;
    @NonNull
    private final TextPaint N;
    private TimeInterpolator O;
    private TimeInterpolator P;
    private float Q;
    private float R;
    private float S;
    private ColorStateList T;
    private float U;
    private float V;
    private float W;
    private ColorStateList X;
    private float Y;
    private float Z;
    private final View a;
    private StaticLayout a0;
    private boolean b;
    private float b0;

    /* renamed from: c  reason: collision with root package name */
    private float f10965c;
    private float c0;

    /* renamed from: d  reason: collision with root package name */
    private boolean f10966d;
    private float d0;

    /* renamed from: e  reason: collision with root package name */
    private float f10967e;
    private CharSequence e0;

    /* renamed from: f  reason: collision with root package name */
    private float f10968f;

    /* renamed from: g  reason: collision with root package name */
    private int f10969g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    private final Rect f10970h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    private final Rect f10971i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    private final RectF f10972j;
    private ColorStateList o;
    private ColorStateList p;
    private float q;
    private float r;
    private float s;
    private float t;
    private float u;
    private float v;
    private Typeface w;
    private Typeface x;
    private Typeface y;
    private e.j.a.c.w.a z;

    /* renamed from: k  reason: collision with root package name */
    private int f10973k = 16;

    /* renamed from: l  reason: collision with root package name */
    private int f10974l = 16;

    /* renamed from: m  reason: collision with root package name */
    private float f10975m = 15.0f;
    private float n = 15.0f;
    private boolean E = true;
    private int f0 = 1;
    private float g0 = 0.0f;
    private float h0 = 1.0f;
    private int i0 = StaticLayoutBuilderCompat.n;

    /* renamed from: e.j.a.c.s.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0370a implements a.InterfaceC0373a {
        public C0370a() {
        }

        @Override // e.j.a.c.w.a.InterfaceC0373a
        public void a(Typeface typeface) {
            a.this.i0(typeface);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements a.InterfaceC0373a {
        public b() {
        }

        @Override // e.j.a.c.w.a.InterfaceC0373a
        public void a(Typeface typeface) {
            a.this.s0(typeface);
        }
    }

    static {
        j0 = Build.VERSION.SDK_INT < 18;
        Paint paint = null;
        o0 = null;
        if (0 != 0) {
            paint.setAntiAlias(true);
            paint.setColor(-65281);
        }
    }

    public a(View view) {
        this.a = view;
        TextPaint textPaint = new TextPaint((int) ServiceStat.EnumPushAction_IN_MSG_ACTION_MOBILE_USER_DISABLED);
        this.M = textPaint;
        this.N = new TextPaint(textPaint);
        this.f10971i = new Rect();
        this.f10970h = new Rect();
        this.f10972j = new RectF();
        this.f10968f = f();
    }

    private boolean I0() {
        return this.f0 > 1 && (!this.D || this.f10966d) && !this.F;
    }

    private void O(@NonNull TextPaint textPaint) {
        textPaint.setTextSize(this.n);
        textPaint.setTypeface(this.w);
        if (Build.VERSION.SDK_INT >= 21) {
            textPaint.setLetterSpacing(this.Y);
        }
    }

    private void P(@NonNull TextPaint textPaint) {
        textPaint.setTextSize(this.f10975m);
        textPaint.setTypeface(this.x);
        if (Build.VERSION.SDK_INT >= 21) {
            textPaint.setLetterSpacing(this.Z);
        }
    }

    private void Q(float f2) {
        if (this.f10966d) {
            this.f10972j.set(f2 < this.f10968f ? this.f10970h : this.f10971i);
            return;
        }
        this.f10972j.left = W(this.f10970h.left, this.f10971i.left, f2, this.O);
        this.f10972j.top = W(this.q, this.r, f2, this.O);
        this.f10972j.right = W(this.f10970h.right, this.f10971i.right, f2, this.O);
        this.f10972j.bottom = W(this.f10970h.bottom, this.f10971i.bottom, f2, this.O);
    }

    private static boolean R(float f2, float f3) {
        return Math.abs(f2 - f3) < 0.001f;
    }

    private boolean S() {
        return ViewCompat.getLayoutDirection(this.a) == 1;
    }

    private boolean V(@NonNull CharSequence charSequence, boolean z) {
        return (z ? TextDirectionHeuristicsCompat.FIRSTSTRONG_RTL : TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR).isRtl(charSequence, 0, charSequence.length());
    }

    private static float W(float f2, float f3, float f4, @Nullable TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f4 = timeInterpolator.getInterpolation(f4);
        }
        return e.j.a.c.a.a.a(f2, f3, f4);
    }

    private static int a(int i2, int i3, float f2) {
        float f3 = 1.0f - f2;
        return Color.argb((int) ((Color.alpha(i2) * f3) + (Color.alpha(i3) * f2)), (int) ((Color.red(i2) * f3) + (Color.red(i3) * f2)), (int) ((Color.green(i2) * f3) + (Color.green(i3) * f2)), (int) ((Color.blue(i2) * f3) + (Color.blue(i3) * f2)));
    }

    private static boolean a0(@NonNull Rect rect, int i2, int i3, int i4, int i5) {
        return rect.left == i2 && rect.top == i3 && rect.right == i4 && rect.bottom == i5;
    }

    private void b(boolean z) {
        StaticLayout staticLayout;
        StaticLayout staticLayout2;
        float f2 = this.J;
        j(this.n, z);
        CharSequence charSequence = this.C;
        if (charSequence != null && (staticLayout2 = this.a0) != null) {
            this.e0 = TextUtils.ellipsize(charSequence, this.M, staticLayout2.getWidth(), TextUtils.TruncateAt.END);
        }
        CharSequence charSequence2 = this.e0;
        float f3 = 0.0f;
        float measureText = charSequence2 != null ? this.M.measureText(charSequence2, 0, charSequence2.length()) : 0.0f;
        int absoluteGravity = GravityCompat.getAbsoluteGravity(this.f10974l, this.D ? 1 : 0);
        int i2 = absoluteGravity & 112;
        if (i2 == 48) {
            this.r = this.f10971i.top;
        } else if (i2 != 80) {
            this.r = this.f10971i.centerY() - ((this.M.descent() - this.M.ascent()) / 2.0f);
        } else {
            this.r = this.f10971i.bottom + this.M.ascent();
        }
        int i3 = absoluteGravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (i3 == 1) {
            this.t = this.f10971i.centerX() - (measureText / 2.0f);
        } else if (i3 != 5) {
            this.t = this.f10971i.left;
        } else {
            this.t = this.f10971i.right - measureText;
        }
        j(this.f10975m, z);
        float height = this.a0 != null ? staticLayout.getHeight() : 0.0f;
        CharSequence charSequence3 = this.C;
        float measureText2 = charSequence3 != null ? this.M.measureText(charSequence3, 0, charSequence3.length()) : 0.0f;
        StaticLayout staticLayout3 = this.a0;
        if (staticLayout3 != null && this.f0 > 1) {
            measureText2 = staticLayout3.getWidth();
        }
        StaticLayout staticLayout4 = this.a0;
        if (staticLayout4 != null) {
            f3 = this.f0 > 1 ? staticLayout4.getLineStart(0) : staticLayout4.getLineLeft(0);
        }
        this.d0 = f3;
        int absoluteGravity2 = GravityCompat.getAbsoluteGravity(this.f10973k, this.D ? 1 : 0);
        int i4 = absoluteGravity2 & 112;
        if (i4 == 48) {
            this.q = this.f10970h.top;
        } else if (i4 != 80) {
            this.q = this.f10970h.centerY() - (height / 2.0f);
        } else {
            this.q = (this.f10970h.bottom - height) + this.M.descent();
        }
        int i5 = absoluteGravity2 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (i5 == 1) {
            this.s = this.f10970h.centerX() - (measureText2 / 2.0f);
        } else if (i5 != 5) {
            this.s = this.f10970h.left;
        } else {
            this.s = this.f10970h.right - measureText2;
        }
        k();
        y0(f2);
    }

    private void d() {
        h(this.f10965c);
    }

    private float e(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        float f3 = this.f10968f;
        if (f2 <= f3) {
            return e.j.a.c.a.a.b(1.0f, 0.0f, this.f10967e, f3, f2);
        }
        return e.j.a.c.a.a.b(0.0f, 1.0f, f3, 1.0f, f2);
    }

    private void e0(float f2) {
        this.b0 = f2;
        ViewCompat.postInvalidateOnAnimation(this.a);
    }

    private float f() {
        float f2 = this.f10967e;
        return f2 + ((1.0f - f2) * 0.5f);
    }

    private boolean g(@NonNull CharSequence charSequence) {
        boolean S = S();
        return this.E ? V(charSequence, S) : S;
    }

    private void h(float f2) {
        float f3;
        Q(f2);
        if (this.f10966d) {
            if (f2 < this.f10968f) {
                this.u = this.s;
                this.v = this.q;
                y0(this.f10975m);
                f3 = 0.0f;
            } else {
                this.u = this.t;
                this.v = this.r - Math.max(0, this.f10969g);
                y0(this.n);
                f3 = 1.0f;
            }
        } else {
            this.u = W(this.s, this.t, f2, this.O);
            this.v = W(this.q, this.r, f2, this.O);
            y0(W(this.f10975m, this.n, f2, this.P));
            f3 = f2;
        }
        TimeInterpolator timeInterpolator = e.j.a.c.a.a.b;
        e0(1.0f - W(0.0f, 1.0f, 1.0f - f2, timeInterpolator));
        o0(W(1.0f, 0.0f, f2, timeInterpolator));
        if (this.p != this.o) {
            this.M.setColor(a(z(), x(), f3));
        } else {
            this.M.setColor(x());
        }
        if (Build.VERSION.SDK_INT >= 21) {
            float f4 = this.Y;
            float f5 = this.Z;
            if (f4 != f5) {
                this.M.setLetterSpacing(W(f5, f4, f2, timeInterpolator));
            } else {
                this.M.setLetterSpacing(f4);
            }
        }
        this.M.setShadowLayer(W(this.U, this.Q, f2, null), W(this.V, this.R, f2, null), W(this.W, this.S, f2, null), a(y(this.X), y(this.T), f2));
        if (this.f10966d) {
            this.M.setAlpha((int) (e(f2) * 255.0f));
        }
        ViewCompat.postInvalidateOnAnimation(this.a);
    }

    private void i(float f2) {
        j(f2, false);
    }

    private void j(float f2, boolean z) {
        boolean z2;
        float f3;
        boolean z3;
        if (this.B == null) {
            return;
        }
        float width = this.f10971i.width();
        float width2 = this.f10970h.width();
        if (R(f2, this.n)) {
            f3 = this.n;
            this.I = 1.0f;
            Typeface typeface = this.y;
            Typeface typeface2 = this.w;
            if (typeface != typeface2) {
                this.y = typeface2;
                z3 = true;
            } else {
                z3 = false;
            }
        } else {
            float f4 = this.f10975m;
            Typeface typeface3 = this.y;
            Typeface typeface4 = this.x;
            if (typeface3 != typeface4) {
                this.y = typeface4;
                z2 = true;
            } else {
                z2 = false;
            }
            if (R(f2, f4)) {
                this.I = 1.0f;
            } else {
                this.I = f2 / this.f10975m;
            }
            float f5 = this.n / this.f10975m;
            width = (!z && width2 * f5 > width) ? Math.min(width / f5, width2) : width2;
            f3 = f4;
            z3 = z2;
        }
        if (width > 0.0f) {
            z3 = this.J != f3 || this.L || z3;
            this.J = f3;
            this.L = false;
        }
        if (this.C == null || z3) {
            this.M.setTextSize(this.J);
            this.M.setTypeface(this.y);
            this.M.setLinearText(this.I != 1.0f);
            this.D = g(this.B);
            StaticLayout l2 = l(I0() ? this.f0 : 1, width, this.D);
            this.a0 = l2;
            this.C = l2.getText();
        }
    }

    private boolean j0(Typeface typeface) {
        e.j.a.c.w.a aVar = this.A;
        if (aVar != null) {
            aVar.c();
        }
        if (this.w != typeface) {
            this.w = typeface;
            return true;
        }
        return false;
    }

    private void k() {
        Bitmap bitmap = this.G;
        if (bitmap != null) {
            bitmap.recycle();
            this.G = null;
        }
    }

    private StaticLayout l(int i2, float f2, boolean z) {
        StaticLayout staticLayout;
        try {
            staticLayout = StaticLayoutBuilderCompat.c(this.B, this.M, (int) f2).e(TextUtils.TruncateAt.END).i(z).d(Layout.Alignment.ALIGN_NORMAL).h(false).k(i2).j(this.g0, this.h0).g(this.i0).a();
        } catch (StaticLayoutBuilderCompat.StaticLayoutBuilderCompatException e2) {
            Log.e(k0, e2.getCause().getMessage(), e2);
            staticLayout = null;
        }
        return (StaticLayout) Preconditions.checkNotNull(staticLayout);
    }

    private void n(@NonNull Canvas canvas, float f2, float f3) {
        int alpha = this.M.getAlpha();
        canvas.translate(f2, f3);
        float f4 = alpha;
        this.M.setAlpha((int) (this.c0 * f4));
        this.a0.draw(canvas);
        this.M.setAlpha((int) (this.b0 * f4));
        int lineBaseline = this.a0.getLineBaseline(0);
        CharSequence charSequence = this.e0;
        float f5 = lineBaseline;
        canvas.drawText(charSequence, 0, charSequence.length(), 0.0f, f5, this.M);
        if (this.f10966d) {
            return;
        }
        String trim = this.e0.toString().trim();
        if (trim.endsWith(l0)) {
            trim = trim.substring(0, trim.length() - 1);
        }
        String str = trim;
        this.M.setAlpha(alpha);
        canvas.drawText(str, 0, Math.min(this.a0.getLineEnd(0), str.length()), 0.0f, f5, (Paint) this.M);
    }

    private void o() {
        if (this.G != null || this.f10970h.isEmpty() || TextUtils.isEmpty(this.C)) {
            return;
        }
        h(0.0f);
        int width = this.a0.getWidth();
        int height = this.a0.getHeight();
        if (width <= 0 || height <= 0) {
            return;
        }
        this.G = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        this.a0.draw(new Canvas(this.G));
        if (this.H == null) {
            this.H = new Paint(3);
        }
    }

    private void o0(float f2) {
        this.c0 = f2;
        ViewCompat.postInvalidateOnAnimation(this.a);
    }

    private float t(int i2, int i3) {
        if (i3 == 17 || (i3 & 7) == 1) {
            return (i2 / 2.0f) - (c() / 2.0f);
        }
        return ((i3 & GravityCompat.END) == 8388613 || (i3 & 5) == 5) ? this.D ? this.f10971i.left : this.f10971i.right - c() : this.D ? this.f10971i.right - c() : this.f10971i.left;
    }

    private boolean t0(Typeface typeface) {
        e.j.a.c.w.a aVar = this.z;
        if (aVar != null) {
            aVar.c();
        }
        if (this.x != typeface) {
            this.x = typeface;
            return true;
        }
        return false;
    }

    private float u(@NonNull RectF rectF, int i2, int i3) {
        if (i3 == 17 || (i3 & 7) == 1) {
            return (i2 / 2.0f) + (c() / 2.0f);
        }
        return ((i3 & GravityCompat.END) == 8388613 || (i3 & 5) == 5) ? this.D ? rectF.left + c() : this.f10971i.right : this.D ? this.f10971i.right : rectF.left + c();
    }

    @ColorInt
    private int y(@Nullable ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.K;
        if (iArr != null) {
            return colorStateList.getColorForState(iArr, 0);
        }
        return colorStateList.getDefaultColor();
    }

    private void y0(float f2) {
        i(f2);
        boolean z = j0 && this.I != 1.0f;
        this.F = z;
        if (z) {
            o();
        }
        ViewCompat.postInvalidateOnAnimation(this.a);
    }

    @ColorInt
    private int z() {
        return y(this.o);
    }

    public ColorStateList A() {
        return this.o;
    }

    @RequiresApi(23)
    public void A0(@FloatRange(from = 0.0d) float f2) {
        this.h0 = f2;
    }

    public float B() {
        P(this.N);
        return (-this.N.ascent()) + this.N.descent();
    }

    public void B0(int i2) {
        if (i2 != this.f0) {
            this.f0 = i2;
            k();
            Y();
        }
    }

    public int C() {
        return this.f10973k;
    }

    public void C0(TimeInterpolator timeInterpolator) {
        this.O = timeInterpolator;
        Y();
    }

    public float D() {
        P(this.N);
        return -this.N.ascent();
    }

    public void D0(boolean z) {
        this.E = z;
    }

    public float E() {
        return this.f10975m;
    }

    public final boolean E0(int[] iArr) {
        this.K = iArr;
        if (U()) {
            Y();
            return true;
        }
        return false;
    }

    public Typeface F() {
        Typeface typeface = this.x;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    public void F0(@Nullable CharSequence charSequence) {
        if (charSequence == null || !TextUtils.equals(this.B, charSequence)) {
            this.B = charSequence;
            this.C = null;
            k();
            Y();
        }
    }

    public float G() {
        return this.f10965c;
    }

    public void G0(TimeInterpolator timeInterpolator) {
        this.P = timeInterpolator;
        Y();
    }

    public float H() {
        return this.f10968f;
    }

    public void H0(Typeface typeface) {
        boolean j02 = j0(typeface);
        boolean t0 = t0(typeface);
        if (j02 || t0) {
            Y();
        }
    }

    @RequiresApi(23)
    public int I() {
        return this.i0;
    }

    public int J() {
        StaticLayout staticLayout = this.a0;
        if (staticLayout != null) {
            return staticLayout.getLineCount();
        }
        return 0;
    }

    @RequiresApi(23)
    public float K() {
        return this.a0.getSpacingAdd();
    }

    @RequiresApi(23)
    public float L() {
        return this.a0.getSpacingMultiplier();
    }

    public int M() {
        return this.f0;
    }

    @Nullable
    public CharSequence N() {
        return this.B;
    }

    public boolean T() {
        return this.E;
    }

    public final boolean U() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.p;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.o) != null && colorStateList.isStateful());
    }

    public void X() {
        this.b = this.f10971i.width() > 0 && this.f10971i.height() > 0 && this.f10970h.width() > 0 && this.f10970h.height() > 0;
    }

    public void Y() {
        Z(false);
    }

    public void Z(boolean z) {
        if ((this.a.getHeight() <= 0 || this.a.getWidth() <= 0) && !z) {
            return;
        }
        b(z);
        d();
    }

    public void b0(int i2, int i3, int i4, int i5) {
        if (a0(this.f10971i, i2, i3, i4, i5)) {
            return;
        }
        this.f10971i.set(i2, i3, i4, i5);
        this.L = true;
        X();
    }

    public float c() {
        if (this.B == null) {
            return 0.0f;
        }
        O(this.N);
        TextPaint textPaint = this.N;
        CharSequence charSequence = this.B;
        return textPaint.measureText(charSequence, 0, charSequence.length());
    }

    public void c0(@NonNull Rect rect) {
        b0(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void d0(int i2) {
        e.j.a.c.w.d dVar = new e.j.a.c.w.d(this.a.getContext(), i2);
        ColorStateList colorStateList = dVar.a;
        if (colorStateList != null) {
            this.p = colorStateList;
        }
        float f2 = dVar.n;
        if (f2 != 0.0f) {
            this.n = f2;
        }
        ColorStateList colorStateList2 = dVar.f11062d;
        if (colorStateList2 != null) {
            this.T = colorStateList2;
        }
        this.R = dVar.f11067i;
        this.S = dVar.f11068j;
        this.Q = dVar.f11069k;
        this.Y = dVar.f11071m;
        e.j.a.c.w.a aVar = this.A;
        if (aVar != null) {
            aVar.c();
        }
        this.A = new e.j.a.c.w.a(new C0370a(), dVar.e());
        dVar.h(this.a.getContext(), this.A);
        Y();
    }

    public void f0(ColorStateList colorStateList) {
        if (this.p != colorStateList) {
            this.p = colorStateList;
            Y();
        }
    }

    public void g0(int i2) {
        if (this.f10974l != i2) {
            this.f10974l = i2;
            Y();
        }
    }

    public void h0(float f2) {
        if (this.n != f2) {
            this.n = f2;
            Y();
        }
    }

    public void i0(Typeface typeface) {
        if (j0(typeface)) {
            Y();
        }
    }

    public void k0(int i2) {
        this.f10969g = i2;
    }

    public void l0(int i2, int i3, int i4, int i5) {
        if (a0(this.f10970h, i2, i3, i4, i5)) {
            return;
        }
        this.f10970h.set(i2, i3, i4, i5);
        this.L = true;
        X();
    }

    public void m(@NonNull Canvas canvas) {
        int save = canvas.save();
        if (this.C == null || !this.b) {
            return;
        }
        boolean z = true;
        float lineStart = (this.u + (this.f0 > 1 ? this.a0.getLineStart(0) : this.a0.getLineLeft(0))) - (this.d0 * 2.0f);
        this.M.setTextSize(this.J);
        float f2 = this.u;
        float f3 = this.v;
        z = (!this.F || this.G == null) ? false : false;
        float f4 = this.I;
        if (f4 != 1.0f && !this.f10966d) {
            canvas.scale(f4, f4, f2, f3);
        }
        if (z) {
            canvas.drawBitmap(this.G, f2, f3, this.H);
            canvas.restoreToCount(save);
            return;
        }
        if (I0() && (!this.f10966d || this.f10965c > this.f10968f)) {
            n(canvas, lineStart, f3);
        } else {
            canvas.translate(f2, f3);
            this.a0.draw(canvas);
        }
        canvas.restoreToCount(save);
    }

    public void m0(@NonNull Rect rect) {
        l0(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void n0(int i2) {
        e.j.a.c.w.d dVar = new e.j.a.c.w.d(this.a.getContext(), i2);
        ColorStateList colorStateList = dVar.a;
        if (colorStateList != null) {
            this.o = colorStateList;
        }
        float f2 = dVar.n;
        if (f2 != 0.0f) {
            this.f10975m = f2;
        }
        ColorStateList colorStateList2 = dVar.f11062d;
        if (colorStateList2 != null) {
            this.X = colorStateList2;
        }
        this.V = dVar.f11067i;
        this.W = dVar.f11068j;
        this.U = dVar.f11069k;
        this.Z = dVar.f11071m;
        e.j.a.c.w.a aVar = this.z;
        if (aVar != null) {
            aVar.c();
        }
        this.z = new e.j.a.c.w.a(new b(), dVar.e());
        dVar.h(this.a.getContext(), this.z);
        Y();
    }

    public void p(@NonNull RectF rectF, int i2, int i3) {
        this.D = g(this.B);
        rectF.left = t(i2, i3);
        rectF.top = this.f10971i.top;
        rectF.right = u(rectF, i2, i3);
        rectF.bottom = this.f10971i.top + s();
    }

    public void p0(ColorStateList colorStateList) {
        if (this.o != colorStateList) {
            this.o = colorStateList;
            Y();
        }
    }

    public ColorStateList q() {
        return this.p;
    }

    public void q0(int i2) {
        if (this.f10973k != i2) {
            this.f10973k = i2;
            Y();
        }
    }

    public int r() {
        return this.f10974l;
    }

    public void r0(float f2) {
        if (this.f10975m != f2) {
            this.f10975m = f2;
            Y();
        }
    }

    public float s() {
        O(this.N);
        return -this.N.ascent();
    }

    public void s0(Typeface typeface) {
        if (t0(typeface)) {
            Y();
        }
    }

    public void u0(float f2) {
        float clamp = MathUtils.clamp(f2, 0.0f, 1.0f);
        if (clamp != this.f10965c) {
            this.f10965c = clamp;
            d();
        }
    }

    public float v() {
        return this.n;
    }

    public void v0(boolean z) {
        this.f10966d = z;
    }

    public Typeface w() {
        Typeface typeface = this.w;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    public void w0(float f2) {
        this.f10967e = f2;
        this.f10968f = f();
    }

    @ColorInt
    public int x() {
        return y(this.p);
    }

    @RequiresApi(23)
    public void x0(int i2) {
        this.i0 = i2;
    }

    @RequiresApi(23)
    public void z0(float f2) {
        this.g0 = f2;
    }
}
