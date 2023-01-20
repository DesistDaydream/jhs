package com.jihuanshe.viewmodel.detail;

import androidx.lifecycle.ViewModelKt;
import com.eth.ext.FlowKt;
import com.eth.model.NLive;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.Constants;
import com.jihuanshe.model.ReviewListInfo;
import com.jihuanshe.model.ReviewMineInfo;
import com.jihuanshe.viewmodel.UploadViewModel;
import com.vector.design.ui.delegate.LoadMore;
import e.g.d.a;
import e.l.h.i.f;
import e.l.n.c.f;
import e.n.i;
import e.n.l;
import h.e2.c;
import h.e2.j.b;
import h.t1;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.Pair;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.flow.Flow;

/* loaded from: classes2.dex */
public final class ReviewListViewModel extends UploadViewModel {
    @d

    /* renamed from: d  reason: collision with root package name */
    private final f f4398d = new f();
    @d

    /* renamed from: e  reason: collision with root package name */
    private final i f4399e;
    @d

    /* renamed from: f  reason: collision with root package name */
    private final i f4400f;
    @d

    /* renamed from: g  reason: collision with root package name */
    private final i f4401g;
    @d

    /* renamed from: h  reason: collision with root package name */
    private final NLive<List<ReviewListInfo>> f4402h;
    @d

    /* renamed from: i  reason: collision with root package name */
    private final l f4403i;
    @d

    /* renamed from: j  reason: collision with root package name */
    private final NLive<ReviewMineInfo> f4404j;
    @d

    /* renamed from: k  reason: collision with root package name */
    private final e.n.f<List<Pair<String, String>>> f4405k;
    @d

    /* renamed from: l  reason: collision with root package name */
    private final e.n.f<Pair<String, String>> f4406l;
    @d

    /* renamed from: m  reason: collision with root package name */
    private final l f4407m;

    public ReviewListViewModel() {
        Boolean bool = Boolean.FALSE;
        this.f4399e = new i(bool);
        this.f4400f = new i(bool);
        this.f4401g = new i(bool);
        this.f4402h = new NLive<>(null, 1, null);
        this.f4403i = new l(null, 1, null);
        this.f4404j = new NLive<>(null, 1, null);
        Constants.Companion companion = Constants.Companion;
        this.f4405k = new e.n.f<>(companion.getSORT_TYPE_REVIEW());
        this.f4406l = new e.n.f<>(companion.getSORT_TYPE_REVIEW().get(0));
        this.f4407m = new l(1);
    }

    @d
    public final l A0() {
        return this.f4407m;
    }

    @d
    public final e.n.f<Pair<String, String>> B0() {
        return this.f4406l;
    }

    @d
    public final a<ReviewMineInfo> C0(@d String str, @e Integer num, @e Integer num2, @e String str2, @e String str3) {
        return a.h(a.o(a.j(FlowKt.c(((e.l.n.c.f) e.l.n.a.d(e.l.n.c.f.class, true, false, false, 60L, true)).c(str, num, num2, str2, str3)), null, new ReviewListViewModel$getMineReviews$1(this), 1, null), null, new ReviewListViewModel$getMineReviews$2(this), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final f D0() {
        return this.f4398d;
    }

    @d
    public final NLive<List<ReviewListInfo>> E0() {
        return this.f4402h;
    }

    @d
    public final NLive<ReviewMineInfo> F0() {
        return this.f4404j;
    }

    @d
    public final e.n.f<List<Pair<String, String>>> G() {
        return this.f4405k;
    }

    @d
    public final l G0() {
        return this.f4403i;
    }

    @d
    public final a<e.l.h.i.e<ReviewListInfo>> H0(@d String str, @e Integer num, @e Integer num2, @e String str2, @e Integer num3, @e Integer num4, @e String str3, @e String str4, @e LoadMore.State state) {
        final Flow<e.l.h.i.e<ReviewListInfo>> f2 = ((e.l.n.c.f) e.l.n.a.d(e.l.n.c.f.class, true, false, false, 60L, true)).f(str, num, num2, str2, num3, num4, str3, str4, this.f4398d.a(state).d());
        return a.h(a.o(BinderKt.b(FlowKt.c(new Flow<e.l.h.i.e<ReviewListInfo>>() { // from class: com.jihuanshe.viewmodel.detail.ReviewListViewModel$getReviews$$inlined$map$1

            /* renamed from: com.jihuanshe.viewmodel.detail.ReviewListViewModel$getReviews$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes2.dex */
            public static final class AnonymousClass2 implements i.b.v3.f<e.l.h.i.e<ReviewListInfo>> {
                public final /* synthetic */ i.b.v3.f a;
                public final /* synthetic */ ReviewListViewModel$getReviews$$inlined$map$1 b;

                /* renamed from: com.jihuanshe.viewmodel.detail.ReviewListViewModel$getReviews$$inlined$map$1$2$1  reason: invalid class name */
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

                public AnonymousClass2(i.b.v3.f fVar, ReviewListViewModel$getReviews$$inlined$map$1 reviewListViewModel$getReviews$$inlined$map$1) {
                    this.a = fVar;
                    this.b = reviewListViewModel$getReviews$$inlined$map$1;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
                @Override // i.b.v3.f
                @k.e.a.e
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public java.lang.Object emit(e.l.h.i.e<com.jihuanshe.model.ReviewListInfo> r10, @k.e.a.d h.e2.c r11) {
                    /*
                        r9 = this;
                        boolean r0 = r11 instanceof com.jihuanshe.viewmodel.detail.ReviewListViewModel$getReviews$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r11
                        com.jihuanshe.viewmodel.detail.ReviewListViewModel$getReviews$$inlined$map$1$2$1 r0 = (com.jihuanshe.viewmodel.detail.ReviewListViewModel$getReviews$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.jihuanshe.viewmodel.detail.ReviewListViewModel$getReviews$$inlined$map$1$2$1 r0 = new com.jihuanshe.viewmodel.detail.ReviewListViewModel$getReviews$$inlined$map$1$2$1
                        r0.<init>(r11)
                    L18:
                        java.lang.Object r11 = r0.result
                        java.lang.Object r1 = h.e2.j.b.h()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L32
                        if (r2 != r3) goto L2a
                        h.r0.n(r11)
                        goto La0
                    L2a:
                        java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                        java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
                        r10.<init>(r11)
                        throw r10
                    L32:
                        h.r0.n(r11)
                        i.b.v3.f r11 = r9.a
                        e.l.h.i.e r10 = (e.l.h.i.e) r10
                        com.jihuanshe.viewmodel.detail.ReviewListViewModel$getReviews$$inlined$map$1 r2 = r9.b
                        com.jihuanshe.viewmodel.detail.ReviewListViewModel r2 = r2
                        e.n.l r2 = r2.G0()
                        java.lang.Integer r4 = r10.e()
                        r2.setValue(r4)
                        java.util.List r2 = r10.b()
                        if (r2 != 0) goto L4f
                        goto L97
                    L4f:
                        java.util.Iterator r2 = r2.iterator()
                    L53:
                        boolean r4 = r2.hasNext()
                        if (r4 == 0) goto L97
                        java.lang.Object r4 = r2.next()
                        com.jihuanshe.model.ReviewListInfo r4 = (com.jihuanshe.model.ReviewListInfo) r4
                        com.jihuanshe.utils.StringUtil r5 = com.jihuanshe.utils.StringUtil.a
                        java.lang.String r6 = r4.getContent()
                        java.lang.CharSequence r5 = r5.i(r6)
                        r4.setHandleContent(r5)
                        java.util.List r5 = r4.getReplyLists()
                        if (r5 != 0) goto L73
                        goto L53
                    L73:
                        java.util.Iterator r5 = r5.iterator()
                    L77:
                        boolean r6 = r5.hasNext()
                        if (r6 == 0) goto L53
                        java.lang.Object r6 = r5.next()
                        com.jihuanshe.model.ReplyListInfo r6 = (com.jihuanshe.model.ReplyListInfo) r6
                        if (r6 == 0) goto L77
                        com.jihuanshe.utils.StringUtil r7 = com.jihuanshe.utils.StringUtil.a
                        java.lang.Integer r8 = r4.getUserID()
                        java.lang.String r8 = r6.getCContent(r8)
                        java.lang.CharSequence r7 = r7.i(r8)
                        r6.setHandleContent(r7)
                        goto L77
                    L97:
                        r0.label = r3
                        java.lang.Object r10 = r11.emit(r10, r0)
                        if (r10 != r1) goto La0
                        return r1
                    La0:
                        h.t1 r10 = h.t1.a
                        return r10
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.jihuanshe.viewmodel.detail.ReviewListViewModel$getReviews$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, h.e2.c):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @e
            public Object e(@d i.b.v3.f<? super e.l.h.i.e<ReviewListInfo>> fVar, @d c cVar) {
                Object e2 = Flow.this.e(new AnonymousClass2(fVar, this), cVar);
                return e2 == b.h() ? e2 : t1.a;
            }
        }), this.f4402h, this.f4398d.f()), null, new ReviewListViewModel$getReviews$2(this), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final i J0() {
        return this.f4401g;
    }

    @d
    public final i K0() {
        return this.f4400f;
    }

    @d
    public final i L0() {
        return this.f4399e;
    }

    @d
    public final a<t1> M0(int i2, boolean z) {
        return a.h(a.j(FlowKt.c(((e.l.n.c.f) e.l.n.a.d(e.l.n.c.f.class, true, false, false, 60L, true)).m(i2)), null, new ReviewListViewModel$goReviewLike$1(z, this), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final a<t1> N0(int i2, boolean z) {
        return a.h(a.j(FlowKt.c(((e.l.n.c.f) e.l.n.a.d(e.l.n.c.f.class, true, false, false, 60L, true)).i(i2)), null, new ReviewListViewModel$goReviewUnlike$1(z, this), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final a<t1> O0(int i2, int i3, @d String str, int i4, @d String str2) {
        return a.h(a.j(FlowKt.c(f.a.d((e.l.n.c.f) e.l.n.a.d(e.l.n.c.f.class, true, false, false, 60L, true), Integer.valueOf(i2), Integer.valueOf(i3), str, i4, str2, null, null, 96, null)), null, ReviewListViewModel$goReviewsAndScore$1.INSTANCE, 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final a<t1> P0(int i2, @d String str) {
        return a.h(FlowKt.c(((e.l.n.c.f) e.l.n.a.d(e.l.n.c.f.class, true, false, false, 60L, true)).e(i2, str)), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final a<t1> Q0(int i2, @d String str, @e String str2, @e List<String> list) {
        return a.h(FlowKt.c(((e.l.n.c.f) e.l.n.a.d(e.l.n.c.f.class, true, false, false, 60L, true)).j(i2, str, str2, list)), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final a<t1> z0(int i2) {
        return a.h(FlowKt.c(((e.l.n.c.f) e.l.n.a.d(e.l.n.c.f.class, true, false, false, 60L, true)).n(i2)), ViewModelKt.getViewModelScope(this), null, 2, null);
    }
}
