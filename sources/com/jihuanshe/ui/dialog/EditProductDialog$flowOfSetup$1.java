package com.jihuanshe.ui.dialog;

import android.view.View;
import com.jihuanshe.model.CardProductNew;
import com.jihuanshe.model.GameCard;
import e.l.q.b.b.a.d;
import e.n.f;
import h.k2.u.l;
import h.t1;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class EditProductDialog$flowOfSetup$1 extends Lambda implements l<GameCard, t1> {
    public final /* synthetic */ EditProductDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditProductDialog$flowOfSetup$1(EditProductDialog editProductDialog) {
        super(1);
        this.this$0 = editProductDialog;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(GameCard gameCard) {
        invoke2(gameCard);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e GameCard gameCard) {
        int i2;
        String str;
        f<CardProductNew> E = this.this$0.E();
        String versionNum = gameCard == null ? null : gameCard.getVersionNum();
        String str2 = versionNum != null ? versionNum : "";
        String image = gameCard == null ? null : gameCard.getImage();
        String rarity = gameCard == null ? null : gameCard.getRarity();
        String str3 = rarity != null ? rarity : "";
        String userImage = gameCard == null ? null : gameCard.getUserImage();
        String nwName = gameCard == null ? null : gameCard.getNwName();
        String str4 = nwName != null ? nwName : "";
        String cnocgname = gameCard == null ? null : gameCard.getCnocgname();
        CardProductNew cardProductNew = new CardProductNew(gameCard == null ? 0.0f : gameCard.getAvgPrice(), 0.0f, 0, str4, cnocgname != null ? cnocgname : "", null, image, str2, str3, gameCard == null ? 0.0f : gameCard.getMinPrice(), false, null, false, null, null, userImage, gameCard == null ? null : gameCard.getProductLan(), null, 162854, null);
        EditProductDialog editProductDialog = this.this$0;
        i2 = editProductDialog.f3970f;
        cardProductNew.setCardVersionId(Integer.valueOf(i2));
        str = editProductDialog.f3971g;
        cardProductNew.setGameKey(str);
        t1 t1Var = t1.a;
        E.r(cardProductNew);
        this.this$0.M().r(gameCard);
        f<d> N = this.this$0.N();
        View requireView = this.this$0.requireView();
        int quantity = gameCard == null ? 0 : gameCard.getQuantity();
        String remark = gameCard != null ? gameCard.getRemark() : null;
        N.r(new e.l.q.b.b.a.f(requireView, quantity, remark != null ? remark : ""));
    }
}
