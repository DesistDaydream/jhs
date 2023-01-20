package com.tencent.qcloud.tuikit.tuicontact.presenter;

import android.text.TextUtils;
import com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.tuicontact.TUIContactService;
import com.tencent.qcloud.tuikit.tuicontact.bean.FriendApplicationBean;
import com.tencent.qcloud.tuikit.tuicontact.interfaces.ContactEventListener;
import com.tencent.qcloud.tuikit.tuicontact.model.ContactProvider;
import com.tencent.qcloud.tuikit.tuicontact.ui.interfaces.INewFriendActivity;
import com.tencent.qcloud.tuikit.tuicontact.util.ContactUtils;
import com.tencent.qcloud.tuikit.tuicontact.util.TUIContactLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class NewFriendPresenter {
    private static final String TAG = "NewFriendPresenter";
    private INewFriendActivity friendActivity;
    private final List<FriendApplicationBean> dataSource = new ArrayList();
    private final ContactProvider provider = new ContactProvider();
    private ContactEventListener friendApplicationListener = new ContactEventListener() { // from class: com.tencent.qcloud.tuikit.tuicontact.presenter.NewFriendPresenter.1
        @Override // com.tencent.qcloud.tuikit.tuicontact.interfaces.ContactEventListener
        public void onFriendApplicationListAdded(List<FriendApplicationBean> list) {
            Iterator<FriendApplicationBean> it = list.iterator();
            while (it.hasNext()) {
                FriendApplicationBean next = it.next();
                for (FriendApplicationBean friendApplicationBean : NewFriendPresenter.this.dataSource) {
                    if (TextUtils.equals(friendApplicationBean.getUserId(), next.getUserId())) {
                        it.remove();
                    }
                }
            }
            NewFriendPresenter.this.dataSource.addAll(list);
            NewFriendPresenter.this.notifyDataSourceChanged();
        }

        @Override // com.tencent.qcloud.tuikit.tuicontact.interfaces.ContactEventListener
        public void onFriendApplicationListDeleted(List<String> list) {
            Iterator it = NewFriendPresenter.this.dataSource.iterator();
            while (it.hasNext()) {
                FriendApplicationBean friendApplicationBean = (FriendApplicationBean) it.next();
                for (String str : list) {
                    if (TextUtils.equals(str, friendApplicationBean.getUserId())) {
                        it.remove();
                    }
                }
            }
            NewFriendPresenter.this.notifyDataSourceChanged();
        }

        @Override // com.tencent.qcloud.tuikit.tuicontact.interfaces.ContactEventListener
        public void onFriendApplicationListRead() {
            super.onFriendApplicationListRead();
        }
    };

    public NewFriendPresenter() {
        TUIContactService.getInstance().addContactEventListener(this.friendApplicationListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyDataSourceChanged() {
        INewFriendActivity iNewFriendActivity = this.friendActivity;
        if (iNewFriendActivity != null) {
            iNewFriendActivity.onDataSourceChanged(this.dataSource);
        }
    }

    public void acceptFriendApplication(FriendApplicationBean friendApplicationBean, final IUIKitCallback<Void> iUIKitCallback) {
        this.provider.acceptFriendApplication(friendApplicationBean, 1, new IUIKitCallback<Void>() { // from class: com.tencent.qcloud.tuikit.tuicontact.presenter.NewFriendPresenter.3
            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str, int i2, String str2) {
                String str3 = NewFriendPresenter.TAG;
                TUIContactLog.e(str3, "acceptFriendApplication error " + i2 + "  " + str2);
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(Void r2) {
                ContactUtils.callbackOnSuccess(iUIKitCallback, null);
            }
        });
    }

    public void loadFriendApplicationList() {
        this.dataSource.clear();
        this.provider.loadFriendApplicationList(new IUIKitCallback<List<FriendApplicationBean>>() { // from class: com.tencent.qcloud.tuikit.tuicontact.presenter.NewFriendPresenter.2
            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str, int i2, String str2) {
                ToastUtil.toastShortMessage("Error code = " + i2 + ", desc = " + str2);
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(List<FriendApplicationBean> list) {
                for (FriendApplicationBean friendApplicationBean : list) {
                    if (friendApplicationBean.getAddType() == 1) {
                        NewFriendPresenter.this.dataSource.add(friendApplicationBean);
                    }
                }
                NewFriendPresenter.this.notifyDataSourceChanged();
            }
        });
    }

    public void refuseFriendApplication(FriendApplicationBean friendApplicationBean, final IUIKitCallback<Void> iUIKitCallback) {
        this.provider.refuseFriendApplication(friendApplicationBean, new IUIKitCallback<Void>() { // from class: com.tencent.qcloud.tuikit.tuicontact.presenter.NewFriendPresenter.4
            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str, int i2, String str2) {
                String str3 = NewFriendPresenter.TAG;
                TUIContactLog.e(str3, "acceptFriendApplication error " + i2 + "  " + str2);
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(Void r2) {
                ContactUtils.callbackOnSuccess(iUIKitCallback, null);
            }
        });
    }

    public void setFriendActivity(INewFriendActivity iNewFriendActivity) {
        this.friendActivity = iNewFriendActivity;
    }

    public void setFriendApplicationListAllRead(IUIKitCallback<Void> iUIKitCallback) {
        this.provider.setGroupApplicationRead(iUIKitCallback);
    }
}
