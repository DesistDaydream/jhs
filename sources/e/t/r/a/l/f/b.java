package e.t.r.a.l.f;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Build;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import e.b.a.p.k.x.e;
import e.b.a.p.m.d.d0;
import e.b.a.p.m.d.h;
import h.k2.v.f0;
import h.k2.v.u;
import java.security.MessageDigest;
import k.e.a.d;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u0003H\u0016J(\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0003H\u0014J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/vector/network/image/glide/transformation/CornerTransform;", "Lcom/bumptech/glide/load/resource/bitmap/BitmapTransformation;", "leftTopRadius", "", "rightTopRadius", "rightBottomRadius", "leftBottomRadius", "(IIII)V", "equals", "", "other", "", "getAlphaSafeConfig", "Landroid/graphics/Bitmap$Config;", "inBitmap", "Landroid/graphics/Bitmap;", TTDownloadField.TT_HASHCODE, "transform", "pool", "Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;", "toTransform", "outWidth", "outHeight", "updateDiskCacheKey", "", "messageDigest", "Ljava/security/MessageDigest;", "Companion", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class b extends h {

    /* renamed from: h  reason: collision with root package name */
    private static final int f14614h = 1;

    /* renamed from: c  reason: collision with root package name */
    private final int f14617c;

    /* renamed from: d  reason: collision with root package name */
    private final int f14618d;

    /* renamed from: e  reason: collision with root package name */
    private final int f14619e;

    /* renamed from: f  reason: collision with root package name */
    private final int f14620f;
    @d

    /* renamed from: g  reason: collision with root package name */
    public static final a f14613g = new a(null);
    @d

    /* renamed from: i  reason: collision with root package name */
    private static final String f14615i = "com.vector.glide.transformation.CornerTransform.1";
    @d

    /* renamed from: j  reason: collision with root package name */
    private static final byte[] f14616j = f14615i.getBytes(e.b.a.p.c.b);

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/vector/network/image/glide/transformation/CornerTransform$Companion;", "", "()V", "ID", "", "ID_BYTES", "", "VERSION", "", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    public b() {
        this(0, 0, 0, 0, 15, null);
    }

    public /* synthetic */ b(int i2, int i3, int i4, int i5, int i6, u uVar) {
        this((i6 & 1) != 0 ? 0 : i2, (i6 & 2) != 0 ? 0 : i3, (i6 & 4) != 0 ? 0 : i4, (i6 & 8) != 0 ? 0 : i5);
    }

    private final Bitmap.Config b(Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 26) {
            if (Bitmap.Config.RGBA_F16 == bitmap.getConfig()) {
                return Bitmap.Config.RGBA_F16;
            }
            return Bitmap.Config.ARGB_8888;
        }
        return Bitmap.Config.ARGB_8888;
    }

    @Override // e.b.a.p.m.d.h
    @d
    public Bitmap a(@d e eVar, @d Bitmap bitmap, int i2, int i3) {
        Bitmap b = d0.b(eVar, bitmap, i2, i3);
        Bitmap f2 = eVar.f(b.getWidth(), b.getHeight(), Bitmap.Config.ARGB_8888);
        f2.setHasAlpha(true);
        Canvas canvas = new Canvas(f2);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new BitmapShader(b, tileMode, tileMode));
        RectF rectF = new RectF(0.0f, 0.0f, f2.getWidth(), f2.getHeight());
        Path path = new Path();
        int i4 = this.f14617c;
        int i5 = this.f14618d;
        int i6 = this.f14619e;
        int i7 = this.f14620f;
        path.addRoundRect(rectF, new float[]{i4, i4, i5, i5, i6, i6, i7, i7}, Path.Direction.CW);
        canvas.drawPath(path, paint);
        canvas.setBitmap(null);
        if (!f0.g(b, bitmap)) {
            eVar.d(b);
        }
        return f2;
    }

    @Override // e.b.a.p.c
    public boolean equals(@k.e.a.e Object obj) {
        if (this != obj) {
            if (!f0.g(b.class, obj == null ? null : obj.getClass())) {
                if (!(obj instanceof b)) {
                    return false;
                }
                b bVar = (b) obj;
                if (bVar.f14617c != this.f14617c || bVar.f14618d != this.f14618d || bVar.f14620f != this.f14620f || bVar.f14619e != this.f14619e) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // e.b.a.p.c
    public int hashCode() {
        return 576071516;
    }

    @Override // e.b.a.p.c
    public void updateDiskCacheKey(@d MessageDigest messageDigest) {
        messageDigest.update(f14616j);
    }

    public b(int i2, int i3, int i4, int i5) {
        this.f14617c = i2;
        this.f14618d = i3;
        this.f14619e = i4;
        this.f14620f = i5;
    }
}
