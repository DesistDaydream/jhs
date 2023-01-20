package com.jihuanshe.ui.page.user.selling;

import android.view.View;
import com.jihuanshe.model.Game;
import com.jihuanshe.model.GameCard;
import com.jihuanshe.ui.dialog.EditProductDialog;
import com.jihuanshe.ui.widget.GameBar;
import com.jihuanshe.viewmodel.user.selling.SellingChildViewModel;
import h.k2.u.p;
import h.t1;
import java.util.List;
import k.e.a.e;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellingChildFragment$onItemClick$1 extends Lambda implements p<View, Integer, t1> {
    public final /* synthetic */ SellingChildFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellingChildFragment$onItemClick$1(SellingChildFragment sellingChildFragment) {
        super(2);
        this.this$0 = sellingChildFragment;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(View view, Integer num) {
        invoke(view, num.intValue());
        return t1.a;
    }

    public final void invoke(@e View view, int i2) {
        List<GameCard> value = ((SellingChildViewModel) this.this$0.T()).D0().getValue();
        GameCard gameCard = value == null ? null : (GameCard) CollectionsKt___CollectionsKt.J2(value, i2);
        if (gameCard == null) {
            return;
        }
        EditProductDialog.a aVar = EditProductDialog.x;
        Integer productId = gameCard.getProductId();
        Integer valueOf = Integer.valueOf(gameCard.getVersionId());
        GameBar.a aVar2 = GameBar.b;
        Game value2 = aVar2.a().getValue();
        String gameKey = value2 == null ? null : value2.getGameKey();
        Game value3 = aVar2.a().getValue();
        aVar.a(productId, valueOf, gameKey, value3 != null ? value3.getGameSubKey() : null).show(this.this$0.getChildFragmentManager(), "edit_card");
    }
}
