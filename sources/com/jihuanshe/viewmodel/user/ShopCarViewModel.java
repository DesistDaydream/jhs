package com.jihuanshe.viewmodel.user;

import androidx.lifecycle.ViewModelKt;
import com.eth.ext.FlowKt;
import com.eth.model.NLive;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.ShopCartItem;
import com.vector.design.ui.delegate.LoadMore;
import e.g.d.a;
import e.l.h.i.e;
import e.l.h.i.f;
import e.l.h.l.b;
import e.l.n.c.k;
import h.e2.c;
import h.t1;
import java.util.List;
import k.e.a.d;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.flow.Flow;

/* loaded from: classes2.dex */
public final class ShopCarViewModel extends b {
    @d
    private final f b = new f();
    @d

    /* renamed from: c  reason: collision with root package name */
    private final NLive<List<ShopCartItem>> f4581c = new NLive<>(null, 1, null);

    public static /* synthetic */ a s0(ShopCarViewModel shopCarViewModel, LoadMore.State state, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            state = null;
        }
        return shopCarViewModel.r0(state);
    }

    @d
    public final a<t1> q0(int i2) {
        return a.h(FlowKt.c(((k) e.l.n.a.d(k.class, true, false, false, 60L, true)).a(i2)), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final a<e<ShopCartItem>> r0(@k.e.a.e LoadMore.State state) {
        final Flow<e<ShopCartItem>> s = ((k) e.l.n.a.d(k.class, true, false, false, 60L, true)).s(this.b.a(state).d());
        return a.h(a.o(BinderKt.b(FlowKt.c(new Flow<e<ShopCartItem>>() { // from class: com.jihuanshe.viewmodel.user.ShopCarViewModel$getCarts$$inlined$map$1

            /* renamed from: com.jihuanshe.viewmodel.user.ShopCarViewModel$getCarts$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes2.dex */
            public static final class AnonymousClass2 implements i.b.v3.f<e<ShopCartItem>> {
                public final /* synthetic */ i.b.v3.f a;
                public final /* synthetic */ ShopCarViewModel$getCarts$$inlined$map$1 b;

                /* renamed from: com.jihuanshe.viewmodel.user.ShopCarViewModel$getCarts$$inlined$map$1$2$1  reason: invalid class name */
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
                    @k.e.a.e
                    public final Object invokeSuspend(@d Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(i.b.v3.f fVar, ShopCarViewModel$getCarts$$inlined$map$1 shopCarViewModel$getCarts$$inlined$map$1) {
                    this.a = fVar;
                    this.b = shopCarViewModel$getCarts$$inlined$map$1;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
                @Override // i.b.v3.f
                @k.e.a.e
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public java.lang.Object emit(e.l.h.i.e<com.jihuanshe.model.ShopCartItem> r9, @k.e.a.d h.e2.c r10) {
                    /*
                        r8 = this;
                        boolean r0 = r10 instanceof com.jihuanshe.viewmodel.user.ShopCarViewModel$getCarts$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r10
                        com.jihuanshe.viewmodel.user.ShopCarViewModel$getCarts$$inlined$map$1$2$1 r0 = (com.jihuanshe.viewmodel.user.ShopCarViewModel$getCarts$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.jihuanshe.viewmodel.user.ShopCarViewModel$getCarts$$inlined$map$1$2$1 r0 = new com.jihuanshe.viewmodel.user.ShopCarViewModel$getCarts$$inlined$map$1$2$1
                        r0.<init>(r10)
                    L18:
                        java.lang.Object r10 = r0.result
                        java.lang.Object r1 = h.e2.j.b.h()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        h.r0.n(r10)
                        goto L7f
                    L29:
                        java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                        java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                        r9.<init>(r10)
                        throw r9
                    L31:
                        h.r0.n(r10)
                        i.b.v3.f r10 = r8.a
                        e.l.h.i.e r9 = (e.l.h.i.e) r9
                        java.util.List r2 = r9.b()
                        if (r2 != 0) goto L3f
                        goto L76
                    L3f:
                        java.util.Iterator r2 = r2.iterator()
                    L43:
                        boolean r4 = r2.hasNext()
                        if (r4 == 0) goto L76
                        java.lang.Object r4 = r2.next()
                        com.jihuanshe.model.ShopCartItem r4 = (com.jihuanshe.model.ShopCartItem) r4
                        java.util.List r4 = r4.getCarts()
                        if (r4 != 0) goto L56
                        goto L43
                    L56:
                        java.util.Iterator r4 = r4.iterator()
                    L5a:
                        boolean r5 = r4.hasNext()
                        if (r5 == 0) goto L43
                        java.lang.Object r5 = r4.next()
                        com.jihuanshe.model.CardProduct r5 = (com.jihuanshe.model.CardProduct) r5
                        java.lang.String r6 = r5.getGameKey()
                        java.lang.String r7 = r5.getGameSubKey()
                        com.jihuanshe.model.Game r6 = e.l.l.a.b(r6, r7)
                        r5.setGame(r6)
                        goto L5a
                    L76:
                        r0.label = r3
                        java.lang.Object r9 = r10.emit(r9, r0)
                        if (r9 != r1) goto L7f
                        return r1
                    L7f:
                        h.t1 r9 = h.t1.a
                        return r9
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.jihuanshe.viewmodel.user.ShopCarViewModel$getCarts$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, h.e2.c):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @k.e.a.e
            public Object e(@d i.b.v3.f<? super e<ShopCartItem>> fVar, @d c cVar) {
                Object e2 = Flow.this.e(new AnonymousClass2(fVar, this), cVar);
                return e2 == h.e2.j.b.h() ? e2 : t1.a;
            }
        }), this.f4581c, this.b.f()), null, new ShopCarViewModel$getCarts$2(this), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final NLive<List<ShopCartItem>> t0() {
        return this.f4581c;
    }
}
