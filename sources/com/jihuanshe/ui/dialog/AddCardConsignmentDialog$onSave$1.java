package com.jihuanshe.ui.dialog;

import android.view.View;
import com.jihuanshe.R;
import com.jihuanshe.model.CardProductNew;
import com.jihuanshe.model.WantCard;
import com.vector.util.Res;
import e.l.h.j.b.e;
import h.k2.u.l;
import h.k2.u.p;
import h.k2.v.f0;
import h.r0;
import h.t1;
import k.e.a.d;
import kotlin.Result;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: classes2.dex */
public final class AddCardConsignmentDialog$onSave$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ p<WantCard, Boolean, t1> $save;
    public final /* synthetic */ AddCardConsignmentDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AddCardConsignmentDialog$onSave$1(AddCardConsignmentDialog addCardConsignmentDialog, p<? super WantCard, ? super Boolean, t1> pVar) {
        super(1);
        this.this$0 = addCardConsignmentDialog;
        this.$save = pVar;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        Object m106constructorimpl;
        Object m106constructorimpl2;
        String str;
        WantCard wantCard = this.this$0.getWantCard();
        WantCard wantCard2 = wantCard == null ? new WantCard(null, null, null, null, null, null, null, null, null, null, null, null, 0.0f, null, 0, null, 0, null, null, 524287, null) : wantCard;
        AddCardConsignmentDialog addCardConsignmentDialog = this.this$0;
        String obj = StringsKt__StringsKt.B5(addCardConsignmentDialog.getPriceEt().getText()).toString();
        boolean z = false;
        if (obj.length() == 0) {
            e.a(wantCard2, "请输入价格");
            return;
        }
        try {
            Result.a aVar = Result.Companion;
            wantCard2.setWishPrice(Float.valueOf(Float.parseFloat(obj)));
            m106constructorimpl = Result.m106constructorimpl(t1.a);
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            m106constructorimpl = Result.m106constructorimpl(r0.a(th));
        }
        if (Result.m109exceptionOrNullimpl(m106constructorimpl) != null) {
            e.a(wantCard2, "非法输入，请重试");
            return;
        }
        if (!(obj.length() == 0) && Float.parseFloat(obj) > 0.0f) {
            if (Float.parseFloat(obj) > 999999.0f) {
                e.a(wantCard2, "价格不能大于999999元");
                return;
            } else if (f0.g(addCardConsignmentDialog.getNumEt().getText().toString(), "") || addCardConsignmentDialog.getCount().getValue().intValue() <= 0) {
                e.f(wantCard2, Res.w(Res.a, R.string.err_count_tip, null, 2, null), (r12 & 2) != 0 ? null : null, (r12 & 4) != 0 ? null : null, (r12 & 8) == 0 ? null : null, (r12 & 16) != 0 ? 1 : 0, (r12 & 32) != 0 ? 80 : null);
                return;
            } else {
                try {
                    Result.a aVar3 = Result.Companion;
                    addCardConsignmentDialog.getCount().setValue(Integer.valueOf(Integer.parseInt(addCardConsignmentDialog.getNumEt().getText().toString())));
                    m106constructorimpl2 = Result.m106constructorimpl(t1.a);
                } catch (Throwable th2) {
                    Result.a aVar4 = Result.Companion;
                    m106constructorimpl2 = Result.m106constructorimpl(r0.a(th2));
                }
                if (Result.m109exceptionOrNullimpl(m106constructorimpl2) != null) {
                    e.f(wantCard2, Res.w(Res.a, R.string.err_num_tip, null, 2, null), (r12 & 2) != 0 ? null : null, (r12 & 4) != 0 ? null : null, (r12 & 8) == 0 ? null : null, (r12 & 16) != 0 ? 1 : 0, (r12 & 32) != 0 ? 80 : null);
                    return;
                }
                Integer value = addCardConsignmentDialog.getCount().getValue();
                wantCard2.setQuantity(value == null ? 1 : value.intValue());
                CardProductNew cardProduct = addCardConsignmentDialog.getCardProduct();
                if (cardProduct != null && cardProduct.getNeedPublishLocation()) {
                    z = true;
                }
                if (z) {
                    Integer value2 = addCardConsignmentDialog.getLocationData().getValue();
                    str = (value2 != null && value2.intValue() == 1) ? "asia" : "jp";
                } else {
                    str = "default";
                }
                wantCard2.setLocation(str);
                wantCard2.setShowSold(addCardConsignmentDialog.E());
                p<WantCard, Boolean, t1> pVar = this.$save;
                if (pVar != null) {
                    pVar.invoke(wantCard2, this.this$0.E());
                }
                this.this$0.h();
                return;
            }
        }
        e.a(wantCard2, "价格必须大于0");
    }
}
