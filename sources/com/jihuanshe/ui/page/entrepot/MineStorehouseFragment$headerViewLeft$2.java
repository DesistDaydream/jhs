package com.jihuanshe.ui.page.entrepot;

import android.view.View;
import com.jihuanshe.viewmodel.entrepot.MineStorehouseViewModel;
import e.l.k.cg;
import h.k2.u.a;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class MineStorehouseFragment$headerViewLeft$2 extends Lambda implements a<View> {
    public final /* synthetic */ MineStorehouseFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MineStorehouseFragment$headerViewLeft$2(MineStorehouseFragment mineStorehouseFragment) {
        super(0);
        this.this$0 = mineStorehouseFragment;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @d
    public final View invoke() {
        cg e2 = cg.e(this.this$0.getLayoutInflater());
        e2.setLifecycleOwner(this.this$0);
        e2.i(this.this$0);
        e2.j((MineStorehouseViewModel) this.this$0.T());
        return e2.getRoot();
    }
}
