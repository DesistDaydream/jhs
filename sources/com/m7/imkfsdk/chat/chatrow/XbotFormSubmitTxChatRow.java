package com.m7.imkfsdk.chat.chatrow;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.m7.imkfsdk.R;
import com.m7.imkfsdk.chat.ChatActivity;
import com.m7.imkfsdk.chat.holder.BaseHolder;
import com.m7.imkfsdk.chat.holder.TextViewHolder;
import com.m7.imkfsdk.view.PopupWindowList;
import com.moor.imkf.model.entity.FromToMessage;

/* loaded from: classes2.dex */
public class XbotFormSubmitTxChatRow extends BaseChatRow {
    private Context context;
    private PopupWindowList mPopupWindowList;

    public XbotFormSubmitTxChatRow(int i2) {
        super(i2);
    }

    @Override // com.m7.imkfsdk.chat.chatrow.IChatRow
    public View buildChatView(LayoutInflater layoutInflater, View view) {
        if (view == null) {
            View inflate = layoutInflater.inflate(R.layout.ykfsdk_kf_chat_row_xbot_submit_tx, (ViewGroup) null);
            inflate.setTag(new TextViewHolder(this.mRowType).initBaseHolder(inflate, false));
            return inflate;
        }
        return view;
    }

    @Override // com.m7.imkfsdk.chat.chatrow.BaseChatRow
    public void buildChattingData(Context context, BaseHolder baseHolder, FromToMessage fromToMessage, int i2) {
        this.context = context;
        TextViewHolder textViewHolder = (TextViewHolder) baseHolder;
        if (fromToMessage != null) {
            BaseChatRow.getMsgStateResId(i2, textViewHolder, fromToMessage, ((ChatActivity) context).getChatAdapter().getOnClickListener());
        }
    }

    @Override // com.m7.imkfsdk.chat.chatrow.IChatRow
    public int getChatViewType() {
        return ChatRowType.XBOT_FORM_DATA_SUBMIT.ordinal();
    }

    @Override // com.m7.imkfsdk.chat.chatrow.BaseChatRow
    public boolean onCreateRowContextMenu(ContextMenu contextMenu, View view, FromToMessage fromToMessage) {
        return false;
    }
}
