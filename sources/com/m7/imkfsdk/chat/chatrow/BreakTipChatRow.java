package com.m7.imkfsdk.chat.chatrow;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.m7.imkfsdk.R;
import com.m7.imkfsdk.chat.holder.BaseHolder;
import com.m7.imkfsdk.chat.holder.BreakTipHolder;
import com.moor.imkf.lib.utils.MoorNullUtil;
import com.moor.imkf.model.entity.FromToMessage;

/* loaded from: classes2.dex */
public class BreakTipChatRow extends BaseChatRow {
    public BreakTipChatRow(int i2) {
        super(i2);
    }

    @Override // com.m7.imkfsdk.chat.chatrow.IChatRow
    public View buildChatView(LayoutInflater layoutInflater, View view) {
        if (view == null) {
            View inflate = layoutInflater.inflate(R.layout.ykfsdk_kf_chat_row_break_tip_rx, (ViewGroup) null);
            inflate.setTag(new BreakTipHolder(this.mRowType).initBaseHolder(inflate, false));
            return inflate;
        }
        return view;
    }

    @Override // com.m7.imkfsdk.chat.chatrow.BaseChatRow
    public void buildChattingData(Context context, BaseHolder baseHolder, FromToMessage fromToMessage, int i2) {
        BreakTipHolder breakTipHolder = (BreakTipHolder) baseHolder;
        if (fromToMessage != null) {
            breakTipHolder.getDescTextView().setText(MoorNullUtil.checkNull(fromToMessage.message));
        }
    }

    @Override // com.m7.imkfsdk.chat.chatrow.IChatRow
    public int getChatViewType() {
        return ChatRowType.BREAK_TIP_ROW_RECEIVED.ordinal();
    }

    @Override // com.m7.imkfsdk.chat.chatrow.BaseChatRow
    public boolean onCreateRowContextMenu(ContextMenu contextMenu, View view, FromToMessage fromToMessage) {
        return false;
    }
}
