package com.jihuanshe.ui.page.user;

import android.view.View;
import com.jihuanshe.R;
import com.jihuanshe.ui.page.shop.SellerConfirmActivityCreator;
import com.jihuanshe.ui.widget.CoinPopupWindow;
import com.vector.design.ui.nav.ImageAttrs;
import e.t.o.d;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CoinActivity$flowOfAppBar$2 extends Lambda implements l<ImageAttrs, t1> {
    public final /* synthetic */ CoinActivity this$0;

    /* renamed from: com.jihuanshe.ui.page.user.CoinActivity$flowOfAppBar$2$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements l<View, t1> {
        public final /* synthetic */ CoinActivity this$0;

        /* renamed from: com.jihuanshe.ui.page.user.CoinActivity$flowOfAppBar$2$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C01251 extends Lambda implements l<Integer, t1> {
            public final /* synthetic */ CoinActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01251(CoinActivity coinActivity) {
                super(1);
                this.this$0 = coinActivity;
            }

            @Override // h.k2.u.l
            public /* bridge */ /* synthetic */ t1 invoke(Integer num) {
                invoke(num.intValue());
                return t1.a;
            }

            public final void invoke(int i2) {
                if (i2 == 1) {
                    SellerConfirmActivityCreator.create().start(this.this$0);
                } else if (i2 != 2) {
                } else {
                    this.this$0.d0().setValue(Integer.valueOf(1 - this.this$0.d0().getValue().intValue()));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(CoinActivity coinActivity) {
            super(1);
            this.this$0 = coinActivity;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(View view) {
            invoke2(view);
            return t1.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@d View view) {
            View view2;
            CoinActivity coinActivity = this.this$0;
            CoinPopupWindow coinPopupWindow = new CoinPopupWindow(coinActivity, 1 - coinActivity.d0().getValue().intValue(), new C01251(this.this$0));
            view2 = this.this$0.y;
            coinPopupWindow.showAsDropDown(view2, -d.a.c(e.t.o.d.a, null, 1, null).d(71), 0);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoinActivity$flowOfAppBar$2(CoinActivity coinActivity) {
        super(1);
        this.this$0 = coinActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(ImageAttrs imageAttrs) {
        invoke2(imageAttrs);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@k.e.a.d ImageAttrs imageAttrs) {
        d.a aVar = e.t.o.d.a;
        imageAttrs.D(d.a.c(aVar, null, 1, null).d(40));
        imageAttrs.v(d.a.c(aVar, null, 1, null).d(30));
        imageAttrs.y(d.a.c(aVar, null, 1, null).d(24));
        imageAttrs.x(R.drawable.svg_more);
        imageAttrs.t(R.drawable.bg_back_icon);
        imageAttrs.g(new AnonymousClass1(this.this$0));
    }
}
