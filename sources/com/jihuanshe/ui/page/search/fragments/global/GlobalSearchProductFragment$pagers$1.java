package com.jihuanshe.ui.page.search.fragments.global;

import com.jihuanshe.model.Constants;
import h.k2.u.l;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class GlobalSearchProductFragment$pagers$1 extends Lambda implements l<Integer, SearchProductFragment> {
    public static final GlobalSearchProductFragment$pagers$1 INSTANCE = new GlobalSearchProductFragment$pagers$1();

    public GlobalSearchProductFragment$pagers$1() {
        super(1);
    }

    public final SearchProductFragment invoke(int i2) {
        return SearchProductFragmentCreator.create(Constants.Companion.getSEARCH_TYPE_CARD(), 0).get();
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ SearchProductFragment invoke(Integer num) {
        return invoke(num.intValue());
    }
}
