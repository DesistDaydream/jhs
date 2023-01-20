package g.a.a.a.j;

import androidx.annotation.NonNull;
import java.security.MessageDigest;
import jp.co.cyberagent.android.gpuimage.filter.GPUImageToonFilter;

/* loaded from: classes3.dex */
public class j extends c {

    /* renamed from: i  reason: collision with root package name */
    private static final int f14809i = 1;

    /* renamed from: j  reason: collision with root package name */
    private static final String f14810j = "jp.wasabeef.glide.transformations.gpu.ToonFilterTransformation.1";

    /* renamed from: g  reason: collision with root package name */
    private final float f14811g;

    /* renamed from: h  reason: collision with root package name */
    private final float f14812h;

    public j() {
        this(0.2f, 10.0f);
    }

    @Override // g.a.a.a.j.c, g.a.a.a.a, e.b.a.p.c
    public boolean equals(Object o) {
        if (o instanceof j) {
            j jVar = (j) o;
            if (jVar.f14811g == this.f14811g && jVar.f14812h == this.f14812h) {
                return true;
            }
        }
        return false;
    }

    @Override // g.a.a.a.j.c, g.a.a.a.a, e.b.a.p.c
    public int hashCode() {
        return 1209810327 + ((int) (this.f14811g * 1000.0f)) + ((int) (this.f14812h * 10.0f));
    }

    @Override // g.a.a.a.j.c
    public String toString() {
        return "ToonFilterTransformation(threshold=" + this.f14811g + ",quantizationLevels=" + this.f14812h + ")";
    }

    @Override // g.a.a.a.j.c, g.a.a.a.a, e.b.a.p.c
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update((f14810j + this.f14811g + this.f14812h).getBytes(e.b.a.p.c.b));
    }

    public j(float threshold, float quantizationLevels) {
        super(new GPUImageToonFilter());
        this.f14811g = threshold;
        this.f14812h = quantizationLevels;
        GPUImageToonFilter gPUImageToonFilter = (GPUImageToonFilter) c();
        gPUImageToonFilter.setThreshold(threshold);
        gPUImageToonFilter.setQuantizationLevels(quantizationLevels);
    }
}
