package com.tencent.qcloud.tuikit.tuichat.ui.interfaces;

import com.tencent.qcloud.tuikit.tuichat.component.popmenu.ChatPopMenu;
import com.tencent.qcloud.tuikit.tuichat.ui.view.message.MessageAdapter;
import java.util.List;

/* loaded from: classes3.dex */
public interface IMessageLayout extends IMessageProperties {
    void addPopAction(ChatPopMenu.ChatPopMenuAction chatPopMenuAction);

    OnItemClickListener getOnItemClickListener();

    List<ChatPopMenu.ChatPopMenuAction> getPopActions();

    void setAdapter(MessageAdapter messageAdapter);

    void setOnItemClickListener(OnItemClickListener onItemClickListener);
}
