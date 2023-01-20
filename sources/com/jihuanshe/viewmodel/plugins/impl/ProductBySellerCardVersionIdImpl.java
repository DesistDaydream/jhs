package com.jihuanshe.viewmodel.plugins.impl;

import androidx.lifecycle.LifecycleCoroutineScope;
import com.eth.ext.FlowKt;
import com.jihuanshe.model.CardProductNew;
import e.g.d.a;
import e.l.n.c.o;
import e.l.s.l.b.b;
import h.e2.c;
import h.t1;
import i.b.v3.f;
import k.e.a.d;
import k.e.a.e;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.flow.Flow;

/* loaded from: classes2.dex */
public final class ProductBySellerCardVersionIdImpl implements b {
    @Override // e.l.s.l.b.b
    @d
    public a<CardProductNew> h(int i2, final int i3, int i4, @d final String str, @d LifecycleCoroutineScope lifecycleCoroutineScope) {
        final Flow a = o.a.a((o) e.l.n.a.d(o.class, true, false, false, 60L, true), i2, i3, i4, str, null, 16, null);
        return a.h(FlowKt.c(new Flow<CardProductNew>() { // from class: com.jihuanshe.viewmodel.plugins.impl.ProductBySellerCardVersionIdImpl$requestBySellerCardVersionID$$inlined$map$1

            /* renamed from: com.jihuanshe.viewmodel.plugins.impl.ProductBySellerCardVersionIdImpl$requestBySellerCardVersionID$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes2.dex */
            public static final class AnonymousClass2 implements f<CardProductNew> {
                public final /* synthetic */ f a;
                public final /* synthetic */ ProductBySellerCardVersionIdImpl$requestBySellerCardVersionID$$inlined$map$1 b;

                /* renamed from: com.jihuanshe.viewmodel.plugins.impl.ProductBySellerCardVersionIdImpl$requestBySellerCardVersionID$$inlined$map$1$2$1  reason: invalid class name */
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

                public AnonymousClass2(f fVar, ProductBySellerCardVersionIdImpl$requestBySellerCardVersionID$$inlined$map$1 productBySellerCardVersionIdImpl$requestBySellerCardVersionID$$inlined$map$1) {
                    this.a = fVar;
                    this.b = productBySellerCardVersionIdImpl$requestBySellerCardVersionID$$inlined$map$1;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
                @Override // i.b.v3.f
                @k.e.a.e
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public java.lang.Object emit(com.jihuanshe.model.CardProductNew r9, @k.e.a.d h.e2.c r10) {
                    /*
                        r8 = this;
                        boolean r0 = r10 instanceof com.jihuanshe.viewmodel.plugins.impl.ProductBySellerCardVersionIdImpl$requestBySellerCardVersionID$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r10
                        com.jihuanshe.viewmodel.plugins.impl.ProductBySellerCardVersionIdImpl$requestBySellerCardVersionID$$inlined$map$1$2$1 r0 = (com.jihuanshe.viewmodel.plugins.impl.ProductBySellerCardVersionIdImpl$requestBySellerCardVersionID$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.jihuanshe.viewmodel.plugins.impl.ProductBySellerCardVersionIdImpl$requestBySellerCardVersionID$$inlined$map$1$2$1 r0 = new com.jihuanshe.viewmodel.plugins.impl.ProductBySellerCardVersionIdImpl$requestBySellerCardVersionID$$inlined$map$1$2$1
                        r0.<init>(r10)
                    L18:
                        java.lang.Object r10 = r0.result
                        java.lang.Object r1 = h.e2.j.b.h()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L32
                        if (r2 != r3) goto L2a
                        h.r0.n(r10)
                        goto Lca
                    L2a:
                        java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                        java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                        r9.<init>(r10)
                        throw r9
                    L32:
                        h.r0.n(r10)
                        i.b.v3.f r10 = r8.a
                        com.jihuanshe.model.CardProductNew r9 = (com.jihuanshe.model.CardProductNew) r9
                        com.jihuanshe.viewmodel.plugins.impl.ProductBySellerCardVersionIdImpl$requestBySellerCardVersionID$$inlined$map$1 r2 = r8.b
                        int r2 = r2
                        java.lang.Integer r2 = h.e2.k.a.a.f(r2)
                        r9.setCardVersionId(r2)
                        com.jihuanshe.viewmodel.plugins.impl.ProductBySellerCardVersionIdImpl$requestBySellerCardVersionID$$inlined$map$1 r2 = r8.b
                        java.lang.String r2 = r3
                        r9.setGameKey(r2)
                        java.util.List r2 = r9.getProducts()
                        if (r2 != 0) goto L52
                        goto L72
                    L52:
                        java.util.Iterator r2 = r2.iterator()
                    L56:
                        boolean r4 = r2.hasNext()
                        if (r4 == 0) goto L72
                        java.lang.Object r4 = r2.next()
                        com.jihuanshe.model.GameCard r4 = (com.jihuanshe.model.GameCard) r4
                        com.jihuanshe.ui.widget.GameBar$a r5 = com.jihuanshe.ui.widget.GameBar.b
                        e.n.f r5 = r5.a()
                        java.lang.Object r5 = r5.getValue()
                        com.jihuanshe.model.Game r5 = (com.jihuanshe.model.Game) r5
                        r4.setGame(r5)
                        goto L56
                    L72:
                        com.jihuanshe.model.GameCard r2 = r9.getDefaultProduct()
                        if (r2 == 0) goto Lc1
                        com.jihuanshe.model.GameCard r2 = r9.getDefaultProduct()
                        r2.setDefaultProduct(r3)
                        java.util.List r2 = r9.getProducts()
                        r4 = 0
                        if (r2 != 0) goto L88
                        r2 = r4
                        goto L8c
                    L88:
                        java.util.List r2 = kotlin.collections.CollectionsKt___CollectionsKt.L5(r2)
                    L8c:
                        if (r2 != 0) goto L8f
                        goto Lc1
                    L8f:
                        java.util.Iterator r5 = r2.iterator()
                    L93:
                        boolean r6 = r5.hasNext()
                        if (r6 == 0) goto Laf
                        java.lang.Object r6 = r5.next()
                        r7 = r6
                        com.jihuanshe.model.GameCard r7 = (com.jihuanshe.model.GameCard) r7
                        boolean r7 = r7.getDefaultProduct()
                        java.lang.Boolean r7 = h.e2.k.a.a.a(r7)
                        boolean r7 = r7.booleanValue()
                        if (r7 == 0) goto L93
                        r4 = r6
                    Laf:
                        com.jihuanshe.model.GameCard r4 = (com.jihuanshe.model.GameCard) r4
                        if (r4 == 0) goto Lb6
                        r2.remove(r4)
                    Lb6:
                        r4 = 0
                        com.jihuanshe.model.GameCard r5 = r9.getDefaultProduct()
                        r2.add(r4, r5)
                        r9.setProducts(r2)
                    Lc1:
                        r0.label = r3
                        java.lang.Object r9 = r10.emit(r9, r0)
                        if (r9 != r1) goto Lca
                        return r1
                    Lca:
                        h.t1 r9 = h.t1.a
                        return r9
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.jihuanshe.viewmodel.plugins.impl.ProductBySellerCardVersionIdImpl$requestBySellerCardVersionID$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, h.e2.c):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @e
            public Object e(@d f<? super CardProductNew> fVar, @d c cVar) {
                Object e2 = Flow.this.e(new AnonymousClass2(fVar, this), cVar);
                return e2 == h.e2.j.b.h() ? e2 : t1.a;
            }
        }), lifecycleCoroutineScope, null, 2, null);
    }
}
