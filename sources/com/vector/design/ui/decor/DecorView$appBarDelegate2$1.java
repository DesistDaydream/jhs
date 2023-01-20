package com.vector.design.ui.decor;

import android.content.Context;
import com.vector.R;
import com.vector.design.ui.nav.AppBar2;
import e.t.l.k;
import e.t.u.p;
import h.k2.u.a;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/vector/design/ui/nav/AppBar2;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class DecorView$appBarDelegate2$1 extends Lambda implements a<AppBar2> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ DecorView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DecorView$appBarDelegate2$1(Context context, DecorView decorView) {
        super(0);
        this.$context = context;
        this.this$0 = decorView;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @d
    public final AppBar2 invoke() {
        boolean f2;
        AppBar2 appBar2 = new AppBar2(k.d(this.$context, null, 1, null), null, 0, 6, null);
        DecorView decorView = this.this$0;
        appBar2.setId(R.id.app_bar);
        f2 = decorView.f();
        if (!f2) {
            decorView.d(decorView.getContentView$vector_release(), appBar2.getId());
            decorView.d(decorView.getLoadingView$vector_release(), appBar2.getId());
            decorView.d(decorView.getErrorView$vector_release(), appBar2.getId());
        }
        this.this$0.addView(appBar2, p.p(-1, -2));
        return appBar2;
    }
}
