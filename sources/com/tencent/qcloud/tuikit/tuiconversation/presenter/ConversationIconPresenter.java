package com.tencent.qcloud.tuikit.tuiconversation.presenter;

import com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuikit.tuiconversation.model.ConversationProvider;
import java.util.List;

/* loaded from: classes3.dex */
public class ConversationIconPresenter {
    private final ConversationProvider provider = new ConversationProvider();

    public void getGroupMemberIconList(String str, IUIKitCallback<List<Object>> iUIKitCallback) {
        this.provider.getGroupMemberIconList(str, 9, iUIKitCallback);
    }
}
