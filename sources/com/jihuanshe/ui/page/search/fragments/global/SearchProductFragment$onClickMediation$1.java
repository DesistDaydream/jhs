package com.jihuanshe.ui.page.search.fragments.global;

import android.view.View;
import com.jihuanshe.ui.dialog.MediationDialog;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SearchProductFragment$onClickMediation$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ SearchProductFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchProductFragment$onClickMediation$1(SearchProductFragment searchProductFragment) {
        super(1);
        this.this$0 = searchProductFragment;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        MediationDialog mediationDialog = new MediationDialog();
        mediationDialog.E(new SearchProductFragment$onClickMediation$1$1$1(this.this$0));
        mediationDialog.show(this.this$0.getChildFragmentManager(), "mediation");
    }
}
