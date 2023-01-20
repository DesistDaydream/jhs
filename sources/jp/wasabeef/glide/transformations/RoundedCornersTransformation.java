package jp.wasabeef.glide.transformations;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.annotation.NonNull;
import e.b.a.p.c;
import e.b.a.p.k.x.e;
import java.security.MessageDigest;

/* loaded from: classes3.dex */
public class RoundedCornersTransformation extends g.a.a.a.a {

    /* renamed from: g  reason: collision with root package name */
    private static final int f16021g = 1;

    /* renamed from: h  reason: collision with root package name */
    private static final String f16022h = "jp.wasabeef.glide.transformations.RoundedCornersTransformation.1";

    /* renamed from: c  reason: collision with root package name */
    private final int f16023c;

    /* renamed from: d  reason: collision with root package name */
    private final int f16024d;

    /* renamed from: e  reason: collision with root package name */
    private final int f16025e;

    /* renamed from: f  reason: collision with root package name */
    private final CornerType f16026f;

    /* loaded from: classes3.dex */
    public enum CornerType {
        ALL,
        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM_LEFT,
        BOTTOM_RIGHT,
        TOP,
        BOTTOM,
        LEFT,
        RIGHT,
        OTHER_TOP_LEFT,
        OTHER_TOP_RIGHT,
        OTHER_BOTTOM_LEFT,
        OTHER_BOTTOM_RIGHT,
        DIAGONAL_FROM_TOP_LEFT,
        DIAGONAL_FROM_TOP_RIGHT
    }

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[CornerType.values().length];
            a = iArr;
            try {
                iArr[CornerType.ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[CornerType.TOP_LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[CornerType.TOP_RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[CornerType.BOTTOM_LEFT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[CornerType.BOTTOM_RIGHT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[CornerType.TOP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[CornerType.BOTTOM.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[CornerType.LEFT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[CornerType.RIGHT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[CornerType.OTHER_TOP_LEFT.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[CornerType.OTHER_TOP_RIGHT.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[CornerType.OTHER_BOTTOM_LEFT.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[CornerType.OTHER_BOTTOM_RIGHT.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                a[CornerType.DIAGONAL_FROM_TOP_LEFT.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                a[CornerType.DIAGONAL_FROM_TOP_RIGHT.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
        }
    }

    public RoundedCornersTransformation(int radius, int margin) {
        this(radius, margin, CornerType.ALL);
    }

    private void c(Canvas canvas, Paint paint, float right, float bottom) {
        int i2 = this.f16025e;
        int i3 = this.f16024d;
        RectF rectF = new RectF(i2, bottom - i3, i2 + i3, bottom);
        int i4 = this.f16023c;
        canvas.drawRoundRect(rectF, i4, i4, paint);
        int i5 = this.f16025e;
        canvas.drawRect(new RectF(i5, i5, i5 + this.f16024d, bottom - this.f16023c), paint);
        int i6 = this.f16025e;
        canvas.drawRect(new RectF(this.f16023c + i6, i6, right, bottom), paint);
    }

    private void d(Canvas canvas, Paint paint, float right, float bottom) {
        int i2 = this.f16024d;
        RectF rectF = new RectF(right - i2, bottom - i2, right, bottom);
        int i3 = this.f16023c;
        canvas.drawRoundRect(rectF, i3, i3, paint);
        int i4 = this.f16025e;
        canvas.drawRect(new RectF(i4, i4, right - this.f16023c, bottom), paint);
        int i5 = this.f16023c;
        canvas.drawRect(new RectF(right - i5, this.f16025e, right, bottom - i5), paint);
    }

    private void e(Canvas canvas, Paint paint, float right, float bottom) {
        RectF rectF = new RectF(this.f16025e, bottom - this.f16024d, right, bottom);
        int i2 = this.f16023c;
        canvas.drawRoundRect(rectF, i2, i2, paint);
        int i3 = this.f16025e;
        canvas.drawRect(new RectF(i3, i3, right, bottom - this.f16023c), paint);
    }

    private void f(Canvas canvas, Paint paint, float right, float bottom) {
        int i2 = this.f16025e;
        int i3 = this.f16024d;
        RectF rectF = new RectF(i2, i2, i2 + i3, i2 + i3);
        int i4 = this.f16023c;
        canvas.drawRoundRect(rectF, i4, i4, paint);
        int i5 = this.f16024d;
        RectF rectF2 = new RectF(right - i5, bottom - i5, right, bottom);
        int i6 = this.f16023c;
        canvas.drawRoundRect(rectF2, i6, i6, paint);
        int i7 = this.f16025e;
        int i8 = this.f16023c;
        canvas.drawRect(new RectF(i7, i7 + i8, right - i8, bottom), paint);
        int i9 = this.f16025e;
        int i10 = this.f16023c;
        canvas.drawRect(new RectF(i9 + i10, i9, right, bottom - i10), paint);
    }

    private void g(Canvas canvas, Paint paint, float right, float bottom) {
        int i2 = this.f16024d;
        int i3 = this.f16025e;
        RectF rectF = new RectF(right - i2, i3, right, i3 + i2);
        int i4 = this.f16023c;
        canvas.drawRoundRect(rectF, i4, i4, paint);
        int i5 = this.f16025e;
        int i6 = this.f16024d;
        RectF rectF2 = new RectF(i5, bottom - i6, i5 + i6, bottom);
        int i7 = this.f16023c;
        canvas.drawRoundRect(rectF2, i7, i7, paint);
        int i8 = this.f16025e;
        int i9 = this.f16023c;
        canvas.drawRect(new RectF(i8, i8, right - i9, bottom - i9), paint);
        int i10 = this.f16025e;
        int i11 = this.f16023c;
        canvas.drawRect(new RectF(i10 + i11, i10 + i11, right, bottom), paint);
    }

    private void h(Canvas canvas, Paint paint, float right, float bottom) {
        int i2 = this.f16025e;
        RectF rectF = new RectF(i2, i2, i2 + this.f16024d, bottom);
        int i3 = this.f16023c;
        canvas.drawRoundRect(rectF, i3, i3, paint);
        int i4 = this.f16025e;
        canvas.drawRect(new RectF(this.f16023c + i4, i4, right, bottom), paint);
    }

    private void i(Canvas canvas, Paint paint, float right, float bottom) {
        int i2 = this.f16025e;
        RectF rectF = new RectF(i2, i2, right, i2 + this.f16024d);
        int i3 = this.f16023c;
        canvas.drawRoundRect(rectF, i3, i3, paint);
        RectF rectF2 = new RectF(right - this.f16024d, this.f16025e, right, bottom);
        int i4 = this.f16023c;
        canvas.drawRoundRect(rectF2, i4, i4, paint);
        int i5 = this.f16025e;
        int i6 = this.f16023c;
        canvas.drawRect(new RectF(i5, i5 + i6, right - i6, bottom), paint);
    }

    private void j(Canvas canvas, Paint paint, float right, float bottom) {
        int i2 = this.f16025e;
        RectF rectF = new RectF(i2, i2, right, i2 + this.f16024d);
        int i3 = this.f16023c;
        canvas.drawRoundRect(rectF, i3, i3, paint);
        int i4 = this.f16025e;
        RectF rectF2 = new RectF(i4, i4, i4 + this.f16024d, bottom);
        int i5 = this.f16023c;
        canvas.drawRoundRect(rectF2, i5, i5, paint);
        int i6 = this.f16025e;
        int i7 = this.f16023c;
        canvas.drawRect(new RectF(i6 + i7, i6 + i7, right, bottom), paint);
    }

    private void k(Canvas canvas, Paint paint, float right, float bottom) {
        RectF rectF = new RectF(this.f16025e, bottom - this.f16024d, right, bottom);
        int i2 = this.f16023c;
        canvas.drawRoundRect(rectF, i2, i2, paint);
        RectF rectF2 = new RectF(right - this.f16024d, this.f16025e, right, bottom);
        int i3 = this.f16023c;
        canvas.drawRoundRect(rectF2, i3, i3, paint);
        int i4 = this.f16025e;
        int i5 = this.f16023c;
        canvas.drawRect(new RectF(i4, i4, right - i5, bottom - i5), paint);
    }

    private void l(Canvas canvas, Paint paint, float right, float bottom) {
        int i2 = this.f16025e;
        RectF rectF = new RectF(i2, i2, i2 + this.f16024d, bottom);
        int i3 = this.f16023c;
        canvas.drawRoundRect(rectF, i3, i3, paint);
        RectF rectF2 = new RectF(this.f16025e, bottom - this.f16024d, right, bottom);
        int i4 = this.f16023c;
        canvas.drawRoundRect(rectF2, i4, i4, paint);
        int i5 = this.f16025e;
        int i6 = this.f16023c;
        canvas.drawRect(new RectF(i5 + i6, i5, right, bottom - i6), paint);
    }

    private void m(Canvas canvas, Paint paint, float right, float bottom) {
        RectF rectF = new RectF(right - this.f16024d, this.f16025e, right, bottom);
        int i2 = this.f16023c;
        canvas.drawRoundRect(rectF, i2, i2, paint);
        int i3 = this.f16025e;
        canvas.drawRect(new RectF(i3, i3, right - this.f16023c, bottom), paint);
    }

    private void n(Canvas canvas, Paint paint, float width, float height) {
        int i2 = this.f16025e;
        float f2 = width - i2;
        float f3 = height - i2;
        switch (a.a[this.f16026f.ordinal()]) {
            case 1:
                int i3 = this.f16025e;
                RectF rectF = new RectF(i3, i3, f2, f3);
                int i4 = this.f16023c;
                canvas.drawRoundRect(rectF, i4, i4, paint);
                return;
            case 2:
                o(canvas, paint, f2, f3);
                return;
            case 3:
                p(canvas, paint, f2, f3);
                return;
            case 4:
                c(canvas, paint, f2, f3);
                return;
            case 5:
                d(canvas, paint, f2, f3);
                return;
            case 6:
                q(canvas, paint, f2, f3);
                return;
            case 7:
                e(canvas, paint, f2, f3);
                return;
            case 8:
                h(canvas, paint, f2, f3);
                return;
            case 9:
                m(canvas, paint, f2, f3);
                return;
            case 10:
                k(canvas, paint, f2, f3);
                return;
            case 11:
                l(canvas, paint, f2, f3);
                return;
            case 12:
                i(canvas, paint, f2, f3);
                return;
            case 13:
                j(canvas, paint, f2, f3);
                return;
            case 14:
                f(canvas, paint, f2, f3);
                return;
            case 15:
                g(canvas, paint, f2, f3);
                return;
            default:
                int i5 = this.f16025e;
                RectF rectF2 = new RectF(i5, i5, f2, f3);
                int i6 = this.f16023c;
                canvas.drawRoundRect(rectF2, i6, i6, paint);
                return;
        }
    }

    private void o(Canvas canvas, Paint paint, float right, float bottom) {
        int i2 = this.f16025e;
        int i3 = this.f16024d;
        RectF rectF = new RectF(i2, i2, i2 + i3, i2 + i3);
        int i4 = this.f16023c;
        canvas.drawRoundRect(rectF, i4, i4, paint);
        int i5 = this.f16025e;
        int i6 = this.f16023c;
        canvas.drawRect(new RectF(i5, i5 + i6, i5 + i6, bottom), paint);
        int i7 = this.f16025e;
        canvas.drawRect(new RectF(this.f16023c + i7, i7, right, bottom), paint);
    }

    private void p(Canvas canvas, Paint paint, float right, float bottom) {
        int i2 = this.f16024d;
        int i3 = this.f16025e;
        RectF rectF = new RectF(right - i2, i3, right, i3 + i2);
        int i4 = this.f16023c;
        canvas.drawRoundRect(rectF, i4, i4, paint);
        int i5 = this.f16025e;
        canvas.drawRect(new RectF(i5, i5, right - this.f16023c, bottom), paint);
        int i6 = this.f16023c;
        canvas.drawRect(new RectF(right - i6, this.f16025e + i6, right, bottom), paint);
    }

    private void q(Canvas canvas, Paint paint, float right, float bottom) {
        int i2 = this.f16025e;
        RectF rectF = new RectF(i2, i2, right, i2 + this.f16024d);
        int i3 = this.f16023c;
        canvas.drawRoundRect(rectF, i3, i3, paint);
        int i4 = this.f16025e;
        canvas.drawRect(new RectF(i4, i4 + this.f16023c, right, bottom), paint);
    }

    @Override // g.a.a.a.a
    public Bitmap b(@NonNull Context context, @NonNull e pool, @NonNull Bitmap toTransform, int outWidth, int outHeight) {
        int width = toTransform.getWidth();
        int height = toTransform.getHeight();
        Bitmap f2 = pool.f(width, height, Bitmap.Config.ARGB_8888);
        f2.setHasAlpha(true);
        a(toTransform, f2);
        Canvas canvas = new Canvas(f2);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new BitmapShader(toTransform, tileMode, tileMode));
        n(canvas, paint, width, height);
        return f2;
    }

    @Override // g.a.a.a.a, e.b.a.p.c
    public boolean equals(Object o) {
        if (o instanceof RoundedCornersTransformation) {
            RoundedCornersTransformation roundedCornersTransformation = (RoundedCornersTransformation) o;
            if (roundedCornersTransformation.f16023c == this.f16023c && roundedCornersTransformation.f16024d == this.f16024d && roundedCornersTransformation.f16025e == this.f16025e && roundedCornersTransformation.f16026f == this.f16026f) {
                return true;
            }
        }
        return false;
    }

    @Override // g.a.a.a.a, e.b.a.p.c
    public int hashCode() {
        return 425235636 + (this.f16023c * 10000) + (this.f16024d * 1000) + (this.f16025e * 100) + (this.f16026f.ordinal() * 10);
    }

    public String toString() {
        return "RoundedTransformation(radius=" + this.f16023c + ", margin=" + this.f16025e + ", diameter=" + this.f16024d + ", cornerType=" + this.f16026f.name() + ")";
    }

    @Override // g.a.a.a.a, e.b.a.p.c
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update((f16022h + this.f16023c + this.f16024d + this.f16025e + this.f16026f).getBytes(c.b));
    }

    public RoundedCornersTransformation(int radius, int margin, CornerType cornerType) {
        this.f16023c = radius;
        this.f16024d = radius * 2;
        this.f16025e = margin;
        this.f16026f = cornerType;
    }
}
