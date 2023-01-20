package com.jihuanshe.ui.page.detail;

import android.view.View;
import com.jihuanshe.mmkv.UserKV;
import com.jihuanshe.ui.page.exam.EtiquetteExamActivityCreator;
import h.k2.u.a;
import h.t1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ReviewListActivity$initObserver$5$1 extends Lambda implements a<t1> {
    public final /* synthetic */ View $v;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReviewListActivity$initObserver$5$1(View view) {
        super(0);
        this.$v = view;
    }

    @Override // h.k2.u.a
    public /* bridge */ /* synthetic */ t1 invoke() {
        invoke2();
        return t1.a;
    }

    @Override // h.k2.u.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        if (UserKV.f3913c.s()) {
            return;
        }
        EtiquetteExamActivityCreator.create().start(e.t.a.b());
        this.$v.clearFocus();
    }
}
