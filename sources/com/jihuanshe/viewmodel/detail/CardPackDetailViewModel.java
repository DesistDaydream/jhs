package com.jihuanshe.viewmodel.detail;

import androidx.lifecycle.ViewModelKt;
import com.eth.ext.FlowKt;
import com.eth.model.NLive;
import com.jihuanshe.model.Constants;
import com.jihuanshe.model.PackDetailResult;
import com.jihuanshe.model.Rarity;
import com.jihuanshe.model.TopCommentInfo;
import com.jihuanshe.viewmodel.UploadViewModel;
import com.vector.util.LayoutManagers;
import e.g.d.a;
import e.l.h.i.b;
import e.l.n.c.k;
import e.l.n.c.m;
import e.n.f;
import e.n.i;
import e.n.p;
import h.e2.c;
import h.t1;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.flow.Flow;

/* loaded from: classes2.dex */
public final class CardPackDetailViewModel extends UploadViewModel {
    @d

    /* renamed from: d  reason: collision with root package name */
    private final String f4381d = "pack";
    @d

    /* renamed from: e  reason: collision with root package name */
    private final f<PackDetailResult> f4382e = new f<>(null, 1, null);
    @d

    /* renamed from: f  reason: collision with root package name */
    private final NLive<List<TopCommentInfo>> f4383f = new NLive<>(null, 1, null);
    @d

    /* renamed from: g  reason: collision with root package name */
    private final p f4384g = new p("0");
    @d

    /* renamed from: h  reason: collision with root package name */
    private final i f4385h = new i(Boolean.FALSE);
    @d

    /* renamed from: i  reason: collision with root package name */
    private final f<List<Rarity>> f4386i = new f<>(null, 1, null);
    @d

    /* renamed from: j  reason: collision with root package name */
    private final f<LayoutManagers.a> f4387j = new f<>(LayoutManagers.f(LayoutManagers.a, 5, null, false, 6, null));

    @d
    public final a<PackDetailResult> A0(int i2, @e String str, @e String str2) {
        final Flow<b<PackDetailResult>> c2 = ((m) e.l.n.a.d(m.class, true, true, true, 60L, true)).c(i2, str, str2);
        return a.h(a.j(FlowKt.c(new Flow<PackDetailResult>() { // from class: com.jihuanshe.viewmodel.detail.CardPackDetailViewModel$getPackDetail$$inlined$map$1

            /* renamed from: com.jihuanshe.viewmodel.detail.CardPackDetailViewModel$getPackDetail$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes2.dex */
            public static final class AnonymousClass2 implements i.b.v3.f<b<PackDetailResult>> {
                public final /* synthetic */ i.b.v3.f a;
                public final /* synthetic */ CardPackDetailViewModel$getPackDetail$$inlined$map$1 b;

                /* renamed from: com.jihuanshe.viewmodel.detail.CardPackDetailViewModel$getPackDetail$$inlined$map$1$2$1  reason: invalid class name */
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

                public AnonymousClass2(i.b.v3.f fVar, CardPackDetailViewModel$getPackDetail$$inlined$map$1 cardPackDetailViewModel$getPackDetail$$inlined$map$1) {
                    this.a = fVar;
                    this.b = cardPackDetailViewModel$getPackDetail$$inlined$map$1;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
                @Override // i.b.v3.f
                @k.e.a.e
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public java.lang.Object emit(e.l.h.i.b<com.jihuanshe.model.PackDetailResult> r5, @k.e.a.d h.e2.c r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof com.jihuanshe.viewmodel.detail.CardPackDetailViewModel$getPackDetail$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        com.jihuanshe.viewmodel.detail.CardPackDetailViewModel$getPackDetail$$inlined$map$1$2$1 r0 = (com.jihuanshe.viewmodel.detail.CardPackDetailViewModel$getPackDetail$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.jihuanshe.viewmodel.detail.CardPackDetailViewModel$getPackDetail$$inlined$map$1$2$1 r0 = new com.jihuanshe.viewmodel.detail.CardPackDetailViewModel$getPackDetail$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = h.e2.j.b.h()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        h.r0.n(r6)
                        goto L45
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        h.r0.n(r6)
                        i.b.v3.f r6 = r4.a
                        e.l.h.i.b r5 = (e.l.h.i.b) r5
                        java.lang.Object r5 = r5.a()
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L45
                        return r1
                    L45:
                        h.t1 r5 = h.t1.a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.jihuanshe.viewmodel.detail.CardPackDetailViewModel$getPackDetail$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, h.e2.c):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @e
            public Object e(@d i.b.v3.f<? super PackDetailResult> fVar, @d c cVar) {
                Object e2 = Flow.this.e(new AnonymousClass2(fVar, this), cVar);
                return e2 == h.e2.j.b.h() ? e2 : t1.a;
            }
        }), null, new CardPackDetailViewModel$getPackDetail$2(str, str2, this), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final f<PackDetailResult> B0() {
        return this.f4382e;
    }

    @d
    public final String C0() {
        return this.f4381d;
    }

    @d
    public final NLive<List<TopCommentInfo>> D0() {
        return this.f4383f;
    }

    @d
    public final p E0() {
        return this.f4384g;
    }

    @d
    public final i F0() {
        return this.f4385h;
    }

    @d
    public final a<e.l.h.i.e<TopCommentInfo>> G0(@e String str, @e String str2) {
        e.l.n.c.f fVar = (e.l.n.c.f) e.l.n.a.d(e.l.n.c.f.class, true, false, false, 60L, true);
        String str3 = this.f4381d;
        PackDetailResult value = this.f4382e.getValue();
        final Flow<e.l.h.i.e<TopCommentInfo>> g2 = fVar.g(str3, null, value == null ? null : value.getId(), null, str, str2);
        return a.h(a.j(FlowKt.c(new Flow<e.l.h.i.e<TopCommentInfo>>() { // from class: com.jihuanshe.viewmodel.detail.CardPackDetailViewModel$getTopComments$$inlined$map$1

            /* renamed from: com.jihuanshe.viewmodel.detail.CardPackDetailViewModel$getTopComments$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes2.dex */
            public static final class AnonymousClass2 implements i.b.v3.f<e.l.h.i.e<TopCommentInfo>> {
                public final /* synthetic */ i.b.v3.f a;
                public final /* synthetic */ CardPackDetailViewModel$getTopComments$$inlined$map$1 b;

                /* renamed from: com.jihuanshe.viewmodel.detail.CardPackDetailViewModel$getTopComments$$inlined$map$1$2$1  reason: invalid class name */
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

                public AnonymousClass2(i.b.v3.f fVar, CardPackDetailViewModel$getTopComments$$inlined$map$1 cardPackDetailViewModel$getTopComments$$inlined$map$1) {
                    this.a = fVar;
                    this.b = cardPackDetailViewModel$getTopComments$$inlined$map$1;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
                @Override // i.b.v3.f
                @k.e.a.e
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public java.lang.Object emit(e.l.h.i.e<com.jihuanshe.model.TopCommentInfo> r8, @k.e.a.d h.e2.c r9) {
                    /*
                        r7 = this;
                        boolean r0 = r9 instanceof com.jihuanshe.viewmodel.detail.CardPackDetailViewModel$getTopComments$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r9
                        com.jihuanshe.viewmodel.detail.CardPackDetailViewModel$getTopComments$$inlined$map$1$2$1 r0 = (com.jihuanshe.viewmodel.detail.CardPackDetailViewModel$getTopComments$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.jihuanshe.viewmodel.detail.CardPackDetailViewModel$getTopComments$$inlined$map$1$2$1 r0 = new com.jihuanshe.viewmodel.detail.CardPackDetailViewModel$getTopComments$$inlined$map$1$2$1
                        r0.<init>(r9)
                    L18:
                        java.lang.Object r9 = r0.result
                        java.lang.Object r1 = h.e2.j.b.h()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        h.r0.n(r9)
                        goto L66
                    L29:
                        java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                        java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                        r8.<init>(r9)
                        throw r8
                    L31:
                        h.r0.n(r9)
                        i.b.v3.f r9 = r7.a
                        e.l.h.i.e r8 = (e.l.h.i.e) r8
                        java.util.List r2 = r8.b()
                        if (r2 != 0) goto L3f
                        goto L5d
                    L3f:
                        java.util.Iterator r2 = r2.iterator()
                    L43:
                        boolean r4 = r2.hasNext()
                        if (r4 == 0) goto L5d
                        java.lang.Object r4 = r2.next()
                        com.jihuanshe.model.TopCommentInfo r4 = (com.jihuanshe.model.TopCommentInfo) r4
                        com.jihuanshe.utils.StringUtil r5 = com.jihuanshe.utils.StringUtil.a
                        java.lang.String r6 = r4.getContent()
                        java.lang.CharSequence r5 = r5.i(r6)
                        r4.setHandleContent(r5)
                        goto L43
                    L5d:
                        r0.label = r3
                        java.lang.Object r8 = r9.emit(r8, r0)
                        if (r8 != r1) goto L66
                        return r1
                    L66:
                        h.t1 r8 = h.t1.a
                        return r8
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.jihuanshe.viewmodel.detail.CardPackDetailViewModel$getTopComments$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, h.e2.c):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @e
            public Object e(@d i.b.v3.f<? super e.l.h.i.e<TopCommentInfo>> fVar2, @d c cVar) {
                Object e2 = Flow.this.e(new AnonymousClass2(fVar2, this), cVar);
                return e2 == h.e2.j.b.h() ? e2 : t1.a;
            }
        }), null, new CardPackDetailViewModel$getTopComments$2(this), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final a<t1> H0(int i2, @e String str) {
        return a.h(a.j(FlowKt.c(((m) e.l.n.a.d(m.class, true, false, false, 60L, true)).b(i2, str)), null, new CardPackDetailViewModel$goLike$1(this), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final a<?> I0(@d TopCommentInfo topCommentInfo) {
        if (!topCommentInfo.isLike()) {
            topCommentInfo.setLike(true);
            topCommentInfo.setLikeCount(topCommentInfo.getLikeCount() + 1);
            return a.h(FlowKt.c(((e.l.n.c.f) e.l.n.a.d(e.l.n.c.f.class, true, false, false, 60L, true)).m(topCommentInfo.getReviewId())), ViewModelKt.getViewModelScope(this), null, 2, null);
        }
        topCommentInfo.setLike(false);
        topCommentInfo.setLikeCount(Math.max(0, topCommentInfo.getLikeCount() - 1));
        return a.h(FlowKt.c(((e.l.n.c.f) e.l.n.a.d(e.l.n.c.f.class, true, false, false, 60L, true)).i(topCommentInfo.getReviewId())), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final a<t1> J0(int i2, @d String str, @e String str2, @e String str3) {
        e.l.n.c.f fVar = (e.l.n.c.f) e.l.n.a.d(e.l.n.c.f.class, true, false, false, 60L, true);
        PackDetailResult value = this.f4382e.getValue();
        return a.h(a.j(FlowKt.c(fVar.h(null, value == null ? null : value.getId(), this.f4381d, i2, str, str2, str3)), null, CardPackDetailViewModel$goReviewsAndScore$1.INSTANCE, 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final a<t1> K0(int i2, @e String str) {
        return a.h(a.j(FlowKt.c(((m) e.l.n.a.d(m.class, true, false, false, 60L, true)).a(i2, str)), null, new CardPackDetailViewModel$goUnlike$1(this), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @e
    public final a<?> L0(@e String str, @e String str2) {
        PackDetailResult value = this.f4382e.getValue();
        if (value == null) {
            return null;
        }
        if (value.isDesire()) {
            value.setNeedRequest(false);
            value.setDesire(false);
            Integer desireCount = value.getDesireCount();
            value.setDesireCount(Integer.valueOf(Math.max((desireCount == null ? 0 : desireCount.intValue()) - 1, 0)));
            this.f4382e.n();
            return a.h(FlowKt.c(((k) e.l.n.a.d(k.class, true, false, false, 60L, true)).f(Constants.Companion.getTYPE_PACK(), null, value.getId(), str, str2)), ViewModelKt.getViewModelScope(this), null, 2, null);
        }
        value.setNeedRequest(false);
        value.setDesire(true);
        Integer desireCount2 = value.getDesireCount();
        value.setDesireCount(Integer.valueOf((desireCount2 != null ? desireCount2.intValue() : 0) + 1));
        this.f4382e.n();
        return a.h(FlowKt.c(((k) e.l.n.a.d(k.class, true, false, false, 60L, true)).W(Constants.Companion.getTYPE_PACK(), null, value.getId(), str, str2)), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final f<List<Rarity>> i() {
        return this.f4386i;
    }

    @d
    public final f<LayoutManagers.a> z0() {
        return this.f4387j;
    }
}
