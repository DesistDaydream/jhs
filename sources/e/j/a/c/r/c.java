package e.j.a.c.r;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.ColorUtils;
import e.j.a.c.z.o;
import e.j.a.c.z.p;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class c extends Drawable {
    private static final float q = 1.3333f;
    @NonNull
    private final Paint b;
    @Dimension

    /* renamed from: h  reason: collision with root package name */
    public float f10938h;
    @ColorInt

    /* renamed from: i  reason: collision with root package name */
    private int f10939i;
    @ColorInt

    /* renamed from: j  reason: collision with root package name */
    private int f10940j;
    @ColorInt

    /* renamed from: k  reason: collision with root package name */
    private int f10941k;
    @ColorInt

    /* renamed from: l  reason: collision with root package name */
    private int f10942l;
    @ColorInt

    /* renamed from: m  reason: collision with root package name */
    private int f10943m;
    private o o;
    @Nullable
    private ColorStateList p;
    private final p a = p.k();

    /* renamed from: c  reason: collision with root package name */
    private final Path f10933c = new Path();

    /* renamed from: d  reason: collision with root package name */
    private final Rect f10934d = new Rect();

    /* renamed from: e  reason: collision with root package name */
    private final RectF f10935e = new RectF();

    /* renamed from: f  reason: collision with root package name */
    private final RectF f10936f = new RectF();

    /* renamed from: g  reason: collision with root package name */
    private final b f10937g = new b();
    private boolean n = true;

    /* loaded from: classes2.dex */
    public class b extends Drawable.ConstantState {
        private b() {
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            return c.this;
        }
    }

    public c(o oVar) {
        this.o = oVar;
        Paint paint = new Paint(1);
        this.b = paint;
        paint.setStyle(Paint.Style.STROKE);
    }

    @NonNull
    private Shader a() {
        Rect rect = this.f10934d;
        copyBounds(rect);
        float height = this.f10938h / rect.height();
        return new LinearGradient(0.0f, rect.top, 0.0f, rect.bottom, new int[]{ColorUtils.compositeColors(this.f10939i, this.f10943m), ColorUtils.compositeColors(this.f10940j, this.f10943m), ColorUtils.compositeColors(ColorUtils.setAlphaComponent(this.f10940j, 0), this.f10943m), ColorUtils.compositeColors(ColorUtils.setAlphaComponent(this.f10942l, 0), this.f10943m), ColorUtils.compositeColors(this.f10942l, this.f10943m), ColorUtils.compositeColors(this.f10941k, this.f10943m)}, new float[]{0.0f, height, 0.5f, 0.5f, 1.0f - height, 1.0f}, Shader.TileMode.CLAMP);
    }

    @NonNull
    public RectF b() {
        this.f10936f.set(getBounds());
        return this.f10936f;
    }

    public o c() {
        return this.o;
    }

    public void d(@Nullable ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.f10943m = colorStateList.getColorForState(getState(), this.f10943m);
        }
        this.p = colorStateList;
        this.n = true;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.n) {
            this.b.setShader(a());
            this.n = false;
        }
        float strokeWidth = this.b.getStrokeWidth() / 2.0f;
        copyBounds(this.f10934d);
        this.f10935e.set(this.f10934d);
        float min = Math.min(this.o.r().a(b()), this.f10935e.width() / 2.0f);
        if (this.o.u(b())) {
            this.f10935e.inset(strokeWidth, strokeWidth);
            canvas.drawRoundRect(this.f10935e, min, min, this.b);
        }
    }

    public void e(@Dimension float f2) {
        if (this.f10938h != f2) {
            this.f10938h = f2;
            this.b.setStrokeWidth(f2 * q);
            this.n = true;
            invalidateSelf();
        }
    }

    public void f(@ColorInt int i2, @ColorInt int i3, @ColorInt int i4, @ColorInt int i5) {
        this.f10939i = i2;
        this.f10940j = i3;
        this.f10941k = i4;
        this.f10942l = i5;
    }

    public void g(o oVar) {
        this.o = oVar;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public Drawable.ConstantState getConstantState() {
        return this.f10937g;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f10938h > 0.0f ? -3 : -2;
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(@NonNull Outline outline) {
        if (this.o.u(b())) {
            outline.setRoundRect(getBounds(), this.o.r().a(b()));
            return;
        }
        copyBounds(this.f10934d);
        this.f10935e.set(this.f10934d);
        this.a.d(this.o, 1.0f, this.f10935e, this.f10933c);
        if (this.f10933c.isConvex()) {
            outline.setConvexPath(this.f10933c);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@NonNull Rect rect) {
        if (this.o.u(b())) {
            int round = Math.round(this.f10938h);
            rect.set(round, round, round, round);
            return true;
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList = this.p;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.n = true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        int colorForState;
        ColorStateList colorStateList = this.p;
        if (colorStateList != null && (colorForState = colorStateList.getColorForState(iArr, this.f10943m)) != this.f10943m) {
            this.n = true;
            this.f10943m = colorForState;
        }
        if (this.n) {
            invalidateSelf();
        }
        return this.n;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@IntRange(from = 0, to = 255) int i2) {
        this.b.setAlpha(i2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.b.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
