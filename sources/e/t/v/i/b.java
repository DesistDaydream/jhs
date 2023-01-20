package e.t.v.i;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.vector.view.recyclerview.BaseDecoration;
import java.util.Objects;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J(\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J \u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/vector/view/recyclerview/GridDecoration;", "Lcom/vector/view/recyclerview/BaseDecoration;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "config", "Lcom/vector/view/recyclerview/config/DecorationConfig;", "(Landroidx/recyclerview/widget/RecyclerView;Lcom/vector/view/recyclerview/config/DecorationConfig;)V", "drawBottom", "", "drawTop", "layoutManager", "Landroidx/recyclerview/widget/GridLayoutManager;", "marginBottom", "", "marginTop", "spanCount", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "onDraw", "c", "Landroid/graphics/Canvas;", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class b extends BaseDecoration {
    @k.e.a.d

    /* renamed from: h  reason: collision with root package name */
    private final GridLayoutManager f14686h;

    /* renamed from: i  reason: collision with root package name */
    private final int f14687i;

    /* renamed from: j  reason: collision with root package name */
    private int f14688j;

    /* renamed from: k  reason: collision with root package name */
    private int f14689k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f14690l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f14691m;

    public b(@k.e.a.d RecyclerView recyclerView, @k.e.a.d e.t.v.i.e.a aVar) {
        super(recyclerView, aVar);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
        GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
        this.f14686h = gridLayoutManager;
        this.f14687i = gridLayoutManager.getSpanCount();
        this.f14690l = true;
        this.f14691m = true;
        e.t.v.i.e.c d2 = aVar.d();
        e.t.v.i.e.b bVar = d2 instanceof e.t.v.i.e.b ? (e.t.v.i.e.b) d2 : null;
        if (bVar == null) {
            return;
        }
        this.f14688j = bVar.d();
        this.f14689k = bVar.c();
        this.f14690l = bVar.b();
        this.f14691m = bVar.a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@k.e.a.d Rect rect, @k.e.a.d View view, @k.e.a.d RecyclerView recyclerView, @k.e.a.d RecyclerView.State state) {
        int childLayoutPosition = recyclerView.getChildLayoutPosition(view);
        if (-1 == childLayoutPosition) {
            return;
        }
        int i2 = childLayoutPosition % this.f14687i;
        rect.left = (g() * i2) / this.f14687i;
        int g2 = g();
        int g3 = (i2 + 1) * g();
        int i3 = this.f14687i;
        rect.right = g2 - (g3 / i3);
        if (this.f14690l && childLayoutPosition < i3) {
            rect.top = g();
        }
        if (this.f14691m || childLayoutPosition / this.f14687i != (c() - 1) / this.f14687i) {
            rect.bottom = g();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(@k.e.a.d Canvas canvas, @k.e.a.d RecyclerView recyclerView, @k.e.a.d RecyclerView.State state) {
        int childLayoutPosition;
        canvas.save();
        int childCount = recyclerView.getChildCount();
        if (childCount > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                View childAt = recyclerView.getChildAt(i2);
                if (childAt != null && -1 != (childLayoutPosition = recyclerView.getChildLayoutPosition(childAt))) {
                    this.f14686h.getDecoratedBoundsWithMargins(childAt, a());
                    int i4 = childLayoutPosition % this.f14687i;
                    int i5 = a().top + this.f14688j;
                    int i6 = a().bottom - this.f14689k;
                    if (this.f14690l && childLayoutPosition < this.f14687i) {
                        i5 += g();
                    }
                    if (this.f14691m || childLayoutPosition / this.f14687i != (c() - 1) / this.f14687i) {
                        i6 -= g();
                    }
                    if (i4 != 0) {
                        int i7 = a().left;
                        canvas.drawRect(i7, i5, ((g() * i4) / this.f14687i) + i7, i6, f());
                    }
                    if ((childLayoutPosition + 1) % this.f14687i != 0) {
                        int i8 = a().right;
                        int g2 = (i8 - g()) + (((i4 + 1) * g()) / this.f14687i);
                        if (childLayoutPosition != c() - 1) {
                            canvas.drawRect(g2, i5, i8, i6, f());
                        }
                    }
                }
                if (i3 >= childCount) {
                    break;
                }
                i2 = i3;
            }
        }
        canvas.restore();
    }
}
