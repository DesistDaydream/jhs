package com.m7.imkfsdk.view.widget;

import android.annotation.SuppressLint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.IntRange;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes2.dex */
public class PagerGridLayoutManager extends RecyclerView.LayoutManager implements RecyclerView.SmoothScroller.ScrollVectorProvider {
    public static final int HORIZONTAL = 1;
    private static final String TAG = "PagerGridLayoutManager";
    public static final int VERTICAL = 0;
    private int mColumns;
    private int mMaxScrollX;
    private int mMaxScrollY;
    private int mOnePageSize;
    @OrientationType
    private int mOrientation;
    private RecyclerView mRecyclerView;
    private int mRows;
    private int mOffsetX = 0;
    private int mOffsetY = 0;
    private int mItemWidth = 0;
    private int mItemHeight = 0;
    private int mWidthUsed = 0;
    private int mHeightUsed = 0;
    private int mScrollState = 0;
    private boolean mAllowContinuousScroll = false;
    private boolean mChangeSelectInScrolling = true;
    private int mLastPageCount = -1;
    private int mLastPageIndex = -1;
    private PageListener mPageListener = null;
    private SparseArray<Rect> mItemFrames = new SparseArray<>();

    /* loaded from: classes2.dex */
    public @interface OrientationType {
    }

    /* loaded from: classes2.dex */
    public interface PageListener {
        void onPageSelect(int i2);

        void onPageSizeChanged(int i2);
    }

    public PagerGridLayoutManager(@IntRange(from = 1, to = 100) int i2, @IntRange(from = 1, to = 100) int i3, @OrientationType int i4) {
        this.mOrientation = i4;
        this.mRows = i2;
        this.mColumns = i3;
        this.mOnePageSize = i2 * i3;
    }

    private void addOrRemove(RecyclerView.Recycler recycler, Rect rect, int i2) {
        View viewForPosition = recycler.getViewForPosition(i2);
        Rect itemFrameByPosition = getItemFrameByPosition(i2);
        if (!Rect.intersects(rect, itemFrameByPosition)) {
            removeAndRecycleView(viewForPosition, recycler);
            return;
        }
        addView(viewForPosition);
        measureChildWithMargins(viewForPosition, this.mWidthUsed, this.mHeightUsed);
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) viewForPosition.getLayoutParams();
        layoutDecorated(viewForPosition, (itemFrameByPosition.left - this.mOffsetX) + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + getPaddingLeft(), (itemFrameByPosition.top - this.mOffsetY) + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + getPaddingTop(), ((itemFrameByPosition.right - this.mOffsetX) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin) + getPaddingLeft(), ((itemFrameByPosition.bottom - this.mOffsetY) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) + getPaddingTop());
    }

    private Rect getItemFrameByPosition(int i2) {
        int usableHeight;
        Rect rect = this.mItemFrames.get(i2);
        if (rect == null) {
            rect = new Rect();
            int i3 = i2 / this.mOnePageSize;
            int i4 = 0;
            if (canScrollHorizontally()) {
                i4 = (getUsableWidth() * i3) + 0;
                usableHeight = 0;
            } else {
                usableHeight = (getUsableHeight() * i3) + 0;
            }
            int i5 = i2 % this.mOnePageSize;
            int i6 = this.mColumns;
            int i7 = i5 / i6;
            int i8 = i5 - (i6 * i7);
            int i9 = this.mItemWidth;
            int i10 = i4 + (i8 * i9);
            int i11 = this.mItemHeight;
            int i12 = usableHeight + (i7 * i11);
            rect.left = i10;
            rect.top = i12;
            rect.right = i10 + i9;
            rect.bottom = i12 + i11;
            this.mItemFrames.put(i2, rect);
        }
        return rect;
    }

    private int getPageIndexByOffset() {
        int i2;
        if (canScrollVertically()) {
            int usableHeight = getUsableHeight();
            int i3 = this.mOffsetY;
            if (i3 <= 0 || usableHeight <= 0) {
                return 0;
            }
            i2 = i3 / usableHeight;
            if (i3 % usableHeight <= usableHeight / 2) {
                return i2;
            }
        } else {
            int usableWidth = getUsableWidth();
            int i4 = this.mOffsetX;
            if (i4 <= 0 || usableWidth <= 0) {
                return 0;
            }
            i2 = i4 / usableWidth;
            if (i4 % usableWidth <= usableWidth / 2) {
                return i2;
            }
        }
        return i2 + 1;
    }

    private int getPageIndexByPos(int i2) {
        return i2 / this.mOnePageSize;
    }

    private int[] getPageLeftTopByPosition(int i2) {
        int[] iArr = new int[2];
        int pageIndexByPos = getPageIndexByPos(i2);
        if (canScrollHorizontally()) {
            iArr[0] = pageIndexByPos * getUsableWidth();
            iArr[1] = 0;
        } else {
            iArr[0] = 0;
            iArr[1] = pageIndexByPos * getUsableHeight();
        }
        return iArr;
    }

    private int getTotalPageCount() {
        if (getItemCount() <= 0) {
            return 0;
        }
        int itemCount = getItemCount() / this.mOnePageSize;
        return getItemCount() % this.mOnePageSize != 0 ? itemCount + 1 : itemCount;
    }

    private int getUsableHeight() {
        return (getHeight() - getPaddingTop()) - getPaddingBottom();
    }

    private int getUsableWidth() {
        return (getWidth() - getPaddingLeft()) - getPaddingRight();
    }

    @SuppressLint({"CheckResult"})
    private void recycleAndFillItems(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        if (state.isPreLayout()) {
            return;
        }
        Rect rect = new Rect(this.mOffsetX - this.mItemWidth, this.mOffsetY - this.mItemHeight, getUsableWidth() + this.mOffsetX + this.mItemWidth, getUsableHeight() + this.mOffsetY + this.mItemHeight);
        rect.intersect(0, 0, this.mMaxScrollX + getUsableWidth(), this.mMaxScrollY + getUsableHeight());
        int pageIndexByOffset = getPageIndexByOffset();
        int i2 = this.mOnePageSize;
        int i3 = (pageIndexByOffset * i2) - (i2 * 2);
        int i4 = i3 >= 0 ? i3 : 0;
        int i5 = (i2 * 4) + i4;
        if (i5 > getItemCount()) {
            i5 = getItemCount();
        }
        detachAndScrapAttachedViews(recycler);
        if (z) {
            while (i4 < i5) {
                addOrRemove(recycler, rect, i4);
                i4++;
            }
            return;
        }
        for (int i6 = i5 - 1; i6 >= i4; i6--) {
            addOrRemove(recycler, rect, i6);
        }
    }

    private void setPageCount(int i2) {
        if (i2 >= 0) {
            PageListener pageListener = this.mPageListener;
            if (pageListener != null && i2 != this.mLastPageCount) {
                pageListener.onPageSizeChanged(i2);
            }
            this.mLastPageCount = i2;
        }
    }

    private void setPageIndex(int i2, boolean z) {
        PageListener pageListener;
        if (i2 == this.mLastPageIndex) {
            return;
        }
        if (isAllowContinuousScroll()) {
            this.mLastPageIndex = i2;
        } else if (!z) {
            this.mLastPageIndex = i2;
        }
        if ((!z || this.mChangeSelectInScrolling) && i2 >= 0 && (pageListener = this.mPageListener) != null) {
            pageListener.onPageSelect(i2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        return this.mOrientation == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return this.mOrientation == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public PointF computeScrollVectorForPosition(int i2) {
        PointF pointF = new PointF();
        int[] snapOffset = getSnapOffset(i2);
        pointF.x = snapOffset[0];
        pointF.y = snapOffset[1];
        return pointF;
    }

    public int findNextPageFirstPos() {
        int i2 = this.mLastPageIndex + 1;
        if (i2 >= getTotalPageCount()) {
            i2 = getTotalPageCount() - 1;
        }
        return i2 * this.mOnePageSize;
    }

    public int findPrePageFirstPos() {
        int i2 = this.mLastPageIndex - 1;
        if (i2 < 0) {
            i2 = 0;
        }
        return i2 * this.mOnePageSize;
    }

    public View findSnapView() {
        if (getFocusedChild() != null) {
            return getFocusedChild();
        }
        if (getChildCount() <= 0) {
            return null;
        }
        int pageIndexByOffset = getPageIndexByOffset() * this.mOnePageSize;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            if (getPosition(getChildAt(i2)) == pageIndexByOffset) {
                return getChildAt(i2);
            }
        }
        return getChildAt(0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    public int getOffsetX() {
        return this.mOffsetX;
    }

    public int getOffsetY() {
        return this.mOffsetY;
    }

    public int[] getSnapOffset(int i2) {
        int[] pageLeftTopByPosition = getPageLeftTopByPosition(i2);
        return new int[]{pageLeftTopByPosition[0] - this.mOffsetX, pageLeftTopByPosition[1] - this.mOffsetY};
    }

    public boolean isAllowContinuousScroll() {
        return this.mAllowContinuousScroll;
    }

    public void nextPage() {
        scrollToPage(getPageIndexByOffset() + 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAttachedToWindow(RecyclerView recyclerView) {
        super.onAttachedToWindow(recyclerView);
        this.mRecyclerView = recyclerView;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (state.isPreLayout() || !state.didStructureChange()) {
            return;
        }
        if (getItemCount() == 0) {
            removeAndRecycleAllViews(recycler);
            setPageCount(0);
            setPageIndex(0, false);
            return;
        }
        setPageCount(getTotalPageCount());
        setPageIndex(getPageIndexByOffset(), false);
        int itemCount = getItemCount() / this.mOnePageSize;
        if (getItemCount() % this.mOnePageSize != 0) {
            itemCount++;
        }
        if (canScrollHorizontally()) {
            int usableWidth = (itemCount - 1) * getUsableWidth();
            this.mMaxScrollX = usableWidth;
            this.mMaxScrollY = 0;
            if (this.mOffsetX > usableWidth) {
                this.mOffsetX = usableWidth;
            }
        } else {
            this.mMaxScrollX = 0;
            int usableHeight = (itemCount - 1) * getUsableHeight();
            this.mMaxScrollY = usableHeight;
            if (this.mOffsetY > usableHeight) {
                this.mOffsetY = usableHeight;
            }
        }
        if (this.mItemWidth <= 0) {
            this.mItemWidth = getUsableWidth() / this.mColumns;
        }
        if (this.mItemHeight <= 0) {
            this.mItemHeight = getUsableHeight() / this.mRows;
        }
        this.mWidthUsed = getUsableWidth() - this.mItemWidth;
        this.mHeightUsed = getUsableHeight() - this.mItemHeight;
        for (int i2 = 0; i2 < this.mOnePageSize * 2; i2++) {
            getItemFrameByPosition(i2);
        }
        if (this.mOffsetX == 0 && this.mOffsetY == 0) {
            for (int i3 = 0; i3 < this.mOnePageSize && i3 < getItemCount(); i3++) {
                View viewForPosition = recycler.getViewForPosition(i3);
                addView(viewForPosition);
                measureChildWithMargins(viewForPosition, this.mWidthUsed, this.mHeightUsed);
            }
        }
        recycleAndFillItems(recycler, state, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        if (state.isPreLayout()) {
            return;
        }
        setPageCount(getTotalPageCount());
        setPageIndex(getPageIndexByOffset(), false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onMeasure(RecyclerView.Recycler recycler, RecyclerView.State state, int i2, int i3) {
        super.onMeasure(recycler, state, i2, i3);
        int size = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        int mode2 = View.MeasureSpec.getMode(i3);
        if (mode != 1073741824 && size > 0) {
            mode = 1073741824;
        }
        if (mode2 != 1073741824 && size2 > 0) {
            mode2 = 1073741824;
        }
        setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(size, mode), View.MeasureSpec.makeMeasureSpec(size2, mode2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onScrollStateChanged(int i2) {
        this.mScrollState = i2;
        super.onScrollStateChanged(i2);
        if (i2 == 0) {
            setPageIndex(getPageIndexByOffset(), false);
        }
    }

    public void prePage() {
        scrollToPage(getPageIndexByOffset() - 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i2, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i3 = this.mOffsetX;
        int i4 = i3 + i2;
        int i5 = this.mMaxScrollX;
        if (i4 > i5) {
            i2 = i5 - i3;
        } else if (i4 < 0) {
            i2 = 0 - i3;
        }
        this.mOffsetX = i3 + i2;
        setPageIndex(getPageIndexByOffset(), true);
        offsetChildrenHorizontal(-i2);
        if (i2 > 0) {
            recycleAndFillItems(recycler, state, true);
        } else {
            recycleAndFillItems(recycler, state, false);
        }
        return i2;
    }

    public void scrollToPage(int i2) {
        int usableWidth;
        int i3;
        if (i2 >= 0 && i2 < this.mLastPageCount) {
            if (this.mRecyclerView == null) {
                Log.e(TAG, "RecyclerView Not Found!");
                return;
            }
            if (canScrollVertically()) {
                i3 = (getUsableHeight() * i2) - this.mOffsetY;
                usableWidth = 0;
            } else {
                usableWidth = (getUsableWidth() * i2) - this.mOffsetX;
                i3 = 0;
            }
            this.mRecyclerView.scrollBy(usableWidth, i3);
            setPageIndex(i2, false);
            return;
        }
        String str = TAG;
        Log.e(str, "pageIndex = " + i2 + " is out of bounds, mast in [0, " + this.mLastPageCount + ")");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i2) {
        scrollToPage(getPageIndexByPos(i2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i2, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i3 = this.mOffsetY;
        int i4 = i3 + i2;
        int i5 = this.mMaxScrollY;
        if (i4 > i5) {
            i2 = i5 - i3;
        } else if (i4 < 0) {
            i2 = 0 - i3;
        }
        this.mOffsetY = i3 + i2;
        setPageIndex(getPageIndexByOffset(), true);
        offsetChildrenVertical(-i2);
        if (i2 > 0) {
            recycleAndFillItems(recycler, state, true);
        } else {
            recycleAndFillItems(recycler, state, false);
        }
        return i2;
    }

    public void setAllowContinuousScroll(boolean z) {
        this.mAllowContinuousScroll = z;
    }

    public void setChangeSelectInScrolling(boolean z) {
        this.mChangeSelectInScrolling = z;
    }

    @OrientationType
    public int setOrientationType(@OrientationType int i2) {
        int i3 = this.mOrientation;
        if (i3 == i2 || this.mScrollState != 0) {
            return i3;
        }
        this.mOrientation = i2;
        this.mItemFrames.clear();
        int i4 = this.mOffsetX;
        this.mOffsetX = (this.mOffsetY / getUsableHeight()) * getUsableWidth();
        this.mOffsetY = (i4 / getUsableWidth()) * getUsableHeight();
        int i5 = this.mMaxScrollX;
        this.mMaxScrollX = (this.mMaxScrollY / getUsableHeight()) * getUsableWidth();
        this.mMaxScrollY = (i5 / getUsableWidth()) * getUsableHeight();
        return this.mOrientation;
    }

    public void setPageListener(PageListener pageListener) {
        this.mPageListener = pageListener;
    }

    public void smoothNextPage() {
        smoothScrollToPage(getPageIndexByOffset() + 1);
    }

    public void smoothPrePage() {
        smoothScrollToPage(getPageIndexByOffset() - 1);
    }

    public void smoothScrollToPage(int i2) {
        if (i2 >= 0 && i2 < this.mLastPageCount) {
            if (this.mRecyclerView == null) {
                Log.e(TAG, "RecyclerView Not Found!");
                return;
            }
            int pageIndexByOffset = getPageIndexByOffset();
            if (Math.abs(i2 - pageIndexByOffset) > 3) {
                if (i2 > pageIndexByOffset) {
                    scrollToPage(i2 - 3);
                } else if (i2 < pageIndexByOffset) {
                    scrollToPage(i2 + 3);
                }
            }
            PagerGridSmoothScroller pagerGridSmoothScroller = new PagerGridSmoothScroller(this.mRecyclerView);
            pagerGridSmoothScroller.setTargetPosition(i2 * this.mOnePageSize);
            startSmoothScroll(pagerGridSmoothScroller);
            return;
        }
        String str = TAG;
        Log.e(str, "pageIndex is outOfIndex, must in [0, " + this.mLastPageCount + ").");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i2) {
        smoothScrollToPage(getPageIndexByPos(i2));
    }
}
