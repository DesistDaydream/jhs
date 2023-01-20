package com.jihuanshe.ui.page.user;

import android.view.View;
import com.jihuanshe.viewmodel.user.CoinViewModel;
import e.l.k.uf;
import h.k2.u.a;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CoinActivity$header$2 extends Lambda implements a<View> {
    public final /* synthetic */ CoinActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoinActivity$header$2(CoinActivity coinActivity) {
        super(0);
        this.this$0 = coinActivity;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @d
    public final View invoke() {
        uf e2 = uf.e(this.this$0.getLayoutInflater());
        this.this$0.k0(e2.a);
        e2.i(this.this$0);
        e2.j((CoinViewModel) this.this$0.L());
        e2.setLifecycleOwner(this.this$0);
        return e2.getRoot();
    }
}
