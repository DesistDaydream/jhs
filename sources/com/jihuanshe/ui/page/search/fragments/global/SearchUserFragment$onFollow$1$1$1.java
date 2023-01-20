package com.jihuanshe.ui.page.search.fragments.global;

import com.jihuanshe.model.SearchUser;
import h.k2.u.a;
import h.t1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SearchUserFragment$onFollow$1$1$1 extends Lambda implements a<t1> {
    public final /* synthetic */ SearchUser $user;
    public final /* synthetic */ SearchUserFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchUserFragment$onFollow$1$1$1(SearchUserFragment searchUserFragment, SearchUser searchUser) {
        super(0);
        this.this$0 = searchUserFragment;
        this.$user = searchUser;
    }

    @Override // h.k2.u.a
    public /* bridge */ /* synthetic */ t1 invoke() {
        invoke2();
        return t1.a;
    }

    @Override // h.k2.u.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.this$0.o0(this.$user);
    }
}
