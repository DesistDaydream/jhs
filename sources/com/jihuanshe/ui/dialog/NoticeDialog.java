package com.jihuanshe.ui.dialog;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.vector.util.Res;
import e.l.k.g5;
import e.l.q.a.w;
import e.n.i;
import e.n.p;
import e.t.j.h.g;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class NoticeDialog extends w {
    @d

    /* renamed from: e  reason: collision with root package name */
    private final p f3983e = new p(null, 1, null);
    @d

    /* renamed from: f  reason: collision with root package name */
    private final p f3984f = new p(null, 1, null);
    @d

    /* renamed from: g  reason: collision with root package name */
    private final i f3985g;
    @d

    /* renamed from: h  reason: collision with root package name */
    private final i f3986h;
    @d

    /* renamed from: i  reason: collision with root package name */
    private final p f3987i;
    @d

    /* renamed from: j  reason: collision with root package name */
    private final p f3988j;
    @d

    /* renamed from: k  reason: collision with root package name */
    private g f3989k;
    @d

    /* renamed from: l  reason: collision with root package name */
    private g f3990l;

    public NoticeDialog() {
        Boolean bool = Boolean.FALSE;
        this.f3985g = new i(bool);
        this.f3986h = new i(bool);
        Res res = Res.a;
        this.f3987i = new p(Res.w(res, R.string.common_close, null, 2, null));
        this.f3988j = new p(Res.w(res, R.string.update_update_now, null, 2, null));
        e.t.j.h.d dVar = e.t.j.h.d.a;
        this.f3989k = dVar.a(new NoticeDialog$onLeftClick$1(this));
        this.f3990l = dVar.a(NoticeDialog$onRightClick$1.INSTANCE);
    }

    @d
    public final p B() {
        return this.f3984f;
    }

    @d
    public final i C() {
        return this.f3986h;
    }

    @d
    public final i D() {
        return this.f3985g;
    }

    @d
    public final p E() {
        return this.f3987i;
    }

    @d
    public final g F() {
        return this.f3989k;
    }

    @d
    public final g G() {
        return this.f3990l;
    }

    @d
    public final p H() {
        return this.f3988j;
    }

    @d
    public final p I() {
        return this.f3983e;
    }

    public final void J(@d g gVar) {
        this.f3989k = gVar;
    }

    public final void K(@d g gVar) {
        this.f3990l = gVar;
    }

    @Override // e.l.q.a.w
    public void d() {
    }

    @Override // e.l.q.a.w
    @d
    public ViewDataBinding p(@e ViewGroup viewGroup) {
        g5 e2 = g5.e(getLayoutInflater(), viewGroup, false);
        e2.h(this);
        return e2;
    }

    @Override // e.l.q.a.w
    public int q() {
        return R.style.animate_dialog_alpha;
    }

    @Override // e.l.q.a.w
    public void y(@e Bundle bundle) {
    }
}
