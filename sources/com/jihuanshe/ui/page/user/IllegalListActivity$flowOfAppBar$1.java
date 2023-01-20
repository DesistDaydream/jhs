package com.jihuanshe.ui.page.user;

import com.jihuanshe.R;
import com.vector.design.ui.nav.TextAttrs;
import com.vector.util.Res;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class IllegalListActivity$flowOfAppBar$1 extends Lambda implements l<TextAttrs, t1> {
    public static final IllegalListActivity$flowOfAppBar$1 INSTANCE = new IllegalListActivity$flowOfAppBar$1();

    public IllegalListActivity$flowOfAppBar$1() {
        super(1);
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(TextAttrs textAttrs) {
        invoke2(textAttrs);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d TextAttrs textAttrs) {
        textAttrs.J(Res.w(Res.a, R.string.me_illegal_record, null, 2, null));
    }
}
