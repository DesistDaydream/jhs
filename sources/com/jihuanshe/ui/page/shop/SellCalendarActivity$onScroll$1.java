package com.jihuanshe.ui.page.shop;

import androidx.recyclerview.widget.RecyclerView;
import com.jihuanshe.model.Product;
import com.jihuanshe.viewmodel.shop.SellCalendarViewModel;
import com.vector.view.pager.ViewPager;
import e.t.l.s;
import h.k2.u.r;
import h.t1;
import java.util.List;
import k.e.a.e;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellCalendarActivity$onScroll$1 extends Lambda implements r<RecyclerView, Integer, Integer, Integer, t1> {
    public final /* synthetic */ SellCalendarActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellCalendarActivity$onScroll$1(SellCalendarActivity sellCalendarActivity) {
        super(4);
        this.this$0 = sellCalendarActivity;
    }

    @Override // h.k2.u.r
    public /* bridge */ /* synthetic */ t1 invoke(RecyclerView recyclerView, Integer num, Integer num2, Integer num3) {
        invoke(recyclerView, num.intValue(), num2.intValue(), num3.intValue());
        return t1.a;
    }

    public final void invoke(@e RecyclerView recyclerView, int i2, int i3, int i4) {
        RecyclerView.LayoutManager layoutManager;
        ViewPager o0;
        boolean z;
        ViewPager o02;
        Integer valueOf = (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null) ? null : Integer.valueOf(s.a(layoutManager));
        if (valueOf == null) {
            return;
        }
        int intValue = valueOf.intValue();
        List<Product> value = ((SellCalendarViewModel) this.this$0.L()).v0().getValue();
        Product product = value == null ? null : (Product) CollectionsKt___CollectionsKt.J2(value, intValue);
        if (product == null) {
            return;
        }
        o0 = this.this$0.o0();
        if (o0.getCurrentItem() != product.getGroupIndex()) {
            z = this.this$0.A;
            if (z) {
                o02 = this.this$0.o0();
                o02.setCurrentItem(product.getGroupIndex());
            }
        }
        ((SellCalendarViewModel) this.this$0.L()).r0(intValue);
        RecyclerView.LayoutManager layoutManager2 = recyclerView.getLayoutManager();
        Integer valueOf2 = layoutManager2 != null ? Integer.valueOf(s.b(layoutManager2)) : null;
        if (valueOf2 == null) {
            return;
        }
        ((SellCalendarViewModel) this.this$0.L()).r0(valueOf2.intValue());
    }
}
