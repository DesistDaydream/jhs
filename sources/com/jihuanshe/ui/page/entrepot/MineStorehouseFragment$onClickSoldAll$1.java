package com.jihuanshe.ui.page.entrepot;

import android.view.View;
import com.jihuanshe.R;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.viewmodel.entrepot.MineStorehouseViewModel;
import com.vector.util.Res;
import e.g.d.a;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class MineStorehouseFragment$onClickSoldAll$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ MineStorehouseFragment this$0;

    /* renamed from: com.jihuanshe.ui.page.entrepot.MineStorehouseFragment$onClickSoldAll$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements l<t1, t1> {
        public final /* synthetic */ MineStorehouseFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(MineStorehouseFragment mineStorehouseFragment) {
            super(1);
            this.this$0 = mineStorehouseFragment;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(t1 t1Var) {
            invoke2(t1Var);
            return t1.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@e t1 t1Var) {
            this.this$0.M();
            e.l.h.j.b.e.d(this.this$0, Res.w(Res.a, R.string.common_complete, null, 2, null), (r13 & 2) != 0 ? null : null, (r13 & 4) != 0 ? null : null, (r13 & 8) != 0 ? null : null, (r13 & 16) != 0 ? 1 : 0, (r13 & 32) == 0 ? null : null);
        }
    }

    /* renamed from: com.jihuanshe.ui.page.entrepot.MineStorehouseFragment$onClickSoldAll$1$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass2 extends Lambda implements l<t1, t1> {
        public final /* synthetic */ MineStorehouseFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(MineStorehouseFragment mineStorehouseFragment) {
            super(1);
            this.this$0 = mineStorehouseFragment;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(t1 t1Var) {
            invoke2(t1Var);
            return t1.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@e t1 t1Var) {
            this.this$0.M();
            e.l.h.j.b.e.d(this.this$0, Res.w(Res.a, R.string.common_complete, null, 2, null), (r13 & 2) != 0 ? null : null, (r13 & 4) != 0 ? null : null, (r13 & 8) != 0 ? null : null, (r13 & 16) != 0 ? 1 : 0, (r13 & 32) == 0 ? null : null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MineStorehouseFragment$onClickSoldAll$1(MineStorehouseFragment mineStorehouseFragment) {
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
        Integer value = ((MineStorehouseViewModel) this.this$0.T()).F0().getValue();
        if (value != null && value.intValue() == 1) {
            BinderKt.j(BinderKt.p(a.j(((MineStorehouseViewModel) this.this$0.T()).J0(), null, new AnonymousClass1(this.this$0), 1, null)), this.this$0, false, 2, null);
        } else {
            BinderKt.j(BinderKt.p(a.j(((MineStorehouseViewModel) this.this$0.T()).L0(), null, new AnonymousClass2(this.this$0), 1, null)), this.this$0, false, 2, null);
        }
    }
}
