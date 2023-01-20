package com.jihuanshe.ui.dialog;

import android.view.View;
import com.jihuanshe.R;
import com.jihuanshe.model.CardPack;
import com.jihuanshe.model.CardVersion;
import com.jihuanshe.model.WantCard;
import com.jihuanshe.ui.widget.NumberView;
import com.vector.util.Res;
import e.l.h.j.b.e;
import e.l.k.e6;
import h.k2.u.l;
import h.r0;
import h.t1;
import k.e.a.d;
import kotlin.Result;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class AddCardDialog$onSave$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ l<WantCard, t1> $save;
    public final /* synthetic */ AddCardDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AddCardDialog$onSave$1(AddCardDialog addCardDialog, l<? super WantCard, t1> lVar) {
        super(1);
        this.this$0 = addCardDialog;
        this.$save = lVar;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        NumberView numberView;
        Object m106constructorimpl;
        Object m106constructorimpl2;
        WantCard wantCard = this.this$0.getWantCard();
        WantCard wantCard2 = wantCard == null ? new WantCard(null, null, null, null, null, null, null, null, null, null, null, null, 0.0f, null, 0, null, 0, null, null, 524287, null) : wantCard;
        e6 binding = this.this$0.getBinding();
        int value = (binding == null || (numberView = binding.a) == null) ? 0 : numberView.getValue();
        if (value <= 0) {
            e.a(this.this$0, Res.w(Res.a, R.string.error_count, null, 2, null));
            return;
        }
        AddCardDialog addCardDialog = this.this$0;
        String obj = addCardDialog.getPriceEt().getText().toString();
        if (addCardDialog.getHasRarity()) {
            if (obj.length() == 0) {
                e.a(wantCard2, "价钱不能为0");
                return;
            }
            try {
                Result.a aVar = Result.Companion;
                wantCard2.setWishPrice(Float.valueOf(Float.parseFloat(obj)));
                m106constructorimpl2 = Result.m106constructorimpl(t1.a);
            } catch (Throwable th) {
                Result.a aVar2 = Result.Companion;
                m106constructorimpl2 = Result.m106constructorimpl(r0.a(th));
            }
            if (Result.m109exceptionOrNullimpl(m106constructorimpl2) != null) {
                e.a(wantCard2, "价钱不能超过999999或非法输入，请重试");
                return;
            }
            Float wishPrice = wantCard2.getWishPrice();
            if ((wishPrice == null ? 0.0f : wishPrice.floatValue()) <= 0.0f) {
                e.a(wantCard2, "价钱不能为0");
                return;
            } else if (wantCard2.getWishPrice().floatValue() > 999999.0f) {
                e.a(wantCard2, "价钱不能超过999999或非法输入，请重试");
                return;
            }
        }
        try {
            Result.a aVar3 = Result.Companion;
            wantCard2.setWishPrice(Float.valueOf(Float.parseFloat(addCardDialog.getPriceEt().getText().toString())));
            m106constructorimpl = Result.m106constructorimpl(t1.a);
        } catch (Throwable th2) {
            Result.a aVar4 = Result.Companion;
            m106constructorimpl = Result.m106constructorimpl(r0.a(th2));
        }
        if (Result.m109exceptionOrNullimpl(m106constructorimpl) != null) {
            wantCard2.setWishPrice(null);
        }
        wantCard2.setRemark(addCardDialog.getRemarkEt().getText().toString());
        Integer value2 = addCardDialog.getIgnore().getValue();
        wantCard2.setIgnoreVersion(value2 != null ? value2.intValue() : 0);
        CardPack value3 = addCardDialog.getVersion().getValue();
        wantCard2.setVersionId(value3 == null ? null : Integer.valueOf(value3.getVersionId()));
        wantCard2.setQuantity(value);
        wantCard2.setCondition(addCardDialog.getRarity().getValue());
        CardVersion value4 = addCardDialog.getCurCardVer().getValue();
        wantCard2.setVersionNum(value4 == null ? null : value4.getNumber());
        CardVersion value5 = addCardDialog.getCurCardVer().getValue();
        wantCard2.setRarity(value5 == null ? null : value5.getRarity());
        CardVersion value6 = addCardDialog.getCurCardVer().getValue();
        wantCard2.setImage(value6 != null ? value6.getImage() : null);
        this.this$0.h();
        l<WantCard, t1> lVar = this.$save;
        if (lVar == null) {
            return;
        }
        lVar.invoke(wantCard2);
    }
}
