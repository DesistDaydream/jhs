package com.jihuanshe.repo;

import com.eth.ext.FlowKt;
import com.jihuanshe.base.ext.BinderKt;
import e.g.d.a;
import e.n.f;
import i.b.n0;
import java.util.List;
import k.e.a.d;

/* loaded from: classes2.dex */
public final class ReportRepo {
    @d
    public static final ReportRepo a = new ReportRepo();
    @d
    private static final f<List<String>> b = new f<>(null, 1, null);
    @d

    /* renamed from: c  reason: collision with root package name */
    private static final f<List<String>> f3925c = new f<>(null, 1, null);
    @d

    /* renamed from: d  reason: collision with root package name */
    private static final f<List<String>> f3926d = new f<>(null, 1, null);

    /* renamed from: e  reason: collision with root package name */
    private static boolean f3927e;

    private ReportRepo() {
    }

    private final void f(n0 n0Var) {
        if (f3927e) {
            return;
        }
        f3927e = true;
        a h2 = a.h(a.o(a.j(FlowKt.c(((e.l.n.c.f) e.l.n.a.d(e.l.n.c.f.class, true, false, false, 60L, true)).l()), null, ReportRepo$refresh$1.INSTANCE, 1, null), null, ReportRepo$refresh$2.INSTANCE, 1, null), n0Var, null, 2, null);
        if (a.d().getValue() == null) {
            BinderKt.p(h2);
        }
    }

    public final void b(@d n0 n0Var) {
        f(n0Var);
    }

    @d
    public final f<List<String>> c() {
        return f3925c;
    }

    @d
    public final f<List<String>> d() {
        return b;
    }

    @d
    public final f<List<String>> e() {
        return f3926d;
    }
}
