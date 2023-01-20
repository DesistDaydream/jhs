package com.jihuanshe.ui.widget;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.widget.PopupWindow;
import e.l.k.me;
import e.t.j.h.g;
import java.util.Objects;
import k.e.a.d;

/* loaded from: classes2.dex */
public final class InteractPopupWindow extends PopupWindow {
    @d
    private final Context a;
    @d
    private final g b;

    /* renamed from: c  reason: collision with root package name */
    public me f4129c;
    @d

    /* renamed from: d  reason: collision with root package name */
    private final g f4130d;

    public InteractPopupWindow(@d Context context, @d g gVar) {
        super(context);
        this.a = context;
        this.b = gVar;
        this.f4130d = e.t.j.h.d.a.a(new InteractPopupWindow$onClick$1(this));
        e();
        d();
    }

    private final void d() {
        setContentView(b().getRoot());
        setWidth(-2);
        setHeight(-2);
        setFocusable(true);
        setOutsideTouchable(true);
        setBackgroundDrawable(new BitmapDrawable());
    }

    private final void e() {
        f(me.d(LayoutInflater.from(this.a)));
        b().h(this);
    }

    @d
    public final g a() {
        return this.b;
    }

    @d
    public final me b() {
        me meVar = this.f4129c;
        Objects.requireNonNull(meVar);
        return meVar;
    }

    @d
    public final g c() {
        return this.f4130d;
    }

    public final void f(@d me meVar) {
        this.f4129c = meVar;
    }

    @d
    public final Context getContext() {
        return this.a;
    }
}
