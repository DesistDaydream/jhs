package com.jihuanshe.ui.page.order;

import com.jihuanshe.R;
import com.vector.design.ui.nav.TextAttrs;
import e.l.j.a;
import h.k2.u.l;
import h.k2.v.f0;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class AddAddressActivity$flowOfAppBar$1 extends Lambda implements l<TextAttrs, t1> {
    public final /* synthetic */ AddAddressActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddAddressActivity$flowOfAppBar$1(AddAddressActivity addAddressActivity) {
        super(1);
        this.this$0 = addAddressActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(TextAttrs textAttrs) {
        invoke2(textAttrs);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d TextAttrs textAttrs) {
        textAttrs.K(Integer.valueOf(f0.g(this.this$0.b0(), a.f12237g) ? R.string.common_modify_address : R.string.common_new_address));
    }
}
