package com.m7.imkfsdk.chat.chatrow;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.m7.imkfsdk.R;
import com.m7.imkfsdk.chat.ChatActivity;
import com.m7.imkfsdk.chat.holder.BaseHolder;
import com.m7.imkfsdk.chat.holder.RichViewHolder;
import com.m7.imkfsdk.utils.GlideUtil;
import com.moor.imkf.model.entity.CardInfo;
import com.moor.imkf.model.entity.FromToMessage;
import com.moor.imkf.model.parser.HttpParser;

/* loaded from: classes2.dex */
public class RichTxChatBox extends BaseChatRow {
    public RichTxChatBox(int i2) {
        super(i2);
    }

    @Override // com.m7.imkfsdk.chat.chatrow.IChatRow
    public View buildChatView(LayoutInflater layoutInflater, View view) {
        if (view == null) {
            View inflate = layoutInflater.inflate(R.layout.ykfsdk_kf_chat_row_rich_tx, (ViewGroup) null);
            inflate.setTag(new RichViewHolder(this.mRowType).initBaseHolder(inflate, true));
            return inflate;
        }
        return view;
    }

    @Override // com.m7.imkfsdk.chat.chatrow.BaseChatRow
    public void buildChattingData(final Context context, BaseHolder baseHolder, FromToMessage fromToMessage, int i2) {
        RichViewHolder richViewHolder = (RichViewHolder) baseHolder;
        if (fromToMessage != null) {
            final CardInfo cardInfo = HttpParser.getCardInfo(fromToMessage.cardInfo, 0);
            richViewHolder.getWithdrawTextView().setVisibility(8);
            richViewHolder.getContainer().setVisibility(0);
            richViewHolder.getTitle().setText(cardInfo.title);
            richViewHolder.getContent().setText(cardInfo.concent);
            richViewHolder.getName().setText(cardInfo.name);
            if (cardInfo.icon.equals("")) {
                richViewHolder.getImageView().setVisibility(8);
            } else {
                richViewHolder.getImageView().setVisibility(0);
            }
            GlideUtil.loadImage(context, cardInfo.icon, richViewHolder.getImageView());
            richViewHolder.getKf_chat_rich_lin().setOnClickListener(new View.OnClickListener() { // from class: com.m7.imkfsdk.chat.chatrow.RichTxChatBox.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    try {
                        Intent intent = new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        intent.setData(Uri.parse(cardInfo.url));
                        context.startActivity(intent);
                    } catch (Exception unused) {
                    }
                }
            });
            BaseChatRow.getMsgStateResId(i2, richViewHolder, fromToMessage, ((ChatActivity) context).getChatAdapter().getOnClickListener());
        }
    }

    @Override // com.m7.imkfsdk.chat.chatrow.IChatRow
    public int getChatViewType() {
        return ChatRowType.RICHTEXT_ROW_TRANSMIT.ordinal();
    }

    @Override // com.m7.imkfsdk.chat.chatrow.BaseChatRow
    public boolean onCreateRowContextMenu(ContextMenu contextMenu, View view, FromToMessage fromToMessage) {
        return false;
    }
}
