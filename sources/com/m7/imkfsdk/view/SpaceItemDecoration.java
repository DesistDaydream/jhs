package com.m7.imkfsdk.view;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes2.dex */
public class SpaceItemDecoration extends RecyclerView.ItemDecoration {
    private int leftRight;
    private int topBottom;

    public SpaceItemDecoration(int i2, int i3) {
        this.leftRight = i2;
        this.topBottom = i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        if (linearLayoutManager.getOrientation() == 1) {
            if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                rect.bottom = this.topBottom;
            }
            rect.top = this.topBottom;
            int i2 = this.leftRight;
            rect.left = i2;
            rect.right = i2;
            return;
        }
        if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
            rect.right = this.leftRight;
        }
        int i3 = this.topBottom;
        rect.top = i3;
        rect.left = this.leftRight;
        rect.bottom = i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        super.onDraw(canvas, recyclerView, state);
    }
}
