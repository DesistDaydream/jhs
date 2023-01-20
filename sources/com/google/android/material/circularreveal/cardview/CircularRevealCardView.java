package com.google.android.material.circularreveal.cardview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.card.MaterialCardView;
import e.j.a.c.k.b;
import e.j.a.c.k.c;

/* loaded from: classes2.dex */
public class CircularRevealCardView extends MaterialCardView implements c {
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    private final b f2859l;

    public CircularRevealCardView(Context context) {
        this(context, null);
    }

    @Override // e.j.a.c.k.c
    public void a() {
        this.f2859l.a();
    }

    @Override // e.j.a.c.k.c
    public void b() {
        this.f2859l.b();
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
    public void draw(Canvas canvas) {
        b bVar = this.f2859l;
        if (bVar != null) {
            bVar.c(canvas);
        } else {
            super.draw(canvas);
        }
    }

    @Override // e.j.a.c.k.c
    @Nullable
    public Drawable getCircularRevealOverlayDrawable() {
        return this.f2859l.g();
    }

    @Override // e.j.a.c.k.c
    public int getCircularRevealScrimColor() {
        return this.f2859l.h();
    }

    @Override // e.j.a.c.k.c
    @Nullable
    public c.e getRevealInfo() {
        return this.f2859l.j();
    }

    @Override // android.view.View, e.j.a.c.k.c
    public boolean isOpaque() {
        b bVar = this.f2859l;
        if (bVar != null) {
            return bVar.l();
        }
        return super.isOpaque();
    }

    @Override // e.j.a.c.k.c
    public void setCircularRevealOverlayDrawable(@Nullable Drawable drawable) {
        this.f2859l.m(drawable);
    }

    @Override // e.j.a.c.k.c
    public void setCircularRevealScrimColor(@ColorInt int i2) {
        this.f2859l.n(i2);
    }

    @Override // e.j.a.c.k.c
    public void setRevealInfo(@Nullable c.e eVar) {
        this.f2859l.o(eVar);
    }

    public CircularRevealCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2859l = new b(this);
    }
}
