package g.a.a.a.j;

import androidx.annotation.NonNull;
import java.security.MessageDigest;
import jp.co.cyberagent.android.gpuimage.filter.GPUImageSketchFilter;

/* loaded from: classes3.dex */
public class h extends c {

    /* renamed from: g  reason: collision with root package name */
    private static final int f14802g = 1;

    /* renamed from: h  reason: collision with root package name */
    private static final String f14803h = "jp.wasabeef.glide.transformations.gpu.SketchFilterTransformation.1";

    public h() {
        super(new GPUImageSketchFilter());
    }

    @Override // g.a.a.a.j.c, g.a.a.a.a, e.b.a.p.c
    public boolean equals(Object o) {
        return o instanceof h;
    }

    @Override // g.a.a.a.j.c, g.a.a.a.a, e.b.a.p.c
    public int hashCode() {
        return -1790215191;
    }

    @Override // g.a.a.a.j.c
    public String toString() {
        return "SketchFilterTransformation()";
    }

    @Override // g.a.a.a.j.c, g.a.a.a.a, e.b.a.p.c
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f14803h.getBytes(e.b.a.p.c.b));
    }
}
