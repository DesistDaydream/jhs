package com.jihuanshe.ui.dialog;

import android.content.Context;
import android.view.View;
import com.jihuanshe.model.Game;
import com.jihuanshe.ui.dialog.HomeWantSellDialog;
import com.jihuanshe.ui.page.shop.AddProductActivityCreator;
import com.jihuanshe.ui.page.user.selling.SellingActivityCreator;
import com.jihuanshe.ui.widget.GameBar;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class HomeWantSellDialog$onClickSell$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ HomeWantSellDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeWantSellDialog$onClickSell$1(HomeWantSellDialog homeWantSellDialog, Context context) {
        super(1);
        this.this$0 = homeWantSellDialog;
        this.$context = context;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        Integer type = this.this$0.getType();
        HomeWantSellDialog.a aVar = HomeWantSellDialog.y;
        int b = aVar.b();
        if (type != null && type.intValue() == b) {
            SellingActivityCreator.create().start(this.$context);
            return;
        }
        int a = aVar.a();
        if (type != null && type.intValue() == a) {
            Integer id = this.this$0.getId();
            GameBar.a aVar2 = GameBar.b;
            Game value = aVar2.a().getValue();
            String gameKey = value == null ? null : value.getGameKey();
            Game value2 = aVar2.a().getValue();
            AddProductActivityCreator.create(id, gameKey, value2 != null ? value2.getGameSubKey() : null).start(this.$context);
        }
    }
}
