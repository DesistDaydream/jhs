package com.jihuanshe.ui.page.user.selling;

import com.jihuanshe.ui.page.search.DefaultSearchHistoryViewImpl;
import e.l.s.m.b;
import h.k2.u.a;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellingFragment$searchHistoryViewImpl$2 extends Lambda implements a<DefaultSearchHistoryViewImpl> {
    public final /* synthetic */ SellingFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellingFragment$searchHistoryViewImpl$2(SellingFragment sellingFragment) {
        super(0);
        this.this$0 = sellingFragment;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @d
    public final DefaultSearchHistoryViewImpl invoke() {
        return new DefaultSearchHistoryViewImpl(this.this$0.requireActivity(), (b) this.this$0.T());
    }
}
