package com.jihuanshe.ui.page.user;

import com.jihuanshe.model.CloseContent;
import h.k2.u.l;
import h.t1;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CloseAccountActivity$onRetryClick$1 extends Lambda implements l<CloseContent, t1> {
    public final /* synthetic */ CloseAccountActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CloseAccountActivity$onRetryClick$1(CloseAccountActivity closeAccountActivity) {
        super(1);
        this.this$0 = closeAccountActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(CloseContent closeContent) {
        invoke2(closeContent);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e CloseContent closeContent) {
        this.this$0.b0().setValue(closeContent == null ? null : closeContent.getTitle());
        this.this$0.W().setValue(closeContent != null ? closeContent.getContent() : null);
    }
}
