package com.tencent.qcloud.tuikit.tuichat.presenter;

import android.text.TextUtils;
import com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuikit.tuichat.bean.message.MergeMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.model.ChatProvider;
import com.tencent.qcloud.tuikit.tuichat.ui.interfaces.IMessageAdapter;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class ForwardPresenter extends ChatPresenter {
    public static final String TAG = "ForwardPresenter";
    public List<TUIMessageBean> loadedData = new ArrayList();
    private IMessageAdapter messageListAdapter;
    private final ChatProvider provider;

    public ForwardPresenter() {
        TUIChatLog.i(TAG, "ChatPresenter Init");
        this.provider = new ChatProvider();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onMergeMessageDownloaded(List<TUIMessageBean> list) {
        this.loadedData.clear();
        this.loadedData.addAll(list);
        IMessageAdapter iMessageAdapter = this.messageListAdapter;
        if (iMessageAdapter != null) {
            iMessageAdapter.onDataSourceChanged(this.loadedData);
            this.messageListAdapter.onViewNeedRefresh(4, this.loadedData.size());
        }
    }

    public void downloadMergerMessage(MergeMessageBean mergeMessageBean) {
        if (mergeMessageBean != null) {
            if (mergeMessageBean.isLayersOverLimit()) {
                TUIChatLog.e(TAG, "merge message Layers Over Limit");
            } else {
                this.provider.downloadMergerMessage(mergeMessageBean, new IUIKitCallback<List<TUIMessageBean>>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ForwardPresenter.1
                    @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                    public void onError(String str, int i2, String str2) {
                        String str3 = ForwardPresenter.TAG;
                        TUIChatLog.e(str3, "downloadMergerMessage error , code = " + i2 + "  message = " + str2);
                    }

                    @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                    public void onSuccess(final List<TUIMessageBean> list) {
                        ForwardPresenter.this.preProcessReplyMessage(list, new IUIKitCallback<List<TUIMessageBean>>() { // from class: com.tencent.qcloud.tuikit.tuichat.presenter.ForwardPresenter.1.1
                            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                            public void onError(String str, int i2, String str2) {
                                ForwardPresenter.this.onMergeMessageDownloaded(list);
                            }

                            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                            public void onSuccess(List<TUIMessageBean> list2) {
                                ForwardPresenter.this.onMergeMessageDownloaded(list2);
                            }
                        });
                    }
                });
            }
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter
    public void locateMessage(String str, IUIKitCallback<Void> iUIKitCallback) {
        boolean z;
        Iterator<TUIMessageBean> it = this.loadedData.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            TUIMessageBean next = it.next();
            if (TextUtils.equals(str, next.getId())) {
                z = true;
                updateAdapter(9, next);
                break;
            }
        }
        if (z) {
            TUIChatUtils.callbackOnSuccess(iUIKitCallback, null);
        } else {
            TUIChatUtils.callbackOnError(iUIKitCallback, -1, "not find");
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter
    public void setMessageListAdapter(IMessageAdapter iMessageAdapter) {
        this.messageListAdapter = iMessageAdapter;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.presenter.ChatPresenter
    public void updateAdapter(int i2, TUIMessageBean tUIMessageBean) {
        IMessageAdapter iMessageAdapter = this.messageListAdapter;
        if (iMessageAdapter != null) {
            iMessageAdapter.onViewNeedRefresh(i2, tUIMessageBean);
        }
    }
}
