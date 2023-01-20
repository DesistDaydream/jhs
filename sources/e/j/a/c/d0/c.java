package e.j.a.c.d0;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import e.j.a.c.z.j;
import e.j.a.c.z.o;

/* loaded from: classes2.dex */
public class c extends j {
    @NonNull
    private final Paint D;
    @NonNull
    private final RectF E;
    private int F;

    public c() {
        this(null);
    }

    private void P0(@NonNull Canvas canvas) {
        if (W0(getCallback())) {
            return;
        }
        canvas.restoreToCount(this.F);
    }

    private void Q0(@NonNull Canvas canvas) {
        Drawable.Callback callback = getCallback();
        if (W0(callback)) {
            View view = (View) callback;
            if (view.getLayerType() != 2) {
                view.setLayerType(2, null);
                return;
            }
            return;
        }
        S0(canvas);
    }

    private void S0(@NonNull Canvas canvas) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.F = canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), null);
        } else {
            this.F = canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), null, 31);
        }
    }

    private void V0() {
        this.D.setStyle(Paint.Style.FILL_AND_STROKE);
        this.D.setColor(-1);
        this.D.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    private boolean W0(Drawable.Callback callback) {
        return callback instanceof View;
    }

    public boolean O0() {
        return !this.E.isEmpty();
    }

    public void R0() {
        T0(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public void T0(float f2, float f3, float f4, float f5) {
        RectF rectF = this.E;
        if (f2 == rectF.left && f3 == rectF.top && f4 == rectF.right && f5 == rectF.bottom) {
            return;
        }
        rectF.set(f2, f3, f4, f5);
        invalidateSelf();
    }

    public void U0(@NonNull RectF rectF) {
        T0(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }

    @Override // e.j.a.c.z.j, android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Q0(canvas);
        super.draw(canvas);
        canvas.drawRect(this.E, this.D);
        P0(canvas);
    }

    public c(@Nullable o oVar) {
        super(oVar == null ? new o() : oVar);
        this.D = new Paint(1);
        V0();
        this.E = new RectF();
    }
}
