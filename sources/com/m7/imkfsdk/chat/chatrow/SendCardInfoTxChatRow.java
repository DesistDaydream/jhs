package com.m7.imkfsdk.chat.chatrow;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.gson.Gson;
import com.m7.imkfsdk.R;
import com.m7.imkfsdk.chat.ChatActivity;
import com.m7.imkfsdk.chat.holder.BaseHolder;
import com.m7.imkfsdk.chat.holder.SendCardInfoTxHolder;
import com.m7.imkfsdk.chat.holder.ViewHolderTag;
import com.m7.imkfsdk.utils.GlideUtil;
import com.moor.imkf.model.entity.FromToMessage;
import com.moor.imkf.model.entity.NewCardInfo;
import e.j.e.t.a;

/* loaded from: classes2.dex */
public class SendCardInfoTxChatRow extends BaseChatRow {
    public SendCardInfoTxChatRow(int i2) {
        super(i2);
    }

    @Override // com.m7.imkfsdk.chat.chatrow.IChatRow
    public View buildChatView(LayoutInflater layoutInflater, View view) {
        if (view == null) {
            View inflate = layoutInflater.inflate(R.layout.ykfsdk_kf_chat_row_newcard_info_tx, (ViewGroup) null);
            inflate.setTag(new SendCardInfoTxHolder(this.mRowType).initBaseHolder(inflate, false));
            return inflate;
        }
        return view;
    }

    @Override // com.m7.imkfsdk.chat.chatrow.BaseChatRow
    public void buildChattingData(Context context, BaseHolder baseHolder, FromToMessage fromToMessage, int i2) {
        SendCardInfoTxHolder sendCardInfoTxHolder = (SendCardInfoTxHolder) baseHolder;
        if (fromToMessage == null || fromToMessage.newCardInfo == null) {
            return;
        }
        NewCardInfo newCardInfo = (NewCardInfo) new Gson().o(fromToMessage.newCardInfo, new a<NewCardInfo>() { // from class: com.m7.imkfsdk.chat.chatrow.SendCardInfoTxChatRow.1
        }.getType());
        sendCardInfoTxHolder.tv_child_title.setText(newCardInfo.getTitle());
        sendCardInfoTxHolder.tv_child_.setText(newCardInfo.getSub_title());
        GlideUtil.loadImage(context, newCardInfo.getImg(), 8.0f, sendCardInfoTxHolder.iv_child_img);
        View.OnClickListener onClickListener = ((ChatActivity) context).getChatAdapter().getOnClickListener();
        sendCardInfoTxHolder.kf_chat_rich_lin.setTag(ViewHolderTag.createTag(newCardInfo.getTarget(), 9));
        sendCardInfoTxHolder.kf_chat_rich_lin.setOnClickListener(onClickListener);
        BaseChatRow.getMsgStateResId(i2, sendCardInfoTxHolder, fromToMessage, onClickListener);
    }

    @Override // com.m7.imkfsdk.chat.chatrow.IChatRow
    public int getChatViewType() {
        return ChatRowType.SEND_ORDER_INFO_ROW_TRANSMIT.ordinal();
    }

    @Override // com.m7.imkfsdk.chat.chatrow.BaseChatRow
    public boolean onCreateRowContextMenu(ContextMenu contextMenu, View view, FromToMessage fromToMessage) {
        return false;
    }
}
