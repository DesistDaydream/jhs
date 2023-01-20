package com.jihuanshe.ui.page.main.shop;

import com.jihuanshe.R;
import com.jihuanshe.model.stat.STATConstant;
import com.jihuanshe.ui.widget.GameBarView;
import com.vector.design.ui.nav.ViewAttrs;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ShopFragment$flowOfAppBar$3 extends Lambda implements l<ViewAttrs, t1> {
    public final /* synthetic */ ShopFragment this$0;

    /* renamed from: com.jihuanshe.ui.page.main.shop.ShopFragment$flowOfAppBar$3$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements l<Boolean, t1> {
        public final /* synthetic */ ShopFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ShopFragment shopFragment) {
            super(1);
            this.this$0 = shopFragment;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return t1.a;
        }

        public final void invoke(boolean z) {
            if (z) {
                this.this$0.A().setBackgroundResource(R.color.white);
                return;
            }
            this.this$0.A().setBackgroundResource(R.color.black_f8f8fa);
            this.this$0.R0(STATConstant.OP_HOME_SHOP.CHANGE_GAME);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShopFragment$flowOfAppBar$3(ShopFragment shopFragment) {
        super(1);
        this.this$0 = shopFragment;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(ViewAttrs viewAttrs) {
        invoke2(viewAttrs);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d ViewAttrs viewAttrs) {
        viewAttrs.s(new GameBarView(this.this$0.requireActivity(), new AnonymousClass1(this.this$0), null, null, 12, null));
    }
}
