package com.jihuanshe.ui.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import androidx.lifecycle.LifecycleOwner;
import com.jihuanshe.ui.widget.GamePopupWindow;
import com.vector.util.LayoutManagers;
import e.l.g.x;
import e.l.k.ie;
import e.t.j.h.d;
import e.t.j.h.g;
import h.k2.u.l;
import h.k2.v.u;
import h.t1;
import h.w;
import h.z;
import java.util.Objects;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class GamePopupWindow extends PopupWindow {
    @d

    /* renamed from: g */
    public static final a f4114g = new a(null);
    @d

    /* renamed from: h */
    private static final String f4115h = "GamePopupWindow";
    @d
    private final Context a;
    @d
    private final l<Integer, t1> b;

    /* renamed from: c */
    public ie f4116c;
    @d

    /* renamed from: d */
    private final w f4117d;
    @d

    /* renamed from: e */
    private final w f4118e;
    @d

    /* renamed from: f */
    private final e.t.j.h.l f4119f;

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GamePopupWindow(@d Context context, @d l<? super Integer, t1> lVar) {
        super(context);
        this.a = context;
        this.b = lVar;
        this.f4117d = z.c(GamePopupWindow$adapter$2.INSTANCE);
        this.f4118e = z.c(GamePopupWindow$layoutManager$2.INSTANCE);
        this.f4119f = d.e.a.a(new GamePopupWindow$onItemClick$1(this));
        h();
        f();
    }

    private final void f() {
        setContentView(d().getRoot());
        setWidth(-2);
        setHeight(-2);
        setFocusable(true);
        setOutsideTouchable(true);
        setBackgroundDrawable(new BitmapDrawable());
        setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: e.l.q.c.u
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                GamePopupWindow.i(GamePopupWindow.this);
            }
        });
    }

    public static final void g(GamePopupWindow gamePopupWindow) {
        WindowManager.LayoutParams attributes = ((Activity) gamePopupWindow.getContext()).getWindow().getAttributes();
        attributes.alpha = 1.0f;
        ((Activity) gamePopupWindow.getContext()).getWindow().setAttributes(attributes);
    }

    private final void h() {
        k(ie.d(LayoutInflater.from(this.a)));
        d().h(this);
        d().setLifecycleOwner((LifecycleOwner) this.a);
    }

    public static /* synthetic */ void i(GamePopupWindow gamePopupWindow) {
        g(gamePopupWindow);
    }

    @k.e.a.d
    public final x a() {
        return (x) this.f4117d.getValue();
    }

    @k.e.a.d
    public final LayoutManagers.a b() {
        return (LayoutManagers.a) this.f4118e.getValue();
    }

    @k.e.a.d
    public final l<Integer, t1> c() {
        return this.b;
    }

    @k.e.a.d
    public final ie d() {
        ie ieVar = this.f4116c;
        Objects.requireNonNull(ieVar);
        return ieVar;
    }

    @k.e.a.d
    public final e.t.j.h.l e() {
        return this.f4119f;
    }

    @k.e.a.d
    public final Context getContext() {
        return this.a;
    }

    @k.e.a.d
    public final g j(int i2) {
        return e.t.j.h.d.a.a(new GamePopupWindow$onChoose$1(this, i2));
    }

    public final void k(@k.e.a.d ie ieVar) {
        this.f4116c = ieVar;
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(@e View view, int i2, int i3) {
        WindowManager.LayoutParams attributes = ((Activity) this.a).getWindow().getAttributes();
        attributes.alpha = 0.7f;
        ((Activity) this.a).getWindow().setAttributes(attributes);
        super.showAsDropDown(view, i2, i3);
    }
}
