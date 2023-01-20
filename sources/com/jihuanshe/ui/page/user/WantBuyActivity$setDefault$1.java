package com.jihuanshe.ui.page.user;

import android.view.View;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.WantBuyList;
import com.jihuanshe.ui.dialog.WantBuyDialog;
import com.jihuanshe.viewmodel.user.WantBuyViewModel;
import e.g.d.a;
import h.k2.u.l;
import h.t1;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class WantBuyActivity$setDefault$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ WantBuyList $item;
    public final /* synthetic */ WantBuyActivity this$0;

    /* renamed from: com.jihuanshe.ui.page.user.WantBuyActivity$setDefault$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements l<t1, t1> {
        public final /* synthetic */ WantBuyList $item;
        public final /* synthetic */ WantBuyActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(WantBuyActivity wantBuyActivity, WantBuyList wantBuyList) {
            super(1);
            this.this$0 = wantBuyActivity;
            this.$item = wantBuyList;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(t1 t1Var) {
            invoke2(t1Var);
            return t1.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@e t1 t1Var) {
            List<WantBuyList> value = ((WantBuyViewModel) this.this$0.L()).r0().getValue();
            if (value != null) {
                for (WantBuyList wantBuyList : value) {
                    wantBuyList.setDef(Boolean.FALSE);
                }
            }
            this.$item.setDef(Boolean.TRUE);
            ((WantBuyViewModel) this.this$0.L()).r0().n();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WantBuyActivity$setDefault$1(WantBuyActivity wantBuyActivity, WantBuyList wantBuyList) {
        super(1);
        this.this$0 = wantBuyActivity;
        this.$item = wantBuyList;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        WantBuyDialog f0 = this.this$0.f0();
        if (f0 != null) {
            f0.h();
        }
        BinderKt.p(BinderKt.k(a.j(((WantBuyViewModel) this.this$0.L()).u0(this.$item.getId()), null, new AnonymousClass1(this.this$0, this.$item), 1, null), this.this$0, false, 2, null));
    }
}
