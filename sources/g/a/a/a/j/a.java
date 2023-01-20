package g.a.a.a.j;

import androidx.annotation.NonNull;
import java.security.MessageDigest;
import jp.co.cyberagent.android.gpuimage.filter.GPUImageBrightnessFilter;

/* loaded from: classes3.dex */
public class a extends c {

    /* renamed from: h  reason: collision with root package name */
    private static final int f14781h = 1;

    /* renamed from: i  reason: collision with root package name */
    private static final String f14782i = "jp.wasabeef.glide.transformations.gpu.BrightnessFilterTransformation.1";

    /* renamed from: g  reason: collision with root package name */
    private final float f14783g;

    public a() {
        this(0.0f);
    }

    @Override // g.a.a.a.j.c, g.a.a.a.a, e.b.a.p.c
    public boolean equals(Object o) {
        return (o instanceof a) && ((a) o).f14783g == this.f14783g;
    }

    @Override // g.a.a.a.j.c, g.a.a.a.a, e.b.a.p.c
    public int hashCode() {
        return (-1311211954) + ((int) ((this.f14783g + 1.0f) * 10.0f));
    }

    @Override // g.a.a.a.j.c
    public String toString() {
        return "BrightnessFilterTransformation(brightness=" + this.f14783g + ")";
    }

    @Override // g.a.a.a.j.c, g.a.a.a.a, e.b.a.p.c
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update((f14782i + this.f14783g).getBytes(e.b.a.p.c.b));
    }

    public a(float brightness) {
        super(new GPUImageBrightnessFilter());
        this.f14783g = brightness;
        ((GPUImageBrightnessFilter) c()).setBrightness(brightness);
    }
}
