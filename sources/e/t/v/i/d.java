package e.t.v.i;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Objects;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002J(\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0011H\u0002J \u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/vector/view/recyclerview/RecyclerDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "()V", "config", "Lcom/vector/view/recyclerview/config/DecorationConfig;", "getConfig", "()Lcom/vector/view/recyclerview/config/DecorationConfig;", "setConfig", "(Lcom/vector/view/recyclerview/config/DecorationConfig;)V", "itemDecoration", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "initItemDecoration", "recyclerView", "onDraw", "c", "Landroid/graphics/Canvas;", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class d extends RecyclerView.ItemDecoration {
    public e.t.v.i.e.a a;
    @e
    private RecyclerView.ItemDecoration b;

    private final void b(RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            if (layoutManager instanceof GridLayoutManager) {
                this.b = new b(recyclerView, a());
            } else {
                this.b = new c(recyclerView, a());
            }
        }
    }

    @k.e.a.d
    public final e.t.v.i.e.a a() {
        e.t.v.i.e.a aVar = this.a;
        Objects.requireNonNull(aVar);
        return aVar;
    }

    public final void c(@k.e.a.d e.t.v.i.e.a aVar) {
        this.a = aVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@k.e.a.d Rect rect, @k.e.a.d View view, @k.e.a.d RecyclerView recyclerView, @k.e.a.d RecyclerView.State state) {
        if (this.b == null) {
            b(recyclerView);
        }
        RecyclerView.ItemDecoration itemDecoration = this.b;
        if (itemDecoration == null) {
            return;
        }
        itemDecoration.getItemOffsets(rect, view, recyclerView, state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(@k.e.a.d Canvas canvas, @k.e.a.d RecyclerView recyclerView, @k.e.a.d RecyclerView.State state) {
        if (this.b == null) {
            b(recyclerView);
        }
        RecyclerView.ItemDecoration itemDecoration = this.b;
        if (itemDecoration == null) {
            return;
        }
        itemDecoration.onDraw(canvas, recyclerView, state);
    }
}
