package com.jihuanshe.ui.page.user;

import com.jihuanshe.model.User;
import h.k2.u.l;
import h.t1;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class FansActivity$follow$1 extends Lambda implements l<t1, t1> {
    public final /* synthetic */ User $user;
    public final /* synthetic */ FansActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FansActivity$follow$1(User user, FansActivity fansActivity) {
        super(1);
        this.$user = user;
        this.this$0 = fansActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(t1 t1Var) {
        invoke2(t1Var);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e t1 t1Var) {
        this.$user.setFollowed(Boolean.TRUE);
        this.this$0.X().notifyDataSetChanged();
    }
}
