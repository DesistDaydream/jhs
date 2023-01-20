package com.xres.address_selector.widget.address_selector;

import h.k2.u.a;
import h.t1;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class AddressSelectorView2$initListener$2 extends Lambda implements a<t1> {
    public final /* synthetic */ AddressSelectorView2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddressSelectorView2$initListener$2(AddressSelectorView2 addressSelectorView2) {
        super(0);
        this.this$0 = addressSelectorView2;
    }

    @Override // h.k2.u.a
    public /* bridge */ /* synthetic */ t1 invoke() {
        invoke2();
        return t1.a;
    }

    @Override // h.k2.u.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        e.u.a.d.a.a aVar;
        String code;
        aVar = this.this$0.o;
        if (aVar == null || (code = aVar.getCode()) == null) {
            return;
        }
        this.this$0.F(code);
    }
}
