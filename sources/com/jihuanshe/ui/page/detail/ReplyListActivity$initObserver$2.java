package com.jihuanshe.ui.page.detail;

import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.viewmodel.detail.ReplyListViewModel;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ReplyListActivity$initObserver$2 extends Lambda implements l<Pair<? extends String, ? extends String>, t1> {
    public final /* synthetic */ ReplyListActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReplyListActivity$initObserver$2(ReplyListActivity replyListActivity) {
        super(1);
        this.this$0 = replyListActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Pair<? extends String, ? extends String> pair) {
        invoke2((Pair<String, String>) pair);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d Pair<String, String> pair) {
        boolean z;
        z = this.this$0.L;
        if (z) {
            this.this$0.L = false;
            return;
        }
        ((ReplyListViewModel) this.this$0.L()).z0().r(CollectionsKt__CollectionsKt.E());
        ReplyListViewModel replyListViewModel = (ReplyListViewModel) this.this$0.L();
        int intValue = this.this$0.x0().intValue();
        Pair<String, String> value = this.this$0.y0().B0().getValue();
        BinderKt.p(ReplyListViewModel.D0(replyListViewModel, intValue, value == null ? null : value.getSecond(), null, 4, null));
    }
}
