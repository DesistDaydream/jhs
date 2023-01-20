package com.tencent.qcloud.tuikit.tuiconversation.ui.interfaces;

import com.tencent.qcloud.tuikit.tuiconversation.ui.view.ConversationListAdapter;
import com.tencent.qcloud.tuikit.tuiconversation.ui.view.ConversationListLayout;

/* loaded from: classes3.dex */
public interface IConversationListLayout {
    void disableItemUnreadDot(boolean z);

    ConversationListAdapter getAdapter();

    ConversationListLayout getListLayout();

    void setAdapter(IConversationListAdapter iConversationListAdapter);

    void setBackground(int i2);

    void setItemAvatarRadius(int i2);

    void setItemBottomTextSize(int i2);

    void setItemDateTextSize(int i2);

    void setItemTopTextSize(int i2);

    void setOnItemClickListener(ConversationListLayout.OnItemClickListener onItemClickListener);

    void setOnItemLongClickListener(ConversationListLayout.OnItemLongClickListener onItemLongClickListener);
}
