package e.j.a.c.k;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import e.j.a.c.k.c;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes2.dex */
public class b {

    /* renamed from: k  reason: collision with root package name */
    private static final boolean f10856k = false;

    /* renamed from: l  reason: collision with root package name */
    public static final int f10857l = 0;

    /* renamed from: m  reason: collision with root package name */
    public static final int f10858m = 1;
    public static final int n = 2;
    public static final int o;
    private final a a;
    @NonNull
    private final View b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final Path f10859c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final Paint f10860d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final Paint f10861e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private c.e f10862f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private Drawable f10863g;

    /* renamed from: h  reason: collision with root package name */
    private Paint f10864h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f10865i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f10866j;

    /* loaded from: classes2.dex */
    public interface a {
        void c(Canvas canvas);

        boolean d();
    }

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: e.j.a.c.k.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public @interface InterfaceC0366b {
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            o = 2;
        } else if (i2 >= 18) {
            o = 1;
        } else {
            o = 0;
        }
    }

    public b(a aVar) {
        this.a = aVar;
        View view = (View) aVar;
        this.b = view;
        view.setWillNotDraw(false);
        this.f10859c = new Path();
        this.f10860d = new Paint(7);
        Paint paint = new Paint(1);
        this.f10861e = paint;
        paint.setColor(0);
    }

    private void d(@NonNull Canvas canvas, int i2, float f2) {
        this.f10864h.setColor(i2);
        this.f10864h.setStrokeWidth(f2);
        c.e eVar = this.f10862f;
        canvas.drawCircle(eVar.a, eVar.b, eVar.f10868c - (f2 / 2.0f), this.f10864h);
    }

    private void e(@NonNull Canvas canvas) {
        this.a.c(canvas);
        if (r()) {
            c.e eVar = this.f10862f;
            canvas.drawCircle(eVar.a, eVar.b, eVar.f10868c, this.f10861e);
        }
        if (p()) {
            d(canvas, ViewCompat.MEASURED_STATE_MASK, 10.0f);
            d(canvas, -65536, 5.0f);
        }
        f(canvas);
    }

    private void f(@NonNull Canvas canvas) {
        if (q()) {
            Rect bounds = this.f10863g.getBounds();
            float width = this.f10862f.a - (bounds.width() / 2.0f);
            float height = this.f10862f.b - (bounds.height() / 2.0f);
            canvas.translate(width, height);
            this.f10863g.draw(canvas);
            canvas.translate(-width, -height);
        }
    }

    private float i(@NonNull c.e eVar) {
        return e.j.a.c.t.a.b(eVar.a, eVar.b, 0.0f, 0.0f, this.b.getWidth(), this.b.getHeight());
    }

    private void k() {
        if (o == 1) {
            this.f10859c.rewind();
            c.e eVar = this.f10862f;
            if (eVar != null) {
                this.f10859c.addCircle(eVar.a, eVar.b, eVar.f10868c, Path.Direction.CW);
            }
        }
        this.b.invalidate();
    }

    private boolean p() {
        c.e eVar = this.f10862f;
        boolean z = eVar == null || eVar.a();
        return o == 0 ? !z && this.f10866j : !z;
    }

    private boolean q() {
        return (this.f10865i || this.f10863g == null || this.f10862f == null) ? false : true;
    }

    private boolean r() {
        return (this.f10865i || Color.alpha(this.f10861e.getColor()) == 0) ? false : true;
    }

    public void a() {
        if (o == 0) {
            this.f10865i = true;
            this.f10866j = false;
            this.b.buildDrawingCache();
            Bitmap drawingCache = this.b.getDrawingCache();
            if (drawingCache == null && this.b.getWidth() != 0 && this.b.getHeight() != 0) {
                drawingCache = Bitmap.createBitmap(this.b.getWidth(), this.b.getHeight(), Bitmap.Config.ARGB_8888);
                this.b.draw(new Canvas(drawingCache));
            }
            if (drawingCache != null) {
                Paint paint = this.f10860d;
                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                paint.setShader(new BitmapShader(drawingCache, tileMode, tileMode));
            }
            this.f10865i = false;
            this.f10866j = true;
        }
    }

    public void b() {
        if (o == 0) {
            this.f10866j = false;
            this.b.destroyDrawingCache();
            this.f10860d.setShader(null);
            this.b.invalidate();
        }
    }

    public void c(@NonNull Canvas canvas) {
        if (p()) {
            int i2 = o;
            if (i2 == 0) {
                c.e eVar = this.f10862f;
                canvas.drawCircle(eVar.a, eVar.b, eVar.f10868c, this.f10860d);
                if (r()) {
                    c.e eVar2 = this.f10862f;
                    canvas.drawCircle(eVar2.a, eVar2.b, eVar2.f10868c, this.f10861e);
                }
            } else if (i2 == 1) {
                int save = canvas.save();
                canvas.clipPath(this.f10859c);
                this.a.c(canvas);
                if (r()) {
                    canvas.drawRect(0.0f, 0.0f, this.b.getWidth(), this.b.getHeight(), this.f10861e);
                }
                canvas.restoreToCount(save);
            } else if (i2 == 2) {
                this.a.c(canvas);
                if (r()) {
                    canvas.drawRect(0.0f, 0.0f, this.b.getWidth(), this.b.getHeight(), this.f10861e);
                }
            } else {
                throw new IllegalStateException("Unsupported strategy " + i2);
            }
        } else {
            this.a.c(canvas);
            if (r()) {
                canvas.drawRect(0.0f, 0.0f, this.b.getWidth(), this.b.getHeight(), this.f10861e);
            }
        }
        f(canvas);
    }

    @Nullable
    public Drawable g() {
        return this.f10863g;
    }

    @ColorInt
    public int h() {
        return this.f10861e.getColor();
    }

    @Nullable
    public c.e j() {
        c.e eVar = this.f10862f;
        if (eVar == null) {
            return null;
        }
        c.e eVar2 = new c.e(eVar);
        if (eVar2.a()) {
            eVar2.f10868c = i(eVar2);
        }
        return eVar2;
    }

    public boolean l() {
        return this.a.d() && !p();
    }

    public void m(@Nullable Drawable drawable) {
        this.f10863g = drawable;
        this.b.invalidate();
    }

    public void n(@ColorInt int i2) {
        this.f10861e.setColor(i2);
        this.b.invalidate();
    }

    public void o(@Nullable c.e eVar) {
        if (eVar == null) {
            this.f10862f = null;
        } else {
            c.e eVar2 = this.f10862f;
            if (eVar2 == null) {
                this.f10862f = new c.e(eVar);
            } else {
                eVar2.c(eVar);
            }
            if (e.j.a.c.t.a.e(eVar.f10868c, i(eVar), 1.0E-4f)) {
                this.f10862f.f10868c = Float.MAX_VALUE;
            }
        }
        k();
    }
}
