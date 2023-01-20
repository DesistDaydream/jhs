package com.jihuanshe.ui.page.user;

import com.jihuanshe.adapter.BlackListAdapter;
import h.k2.u.a;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class BlackListActivity$adapter$2 extends Lambda implements a<BlackListAdapter> {
    public final /* synthetic */ BlackListActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BlackListActivity$adapter$2(BlackListActivity blackListActivity) {
        super(0);
        this.this$0 = blackListActivity;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @d
    public final BlackListAdapter invoke() {
        return new BlackListAdapter(this.this$0);
    }
}
