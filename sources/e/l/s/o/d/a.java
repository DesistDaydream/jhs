package e.l.s.o.d;

import com.jihuanshe.R;
import com.jihuanshe.model.Rarity;
import com.vector.util.Res;
import e.l.h.l.b;
import e.n.f;
import e.n.i;
import e.n.l;
import e.n.p;
import java.util.List;
import k.e.a.d;
import kotlin.Pair;

/* loaded from: classes2.dex */
public final class a extends b implements e.l.s.m.b {
    private final /* synthetic */ e.l.s.m.a b = new e.l.s.m.a(true, "selling");
    @d

    /* renamed from: c  reason: collision with root package name */
    private final l f14354c = new l(0);
    @d

    /* renamed from: d  reason: collision with root package name */
    private final f<Pair<String, String>> f14355d = new f<>(null, 1, null);
    @d

    /* renamed from: e  reason: collision with root package name */
    private final i f14356e = new i(null, 1, null);
    @d

    /* renamed from: f  reason: collision with root package name */
    private final p f14357f = new p(Res.w(Res.a, R.string.common_new_product, null, 2, null));
    @d

    /* renamed from: g  reason: collision with root package name */
    private final i f14358g;
    @d

    /* renamed from: h  reason: collision with root package name */
    private final p f14359h;
    @d

    /* renamed from: i  reason: collision with root package name */
    private final i f14360i;
    @d

    /* renamed from: j  reason: collision with root package name */
    private final i f14361j;
    @d

    /* renamed from: k  reason: collision with root package name */
    private final f<List<Rarity>> f14362k;

    public a() {
        Boolean bool = Boolean.FALSE;
        this.f14358g = new i(bool);
        this.f14359h = new p(null, 1, null);
        this.f14360i = new i(null, 1, null);
        this.f14361j = new i(bool);
        this.f14362k = new f<>(null, 1, null);
    }

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
    public final l p0() {
        return this.f14354c;
    }

    @d
    public final p q0() {
        return this.f14359h;
    }

    @d
    public final f<List<Rarity>> r0() {
        return this.f14362k;
    }

    @d
    public final i s0() {
        return this.f14360i;
    }

    @Override // e.l.s.m.b
    public void t() {
        this.b.t();
    }

    @d
    public final i t0() {
        return this.f14361j;
    }

    @d
    public final p u0() {
        return this.f14357f;
    }

    @d
    public final f<Pair<String, String>> v0() {
        return this.f14355d;
    }

    @d
    public final i w0() {
        return this.f14358g;
    }

    @Override // e.l.s.m.b
    @d
    public f<List<String>> x() {
        return this.b.x();
    }

    @d
    public final i x0() {
        return this.f14356e;
    }
}
