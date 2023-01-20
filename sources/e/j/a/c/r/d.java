package e.j.a.c.r;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import e.j.a.c.z.o;
import e.j.a.c.z.s;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class d {
    public static final long G = 100;
    public static final long H = 100;
    public static final int I = 0;
    public static final int J = 1;
    public static final int K = 2;
    public static final float L = 1.5f;
    private static final float M = 0.0f;
    private static final float N = 0.0f;
    private static final float O = 0.0f;
    private static final float P = 1.0f;
    private static final float Q = 1.0f;
    private static final float R = 1.0f;
    @Nullable
    private ViewTreeObserver.OnPreDrawListener E;
    @Nullable
    public o a;
    @Nullable
    public e.j.a.c.z.j b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public Drawable f10944c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public e.j.a.c.r.c f10945d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public Drawable f10946e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f10947f;

    /* renamed from: h  reason: collision with root package name */
    public float f10949h;

    /* renamed from: i  reason: collision with root package name */
    public float f10950i;

    /* renamed from: j  reason: collision with root package name */
    public float f10951j;

    /* renamed from: k  reason: collision with root package name */
    public int f10952k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    private final e.j.a.c.s.i f10953l;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private e.j.a.c.a.h f10954m;
    @Nullable
    private e.j.a.c.a.h n;
    @Nullable
    private Animator o;
    @Nullable
    private e.j.a.c.a.h p;
    @Nullable
    private e.j.a.c.a.h q;
    private float r;
    private int t;
    private ArrayList<Animator.AnimatorListener> v;
    private ArrayList<Animator.AnimatorListener> w;
    private ArrayList<i> x;
    public final FloatingActionButton y;
    public final e.j.a.c.y.c z;
    public static final TimeInterpolator F = e.j.a.c.a.a.f10551c;
    public static final int[] S = {16842919, 16842910};
    public static final int[] T = {16843623, 16842908, 16842910};
    public static final int[] U = {16842908, 16842910};
    public static final int[] V = {16843623, 16842910};
    public static final int[] W = {16842910};
    public static final int[] X = new int[0];

    /* renamed from: g  reason: collision with root package name */
    public boolean f10948g = true;
    private float s = 1.0f;
    private int u = 0;
    private final Rect A = new Rect();
    private final RectF B = new RectF();
    private final RectF C = new RectF();
    private final Matrix D = new Matrix();

    /* loaded from: classes2.dex */
    public class a extends AnimatorListenerAdapter {
        private boolean a;
        public final /* synthetic */ boolean b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ j f10955c;

        public a(boolean z, j jVar) {
            this.b = z;
            this.f10955c = jVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            d.this.u = 0;
            d.this.o = null;
            if (this.a) {
                return;
            }
            FloatingActionButton floatingActionButton = d.this.y;
            boolean z = this.b;
            floatingActionButton.c(z ? 8 : 4, z);
            j jVar = this.f10955c;
            if (jVar != null) {
                jVar.b();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            d.this.y.c(0, this.b);
            d.this.u = 1;
            d.this.o = animator;
            this.a = false;
        }
    }

    /* loaded from: classes2.dex */
    public class b extends AnimatorListenerAdapter {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ j b;

        public b(boolean z, j jVar) {
            this.a = z;
            this.b = jVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            d.this.u = 0;
            d.this.o = null;
            j jVar = this.b;
            if (jVar != null) {
                jVar.a();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            d.this.y.c(0, this.a);
            d.this.u = 2;
            d.this.o = animator;
        }
    }

    /* loaded from: classes2.dex */
    public class c extends e.j.a.c.a.g {
        public c() {
        }

        @Override // e.j.a.c.a.g, android.animation.TypeEvaluator
        /* renamed from: a */
        public Matrix evaluate(float f2, @NonNull Matrix matrix, @NonNull Matrix matrix2) {
            d.this.s = f2;
            return super.evaluate(f2, matrix, matrix2);
        }
    }

    /* renamed from: e.j.a.c.r.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0369d implements TypeEvaluator<Float> {
        public FloatEvaluator a = new FloatEvaluator();

        public C0369d() {
        }

        @Override // android.animation.TypeEvaluator
        /* renamed from: a */
        public Float evaluate(float f2, Float f3, Float f4) {
            float floatValue = this.a.evaluate(f2, (Number) f3, (Number) f4).floatValue();
            if (floatValue < 0.1f) {
                floatValue = 0.0f;
            }
            return Float.valueOf(floatValue);
        }
    }

    /* loaded from: classes2.dex */
    public class e implements ViewTreeObserver.OnPreDrawListener {
        public e() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            d.this.H();
            return true;
        }
    }

    /* loaded from: classes2.dex */
    public class f extends l {
        public f() {
            super(d.this, null);
        }

        @Override // e.j.a.c.r.d.l
        public float a() {
            return 0.0f;
        }
    }

    /* loaded from: classes2.dex */
    public class g extends l {
        public g() {
            super(d.this, null);
        }

        @Override // e.j.a.c.r.d.l
        public float a() {
            d dVar = d.this;
            return dVar.f10949h + dVar.f10950i;
        }
    }

    /* loaded from: classes2.dex */
    public class h extends l {
        public h() {
            super(d.this, null);
        }

        @Override // e.j.a.c.r.d.l
        public float a() {
            d dVar = d.this;
            return dVar.f10949h + dVar.f10951j;
        }
    }

    /* loaded from: classes2.dex */
    public interface i {
        void a();

        void b();
    }

    /* loaded from: classes2.dex */
    public interface j {
        void a();

        void b();
    }

    /* loaded from: classes2.dex */
    public class k extends l {
        public k() {
            super(d.this, null);
        }

        @Override // e.j.a.c.r.d.l
        public float a() {
            return d.this.f10949h;
        }
    }

    /* loaded from: classes2.dex */
    public abstract class l extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {
        private boolean a;
        private float b;

        /* renamed from: c  reason: collision with root package name */
        private float f10963c;

        private l() {
        }

        public abstract float a();

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            d.this.j0((int) this.f10963c);
            this.a = false;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            if (!this.a) {
                e.j.a.c.z.j jVar = d.this.b;
                this.b = jVar == null ? 0.0f : jVar.x();
                this.f10963c = a();
                this.a = true;
            }
            d dVar = d.this;
            float f2 = this.b;
            dVar.j0((int) (f2 + ((this.f10963c - f2) * valueAnimator.getAnimatedFraction())));
        }

        public /* synthetic */ l(d dVar, a aVar) {
            this();
        }
    }

    public d(FloatingActionButton floatingActionButton, e.j.a.c.y.c cVar) {
        this.y = floatingActionButton;
        this.z = cVar;
        e.j.a.c.s.i iVar = new e.j.a.c.s.i();
        this.f10953l = iVar;
        iVar.a(S, i(new h()));
        iVar.a(T, i(new g()));
        iVar.a(U, i(new g()));
        iVar.a(V, i(new g()));
        iVar.a(W, i(new k()));
        iVar.a(X, i(new f()));
        this.r = floatingActionButton.getRotation();
    }

    private boolean d0() {
        return ViewCompat.isLaidOut(this.y) && !this.y.isInEditMode();
    }

    private void g(float f2, @NonNull Matrix matrix) {
        matrix.reset();
        Drawable drawable = this.y.getDrawable();
        if (drawable == null || this.t == 0) {
            return;
        }
        RectF rectF = this.B;
        RectF rectF2 = this.C;
        rectF.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        int i2 = this.t;
        rectF2.set(0.0f, 0.0f, i2, i2);
        matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
        int i3 = this.t;
        matrix.postScale(f2, f2, i3 / 2.0f, i3 / 2.0f);
    }

    @NonNull
    private AnimatorSet h(@NonNull e.j.a.c.a.h hVar, float f2, float f3, float f4) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.y, View.ALPHA, f2);
        hVar.h("opacity").a(ofFloat);
        arrayList.add(ofFloat);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.y, View.SCALE_X, f3);
        hVar.h("scale").a(ofFloat2);
        k0(ofFloat2);
        arrayList.add(ofFloat2);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.y, View.SCALE_Y, f3);
        hVar.h("scale").a(ofFloat3);
        k0(ofFloat3);
        arrayList.add(ofFloat3);
        g(f4, this.D);
        ObjectAnimator ofObject = ObjectAnimator.ofObject(this.y, new e.j.a.c.a.f(), new c(), new Matrix(this.D));
        hVar.h("iconScale").a(ofObject);
        arrayList.add(ofObject);
        AnimatorSet animatorSet = new AnimatorSet();
        e.j.a.c.a.b.a(animatorSet, arrayList);
        return animatorSet;
    }

    @NonNull
    private ValueAnimator i(@NonNull l lVar) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(F);
        valueAnimator.setDuration(100L);
        valueAnimator.addListener(lVar);
        valueAnimator.addUpdateListener(lVar);
        valueAnimator.setFloatValues(0.0f, 1.0f);
        return valueAnimator;
    }

    private void k0(ObjectAnimator objectAnimator) {
        if (Build.VERSION.SDK_INT != 26) {
            return;
        }
        objectAnimator.setEvaluator(new C0369d());
    }

    private e.j.a.c.a.h l() {
        if (this.n == null) {
            this.n = e.j.a.c.a.h.d(this.y.getContext(), R.animator.design_fab_hide_motion_spec);
        }
        return (e.j.a.c.a.h) Preconditions.checkNotNull(this.n);
    }

    private e.j.a.c.a.h m() {
        if (this.f10954m == null) {
            this.f10954m = e.j.a.c.a.h.d(this.y.getContext(), R.animator.design_fab_show_motion_spec);
        }
        return (e.j.a.c.a.h) Preconditions.checkNotNull(this.f10954m);
    }

    @NonNull
    private ViewTreeObserver.OnPreDrawListener r() {
        if (this.E == null) {
            this.E = new e();
        }
        return this.E;
    }

    public void A() {
        this.f10953l.c();
    }

    public void B() {
        e.j.a.c.z.j jVar = this.b;
        if (jVar != null) {
            e.j.a.c.z.k.f(this.y, jVar);
        }
        if (N()) {
            this.y.getViewTreeObserver().addOnPreDrawListener(r());
        }
    }

    public void C() {
    }

    public void D() {
        ViewTreeObserver viewTreeObserver = this.y.getViewTreeObserver();
        ViewTreeObserver.OnPreDrawListener onPreDrawListener = this.E;
        if (onPreDrawListener != null) {
            viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
            this.E = null;
        }
    }

    public void E(int[] iArr) {
        this.f10953l.d(iArr);
    }

    public void F(float f2, float f3, float f4) {
        i0();
        j0(f2);
    }

    public void G(@NonNull Rect rect) {
        Preconditions.checkNotNull(this.f10946e, "Didn't initialize content background");
        if (c0()) {
            this.z.setBackgroundDrawable(new InsetDrawable(this.f10946e, rect.left, rect.top, rect.right, rect.bottom));
            return;
        }
        this.z.setBackgroundDrawable(this.f10946e);
    }

    public void H() {
        float rotation = this.y.getRotation();
        if (this.r != rotation) {
            this.r = rotation;
            g0();
        }
    }

    public void I() {
        ArrayList<i> arrayList = this.x;
        if (arrayList != null) {
            Iterator<i> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
        }
    }

    public void J() {
        ArrayList<i> arrayList = this.x;
        if (arrayList != null) {
            Iterator<i> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }
    }

    public void K(@NonNull Animator.AnimatorListener animatorListener) {
        ArrayList<Animator.AnimatorListener> arrayList = this.w;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(animatorListener);
    }

    public void L(@NonNull Animator.AnimatorListener animatorListener) {
        ArrayList<Animator.AnimatorListener> arrayList = this.v;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(animatorListener);
    }

    public void M(@NonNull i iVar) {
        ArrayList<i> arrayList = this.x;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(iVar);
    }

    public boolean N() {
        return true;
    }

    public void O(@Nullable ColorStateList colorStateList) {
        e.j.a.c.z.j jVar = this.b;
        if (jVar != null) {
            jVar.setTintList(colorStateList);
        }
        e.j.a.c.r.c cVar = this.f10945d;
        if (cVar != null) {
            cVar.d(colorStateList);
        }
    }

    public void P(@Nullable PorterDuff.Mode mode) {
        e.j.a.c.z.j jVar = this.b;
        if (jVar != null) {
            jVar.setTintMode(mode);
        }
    }

    public final void Q(float f2) {
        if (this.f10949h != f2) {
            this.f10949h = f2;
            F(f2, this.f10950i, this.f10951j);
        }
    }

    public void R(boolean z) {
        this.f10947f = z;
    }

    public final void S(@Nullable e.j.a.c.a.h hVar) {
        this.q = hVar;
    }

    public final void T(float f2) {
        if (this.f10950i != f2) {
            this.f10950i = f2;
            F(this.f10949h, f2, this.f10951j);
        }
    }

    public final void U(float f2) {
        this.s = f2;
        Matrix matrix = this.D;
        g(f2, matrix);
        this.y.setImageMatrix(matrix);
    }

    public final void V(int i2) {
        if (this.t != i2) {
            this.t = i2;
            h0();
        }
    }

    public void W(int i2) {
        this.f10952k = i2;
    }

    public final void X(float f2) {
        if (this.f10951j != f2) {
            this.f10951j = f2;
            F(this.f10949h, this.f10950i, f2);
        }
    }

    public void Y(@Nullable ColorStateList colorStateList) {
        Drawable drawable = this.f10944c;
        if (drawable != null) {
            DrawableCompat.setTintList(drawable, e.j.a.c.x.b.d(colorStateList));
        }
    }

    public void Z(boolean z) {
        this.f10948g = z;
        i0();
    }

    public final void a0(@NonNull o oVar) {
        this.a = oVar;
        e.j.a.c.z.j jVar = this.b;
        if (jVar != null) {
            jVar.setShapeAppearanceModel(oVar);
        }
        Drawable drawable = this.f10944c;
        if (drawable instanceof s) {
            ((s) drawable).setShapeAppearanceModel(oVar);
        }
        e.j.a.c.r.c cVar = this.f10945d;
        if (cVar != null) {
            cVar.g(oVar);
        }
    }

    public final void b0(@Nullable e.j.a.c.a.h hVar) {
        this.p = hVar;
    }

    public boolean c0() {
        return true;
    }

    public void d(@NonNull Animator.AnimatorListener animatorListener) {
        if (this.w == null) {
            this.w = new ArrayList<>();
        }
        this.w.add(animatorListener);
    }

    public void e(@NonNull Animator.AnimatorListener animatorListener) {
        if (this.v == null) {
            this.v = new ArrayList<>();
        }
        this.v.add(animatorListener);
    }

    public final boolean e0() {
        return !this.f10947f || this.y.getSizeDimension() >= this.f10952k;
    }

    public void f(@NonNull i iVar) {
        if (this.x == null) {
            this.x = new ArrayList<>();
        }
        this.x.add(iVar);
    }

    public void f0(@Nullable j jVar, boolean z) {
        if (z()) {
            return;
        }
        Animator animator = this.o;
        if (animator != null) {
            animator.cancel();
        }
        if (d0()) {
            if (this.y.getVisibility() != 0) {
                this.y.setAlpha(0.0f);
                this.y.setScaleY(0.0f);
                this.y.setScaleX(0.0f);
                U(0.0f);
            }
            e.j.a.c.a.h hVar = this.p;
            if (hVar == null) {
                hVar = m();
            }
            AnimatorSet h2 = h(hVar, 1.0f, 1.0f, 1.0f);
            h2.addListener(new b(z, jVar));
            ArrayList<Animator.AnimatorListener> arrayList = this.v;
            if (arrayList != null) {
                Iterator<Animator.AnimatorListener> it = arrayList.iterator();
                while (it.hasNext()) {
                    h2.addListener(it.next());
                }
            }
            h2.start();
            return;
        }
        this.y.c(0, z);
        this.y.setAlpha(1.0f);
        this.y.setScaleY(1.0f);
        this.y.setScaleX(1.0f);
        U(1.0f);
        if (jVar != null) {
            jVar.a();
        }
    }

    public void g0() {
        if (Build.VERSION.SDK_INT == 19) {
            if (this.r % 90.0f != 0.0f) {
                if (this.y.getLayerType() != 1) {
                    this.y.setLayerType(1, null);
                }
            } else if (this.y.getLayerType() != 0) {
                this.y.setLayerType(0, null);
            }
        }
        e.j.a.c.z.j jVar = this.b;
        if (jVar != null) {
            jVar.v0((int) this.r);
        }
    }

    public final void h0() {
        U(this.s);
    }

    public final void i0() {
        Rect rect = this.A;
        s(rect);
        G(rect);
        this.z.setShadowPadding(rect.left, rect.top, rect.right, rect.bottom);
    }

    public e.j.a.c.z.j j() {
        return new e.j.a.c.z.j((o) Preconditions.checkNotNull(this.a));
    }

    public void j0(float f2) {
        e.j.a.c.z.j jVar = this.b;
        if (jVar != null) {
            jVar.m0(f2);
        }
    }

    @Nullable
    public final Drawable k() {
        return this.f10946e;
    }

    public float n() {
        return this.f10949h;
    }

    public boolean o() {
        return this.f10947f;
    }

    @Nullable
    public final e.j.a.c.a.h p() {
        return this.q;
    }

    public float q() {
        return this.f10950i;
    }

    public void s(@NonNull Rect rect) {
        int sizeDimension = this.f10947f ? (this.f10952k - this.y.getSizeDimension()) / 2 : 0;
        float n = this.f10948g ? n() + this.f10951j : 0.0f;
        int max = Math.max(sizeDimension, (int) Math.ceil(n));
        int max2 = Math.max(sizeDimension, (int) Math.ceil(n * 1.5f));
        rect.set(max, max2, max, max2);
    }

    public float t() {
        return this.f10951j;
    }

    @Nullable
    public final o u() {
        return this.a;
    }

    @Nullable
    public final e.j.a.c.a.h v() {
        return this.p;
    }

    public void w(@Nullable j jVar, boolean z) {
        if (y()) {
            return;
        }
        Animator animator = this.o;
        if (animator != null) {
            animator.cancel();
        }
        if (d0()) {
            e.j.a.c.a.h hVar = this.q;
            if (hVar == null) {
                hVar = l();
            }
            AnimatorSet h2 = h(hVar, 0.0f, 0.0f, 0.0f);
            h2.addListener(new a(z, jVar));
            ArrayList<Animator.AnimatorListener> arrayList = this.w;
            if (arrayList != null) {
                Iterator<Animator.AnimatorListener> it = arrayList.iterator();
                while (it.hasNext()) {
                    h2.addListener(it.next());
                }
            }
            h2.start();
            return;
        }
        this.y.c(z ? 8 : 4, z);
        if (jVar != null) {
            jVar.b();
        }
    }

    public void x(ColorStateList colorStateList, @Nullable PorterDuff.Mode mode, ColorStateList colorStateList2, int i2) {
        e.j.a.c.z.j j2 = j();
        this.b = j2;
        j2.setTintList(colorStateList);
        if (mode != null) {
            this.b.setTintMode(mode);
        }
        this.b.u0(-12303292);
        this.b.Y(this.y.getContext());
        e.j.a.c.x.a aVar = new e.j.a.c.x.a(this.b.getShapeAppearanceModel());
        aVar.setTintList(e.j.a.c.x.b.d(colorStateList2));
        this.f10944c = aVar;
        this.f10946e = new LayerDrawable(new Drawable[]{(Drawable) Preconditions.checkNotNull(this.b), aVar});
    }

    public boolean y() {
        return this.y.getVisibility() == 0 ? this.u == 1 : this.u != 2;
    }

    public boolean z() {
        return this.y.getVisibility() != 0 ? this.u == 2 : this.u != 1;
    }
}
