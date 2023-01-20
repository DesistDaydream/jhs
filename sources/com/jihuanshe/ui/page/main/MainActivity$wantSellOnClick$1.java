package com.jihuanshe.ui.page.main;

import android.view.View;
import com.jihuanshe.model.Game;
import com.jihuanshe.ui.dialog.HomeWantSellDialog;
import com.jihuanshe.ui.page.user.selling.SellingActivityCreator;
import com.jihuanshe.ui.widget.GameBar;
import h.k2.u.a;
import h.k2.u.l;
import h.k2.v.f0;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class MainActivity$wantSellOnClick$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ MainActivity this$0;

    /* renamed from: com.jihuanshe.ui.page.main.MainActivity$wantSellOnClick$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements a<t1> {
        public final /* synthetic */ MainActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(MainActivity mainActivity) {
            super(0);
            this.this$0 = mainActivity;
        }

        @Override // h.k2.u.a
        public /* bridge */ /* synthetic */ t1 invoke() {
            invoke2();
            return t1.a;
        }

        @Override // h.k2.u.a
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Game value = GameBar.b.a().getValue();
            if (value == null ? false : f0.g(value.getWarehouse(), 1)) {
                new HomeWantSellDialog(this.this$0, Integer.valueOf(HomeWantSellDialog.y.b()), null, 4, null).y();
            } else {
                SellingActivityCreator.create().start(this.this$0);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainActivity$wantSellOnClick$1(MainActivity mainActivity) {
        super(1);
        this.this$0 = mainActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        e.l.l.a.d(new AnonymousClass1(this.this$0));
    }
}
