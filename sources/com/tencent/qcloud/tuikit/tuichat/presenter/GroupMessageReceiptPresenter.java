package com.tencent.qcloud.tuikit.tuichat.presenter;

import com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuikit.tuichat.bean.GroupMessageReceiptInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.message.GroupMessageReadMembersInfo;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.model.ChatProvider;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class GroupMessageReceiptPresenter {
    public static final int GET_MEMBERS_COUNT = 100;
    private final ChatProvider provider = new ChatProvider();

    public void getGroupMessageReadMembers(TUIMessageBean tUIMessageBean, boolean z, long j2, IUIKitCallback<GroupMessageReadMembersInfo> iUIKitCallback) {
        this.provider.getGroupMessageReadMembers(tUIMessageBean, z, 100, j2, iUIKitCallback);
    }

    public void getGroupMessageReadReceipt(TUIMessageBean tUIMessageBean, IUIKitCallback<List<GroupMessageReceiptInfo>> iUIKitCallback) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(tUIMessageBean);
        this.provider.getGroupReadReceipt(arrayList, iUIKitCallback);
    }
}
