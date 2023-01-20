package com.jihuanshe.ui.page.entrepot;

import android.view.View;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class StorehouseActivity$applyForOnClick$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ StorehouseActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StorehouseActivity$applyForOnClick$1(StorehouseActivity storehouseActivity) {
        super(1);
        this.this$0 = storehouseActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        ApplyForActivityCreator.create().start(this.this$0);
    }
}
