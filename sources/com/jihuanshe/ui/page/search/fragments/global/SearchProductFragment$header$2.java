package com.jihuanshe.ui.page.search.fragments.global;

import android.view.View;
import com.jihuanshe.model.Constants;
import com.jihuanshe.viewmodel.search.globals.SearchProductViewModel;
import e.l.k.o8;
import h.k2.u.a;
import h.k2.v.f0;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SearchProductFragment$header$2 extends Lambda implements a<View> {
    public final /* synthetic */ SearchProductFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchProductFragment$header$2(SearchProductFragment searchProductFragment) {
        super(0);
        this.this$0 = searchProductFragment;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @e
    public final View invoke() {
        if (f0.g(this.this$0.getType(), Constants.Companion.getSEARCH_TYPE_CARD())) {
            o8 e2 = o8.e(this.this$0.getLayoutInflater());
            e2.setLifecycleOwner(this.this$0);
            e2.i(this.this$0);
            e2.j((SearchProductViewModel) this.this$0.T());
            return e2.getRoot();
        }
        return null;
    }
}
