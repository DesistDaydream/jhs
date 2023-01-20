package com.jihuanshe.adapter;

import android.view.View;
import com.jihuanshe.ui.page.user.SellerDetailActivityCreator;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ReplyListAdapter$onClickHead$1 extends Lambda implements l<View, t1> {
    public static final ReplyListAdapter$onClickHead$1 INSTANCE = new ReplyListAdapter$onClickHead$1();

    public ReplyListAdapter$onClickHead$1() {
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
        if (tag instanceof Integer) {
            SellerDetailActivityCreator.create(Integer.valueOf(((Number) tag).intValue()), null).start(view.getContext());
        }
    }
}
