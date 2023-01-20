package com.jihuanshe.ui.page.user.selling;

import android.view.View;
import com.jihuanshe.R;
import com.vector.util.Res;
import e.l.s.o.d.a;
import h.k2.u.p;
import h.t1;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellingFragment$onItemClick$1 extends Lambda implements p<View, Integer, t1> {
    public final /* synthetic */ SellingFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellingFragment$onItemClick$1(SellingFragment sellingFragment) {
        super(2);
        this.this$0 = sellingFragment;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(View view, Integer num) {
        invoke(view, num.intValue());
        return t1.a;
    }

    public final void invoke(@e View view, int i2) {
        String w;
        Boolean bool = Boolean.TRUE;
        ((a) this.this$0.T()).v0().setValue(this.this$0.u0().get(i2));
        e.n.p u0 = ((a) this.this$0.T()).u0();
        if (i2 == 0) {
            ((a) this.this$0.T()).w0().setValue(Boolean.FALSE);
            w = Res.w(Res.a, R.string.common_new_product, null, 2, null);
        } else {
            ((a) this.this$0.T()).w0().setValue(bool);
            w = Res.w(Res.a, R.string.common_price, null, 2, null);
        }
        u0.setValue(w);
        ((a) this.this$0.T()).x0().setValue(bool);
    }
}
