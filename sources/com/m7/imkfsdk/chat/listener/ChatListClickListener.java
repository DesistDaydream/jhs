package com.m7.imkfsdk.chat.listener;

import android.view.View;
import com.m7.imkfsdk.chat.ChatActivity;
import com.m7.imkfsdk.chat.adapter.ChatAdapter;
import com.m7.imkfsdk.chat.holder.ViewHolderTag;
import com.m7.imkfsdk.utils.MediaPlayTools;
import com.moor.imkf.db.dao.MessageDao;
import com.moor.imkf.model.entity.FromToMessage;

/* loaded from: classes2.dex */
public class ChatListClickListener implements View.OnClickListener, View.OnLongClickListener {
    private ChatActivity mContext;

    public ChatListClickListener(ChatActivity chatActivity, String str) {
        this.mContext = chatActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewHolderTag viewHolderTag = (ViewHolderTag) view.getTag();
        FromToMessage fromToMessage = viewHolderTag.detail;
        int i2 = viewHolderTag.type;
        if (i2 != 2) {
            if (i2 != 4) {
                switch (i2) {
                    case 7:
                        this.mContext.sendCardMsg(fromToMessage, FromToMessage.MSG_TYPE_CARDINFO);
                        return;
                    case 8:
                        this.mContext.sendCardMsg(fromToMessage, FromToMessage.MSG_TYPE_NEW_CARD_INFO);
                        return;
                    case 9:
                    case 12:
                    case 14:
                        this.mContext.handleOnClickOfLogisticsShop(viewHolderTag.target);
                        return;
                    case 10:
                        this.mContext.handleOnClickOfLogisticsItem(viewHolderTag._id, viewHolderTag.current, viewHolderTag.orderInfoBean);
                        return;
                    case 11:
                        this.mContext.handleOnClickOfLogisticsMore(viewHolderTag.target, viewHolderTag._id);
                        return;
                    case 13:
                        this.mContext.handleOnClickOfLogisticsProgressMore(fromToMessage);
                        return;
                    case 15:
                        this.mContext.dealCancelInvestigateClick(fromToMessage);
                        return;
                    case 16:
                        this.mContext.handleTab_QusetionMoreClick(viewHolderTag.tabtitle, viewHolderTag.tabquestions);
                        return;
                    default:
                        return;
                }
            }
            this.mContext.resendMsg(fromToMessage, viewHolderTag.position);
        } else if (fromToMessage == null) {
        } else {
            MediaPlayTools mediaPlayTools = MediaPlayTools.getInstance();
            final ChatAdapter chatAdapter = this.mContext.getChatAdapter();
            if (mediaPlayTools.isPlaying()) {
                mediaPlayTools.stop();
            }
            if (chatAdapter.mVoicePosition == viewHolderTag.position) {
                chatAdapter.mVoicePosition = -1;
                chatAdapter.notifyDataSetChanged();
                return;
            }
            String str = fromToMessage.unread2;
            if (str != null && str.equals("1")) {
                fromToMessage.unread2 = "0";
                viewHolderTag.holder.voiceUnread.setVisibility(8);
            }
            MessageDao.getInstance().updateMsgToDao(fromToMessage);
            chatAdapter.notifyDataSetChanged();
            mediaPlayTools.setOnVoicePlayCompletionListener(new MediaPlayTools.OnVoicePlayCompletionListener() { // from class: com.m7.imkfsdk.chat.listener.ChatListClickListener.1
                @Override // com.m7.imkfsdk.utils.MediaPlayTools.OnVoicePlayCompletionListener
                public void OnVoicePlayCompletion() {
                    ChatAdapter chatAdapter2 = chatAdapter;
                    chatAdapter2.mVoicePosition = -1;
                    chatAdapter2.notifyDataSetChanged();
                }
            });
            mediaPlayTools.playVoice(viewHolderTag.detail.filePath, false);
            chatAdapter.setVoicePosition(viewHolderTag.position);
            chatAdapter.notifyDataSetChanged();
        }
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        FromToMessage fromToMessage = ((ViewHolderTag) view.getTag()).detail;
        return true;
    }
}
