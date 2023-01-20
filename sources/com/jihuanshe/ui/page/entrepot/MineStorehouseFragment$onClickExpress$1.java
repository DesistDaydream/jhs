package com.jihuanshe.ui.page.entrepot;

import android.view.View;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.CardConsignmentInfo;
import com.jihuanshe.model.ExpressData;
import com.jihuanshe.ui.dialog.ExpressDialog;
import com.jihuanshe.viewmodel.entrepot.MineStorehouseViewModel;
import e.g.d.a;
import h.k2.u.l;
import h.t1;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class MineStorehouseFragment$onClickExpress$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ MineStorehouseFragment this$0;

    /* renamed from: com.jihuanshe.ui.page.entrepot.MineStorehouseFragment$onClickExpress$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements l<List<? extends ExpressData>, t1> {
        public final /* synthetic */ CardConsignmentInfo $info;
        public final /* synthetic */ MineStorehouseFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(MineStorehouseFragment mineStorehouseFragment, CardConsignmentInfo cardConsignmentInfo) {
            super(1);
            this.this$0 = mineStorehouseFragment;
            this.$info = cardConsignmentInfo;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(List<? extends ExpressData> list) {
            invoke2((List<ExpressData>) list);
            return t1.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@e List<ExpressData> list) {
            new ExpressDialog(this.this$0.requireActivity(), this.$info, null, ((MineStorehouseViewModel) this.this$0.T()).x0().getValue()).y();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MineStorehouseFragment$onClickExpress$1(MineStorehouseFragment mineStorehouseFragment) {
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
        List<CardConsignmentInfo> value = ((MineStorehouseViewModel) this.this$0.T()).t0().getValue();
        if ((value == null ? null : (CardConsignmentInfo) CollectionsKt___CollectionsKt.J2(value, 0)) == null) {
            return;
        }
        List<CardConsignmentInfo> value2 = ((MineStorehouseViewModel) this.this$0.T()).t0().getValue();
        CardConsignmentInfo cardConsignmentInfo = value2 == null ? null : value2.get(0);
        BinderKt.j(a.j(((MineStorehouseViewModel) this.this$0.T()).w0(cardConsignmentInfo.getWarehouseOrderId()), null, new AnonymousClass1(this.this$0, cardConsignmentInfo), 1, null), this.this$0, false, 2, null);
    }
}
