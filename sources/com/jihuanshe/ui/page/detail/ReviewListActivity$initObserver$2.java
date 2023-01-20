package com.jihuanshe.ui.page.detail;

import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.Pair;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ReviewListActivity$initObserver$2 extends Lambda implements l<Pair<? extends String, ? extends String>, t1> {
    public final /* synthetic */ ReviewListActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReviewListActivity$initObserver$2(ReviewListActivity reviewListActivity) {
        super(1);
        this.this$0 = reviewListActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Pair<? extends String, ? extends String> pair) {
        invoke2((Pair<String, String>) pair);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d Pair<String, String> pair) {
        if (this.this$0.K0()) {
            this.this$0.c1(false);
        } else {
            this.this$0.F();
        }
    }
}
