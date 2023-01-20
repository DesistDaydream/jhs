package com.jihuanshe.ui.widget;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.widget.PopupWindow;
import e.l.k.qe;
import e.t.j.h.g;
import h.k2.u.l;
import h.k2.v.u;
import h.t1;
import java.util.List;
import java.util.Objects;
import k.e.a.d;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* loaded from: classes2.dex */
public final class PhonePopupWindow extends PopupWindow {
    @d

    /* renamed from: e  reason: collision with root package name */
    public static final a f4169e = new a(null);
    @d

    /* renamed from: f  reason: collision with root package name */
    private static final String f4170f = "GamePopupWindow";
    @d
    private final Context a;
    @d
    private final l<String, t1> b;
    @d

    /* renamed from: c  reason: collision with root package name */
    private final List<String> f4171c;

    /* renamed from: d  reason: collision with root package name */
    public qe f4172d;

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PhonePopupWindow(@d Context context, @d l<? super String, t1> lVar) {
        super(context);
        this.a = context;
        this.b = lVar;
        this.f4171c = CollectionsKt__CollectionsKt.P("+86", "+852", "+853", "+886");
        e();
        d();
    }

    private final void d() {
        setContentView(c().getRoot());
        setWidth(-2);
        setHeight(-2);
        setFocusable(true);
        setOutsideTouchable(true);
        setBackgroundDrawable(new BitmapDrawable());
    }

    private final void e() {
        g(qe.d(LayoutInflater.from(this.a)));
        c().h(this);
    }

    @d
    public final List<String> a() {
        return this.f4171c;
    }

    @d
    public final l<String, t1> b() {
        return this.b;
    }

    @d
    public final qe c() {
        qe qeVar = this.f4172d;
        Objects.requireNonNull(qeVar);
        return qeVar;
    }

    @d
    public final g f(int i2) {
        return e.t.j.h.d.a.a(new PhonePopupWindow$onChoose$1(this, i2));
    }

    public final void g(@d qe qeVar) {
        this.f4172d = qeVar;
    }

    @d
    public final Context getContext() {
        return this.a;
    }
}
