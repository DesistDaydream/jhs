package com.tencent.qcloud.tuikit.tuicontact.presenter;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.tencent.qcloud.tuicore.TUILogin;
import com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuicore.util.BackgroundTasks;
import com.tencent.qcloud.tuicore.util.ThreadHelper;
import com.tencent.qcloud.tuikit.tuicontact.R;
import com.tencent.qcloud.tuikit.tuicontact.TUIContactConstants;
import com.tencent.qcloud.tuikit.tuicontact.TUIContactService;
import com.tencent.qcloud.tuikit.tuicontact.bean.ContactItemBean;
import com.tencent.qcloud.tuikit.tuicontact.bean.FriendApplicationBean;
import com.tencent.qcloud.tuikit.tuicontact.bean.GroupInfo;
import com.tencent.qcloud.tuikit.tuicontact.bean.MessageCustom;
import com.tencent.qcloud.tuikit.tuicontact.interfaces.ContactEventListener;
import com.tencent.qcloud.tuikit.tuicontact.model.ContactProvider;
import com.tencent.qcloud.tuikit.tuicontact.ui.interfaces.IContactListView;
import com.tencent.qcloud.tuikit.tuicontact.util.ContactUtils;
import com.tencent.qcloud.tuikit.tuicontact.util.TUIContactLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class ContactPresenter {
    private static final String TAG = "ContactPresenter";
    private ContactEventListener blackListListener;
    private IContactListView contactListView;
    private ContactEventListener friendListListener;
    private final ContactProvider provider;
    private final List<ContactItemBean> dataSource = new ArrayList();
    private boolean isSelectForCall = false;

    /* renamed from: com.tencent.qcloud.tuikit.tuicontact.presenter.ContactPresenter$6 */
    /* loaded from: classes3.dex */
    public class AnonymousClass6 extends IUIKitCallback<String> {
        public final /* synthetic */ IUIKitCallback val$callback;
        public final /* synthetic */ GroupInfo val$groupInfo;

        /* renamed from: com.tencent.qcloud.tuikit.tuicontact.presenter.ContactPresenter$6$1 */
        /* loaded from: classes3.dex */
        public class AnonymousClass1 implements Runnable {
            public final /* synthetic */ String val$data;
            public final /* synthetic */ String val$groupId;

            public AnonymousClass1(String str, String str2) {
                AnonymousClass6.this = r1;
                this.val$groupId = str;
                this.val$data = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                ContactPresenter.this.sendGroupTipsMessage(this.val$groupId, this.val$data, new IUIKitCallback<String>() { // from class: com.tencent.qcloud.tuikit.tuicontact.presenter.ContactPresenter.6.1.1
                    {
                        AnonymousClass1.this = this;
                    }

                    @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                    public void onError(final String str, final int i2, final String str2) {
                        BackgroundTasks.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuicontact.presenter.ContactPresenter.6.1.1.2
                            {
                                C02621.this = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                ContactUtils.callbackOnError(AnonymousClass6.this.val$callback, str, i2, str2);
                            }
                        });
                    }

                    @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                    public void onSuccess(final String str) {
                        BackgroundTasks.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuicontact.presenter.ContactPresenter.6.1.1.1
                            {
                                C02621.this = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                ContactUtils.callbackOnSuccess(AnonymousClass6.this.val$callback, str);
                            }
                        });
                    }
                });
            }
        }

        public AnonymousClass6(GroupInfo groupInfo, IUIKitCallback iUIKitCallback) {
            ContactPresenter.this = r1;
            this.val$groupInfo = groupInfo;
            this.val$callback = iUIKitCallback;
        }

        @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
        public void onError(String str, int i2, String str2) {
            ContactUtils.callbackOnError(this.val$callback, str, i2, str2);
        }

        @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
        public void onSuccess(String str) {
            this.val$groupInfo.setId(str);
            Gson gson = new Gson();
            MessageCustom messageCustom = new MessageCustom();
            messageCustom.version = TUIContactConstants.version;
            messageCustom.businessID = "group_create";
            messageCustom.opUser = TUILogin.getLoginUser();
            messageCustom.content = TUIContactService.getAppContext().getString(R.string.create_group);
            ThreadHelper.INST.execute(new AnonymousClass1(str, gson.z(messageCustom)));
        }
    }

    public ContactPresenter() {
        ContactProvider contactProvider = new ContactProvider();
        this.provider = contactProvider;
        contactProvider.setNextSeq(0L);
    }

    private void notifyDataSourceChanged() {
        IContactListView iContactListView = this.contactListView;
        if (iContactListView != null) {
            iContactListView.onDataSourceChanged(this.dataSource);
        }
    }

    public void onDataListAdd(List<ContactItemBean> list) {
        ArrayList arrayList = new ArrayList(list);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ContactItemBean contactItemBean = (ContactItemBean) it.next();
            for (ContactItemBean contactItemBean2 : this.dataSource) {
                if (TextUtils.equals(contactItemBean.getId(), contactItemBean2.getId())) {
                    it.remove();
                }
            }
        }
        this.dataSource.addAll(arrayList);
        notifyDataSourceChanged();
    }

    public void onDataListDeleted(List<String> list) {
        Iterator<ContactItemBean> it = this.dataSource.iterator();
        while (it.hasNext()) {
            ContactItemBean next = it.next();
            for (String str : list) {
                if (TextUtils.equals(str, next.getId())) {
                    it.remove();
                }
            }
        }
        notifyDataSourceChanged();
    }

    public void onDataLoaded(List<ContactItemBean> list) {
        this.dataSource.addAll(list);
        notifyDataSourceChanged();
    }

    public void createGroupChat(GroupInfo groupInfo, IUIKitCallback<String> iUIKitCallback) {
        this.provider.createGroupChat(groupInfo, new AnonymousClass6(groupInfo, iUIKitCallback));
    }

    public void getFriendApplicationUnreadCount(IUIKitCallback<Integer> iUIKitCallback) {
        this.provider.getFriendApplicationListUnreadCount(iUIKitCallback);
    }

    public long getNextSeq() {
        ContactProvider contactProvider = this.provider;
        if (contactProvider == null) {
            return 0L;
        }
        return contactProvider.getNextSeq();
    }

    public void loadDataSource(final int i2) {
        IUIKitCallback<List<ContactItemBean>> iUIKitCallback = new IUIKitCallback<List<ContactItemBean>>() { // from class: com.tencent.qcloud.tuikit.tuicontact.presenter.ContactPresenter.3
            {
                ContactPresenter.this = this;
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str, int i3, String str2) {
                String str3 = ContactPresenter.TAG;
                TUIContactLog.e(str3, "load data source error , loadType = " + i2 + "  errCode = " + i3 + "  errMsg = " + str2);
                ContactPresenter.this.onDataLoaded(new ArrayList());
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(List<ContactItemBean> list) {
                String str = ContactPresenter.TAG;
                TUIContactLog.i(str, "load data source success , loadType = " + i2);
                ContactPresenter.this.onDataLoaded(list);
            }
        };
        this.dataSource.clear();
        if (i2 == 1) {
            this.provider.loadFriendListDataAsync(iUIKitCallback);
        } else if (i2 == 2) {
            this.provider.loadBlackListData(iUIKitCallback);
        } else if (i2 == 3) {
            this.provider.loadGroupListData(iUIKitCallback);
        } else if (i2 != 4) {
        } else {
            this.dataSource.add((ContactItemBean) new ContactItemBean(TUIContactService.getAppContext().getResources().getString(R.string.new_friend)).setTop(true).setBaseIndexTag(ContactItemBean.INDEX_STRING_TOP));
            this.dataSource.add((ContactItemBean) new ContactItemBean(TUIContactService.getAppContext().getResources().getString(R.string.group)).setTop(true).setBaseIndexTag(ContactItemBean.INDEX_STRING_TOP));
            this.dataSource.add((ContactItemBean) new ContactItemBean(TUIContactService.getAppContext().getResources().getString(R.string.blacklist)).setTop(true).setBaseIndexTag(ContactItemBean.INDEX_STRING_TOP));
            this.provider.loadFriendListDataAsync(iUIKitCallback);
        }
    }

    public void loadFriendApplicationList(final IUIKitCallback<Integer> iUIKitCallback) {
        this.provider.loadFriendApplicationList(new IUIKitCallback<List<FriendApplicationBean>>() { // from class: com.tencent.qcloud.tuikit.tuicontact.presenter.ContactPresenter.5
            {
                ContactPresenter.this = this;
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str, int i2, String str2) {
                ContactUtils.callbackOnError(iUIKitCallback, str, i2, str2);
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(List<FriendApplicationBean> list) {
                int i2 = 0;
                for (FriendApplicationBean friendApplicationBean : list) {
                    if (friendApplicationBean.getAddType() == 1) {
                        i2++;
                    }
                }
                ContactUtils.callbackOnSuccess(iUIKitCallback, Integer.valueOf(i2));
            }
        });
    }

    public void loadGroupMemberList(String str) {
        if (!this.isSelectForCall && getNextSeq() == 0) {
            this.dataSource.add((ContactItemBean) new ContactItemBean(TUIContactService.getAppContext().getResources().getString(R.string.at_all)).setTop(true).setBaseIndexTag(ContactItemBean.INDEX_STRING_TOP));
        }
        this.provider.loadGroupMembers(str, new IUIKitCallback<List<ContactItemBean>>() { // from class: com.tencent.qcloud.tuikit.tuicontact.presenter.ContactPresenter.4
            {
                ContactPresenter.this = this;
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str2, int i2, String str3) {
                String str4 = ContactPresenter.TAG;
                TUIContactLog.e(str4, "load data source error , loadType = 5  errCode = " + i2 + "  errMsg = " + str3);
                ContactPresenter.this.onDataLoaded(new ArrayList());
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(List<ContactItemBean> list) {
                TUIContactLog.i(ContactPresenter.TAG, "load data source success , loadType = 5");
                ContactPresenter.this.onDataLoaded(list);
            }
        });
    }

    public void onFriendInfoChanged(List<ContactItemBean> list) {
        for (ContactItemBean contactItemBean : list) {
            int i2 = 0;
            while (true) {
                if (i2 >= this.dataSource.size()) {
                    break;
                } else if (TextUtils.equals(this.dataSource.get(i2).getId(), contactItemBean.getId())) {
                    this.dataSource.set(i2, contactItemBean);
                    break;
                } else {
                    i2++;
                }
            }
        }
        notifyDataSourceChanged();
    }

    public void onFriendRemarkChanged(String str, String str2) {
        loadDataSource(4);
    }

    public void sendGroupTipsMessage(String str, String str2, IUIKitCallback<String> iUIKitCallback) {
        this.provider.sendGroupTipsMessage(str, str2, iUIKitCallback);
    }

    public void setBlackListListener() {
        this.blackListListener = new ContactEventListener() { // from class: com.tencent.qcloud.tuikit.tuicontact.presenter.ContactPresenter.2
            {
                ContactPresenter.this = this;
            }

            @Override // com.tencent.qcloud.tuikit.tuicontact.interfaces.ContactEventListener
            public void onBlackListAdd(List<ContactItemBean> list) {
                ContactPresenter.this.onDataListAdd(list);
            }

            @Override // com.tencent.qcloud.tuikit.tuicontact.interfaces.ContactEventListener
            public void onBlackListDeleted(List<String> list) {
                ContactPresenter.this.onDataListDeleted(list);
            }
        };
        TUIContactService.getInstance().addContactEventListener(this.blackListListener);
    }

    public void setContactListView(IContactListView iContactListView) {
        this.contactListView = iContactListView;
    }

    public void setFriendListListener() {
        this.friendListListener = new ContactEventListener() { // from class: com.tencent.qcloud.tuikit.tuicontact.presenter.ContactPresenter.1
            {
                ContactPresenter.this = this;
            }

            @Override // com.tencent.qcloud.tuikit.tuicontact.interfaces.ContactEventListener
            public void onFriendApplicationListAdded(List<FriendApplicationBean> list) {
                if (ContactPresenter.this.contactListView != null) {
                    ContactPresenter.this.contactListView.onFriendApplicationChanged();
                }
            }

            @Override // com.tencent.qcloud.tuikit.tuicontact.interfaces.ContactEventListener
            public void onFriendApplicationListDeleted(List<String> list) {
                if (ContactPresenter.this.contactListView != null) {
                    ContactPresenter.this.contactListView.onFriendApplicationChanged();
                }
            }

            @Override // com.tencent.qcloud.tuikit.tuicontact.interfaces.ContactEventListener
            public void onFriendInfoChanged(List<ContactItemBean> list) {
                ContactPresenter.this.onFriendInfoChanged(list);
            }

            @Override // com.tencent.qcloud.tuikit.tuicontact.interfaces.ContactEventListener
            public void onFriendListAdded(List<ContactItemBean> list) {
                ContactPresenter.this.onDataListAdd(list);
            }

            @Override // com.tencent.qcloud.tuikit.tuicontact.interfaces.ContactEventListener
            public void onFriendListDeleted(List<String> list) {
                ContactPresenter.this.onDataListDeleted(list);
            }

            @Override // com.tencent.qcloud.tuikit.tuicontact.interfaces.ContactEventListener
            public void onFriendRemarkChanged(String str, String str2) {
                ContactPresenter.this.onFriendRemarkChanged(str, str2);
            }
        };
        TUIContactService.getInstance().addContactEventListener(this.friendListListener);
    }

    public void setIsForCall(boolean z) {
        this.isSelectForCall = z;
    }
}
