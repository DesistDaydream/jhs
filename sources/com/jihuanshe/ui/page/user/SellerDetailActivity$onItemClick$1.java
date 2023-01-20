package com.jihuanshe.ui.page.user;

import android.view.View;
import com.jihuanshe.model.Game;
import com.jihuanshe.model.GameCard;
import com.jihuanshe.ui.dialog.CardProductDialogFragment;
import com.jihuanshe.ui.dialog.ContactDialog;
import com.jihuanshe.ui.widget.GameBar;
import com.jihuanshe.viewmodel.user.SellerDetailViewModel;
import h.k2.u.p;
import h.t1;
import java.util.List;
import k.e.a.e;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellerDetailActivity$onItemClick$1 extends Lambda implements p<View, Integer, t1> {
    public final /* synthetic */ SellerDetailActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellerDetailActivity$onItemClick$1(SellerDetailActivity sellerDetailActivity) {
        super(2);
        this.this$0 = sellerDetailActivity;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(View view, Integer num) {
        invoke(view, num.intValue());
        return t1.a;
    }

    public final void invoke(@e View view, int i2) {
        List<GameCard> value = ((SellerDetailViewModel) this.this$0.L()).H0().getValue();
        GameCard gameCard = value == null ? null : (GameCard) CollectionsKt___CollectionsKt.J2(value, i2);
        if (gameCard == null) {
            return;
        }
        if (((SellerDetailViewModel) this.this$0.L()).d1()) {
            gameCard.setGame(GameBar.b.a().getValue());
            SellerDetailActivity sellerDetailActivity = this.this$0;
            new ContactDialog(sellerDetailActivity, gameCard, (SellerDetailViewModel) sellerDetailActivity.L()).y();
            return;
        }
        CardProductDialogFragment.a aVar = CardProductDialogFragment.w;
        Integer valueOf = Integer.valueOf(this.this$0.Z0());
        Integer valueOf2 = Integer.valueOf(gameCard.getVersionId());
        GameBar.a aVar2 = GameBar.b;
        Game value2 = aVar2.a().getValue();
        String gameKey = value2 == null ? null : value2.getGameKey();
        if (gameKey == null) {
            gameKey = "";
        }
        Game value3 = aVar2.a().getValue();
        String gameSubKey = value3 != null ? value3.getGameSubKey() : null;
        aVar.a(valueOf, valueOf2, gameKey, gameSubKey != null ? gameSubKey : "").show(this.this$0.getSupportFragmentManager(), "card_product");
    }
}
