package com.tencent.imsdk.relationship;

import com.tencent.imsdk.BaseConstants;
import com.tencent.imsdk.common.IMCallback;
import com.tencent.imsdk.common.IMContext;
import com.tencent.imsdk.manager.BaseManager;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes3.dex */
public class RelationshipManager {
    private FriendshipListener mFriendshipInternalListener;
    private FriendshipListener mFriendshipListener;

    /* loaded from: classes3.dex */
    public static class RelationshipManagerHolder {
        private static final RelationshipManager relationshipManager = new RelationshipManager();

        private RelationshipManagerHolder() {
        }
    }

    public static RelationshipManager getInstance() {
        return RelationshipManagerHolder.relationshipManager;
    }

    private void initFriendshipListener() {
        if (this.mFriendshipInternalListener == null) {
            this.mFriendshipInternalListener = new FriendshipListener() { // from class: com.tencent.imsdk.relationship.RelationshipManager.1
                @Override // com.tencent.imsdk.relationship.FriendshipListener
                public void OnBlackListAdded(final List<FriendInfo> list) {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.relationship.RelationshipManager.1.4
                        @Override // java.lang.Runnable
                        public void run() {
                            if (RelationshipManager.this.mFriendshipListener != null) {
                                RelationshipManager.this.mFriendshipListener.OnBlackListAdded(list);
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.relationship.FriendshipListener
                public void OnBlackListDeleted(final List<String> list) {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.relationship.RelationshipManager.1.5
                        @Override // java.lang.Runnable
                        public void run() {
                            if (RelationshipManager.this.mFriendshipListener != null) {
                                RelationshipManager.this.mFriendshipListener.OnBlackListDeleted(list);
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.relationship.FriendshipListener
                public void OnFriendApplicationListAdded(final List<FriendApplication> list) {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.relationship.RelationshipManager.1.6
                        @Override // java.lang.Runnable
                        public void run() {
                            if (RelationshipManager.this.mFriendshipListener != null) {
                                RelationshipManager.this.mFriendshipListener.OnFriendApplicationListAdded(list);
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.relationship.FriendshipListener
                public void OnFriendApplicationListDelete(final List<String> list) {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.relationship.RelationshipManager.1.7
                        @Override // java.lang.Runnable
                        public void run() {
                            if (RelationshipManager.this.mFriendshipListener != null) {
                                RelationshipManager.this.mFriendshipListener.OnFriendApplicationListDelete(list);
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.relationship.FriendshipListener
                public void OnFriendApplicationListRead() {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.relationship.RelationshipManager.1.8
                        @Override // java.lang.Runnable
                        public void run() {
                            if (RelationshipManager.this.mFriendshipListener != null) {
                                RelationshipManager.this.mFriendshipListener.OnFriendApplicationListRead();
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.relationship.FriendshipListener
                public void OnFriendInfoChanged(final List<FriendInfo> list) {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.relationship.RelationshipManager.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (RelationshipManager.this.mFriendshipListener != null) {
                                RelationshipManager.this.mFriendshipListener.OnFriendInfoChanged(list);
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.relationship.FriendshipListener
                public void OnFriendListAdded(final List<FriendInfo> list) {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.relationship.RelationshipManager.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (RelationshipManager.this.mFriendshipListener != null) {
                                RelationshipManager.this.mFriendshipListener.OnFriendListAdded(list);
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.relationship.FriendshipListener
                public void OnFriendListDeleted(final List<String> list) {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.relationship.RelationshipManager.1.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (RelationshipManager.this.mFriendshipListener != null) {
                                RelationshipManager.this.mFriendshipListener.OnFriendListDeleted(list);
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.relationship.FriendshipListener
                public void OnSelfInfoUpdated(UserInfo userInfo) {
                    BaseManager.getInstance().notifySelfInfoUpdated(userInfo);
                }
            };
        }
        nativeSetFriendshipListener(this.mFriendshipInternalListener);
    }

    public void addFriend(FriendAddApplication friendAddApplication, IMCallback<FriendOperationResult> iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeAddFriend(friendAddApplication, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void addFriendsToFriendGroup(String str, List<String> list, IMCallback<List<FriendOperationResult>> iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeAddFriendsToFriendGroup(str, list, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void addToBlackList(List<String> list, IMCallback<List<FriendOperationResult>> iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeAddToBlackList(list, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void checkFriend(List<String> list, int i2, IMCallback<List<FriendCheckResult>> iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeCheckFriend(list, i2, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void createFriendGroup(String str, List<String> list, IMCallback<List<FriendOperationResult>> iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeCreateFromGroup(str, list, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void deleteFrendsFromFriendGroup(String str, List<String> list, IMCallback<List<FriendOperationResult>> iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeDeleteFriendsFromFriendGroup(str, list, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void deleteFriendApplication(int i2, String str, IMCallback iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeDeleteFriendApplication(i2, str, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void deleteFriendGroup(List<String> list, IMCallback iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeDeleteFriendGroup(list, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void deleteFromBlackList(List<String> list, IMCallback<List<FriendOperationResult>> iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeDeleteFromBlackList(list, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void deleteFromFriendList(List<String> list, int i2, IMCallback<List<FriendOperationResult>> iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeDeleteFromFriendList(list, i2, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void getBlackList(IMCallback<List<FriendInfo>> iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeGetBlackList(iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void getC2CReceiveMessageOpt(List<String> list, IMCallback<List<ReceiveMessageOptInfo>> iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeGetC2CReceiveMessageOpt(list, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void getFriendApplicationList(IMCallback<FriendApplicationResult> iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeGetFriendApplicationList(iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void getFriendGroups(List<String> list, IMCallback<List<FriendGroup>> iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeGetFriendGroups(list, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void getFriendList(IMCallback<List<FriendInfo>> iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeGetFriendList(iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void getFriendsInfo(List<String> list, IMCallback<List<FriendInfoResult>> iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeGetFriendsInfo(list, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void getUsersInfo(List<String> list, IMCallback<List<UserInfo>> iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeGetUsersInfo(list, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void init() {
        initFriendshipListener();
    }

    public native void nativeAddFriend(FriendAddApplication friendAddApplication, IMCallback iMCallback);

    public native void nativeAddFriendsToFriendGroup(String str, List<String> list, IMCallback iMCallback);

    public native void nativeAddToBlackList(List<String> list, IMCallback iMCallback);

    public native void nativeCheckFriend(List<String> list, int i2, IMCallback iMCallback);

    public native void nativeCreateFromGroup(String str, List<String> list, IMCallback iMCallback);

    public native void nativeDeleteFriendApplication(int i2, String str, IMCallback iMCallback);

    public native void nativeDeleteFriendGroup(List<String> list, IMCallback iMCallback);

    public native void nativeDeleteFriendsFromFriendGroup(String str, List<String> list, IMCallback iMCallback);

    public native void nativeDeleteFromBlackList(List<String> list, IMCallback iMCallback);

    public native void nativeDeleteFromFriendList(List<String> list, int i2, IMCallback iMCallback);

    public native void nativeGetBlackList(IMCallback iMCallback);

    public native void nativeGetC2CReceiveMessageOpt(List<String> list, IMCallback<List<ReceiveMessageOptInfo>> iMCallback);

    public native void nativeGetFriendApplicationList(IMCallback iMCallback);

    public native void nativeGetFriendGroups(List<String> list, IMCallback iMCallback);

    public native void nativeGetFriendList(IMCallback iMCallback);

    public native void nativeGetFriendsInfo(List<String> list, IMCallback iMCallback);

    public native void nativeGetUsersInfo(List<String> list, IMCallback<List<UserInfo>> iMCallback);

    public native void nativeRenameFriendGroup(String str, String str2, IMCallback iMCallback);

    public native void nativeResponseFriendApplication(FriendResponse friendResponse, IMCallback iMCallback);

    public native void nativeSearchFriends(FriendSearchParam friendSearchParam, IMCallback iMCallback);

    public native void nativeSetC2CReceiveMessageOpt(List<String> list, int i2, IMCallback iMCallback);

    public native void nativeSetFriendApplicationRead(IMCallback iMCallback);

    public native void nativeSetFriendInfo(String str, HashMap<String, Object> hashMap, IMCallback iMCallback);

    public native void nativeSetFriendshipListener(FriendshipListener friendshipListener);

    public native void nativeSetSelfInfo(HashMap<String, Object> hashMap, IMCallback iMCallback);

    public void renameFriendGroup(String str, String str2, IMCallback iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeRenameFriendGroup(str, str2, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void responseFriendApplication(FriendResponse friendResponse, IMCallback<FriendOperationResult> iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeResponseFriendApplication(friendResponse, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void searchFriends(FriendSearchParam friendSearchParam, IMCallback<List<FriendInfoResult>> iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeSearchFriends(friendSearchParam, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void setC2CReceiveMessageOpt(List<String> list, int i2, IMCallback iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeSetC2CReceiveMessageOpt(list, i2, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void setFriendApplicationRead(IMCallback iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeSetFriendApplicationRead(iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void setFriendInfo(String str, HashMap<String, Object> hashMap, IMCallback iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeSetFriendInfo(str, hashMap, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void setFriendshipListener(FriendshipListener friendshipListener) {
        this.mFriendshipListener = friendshipListener;
    }

    public void setSelfInfo(HashMap<String, Object> hashMap, IMCallback iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeSetSelfInfo(hashMap, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }
}
