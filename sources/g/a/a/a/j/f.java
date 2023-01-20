package g.a.a.a.j;

import androidx.annotation.NonNull;
import java.security.MessageDigest;
import jp.co.cyberagent.android.gpuimage.filter.GPUImagePixelationFilter;

/* loaded from: classes3.dex */
public class f extends c {

    /* renamed from: h  reason: collision with root package name */
    private static final int f14796h = 1;

    /* renamed from: i  reason: collision with root package name */
    private static final String f14797i = "jp.wasabeef.glide.transformations.gpu.PixelationFilterTransformation.1";

    /* renamed from: g  reason: collision with root package name */
    private final float f14798g;

    public f() {
        this(10.0f);
    }

    @Override // g.a.a.a.j.c, g.a.a.a.a, e.b.a.p.c
    public boolean equals(Object o) {
        return o instanceof f;
    }

    @Override // g.a.a.a.j.c, g.a.a.a.a, e.b.a.p.c
    public int hashCode() {
        return 1525023660 + ((int) (this.f14798g * 10.0f));
    }

    @Override // g.a.a.a.j.c
    public String toString() {
        return "PixelationFilterTransformation(pixel=" + this.f14798g + ")";
    }

    @Override // g.a.a.a.j.c, g.a.a.a.a, e.b.a.p.c
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update((f14797i + this.f14798g).getBytes(e.b.a.p.c.b));
    }

    public f(float pixel) {
        super(new GPUImagePixelationFilter());
        this.f14798g = pixel;
        ((GPUImagePixelationFilter) c()).setPixel(pixel);
    }
}
