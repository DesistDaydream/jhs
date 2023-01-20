package com.jihuanshe.ui.page.user;

import android.view.View;
import com.jihuanshe.R;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.ui.dialog.UseDialog;
import com.jihuanshe.viewmodel.user.SellerDetailViewModel;
import com.vector.util.Res;
import h.k2.u.a;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellerDetailActivity$onClickFollow$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ SellerDetailActivity this$0;

    /* renamed from: com.jihuanshe.ui.page.user.SellerDetailActivity$onClickFollow$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements a<t1> {
        public final /* synthetic */ SellerDetailActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(SellerDetailActivity sellerDetailActivity) {
            super(0);
            this.this$0 = sellerDetailActivity;
        }

        @Override // h.k2.u.a
        public /* bridge */ /* synthetic */ t1 invoke() {
            invoke2();
            return t1.a;
        }

        @Override // h.k2.u.a
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (!((SellerDetailViewModel) this.this$0.L()).I0().u()) {
                UseDialog useDialog = new UseDialog(this.this$0);
                SellerDetailActivity sellerDetailActivity = this.this$0;
                useDialog.setContent(Res.w(Res.a, R.string.common_unfollow_confirm, null, 2, null));
                useDialog.setOnClickRightButton(new SellerDetailActivity$onClickFollow$1$1$1$1(sellerDetailActivity));
                useDialog.y();
                return;
            }
            BinderKt.p(BinderKt.k(((SellerDetailViewModel) this.this$0.L()).a1(this.this$0.Z0()), this.this$0, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellerDetailActivity$onClickFollow$1(SellerDetailActivity sellerDetailActivity) {
        super(1);
        this.this$0 = sellerDetailActivity;
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
