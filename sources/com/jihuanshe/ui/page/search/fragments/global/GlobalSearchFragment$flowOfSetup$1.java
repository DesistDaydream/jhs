package com.jihuanshe.ui.page.search.fragments.global;

import com.jihuanshe.R;
import com.jihuanshe.model.SearchResultCount;
import com.vector.util.Res;
import e.n.f;
import h.k2.u.l;
import h.k2.v.f0;
import h.t1;
import java.util.List;
import k.e.a.d;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class GlobalSearchFragment$flowOfSetup$1 extends Lambda implements l<SearchResultCount, t1> {
    public final /* synthetic */ GlobalSearchFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GlobalSearchFragment$flowOfSetup$1(GlobalSearchFragment globalSearchFragment) {
        super(1);
        this.this$0 = globalSearchFragment;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(SearchResultCount searchResultCount) {
        invoke2(searchResultCount);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d SearchResultCount searchResultCount) {
        CharSequence h0;
        Long userCount = searchResultCount.getUserCount();
        if (userCount == null) {
            return;
        }
        userCount.longValue();
        f<List<CharSequence>> m0 = this.this$0.m0();
        Res res = Res.a;
        h0 = this.this$0.h0(f0.C(Res.w(res, R.string.common_tab_user, null, 2, null), searchResultCount.getUserCount()));
        m0.r(CollectionsKt__CollectionsKt.P(Res.w(res, R.string.common_tab_product, null, 2, null), h0));
    }
}
