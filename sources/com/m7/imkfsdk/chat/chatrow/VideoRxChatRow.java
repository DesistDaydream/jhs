package com.m7.imkfsdk.chat.chatrow;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.m7.imkfsdk.R;
import com.m7.imkfsdk.chat.holder.BaseHolder;
import com.m7.imkfsdk.chat.holder.VideoViewHolder;
import com.moor.imkf.lib.utils.MoorNullUtil;
import com.moor.imkf.model.entity.FromToMessage;
import com.moor.imkf.utils.TimeUtil;

/* loaded from: classes2.dex */
public class VideoRxChatRow extends BaseChatRow {
    private Context context;

    public VideoRxChatRow(int i2) {
        super(i2);
    }

    @Override // com.m7.imkfsdk.chat.chatrow.IChatRow
    public View buildChatView(LayoutInflater layoutInflater, View view) {
        if (view == null) {
            View inflate = layoutInflater.inflate(R.layout.ykfsdk_kf_chat_row_video_rx, (ViewGroup) null);
            inflate.setTag(new VideoViewHolder(this.mRowType).initBaseHolder(inflate, true));
            return inflate;
        }
        return view;
    }

    @Override // com.m7.imkfsdk.chat.chatrow.BaseChatRow
    public void buildChattingData(Context context, BaseHolder baseHolder, FromToMessage fromToMessage, int i2) {
        String str;
        this.context = context;
        VideoViewHolder videoViewHolder = (VideoViewHolder) baseHolder;
        if (fromToMessage != null) {
            if (fromToMessage.withDrawStatus) {
                videoViewHolder.getWithdrawTextView().setVisibility(0);
                videoViewHolder.getContainer().setVisibility(8);
                return;
            }
            videoViewHolder.getWithdrawTextView().setVisibility(8);
            videoViewHolder.getContainer().setVisibility(0);
            if (!"Hangup".equals(MoorNullUtil.checkNull(fromToMessage.videoStatus)) && !"hangup".equals(MoorNullUtil.checkNull(fromToMessage.videoStatus))) {
                if ("cancel".equals(MoorNullUtil.checkNull(fromToMessage.videoStatus))) {
                    videoViewHolder.getDescTextView().setText(context.getString(R.string.ykfsdk_ykf_video_cancle));
                    videoViewHolder.getDescTextView().setTextColor(context.getResources().getColor(R.color.ykfsdk_all_black));
                    videoViewHolder.getVideoIcon().setImageResource(R.drawable.ykfsdk_kf_chatrow_video);
                    return;
                } else if ("refuse".equals(MoorNullUtil.checkNull(fromToMessage.videoStatus))) {
                    videoViewHolder.getDescTextView().setText(context.getString(R.string.ykfsdk_ykf_video_refuse));
                    videoViewHolder.getDescTextView().setTextColor(context.getResources().getColor(R.color.ykfsdk_all_black));
                    videoViewHolder.getVideoIcon().setImageResource(R.drawable.ykfsdk_kf_chatrow_video);
                    return;
                } else {
                    return;
                }
            }
            try {
                str = TimeUtil.getVideoTime(Long.parseLong(MoorNullUtil.checkNull(fromToMessage.message)) / 1000);
            } catch (Exception unused) {
                str = "";
            }
            TextView descTextView = videoViewHolder.getDescTextView();
            descTextView.setText(context.getString(R.string.ykfsdk_ykf_call_time) + str);
            videoViewHolder.getDescTextView().setTextColor(context.getResources().getColor(R.color.ykfsdk_all_black));
            videoViewHolder.getVideoIcon().setImageResource(R.drawable.ykfsdk_kf_chatrow_video);
        }
    }

    @Override // com.m7.imkfsdk.chat.chatrow.IChatRow
    public int getChatViewType() {
        return ChatRowType.VIDEO_ROW_RECEIVED.ordinal();
    }

    @Override // com.m7.imkfsdk.chat.chatrow.BaseChatRow
    public boolean onCreateRowContextMenu(ContextMenu contextMenu, View view, FromToMessage fromToMessage) {
        return false;
    }
}
