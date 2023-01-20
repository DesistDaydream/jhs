package com.jihuanshe.ui.widget.shimmer;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.jihuanshe.R;
import e.l.q.c.u0.a;
import e.l.q.c.u0.b;

/* loaded from: classes2.dex */
public class ShimmerFrameLayout extends FrameLayout {
    private final Paint a;
    private final b b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f4322c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f4323d;

    public ShimmerFrameLayout(Context context) {
        super(context);
        this.a = new Paint();
        this.b = new b();
        this.f4322c = true;
        this.f4323d = false;
        c(context, null);
    }

    private void c(Context context, @Nullable AttributeSet attributeSet) {
        a.b c0400a;
        setWillNotDraw(false);
        this.b.setCallback(this);
        if (attributeSet == null) {
            g(new a.C0400a().a());
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ShimmerFrameLayout, 0, 0);
        try {
            if (obtainStyledAttributes.hasValue(4) && obtainStyledAttributes.getBoolean(4, false)) {
                c0400a = new a.c();
            } else {
                c0400a = new a.C0400a();
            }
            g(c0400a.d(obtainStyledAttributes).a());
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public void a() {
        this.b.a();
    }

    public void b() {
        j();
        this.f4322c = false;
        invalidate();
    }

    public boolean d() {
        return this.b.d();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f4322c) {
            this.b.draw(canvas);
        }
    }

    public boolean e() {
        return this.b.e();
    }

    public boolean f() {
        return this.f4322c;
    }

    public ShimmerFrameLayout g(@Nullable a aVar) {
        this.b.h(aVar);
        if (aVar != null && aVar.o) {
            setLayerType(2, this.a);
        } else {
            setLayerType(0, null);
        }
        return this;
    }

    @Nullable
    public a getShimmer() {
        return this.b.c();
    }

    public void h(boolean z) {
        this.f4322c = true;
        if (z) {
            i();
        }
        invalidate();
    }

    public void i() {
        this.b.k();
    }

    public void j() {
        this.f4323d = false;
        this.b.m();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.b.c() == null || !this.b.c().p) {
            return;
        }
        this.b.k();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        j();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        this.b.setBounds(0, 0, getWidth(), getHeight());
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i2) {
        super.onVisibilityChanged(view, i2);
        b bVar = this.b;
        if (bVar == null) {
            return;
        }
        if (i2 != 0) {
            if (e()) {
                j();
                this.f4323d = true;
            }
        } else if (this.f4323d) {
            bVar.f();
            this.f4323d = false;
        }
    }

    public void setStaticAnimationProgress(float f2) {
        this.b.i(f2);
    }

    @Override // android.view.View
    public boolean verifyDrawable(@NonNull Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.b;
    }

    public ShimmerFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new Paint();
        this.b = new b();
        this.f4322c = true;
        this.f4323d = false;
        c(context, attributeSet);
    }

    public ShimmerFrameLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = new Paint();
        this.b = new b();
        this.f4322c = true;
        this.f4323d = false;
        c(context, attributeSet);
    }

    @TargetApi(21)
    public ShimmerFrameLayout(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.a = new Paint();
        this.b = new b();
        this.f4322c = true;
        this.f4323d = false;
        c(context, attributeSet);
    }
}
