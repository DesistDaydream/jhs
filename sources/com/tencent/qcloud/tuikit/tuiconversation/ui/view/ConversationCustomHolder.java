package com.tencent.qcloud.tuikit.tuiconversation.ui.view;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.qcloud.tuikit.tuiconversation.R;
import com.tencent.qcloud.tuikit.tuiconversation.bean.ConversationInfo;

/* loaded from: classes3.dex */
public class ConversationCustomHolder extends ConversationBaseHolder {
    public ConversationIconView conversationIconView;
    public LinearLayout leftItemLayout;
    public TextView messageText;
    public TextView timelineText;
    public TextView titleText;
    public TextView unreadText;

    public ConversationCustomHolder(View view) {
        super(view);
        this.leftItemLayout = (LinearLayout) this.rootView.findViewById(R.id.item_left);
        this.conversationIconView = (ConversationIconView) this.rootView.findViewById(R.id.conversation_icon);
        this.titleText = (TextView) this.rootView.findViewById(R.id.conversation_title);
        this.messageText = (TextView) this.rootView.findViewById(R.id.conversation_last_msg);
        this.timelineText = (TextView) this.rootView.findViewById(R.id.conversation_time);
        this.unreadText = (TextView) this.rootView.findViewById(R.id.conversation_unread);
    }

    @Override // com.tencent.qcloud.tuikit.tuiconversation.ui.view.ConversationBaseHolder
    public void layoutViews(ConversationInfo conversationInfo, int i2) {
        if (conversationInfo.isTop()) {
            this.leftItemLayout.setBackgroundColor(this.rootView.getResources().getColor(R.color.conversation_item_top_color));
        } else {
            this.leftItemLayout.setBackgroundColor(-1);
        }
        this.conversationIconView.setConversation(conversationInfo);
        this.titleText.setText(conversationInfo.getTitle());
        this.messageText.setText("");
        this.timelineText.setText("");
        if (conversationInfo.getUnRead() > 0) {
            this.unreadText.setVisibility(0);
            if (conversationInfo.getUnRead() > 99) {
                this.unreadText.setText("99+");
            } else {
                TextView textView = this.unreadText;
                textView.setText("" + conversationInfo.getUnRead());
            }
        } else {
            this.unreadText.setVisibility(8);
        }
        if (this.mAdapter.getItemDateTextSize() != 0) {
            this.timelineText.setTextSize(this.mAdapter.getItemDateTextSize());
        }
        if (this.mAdapter.getItemBottomTextSize() != 0) {
            this.messageText.setTextSize(this.mAdapter.getItemBottomTextSize());
        }
        if (this.mAdapter.getItemTopTextSize() != 0) {
            this.titleText.setTextSize(this.mAdapter.getItemTopTextSize());
        }
    }
}
