package com.jihuanshe.ui.page.im;

import com.jihuanshe.model.InteractData;
import com.jihuanshe.viewmodel.im.LikeViewModel;
import e.n.f;
import h.k2.u.a;
import h.t1;
import java.util.List;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class LikeFragment$initObserver$1 extends Lambda implements a<t1> {
    public final /* synthetic */ LikeFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LikeFragment$initObserver$1(LikeFragment likeFragment) {
        super(0);
        this.this$0 = likeFragment;
    }

    @Override // h.k2.u.a
    public /* bridge */ /* synthetic */ t1 invoke() {
        invoke2();
        return t1.a;
    }

    @Override // h.k2.u.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        f<List<InteractData>> s0 = ((LikeViewModel) this.this$0.T()).s0();
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
