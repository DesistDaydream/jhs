package com.jihuanshe.ui.page.search.fragments.cardrepo;

import androidx.lifecycle.ViewModelProvider;
import e.l.s.m.c;
import h.k2.u.a;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CardRepoSearchFragment$parentViewModel$2 extends Lambda implements a<c> {
    public final /* synthetic */ CardRepoSearchFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardRepoSearchFragment$parentViewModel$2(CardRepoSearchFragment cardRepoSearchFragment) {
        super(0);
        this.this$0 = cardRepoSearchFragment;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @d
    public final c invoke() {
        return (c) new ViewModelProvider(this.this$0.requireActivity()).get(c.class);
    }
}
