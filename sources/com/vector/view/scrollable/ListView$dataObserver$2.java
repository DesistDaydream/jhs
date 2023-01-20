package com.vector.view.scrollable;

import androidx.recyclerview.widget.RecyclerView;
import e.t.k.a.c.c;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0007\n\u0000\n\u0000*\u0001\u0001\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "com/vector/view/scrollable/ListView$dataObserver$2$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ListView$dataObserver$2 extends Lambda implements h.k2.u.a<a> {
    public final /* synthetic */ ListView this$0;

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\"\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\u000b"}, d2 = {"com/vector/view/scrollable/ListView$dataObserver$2$1", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class a extends RecyclerView.AdapterDataObserver {
        public final /* synthetic */ ListView a;

        public a(ListView listView) {
            this.a = listView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            this.a.b(false);
            c<?> adapter = this.a.getAdapter();
            if (adapter != null && adapter.k() == 0) {
                if (this.a.getEmptyFooterResId() != null) {
                    this.a.J(FooterState.GONE);
                    this.a.c(true);
                }
            } else {
                this.a.c(false);
            }
            if (this.a.getPreLoad()) {
                this.a.R = false;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i2, int i3, @e Object obj) {
            if (this.a.getPreLoad()) {
                this.a.R = false;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i2, int i3) {
            if (this.a.getPreLoad()) {
                this.a.R = false;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ListView$dataObserver$2(ListView listView) {
        super(0);
        this.this$0 = listView;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @d
    public final a invoke() {
        return new a(this.this$0);
    }
}
