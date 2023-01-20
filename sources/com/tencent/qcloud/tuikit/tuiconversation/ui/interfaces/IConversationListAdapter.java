package com.tencent.qcloud.tuikit.tuiconversation.ui.interfaces;

import com.tencent.qcloud.tuikit.tuiconversation.bean.ConversationInfo;
import java.util.List;

/* loaded from: classes3.dex */
public interface IConversationListAdapter {
    ConversationInfo getItem(int i2);

    void onDataSourceChanged(List<ConversationInfo> list);

    void onItemChanged(int i2);

    void onItemInserted(int i2);

    void onItemRangeChanged(int i2, int i3);

    void onItemRemoved(int i2);

    void onLoadingStateChanged(boolean z);

    void onViewNeedRefresh();
}
