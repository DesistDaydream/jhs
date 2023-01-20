package com.jihuanshe.viewmodel.user;

import com.jihuanshe.model.Constants;
import com.jihuanshe.model.User;
import h.k2.u.l;
import h.t1;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellerDetailViewModel$getUserDetail$1 extends Lambda implements l<User, t1> {
    public final /* synthetic */ SellerDetailViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellerDetailViewModel$getUserDetail$1(SellerDetailViewModel sellerDetailViewModel) {
        super(1);
        this.this$0 = sellerDetailViewModel;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(User user) {
        invoke2(user);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e User user) {
        this.this$0.X0().r(user);
        this.this$0.I0().setValue(user == null ? null : user.getFollowed());
        this.this$0.W0().setValue(Boolean.valueOf(user != null && user.getId() == Constants.Companion.getWAREHOUSE_SELLER_USER_ID()));
        this.this$0.c1().setValue(Boolean.valueOf(user != null && user.getId() == 1000));
    }
}
