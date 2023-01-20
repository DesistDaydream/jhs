package com.jihuanshe.ui.page.user;

import android.view.View;
import com.jihuanshe.model.WantBuyList;
import com.jihuanshe.ui.dialog.WantBuyDialog;
import com.jihuanshe.viewmodel.user.WantBuyViewModel;
import h.k2.u.p;
import java.util.List;
import k.e.a.e;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class WantBuyActivity$onItemLongClick$1 extends Lambda implements p<View, Integer, Boolean> {
    public final /* synthetic */ WantBuyActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WantBuyActivity$onItemLongClick$1(WantBuyActivity wantBuyActivity) {
        super(2);
        this.this$0 = wantBuyActivity;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ Boolean invoke(View view, Integer num) {
        return Boolean.valueOf(invoke(view, num.intValue()));
    }

    public final boolean invoke(@e View view, int i2) {
        List<WantBuyList> value = ((WantBuyViewModel) this.this$0.L()).r0().getValue();
        WantBuyList wantBuyList = value == null ? null : (WantBuyList) CollectionsKt___CollectionsKt.J2(value, i2);
        if (wantBuyList == null) {
            return false;
        }
        this.this$0.q0(new WantBuyDialog(this.this$0, wantBuyList));
        WantBuyDialog f0 = this.this$0.f0();
        if (f0 == null) {
            return true;
        }
        f0.y();
        return true;
    }
}
