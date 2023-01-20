package com.jihuanshe.ui.page.user;

import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.base.model.Result;
import com.jihuanshe.model.Game;
import com.jihuanshe.model.GameCard;
import com.jihuanshe.model.User;
import com.jihuanshe.ui.widget.GameBar;
import com.jihuanshe.viewmodel.user.SellerDetailViewModel;
import e.g.d.a;
import h.k2.u.l;
import h.t1;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellerDetailActivity$onRetryClick$1 extends Lambda implements l<User, t1> {
    public final /* synthetic */ SellerDetailActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellerDetailActivity$onRetryClick$1(SellerDetailActivity sellerDetailActivity) {
        super(1);
        this.this$0 = sellerDetailActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(User user) {
        invoke2(user);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e User user) {
        SellerDetailViewModel sellerDetailViewModel = (SellerDetailViewModel) this.this$0.L();
        int Z0 = this.this$0.Z0();
        Integer a1 = this.this$0.a1();
        GameBar.a aVar = GameBar.b;
        Game value = aVar.a().getValue();
        String gameKey = value == null ? null : value.getGameKey();
        if (gameKey == null) {
            gameKey = "";
        }
        Game value2 = aVar.a().getValue();
        String gameSubKey = value2 != null ? value2.getGameSubKey() : null;
        if (gameSubKey == null) {
            gameSubKey = "";
        }
        a<Result<e.l.h.i.e<GameCard>>> R0 = sellerDetailViewModel.R0(Z0, a1, gameKey, gameSubKey, true, null);
        SellerDetailActivity sellerDetailActivity = this.this$0;
        BinderKt.p(BinderKt.e(R0, sellerDetailActivity, sellerDetailActivity.E0(), false, 4, null));
    }
}
