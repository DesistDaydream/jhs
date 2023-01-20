package com.google.android.material.circularreveal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.GridLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import e.j.a.c.k.b;
import e.j.a.c.k.c;

/* loaded from: classes2.dex */
public class CircularRevealGridLayout extends GridLayout implements c {
    @NonNull
    private final b a;

    public CircularRevealGridLayout(Context context) {
        this(context, null);
    }

    @Override // e.j.a.c.k.c
    public void a() {
        this.a.a();
    }

    @Override // e.j.a.c.k.c
    public void b() {
        this.a.b();
    }

    @Override // e.j.a.c.k.b.a
    public void c(Canvas canvas) {
        super.draw(canvas);
    }

    @Override // e.j.a.c.k.b.a
    public boolean d() {
        return super.isOpaque();
    }

    @Override // android.view.View, e.j.a.c.k.c
    public void draw(@NonNull Canvas canvas) {
        b bVar = this.a;
        if (bVar != null) {
            bVar.c(canvas);
        } else {
            super.draw(canvas);
        }
    }

    @Override // e.j.a.c.k.c
    @Nullable
    public Drawable getCircularRevealOverlayDrawable() {
        return this.a.g();
    }

    @Override // e.j.a.c.k.c
    public int getCircularRevealScrimColor() {
        return this.a.h();
    }

    @Override // e.j.a.c.k.c
    @Nullable
    public c.e getRevealInfo() {
        return this.a.j();
    }

    @Override // android.view.View, e.j.a.c.k.c
    public boolean isOpaque() {
        b bVar = this.a;
        if (bVar != null) {
            return bVar.l();
        }
        return super.isOpaque();
    }

    @Override // e.j.a.c.k.c
    public void setCircularRevealOverlayDrawable(@Nullable Drawable drawable) {
        this.a.m(drawable);
    }

    @Override // e.j.a.c.k.c
    public void setCircularRevealScrimColor(@ColorInt int i2) {
        this.a.n(i2);
    }

    @Override // e.j.a.c.k.c
    public void setRevealInfo(@Nullable c.e eVar) {
        this.a.o(eVar);
    }

    public CircularRevealGridLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new b(this);
    }
}
