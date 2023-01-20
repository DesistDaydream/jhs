package com.jihuanshe.ui.page.detail;

import android.view.View;
import com.jihuanshe.model.ReplyDetailInfo;
import com.jihuanshe.viewmodel.detail.ReplyListViewModel;
import h.k2.u.a;
import h.k2.u.p;
import h.k2.v.f0;
import h.t1;
import java.util.List;
import k.e.a.e;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ReplyListActivity$onItemClick$1 extends Lambda implements p<View, Integer, t1> {
    public final /* synthetic */ ReplyListActivity this$0;

    /* renamed from: com.jihuanshe.ui.page.detail.ReplyListActivity$onItemClick$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements a<t1> {
        public final /* synthetic */ ReplyDetailInfo $info;
        public final /* synthetic */ ReplyListActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ReplyListActivity replyListActivity, ReplyDetailInfo replyDetailInfo) {
            super(0);
            this.this$0 = replyListActivity;
            this.$info = replyDetailInfo;
        }

        @Override // h.k2.u.a
        public /* bridge */ /* synthetic */ t1 invoke() {
            invoke2();
            return t1.a;
        }

        @Override // h.k2.u.a
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.this$0.y0().K0().setValue(Boolean.TRUE);
            this.this$0.l0().setHint(f0.C("回复 @", this.$info.getUsername()));
            this.this$0.J0(this.$info);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReplyListActivity$onItemClick$1(ReplyListActivity replyListActivity) {
        super(2);
        this.this$0 = replyListActivity;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(View view, Integer num) {
        invoke(view, num.intValue());
        return t1.a;
    }

    public final void invoke(@e View view, int i2) {
        List<ReplyDetailInfo> value = ((ReplyListViewModel) this.this$0.L()).z0().getValue();
        ReplyDetailInfo replyDetailInfo = value == null ? null : (ReplyDetailInfo) CollectionsKt___CollectionsKt.J2(value, i2);
        if (replyDetailInfo == null) {
            return;
        }
        e.l.l.a.c(new AnonymousClass1(this.this$0, replyDetailInfo));
    }
}
