package e.t.u;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import com.umeng.analytics.pro.am;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J6\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ.\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rJ0\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0002J0\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0002J>\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\nJ&\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0019J>\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\nJ6\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ0\u0010!\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0002J.\u0010\"\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010#\u001a\u00020\rJ0\u0010$\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0002J0\u0010%\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0002¨\u0006&"}, d2 = {"Lcom/vector/util/DrawUtil;", "", "()V", "drawBmpByAlignX", "", "canvas", "Landroid/graphics/Canvas;", "bmp", "Landroid/graphics/Bitmap;", "x", "", "y", "paint", "Landroid/graphics/Paint;", "align", "Landroid/graphics/Paint$Align;", "drawBmpInCenterX", "drawBmpInLeftX", "drawBmpInRightX", "drawBmpScaleInCenter", "scaleW", "scaleH", "drawRoundRect", "radius", "r", "Landroid/graphics/RectF;", "left", "top", "right", "bottom", "drawTextByAlignX", "text", "", "drawTextInCenterX", "drawTextInCenterXY", am.ax, "drawTextInLeftX", "drawTextInRightX", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class h {
    @k.e.a.d
    public static final h a = new h();

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Paint.Align.values().length];
            iArr[Paint.Align.LEFT.ordinal()] = 1;
            iArr[Paint.Align.CENTER.ordinal()] = 2;
            iArr[Paint.Align.RIGHT.ordinal()] = 3;
            a = iArr;
        }
    }

    private h() {
    }

    private final void c(Canvas canvas, Bitmap bitmap, float f2, float f3, Paint paint) {
        canvas.drawBitmap(bitmap, f2, f3, paint);
    }

    private final void d(Canvas canvas, Bitmap bitmap, float f2, float f3, Paint paint) {
        canvas.drawBitmap(bitmap, f2 - bitmap.getWidth(), f3, paint);
    }

    private final void i(Canvas canvas, String str, float f2, float f3, Paint paint) {
        canvas.drawText(str, f2 - (paint.measureText(str) / 2), f3, paint);
    }

    private final void k(Canvas canvas, String str, float f2, float f3, Paint paint) {
        canvas.drawText(str, f2, f3, paint);
    }

    private final void l(Canvas canvas, String str, float f2, float f3, Paint paint) {
        canvas.drawText(str, f2 - paint.measureText(str), f3, paint);
    }

    public final void a(@k.e.a.d Canvas canvas, @k.e.a.d Bitmap bitmap, float f2, float f3, @k.e.a.d Paint paint, @k.e.a.d Paint.Align align) {
        int i2 = a.a[align.ordinal()];
        if (i2 == 1) {
            c(canvas, bitmap, f2, f3, paint);
        } else if (i2 == 2) {
            b(canvas, bitmap, f2, f3, paint);
        } else if (i2 != 3) {
        } else {
            d(canvas, bitmap, f2, f3, paint);
        }
    }

    public final void b(@k.e.a.d Canvas canvas, @k.e.a.d Bitmap bitmap, float f2, float f3, @k.e.a.d Paint paint) {
        canvas.drawBitmap(bitmap, f2 - (bitmap.getWidth() / 2.0f), f3, paint);
    }

    public final void e(@k.e.a.d Canvas canvas, @k.e.a.d Bitmap bitmap, float f2, float f3, @k.e.a.d Paint paint, float f4, float f5) {
        Matrix matrix = new Matrix();
        matrix.setScale(f4, f5);
        float width = bitmap.getWidth() * f4;
        float height = bitmap.getHeight() * f5;
        float f6 = 2;
        matrix.postTranslate(f2 - (width / f6), f3 - (height / f6));
        canvas.drawBitmap(bitmap, matrix, paint);
    }

    public final void f(@k.e.a.d Canvas canvas, @k.e.a.d Paint paint, float f2, float f3, float f4, float f5, float f6) {
        g(canvas, paint, f2, new RectF(f3, f4, f5, f6));
    }

    public final void g(@k.e.a.d Canvas canvas, @k.e.a.d Paint paint, float f2, @k.e.a.d RectF rectF) {
        canvas.drawRoundRect(rectF, f2, f2, paint);
    }

    public final void h(@k.e.a.d Canvas canvas, @k.e.a.d String str, float f2, float f3, @k.e.a.d Paint paint, @k.e.a.d Paint.Align align) {
        float textSize = f3 + paint.getTextSize();
        int i2 = a.a[align.ordinal()];
        if (i2 == 1) {
            k(canvas, str, f2, textSize, paint);
        } else if (i2 == 2) {
            i(canvas, str, f2, textSize, paint);
        } else if (i2 != 3) {
        } else {
            l(canvas, str, f2, textSize, paint);
        }
    }

    public final void j(@k.e.a.d Canvas canvas, @k.e.a.d String str, float f2, float f3, @k.e.a.d Paint paint) {
        float measureText = paint.measureText(str) / 2;
        canvas.drawText(str, f2 - measureText, f3 + measureText, paint);
    }
}
