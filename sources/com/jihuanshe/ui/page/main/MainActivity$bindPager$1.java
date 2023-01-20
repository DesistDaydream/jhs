package com.jihuanshe.ui.page.main;

import androidx.fragment.app.Fragment;
import com.jihuanshe.ui.page.im.ImConversationFragment;
import com.jihuanshe.ui.page.main.me.MeFragment;
import com.jihuanshe.ui.page.main.shop.ShopFragment;
import h.k2.u.l;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class MainActivity$bindPager$1 extends Lambda implements l<Integer, Fragment> {
    public final /* synthetic */ MainActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainActivity$bindPager$1(MainActivity mainActivity) {
        super(1);
        this.this$0 = mainActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ Fragment invoke(Integer num) {
        return invoke(num.intValue());
    }

    @d
    public final Fragment invoke(int i2) {
        ShopFragment shopFragment;
        ImConversationFragment imConversationFragment;
        MeFragment meFragment;
        if (i2 == 0) {
            this.this$0.q = new ShopFragment();
            shopFragment = this.this$0.q;
            return shopFragment;
        } else if (i2 != 1) {
            this.this$0.s = new MeFragment();
            meFragment = this.this$0.s;
            return meFragment;
        } else {
            this.this$0.r = new ImConversationFragment();
            imConversationFragment = this.this$0.r;
            return imConversationFragment;
        }
    }
}
