package com.jihuanshe.ui.page.user;

import com.jihuanshe.model.WantBuyList;
import com.jihuanshe.ui.page.search.SearchActivityCreator;
import h.k2.u.a;
import h.t1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class WantCardListActivity$flowOfAppBar$2 extends Lambda implements a<t1> {
    public final /* synthetic */ WantCardListActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WantCardListActivity$flowOfAppBar$2(WantCardListActivity wantCardListActivity) {
        super(0);
        this.this$0 = wantCardListActivity;
    }

    @Override // h.k2.u.a
    public /* bridge */ /* synthetic */ t1 invoke() {
        invoke2();
        return t1.a;
    }

    @Override // h.k2.u.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        SearchActivityCreator create = SearchActivityCreator.create(11);
        WantBuyList f0 = this.this$0.f0();
        create.wid(f0 == null ? null : Integer.valueOf(f0.getId())).start(this.this$0);
    }
}
