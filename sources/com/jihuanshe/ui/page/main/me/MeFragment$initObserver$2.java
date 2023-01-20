package com.jihuanshe.ui.page.main.me;

import com.jihuanshe.model.User;
import com.jihuanshe.viewmodel.main.me.MeViewModel;
import e.n.f;
import h.k2.u.a;
import h.t1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class MeFragment$initObserver$2 extends Lambda implements a<t1> {
    public final /* synthetic */ MeFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MeFragment$initObserver$2(MeFragment meFragment) {
        super(0);
        this.this$0 = meFragment;
    }

    @Override // h.k2.u.a
    public /* bridge */ /* synthetic */ t1 invoke() {
        invoke2();
        return t1.a;
    }

    @Override // h.k2.u.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        f<User> s0 = ((MeViewModel) this.this$0.T()).s0();
        User value = s0.getValue();
        if (value != null) {
            value.setVerifyStatus(0);
        }
        s0.n();
    }
}
