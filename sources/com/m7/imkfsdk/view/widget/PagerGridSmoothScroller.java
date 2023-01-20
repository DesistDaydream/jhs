package com.m7.imkfsdk.view.widget;

import android.util.DisplayMetrics;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes2.dex */
public class PagerGridSmoothScroller extends LinearSmoothScroller {
    private RecyclerView mRecyclerView;

    public PagerGridSmoothScroller(@NonNull RecyclerView recyclerView) {
        super(recyclerView.getContext());
        this.mRecyclerView = recyclerView;
    }

    @Override // androidx.recyclerview.widget.LinearSmoothScroller
    public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
        return PagerConfig.getMillisecondsPreInch() / displayMetrics.densityDpi;
    }

    @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
    public void onTargetFound(View view, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
        RecyclerView.LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
        if (layoutManager != null && (layoutManager instanceof PagerGridLayoutManager)) {
            int[] snapOffset = ((PagerGridLayoutManager) layoutManager).getSnapOffset(this.mRecyclerView.getChildAdapterPosition(view));
            int i2 = snapOffset[0];
            int i3 = snapOffset[1];
            int calculateTimeForScrolling = calculateTimeForScrolling(Math.max(Math.abs(i2), Math.abs(i3)));
            if (calculateTimeForScrolling > 0) {
                action.update(i2, i3, calculateTimeForScrolling, this.mDecelerateInterpolator);
            }
        }
    }
}
