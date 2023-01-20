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
import com.moor.imkf.db.dao.MessageDao;
import com.moor.imkf.lib.http.donwload.IMoorOnDownloadListener;
import com.moor.imkf.lib.http.donwload.MoorDownLoadUtils;
import com.moor.imkf.model.entity.FromToMessage;
import java.util.UUID;

/* loaded from: classes2.dex */
public class VoiceRxChatRow extends BaseChatRow {
    private String dirStr;

    public VoiceRxChatRow(int i2) {
        super(i2);
    }

    @Override // com.m7.imkfsdk.chat.chatrow.IChatRow
    public View buildChatView(LayoutInflater layoutInflater, View view) {
        if (view == null) {
            View inflate = layoutInflater.inflate(R.layout.ykfsdk_kf_chat_row_voice_rx, (ViewGroup) null);
            inflate.setTag(new VoiceViewHolder(this.mRowType).initBaseHolder(inflate, true));
            return inflate;
        }
        return view;
    }

    @Override // com.m7.imkfsdk.chat.chatrow.BaseChatRow
    public void buildChattingData(final Context context, BaseHolder baseHolder, final FromToMessage fromToMessage, final int i2) {
        final VoiceViewHolder voiceViewHolder = (VoiceViewHolder) baseHolder;
        if (fromToMessage != null) {
            if (fromToMessage.withDrawStatus) {
                voiceViewHolder.getWithdrawTextView().setVisibility(0);
                voiceViewHolder.getContainer().setVisibility(8);
                return;
            }
            voiceViewHolder.getWithdrawTextView().setVisibility(8);
            voiceViewHolder.getContainer().setVisibility(0);
            String str = fromToMessage.unread2;
            if (str != null && str.equals("1")) {
                voiceViewHolder.voiceUnread.setVisibility(0);
            } else {
                voiceViewHolder.voiceUnread.setVisibility(8);
            }
            String str2 = fromToMessage.filePath;
            if (str2 != null && !str2.equals("")) {
                VoiceViewHolder.initVoiceRow(voiceViewHolder, fromToMessage, i2, (ChatActivity) context, true);
                return;
            }
            fromToMessage.message = fromToMessage.message.replaceAll("https://", "http://");
            MoorDownLoadUtils.loadFile(fromToMessage.message, "7moor_record_" + UUID.randomUUID() + ".amr", new IMoorOnDownloadListener() { // from class: com.m7.imkfsdk.chat.chatrow.VoiceRxChatRow.1
                @Override // com.moor.imkf.lib.http.donwload.IMoorOnDownloadListener
                public void onDownloadFailed() {
                }

                @Override // com.moor.imkf.lib.http.donwload.IMoorOnDownloadListener
                public void onDownloadStart() {
                }

                @Override // com.moor.imkf.lib.http.donwload.IMoorOnDownloadListener
                public void onDownloadSuccess(final String str3) {
                    ((ChatActivity) context).runOnUiThread(new Runnable() { // from class: com.m7.imkfsdk.chat.chatrow.VoiceRxChatRow.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            fromToMessage.filePath = str3;
                            MessageDao.getInstance().updateMsgToDao(fromToMessage);
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            VoiceViewHolder.initVoiceRow(voiceViewHolder, fromToMessage, i2, (ChatActivity) context, true);
                        }
                    });
                }

                @Override // com.moor.imkf.lib.http.donwload.IMoorOnDownloadListener
                public void onDownloading(int i3) {
                }
            });
        }
    }

    @Override // com.m7.imkfsdk.chat.chatrow.IChatRow
    public int getChatViewType() {
        return ChatRowType.VOICE_ROW_RECEIVED.ordinal();
    }

    @Override // com.m7.imkfsdk.chat.chatrow.BaseChatRow
    public boolean onCreateRowContextMenu(ContextMenu contextMenu, View view, FromToMessage fromToMessage) {
        return false;
    }
}
