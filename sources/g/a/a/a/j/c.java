package g.a.a.a.j;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import java.security.MessageDigest;
import jp.co.cyberagent.android.gpuimage.GPUImage;
import jp.co.cyberagent.android.gpuimage.filter.GPUImageFilter;

/* loaded from: classes3.dex */
public class c extends g.a.a.a.a {

    /* renamed from: d  reason: collision with root package name */
    private static final int f14787d = 1;

    /* renamed from: e  reason: collision with root package name */
    private static final String f14788e = "jp.wasabeef.glide.transformations.gpu.GPUFilterTransformation.1";

    /* renamed from: f  reason: collision with root package name */
    private static final byte[] f14789f = f14788e.getBytes(e.b.a.p.c.b);

    /* renamed from: c  reason: collision with root package name */
    private final GPUImageFilter f14790c;

    public c(GPUImageFilter filter) {
        this.f14790c = filter;
    }

    @Override // g.a.a.a.a
    public Bitmap b(@NonNull Context context, @NonNull e.b.a.p.k.x.e pool, @NonNull Bitmap toTransform, int outWidth, int outHeight) {
        GPUImage gPUImage = new GPUImage(context);
        gPUImage.setImage(toTransform);
        gPUImage.setFilter(this.f14790c);
        return gPUImage.getBitmapWithFilterApplied();
    }

    public <T> T c() {
        return (T) this.f14790c;
    }

    @Override // g.a.a.a.a, e.b.a.p.c
    public boolean equals(Object o) {
        return o instanceof c;
    }

    @Override // g.a.a.a.a, e.b.a.p.c
    public int hashCode() {
        return 1751294359;
    }

    public String toString() {
        return getClass().getSimpleName();
    }

    @Override // g.a.a.a.a, e.b.a.p.c
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f14789f);
    }
}
