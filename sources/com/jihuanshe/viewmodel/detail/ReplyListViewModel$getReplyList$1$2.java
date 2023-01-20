package com.jihuanshe.viewmodel.detail;

import com.jihuanshe.base.model.Result;
import com.jihuanshe.model.ReplyDetailInfo;
import com.jihuanshe.utils.StringUtil;
import e.l.h.i.e;
import e.n.l;
import h.e2.c;
import h.e2.j.b;
import h.e2.k.a.a;
import h.k2.u.p;
import h.r0;
import h.t1;
import i.b.n0;
import k.e.a.d;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref;

/* loaded from: classes2.dex */
public final class ReplyListViewModel$getReplyList$1$2 extends SuspendLambda implements p<n0, c<? super t1>, Object> {
    public final /* synthetic */ Ref.ObjectRef<ReplyDetailInfo> $info;
    public final /* synthetic */ Result<e<ReplyDetailInfo>> $it;
    public int label;
    public final /* synthetic */ ReplyListViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReplyListViewModel$getReplyList$1$2(ReplyListViewModel replyListViewModel, Result<e<ReplyDetailInfo>> result, Ref.ObjectRef<ReplyDetailInfo> objectRef, c<? super ReplyListViewModel$getReplyList$1$2> cVar) {
        super(2, cVar);
        this.this$0 = replyListViewModel;
        this.$it = result;
        this.$info = objectRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @d
    public final c<t1> create(@k.e.a.e Object obj, @d c<?> cVar) {
        return new ReplyListViewModel$getReplyList$1$2(this.this$0, this.$it, this.$info, cVar);
    }

    @Override // h.k2.u.p
    @k.e.a.e
    public final Object invoke(@d n0 n0Var, @k.e.a.e c<? super t1> cVar) {
        return ((ReplyListViewModel$getReplyList$1$2) create(n0Var, cVar)).invokeSuspend(t1.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k.e.a.e
    public final Object invokeSuspend(@d Object obj) {
        Integer e2;
        b.h();
        if (this.label == 0) {
            r0.n(obj);
            l F0 = this.this$0.F0();
            e<ReplyDetailInfo> data = this.$it.getData();
            if (data == null || (e2 = data.e()) == null) {
                e2 = a.f(0);
            }
            F0.setValue(e2);
            ReplyDetailInfo replyDetailInfo = this.$info.element;
            if (replyDetailInfo != null) {
                replyDetailInfo.setHandleContent(StringUtil.a.i(this.$info.element.getContent()));
                this.this$0.E0().r(this.$info.element);
                this.this$0.G0().setValue(a.a(true));
            }
            return t1.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
