package com.jihuanshe.ui.page.user;

import com.jihuanshe.R;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.WantBuyList;
import com.jihuanshe.ui.dialog.UseDialog;
import com.jihuanshe.viewmodel.user.WantBuyViewModel;
import com.vector.util.Res;
import e.g.d.a;
import h.k2.u.l;
import h.k2.u.p;
import h.t1;
import k.e.a.d;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class WantBuyActivity$reSetName$1 extends Lambda implements p<String, Boolean, t1> {
    public final /* synthetic */ WantBuyList $item;
    public final /* synthetic */ WantBuyActivity this$0;

    /* renamed from: com.jihuanshe.ui.page.user.WantBuyActivity$reSetName$1$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass2 extends Lambda implements l<t1, t1> {
        public final /* synthetic */ WantBuyList $item;
        public final /* synthetic */ String $n;
        public final /* synthetic */ WantBuyActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(WantBuyList wantBuyList, String str, WantBuyActivity wantBuyActivity) {
            super(1);
            this.$item = wantBuyList;
            this.$n = str;
            this.this$0 = wantBuyActivity;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(t1 t1Var) {
            invoke2(t1Var);
            return t1.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@e t1 t1Var) {
            this.$item.setName(this.$n);
            ((WantBuyViewModel) this.this$0.L()).r0().n();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WantBuyActivity$reSetName$1(WantBuyActivity wantBuyActivity, WantBuyList wantBuyList) {
        super(2);
        this.this$0 = wantBuyActivity;
        this.$item = wantBuyList;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(String str, Boolean bool) {
        invoke(str, bool.booleanValue());
        return t1.a;
    }

    public final void invoke(@d String str, boolean z) {
        if (z) {
            UseDialog useDialog = new UseDialog(this.this$0);
            WantBuyActivity wantBuyActivity = this.this$0;
            WantBuyList wantBuyList = this.$item;
            useDialog.setContent(Res.w(Res.a, R.string.buy_tip_title_del, null, 2, null));
            useDialog.setOnClickRightButton(new WantBuyActivity$reSetName$1$1$1(wantBuyActivity, wantBuyList));
            useDialog.y();
            return;
        }
        if (str.length() == 0) {
            return;
        }
        BinderKt.p(BinderKt.k(a.j(((WantBuyViewModel) this.this$0.L()).v0(this.$item.getId(), str), null, new AnonymousClass2(this.$item, str, this.this$0), 1, null), this.this$0, false, 2, null));
    }
}
