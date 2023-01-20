package com.jihuanshe.ui.page.search.fragments.cardrepo;

import com.jihuanshe.model.GameCard;
import h.k2.u.l;
import h.t1;
import java.util.List;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CardRepoSearchFragment$flowOfSetup$4 extends Lambda implements l<List<? extends GameCard>, t1> {
    public final /* synthetic */ CardRepoSearchFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardRepoSearchFragment$flowOfSetup$4(CardRepoSearchFragment cardRepoSearchFragment) {
        super(1);
        this.this$0 = cardRepoSearchFragment;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(List<? extends GameCard> list) {
        invoke2(list);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d List<? extends GameCard> list) {
        this.this$0.I0(list);
    }
}
