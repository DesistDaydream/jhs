package com.jihuanshe.ui.page.detail;

import com.jihuanshe.R;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.ImageErrorInfo;
import com.jihuanshe.model.ReplyDetailInfo;
import com.jihuanshe.viewmodel.detail.ReplyListViewModel;
import e.g.d.a;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ReplyListActivity$showReportDialog$1 extends Lambda implements l<ImageErrorInfo, t1> {
    public final /* synthetic */ ReplyDetailInfo $info;
    public final /* synthetic */ ReplyListActivity this$0;

    /* renamed from: com.jihuanshe.ui.page.detail.ReplyListActivity$showReportDialog$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements l<t1, t1> {
        public final /* synthetic */ ReplyListActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ReplyListActivity replyListActivity) {
            super(1);
            this.this$0 = replyListActivity;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(t1 t1Var) {
            invoke2(t1Var);
            return t1.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@e t1 t1Var) {
            e.l.h.j.b.e.b(this.this$0, R.string.report_success, (r12 & 2) != 0 ? null : null, (r12 & 4) != 0 ? null : null, (r12 & 8) == 0 ? null : null, (r12 & 16) != 0 ? 1 : 0, (r12 & 32) != 0 ? 80 : null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReplyListActivity$showReportDialog$1(ReplyListActivity replyListActivity, ReplyDetailInfo replyDetailInfo) {
        super(1);
        this.this$0 = replyListActivity;
        this.$info = replyDetailInfo;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(ImageErrorInfo imageErrorInfo) {
        invoke2(imageErrorInfo);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d ImageErrorInfo imageErrorInfo) {
        BinderKt.k(BinderKt.p(a.j(((ReplyListViewModel) this.this$0.L()).I0(this.$info.getId(), imageErrorInfo.getReason(), imageErrorInfo.getContent(), imageErrorInfo.getImages()), null, new AnonymousClass1(this.this$0), 1, null)), this.this$0, false, 2, null);
    }
}
