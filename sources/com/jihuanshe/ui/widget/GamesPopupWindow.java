package com.jihuanshe.ui.widget;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.widget.PopupWindow;
import androidx.lifecycle.LifecycleOwner;
import com.jihuanshe.model.Game;
import com.vector.util.LayoutManagers;
import e.l.g.y;
import e.l.k.ke;
import e.t.j.h.d;
import e.t.j.h.g;
import e.t.o.d;
import h.k2.u.l;
import h.k2.v.u;
import h.t1;
import h.w;
import h.z;
import java.util.Objects;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class GamesPopupWindow extends PopupWindow {
    @d
    private final Context a;
    @e
    private final l<Boolean, t1> b;
    @e

    /* renamed from: c  reason: collision with root package name */
    private final l<Game, t1> f4120c;
    @e

    /* renamed from: d  reason: collision with root package name */
    private final Boolean f4121d;

    /* renamed from: e  reason: collision with root package name */
    private final int f4122e;

    /* renamed from: f  reason: collision with root package name */
    public ke f4123f;
    @d

    /* renamed from: g  reason: collision with root package name */
    private final w f4124g;
    @d

    /* renamed from: h  reason: collision with root package name */
    private final w f4125h;
    @d

    /* renamed from: i  reason: collision with root package name */
    private final e.t.j.h.l f4126i;
    @d

    /* renamed from: j  reason: collision with root package name */
    private final g f4127j;
    @d

    /* renamed from: k  reason: collision with root package name */
    private final g f4128k;

    public /* synthetic */ GamesPopupWindow(Context context, l lVar, l lVar2, Boolean bool, int i2, u uVar) {
        this(context, (i2 & 2) != 0 ? null : lVar, (i2 & 4) != 0 ? null : lVar2, (i2 & 8) != 0 ? Boolean.FALSE : bool);
    }

    private final void k() {
        setContentView(f().getRoot());
        setWidth(-1);
        setHeight(-1);
        setFocusable(true);
        setAnimationStyle(0);
        setBackgroundDrawable(new BitmapDrawable());
    }

    private final void l() {
        m(ke.d(LayoutInflater.from(this.a)));
        f().h(this);
        f().setLifecycleOwner((LifecycleOwner) this.a);
    }

    @d
    public final y a() {
        return (y) this.f4124g.getValue();
    }

    public final int b() {
        return this.f4122e;
    }

    @e
    public final Boolean c() {
        return this.f4121d;
    }

    @d
    public final LayoutManagers.a d() {
        return (LayoutManagers.a) this.f4125h.getValue();
    }

    @e
    public final l<Game, t1> e() {
        return this.f4120c;
    }

    @d
    public final ke f() {
        ke keVar = this.f4123f;
        Objects.requireNonNull(keVar);
        return keVar;
    }

    @d
    public final g g() {
        return this.f4127j;
    }

    @d
    public final Context getContext() {
        return this.a;
    }

    @d
    public final g h() {
        return this.f4128k;
    }

    @d
    public final e.t.j.h.l i() {
        return this.f4126i;
    }

    @e
    public final l<Boolean, t1> j() {
        return this.b;
    }

    public final void m(@d ke keVar) {
        this.f4123f = keVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GamesPopupWindow(@d Context context, @e l<? super Boolean, t1> lVar, @e l<? super Game, t1> lVar2, @e Boolean bool) {
        super(context);
        this.a = context;
        this.b = lVar;
        this.f4120c = lVar2;
        this.f4121d = bool;
        this.f4122e = d.a.c(e.t.o.d.a, null, 1, null).d(48);
        this.f4124g = z.c(new GamesPopupWindow$adapterFilter$2(this));
        this.f4125h = z.c(GamesPopupWindow$layoutManagerFilter$2.INSTANCE);
        this.f4126i = d.e.a.a(new GamesPopupWindow$onFilterItemClick$1(this));
        e.t.j.h.d dVar = e.t.j.h.d.a;
        this.f4127j = dVar.a(new GamesPopupWindow$onClickCancel$1(this));
        this.f4128k = dVar.a(GamesPopupWindow$onClickNull$1.INSTANCE);
        l();
        k();
    }
}
