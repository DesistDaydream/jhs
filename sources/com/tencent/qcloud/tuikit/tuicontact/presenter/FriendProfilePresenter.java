package com.tencent.qcloud.tuikit.tuicontact.presenter;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuicore.TUICore;
import com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback;
import com.tencent.qcloud.tuicore.util.BackgroundTasks;
import com.tencent.qcloud.tuicore.util.ThreadHelper;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.tuicontact.R;
import com.tencent.qcloud.tuikit.tuicontact.TUIContactService;
import com.tencent.qcloud.tuikit.tuicontact.bean.ContactGroupApplyInfo;
import com.tencent.qcloud.tuikit.tuicontact.bean.ContactItemBean;
import com.tencent.qcloud.tuikit.tuicontact.bean.FriendApplicationBean;
import com.tencent.qcloud.tuikit.tuicontact.model.ContactProvider;
import com.tencent.qcloud.tuikit.tuicontact.ui.interfaces.IFriendProfileLayout;
import com.tencent.qcloud.tuikit.tuicontact.util.ContactUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes3.dex */
public class FriendProfilePresenter {
    private static final String TAG = "FriendProfilePresenter";
    private IFriendProfileLayout friendProfileLayout;
    private final ContactProvider provider = new ContactProvider();

    /* renamed from: com.tencent.qcloud.tuikit.tuicontact.presenter.FriendProfilePresenter$3  reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass3 extends IUIKitCallback<List<ContactItemBean>> {
        public final /* synthetic */ ContactItemBean val$bean;
        public final /* synthetic */ String val$id;

        public AnonymousClass3(ContactItemBean contactItemBean, String str) {
            this.val$bean = contactItemBean;
            this.val$id = str;
        }

        @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
        public void onError(String str, int i2, String str2) {
            ToastUtil.toastShortMessage("getUsersInfo error , code = " + i2 + ", desc = " + str2);
        }

        @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
        public void onSuccess(List<ContactItemBean> list) {
            if (list == null || list.size() != 1) {
                return;
            }
            ContactItemBean contactItemBean = list.get(0);
            this.val$bean.setNickName(contactItemBean.getNickName());
            this.val$bean.setId(contactItemBean.getId());
            this.val$bean.setAvatarUrl(contactItemBean.getAvatarUrl());
            this.val$bean.setSignature(contactItemBean.getSignature());
            final CountDownLatch countDownLatch = new CountDownLatch(2);
            ThreadHelper threadHelper = ThreadHelper.INST;
            threadHelper.execute(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuicontact.presenter.FriendProfilePresenter.3.1
                @Override // java.lang.Runnable
                public void run() {
                    AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                    FriendProfilePresenter.this.isInBlackList(anonymousClass3.val$id, new IUIKitCallback<Boolean>() { // from class: com.tencent.qcloud.tuikit.tuicontact.presenter.FriendProfilePresenter.3.1.1
                        @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                        public void onError(String str, int i2, String str2) {
                            countDownLatch.countDown();
                        }

                        @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                        public void onSuccess(Boolean bool) {
                            AnonymousClass3.this.val$bean.setBlackList(bool.booleanValue());
                            countDownLatch.countDown();
                        }
                    });
                }
            });
            threadHelper.execute(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuicontact.presenter.FriendProfilePresenter.3.2
                @Override // java.lang.Runnable
                public void run() {
                    AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                    FriendProfilePresenter.this.isFriend(anonymousClass3.val$id, anonymousClass3.val$bean, new IUIKitCallback<Boolean>() { // from class: com.tencent.qcloud.tuikit.tuicontact.presenter.FriendProfilePresenter.3.2.1
                        @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                        public void onError(String str, int i2, String str2) {
                            countDownLatch.countDown();
                        }

                        @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
                        public void onSuccess(Boolean bool) {
                            AnonymousClass3.this.val$bean.setFriend(bool.booleanValue());
                            countDownLatch.countDown();
                        }
                    });
                }
            });
            threadHelper.execute(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuicontact.presenter.FriendProfilePresenter.3.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        countDownLatch.await();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                    BackgroundTasks.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuicontact.presenter.FriendProfilePresenter.3.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (FriendProfilePresenter.this.friendProfileLayout != null) {
                                FriendProfilePresenter.this.friendProfileLayout.onDataSourceChanged(AnonymousClass3.this.val$bean);
                            }
                        }
                    });
                }
            });
        }
    }

    public void acceptFriendApplication(FriendApplicationBean friendApplicationBean, int i2, IUIKitCallback<Void> iUIKitCallback) {
        this.provider.acceptFriendApplication(friendApplicationBean, i2, iUIKitCallback);
    }

    public void acceptJoinGroupApply(ContactGroupApplyInfo contactGroupApplyInfo, IUIKitCallback<Void> iUIKitCallback) {
        this.provider.acceptJoinGroupApply(contactGroupApplyInfo, iUIKitCallback);
    }

    public void addFriend(String str, String str2, String str3, String str4, final IUIKitCallback<Pair<Integer, String>> iUIKitCallback) {
        this.provider.addFriend(str, str2, str3, str4, new IUIKitCallback<Pair<Integer, String>>() { // from class: com.tencent.qcloud.tuikit.tuicontact.presenter.FriendProfilePresenter.8
            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str5, int i2, String str6) {
                ContactUtils.callbackOnError(iUIKitCallback, i2, str6);
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(Pair<Integer, String> pair) {
                String string;
                int intValue = ((Integer) pair.first).intValue();
                if (intValue == 0) {
                    string = TUIContactService.getAppContext().getString(R.string.success);
                } else if (intValue == 30001) {
                    if (TextUtils.equals((CharSequence) pair.second, "Err_SNS_FriendAdd_Friend_Exist")) {
                        string = TUIContactService.getAppContext().getString(R.string.have_be_friend);
                    }
                    string = TUIContactService.getAppContext().getString(R.string.friend_limit);
                } else {
                    if (intValue != 30010) {
                        if (intValue == 30014) {
                            string = TUIContactService.getAppContext().getString(R.string.other_friend_limit);
                        } else if (intValue == 30525) {
                            string = TUIContactService.getAppContext().getString(R.string.set_in_blacklist);
                        } else if (intValue == 30539) {
                            string = TUIContactService.getAppContext().getString(R.string.wait_agree_friend);
                        } else if (intValue == 30515) {
                            string = TUIContactService.getAppContext().getString(R.string.in_blacklist);
                        } else if (intValue != 30516) {
                            string = TUIContactService.getAppContext().getString(R.string.other_friend_limit);
                            ToastUtil.toastLongMessage(pair.first + ExpandableTextView.N + ((String) pair.second));
                        } else {
                            string = TUIContactService.getAppContext().getString(R.string.forbid_add_friend);
                        }
                    }
                    string = TUIContactService.getAppContext().getString(R.string.friend_limit);
                }
                ContactUtils.callbackOnSuccess(iUIKitCallback, new Pair(Integer.valueOf(intValue), string));
            }
        });
    }

    public void addToBlackList(List<String> list) {
        this.provider.addToBlackList(list, new IUIKitCallback<Void>() { // from class: com.tencent.qcloud.tuikit.tuicontact.presenter.FriendProfilePresenter.6
            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str, int i2, String str2) {
                ToastUtil.toastShortMessage("addToBlackList Error code = " + i2 + ", desc = " + str2);
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(Void r1) {
            }
        });
    }

    public void deleteFriend(final List<String> list, final IUIKitCallback<Void> iUIKitCallback) {
        this.provider.deleteFriend(list, new IUIKitCallback<Void>() { // from class: com.tencent.qcloud.tuikit.tuicontact.presenter.FriendProfilePresenter.7
            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str, int i2, String str2) {
                ContactUtils.callbackOnError(iUIKitCallback, str, i2, str2);
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(Void r5) {
                for (String str : list) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(TUIConstants.TUIConversation.CONVERSATION_ID, "c2c_" + str);
                    hashMap.put("chatId", str);
                    hashMap.put(TUIConstants.TUIChat.IS_GROUP_CHAT, Boolean.FALSE);
                    TUICore.callService("TUIConversationService", TUIConstants.TUIConversation.METHOD_DELETE_CONVERSATION, hashMap);
                    TUICore.callService("TUIChatService", TUIConstants.TUIChat.METHOD_EXIT_CHAT, hashMap);
                }
                ContactUtils.callbackOnSuccess(iUIKitCallback, null);
            }
        });
    }

    public void deleteFromBlackList(List<String> list) {
        this.provider.deleteFromBlackList(list, new IUIKitCallback<Void>() { // from class: com.tencent.qcloud.tuikit.tuicontact.presenter.FriendProfilePresenter.5
            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str, int i2, String str2) {
                ToastUtil.toastShortMessage("deleteFromBlackList Error code = " + i2 + ", desc = " + str2);
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(Void r1) {
            }
        });
    }

    public void getC2CReceiveMessageOpt(List<String> list, final IUIKitCallback<Boolean> iUIKitCallback) {
        this.provider.getC2CReceiveMessageOpt(list, new IUIKitCallback<Boolean>() { // from class: com.tencent.qcloud.tuikit.tuicontact.presenter.FriendProfilePresenter.1
            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str, int i2, String str2) {
                ContactUtils.callbackOnError(iUIKitCallback, FriendProfilePresenter.TAG, i2, str2);
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(Boolean bool) {
                ContactUtils.callbackOnSuccess(iUIKitCallback, bool);
            }
        });
    }

    public void getUsersInfo(String str, ContactItemBean contactItemBean) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        this.provider.getUserInfo(arrayList, new AnonymousClass3(contactItemBean, str));
    }

    public void isFriend(String str, ContactItemBean contactItemBean, IUIKitCallback<Boolean> iUIKitCallback) {
        this.provider.isFriend(str, contactItemBean, iUIKitCallback);
    }

    public void isInBlackList(String str, final IUIKitCallback<Boolean> iUIKitCallback) {
        this.provider.isInBlackList(str, new IUIKitCallback<Boolean>() { // from class: com.tencent.qcloud.tuikit.tuicontact.presenter.FriendProfilePresenter.4
            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str2, int i2, String str3) {
                ToastUtil.toastShortMessage("getBlackList error , code = " + i2 + ", desc = " + str3);
                ContactUtils.callbackOnError(iUIKitCallback, i2, str3);
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(Boolean bool) {
                ContactUtils.callbackOnSuccess(iUIKitCallback, bool);
            }
        });
    }

    public boolean isTopConversation(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("chatId", str);
        Object callService = TUICore.callService("TUIConversationService", TUIConstants.TUIConversation.METHOD_IS_TOP_CONVERSATION, hashMap);
        if (callService instanceof Bundle) {
            return ((Bundle) callService).getBoolean(TUIConstants.TUIConversation.IS_TOP, false);
        }
        return false;
    }

    public void joinGroup(String str, String str2, final IUIKitCallback<Void> iUIKitCallback) {
        this.provider.joinGroup(str, str2, new IUIKitCallback<Void>() { // from class: com.tencent.qcloud.tuikit.tuicontact.presenter.FriendProfilePresenter.9
            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str3, int i2, String str4) {
                if (i2 == 10007) {
                    str4 = TUIContactService.getAppContext().getString(R.string.add_group_permission_deny);
                } else if (i2 == 10013) {
                    str4 = TUIContactService.getAppContext().getString(R.string.add_group_allready_member);
                } else if (i2 == 10010) {
                    str4 = TUIContactService.getAppContext().getString(R.string.add_group_not_found);
                } else if (i2 == 10014) {
                    str4 = TUIContactService.getAppContext().getString(R.string.add_group_full_member);
                }
                ContactUtils.callbackOnError(iUIKitCallback, i2, str4);
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(Void r2) {
                ContactUtils.callbackOnSuccess(iUIKitCallback, null);
            }
        });
    }

    public void modifyRemark(String str, String str2, IUIKitCallback<String> iUIKitCallback) {
        this.provider.modifyRemark(str, str2, iUIKitCallback);
    }

    public void refuseFriendApplication(FriendApplicationBean friendApplicationBean, IUIKitCallback<Void> iUIKitCallback) {
        this.provider.refuseFriendApplication(friendApplicationBean, iUIKitCallback);
    }

    public void refuseJoinGroupApply(ContactGroupApplyInfo contactGroupApplyInfo, String str, IUIKitCallback<Void> iUIKitCallback) {
        this.provider.refuseJoinGroupApply(contactGroupApplyInfo, str, iUIKitCallback);
    }

    public void setC2CReceiveMessageOpt(List<String> list, boolean z) {
        this.provider.setC2CReceiveMessageOpt(list, z, new IUIKitCallback<Void>() { // from class: com.tencent.qcloud.tuikit.tuicontact.presenter.FriendProfilePresenter.2
            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onError(String str, int i2, String str2) {
            }

            @Override // com.tencent.qcloud.tuicore.component.interfaces.IUIKitCallback
            public void onSuccess(Void r1) {
            }
        });
    }

    public void setConversationTop(String str, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("chatId", str);
        hashMap.put(TUIConstants.TUIConversation.IS_SET_TOP, Boolean.valueOf(z));
        TUICore.callService("TUIConversationService", TUIConstants.TUIConversation.METHOD_SET_TOP_CONVERSATION, hashMap);
    }

    public void setFriendProfileLayout(IFriendProfileLayout iFriendProfileLayout) {
        this.friendProfileLayout = iFriendProfileLayout;
    }
}
