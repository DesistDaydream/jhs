package com.jihuanshe.viewmodel.detail;

import androidx.lifecycle.ViewModelKt;
import com.eth.ext.FlowKt;
import com.eth.model.NLive;
import com.jihuanshe.R;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.base.model.Result;
import com.jihuanshe.model.CardDetailInfo;
import com.jihuanshe.model.CardInfo;
import com.jihuanshe.model.ConditionCount;
import com.jihuanshe.model.Constants;
import com.jihuanshe.model.DatePrice;
import com.jihuanshe.model.GameCard;
import com.jihuanshe.model.Rarity;
import com.jihuanshe.model.TopCommentInfo;
import com.jihuanshe.repo.ReportRepo;
import com.jihuanshe.ui.page.detail.CardViewInfo;
import com.jihuanshe.viewmodel.UploadViewModel;
import com.vector.design.ui.delegate.LoadMore;
import com.vector.util.Res;
import e.g.d.a;
import e.l.h.i.b;
import e.l.h.i.f;
import e.l.n.c.c;
import e.l.n.c.f;
import e.l.n.c.k;
import e.n.i;
import e.n.l;
import e.n.p;
import h.k2.v.f0;
import h.t1;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.flow.Flow;

/* loaded from: classes2.dex */
public final class CardDetailViewModel extends UploadViewModel {
    private int s;
    @e
    private Integer w;
    @e
    private a<e.l.h.i.e<GameCard>> x;
    @d

    /* renamed from: d  reason: collision with root package name */
    private final String f4369d = "card_version";
    @d

    /* renamed from: e  reason: collision with root package name */
    private final f f4370e = new f();
    @d

    /* renamed from: f  reason: collision with root package name */
    private final NLive<CardDetailInfo> f4371f = new NLive<>(null, 1, null);
    @d

    /* renamed from: g  reason: collision with root package name */
    private final NLive<CardInfo> f4372g = new NLive<>(null, 1, null);
    @d

    /* renamed from: h  reason: collision with root package name */
    private final NLive<List<TopCommentInfo>> f4373h = new NLive<>(null, 1, null);
    @d

    /* renamed from: i  reason: collision with root package name */
    private final p f4374i = new p("0");
    @d

    /* renamed from: j  reason: collision with root package name */
    private final i f4375j = new i(Boolean.FALSE);
    @d

    /* renamed from: k  reason: collision with root package name */
    private final l f4376k = new l(0);
    @d

    /* renamed from: l  reason: collision with root package name */
    private final e.n.f<ConditionCount> f4377l = new e.n.f<>(null, 1, null);
    @d

    /* renamed from: m  reason: collision with root package name */
    private final e.n.f<List<Rarity>> f4378m = new e.n.f<>(null, 1, null);
    @d
    private final e.n.f<Integer> n = new e.n.f<>(1);
    @d
    private final NLive<List<GameCard>> o = new NLive<>(null, 1, null);
    @d
    private final e.n.f<List<String>> p = ReportRepo.a.c();
    @d
    private final NLive<List<CardViewInfo>> q = new NLive<>(null, 1, null);
    @d
    private final NLive<List<DatePrice>> r = new NLive<>(null, 1, null);
    @d
    private final e.n.f<CharSequence> t = new e.n.f<>(null);
    @d
    private final e.n.f<DatePrice> u = new e.n.f<>(null);
    @d
    private final l v = new l(2);

    public static /* synthetic */ a R0(CardDetailViewModel cardDetailViewModel, int i2, String str, String str2, LoadMore.State state, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            state = null;
        }
        return cardDetailViewModel.Q0(i2, str, str2, state);
    }

    @d
    public final NLive<CardInfo> A0() {
        return this.f4372g;
    }

    @d
    public final a<CardDetailInfo> B0(int i2, @e final String str, @e final String str2) {
        final Flow<b<CardDetailInfo>> c2 = ((c) e.l.n.a.d(c.class, true, true, true, 60L, true)).c(i2, str, str2);
        return a.h(a.j(FlowKt.c(new Flow<CardDetailInfo>() { // from class: com.jihuanshe.viewmodel.detail.CardDetailViewModel$getCardDetail$$inlined$map$1

            /* renamed from: com.jihuanshe.viewmodel.detail.CardDetailViewModel$getCardDetail$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes2.dex */
            public static final class AnonymousClass2 implements i.b.v3.f<b<CardDetailInfo>> {
                public final /* synthetic */ i.b.v3.f a;
                public final /* synthetic */ CardDetailViewModel$getCardDetail$$inlined$map$1 b;

                /* renamed from: com.jihuanshe.viewmodel.detail.CardDetailViewModel$getCardDetail$$inlined$map$1$2$1  reason: invalid class name */
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

                public AnonymousClass2(i.b.v3.f fVar, CardDetailViewModel$getCardDetail$$inlined$map$1 cardDetailViewModel$getCardDetail$$inlined$map$1) {
                    this.a = fVar;
                    this.b = cardDetailViewModel$getCardDetail$$inlined$map$1;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
                @Override // i.b.v3.f
                @k.e.a.e
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public java.lang.Object emit(e.l.h.i.b<com.jihuanshe.model.CardDetailInfo> r7, @k.e.a.d h.e2.c r8) {
                    /*
                        r6 = this;
                        boolean r0 = r8 instanceof com.jihuanshe.viewmodel.detail.CardDetailViewModel$getCardDetail$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r8
                        com.jihuanshe.viewmodel.detail.CardDetailViewModel$getCardDetail$$inlined$map$1$2$1 r0 = (com.jihuanshe.viewmodel.detail.CardDetailViewModel$getCardDetail$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.jihuanshe.viewmodel.detail.CardDetailViewModel$getCardDetail$$inlined$map$1$2$1 r0 = new com.jihuanshe.viewmodel.detail.CardDetailViewModel$getCardDetail$$inlined$map$1$2$1
                        r0.<init>(r8)
                    L18:
                        java.lang.Object r8 = r0.result
                        java.lang.Object r1 = h.e2.j.b.h()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        h.r0.n(r8)
                        goto L55
                    L29:
                        java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                        java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                        r7.<init>(r8)
                        throw r7
                    L31:
                        h.r0.n(r8)
                        i.b.v3.f r8 = r6.a
                        e.l.h.i.b r7 = (e.l.h.i.b) r7
                        java.lang.Object r7 = r7.a()
                        r2 = r7
                        com.jihuanshe.model.CardDetailInfo r2 = (com.jihuanshe.model.CardDetailInfo) r2
                        com.jihuanshe.viewmodel.detail.CardDetailViewModel$getCardDetail$$inlined$map$1 r4 = r6.b
                        java.lang.String r5 = r2
                        java.lang.String r4 = r3
                        com.jihuanshe.model.Game r4 = e.l.l.a.b(r5, r4)
                        r2.setGame(r4)
                        r0.label = r3
                        java.lang.Object r7 = r8.emit(r7, r0)
                        if (r7 != r1) goto L55
                        return r1
                    L55:
                        h.t1 r7 = h.t1.a
                        return r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.jihuanshe.viewmodel.detail.CardDetailViewModel$getCardDetail$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, h.e2.c):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @e
            public Object e(@d i.b.v3.f<? super CardDetailInfo> fVar, @d h.e2.c cVar) {
                Object e2 = Flow.this.e(new AnonymousClass2(fVar, this), cVar);
                return e2 == h.e2.j.b.h() ? e2 : t1.a;
            }
        }), null, new CardDetailViewModel$getCardDetail$2(this), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final NLive<CardDetailInfo> C0() {
        return this.f4371f;
    }

    @d
    public final NLive<List<GameCard>> D0() {
        return this.o;
    }

    @d
    public final NLive<List<CardViewInfo>> E0() {
        return this.q;
    }

    @d
    public final e.n.f<ConditionCount> F0() {
        return this.f4377l;
    }

    @d
    public final e.n.f<List<Rarity>> G0() {
        return this.f4378m;
    }

    @d
    public final String H0(int i2) {
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    return Res.w(Res.a, R.string.card_detail_condition_4, null, 2, null);
                }
                return Res.w(Res.a, R.string.card_detail_condition_3, null, 2, null);
            }
            return Res.w(Res.a, R.string.card_detail_condition_2, null, 2, null);
        }
        return Res.w(Res.a, R.string.card_detail_condition_1, null, 2, null);
    }

    public final void I0() {
        ReportRepo.a.b(ViewModelKt.getViewModelScope(this));
    }

    @d
    public final e.n.f<Integer> J0() {
        return this.n;
    }

    @d
    public final l K0() {
        return this.f4376k;
    }

    @d
    public final l L0() {
        return this.v;
    }

    @d
    public final a<List<DatePrice>> M0(int i2, @e String str) {
        final Flow<b<List<DatePrice>>> d2 = ((e.l.n.c.b) e.l.n.a.d(e.l.n.c.b.class, true, true, true, 60L, true)).d(i2, Constants.Companion.getFILTER_TYPE().get(this.v.getValue().intValue()), str);
        return a.h(a.o(a.j(FlowKt.a(new Flow<List<? extends DatePrice>>() { // from class: com.jihuanshe.viewmodel.detail.CardDetailViewModel$getHistoryPrice$$inlined$map$1

            /* renamed from: com.jihuanshe.viewmodel.detail.CardDetailViewModel$getHistoryPrice$$inlined$map$1$2 */
            /* loaded from: classes2.dex */
            public static final class AnonymousClass2 implements i.b.v3.f<b<List<? extends DatePrice>>> {
                public final /* synthetic */ i.b.v3.f a;
                public final /* synthetic */ CardDetailViewModel$getHistoryPrice$$inlined$map$1 b;

                /* renamed from: com.jihuanshe.viewmodel.detail.CardDetailViewModel$getHistoryPrice$$inlined$map$1$2$1 */
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

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public AnonymousClass1(h.e2.c cVar) {
                        super(cVar);
                        AnonymousClass2.this = r1;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @e
                    public final Object invokeSuspend(@d Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(i.b.v3.f fVar, CardDetailViewModel$getHistoryPrice$$inlined$map$1 cardDetailViewModel$getHistoryPrice$$inlined$map$1) {
                    this.a = fVar;
                    this.b = cardDetailViewModel$getHistoryPrice$$inlined$map$1;
                }

                /* JADX WARN: Removed duplicated region for block: B:48:0x0023  */
                /* JADX WARN: Removed duplicated region for block: B:52:0x0031  */
                @Override // i.b.v3.f
                @k.e.a.e
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public java.lang.Object emit(e.l.h.i.b<java.util.List<? extends com.jihuanshe.model.DatePrice>> r5, @k.e.a.d h.e2.c r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof com.jihuanshe.viewmodel.detail.CardDetailViewModel$getHistoryPrice$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        com.jihuanshe.viewmodel.detail.CardDetailViewModel$getHistoryPrice$$inlined$map$1$2$1 r0 = (com.jihuanshe.viewmodel.detail.CardDetailViewModel$getHistoryPrice$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.jihuanshe.viewmodel.detail.CardDetailViewModel$getHistoryPrice$$inlined$map$1$2$1 r0 = new com.jihuanshe.viewmodel.detail.CardDetailViewModel$getHistoryPrice$$inlined$map$1$2$1
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
                    throw new UnsupportedOperationException("Method not decompiled: com.jihuanshe.viewmodel.detail.CardDetailViewModel$getHistoryPrice$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, h.e2.c):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @e
            public Object e(@d i.b.v3.f<? super List<? extends DatePrice>> fVar, @d h.e2.c cVar) {
                Object e2 = d2.e(new AnonymousClass2(fVar, this), cVar);
                return e2 == h.e2.j.b.h() ? e2 : t1.a;
            }
        }, this.r), null, new CardDetailViewModel$getHistoryPrice$2(this, i2), 1, null), null, new CardDetailViewModel$getHistoryPrice$3(this), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final e.n.f<DatePrice> N0() {
        return this.u;
    }

    public final int O0() {
        return this.s;
    }

    @d
    public final e.n.f<CharSequence> P0() {
        return this.t;
    }

    @d
    public final a<e.l.h.i.e<GameCard>> Q0(int i2, @e String str, @e String str2, @e final LoadMore.State state) {
        Flow<e.l.h.i.e<GameCard>> flow;
        a<e.l.h.i.e<GameCard>> aVar = this.x;
        if (aVar != null) {
            aVar.b();
        }
        Integer value = this.f4376k.getValue();
        if (value != null && value.intValue() == 0) {
            final Flow<Result<e.l.h.i.e<GameCard>>> a = ((c) e.l.n.a.d(c.class, false, false, false, 60L, true)).a(i2, this.n.getValue().intValue(), this.f4370e.a(state).d(), str, str2);
            flow = new Flow<e.l.h.i.e<GameCard>>() { // from class: com.jihuanshe.viewmodel.detail.CardDetailViewModel$getOnSaleCardList$$inlined$map$1

                /* renamed from: com.jihuanshe.viewmodel.detail.CardDetailViewModel$getOnSaleCardList$$inlined$map$1$2  reason: invalid class name */
                /* loaded from: classes2.dex */
                public static final class AnonymousClass2 implements i.b.v3.f<Result<e.l.h.i.e<GameCard>>> {
                    public final /* synthetic */ i.b.v3.f a;
                    public final /* synthetic */ CardDetailViewModel$getOnSaleCardList$$inlined$map$1 b;

                    /* renamed from: com.jihuanshe.viewmodel.detail.CardDetailViewModel$getOnSaleCardList$$inlined$map$1$2$1  reason: invalid class name */
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

                    public AnonymousClass2(i.b.v3.f fVar, CardDetailViewModel$getOnSaleCardList$$inlined$map$1 cardDetailViewModel$getOnSaleCardList$$inlined$map$1) {
                        this.a = fVar;
                        this.b = cardDetailViewModel$getOnSaleCardList$$inlined$map$1;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
                    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
                    /* JADX WARN: Removed duplicated region for block: B:66:0x01aa A[Catch: all -> 0x0226, TryCatch #0 {all -> 0x0226, blocks: (B:54:0x018b, B:60:0x019e, B:66:0x01aa, B:71:0x01cc, B:72:0x01d0, B:76:0x01eb, B:80:0x0211, B:83:0x021d, B:79:0x01fc, B:75:0x01e4, B:69:0x01c6, B:84:0x0220, B:57:0x0195), top: B:93:0x018b }] */
                    @Override // i.b.v3.f
                    @k.e.a.e
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public java.lang.Object emit(com.jihuanshe.base.model.Result<e.l.h.i.e<com.jihuanshe.model.GameCard>> r10, @k.e.a.d h.e2.c r11) {
                        /*
                            Method dump skipped, instructions count: 576
                            To view this dump change 'Code comments level' option to 'DEBUG'
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.jihuanshe.viewmodel.detail.CardDetailViewModel$getOnSaleCardList$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, h.e2.c):java.lang.Object");
                    }
                }

                @Override // kotlinx.coroutines.flow.Flow
                @e
                public Object e(@d i.b.v3.f<? super e.l.h.i.e<GameCard>> fVar, @d h.e2.c cVar) {
                    Object e2 = Flow.this.e(new AnonymousClass2(fVar, this), cVar);
                    return e2 == h.e2.j.b.h() ? e2 : t1.a;
                }
            };
        } else {
            final Flow<Result<e.l.h.i.e<GameCard>>> b = ((c) e.l.n.a.d(c.class, false, false, false, 60L, true)).b(i2, this.f4370e.a(state).d(), str, str2);
            flow = new Flow<e.l.h.i.e<GameCard>>() { // from class: com.jihuanshe.viewmodel.detail.CardDetailViewModel$getOnSaleCardList$$inlined$map$2

                /* renamed from: com.jihuanshe.viewmodel.detail.CardDetailViewModel$getOnSaleCardList$$inlined$map$2$2  reason: invalid class name */
                /* loaded from: classes2.dex */
                public static final class AnonymousClass2 implements i.b.v3.f<Result<e.l.h.i.e<GameCard>>> {
                    public final /* synthetic */ i.b.v3.f a;
                    public final /* synthetic */ CardDetailViewModel$getOnSaleCardList$$inlined$map$2 b;

                    /* renamed from: com.jihuanshe.viewmodel.detail.CardDetailViewModel$getOnSaleCardList$$inlined$map$2$2$1  reason: invalid class name */
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

                    public AnonymousClass2(i.b.v3.f fVar, CardDetailViewModel$getOnSaleCardList$$inlined$map$2 cardDetailViewModel$getOnSaleCardList$$inlined$map$2) {
                        this.a = fVar;
                        this.b = cardDetailViewModel$getOnSaleCardList$$inlined$map$2;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
                    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
                    @Override // i.b.v3.f
                    @k.e.a.e
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public java.lang.Object emit(com.jihuanshe.base.model.Result<e.l.h.i.e<com.jihuanshe.model.GameCard>> r8, @k.e.a.d h.e2.c r9) {
                        /*
                            Method dump skipped, instructions count: 241
                            To view this dump change 'Code comments level' option to 'DEBUG'
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.jihuanshe.viewmodel.detail.CardDetailViewModel$getOnSaleCardList$$inlined$map$2.AnonymousClass2.emit(java.lang.Object, h.e2.c):java.lang.Object");
                    }
                }

                @Override // kotlinx.coroutines.flow.Flow
                @e
                public Object e(@d i.b.v3.f<? super e.l.h.i.e<GameCard>> fVar, @d h.e2.c cVar) {
                    Object e2 = Flow.this.e(new AnonymousClass2(fVar, this), cVar);
                    return e2 == h.e2.j.b.h() ? e2 : t1.a;
                }
            };
        }
        a<e.l.h.i.e<GameCard>> h2 = a.h(a.o(BinderKt.b(FlowKt.c(flow), this.o, this.f4370e.f()), null, new CardDetailViewModel$getOnSaleCardList$3(this), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
        this.x = h2;
        return h2;
    }

    @d
    public final NLive<List<DatePrice>> S0() {
        return this.r;
    }

    @d
    public final e.n.f<List<String>> T0() {
        return this.p;
    }

    @e
    public final Integer U0() {
        return this.w;
    }

    @d
    public final String V0() {
        return this.f4369d;
    }

    @d
    public final NLive<List<TopCommentInfo>> W0() {
        return this.f4373h;
    }

    @d
    public final p X0() {
        return this.f4374i;
    }

    @d
    public final i Y0() {
        return this.f4375j;
    }

    @d
    public final a<e.l.h.i.e<TopCommentInfo>> Z0(@e String str, @e String str2) {
        e.l.n.c.f fVar = (e.l.n.c.f) e.l.n.a.d(e.l.n.c.f.class, true, false, false, 60L, true);
        String str3 = this.f4369d;
        CardDetailInfo value = this.f4371f.getValue();
        final Flow<e.l.h.i.e<TopCommentInfo>> g2 = fVar.g(str3, value == null ? null : value.getId(), null, 1, str, str2);
        return a.h(a.j(FlowKt.c(new Flow<e.l.h.i.e<TopCommentInfo>>() { // from class: com.jihuanshe.viewmodel.detail.CardDetailViewModel$getTopComments$$inlined$map$1

            /* renamed from: com.jihuanshe.viewmodel.detail.CardDetailViewModel$getTopComments$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes2.dex */
            public static final class AnonymousClass2 implements i.b.v3.f<e.l.h.i.e<TopCommentInfo>> {
                public final /* synthetic */ i.b.v3.f a;
                public final /* synthetic */ CardDetailViewModel$getTopComments$$inlined$map$1 b;

                /* renamed from: com.jihuanshe.viewmodel.detail.CardDetailViewModel$getTopComments$$inlined$map$1$2$1  reason: invalid class name */
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

                public AnonymousClass2(i.b.v3.f fVar, CardDetailViewModel$getTopComments$$inlined$map$1 cardDetailViewModel$getTopComments$$inlined$map$1) {
                    this.a = fVar;
                    this.b = cardDetailViewModel$getTopComments$$inlined$map$1;
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
                        boolean r0 = r9 instanceof com.jihuanshe.viewmodel.detail.CardDetailViewModel$getTopComments$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r9
                        com.jihuanshe.viewmodel.detail.CardDetailViewModel$getTopComments$$inlined$map$1$2$1 r0 = (com.jihuanshe.viewmodel.detail.CardDetailViewModel$getTopComments$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.jihuanshe.viewmodel.detail.CardDetailViewModel$getTopComments$$inlined$map$1$2$1 r0 = new com.jihuanshe.viewmodel.detail.CardDetailViewModel$getTopComments$$inlined$map$1$2$1
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
                    throw new UnsupportedOperationException("Method not decompiled: com.jihuanshe.viewmodel.detail.CardDetailViewModel$getTopComments$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, h.e2.c):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @e
            public Object e(@d i.b.v3.f<? super e.l.h.i.e<TopCommentInfo>> fVar2, @d h.e2.c cVar) {
                Object e2 = Flow.this.e(new AnonymousClass2(fVar2, this), cVar);
                return e2 == h.e2.j.b.h() ? e2 : t1.a;
            }
        }), null, new CardDetailViewModel$getTopComments$2(this), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final a<List<CardViewInfo>> a1(int i2, @e String str) {
        return a.h(a.j(FlowKt.c(((e.l.n.c.b) e.l.n.a.d(e.l.n.c.b.class, true, false, false, 60L, true)).a(i2, str)), null, new CardDetailViewModel$getUserImages$1(this), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final a<t1> b1(@d String str, @d String str2, @d List<String> list) {
        Integer id;
        int i2 = 0;
        e.l.n.c.f fVar = (e.l.n.c.f) e.l.n.a.d(e.l.n.c.f.class, true, false, false, 60L, true);
        CardDetailInfo value = this.f4371f.getValue();
        if (value != null && (id = value.getId()) != null) {
            i2 = id.intValue();
        }
        return a.h(a.j(FlowKt.c(f.a.b(fVar, i2, str, str2, list, null, 16, null)), null, new CardDetailViewModel$goErrorCorrect$1(this), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final a<t1> c1(int i2) {
        return a.h(FlowKt.c(f.a.c((e.l.n.c.f) e.l.n.a.d(e.l.n.c.f.class, true, false, false, 60L, true), i2, null, 2, null)), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final a<?> d1(@d TopCommentInfo topCommentInfo) {
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
    public final a<t1> e1(int i2, @d String str, @e String str2, @e String str3) {
        e.l.n.c.f fVar = (e.l.n.c.f) e.l.n.a.d(e.l.n.c.f.class, true, false, false, 60L, true);
        CardDetailInfo value = this.f4371f.getValue();
        return a.h(FlowKt.c(fVar.h(value == null ? null : value.getId(), null, this.f4369d, i2, str, str2, str3)), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final a<t1> f1(int i2) {
        return a.h(FlowKt.c(f.a.e((e.l.n.c.f) e.l.n.a.d(e.l.n.c.f.class, true, false, false, 60L, true), i2, null, 2, null)), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @e
    public final a<?> g1(@e String str, @e String str2) {
        CardDetailInfo value = this.f4371f.getValue();
        if (value == null) {
            return null;
        }
        Boolean isDesire = value.isDesire();
        Boolean bool = Boolean.TRUE;
        if (f0.g(isDesire, bool)) {
            value.setDesire(Boolean.FALSE);
            Integer desireCount = value.getDesireCount();
            value.setDesireCount(Integer.valueOf(Math.max((desireCount == null ? 0 : desireCount.intValue()) - 1, 0)));
            this.f4371f.n();
            return a.h(FlowKt.c(((k) e.l.n.a.d(k.class, true, false, false, 60L, true)).f(Constants.Companion.getTYPE_CARD(), value.getId(), null, str, str2)), ViewModelKt.getViewModelScope(this), null, 2, null);
        }
        value.setDesire(bool);
        Integer desireCount2 = value.getDesireCount();
        value.setDesireCount(Integer.valueOf((desireCount2 != null ? desireCount2.intValue() : 0) + 1));
        this.f4371f.n();
        return a.h(FlowKt.c(((k) e.l.n.a.d(k.class, true, false, false, 60L, true)).W(Constants.Companion.getTYPE_CARD(), value.getId(), null, str, str2)), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    public final void h1(int i2) {
        this.s = i2;
    }

    public final void i1(@e Integer num) {
        this.w = num;
    }
}
