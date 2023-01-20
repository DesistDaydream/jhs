package com.jihuanshe.ui.page.main.me;

import android.view.View;
import com.jihuanshe.model.User;
import com.jihuanshe.ui.page.user.SellerDetailActivityCreator;
import com.jihuanshe.viewmodel.main.me.MeViewModel;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class MeFragment$onClickMyShop$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ MeFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MeFragment$onClickMyShop$1(MeFragment meFragment) {
        super(1);
        this.this$0 = meFragment;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        User value = ((MeViewModel) this.this$0.T()).s0().getValue();
        SellerDetailActivityCreator.create(value == null ? null : Integer.valueOf(value.getId()), null).start(this.this$0.getActivity());
    }
}
