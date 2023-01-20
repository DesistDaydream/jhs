package g.a.a.a.j;

import androidx.annotation.NonNull;
import java.security.MessageDigest;
import jp.co.cyberagent.android.gpuimage.filter.GPUImageColorInvertFilter;

/* loaded from: classes3.dex */
public class d extends c {

    /* renamed from: g  reason: collision with root package name */
    private static final int f14791g = 1;

    /* renamed from: h  reason: collision with root package name */
    private static final String f14792h = "jp.wasabeef.glide.transformations.gpu.InvertFilterTransformation.1";

    public d() {
        super(new GPUImageColorInvertFilter());
    }

    @Override // g.a.a.a.j.c, g.a.a.a.a, e.b.a.p.c
    public boolean equals(Object o) {
        return o instanceof d;
    }

    @Override // g.a.a.a.j.c, g.a.a.a.a, e.b.a.p.c
    public int hashCode() {
        return 2014901395;
    }

    @Override // g.a.a.a.j.c
    public String toString() {
        return "InvertFilterTransformation()";
    }

    @Override // g.a.a.a.j.c, g.a.a.a.a, e.b.a.p.c
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f14792h.getBytes(e.b.a.p.c.b));
    }
}
