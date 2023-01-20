package e.t.v.i;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.vector.view.recyclerview.BaseDecoration;
import e.t.l.h;
import java.util.Objects;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0018\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J(\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u000e\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0003J \u0010\u001f\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001dH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/vector/view/recyclerview/LinearDecoration;", "Lcom/vector/view/recyclerview/BaseDecoration;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "config", "Lcom/vector/view/recyclerview/config/DecorationConfig;", "(Landroidx/recyclerview/widget/RecyclerView;Lcom/vector/view/recyclerview/config/DecorationConfig;)V", "drawBottom", "", "drawLeft", "drawRight", "drawTop", "marginBottom", "", "marginLeft", "marginRight", "marginTop", "orientation", "drawHorizontal", "", "c", "Landroid/graphics/Canvas;", "drawVertical", "getItemOffsets", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "isFooter", "onDraw", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class c extends BaseDecoration {

    /* renamed from: h  reason: collision with root package name */
    private final int f14692h;

    /* renamed from: i  reason: collision with root package name */
    private int f14693i;

    /* renamed from: j  reason: collision with root package name */
    private int f14694j;

    /* renamed from: k  reason: collision with root package name */
    private int f14695k;

    /* renamed from: l  reason: collision with root package name */
    private int f14696l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f14697m;
    private boolean n;
    private boolean o;
    private boolean p;

    public c(@k.e.a.d RecyclerView recyclerView, @k.e.a.d e.t.v.i.e.a aVar) {
        super(recyclerView, aVar);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        this.f14692h = ((LinearLayoutManager) layoutManager).getOrientation();
        this.f14697m = true;
        this.n = true;
        this.o = true;
        this.p = true;
        e.t.v.i.e.c d2 = aVar.d();
        e.t.v.i.e.d dVar = d2 instanceof e.t.v.i.e.d ? (e.t.v.i.e.d) d2 : null;
        if (dVar == null) {
            return;
        }
        this.f14693i = dVar.f();
        this.f14694j = dVar.h();
        this.f14695k = dVar.g();
        this.f14696l = dVar.e();
        this.n = dVar.d();
        this.f14697m = dVar.b();
        this.o = dVar.c();
        this.p = dVar.a();
    }

    private final void drawHorizontal(Canvas canvas, RecyclerView recyclerView) {
        int i2;
        int width;
        int childLayoutPosition;
        int c2;
        canvas.save();
        int i3 = 0;
        if (recyclerView.getClipToPadding()) {
            i2 = recyclerView.getPaddingLeft() + this.f14693i;
            width = (recyclerView.getWidth() - recyclerView.getPaddingRight()) - this.f14695k;
            canvas.clipRect(i2, recyclerView.getPaddingTop(), width, recyclerView.getHeight() - recyclerView.getPaddingBottom());
        } else {
            i2 = this.f14693i + 0;
            width = recyclerView.getWidth() - this.f14695k;
        }
        int childCount = recyclerView.getChildCount();
        if (childCount > 0) {
            while (true) {
                int i4 = i3 + 1;
                View childAt = recyclerView.getChildAt(i3);
                if (childAt != null && (childLayoutPosition = recyclerView.getChildLayoutPosition(childAt)) != -1 && (d() == 0 || (c2 = (c() - childLayoutPosition) - 1) > d() || (c2 == d() && this.p))) {
                    recyclerView.getDecoratedBoundsWithMargins(childAt, a());
                    if (this.n && childLayoutPosition < 1) {
                        int round = a().top + Math.round(childAt.getTranslationY());
                        canvas.drawRect(i2, round, width, g() + round, f());
                    }
                    if (this.p || childLayoutPosition != c() - 1) {
                        int round2 = a().bottom + Math.round(childAt.getTranslationY());
                        canvas.drawRect(i2, round2 - g(), width, round2, f());
                    }
                }
                if (i4 >= childCount) {
                    break;
                }
                i3 = i4;
            }
        }
        canvas.restore();
    }

    private final void drawVertical(Canvas canvas, RecyclerView recyclerView) {
        int i2;
        int height;
        int childLayoutPosition;
        int i3;
        canvas.save();
        int i4 = 0;
        if (recyclerView.getClipToPadding()) {
            i2 = recyclerView.getPaddingTop() + this.f14694j;
            height = (recyclerView.getHeight() - recyclerView.getPaddingBottom()) - this.f14696l;
            canvas.clipRect(recyclerView.getPaddingLeft(), i2, recyclerView.getWidth() - recyclerView.getPaddingRight(), height);
        } else {
            i2 = this.f14694j + 0;
            height = recyclerView.getHeight() - this.f14696l;
        }
        int childCount = recyclerView.getChildCount();
        if (childCount > 0) {
            while (true) {
                int i5 = i4 + 1;
                View childAt = recyclerView.getChildAt(i4);
                if (childAt != null && (childLayoutPosition = recyclerView.getChildLayoutPosition(childAt)) != -1) {
                    RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                    if (layoutManager != null) {
                        layoutManager.getDecoratedBoundsWithMargins(childAt, a());
                    }
                    if (e() == 0 || (i3 = childLayoutPosition + 1) > e() || (i3 == e() && this.o)) {
                        if (this.f14697m && childLayoutPosition < 1) {
                            int round = a().left + Math.round(childAt.getTranslationX());
                            canvas.drawRect(round, i2, g() + round, height, f());
                        }
                        if (this.o || childLayoutPosition != c() - 1) {
                            int round2 = a().right + Math.round(childAt.getTranslationX());
                            canvas.drawRect(round2 - g(), i2, round2, height, f());
                        }
                    }
                }
                if (i5 >= childCount) {
                    break;
                }
                i4 = i5;
            }
        }
        canvas.restore();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@k.e.a.d Rect rect, @k.e.a.d View view, @k.e.a.d RecyclerView recyclerView, @k.e.a.d RecyclerView.State state) {
        int c2;
        int i2;
        int itemCount;
        int childLayoutPosition = recyclerView.getChildLayoutPosition(view);
        if (childLayoutPosition == -1 || k(recyclerView)) {
            return;
        }
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter != null && (itemCount = adapter.getItemCount()) != c()) {
            i(itemCount);
        }
        if (e() != 0 && (i2 = childLayoutPosition + 1) <= e()) {
            if (i2 == e()) {
                if (this.f14692h == 1) {
                    if (this.n) {
                        rect.set(0, 0, 0, g());
                        return;
                    }
                    return;
                } else if (this.f14697m) {
                    rect.set(0, 0, g(), 0);
                    return;
                } else {
                    return;
                }
            }
            rect.set(0, 0, 0, 0);
        } else if (d() != 0 && (c2 = (c() - childLayoutPosition) - 1) <= d()) {
            if (c2 == d()) {
                if (this.f14692h == 1) {
                    if (this.p) {
                        rect.set(0, 0, 0, g());
                        return;
                    }
                    return;
                } else if (this.o) {
                    rect.set(0, 0, g(), 0);
                    return;
                } else {
                    return;
                }
            }
            rect.set(0, 0, 0, 0);
        } else if (this.f14692h == 1) {
            rect.set(0, 0, 0, g());
            if (this.n && childLayoutPosition < 1) {
                rect.top = g();
            }
            if (this.p || childLayoutPosition != c() - 1) {
                return;
            }
            rect.bottom = 0;
        } else {
            rect.set(0, 0, g(), 0);
            if (this.f14697m && childLayoutPosition < 1) {
                rect.left = g();
            }
            if (this.o || childLayoutPosition != c() - 1) {
                return;
            }
            rect.right = g();
        }
    }

    public final boolean k(@k.e.a.d RecyclerView recyclerView) {
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter != null && (adapter instanceof e.t.k.a.c.c)) {
            e.t.k.a.c.c cVar = (e.t.k.a.c.c) adapter;
            if (recyclerView.getChildCount() == 1 && cVar.k() == 0) {
                return true;
            }
        }
        new h();
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(@k.e.a.d Canvas canvas, @k.e.a.d RecyclerView recyclerView, @k.e.a.d RecyclerView.State state) {
        if (k(recyclerView)) {
            return;
        }
        if (this.f14692h == 1) {
            drawHorizontal(canvas, recyclerView);
        } else {
            drawVertical(canvas, recyclerView);
        }
    }
}
