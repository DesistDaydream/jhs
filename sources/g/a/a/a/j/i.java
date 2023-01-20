package g.a.a.a.j;

import android.graphics.PointF;
import androidx.annotation.NonNull;
import java.security.MessageDigest;
import jp.co.cyberagent.android.gpuimage.filter.GPUImageSwirlFilter;

/* loaded from: classes3.dex */
public class i extends c {

    /* renamed from: j  reason: collision with root package name */
    private static final int f14804j = 1;

    /* renamed from: k  reason: collision with root package name */
    private static final String f14805k = "jp.wasabeef.glide.transformations.gpu.SwirlFilterTransformation.1";

    /* renamed from: g  reason: collision with root package name */
    private final float f14806g;

    /* renamed from: h  reason: collision with root package name */
    private final float f14807h;

    /* renamed from: i  reason: collision with root package name */
    private final PointF f14808i;

    public i() {
        this(0.5f, 1.0f, new PointF(0.5f, 0.5f));
    }

    @Override // g.a.a.a.j.c, g.a.a.a.a, e.b.a.p.c
    public boolean equals(Object o) {
        if (o instanceof i) {
            i iVar = (i) o;
            float f2 = iVar.f14806g;
            float f3 = this.f14806g;
            if (f2 == f3 && iVar.f14807h == f3) {
                PointF pointF = iVar.f14808i;
                PointF pointF2 = this.f14808i;
                if (pointF.equals(pointF2.x, pointF2.y)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // g.a.a.a.j.c, g.a.a.a.a, e.b.a.p.c
    public int hashCode() {
        return (-981084566) + ((int) (this.f14806g * 1000.0f)) + ((int) (this.f14807h * 10.0f)) + this.f14808i.hashCode();
    }

    @Override // g.a.a.a.j.c
    public String toString() {
        return "SwirlFilterTransformation(radius=" + this.f14806g + ",angle=" + this.f14807h + ",center=" + this.f14808i.toString() + ")";
    }

    @Override // g.a.a.a.j.c, g.a.a.a.a, e.b.a.p.c
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update((f14805k + this.f14806g + this.f14807h + this.f14808i.hashCode()).getBytes(e.b.a.p.c.b));
    }

    public i(float radius, float angle, PointF center) {
        super(new GPUImageSwirlFilter());
        this.f14806g = radius;
        this.f14807h = angle;
        this.f14808i = center;
        GPUImageSwirlFilter gPUImageSwirlFilter = (GPUImageSwirlFilter) c();
        gPUImageSwirlFilter.setRadius(radius);
        gPUImageSwirlFilter.setAngle(angle);
        gPUImageSwirlFilter.setCenter(center);
    }
}
