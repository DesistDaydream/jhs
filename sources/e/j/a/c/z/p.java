package e.j.a.c.z;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;

/* loaded from: classes2.dex */
public class p {
    private final q[] a = new q[4];
    private final Matrix[] b = new Matrix[4];

    /* renamed from: c  reason: collision with root package name */
    private final Matrix[] f11153c = new Matrix[4];

    /* renamed from: d  reason: collision with root package name */
    private final PointF f11154d = new PointF();

    /* renamed from: e  reason: collision with root package name */
    private final Path f11155e = new Path();

    /* renamed from: f  reason: collision with root package name */
    private final Path f11156f = new Path();

    /* renamed from: g  reason: collision with root package name */
    private final q f11157g = new q();

    /* renamed from: h  reason: collision with root package name */
    private final float[] f11158h = new float[2];

    /* renamed from: i  reason: collision with root package name */
    private final float[] f11159i = new float[2];

    /* renamed from: j  reason: collision with root package name */
    private final Path f11160j = new Path();

    /* renamed from: k  reason: collision with root package name */
    private final Path f11161k = new Path();

    /* renamed from: l  reason: collision with root package name */
    private boolean f11162l = true;

    /* loaded from: classes2.dex */
    public static class a {
        public static final p a = new p();

        private a() {
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes2.dex */
    public interface b {
        void a(q qVar, Matrix matrix, int i2);

        void b(q qVar, Matrix matrix, int i2);
    }

    /* loaded from: classes2.dex */
    public static final class c {
        @NonNull
        public final o a;
        @NonNull
        public final Path b;
        @NonNull

        /* renamed from: c  reason: collision with root package name */
        public final RectF f11163c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        public final b f11164d;

        /* renamed from: e  reason: collision with root package name */
        public final float f11165e;

        public c(@NonNull o oVar, float f2, RectF rectF, @Nullable b bVar, Path path) {
            this.f11164d = bVar;
            this.a = oVar;
            this.f11165e = f2;
            this.f11163c = rectF;
            this.b = path;
        }
    }

    public p() {
        for (int i2 = 0; i2 < 4; i2++) {
            this.a[i2] = new q();
            this.b[i2] = new Matrix();
            this.f11153c[i2] = new Matrix();
        }
    }

    private float a(int i2) {
        return (i2 + 1) * 90;
    }

    private void b(@NonNull c cVar, int i2) {
        this.f11158h[0] = this.a[i2].l();
        this.f11158h[1] = this.a[i2].m();
        this.b[i2].mapPoints(this.f11158h);
        if (i2 == 0) {
            Path path = cVar.b;
            float[] fArr = this.f11158h;
            path.moveTo(fArr[0], fArr[1]);
        } else {
            Path path2 = cVar.b;
            float[] fArr2 = this.f11158h;
            path2.lineTo(fArr2[0], fArr2[1]);
        }
        this.a[i2].d(this.b[i2], cVar.b);
        b bVar = cVar.f11164d;
        if (bVar != null) {
            bVar.a(this.a[i2], this.b[i2], i2);
        }
    }

    private void c(@NonNull c cVar, int i2) {
        int i3 = (i2 + 1) % 4;
        this.f11158h[0] = this.a[i2].j();
        this.f11158h[1] = this.a[i2].k();
        this.b[i2].mapPoints(this.f11158h);
        this.f11159i[0] = this.a[i3].l();
        this.f11159i[1] = this.a[i3].m();
        this.b[i3].mapPoints(this.f11159i);
        float[] fArr = this.f11158h;
        float f2 = fArr[0];
        float[] fArr2 = this.f11159i;
        float max = Math.max(((float) Math.hypot(f2 - fArr2[0], fArr[1] - fArr2[1])) - 0.001f, 0.0f);
        float i4 = i(cVar.f11163c, i2);
        this.f11157g.p(0.0f, 0.0f);
        g j2 = j(i2, cVar.a);
        j2.b(max, i4, cVar.f11165e, this.f11157g);
        this.f11160j.reset();
        this.f11157g.d(this.f11153c[i2], this.f11160j);
        if (this.f11162l && Build.VERSION.SDK_INT >= 19 && (j2.a() || l(this.f11160j, i2) || l(this.f11160j, i3))) {
            Path path = this.f11160j;
            path.op(path, this.f11156f, Path.Op.DIFFERENCE);
            this.f11158h[0] = this.f11157g.l();
            this.f11158h[1] = this.f11157g.m();
            this.f11153c[i2].mapPoints(this.f11158h);
            Path path2 = this.f11155e;
            float[] fArr3 = this.f11158h;
            path2.moveTo(fArr3[0], fArr3[1]);
            this.f11157g.d(this.f11153c[i2], this.f11155e);
        } else {
            this.f11157g.d(this.f11153c[i2], cVar.b);
        }
        b bVar = cVar.f11164d;
        if (bVar != null) {
            bVar.b(this.f11157g, this.f11153c[i2], i2);
        }
    }

    private void f(int i2, @NonNull RectF rectF, @NonNull PointF pointF) {
        if (i2 == 1) {
            pointF.set(rectF.right, rectF.bottom);
        } else if (i2 == 2) {
            pointF.set(rectF.left, rectF.bottom);
        } else if (i2 != 3) {
            pointF.set(rectF.right, rectF.top);
        } else {
            pointF.set(rectF.left, rectF.top);
        }
    }

    private d g(int i2, @NonNull o oVar) {
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    return oVar.t();
                }
                return oVar.r();
            }
            return oVar.j();
        }
        return oVar.l();
    }

    private e h(int i2, @NonNull o oVar) {
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    return oVar.s();
                }
                return oVar.q();
            }
            return oVar.i();
        }
        return oVar.k();
    }

    private float i(@NonNull RectF rectF, int i2) {
        float[] fArr = this.f11158h;
        q[] qVarArr = this.a;
        fArr[0] = qVarArr[i2].f11168c;
        fArr[1] = qVarArr[i2].f11169d;
        this.b[i2].mapPoints(fArr);
        if (i2 != 1 && i2 != 3) {
            return Math.abs(rectF.centerY() - this.f11158h[1]);
        }
        return Math.abs(rectF.centerX() - this.f11158h[0]);
    }

    private g j(int i2, @NonNull o oVar) {
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    return oVar.o();
                }
                return oVar.p();
            }
            return oVar.n();
        }
        return oVar.h();
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @UiThread
    public static p k() {
        return a.a;
    }

    @RequiresApi(19)
    private boolean l(Path path, int i2) {
        this.f11161k.reset();
        this.a[i2].d(this.b[i2], this.f11161k);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        this.f11161k.computeBounds(rectF, true);
        path.op(this.f11161k, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        if (rectF.isEmpty()) {
            return rectF.width() > 1.0f && rectF.height() > 1.0f;
        }
        return true;
    }

    private void m(@NonNull c cVar, int i2) {
        h(i2, cVar.a).c(this.a[i2], 90.0f, cVar.f11165e, cVar.f11163c, g(i2, cVar.a));
        float a2 = a(i2);
        this.b[i2].reset();
        f(i2, cVar.f11163c, this.f11154d);
        Matrix matrix = this.b[i2];
        PointF pointF = this.f11154d;
        matrix.setTranslate(pointF.x, pointF.y);
        this.b[i2].preRotate(a2);
    }

    private void o(int i2) {
        this.f11158h[0] = this.a[i2].j();
        this.f11158h[1] = this.a[i2].k();
        this.b[i2].mapPoints(this.f11158h);
        float a2 = a(i2);
        this.f11153c[i2].reset();
        Matrix matrix = this.f11153c[i2];
        float[] fArr = this.f11158h;
        matrix.setTranslate(fArr[0], fArr[1]);
        this.f11153c[i2].preRotate(a2);
    }

    public void d(o oVar, float f2, RectF rectF, @NonNull Path path) {
        e(oVar, f2, rectF, null, path);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void e(o oVar, float f2, RectF rectF, b bVar, @NonNull Path path) {
        path.rewind();
        this.f11155e.rewind();
        this.f11156f.rewind();
        this.f11156f.addRect(rectF, Path.Direction.CW);
        c cVar = new c(oVar, f2, rectF, bVar, path);
        for (int i2 = 0; i2 < 4; i2++) {
            m(cVar, i2);
            o(i2);
        }
        for (int i3 = 0; i3 < 4; i3++) {
            b(cVar, i3);
            c(cVar, i3);
        }
        path.close();
        this.f11155e.close();
        if (Build.VERSION.SDK_INT < 19 || this.f11155e.isEmpty()) {
            return;
        }
        path.op(this.f11155e, Path.Op.UNION);
    }

    public void n(boolean z) {
        this.f11162l = z;
    }
}
