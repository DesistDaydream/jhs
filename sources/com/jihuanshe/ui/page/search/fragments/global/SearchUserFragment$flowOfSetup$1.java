package com.jihuanshe.ui.page.search.fragments.global;

import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.viewmodel.search.globals.SearchUserViewModel;
import e.l.s.m.c;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SearchUserFragment$flowOfSetup$1 extends Lambda implements l<String, t1> {
    public final /* synthetic */ SearchUserFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchUserFragment$flowOfSetup$1(SearchUserFragment searchUserFragment) {
        super(1);
        this.this$0 = searchUserFragment;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(String str) {
        invoke2(str);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d String str) {
        c m0;
        ((SearchUserViewModel) this.this$0.T()).q0().r(CollectionsKt__CollectionsKt.E());
        SearchUserViewModel searchUserViewModel = (SearchUserViewModel) this.this$0.T();
        m0 = this.this$0.m0();
        String value = m0.s0().getValue();
        if (value == null) {
            value = "";
        }
        BinderKt.t(SearchUserViewModel.t0(searchUserViewModel, value, null, 2, null), this.this$0, false, 2, null);
    }
}
