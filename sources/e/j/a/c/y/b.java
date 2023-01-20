package e.j.a.c.y;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.ViewCompat;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class b {

    /* renamed from: i  reason: collision with root package name */
    private static final int f11095i = 68;

    /* renamed from: j  reason: collision with root package name */
    private static final int f11096j = 20;

    /* renamed from: k  reason: collision with root package name */
    private static final int f11097k = 0;

    /* renamed from: l  reason: collision with root package name */
    private static final int[] f11098l = new int[3];

    /* renamed from: m  reason: collision with root package name */
    private static final float[] f11099m = {0.0f, 0.5f, 1.0f};
    private static final int[] n = new int[4];
    private static final float[] o = {0.0f, 0.0f, 0.5f, 1.0f};
    @NonNull
    private final Paint a;
    @NonNull
    private final Paint b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final Paint f11100c;

    /* renamed from: d  reason: collision with root package name */
    private int f11101d;

    /* renamed from: e  reason: collision with root package name */
    private int f11102e;

    /* renamed from: f  reason: collision with root package name */
    private int f11103f;

    /* renamed from: g  reason: collision with root package name */
    private final Path f11104g;

    /* renamed from: h  reason: collision with root package name */
    private Paint f11105h;

    public b() {
        this(ViewCompat.MEASURED_STATE_MASK);
    }

    public void a(@NonNull Canvas canvas, @Nullable Matrix matrix, @NonNull RectF rectF, int i2, float f2, float f3) {
        boolean z = f3 < 0.0f;
        Path path = this.f11104g;
        if (z) {
            int[] iArr = n;
            iArr[0] = 0;
            iArr[1] = this.f11103f;
            iArr[2] = this.f11102e;
            iArr[3] = this.f11101d;
        } else {
            path.rewind();
            path.moveTo(rectF.centerX(), rectF.centerY());
            path.arcTo(rectF, f2, f3);
            path.close();
            float f4 = -i2;
            rectF.inset(f4, f4);
            int[] iArr2 = n;
            iArr2[0] = 0;
            iArr2[1] = this.f11101d;
            iArr2[2] = this.f11102e;
            iArr2[3] = this.f11103f;
        }
        float width = rectF.width() / 2.0f;
        if (width <= 0.0f) {
            return;
        }
        float f5 = 1.0f - (i2 / width);
        float[] fArr = o;
        fArr[1] = f5;
        fArr[2] = ((1.0f - f5) / 2.0f) + f5;
        this.b.setShader(new RadialGradient(rectF.centerX(), rectF.centerY(), width, n, fArr, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.scale(1.0f, rectF.height() / rectF.width());
        if (!z) {
            canvas.clipPath(path, Region.Op.DIFFERENCE);
            canvas.drawPath(path, this.f11105h);
        }
        canvas.drawArc(rectF, f2, f3, true, this.b);
        canvas.restore();
    }

    public void b(@NonNull Canvas canvas, @Nullable Matrix matrix, @NonNull RectF rectF, int i2) {
        rectF.bottom += i2;
        rectF.offset(0.0f, -i2);
        int[] iArr = f11098l;
        iArr[0] = this.f11103f;
        iArr[1] = this.f11102e;
        iArr[2] = this.f11101d;
        Paint paint = this.f11100c;
        float f2 = rectF.left;
        paint.setShader(new LinearGradient(f2, rectF.top, f2, rectF.bottom, iArr, f11099m, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.drawRect(rectF, this.f11100c);
        canvas.restore();
    }

    @NonNull
    public Paint c() {
        return this.a;
    }

    public void d(int i2) {
        this.f11101d = ColorUtils.setAlphaComponent(i2, 68);
        this.f11102e = ColorUtils.setAlphaComponent(i2, 20);
        this.f11103f = ColorUtils.setAlphaComponent(i2, 0);
        this.a.setColor(this.f11101d);
    }

    public b(int i2) {
        this.f11104g = new Path();
        this.f11105h = new Paint();
        this.a = new Paint();
        d(i2);
        this.f11105h.setColor(0);
        Paint paint = new Paint(4);
        this.b = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f11100c = new Paint(paint);
    }
}
