package e.l.s;

import androidx.lifecycle.LifecycleOwner;
import e.n.i;
import e.n.l;
import h.t1;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;

/* loaded from: classes2.dex */
public final class b implements f {
    @k.e.a.d
    private final e.n.f<List<e.l.s.a>> a = new e.n.f<>(null, 1, null);
    @k.e.a.d
    private final e.n.f<e.l.s.a> b = new e.n.f<>(null, 1, null);
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    private final l f14329c = new l(0);
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    private final e.n.f<e.l.s.a> f14330d = new e.n.f<>(null, 1, null);
    @k.e.a.d

    /* renamed from: e  reason: collision with root package name */
    private final i f14331e = new i(null, 1, null);
    @k.e.a.d

    /* renamed from: f  reason: collision with root package name */
    private final a f14332f = new a();

    /* loaded from: classes2.dex */
    public static final class a implements h.k2.u.l<e.l.s.a, t1> {
        public a() {
        }

        public void a(@k.e.a.d e.l.s.a aVar) {
            b.this.b.r(aVar);
            b.this.f14330d.r(aVar);
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(e.l.s.a aVar) {
            a(aVar);
            return t1.a;
        }
    }

    @Override // e.l.s.f
    public void D() {
        this.f14331e.setValue(Boolean.TRUE);
    }

    @Override // e.l.s.f
    @k.e.a.d
    public e.n.f<List<e.l.s.a>> K() {
        return this.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // e.l.s.f
    public void R(@k.e.a.d List<e.l.s.a> list, int i2) {
        this.f14329c.setValue(Integer.valueOf(i2));
        this.a.r(list);
        this.b.r(CollectionsKt___CollectionsKt.J2(list, i2));
    }

    @Override // e.l.s.f
    public void U(@k.e.a.e LifecycleOwner lifecycleOwner, @k.e.a.d h.k2.u.l<? super e.l.s.a, t1> lVar) {
        this.f14330d.f(lifecycleOwner, lVar);
    }

    @Override // e.l.s.f
    @k.e.a.d
    public e.n.f<e.l.s.a> e0() {
        return this.b;
    }

    @Override // e.l.s.f
    @k.e.a.d
    public l f() {
        return this.f14329c;
    }

    @Override // e.l.s.f
    @k.e.a.d
    public i g() {
        return this.f14331e;
    }

    @Override // e.l.s.f
    @k.e.a.d
    public h.k2.u.l<e.l.s.a, t1> p() {
        return this.f14332f;
    }

    @Override // e.l.s.f
    @k.e.a.e
    public e.l.s.a u() {
        return this.b.getValue();
    }
}
