package com.jihuanshe.viewmodel.entrepot;

import androidx.fragment.app.Fragment;
import com.jihuanshe.ui.page.entrepot.MineStorehouseFragmentCreator;
import h.k2.u.l;
import java.util.List;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class StorehouseViewModel$pagers$1 extends Lambda implements l<Integer, Fragment> {
    public final /* synthetic */ StorehouseViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StorehouseViewModel$pagers$1(StorehouseViewModel storehouseViewModel) {
        super(1);
        this.this$0 = storehouseViewModel;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ Fragment invoke(Integer num) {
        return invoke(num.intValue());
    }

    @d
    public final Fragment invoke(int i2) {
        List list;
        list = this.this$0.f4440c;
        return MineStorehouseFragmentCreator.create((String) list.get(i2)).get();
    }
}
