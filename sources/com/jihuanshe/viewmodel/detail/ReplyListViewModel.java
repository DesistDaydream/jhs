package com.jihuanshe.viewmodel.detail;

import androidx.lifecycle.ViewModelKt;
import com.eth.ext.FlowKt;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.base.model.Result;
import com.jihuanshe.model.ReplyDetailInfo;
import com.jihuanshe.viewmodel.UploadViewModel;
import com.vector.design.ui.delegate.LoadMore;
import e.g.d.a;
import e.l.h.i.e;
import e.l.h.i.f;
import e.n.i;
import e.n.l;
import h.e2.c;
import h.e2.j.b;
import h.t1;
import java.util.List;
import k.e.a.d;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.flow.Flow;

/* loaded from: classes2.dex */
public final class ReplyListViewModel extends UploadViewModel {
    @d

    /* renamed from: d  reason: collision with root package name */
    private final f f4392d = new f();
    @d

    /* renamed from: e  reason: collision with root package name */
    private final i f4393e;
    @d

    /* renamed from: f  reason: collision with root package name */
    private final e.n.f<List<ReplyDetailInfo>> f4394f;
    @d

    /* renamed from: g  reason: collision with root package name */
    private final e.n.f<ReplyDetailInfo> f4395g;
    @d

    /* renamed from: h  reason: collision with root package name */
    private final l f4396h;
    @d

    /* renamed from: i  reason: collision with root package name */
    private final i f4397i;

    public ReplyListViewModel() {
        Boolean bool = Boolean.FALSE;
        this.f4393e = new i(bool);
        this.f4394f = new e.n.f<>(null, 1, null);
        this.f4395g = new e.n.f<>(null, 1, null);
        this.f4396h = new l(0);
        this.f4397i = new i(bool);
    }

    public static /* synthetic */ a D0(ReplyListViewModel replyListViewModel, int i2, String str, LoadMore.State state, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            state = null;
        }
        return replyListViewModel.C0(i2, str, state);
    }

    @d
    public final i A0() {
        return this.f4397i;
    }

    @d
    public final f B0() {
        return this.f4392d;
    }

    @d
    public final a<e<ReplyDetailInfo>> C0(int i2, @k.e.a.e String str, @k.e.a.e LoadMore.State state) {
        final Flow<Result<e<ReplyDetailInfo>>> d2 = ((e.l.n.c.f) e.l.n.a.d(e.l.n.c.f.class, false, false, false, 60L, true)).d(i2, str, this.f4392d.a(state).d());
        return a.h(a.o(BinderKt.b(FlowKt.c(new Flow<e<ReplyDetailInfo>>() { // from class: com.jihuanshe.viewmodel.detail.ReplyListViewModel$getReplyList$$inlined$map$1

            /* renamed from: com.jihuanshe.viewmodel.detail.ReplyListViewModel$getReplyList$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes2.dex */
            public static final class AnonymousClass2 implements i.b.v3.f<Result<e<ReplyDetailInfo>>> {
                public final /* synthetic */ i.b.v3.f a;
                public final /* synthetic */ ReplyListViewModel$getReplyList$$inlined$map$1 b;

                /* renamed from: com.jihuanshe.viewmodel.detail.ReplyListViewModel$getReplyList$$inlined$map$1$2$1  reason: invalid class name */
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

                public AnonymousClass2(i.b.v3.f fVar, ReplyListViewModel$getReplyList$$inlined$map$1 replyListViewModel$getReplyList$$inlined$map$1) {
                    this.a = fVar;
                    this.b = replyListViewModel$getReplyList$$inlined$map$1;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
                /* JADX WARN: Removed duplicated region for block: B:16:0x0047  */
                /* JADX WARN: Removed duplicated region for block: B:28:0x0072 A[Catch: all -> 0x0086, TryCatch #0 {all -> 0x0086, blocks: (B:17:0x0054, B:22:0x0066, B:28:0x0072, B:29:0x0080, B:20:0x005e), top: B:59:0x0054 }] */
                /* JADX WARN: Removed duplicated region for block: B:35:0x00ab A[RETURN] */
                /* JADX WARN: Removed duplicated region for block: B:36:0x00ac  */
                /* JADX WARN: Removed duplicated region for block: B:39:0x00b5  */
                /* JADX WARN: Removed duplicated region for block: B:40:0x00b7  */
                /* JADX WARN: Removed duplicated region for block: B:56:0x0109 A[RETURN] */
                /* JADX WARN: Type inference failed for: r7v8, types: [T, java.lang.Object] */
                @Override // i.b.v3.f
                @k.e.a.e
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public java.lang.Object emit(com.jihuanshe.base.model.Result<e.l.h.i.e<com.jihuanshe.model.ReplyDetailInfo>> r11, @k.e.a.d h.e2.c r12) {
                    /*
                        Method dump skipped, instructions count: 269
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.jihuanshe.viewmodel.detail.ReplyListViewModel$getReplyList$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, h.e2.c):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @k.e.a.e
            public Object e(@d i.b.v3.f<? super e<ReplyDetailInfo>> fVar, @d c cVar) {
                Object e2 = Flow.this.e(new AnonymousClass2(fVar, this), cVar);
                return e2 == b.h() ? e2 : t1.a;
            }
        }), this.f4394f, this.f4392d.f()), null, new ReplyListViewModel$getReplyList$2(this), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final e.n.f<ReplyDetailInfo> E0() {
        return this.f4395g;
    }

    @d
    public final l F0() {
        return this.f4396h;
    }

    @d
    public final i G0() {
        return this.f4393e;
    }

    @d
    public final a<?> H0(@d ReplyDetailInfo replyDetailInfo) {
        if (!replyDetailInfo.isLike()) {
            replyDetailInfo.setLike(true);
            replyDetailInfo.setLikeCount(replyDetailInfo.getLikeCount() + 1);
            return a.h(FlowKt.c(((e.l.n.c.f) e.l.n.a.d(e.l.n.c.f.class, true, false, false, 60L, true)).m(replyDetailInfo.getId())), ViewModelKt.getViewModelScope(this), null, 2, null);
        }
        replyDetailInfo.setLike(false);
        replyDetailInfo.setLikeCount(Math.max(0, replyDetailInfo.getLikeCount() - 1));
        return a.h(FlowKt.c(((e.l.n.c.f) e.l.n.a.d(e.l.n.c.f.class, true, false, false, 60L, true)).i(replyDetailInfo.getId())), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final a<t1> I0(int i2, @d String str, @k.e.a.e String str2, @k.e.a.e List<String> list) {
        return a.h(FlowKt.c(((e.l.n.c.f) e.l.n.a.d(e.l.n.c.f.class, true, false, false, 60L, true)).j(i2, str, str2, list)), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final e.n.f<List<ReplyDetailInfo>> z0() {
        return this.f4394f;
    }
}
