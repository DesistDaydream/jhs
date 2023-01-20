package e.d.a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.os.Build;
import android.util.Base64;
import android.util.Log;
import com.caverock.androidsvg.CSSParser;
import com.caverock.androidsvg.PreserveAspectRatio;
import com.caverock.androidsvg.SVG;
import com.caverock.androidsvg.SVGParser;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.Stack;

/* loaded from: classes.dex */
public class b {

    /* renamed from: l  reason: collision with root package name */
    private static final String f9967l = "SVGAndroidRenderer";

    /* renamed from: m  reason: collision with root package name */
    private static final float f9968m = 0.5522848f;
    private static final int n = 15;
    private static final int o = 6963;
    private static final int p = 23442;
    private static final int q = 2362;
    private static final String r = "sans-serif";
    private static /* synthetic */ int[] s;
    private static /* synthetic */ int[] t;
    private static /* synthetic */ int[] u;
    private static /* synthetic */ int[] v;
    private Canvas a;
    private SVG.a b;

    /* renamed from: c  reason: collision with root package name */
    private float f9969c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f9970d;

    /* renamed from: e  reason: collision with root package name */
    private SVG f9971e;

    /* renamed from: f  reason: collision with root package name */
    private g f9972f;

    /* renamed from: g  reason: collision with root package name */
    private Stack<g> f9973g;

    /* renamed from: h  reason: collision with root package name */
    private Stack<SVG.g0> f9974h;

    /* renamed from: i  reason: collision with root package name */
    private Stack<Matrix> f9975i;

    /* renamed from: j  reason: collision with root package name */
    private Stack<Canvas> f9976j;

    /* renamed from: k  reason: collision with root package name */
    private Stack<Bitmap> f9977k;

    /* loaded from: classes.dex */
    public class a implements SVG.v {
        private float b;

        /* renamed from: c  reason: collision with root package name */
        private float f9978c;

        /* renamed from: h  reason: collision with root package name */
        private boolean f9983h;
        private List<C0330b> a = new ArrayList();

        /* renamed from: d  reason: collision with root package name */
        private C0330b f9979d = null;

        /* renamed from: e  reason: collision with root package name */
        private boolean f9980e = false;

        /* renamed from: f  reason: collision with root package name */
        private boolean f9981f = true;

        /* renamed from: g  reason: collision with root package name */
        private int f9982g = -1;

        public a(SVG.u uVar) {
            uVar.f(this);
            if (this.f9983h) {
                this.f9979d.b(this.a.get(this.f9982g));
                this.a.set(this.f9982g, this.f9979d);
                this.f9983h = false;
            }
            C0330b c0330b = this.f9979d;
            if (c0330b != null) {
                this.a.add(c0330b);
            }
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void a(float f2, float f3, float f4, float f5) {
            this.f9979d.a(f2, f3);
            this.a.add(this.f9979d);
            this.f9979d = new C0330b(f4, f5, f4 - f2, f5 - f3);
            this.f9983h = false;
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void b(float f2, float f3) {
            if (this.f9983h) {
                this.f9979d.b(this.a.get(this.f9982g));
                this.a.set(this.f9982g, this.f9979d);
                this.f9983h = false;
            }
            C0330b c0330b = this.f9979d;
            if (c0330b != null) {
                this.a.add(c0330b);
            }
            this.b = f2;
            this.f9978c = f3;
            this.f9979d = new C0330b(f2, f3, 0.0f, 0.0f);
            this.f9982g = this.a.size();
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void c(float f2, float f3, float f4, float f5, float f6, float f7) {
            if (this.f9981f || this.f9980e) {
                this.f9979d.a(f2, f3);
                this.a.add(this.f9979d);
                this.f9980e = false;
            }
            this.f9979d = new C0330b(f6, f7, f6 - f4, f7 - f5);
            this.f9983h = false;
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void close() {
            this.a.add(this.f9979d);
            e(this.b, this.f9978c);
            this.f9983h = true;
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void d(float f2, float f3, float f4, boolean z, boolean z2, float f5, float f6) {
            this.f9980e = true;
            this.f9981f = false;
            C0330b c0330b = this.f9979d;
            b.q(c0330b.a, c0330b.b, f2, f3, f4, z, z2, f5, f6, this);
            this.f9981f = true;
            this.f9983h = false;
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void e(float f2, float f3) {
            this.f9979d.a(f2, f3);
            this.a.add(this.f9979d);
            b bVar = b.this;
            C0330b c0330b = this.f9979d;
            this.f9979d = new C0330b(f2, f3, f2 - c0330b.a, f3 - c0330b.b);
            this.f9983h = false;
        }

        public List<C0330b> f() {
            return this.a;
        }
    }

    /* renamed from: e.d.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0330b {
        public float a;
        public float b;

        /* renamed from: c  reason: collision with root package name */
        public float f9985c;

        /* renamed from: d  reason: collision with root package name */
        public float f9986d;

        public C0330b(float f2, float f3, float f4, float f5) {
            this.f9985c = 0.0f;
            this.f9986d = 0.0f;
            this.a = f2;
            this.b = f3;
            double sqrt = Math.sqrt((f4 * f4) + (f5 * f5));
            if (sqrt != 0.0d) {
                this.f9985c = (float) (f4 / sqrt);
                this.f9986d = (float) (f5 / sqrt);
            }
        }

        public void a(float f2, float f3) {
            float f4 = f2 - this.a;
            float f5 = f3 - this.b;
            double sqrt = Math.sqrt((f4 * f4) + (f5 * f5));
            if (sqrt != 0.0d) {
                this.f9985c += (float) (f4 / sqrt);
                this.f9986d += (float) (f5 / sqrt);
            }
        }

        public void b(C0330b c0330b) {
            this.f9985c += c0330b.f9985c;
            this.f9986d += c0330b.f9986d;
        }

        public String toString() {
            return "(" + this.a + Constants.ACCEPT_TIME_SEPARATOR_SP + this.b + ExpandableTextView.N + this.f9985c + Constants.ACCEPT_TIME_SEPARATOR_SP + this.f9986d + ")";
        }
    }

    /* loaded from: classes.dex */
    public class c implements SVG.v {
        public Path a = new Path();
        public float b;

        /* renamed from: c  reason: collision with root package name */
        public float f9988c;

        public c(SVG.u uVar) {
            uVar.f(this);
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void a(float f2, float f3, float f4, float f5) {
            this.a.quadTo(f2, f3, f4, f5);
            this.b = f4;
            this.f9988c = f5;
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void b(float f2, float f3) {
            this.a.moveTo(f2, f3);
            this.b = f2;
            this.f9988c = f3;
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void c(float f2, float f3, float f4, float f5, float f6, float f7) {
            this.a.cubicTo(f2, f3, f4, f5, f6, f7);
            this.b = f6;
            this.f9988c = f7;
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void close() {
            this.a.close();
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void d(float f2, float f3, float f4, boolean z, boolean z2, float f5, float f6) {
            b.q(this.b, this.f9988c, f2, f3, f4, z, z2, f5, f6, this);
            this.b = f5;
            this.f9988c = f6;
        }

        @Override // com.caverock.androidsvg.SVG.v
        public void e(float f2, float f3) {
            this.a.lineTo(f2, f3);
            this.b = f2;
            this.f9988c = f3;
        }

        public Path f() {
            return this.a;
        }
    }

    /* loaded from: classes.dex */
    public class d extends e {

        /* renamed from: e  reason: collision with root package name */
        private Path f9990e;

        public d(Path path, float f2, float f3) {
            super(f2, f3);
            this.f9990e = path;
        }

        @Override // e.d.a.b.e, e.d.a.b.i
        public void b(String str) {
            if (b.this.c1()) {
                if (b.this.f9972f.b) {
                    b.this.a.drawTextOnPath(str, this.f9990e, this.b, this.f9992c, b.this.f9972f.f9998d);
                }
                if (b.this.f9972f.f9997c) {
                    b.this.a.drawTextOnPath(str, this.f9990e, this.b, this.f9992c, b.this.f9972f.f9999e);
                }
            }
            this.b += b.this.f9972f.f9998d.measureText(str);
        }
    }

    /* loaded from: classes.dex */
    public class e extends i {
        public float b;

        /* renamed from: c  reason: collision with root package name */
        public float f9992c;

        public e(float f2, float f3) {
            super(b.this, null);
            this.b = f2;
            this.f9992c = f3;
        }

        @Override // e.d.a.b.i
        public void b(String str) {
            b.G("TextSequence render", new Object[0]);
            if (b.this.c1()) {
                if (b.this.f9972f.b) {
                    b.this.a.drawText(str, this.b, this.f9992c, b.this.f9972f.f9998d);
                }
                if (b.this.f9972f.f9997c) {
                    b.this.a.drawText(str, this.b, this.f9992c, b.this.f9972f.f9999e);
                }
            }
            this.b += b.this.f9972f.f9998d.measureText(str);
        }
    }

    /* loaded from: classes.dex */
    public class f extends i {
        public float b;

        /* renamed from: c  reason: collision with root package name */
        public float f9994c;

        /* renamed from: d  reason: collision with root package name */
        public Path f9995d;

        public f(float f2, float f3, Path path) {
            super(b.this, null);
            this.b = f2;
            this.f9994c = f3;
            this.f9995d = path;
        }

        @Override // e.d.a.b.i
        public boolean a(SVG.v0 v0Var) {
            if (v0Var instanceof SVG.w0) {
                b.d1("Using <textPath> elements in a clip path is not supported.", new Object[0]);
                return false;
            }
            return true;
        }

        @Override // e.d.a.b.i
        public void b(String str) {
            if (b.this.c1()) {
                Path path = new Path();
                b.this.f9972f.f9998d.getTextPath(str, 0, str.length(), this.b, this.f9994c, path);
                this.f9995d.addPath(path);
            }
            this.b += b.this.f9972f.f9998d.measureText(str);
        }
    }

    /* loaded from: classes.dex */
    public class g implements Cloneable {
        public SVG.Style a;
        public boolean b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f9997c;

        /* renamed from: d  reason: collision with root package name */
        public Paint f9998d;

        /* renamed from: e  reason: collision with root package name */
        public Paint f9999e;

        /* renamed from: f  reason: collision with root package name */
        public SVG.a f10000f;

        /* renamed from: g  reason: collision with root package name */
        public SVG.a f10001g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f10002h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f10003i;

        public g() {
            Paint paint = new Paint();
            this.f9998d = paint;
            paint.setFlags(385);
            this.f9998d.setStyle(Paint.Style.FILL);
            this.f9998d.setTypeface(Typeface.DEFAULT);
            Paint paint2 = new Paint();
            this.f9999e = paint2;
            paint2.setFlags(385);
            this.f9999e.setStyle(Paint.Style.STROKE);
            this.f9999e.setTypeface(Typeface.DEFAULT);
            this.a = SVG.Style.a();
        }

        public Object clone() {
            try {
                g gVar = (g) super.clone();
                gVar.a = (SVG.Style) this.a.clone();
                gVar.f9998d = new Paint(this.f9998d);
                gVar.f9999e = new Paint(this.f9999e);
                return gVar;
            } catch (CloneNotSupportedException e2) {
                throw new InternalError(e2.toString());
            }
        }
    }

    /* loaded from: classes.dex */
    public class h extends i {
        public float b;

        /* renamed from: c  reason: collision with root package name */
        public float f10005c;

        /* renamed from: d  reason: collision with root package name */
        public RectF f10006d;

        public h(float f2, float f3) {
            super(b.this, null);
            this.f10006d = new RectF();
            this.b = f2;
            this.f10005c = f3;
        }

        @Override // e.d.a.b.i
        public boolean a(SVG.v0 v0Var) {
            if (v0Var instanceof SVG.w0) {
                SVG.w0 w0Var = (SVG.w0) v0Var;
                SVG.k0 J = v0Var.a.J(w0Var.o);
                if (J == null) {
                    b.N("TextPath path reference '%s' not found", w0Var.o);
                    return false;
                }
                SVG.t tVar = (SVG.t) J;
                Path f2 = new c(tVar.o).f();
                Matrix matrix = tVar.n;
                if (matrix != null) {
                    f2.transform(matrix);
                }
                RectF rectF = new RectF();
                f2.computeBounds(rectF, true);
                this.f10006d.union(rectF);
                return false;
            }
            return true;
        }

        @Override // e.d.a.b.i
        public void b(String str) {
            if (b.this.c1()) {
                Rect rect = new Rect();
                b.this.f9972f.f9998d.getTextBounds(str, 0, str.length(), rect);
                RectF rectF = new RectF(rect);
                rectF.offset(this.b, this.f10005c);
                this.f10006d.union(rectF);
            }
            this.b += b.this.f9972f.f9998d.measureText(str);
        }
    }

    /* loaded from: classes.dex */
    public abstract class i {
        private i() {
        }

        public boolean a(SVG.v0 v0Var) {
            return true;
        }

        public abstract void b(String str);

        public /* synthetic */ i(b bVar, i iVar) {
            this();
        }
    }

    public b(Canvas canvas, SVG.a aVar, float f2) {
        this.a = canvas;
        this.f9969c = f2;
        this.b = aVar;
    }

    private Bitmap A(String str) {
        int indexOf;
        if (str.startsWith("data:") && str.length() >= 14 && (indexOf = str.indexOf(44)) != -1 && indexOf >= 12 && ";base64".equals(str.substring(indexOf - 7, indexOf))) {
            byte[] decode = Base64.decode(str.substring(indexOf + 1), 0);
            return BitmapFactory.decodeByteArray(decode, 0, decode.length);
        }
        return null;
    }

    private void A0(SVG.z zVar) {
        G("Rect render", new Object[0]);
        SVG.n nVar = zVar.q;
        if (nVar == null || zVar.r == null || nVar.k() || zVar.r.k()) {
            return;
        }
        a1(this.f9972f, zVar);
        if (I() && c1()) {
            Matrix matrix = zVar.n;
            if (matrix != null) {
                this.a.concat(matrix);
            }
            Path k0 = k0(zVar);
            Y0(zVar);
            z(zVar);
            x(zVar);
            boolean r0 = r0();
            if (this.f9972f.b) {
                J(zVar, k0);
            }
            if (this.f9972f.f9997c) {
                K(k0);
            }
            if (r0) {
                o0(zVar);
            }
        }
    }

    private Typeface B(String str, Integer num, SVG.Style.FontStyle fontStyle) {
        int i2 = 1;
        boolean z = fontStyle == SVG.Style.FontStyle.Italic;
        if (num.intValue() <= 500) {
            i2 = z ? 2 : 0;
        } else if (z) {
            i2 = 3;
        }
        if (str.equals("serif")) {
            return Typeface.create(Typeface.SERIF, i2);
        }
        if (str.equals(r)) {
            return Typeface.create(Typeface.SANS_SERIF, i2);
        }
        if (str.equals("monospace")) {
            return Typeface.create(Typeface.MONOSPACE, i2);
        }
        if (str.equals("cursive")) {
            return Typeface.create(Typeface.SANS_SERIF, i2);
        }
        if (str.equals("fantasy")) {
            return Typeface.create(Typeface.SANS_SERIF, i2);
        }
        return null;
    }

    private void B0(SVG.c0 c0Var) {
        C0(c0Var, c0Var.s, c0Var.t);
    }

    private void C(SVG.k0 k0Var) {
        Boolean bool;
        if ((k0Var instanceof SVG.i0) && (bool = ((SVG.i0) k0Var).f2518d) != null) {
            this.f9972f.f10002h = bool.booleanValue();
        }
    }

    private void C0(SVG.c0 c0Var, SVG.n nVar, SVG.n nVar2) {
        D0(c0Var, nVar, nVar2, c0Var.p, c0Var.o);
    }

    private int D(float f2) {
        int i2 = (int) (f2 * 256.0f);
        if (i2 < 0) {
            return 0;
        }
        if (i2 > 255) {
            return 255;
        }
        return i2;
    }

    private void D0(SVG.c0 c0Var, SVG.n nVar, SVG.n nVar2, SVG.a aVar, PreserveAspectRatio preserveAspectRatio) {
        float f2;
        G("Svg render", new Object[0]);
        if (nVar == null || !nVar.k()) {
            if (nVar2 == null || !nVar2.k()) {
                if (preserveAspectRatio == null && (preserveAspectRatio = c0Var.o) == null) {
                    preserveAspectRatio = PreserveAspectRatio.f2465e;
                }
                a1(this.f9972f, c0Var);
                if (I()) {
                    if (c0Var.b != null) {
                        SVG.n nVar3 = c0Var.q;
                        float g2 = nVar3 != null ? nVar3.g(this) : 0.0f;
                        SVG.n nVar4 = c0Var.r;
                        r1 = g2;
                        f2 = nVar4 != null ? nVar4.h(this) : 0.0f;
                    } else {
                        f2 = 0.0f;
                    }
                    SVG.a a0 = a0();
                    this.f9972f.f10000f = new SVG.a(r1, f2, nVar != null ? nVar.g(this) : a0.f2494c, nVar2 != null ? nVar2.h(this) : a0.f2495d);
                    if (!this.f9972f.a.v.booleanValue()) {
                        SVG.a aVar2 = this.f9972f.f10000f;
                        S0(aVar2.a, aVar2.b, aVar2.f2494c, aVar2.f2495d);
                    }
                    y(c0Var, this.f9972f.f10000f);
                    if (aVar != null) {
                        this.a.concat(w(this.f9972f.f10000f, aVar, preserveAspectRatio));
                        this.f9972f.f10001g = c0Var.p;
                    } else {
                        this.a.translate(r1, f2);
                    }
                    boolean r0 = r0();
                    b1();
                    J0(c0Var, true);
                    if (r0) {
                        o0(c0Var);
                    }
                    Y0(c0Var);
                }
            }
        }
    }

    private void E() {
        this.a.restore();
        this.f9972f = this.f9973g.pop();
    }

    private void E0(SVG.k0 k0Var) {
        if (k0Var instanceof SVG.r) {
            return;
        }
        W0();
        C(k0Var);
        if (k0Var instanceof SVG.c0) {
            B0((SVG.c0) k0Var);
        } else if (k0Var instanceof SVG.a1) {
            I0((SVG.a1) k0Var);
        } else if (k0Var instanceof SVG.p0) {
            F0((SVG.p0) k0Var);
        } else if (k0Var instanceof SVG.k) {
            u0((SVG.k) k0Var);
        } else if (k0Var instanceof SVG.m) {
            v0((SVG.m) k0Var);
        } else if (k0Var instanceof SVG.t) {
            x0((SVG.t) k0Var);
        } else if (k0Var instanceof SVG.z) {
            A0((SVG.z) k0Var);
        } else if (k0Var instanceof SVG.c) {
            s0((SVG.c) k0Var);
        } else if (k0Var instanceof SVG.h) {
            t0((SVG.h) k0Var);
        } else if (k0Var instanceof SVG.o) {
            w0((SVG.o) k0Var);
        } else if (k0Var instanceof SVG.y) {
            z0((SVG.y) k0Var);
        } else if (k0Var instanceof SVG.x) {
            y0((SVG.x) k0Var);
        } else if (k0Var instanceof SVG.t0) {
            H0((SVG.t0) k0Var);
        }
        V0();
    }

    private void F() {
        this.a.save(1);
        this.f9973g.push(this.f9972f);
        this.f9972f = (g) this.f9972f.clone();
    }

    private void F0(SVG.p0 p0Var) {
        G("Switch render", new Object[0]);
        a1(this.f9972f, p0Var);
        if (I()) {
            Matrix matrix = p0Var.o;
            if (matrix != null) {
                this.a.concat(matrix);
            }
            x(p0Var);
            boolean r0 = r0();
            O0(p0Var);
            if (r0) {
                o0(p0Var);
            }
            Y0(p0Var);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void G(String str, Object... objArr) {
    }

    private void G0(SVG.q0 q0Var, SVG.n nVar, SVG.n nVar2) {
        G("Symbol render", new Object[0]);
        if (nVar == null || !nVar.k()) {
            if (nVar2 == null || !nVar2.k()) {
                PreserveAspectRatio preserveAspectRatio = q0Var.o;
                if (preserveAspectRatio == null) {
                    preserveAspectRatio = PreserveAspectRatio.f2465e;
                }
                a1(this.f9972f, q0Var);
                this.f9972f.f10000f = new SVG.a(0.0f, 0.0f, nVar != null ? nVar.g(this) : this.f9972f.f10000f.f2494c, nVar2 != null ? nVar2.g(this) : this.f9972f.f10000f.f2495d);
                if (!this.f9972f.a.v.booleanValue()) {
                    SVG.a aVar = this.f9972f.f10000f;
                    S0(aVar.a, aVar.b, aVar.f2494c, aVar.f2495d);
                }
                SVG.a aVar2 = q0Var.p;
                if (aVar2 != null) {
                    this.a.concat(w(this.f9972f.f10000f, aVar2, preserveAspectRatio));
                    this.f9972f.f10001g = q0Var.p;
                }
                boolean r0 = r0();
                J0(q0Var, true);
                if (r0) {
                    o0(q0Var);
                }
                Y0(q0Var);
            }
        }
    }

    private void H(boolean z, SVG.a aVar, SVG.s sVar) {
        SVG.k0 J = this.f9971e.J(sVar.a);
        if (J == null) {
            Object[] objArr = new Object[2];
            objArr[0] = z ? "Fill" : "Stroke";
            objArr[1] = sVar.a;
            N("%s reference '%s' not found", objArr);
            SVG.l0 l0Var = sVar.b;
            if (l0Var != null) {
                T0(this.f9972f, z, l0Var);
                return;
            } else if (z) {
                this.f9972f.b = false;
                return;
            } else {
                this.f9972f.f9997c = false;
                return;
            }
        }
        if (J instanceof SVG.j0) {
            f0(z, aVar, (SVG.j0) J);
        }
        if (J instanceof SVG.n0) {
            l0(z, aVar, (SVG.n0) J);
        }
        if (J instanceof SVG.a0) {
            U0(z, (SVG.a0) J);
        }
    }

    private void H0(SVG.t0 t0Var) {
        G("Text render", new Object[0]);
        a1(this.f9972f, t0Var);
        if (I()) {
            Matrix matrix = t0Var.s;
            if (matrix != null) {
                this.a.concat(matrix);
            }
            List<SVG.n> list = t0Var.o;
            float f2 = 0.0f;
            float g2 = (list == null || list.size() == 0) ? 0.0f : t0Var.o.get(0).g(this);
            List<SVG.n> list2 = t0Var.p;
            float h2 = (list2 == null || list2.size() == 0) ? 0.0f : t0Var.p.get(0).h(this);
            List<SVG.n> list3 = t0Var.q;
            float g3 = (list3 == null || list3.size() == 0) ? 0.0f : t0Var.q.get(0).g(this);
            List<SVG.n> list4 = t0Var.r;
            if (list4 != null && list4.size() != 0) {
                f2 = t0Var.r.get(0).h(this);
            }
            SVG.Style.TextAnchor W = W();
            if (W != SVG.Style.TextAnchor.Start) {
                float v2 = v(t0Var);
                if (W == SVG.Style.TextAnchor.Middle) {
                    v2 /= 2.0f;
                }
                g2 -= v2;
            }
            if (t0Var.f2511h == null) {
                h hVar = new h(g2, h2);
                M(t0Var, hVar);
                RectF rectF = hVar.f10006d;
                t0Var.f2511h = new SVG.a(rectF.left, rectF.top, rectF.width(), hVar.f10006d.height());
            }
            Y0(t0Var);
            z(t0Var);
            x(t0Var);
            boolean r0 = r0();
            M(t0Var, new e(g2 + g3, h2 + f2));
            if (r0) {
                o0(t0Var);
            }
        }
    }

    private boolean I() {
        Boolean bool = this.f9972f.a.A;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    private void I0(SVG.a1 a1Var) {
        G("Use render", new Object[0]);
        SVG.n nVar = a1Var.s;
        if (nVar == null || !nVar.k()) {
            SVG.n nVar2 = a1Var.t;
            if (nVar2 == null || !nVar2.k()) {
                a1(this.f9972f, a1Var);
                if (I()) {
                    SVG.k0 J = a1Var.a.J(a1Var.p);
                    if (J == null) {
                        N("Use reference '%s' not found", a1Var.p);
                        return;
                    }
                    Matrix matrix = a1Var.o;
                    if (matrix != null) {
                        this.a.concat(matrix);
                    }
                    Matrix matrix2 = new Matrix();
                    SVG.n nVar3 = a1Var.q;
                    float g2 = nVar3 != null ? nVar3.g(this) : 0.0f;
                    SVG.n nVar4 = a1Var.r;
                    matrix2.preTranslate(g2, nVar4 != null ? nVar4.h(this) : 0.0f);
                    this.a.concat(matrix2);
                    x(a1Var);
                    boolean r0 = r0();
                    n0(a1Var);
                    if (J instanceof SVG.c0) {
                        W0();
                        SVG.c0 c0Var = (SVG.c0) J;
                        SVG.n nVar5 = a1Var.s;
                        if (nVar5 == null) {
                            nVar5 = c0Var.s;
                        }
                        SVG.n nVar6 = a1Var.t;
                        if (nVar6 == null) {
                            nVar6 = c0Var.t;
                        }
                        C0(c0Var, nVar5, nVar6);
                        V0();
                    } else if (J instanceof SVG.q0) {
                        SVG.n nVar7 = a1Var.s;
                        if (nVar7 == null) {
                            nVar7 = new SVG.n(100.0f, SVG.Unit.percent);
                        }
                        SVG.n nVar8 = a1Var.t;
                        if (nVar8 == null) {
                            nVar8 = new SVG.n(100.0f, SVG.Unit.percent);
                        }
                        W0();
                        G0((SVG.q0) J, nVar7, nVar8);
                        V0();
                    } else {
                        E0(J);
                    }
                    m0();
                    if (r0) {
                        o0(a1Var);
                    }
                    Y0(a1Var);
                }
            }
        }
    }

    private void J(SVG.h0 h0Var, Path path) {
        SVG.l0 l0Var = this.f9972f.a.b;
        if (l0Var instanceof SVG.s) {
            SVG.k0 J = this.f9971e.J(((SVG.s) l0Var).a);
            if (J instanceof SVG.w) {
                T(h0Var, path, (SVG.w) J);
                return;
            }
        }
        this.a.drawPath(path, this.f9972f.f9998d);
    }

    private void J0(SVG.g0 g0Var, boolean z) {
        if (z) {
            n0(g0Var);
        }
        for (SVG.k0 k0Var : g0Var.k()) {
            E0(k0Var);
        }
        if (z) {
            m0();
        }
    }

    private void K(Path path) {
        g gVar = this.f9972f;
        if (gVar.a.L == SVG.Style.VectorEffect.NonScalingStroke) {
            Matrix matrix = this.a.getMatrix();
            Path path2 = new Path();
            path.transform(matrix, path2);
            this.a.setMatrix(new Matrix());
            Shader shader = this.f9972f.f9999e.getShader();
            Matrix matrix2 = new Matrix();
            if (shader != null) {
                shader.getLocalMatrix(matrix2);
                Matrix matrix3 = new Matrix(matrix2);
                matrix3.postConcat(matrix);
                shader.setLocalMatrix(matrix3);
            }
            this.a.drawPath(path2, this.f9972f.f9999e);
            this.a.setMatrix(matrix);
            if (shader != null) {
                shader.setLocalMatrix(matrix2);
                return;
            }
            return;
        }
        this.a.drawPath(path, gVar.f9999e);
    }

    private void L() {
        try {
            Bitmap createBitmap = Bitmap.createBitmap(this.a.getWidth(), this.a.getHeight(), Bitmap.Config.ARGB_8888);
            this.f9977k.push(createBitmap);
            Canvas canvas = new Canvas(createBitmap);
            canvas.setMatrix(this.a.getMatrix());
            this.a = canvas;
        } catch (OutOfMemoryError e2) {
            N("Not enough memory to create temporary bitmaps for mask processing", new Object[0]);
            throw e2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0115 A[PHI: r1 
      PHI: (r1v1 float) = (r1v0 float), (r1v2 float) binds: [B:62:0x010a, B:66:0x0114] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0153  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void L0(com.caverock.androidsvg.SVG.p r12, e.d.a.b.C0330b r13) {
        /*
            Method dump skipped, instructions count: 362
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.d.a.b.L0(com.caverock.androidsvg.SVG$p, e.d.a.b$b):void");
    }

    private void M(SVG.v0 v0Var, i iVar) {
        if (I()) {
            Iterator<SVG.k0> it = v0Var.f2501i.iterator();
            boolean z = true;
            while (it.hasNext()) {
                SVG.k0 next = it.next();
                if (next instanceof SVG.z0) {
                    iVar.b(X0(((SVG.z0) next).f2531c, z, !it.hasNext()));
                } else {
                    q0(next, iVar);
                }
                z = false;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0098 A[ADDED_TO_REGION, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void M0(com.caverock.androidsvg.SVG.j r9) {
        /*
            Method dump skipped, instructions count: 214
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.d.a.b.M0(com.caverock.androidsvg.SVG$j):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void N(String str, Object... objArr) {
        Log.e(f9967l, String.format(str, objArr));
    }

    private void N0(SVG.q qVar, SVG.h0 h0Var) {
        float f2;
        float f3;
        G("Mask render", new Object[0]);
        Boolean bool = qVar.o;
        boolean z = true;
        if (bool != null && bool.booleanValue()) {
            SVG.n nVar = qVar.s;
            f2 = nVar != null ? nVar.g(this) : h0Var.f2511h.f2494c;
            SVG.n nVar2 = qVar.t;
            f3 = nVar2 != null ? nVar2.h(this) : h0Var.f2511h.f2495d;
            SVG.n nVar3 = qVar.q;
            if (nVar3 != null) {
                nVar3.g(this);
            } else {
                SVG.a aVar = h0Var.f2511h;
                float f4 = aVar.a;
                float f5 = aVar.f2494c;
            }
            SVG.n nVar4 = qVar.r;
            if (nVar4 != null) {
                nVar4.h(this);
            } else {
                SVG.a aVar2 = h0Var.f2511h;
                float f6 = aVar2.b;
                float f7 = aVar2.f2495d;
            }
        } else {
            SVG.n nVar5 = qVar.q;
            if (nVar5 != null) {
                nVar5.f(this, 1.0f);
            }
            SVG.n nVar6 = qVar.r;
            if (nVar6 != null) {
                nVar6.f(this, 1.0f);
            }
            SVG.n nVar7 = qVar.s;
            float f8 = nVar7 != null ? nVar7.f(this, 1.0f) : 1.2f;
            SVG.n nVar8 = qVar.t;
            float f9 = nVar8 != null ? nVar8.f(this, 1.0f) : 1.2f;
            SVG.a aVar3 = h0Var.f2511h;
            float f10 = aVar3.a;
            float f11 = aVar3.f2494c;
            float f12 = aVar3.b;
            f2 = f8 * f11;
            f3 = f9 * aVar3.f2495d;
        }
        if (f2 == 0.0f || f3 == 0.0f) {
            return;
        }
        W0();
        g U = U(qVar);
        this.f9972f = U;
        U.a.f2493m = Float.valueOf(1.0f);
        Boolean bool2 = qVar.p;
        if (bool2 != null && !bool2.booleanValue()) {
            z = false;
        }
        if (!z) {
            Canvas canvas = this.a;
            SVG.a aVar4 = h0Var.f2511h;
            canvas.translate(aVar4.a, aVar4.b);
            Canvas canvas2 = this.a;
            SVG.a aVar5 = h0Var.f2511h;
            canvas2.scale(aVar5.f2494c, aVar5.f2495d);
        }
        J0(qVar, false);
        V0();
    }

    private void O(SVG.v0 v0Var, StringBuilder sb) {
        Iterator<SVG.k0> it = v0Var.f2501i.iterator();
        boolean z = true;
        while (it.hasNext()) {
            SVG.k0 next = it.next();
            if (next instanceof SVG.v0) {
                O((SVG.v0) next, sb);
            } else if (next instanceof SVG.z0) {
                sb.append(X0(((SVG.z0) next).f2531c, z, !it.hasNext()));
            }
            z = false;
        }
    }

    private void O0(SVG.p0 p0Var) {
        Set<String> b;
        String language = Locale.getDefault().getLanguage();
        e.d.a.c q2 = this.f9971e.q();
        for (SVG.k0 k0Var : p0Var.k()) {
            if (k0Var instanceof SVG.d0) {
                SVG.d0 d0Var = (SVG.d0) k0Var;
                if (d0Var.c() == null && ((b = d0Var.b()) == null || (!b.isEmpty() && b.contains(language)))) {
                    Set<String> a2 = d0Var.a();
                    if (a2 == null || (!a2.isEmpty() && SVGParser.c0.containsAll(a2))) {
                        Set<String> n2 = d0Var.n();
                        if (n2 != null) {
                            if (!n2.isEmpty() && q2 != null) {
                                for (String str : n2) {
                                    if (!q2.a(str)) {
                                        break;
                                    }
                                }
                            }
                        }
                        Set<String> o2 = d0Var.o();
                        if (o2 != null) {
                            if (!o2.isEmpty() && q2 != null) {
                                for (String str2 : o2) {
                                    if (q2.b(str2, this.f9972f.a.q.intValue(), String.valueOf(this.f9972f.a.r)) == null) {
                                        break;
                                    }
                                }
                            }
                        }
                        E0(k0Var);
                        return;
                    }
                }
            }
        }
    }

    private void P(SVG.i iVar, String str) {
        SVG.k0 J = iVar.a.J(str);
        if (J == null) {
            d1("Gradient reference '%s' not found", str);
        } else if (!(J instanceof SVG.i)) {
            N("Gradient href attributes must point to other gradient elements", new Object[0]);
        } else if (J == iVar) {
            N("Circular reference in gradient href attribute '%s'", str);
        } else {
            SVG.i iVar2 = (SVG.i) J;
            if (iVar.f2513i == null) {
                iVar.f2513i = iVar2.f2513i;
            }
            if (iVar.f2514j == null) {
                iVar.f2514j = iVar2.f2514j;
            }
            if (iVar.f2515k == null) {
                iVar.f2515k = iVar2.f2515k;
            }
            if (iVar.f2512h.isEmpty()) {
                iVar.f2512h = iVar2.f2512h;
            }
            try {
                if (iVar instanceof SVG.j0) {
                    Q((SVG.j0) iVar, (SVG.j0) J);
                } else {
                    R((SVG.n0) iVar, (SVG.n0) J);
                }
            } catch (ClassCastException unused) {
            }
            String str2 = iVar2.f2516l;
            if (str2 != null) {
                P(iVar, str2);
            }
        }
    }

    private void P0(SVG.w0 w0Var) {
        G("TextPath render", new Object[0]);
        a1(this.f9972f, w0Var);
        if (I() && c1()) {
            SVG.k0 J = w0Var.a.J(w0Var.o);
            if (J == null) {
                N("TextPath reference '%s' not found", w0Var.o);
                return;
            }
            SVG.t tVar = (SVG.t) J;
            Path f2 = new c(tVar.o).f();
            Matrix matrix = tVar.n;
            if (matrix != null) {
                f2.transform(matrix);
            }
            PathMeasure pathMeasure = new PathMeasure(f2, false);
            SVG.n nVar = w0Var.p;
            float f3 = nVar != null ? nVar.f(this, pathMeasure.getLength()) : 0.0f;
            SVG.Style.TextAnchor W = W();
            if (W != SVG.Style.TextAnchor.Start) {
                float v2 = v(w0Var);
                if (W == SVG.Style.TextAnchor.Middle) {
                    v2 /= 2.0f;
                }
                f3 -= v2;
            }
            z((SVG.h0) w0Var.e());
            boolean r0 = r0();
            M(w0Var, new d(f2, f3, 0.0f));
            if (r0) {
                o0(w0Var);
            }
        }
    }

    private void Q(SVG.j0 j0Var, SVG.j0 j0Var2) {
        if (j0Var.f2522m == null) {
            j0Var.f2522m = j0Var2.f2522m;
        }
        if (j0Var.n == null) {
            j0Var.n = j0Var2.n;
        }
        if (j0Var.o == null) {
            j0Var.o = j0Var2.o;
        }
        if (j0Var.p == null) {
            j0Var.p = j0Var2.p;
        }
    }

    private boolean Q0() {
        g gVar = this.f9972f;
        if (gVar.a.G != null && !gVar.f10003i) {
            d1("Masks are not supported when using getPicture()", new Object[0]);
        }
        if (this.f9972f.a.f2493m.floatValue() >= 1.0f) {
            g gVar2 = this.f9972f;
            return gVar2.a.G != null && gVar2.f10003i;
        }
        return true;
    }

    private void R(SVG.n0 n0Var, SVG.n0 n0Var2) {
        if (n0Var.f2524m == null) {
            n0Var.f2524m = n0Var2.f2524m;
        }
        if (n0Var.n == null) {
            n0Var.n = n0Var2.n;
        }
        if (n0Var.o == null) {
            n0Var.o = n0Var2.o;
        }
        if (n0Var.p == null) {
            n0Var.p = n0Var2.p;
        }
        if (n0Var.q == null) {
            n0Var.q = n0Var2.q;
        }
    }

    private void R0() {
        this.f9972f = new g();
        this.f9973g = new Stack<>();
        Z0(this.f9972f, SVG.Style.a());
        g gVar = this.f9972f;
        gVar.f10000f = this.b;
        gVar.f10002h = false;
        gVar.f10003i = this.f9970d;
        this.f9973g.push((g) gVar.clone());
        this.f9976j = new Stack<>();
        this.f9977k = new Stack<>();
        this.f9975i = new Stack<>();
        this.f9974h = new Stack<>();
    }

    private void S(SVG.w wVar, String str) {
        SVG.k0 J = wVar.a.J(str);
        if (J == null) {
            d1("Pattern reference '%s' not found", str);
        } else if (!(J instanceof SVG.w)) {
            N("Pattern href attributes must point to other pattern elements", new Object[0]);
        } else if (J == wVar) {
            N("Circular reference in pattern href attribute '%s'", str);
        } else {
            SVG.w wVar2 = (SVG.w) J;
            if (wVar.q == null) {
                wVar.q = wVar2.q;
            }
            if (wVar.r == null) {
                wVar.r = wVar2.r;
            }
            if (wVar.s == null) {
                wVar.s = wVar2.s;
            }
            if (wVar.t == null) {
                wVar.t = wVar2.t;
            }
            if (wVar.u == null) {
                wVar.u = wVar2.u;
            }
            if (wVar.v == null) {
                wVar.v = wVar2.v;
            }
            if (wVar.w == null) {
                wVar.w = wVar2.w;
            }
            if (wVar.f2501i.isEmpty()) {
                wVar.f2501i = wVar2.f2501i;
            }
            if (wVar.p == null) {
                wVar.p = wVar2.p;
            }
            if (wVar.o == null) {
                wVar.o = wVar2.o;
            }
            String str2 = wVar2.x;
            if (str2 != null) {
                S(wVar, str2);
            }
        }
    }

    private void S0(float f2, float f3, float f4, float f5) {
        float f6 = f4 + f2;
        float f7 = f5 + f3;
        SVG.b bVar = this.f9972f.a.w;
        if (bVar != null) {
            f2 += bVar.f2499d.g(this);
            f3 += this.f9972f.a.w.a.h(this);
            f6 -= this.f9972f.a.w.b.g(this);
            f7 -= this.f9972f.a.w.f2498c.h(this);
        }
        this.a.clipRect(f2, f3, f6, f7);
    }

    private void T(SVG.h0 h0Var, Path path, SVG.w wVar) {
        float f2;
        float f3;
        float f4;
        float f5;
        Boolean bool = wVar.q;
        boolean z = bool != null && bool.booleanValue();
        String str = wVar.x;
        if (str != null) {
            S(wVar, str);
        }
        if (z) {
            SVG.n nVar = wVar.t;
            f2 = nVar != null ? nVar.g(this) : 0.0f;
            SVG.n nVar2 = wVar.u;
            f4 = nVar2 != null ? nVar2.h(this) : 0.0f;
            SVG.n nVar3 = wVar.v;
            f5 = nVar3 != null ? nVar3.g(this) : 0.0f;
            SVG.n nVar4 = wVar.w;
            f3 = nVar4 != null ? nVar4.h(this) : 0.0f;
        } else {
            SVG.n nVar5 = wVar.t;
            float f6 = nVar5 != null ? nVar5.f(this, 1.0f) : 0.0f;
            SVG.n nVar6 = wVar.u;
            float f7 = nVar6 != null ? nVar6.f(this, 1.0f) : 0.0f;
            SVG.n nVar7 = wVar.v;
            float f8 = nVar7 != null ? nVar7.f(this, 1.0f) : 0.0f;
            SVG.n nVar8 = wVar.w;
            float f9 = nVar8 != null ? nVar8.f(this, 1.0f) : 0.0f;
            SVG.a aVar = h0Var.f2511h;
            float f10 = aVar.a;
            float f11 = aVar.f2494c;
            f2 = (f6 * f11) + f10;
            float f12 = aVar.b;
            float f13 = aVar.f2495d;
            float f14 = f8 * f11;
            f3 = f9 * f13;
            f4 = (f7 * f13) + f12;
            f5 = f14;
        }
        if (f5 == 0.0f || f3 == 0.0f) {
            return;
        }
        PreserveAspectRatio preserveAspectRatio = wVar.o;
        if (preserveAspectRatio == null) {
            preserveAspectRatio = PreserveAspectRatio.f2465e;
        }
        W0();
        this.a.clipPath(path);
        g gVar = new g();
        Z0(gVar, SVG.Style.a());
        gVar.a.v = Boolean.FALSE;
        this.f9972f = V(wVar, gVar);
        SVG.a aVar2 = h0Var.f2511h;
        Matrix matrix = wVar.s;
        if (matrix != null) {
            this.a.concat(matrix);
            Matrix matrix2 = new Matrix();
            if (wVar.s.invert(matrix2)) {
                SVG.a aVar3 = h0Var.f2511h;
                SVG.a aVar4 = h0Var.f2511h;
                SVG.a aVar5 = h0Var.f2511h;
                float[] fArr = {aVar3.a, aVar3.b, aVar3.b(), aVar4.b, aVar4.b(), h0Var.f2511h.c(), aVar5.a, aVar5.c()};
                matrix2.mapPoints(fArr);
                RectF rectF = new RectF(fArr[0], fArr[1], fArr[0], fArr[1]);
                for (int i2 = 2; i2 <= 6; i2 += 2) {
                    if (fArr[i2] < rectF.left) {
                        rectF.left = fArr[i2];
                    }
                    if (fArr[i2] > rectF.right) {
                        rectF.right = fArr[i2];
                    }
                    int i3 = i2 + 1;
                    if (fArr[i3] < rectF.top) {
                        rectF.top = fArr[i3];
                    }
                    if (fArr[i3] > rectF.bottom) {
                        rectF.bottom = fArr[i3];
                    }
                }
                float f15 = rectF.left;
                float f16 = rectF.top;
                aVar2 = new SVG.a(f15, f16, rectF.right - f15, rectF.bottom - f16);
            }
        }
        float floor = f2 + (((float) Math.floor((aVar2.a - f2) / f5)) * f5);
        float b = aVar2.b();
        float c2 = aVar2.c();
        SVG.a aVar6 = new SVG.a(0.0f, 0.0f, f5, f3);
        for (float floor2 = f4 + (((float) Math.floor((aVar2.b - f4) / f3)) * f3); floor2 < c2; floor2 += f3) {
            for (float f17 = floor; f17 < b; f17 += f5) {
                aVar6.a = f17;
                aVar6.b = floor2;
                W0();
                if (!this.f9972f.a.v.booleanValue()) {
                    S0(aVar6.a, aVar6.b, aVar6.f2494c, aVar6.f2495d);
                }
                SVG.a aVar7 = wVar.p;
                if (aVar7 != null) {
                    this.a.concat(w(aVar6, aVar7, preserveAspectRatio));
                } else {
                    Boolean bool2 = wVar.r;
                    boolean z2 = bool2 == null || bool2.booleanValue();
                    this.a.translate(f17, floor2);
                    if (!z2) {
                        Canvas canvas = this.a;
                        SVG.a aVar8 = h0Var.f2511h;
                        canvas.scale(aVar8.f2494c, aVar8.f2495d);
                    }
                }
                boolean r0 = r0();
                for (SVG.k0 k0Var : wVar.f2501i) {
                    E0(k0Var);
                }
                if (r0) {
                    o0(wVar);
                }
                V0();
            }
        }
        V0();
    }

    private void T0(g gVar, boolean z, SVG.l0 l0Var) {
        int i2;
        SVG.Style style = gVar.a;
        float floatValue = (z ? style.f2484d : style.f2486f).floatValue();
        if (l0Var instanceof SVG.e) {
            i2 = ((SVG.e) l0Var).a;
        } else if (!(l0Var instanceof SVG.f)) {
            return;
        } else {
            i2 = gVar.a.n.a;
        }
        int D = i2 | (D(floatValue) << 24);
        if (z) {
            gVar.f9998d.setColor(D);
        } else {
            gVar.f9999e.setColor(D);
        }
    }

    private g U(SVG.k0 k0Var) {
        g gVar = new g();
        Z0(gVar, SVG.Style.a());
        return V(k0Var, gVar);
    }

    private void U0(boolean z, SVG.a0 a0Var) {
        if (z) {
            if (e0(a0Var.f2519e, SVG.S)) {
                g gVar = this.f9972f;
                SVG.Style style = gVar.a;
                SVG.l0 l0Var = a0Var.f2519e.H;
                style.b = l0Var;
                gVar.b = l0Var != null;
            }
            if (e0(a0Var.f2519e, SVG.T)) {
                this.f9972f.a.f2484d = a0Var.f2519e.I;
            }
            if (e0(a0Var.f2519e, 6442450944L)) {
                g gVar2 = this.f9972f;
                T0(gVar2, z, gVar2.a.b);
                return;
            }
            return;
        }
        if (e0(a0Var.f2519e, SVG.S)) {
            g gVar3 = this.f9972f;
            SVG.Style style2 = gVar3.a;
            SVG.l0 l0Var2 = a0Var.f2519e.H;
            style2.f2485e = l0Var2;
            gVar3.f9997c = l0Var2 != null;
        }
        if (e0(a0Var.f2519e, SVG.T)) {
            this.f9972f.a.f2486f = a0Var.f2519e.I;
        }
        if (e0(a0Var.f2519e, 6442450944L)) {
            g gVar4 = this.f9972f;
            T0(gVar4, z, gVar4.a.f2485e);
        }
    }

    private g V(SVG.k0 k0Var, g gVar) {
        ArrayList<SVG.i0> arrayList = new ArrayList();
        while (true) {
            if (k0Var instanceof SVG.i0) {
                arrayList.add(0, (SVG.i0) k0Var);
            }
            SVG.g0 g0Var = k0Var.b;
            if (g0Var == null) {
                break;
            }
            k0Var = (SVG.k0) g0Var;
        }
        for (SVG.i0 i0Var : arrayList) {
            a1(gVar, i0Var);
        }
        SVG.a aVar = this.f9971e.x().p;
        gVar.f10001g = aVar;
        if (aVar == null) {
            gVar.f10001g = this.b;
        }
        gVar.f10000f = this.b;
        gVar.f10003i = this.f9972f.f10003i;
        return gVar;
    }

    private void V0() {
        this.a.restore();
        this.f9972f = this.f9973g.pop();
    }

    private SVG.Style.TextAnchor W() {
        SVG.Style.TextAnchor textAnchor;
        SVG.Style style = this.f9972f.a;
        if (style.t != SVG.Style.TextDirection.LTR && (textAnchor = style.u) != SVG.Style.TextAnchor.Middle) {
            SVG.Style.TextAnchor textAnchor2 = SVG.Style.TextAnchor.Start;
            return textAnchor == textAnchor2 ? SVG.Style.TextAnchor.End : textAnchor2;
        }
        return style.u;
    }

    private void W0() {
        this.a.save();
        this.f9973g.push(this.f9972f);
        this.f9972f = (g) this.f9972f.clone();
    }

    private Path.FillType X() {
        if (this.f9972f.a.F == null) {
            return Path.FillType.WINDING;
        }
        if (b()[this.f9972f.a.F.ordinal()] != 2) {
            return Path.FillType.WINDING;
        }
        return Path.FillType.EVEN_ODD;
    }

    private String X0(String str, boolean z, boolean z2) {
        if (this.f9972f.f10002h) {
            return str.replaceAll("[\\n\\t]", ExpandableTextView.N);
        }
        String replaceAll = str.replaceAll("\\n", "").replaceAll("\\t", ExpandableTextView.N);
        if (z) {
            replaceAll = replaceAll.replaceAll("^\\s+", "");
        }
        if (z2) {
            replaceAll = replaceAll.replaceAll("\\s+$", "");
        }
        return replaceAll.replaceAll("\\s{2,}", ExpandableTextView.N);
    }

    private void Y0(SVG.h0 h0Var) {
        if (h0Var.b == null || h0Var.f2511h == null) {
            return;
        }
        Matrix matrix = new Matrix();
        if (this.f9975i.peek().invert(matrix)) {
            SVG.a aVar = h0Var.f2511h;
            SVG.a aVar2 = h0Var.f2511h;
            SVG.a aVar3 = h0Var.f2511h;
            float[] fArr = {aVar.a, aVar.b, aVar.b(), aVar2.b, aVar2.b(), h0Var.f2511h.c(), aVar3.a, aVar3.c()};
            matrix.preConcat(this.a.getMatrix());
            matrix.mapPoints(fArr);
            RectF rectF = new RectF(fArr[0], fArr[1], fArr[0], fArr[1]);
            for (int i2 = 2; i2 <= 6; i2 += 2) {
                if (fArr[i2] < rectF.left) {
                    rectF.left = fArr[i2];
                }
                if (fArr[i2] > rectF.right) {
                    rectF.right = fArr[i2];
                }
                int i3 = i2 + 1;
                if (fArr[i3] < rectF.top) {
                    rectF.top = fArr[i3];
                }
                if (fArr[i3] > rectF.bottom) {
                    rectF.bottom = fArr[i3];
                }
            }
            SVG.h0 h0Var2 = (SVG.h0) this.f9974h.peek();
            SVG.a aVar4 = h0Var2.f2511h;
            if (aVar4 == null) {
                h0Var2.f2511h = SVG.a.a(rectF.left, rectF.top, rectF.right, rectF.bottom);
            } else {
                aVar4.f(SVG.a.a(rectF.left, rectF.top, rectF.right, rectF.bottom));
            }
        }
    }

    private void Z0(g gVar, SVG.Style style) {
        SVG svg;
        if (e0(style, 4096L)) {
            gVar.a.n = style.n;
        }
        if (e0(style, 2048L)) {
            gVar.a.f2493m = style.f2493m;
        }
        if (e0(style, 1L)) {
            gVar.a.b = style.b;
            gVar.b = style.b != null;
        }
        if (e0(style, 4L)) {
            gVar.a.f2484d = style.f2484d;
        }
        if (e0(style, 6149L)) {
            T0(gVar, true, gVar.a.b);
        }
        if (e0(style, 2L)) {
            gVar.a.f2483c = style.f2483c;
        }
        if (e0(style, 8L)) {
            gVar.a.f2485e = style.f2485e;
            gVar.f9997c = style.f2485e != null;
        }
        if (e0(style, 16L)) {
            gVar.a.f2486f = style.f2486f;
        }
        if (e0(style, 6168L)) {
            T0(gVar, false, gVar.a.f2485e);
        }
        if (e0(style, SVG.W)) {
            gVar.a.L = style.L;
        }
        if (e0(style, 32L)) {
            SVG.Style style2 = gVar.a;
            SVG.n nVar = style.f2487g;
            style2.f2487g = nVar;
            gVar.f9999e.setStrokeWidth(nVar.e(this));
        }
        if (e0(style, 64L)) {
            gVar.a.f2488h = style.f2488h;
            int i2 = c()[style.f2488h.ordinal()];
            if (i2 == 1) {
                gVar.f9999e.setStrokeCap(Paint.Cap.BUTT);
            } else if (i2 == 2) {
                gVar.f9999e.setStrokeCap(Paint.Cap.ROUND);
            } else if (i2 == 3) {
                gVar.f9999e.setStrokeCap(Paint.Cap.SQUARE);
            }
        }
        if (e0(style, 128L)) {
            gVar.a.f2489i = style.f2489i;
            int i3 = d()[style.f2489i.ordinal()];
            if (i3 == 1) {
                gVar.f9999e.setStrokeJoin(Paint.Join.MITER);
            } else if (i3 == 2) {
                gVar.f9999e.setStrokeJoin(Paint.Join.ROUND);
            } else if (i3 == 3) {
                gVar.f9999e.setStrokeJoin(Paint.Join.BEVEL);
            }
        }
        if (e0(style, 256L)) {
            gVar.a.f2490j = style.f2490j;
            gVar.f9999e.setStrokeMiter(style.f2490j.floatValue());
        }
        if (e0(style, 512L)) {
            gVar.a.f2491k = style.f2491k;
        }
        if (e0(style, 1024L)) {
            gVar.a.f2492l = style.f2492l;
        }
        Typeface typeface = null;
        if (e0(style, 1536L)) {
            SVG.n[] nVarArr = gVar.a.f2491k;
            if (nVarArr == null) {
                gVar.f9999e.setPathEffect(null);
            } else {
                int length = nVarArr.length;
                int i4 = length % 2 == 0 ? length : length * 2;
                float[] fArr = new float[i4];
                float f2 = 0.0f;
                for (int i5 = 0; i5 < i4; i5++) {
                    fArr[i5] = gVar.a.f2491k[i5 % length].e(this);
                    f2 += fArr[i5];
                }
                if (f2 == 0.0f) {
                    gVar.f9999e.setPathEffect(null);
                } else {
                    float e2 = gVar.a.f2492l.e(this);
                    if (e2 < 0.0f) {
                        e2 = (e2 % f2) + f2;
                    }
                    gVar.f9999e.setPathEffect(new DashPathEffect(fArr, e2));
                }
            }
        }
        if (e0(style, 16384L)) {
            float Y = Y();
            gVar.a.p = style.p;
            gVar.f9998d.setTextSize(style.p.f(this, Y));
            gVar.f9999e.setTextSize(style.p.f(this, Y));
        }
        if (e0(style, SVG.A)) {
            gVar.a.o = style.o;
        }
        if (e0(style, SVG.C)) {
            if (style.q.intValue() == -1 && gVar.a.q.intValue() > 100) {
                SVG.Style style3 = gVar.a;
                style3.q = Integer.valueOf(style3.q.intValue() - 100);
            } else if (style.q.intValue() == 1 && gVar.a.q.intValue() < 900) {
                SVG.Style style4 = gVar.a;
                style4.q = Integer.valueOf(style4.q.intValue() + 100);
            } else {
                gVar.a.q = style.q;
            }
        }
        if (e0(style, SVG.D)) {
            gVar.a.r = style.r;
        }
        if (e0(style, 106496L)) {
            if (gVar.a.o != null && (svg = this.f9971e) != null) {
                e.d.a.c q2 = svg.q();
                for (String str : gVar.a.o) {
                    SVG.Style style5 = gVar.a;
                    Typeface B = B(str, style5.q, style5.r);
                    if (B != null || q2 == null) {
                        typeface = B;
                        continue;
                    } else {
                        typeface = q2.b(str, gVar.a.q.intValue(), String.valueOf(gVar.a.r));
                        continue;
                    }
                    if (typeface != null) {
                        break;
                    }
                }
            }
            if (typeface == null) {
                SVG.Style style6 = gVar.a;
                typeface = B(r, style6.q, style6.r);
            }
            gVar.f9998d.setTypeface(typeface);
            gVar.f9999e.setTypeface(typeface);
        }
        if (e0(style, SVG.E)) {
            gVar.a.s = style.s;
            Paint paint = gVar.f9998d;
            SVG.Style.TextDecoration textDecoration = style.s;
            SVG.Style.TextDecoration textDecoration2 = SVG.Style.TextDecoration.LineThrough;
            paint.setStrikeThruText(textDecoration == textDecoration2);
            Paint paint2 = gVar.f9998d;
            SVG.Style.TextDecoration textDecoration3 = style.s;
            SVG.Style.TextDecoration textDecoration4 = SVG.Style.TextDecoration.Underline;
            paint2.setUnderlineText(textDecoration3 == textDecoration4);
            if (Build.VERSION.SDK_INT >= 17) {
                gVar.f9999e.setStrikeThruText(style.s == textDecoration2);
                gVar.f9999e.setUnderlineText(style.s == textDecoration4);
            }
        }
        if (e0(style, SVG.X)) {
            gVar.a.t = style.t;
        }
        if (e0(style, SVG.F)) {
            gVar.a.u = style.u;
        }
        if (e0(style, SVG.G)) {
            gVar.a.v = style.v;
        }
        if (e0(style, SVG.I)) {
            gVar.a.x = style.x;
        }
        if (e0(style, SVG.J)) {
            gVar.a.y = style.y;
        }
        if (e0(style, SVG.K)) {
            gVar.a.z = style.z;
        }
        if (e0(style, SVG.L)) {
            gVar.a.A = style.A;
        }
        if (e0(style, SVG.M)) {
            gVar.a.B = style.B;
        }
        if (e0(style, SVG.H)) {
            gVar.a.w = style.w;
        }
        if (e0(style, SVG.P)) {
            gVar.a.E = style.E;
        }
        if (e0(style, SVG.Q)) {
            gVar.a.F = style.F;
        }
        if (e0(style, SVG.R)) {
            gVar.a.G = style.G;
        }
        if (e0(style, SVG.N)) {
            gVar.a.C = style.C;
        }
        if (e0(style, SVG.O)) {
            gVar.a.D = style.D;
        }
        if (e0(style, SVG.U)) {
            gVar.a.J = style.J;
        }
        if (e0(style, SVG.V)) {
            gVar.a.K = style.K;
        }
    }

    public static /* synthetic */ int[] a() {
        int[] iArr = s;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[PreserveAspectRatio.Alignment.valuesCustom().length];
        try {
            iArr2[PreserveAspectRatio.Alignment.None.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[PreserveAspectRatio.Alignment.XMaxYMax.ordinal()] = 10;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[PreserveAspectRatio.Alignment.XMaxYMid.ordinal()] = 7;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[PreserveAspectRatio.Alignment.XMaxYMin.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr2[PreserveAspectRatio.Alignment.XMidYMax.ordinal()] = 9;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            iArr2[PreserveAspectRatio.Alignment.XMidYMid.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            iArr2[PreserveAspectRatio.Alignment.XMidYMin.ordinal()] = 3;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            iArr2[PreserveAspectRatio.Alignment.XMinYMax.ordinal()] = 8;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            iArr2[PreserveAspectRatio.Alignment.XMinYMid.ordinal()] = 5;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            iArr2[PreserveAspectRatio.Alignment.XMinYMin.ordinal()] = 2;
        } catch (NoSuchFieldError unused10) {
        }
        s = iArr2;
        return iArr2;
    }

    private void a1(g gVar, SVG.i0 i0Var) {
        gVar.a.c(i0Var.b == null);
        SVG.Style style = i0Var.f2519e;
        if (style != null) {
            Z0(gVar, style);
        }
        if (this.f9971e.A()) {
            for (CSSParser.c cVar : this.f9971e.c()) {
                if (CSSParser.m(cVar.a, i0Var)) {
                    Z0(gVar, cVar.b);
                }
            }
        }
        SVG.Style style2 = i0Var.f2520f;
        if (style2 != null) {
            Z0(gVar, style2);
        }
    }

    public static /* synthetic */ int[] b() {
        int[] iArr = v;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[SVG.Style.FillRule.valuesCustom().length];
        try {
            iArr2[SVG.Style.FillRule.EvenOdd.ordinal()] = 2;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[SVG.Style.FillRule.NonZero.ordinal()] = 1;
        } catch (NoSuchFieldError unused2) {
        }
        v = iArr2;
        return iArr2;
    }

    private void b1() {
        int i2;
        SVG.Style style = this.f9972f.a;
        SVG.l0 l0Var = style.J;
        if (l0Var instanceof SVG.e) {
            i2 = ((SVG.e) l0Var).a;
        } else if (!(l0Var instanceof SVG.f)) {
            return;
        } else {
            i2 = style.n.a;
        }
        Float f2 = style.K;
        if (f2 != null) {
            i2 |= D(f2.floatValue()) << 24;
        }
        this.a.drawColor(i2);
    }

    public static /* synthetic */ int[] c() {
        int[] iArr = t;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[SVG.Style.LineCaps.valuesCustom().length];
        try {
            iArr2[SVG.Style.LineCaps.Butt.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[SVG.Style.LineCaps.Round.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[SVG.Style.LineCaps.Square.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        t = iArr2;
        return iArr2;
    }

    private Path.FillType c0() {
        if (this.f9972f.a.f2483c == null) {
            return Path.FillType.WINDING;
        }
        if (b()[this.f9972f.a.f2483c.ordinal()] != 2) {
            return Path.FillType.WINDING;
        }
        return Path.FillType.EVEN_ODD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c1() {
        Boolean bool = this.f9972f.a.B;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    public static /* synthetic */ int[] d() {
        int[] iArr = u;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[SVG.Style.LineJoin.valuesCustom().length];
        try {
            iArr2[SVG.Style.LineJoin.Bevel.ordinal()] = 3;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[SVG.Style.LineJoin.Miter.ordinal()] = 1;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[SVG.Style.LineJoin.Round.ordinal()] = 2;
        } catch (NoSuchFieldError unused3) {
        }
        u = iArr2;
        return iArr2;
    }

    private static void d0(String str, Object... objArr) {
        Log.i(f9967l, String.format(str, objArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d1(String str, Object... objArr) {
        Log.w(f9967l, String.format(str, objArr));
    }

    private boolean e0(SVG.Style style, long j2) {
        return (style.a & j2) != 0;
    }

    private void f0(boolean z, SVG.a aVar, SVG.j0 j0Var) {
        float f2;
        float f3;
        float f4;
        float f5;
        String str = j0Var.f2516l;
        if (str != null) {
            P(j0Var, str);
        }
        Boolean bool = j0Var.f2513i;
        int i2 = 0;
        boolean z2 = bool != null && bool.booleanValue();
        g gVar = this.f9972f;
        Paint paint = z ? gVar.f9998d : gVar.f9999e;
        if (z2) {
            SVG.a a0 = a0();
            SVG.n nVar = j0Var.f2522m;
            float g2 = nVar != null ? nVar.g(this) : 0.0f;
            SVG.n nVar2 = j0Var.n;
            float h2 = nVar2 != null ? nVar2.h(this) : 0.0f;
            SVG.n nVar3 = j0Var.o;
            float g3 = nVar3 != null ? nVar3.g(this) : a0.f2494c;
            SVG.n nVar4 = j0Var.p;
            f2 = nVar4 != null ? nVar4.h(this) : 0.0f;
            f5 = g3;
            f3 = g2;
            f4 = h2;
        } else {
            SVG.n nVar5 = j0Var.f2522m;
            float f6 = nVar5 != null ? nVar5.f(this, 1.0f) : 0.0f;
            SVG.n nVar6 = j0Var.n;
            float f7 = nVar6 != null ? nVar6.f(this, 1.0f) : 0.0f;
            SVG.n nVar7 = j0Var.o;
            float f8 = nVar7 != null ? nVar7.f(this, 1.0f) : 1.0f;
            SVG.n nVar8 = j0Var.p;
            f2 = nVar8 != null ? nVar8.f(this, 1.0f) : 0.0f;
            f3 = f6;
            f4 = f7;
            f5 = f8;
        }
        W0();
        this.f9972f = U(j0Var);
        Matrix matrix = new Matrix();
        if (!z2) {
            matrix.preTranslate(aVar.a, aVar.b);
            matrix.preScale(aVar.f2494c, aVar.f2495d);
        }
        Matrix matrix2 = j0Var.f2514j;
        if (matrix2 != null) {
            matrix.preConcat(matrix2);
        }
        int size = j0Var.f2512h.size();
        if (size == 0) {
            V0();
            if (z) {
                this.f9972f.b = false;
                return;
            } else {
                this.f9972f.f9997c = false;
                return;
            }
        }
        int[] iArr = new int[size];
        float[] fArr = new float[size];
        float f9 = -1.0f;
        Iterator<SVG.k0> it = j0Var.f2512h.iterator();
        while (it.hasNext()) {
            SVG.b0 b0Var = (SVG.b0) it.next();
            if (i2 != 0 && b0Var.f2500h.floatValue() < f9) {
                fArr[i2] = f9;
            } else {
                fArr[i2] = b0Var.f2500h.floatValue();
                f9 = b0Var.f2500h.floatValue();
            }
            W0();
            a1(this.f9972f, b0Var);
            SVG.Style style = this.f9972f.a;
            SVG.e eVar = (SVG.e) style.C;
            if (eVar == null) {
                eVar = SVG.e.b;
            }
            iArr[i2] = (D(style.D.floatValue()) << 24) | eVar.a;
            i2++;
            V0();
        }
        if ((f3 == f5 && f4 == f2) || size == 1) {
            V0();
            paint.setColor(iArr[size - 1]);
            return;
        }
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        SVG.GradientSpread gradientSpread = j0Var.f2515k;
        if (gradientSpread != null) {
            if (gradientSpread == SVG.GradientSpread.reflect) {
                tileMode = Shader.TileMode.MIRROR;
            } else if (gradientSpread == SVG.GradientSpread.repeat) {
                tileMode = Shader.TileMode.REPEAT;
            }
        }
        V0();
        LinearGradient linearGradient = new LinearGradient(f3, f4, f5, f2, iArr, fArr, tileMode);
        linearGradient.setLocalMatrix(matrix);
        paint.setShader(linearGradient);
    }

    private Path g0(SVG.c cVar) {
        SVG.n nVar = cVar.o;
        float g2 = nVar != null ? nVar.g(this) : 0.0f;
        SVG.n nVar2 = cVar.p;
        float h2 = nVar2 != null ? nVar2.h(this) : 0.0f;
        float e2 = cVar.q.e(this);
        float f2 = g2 - e2;
        float f3 = h2 - e2;
        float f4 = g2 + e2;
        float f5 = h2 + e2;
        if (cVar.f2511h == null) {
            float f6 = 2.0f * e2;
            cVar.f2511h = new SVG.a(f2, f3, f6, f6);
        }
        float f7 = f9968m * e2;
        Path path = new Path();
        path.moveTo(g2, f3);
        float f8 = g2 + f7;
        float f9 = h2 - f7;
        path.cubicTo(f8, f3, f4, f9, f4, h2);
        float f10 = h2 + f7;
        path.cubicTo(f4, f10, f8, f5, g2, f5);
        float f11 = g2 - f7;
        path.cubicTo(f11, f5, f2, f10, f2, h2);
        path.cubicTo(f2, f9, f11, f3, g2, f3);
        path.close();
        return path;
    }

    private Path h0(SVG.h hVar) {
        SVG.n nVar = hVar.o;
        float g2 = nVar != null ? nVar.g(this) : 0.0f;
        SVG.n nVar2 = hVar.p;
        float h2 = nVar2 != null ? nVar2.h(this) : 0.0f;
        float g3 = hVar.q.g(this);
        float h3 = hVar.r.h(this);
        float f2 = g2 - g3;
        float f3 = h2 - h3;
        float f4 = g2 + g3;
        float f5 = h2 + h3;
        if (hVar.f2511h == null) {
            hVar.f2511h = new SVG.a(f2, f3, g3 * 2.0f, 2.0f * h3);
        }
        float f6 = g3 * f9968m;
        float f7 = f9968m * h3;
        Path path = new Path();
        path.moveTo(g2, f3);
        float f8 = g2 + f6;
        float f9 = h2 - f7;
        path.cubicTo(f8, f3, f4, f9, f4, h2);
        float f10 = f7 + h2;
        path.cubicTo(f4, f10, f8, f5, g2, f5);
        float f11 = g2 - f6;
        path.cubicTo(f11, f5, f2, f10, f2, h2);
        path.cubicTo(f2, f9, f11, f3, g2, f3);
        path.close();
        return path;
    }

    private Path i0(SVG.o oVar) {
        SVG.n nVar = oVar.o;
        float g2 = nVar == null ? 0.0f : nVar.g(this);
        SVG.n nVar2 = oVar.p;
        float h2 = nVar2 == null ? 0.0f : nVar2.h(this);
        SVG.n nVar3 = oVar.q;
        float g3 = nVar3 == null ? 0.0f : nVar3.g(this);
        SVG.n nVar4 = oVar.r;
        float h3 = nVar4 != null ? nVar4.h(this) : 0.0f;
        if (oVar.f2511h == null) {
            oVar.f2511h = new SVG.a(Math.min(g2, h2), Math.min(h2, h3), Math.abs(g3 - g2), Math.abs(h3 - h2));
        }
        Path path = new Path();
        path.moveTo(g2, h2);
        path.lineTo(g3, h3);
        return path;
    }

    private Path j0(SVG.x xVar) {
        Path path = new Path();
        float[] fArr = xVar.o;
        path.moveTo(fArr[0], fArr[1]);
        int i2 = 2;
        while (true) {
            float[] fArr2 = xVar.o;
            if (i2 >= fArr2.length) {
                break;
            }
            path.lineTo(fArr2[i2], fArr2[i2 + 1]);
            i2 += 2;
        }
        if (xVar instanceof SVG.y) {
            path.close();
        }
        if (xVar.f2511h == null) {
            xVar.f2511h = u(path);
        }
        path.setFillType(X());
        return path;
    }

    private Path k0(SVG.z zVar) {
        float g2;
        float h2;
        Path path;
        SVG.n nVar = zVar.s;
        if (nVar == null && zVar.t == null) {
            g2 = 0.0f;
            h2 = 0.0f;
        } else {
            if (nVar == null) {
                g2 = zVar.t.h(this);
            } else if (zVar.t == null) {
                g2 = nVar.g(this);
            } else {
                g2 = nVar.g(this);
                h2 = zVar.t.h(this);
            }
            h2 = g2;
        }
        float min = Math.min(g2, zVar.q.g(this) / 2.0f);
        float min2 = Math.min(h2, zVar.r.h(this) / 2.0f);
        SVG.n nVar2 = zVar.o;
        float g3 = nVar2 != null ? nVar2.g(this) : 0.0f;
        SVG.n nVar3 = zVar.p;
        float h3 = nVar3 != null ? nVar3.h(this) : 0.0f;
        float g4 = zVar.q.g(this);
        float h4 = zVar.r.h(this);
        if (zVar.f2511h == null) {
            zVar.f2511h = new SVG.a(g3, h3, g4, h4);
        }
        float f2 = g3 + g4;
        float f3 = h3 + h4;
        Path path2 = new Path();
        if (min != 0.0f && min2 != 0.0f) {
            float f4 = min * f9968m;
            float f5 = f9968m * min2;
            float f6 = h3 + min2;
            path2.moveTo(g3, f6);
            float f7 = f6 - f5;
            float f8 = g3 + min;
            float f9 = f8 - f4;
            path2.cubicTo(g3, f7, f9, h3, f8, h3);
            float f10 = f2 - min;
            path2.lineTo(f10, h3);
            float f11 = f10 + f4;
            path2.cubicTo(f11, h3, f2, f7, f2, f6);
            float f12 = f3 - min2;
            path2.lineTo(f2, f12);
            float f13 = f12 + f5;
            path = path2;
            path2.cubicTo(f2, f13, f11, f3, f10, f3);
            path.lineTo(f8, f3);
            path.cubicTo(f9, f3, g3, f13, g3, f12);
            path.lineTo(g3, f6);
        } else {
            path = path2;
            path.moveTo(g3, h3);
            path.lineTo(f2, h3);
            path.lineTo(f2, f3);
            path.lineTo(g3, f3);
            path.lineTo(g3, h3);
        }
        path.close();
        return path;
    }

    private void l(SVG.j jVar, Path path, Matrix matrix) {
        Path j0;
        a1(this.f9972f, jVar);
        if (I() && c1()) {
            Matrix matrix2 = jVar.n;
            if (matrix2 != null) {
                matrix.preConcat(matrix2);
            }
            if (jVar instanceof SVG.z) {
                j0 = k0((SVG.z) jVar);
            } else if (jVar instanceof SVG.c) {
                j0 = g0((SVG.c) jVar);
            } else if (jVar instanceof SVG.h) {
                j0 = h0((SVG.h) jVar);
            } else if (!(jVar instanceof SVG.x)) {
                return;
            } else {
                j0 = j0((SVG.x) jVar);
            }
            x(jVar);
            path.setFillType(j0.getFillType());
            path.addPath(j0, matrix);
        }
    }

    private void l0(boolean z, SVG.a aVar, SVG.n0 n0Var) {
        float f2;
        float f3;
        float f4;
        String str = n0Var.f2516l;
        if (str != null) {
            P(n0Var, str);
        }
        Boolean bool = n0Var.f2513i;
        int i2 = 0;
        boolean z2 = bool != null && bool.booleanValue();
        g gVar = this.f9972f;
        Paint paint = z ? gVar.f9998d : gVar.f9999e;
        if (z2) {
            SVG.n nVar = new SVG.n(50.0f, SVG.Unit.percent);
            SVG.n nVar2 = n0Var.f2524m;
            float g2 = nVar2 != null ? nVar2.g(this) : nVar.g(this);
            SVG.n nVar3 = n0Var.n;
            float h2 = nVar3 != null ? nVar3.h(this) : nVar.h(this);
            SVG.n nVar4 = n0Var.o;
            f3 = nVar4 != null ? nVar4.e(this) : nVar.e(this);
            f2 = g2;
            f4 = h2;
        } else {
            SVG.n nVar5 = n0Var.f2524m;
            float f5 = nVar5 != null ? nVar5.f(this, 1.0f) : 0.5f;
            SVG.n nVar6 = n0Var.n;
            float f6 = nVar6 != null ? nVar6.f(this, 1.0f) : 0.5f;
            SVG.n nVar7 = n0Var.o;
            f2 = f5;
            f3 = nVar7 != null ? nVar7.f(this, 1.0f) : 0.5f;
            f4 = f6;
        }
        W0();
        this.f9972f = U(n0Var);
        Matrix matrix = new Matrix();
        if (!z2) {
            matrix.preTranslate(aVar.a, aVar.b);
            matrix.preScale(aVar.f2494c, aVar.f2495d);
        }
        Matrix matrix2 = n0Var.f2514j;
        if (matrix2 != null) {
            matrix.preConcat(matrix2);
        }
        int size = n0Var.f2512h.size();
        if (size == 0) {
            V0();
            if (z) {
                this.f9972f.b = false;
                return;
            } else {
                this.f9972f.f9997c = false;
                return;
            }
        }
        int[] iArr = new int[size];
        float[] fArr = new float[size];
        float f7 = -1.0f;
        Iterator<SVG.k0> it = n0Var.f2512h.iterator();
        while (it.hasNext()) {
            SVG.b0 b0Var = (SVG.b0) it.next();
            if (i2 != 0 && b0Var.f2500h.floatValue() < f7) {
                fArr[i2] = f7;
            } else {
                fArr[i2] = b0Var.f2500h.floatValue();
                f7 = b0Var.f2500h.floatValue();
            }
            W0();
            a1(this.f9972f, b0Var);
            SVG.Style style = this.f9972f.a;
            SVG.e eVar = (SVG.e) style.C;
            if (eVar == null) {
                eVar = SVG.e.b;
            }
            iArr[i2] = (D(style.D.floatValue()) << 24) | eVar.a;
            i2++;
            V0();
        }
        if (f3 != 0.0f && size != 1) {
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            SVG.GradientSpread gradientSpread = n0Var.f2515k;
            if (gradientSpread != null) {
                if (gradientSpread == SVG.GradientSpread.reflect) {
                    tileMode = Shader.TileMode.MIRROR;
                } else if (gradientSpread == SVG.GradientSpread.repeat) {
                    tileMode = Shader.TileMode.REPEAT;
                }
            }
            V0();
            RadialGradient radialGradient = new RadialGradient(f2, f4, f3, iArr, fArr, tileMode);
            radialGradient.setLocalMatrix(matrix);
            paint.setShader(radialGradient);
            return;
        }
        V0();
        paint.setColor(iArr[size - 1]);
    }

    private void m(SVG.t tVar, Path path, Matrix matrix) {
        a1(this.f9972f, tVar);
        if (I() && c1()) {
            Matrix matrix2 = tVar.n;
            if (matrix2 != null) {
                matrix.preConcat(matrix2);
            }
            Path f2 = new c(tVar.o).f();
            if (tVar.f2511h == null) {
                tVar.f2511h = u(f2);
            }
            x(tVar);
            path.setFillType(X());
            path.addPath(f2, matrix);
        }
    }

    private void m0() {
        this.f9974h.pop();
        this.f9975i.pop();
    }

    private void n(SVG.k0 k0Var, boolean z, Path path, Matrix matrix) {
        if (I()) {
            F();
            if (k0Var instanceof SVG.a1) {
                if (z) {
                    p((SVG.a1) k0Var, path, matrix);
                } else {
                    N("<use> elements inside a <clipPath> cannot reference another <use>", new Object[0]);
                }
            } else if (k0Var instanceof SVG.t) {
                m((SVG.t) k0Var, path, matrix);
            } else if (k0Var instanceof SVG.t0) {
                o((SVG.t0) k0Var, path, matrix);
            } else if (k0Var instanceof SVG.j) {
                l((SVG.j) k0Var, path, matrix);
            } else {
                N("Invalid %s element found in clipPath definition", k0Var.getClass().getSimpleName());
            }
            E();
        }
    }

    private void n0(SVG.g0 g0Var) {
        this.f9974h.push(g0Var);
        this.f9975i.push(this.a.getMatrix());
    }

    private void o(SVG.t0 t0Var, Path path, Matrix matrix) {
        a1(this.f9972f, t0Var);
        if (I()) {
            Matrix matrix2 = t0Var.s;
            if (matrix2 != null) {
                matrix.preConcat(matrix2);
            }
            List<SVG.n> list = t0Var.o;
            float f2 = 0.0f;
            float g2 = (list == null || list.size() == 0) ? 0.0f : t0Var.o.get(0).g(this);
            List<SVG.n> list2 = t0Var.p;
            float h2 = (list2 == null || list2.size() == 0) ? 0.0f : t0Var.p.get(0).h(this);
            List<SVG.n> list3 = t0Var.q;
            float g3 = (list3 == null || list3.size() == 0) ? 0.0f : t0Var.q.get(0).g(this);
            List<SVG.n> list4 = t0Var.r;
            if (list4 != null && list4.size() != 0) {
                f2 = t0Var.r.get(0).h(this);
            }
            if (this.f9972f.a.u != SVG.Style.TextAnchor.Start) {
                float v2 = v(t0Var);
                if (this.f9972f.a.u == SVG.Style.TextAnchor.Middle) {
                    v2 /= 2.0f;
                }
                g2 -= v2;
            }
            if (t0Var.f2511h == null) {
                h hVar = new h(g2, h2);
                M(t0Var, hVar);
                RectF rectF = hVar.f10006d;
                t0Var.f2511h = new SVG.a(rectF.left, rectF.top, rectF.width(), hVar.f10006d.height());
            }
            x(t0Var);
            Path path2 = new Path();
            M(t0Var, new f(g2 + g3, h2 + f2, path2));
            path.setFillType(X());
            path.addPath(path2, matrix);
        }
    }

    private void o0(SVG.h0 h0Var) {
        g gVar = this.f9972f;
        String str = gVar.a.G;
        if (str != null && gVar.f10003i) {
            SVG.k0 J = this.f9971e.J(str);
            L();
            N0((SVG.q) J, h0Var);
            Bitmap p0 = p0();
            Canvas pop = this.f9976j.pop();
            this.a = pop;
            pop.save();
            this.a.setMatrix(new Matrix());
            this.a.drawBitmap(p0, 0.0f, 0.0f, this.f9972f.f9998d);
            p0.recycle();
            this.a.restore();
        }
        V0();
    }

    private void p(SVG.a1 a1Var, Path path, Matrix matrix) {
        a1(this.f9972f, a1Var);
        if (I() && c1()) {
            Matrix matrix2 = a1Var.o;
            if (matrix2 != null) {
                matrix.preConcat(matrix2);
            }
            SVG.k0 J = a1Var.a.J(a1Var.p);
            if (J == null) {
                N("Use reference '%s' not found", a1Var.p);
                return;
            }
            x(a1Var);
            n(J, false, path, matrix);
        }
    }

    private Bitmap p0() {
        Bitmap pop = this.f9977k.pop();
        Bitmap pop2 = this.f9977k.pop();
        int width = pop.getWidth();
        int height = pop.getHeight();
        int[] iArr = new int[width];
        int[] iArr2 = new int[width];
        int i2 = 0;
        while (i2 < height) {
            pop.getPixels(iArr, 0, width, 0, i2, width, 1);
            int i3 = i2;
            pop2.getPixels(iArr2, 0, width, 0, i2, width, 1);
            for (int i4 = 0; i4 < width; i4++) {
                int i5 = iArr[i4];
                int i6 = i5 & 255;
                int i7 = (i5 >> 8) & 255;
                int i8 = (i5 >> 16) & 255;
                int i9 = (i5 >> 24) & 255;
                if (i9 == 0) {
                    iArr2[i4] = 0;
                } else {
                    int i10 = iArr2[i4];
                    iArr2[i4] = (i10 & 16777215) | (((((i10 >> 24) & 255) * (((((i8 * o) + (i7 * p)) + (i6 * q)) * i9) / 8355840)) / 255) << 24);
                }
            }
            pop2.setPixels(iArr2, 0, width, 0, i3, width, 1);
            i2 = i3 + 1;
        }
        pop.recycle();
        return pop2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void q(float f2, float f3, float f4, float f5, float f6, boolean z, boolean z2, float f7, float f8, SVG.v vVar) {
        double d2;
        if (f2 == f7 && f3 == f8) {
            return;
        }
        if (f4 != 0.0f && f5 != 0.0f) {
            float abs = Math.abs(f4);
            float abs2 = Math.abs(f5);
            double radians = (float) Math.toRadians(f6 % 360.0d);
            double cos = Math.cos(radians);
            double sin = Math.sin(radians);
            double d3 = (f2 - f7) / 2.0d;
            double d4 = (f3 - f8) / 2.0d;
            double d5 = (cos * d3) + (sin * d4);
            double d6 = ((-sin) * d3) + (d4 * cos);
            double d7 = abs * abs;
            double d8 = abs2 * abs2;
            double d9 = d5 * d5;
            double d10 = d6 * d6;
            double d11 = (d9 / d7) + (d10 / d8);
            if (d11 > 1.0d) {
                abs *= (float) Math.sqrt(d11);
                abs2 *= (float) Math.sqrt(d11);
                d7 = abs * abs;
                d8 = abs2 * abs2;
            }
            double d12 = z == z2 ? -1 : 1;
            double d13 = d7 * d8;
            double d14 = d7 * d10;
            double d15 = d8 * d9;
            double d16 = ((d13 - d14) - d15) / (d14 + d15);
            if (d16 < 0.0d) {
                d16 = 0.0d;
            }
            double sqrt = d12 * Math.sqrt(d16);
            double d17 = abs;
            double d18 = abs2;
            double d19 = ((d17 * d6) / d18) * sqrt;
            float f9 = abs;
            float f10 = abs2;
            double d20 = sqrt * (-((d18 * d5) / d17));
            double d21 = ((f2 + f7) / 2.0d) + ((cos * d19) - (sin * d20));
            double d22 = ((f3 + f8) / 2.0d) + (sin * d19) + (cos * d20);
            double d23 = (d5 - d19) / d17;
            double d24 = (d6 - d20) / d18;
            double d25 = ((-d5) - d19) / d17;
            double d26 = ((-d6) - d20) / d18;
            double d27 = (d23 * d23) + (d24 * d24);
            double degrees = Math.toDegrees((d24 < 0.0d ? -1.0d : 1.0d) * Math.acos(d23 / Math.sqrt(d27)));
            double degrees2 = Math.toDegrees(((d23 * d26) - (d24 * d25) < 0.0d ? -1.0d : 1.0d) * Math.acos(((d23 * d25) + (d24 * d26)) / Math.sqrt(d27 * ((d25 * d25) + (d26 * d26)))));
            if (z2 || degrees2 <= 0.0d) {
                d2 = 360.0d;
                if (z2 && degrees2 < 0.0d) {
                    degrees2 += 360.0d;
                }
            } else {
                d2 = 360.0d;
                degrees2 -= 360.0d;
            }
            float[] r2 = r(degrees % d2, degrees2 % d2);
            Matrix matrix = new Matrix();
            matrix.postScale(f9, f10);
            matrix.postRotate(f6);
            matrix.postTranslate((float) d21, (float) d22);
            matrix.mapPoints(r2);
            r2[r2.length - 2] = f7;
            r2[r2.length - 1] = f8;
            for (int i2 = 0; i2 < r2.length; i2 += 6) {
                vVar.c(r2[i2], r2[i2 + 1], r2[i2 + 2], r2[i2 + 3], r2[i2 + 4], r2[i2 + 5]);
            }
            return;
        }
        vVar.e(f7, f8);
    }

    private void q0(SVG.k0 k0Var, i iVar) {
        float f2;
        float f3;
        float f4;
        if (iVar.a((SVG.v0) k0Var)) {
            if (k0Var instanceof SVG.w0) {
                W0();
                P0((SVG.w0) k0Var);
                V0();
            } else if (k0Var instanceof SVG.s0) {
                G("TSpan render", new Object[0]);
                W0();
                SVG.s0 s0Var = (SVG.s0) k0Var;
                a1(this.f9972f, s0Var);
                if (I()) {
                    boolean z = iVar instanceof e;
                    float f5 = 0.0f;
                    if (z) {
                        List<SVG.n> list = s0Var.o;
                        float g2 = (list == null || list.size() == 0) ? ((e) iVar).b : s0Var.o.get(0).g(this);
                        List<SVG.n> list2 = s0Var.p;
                        f3 = (list2 == null || list2.size() == 0) ? ((e) iVar).f9992c : s0Var.p.get(0).h(this);
                        List<SVG.n> list3 = s0Var.q;
                        f4 = (list3 == null || list3.size() == 0) ? 0.0f : s0Var.q.get(0).g(this);
                        List<SVG.n> list4 = s0Var.r;
                        if (list4 != null && list4.size() != 0) {
                            f5 = s0Var.r.get(0).h(this);
                        }
                        f2 = f5;
                        f5 = g2;
                    } else {
                        f2 = 0.0f;
                        f3 = 0.0f;
                        f4 = 0.0f;
                    }
                    z((SVG.h0) s0Var.e());
                    if (z) {
                        e eVar = (e) iVar;
                        eVar.b = f5 + f4;
                        eVar.f9992c = f3 + f2;
                    }
                    boolean r0 = r0();
                    M(s0Var, iVar);
                    if (r0) {
                        o0(s0Var);
                    }
                }
                V0();
            } else if (k0Var instanceof SVG.r0) {
                W0();
                SVG.r0 r0Var = (SVG.r0) k0Var;
                a1(this.f9972f, r0Var);
                if (I()) {
                    z((SVG.h0) r0Var.e());
                    SVG.k0 J = k0Var.a.J(r0Var.o);
                    if (J == null || !(J instanceof SVG.v0)) {
                        N("Tref reference '%s' not found", r0Var.o);
                    } else {
                        StringBuilder sb = new StringBuilder();
                        O((SVG.v0) J, sb);
                        if (sb.length() > 0) {
                            iVar.b(sb.toString());
                        }
                    }
                }
                V0();
            }
        }
    }

    private static float[] r(double d2, double d3) {
        float radians;
        int ceil = (int) Math.ceil(Math.abs(d3) / 90.0d);
        double radians2 = Math.toRadians(d2);
        double radians3 = (float) (Math.toRadians(d3) / ceil);
        double d4 = radians3 / 2.0d;
        double sin = (Math.sin(d4) * 1.3333333333333333d) / (Math.cos(d4) + 1.0d);
        float[] fArr = new float[ceil * 6];
        int i2 = 0;
        int i3 = 0;
        while (i2 < ceil) {
            double d5 = (i2 * radians) + radians2;
            double cos = Math.cos(d5);
            double sin2 = Math.sin(d5);
            int i4 = i3 + 1;
            int i5 = ceil;
            double d6 = radians2;
            fArr[i3] = (float) (cos - (sin * sin2));
            int i6 = i4 + 1;
            fArr[i4] = (float) (sin2 + (cos * sin));
            double d7 = d5 + radians3;
            double cos2 = Math.cos(d7);
            double sin3 = Math.sin(d7);
            int i7 = i6 + 1;
            fArr[i6] = (float) ((sin * sin3) + cos2);
            int i8 = i7 + 1;
            fArr[i7] = (float) (sin3 - (sin * cos2));
            int i9 = i8 + 1;
            fArr[i8] = (float) cos2;
            fArr[i9] = (float) sin3;
            i2++;
            radians2 = d6;
            i3 = i9 + 1;
            ceil = i5;
        }
        return fArr;
    }

    private boolean r0() {
        if (Q0()) {
            this.a.saveLayerAlpha(null, D(this.f9972f.a.f2493m.floatValue()), 4);
            this.f9973g.push(this.f9972f);
            g gVar = (g) this.f9972f.clone();
            this.f9972f = gVar;
            String str = gVar.a.G;
            if (str != null && gVar.f10003i) {
                SVG.k0 J = this.f9971e.J(str);
                if (J != null && (J instanceof SVG.q)) {
                    this.f9976j.push(this.a);
                    L();
                } else {
                    N("Mask reference '%s' not found", this.f9972f.a.G);
                    this.f9972f.a.G = null;
                }
            }
            return true;
        }
        return false;
    }

    private List<C0330b> s(SVG.o oVar) {
        SVG.n nVar = oVar.o;
        float g2 = nVar != null ? nVar.g(this) : 0.0f;
        SVG.n nVar2 = oVar.p;
        float h2 = nVar2 != null ? nVar2.h(this) : 0.0f;
        SVG.n nVar3 = oVar.q;
        float g3 = nVar3 != null ? nVar3.g(this) : 0.0f;
        SVG.n nVar4 = oVar.r;
        float h3 = nVar4 != null ? nVar4.h(this) : 0.0f;
        ArrayList arrayList = new ArrayList(2);
        float f2 = g3 - g2;
        float f3 = h3 - h2;
        arrayList.add(new C0330b(g2, h2, f2, f3));
        arrayList.add(new C0330b(g3, h3, f2, f3));
        return arrayList;
    }

    private void s0(SVG.c cVar) {
        G("Circle render", new Object[0]);
        SVG.n nVar = cVar.q;
        if (nVar == null || nVar.k()) {
            return;
        }
        a1(this.f9972f, cVar);
        if (I() && c1()) {
            Matrix matrix = cVar.n;
            if (matrix != null) {
                this.a.concat(matrix);
            }
            Path g0 = g0(cVar);
            Y0(cVar);
            z(cVar);
            x(cVar);
            boolean r0 = r0();
            if (this.f9972f.b) {
                J(cVar, g0);
            }
            if (this.f9972f.f9997c) {
                K(g0);
            }
            if (r0) {
                o0(cVar);
            }
        }
    }

    private List<C0330b> t(SVG.x xVar) {
        int length = xVar.o.length;
        int i2 = 2;
        if (length < 2) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        float[] fArr = xVar.o;
        C0330b c0330b = new C0330b(fArr[0], fArr[1], 0.0f, 0.0f);
        float f2 = 0.0f;
        float f3 = 0.0f;
        while (i2 < length) {
            float[] fArr2 = xVar.o;
            float f4 = fArr2[i2];
            float f5 = fArr2[i2 + 1];
            c0330b.a(f4, f5);
            arrayList.add(c0330b);
            i2 += 2;
            c0330b = new C0330b(f4, f5, f4 - c0330b.a, f5 - c0330b.b);
            f3 = f5;
            f2 = f4;
        }
        if (xVar instanceof SVG.y) {
            float[] fArr3 = xVar.o;
            if (f2 != fArr3[0] && f3 != fArr3[1]) {
                float f6 = fArr3[0];
                float f7 = fArr3[1];
                c0330b.a(f6, f7);
                arrayList.add(c0330b);
                C0330b c0330b2 = new C0330b(f6, f7, f6 - c0330b.a, f7 - c0330b.b);
                c0330b2.b((C0330b) arrayList.get(0));
                arrayList.add(c0330b2);
                arrayList.set(0, c0330b2);
            }
        } else {
            arrayList.add(c0330b);
        }
        return arrayList;
    }

    private void t0(SVG.h hVar) {
        G("Ellipse render", new Object[0]);
        SVG.n nVar = hVar.q;
        if (nVar == null || hVar.r == null || nVar.k() || hVar.r.k()) {
            return;
        }
        a1(this.f9972f, hVar);
        if (I() && c1()) {
            Matrix matrix = hVar.n;
            if (matrix != null) {
                this.a.concat(matrix);
            }
            Path h0 = h0(hVar);
            Y0(hVar);
            z(hVar);
            x(hVar);
            boolean r0 = r0();
            if (this.f9972f.b) {
                J(hVar, h0);
            }
            if (this.f9972f.f9997c) {
                K(h0);
            }
            if (r0) {
                o0(hVar);
            }
        }
    }

    private SVG.a u(Path path) {
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        return new SVG.a(rectF.left, rectF.top, rectF.width(), rectF.height());
    }

    private void u0(SVG.k kVar) {
        G("Group render", new Object[0]);
        a1(this.f9972f, kVar);
        if (I()) {
            Matrix matrix = kVar.o;
            if (matrix != null) {
                this.a.concat(matrix);
            }
            x(kVar);
            boolean r0 = r0();
            J0(kVar, true);
            if (r0) {
                o0(kVar);
            }
            Y0(kVar);
        }
    }

    private float v(SVG.v0 v0Var) {
        j jVar = new j(this, null);
        M(v0Var, jVar);
        return jVar.b;
    }

    private void v0(SVG.m mVar) {
        SVG.n nVar;
        String str;
        G("Image render", new Object[0]);
        SVG.n nVar2 = mVar.s;
        if (nVar2 == null || nVar2.k() || (nVar = mVar.t) == null || nVar.k() || (str = mVar.p) == null) {
            return;
        }
        PreserveAspectRatio preserveAspectRatio = mVar.o;
        if (preserveAspectRatio == null) {
            preserveAspectRatio = PreserveAspectRatio.f2465e;
        }
        Bitmap A = A(str);
        if (A == null) {
            e.d.a.c q2 = this.f9971e.q();
            if (q2 == null) {
                return;
            }
            A = q2.c(mVar.p);
        }
        if (A == null) {
            N("Could not locate image '%s'", mVar.p);
            return;
        }
        a1(this.f9972f, mVar);
        if (I() && c1()) {
            Matrix matrix = mVar.u;
            if (matrix != null) {
                this.a.concat(matrix);
            }
            SVG.n nVar3 = mVar.q;
            float g2 = nVar3 != null ? nVar3.g(this) : 0.0f;
            SVG.n nVar4 = mVar.r;
            this.f9972f.f10000f = new SVG.a(g2, nVar4 != null ? nVar4.h(this) : 0.0f, mVar.s.g(this), mVar.t.g(this));
            if (!this.f9972f.a.v.booleanValue()) {
                SVG.a aVar = this.f9972f.f10000f;
                S0(aVar.a, aVar.b, aVar.f2494c, aVar.f2495d);
            }
            SVG.a aVar2 = new SVG.a(0.0f, 0.0f, A.getWidth(), A.getHeight());
            mVar.f2511h = aVar2;
            this.a.concat(w(this.f9972f.f10000f, aVar2, preserveAspectRatio));
            Y0(mVar);
            x(mVar);
            boolean r0 = r0();
            b1();
            this.a.drawBitmap(A, 0.0f, 0.0f, this.f9972f.f9998d);
            if (r0) {
                o0(mVar);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x006e, code lost:
        if (r6 != 10) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0095 A[PHI: r4 
      PHI: (r4v2 float) = (r4v1 float), (r4v3 float) binds: [B:32:0x0088, B:36:0x0094] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.graphics.Matrix w(com.caverock.androidsvg.SVG.a r10, com.caverock.androidsvg.SVG.a r11, com.caverock.androidsvg.PreserveAspectRatio r12) {
        /*
            r9 = this;
            android.graphics.Matrix r0 = new android.graphics.Matrix
            r0.<init>()
            if (r12 == 0) goto La2
            com.caverock.androidsvg.PreserveAspectRatio$Alignment r1 = r12.a()
            if (r1 != 0) goto Lf
            goto La2
        Lf:
            float r1 = r10.f2494c
            float r2 = r11.f2494c
            float r1 = r1 / r2
            float r2 = r10.f2495d
            float r3 = r11.f2495d
            float r2 = r2 / r3
            float r3 = r11.a
            float r3 = -r3
            float r4 = r11.b
            float r4 = -r4
            com.caverock.androidsvg.PreserveAspectRatio r5 = com.caverock.androidsvg.PreserveAspectRatio.f2464d
            boolean r5 = r12.equals(r5)
            if (r5 == 0) goto L35
            float r11 = r10.a
            float r10 = r10.b
            r0.preTranslate(r11, r10)
            r0.preScale(r1, r2)
            r0.preTranslate(r3, r4)
            return r0
        L35:
            com.caverock.androidsvg.PreserveAspectRatio$Scale r5 = r12.b()
            com.caverock.androidsvg.PreserveAspectRatio$Scale r6 = com.caverock.androidsvg.PreserveAspectRatio.Scale.Slice
            if (r5 != r6) goto L42
            float r1 = java.lang.Math.max(r1, r2)
            goto L46
        L42:
            float r1 = java.lang.Math.min(r1, r2)
        L46:
            float r2 = r10.f2494c
            float r2 = r2 / r1
            float r5 = r10.f2495d
            float r5 = r5 / r1
            int[] r6 = a()
            com.caverock.androidsvg.PreserveAspectRatio$Alignment r7 = r12.a()
            int r7 = r7.ordinal()
            r6 = r6[r7]
            r7 = 3
            r8 = 1073741824(0x40000000, float:2.0)
            if (r6 == r7) goto L75
            r7 = 4
            if (r6 == r7) goto L71
            r7 = 6
            if (r6 == r7) goto L75
            r7 = 7
            if (r6 == r7) goto L71
            r7 = 9
            if (r6 == r7) goto L75
            r7 = 10
            if (r6 == r7) goto L71
            goto L7a
        L71:
            float r6 = r11.f2494c
            float r6 = r6 - r2
            goto L79
        L75:
            float r6 = r11.f2494c
            float r6 = r6 - r2
            float r6 = r6 / r8
        L79:
            float r3 = r3 - r6
        L7a:
            int[] r2 = a()
            com.caverock.androidsvg.PreserveAspectRatio$Alignment r12 = r12.a()
            int r12 = r12.ordinal()
            r12 = r2[r12]
            switch(r12) {
                case 5: goto L90;
                case 6: goto L90;
                case 7: goto L90;
                case 8: goto L8c;
                case 9: goto L8c;
                case 10: goto L8c;
                default: goto L8b;
            }
        L8b:
            goto L95
        L8c:
            float r11 = r11.f2495d
            float r11 = r11 - r5
            goto L94
        L90:
            float r11 = r11.f2495d
            float r11 = r11 - r5
            float r11 = r11 / r8
        L94:
            float r4 = r4 - r11
        L95:
            float r11 = r10.a
            float r10 = r10.b
            r0.preTranslate(r11, r10)
            r0.preScale(r1, r1)
            r0.preTranslate(r3, r4)
        La2:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.d.a.b.w(com.caverock.androidsvg.SVG$a, com.caverock.androidsvg.SVG$a, com.caverock.androidsvg.PreserveAspectRatio):android.graphics.Matrix");
    }

    private void w0(SVG.o oVar) {
        G("Line render", new Object[0]);
        a1(this.f9972f, oVar);
        if (I() && c1() && this.f9972f.f9997c) {
            Matrix matrix = oVar.n;
            if (matrix != null) {
                this.a.concat(matrix);
            }
            Path i0 = i0(oVar);
            Y0(oVar);
            z(oVar);
            x(oVar);
            boolean r0 = r0();
            K(i0);
            M0(oVar);
            if (r0) {
                o0(oVar);
            }
        }
    }

    private void x(SVG.h0 h0Var) {
        y(h0Var, h0Var.f2511h);
    }

    private void x0(SVG.t tVar) {
        G("Path render", new Object[0]);
        a1(this.f9972f, tVar);
        if (I() && c1()) {
            g gVar = this.f9972f;
            if (gVar.f9997c || gVar.b) {
                Matrix matrix = tVar.n;
                if (matrix != null) {
                    this.a.concat(matrix);
                }
                Path f2 = new c(tVar.o).f();
                if (tVar.f2511h == null) {
                    tVar.f2511h = u(f2);
                }
                Y0(tVar);
                z(tVar);
                x(tVar);
                boolean r0 = r0();
                if (this.f9972f.b) {
                    f2.setFillType(c0());
                    J(tVar, f2);
                }
                if (this.f9972f.f9997c) {
                    K(f2);
                }
                M0(tVar);
                if (r0) {
                    o0(tVar);
                }
            }
        }
    }

    private void y(SVG.h0 h0Var, SVG.a aVar) {
        String str = this.f9972f.a.E;
        if (str == null) {
            return;
        }
        SVG.k0 J = h0Var.a.J(str);
        if (J == null) {
            N("ClipPath reference '%s' not found", this.f9972f.a.E);
            return;
        }
        SVG.d dVar = (SVG.d) J;
        if (dVar.f2501i.isEmpty()) {
            this.a.clipRect(0, 0, 0, 0);
            return;
        }
        Boolean bool = dVar.p;
        boolean z = bool == null || bool.booleanValue();
        if ((h0Var instanceof SVG.k) && !z) {
            d1("<clipPath clipPathUnits=\"objectBoundingBox\"> is not supported when referenced from container elements (like %s)", h0Var.getClass().getSimpleName());
            return;
        }
        F();
        if (!z) {
            Matrix matrix = new Matrix();
            matrix.preTranslate(aVar.a, aVar.b);
            matrix.preScale(aVar.f2494c, aVar.f2495d);
            this.a.concat(matrix);
        }
        Matrix matrix2 = dVar.o;
        if (matrix2 != null) {
            this.a.concat(matrix2);
        }
        this.f9972f = U(dVar);
        x(dVar);
        Path path = new Path();
        for (SVG.k0 k0Var : dVar.f2501i) {
            n(k0Var, true, path, new Matrix());
        }
        this.a.clipPath(path);
        E();
    }

    private void y0(SVG.x xVar) {
        G("PolyLine render", new Object[0]);
        a1(this.f9972f, xVar);
        if (I() && c1()) {
            g gVar = this.f9972f;
            if (gVar.f9997c || gVar.b) {
                Matrix matrix = xVar.n;
                if (matrix != null) {
                    this.a.concat(matrix);
                }
                if (xVar.o.length < 2) {
                    return;
                }
                Path j0 = j0(xVar);
                Y0(xVar);
                z(xVar);
                x(xVar);
                boolean r0 = r0();
                if (this.f9972f.b) {
                    J(xVar, j0);
                }
                if (this.f9972f.f9997c) {
                    K(j0);
                }
                M0(xVar);
                if (r0) {
                    o0(xVar);
                }
            }
        }
    }

    private void z(SVG.h0 h0Var) {
        SVG.l0 l0Var = this.f9972f.a.b;
        if (l0Var instanceof SVG.s) {
            H(true, h0Var.f2511h, (SVG.s) l0Var);
        }
        SVG.l0 l0Var2 = this.f9972f.a.f2485e;
        if (l0Var2 instanceof SVG.s) {
            H(false, h0Var.f2511h, (SVG.s) l0Var2);
        }
    }

    private void z0(SVG.y yVar) {
        G("Polygon render", new Object[0]);
        a1(this.f9972f, yVar);
        if (I() && c1()) {
            g gVar = this.f9972f;
            if (gVar.f9997c || gVar.b) {
                Matrix matrix = yVar.n;
                if (matrix != null) {
                    this.a.concat(matrix);
                }
                if (yVar.o.length < 2) {
                    return;
                }
                Path j0 = j0(yVar);
                Y0(yVar);
                z(yVar);
                x(yVar);
                boolean r0 = r0();
                if (this.f9972f.b) {
                    J(yVar, j0);
                }
                if (this.f9972f.f9997c) {
                    K(j0);
                }
                M0(yVar);
                if (r0) {
                    o0(yVar);
                }
            }
        }
    }

    public void K0(SVG svg, SVG.a aVar, PreserveAspectRatio preserveAspectRatio, boolean z) {
        this.f9971e = svg;
        this.f9970d = z;
        SVG.c0 x = svg.x();
        if (x == null) {
            d1("Nothing to render. Document is empty.", new Object[0]);
            return;
        }
        R0();
        C(x);
        SVG.n nVar = x.s;
        SVG.n nVar2 = x.t;
        if (aVar == null) {
            aVar = x.p;
        }
        SVG.a aVar2 = aVar;
        if (preserveAspectRatio == null) {
            preserveAspectRatio = x.o;
        }
        D0(x, nVar, nVar2, aVar2, preserveAspectRatio);
    }

    public float Y() {
        return this.f9972f.f9998d.getTextSize();
    }

    public float Z() {
        return this.f9972f.f9998d.getTextSize() / 2.0f;
    }

    public SVG.a a0() {
        g gVar = this.f9972f;
        SVG.a aVar = gVar.f10001g;
        return aVar != null ? aVar : gVar.f10000f;
    }

    public float b0() {
        return this.f9969c;
    }

    /* loaded from: classes.dex */
    public class j extends i {
        public float b;

        private j() {
            super(b.this, null);
            this.b = 0.0f;
        }

        @Override // e.d.a.b.i
        public void b(String str) {
            this.b += b.this.f9972f.f9998d.measureText(str);
        }

        public /* synthetic */ j(b bVar, j jVar) {
            this();
        }
    }
}
