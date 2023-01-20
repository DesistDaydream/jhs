package com.tencent.qcloud.tuikit.tuichat.ui.interfaces;

import com.tencent.qcloud.tuicore.component.interfaces.ILayout;
import com.tencent.qcloud.tuikit.tuichat.bean.ChatInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.component.noticelayout.NoticeLayout;
import com.tencent.qcloud.tuikit.tuichat.ui.view.input.InputView;
import com.tencent.qcloud.tuikit.tuichat.ui.view.message.MessageRecyclerView;

/* loaded from: classes3.dex */
public interface IChatLayout extends ILayout {
    void exitChat();

    ChatInfo getChatInfo();

    InputView getInputLayout();

    MessageRecyclerView getMessageLayout();

    NoticeLayout getNoticeLayout();

    void initDefault();

    void loadMessages(int i2);

    void sendMessage(TUIMessageBean tUIMessageBean, boolean z);

    void setChatInfo(ChatInfo chatInfo);
}
