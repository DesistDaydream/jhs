package com.jihuanshe.ui.page.entrepot;

import android.view.View;
import com.jihuanshe.ui.page.search.SearchActivityCreator;
import h.k2.u.l;
import h.k2.v.f0;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class MineStorehouseFragment$onClickSearch$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ MineStorehouseFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MineStorehouseFragment$onClickSearch$1(MineStorehouseFragment mineStorehouseFragment) {
        super(1);
        this.this$0 = mineStorehouseFragment;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        int i2;
        String k0 = this.this$0.k0();
        if (f0.g(k0, "FRAGMENT_CHECK")) {
            i2 = 4;
        } else {
            i2 = f0.g(k0, "FRAGMENT_HOUSE") ? 5 : 6;
        }
        SearchActivityCreator.create(Integer.valueOf(i2)).start(this.this$0.getContext());
    }
}
