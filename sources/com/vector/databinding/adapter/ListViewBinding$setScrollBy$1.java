package com.vector.databinding.adapter;

import com.vector.view.scrollable.ListView;
import h.k2.u.q;
import h.t1;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\n"}, d2 = {"<anonymous>", "", "x", "", "y", "smoothScroll", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ListViewBinding$setScrollBy$1 extends Lambda implements q<Integer, Integer, Boolean, t1> {
    public final /* synthetic */ ListView $view;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ListViewBinding$setScrollBy$1(ListView listView) {
        super(3);
        this.$view = listView;
    }

    @Override // h.k2.u.q
    public /* bridge */ /* synthetic */ t1 invoke(Integer num, Integer num2, Boolean bool) {
        invoke(num.intValue(), num2.intValue(), bool);
        return t1.a;
    }

    public final void invoke(int i2, int i3, @e Boolean bool) {
        if (bool == null ? this.$view.getSmoothScroll() : bool.booleanValue()) {
            this.$view.getScrollable().smoothScrollBy(i2, i3);
        } else {
            this.$view.getScrollable().scrollBy(i2, i3);
        }
    }
}
