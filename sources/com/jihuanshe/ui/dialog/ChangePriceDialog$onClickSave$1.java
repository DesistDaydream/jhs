package com.jihuanshe.ui.dialog;

import android.view.View;
import com.jihuanshe.R;
import com.vector.util.Res;
import e.l.h.j.b.e;
import h.k2.u.l;
import h.k2.u.p;
import h.r0;
import h.t1;
import k.e.a.d;
import kotlin.Result;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ChangePriceDialog$onClickSave$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ ChangePriceDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChangePriceDialog$onClickSave$1(ChangePriceDialog changePriceDialog) {
        super(1);
        this.this$0 = changePriceDialog;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        Object m106constructorimpl;
        String obj;
        boolean z;
        t1 t1Var;
        ChangePriceDialog changePriceDialog = this.this$0;
        try {
            Result.a aVar = Result.Companion;
            obj = changePriceDialog.getPriceEt().getText().toString();
            z = true;
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            m106constructorimpl = Result.m106constructorimpl(r0.a(th));
        }
        if (obj.length() == 0) {
            return;
        }
        float parseFloat = Float.parseFloat(obj);
        String obj2 = changePriceDialog.getShippingEt().getText().toString();
        if (obj2.length() != 0) {
            z = false;
        }
        float parseFloat2 = z ? 0.0f : Float.parseFloat(obj2);
        changePriceDialog.h();
        p<Float, Float, t1> listener = changePriceDialog.getListener();
        if (listener == null) {
            t1Var = null;
        } else {
            listener.invoke(Float.valueOf(parseFloat), Float.valueOf(parseFloat2));
            t1Var = t1.a;
        }
        m106constructorimpl = Result.m106constructorimpl(t1Var);
        ChangePriceDialog changePriceDialog2 = this.this$0;
        if (Result.m109exceptionOrNullimpl(m106constructorimpl) != null) {
            e.f(changePriceDialog2, Res.w(Res.a, R.string.shop_price_err, null, 2, null), (r12 & 2) != 0 ? null : null, (r12 & 4) != 0 ? null : null, (r12 & 8) == 0 ? null : null, (r12 & 16) != 0 ? 1 : 0, (r12 & 32) != 0 ? 80 : null);
        }
    }
}
