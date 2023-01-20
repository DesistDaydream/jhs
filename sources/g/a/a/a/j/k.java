package g.a.a.a.j;

import android.graphics.PointF;
import androidx.annotation.NonNull;
import java.security.MessageDigest;
import java.util.Arrays;
import jp.co.cyberagent.android.gpuimage.filter.GPUImageVignetteFilter;

/* loaded from: classes3.dex */
public class k extends c {

    /* renamed from: k  reason: collision with root package name */
    private static final int f14813k = 1;

    /* renamed from: l  reason: collision with root package name */
    private static final String f14814l = "jp.wasabeef.glide.transformations.gpu.VignetteFilterTransformation.1";

    /* renamed from: g  reason: collision with root package name */
    private final PointF f14815g;

    /* renamed from: h  reason: collision with root package name */
    private final float[] f14816h;

    /* renamed from: i  reason: collision with root package name */
    private final float f14817i;

    /* renamed from: j  reason: collision with root package name */
    private final float f14818j;

    public k() {
        this(new PointF(0.5f, 0.5f), new float[]{0.0f, 0.0f, 0.0f}, 0.0f, 0.75f);
    }

    @Override // g.a.a.a.j.c, g.a.a.a.a, e.b.a.p.c
    public boolean equals(Object o) {
        if (o instanceof k) {
            k kVar = (k) o;
            PointF pointF = kVar.f14815g;
            PointF pointF2 = this.f14815g;
            if (pointF.equals(pointF2.x, pointF2.y) && Arrays.equals(kVar.f14816h, this.f14816h) && kVar.f14817i == this.f14817i && kVar.f14818j == this.f14818j) {
                return true;
            }
        }
        return false;
    }

    @Override // g.a.a.a.j.c, g.a.a.a.a, e.b.a.p.c
    public int hashCode() {
        return 1874002103 + this.f14815g.hashCode() + Arrays.hashCode(this.f14816h) + ((int) (this.f14817i * 100.0f)) + ((int) (this.f14818j * 10.0f));
    }

    @Override // g.a.a.a.j.c
    public String toString() {
        return "VignetteFilterTransformation(center=" + this.f14815g.toString() + ",color=" + Arrays.toString(this.f14816h) + ",start=" + this.f14817i + ",end=" + this.f14818j + ")";
    }

    @Override // g.a.a.a.j.c, g.a.a.a.a, e.b.a.p.c
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update((f14814l + this.f14815g + Arrays.hashCode(this.f14816h) + this.f14817i + this.f14818j).getBytes(e.b.a.p.c.b));
    }

    public k(PointF center, float[] color, float start, float end) {
        super(new GPUImageVignetteFilter());
        this.f14815g = center;
        this.f14816h = color;
        this.f14817i = start;
        this.f14818j = end;
        GPUImageVignetteFilter gPUImageVignetteFilter = (GPUImageVignetteFilter) c();
        gPUImageVignetteFilter.setVignetteCenter(center);
        gPUImageVignetteFilter.setVignetteColor(color);
        gPUImageVignetteFilter.setVignetteStart(start);
        gPUImageVignetteFilter.setVignetteEnd(end);
    }
}
