package com.jihuanshe.ui.page.search.fragments.global;

import com.vector.design.ui.adapter.pager.FragPagerAdapter;
import h.k2.u.a;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class GlobalSearchProductFragment$adapter$2 extends Lambda implements a<FragPagerAdapter> {
    public final /* synthetic */ GlobalSearchProductFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GlobalSearchProductFragment$adapter$2(GlobalSearchProductFragment globalSearchProductFragment) {
        super(0);
        this.this$0 = globalSearchProductFragment;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @d
    public final FragPagerAdapter invoke() {
        return new FragPagerAdapter(this.this$0);
    }
}
