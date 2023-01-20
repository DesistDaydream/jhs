package com.m7.imkfsdk.chat.chatrow;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.m7.imkfsdk.R;
import com.m7.imkfsdk.chat.ChatActivity;
import com.m7.imkfsdk.chat.holder.BaseHolder;
import com.m7.imkfsdk.chat.holder.InvestigateCancelViewHolder;
import com.m7.imkfsdk.chat.holder.ViewHolderTag;
import com.moor.imkf.model.entity.FromToMessage;

/* loaded from: classes2.dex */
public class InvestigateCancelRxChatRow extends BaseChatRow {
    public InvestigateCancelRxChatRow(int i2) {
        super(i2);
    }

    @Override // com.m7.imkfsdk.chat.chatrow.IChatRow
    public View buildChatView(LayoutInflater layoutInflater, View view) {
        if (view == null) {
            View inflate = layoutInflater.inflate(R.layout.ykfsdk_kf_chat_row_investigate_canlel_rx, (ViewGroup) null);
            inflate.setTag(new InvestigateCancelViewHolder(this.mRowType).initBaseHolder(inflate, true));
            return inflate;
        }
        return view;
    }

    @Override // com.m7.imkfsdk.chat.chatrow.BaseChatRow
    public void buildChattingData(Context context, BaseHolder baseHolder, FromToMessage fromToMessage, int i2) {
        InvestigateCancelViewHolder investigateCancelViewHolder = (InvestigateCancelViewHolder) baseHolder;
        if (fromToMessage != null) {
            View.OnClickListener onClickListener = ((ChatActivity) context).getChatAdapter().getOnClickListener();
            investigateCancelViewHolder.chatting_tv_to_investigate.setTag(ViewHolderTag.createTag(fromToMessage, 15, i2));
            investigateCancelViewHolder.chatting_tv_to_investigate.setOnClickListener(onClickListener);
        }
    }

    @Override // com.m7.imkfsdk.chat.chatrow.IChatRow
    public int getChatViewType() {
        return ChatRowType.INVESTIGATE_CANCEL_RECEIVED.ordinal();
    }

    @Override // com.m7.imkfsdk.chat.chatrow.BaseChatRow
    public boolean onCreateRowContextMenu(ContextMenu contextMenu, View view, FromToMessage fromToMessage) {
        return false;
    }
}
