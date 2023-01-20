package com.jihuanshe.ui.page.main.shop;

import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.Category;
import com.jihuanshe.model.Game;
import com.jihuanshe.viewmodel.main.shop.ShopViewModel;
import com.vector.design.ui.delegate.LoadMore;
import e.g.d.a;
import h.k2.u.l;
import h.t1;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ShopFragment$initGameObserver$1 extends Lambda implements l<Game, t1> {
    public final /* synthetic */ ShopFragment this$0;

    /* renamed from: com.jihuanshe.ui.page.main.shop.ShopFragment$initGameObserver$1$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass2 extends Lambda implements l<Object, t1> {
        public final /* synthetic */ ShopFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ShopFragment shopFragment) {
            super(1);
            this.this$0 = shopFragment;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(Object obj) {
            invoke2(obj);
            return t1.a;
        }

        @Override // h.k2.u.l
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@e Object obj) {
            this.this$0.u0().f(LoadMore.State.END);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShopFragment$initGameObserver$1(ShopFragment shopFragment) {
        super(1);
        this.this$0 = shopFragment;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Game game) {
        invoke2(game);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d Game game) {
        a<?> v0 = ((ShopViewModel) this.this$0.T()).v0(game);
        ShopFragment shopFragment = this.this$0;
        List<Category> value = ((ShopViewModel) shopFragment.T()).u0().getValue();
        if (value == null || value.isEmpty()) {
            BinderKt.r(v0, shopFragment, true);
        } else {
            BinderKt.p(v0);
        }
        a.j(v0, null, new AnonymousClass2(this.this$0), 1, null);
    }
}
