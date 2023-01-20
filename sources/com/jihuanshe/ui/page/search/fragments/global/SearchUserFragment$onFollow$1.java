package com.jihuanshe.ui.page.search.fragments.global;

import android.view.View;
import com.jihuanshe.R;
import com.jihuanshe.model.SearchUser;
import com.jihuanshe.ui.dialog.UseDialog;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SearchUserFragment$onFollow$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ SearchUser $user;
    public final /* synthetic */ SearchUserFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchUserFragment$onFollow$1(SearchUser searchUser, SearchUserFragment searchUserFragment) {
        super(1);
        this.$user = searchUser;
        this.this$0 = searchUserFragment;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        if (!this.$user.getFollowed()) {
            this.this$0.o0(this.$user);
            return;
        }
        UseDialog useDialog = new UseDialog(this.this$0.requireActivity());
        SearchUserFragment searchUserFragment = this.this$0;
        SearchUser searchUser = this.$user;
        useDialog.setContent(R.string.common_unfollow_confirm);
        useDialog.setOnClickRightButton(new SearchUserFragment$onFollow$1$1$1(searchUserFragment, searchUser));
        useDialog.y();
    }
}
