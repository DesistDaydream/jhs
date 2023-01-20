package com.jihuanshe.viewmodel;

import com.jihuanshe.adapter.RarityAdapter;
import h.k2.u.a;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class FilterBarImpl$adapter$2 extends Lambda implements a<RarityAdapter> {
    public final /* synthetic */ FilterBarImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterBarImpl$adapter$2(FilterBarImpl filterBarImpl) {
        super(0);
        this.this$0 = filterBarImpl;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @d
    public final RarityAdapter invoke() {
        return new RarityAdapter(this.this$0, false, 2, null);
    }
}
