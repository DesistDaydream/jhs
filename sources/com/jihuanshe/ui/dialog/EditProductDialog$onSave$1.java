package com.jihuanshe.ui.dialog;

import android.view.View;
import com.jihuanshe.model.CardProductNew;
import com.jihuanshe.model.GameCard;
import e.l.h.d.f;
import e.l.j.a;
import h.k2.u.l;
import h.t1;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class EditProductDialog$onSave$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ EditProductDialog this$0;

    /* renamed from: com.jihuanshe.ui.dialog.EditProductDialog$onSave$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements l<t1, t1> {
        public final /* synthetic */ int $condition;
        public final /* synthetic */ int $count;
        public final /* synthetic */ int $defaultP;
        public final /* synthetic */ GameCard $gameCard;
        public final /* synthetic */ int $onSale;
        public final /* synthetic */ Float $price;
        public final /* synthetic */ String $remark;
        public final /* synthetic */ EditProductDialog this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(GameCard gameCard, EditProductDialog editProductDialog, Float f2, int i2, String str, int i3, int i4, int i5) {
            super(1);
            this.$gameCard = gameCard;
            this.this$0 = editProductDialog;
            this.$price = f2;
            this.$condition = i2;
            this.$remark = str;
            this.$count = i3;
            this.$onSale = i4;
            this.$defaultP = i5;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(t1 t1Var) {
            invoke2(t1Var);
            return t1.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@e t1 t1Var) {
            int i2;
            f fVar = f.b;
            GameCard gameCard = this.$gameCard;
            EditProductDialog editProductDialog = this.this$0;
            Float f2 = this.$price;
            int i3 = this.$condition;
            String str = this.$remark;
            int i4 = this.$count;
            int i5 = this.$onSale;
            int i6 = this.$defaultP;
            i2 = editProductDialog.f3969e;
            gameCard.setProductId(Integer.valueOf(i2));
            gameCard.setCardPrice(f2.floatValue());
            gameCard.setCondition(Integer.valueOf(i3));
            gameCard.setRemark(str);
            gameCard.setQuantity(i4);
            CardProductNew value = editProductDialog.E().getValue();
            String str2 = null;
            String userUploadPhotoPath = value == null ? null : value.getUserUploadPhotoPath();
            if (userUploadPhotoPath == null || userUploadPhotoPath.length() == 0) {
                String image = gameCard.getImage();
                str2 = image == null || image.length() == 0 ? "1" : gameCard.getImage();
            } else {
                CardProductNew value2 = editProductDialog.E().getValue();
                if (value2 != null) {
                    str2 = value2.getUserUploadPhotoPath();
                }
            }
            gameCard.setImage(str2);
            gameCard.setOnSell(i5);
            gameCard.setDefaultProduct(i6 == 1);
            t1 t1Var2 = t1.a;
            fVar.c(a.f12243m, gameCard);
            this.this$0.dismiss();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditProductDialog$onSave$1(EditProductDialog editProductDialog) {
        super(1);
        this.this$0 = editProductDialog;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0124  */
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void invoke2(@k.e.a.d android.view.View r24) {
        /*
            Method dump skipped, instructions count: 404
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jihuanshe.ui.dialog.EditProductDialog$onSave$1.invoke2(android.view.View):void");
    }
}
