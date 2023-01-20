package g.a.a.a.j;

import androidx.annotation.NonNull;
import java.security.MessageDigest;
import jp.co.cyberagent.android.gpuimage.filter.GPUImageKuwaharaFilter;

/* loaded from: classes3.dex */
public class e extends c {

    /* renamed from: h  reason: collision with root package name */
    private static final int f14793h = 1;

    /* renamed from: i  reason: collision with root package name */
    private static final String f14794i = "jp.wasabeef.glide.transformations.gpu.KuwaharaFilterTransformation.1";

    /* renamed from: g  reason: collision with root package name */
    private final int f14795g;

    public e() {
        this(25);
    }

    @Override // g.a.a.a.j.c, g.a.a.a.a, e.b.a.p.c
    public boolean equals(Object o) {
        return o instanceof e;
    }

    @Override // g.a.a.a.j.c, g.a.a.a.a, e.b.a.p.c
    public int hashCode() {
        return (-1859800423) + (this.f14795g * 10);
    }

    @Override // g.a.a.a.j.c
    public String toString() {
        return "KuwaharaFilterTransformation(radius=" + this.f14795g + ")";
    }

    @Override // g.a.a.a.j.c, g.a.a.a.a, e.b.a.p.c
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update((f14794i + this.f14795g).getBytes(e.b.a.p.c.b));
    }

    public e(int radius) {
        super(new GPUImageKuwaharaFilter());
        this.f14795g = radius;
        ((GPUImageKuwaharaFilter) c()).setRadius(radius);
    }
}
