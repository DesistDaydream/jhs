package com.jihuanshe.ui.page.search.fragments.global;

import androidx.lifecycle.ViewModelProvider;
import e.l.s.m.c;
import h.k2.u.a;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class GlobalSearchFragment$parentViewModel$2 extends Lambda implements a<c> {
    public final /* synthetic */ GlobalSearchFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GlobalSearchFragment$parentViewModel$2(GlobalSearchFragment globalSearchFragment) {
        super(0);
        this.this$0 = globalSearchFragment;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @d
    public final c invoke() {
        return (c) new ViewModelProvider(this.this$0.requireActivity()).get(c.class);
    }
}
