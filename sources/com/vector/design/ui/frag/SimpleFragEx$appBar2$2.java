package com.vector.design.ui.frag;

import com.vector.design.ui.decor.DecorView;
import com.vector.design.ui.nav.AppBar2;
import com.vector.ext.AnyKt;
import h.k2.u.a;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/vector/design/ui/nav/AppBar2;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class SimpleFragEx$appBar2$2 extends Lambda implements a<AppBar2> {
    public final /* synthetic */ SimpleFragEx this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleFragEx$appBar2$2(SimpleFragEx simpleFragEx) {
        super(0);
        this.this$0 = simpleFragEx;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @d
    public final AppBar2 invoke() {
        DecorView decorView;
        decorView = this.this$0.b;
        return (AppBar2) AnyKt.I(decorView == null ? null : decorView.getAppBar2$vector_release(), "decorView can not be null");
    }
}
