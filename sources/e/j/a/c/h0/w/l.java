package e.j.a.c.h0.w;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.transition.ArcMotion;
import android.transition.PathMotion;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.core.util.Preconditions;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import e.j.a.c.h0.w.v;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@RequiresApi(21)
/* loaded from: classes2.dex */
public final class l extends Transition {
    public static final int A = 1;
    public static final int B = 2;
    public static final int C = 0;
    public static final int D = 1;
    public static final int E = 2;
    public static final int F = 3;
    public static final int G = 0;
    public static final int H = 1;
    public static final int I = 2;
    private static final String J = l.class.getSimpleName();
    private static final String K = "materialContainerTransition:bounds";
    private static final String L = "materialContainerTransition:shapeAppearance";
    private static final String[] M = {K, L};
    private static final f N = new f(new e(0.0f, 0.25f), new e(0.0f, 1.0f), new e(0.0f, 1.0f), new e(0.0f, 0.75f), null);
    private static final f O = new f(new e(0.6f, 0.9f), new e(0.0f, 1.0f), new e(0.0f, 0.9f), new e(0.3f, 0.9f), null);
    private static final f P = new f(new e(0.1f, 0.4f), new e(0.1f, 1.0f), new e(0.1f, 1.0f), new e(0.1f, 0.9f), null);
    private static final f Q = new f(new e(0.6f, 0.9f), new e(0.0f, 0.9f), new e(0.0f, 0.9f), new e(0.2f, 0.9f), null);
    private static final float R = -1.0f;
    public static final int z = 0;
    private boolean a;
    private boolean b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f10780c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f10781d;
    @IdRes

    /* renamed from: e  reason: collision with root package name */
    private int f10782e;
    @IdRes

    /* renamed from: f  reason: collision with root package name */
    private int f10783f;
    @IdRes

    /* renamed from: g  reason: collision with root package name */
    private int f10784g;
    @ColorInt

    /* renamed from: h  reason: collision with root package name */
    private int f10785h;
    @ColorInt

    /* renamed from: i  reason: collision with root package name */
    private int f10786i;
    @ColorInt

    /* renamed from: j  reason: collision with root package name */
    private int f10787j;
    @ColorInt

    /* renamed from: k  reason: collision with root package name */
    private int f10788k;

    /* renamed from: l  reason: collision with root package name */
    private int f10789l;

    /* renamed from: m  reason: collision with root package name */
    private int f10790m;
    private int n;
    @Nullable
    private View o;
    @Nullable
    private View p;
    @Nullable
    private e.j.a.c.z.o q;
    @Nullable
    private e.j.a.c.z.o r;
    @Nullable
    private e s;
    @Nullable
    private e t;
    @Nullable
    private e u;
    @Nullable
    private e v;
    private boolean w;
    private float x;
    private float y;

    /* loaded from: classes2.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ h a;

        public a(h hVar) {
            this.a = hVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.a.o(valueAnimator.getAnimatedFraction());
        }
    }

    /* loaded from: classes2.dex */
    public class b extends u {
        public final /* synthetic */ View a;
        public final /* synthetic */ h b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ View f10791c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ View f10792d;

        public b(View view, h hVar, View view2, View view3) {
            this.a = view;
            this.b = hVar;
            this.f10791c = view2;
            this.f10792d = view3;
        }

        @Override // e.j.a.c.h0.w.u, android.transition.Transition.TransitionListener
        public void onTransitionEnd(@NonNull Transition transition) {
            l.this.removeListener(this);
            if (l.this.b) {
                return;
            }
            this.f10791c.setAlpha(1.0f);
            this.f10792d.setAlpha(1.0f);
            e.j.a.c.s.t.h(this.a).remove(this.b);
        }

        @Override // e.j.a.c.h0.w.u, android.transition.Transition.TransitionListener
        public void onTransitionStart(@NonNull Transition transition) {
            e.j.a.c.s.t.h(this.a).add(this.b);
            this.f10791c.setAlpha(0.0f);
            this.f10792d.setAlpha(0.0f);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes2.dex */
    public @interface c {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes2.dex */
    public @interface d {
    }

    /* loaded from: classes2.dex */
    public static class e {
        @FloatRange(from = 0.0d, to = 1.0d)
        private final float a;
        @FloatRange(from = 0.0d, to = 1.0d)
        private final float b;

        public e(@FloatRange(from = 0.0d, to = 1.0d) float f2, @FloatRange(from = 0.0d, to = 1.0d) float f3) {
            this.a = f2;
            this.b = f3;
        }

        @FloatRange(from = 0.0d, to = 1.0d)
        public float c() {
            return this.b;
        }

        @FloatRange(from = 0.0d, to = 1.0d)
        public float d() {
            return this.a;
        }
    }

    /* loaded from: classes2.dex */
    public static class f {
        @NonNull
        private final e a;
        @NonNull
        private final e b;
        @NonNull

        /* renamed from: c  reason: collision with root package name */
        private final e f10794c;
        @NonNull

        /* renamed from: d  reason: collision with root package name */
        private final e f10795d;

        public /* synthetic */ f(e eVar, e eVar2, e eVar3, e eVar4, a aVar) {
            this(eVar, eVar2, eVar3, eVar4);
        }

        private f(@NonNull e eVar, @NonNull e eVar2, @NonNull e eVar3, @NonNull e eVar4) {
            this.a = eVar;
            this.b = eVar2;
            this.f10794c = eVar3;
            this.f10795d = eVar4;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes2.dex */
    public @interface g {
    }

    /* loaded from: classes2.dex */
    public static final class h extends Drawable {
        private static final int M = 754974720;
        private static final int N = -7829368;
        private static final float O = 0.3f;
        private static final float P = 1.5f;
        private final f A;
        private final e.j.a.c.h0.w.a B;
        private final e.j.a.c.h0.w.f C;
        private final boolean D;
        private final Paint E;
        private final Path F;
        private e.j.a.c.h0.w.c G;
        private e.j.a.c.h0.w.h H;
        private RectF I;
        private float J;
        private float K;
        private float L;
        private final View a;
        private final RectF b;

        /* renamed from: c  reason: collision with root package name */
        private final e.j.a.c.z.o f10796c;

        /* renamed from: d  reason: collision with root package name */
        private final float f10797d;

        /* renamed from: e  reason: collision with root package name */
        private final View f10798e;

        /* renamed from: f  reason: collision with root package name */
        private final RectF f10799f;

        /* renamed from: g  reason: collision with root package name */
        private final e.j.a.c.z.o f10800g;

        /* renamed from: h  reason: collision with root package name */
        private final float f10801h;

        /* renamed from: i  reason: collision with root package name */
        private final Paint f10802i;

        /* renamed from: j  reason: collision with root package name */
        private final Paint f10803j;

        /* renamed from: k  reason: collision with root package name */
        private final Paint f10804k;

        /* renamed from: l  reason: collision with root package name */
        private final Paint f10805l;

        /* renamed from: m  reason: collision with root package name */
        private final Paint f10806m;
        private final j n;
        private final PathMeasure o;
        private final float p;
        private final float[] q;
        private final boolean r;
        private final float s;
        private final float t;
        private final boolean u;
        private final e.j.a.c.z.j v;
        private final RectF w;
        private final RectF x;
        private final RectF y;
        private final RectF z;

        /* loaded from: classes2.dex */
        public class a implements v.c {
            public a() {
            }

            @Override // e.j.a.c.h0.w.v.c
            public void a(Canvas canvas) {
                h.this.a.draw(canvas);
            }
        }

        /* loaded from: classes2.dex */
        public class b implements v.c {
            public b() {
            }

            @Override // e.j.a.c.h0.w.v.c
            public void a(Canvas canvas) {
                h.this.f10798e.draw(canvas);
            }
        }

        public /* synthetic */ h(PathMotion pathMotion, View view, RectF rectF, e.j.a.c.z.o oVar, float f2, View view2, RectF rectF2, e.j.a.c.z.o oVar2, float f3, int i2, int i3, int i4, int i5, boolean z, boolean z2, e.j.a.c.h0.w.a aVar, e.j.a.c.h0.w.f fVar, f fVar2, boolean z3, a aVar2) {
            this(pathMotion, view, rectF, oVar, f2, view2, rectF2, oVar2, f3, i2, i3, i4, i5, z, z2, aVar, fVar, fVar2, z3);
        }

        private static float d(RectF rectF, float f2) {
            return ((rectF.centerX() / (f2 / 2.0f)) - 1.0f) * O;
        }

        private static float e(RectF rectF, float f2) {
            return (rectF.centerY() / f2) * 1.5f;
        }

        private void f(Canvas canvas, RectF rectF, Path path, @ColorInt int i2) {
            PointF m2 = m(rectF);
            if (this.L == 0.0f) {
                path.reset();
                path.moveTo(m2.x, m2.y);
                return;
            }
            path.lineTo(m2.x, m2.y);
            this.E.setColor(i2);
            canvas.drawPath(path, this.E);
        }

        private void g(Canvas canvas, RectF rectF, @ColorInt int i2) {
            this.E.setColor(i2);
            canvas.drawRect(rectF, this.E);
        }

        private void h(Canvas canvas) {
            canvas.save();
            canvas.clipPath(this.n.d(), Region.Op.DIFFERENCE);
            if (Build.VERSION.SDK_INT > 28) {
                j(canvas);
            } else {
                i(canvas);
            }
            canvas.restore();
        }

        private void i(Canvas canvas) {
            e.j.a.c.z.j jVar = this.v;
            RectF rectF = this.I;
            jVar.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
            this.v.m0(this.J);
            this.v.A0((int) this.K);
            this.v.setShapeAppearanceModel(this.n.c());
            this.v.draw(canvas);
        }

        private void j(Canvas canvas) {
            e.j.a.c.z.o c2 = this.n.c();
            if (c2.u(this.I)) {
                float a2 = c2.r().a(this.I);
                canvas.drawRoundRect(this.I, a2, a2, this.f10805l);
                return;
            }
            canvas.drawPath(this.n.d(), this.f10805l);
        }

        private void k(Canvas canvas) {
            n(canvas, this.f10804k);
            Rect bounds = getBounds();
            RectF rectF = this.y;
            v.A(canvas, bounds, rectF.left, rectF.top, this.H.b, this.G.b, new b());
        }

        private void l(Canvas canvas) {
            n(canvas, this.f10803j);
            Rect bounds = getBounds();
            RectF rectF = this.w;
            v.A(canvas, bounds, rectF.left, rectF.top, this.H.a, this.G.a, new a());
        }

        private static PointF m(RectF rectF) {
            return new PointF(rectF.centerX(), rectF.top);
        }

        private void n(Canvas canvas, Paint paint) {
            if (paint.getColor() == 0 || paint.getAlpha() <= 0) {
                return;
            }
            canvas.drawRect(getBounds(), paint);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void o(float f2) {
            if (this.L != f2) {
                p(f2);
            }
        }

        private void p(float f2) {
            float f3;
            float f4;
            this.L = f2;
            this.f10806m.setAlpha((int) (this.r ? v.n(0.0f, 255.0f, f2) : v.n(255.0f, 0.0f, f2)));
            this.o.getPosTan(this.p * f2, this.q, null);
            float[] fArr = this.q;
            float f5 = fArr[0];
            float f6 = fArr[1];
            int i2 = (f2 > 1.0f ? 1 : (f2 == 1.0f ? 0 : -1));
            if (i2 > 0 || f2 < 0.0f) {
                if (i2 > 0) {
                    f3 = 0.99f;
                    f4 = (f2 - 1.0f) / 0.00999999f;
                } else {
                    f3 = 0.01f;
                    f4 = (f2 / 0.01f) * (-1.0f);
                }
                this.o.getPosTan(this.p * f3, fArr, null);
                float[] fArr2 = this.q;
                f5 += (f5 - fArr2[0]) * f4;
                f6 += (f6 - fArr2[1]) * f4;
            }
            float f7 = f5;
            float f8 = f6;
            e.j.a.c.h0.w.h a2 = this.C.a(f2, ((Float) Preconditions.checkNotNull(Float.valueOf(this.A.b.a))).floatValue(), ((Float) Preconditions.checkNotNull(Float.valueOf(this.A.b.b))).floatValue(), this.b.width(), this.b.height(), this.f10799f.width(), this.f10799f.height());
            this.H = a2;
            RectF rectF = this.w;
            float f9 = a2.f10773c;
            rectF.set(f7 - (f9 / 2.0f), f8, (f9 / 2.0f) + f7, a2.f10774d + f8);
            RectF rectF2 = this.y;
            e.j.a.c.h0.w.h hVar = this.H;
            float f10 = hVar.f10775e;
            rectF2.set(f7 - (f10 / 2.0f), f8, f7 + (f10 / 2.0f), hVar.f10776f + f8);
            this.x.set(this.w);
            this.z.set(this.y);
            float floatValue = ((Float) Preconditions.checkNotNull(Float.valueOf(this.A.f10794c.a))).floatValue();
            float floatValue2 = ((Float) Preconditions.checkNotNull(Float.valueOf(this.A.f10794c.b))).floatValue();
            boolean b2 = this.C.b(this.H);
            RectF rectF3 = b2 ? this.x : this.z;
            float o = v.o(0.0f, 1.0f, floatValue, floatValue2, f2);
            if (!b2) {
                o = 1.0f - o;
            }
            this.C.c(rectF3, o, this.H);
            this.I = new RectF(Math.min(this.x.left, this.z.left), Math.min(this.x.top, this.z.top), Math.max(this.x.right, this.z.right), Math.max(this.x.bottom, this.z.bottom));
            this.n.b(f2, this.f10796c, this.f10800g, this.w, this.x, this.z, this.A.f10795d);
            this.J = v.n(this.f10797d, this.f10801h, f2);
            float d2 = d(this.I, this.s);
            float e2 = e(this.I, this.t);
            float f11 = this.J;
            float f12 = (int) (e2 * f11);
            this.K = f12;
            this.f10805l.setShadowLayer(f11, (int) (d2 * f11), f12, M);
            this.G = this.B.a(f2, ((Float) Preconditions.checkNotNull(Float.valueOf(this.A.a.a))).floatValue(), ((Float) Preconditions.checkNotNull(Float.valueOf(this.A.a.b))).floatValue(), 0.35f);
            if (this.f10803j.getColor() != 0) {
                this.f10803j.setAlpha(this.G.a);
            }
            if (this.f10804k.getColor() != 0) {
                this.f10804k.setAlpha(this.G.b);
            }
            invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(@NonNull Canvas canvas) {
            if (this.f10806m.getAlpha() > 0) {
                canvas.drawRect(getBounds(), this.f10806m);
            }
            int save = this.D ? canvas.save() : -1;
            if (this.u && this.J > 0.0f) {
                h(canvas);
            }
            this.n.a(canvas);
            n(canvas, this.f10802i);
            if (this.G.f10766c) {
                l(canvas);
                k(canvas);
            } else {
                k(canvas);
                l(canvas);
            }
            if (this.D) {
                canvas.restoreToCount(save);
                f(canvas, this.w, this.F, -65281);
                g(canvas, this.x, InputDeviceCompat.SOURCE_ANY);
                g(canvas, this.w, -16711936);
                g(canvas, this.z, -16711681);
                g(canvas, this.y, -16776961);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -3;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i2) {
            throw new UnsupportedOperationException("Setting alpha on is not supported");
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(@Nullable ColorFilter colorFilter) {
            throw new UnsupportedOperationException("Setting a color filter is not supported");
        }

        private h(PathMotion pathMotion, View view, RectF rectF, e.j.a.c.z.o oVar, float f2, View view2, RectF rectF2, e.j.a.c.z.o oVar2, float f3, @ColorInt int i2, @ColorInt int i3, @ColorInt int i4, int i5, boolean z, boolean z2, e.j.a.c.h0.w.a aVar, e.j.a.c.h0.w.f fVar, f fVar2, boolean z3) {
            Paint paint = new Paint();
            this.f10802i = paint;
            Paint paint2 = new Paint();
            this.f10803j = paint2;
            Paint paint3 = new Paint();
            this.f10804k = paint3;
            this.f10805l = new Paint();
            Paint paint4 = new Paint();
            this.f10806m = paint4;
            this.n = new j();
            this.q = r7;
            e.j.a.c.z.j jVar = new e.j.a.c.z.j();
            this.v = jVar;
            Paint paint5 = new Paint();
            this.E = paint5;
            this.F = new Path();
            this.a = view;
            this.b = rectF;
            this.f10796c = oVar;
            this.f10797d = f2;
            this.f10798e = view2;
            this.f10799f = rectF2;
            this.f10800g = oVar2;
            this.f10801h = f3;
            this.r = z;
            this.u = z2;
            this.B = aVar;
            this.C = fVar;
            this.A = fVar2;
            this.D = z3;
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            this.s = displayMetrics.widthPixels;
            this.t = displayMetrics.heightPixels;
            paint.setColor(i2);
            paint2.setColor(i3);
            paint3.setColor(i4);
            jVar.n0(ColorStateList.valueOf(0));
            jVar.w0(2);
            jVar.t0(false);
            jVar.u0(N);
            RectF rectF3 = new RectF(rectF);
            this.w = rectF3;
            this.x = new RectF(rectF3);
            RectF rectF4 = new RectF(rectF3);
            this.y = rectF4;
            this.z = new RectF(rectF4);
            PointF m2 = m(rectF);
            PointF m3 = m(rectF2);
            PathMeasure pathMeasure = new PathMeasure(pathMotion.getPath(m2.x, m2.y, m3.x, m3.y), false);
            this.o = pathMeasure;
            this.p = pathMeasure.getLength();
            float[] fArr = {rectF.centerX(), rectF.top};
            paint4.setStyle(Paint.Style.FILL);
            paint4.setShader(v.c(i5));
            paint5.setStyle(Paint.Style.STROKE);
            paint5.setStrokeWidth(10.0f);
            p(0.0f);
        }
    }

    public l() {
        this.a = false;
        this.b = false;
        this.f10780c = false;
        this.f10781d = false;
        this.f10782e = 16908290;
        this.f10783f = -1;
        this.f10784g = -1;
        this.f10785h = 0;
        this.f10786i = 0;
        this.f10787j = 0;
        this.f10788k = 1375731712;
        this.f10789l = 0;
        this.f10790m = 0;
        this.n = 0;
        this.w = Build.VERSION.SDK_INT >= 28;
        this.x = -1.0f;
        this.y = -1.0f;
    }

    private f C(boolean z2, f fVar, f fVar2) {
        if (!z2) {
            fVar = fVar2;
        }
        return new f((e) v.d(this.s, fVar.a), (e) v.d(this.t, fVar.b), (e) v.d(this.u, fVar.f10794c), (e) v.d(this.v, fVar.f10795d), null);
    }

    @StyleRes
    private static int E(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(new int[]{R.attr.transitionShapeAppearance});
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    private boolean H(@NonNull RectF rectF, @NonNull RectF rectF2) {
        int i2 = this.f10789l;
        if (i2 == 0) {
            return v.a(rectF2) > v.a(rectF);
        } else if (i2 != 1) {
            if (i2 == 2) {
                return false;
            }
            throw new IllegalArgumentException("Invalid transition direction: " + this.f10789l);
        } else {
            return true;
        }
    }

    private void J(Context context, boolean z2) {
        v.u(this, context, R.attr.motionEasingStandard, e.j.a.c.a.a.b);
        v.t(this, context, z2 ? R.attr.motionDurationLong1 : R.attr.motionDurationMedium2);
        if (this.f10780c) {
            return;
        }
        v.v(this, context, R.attr.motionPath);
    }

    private f b(boolean z2) {
        PathMotion pathMotion = getPathMotion();
        if (!(pathMotion instanceof ArcMotion) && !(pathMotion instanceof k)) {
            return C(z2, N, O);
        }
        return C(z2, P, Q);
    }

    private static RectF c(View view, @Nullable View view2, float f2, float f3) {
        if (view2 != null) {
            RectF i2 = v.i(view2);
            i2.offset(f2, f3);
            return i2;
        }
        return new RectF(0.0f, 0.0f, view.getWidth(), view.getHeight());
    }

    private static e.j.a.c.z.o e(@NonNull View view, @NonNull RectF rectF, @Nullable e.j.a.c.z.o oVar) {
        return v.b(v(view, oVar), rectF);
    }

    private static void f(@NonNull TransitionValues transitionValues, @Nullable View view, @IdRes int i2, @Nullable e.j.a.c.z.o oVar) {
        if (i2 != -1) {
            transitionValues.view = v.f(transitionValues.view, i2);
        } else if (view != null) {
            transitionValues.view = view;
        } else {
            View view2 = transitionValues.view;
            int i3 = R.id.mtrl_motion_snapshot_view;
            if (view2.getTag(i3) instanceof View) {
                transitionValues.view.setTag(i3, null);
                transitionValues.view = (View) transitionValues.view.getTag(i3);
            }
        }
        View view3 = transitionValues.view;
        if (!ViewCompat.isLaidOut(view3) && view3.getWidth() == 0 && view3.getHeight() == 0) {
            return;
        }
        RectF j2 = view3.getParent() == null ? v.j(view3) : v.i(view3);
        transitionValues.values.put(K, j2);
        transitionValues.values.put(L, e(view3, j2, oVar));
    }

    private static float j(float f2, View view) {
        return f2 != -1.0f ? f2 : ViewCompat.getElevation(view);
    }

    private static e.j.a.c.z.o v(@NonNull View view, @Nullable e.j.a.c.z.o oVar) {
        if (oVar != null) {
            return oVar;
        }
        int i2 = R.id.mtrl_motion_snapshot_view;
        if (view.getTag(i2) instanceof e.j.a.c.z.o) {
            return (e.j.a.c.z.o) view.getTag(i2);
        }
        Context context = view.getContext();
        int E2 = E(context);
        if (E2 != -1) {
            return e.j.a.c.z.o.b(context, E2, 0).m();
        }
        if (view instanceof e.j.a.c.z.s) {
            return ((e.j.a.c.z.s) view).getShapeAppearanceModel();
        }
        return e.j.a.c.z.o.a().m();
    }

    @Nullable
    public View A() {
        return this.o;
    }

    @IdRes
    public int B() {
        return this.f10783f;
    }

    public int D() {
        return this.f10789l;
    }

    public boolean F() {
        return this.a;
    }

    public boolean G() {
        return this.w;
    }

    public boolean I() {
        return this.b;
    }

    public void K(@ColorInt int i2) {
        this.f10785h = i2;
        this.f10786i = i2;
        this.f10787j = i2;
    }

    public void L(@ColorInt int i2) {
        this.f10785h = i2;
    }

    public void M(boolean z2) {
        this.a = z2;
    }

    public void N(@IdRes int i2) {
        this.f10782e = i2;
    }

    public void O(boolean z2) {
        this.w = z2;
    }

    public void P(@ColorInt int i2) {
        this.f10787j = i2;
    }

    public void Q(float f2) {
        this.y = f2;
    }

    public void R(@Nullable e.j.a.c.z.o oVar) {
        this.r = oVar;
    }

    public void S(@Nullable View view) {
        this.p = view;
    }

    public void T(@IdRes int i2) {
        this.f10784g = i2;
    }

    public void U(int i2) {
        this.f10790m = i2;
    }

    public void V(@Nullable e eVar) {
        this.s = eVar;
    }

    public void W(int i2) {
        this.n = i2;
    }

    public void X(boolean z2) {
        this.b = z2;
    }

    public void Y(@Nullable e eVar) {
        this.u = eVar;
    }

    public void Z(@Nullable e eVar) {
        this.t = eVar;
    }

    public void a0(@ColorInt int i2) {
        this.f10788k = i2;
    }

    public void b0(@Nullable e eVar) {
        this.v = eVar;
    }

    public void c0(@ColorInt int i2) {
        this.f10786i = i2;
    }

    @Override // android.transition.Transition
    public void captureEndValues(@NonNull TransitionValues transitionValues) {
        f(transitionValues, this.p, this.f10784g, this.r);
    }

    @Override // android.transition.Transition
    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        f(transitionValues, this.o, this.f10783f, this.q);
    }

    @Override // android.transition.Transition
    @Nullable
    public Animator createAnimator(@NonNull ViewGroup viewGroup, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        View e2;
        View view;
        if (transitionValues != null && transitionValues2 != null) {
            RectF rectF = (RectF) transitionValues.values.get(K);
            e.j.a.c.z.o oVar = (e.j.a.c.z.o) transitionValues.values.get(L);
            if (rectF != null && oVar != null) {
                RectF rectF2 = (RectF) transitionValues2.values.get(K);
                e.j.a.c.z.o oVar2 = (e.j.a.c.z.o) transitionValues2.values.get(L);
                if (rectF2 != null && oVar2 != null) {
                    View view2 = transitionValues.view;
                    View view3 = transitionValues2.view;
                    View view4 = view3.getParent() != null ? view3 : view2;
                    if (this.f10782e == view4.getId()) {
                        e2 = (View) view4.getParent();
                        view = view4;
                    } else {
                        e2 = v.e(view4, this.f10782e);
                        view = null;
                    }
                    RectF i2 = v.i(e2);
                    float f2 = -i2.left;
                    float f3 = -i2.top;
                    RectF c2 = c(e2, view, f2, f3);
                    rectF.offset(f2, f3);
                    rectF2.offset(f2, f3);
                    boolean H2 = H(rectF, rectF2);
                    if (!this.f10781d) {
                        J(view4.getContext(), H2);
                    }
                    h hVar = new h(getPathMotion(), view2, rectF, oVar, j(this.x, view2), view3, rectF2, oVar2, j(this.y, view3), this.f10785h, this.f10786i, this.f10787j, this.f10788k, H2, this.w, e.j.a.c.h0.w.b.a(this.f10790m, H2), e.j.a.c.h0.w.g.a(this.n, H2, rectF, rectF2), b(H2), this.a, null);
                    hVar.setBounds(Math.round(c2.left), Math.round(c2.top), Math.round(c2.right), Math.round(c2.bottom));
                    ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                    ofFloat.addUpdateListener(new a(hVar));
                    addListener(new b(e2, hVar, view2, view3));
                    return ofFloat;
                }
                Log.w(J, "Skipping due to null end bounds. Ensure end view is laid out and measured.");
                return null;
            }
            Log.w(J, "Skipping due to null start bounds. Ensure start view is laid out and measured.");
        }
        return null;
    }

    public void d0(float f2) {
        this.x = f2;
    }

    public void e0(@Nullable e.j.a.c.z.o oVar) {
        this.q = oVar;
    }

    public void f0(@Nullable View view) {
        this.o = view;
    }

    @ColorInt
    public int g() {
        return this.f10785h;
    }

    public void g0(@IdRes int i2) {
        this.f10783f = i2;
    }

    @Override // android.transition.Transition
    @Nullable
    public String[] getTransitionProperties() {
        return M;
    }

    @IdRes
    public int h() {
        return this.f10782e;
    }

    public void h0(int i2) {
        this.f10789l = i2;
    }

    @ColorInt
    public int k() {
        return this.f10787j;
    }

    public float l() {
        return this.y;
    }

    @Nullable
    public e.j.a.c.z.o m() {
        return this.r;
    }

    @Nullable
    public View n() {
        return this.p;
    }

    @IdRes
    public int o() {
        return this.f10784g;
    }

    public int p() {
        return this.f10790m;
    }

    @Nullable
    public e q() {
        return this.s;
    }

    public int r() {
        return this.n;
    }

    @Nullable
    public e s() {
        return this.u;
    }

    @Override // android.transition.Transition
    public void setPathMotion(@Nullable PathMotion pathMotion) {
        super.setPathMotion(pathMotion);
        this.f10780c = true;
    }

    @Nullable
    public e t() {
        return this.t;
    }

    @ColorInt
    public int u() {
        return this.f10788k;
    }

    @Nullable
    public e w() {
        return this.v;
    }

    @ColorInt
    public int x() {
        return this.f10786i;
    }

    public float y() {
        return this.x;
    }

    @Nullable
    public e.j.a.c.z.o z() {
        return this.q;
    }

    public l(@NonNull Context context, boolean z2) {
        this.a = false;
        this.b = false;
        this.f10780c = false;
        this.f10781d = false;
        this.f10782e = 16908290;
        this.f10783f = -1;
        this.f10784g = -1;
        this.f10785h = 0;
        this.f10786i = 0;
        this.f10787j = 0;
        this.f10788k = 1375731712;
        this.f10789l = 0;
        this.f10790m = 0;
        this.n = 0;
        this.w = Build.VERSION.SDK_INT >= 28;
        this.x = -1.0f;
        this.y = -1.0f;
        J(context, z2);
        this.f10781d = true;
    }
}
