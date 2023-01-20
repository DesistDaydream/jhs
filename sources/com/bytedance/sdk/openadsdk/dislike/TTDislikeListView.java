package com.bytedance.sdk.openadsdk.dislike;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.TTDislikeController;

/* loaded from: classes.dex */
public class TTDislikeListView extends ListView {
    private TTDislikeController mDislikeController;
    private AdapterView.OnItemClickListener mOnItemClickListener;
    private AdapterView.OnItemClickListener mOnItemClickListenerInner;

    public TTDislikeListView(Context context) {
        super(context);
        this.mOnItemClickListenerInner = new AdapterView.OnItemClickListener() { // from class: com.bytedance.sdk.openadsdk.dislike.TTDislikeListView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                if (TTDislikeListView.this.getAdapter() != null && TTDislikeListView.this.getAdapter().getItem(i2) != null && (TTDislikeListView.this.getAdapter().getItem(i2) instanceof FilterWord)) {
                    FilterWord filterWord = (FilterWord) TTDislikeListView.this.getAdapter().getItem(i2);
                    if (filterWord.hasSecondOptions()) {
                        return;
                    }
                    if (TTDislikeListView.this.mDislikeController != null) {
                        TTDislikeListView.this.mDislikeController.onDislikeSelected(filterWord);
                    }
                    if (TTDislikeListView.this.mOnItemClickListener != null) {
                        TTDislikeListView.this.mOnItemClickListener.onItemClick(adapterView, view, i2, j2);
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("adapter数据异常，必须为FilterWord");
            }
        };
        init();
    }

    private void init() {
        super.setOnItemClickListener(this.mOnItemClickListenerInner);
    }

    public void setDislikeInfo(TTDislikeController tTDislikeController) {
        this.mDislikeController = tTDislikeController;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public TTDislikeListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mOnItemClickListenerInner = new AdapterView.OnItemClickListener() { // from class: com.bytedance.sdk.openadsdk.dislike.TTDislikeListView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                if (TTDislikeListView.this.getAdapter() != null && TTDislikeListView.this.getAdapter().getItem(i2) != null && (TTDislikeListView.this.getAdapter().getItem(i2) instanceof FilterWord)) {
                    FilterWord filterWord = (FilterWord) TTDislikeListView.this.getAdapter().getItem(i2);
                    if (filterWord.hasSecondOptions()) {
                        return;
                    }
                    if (TTDislikeListView.this.mDislikeController != null) {
                        TTDislikeListView.this.mDislikeController.onDislikeSelected(filterWord);
                    }
                    if (TTDislikeListView.this.mOnItemClickListener != null) {
                        TTDislikeListView.this.mOnItemClickListener.onItemClick(adapterView, view, i2, j2);
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("adapter数据异常，必须为FilterWord");
            }
        };
        init();
    }

    public TTDislikeListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mOnItemClickListenerInner = new AdapterView.OnItemClickListener() { // from class: com.bytedance.sdk.openadsdk.dislike.TTDislikeListView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i22, long j2) {
                if (TTDislikeListView.this.getAdapter() != null && TTDislikeListView.this.getAdapter().getItem(i22) != null && (TTDislikeListView.this.getAdapter().getItem(i22) instanceof FilterWord)) {
                    FilterWord filterWord = (FilterWord) TTDislikeListView.this.getAdapter().getItem(i22);
                    if (filterWord.hasSecondOptions()) {
                        return;
                    }
                    if (TTDislikeListView.this.mDislikeController != null) {
                        TTDislikeListView.this.mDislikeController.onDislikeSelected(filterWord);
                    }
                    if (TTDislikeListView.this.mOnItemClickListener != null) {
                        TTDislikeListView.this.mOnItemClickListener.onItemClick(adapterView, view, i22, j2);
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("adapter数据异常，必须为FilterWord");
            }
        };
        init();
    }
}
