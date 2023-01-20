package com.jihuanshe.ui.page.shop;

import com.jihuanshe.ui.page.search.SearchActivityCreator;
import h.k2.u.a;
import h.t1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class AddCardActivity$flowOfAppBar$2 extends Lambda implements a<t1> {
    public final /* synthetic */ AddCardActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddCardActivity$flowOfAppBar$2(AddCardActivity addCardActivity) {
        super(0);
        this.this$0 = addCardActivity;
    }

    @Override // h.k2.u.a
    public /* bridge */ /* synthetic */ t1 invoke() {
        invoke2();
        return t1.a;
    }

    @Override // h.k2.u.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        SearchActivityCreator.create(9).cardRepoType(Integer.valueOf(this.this$0.getType())).wid(Integer.valueOf(this.this$0.d0())).start(this.this$0);
    }
}
