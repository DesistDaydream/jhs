package com.m7.imkfsdk.chat.chatrow;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.m7.imkfsdk.R;
import com.m7.imkfsdk.chat.ChatActivity;
import com.m7.imkfsdk.chat.holder.BaseHolder;
import com.m7.imkfsdk.chat.holder.VoiceViewHolder;
import com.moor.imkf.model.entity.FromToMessage;

/* loaded from: classes2.dex */
public class VoiceTxChatRow extends BaseChatRow {
    public VoiceTxChatRow(int i2) {
        super(i2);
    }

    @Override // com.m7.imkfsdk.chat.chatrow.IChatRow
    public View buildChatView(LayoutInflater layoutInflater, View view) {
        if (view == null) {
            View inflate = layoutInflater.inflate(R.layout.ykfsdk_kf_chat_row_voice_tx, (ViewGroup) null);
            inflate.setTag(new VoiceViewHolder(this.mRowType).initBaseHolder(inflate, false));
            return inflate;
        }
        return view;
    }

    @Override // com.m7.imkfsdk.chat.chatrow.BaseChatRow
    public void buildChattingData(Context context, BaseHolder baseHolder, FromToMessage fromToMessage, int i2) {
        VoiceViewHolder voiceViewHolder = (VoiceViewHolder) baseHolder;
        if (fromToMessage != null) {
            ChatActivity chatActivity = (ChatActivity) context;
            VoiceViewHolder.initVoiceRow(voiceViewHolder, fromToMessage, i2, chatActivity, false);
            BaseChatRow.getMsgStateResId(i2, voiceViewHolder, fromToMessage, chatActivity.getChatAdapter().getOnClickListener());
        }
    }

    @Override // com.m7.imkfsdk.chat.chatrow.IChatRow
    public int getChatViewType() {
        return ChatRowType.VOICE_ROW_TRANSMIT.ordinal();
    }

    @Override // com.m7.imkfsdk.chat.chatrow.BaseChatRow
    public boolean onCreateRowContextMenu(ContextMenu contextMenu, View view, FromToMessage fromToMessage) {
        return false;
    }
}
