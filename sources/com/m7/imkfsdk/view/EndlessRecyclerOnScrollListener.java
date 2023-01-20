package com.m7.imkfsdk.view;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes2.dex */
public abstract class EndlessRecyclerOnScrollListener extends RecyclerView.OnScrollListener {
    private boolean isSlidingUpward = false;

    public abstract void onLoadMore();

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
        super.onScrollStateChanged(recyclerView, i2);
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        if (i2 == 0 && linearLayoutManager.findLastCompletelyVisibleItemPosition() == linearLayoutManager.getItemCount() - 1 && this.isSlidingUpward) {
            onLoadMore();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
        super.onScrolled(recyclerView, i2, i3);
        this.isSlidingUpward = i3 > 0;
    }
}
