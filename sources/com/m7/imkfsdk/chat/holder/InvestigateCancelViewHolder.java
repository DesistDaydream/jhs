package com.m7.imkfsdk.chat.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.m7.imkfsdk.R;

/* loaded from: classes2.dex */
public class InvestigateCancelViewHolder extends BaseHolder {
    public TextView chatting_tv_to_investigate;
    public TextView contentTv;
    public TextView tv_investigate_content;

    public InvestigateCancelViewHolder(int i2) {
        super(i2);
    }

    public BaseHolder initBaseHolder(View view, boolean z) {
        super.initBaseHolder(view);
        this.chattingTime = (TextView) view.findViewById(R.id.chatting_time_tv);
        if (!z) {
            this.tv_investigate_content = (TextView) view.findViewById(R.id.tv_investigate_content);
        } else {
            this.chatting_tv_to_investigate = (TextView) view.findViewById(R.id.chatting_tv_to_investigate);
            this.uploadState = (ImageView) view.findViewById(R.id.chatting_state_iv);
            this.contentTv = (TextView) view.findViewById(R.id.chatting_content_itv);
        }
        return this;
    }
}
