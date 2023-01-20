package com.jihuanshe.ui.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.widget.PopupWindow;
import com.jihuanshe.ui.widget.CopyPopupWindow;
import e.l.k.ce;
import e.t.j.h.g;
import h.k2.u.a;
import h.r0;
import h.t1;
import java.util.Objects;
import k.e.a.d;
import kotlin.Result;

/* loaded from: classes2.dex */
public final class CopyPopupWindow extends PopupWindow {
    @d
    private final Context a;
    public ce b;
    @d

    /* renamed from: c */
    private final g f4052c;

    public CopyPopupWindow(@d Context context, @d a<t1> aVar) {
        super(context);
        this.a = context;
        this.f4052c = e.t.j.h.d.a.a(new CopyPopupWindow$onClick$1(this, aVar));
        e();
        c();
    }

    private final void c() {
        setContentView(a().getRoot());
        setWidth(-2);
        setHeight(-2);
        setBackgroundDrawable(new BitmapDrawable());
        setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: e.l.q.c.e
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                CopyPopupWindow.f(CopyPopupWindow.this);
            }
        });
    }

    public static final void d(CopyPopupWindow copyPopupWindow) {
        try {
            Result.a aVar = Result.Companion;
            WindowManager.LayoutParams attributes = ((Activity) copyPopupWindow.getContext()).getWindow().getAttributes();
            attributes.alpha = 1.0f;
            ((Activity) copyPopupWindow.getContext()).getWindow().setAttributes(attributes);
            Result.m106constructorimpl(t1.a);
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            Result.m106constructorimpl(r0.a(th));
        }
    }

    private final void e() {
        g(ce.d(LayoutInflater.from(this.a)));
        a().h(this);
    }

    public static /* synthetic */ void f(CopyPopupWindow copyPopupWindow) {
        d(copyPopupWindow);
    }

    @d
    public final ce a() {
        ce ceVar = this.b;
        Objects.requireNonNull(ceVar);
        return ceVar;
    }

    @d
    public final g b() {
        return this.f4052c;
    }

    public final void g(@d ce ceVar) {
        this.b = ceVar;
    }

    @d
    public final Context getContext() {
        return this.a;
    }
}
