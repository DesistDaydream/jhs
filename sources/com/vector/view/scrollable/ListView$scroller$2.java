package com.vector.view.scrollable;

import android.content.Context;
import com.vector.view.scrollable.ListView;
import h.k2.u.a;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00060\u0001R\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/vector/view/scrollable/ListView$StartScroller;", "Lcom/vector/view/scrollable/ListView;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ListView$scroller$2 extends Lambda implements a<ListView.b> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ ListView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ListView$scroller$2(ListView listView, Context context) {
        super(0);
        this.this$0 = listView;
        this.$context = context;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @d
    public final ListView.b invoke() {
        return new ListView.b(this.$context);
    }
}
