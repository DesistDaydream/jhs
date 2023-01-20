package e.l.s.m;

import e.n.f;
import e.n.p;
import h.k2.v.u;
import java.util.ArrayList;
import java.util.List;
import k.e.a.d;
import kotlin.collections.CollectionsKt___CollectionsKt;

/* loaded from: classes2.dex */
public final class a implements b {
    private final boolean a;
    @d
    private final String b;
    @d

    /* renamed from: c  reason: collision with root package name */
    private final p f14336c;
    @d

    /* renamed from: d  reason: collision with root package name */
    private final f<List<String>> f14337d;

    public a() {
        this(false, null, 3, null);
    }

    public a(boolean z, @d String str) {
        this.a = z;
        this.b = str;
        this.f14336c = new p(null, 1, null);
        this.f14337d = new f<>(e.l.m.b.f14084c.v(str));
    }

    @Override // e.l.s.m.b
    public void T(@d String str) {
        this.f14336c.setValue(str);
    }

    @Override // e.l.s.m.b
    @d
    /* renamed from: a */
    public p E() {
        return this.f14336c;
    }

    @Override // e.l.s.m.b
    public boolean e() {
        return this.a;
    }

    @Override // e.l.s.m.b
    public void o(@d String str) {
        List<String> value = this.f14337d.getValue();
        List<String> L5 = value == null ? null : CollectionsKt___CollectionsKt.L5(value);
        if (L5 == null) {
            L5 = new ArrayList<>();
        }
        if (L5.contains(str)) {
            L5.remove(str);
        }
        L5.add(0, str);
        e.l.m.b.f14084c.E(this.b, L5);
        this.f14337d.r(L5);
    }

    @Override // e.l.s.m.b
    public void t() {
        e.l.m.b.f14084c.q(this.b);
        this.f14337d.r(null);
    }

    @Override // e.l.s.m.b
    @d
    public f<List<String>> x() {
        return this.f14337d;
    }

    public /* synthetic */ a(boolean z, String str, int i2, u uVar) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? "" : str);
    }
}
