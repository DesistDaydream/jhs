package com.jihuanshe.viewmodel.search.globals;

import com.jihuanshe.model.SearchUser;
import h.k2.u.l;
import h.t1;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SearchUserViewModel$handleFollow$1 extends Lambda implements l<t1, t1> {
    public final /* synthetic */ SearchUser $user;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchUserViewModel$handleFollow$1(SearchUser searchUser) {
        super(1);
        this.$user = searchUser;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(t1 t1Var) {
        invoke2(t1Var);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e t1 t1Var) {
        this.$user.setFollowed(true);
    }
}
