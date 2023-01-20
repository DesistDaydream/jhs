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
import com.m7.imkfsdk.chat.holder.CardViewHolder;
import com.m7.imkfsdk.chat.holder.ViewHolderTag;
import com.m7.imkfsdk.utils.GlideUtil;
import com.moor.imkf.model.entity.CardInfo;
import com.moor.imkf.model.entity.FromToMessage;
import com.moor.imkf.model.parser.HttpParser;

/* loaded from: classes2.dex */
public class CardRxChatBox extends BaseChatRow {
    public CardRxChatBox(int i2) {
        super(i2);
    }

    @Override // com.m7.imkfsdk.chat.chatrow.IChatRow
    public View buildChatView(LayoutInflater layoutInflater, View view) {
        if (view == null) {
            View inflate = layoutInflater.inflate(R.layout.ykfsdk_kf_chat_row_card, (ViewGroup) null);
            inflate.setTag(new CardViewHolder(this.mRowType).initBaseHolder(inflate, true));
            return inflate;
        }
        return view;
    }

    @Override // com.m7.imkfsdk.chat.chatrow.BaseChatRow
    public void buildChattingData(final Context context, BaseHolder baseHolder, FromToMessage fromToMessage, int i2) {
        CardViewHolder cardViewHolder = (CardViewHolder) baseHolder;
        if (fromToMessage != null) {
            final CardInfo cardInfo = HttpParser.getCardInfo(fromToMessage.cardInfo, 0);
            GlideUtil.loadImage(context, cardInfo.icon, 5.0f, cardViewHolder.getIcon());
            cardViewHolder.getMame().setText(cardInfo.name);
            cardViewHolder.getTitle().setText(cardInfo.title);
            cardViewHolder.getContent().setText(cardInfo.concent);
            cardViewHolder.getRelativeLayout().setOnClickListener(new View.OnClickListener() { // from class: com.m7.imkfsdk.chat.chatrow.CardRxChatBox.1
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
            View.OnClickListener onClickListener = ((ChatActivity) context).getChatAdapter().getOnClickListener();
            cardViewHolder.getSend().setTag(ViewHolderTag.createTag(fromToMessage, 7, i2));
            cardViewHolder.getSend().setOnClickListener(onClickListener);
        }
    }

    @Override // com.m7.imkfsdk.chat.chatrow.IChatRow
    public int getChatViewType() {
        return ChatRowType.CARDINFO_ROW_TRANSMIT.ordinal();
    }

    @Override // com.m7.imkfsdk.chat.chatrow.BaseChatRow
    public boolean onCreateRowContextMenu(ContextMenu contextMenu, View view, FromToMessage fromToMessage) {
        return false;
    }
}
