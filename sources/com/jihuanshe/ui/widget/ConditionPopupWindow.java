package com.jihuanshe.ui.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.widget.PopupWindow;
import com.jihuanshe.ui.widget.ConditionPopupWindow;
import e.l.k.ae;
import e.t.j.h.g;
import h.k2.u.l;
import h.t1;
import java.util.Objects;
import k.e.a.d;

/* loaded from: classes2.dex */
public final class ConditionPopupWindow extends PopupWindow {
    @d
    private final Context a;
    @d
    private final l<Integer, t1> b;

    /* renamed from: c */
    public ae f4051c;

    /* JADX WARN: Multi-variable type inference failed */
    public ConditionPopupWindow(@d Context context, @d l<? super Integer, t1> lVar) {
        super(context);
        this.a = context;
        this.b = lVar;
        e();
        c();
    }

    private final void c() {
        setContentView(b().getRoot());
        setWidth(-2);
        setHeight(-2);
        setFocusable(true);
        setOutsideTouchable(true);
        setBackgroundDrawable(new BitmapDrawable());
        setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: e.l.q.c.d
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                ConditionPopupWindow.f(ConditionPopupWindow.this);
            }
        });
    }

    public static final void d(ConditionPopupWindow conditionPopupWindow) {
        WindowManager.LayoutParams attributes = ((Activity) conditionPopupWindow.getContext()).getWindow().getAttributes();
        attributes.alpha = 1.0f;
        ((Activity) conditionPopupWindow.getContext()).getWindow().setAttributes(attributes);
    }

    private final void e() {
        h(ae.d(LayoutInflater.from(this.a)));
        b().h(this);
    }

    public static /* synthetic */ void f(ConditionPopupWindow conditionPopupWindow) {
        d(conditionPopupWindow);
    }

    @d
    public final l<Integer, t1> a() {
        return this.b;
    }

    @d
    public final ae b() {
        ae aeVar = this.f4051c;
        Objects.requireNonNull(aeVar);
        return aeVar;
    }

    @d
    public final g g(int i2) {
        return e.t.j.h.d.a.a(new ConditionPopupWindow$onChoose$1(this, i2));
    }

    @d
    public final Context getContext() {
        return this.a;
    }

    public final void h(@d ae aeVar) {
        this.f4051c = aeVar;
    }
}
