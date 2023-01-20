package g.a.a.a.j;

import androidx.annotation.NonNull;
import java.security.MessageDigest;
import jp.co.cyberagent.android.gpuimage.filter.GPUImageContrastFilter;

/* loaded from: classes3.dex */
public class b extends c {

    /* renamed from: h  reason: collision with root package name */
    private static final int f14784h = 1;

    /* renamed from: i  reason: collision with root package name */
    private static final String f14785i = "jp.wasabeef.glide.transformations.gpu.ContrastFilterTransformation.1";

    /* renamed from: g  reason: collision with root package name */
    private final float f14786g;

    public b() {
        this(1.0f);
    }

    @Override // g.a.a.a.j.c, g.a.a.a.a, e.b.a.p.c
    public boolean equals(Object o) {
        return o instanceof b;
    }

    @Override // g.a.a.a.j.c, g.a.a.a.a, e.b.a.p.c
    public int hashCode() {
        return (-306633601) + ((int) (this.f14786g * 10.0f));
    }

    @Override // g.a.a.a.j.c
    public String toString() {
        return "ContrastFilterTransformation(contrast=" + this.f14786g + ")";
    }

    @Override // g.a.a.a.j.c, g.a.a.a.a, e.b.a.p.c
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update((f14785i + this.f14786g).getBytes(e.b.a.p.c.b));
    }

    public b(float contrast) {
        super(new GPUImageContrastFilter());
        this.f14786g = contrast;
        ((GPUImageContrastFilter) c()).setContrast(contrast);
    }
}
