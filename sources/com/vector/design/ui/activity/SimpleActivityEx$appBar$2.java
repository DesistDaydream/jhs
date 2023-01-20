package com.vector.design.ui.activity;

import com.vector.design.ui.decor.DecorView;
import com.vector.design.ui.nav.AppBar;
import h.k2.u.a;
import java.util.Objects;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/vector/design/ui/nav/AppBar;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class SimpleActivityEx$appBar$2 extends Lambda implements a<AppBar> {
    public final /* synthetic */ SimpleActivityEx this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleActivityEx$appBar$2(SimpleActivityEx simpleActivityEx) {
        super(0);
        this.this$0 = simpleActivityEx;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @d
    public final AppBar invoke() {
        DecorView decorView;
        decorView = this.this$0.b;
        Objects.requireNonNull(decorView);
        return decorView.getAppBar$vector_release();
    }
}
