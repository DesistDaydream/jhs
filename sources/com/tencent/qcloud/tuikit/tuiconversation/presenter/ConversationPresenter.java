package com.tencent.qcloud.tuikit.tuiconversation.presenter;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuicore.TUICore;
import com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuikit.tuiconversation.TUIConversationService;
import com.tencent.qcloud.tuikit.tuiconversation.bean.ConversationInfo;
import com.tencent.qcloud.tuikit.tuiconversation.interfaces.ConversationEventListener;
import com.tencent.qcloud.tuikit.tuiconversation.model.ConversationProvider;
import com.tencent.qcloud.tuikit.tuiconversation.ui.interfaces.IConversationListAdapter;
import com.tencent.qcloud.tuikit.tuiconversation.util.ConversationUtils;
import com.tencent.qcloud.tuikit.tuiconversation.util.TUIConversationLog;
import com.tencent.qcloud.tuikit.tuiconversation.util.TUIConversationUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class ConversationPresenter {
    private static final int GET_CONVERSATION_COUNT = 100;
    private static final String TAG = "ConversationPresenter";
    private IConversationListAdapter adapter;
    public ConversationEventListener conversationEventListener;
    private long totalUnreadCount;
    private final List<ConversationInfo> loadedConversationInfoList = new ArrayList();
    public boolean isError = false;
    private final ConversationProvider provider = new ConversationProvider();

    public void onLoadConversationCompleted(List<ConversationInfo> list) {
        onNewConversation(list);
        IConversationListAdapter iConversationListAdapter = this.adapter;
        if (iConversationListAdapter != null) {
            iConversationListAdapter.onLoadingStateChanged(false);
        }
        this.provider.getTotalUnreadMessageCount(new IUIKitCallback<Long>() { // from class: com.tencent.qcloud.tuikit.tuiconversation.presenter.ConversationPresenter.4
            {
                ConversationPresenter.this = this;
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str, int i2, String str2) {
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(Long l2) {
                ConversationPresenter.this.totalUnreadCount = l2.intValue();
                ConversationPresenter conversationPresenter = ConversationPresenter.this;
                conversationPresenter.updateUnreadTotal(conversationPresenter.totalUnreadCount);
            }
        });
    }

    public void clearConversationMessage(ConversationInfo conversationInfo) {
        if (conversationInfo != null && !TextUtils.isEmpty(conversationInfo.getConversationId())) {
            this.provider.clearHistoryMessage(conversationInfo.getId(), conversationInfo.isGroup(), new IUIKitCallback<Void>() { // from class: com.tencent.qcloud.tuikit.tuiconversation.presenter.ConversationPresenter.8
                {
                    ConversationPresenter.this = this;
                }

                @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                public void onError(String str, int i2, String str2) {
                }

                @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                public void onSuccess(Void r1) {
                }
            });
        } else {
            TUIConversationLog.e(TAG, "clearConversationMessage error: invalid conversation");
        }
    }

    public void deleteConversation(final ConversationInfo conversationInfo) {
        String str = TAG;
        TUIConversationLog.i(str, "deleteConversation conversation:" + conversationInfo);
        if (conversationInfo == null) {
            return;
        }
        this.provider.deleteConversation(conversationInfo.getConversationId(), new IUIKitCallback<Void>() { // from class: com.tencent.qcloud.tuikit.tuiconversation.presenter.ConversationPresenter.7
            {
                ConversationPresenter.this = this;
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str2, int i2, String str3) {
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(Void r3) {
                int indexOf = ConversationPresenter.this.loadedConversationInfoList.indexOf(conversationInfo);
                boolean remove = ConversationPresenter.this.loadedConversationInfoList.remove(conversationInfo);
                if (ConversationPresenter.this.adapter == null || !remove || indexOf == -1) {
                    return;
                }
                ConversationPresenter.this.adapter.onItemRemoved(indexOf);
            }
        });
    }

    public boolean isLoadFinished() {
        return this.provider.isLoadFinished();
    }

    public boolean isTopConversation(String str) {
        for (int i2 = 0; i2 < this.loadedConversationInfoList.size(); i2++) {
            ConversationInfo conversationInfo = this.loadedConversationInfoList.get(i2);
            if (conversationInfo.getId().equals(str)) {
                return conversationInfo.isTop();
            }
        }
        return false;
    }

    public void loadConversation(final long j2) {
        TUIConversationLog.i(TAG, "loadConversation");
        this.provider.loadConversation(j2, 100, new IUIKitCallback<List<ConversationInfo>>() { // from class: com.tencent.qcloud.tuikit.tuiconversation.presenter.ConversationPresenter.2
            {
                ConversationPresenter.this = this;
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str, int i2, String str2) {
                if (j2 == 0) {
                    ConversationPresenter.this.isError = true;
                }
                String str3 = ConversationPresenter.TAG;
                Log.e(str3, "loadConversation fail" + i2 + " , " + str2);
                if (ConversationPresenter.this.adapter != null) {
                    ConversationPresenter.this.adapter.onLoadingStateChanged(false);
                }
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(List<ConversationInfo> list) {
                ConversationPresenter conversationPresenter = ConversationPresenter.this;
                conversationPresenter.isError = false;
                conversationPresenter.onLoadConversationCompleted(list);
            }
        });
    }

    public void loadMoreConversation() {
        this.provider.loadMoreConversation(100, new IUIKitCallback<List<ConversationInfo>>() { // from class: com.tencent.qcloud.tuikit.tuiconversation.presenter.ConversationPresenter.3
            {
                ConversationPresenter.this = this;
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str, int i2, String str2) {
                if (ConversationPresenter.this.adapter != null) {
                    ConversationPresenter.this.adapter.onLoadingStateChanged(false);
                }
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(List<ConversationInfo> list) {
                ConversationPresenter.this.onLoadConversationCompleted(list);
            }
        });
    }

    public void onConversationChanged(List<ConversationInfo> list) {
        String str = TAG;
        TUIConversationLog.i(str, "onConversationChanged conversations:" + list);
        ArrayList arrayList = new ArrayList();
        for (ConversationInfo conversationInfo : list) {
            if (!ConversationUtils.isNeedUpdate(conversationInfo)) {
                String str2 = TAG;
                TUIConversationLog.i(str2, "onConversationChanged conversationInfo " + conversationInfo.toString());
                arrayList.add(conversationInfo);
            }
        }
        if (arrayList.size() == 0) {
            return;
        }
        Collections.sort(arrayList);
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            ConversationInfo conversationInfo2 = (ConversationInfo) arrayList.get(i2);
            int i3 = 0;
            while (true) {
                if (i3 >= this.loadedConversationInfoList.size()) {
                    break;
                } else if (this.loadedConversationInfoList.get(i3).getConversationId().equals(conversationInfo2.getConversationId())) {
                    this.loadedConversationInfoList.set(i3, conversationInfo2);
                    hashMap.put(conversationInfo2, Integer.valueOf(i3));
                    break;
                } else {
                    i3++;
                }
            }
        }
        if (this.adapter != null) {
            Collections.sort(this.loadedConversationInfoList);
            this.adapter.onDataSourceChanged(this.loadedConversationInfoList);
            int i4 = Integer.MAX_VALUE;
            int i5 = Integer.MIN_VALUE;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ConversationInfo conversationInfo3 = (ConversationInfo) it.next();
                Integer num = (Integer) hashMap.get(conversationInfo3);
                if (num != null) {
                    int intValue = num.intValue();
                    int indexOf = this.loadedConversationInfoList.indexOf(conversationInfo3);
                    if (indexOf != -1) {
                        i4 = Math.min(i4, Math.min(intValue, indexOf));
                        i5 = Math.max(i5, Math.max(intValue, indexOf));
                    }
                }
            }
            int i6 = i4 != i5 ? 1 + (i5 - i4) : 1;
            if (i6 <= 0 || i5 < i4) {
                return;
            }
            this.adapter.onItemRangeChanged(i4, i6);
        }
    }

    public void onFriendRemarkChanged(String str, String str2) {
        for (int i2 = 0; i2 < this.loadedConversationInfoList.size(); i2++) {
            ConversationInfo conversationInfo = this.loadedConversationInfoList.get(i2);
            if (conversationInfo.getId().equals(str) && !conversationInfo.isGroup()) {
                String showName = conversationInfo.getShowName();
                if (TextUtils.isEmpty(str2)) {
                    str2 = showName;
                }
                conversationInfo.setTitle(str2);
                this.adapter.onDataSourceChanged(this.loadedConversationInfoList);
                IConversationListAdapter iConversationListAdapter = this.adapter;
                if (iConversationListAdapter != null) {
                    iConversationListAdapter.onItemChanged(i2);
                    return;
                }
                return;
            }
        }
    }

    public void onNewConversation(List<ConversationInfo> list) {
        String str = TAG;
        TUIConversationLog.i(str, "onNewConversation conversations:" + list);
        ArrayList arrayList = new ArrayList();
        for (ConversationInfo conversationInfo : list) {
            if (!ConversationUtils.isNeedUpdate(conversationInfo)) {
                String str2 = TAG;
                TUIConversationLog.i(str2, "onNewConversation conversationInfo " + conversationInfo.toString());
                arrayList.add(conversationInfo);
            }
        }
        if (arrayList.size() == 0) {
            return;
        }
        ArrayList<ConversationInfo> arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ConversationInfo conversationInfo2 = (ConversationInfo) it.next();
            int i2 = 0;
            while (true) {
                if (i2 >= this.loadedConversationInfoList.size()) {
                    break;
                } else if (this.loadedConversationInfoList.get(i2).getConversationId().equals(conversationInfo2.getConversationId())) {
                    this.loadedConversationInfoList.set(i2, conversationInfo2);
                    it.remove();
                    arrayList2.add(conversationInfo2);
                    break;
                } else {
                    i2++;
                }
            }
        }
        Collections.sort(arrayList);
        this.loadedConversationInfoList.addAll(arrayList);
        if (this.adapter != null) {
            Collections.sort(this.loadedConversationInfoList);
            this.adapter.onDataSourceChanged(this.loadedConversationInfoList);
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                int indexOf = this.loadedConversationInfoList.indexOf((ConversationInfo) it2.next());
                if (indexOf != -1) {
                    this.adapter.onItemInserted(indexOf);
                }
            }
            for (ConversationInfo conversationInfo3 : arrayList2) {
                int indexOf2 = this.loadedConversationInfoList.indexOf(conversationInfo3);
                if (indexOf2 != -1) {
                    this.adapter.onItemChanged(indexOf2);
                }
            }
        }
    }

    public void setAdapter(IConversationListAdapter iConversationListAdapter) {
        this.adapter = iConversationListAdapter;
    }

    public void setConversationListener() {
        this.conversationEventListener = new ConversationEventListener() { // from class: com.tencent.qcloud.tuikit.tuiconversation.presenter.ConversationPresenter.1
            {
                ConversationPresenter.this = this;
            }

            @Override // com.tencent.qcloud.tuikit.tuiconversation.interfaces.ConversationEventListener
            public void clearConversationMessage(String str, boolean z) {
                ConversationPresenter.this.clearConversationMessage(str, z);
            }

            @Override // com.tencent.qcloud.tuikit.tuiconversation.interfaces.ConversationEventListener
            public void deleteConversation(String str, boolean z) {
                ConversationPresenter.this.deleteConversation(str, z);
            }

            @Override // com.tencent.qcloud.tuikit.tuiconversation.interfaces.ConversationEventListener
            public long getUnreadTotal() {
                return ConversationPresenter.this.totalUnreadCount;
            }

            @Override // com.tencent.qcloud.tuikit.tuiconversation.interfaces.ConversationEventListener
            public boolean isTopConversation(String str) {
                return ConversationPresenter.this.isTopConversation(str);
            }

            @Override // com.tencent.qcloud.tuikit.tuiconversation.interfaces.ConversationEventListener
            public void onConversationChanged(List<ConversationInfo> list) {
                ConversationPresenter.this.onConversationChanged(list);
            }

            @Override // com.tencent.qcloud.tuikit.tuiconversation.interfaces.ConversationEventListener
            public void onFriendRemarkChanged(String str, String str2) {
                ConversationPresenter.this.onFriendRemarkChanged(str, str2);
            }

            @Override // com.tencent.qcloud.tuikit.tuiconversation.interfaces.ConversationEventListener
            public void onLoginSuccess() {
            }

            @Override // com.tencent.qcloud.tuikit.tuiconversation.interfaces.ConversationEventListener
            public void onNewConversation(List<ConversationInfo> list) {
                ConversationPresenter.this.onNewConversation(list);
            }

            @Override // com.tencent.qcloud.tuikit.tuiconversation.interfaces.ConversationEventListener
            public void setConversationTop(String str, boolean z, IUIKitCallback<Void> iUIKitCallback) {
                ConversationPresenter.this.setConversationTop(str, z, iUIKitCallback);
            }

            @Override // com.tencent.qcloud.tuikit.tuiconversation.interfaces.ConversationEventListener
            public void updateTotalUnreadMessageCount(long j2) {
                ConversationPresenter.this.updateTotalUnreadMessageCount(j2);
            }

            @Override // com.tencent.qcloud.tuikit.tuiconversation.interfaces.ConversationEventListener
            public void deleteConversation(String str) {
                ConversationPresenter.this.deleteConversation(str);
            }
        };
        TUIConversationService.getInstance().setConversationEventListener(this.conversationEventListener);
    }

    public void setConversationTop(final ConversationInfo conversationInfo, final IUIKitCallback<Void> iUIKitCallback) {
        String str = TAG;
        TUIConversationLog.i(str, "setConversationTop|conversation:" + conversationInfo);
        final boolean isTop = conversationInfo.isTop() ^ true;
        this.provider.setConversationTop(conversationInfo.getConversationId(), isTop, new IUIKitCallback<Void>() { // from class: com.tencent.qcloud.tuikit.tuiconversation.presenter.ConversationPresenter.5
            {
                ConversationPresenter.this = this;
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str2, int i2, String str3) {
                String str4 = ConversationPresenter.TAG;
                TUIConversationLog.e(str4, "setConversationTop code:" + i2 + "|desc:" + str3);
                IUIKitCallback iUIKitCallback2 = iUIKitCallback;
                if (iUIKitCallback2 != null) {
                    iUIKitCallback2.onError("setConversationTop", i2, str3);
                }
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(Void r2) {
                conversationInfo.setTop(isTop);
            }
        });
    }

    public void updateAdapter() {
        IConversationListAdapter iConversationListAdapter = this.adapter;
        if (iConversationListAdapter != null) {
            iConversationListAdapter.onViewNeedRefresh();
        }
    }

    public void updateTotalUnreadMessageCount(long j2) {
        long j3 = (int) j2;
        this.totalUnreadCount = j3;
        updateUnreadTotal(j3);
    }

    public void updateUnreadTotal(long j2) {
        String str = TAG;
        TUIConversationLog.i(str, "updateUnreadTotal:" + j2);
        this.totalUnreadCount = j2;
        HashMap hashMap = new HashMap();
        hashMap.put(TUIConstants.TUIConversation.TOTAL_UNREAD_COUNT, Long.valueOf(this.totalUnreadCount));
        TUICore.notifyEvent(TUIConstants.TUIConversation.EVENT_UNREAD, TUIConstants.TUIConversation.EVENT_SUB_KEY_UNREAD_CHANGED, hashMap);
    }

    public void deleteConversation(String str, boolean z) {
        ConversationInfo conversationInfo;
        int i2 = 0;
        while (true) {
            if (i2 >= this.loadedConversationInfoList.size()) {
                conversationInfo = null;
                break;
            }
            conversationInfo = this.loadedConversationInfoList.get(i2);
            if (z == conversationInfo.isGroup() && conversationInfo.getId().equals(str)) {
                break;
            }
            i2++;
        }
        deleteConversation(conversationInfo);
    }

    public void clearConversationMessage(String str, boolean z) {
        this.provider.clearHistoryMessage(str, z, new IUIKitCallback<Void>() { // from class: com.tencent.qcloud.tuikit.tuiconversation.presenter.ConversationPresenter.9
            {
                ConversationPresenter.this = this;
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str2, int i2, String str3) {
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(Void r1) {
            }
        });
    }

    public void setConversationTop(String str, final boolean z, final IUIKitCallback<Void> iUIKitCallback) {
        final ConversationInfo conversationInfo;
        String str2 = TAG;
        TUIConversationLog.i(str2, "setConversationTop id:" + str + "|isTop:" + z);
        int i2 = 0;
        while (true) {
            if (i2 >= this.loadedConversationInfoList.size()) {
                conversationInfo = null;
                break;
            }
            conversationInfo = this.loadedConversationInfoList.get(i2);
            if (conversationInfo.getId().equals(str)) {
                break;
            }
            i2++;
        }
        if (conversationInfo == null) {
            return;
        }
        this.provider.setConversationTop(conversationInfo.getConversationId(), z, new IUIKitCallback<Void>() { // from class: com.tencent.qcloud.tuikit.tuiconversation.presenter.ConversationPresenter.6
            {
                ConversationPresenter.this = this;
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str3, int i3, String str4) {
                String str5 = ConversationPresenter.TAG;
                TUIConversationLog.e(str5, "setConversationTop code:" + i3 + "|desc:" + str4);
                IUIKitCallback iUIKitCallback2 = iUIKitCallback;
                if (iUIKitCallback2 != null) {
                    iUIKitCallback2.onError("setConversationTop", i3, str4);
                }
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(Void r2) {
                conversationInfo.setTop(z);
                TUIConversationUtils.callbackOnSuccess(iUIKitCallback, null);
            }
        });
    }

    public void deleteConversation(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ConversationInfo conversationInfo = null;
        int i2 = 0;
        while (true) {
            if (i2 >= this.loadedConversationInfoList.size()) {
                break;
            }
            ConversationInfo conversationInfo2 = this.loadedConversationInfoList.get(i2);
            if (conversationInfo2.getConversationId().equals(str)) {
                conversationInfo = conversationInfo2;
                break;
            }
            i2++;
        }
        deleteConversation(conversationInfo);
    }
}
