package e.j.a.a;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.flexbox.FlexboxLayoutManager;
import java.util.List;

/* loaded from: classes.dex */
public class i extends RecyclerView.ItemDecoration {

    /* renamed from: c  reason: collision with root package name */
    public static final int f10100c = 1;

    /* renamed from: d  reason: collision with root package name */
    public static final int f10101d = 2;

    /* renamed from: e  reason: collision with root package name */
    public static final int f10102e = 3;

    /* renamed from: f  reason: collision with root package name */
    private static final int[] f10103f = {16843284};
    private Drawable a;
    private int b;

    public i(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(f10103f);
        this.a = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        setOrientation(3);
    }

    private void a(Canvas canvas, RecyclerView recyclerView) {
        int top;
        int intrinsicHeight;
        int left;
        int right;
        int i2;
        int i3;
        int i4;
        if (d()) {
            FlexboxLayoutManager flexboxLayoutManager = (FlexboxLayoutManager) recyclerView.getLayoutManager();
            int flexDirection = flexboxLayoutManager.getFlexDirection();
            int left2 = recyclerView.getLeft() - recyclerView.getPaddingLeft();
            int right2 = recyclerView.getRight() + recyclerView.getPaddingRight();
            int childCount = recyclerView.getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = recyclerView.getChildAt(i5);
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
                if (flexDirection == 3) {
                    intrinsicHeight = childAt.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                    top = this.a.getIntrinsicHeight() + intrinsicHeight;
                } else {
                    top = childAt.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                    intrinsicHeight = top - this.a.getIntrinsicHeight();
                }
                if (flexboxLayoutManager.j()) {
                    if (flexboxLayoutManager.J()) {
                        i3 = Math.min(childAt.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + this.a.getIntrinsicWidth(), right2);
                        i4 = childAt.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                        this.a.setBounds(i4, intrinsicHeight, i3, top);
                        this.a.draw(canvas);
                    } else {
                        left = Math.max((childAt.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - this.a.getIntrinsicWidth(), left2);
                        right = childAt.getRight();
                        i2 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                    }
                } else {
                    left = childAt.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                    right = childAt.getRight();
                    i2 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                }
                int i6 = left;
                i3 = right + i2;
                i4 = i6;
                this.a.setBounds(i4, intrinsicHeight, i3, top);
                this.a.draw(canvas);
            }
        }
    }

    private void b(Canvas canvas, RecyclerView recyclerView) {
        int left;
        int intrinsicWidth;
        int max;
        int bottom;
        int i2;
        int i3;
        if (e()) {
            FlexboxLayoutManager flexboxLayoutManager = (FlexboxLayoutManager) recyclerView.getLayoutManager();
            int top = recyclerView.getTop() - recyclerView.getPaddingTop();
            int bottom2 = recyclerView.getBottom() + recyclerView.getPaddingBottom();
            int childCount = recyclerView.getChildCount();
            int flexDirection = flexboxLayoutManager.getFlexDirection();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = recyclerView.getChildAt(i4);
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
                if (flexboxLayoutManager.J()) {
                    intrinsicWidth = childAt.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                    left = this.a.getIntrinsicWidth() + intrinsicWidth;
                } else {
                    left = childAt.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                    intrinsicWidth = left - this.a.getIntrinsicWidth();
                }
                if (flexboxLayoutManager.j()) {
                    max = childAt.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                    bottom = childAt.getBottom();
                    i2 = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                } else if (flexDirection == 3) {
                    int min = Math.min(childAt.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + this.a.getIntrinsicHeight(), bottom2);
                    max = childAt.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                    i3 = min;
                    this.a.setBounds(intrinsicWidth, max, left, i3);
                    this.a.draw(canvas);
                } else {
                    max = Math.max((childAt.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - this.a.getIntrinsicHeight(), top);
                    bottom = childAt.getBottom();
                    i2 = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                }
                i3 = bottom + i2;
                this.a.setBounds(intrinsicWidth, max, left, i3);
                this.a.draw(canvas);
            }
        }
    }

    private boolean c(int i2, List<f> list, FlexboxLayoutManager flexboxLayoutManager) {
        int G = flexboxLayoutManager.G(i2);
        if ((G == -1 || G >= flexboxLayoutManager.getFlexLinesInternal().size() || flexboxLayoutManager.getFlexLinesInternal().get(G).o != i2) && i2 != 0) {
            return list.size() != 0 && list.get(list.size() - 1).p == i2 - 1;
        }
        return true;
    }

    private boolean d() {
        return (this.b & 1) > 0;
    }

    private boolean e() {
        return (this.b & 2) > 0;
    }

    private void f(Rect rect, int i2, FlexboxLayoutManager flexboxLayoutManager, List<f> list) {
        if (list.size() == 0 || flexboxLayoutManager.G(i2) == 0) {
            return;
        }
        if (flexboxLayoutManager.j()) {
            if (!d()) {
                rect.top = 0;
                rect.bottom = 0;
                return;
            }
            rect.top = this.a.getIntrinsicHeight();
            rect.bottom = 0;
        } else if (e()) {
            if (flexboxLayoutManager.J()) {
                rect.right = this.a.getIntrinsicWidth();
                rect.left = 0;
                return;
            }
            rect.left = this.a.getIntrinsicWidth();
            rect.right = 0;
        }
    }

    private void g(Rect rect, int i2, FlexboxLayoutManager flexboxLayoutManager, List<f> list, int i3) {
        if (c(i2, list, flexboxLayoutManager)) {
            return;
        }
        if (flexboxLayoutManager.j()) {
            if (!e()) {
                rect.left = 0;
                rect.right = 0;
            } else if (flexboxLayoutManager.J()) {
                rect.right = this.a.getIntrinsicWidth();
                rect.left = 0;
            } else {
                rect.left = this.a.getIntrinsicWidth();
                rect.right = 0;
            }
        } else if (!d()) {
            rect.top = 0;
            rect.bottom = 0;
        } else if (i3 == 3) {
            rect.bottom = this.a.getIntrinsicHeight();
            rect.top = 0;
        } else {
            rect.top = this.a.getIntrinsicHeight();
            rect.bottom = 0;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (childAdapterPosition == 0) {
            return;
        }
        if (!d() && !e()) {
            rect.set(0, 0, 0, 0);
            return;
        }
        FlexboxLayoutManager flexboxLayoutManager = (FlexboxLayoutManager) recyclerView.getLayoutManager();
        List<f> flexLines = flexboxLayoutManager.getFlexLines();
        g(rect, childAdapterPosition, flexboxLayoutManager, flexLines, flexboxLayoutManager.getFlexDirection());
        f(rect, childAdapterPosition, flexboxLayoutManager, flexLines);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        a(canvas, recyclerView);
        b(canvas, recyclerView);
    }

    public void setDrawable(Drawable drawable) {
        if (drawable != null) {
            this.a = drawable;
            return;
        }
        throw new IllegalArgumentException("Drawable cannot be null.");
    }

    public void setOrientation(int i2) {
        this.b = i2;
    }
}
