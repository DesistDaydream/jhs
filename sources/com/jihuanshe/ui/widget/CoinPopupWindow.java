package com.jihuanshe.ui.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import com.jihuanshe.ui.widget.CoinPopupWindow;
import e.l.k.yd;
import e.t.j.h.g;
import h.k2.u.l;
import h.t1;
import java.util.Objects;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class CoinPopupWindow extends PopupWindow {
    @d
    private final Context a;
    private final int b;
    @d

    /* renamed from: c */
    private final l<Integer, t1> f4047c;

    /* renamed from: d */
    public yd f4048d;

    /* JADX WARN: Multi-variable type inference failed */
    public CoinPopupWindow(@d Context context, int i2, @d l<? super Integer, t1> lVar) {
        super(context);
        this.a = context;
        this.b = i2;
        this.f4047c = lVar;
        f();
        d();
    }

    private final void d() {
        setContentView(b().getRoot());
        setWidth(-2);
        setHeight(-2);
        setFocusable(true);
        setOutsideTouchable(true);
        setBackgroundDrawable(new BitmapDrawable());
        setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: e.l.q.c.b
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                CoinPopupWindow.g(CoinPopupWindow.this);
            }
        });
    }

    public static final void e(CoinPopupWindow coinPopupWindow) {
        WindowManager.LayoutParams attributes = ((Activity) coinPopupWindow.getContext()).getWindow().getAttributes();
        attributes.alpha = 1.0f;
        ((Activity) coinPopupWindow.getContext()).getWindow().setAttributes(attributes);
    }

    private final void f() {
        i(yd.d(LayoutInflater.from(this.a)));
        b().h(this);
    }

    public static /* synthetic */ void g(CoinPopupWindow coinPopupWindow) {
        e(coinPopupWindow);
    }

    @d
    public final l<Integer, t1> a() {
        return this.f4047c;
    }

    @d
    public final yd b() {
        yd ydVar = this.f4048d;
        Objects.requireNonNull(ydVar);
        return ydVar;
    }

    public final int c() {
        return this.b;
    }

    @d
    public final Context getContext() {
        return this.a;
    }

    @d
    public final g h(int i2) {
        return e.t.j.h.d.a.a(new CoinPopupWindow$onChoose$1(this, i2));
    }

    public final void i(@d yd ydVar) {
        this.f4048d = ydVar;
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(@e View view, int i2, int i3) {
        WindowManager.LayoutParams attributes = ((Activity) this.a).getWindow().getAttributes();
        attributes.alpha = 0.7f;
        ((Activity) this.a).getWindow().setAttributes(attributes);
        super.showAsDropDown(view, i2, i3);
    }
}
