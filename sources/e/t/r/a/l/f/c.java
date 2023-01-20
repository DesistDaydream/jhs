package e.t.r.a.l.f;

import android.graphics.Bitmap;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import e.b.a.p.k.x.e;
import e.b.a.p.m.d.h;
import h.k2.v.u;
import java.security.MessageDigest;
import java.util.List;
import k.e.a.d;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0013\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0096\u0002J\b\u0010\n\u001a\u00020\u000bH\u0016J(\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000bH\u0014J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/vector/network/image/glide/transformation/InterceptorTransformation;", "Lcom/bumptech/glide/load/resource/bitmap/BitmapTransformation;", "interceptors", "", "Lcom/vector/network/image/interceptor/Interceptor;", "(Ljava/util/List;)V", "equals", "", "other", "", TTDownloadField.TT_HASHCODE, "", "transform", "Landroid/graphics/Bitmap;", "pool", "Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;", "toTransform", "outWidth", "outHeight", "updateDiskCacheKey", "", "messageDigest", "Ljava/security/MessageDigest;", "Companion", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class c extends h {

    /* renamed from: e  reason: collision with root package name */
    private static final int f14622e = 1;
    @d

    /* renamed from: c  reason: collision with root package name */
    private final List<e.t.r.a.n.c> f14625c;
    @d

    /* renamed from: d  reason: collision with root package name */
    public static final a f14621d = new a(null);
    @d

    /* renamed from: f  reason: collision with root package name */
    private static final String f14623f = "com.vector.glide.transformation.interceptors.1";
    @d

    /* renamed from: g  reason: collision with root package name */
    private static final byte[] f14624g = f14623f.getBytes(e.b.a.p.c.b);

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/vector/network/image/glide/transformation/InterceptorTransformation$Companion;", "", "()V", "ID", "", "ID_BYTES", "", "VERSION", "", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(@d List<? extends e.t.r.a.n.c> list) {
        this.f14625c = list;
    }

    @Override // e.b.a.p.m.d.h
    @d
    public Bitmap a(@d e eVar, @d Bitmap bitmap, int i2, int i3) {
        for (e.t.r.a.n.c cVar : this.f14625c) {
            bitmap = cVar.a(bitmap);
        }
        return bitmap;
    }

    @Override // e.b.a.p.c
    public boolean equals(@k.e.a.e Object obj) {
        return obj instanceof c;
    }

    @Override // e.b.a.p.c
    public int hashCode() {
        return -1980909169;
    }

    @Override // e.b.a.p.c
    public void updateDiskCacheKey(@d MessageDigest messageDigest) {
        messageDigest.update(f14624g);
    }
}
