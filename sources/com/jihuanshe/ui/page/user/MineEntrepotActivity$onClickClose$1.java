package com.jihuanshe.ui.page.user;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.jihuanshe.viewmodel.user.MineEntrepotViewModel;
import com.vector.ext.view.ViewKt;
import e.l.m.b;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class MineEntrepotActivity$onClickClose$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ ConstraintLayout $v;
    public final /* synthetic */ MineEntrepotActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MineEntrepotActivity$onClickClose$1(ConstraintLayout constraintLayout, MineEntrepotActivity mineEntrepotActivity) {
        super(1);
        this.$v = constraintLayout;
        this.this$0 = mineEntrepotActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        ViewKt.n(this.$v);
        b.f14084c.F();
        ((MineEntrepotViewModel) this.this$0.L()).p0().setValue(0);
    }
}
