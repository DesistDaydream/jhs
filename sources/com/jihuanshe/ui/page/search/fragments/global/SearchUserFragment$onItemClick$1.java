package com.jihuanshe.ui.page.search.fragments.global;

import android.view.View;
import com.jihuanshe.model.SearchUser;
import com.jihuanshe.ui.page.user.SellerDetailActivityCreator;
import com.jihuanshe.viewmodel.search.globals.SearchUserViewModel;
import h.k2.u.p;
import h.t1;
import java.util.List;
import k.e.a.e;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SearchUserFragment$onItemClick$1 extends Lambda implements p<View, Integer, t1> {
    public final /* synthetic */ SearchUserFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchUserFragment$onItemClick$1(SearchUserFragment searchUserFragment) {
        super(2);
        this.this$0 = searchUserFragment;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(View view, Integer num) {
        invoke(view, num.intValue());
        return t1.a;
    }

    public final void invoke(@e View view, int i2) {
        List<SearchUser> value = ((SearchUserViewModel) this.this$0.T()).q0().getValue();
        SearchUser searchUser = value == null ? null : (SearchUser) CollectionsKt___CollectionsKt.J2(value, i2);
        if (searchUser == null) {
            return;
        }
        SellerDetailActivityCreator.create(searchUser.getId(), 0).start(this.this$0.getActivity());
    }
}
