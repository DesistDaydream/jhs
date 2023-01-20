package com.jihuanshe.ui.page.search;

import e.t.o.d;
import h.k2.u.a;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SearchActivity$searchBarHeight$2 extends Lambda implements a<Integer> {
    public final /* synthetic */ SearchActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchActivity$searchBarHeight$2(SearchActivity searchActivity) {
        super(0);
        this.this$0 = searchActivity;
    }

    @Override // h.k2.u.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public /* bridge */ /* synthetic */ Integer invoke2() {
        return Integer.valueOf(invoke());
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [int, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int, java.lang.Integer] */
    @Override // h.k2.u.a
    public final Integer invoke() {
        if (this.this$0.getType() == 1) {
            return d.a.c(d.a, null, 1, null).d(108);
        }
        return d.a.c(d.a, null, 1, null).d(60);
    }
}
