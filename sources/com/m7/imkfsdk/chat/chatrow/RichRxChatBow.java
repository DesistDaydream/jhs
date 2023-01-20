package com.m7.imkfsdk.chat.chatrow;

import android.content.Context;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.m7.imkfsdk.MoorWebCenter;
import com.m7.imkfsdk.R;
import com.m7.imkfsdk.chat.holder.BaseHolder;
import com.m7.imkfsdk.chat.holder.RichViewHolder;
import com.m7.imkfsdk.utils.GlideUtil;
import com.moor.imkf.model.entity.FromToMessage;

/* loaded from: classes2.dex */
public class RichRxChatBow extends BaseChatRow {
    public RichRxChatBow(int i2) {
        super(i2);
    }

    @Override // com.m7.imkfsdk.chat.chatrow.IChatRow
    public View buildChatView(LayoutInflater layoutInflater, View view) {
        if (view == null) {
            View inflate = layoutInflater.inflate(R.layout.ykfsdk_kf_chat_row_rich_rx, (ViewGroup) null);
            inflate.setTag(new RichViewHolder(this.mRowType).initBaseHolder(inflate, true));
            return inflate;
        }
        return view;
    }

    @Override // com.m7.imkfsdk.chat.chatrow.BaseChatRow
    public void buildChattingData(final Context context, BaseHolder baseHolder, final FromToMessage fromToMessage, int i2) {
        RichViewHolder richViewHolder = (RichViewHolder) baseHolder;
        if (fromToMessage != null) {
            if (fromToMessage.withDrawStatus) {
                richViewHolder.getWithdrawTextView().setVisibility(0);
                richViewHolder.getContainer().setVisibility(8);
                return;
            }
            richViewHolder.getWithdrawTextView().setVisibility(8);
            richViewHolder.getContainer().setVisibility(0);
            richViewHolder.getTitle().setText(fromToMessage.richTextTitle);
            richViewHolder.getTitle().getPaint().setFlags(8);
            richViewHolder.getContent().setText(fromToMessage.richTextDescription);
            if (fromToMessage.richTextPicUrl.equals("")) {
                richViewHolder.getImageView().setVisibility(4);
            } else {
                richViewHolder.getImageView().setVisibility(0);
            }
            GlideUtil.loadImage(context, fromToMessage.richTextPicUrl + "?imageView2/0/w/200/h/140", richViewHolder.getImageView());
            richViewHolder.getKf_chat_rich_lin().setOnClickListener(new View.OnClickListener() { // from class: com.m7.imkfsdk.chat.chatrow.RichRxChatBow.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Intent intent = new Intent(context, MoorWebCenter.class);
                    intent.putExtra("OpenUrl", fromToMessage.richTextUrl);
                    intent.putExtra("titleName", fromToMessage.richTextTitle);
                    context.startActivity(intent);
                }
            });
        }
    }

    @Override // com.m7.imkfsdk.chat.chatrow.IChatRow
    public int getChatViewType() {
        return ChatRowType.RICHTEXT_ROW_RECEIVED.ordinal();
    }

    @Override // com.m7.imkfsdk.chat.chatrow.BaseChatRow
    public boolean onCreateRowContextMenu(ContextMenu contextMenu, View view, FromToMessage fromToMessage) {
        return false;
    }
}
