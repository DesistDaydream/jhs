package com.tencent.qcloud.tuikit.tuichat.ui.view.input;

import com.tencent.qcloud.tuicore.component.fragments.BaseFragment;
import com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IChatLayout;

/* loaded from: classes3.dex */
public class BaseInputFragment extends BaseFragment {
    private IChatLayout mChatLayout;

    public IChatLayout getChatLayout() {
        return this.mChatLayout;
    }

    public BaseInputFragment setChatLayout(IChatLayout iChatLayout) {
        this.mChatLayout = iChatLayout;
        return this;
    }
}
