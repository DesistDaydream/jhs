package com.jihuanshe.ui.page.user;

import android.view.View;
import android.widget.ImageView;
import androidx.core.view.GravityCompat;
import com.jihuanshe.R;
import com.jihuanshe.model.WantBuyList;
import com.jihuanshe.ui.dialog.UseDialog;
import com.jihuanshe.ui.widget.WantBuyPopupWindow;
import com.vector.util.Res;
import e.t.o.d;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class WantBuyActivity$edit$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ WantBuyList $a;
    public final /* synthetic */ ImageView $iv;
    public final /* synthetic */ WantBuyActivity this$0;

    /* renamed from: com.jihuanshe.ui.page.user.WantBuyActivity$edit$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements l<Integer, t1> {
        public final /* synthetic */ WantBuyList $a;
        public final /* synthetic */ WantBuyActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(WantBuyActivity wantBuyActivity, WantBuyList wantBuyList) {
            super(1);
            this.this$0 = wantBuyActivity;
            this.$a = wantBuyList;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(Integer num) {
            invoke(num.intValue());
            return t1.a;
        }

        public final void invoke(int i2) {
            if (i2 == 1) {
                this.this$0.n0(this.$a);
            } else if (i2 != 2) {
                this.this$0.p0(this.$a);
            } else {
                UseDialog useDialog = new UseDialog(this.this$0);
                WantBuyActivity wantBuyActivity = this.this$0;
                WantBuyList wantBuyList = this.$a;
                useDialog.setContent(Res.w(Res.a, R.string.buy_tip_title_del, null, 2, null));
                useDialog.setOnClickRightButton(new WantBuyActivity$edit$1$1$1$1(wantBuyActivity, wantBuyList));
                useDialog.y();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WantBuyActivity$edit$1(WantBuyActivity wantBuyActivity, ImageView imageView, WantBuyList wantBuyList) {
        super(1);
        this.this$0 = wantBuyActivity;
        this.$iv = imageView;
        this.$a = wantBuyList;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        WantBuyActivity wantBuyActivity = this.this$0;
        WantBuyActivity wantBuyActivity2 = this.this$0;
        wantBuyActivity.r0(new WantBuyPopupWindow(wantBuyActivity2, new AnonymousClass1(wantBuyActivity2, this.$a)));
        this.this$0.m0().showAsDropDown(this.$iv, -d.a.c(e.t.o.d.a, null, 1, null).d(98), 0, GravityCompat.START);
    }
}
