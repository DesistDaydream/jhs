package com.jihuanshe.ui;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import e.l.h.d.f;
import e.l.h.j.a.a;
import e.l.h.l.b;
import h.w;
import h.z;
import java.util.Objects;
import k.e.a.d;

/* loaded from: classes2.dex */
public abstract class BaseFragment<VM extends b> extends a<VM> {
    public FragmentActivity o;
    private long p;
    @d
    private final w q = z.c(BaseFragment$statusHeight$2.INSTANCE);

    public final long V() {
        return this.p;
    }

    @d
    public final FragmentActivity W() {
        FragmentActivity fragmentActivity = this.o;
        Objects.requireNonNull(fragmentActivity);
        return fragmentActivity;
    }

    public final int X() {
        return ((Number) this.q.getValue()).intValue();
    }

    public void Y() {
    }

    public void Z() {
    }

    public void a0() {
    }

    public void b0(long j2) {
    }

    public final void c0(long j2) {
        this.p = j2;
    }

    public final void d0(@d FragmentActivity fragmentActivity) {
        this.o = fragmentActivity;
    }

    @Override // e.l.h.j.a.a, e.t.k.a.g.c, com.vector.design.ui.frag.SimpleFragEx, e.t.k.a.a
    public void g() {
        super.g();
        f fVar = f.b;
        fVar.e(this).g(e.l.j.a.b, new BaseFragment$initializeFlow$1(this));
        fVar.e(this).g(e.l.j.a.f12233c, new BaseFragment$initializeFlow$2(this));
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@d Context context) {
        super.onAttach(context);
        d0((FragmentActivity) context);
    }

    @Override // com.vector.design.ui.frag.SimpleFragEx, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        b0((System.currentTimeMillis() - this.p) / 1000);
    }

    @Override // e.l.h.j.a.a, com.vector.design.ui.frag.SimpleFragEx, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.p = System.currentTimeMillis();
        a0();
    }
}
