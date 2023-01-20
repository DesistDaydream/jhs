package com.jihuanshe.ui.page.user;

import android.view.View;
import com.jihuanshe.model.MatchResult;
import com.jihuanshe.viewmodel.user.WantBuyMatchViewModel;
import h.k2.u.p;
import h.t1;
import java.util.List;
import k.e.a.e;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class WantBuyMatchActivity$onItemClick$1 extends Lambda implements p<View, Integer, t1> {
    public final /* synthetic */ WantBuyMatchActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WantBuyMatchActivity$onItemClick$1(WantBuyMatchActivity wantBuyMatchActivity) {
        super(2);
        this.this$0 = wantBuyMatchActivity;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(View view, Integer num) {
        invoke(view, num.intValue());
        return t1.a;
    }

    public final void invoke(@e View view, int i2) {
        List<MatchResult> value = ((WantBuyMatchViewModel) this.this$0.L()).q0().getValue();
        MatchResult matchResult = value == null ? null : (MatchResult) CollectionsKt___CollectionsKt.J2(value, i2);
        if (matchResult == null) {
            return;
        }
        SellerDetailActivityCreator wid = SellerDetailActivityCreator.create(matchResult.getUid(), null).wid(this.this$0.d0());
        Boolean value2 = ((WantBuyMatchViewModel) this.this$0.L()).r0().getValue();
        if (value2 == null) {
            value2 = Boolean.FALSE;
        }
        wid.ignoreVersion(value2).start(this.this$0);
    }
}
