package com.vector.network.image.glide.transformation;

import android.graphics.Bitmap;
import androidx.annotation.DrawableRes;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.vector.ext.BitmapKt;
import e.b.a.p.c;
import e.b.a.p.k.x.e;
import h.k2.v.f0;
import h.k2.v.u;
import java.security.MessageDigest;
import k.e.a.d;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0096\u0002J\b\u0010\u000b\u001a\u00020\u0003H\u0016J(\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0003H\u0014J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0018"}, d2 = {"Lcom/vector/network/image/glide/transformation/IrregularCrop;", "Lcom/vector/network/image/glide/transformation/BaseBitmapTransformation;", "resId", "", "(I)V", "getResId", "()I", "equals", "", "other", "", TTDownloadField.TT_HASHCODE, "transform", "Landroid/graphics/Bitmap;", "pool", "Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;", "toTransform", "outWidth", "outHeight", "updateDiskCacheKey", "", "messageDigest", "Ljava/security/MessageDigest;", "Companion", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class IrregularCrop extends e.t.r.a.l.f.a {

    /* renamed from: e  reason: collision with root package name */
    private static final int f7833e = 1;

    /* renamed from: c  reason: collision with root package name */
    private final int f7836c;
    @d

    /* renamed from: d  reason: collision with root package name */
    public static final a f7832d = new a(null);
    @d

    /* renamed from: f  reason: collision with root package name */
    private static final String f7834f = "glide.transformations.IrregularCrop.1";
    @d

    /* renamed from: g  reason: collision with root package name */
    private static final byte[] f7835g = f7834f.getBytes(c.b);

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/vector/network/image/glide/transformation/IrregularCrop$Companion;", "", "()V", "ID", "", "ID_BYTES", "", "VERSION", "", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    public IrregularCrop(@DrawableRes int i2) {
        this.f7836c = i2;
    }

    @Override // e.b.a.p.m.d.h
    @d
    public Bitmap a(@d e eVar, @d Bitmap bitmap, int i2, int i3) {
        Bitmap b = b(eVar, bitmap);
        Bitmap f2 = eVar.f(i2, i3, Bitmap.Config.ARGB_8888);
        BitmapKt.a(f2, new IrregularCrop$transform$1(this, i2, i3, bitmap));
        if (!f0.g(b, bitmap)) {
            eVar.d(b);
        }
        return f2;
    }

    public final int d() {
        return this.f7836c;
    }

    @Override // e.b.a.p.c
    public boolean equals(@k.e.a.e Object obj) {
        return obj instanceof IrregularCrop;
    }

    @Override // e.b.a.p.c
    public int hashCode() {
        return -1361970503;
    }

    @Override // e.b.a.p.c
    public void updateDiskCacheKey(@d MessageDigest messageDigest) {
        messageDigest.update(f7835g);
    }
}
