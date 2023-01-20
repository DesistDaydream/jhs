package com.jihuanshe.ui.dialog;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.jihuanshe.model.CardBaseInfo;
import e.l.q.b.h.k;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CardDetailDialog$onClickPreview$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ CardDetailDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardDetailDialog$onClickPreview$1(Context context, CardDetailDialog cardDetailDialog) {
        super(1);
        this.$context = context;
        this.this$0 = cardDetailDialog;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        Activity activity = (Activity) this.$context;
        CardBaseInfo value = this.this$0.getCardInfo().getValue();
        new k(activity, value == null ? null : value.getImage(), (ImageView) view).t();
    }
}
