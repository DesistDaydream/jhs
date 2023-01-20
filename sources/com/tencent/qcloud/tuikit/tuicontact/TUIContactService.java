package com.tencent.qcloud.tuikit.tuicontact;

import android.content.Context;
import com.tencent.imsdk.v2.V2TIMFriendApplication;
import com.tencent.imsdk.v2.V2TIMFriendInfo;
import com.tencent.imsdk.v2.V2TIMFriendshipListener;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.qcloud.tuicore.ServiceInitializer;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuicore.TUICore;
import com.tencent.qcloud.tuikit.tuicontact.bean.ContactItemBean;
import com.tencent.qcloud.tuikit.tuicontact.bean.FriendApplicationBean;
import com.tencent.qcloud.tuikit.tuicontact.interfaces.ContactEventListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class TUIContactService extends ServiceInitializer implements ITUIContactService {
    public static final String TAG = TUIContactService.class.getSimpleName();
    private static Context appContext;
    private static TUIContactService instance;
    private final List<WeakReference<ContactEventListener>> contactEventListenerList = new ArrayList();

    public static Context getAppContext() {
        return appContext;
    }

    public static TUIContactService getInstance() {
        return instance;
    }

    private void initEvent() {
        TUICore.registerEvent(TUIConstants.TUIContact.EVENT_FRIEND_INFO_CHANGED, TUIConstants.TUIContact.EVENT_SUB_KEY_FRIEND_REMARK_CHANGED, this);
    }

    private void initIMListener() {
        V2TIMManager.getFriendshipManager().addFriendListener(new V2TIMFriendshipListener() { // from class: com.tencent.qcloud.tuikit.tuicontact.TUIContactService.1
            @Override // com.tencent.imsdk.v2.V2TIMFriendshipListener
            public void onBlackListAdd(List<V2TIMFriendInfo> list) {
                List<ContactEventListener> contactEventListenerList = TUIContactService.getInstance().getContactEventListenerList();
                ArrayList arrayList = new ArrayList();
                for (V2TIMFriendInfo v2TIMFriendInfo : list) {
                    ContactItemBean contactItemBean = new ContactItemBean();
                    contactItemBean.covertTIMFriend(v2TIMFriendInfo);
                    arrayList.add(contactItemBean);
                }
                for (ContactEventListener contactEventListener : contactEventListenerList) {
                    contactEventListener.onBlackListAdd(arrayList);
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMFriendshipListener
            public void onBlackListDeleted(List<String> list) {
                for (ContactEventListener contactEventListener : TUIContactService.getInstance().getContactEventListenerList()) {
                    contactEventListener.onBlackListDeleted(list);
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMFriendshipListener
            public void onFriendApplicationListAdded(List<V2TIMFriendApplication> list) {
                List<ContactEventListener> contactEventListenerList = TUIContactService.getInstance().getContactEventListenerList();
                ArrayList arrayList = new ArrayList();
                for (V2TIMFriendApplication v2TIMFriendApplication : list) {
                    FriendApplicationBean friendApplicationBean = new FriendApplicationBean();
                    friendApplicationBean.convertFromTimFriendApplication(v2TIMFriendApplication);
                    arrayList.add(friendApplicationBean);
                }
                for (ContactEventListener contactEventListener : contactEventListenerList) {
                    contactEventListener.onFriendApplicationListAdded(arrayList);
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMFriendshipListener
            public void onFriendApplicationListDeleted(List<String> list) {
                for (ContactEventListener contactEventListener : TUIContactService.getInstance().getContactEventListenerList()) {
                    contactEventListener.onFriendApplicationListDeleted(list);
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMFriendshipListener
            public void onFriendApplicationListRead() {
                for (ContactEventListener contactEventListener : TUIContactService.getInstance().getContactEventListenerList()) {
                    contactEventListener.onFriendApplicationListRead();
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMFriendshipListener
            public void onFriendInfoChanged(List<V2TIMFriendInfo> list) {
                List<ContactEventListener> contactEventListenerList = TUIContactService.getInstance().getContactEventListenerList();
                ArrayList arrayList = new ArrayList();
                for (V2TIMFriendInfo v2TIMFriendInfo : list) {
                    ContactItemBean contactItemBean = new ContactItemBean();
                    contactItemBean.setFriend(true);
                    contactItemBean.covertTIMFriend(v2TIMFriendInfo);
                    arrayList.add(contactItemBean);
                }
                for (ContactEventListener contactEventListener : contactEventListenerList) {
                    contactEventListener.onFriendInfoChanged(arrayList);
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMFriendshipListener
            public void onFriendListAdded(List<V2TIMFriendInfo> list) {
                List<ContactEventListener> contactEventListenerList = TUIContactService.getInstance().getContactEventListenerList();
                ArrayList arrayList = new ArrayList();
                for (V2TIMFriendInfo v2TIMFriendInfo : list) {
                    ContactItemBean contactItemBean = new ContactItemBean();
                    contactItemBean.setFriend(true);
                    contactItemBean.covertTIMFriend(v2TIMFriendInfo);
                    arrayList.add(contactItemBean);
                }
                for (ContactEventListener contactEventListener : contactEventListenerList) {
                    contactEventListener.onFriendListAdded(arrayList);
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMFriendshipListener
            public void onFriendListDeleted(List<String> list) {
                for (ContactEventListener contactEventListener : TUIContactService.getInstance().getContactEventListenerList()) {
                    contactEventListener.onFriendListDeleted(list);
                }
                HashMap hashMap = new HashMap();
                hashMap.put(TUIConstants.TUIContact.FRIEND_ID_LIST, new ArrayList(list));
                TUICore.notifyEvent(TUIConstants.TUIContact.EVENT_FRIEND_STATE_CHANGED, TUIConstants.TUIContact.EVENT_SUB_KEY_FRIEND_DELETE, hashMap);
            }
        });
    }

    private void initService() {
        TUICore.registerService("TUIContactService", this);
    }

    public void addContactEventListener(ContactEventListener contactEventListener) {
        WeakReference<ContactEventListener> weakReference = new WeakReference<>(contactEventListener);
        Iterator<WeakReference<ContactEventListener>> it = this.contactEventListenerList.iterator();
        while (it.hasNext()) {
            WeakReference<ContactEventListener> next = it.next();
            if (next.get() == null) {
                it.remove();
            } else if (next.get() == contactEventListener) {
                return;
            }
        }
        this.contactEventListenerList.add(weakReference);
    }

    public List<ContactEventListener> getContactEventListenerList() {
        ArrayList arrayList = new ArrayList();
        Iterator<WeakReference<ContactEventListener>> it = this.contactEventListenerList.iterator();
        while (it.hasNext()) {
            WeakReference<ContactEventListener> next = it.next();
            if (next.get() == null) {
                it.remove();
            } else {
                arrayList.add(next.get());
            }
        }
        return arrayList;
    }

    @Override // com.tencent.qcloud.tuicore.ServiceInitializer
    public int getLightThemeResId() {
        return R.style.TUIContactLightTheme;
    }

    @Override // com.tencent.qcloud.tuicore.ServiceInitializer
    public int getLivelyThemeResId() {
        return R.style.TUIContactLivelyTheme;
    }

    @Override // com.tencent.qcloud.tuicore.ServiceInitializer
    public int getSeriousThemeResId() {
        return R.style.TUIContactSeriousTheme;
    }

    @Override // com.tencent.qcloud.tuicore.ServiceInitializer
    public void init(Context context) {
        instance = this;
        appContext = context;
        initService();
        initEvent();
        initIMListener();
    }

    @Override // com.tencent.qcloud.tuikit.tuicontact.ITUIContactService, com.tencent.qcloud.tuicore.interfaces.ITUIService
    public Object onCall(String str, Map<String, Object> map) {
        return null;
    }

    @Override // com.tencent.qcloud.tuikit.tuicontact.ITUIContactService, com.tencent.qcloud.tuicore.interfaces.ITUINotification
    public void onNotifyEvent(String str, String str2, Map<String, Object> map) {
        if (str.equals(TUIConstants.TUIContact.EVENT_FRIEND_INFO_CHANGED) && str2.equals(TUIConstants.TUIContact.EVENT_SUB_KEY_FRIEND_REMARK_CHANGED)) {
            List<ContactEventListener> contactEventListenerList = getInstance().getContactEventListenerList();
            if (map == null || map.isEmpty()) {
                return;
            }
            String str3 = (String) map.get(TUIConstants.TUIContact.FRIEND_ID);
            String str4 = (String) map.get(TUIConstants.TUIContact.FRIEND_REMARK);
            for (ContactEventListener contactEventListener : contactEventListenerList) {
                contactEventListener.onFriendRemarkChanged(str3, str4);
            }
        }
    }
}
