package com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;

/* loaded from: classes3.dex */
public class MessageHeaderHolder extends MessageBaseHolder {
    private boolean mLoading;

    public MessageHeaderHolder(View view) {
        super(view);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.MessageBaseHolder
    public int getVariableLayout() {
        return 0;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.MessageBaseHolder
    public void layoutViews(TUIMessageBean tUIMessageBean, int i2) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) this.itemView.getLayoutParams();
        if (this.mLoading) {
            ((ViewGroup.MarginLayoutParams) layoutParams).height = -2;
            ((ViewGroup.MarginLayoutParams) layoutParams).width = -1;
            this.itemView.setVisibility(0);
        } else {
            ((ViewGroup.MarginLayoutParams) layoutParams).height = 0;
            ((ViewGroup.MarginLayoutParams) layoutParams).width = 0;
            this.itemView.setVisibility(8);
        }
        this.itemView.setLayoutParams(layoutParams);
    }

    public void setLoadingStatus(boolean z) {
        this.mLoading = z;
    }
}
