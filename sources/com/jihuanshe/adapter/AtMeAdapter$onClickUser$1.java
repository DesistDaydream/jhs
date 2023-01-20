package com.jihuanshe.adapter;

import android.view.View;
import com.jihuanshe.model.InteractData;
import com.jihuanshe.ui.page.user.SellerDetailActivityCreator;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class AtMeAdapter$onClickUser$1 extends Lambda implements l<View, t1> {
    public static final AtMeAdapter$onClickUser$1 INSTANCE = new AtMeAdapter$onClickUser$1();

    public AtMeAdapter$onClickUser$1() {
        super(1);
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        Object tag = view.getTag(view.getId());
        if (tag instanceof InteractData) {
            SellerDetailActivityCreator.create(((InteractData) tag).getFromUid(), null).start(view.getContext());
        }
    }
}
