package e.b.a.p.m.h;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import e.b.a.p.m.h.g;
import e.b.a.v.l;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class c extends Drawable implements g.b, Animatable, Animatable2Compat {

    /* renamed from: l  reason: collision with root package name */
    public static final int f9808l = -1;

    /* renamed from: m  reason: collision with root package name */
    public static final int f9809m = 0;
    private static final int n = 119;
    private final a a;
    private boolean b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f9810c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f9811d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f9812e;

    /* renamed from: f  reason: collision with root package name */
    private int f9813f;

    /* renamed from: g  reason: collision with root package name */
    private int f9814g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f9815h;

    /* renamed from: i  reason: collision with root package name */
    private Paint f9816i;

    /* renamed from: j  reason: collision with root package name */
    private Rect f9817j;

    /* renamed from: k  reason: collision with root package name */
    private List<Animatable2Compat.AnimationCallback> f9818k;

    /* loaded from: classes.dex */
    public static final class a extends Drawable.ConstantState {
        @VisibleForTesting
        public final g a;

        public a(g gVar) {
            this.a = gVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable(Resources resources) {
            return newDrawable();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            return new c(this);
        }
    }

    @Deprecated
    public c(Context context, e.b.a.n.a aVar, e.b.a.p.k.x.e eVar, e.b.a.p.i<Bitmap> iVar, int i2, int i3, Bitmap bitmap) {
        this(context, aVar, iVar, i2, i3, bitmap);
    }

    private Drawable.Callback b() {
        Drawable.Callback callback = getCallback();
        while (callback instanceof Drawable) {
            callback = ((Drawable) callback).getCallback();
        }
        return callback;
    }

    private Rect d() {
        if (this.f9817j == null) {
            this.f9817j = new Rect();
        }
        return this.f9817j;
    }

    private Paint i() {
        if (this.f9816i == null) {
            this.f9816i = new Paint(2);
        }
        return this.f9816i;
    }

    private void l() {
        List<Animatable2Compat.AnimationCallback> list = this.f9818k;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f9818k.get(i2).onAnimationEnd(this);
            }
        }
    }

    private void n() {
        this.f9813f = 0;
    }

    private void s() {
        l.a(!this.f9811d, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        if (this.a.a.f() == 1) {
            invalidateSelf();
        } else if (this.b) {
        } else {
            this.b = true;
            this.a.a.v(this);
            invalidateSelf();
        }
    }

    private void t() {
        this.b = false;
        this.a.a.w(this);
    }

    @Override // e.b.a.p.m.h.g.b
    public void a() {
        if (b() == null) {
            stop();
            invalidateSelf();
            return;
        }
        invalidateSelf();
        if (g() == f() - 1) {
            this.f9813f++;
        }
        int i2 = this.f9814g;
        if (i2 == -1 || this.f9813f < i2) {
            return;
        }
        l();
        stop();
    }

    public ByteBuffer c() {
        return this.a.a.b();
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void clearAnimationCallbacks() {
        List<Animatable2Compat.AnimationCallback> list = this.f9818k;
        if (list != null) {
            list.clear();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.f9811d) {
            return;
        }
        if (this.f9815h) {
            Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), d());
            this.f9815h = false;
        }
        canvas.drawBitmap(this.a.a.c(), (Rect) null, d(), i());
    }

    public Bitmap e() {
        return this.a.a.e();
    }

    public int f() {
        return this.a.a.f();
    }

    public int g() {
        return this.a.a.d();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.a.a.i();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.a.a.m();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    public e.b.a.p.i<Bitmap> h() {
        return this.a.a.h();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.b;
    }

    public int j() {
        return this.a.a.l();
    }

    public boolean k() {
        return this.f9811d;
    }

    public void m() {
        this.f9811d = true;
        this.a.a.a();
    }

    public void o(e.b.a.p.i<Bitmap> iVar, Bitmap bitmap) {
        this.a.a.q(iVar, bitmap);
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f9815h = true;
    }

    public void p(boolean z) {
        this.b = z;
    }

    public void q(int i2) {
        if (i2 <= 0 && i2 != -1 && i2 != 0) {
            throw new IllegalArgumentException("Loop count must be greater than 0, or equal to GlideDrawable.LOOP_FOREVER, or equal to GlideDrawable.LOOP_INTRINSIC");
        }
        if (i2 == 0) {
            int j2 = this.a.a.j();
            this.f9814g = j2 != 0 ? j2 : -1;
            return;
        }
        this.f9814g = i2;
    }

    public void r() {
        l.a(!this.b, "You cannot restart a currently running animation.");
        this.a.a.r();
        start();
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void registerAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        if (animationCallback == null) {
            return;
        }
        if (this.f9818k == null) {
            this.f9818k = new ArrayList();
        }
        this.f9818k.add(animationCallback);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        i().setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        i().setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        l.a(!this.f9811d, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.f9812e = z;
        if (!z) {
            t();
        } else if (this.f9810c) {
            s();
        }
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.f9810c = true;
        n();
        if (this.f9812e) {
            s();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.f9810c = false;
        t();
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public boolean unregisterAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        List<Animatable2Compat.AnimationCallback> list = this.f9818k;
        if (list == null || animationCallback == null) {
            return false;
        }
        return list.remove(animationCallback);
    }

    public c(Context context, e.b.a.n.a aVar, e.b.a.p.i<Bitmap> iVar, int i2, int i3, Bitmap bitmap) {
        this(new a(new g(e.b.a.c.e(context), aVar, i2, i3, iVar, bitmap)));
    }

    public c(a aVar) {
        this.f9812e = true;
        this.f9814g = -1;
        this.a = (a) l.d(aVar);
    }

    @VisibleForTesting
    public c(g gVar, Paint paint) {
        this(new a(gVar));
        this.f9816i = paint;
    }
}
