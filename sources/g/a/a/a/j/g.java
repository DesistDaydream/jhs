package g.a.a.a.j;

import androidx.annotation.NonNull;
import java.security.MessageDigest;
import jp.co.cyberagent.android.gpuimage.filter.GPUImageSepiaToneFilter;

/* loaded from: classes3.dex */
public class g extends c {

    /* renamed from: h  reason: collision with root package name */
    private static final int f14799h = 1;

    /* renamed from: i  reason: collision with root package name */
    private static final String f14800i = "jp.wasabeef.glide.transformations.gpu.SepiaFilterTransformation.1";

    /* renamed from: g  reason: collision with root package name */
    private final float f14801g;

    public g() {
        this(1.0f);
    }

    @Override // g.a.a.a.j.c, g.a.a.a.a, e.b.a.p.c
    public boolean equals(Object o) {
        return o instanceof g;
    }

    @Override // g.a.a.a.j.c, g.a.a.a.a, e.b.a.p.c
    public int hashCode() {
        return 895516065 + ((int) (this.f14801g * 10.0f));
    }

    @Override // g.a.a.a.j.c
    public String toString() {
        return "SepiaFilterTransformation(intensity=" + this.f14801g + ")";
    }

    @Override // g.a.a.a.j.c, g.a.a.a.a, e.b.a.p.c
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update((f14800i + this.f14801g).getBytes(e.b.a.p.c.b));
    }

    public g(float intensity) {
        super(new GPUImageSepiaToneFilter());
        this.f14801g = intensity;
        ((GPUImageSepiaToneFilter) c()).setIntensity(intensity);
    }
}
