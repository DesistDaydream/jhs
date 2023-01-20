package com.jihuanshe.ui.page.im;

import com.eth.model.NLive;
import com.jihuanshe.model.InteractNewCount;
import com.jihuanshe.viewmodel.im.InteractMessageViewModel;
import h.k2.u.a;
import h.t1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class InteractMessageActivity$initObserver$2 extends Lambda implements a<t1> {
    public final /* synthetic */ InteractMessageActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InteractMessageActivity$initObserver$2(InteractMessageActivity interactMessageActivity) {
        super(0);
        this.this$0 = interactMessageActivity;
    }

    @Override // h.k2.u.a
    public /* bridge */ /* synthetic */ t1 invoke() {
        invoke2();
        return t1.a;
    }

    @Override // h.k2.u.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        NLive<InteractNewCount> q0 = ((InteractMessageViewModel) this.this$0.L()).q0();
        InteractNewCount value = q0.getValue();
        if (value != null && value.getNewReply().intValue() > 0) {
            value.setNewReply(Integer.valueOf(value.getNewReply().intValue() - 1));
            q0.n();
        }
    }
}
