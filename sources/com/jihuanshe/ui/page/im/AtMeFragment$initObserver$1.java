package com.jihuanshe.ui.page.im;

import com.jihuanshe.model.InteractData;
import com.jihuanshe.viewmodel.im.AtMeViewModel;
import e.n.f;
import h.k2.u.a;
import h.t1;
import java.util.List;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class AtMeFragment$initObserver$1 extends Lambda implements a<t1> {
    public final /* synthetic */ AtMeFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AtMeFragment$initObserver$1(AtMeFragment atMeFragment) {
        super(0);
        this.this$0 = atMeFragment;
    }

    @Override // h.k2.u.a
    public /* bridge */ /* synthetic */ t1 invoke() {
        invoke2();
        return t1.a;
    }

    @Override // h.k2.u.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        f<List<InteractData>> s0 = ((AtMeViewModel) this.this$0.T()).s0();
        List<InteractData> value = s0.getValue();
        if (value == null) {
            return;
        }
        for (InteractData interactData : value) {
            interactData.setReaded(Boolean.TRUE);
        }
        s0.n();
    }
}
