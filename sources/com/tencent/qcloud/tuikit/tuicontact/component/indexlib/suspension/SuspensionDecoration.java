package com.tencent.qcloud.tuikit.tuicontact.component.indexlib.suspension;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* loaded from: classes3.dex */
public class SuspensionDecoration extends RecyclerView.ItemDecoration {
    private static int COLOR_TITLE_BG = Color.parseColor("#FFEDEDED");
    private static int COLOR_TITLE_BOTTOM_LINE = Color.parseColor("#FFCACACA");
    private static int COLOR_TITLE_FONT = Color.parseColor("#FF888888");
    private static final String TAG = "SuspensionDecoration";
    private List<? extends ISuspensionInterface> mDatas;
    private int mTitleFontSize;
    private int mTitleHeight;
    private int mHeaderViewCount = 0;
    private Paint mPaint = new Paint();
    private Rect mBounds = new Rect();

    public SuspensionDecoration(Context context, List<? extends ISuspensionInterface> list) {
        this.mDatas = list;
        this.mTitleHeight = (int) TypedValue.applyDimension(1, 33.0f, context.getResources().getDisplayMetrics());
        int applyDimension = (int) TypedValue.applyDimension(2, 13.0f, context.getResources().getDisplayMetrics());
        this.mTitleFontSize = applyDimension;
        this.mPaint.setTextSize(applyDimension);
        this.mPaint.setAntiAlias(true);
    }

    private void drawTitleArea(Canvas canvas, int i2, int i3, View view, RecyclerView.LayoutParams layoutParams, int i4) {
        this.mPaint.setColor(COLOR_TITLE_BG);
        float f2 = i2;
        float f3 = i3;
        canvas.drawRect(f2, (view.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - this.mTitleHeight, f3, view.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, this.mPaint);
        this.mPaint.setColor(COLOR_TITLE_BOTTOM_LINE);
        canvas.drawRect(f2, (view.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - 1, f3, view.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, this.mPaint);
        this.mPaint.setColor(COLOR_TITLE_FONT);
        this.mPaint.getTextBounds(this.mDatas.get(i4).getSuspensionTag(), 0, this.mDatas.get(i4).getSuspensionTag().length(), this.mBounds);
        canvas.drawText(this.mDatas.get(i4).getSuspensionTag(), view.getPaddingLeft() + 61, (view.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - ((this.mTitleHeight / 2) - (this.mBounds.height() / 2)), this.mPaint);
    }

    public int getHeaderViewCount() {
        return this.mHeaderViewCount;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        int viewLayoutPosition = ((RecyclerView.LayoutParams) view.getLayoutParams()).getViewLayoutPosition() - getHeaderViewCount();
        List<? extends ISuspensionInterface> list = this.mDatas;
        if (list == null || list.isEmpty() || viewLayoutPosition > this.mDatas.size() - 1 || viewLayoutPosition <= -1) {
            return;
        }
        ISuspensionInterface iSuspensionInterface = this.mDatas.get(viewLayoutPosition);
        if (iSuspensionInterface.isShowSuspension()) {
            if (viewLayoutPosition == 0) {
                rect.set(0, this.mTitleHeight, 0, 0);
            } else if (iSuspensionInterface.getSuspensionTag() == null || iSuspensionInterface.getSuspensionTag().equals(this.mDatas.get(viewLayoutPosition - 1).getSuspensionTag())) {
            } else {
                rect.set(0, this.mTitleHeight, 0, 0);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        super.onDraw(canvas, recyclerView, state);
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = recyclerView.getChildAt(i2);
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
            int viewLayoutPosition = layoutParams.getViewLayoutPosition() - getHeaderViewCount();
            List<? extends ISuspensionInterface> list = this.mDatas;
            if (list != null && !list.isEmpty() && viewLayoutPosition <= this.mDatas.size() - 1 && viewLayoutPosition >= 0 && this.mDatas.get(viewLayoutPosition).isShowSuspension() && viewLayoutPosition > -1) {
                if (viewLayoutPosition == 0) {
                    drawTitleArea(canvas, paddingLeft, width, childAt, layoutParams, viewLayoutPosition);
                } else if (this.mDatas.get(viewLayoutPosition).getSuspensionTag() != null && !this.mDatas.get(viewLayoutPosition).getSuspensionTag().equals(this.mDatas.get(viewLayoutPosition - 1).getSuspensionTag())) {
                    drawTitleArea(canvas, paddingLeft, width, childAt, layoutParams, viewLayoutPosition);
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        int findFirstVisibleItemPosition = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition() - getHeaderViewCount();
        List<? extends ISuspensionInterface> list = this.mDatas;
        if (list == null || list.isEmpty()) {
            return;
        }
        boolean z = true;
        if (findFirstVisibleItemPosition > this.mDatas.size() - 1 || findFirstVisibleItemPosition < 0 || !this.mDatas.get(findFirstVisibleItemPosition).isShowSuspension()) {
            return;
        }
        String suspensionTag = this.mDatas.get(findFirstVisibleItemPosition).getSuspensionTag();
        View view = recyclerView.findViewHolderForLayoutPosition(getHeaderViewCount() + findFirstVisibleItemPosition).itemView;
        int i2 = findFirstVisibleItemPosition + 1;
        if (i2 >= this.mDatas.size() || suspensionTag == null || suspensionTag.equals(this.mDatas.get(i2).getSuspensionTag()) || view.getHeight() + view.getTop() >= this.mTitleHeight) {
            z = false;
        } else {
            canvas.save();
            canvas.translate(0.0f, (view.getHeight() + view.getTop()) - this.mTitleHeight);
        }
        this.mPaint.setColor(COLOR_TITLE_BG);
        canvas.drawRect(recyclerView.getPaddingLeft(), recyclerView.getPaddingTop(), recyclerView.getRight() - recyclerView.getPaddingRight(), recyclerView.getPaddingTop() + this.mTitleHeight, this.mPaint);
        this.mPaint.setColor(COLOR_TITLE_FONT);
        this.mPaint.getTextBounds(suspensionTag, 0, suspensionTag.length(), this.mBounds);
        int paddingTop = recyclerView.getPaddingTop();
        int i3 = this.mTitleHeight;
        canvas.drawText(suspensionTag, view.getPaddingLeft() + 40, (paddingTop + i3) - ((i3 / 2) - (this.mBounds.height() / 2)), this.mPaint);
        if (z) {
            canvas.restore();
        }
    }

    public SuspensionDecoration setColorTitleBg(int i2) {
        COLOR_TITLE_BG = i2;
        return this;
    }

    public SuspensionDecoration setColorTitleFont(int i2) {
        COLOR_TITLE_FONT = i2;
        return this;
    }

    public SuspensionDecoration setDatas(List<? extends ISuspensionInterface> list) {
        this.mDatas = list;
        return this;
    }

    public SuspensionDecoration setHeaderViewCount(int i2) {
        this.mHeaderViewCount = i2;
        return this;
    }

    public SuspensionDecoration setTitleFontSize(int i2) {
        this.mPaint.setTextSize(i2);
        return this;
    }

    public SuspensionDecoration setTitleHeight(int i2) {
        this.mTitleHeight = i2;
        return this;
    }
}
