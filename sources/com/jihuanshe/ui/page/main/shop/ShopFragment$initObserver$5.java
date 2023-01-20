package com.jihuanshe.ui.page.main.shop;

import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.Category;
import com.jihuanshe.model.Constants;
import com.jihuanshe.model.Game;
import com.jihuanshe.ui.page.main.shop.ShopFragment;
import com.jihuanshe.ui.page.main.shop.ShopFragment$initObserver$5;
import com.jihuanshe.ui.widget.GameBar;
import com.jihuanshe.viewmodel.main.shop.ShopViewModel;
import com.vector.ext.AnyKt;
import com.vector.view.scrollable.ListView;
import e.g.d.a;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ShopFragment$initObserver$5 extends Lambda implements l<String, t1> {
    public final /* synthetic */ ShopFragment this$0;

    /* renamed from: com.jihuanshe.ui.page.main.shop.ShopFragment$initObserver$5$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements l<Object, t1> {
        public final /* synthetic */ ShopFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ShopFragment shopFragment) {
            super(1);
            this.this$0 = shopFragment;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: invoke$lambda-0  reason: not valid java name */
        public static final void m25invoke$lambda0(ShopFragment shopFragment) {
            AnyKt.z(new ShopFragment$initObserver$5$1$1$1(shopFragment));
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(Object obj) {
            invoke2(obj);
            return t1.a;
        }

        @Override // h.k2.u.l
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@e Object obj) {
            ListView u0 = this.this$0.u0();
            final ShopFragment shopFragment = this.this$0;
            u0.postDelayed(new Runnable() { // from class: e.l.q.b.g.b.c
                @Override // java.lang.Runnable
                public final void run() {
                    ShopFragment$initObserver$5.AnonymousClass1.m25invoke$lambda0(ShopFragment.this);
                }
            }, 100L);
        }
    }

    /* renamed from: com.jihuanshe.ui.page.main.shop.ShopFragment$initObserver$5$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass2 extends Lambda implements l<Object, t1> {
        public final /* synthetic */ ShopFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ShopFragment shopFragment) {
            super(1);
            this.this$0 = shopFragment;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: invoke$lambda-0  reason: not valid java name */
        public static final void m26invoke$lambda0(ShopFragment shopFragment) {
            AnyKt.z(new ShopFragment$initObserver$5$2$1$1(shopFragment));
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(Object obj) {
            invoke2(obj);
            return t1.a;
        }

        @Override // h.k2.u.l
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@e Object obj) {
            ListView u0 = this.this$0.u0();
            final ShopFragment shopFragment = this.this$0;
            u0.postDelayed(new Runnable() { // from class: e.l.q.b.g.b.d
                @Override // java.lang.Runnable
                public final void run() {
                    ShopFragment$initObserver$5.AnonymousClass2.m26invoke$lambda0(ShopFragment.this);
                }
            }, 100L);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShopFragment$initObserver$5(ShopFragment shopFragment) {
        super(1);
        this.this$0 = shopFragment;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(String str) {
        invoke2(str);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d String str) {
        Category value = ((ShopViewModel) this.this$0.T()).x0().getValue();
        boolean z = false;
        if (value != null && value.getId() == Constants.Companion.getCATEGORY_ID()) {
            z = true;
        }
        if (z) {
            ShopViewModel shopViewModel = (ShopViewModel) this.this$0.T();
            int warehouse_seller_user_id = Constants.Companion.getWAREHOUSE_SELLER_USER_ID();
            GameBar.a aVar = GameBar.b;
            Game value2 = aVar.a().getValue();
            String gameKey = value2 == null ? null : value2.getGameKey();
            if (gameKey == null) {
                gameKey = "";
            }
            Game value3 = aVar.a().getValue();
            String gameSubKey = value3 == null ? null : value3.getGameSubKey();
            a j2 = a.j(shopViewModel.A0(warehouse_seller_user_id, gameKey, gameSubKey != null ? gameSubKey : "", true, null), null, new AnonymousClass1(this.this$0), 1, null);
            ShopFragment shopFragment = this.this$0;
            BinderKt.p(BinderKt.e(j2, shopFragment, shopFragment.u0(), false, 4, null));
        } else if (((ShopViewModel) this.this$0.T()).w0().getValue() == null) {
        } else {
            a p = BinderKt.p(a.j(((ShopViewModel) this.this$0.T()).s0(GameBar.b.a().getValue(), ((ShopViewModel) this.this$0.T()).w0().getValue(), null, true), null, new AnonymousClass2(this.this$0), 1, null));
            ShopFragment shopFragment2 = this.this$0;
            BinderKt.e(p, shopFragment2, shopFragment2.u0(), false, 4, null);
        }
    }
}
