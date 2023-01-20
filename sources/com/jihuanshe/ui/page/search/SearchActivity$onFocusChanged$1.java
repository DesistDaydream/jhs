package com.jihuanshe.ui.page.search;

import android.view.View;
import e.t.u.o;
import h.k2.u.p;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SearchActivity$onFocusChanged$1 extends Lambda implements p<View, Boolean, t1> {
    public final /* synthetic */ SearchActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchActivity$onFocusChanged$1(SearchActivity searchActivity) {
        super(2);
        this.this$0 = searchActivity;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(View view, Boolean bool) {
        invoke(view, bool.booleanValue());
        return t1.a;
    }

    public final void invoke(@d View view, boolean z) {
        if (z) {
            o.a.i(this.this$0.getWindow());
        }
    }
}
