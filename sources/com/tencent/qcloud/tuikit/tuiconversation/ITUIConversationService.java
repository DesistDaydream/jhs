package com.tencent.qcloud.tuikit.tuiconversation;

import com.tencent.qcloud.tuicore.interfaces.ITUINotification;
import com.tencent.qcloud.tuicore.interfaces.ITUIService;
import java.util.Map;

/* loaded from: classes3.dex */
public interface ITUIConversationService extends ITUIService, ITUINotification {
    @Override // com.tencent.qcloud.tuicore.interfaces.ITUIService
    Object onCall(String str, Map<String, Object> map);

    @Override // com.tencent.qcloud.tuicore.interfaces.ITUINotification
    void onNotifyEvent(String str, String str2, Map<String, Object> map);
}
