package e.j.a.b.f.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;

/* loaded from: classes2.dex */
public final class e extends Drawable implements Drawable.Callback {
    private int a;
    private long b;

    /* renamed from: c  reason: collision with root package name */
    private int f10495c;

    /* renamed from: d  reason: collision with root package name */
    private int f10496d;

    /* renamed from: e  reason: collision with root package name */
    private int f10497e;

    /* renamed from: f  reason: collision with root package name */
    private int f10498f;

    /* renamed from: g  reason: collision with root package name */
    private int f10499g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f10500h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f10501i;

    /* renamed from: j  reason: collision with root package name */
    private i f10502j;

    /* renamed from: k  reason: collision with root package name */
    private Drawable f10503k;

    /* renamed from: l  reason: collision with root package name */
    private Drawable f10504l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f10505m;
    private boolean n;
    private boolean o;
    private int p;

    public e(Drawable drawable, Drawable drawable2) {
        this(null);
        drawable = drawable == null ? g.a : drawable;
        this.f10503k = drawable;
        drawable.setCallback(this);
        i iVar = this.f10502j;
        iVar.b = drawable.getChangingConfigurations() | iVar.b;
        drawable2 = drawable2 == null ? g.a : drawable2;
        this.f10504l = drawable2;
        drawable2.setCallback(this);
        i iVar2 = this.f10502j;
        iVar2.b = drawable2.getChangingConfigurations() | iVar2.b;
    }

    private final boolean a() {
        if (!this.f10505m) {
            this.n = (this.f10503k.getConstantState() == null || this.f10504l.getConstantState() == null) ? false : true;
            this.f10505m = true;
        }
        return this.n;
    }

    public final void b(int i2) {
        this.f10495c = 0;
        this.f10496d = this.f10497e;
        this.f10499g = 0;
        this.f10498f = 250;
        this.a = 1;
        invalidateSelf();
    }

    public final Drawable c() {
        return this.f10504l;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        int i2 = this.a;
        boolean z = false;
        if (i2 != 1) {
            if (i2 == 2 && this.b >= 0) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.b)) / this.f10498f;
                boolean z2 = uptimeMillis >= 1.0f;
                if (z2) {
                    this.a = 0;
                }
                this.f10499g = (int) ((this.f10496d * Math.min(uptimeMillis, 1.0f)) + 0.0f);
                z = z2;
            } else {
                z = true;
            }
        } else {
            this.b = SystemClock.uptimeMillis();
            this.a = 2;
        }
        int i3 = this.f10499g;
        boolean z3 = this.f10500h;
        Drawable drawable = this.f10503k;
        Drawable drawable2 = this.f10504l;
        if (z) {
            if (!z3 || i3 == 0) {
                drawable.draw(canvas);
            }
            int i4 = this.f10497e;
            if (i3 == i4) {
                drawable2.setAlpha(i4);
                drawable2.draw(canvas);
                return;
            }
            return;
        }
        if (z3) {
            drawable.setAlpha(this.f10497e - i3);
        }
        drawable.draw(canvas);
        if (z3) {
            drawable.setAlpha(this.f10497e);
        }
        if (i3 > 0) {
            drawable2.setAlpha(i3);
            drawable2.draw(canvas);
            drawable2.setAlpha(this.f10497e);
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getChangingConfigurations() {
        int changingConfigurations = super.getChangingConfigurations();
        i iVar = this.f10502j;
        return changingConfigurations | iVar.a | iVar.b;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (a()) {
            this.f10502j.a = getChangingConfigurations();
            return this.f10502j;
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return Math.max(this.f10503k.getIntrinsicHeight(), this.f10504l.getIntrinsicHeight());
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return Math.max(this.f10503k.getIntrinsicWidth(), this.f10504l.getIntrinsicWidth());
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        if (!this.o) {
            this.p = Drawable.resolveOpacity(this.f10503k.getOpacity(), this.f10504l.getOpacity());
            this.o = true;
        }
        return this.p;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable mutate() {
        if (!this.f10501i && super.mutate() == this) {
            if (a()) {
                this.f10503k.mutate();
                this.f10504l.mutate();
                this.f10501i = true;
            } else {
                throw new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
            }
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        this.f10503k.setBounds(rect);
        this.f10504l.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i2) {
        if (this.f10499g == this.f10497e) {
            this.f10499g = i2;
        }
        this.f10497e = i2;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f10503k.setColorFilter(colorFilter);
        this.f10504l.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public e(i iVar) {
        this.a = 0;
        this.f10497e = 255;
        this.f10499g = 0;
        this.f10500h = true;
        this.f10502j = new i(iVar);
    }
}
