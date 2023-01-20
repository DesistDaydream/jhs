package com.jihuanshe.ui.page.detail;

import android.view.View;
import com.jihuanshe.viewmodel.detail.ReplyListViewModel;
import e.g.d.a;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ReplyListActivity$onClickFavor$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ ReplyListActivity this$0;

    /* renamed from: com.jihuanshe.ui.page.detail.ReplyListActivity$onClickFavor$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements l<Object, t1> {
        public final /* synthetic */ ReplyListActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ReplyListActivity replyListActivity) {
            super(1);
            this.this$0 = replyListActivity;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(Object obj) {
            invoke2(obj);
            return t1.a;
        }

        @Override // h.k2.u.l
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@e Object obj) {
            ((ReplyListViewModel) this.this$0.L()).E0().n();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReplyListActivity$onClickFavor$1(ReplyListActivity replyListActivity) {
        super(1);
        this.this$0 = replyListActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        if (((ReplyListViewModel) this.this$0.L()).E0().getValue() == null) {
            return;
        }
        a.j(((ReplyListViewModel) this.this$0.L()).H0(((ReplyListViewModel) this.this$0.L()).E0().getValue()), null, new AnonymousClass1(this.this$0), 1, null);
    }
}
