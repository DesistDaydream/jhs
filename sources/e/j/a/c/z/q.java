package e.j.a.c.z;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class q {

    /* renamed from: j  reason: collision with root package name */
    private static final float f11166j = 270.0f;

    /* renamed from: k  reason: collision with root package name */
    public static final float f11167k = 180.0f;
    @Deprecated
    public float a;
    @Deprecated
    public float b;
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    public float f11168c;
    @Deprecated

    /* renamed from: d  reason: collision with root package name */
    public float f11169d;
    @Deprecated

    /* renamed from: e  reason: collision with root package name */
    public float f11170e;
    @Deprecated

    /* renamed from: f  reason: collision with root package name */
    public float f11171f;

    /* renamed from: g  reason: collision with root package name */
    private final List<g> f11172g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    private final List<i> f11173h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    private boolean f11174i;

    /* loaded from: classes2.dex */
    public class a extends i {
        public final /* synthetic */ List b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Matrix f11175c;

        public a(List list, Matrix matrix) {
            this.b = list;
            this.f11175c = matrix;
        }

        @Override // e.j.a.c.z.q.i
        public void a(Matrix matrix, e.j.a.c.y.b bVar, int i2, Canvas canvas) {
            for (i iVar : this.b) {
                iVar.a(this.f11175c, bVar, i2, canvas);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b extends i {
        private final d b;

        public b(d dVar) {
            this.b = dVar;
        }

        @Override // e.j.a.c.z.q.i
        public void a(Matrix matrix, @NonNull e.j.a.c.y.b bVar, int i2, @NonNull Canvas canvas) {
            bVar.a(canvas, matrix, new RectF(this.b.k(), this.b.o(), this.b.l(), this.b.j()), i2, this.b.m(), this.b.n());
        }
    }

    /* loaded from: classes2.dex */
    public static class c extends i {
        private final f b;

        /* renamed from: c  reason: collision with root package name */
        private final float f11177c;

        /* renamed from: d  reason: collision with root package name */
        private final float f11178d;

        public c(f fVar, float f2, float f3) {
            this.b = fVar;
            this.f11177c = f2;
            this.f11178d = f3;
        }

        @Override // e.j.a.c.z.q.i
        public void a(Matrix matrix, @NonNull e.j.a.c.y.b bVar, int i2, @NonNull Canvas canvas) {
            RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot(this.b.f11190c - this.f11178d, this.b.b - this.f11177c), 0.0f);
            Matrix matrix2 = new Matrix(matrix);
            matrix2.preTranslate(this.f11177c, this.f11178d);
            matrix2.preRotate(c());
            bVar.b(canvas, matrix2, rectF, i2);
        }

        public float c() {
            return (float) Math.toDegrees(Math.atan((this.b.f11190c - this.f11178d) / (this.b.b - this.f11177c)));
        }
    }

    /* loaded from: classes2.dex */
    public static class d extends g {

        /* renamed from: h  reason: collision with root package name */
        private static final RectF f11179h = new RectF();
        @Deprecated
        public float b;
        @Deprecated

        /* renamed from: c  reason: collision with root package name */
        public float f11180c;
        @Deprecated

        /* renamed from: d  reason: collision with root package name */
        public float f11181d;
        @Deprecated

        /* renamed from: e  reason: collision with root package name */
        public float f11182e;
        @Deprecated

        /* renamed from: f  reason: collision with root package name */
        public float f11183f;
        @Deprecated

        /* renamed from: g  reason: collision with root package name */
        public float f11184g;

        public d(float f2, float f3, float f4, float f5) {
            q(f2);
            u(f3);
            r(f4);
            p(f5);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float j() {
            return this.f11182e;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float k() {
            return this.b;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float l() {
            return this.f11181d;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float m() {
            return this.f11183f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float n() {
            return this.f11184g;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float o() {
            return this.f11180c;
        }

        private void p(float f2) {
            this.f11182e = f2;
        }

        private void q(float f2) {
            this.b = f2;
        }

        private void r(float f2) {
            this.f11181d = f2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s(float f2) {
            this.f11183f = f2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void t(float f2) {
            this.f11184g = f2;
        }

        private void u(float f2) {
            this.f11180c = f2;
        }

        @Override // e.j.a.c.z.q.g
        public void a(@NonNull Matrix matrix, @NonNull Path path) {
            Matrix matrix2 = this.a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            RectF rectF = f11179h;
            rectF.set(k(), o(), l(), j());
            path.arcTo(rectF, m(), n(), false);
            path.transform(matrix);
        }
    }

    /* loaded from: classes2.dex */
    public static class e extends g {
        private float b;

        /* renamed from: c  reason: collision with root package name */
        private float f11185c;

        /* renamed from: d  reason: collision with root package name */
        private float f11186d;

        /* renamed from: e  reason: collision with root package name */
        private float f11187e;

        /* renamed from: f  reason: collision with root package name */
        private float f11188f;

        /* renamed from: g  reason: collision with root package name */
        private float f11189g;

        public e(float f2, float f3, float f4, float f5, float f6, float f7) {
            h(f2);
            j(f3);
            i(f4);
            k(f5);
            l(f6);
            m(f7);
        }

        private float b() {
            return this.b;
        }

        private float c() {
            return this.f11186d;
        }

        private float d() {
            return this.f11185c;
        }

        private float e() {
            return this.f11185c;
        }

        private float f() {
            return this.f11188f;
        }

        private float g() {
            return this.f11189g;
        }

        private void h(float f2) {
            this.b = f2;
        }

        private void i(float f2) {
            this.f11186d = f2;
        }

        private void j(float f2) {
            this.f11185c = f2;
        }

        private void k(float f2) {
            this.f11187e = f2;
        }

        private void l(float f2) {
            this.f11188f = f2;
        }

        private void m(float f2) {
            this.f11189g = f2;
        }

        @Override // e.j.a.c.z.q.g
        public void a(@NonNull Matrix matrix, @NonNull Path path) {
            Matrix matrix2 = this.a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.cubicTo(this.b, this.f11185c, this.f11186d, this.f11187e, this.f11188f, this.f11189g);
            path.transform(matrix);
        }
    }

    /* loaded from: classes2.dex */
    public static class f extends g {
        private float b;

        /* renamed from: c  reason: collision with root package name */
        private float f11190c;

        @Override // e.j.a.c.z.q.g
        public void a(@NonNull Matrix matrix, @NonNull Path path) {
            Matrix matrix2 = this.a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.b, this.f11190c);
            path.transform(matrix);
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class g {
        public final Matrix a = new Matrix();

        public abstract void a(Matrix matrix, Path path);
    }

    /* loaded from: classes2.dex */
    public static class h extends g {
        @Deprecated
        public float b;
        @Deprecated

        /* renamed from: c  reason: collision with root package name */
        public float f11191c;
        @Deprecated

        /* renamed from: d  reason: collision with root package name */
        public float f11192d;
        @Deprecated

        /* renamed from: e  reason: collision with root package name */
        public float f11193e;

        private float f() {
            return this.b;
        }

        private float g() {
            return this.f11191c;
        }

        private float h() {
            return this.f11192d;
        }

        private float i() {
            return this.f11193e;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(float f2) {
            this.b = f2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k(float f2) {
            this.f11191c = f2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void l(float f2) {
            this.f11192d = f2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void m(float f2) {
            this.f11193e = f2;
        }

        @Override // e.j.a.c.z.q.g
        public void a(@NonNull Matrix matrix, @NonNull Path path) {
            Matrix matrix2 = this.a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.quadTo(f(), g(), h(), i());
            path.transform(matrix);
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class i {
        public static final Matrix a = new Matrix();

        public abstract void a(Matrix matrix, e.j.a.c.y.b bVar, int i2, Canvas canvas);

        public final void b(e.j.a.c.y.b bVar, int i2, Canvas canvas) {
            a(a, bVar, i2, canvas);
        }
    }

    public q() {
        p(0.0f, 0.0f);
    }

    private void b(float f2) {
        if (h() == f2) {
            return;
        }
        float h2 = ((f2 - h()) + 360.0f) % 360.0f;
        if (h2 > 180.0f) {
            return;
        }
        d dVar = new d(j(), k(), j(), k());
        dVar.s(h());
        dVar.t(h2);
        this.f11173h.add(new b(dVar));
        r(f2);
    }

    private void c(i iVar, float f2, float f3) {
        b(f2);
        this.f11173h.add(iVar);
        r(f3);
    }

    private float h() {
        return this.f11170e;
    }

    private float i() {
        return this.f11171f;
    }

    private void r(float f2) {
        this.f11170e = f2;
    }

    private void s(float f2) {
        this.f11171f = f2;
    }

    private void t(float f2) {
        this.f11168c = f2;
    }

    private void u(float f2) {
        this.f11169d = f2;
    }

    private void v(float f2) {
        this.a = f2;
    }

    private void w(float f2) {
        this.b = f2;
    }

    public void a(float f2, float f3, float f4, float f5, float f6, float f7) {
        d dVar = new d(f2, f3, f4, f5);
        dVar.s(f6);
        dVar.t(f7);
        this.f11172g.add(dVar);
        b bVar = new b(dVar);
        float f8 = f6 + f7;
        boolean z = f7 < 0.0f;
        if (z) {
            f6 = (f6 + 180.0f) % 360.0f;
        }
        c(bVar, f6, z ? (180.0f + f8) % 360.0f : f8);
        double d2 = f8;
        t(((f2 + f4) * 0.5f) + (((f4 - f2) / 2.0f) * ((float) Math.cos(Math.toRadians(d2)))));
        u(((f3 + f5) * 0.5f) + (((f5 - f3) / 2.0f) * ((float) Math.sin(Math.toRadians(d2)))));
    }

    public void d(Matrix matrix, Path path) {
        int size = this.f11172g.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f11172g.get(i2).a(matrix, path);
        }
    }

    public boolean e() {
        return this.f11174i;
    }

    @NonNull
    public i f(Matrix matrix) {
        b(i());
        return new a(new ArrayList(this.f11173h), new Matrix(matrix));
    }

    @RequiresApi(21)
    public void g(float f2, float f3, float f4, float f5, float f6, float f7) {
        this.f11172g.add(new e(f2, f3, f4, f5, f6, f7));
        this.f11174i = true;
        t(f6);
        u(f7);
    }

    public float j() {
        return this.f11168c;
    }

    public float k() {
        return this.f11169d;
    }

    public float l() {
        return this.a;
    }

    public float m() {
        return this.b;
    }

    public void n(float f2, float f3) {
        f fVar = new f();
        fVar.b = f2;
        fVar.f11190c = f3;
        this.f11172g.add(fVar);
        c cVar = new c(fVar, j(), k());
        c(cVar, cVar.c() + f11166j, cVar.c() + f11166j);
        t(f2);
        u(f3);
    }

    @RequiresApi(21)
    public void o(float f2, float f3, float f4, float f5) {
        h hVar = new h();
        hVar.j(f2);
        hVar.k(f3);
        hVar.l(f4);
        hVar.m(f5);
        this.f11172g.add(hVar);
        this.f11174i = true;
        t(f4);
        u(f5);
    }

    public void p(float f2, float f3) {
        q(f2, f3, f11166j, 0.0f);
    }

    public void q(float f2, float f3, float f4, float f5) {
        v(f2);
        w(f3);
        t(f2);
        u(f3);
        r(f4);
        s((f4 + f5) % 360.0f);
        this.f11172g.clear();
        this.f11173h.clear();
        this.f11174i = false;
    }

    public q(float f2, float f3) {
        p(f2, f3);
    }
}
