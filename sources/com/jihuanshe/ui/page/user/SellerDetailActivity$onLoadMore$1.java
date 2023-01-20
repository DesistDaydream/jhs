package com.jihuanshe.ui.page.user;

import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.Game;
import com.jihuanshe.ui.widget.GameBar;
import com.jihuanshe.viewmodel.user.SellerDetailViewModel;
import com.vector.design.ui.delegate.LoadMore;
import e.t.v.j.g;
import h.k2.u.p;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellerDetailActivity$onLoadMore$1 extends Lambda implements p<g<?>, LoadMore.State, t1> {
    public final /* synthetic */ SellerDetailActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellerDetailActivity$onLoadMore$1(SellerDetailActivity sellerDetailActivity) {
        super(2);
        this.this$0 = sellerDetailActivity;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(g<?> gVar, LoadMore.State state) {
        invoke2(gVar, state);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d g<?> gVar, @d LoadMore.State state) {
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
        BinderKt.d(sellerDetailViewModel.R0(Z0, a1, gameKey, gameSubKey, false, state), this.this$0, gVar, true);
    }
}
