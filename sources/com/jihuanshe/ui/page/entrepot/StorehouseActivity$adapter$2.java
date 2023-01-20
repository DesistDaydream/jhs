package com.jihuanshe.ui.page.entrepot;

import androidx.fragment.app.FragmentActivity;
import com.vector.design.ui.adapter.pager.FragPagerAdapter;
import h.k2.u.a;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class StorehouseActivity$adapter$2 extends Lambda implements a<FragPagerAdapter> {
    public final /* synthetic */ StorehouseActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StorehouseActivity$adapter$2(StorehouseActivity storehouseActivity) {
        super(0);
        this.this$0 = storehouseActivity;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @d
    public final FragPagerAdapter invoke() {
        return new FragPagerAdapter((FragmentActivity) this.this$0);
    }
}
