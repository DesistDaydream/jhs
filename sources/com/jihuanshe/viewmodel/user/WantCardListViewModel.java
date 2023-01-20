package com.jihuanshe.viewmodel.user;

import androidx.lifecycle.ViewModelKt;
import com.eth.ext.FlowKt;
import com.eth.model.NLive;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.mmkv.UserKV;
import com.jihuanshe.model.CardInfo;
import com.jihuanshe.model.CardPack;
import com.jihuanshe.model.Game;
import com.jihuanshe.model.Poster;
import com.jihuanshe.model.WantCard;
import com.jihuanshe.ui.widget.GameBar;
import com.vector.design.ui.delegate.LoadMore;
import e.g.d.a;
import e.l.h.i.f;
import e.l.h.l.b;
import e.l.n.c.a;
import e.l.n.c.k;
import e.l.n.c.u;
import h.e2.c;
import h.t1;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.flow.Flow;

/* loaded from: classes2.dex */
public final class WantCardListViewModel extends b {
    @d
    private final f b = new f();
    @d

    /* renamed from: c  reason: collision with root package name */
    private final NLive<List<WantCard>> f4584c = new NLive<>(null, 1, null);
    @d

    /* renamed from: d  reason: collision with root package name */
    private final e.n.f<List<CardPack>> f4585d = new e.n.f<>(null, 1, null);

    public static /* synthetic */ a w0(WantCardListViewModel wantCardListViewModel, int i2, String str, LoadMore.State state, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            state = null;
        }
        return wantCardListViewModel.u0(i2, str, state);
    }

    @d
    public final a<Poster> q0() {
        u uVar = (u) e.l.n.a.d(u.class, true, false, false, 60L, true);
        GameBar.a aVar = GameBar.b;
        Game value = aVar.a().getValue();
        String gameKey = value == null ? null : value.getGameKey();
        if (gameKey == null) {
            gameKey = "";
        }
        Game value2 = aVar.a().getValue();
        String gameSubKey = value2 == null ? null : value2.getGameSubKey();
        return a.h(FlowKt.c(uVar.a(gameKey, gameSubKey != null ? gameSubKey : "")), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final a<t1> r0(@e Integer num, @e Integer num2) {
        k kVar = (k) e.l.n.a.d(k.class, true, false, false, 60L, true);
        GameBar.a aVar = GameBar.b;
        Game value = aVar.a().getValue();
        String gameKey = value == null ? null : value.getGameKey();
        Game value2 = aVar.a().getValue();
        return a.h(FlowKt.c(kVar.l0(num, gameKey, value2 == null ? null : value2.getGameSubKey(), num2)), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final a<t1> s0(@e Integer num) {
        return a.h(FlowKt.c(((k) e.l.n.a.d(k.class, true, false, false, 60L, true)).I(num)), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final a<e.l.h.i.b<CardInfo>> t0(int i2) {
        final Flow a = a.C0390a.a((e.l.n.c.a) e.l.n.a.d(e.l.n.c.a.class, true, true, true, 60L, true), i2, null, null, 6, null);
        return e.g.d.a.h(FlowKt.c(new Flow<e.l.h.i.b<CardInfo>>() { // from class: com.jihuanshe.viewmodel.user.WantCardListViewModel$getCardInfo$$inlined$map$1

            /* renamed from: com.jihuanshe.viewmodel.user.WantCardListViewModel$getCardInfo$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes2.dex */
            public static final class AnonymousClass2 implements i.b.v3.f<e.l.h.i.b<CardInfo>> {
                public final /* synthetic */ i.b.v3.f a;
                public final /* synthetic */ WantCardListViewModel$getCardInfo$$inlined$map$1 b;

                /* renamed from: com.jihuanshe.viewmodel.user.WantCardListViewModel$getCardInfo$$inlined$map$1$2$1  reason: invalid class name */
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

                public AnonymousClass2(i.b.v3.f fVar, WantCardListViewModel$getCardInfo$$inlined$map$1 wantCardListViewModel$getCardInfo$$inlined$map$1) {
                    this.a = fVar;
                    this.b = wantCardListViewModel$getCardInfo$$inlined$map$1;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
                @Override // i.b.v3.f
                @k.e.a.e
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public java.lang.Object emit(e.l.h.i.b<com.jihuanshe.model.CardInfo> r11, @k.e.a.d h.e2.c r12) {
                    /*
                        r10 = this;
                        boolean r0 = r12 instanceof com.jihuanshe.viewmodel.user.WantCardListViewModel$getCardInfo$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r12
                        com.jihuanshe.viewmodel.user.WantCardListViewModel$getCardInfo$$inlined$map$1$2$1 r0 = (com.jihuanshe.viewmodel.user.WantCardListViewModel$getCardInfo$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.jihuanshe.viewmodel.user.WantCardListViewModel$getCardInfo$$inlined$map$1$2$1 r0 = new com.jihuanshe.viewmodel.user.WantCardListViewModel$getCardInfo$$inlined$map$1$2$1
                        r0.<init>(r12)
                    L18:
                        java.lang.Object r12 = r0.result
                        java.lang.Object r1 = h.e2.j.b.h()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L32
                        if (r2 != r3) goto L2a
                        h.r0.n(r12)
                        goto Ld3
                    L2a:
                        java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                        java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
                        r11.<init>(r12)
                        throw r11
                    L32:
                        h.r0.n(r12)
                        i.b.v3.f r12 = r10.a
                        e.l.h.i.b r11 = (e.l.h.i.b) r11
                        java.util.ArrayList r2 = new java.util.ArrayList
                        r2.<init>()
                        java.lang.Object r4 = r11.a()
                        com.jihuanshe.model.CardInfo r4 = (com.jihuanshe.model.CardInfo) r4
                        java.util.List r4 = r4.getVersions()
                        if (r4 != 0) goto L4c
                        goto Lbf
                    L4c:
                        java.util.Iterator r4 = r4.iterator()
                    L50:
                        boolean r5 = r4.hasNext()
                        if (r5 == 0) goto Lbf
                        java.lang.Object r5 = r4.next()
                        com.jihuanshe.model.CardVersion r5 = (com.jihuanshe.model.CardVersion) r5
                        java.util.List r6 = r5.getPack()
                        if (r6 != 0) goto L63
                        goto L50
                    L63:
                        java.util.Iterator r6 = r6.iterator()
                    L67:
                        boolean r7 = r6.hasNext()
                        if (r7 == 0) goto L50
                        java.lang.Object r7 = r6.next()
                        com.jihuanshe.model.CardPack r7 = (com.jihuanshe.model.CardPack) r7
                        java.lang.Float r8 = r5.getMinPrice()
                        if (r8 != 0) goto L7b
                        r8 = 0
                        goto L7f
                    L7b:
                        float r8 = r8.floatValue()
                    L7f:
                        r7.setMinPrice(r8)
                        java.lang.StringBuilder r8 = new java.lang.StringBuilder
                        r8.<init>()
                        java.lang.String r9 = r5.getNumber()
                        r8.append(r9)
                        java.lang.String r9 = " ["
                        r8.append(r9)
                        java.lang.String r9 = r5.getRarity()
                        r8.append(r9)
                        java.lang.String r9 = "] "
                        r8.append(r9)
                        java.lang.String r9 = r7.getNameCN()
                        r8.append(r9)
                        java.lang.String r8 = r8.toString()
                        r7.setVersionStr(r8)
                        int r8 = r5.getId()
                        r7.setVersionId(r8)
                        java.lang.String r8 = r5.getImage()
                        r7.setImage(r8)
                        r2.add(r7)
                        goto L67
                    Lbf:
                        com.jihuanshe.viewmodel.user.WantCardListViewModel$getCardInfo$$inlined$map$1 r4 = r10.b
                        com.jihuanshe.viewmodel.user.WantCardListViewModel r4 = r2
                        e.n.f r4 = r4.x0()
                        r4.postValue(r2)
                        r0.label = r3
                        java.lang.Object r11 = r12.emit(r11, r0)
                        if (r11 != r1) goto Ld3
                        return r1
                    Ld3:
                        h.t1 r11 = h.t1.a
                        return r11
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.jihuanshe.viewmodel.user.WantCardListViewModel$getCardInfo$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, h.e2.c):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @e
            public Object e(@d i.b.v3.f<? super e.l.h.i.b<CardInfo>> fVar, @d c cVar) {
                Object e2 = Flow.this.e(new AnonymousClass2(fVar, this), cVar);
                return e2 == h.e2.j.b.h() ? e2 : t1.a;
            }
        }), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final e.g.d.a<e.l.h.i.e<WantCard>> u0(int i2, @e String str, @e LoadMore.State state) {
        final Flow h2 = k.a.h((k) e.l.n.a.d(k.class, true, false, false, 60L, true), Integer.valueOf(UserKV.f3913c.v()), str, i2, this.b.a(state).d(), null, null, 48, null);
        return e.g.d.a.h(e.g.d.a.o(BinderKt.b(FlowKt.c(new Flow<e.l.h.i.e<WantCard>>() { // from class: com.jihuanshe.viewmodel.user.WantCardListViewModel$getData$$inlined$map$1

            /* renamed from: com.jihuanshe.viewmodel.user.WantCardListViewModel$getData$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes2.dex */
            public static final class AnonymousClass2 implements i.b.v3.f<e.l.h.i.e<WantCard>> {
                public final /* synthetic */ i.b.v3.f a;
                public final /* synthetic */ WantCardListViewModel$getData$$inlined$map$1 b;

                /* renamed from: com.jihuanshe.viewmodel.user.WantCardListViewModel$getData$$inlined$map$1$2$1  reason: invalid class name */
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

                public AnonymousClass2(i.b.v3.f fVar, WantCardListViewModel$getData$$inlined$map$1 wantCardListViewModel$getData$$inlined$map$1) {
                    this.a = fVar;
                    this.b = wantCardListViewModel$getData$$inlined$map$1;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
                @Override // i.b.v3.f
                @k.e.a.e
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public java.lang.Object emit(e.l.h.i.e<com.jihuanshe.model.WantCard> r7, @k.e.a.d h.e2.c r8) {
                    /*
                        r6 = this;
                        boolean r0 = r8 instanceof com.jihuanshe.viewmodel.user.WantCardListViewModel$getData$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r8
                        com.jihuanshe.viewmodel.user.WantCardListViewModel$getData$$inlined$map$1$2$1 r0 = (com.jihuanshe.viewmodel.user.WantCardListViewModel$getData$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.jihuanshe.viewmodel.user.WantCardListViewModel$getData$$inlined$map$1$2$1 r0 = new com.jihuanshe.viewmodel.user.WantCardListViewModel$getData$$inlined$map$1$2$1
                        r0.<init>(r8)
                    L18:
                        java.lang.Object r8 = r0.result
                        java.lang.Object r1 = h.e2.j.b.h()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        h.r0.n(r8)
                        goto L68
                    L29:
                        java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                        java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                        r7.<init>(r8)
                        throw r7
                    L31:
                        h.r0.n(r8)
                        i.b.v3.f r8 = r6.a
                        e.l.h.i.e r7 = (e.l.h.i.e) r7
                        java.util.List r2 = r7.b()
                        if (r2 != 0) goto L3f
                        goto L5f
                    L3f:
                        java.util.Iterator r2 = r2.iterator()
                    L43:
                        boolean r4 = r2.hasNext()
                        if (r4 == 0) goto L5f
                        java.lang.Object r4 = r2.next()
                        com.jihuanshe.model.WantCard r4 = (com.jihuanshe.model.WantCard) r4
                        com.jihuanshe.ui.widget.GameBar$a r5 = com.jihuanshe.ui.widget.GameBar.b
                        e.n.f r5 = r5.a()
                        java.lang.Object r5 = r5.getValue()
                        com.jihuanshe.model.Game r5 = (com.jihuanshe.model.Game) r5
                        r4.setGame(r5)
                        goto L43
                    L5f:
                        r0.label = r3
                        java.lang.Object r7 = r8.emit(r7, r0)
                        if (r7 != r1) goto L68
                        return r1
                    L68:
                        h.t1 r7 = h.t1.a
                        return r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.jihuanshe.viewmodel.user.WantCardListViewModel$getData$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, h.e2.c):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @e
            public Object e(@d i.b.v3.f<? super e.l.h.i.e<WantCard>> fVar, @d c cVar) {
                Object e2 = Flow.this.e(new AnonymousClass2(fVar, this), cVar);
                return e2 == h.e2.j.b.h() ? e2 : t1.a;
            }
        }), this.f4584c, this.b.f()), null, new WantCardListViewModel$getData$2(this), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final NLive<List<WantCard>> v0() {
        return this.f4584c;
    }

    @d
    public final e.n.f<List<CardPack>> x0() {
        return this.f4585d;
    }

    @d
    public final e.g.d.a<t1> y0(@e Integer num, @e Integer num2, @e Float f2, int i2, @e String str, int i3) {
        return e.g.d.a.h(FlowKt.c(((k) e.l.n.a.d(k.class, true, false, false, 60L, true)).X(num2, f2, i2, str, i3, num)), ViewModelKt.getViewModelScope(this), null, 2, null);
    }
}
