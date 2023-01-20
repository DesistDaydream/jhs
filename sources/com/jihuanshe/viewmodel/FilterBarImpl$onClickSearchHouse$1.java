package com.jihuanshe.viewmodel;

import android.view.View;
import com.jihuanshe.model.Constants;
import com.jihuanshe.ui.page.search.SearchActivityCreator;
import e.t.a;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class FilterBarImpl$onClickSearchHouse$1 extends Lambda implements l<View, t1> {
    public static final FilterBarImpl$onClickSearchHouse$1 INSTANCE = new FilterBarImpl$onClickSearchHouse$1();

    public FilterBarImpl$onClickSearchHouse$1() {
        super(1);
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        SearchActivityCreator.create(3).uid(Integer.valueOf(Constants.Companion.getWAREHOUSE_SELLER_USER_ID())).start(a.b());
    }
}
