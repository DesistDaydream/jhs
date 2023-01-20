package com.jihuanshe.ui.page.search.fragments.cardrepo;

import com.jihuanshe.ui.widget.RarityFilterBtn;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CardRepoSearchFragment$flowOfSetup$1 extends Lambda implements l<String, t1> {
    public final /* synthetic */ CardRepoSearchFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardRepoSearchFragment$flowOfSetup$1(CardRepoSearchFragment cardRepoSearchFragment) {
        super(1);
        this.this$0 = cardRepoSearchFragment;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(String str) {
        invoke2(str);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d String str) {
        RarityFilterBtn x0;
        x0 = this.this$0.x0();
        x0.g(true);
    }
}
