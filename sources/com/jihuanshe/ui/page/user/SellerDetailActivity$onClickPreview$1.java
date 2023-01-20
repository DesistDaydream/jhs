package com.jihuanshe.ui.page.user;

import android.view.View;
import com.jihuanshe.model.User;
import com.jihuanshe.viewmodel.user.SellerDetailViewModel;
import com.vector.network.image.NImageView;
import e.l.q.b.h.k;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellerDetailActivity$onClickPreview$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ NImageView $image;
    public final /* synthetic */ SellerDetailActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellerDetailActivity$onClickPreview$1(SellerDetailActivity sellerDetailActivity, NImageView nImageView) {
        super(1);
        this.this$0 = sellerDetailActivity;
        this.$image = nImageView;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        SellerDetailActivity sellerDetailActivity = this.this$0;
        User value = ((SellerDetailViewModel) sellerDetailActivity.L()).X0().getValue();
        new k(sellerDetailActivity, value == null ? null : value.getAvatar(), this.$image).t();
    }
}
