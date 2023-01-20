package com.jihuanshe.ui.page.user;

import com.jihuanshe.model.User;
import com.jihuanshe.ui.widget.UserBar;
import e.n.f;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellerDetailActivity$flowOfSetup$2 extends Lambda implements l<User, t1> {
    public final /* synthetic */ SellerDetailActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellerDetailActivity$flowOfSetup$2(SellerDetailActivity sellerDetailActivity) {
        super(1);
        this.this$0 = sellerDetailActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(User user) {
        invoke2(user);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d User user) {
        UserBar userBar;
        f<User> user2;
        userBar = this.this$0.b0;
        if (userBar == null || (user2 = userBar.getUser()) == null) {
            return;
        }
        user2.r(user);
    }
}
