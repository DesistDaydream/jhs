package e.l.s.m.d;

import androidx.lifecycle.ViewModelKt;
import com.eth.ext.FlowKt;
import com.eth.model.NLive;
import com.jihuanshe.model.SearchResultCount;
import e.l.n.c.s;
import e.n.f;
import java.util.List;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class b extends e.l.h.l.b implements e.l.s.m.b {
    private final /* synthetic */ e.l.s.m.a b = new e.l.s.m.a(false, null, 3, null);
    @d

    /* renamed from: c  reason: collision with root package name */
    private final NLive<SearchResultCount> f14347c = new NLive<>(null, 1, null);
    @e

    /* renamed from: d  reason: collision with root package name */
    private e.g.d.a<SearchResultCount> f14348d;

    @Override // e.l.s.m.b
    @d
    public f<String> E() {
        return this.b.E();
    }

    @Override // e.l.s.m.b
    public void T(@d String str) {
        this.b.T(str);
    }

    @Override // e.l.s.m.b
    public boolean e() {
        return this.b.e();
    }

    @Override // e.l.s.m.b
    public void o(@d String str) {
        this.b.o(str);
    }

    @d
    public final NLive<SearchResultCount> p0() {
        return this.f14347c;
    }

    public final void q0(@d String str) {
        e.g.d.a<SearchResultCount> aVar = this.f14348d;
        if (aVar != null) {
            aVar.b();
        }
        this.f14348d = e.g.d.a.h(FlowKt.a(((s) e.l.n.a.d(s.class, true, false, false, 60L, true)).a(str), this.f14347c), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @e
    public final e.g.d.a<SearchResultCount> r0() {
        return this.f14348d;
    }

    public final void s0(@e e.g.d.a<SearchResultCount> aVar) {
        this.f14348d = aVar;
    }

    @Override // e.l.s.m.b
    public void t() {
        this.b.t();
    }

    @Override // e.l.s.m.b
    @d
    public f<List<String>> x() {
        return this.b.x();
    }
}
