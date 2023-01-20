package e.j.a.c.h0;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;
import e.j.a.c.h0.l;

/* loaded from: classes2.dex */
public class j {
    private final Path a = new Path();
    private final Path b = new Path();

    /* renamed from: c  reason: collision with root package name */
    private final Path f10700c = new Path();

    /* renamed from: d  reason: collision with root package name */
    private final e.j.a.c.z.p f10701d = e.j.a.c.z.p.k();

    /* renamed from: e  reason: collision with root package name */
    private e.j.a.c.z.o f10702e;

    public void a(Canvas canvas) {
        if (Build.VERSION.SDK_INT >= 23) {
            canvas.clipPath(this.a);
            return;
        }
        canvas.clipPath(this.b);
        canvas.clipPath(this.f10700c, Region.Op.UNION);
    }

    public void b(float f2, e.j.a.c.z.o oVar, e.j.a.c.z.o oVar2, RectF rectF, RectF rectF2, RectF rectF3, l.e eVar) {
        e.j.a.c.z.o r = u.r(oVar, oVar2, rectF, rectF3, eVar.d(), eVar.c(), f2);
        this.f10702e = r;
        this.f10701d.d(r, 1.0f, rectF2, this.b);
        this.f10701d.d(this.f10702e, 1.0f, rectF3, this.f10700c);
        if (Build.VERSION.SDK_INT >= 23) {
            this.a.op(this.b, this.f10700c, Path.Op.UNION);
        }
    }

    public e.j.a.c.z.o c() {
        return this.f10702e;
    }

    public Path d() {
        return this.a;
    }
}
