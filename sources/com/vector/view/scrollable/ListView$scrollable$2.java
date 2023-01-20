package com.vector.view.scrollable;

import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import e.t.u.p;
import h.k2.u.a;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ListView$scrollable$2 extends Lambda implements a<RecyclerView> {
    public final /* synthetic */ ListView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ListView$scrollable$2(ListView listView) {
        super(0);
        this.this$0 = listView;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @d
    public final RecyclerView invoke() {
        RecyclerView recyclerView = this.this$0.getRecyclerView();
        recyclerView.setId(ViewCompat.generateViewId());
        this.this$0.addView(recyclerView, p.l(-1, -1));
        return recyclerView;
    }
}
