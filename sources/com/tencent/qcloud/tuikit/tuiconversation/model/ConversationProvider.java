package com.tencent.qcloud.tuikit.tuiconversation.model;

import com.tencent.imsdk.v2.V2TIMCallback;
import com.tencent.imsdk.v2.V2TIMConversationResult;
import com.tencent.imsdk.v2.V2TIMGroupMemberFullInfo;
import com.tencent.imsdk.v2.V2TIMGroupMemberInfoResult;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMValueCallback;
import com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuicore.util.ErrorMessageConverter;
import com.tencent.qcloud.tuikit.tuiconversation.bean.ConversationInfo;
import com.tencent.qcloud.tuikit.tuiconversation.util.ConversationUtils;
import com.tencent.qcloud.tuikit.tuiconversation.util.TUIConversationLog;
import com.tencent.qcloud.tuikit.tuiconversation.util.TUIConversationUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class ConversationProvider {
    private static final String TAG = "ConversationProvider";
    private boolean isFinished = false;
    private long nextLoadSeq = 0;

    public void clearHistoryMessage(String str, boolean z, final IUIKitCallback<Void> iUIKitCallback) {
        if (z) {
            V2TIMManager.getMessageManager().clearGroupHistoryMessage(str, new V2TIMCallback() { // from class: com.tencent.qcloud.tuikit.tuiconversation.model.ConversationProvider.5
                @Override // com.tencent.imsdk.v2.V2TIMCallback
                public void onError(int i2, String str2) {
                    String str3 = ConversationProvider.TAG;
                    TUIConversationLog.e(str3, "clearConversationMessage error:" + i2 + ", desc:" + ErrorMessageConverter.convertIMError(i2, str2));
                    TUIConversationUtils.callbackOnError(iUIKitCallback, ConversationProvider.TAG, i2, str2);
                }

                @Override // com.tencent.imsdk.v2.V2TIMCallback
                public void onSuccess() {
                    TUIConversationLog.i(ConversationProvider.TAG, "clearConversationMessage success");
                    TUIConversationUtils.callbackOnSuccess(iUIKitCallback, null);
                }
            });
        } else {
            V2TIMManager.getMessageManager().clearC2CHistoryMessage(str, new V2TIMCallback() { // from class: com.tencent.qcloud.tuikit.tuiconversation.model.ConversationProvider.6
                @Override // com.tencent.imsdk.v2.V2TIMCallback
                public void onError(int i2, String str2) {
                    String str3 = ConversationProvider.TAG;
                    TUIConversationLog.e(str3, "clearConversationMessage error:" + i2 + ", desc:" + ErrorMessageConverter.convertIMError(i2, str2));
                    TUIConversationUtils.callbackOnError(iUIKitCallback, ConversationProvider.TAG, i2, str2);
                }

                @Override // com.tencent.imsdk.v2.V2TIMCallback
                public void onSuccess() {
                    TUIConversationLog.i(ConversationProvider.TAG, "clearConversationMessage success");
                    TUIConversationUtils.callbackOnSuccess(iUIKitCallback, null);
                }
            });
        }
    }

    public void deleteConversation(String str, final IUIKitCallback<Void> iUIKitCallback) {
        V2TIMManager.getConversationManager().deleteConversation(str, new V2TIMCallback() { // from class: com.tencent.qcloud.tuikit.tuiconversation.model.ConversationProvider.4
            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onError(int i2, String str2) {
                String str3 = ConversationProvider.TAG;
                TUIConversationLog.e(str3, "deleteConversation error:" + i2 + ", desc:" + ErrorMessageConverter.convertIMError(i2, str2));
                TUIConversationUtils.callbackOnError(iUIKitCallback, ConversationProvider.TAG, i2, str2);
            }

            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onSuccess() {
                TUIConversationLog.i(ConversationProvider.TAG, "deleteConversation success");
                TUIConversationUtils.callbackOnSuccess(iUIKitCallback, null);
            }
        });
    }

    public void getGroupMemberIconList(final String str, final int i2, final IUIKitCallback<List<Object>> iUIKitCallback) {
        V2TIMManager.getGroupManager().getGroupMemberList(str, 0, 0L, new V2TIMValueCallback<V2TIMGroupMemberInfoResult>() { // from class: com.tencent.qcloud.tuikit.tuiconversation.model.ConversationProvider.7
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i3, String str2) {
                TUIConversationUtils.callbackOnError(iUIKitCallback, i3, str2);
                TUIConversationLog.e("ConversationIconView", "getGroupMemberList failed! groupID:" + str + "|code:" + i3 + "|desc: " + ErrorMessageConverter.convertIMError(i3, str2));
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(V2TIMGroupMemberInfoResult v2TIMGroupMemberInfoResult) {
                List<V2TIMGroupMemberFullInfo> memberInfoList = v2TIMGroupMemberInfoResult.getMemberInfoList();
                int min = Math.min(memberInfoList.size(), i2);
                ArrayList arrayList = new ArrayList();
                for (int i3 = 0; i3 < min; i3++) {
                    arrayList.add(memberInfoList.get(i3).getFaceUrl());
                }
                TUIConversationUtils.callbackOnSuccess(iUIKitCallback, arrayList);
            }
        });
    }

    public void getTotalUnreadMessageCount(final IUIKitCallback<Long> iUIKitCallback) {
        V2TIMManager.getConversationManager().getTotalUnreadMessageCount(new V2TIMValueCallback<Long>() { // from class: com.tencent.qcloud.tuikit.tuiconversation.model.ConversationProvider.2
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i2, String str) {
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(Long l2) {
                TUIConversationUtils.callbackOnSuccess(iUIKitCallback, l2);
            }
        });
    }

    public boolean isLoadFinished() {
        return this.isFinished;
    }

    public void loadConversation(long j2, int i2, final IUIKitCallback<List<ConversationInfo>> iUIKitCallback) {
        this.isFinished = false;
        this.nextLoadSeq = 0L;
        V2TIMManager.getConversationManager().getConversationList(j2, i2, new V2TIMValueCallback<V2TIMConversationResult>() { // from class: com.tencent.qcloud.tuikit.tuiconversation.model.ConversationProvider.1
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i3, String str) {
                String str2 = ConversationProvider.TAG;
                TUIConversationLog.v(str2, "loadConversation getConversationList error, code = " + i3 + ", desc = " + ErrorMessageConverter.convertIMError(i3, str));
                TUIConversationUtils.callbackOnError(iUIKitCallback, ConversationProvider.TAG, i3, str);
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(V2TIMConversationResult v2TIMConversationResult) {
                List<ConversationInfo> convertV2TIMConversationList = ConversationUtils.convertV2TIMConversationList(v2TIMConversationResult.getConversationList());
                ConversationProvider.this.isFinished = v2TIMConversationResult.isFinished();
                ConversationProvider.this.nextLoadSeq = v2TIMConversationResult.getNextSeq();
                TUIConversationUtils.callbackOnSuccess(iUIKitCallback, convertV2TIMConversationList);
            }
        });
    }

    public void loadMoreConversation(int i2, IUIKitCallback<List<ConversationInfo>> iUIKitCallback) {
        if (this.isFinished) {
            return;
        }
        loadConversation(this.nextLoadSeq, i2, iUIKitCallback);
    }

    public void setConversationTop(String str, boolean z, final IUIKitCallback<Void> iUIKitCallback) {
        V2TIMManager.getConversationManager().pinConversation(str, z, new V2TIMCallback() { // from class: com.tencent.qcloud.tuikit.tuiconversation.model.ConversationProvider.3
            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onError(int i2, String str2) {
                TUIConversationUtils.callbackOnError(iUIKitCallback, ConversationProvider.TAG, i2, str2);
            }

            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onSuccess() {
                TUIConversationUtils.callbackOnSuccess(iUIKitCallback, null);
            }
        });
    }
}
