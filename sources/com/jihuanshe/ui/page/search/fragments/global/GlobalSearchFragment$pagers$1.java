package com.jihuanshe.ui.page.search.fragments.global;

import com.jihuanshe.ui.BaseFragment;
import e.l.h.l.b;
import h.k2.u.l;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class GlobalSearchFragment$pagers$1 extends Lambda implements l<Integer, BaseFragment<? extends b>> {
    public static final GlobalSearchFragment$pagers$1 INSTANCE = new GlobalSearchFragment$pagers$1();

    public GlobalSearchFragment$pagers$1() {
        super(1);
    }

    public final BaseFragment<? extends b> invoke(int i2) {
        return GlobalSearchProductFragmentCreator.create().get();
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ BaseFragment<? extends b> invoke(Integer num) {
        return invoke(num.intValue());
    }
}
