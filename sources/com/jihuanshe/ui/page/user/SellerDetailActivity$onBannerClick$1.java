package com.jihuanshe.ui.page.user;

import android.view.View;
import com.jihuanshe.model.Banner;
import com.jihuanshe.ui.page.web.CommonWebViewActivityCreator;
import com.jihuanshe.viewmodel.user.SellerDetailViewModel;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellerDetailActivity$onBannerClick$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ SellerDetailActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellerDetailActivity$onBannerClick$1(SellerDetailActivity sellerDetailActivity) {
        super(1);
        this.this$0 = sellerDetailActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        if (((SellerDetailViewModel) this.this$0.L()).G0().getValue() == null) {
            return;
        }
        String deeplink = ((SellerDetailViewModel) this.this$0.L()).G0().getValue().getDeeplink();
        if (deeplink == null || deeplink.length() == 0) {
            return;
        }
        Banner value = ((SellerDetailViewModel) this.this$0.L()).G0().getValue();
        CommonWebViewActivityCreator.create(value == null ? null : value.getDeeplink()).start(this.this$0);
    }
}
