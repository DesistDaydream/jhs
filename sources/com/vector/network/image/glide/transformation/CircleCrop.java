package com.vector.network.image.glide.transformation;

import android.graphics.Bitmap;
import androidx.annotation.ColorInt;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.vector.ext.BitmapKt;
import e.b.a.p.c;
import e.b.a.p.m.d.d0;
import h.k2.v.f0;
import h.k2.v.u;
import java.security.MessageDigest;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0096\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0016J*\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005H\u0014J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/vector/network/image/glide/transformation/CircleCrop;", "Lcom/vector/network/image/glide/transformation/BaseBitmapTransformation;", "borderWidth", "", "borderColor", "", "(FI)V", "equals", "", "other", "", TTDownloadField.TT_HASHCODE, "transform", "Landroid/graphics/Bitmap;", "pool", "Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;", "toTransform", "outWidth", "outHeight", "updateDiskCacheKey", "", "messageDigest", "Ljava/security/MessageDigest;", "Companion", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class CircleCrop extends e.t.r.a.l.f.a {

    /* renamed from: f  reason: collision with root package name */
    private static final int f7827f = 1;

    /* renamed from: c  reason: collision with root package name */
    private final float f7830c;

    /* renamed from: d  reason: collision with root package name */
    private final int f7831d;
    @d

    /* renamed from: e  reason: collision with root package name */
    public static final a f7826e = new a(null);
    @d

    /* renamed from: g  reason: collision with root package name */
    private static final String f7828g = "com.vector.glide.transformation.circleCrop.1";
    @d

    /* renamed from: h  reason: collision with root package name */
    private static final byte[] f7829h = f7828g.getBytes(c.b);

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/vector/network/image/glide/transformation/CircleCrop$Companion;", "", "()V", "ID", "", "ID_BYTES", "", "VERSION", "", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    public CircleCrop(float f2, @ColorInt int i2) {
        this.f7830c = f2;
        this.f7831d = i2;
    }

    @Override // e.b.a.p.m.d.h
    @e
    public Bitmap a(@d e.b.a.p.k.x.e eVar, @d Bitmap bitmap, int i2, int i3) {
        Bitmap b = b(eVar, bitmap);
        Bitmap d2 = d0.d(eVar, bitmap, i2, i3);
        if (this.f7830c > 0.0f) {
            d0.i().lock();
            try {
                BitmapKt.a(d2, new CircleCrop$transform$1(this, i2, i3));
            } finally {
                d0.i().unlock();
            }
        }
        if (!f0.g(b, bitmap)) {
            eVar.d(b);
        }
        return d2;
    }

    @Override // e.b.a.p.c
    public boolean equals(@e Object obj) {
        if (this != obj) {
            if (!f0.g(CircleCrop.class, obj == null ? null : obj.getClass())) {
                if (!(obj instanceof CircleCrop)) {
                    return false;
                }
                CircleCrop circleCrop = (CircleCrop) obj;
                if (!(circleCrop.f7830c == this.f7830c) || circleCrop.f7831d != this.f7831d) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // e.b.a.p.c
    public int hashCode() {
        return -369254111;
    }

    @Override // e.b.a.p.c
    public void updateDiskCacheKey(@d MessageDigest messageDigest) {
        messageDigest.update(f7829h);
    }
}
