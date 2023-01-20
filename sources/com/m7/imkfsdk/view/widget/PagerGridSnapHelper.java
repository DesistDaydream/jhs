package com.m7.imkfsdk.view.widget;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

/* loaded from: classes2.dex */
public class PagerGridSnapHelper extends SnapHelper {
    private RecyclerView mRecyclerView;

    private boolean snapFromFling(@NonNull RecyclerView.LayoutManager layoutManager, int i2, int i3) {
        LinearSmoothScroller createSnapScroller;
        int findTargetSnapPosition;
        if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) || (createSnapScroller = createSnapScroller(layoutManager)) == null || (findTargetSnapPosition = findTargetSnapPosition(layoutManager, i2, i3)) == -1) {
            return false;
        }
        createSnapScroller.setTargetPosition(findTargetSnapPosition);
        layoutManager.startSmoothScroll(createSnapScroller);
        return true;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public void attachToRecyclerView(@Nullable RecyclerView recyclerView) throws IllegalStateException {
        super.attachToRecyclerView(recyclerView);
        this.mRecyclerView = recyclerView;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    @Nullable
    public int[] calculateDistanceToFinalSnap(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull View view) {
        return layoutManager instanceof PagerGridLayoutManager ? ((PagerGridLayoutManager) layoutManager).getSnapOffset(layoutManager.getPosition(view)) : new int[2];
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public LinearSmoothScroller createSnapScroller(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) {
            return new PagerGridSmoothScroller(this.mRecyclerView);
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    @Nullable
    public View findSnapView(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof PagerGridLayoutManager) {
            return ((PagerGridLayoutManager) layoutManager).findSnapView();
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int i2, int i3) {
        if (layoutManager != null && (layoutManager instanceof PagerGridLayoutManager)) {
            PagerGridLayoutManager pagerGridLayoutManager = (PagerGridLayoutManager) layoutManager;
            if (pagerGridLayoutManager.canScrollHorizontally()) {
                if (i2 > PagerConfig.getFlingThreshold()) {
                    return pagerGridLayoutManager.findNextPageFirstPos();
                }
                if (i2 < (-PagerConfig.getFlingThreshold())) {
                    return pagerGridLayoutManager.findPrePageFirstPos();
                }
            } else if (pagerGridLayoutManager.canScrollVertically()) {
                if (i3 > PagerConfig.getFlingThreshold()) {
                    return pagerGridLayoutManager.findNextPageFirstPos();
                }
                if (i3 < (-PagerConfig.getFlingThreshold())) {
                    return pagerGridLayoutManager.findPrePageFirstPos();
                }
            }
        }
        return -1;
    }

    @Override // androidx.recyclerview.widget.SnapHelper, androidx.recyclerview.widget.RecyclerView.OnFlingListener
    public boolean onFling(int i2, int i3) {
        RecyclerView.LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
        if (layoutManager == null || this.mRecyclerView.getAdapter() == null) {
            return false;
        }
        int flingThreshold = PagerConfig.getFlingThreshold();
        return (Math.abs(i3) > flingThreshold || Math.abs(i2) > flingThreshold) && snapFromFling(layoutManager, i2, i3);
    }

    public void setFlingThreshold(int i2) {
        PagerConfig.setFlingThreshold(i2);
    }
}
