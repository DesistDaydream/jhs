package com.jihuanshe.ui.widget;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.widget.PopupWindow;
import e.l.k.oe;
import e.t.j.h.g;
import java.util.Objects;
import k.e.a.d;

/* loaded from: classes2.dex */
public final class OnePopupWindow extends PopupWindow {
    @d
    private final Context a;
    @d
    private final String b;
    @d

    /* renamed from: c  reason: collision with root package name */
    private final g f4166c;

    /* renamed from: d  reason: collision with root package name */
    public oe f4167d;
    @d

    /* renamed from: e  reason: collision with root package name */
    private final g f4168e;

    public OnePopupWindow(@d Context context, @d String str, @d g gVar) {
        super(context);
        this.a = context;
        this.b = str;
        this.f4166c = gVar;
        this.f4168e = e.t.j.h.d.a.a(new OnePopupWindow$onClick$1(this));
        f();
        e();
    }

    private final void e() {
        setContentView(b().getRoot());
        setWidth(-2);
        setHeight(-2);
        setFocusable(true);
        setOutsideTouchable(true);
        setBackgroundDrawable(new BitmapDrawable());
    }

    private final void f() {
        g(oe.d(LayoutInflater.from(this.a)));
        b().h(this);
    }

    @d
    public final g a() {
        return this.f4166c;
    }

    @d
    public final oe b() {
        oe oeVar = this.f4167d;
        Objects.requireNonNull(oeVar);
        return oeVar;
    }

    @d
    public final g c() {
        return this.f4168e;
    }

    @d
    public final String d() {
        return this.b;
    }

    public final void g(@d oe oeVar) {
        this.f4167d = oeVar;
    }

    @d
    public final Context getContext() {
        return this.a;
    }
}
