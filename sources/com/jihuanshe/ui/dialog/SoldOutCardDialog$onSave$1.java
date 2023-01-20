package com.jihuanshe.ui.dialog;

import android.view.View;
import com.jihuanshe.R;
import com.jihuanshe.model.GameCard;
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

/* loaded from: classes2.dex */
public final class SoldOutCardDialog$onSave$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ p<WantCard, Boolean, t1> $save;
    public final /* synthetic */ SoldOutCardDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SoldOutCardDialog$onSave$1(SoldOutCardDialog soldOutCardDialog, p<? super WantCard, ? super Boolean, t1> pVar) {
        super(1);
        this.this$0 = soldOutCardDialog;
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
        WantCard wantCard = new WantCard(null, null, null, null, null, null, null, null, null, null, null, null, 0.0f, null, 0, null, 0, null, null, 524287, null);
        SoldOutCardDialog soldOutCardDialog = this.this$0;
        GameCard gameCard = soldOutCardDialog.getGameCard();
        wantCard.setId(gameCard == null ? null : gameCard.getProductId());
        try {
            Result.a aVar = Result.Companion;
            wantCard.setWishPrice(Float.valueOf(Float.parseFloat(soldOutCardDialog.getPriceEt().getText().toString())));
            m106constructorimpl = Result.m106constructorimpl(t1.a);
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            m106constructorimpl = Result.m106constructorimpl(r0.a(th));
        }
        if (Result.m109exceptionOrNullimpl(m106constructorimpl) != null) {
            e.a(wantCard, "价钱不能超过999999或非法输入，请重试");
            return;
        }
        Float wishPrice = wantCard.getWishPrice();
        if ((wishPrice == null ? 0.0f : wishPrice.floatValue()) <= 0.0f) {
            return;
        }
        if (wantCard.getWishPrice().floatValue() > 999999.0f) {
            e.a(wantCard, "价钱不能超过999999或非法输入，请重试");
        } else if (f0.g(soldOutCardDialog.getNumEt().getText().toString(), "") || soldOutCardDialog.getCount().getValue().intValue() <= 0) {
            e.f(wantCard, Res.w(Res.a, R.string.err_count_tip, null, 2, null), (r12 & 2) != 0 ? null : null, (r12 & 4) != 0 ? null : null, (r12 & 8) == 0 ? null : null, (r12 & 16) != 0 ? 1 : 0, (r12 & 32) != 0 ? 80 : null);
        } else {
            try {
                soldOutCardDialog.getCount().setValue(Integer.valueOf(Integer.parseInt(soldOutCardDialog.getNumEt().getText().toString())));
                wantCard.setRemark(soldOutCardDialog.getRemarkEt().getText().toString());
                Integer value = soldOutCardDialog.getCount().getValue();
                wantCard.setQuantity(value == null ? 1 : value.intValue());
                wantCard.setCondition(soldOutCardDialog.getMCondition().getValue());
                if (wantCard.getQuantity() <= 0) {
                    e.f(this.this$0, "数量错误不能为0", (r12 & 2) != 0 ? null : null, (r12 & 4) != 0 ? null : null, (r12 & 8) == 0 ? null : null, (r12 & 16) != 0 ? 1 : 0, (r12 & 32) != 0 ? 80 : null);
                    return;
                }
                this.this$0.h();
                p<WantCard, Boolean, t1> pVar = this.$save;
                if (pVar == null) {
                    return;
                }
                pVar.invoke(wantCard, Boolean.valueOf(this.this$0.getOn()));
            } catch (Exception unused) {
                e.f(wantCard, Res.w(Res.a, R.string.err_num_tip, null, 2, null), (r12 & 2) != 0 ? null : null, (r12 & 4) != 0 ? null : null, (r12 & 8) == 0 ? null : null, (r12 & 16) != 0 ? 1 : 0, (r12 & 32) != 0 ? 80 : null);
            }
        }
    }
}
