package com.jihuanshe.viewmodel.search.globals;

import androidx.lifecycle.ViewModelKt;
import com.eth.ext.FlowKt;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.base.model.Result;
import com.jihuanshe.model.Constants;
import com.jihuanshe.model.Product;
import com.jihuanshe.model.Rarity;
import com.vector.design.ui.delegate.LoadMore;
import e.g.d.a;
import e.l.h.i.f;
import e.l.h.l.b;
import e.n.l;
import h.e2.c;
import h.k2.v.f0;
import h.t1;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.flow.Flow;

/* loaded from: classes2.dex */
public final class SearchProductViewModel extends b {
    @d
    private final f b = new f();
    @d

    /* renamed from: c  reason: collision with root package name */
    private final e.n.f<List<Product>> f4522c = new e.n.f<>(null, 1, null);
    @d

    /* renamed from: d  reason: collision with root package name */
    private String f4523d = "";
    @d

    /* renamed from: e  reason: collision with root package name */
    private e.n.f<List<Rarity>> f4524e = new e.n.f<>(null, 1, null);
    @d

    /* renamed from: f  reason: collision with root package name */
    private final l f4525f = new l(null, 1, null);

    public static /* synthetic */ a v0(SearchProductViewModel searchProductViewModel, String str, String str2, String str3, String str4, LoadMore.State state, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            state = null;
        }
        return searchProductViewModel.u0(str, str2, str3, str4, state);
    }

    @d
    public final e.n.f<List<Product>> q0() {
        return this.f4522c;
    }

    @d
    public final String r0() {
        return this.f4523d;
    }

    @d
    public final e.n.f<List<Rarity>> s0() {
        return this.f4524e;
    }

    @d
    public final l t0() {
        return this.f4525f;
    }

    @d
    public final a<? extends Object> u0(@e final String str, @e final String str2, @e final String str3, @e String str4, @e LoadMore.State state) {
        Integer value = this.f4525f.getValue();
        if (value == null || value.intValue() != 0) {
            final Flow<Result<e.l.h.i.e<Product>>> b = e.l.o.b.a.a.b(str, this.f4523d, str2, str3, !f0.g(str, Constants.Companion.getSEARCH_TYPE_PACK()) ? str4 : null, this.b.a(state).d());
            return a.h(a.o(BinderKt.b(FlowKt.c(new Flow<e.l.h.i.e<Product>>() { // from class: com.jihuanshe.viewmodel.search.globals.SearchProductViewModel$search$$inlined$map$1

                /* renamed from: com.jihuanshe.viewmodel.search.globals.SearchProductViewModel$search$$inlined$map$1$2  reason: invalid class name */
                /* loaded from: classes2.dex */
                public static final class AnonymousClass2 implements i.b.v3.f<Result<e.l.h.i.e<Product>>> {
                    public final /* synthetic */ i.b.v3.f a;
                    public final /* synthetic */ SearchProductViewModel$search$$inlined$map$1 b;

                    /* renamed from: com.jihuanshe.viewmodel.search.globals.SearchProductViewModel$search$$inlined$map$1$2$1  reason: invalid class name */
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

                    public AnonymousClass2(i.b.v3.f fVar, SearchProductViewModel$search$$inlined$map$1 searchProductViewModel$search$$inlined$map$1) {
                        this.a = fVar;
                        this.b = searchProductViewModel$search$$inlined$map$1;
                    }

                    /* JADX WARN: Can't wrap try/catch for region: R(12:1|(2:3|(10:5|6|7|(1:(1:(3:11|12|13)(2:15|16))(2:17|18))(2:32|(5:34|35|(1:37)(1:41)|38|(1:40)))|19|(1:21)(2:25|(3:27|(2:30|28)|31))|22|(1:24)|12|13))|43|6|7|(0)(0)|19|(0)(0)|22|(0)|12|13) */
                    /* JADX WARN: Code restructure failed: missing block: B:18:0x0042, code lost:
                        r2 = r2;
                     */
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
                    /* JADX WARN: Removed duplicated region for block: B:19:0x0044  */
                    /* JADX WARN: Removed duplicated region for block: B:31:0x009b  */
                    /* JADX WARN: Removed duplicated region for block: B:32:0x009d  */
                    /* JADX WARN: Removed duplicated region for block: B:41:0x00c4 A[RETURN] */
                    /* JADX WARN: Type inference failed for: r2v1, types: [i.b.v3.f] */
                    /* JADX WARN: Type inference failed for: r2v5 */
                    @Override // i.b.v3.f
                    @k.e.a.e
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public java.lang.Object emit(com.jihuanshe.base.model.Result<e.l.h.i.e<com.jihuanshe.model.Product>> r10, @k.e.a.d h.e2.c r11) {
                        /*
                            r9 = this;
                            boolean r0 = r11 instanceof com.jihuanshe.viewmodel.search.globals.SearchProductViewModel$search$$inlined$map$1.AnonymousClass2.AnonymousClass1
                            if (r0 == 0) goto L13
                            r0 = r11
                            com.jihuanshe.viewmodel.search.globals.SearchProductViewModel$search$$inlined$map$1$2$1 r0 = (com.jihuanshe.viewmodel.search.globals.SearchProductViewModel$search$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                            int r1 = r0.label
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.label = r1
                            goto L18
                        L13:
                            com.jihuanshe.viewmodel.search.globals.SearchProductViewModel$search$$inlined$map$1$2$1 r0 = new com.jihuanshe.viewmodel.search.globals.SearchProductViewModel$search$$inlined$map$1$2$1
                            r0.<init>(r11)
                        L18:
                            java.lang.Object r11 = r0.result
                            java.lang.Object r1 = h.e2.j.b.h()
                            int r2 = r0.label
                            r3 = 2
                            r4 = 1
                            r5 = 0
                            if (r2 == 0) goto L44
                            if (r2 == r4) goto L36
                            if (r2 != r3) goto L2e
                            h.r0.n(r11)
                            goto Lc5
                        L2e:
                            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
                            r10.<init>(r11)
                            throw r10
                        L36:
                            java.lang.Object r10 = r0.L$1
                            com.jihuanshe.base.model.Result r10 = (com.jihuanshe.base.model.Result) r10
                            java.lang.Object r2 = r0.L$0
                            i.b.v3.f r2 = (i.b.v3.f) r2
                            h.r0.n(r11)     // Catch: java.lang.Exception -> L42
                            goto L93
                        L42:
                            goto L93
                        L44:
                            h.r0.n(r11)
                            i.b.v3.f r2 = r9.a
                            com.jihuanshe.base.model.Result r10 = (com.jihuanshe.base.model.Result) r10
                            com.jihuanshe.viewmodel.search.globals.SearchProductViewModel$search$$inlined$map$1 r11 = r9.b
                            java.lang.String r11 = r2
                            com.jihuanshe.model.Constants$Companion r6 = com.jihuanshe.model.Constants.Companion
                            java.lang.String r6 = r6.getSEARCH_TYPE_PACK()
                            boolean r11 = h.k2.v.f0.g(r11, r6)
                            if (r11 != 0) goto L93
                            java.util.ArrayList r11 = new java.util.ArrayList
                            r11.<init>()
                            e.l.r.f0 r6 = e.l.r.f0.a     // Catch: java.lang.Exception -> L42
                            okhttp3.Headers r7 = r10.getHeader()     // Catch: java.lang.Exception -> L42
                            if (r7 != 0) goto L6a
                            r7 = r5
                            goto L70
                        L6a:
                            java.lang.String r8 = "rarities_count"
                            java.lang.String r7 = r7.get(r8)     // Catch: java.lang.Exception -> L42
                        L70:
                            java.lang.Class<com.jihuanshe.model.Rarity> r8 = com.jihuanshe.model.Rarity.class
                            java.util.List r6 = r6.b(r7, r8)     // Catch: java.lang.Exception -> L42
                            r11.addAll(r6)     // Catch: java.lang.Exception -> L42
                            i.b.l2 r6 = i.b.b1.e()     // Catch: java.lang.Exception -> L42
                            com.jihuanshe.viewmodel.search.globals.SearchProductViewModel$search$1$1 r7 = new com.jihuanshe.viewmodel.search.globals.SearchProductViewModel$search$1$1     // Catch: java.lang.Exception -> L42
                            com.jihuanshe.viewmodel.search.globals.SearchProductViewModel$search$$inlined$map$1 r8 = r9.b     // Catch: java.lang.Exception -> L42
                            com.jihuanshe.viewmodel.search.globals.SearchProductViewModel r8 = r3     // Catch: java.lang.Exception -> L42
                            r7.<init>(r8, r11, r5)     // Catch: java.lang.Exception -> L42
                            r0.L$0 = r2     // Catch: java.lang.Exception -> L42
                            r0.L$1 = r10     // Catch: java.lang.Exception -> L42
                            r0.label = r4     // Catch: java.lang.Exception -> L42
                            java.lang.Object r11 = i.b.g.i(r6, r7, r0)     // Catch: java.lang.Exception -> L42
                            if (r11 != r1) goto L93
                            return r1
                        L93:
                            java.lang.Object r10 = r10.getData()
                            e.l.h.i.e r10 = (e.l.h.i.e) r10
                            if (r10 != 0) goto L9d
                            r10 = r5
                            goto Lb8
                        L9d:
                            java.util.List r11 = r10.b()
                            if (r11 != 0) goto La4
                            goto Lb8
                        La4:
                            java.util.Iterator r11 = r11.iterator()
                        La8:
                            boolean r4 = r11.hasNext()
                            if (r4 == 0) goto Lb8
                            java.lang.Object r4 = r11.next()
                            com.jihuanshe.model.Product r4 = (com.jihuanshe.model.Product) r4
                            r4.updateData(r4)
                            goto La8
                        Lb8:
                            r0.L$0 = r5
                            r0.L$1 = r5
                            r0.label = r3
                            java.lang.Object r10 = r2.emit(r10, r0)
                            if (r10 != r1) goto Lc5
                            return r1
                        Lc5:
                            h.t1 r10 = h.t1.a
                            return r10
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.jihuanshe.viewmodel.search.globals.SearchProductViewModel$search$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, h.e2.c):java.lang.Object");
                    }
                }

                @Override // kotlinx.coroutines.flow.Flow
                @e
                public Object e(@d i.b.v3.f<? super e.l.h.i.e<Product>> fVar, @d c cVar) {
                    Object e2 = Flow.this.e(new AnonymousClass2(fVar, this), cVar);
                    return e2 == h.e2.j.b.h() ? e2 : t1.a;
                }
            }), this.f4522c, this.b.f()), null, new SearchProductViewModel$search$2(this), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
        }
        final Flow<Result<e.l.h.i.b<e.l.h.i.e<Product>>>> a = e.l.o.b.a.a.a(this.f4523d, str4, str2, str3, this.b.a(state).d());
        return a.h(a.o(BinderKt.a(FlowKt.c(new Flow<e.l.h.i.b<e.l.h.i.e<Product>>>() { // from class: com.jihuanshe.viewmodel.search.globals.SearchProductViewModel$search$$inlined$map$2

            /* renamed from: com.jihuanshe.viewmodel.search.globals.SearchProductViewModel$search$$inlined$map$2$2  reason: invalid class name */
            /* loaded from: classes2.dex */
            public static final class AnonymousClass2 implements i.b.v3.f<Result<e.l.h.i.b<e.l.h.i.e<Product>>>> {
                public final /* synthetic */ i.b.v3.f a;
                public final /* synthetic */ SearchProductViewModel$search$$inlined$map$2 b;

                /* renamed from: com.jihuanshe.viewmodel.search.globals.SearchProductViewModel$search$$inlined$map$2$2$1  reason: invalid class name */
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

                public AnonymousClass2(i.b.v3.f fVar, SearchProductViewModel$search$$inlined$map$2 searchProductViewModel$search$$inlined$map$2) {
                    this.a = fVar;
                    this.b = searchProductViewModel$search$$inlined$map$2;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
                /* JADX WARN: Removed duplicated region for block: B:19:0x0048  */
                /* JADX WARN: Removed duplicated region for block: B:32:0x00a2  */
                /* JADX WARN: Removed duplicated region for block: B:33:0x00a4  */
                /* JADX WARN: Removed duplicated region for block: B:42:0x00ee A[RETURN] */
                @Override // i.b.v3.f
                @k.e.a.e
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public java.lang.Object emit(com.jihuanshe.base.model.Result<e.l.h.i.b<e.l.h.i.e<com.jihuanshe.model.Product>>> r10, @k.e.a.d h.e2.c r11) {
                    /*
                        Method dump skipped, instructions count: 242
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.jihuanshe.viewmodel.search.globals.SearchProductViewModel$search$$inlined$map$2.AnonymousClass2.emit(java.lang.Object, h.e2.c):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @e
            public Object e(@d i.b.v3.f<? super e.l.h.i.b<e.l.h.i.e<Product>>> fVar, @d c cVar) {
                Object e2 = Flow.this.e(new AnonymousClass2(fVar, this), cVar);
                return e2 == h.e2.j.b.h() ? e2 : t1.a;
            }
        }), this.f4522c, this.b.f()), null, new SearchProductViewModel$search$4(this), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    public final void w0(@d String str) {
        this.f4523d = str;
    }

    public final void x0(@d e.n.f<List<Rarity>> fVar) {
        this.f4524e = fVar;
    }
}
