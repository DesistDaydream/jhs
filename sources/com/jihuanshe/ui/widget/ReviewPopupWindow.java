package com.jihuanshe.ui.widget;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.jihuanshe.R;
import e.l.k.se;
import e.t.j.h.g;
import java.util.Objects;
import k.e.a.d;

/* loaded from: classes2.dex */
public final class ReviewPopupWindow extends PopupWindow {
    @d
    private final Context a;
    @d
    private final String b;
    @d

    /* renamed from: c  reason: collision with root package name */
    private final g f4198c;

    /* renamed from: d  reason: collision with root package name */
    public se f4199d;
    @d

    /* renamed from: e  reason: collision with root package name */
    private final g f4200e;

    public ReviewPopupWindow(@d Context context, @d String str, @d g gVar) {
        super(context);
        this.a = context;
        this.b = str;
        this.f4198c = gVar;
        this.f4200e = e.t.j.h.d.a.a(new ReviewPopupWindow$onClick$1(this));
        f();
        e();
    }

    private final void e() {
        setContentView(b().getRoot());
        ((TextView) getContentView().findViewById(R.id.tvTitle)).setText(this.b);
        setWidth(-2);
        setHeight(-2);
        setFocusable(true);
        setOutsideTouchable(true);
        setAnimationStyle(0);
        setBackgroundDrawable(new ColorDrawable());
    }

    private final void f() {
        g(se.d(LayoutInflater.from(this.a)));
        b().h(this);
    }

    @d
    public final g a() {
        return this.f4198c;
    }

    @d
    public final se b() {
        se seVar = this.f4199d;
        Objects.requireNonNull(seVar);
        return seVar;
    }

    @d
    public final g c() {
        return this.f4200e;
    }

    @d
    public final String d() {
        return this.b;
    }

    public final void g(@d se seVar) {
        this.f4199d = seVar;
    }

    @d
    public final Context getContext() {
        return this.a;
    }
}
