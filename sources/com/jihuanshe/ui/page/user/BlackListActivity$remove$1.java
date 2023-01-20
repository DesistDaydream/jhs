package com.jihuanshe.ui.page.user;

import com.jihuanshe.model.BanUser;
import com.jihuanshe.viewmodel.user.BlackListViewModel;
import h.k2.u.l;
import h.t1;
import java.util.List;
import k.e.a.e;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class BlackListActivity$remove$1 extends Lambda implements l<t1, t1> {
    public final /* synthetic */ BanUser $user;
    public final /* synthetic */ BlackListActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BlackListActivity$remove$1(BlackListActivity blackListActivity, BanUser banUser) {
        super(1);
        this.this$0 = blackListActivity;
        this.$user = banUser;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(t1 t1Var) {
        invoke2(t1Var);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e t1 t1Var) {
        List<BanUser> value = ((BlackListViewModel) this.this$0.L()).q0().getValue();
        List<BanUser> L5 = value == null ? null : CollectionsKt___CollectionsKt.L5(value);
        if (L5 == null) {
            return;
        }
        L5.remove(this.$user);
        ((BlackListViewModel) this.this$0.L()).q0().r(L5);
    }
}
