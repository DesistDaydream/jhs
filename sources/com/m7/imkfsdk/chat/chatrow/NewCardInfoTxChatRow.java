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
import com.m7.imkfsdk.chat.holder.NewCardInfoTxHolder;
import com.m7.imkfsdk.chat.holder.ViewHolderTag;
import com.m7.imkfsdk.utils.GlideUtil;
import com.moor.imkf.model.entity.FromToMessage;
import com.moor.imkf.model.entity.NewCardInfo;
import e.j.e.t.a;

/* loaded from: classes2.dex */
public class NewCardInfoTxChatRow extends BaseChatRow {
    public NewCardInfoTxChatRow(int i2) {
        super(i2);
    }

    @Override // com.m7.imkfsdk.chat.chatrow.IChatRow
    public View buildChatView(LayoutInflater layoutInflater, View view) {
        if (view == null) {
            View inflate = layoutInflater.inflate(R.layout.ykfsdk_kf_chat_row_new_card_info_click_tx, (ViewGroup) null);
            inflate.setTag(new NewCardInfoTxHolder(this.mRowType).initBaseHolder(inflate, false));
            return inflate;
        }
        return view;
    }

    @Override // com.m7.imkfsdk.chat.chatrow.BaseChatRow
    public void buildChattingData(Context context, BaseHolder baseHolder, FromToMessage fromToMessage, int i2) {
        NewCardInfoTxHolder newCardInfoTxHolder = (NewCardInfoTxHolder) baseHolder;
        if (fromToMessage == null || fromToMessage.newCardInfo == null) {
            return;
        }
        NewCardInfo newCardInfo = (NewCardInfo) new Gson().o(fromToMessage.newCardInfo, new a<NewCardInfo>() { // from class: com.m7.imkfsdk.chat.chatrow.NewCardInfoTxChatRow.1
        }.getType());
        newCardInfoTxHolder.tv_order_title.setText(newCardInfo.getTitle());
        newCardInfoTxHolder.tv_order_.setText(newCardInfo.getSub_title());
        GlideUtil.loadImage(context, newCardInfo.getImg(), 5.0f, newCardInfoTxHolder.iv_order_img);
        View.OnClickListener onClickListener = ((ChatActivity) context).getChatAdapter().getOnClickListener();
        newCardInfoTxHolder.tv_send_order.setTag(ViewHolderTag.createTag(fromToMessage, 8, i2));
        newCardInfoTxHolder.tv_send_order.setOnClickListener(onClickListener);
        newCardInfoTxHolder.ll_order_main.setTag(ViewHolderTag.createTag(newCardInfo.getTarget(), 9));
        newCardInfoTxHolder.ll_order_main.setOnClickListener(onClickListener);
    }

    @Override // com.m7.imkfsdk.chat.chatrow.IChatRow
    public int getChatViewType() {
        return ChatRowType.ORDER_INFO_ROW_TRANSMIT.ordinal();
    }

    @Override // com.m7.imkfsdk.chat.chatrow.BaseChatRow
    public boolean onCreateRowContextMenu(ContextMenu contextMenu, View view, FromToMessage fromToMessage) {
        return false;
    }
}
