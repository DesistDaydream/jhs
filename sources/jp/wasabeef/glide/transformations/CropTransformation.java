package jp.wasabeef.glide.transformations;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import e.b.a.p.c;
import e.b.a.p.k.x.e;
import java.security.MessageDigest;

/* loaded from: classes3.dex */
public class CropTransformation extends g.a.a.a.a {

    /* renamed from: f  reason: collision with root package name */
    private static final int f16016f = 1;

    /* renamed from: g  reason: collision with root package name */
    private static final String f16017g = "jp.wasabeef.glide.transformations.CropTransformation.1";

    /* renamed from: c  reason: collision with root package name */
    private int f16018c;

    /* renamed from: d  reason: collision with root package name */
    private int f16019d;

    /* renamed from: e  reason: collision with root package name */
    private CropType f16020e;

    /* loaded from: classes3.dex */
    public enum CropType {
        TOP,
        CENTER,
        BOTTOM
    }

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[CropType.values().length];
            a = iArr;
            try {
                iArr[CropType.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[CropType.CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[CropType.BOTTOM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public CropTransformation(int width, int height) {
        this(width, height, CropType.CENTER);
    }

    private float c(float scaledHeight) {
        int i2 = a.a[this.f16020e.ordinal()];
        if (i2 != 2) {
            if (i2 != 3) {
                return 0.0f;
            }
            return this.f16019d - scaledHeight;
        }
        return (this.f16019d - scaledHeight) / 2.0f;
    }

    @Override // g.a.a.a.a
    public Bitmap b(@NonNull Context context, @NonNull e pool, @NonNull Bitmap toTransform, int outWidth, int outHeight) {
        int i2 = this.f16018c;
        if (i2 == 0) {
            i2 = toTransform.getWidth();
        }
        this.f16018c = i2;
        int i3 = this.f16019d;
        if (i3 == 0) {
            i3 = toTransform.getHeight();
        }
        this.f16019d = i3;
        Bitmap f2 = pool.f(this.f16018c, this.f16019d, toTransform.getConfig() != null ? toTransform.getConfig() : Bitmap.Config.ARGB_8888);
        f2.setHasAlpha(true);
        float max = Math.max(this.f16018c / toTransform.getWidth(), this.f16019d / toTransform.getHeight());
        float width = toTransform.getWidth() * max;
        float height = max * toTransform.getHeight();
        float f3 = (this.f16018c - width) / 2.0f;
        float c2 = c(height);
        RectF rectF = new RectF(f3, c2, width + f3, height + c2);
        a(toTransform, f2);
        new Canvas(f2).drawBitmap(toTransform, (Rect) null, rectF, (Paint) null);
        return f2;
    }

    @Override // g.a.a.a.a, e.b.a.p.c
    public boolean equals(Object o) {
        if (o instanceof CropTransformation) {
            CropTransformation cropTransformation = (CropTransformation) o;
            if (cropTransformation.f16018c == this.f16018c && cropTransformation.f16019d == this.f16019d && cropTransformation.f16020e == this.f16020e) {
                return true;
            }
        }
        return false;
    }

    @Override // g.a.a.a.a, e.b.a.p.c
    public int hashCode() {
        return (-1462327117) + (this.f16018c * 100000) + (this.f16019d * 1000) + (this.f16020e.ordinal() * 10);
    }

    public String toString() {
        return "CropTransformation(width=" + this.f16018c + ", height=" + this.f16019d + ", cropType=" + this.f16020e + ")";
    }

    @Override // g.a.a.a.a, e.b.a.p.c
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update((f16017g + this.f16018c + this.f16019d + this.f16020e).getBytes(c.b));
    }

    public CropTransformation(int width, int height, CropType cropType) {
        this.f16020e = CropType.CENTER;
        this.f16018c = width;
        this.f16019d = height;
        this.f16020e = cropType;
    }
}
