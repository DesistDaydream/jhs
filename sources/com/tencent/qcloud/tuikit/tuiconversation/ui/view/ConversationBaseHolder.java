package com.tencent.qcloud.tuikit.tuiconversation.ui.view;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.qcloud.tuikit.tuiconversation.bean.ConversationInfo;

/* loaded from: classes3.dex */
public abstract class ConversationBaseHolder extends RecyclerView.ViewHolder {
    public ConversationListAdapter mAdapter;
    public View rootView;

    public ConversationBaseHolder(View view) {
        super(view);
        this.rootView = view;
    }

    public abstract void layoutViews(ConversationInfo conversationInfo, int i2);

    public void setAdapter(RecyclerView.Adapter adapter) {
        this.mAdapter = (ConversationListAdapter) adapter;
    }
}
