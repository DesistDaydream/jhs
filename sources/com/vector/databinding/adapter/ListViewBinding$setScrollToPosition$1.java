package com.vector.databinding.adapter;

import com.vector.view.scrollable.ListView;
import h.k2.u.p;
import h.t1;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n"}, d2 = {"<anonymous>", "", "position", "", "smoothScroll", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ListViewBinding$setScrollToPosition$1 extends Lambda implements p<Integer, Boolean, t1> {
    public final /* synthetic */ ListView $view;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ListViewBinding$setScrollToPosition$1(ListView listView) {
        super(2);
        this.$view = listView;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(Integer num, Boolean bool) {
        invoke(num.intValue(), bool);
        return t1.a;
    }

    public final void invoke(int i2, @e Boolean bool) {
        if (bool == null ? this.$view.getSmoothScroll() : bool.booleanValue()) {
            this.$view.getScrollable().smoothScrollToPosition(i2);
        } else {
            this.$view.Q(i2, Boolean.FALSE);
        }
    }
}
