package com.jihuanshe.ui.page.im;

import com.jihuanshe.ui.BaseFragment;
import e.l.h.l.b;
import h.k2.u.l;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class InteractMessageActivity$pager$3 extends Lambda implements l<Integer, BaseFragment<? extends b>> {
    public static final InteractMessageActivity$pager$3 INSTANCE = new InteractMessageActivity$pager$3();

    public InteractMessageActivity$pager$3() {
        super(1);
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ BaseFragment<? extends b> invoke(Integer num) {
        return invoke(num.intValue());
    }

    public final BaseFragment<? extends b> invoke(int i2) {
        return LikeFragmentCreator.create().get();
    }
}
