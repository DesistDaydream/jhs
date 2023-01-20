package com.jihuanshe.ui.page.detail;

import android.view.View;
import com.jihuanshe.R;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.mmkv.UserKV;
import com.jihuanshe.model.ReplyDetailInfo;
import com.jihuanshe.viewmodel.detail.ReplyListViewModel;
import com.vector.util.Res;
import e.n.f;
import h.k2.u.a;
import h.k2.u.l;
import h.t1;
import java.util.List;
import k.e.a.e;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ReplyListActivity$showPopUpWindow$1 extends Lambda implements a<t1> {
    public final /* synthetic */ ReplyDetailInfo $rd;
    public final /* synthetic */ View $v;
    public final /* synthetic */ ReplyListActivity this$0;

    /* renamed from: com.jihuanshe.ui.page.detail.ReplyListActivity$showPopUpWindow$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements a<t1> {
        public final /* synthetic */ ReplyDetailInfo $rd;
        public final /* synthetic */ ReplyListActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ReplyListActivity replyListActivity, ReplyDetailInfo replyDetailInfo) {
            super(0);
            this.this$0 = replyListActivity;
            this.$rd = replyDetailInfo;
        }

        @Override // h.k2.u.a
        public /* bridge */ /* synthetic */ t1 invoke() {
            invoke2();
            return t1.a;
        }

        @Override // h.k2.u.a
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.this$0.O0(this.$rd);
        }
    }

    /* renamed from: com.jihuanshe.ui.page.detail.ReplyListActivity$showPopUpWindow$1$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass2 extends Lambda implements a<t1> {
        public final /* synthetic */ ReplyDetailInfo $rd;
        public final /* synthetic */ ReplyListActivity this$0;

        /* renamed from: com.jihuanshe.ui.page.detail.ReplyListActivity$showPopUpWindow$1$2$1  reason: invalid class name */
        /* loaded from: classes2.dex */
        public static final class AnonymousClass1 extends Lambda implements l<t1, t1> {
            public final /* synthetic */ ReplyDetailInfo $rd;
            public final /* synthetic */ ReplyListActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(ReplyListActivity replyListActivity, ReplyDetailInfo replyDetailInfo) {
                super(1);
                this.this$0 = replyListActivity;
                this.$rd = replyDetailInfo;
            }

            @Override // h.k2.u.l
            public /* bridge */ /* synthetic */ t1 invoke(t1 t1Var) {
                invoke2(t1Var);
                return t1.a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@e t1 t1Var) {
                List<ReplyDetailInfo> L5;
                Integer x0 = this.this$0.x0();
                int id = this.$rd.getId();
                if (x0 != null && x0.intValue() == id) {
                    this.this$0.finish();
                    return;
                }
                f<List<ReplyDetailInfo>> z0 = ((ReplyListViewModel) this.this$0.L()).z0();
                List<ReplyDetailInfo> value = ((ReplyListViewModel) this.this$0.L()).z0().getValue();
                List<ReplyDetailInfo> list = null;
                if (value != null && (L5 = CollectionsKt___CollectionsKt.L5(value)) != null) {
                    ReplyDetailInfo replyDetailInfo = this.$rd;
                    ReplyListActivity replyListActivity = this.this$0;
                    if (L5.remove(replyDetailInfo)) {
                        e.n.l F0 = ((ReplyListViewModel) replyListActivity.L()).F0();
                        Integer value2 = ((ReplyListViewModel) replyListActivity.L()).F0().getValue();
                        if (value2 == null) {
                            value2 = 0;
                        }
                        F0.setValue(Integer.valueOf(Math.max(0, value2.intValue() - 1)));
                    }
                    t1 t1Var2 = t1.a;
                    list = L5;
                }
                z0.setValue(list);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ReplyListActivity replyListActivity, ReplyDetailInfo replyDetailInfo) {
            super(0);
            this.this$0 = replyListActivity;
            this.$rd = replyDetailInfo;
        }

        @Override // h.k2.u.a
        public /* bridge */ /* synthetic */ t1 invoke() {
            invoke2();
            return t1.a;
        }

        @Override // h.k2.u.a
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            BinderKt.p(BinderKt.k(e.g.d.a.j(this.this$0.y0().z0(this.$rd.getId()), null, new AnonymousClass1(this.this$0, this.$rd), 1, null), this.this$0, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReplyListActivity$showPopUpWindow$1(ReplyDetailInfo replyDetailInfo, ReplyListActivity replyListActivity, View view) {
        super(0);
        this.$rd = replyDetailInfo;
        this.this$0 = replyListActivity;
        this.$v = view;
    }

    @Override // h.k2.u.a
    public /* bridge */ /* synthetic */ t1 invoke() {
        invoke2();
        return t1.a;
    }

    @Override // h.k2.u.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        if (this.$rd.getUserID() != UserKV.f3913c.v()) {
            ReplyListActivity replyListActivity = this.this$0;
            View view = this.$v;
            List P = CollectionsKt__CollectionsKt.P(Res.w(Res.a, R.string.common_report, null, 2, null));
            ReplyDetailInfo replyDetailInfo = this.$rd;
            replyListActivity.N0(view, P, replyDetailInfo, new AnonymousClass1(this.this$0, replyDetailInfo));
            return;
        }
        ReplyListActivity replyListActivity2 = this.this$0;
        View view2 = this.$v;
        List P2 = CollectionsKt__CollectionsKt.P(Res.w(Res.a, R.string.common_delete, null, 2, null));
        ReplyDetailInfo replyDetailInfo2 = this.$rd;
        replyListActivity2.N0(view2, P2, replyDetailInfo2, new AnonymousClass2(this.this$0, replyDetailInfo2));
    }
}
