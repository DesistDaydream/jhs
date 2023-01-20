package com.jihuanshe.ui.page.common.card;

import android.view.View;
import com.jihuanshe.ui.page.web.CommonWebViewActivityCreator;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ConditionOpImpl$onClick$1 extends Lambda implements l<View, t1> {
    public static final ConditionOpImpl$onClick$1 INSTANCE = new ConditionOpImpl$onClick$1();

    public ConditionOpImpl$onClick$1() {
        super(1);
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        CommonWebViewActivityCreator.create("https://api.jihuanshe.com/api/market/articles?type=condition").start(view.getContext());
    }
}
