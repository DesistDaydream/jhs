package com.jihuanshe.ui.page.im;

import androidx.fragment.app.FragmentActivity;
import com.vector.design.ui.adapter.pager.FragPagerAdapter;
import h.k2.u.a;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class InteractMessageActivity$adapter$2 extends Lambda implements a<FragPagerAdapter> {
    public final /* synthetic */ InteractMessageActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InteractMessageActivity$adapter$2(InteractMessageActivity interactMessageActivity) {
        super(0);
        this.this$0 = interactMessageActivity;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @d
    public final FragPagerAdapter invoke() {
        return new FragPagerAdapter((FragmentActivity) this.this$0);
    }
}
