package com.jihuanshe.ui.page.shop;

import android.view.View;
import com.jihuanshe.R;
import com.jihuanshe.ui.dialog.DateOfBirthDialog;
import com.vector.util.Res;
import h.k2.u.l;
import h.t1;
import h.t2.u;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellerConfirmActivity$onChooseValidStartDate$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ SellerConfirmActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellerConfirmActivity$onChooseValidStartDate$1(SellerConfirmActivity sellerConfirmActivity) {
        super(1);
        this.this$0 = sellerConfirmActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        String str;
        String str2;
        String str3;
        String str4;
        DateOfBirthDialog dateOfBirthDialog = new DateOfBirthDialog(this.this$0, u.k2(Res.w(Res.a, R.string.common_valid_date_begin, null, 2, null), "\n", "", false, 4, null));
        SellerConfirmActivity sellerConfirmActivity = this.this$0;
        str = sellerConfirmActivity.N;
        if (str.length() > 0) {
            str2 = sellerConfirmActivity.N;
            str3 = sellerConfirmActivity.O;
            str4 = sellerConfirmActivity.P;
            dateOfBirthDialog.G(str2, str3, str4);
        } else {
            dateOfBirthDialog.F();
        }
        dateOfBirthDialog.setOnDoneClick(new SellerConfirmActivity$onChooseValidStartDate$1$1$1(sellerConfirmActivity));
        dateOfBirthDialog.y();
    }
}
