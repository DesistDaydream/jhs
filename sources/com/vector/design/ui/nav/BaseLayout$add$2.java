package com.vector.design.ui.nav;

import android.view.View;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/vector/design/ui/nav/ViewAttrs;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class BaseLayout$add$2 extends Lambda implements l<ViewAttrs, t1> {
    public final /* synthetic */ View $v;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseLayout$add$2(View view) {
        super(1);
        this.$v = view;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(ViewAttrs viewAttrs) {
        invoke2(viewAttrs);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d ViewAttrs viewAttrs) {
        viewAttrs.s(this.$v);
    }
}
