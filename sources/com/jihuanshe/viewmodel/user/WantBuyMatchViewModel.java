package com.jihuanshe.viewmodel.user;

import androidx.lifecycle.ViewModelKt;
import com.eth.ext.FlowKt;
import com.eth.model.NLive;
import com.jihuanshe.base.model.Result;
import com.jihuanshe.model.Game;
import com.jihuanshe.model.MatchResult;
import com.jihuanshe.ui.widget.GameBar;
import e.g.d.a;
import e.l.h.l.b;
import e.l.n.c.j;
import e.n.i;
import h.e2.c;
import h.k2.v.f0;
import h.t1;
import i.b.v3.f;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.flow.Flow;

/* loaded from: classes2.dex */
public final class WantBuyMatchViewModel extends b {
    @d
    private final NLive<List<MatchResult>> b = new NLive<>(null, 1, null);
    @d

    /* renamed from: c  reason: collision with root package name */
    private final i f4582c = new i(null, 1, null);

    @d
    public final a<List<MatchResult>> p0(@e Integer num) {
        j jVar = (j) e.l.n.a.d(j.class, false, false, false, 60L, true);
        GameBar.a aVar = GameBar.b;
        Game value = aVar.a().getValue();
        String gameKey = value == null ? null : value.getGameKey();
        Game value2 = aVar.a().getValue();
        final Flow<Result<List<MatchResult>>> a = jVar.a(gameKey, value2 == null ? null : value2.getGameSubKey(), num, Integer.valueOf(f0.g(this.f4582c.getValue(), Boolean.TRUE) ? 1 : 0));
        return a.h(FlowKt.a(new Flow<List<MatchResult>>() { // from class: com.jihuanshe.viewmodel.user.WantBuyMatchViewModel$getData$$inlined$map$1

            /* renamed from: com.jihuanshe.viewmodel.user.WantBuyMatchViewModel$getData$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes2.dex */
            public static final class AnonymousClass2 implements f<Result<List<? extends MatchResult>>> {
                public final /* synthetic */ f a;
                public final /* synthetic */ WantBuyMatchViewModel$getData$$inlined$map$1 b;

                /* renamed from: com.jihuanshe.viewmodel.user.WantBuyMatchViewModel$getData$$inlined$map$1$2$1  reason: invalid class name */
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

                public AnonymousClass2(f fVar, WantBuyMatchViewModel$getData$$inlined$map$1 wantBuyMatchViewModel$getData$$inlined$map$1) {
                    this.a = fVar;
                    this.b = wantBuyMatchViewModel$getData$$inlined$map$1;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
                /* JADX WARN: Removed duplicated region for block: B:30:0x006c A[Catch: all -> 0x0083, TryCatch #0 {all -> 0x0083, blocks: (B:18:0x004d, B:24:0x0060, B:30:0x006c, B:31:0x007d, B:21:0x0057), top: B:44:0x004d }] */
                /* JADX WARN: Removed duplicated region for block: B:38:0x0097 A[LOOP:0: B:36:0x0091->B:38:0x0097, LOOP_END] */
                /* JADX WARN: Removed duplicated region for block: B:41:0x00b5 A[RETURN] */
                @Override // i.b.v3.f
                @k.e.a.e
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public java.lang.Object emit(com.jihuanshe.base.model.Result<java.util.List<? extends com.jihuanshe.model.MatchResult>> r8, @k.e.a.d h.e2.c r9) {
                    /*
                        r7 = this;
                        boolean r0 = r9 instanceof com.jihuanshe.viewmodel.user.WantBuyMatchViewModel$getData$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r9
                        com.jihuanshe.viewmodel.user.WantBuyMatchViewModel$getData$$inlined$map$1$2$1 r0 = (com.jihuanshe.viewmodel.user.WantBuyMatchViewModel$getData$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.jihuanshe.viewmodel.user.WantBuyMatchViewModel$getData$$inlined$map$1$2$1 r0 = new com.jihuanshe.viewmodel.user.WantBuyMatchViewModel$getData$$inlined$map$1$2$1
                        r0.<init>(r9)
                    L18:
                        java.lang.Object r9 = r0.result
                        java.lang.Object r1 = h.e2.j.b.h()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L32
                        if (r2 != r3) goto L2a
                        h.r0.n(r9)
                        goto Lb6
                    L2a:
                        java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                        java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                        r8.<init>(r9)
                        throw r8
                    L32:
                        h.r0.n(r9)
                        i.b.v3.f r9 = r7.a
                        com.jihuanshe.base.model.Result r8 = (com.jihuanshe.base.model.Result) r8
                        java.util.ArrayList r2 = new java.util.ArrayList
                        r2.<init>()
                        java.lang.Object r4 = r8.getData()
                        java.util.List r4 = (java.util.List) r4
                        if (r4 != 0) goto L4a
                        java.util.List r4 = kotlin.collections.CollectionsKt__CollectionsKt.E()
                    L4a:
                        r2.addAll(r4)
                        kotlin.Result$a r4 = kotlin.Result.Companion     // Catch: java.lang.Throwable -> L83
                        okhttp3.Headers r8 = r8.getHeader()     // Catch: java.lang.Throwable -> L83
                        if (r8 != 0) goto L57
                        r8 = 0
                        goto L5d
                    L57:
                        java.lang.String r4 = "warehouse"
                        java.lang.String r8 = r8.get(r4)     // Catch: java.lang.Throwable -> L83
                    L5d:
                        r4 = 0
                        if (r8 == 0) goto L69
                        int r5 = r8.length()     // Catch: java.lang.Throwable -> L83
                        if (r5 != 0) goto L67
                        goto L69
                    L67:
                        r5 = 0
                        goto L6a
                    L69:
                        r5 = 1
                    L6a:
                        if (r5 != 0) goto L7d
                        e.l.r.f0 r5 = e.l.r.f0.a     // Catch: java.lang.Throwable -> L83
                        com.google.gson.Gson r5 = r5.a()     // Catch: java.lang.Throwable -> L83
                        java.lang.Class<com.jihuanshe.model.MatchResult> r6 = com.jihuanshe.model.MatchResult.class
                        java.lang.Object r8 = r5.n(r8, r6)     // Catch: java.lang.Throwable -> L83
                        com.jihuanshe.model.MatchResult r8 = (com.jihuanshe.model.MatchResult) r8     // Catch: java.lang.Throwable -> L83
                        r2.add(r4, r8)     // Catch: java.lang.Throwable -> L83
                    L7d:
                        h.t1 r8 = h.t1.a     // Catch: java.lang.Throwable -> L83
                        kotlin.Result.m106constructorimpl(r8)     // Catch: java.lang.Throwable -> L83
                        goto L8d
                    L83:
                        r8 = move-exception
                        kotlin.Result$a r4 = kotlin.Result.Companion
                        java.lang.Object r8 = h.r0.a(r8)
                        kotlin.Result.m106constructorimpl(r8)
                    L8d:
                        java.util.Iterator r8 = r2.iterator()
                    L91:
                        boolean r4 = r8.hasNext()
                        if (r4 == 0) goto Lad
                        java.lang.Object r4 = r8.next()
                        com.jihuanshe.model.MatchResult r4 = (com.jihuanshe.model.MatchResult) r4
                        com.jihuanshe.ui.widget.GameBar$a r5 = com.jihuanshe.ui.widget.GameBar.b
                        e.n.f r5 = r5.a()
                        java.lang.Object r5 = r5.getValue()
                        com.jihuanshe.model.Game r5 = (com.jihuanshe.model.Game) r5
                        r4.setGame(r5)
                        goto L91
                    Lad:
                        r0.label = r3
                        java.lang.Object r8 = r9.emit(r2, r0)
                        if (r8 != r1) goto Lb6
                        return r1
                    Lb6:
                        h.t1 r8 = h.t1.a
                        return r8
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.jihuanshe.viewmodel.user.WantBuyMatchViewModel$getData$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, h.e2.c):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @e
            public Object e(@d f<? super List<MatchResult>> fVar, @d c cVar) {
                Object e2 = Flow.this.e(new AnonymousClass2(fVar, this), cVar);
                return e2 == h.e2.j.b.h() ? e2 : t1.a;
            }
        }, this.b), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final NLive<List<MatchResult>> q0() {
        return this.b;
    }

    @d
    public final i r0() {
        return this.f4582c;
    }
}
