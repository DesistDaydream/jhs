package e.l.h.j.b;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import java.util.Objects;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003H\u0002J(\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0017"}, d2 = {"Lcom/jihuanshe/base/ui/widget/StageItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "space", "", "(I)V", "mIncludeEdge", "", "getSpace", "()I", "getGridItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "position", "column", "spanCount", "getItemOffsets", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "lib-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class d extends RecyclerView.ItemDecoration {
    private final int a;
    private final boolean b = true;

    public d(int i2) {
        this.a = i2;
    }

    private final void a(Rect rect, int i2, int i3, int i4) {
        if (this.b) {
            int i5 = this.a;
            rect.left = ((i4 - i3) * i5) / i4;
            rect.right = (i5 * (i3 + 1)) / i4;
            e.l.h.k.b bVar = e.l.h.k.b.a;
            bVar.a("StageItemDecoration", "left =" + rect.left + " right=" + rect.right + " position=" + i2 + " column=" + i3);
            if (i2 < i4) {
                rect.top = this.a;
            }
            rect.bottom = this.a;
            return;
        }
        int i6 = this.a;
        rect.left = (i6 * i3) / i4;
        rect.right = (((i4 - 1) - i3) * i6) / i4;
        if (i2 >= i4) {
            rect.top = i6;
        }
    }

    public final int b() {
        return this.a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@k.e.a.d Rect rect, @k.e.a.d View view, @k.e.a.d RecyclerView recyclerView, @k.e.a.d RecyclerView.State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        int spanCount = ((StaggeredGridLayoutManager) recyclerView.getLayoutManager()).getSpanCount();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams");
        a(rect, childAdapterPosition, ((StaggeredGridLayoutManager.LayoutParams) layoutParams).getSpanIndex(), spanCount);
    }
}
