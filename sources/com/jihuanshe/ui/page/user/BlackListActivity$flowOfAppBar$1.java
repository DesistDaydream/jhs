package com.jihuanshe.ui.page.user;

import com.jihuanshe.R;
import com.vector.design.ui.nav.TextAttrs;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class BlackListActivity$flowOfAppBar$1 extends Lambda implements l<TextAttrs, t1> {
    public static final BlackListActivity$flowOfAppBar$1 INSTANCE = new BlackListActivity$flowOfAppBar$1();

    public BlackListActivity$flowOfAppBar$1() {
        super(1);
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(TextAttrs textAttrs) {
        invoke2(textAttrs);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d TextAttrs textAttrs) {
        textAttrs.K(Integer.valueOf((int) R.string.common_my_black_list));
    }
}
