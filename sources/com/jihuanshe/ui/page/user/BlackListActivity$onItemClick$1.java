package com.jihuanshe.ui.page.user;

import android.view.View;
import com.jihuanshe.model.BanUser;
import com.jihuanshe.viewmodel.user.BlackListViewModel;
import h.k2.u.p;
import h.t1;
import java.util.List;
import k.e.a.e;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class BlackListActivity$onItemClick$1 extends Lambda implements p<View, Integer, t1> {
    public final /* synthetic */ BlackListActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BlackListActivity$onItemClick$1(BlackListActivity blackListActivity) {
        super(2);
        this.this$0 = blackListActivity;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(View view, Integer num) {
        invoke(view, num.intValue());
        return t1.a;
    }

    public final void invoke(@e View view, int i2) {
        List<BanUser> value = ((BlackListViewModel) this.this$0.L()).q0().getValue();
        BanUser banUser = value == null ? null : (BanUser) CollectionsKt___CollectionsKt.J2(value, i2);
        if (banUser == null) {
            return;
        }
        SellerDetailActivityCreator.create(Integer.valueOf(banUser.getUid()), null).start(this.this$0);
    }
}
