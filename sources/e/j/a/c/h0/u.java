package e.j.a.c.h0;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.PathParser;
import androidx.core.view.animation.PathInterpolatorCompat;
import androidx.transition.PathMotion;
import androidx.transition.PatternPathMotion;
import androidx.transition.Transition;
import androidx.transition.TransitionSet;
import com.xiaomi.mipush.sdk.Constants;
import e.j.a.c.z.o;

/* loaded from: classes2.dex */
public class u {
    public static final int a = -1;
    @AttrRes
    public static final int b = 0;

    /* renamed from: c  reason: collision with root package name */
    private static final String f10754c = "cubic-bezier";

    /* renamed from: d  reason: collision with root package name */
    private static final String f10755d = "path";

    /* renamed from: e  reason: collision with root package name */
    private static final String f10756e = "(";

    /* renamed from: f  reason: collision with root package name */
    private static final String f10757f = ")";

    /* renamed from: g  reason: collision with root package name */
    private static final int f10758g = 0;

    /* renamed from: h  reason: collision with root package name */
    private static final int f10759h = 1;

    /* renamed from: i  reason: collision with root package name */
    private static final RectF f10760i = new RectF();

    /* loaded from: classes2.dex */
    public static class a implements o.c {
        public final /* synthetic */ RectF a;

        public a(RectF rectF) {
            this.a = rectF;
        }

        @Override // e.j.a.c.z.o.c
        @NonNull
        public e.j.a.c.z.d a(@NonNull e.j.a.c.z.d dVar) {
            return dVar instanceof e.j.a.c.z.m ? dVar : new e.j.a.c.z.m(dVar.a(this.a) / this.a.height());
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements d {
        public final /* synthetic */ RectF a;
        public final /* synthetic */ RectF b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ float f10761c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ float f10762d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ float f10763e;

        public b(RectF rectF, RectF rectF2, float f2, float f3, float f4) {
            this.a = rectF;
            this.b = rectF2;
            this.f10761c = f2;
            this.f10762d = f3;
            this.f10763e = f4;
        }

        @Override // e.j.a.c.h0.u.d
        @NonNull
        public e.j.a.c.z.d a(@NonNull e.j.a.c.z.d dVar, @NonNull e.j.a.c.z.d dVar2) {
            return new e.j.a.c.z.a(u.o(dVar.a(this.a), dVar2.a(this.b), this.f10761c, this.f10762d, this.f10763e));
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
        void a(Canvas canvas);
    }

    /* loaded from: classes2.dex */
    public interface d {
        @NonNull
        e.j.a.c.z.d a(@NonNull e.j.a.c.z.d dVar, @NonNull e.j.a.c.z.d dVar2);
    }

    private u() {
    }

    public static void A(Canvas canvas, Rect rect, float f2, float f3, float f4, int i2, c cVar) {
        if (i2 <= 0) {
            return;
        }
        int save = canvas.save();
        canvas.translate(f2, f3);
        canvas.scale(f4, f4);
        if (i2 < 255) {
            z(canvas, rect, i2);
        }
        cVar.a(canvas);
        canvas.restoreToCount(save);
    }

    public static e.j.a.c.z.o B(e.j.a.c.z.o oVar, e.j.a.c.z.o oVar2, RectF rectF, d dVar) {
        return (m(oVar, rectF) ? oVar : oVar2).v().L(dVar.a(oVar.r(), oVar2.r())).Q(dVar.a(oVar.t(), oVar2.t())).y(dVar.a(oVar.j(), oVar2.j())).D(dVar.a(oVar.l(), oVar2.l())).m();
    }

    public static float a(@NonNull RectF rectF) {
        return rectF.width() * rectF.height();
    }

    public static e.j.a.c.z.o b(e.j.a.c.z.o oVar, RectF rectF) {
        return oVar.y(new a(rectF));
    }

    public static Shader c(@ColorInt int i2) {
        return new LinearGradient(0.0f, 0.0f, 0.0f, 0.0f, i2, i2, Shader.TileMode.CLAMP);
    }

    @NonNull
    public static <T> T d(@Nullable T t, @NonNull T t2) {
        return t != null ? t : t2;
    }

    public static View e(View view, @IdRes int i2) {
        String resourceName = view.getResources().getResourceName(i2);
        while (view != null) {
            if (view.getId() != i2) {
                ViewParent parent = view.getParent();
                if (!(parent instanceof View)) {
                    break;
                }
                view = (View) parent;
            } else {
                return view;
            }
        }
        throw new IllegalArgumentException(resourceName + " is not a valid ancestor");
    }

    public static View f(View view, @IdRes int i2) {
        View findViewById = view.findViewById(i2);
        return findViewById != null ? findViewById : e(view, i2);
    }

    private static float g(String[] strArr, int i2) {
        float parseFloat = Float.parseFloat(strArr[i2]);
        if (parseFloat < 0.0f || parseFloat > 1.0f) {
            throw new IllegalArgumentException("Motion easing control point value must be between 0 and 1; instead got: " + parseFloat);
        }
        return parseFloat;
    }

    private static String h(String str, String str2) {
        return str.substring(str2.length() + 1, str.length() - 1);
    }

    public static RectF i(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i2 = iArr[0];
        int i3 = iArr[1];
        return new RectF(i2, i3, view.getWidth() + i2, view.getHeight() + i3);
    }

    public static RectF j(View view) {
        return new RectF(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }

    public static Rect k(View view) {
        return new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }

    private static boolean l(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append(f10756e);
        return str.startsWith(sb.toString()) && str.endsWith(f10757f);
    }

    private static boolean m(e.j.a.c.z.o oVar, RectF rectF) {
        return (oVar.r().a(rectF) == 0.0f && oVar.t().a(rectF) == 0.0f && oVar.l().a(rectF) == 0.0f && oVar.j().a(rectF) == 0.0f) ? false : true;
    }

    public static float n(float f2, float f3, float f4) {
        return f2 + (f4 * (f3 - f2));
    }

    public static float o(float f2, float f3, @FloatRange(from = 0.0d, to = 1.0d) float f4, @FloatRange(from = 0.0d, to = 1.0d) float f5, @FloatRange(from = 0.0d, to = 1.0d) float f6) {
        return p(f2, f3, f4, f5, f6, false);
    }

    public static float p(float f2, float f3, @FloatRange(from = 0.0d, to = 1.0d) float f4, @FloatRange(from = 0.0d, to = 1.0d) float f5, @FloatRange(from = 0.0d) float f6, boolean z) {
        if (!z || (f6 >= 0.0f && f6 <= 1.0f)) {
            return f6 < f4 ? f2 : f6 > f5 ? f3 : n(f2, f3, (f6 - f4) / (f5 - f4));
        }
        return n(f2, f3, f6);
    }

    public static int q(int i2, int i3, @FloatRange(from = 0.0d, to = 1.0d) float f2, @FloatRange(from = 0.0d, to = 1.0d) float f3, @FloatRange(from = 0.0d, to = 1.0d) float f4) {
        return f4 < f2 ? i2 : f4 > f3 ? i3 : (int) n(i2, i3, (f4 - f2) / (f3 - f2));
    }

    public static e.j.a.c.z.o r(e.j.a.c.z.o oVar, e.j.a.c.z.o oVar2, RectF rectF, RectF rectF2, @FloatRange(from = 0.0d, to = 1.0d) float f2, @FloatRange(from = 0.0d, to = 1.0d) float f3, @FloatRange(from = 0.0d, to = 1.0d) float f4) {
        return f4 < f2 ? oVar : f4 > f3 ? oVar2 : B(oVar, oVar2, rectF, new b(rectF, rectF2, f2, f3, f4));
    }

    public static void s(TransitionSet transitionSet, @Nullable Transition transition) {
        if (transition != null) {
            transitionSet.addTransition(transition);
        }
    }

    public static boolean t(Transition transition, Context context, @AttrRes int i2) {
        int e2;
        if (i2 == 0 || transition.getDuration() != -1 || (e2 = e.j.a.c.w.b.e(context, i2, -1)) == -1) {
            return false;
        }
        transition.setDuration(e2);
        return true;
    }

    public static boolean u(Transition transition, Context context, @AttrRes int i2, TimeInterpolator timeInterpolator) {
        if (i2 == 0 || transition.getInterpolator() != null) {
            return false;
        }
        transition.setInterpolator(x(context, i2, timeInterpolator));
        return true;
    }

    public static boolean v(Transition transition, Context context, @AttrRes int i2) {
        PathMotion y;
        if (i2 == 0 || (y = y(context, i2)) == null) {
            return false;
        }
        transition.setPathMotion(y);
        return true;
    }

    public static void w(TransitionSet transitionSet, @Nullable Transition transition) {
        if (transition != null) {
            transitionSet.removeTransition(transition);
        }
    }

    public static TimeInterpolator x(Context context, @AttrRes int i2, @NonNull TimeInterpolator timeInterpolator) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i2, typedValue, true)) {
            if (typedValue.type == 3) {
                String valueOf = String.valueOf(typedValue.string);
                if (l(valueOf, f10754c)) {
                    String[] split = h(valueOf, f10754c).split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    if (split.length == 4) {
                        return PathInterpolatorCompat.create(g(split, 0), g(split, 1), g(split, 2), g(split, 3));
                    }
                    throw new IllegalArgumentException("Motion easing theme attribute must have 4 control points if using bezier curve format; instead got: " + split.length);
                } else if (l(valueOf, f10755d)) {
                    return PathInterpolatorCompat.create(PathParser.createPathFromPathData(h(valueOf, f10755d)));
                } else {
                    throw new IllegalArgumentException("Invalid motion easing type: " + valueOf);
                }
            }
            throw new IllegalArgumentException("Motion easing theme attribute must be a string");
        }
        return timeInterpolator;
    }

    @Nullable
    public static PathMotion y(Context context, @AttrRes int i2) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i2, typedValue, true)) {
            int i3 = typedValue.type;
            if (i3 != 16) {
                if (i3 == 3) {
                    return new PatternPathMotion(PathParser.createPathFromPathData(String.valueOf(typedValue.string)));
                }
                throw new IllegalArgumentException("Motion path theme attribute must either be an enum value or path data string");
            }
            int i4 = typedValue.data;
            if (i4 == 0) {
                return null;
            }
            if (i4 == 1) {
                return new k();
            }
            throw new IllegalArgumentException("Invalid motion path type: " + i4);
        }
        return null;
    }

    private static int z(Canvas canvas, Rect rect, int i2) {
        RectF rectF = f10760i;
        rectF.set(rect);
        if (Build.VERSION.SDK_INT >= 21) {
            return canvas.saveLayerAlpha(rectF, i2);
        }
        return canvas.saveLayerAlpha(rectF.left, rectF.top, rectF.right, rectF.bottom, i2, 31);
    }
}
