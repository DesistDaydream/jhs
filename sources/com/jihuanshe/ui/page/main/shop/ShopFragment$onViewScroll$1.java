package com.jihuanshe.ui.page.main.shop;

import android.animation.ValueAnimator;
import androidx.recyclerview.widget.RecyclerView;
import e.t.l.s;
import h.k2.u.r;
import h.t1;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ShopFragment$onViewScroll$1 extends Lambda implements r<RecyclerView, Integer, Integer, Integer, t1> {
    public final /* synthetic */ ShopFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShopFragment$onViewScroll$1(ShopFragment shopFragment) {
        super(4);
        this.this$0 = shopFragment;
    }

    @Override // h.k2.u.r
    public /* bridge */ /* synthetic */ t1 invoke(RecyclerView recyclerView, Integer num, Integer num2, Integer num3) {
        invoke(recyclerView, num.intValue(), num2.intValue(), num3.intValue());
        return t1.a;
    }

    public final void invoke(@e RecyclerView recyclerView, int i2, int i3, int i4) {
        ValueAnimator valueAnimator;
        RecyclerView.LayoutManager layoutManager;
        valueAnimator = this.this$0.M;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            return;
        }
        Integer num = null;
        if (recyclerView != null && (layoutManager = recyclerView.getLayoutManager()) != null) {
            num = Integer.valueOf(s.a(layoutManager));
        }
        if ((num == null ? 0 : num.intValue()) > 1 && this.this$0.N0()) {
            ShopFragment shopFragment = this.this$0;
            shopFragment.Q0(0, -shopFragment.w0().getHeight(), 300L);
            return;
        }
        if ((num == null ? 0 : num.intValue()) > 1 || this.this$0.N0()) {
            return;
        }
        ShopFragment shopFragment2 = this.this$0;
        shopFragment2.Q0(-shopFragment2.w0().getHeight(), 0, 300L);
    }
}
