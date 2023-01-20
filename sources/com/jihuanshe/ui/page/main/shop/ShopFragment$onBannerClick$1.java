package com.jihuanshe.ui.page.main.shop;

import android.view.View;
import com.jihuanshe.model.Banner;
import com.jihuanshe.ui.page.web.CommonWebViewActivityCreator;
import com.jihuanshe.viewmodel.main.shop.ShopViewModel;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ShopFragment$onBannerClick$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ ShopFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShopFragment$onBannerClick$1(ShopFragment shopFragment) {
        super(1);
        this.this$0 = shopFragment;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        Banner value = ((ShopViewModel) this.this$0.T()).q0().getValue();
        if (value == null) {
            return;
        }
        String deeplink = value.getDeeplink();
        if (deeplink == null || deeplink.length() == 0) {
            return;
        }
        CommonWebViewActivityCreator.create(value.getDeeplink()).start(this.this$0.getActivity());
    }
}
