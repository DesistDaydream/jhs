package com.jihuanshe.ui.dialog;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import e.l.k.a7;
import e.l.q.a.w;
import e.t.j.h.g;
import h.k2.u.l;
import h.k2.v.u;
import h.t1;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class MediationDialog extends w {
    @d

    /* renamed from: h  reason: collision with root package name */
    public static final a f3979h = new a(null);
    @e

    /* renamed from: e  reason: collision with root package name */
    private l<? super Integer, t1> f3980e;
    @d

    /* renamed from: f  reason: collision with root package name */
    private final g f3981f;
    @d

    /* renamed from: g  reason: collision with root package name */
    private final g f3982g;

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @d
        public final MediationDialog a() {
            return new MediationDialog();
        }
    }

    public MediationDialog() {
        e.t.j.h.d dVar = e.t.j.h.d.a;
        this.f3981f = dVar.a(new MediationDialog$onClickFirst$1(this));
        this.f3982g = dVar.a(new MediationDialog$onClickSecond$1(this));
    }

    @e
    public final l<Integer, t1> B() {
        return this.f3980e;
    }

    @d
    public final g C() {
        return this.f3981f;
    }

    @d
    public final g D() {
        return this.f3982g;
    }

    public final void E(@e l<? super Integer, t1> lVar) {
        this.f3980e = lVar;
    }

    @Override // e.l.q.a.w
    public void d() {
    }

    @Override // e.l.q.a.w
    @d
    public ViewDataBinding p(@e ViewGroup viewGroup) {
        a7 d2 = a7.d(getLayoutInflater());
        d2.h(this);
        return d2;
    }

    @Override // e.l.q.a.w
    public void y(@e Bundle bundle) {
    }
}
