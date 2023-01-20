package com.vector.view.scrollable;

import androidx.recyclerview.widget.RecyclerView;
import com.vector.design.ui.delegate.LoadMore;
import com.vector.view.swipe.ScrollableExtend;
import e.t.l.s;
import java.util.List;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0007\n\u0000\n\u0000*\u0001\u0001\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "com/vector/view/scrollable/ListView$innerScrollListener$2$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ListView$innerScrollListener$2 extends Lambda implements h.k2.u.a<a> {
    public final /* synthetic */ ListView this$0;

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0016¨\u0006\u000b"}, d2 = {"com/vector/view/scrollable/ListView$innerScrollListener$2$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "rv", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class a extends RecyclerView.OnScrollListener {
        public final /* synthetic */ ListView a;

        public a(ListView listView) {
            this.a = listView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@d RecyclerView recyclerView, int i2) {
            List<e.t.k.a.e.a> list;
            LoadMore.b bVar;
            boolean z;
            RecyclerView.LayoutManager layoutManager;
            list = this.a.b0;
            if (list != null) {
                for (e.t.k.a.e.a aVar : list) {
                    aVar.onScrollStateChanged(recyclerView, i2);
                }
            }
            if (this.a.getPreLoad()) {
                return;
            }
            bVar = this.a.W;
            if (bVar != null && i2 == 0 && this.a.getLoadMoreFooter().getState() == ScrollableExtend.State.LOADING) {
                z = this.a.T;
                if (z || (layoutManager = recyclerView.getLayoutManager()) == null || layoutManager.getChildCount() + s.a(layoutManager) < layoutManager.getItemCount()) {
                    return;
                }
                this.a.g(LoadMore.State.CONTINUE);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@d RecyclerView recyclerView, int i2, int i3) {
            List<e.t.k.a.e.a> list;
            LoadMore.b bVar;
            boolean z;
            boolean z2;
            RecyclerView.LayoutManager layoutManager;
            list = this.a.b0;
            if (list != null) {
                for (e.t.k.a.e.a aVar : list) {
                    aVar.onScrolled(recyclerView, i2, i3);
                }
            }
            if (this.a.getPreLoad()) {
                bVar = this.a.W;
                if (bVar != null) {
                    z = this.a.R;
                    if (z || this.a.getLoadMoreFooter().getState() != ScrollableExtend.State.LOADING) {
                        return;
                    }
                    z2 = this.a.T;
                    if (z2 || (layoutManager = recyclerView.getLayoutManager()) == null) {
                        return;
                    }
                    int childCount = layoutManager.getChildCount() + s.a(layoutManager);
                    if (childCount < layoutManager.getItemCount() * this.a.getPreloadRate() || childCount <= 10) {
                        return;
                    }
                    this.a.R = true;
                    this.a.g(LoadMore.State.CONTINUE);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ListView$innerScrollListener$2(ListView listView) {
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
