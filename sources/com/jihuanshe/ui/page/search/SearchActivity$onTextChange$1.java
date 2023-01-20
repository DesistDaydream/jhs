package com.jihuanshe.ui.page.search;

import e.l.s.m.c;
import h.k2.u.r;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SearchActivity$onTextChange$1 extends Lambda implements r<CharSequence, Integer, Integer, Integer, t1> {
    public final /* synthetic */ SearchActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchActivity$onTextChange$1(SearchActivity searchActivity) {
        super(4);
        this.this$0 = searchActivity;
    }

    @Override // h.k2.u.r
    public /* bridge */ /* synthetic */ t1 invoke(CharSequence charSequence, Integer num, Integer num2, Integer num3) {
        invoke(charSequence, num.intValue(), num2.intValue(), num3.intValue());
        return t1.a;
    }

    public final void invoke(@d CharSequence charSequence, int i2, int i3, int i4) {
        ((c) this.this$0.L()).q0().setValue(Boolean.valueOf(charSequence.toString().length() > 0));
        this.this$0.n0(false);
        if (charSequence.length() == 0) {
            ((c) this.this$0.L()).p0().setValue(Boolean.TRUE);
        }
    }
}
