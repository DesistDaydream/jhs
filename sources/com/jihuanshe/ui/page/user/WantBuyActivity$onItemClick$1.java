package com.jihuanshe.ui.page.user;

import android.view.View;
import com.jihuanshe.model.WantBuyList;
import com.jihuanshe.viewmodel.user.WantBuyViewModel;
import h.k2.u.p;
import h.t1;
import java.util.List;
import k.e.a.e;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class WantBuyActivity$onItemClick$1 extends Lambda implements p<View, Integer, t1> {
    public final /* synthetic */ WantBuyActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WantBuyActivity$onItemClick$1(WantBuyActivity wantBuyActivity) {
        super(2);
        this.this$0 = wantBuyActivity;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(View view, Integer num) {
        invoke(view, num.intValue());
        return t1.a;
    }

    public final void invoke(@e View view, int i2) {
        List<WantBuyList> value = ((WantBuyViewModel) this.this$0.L()).r0().getValue();
        WantBuyList wantBuyList = value == null ? null : (WantBuyList) CollectionsKt___CollectionsKt.J2(value, i2);
        if (wantBuyList == null) {
            return;
        }
        WantCardListActivityCreator.create(wantBuyList).start(this.this$0);
    }
}
