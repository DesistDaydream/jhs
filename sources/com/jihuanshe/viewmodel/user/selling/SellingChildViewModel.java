package com.jihuanshe.viewmodel.user.selling;

import androidx.lifecycle.ViewModelKt;
import com.eth.ext.FlowKt;
import com.eth.model.NLive;
import com.jihuanshe.base.model.Result;
import com.jihuanshe.mmkv.UserKV;
import com.jihuanshe.model.CardProductNew;
import com.jihuanshe.model.Game;
import com.jihuanshe.model.GameCard;
import com.jihuanshe.model.Rarity;
import com.jihuanshe.model.WantCard;
import com.jihuanshe.ui.widget.GameBar;
import com.jihuanshe.viewmodel.UploadViewModel;
import com.vector.design.ui.delegate.LoadMore;
import e.g.d.a;
import e.l.h.i.f;
import e.l.n.c.f;
import e.l.n.c.j;
import e.l.n.c.k;
import e.l.n.c.o;
import h.e2.c;
import h.e2.j.b;
import h.t1;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.flow.Flow;

/* loaded from: classes2.dex */
public final class SellingChildViewModel extends UploadViewModel {
    @e

    /* renamed from: e  reason: collision with root package name */
    private String f4588e;
    @e

    /* renamed from: h  reason: collision with root package name */
    private a<?> f4591h;
    @d

    /* renamed from: d  reason: collision with root package name */
    private final f f4587d = new f();
    @d

    /* renamed from: f  reason: collision with root package name */
    private final NLive<List<GameCard>> f4589f = new NLive<>(null, 1, null);
    @d

    /* renamed from: g  reason: collision with root package name */
    private final e.n.f<List<Rarity>> f4590g = new e.n.f<>(null, 1, null);

    public static /* synthetic */ a E0(SellingChildViewModel sellingChildViewModel, int i2, String str, String str2, LoadMore.State state, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            state = null;
        }
        return sellingChildViewModel.C0(i2, str, str2, state);
    }

    public static /* synthetic */ a K0(SellingChildViewModel sellingChildViewModel, Integer num, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            num = 0;
        }
        return sellingChildViewModel.J0(num);
    }

    @d
    public final a<CardProductNew> A0(int i2) {
        o oVar = (o) e.l.n.a.d(o.class, true, false, false, 60L, true);
        int v = UserKV.f3913c.v();
        Game value = GameBar.b.a().getValue();
        String gameKey = value == null ? null : value.getGameKey();
        if (gameKey == null) {
            gameKey = "";
        }
        return a.h(FlowKt.c(o.a.a(oVar, v, i2, 0, gameKey, null, 16, null)), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @e
    public final a<?> B0() {
        return this.f4591h;
    }

    @d
    public final a<?> C0(int i2, @e String str, @e String str2, @e LoadMore.State state) {
        a<?> aVar;
        if (state == null && (aVar = this.f4591h) != null) {
            aVar.b();
        }
        final Game value = GameBar.b.a().getValue();
        final Flow<Result<e.l.h.i.e<GameCard>>> b = ((j) e.l.n.a.d(j.class, false, false, false, 60L, true)).b(i2, str, str2, this.f4588e, value == null ? null : value.getGameKey(), value == null ? null : value.getGameSubKey(), this.f4587d.a(state).d());
        a<?> h2 = a.h(a.o(a.j(FlowKt.c(new Flow<Result<e.l.h.i.e<GameCard>>>() { // from class: com.jihuanshe.viewmodel.user.selling.SellingChildViewModel$getData$$inlined$map$1

            /* renamed from: com.jihuanshe.viewmodel.user.selling.SellingChildViewModel$getData$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes2.dex */
            public static final class AnonymousClass2 implements i.b.v3.f<Result<e.l.h.i.e<GameCard>>> {
                public final /* synthetic */ i.b.v3.f a;
                public final /* synthetic */ SellingChildViewModel$getData$$inlined$map$1 b;

                /* renamed from: com.jihuanshe.viewmodel.user.selling.SellingChildViewModel$getData$$inlined$map$1$2$1  reason: invalid class name */
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

                    public AnonymousClass1(c cVar) {
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

                public AnonymousClass2(i.b.v3.f fVar, SellingChildViewModel$getData$$inlined$map$1 sellingChildViewModel$getData$$inlined$map$1) {
                    this.a = fVar;
                    this.b = sellingChildViewModel$getData$$inlined$map$1;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
                @Override // i.b.v3.f
                @k.e.a.e
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public java.lang.Object emit(com.jihuanshe.base.model.Result<e.l.h.i.e<com.jihuanshe.model.GameCard>> r7, @k.e.a.d h.e2.c r8) {
                    /*
                        r6 = this;
                        boolean r0 = r8 instanceof com.jihuanshe.viewmodel.user.selling.SellingChildViewModel$getData$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r8
                        com.jihuanshe.viewmodel.user.selling.SellingChildViewModel$getData$$inlined$map$1$2$1 r0 = (com.jihuanshe.viewmodel.user.selling.SellingChildViewModel$getData$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.jihuanshe.viewmodel.user.selling.SellingChildViewModel$getData$$inlined$map$1$2$1 r0 = new com.jihuanshe.viewmodel.user.selling.SellingChildViewModel$getData$$inlined$map$1$2$1
                        r0.<init>(r8)
                    L18:
                        java.lang.Object r8 = r0.result
                        java.lang.Object r1 = h.e2.j.b.h()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        h.r0.n(r8)
                        goto L69
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
                        e.l.h.i.e r2 = (e.l.h.i.e) r2
                        if (r2 != 0) goto L41
                        goto L60
                    L41:
                        java.util.List r2 = r2.b()
                        if (r2 != 0) goto L48
                        goto L60
                    L48:
                        java.util.Iterator r2 = r2.iterator()
                    L4c:
                        boolean r4 = r2.hasNext()
                        if (r4 == 0) goto L60
                        java.lang.Object r4 = r2.next()
                        com.jihuanshe.model.GameCard r4 = (com.jihuanshe.model.GameCard) r4
                        com.jihuanshe.viewmodel.user.selling.SellingChildViewModel$getData$$inlined$map$1 r5 = r6.b
                        com.jihuanshe.model.Game r5 = r2
                        r4.setGame(r5)
                        goto L4c
                    L60:
                        r0.label = r3
                        java.lang.Object r7 = r8.emit(r7, r0)
                        if (r7 != r1) goto L69
                        return r1
                    L69:
                        h.t1 r7 = h.t1.a
                        return r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.jihuanshe.viewmodel.user.selling.SellingChildViewModel$getData$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, h.e2.c):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @e
            public Object e(@d i.b.v3.f<? super Result<e.l.h.i.e<GameCard>>> fVar, @d c cVar) {
                Object e2 = Flow.this.e(new AnonymousClass2(fVar, this), cVar);
                return e2 == b.h() ? e2 : t1.a;
            }
        }), null, new SellingChildViewModel$getData$task$2(this), 1, null), null, new SellingChildViewModel$getData$task$3(this), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
        if (state == null) {
            this.f4591h = h2;
        }
        return h2;
    }

    @d
    public final NLive<List<GameCard>> D0() {
        return this.f4589f;
    }

    @e
    public final String F0() {
        return this.f4588e;
    }

    @d
    public final a<t1> G0(int i2, @d String str, @d String str2, @d List<String> list) {
        return a.h(a.j(FlowKt.c(f.a.b((e.l.n.c.f) e.l.n.a.d(e.l.n.c.f.class, true, false, false, 60L, true), i2, str, str2, list, null, 16, null)), null, new SellingChildViewModel$goErrorCorrect$1(this), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    public final void H0(@e a<?> aVar) {
        this.f4591h = aVar;
    }

    public final void I0(@e String str) {
        this.f4588e = str;
    }

    @d
    public final a<t1> J0(@e Integer num) {
        return a.h(FlowKt.c(((k) e.l.n.a.d(k.class, true, false, false, 60L, true)).P(num)), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final a<t1> L0(@d WantCard wantCard) {
        return a.h(FlowKt.c(((k) e.l.n.a.d(k.class, true, false, false, 60L, true)).H(wantCard.getId(), wantCard.getWishPrice(), wantCard.getCondition(), wantCard.getRemark(), Integer.valueOf(wantCard.getQuantity()))), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final a<t1> M0(@e Integer num) {
        return a.h(FlowKt.c(((k) e.l.n.a.d(k.class, true, false, false, 60L, true)).k(num)), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final e.n.f<List<Rarity>> N() {
        return this.f4590g;
    }

    @d
    public final a<t1> N0(@d WantCard wantCard) {
        return a.h(FlowKt.c(((k) e.l.n.a.d(k.class, true, false, false, 60L, true)).x(wantCard.getId(), wantCard.getWishPrice(), wantCard.getCondition(), wantCard.getRemark(), Integer.valueOf(wantCard.getQuantity()), wantCard.getRemote(), null, null)), ViewModelKt.getViewModelScope(this), null, 2, null);
    }
}
