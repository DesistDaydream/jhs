package com.jihuanshe.ui.page.main.shop;

import android.view.View;
import com.jihuanshe.viewmodel.main.shop.ShopViewModel;
import e.l.k.sf;
import h.k2.u.a;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ShopFragment$header$2 extends Lambda implements a<View> {
    public final /* synthetic */ ShopFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShopFragment$header$2(ShopFragment shopFragment) {
        super(0);
        this.this$0 = shopFragment;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @d
    public final View invoke() {
        sf e2 = sf.e(this.this$0.getLayoutInflater());
        e2.setLifecycleOwner(this.this$0);
        e2.i(this.this$0);
        e2.j((ShopViewModel) this.this$0.T());
        return e2.getRoot();
    }
}
