package com.jihuanshe.viewmodel.detail;

import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.ViewModelKt;
import com.eth.ext.FlowKt;
import com.eth.model.NLive;
import com.jihuanshe.base.model.Result;
import com.jihuanshe.model.Game;
import com.jihuanshe.model.GameCard;
import com.jihuanshe.model.Rarity;
import com.jihuanshe.viewmodel.FilterBarImpl;
import com.vector.design.ui.delegate.LoadMore;
import com.vector.util.LayoutManagers;
import e.g.d.a;
import e.l.h.i.f;
import e.l.h.l.b;
import e.l.s.c;
import e.n.i;
import e.n.l;
import e.n.p;
import e.t.j.h.g;
import e.t.j.h.h;
import h.t1;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.Pair;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.flow.Flow;

/* loaded from: classes2.dex */
public final class CardPackListViewModel extends b implements c {
    @e

    /* renamed from: c  reason: collision with root package name */
    private a<?> f4388c;
    private final /* synthetic */ FilterBarImpl b = new FilterBarImpl();
    @d

    /* renamed from: d  reason: collision with root package name */
    private final p f4389d = new p(null, 1, null);
    @d

    /* renamed from: e  reason: collision with root package name */
    private final f f4390e = new f();
    @d

    /* renamed from: f  reason: collision with root package name */
    private final NLive<List<GameCard>> f4391f = new NLive<>(null, 1, null);

    public static /* synthetic */ a r0(CardPackListViewModel cardPackListViewModel, Game game, int i2, LoadMore.State state, boolean z, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            state = null;
        }
        if ((i3 & 8) != 0) {
            z = true;
        }
        return cardPackListViewModel.q0(game, i2, state, z);
    }

    @Override // e.l.s.c
    @d
    public e.t.k.a.c.a<Pair<String, String>> A() {
        return this.b.A();
    }

    @Override // e.l.s.c
    public boolean B() {
        return this.b.B();
    }

    @Override // e.l.s.c
    @d
    public e.n.f<Pair<String, String>> C() {
        return this.b.C();
    }

    @Override // e.l.s.c
    @d
    public g F(@d View view) {
        return this.b.F(view);
    }

    @Override // e.l.s.c
    @d
    public e.n.f<List<Pair<String, String>>> G() {
        return this.b.G();
    }

    @Override // e.l.s.c
    @d
    public i I() {
        return this.b.I();
    }

    @Override // e.l.s.c
    @d
    public e.n.f<Pair<String, String>> L() {
        return this.b.L();
    }

    @Override // e.l.s.c
    @d
    public p M() {
        return this.b.M();
    }

    @Override // e.l.s.c
    @d
    public e.n.f<Pair<String, String>> N() {
        return this.b.N();
    }

    @Override // e.l.s.c
    @d
    public g O(@d View view) {
        return this.b.O(view);
    }

    @Override // e.l.s.c
    @d
    public l P() {
        return this.b.P();
    }

    @Override // e.l.s.c
    @d
    public e.t.j.h.l Q() {
        return this.b.Q();
    }

    @Override // e.l.s.c
    @d
    public e.t.k.a.c.a<Rarity> S() {
        return this.b.S();
    }

    @Override // e.l.s.c
    @d
    public e.n.f<String> V() {
        return this.b.V();
    }

    @Override // e.l.s.c
    @d
    public e.n.f<Pair<String, String>> W() {
        return this.b.W();
    }

    @Override // e.l.s.c
    @d
    public i X() {
        return this.b.X();
    }

    @Override // e.l.s.c
    @d
    public LayoutManagers.a Y() {
        return this.b.Y();
    }

    @Override // e.l.s.c
    public boolean Z() {
        return this.b.Z();
    }

    @Override // e.l.s.c
    public void a(@d List<Rarity> list) {
        this.b.a(list);
    }

    @Override // e.l.s.c
    @d
    public g a0(int i2) {
        return this.b.a0(i2);
    }

    @Override // e.l.s.c
    @d
    public g b(@d View view) {
        return this.b.b(view);
    }

    @Override // e.l.s.c
    public void c0(@d TextView textView) {
        this.b.c0(textView);
    }

    @Override // e.l.s.c
    @d
    public i d() {
        return this.b.d();
    }

    @Override // e.l.s.c
    public void d0(int i2) {
        this.b.d0(i2);
    }

    @Override // e.l.s.c
    @d
    public i f0() {
        return this.b.f0();
    }

    @Override // e.l.s.c
    @d
    public g g0() {
        return this.b.g0();
    }

    @Override // e.l.s.c
    @d
    public h.k2.u.l<List<Rarity>, t1> h0() {
        return this.b.h0();
    }

    @Override // e.l.s.c
    @d
    public e.n.f<List<Rarity>> i() {
        return this.b.i();
    }

    @Override // e.l.s.c
    public boolean j0() {
        return this.b.j0();
    }

    @Override // e.l.s.c
    public boolean k() {
        return this.b.k();
    }

    @Override // e.l.s.c
    @d
    public l l() {
        return this.b.l();
    }

    @Override // e.l.s.c
    @d
    public g m(@d View view) {
        return this.b.m(view);
    }

    @Override // e.l.s.c
    @d
    public e.n.f<Pair<String, String>> n() {
        return this.b.n();
    }

    @Override // e.l.s.c
    @d
    public g q(@d View view) {
        return this.b.q(view);
    }

    @d
    public final a<?> q0(@d final Game game, int i2, @e LoadMore.State state, boolean z) {
        a<?> aVar = this.f4388c;
        if (aVar != null) {
            aVar.b();
        }
        e.l.o.a.a.a aVar2 = e.l.o.a.a.a.a;
        Integer valueOf = Integer.valueOf(i2);
        String value = this.f4389d.getValue();
        Pair<String, String> value2 = L().getValue();
        String second = value2 == null ? null : value2.getSecond();
        Pair<String, String> value3 = W().getValue();
        final Flow<Result<e.l.h.i.b<e.l.h.i.e<GameCard>>>> c2 = aVar2.c(null, valueOf, null, game, null, null, null, value, second, value3 == null ? null : value3.getSecond(), this.f4390e.a(state).d());
        a<?> h2 = a.h(a.o(a.j(FlowKt.c(new Flow<Result<e.l.h.i.b<e.l.h.i.e<GameCard>>>>() { // from class: com.jihuanshe.viewmodel.detail.CardPackListViewModel$getCards$$inlined$map$1

            /* renamed from: com.jihuanshe.viewmodel.detail.CardPackListViewModel$getCards$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes2.dex */
            public static final class AnonymousClass2 implements i.b.v3.f<Result<e.l.h.i.b<e.l.h.i.e<GameCard>>>> {
                public final /* synthetic */ i.b.v3.f a;
                public final /* synthetic */ CardPackListViewModel$getCards$$inlined$map$1 b;

                /* renamed from: com.jihuanshe.viewmodel.detail.CardPackListViewModel$getCards$$inlined$map$1$2$1  reason: invalid class name */
                /* loaded from: classes2.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    public Object L$0;
                    public Object L$1;
                    public Object L$2;
                    public Object L$3;
                    public Object L$4;
                    public Object L$5;
                    public Object L$6;
                    public Object L$7;
                    public int label;
                    public /* synthetic */ Object result;

                    public AnonymousClass1(h.e2.c cVar) {
                        super(cVar);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @e
                    public final Object invokeSuspend(@d Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(i.b.v3.f fVar, CardPackListViewModel$getCards$$inlined$map$1 cardPackListViewModel$getCards$$inlined$map$1) {
                    this.a = fVar;
                    this.b = cardPackListViewModel$getCards$$inlined$map$1;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
                @Override // i.b.v3.f
                @k.e.a.e
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public java.lang.Object emit(com.jihuanshe.base.model.Result<e.l.h.i.b<e.l.h.i.e<com.jihuanshe.model.GameCard>>> r7, @k.e.a.d h.e2.c r8) {
                    /*
                        r6 = this;
                        boolean r0 = r8 instanceof com.jihuanshe.viewmodel.detail.CardPackListViewModel$getCards$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r8
                        com.jihuanshe.viewmodel.detail.CardPackListViewModel$getCards$$inlined$map$1$2$1 r0 = (com.jihuanshe.viewmodel.detail.CardPackListViewModel$getCards$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.jihuanshe.viewmodel.detail.CardPackListViewModel$getCards$$inlined$map$1$2$1 r0 = new com.jihuanshe.viewmodel.detail.CardPackListViewModel$getCards$$inlined$map$1$2$1
                        r0.<init>(r8)
                    L18:
                        java.lang.Object r8 = r0.result
                        java.lang.Object r1 = h.e2.j.b.h()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        h.r0.n(r8)
                        goto L72
                    L29:
                        java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                        java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                        r7.<init>(r8)
                        throw r7
                    L31:
                        h.r0.n(r8)
                        i.b.v3.f r8 = r6.a
                        com.jihuanshe.base.model.Result r7 = (com.jihuanshe.base.model.Result) r7
                        java.lang.Object r2 = r7.getData()
                        e.l.h.i.b r2 = (e.l.h.i.b) r2
                        if (r2 != 0) goto L41
                        goto L69
                    L41:
                        java.lang.Object r2 = r2.a()
                        e.l.h.i.e r2 = (e.l.h.i.e) r2
                        if (r2 != 0) goto L4a
                        goto L69
                    L4a:
                        java.util.List r2 = r2.b()
                        if (r2 != 0) goto L51
                        goto L69
                    L51:
                        java.util.Iterator r2 = r2.iterator()
                    L55:
                        boolean r4 = r2.hasNext()
                        if (r4 == 0) goto L69
                        java.lang.Object r4 = r2.next()
                        com.jihuanshe.model.GameCard r4 = (com.jihuanshe.model.GameCard) r4
                        com.jihuanshe.viewmodel.detail.CardPackListViewModel$getCards$$inlined$map$1 r5 = r6.b
                        com.jihuanshe.model.Game r5 = r2
                        r4.setGame(r5)
                        goto L55
                    L69:
                        r0.label = r3
                        java.lang.Object r7 = r8.emit(r7, r0)
                        if (r7 != r1) goto L72
                        return r1
                    L72:
                        h.t1 r7 = h.t1.a
                        return r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.jihuanshe.viewmodel.detail.CardPackListViewModel$getCards$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, h.e2.c):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @e
            public Object e(@d i.b.v3.f<? super Result<e.l.h.i.b<e.l.h.i.e<GameCard>>>> fVar, @d h.e2.c cVar) {
                Object e2 = Flow.this.e(new AnonymousClass2(fVar, this), cVar);
                return e2 == h.e2.j.b.h() ? e2 : t1.a;
            }
        }), null, new CardPackListViewModel$getCards$2(z, this), 1, null), null, new CardPackListViewModel$getCards$3(this), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
        this.f4388c = h2;
        return h2;
    }

    @Override // e.l.s.c
    public void r(@d Pair<String, String> pair) {
        this.b.r(pair);
    }

    @Override // e.l.s.c
    @d
    public i s() {
        return this.b.s();
    }

    @d
    public final p s0() {
        return this.f4389d;
    }

    @d
    public final NLive<List<GameCard>> t0() {
        return this.f4391f;
    }

    @Override // e.l.s.c
    public void v(int i2) {
        this.b.v(i2);
    }

    @Override // e.l.s.c
    @d
    public h w() {
        return this.b.w();
    }

    @Override // e.l.s.c
    public void y(int i2) {
        this.b.y(i2);
    }
}
