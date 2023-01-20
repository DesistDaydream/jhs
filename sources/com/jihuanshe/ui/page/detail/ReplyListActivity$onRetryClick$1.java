package com.jihuanshe.ui.page.detail;

import com.jihuanshe.viewmodel.detail.ReplyListViewModel;
import e.g.e.a;
import e.l.h.j.b.e;
import h.k2.u.l;
import h.k2.v.f0;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ReplyListActivity$onRetryClick$1 extends Lambda implements l<a, t1> {
    public final /* synthetic */ ReplyListActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReplyListActivity$onRetryClick$1(ReplyListActivity replyListActivity) {
        super(1);
        this.this$0 = replyListActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(a aVar) {
        invoke2(aVar);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d a aVar) {
        if (f0.g(aVar.f(), "346")) {
            ((ReplyListViewModel) this.this$0.L()).A0().setValue(Boolean.TRUE);
        } else {
            e.a(this.this$0, aVar.h());
        }
    }
}
