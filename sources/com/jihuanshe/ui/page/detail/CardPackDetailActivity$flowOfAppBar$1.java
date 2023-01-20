package com.jihuanshe.ui.page.detail;

import com.jihuanshe.R;
import com.vector.design.ui.nav.TextAttrs;
import com.vector.util.Res;
import com.vector.util.Screen;
import e.t.o.d;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CardPackDetailActivity$flowOfAppBar$1 extends Lambda implements l<TextAttrs, t1> {
    public static final CardPackDetailActivity$flowOfAppBar$1 INSTANCE = new CardPackDetailActivity$flowOfAppBar$1();

    public CardPackDetailActivity$flowOfAppBar$1() {
        super(1);
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(TextAttrs textAttrs) {
        invoke2(textAttrs);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d TextAttrs textAttrs) {
        textAttrs.F(Boolean.TRUE);
        textAttrs.H(Screen.a.l() - d.a.c(e.t.o.d.a, null, 1, null).d(96));
        textAttrs.J(Res.w(Res.a, R.string.card_pack_detail, null, 2, null));
    }
}
