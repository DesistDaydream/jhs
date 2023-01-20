package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import h.k2.v.u;
import h.p2.b0.g.t.k.r.a;
import h.p2.b0.g.t.m.h;
import h.p2.b0.g.t.m.m;
import k.e.a.d;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;

/* loaded from: classes3.dex */
public final class LazyScopeAdapter extends a {
    @d
    private final h<MemberScope> b;

    @h.k2.h
    public LazyScopeAdapter(@d h.k2.u.a<? extends MemberScope> aVar) {
        this(null, aVar, 1, null);
    }

    public /* synthetic */ LazyScopeAdapter(m mVar, h.k2.u.a aVar, int i2, u uVar) {
        this((i2 & 1) != 0 ? LockBasedStorageManager.f16850e : mVar, aVar);
    }

    @Override // h.p2.b0.g.t.k.r.a
    @d
    public MemberScope j() {
        return this.b.invoke();
    }

    @h.k2.h
    public LazyScopeAdapter(@d m mVar, @d h.k2.u.a<? extends MemberScope> aVar) {
        this.b = mVar.c(new LazyScopeAdapter$lazyScope$1(aVar));
    }
}
