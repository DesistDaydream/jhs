package com.jihuanshe.ui.page.search.fragments.global;

import com.jihuanshe.model.SearchUser;
import com.jihuanshe.viewmodel.search.globals.SearchUserViewModel;
import h.k2.u.l;
import h.t1;
import java.util.List;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SearchUserFragment$requestFollow$1 extends Lambda implements l<t1, t1> {
    public final /* synthetic */ SearchUser $user;
    public final /* synthetic */ SearchUserFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchUserFragment$requestFollow$1(SearchUserFragment searchUserFragment, SearchUser searchUser) {
        super(1);
        this.this$0 = searchUserFragment;
        this.$user = searchUser;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(t1 t1Var) {
        invoke2(t1Var);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e t1 t1Var) {
        List<SearchUser> value = ((SearchUserViewModel) this.this$0.T()).q0().getValue();
        Integer valueOf = value == null ? null : Integer.valueOf(value.indexOf(this.$user));
        if (valueOf != null) {
            this.this$0.g0().notifyItemChanged(valueOf.intValue());
        } else {
            this.this$0.g0().notifyDataSetChanged();
        }
    }
}
