package com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes3.dex */
public class ViewPagerLayoutManager extends LinearLayoutManager {
    private static final String TAG = "ViewPagerLayoutManager";
    private RecyclerView.OnChildAttachStateChangeListener mChildAttachStateChangeListener;
    private int mDrift;
    private boolean mIsLeftScroll;
    private OnViewPagerListener mOnViewPagerListener;
    private PagerSnapHelper mPagerSnapHelper;
    private RecyclerView mRecyclerView;

    public ViewPagerLayoutManager(Context context, int i2) {
        super(context, i2, false);
        this.mIsLeftScroll = false;
        this.mChildAttachStateChangeListener = new RecyclerView.OnChildAttachStateChangeListener() { // from class: com.tencent.qcloud.tuikit.tuichat.component.imagevideoscan.ViewPagerLayoutManager.1
            {
                ViewPagerLayoutManager.this = this;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
            public void onChildViewAttachedToWindow(View view) {
                if (ViewPagerLayoutManager.this.mOnViewPagerListener == null || ViewPagerLayoutManager.this.getChildCount() != 1) {
                    return;
                }
                ViewPagerLayoutManager.this.mOnViewPagerListener.onInitComplete();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
            public void onChildViewDetachedFromWindow(View view) {
                if (ViewPagerLayoutManager.this.mDrift >= 0) {
                    if (ViewPagerLayoutManager.this.mOnViewPagerListener != null) {
                        ViewPagerLayoutManager.this.mOnViewPagerListener.onPageRelease(true, ViewPagerLayoutManager.this.getPosition(view));
                    }
                } else if (ViewPagerLayoutManager.this.mOnViewPagerListener != null) {
                    ViewPagerLayoutManager.this.mOnViewPagerListener.onPageRelease(false, ViewPagerLayoutManager.this.getPosition(view));
                }
            }
        };
        init();
    }

    private void init() {
        this.mPagerSnapHelper = new PagerSnapHelper();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAttachedToWindow(RecyclerView recyclerView) {
        super.onAttachedToWindow(recyclerView);
        this.mPagerSnapHelper.attachToRecyclerView(recyclerView);
        this.mRecyclerView = recyclerView;
        recyclerView.addOnChildAttachStateChangeListener(this.mChildAttachStateChangeListener);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        super.onLayoutChildren(recycler, state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onScrollStateChanged(int i2) {
        if (i2 != 0) {
            return;
        }
        int position = getPosition(this.mPagerSnapHelper.findSnapView(this));
        if (this.mOnViewPagerListener != null) {
            if (getChildCount() == 1) {
                this.mOnViewPagerListener.onPageSelected(position, position == getItemCount() - 1, this.mIsLeftScroll);
            }
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i2, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (i2 <= 0) {
            this.mIsLeftScroll = true;
        } else {
            this.mIsLeftScroll = false;
        }
        this.mDrift = i2;
        return super.scrollHorizontallyBy(i2, recycler, state);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i2, RecyclerView.Recycler recycler, RecyclerView.State state) {
        this.mDrift = i2;
        return super.scrollVerticallyBy(i2, recycler, state);
    }

    public void setOnViewPagerListener(OnViewPagerListener onViewPagerListener) {
        this.mOnViewPagerListener = onViewPagerListener;
    }
}
