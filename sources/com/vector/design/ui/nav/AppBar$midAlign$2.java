package com.vector.design.ui.nav;

import android.content.Context;
import h.k2.u.a;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/vector/design/ui/nav/MidAlignLayout;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class AppBar$midAlign$2 extends Lambda implements a<MidAlignLayout> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ AppBar this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppBar$midAlign$2(Context context, AppBar appBar) {
        super(0);
        this.$context = context;
        this.this$0 = appBar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @d
    public final MidAlignLayout invoke() {
        MidAlignLayout midAlignLayout = new MidAlignLayout(this.$context, null, 0, 6, null);
        this.this$0.addView(midAlignLayout, midAlignLayout.j());
        return midAlignLayout;
    }
}
