package e.t.l;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.vector.view.scrollable.FlowLayoutManager;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0004"}, d2 = {"findFirstVisibleItemPosition", "", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "findLastVisibleItemPosition", "vector_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class s {
    public static final int a(@k.e.a.d RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof LinearLayoutManager) {
            return ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
        }
        if (layoutManager instanceof GridLayoutManager) {
            return ((GridLayoutManager) layoutManager).findFirstVisibleItemPosition();
        }
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            int[] findFirstVisibleItemPositions = ((StaggeredGridLayoutManager) layoutManager).findFirstVisibleItemPositions(null);
            if (!(findFirstVisibleItemPositions.length == 0)) {
                return findFirstVisibleItemPositions[0];
            }
            return -1;
        } else if (layoutManager instanceof FlowLayoutManager) {
            return ((FlowLayoutManager) layoutManager).findFirstVisibleItemPosition();
        } else {
            return -1;
        }
    }

    public static final int b(@k.e.a.d RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof LinearLayoutManager) {
            return ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
        }
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            int[] findLastVisibleItemPositions = ((StaggeredGridLayoutManager) layoutManager).findLastVisibleItemPositions(null);
            if (!(findLastVisibleItemPositions.length == 0)) {
                return findLastVisibleItemPositions[0];
            }
            return -1;
        }
        return -1;
    }
}
