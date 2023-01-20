package com.tencent.qcloud.tuicore;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.imsdk.v2.V2TIMCallback;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMSDKConfig;
import com.tencent.imsdk.v2.V2TIMSDKListener;
import com.tencent.imsdk.v2.V2TIMUserFullInfo;
import com.tencent.imsdk.v2.V2TIMValueCallback;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuicore.interfaces.TUICallback;
import com.tencent.qcloud.tuicore.interfaces.TUILoginListener;
import com.tencent.qcloud.tuicore.util.ErrorMessageConverter;
import e.s.a.a.a.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes3.dex */
public class TUILogin {
    private static final String TAG = "TUILogin";
    private Context appContext;
    private boolean hasLoginSuccess;
    private final V2TIMSDKListener imSdkListener;
    private final List<TUILoginListener> listenerList;
    private int sdkAppId;
    private String userId;
    private String userSig;

    /* loaded from: classes3.dex */
    public static class TUILoginHolder {
        private static final TUILogin loginInstance = new TUILogin();

        private TUILoginHolder() {
        }
    }

    public static void addLoginListener(TUILoginListener tUILoginListener) {
        getInstance().internalAddLoginListener(tUILoginListener);
    }

    public static Context getAppContext() {
        return getInstance().appContext;
    }

    public static String getFaceUrl() {
        return TUIConfig.getSelfFaceUrl();
    }

    public static TUILogin getInstance() {
        return TUILoginHolder.loginInstance;
    }

    public static String getLoginUser() {
        return V2TIMManager.getInstance().getLoginUser();
    }

    public static String getNickName() {
        return TUIConfig.getSelfNickName();
    }

    public static int getSdkAppId() {
        return getInstance().sdkAppId;
    }

    public static String getUserId() {
        return getInstance().userId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void getUserInfo(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        V2TIMManager.getInstance().getUsersInfo(arrayList, new V2TIMValueCallback<List<V2TIMUserFullInfo>>() { // from class: com.tencent.qcloud.tuicore.TUILogin.7
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i2, String str2) {
                String str3 = TUILogin.TAG;
                Log.e(str3, "get logined userInfo failed. code : " + i2 + " desc : " + ErrorMessageConverter.convertIMError(i2, str2));
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(List<V2TIMUserFullInfo> list) {
                if (list.isEmpty()) {
                    Log.e(TUILogin.TAG, "get logined userInfo failed. list is empty");
                    return;
                }
                V2TIMUserFullInfo v2TIMUserFullInfo = list.get(0);
                TUIConfig.setSelfInfo(v2TIMUserFullInfo);
                TUILogin.notifyUserInfoChanged(v2TIMUserFullInfo);
            }
        });
    }

    public static String getUserSig() {
        return getInstance().userSig;
    }

    @Deprecated
    public static boolean init(@NonNull Context context, int i2, @Nullable V2TIMSDKConfig v2TIMSDKConfig, @Nullable final V2TIMSDKListener v2TIMSDKListener) {
        if (getInstance().sdkAppId != 0 && i2 != getInstance().sdkAppId) {
            logout((V2TIMCallback) null);
            unInit();
        }
        getInstance().appContext = context;
        getInstance().sdkAppId = i2;
        V2TIMManager.getInstance().addIMSDKListener(new V2TIMSDKListener() { // from class: com.tencent.qcloud.tuicore.TUILogin.4
            @Override // com.tencent.imsdk.v2.V2TIMSDKListener
            public void onConnectFailed(int i3, String str) {
                V2TIMSDKListener v2TIMSDKListener2 = V2TIMSDKListener.this;
                if (v2TIMSDKListener2 != null) {
                    v2TIMSDKListener2.onConnectFailed(i3, ErrorMessageConverter.convertIMError(i3, str));
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMSDKListener
            public void onConnectSuccess() {
                V2TIMSDKListener v2TIMSDKListener2 = V2TIMSDKListener.this;
                if (v2TIMSDKListener2 != null) {
                    v2TIMSDKListener2.onConnectSuccess();
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMSDKListener
            public void onConnecting() {
                V2TIMSDKListener v2TIMSDKListener2 = V2TIMSDKListener.this;
                if (v2TIMSDKListener2 != null) {
                    v2TIMSDKListener2.onConnecting();
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMSDKListener
            public void onKickedOffline() {
                V2TIMSDKListener v2TIMSDKListener2 = V2TIMSDKListener.this;
                if (v2TIMSDKListener2 != null) {
                    v2TIMSDKListener2.onKickedOffline();
                }
                TUICore.notifyEvent(TUIConstants.TUILogin.EVENT_LOGIN_STATE_CHANGED, TUIConstants.TUILogin.EVENT_SUB_KEY_USER_KICKED_OFFLINE, null);
            }

            @Override // com.tencent.imsdk.v2.V2TIMSDKListener
            public void onSelfInfoUpdated(V2TIMUserFullInfo v2TIMUserFullInfo) {
                V2TIMSDKListener v2TIMSDKListener2 = V2TIMSDKListener.this;
                if (v2TIMSDKListener2 != null) {
                    v2TIMSDKListener2.onSelfInfoUpdated(v2TIMUserFullInfo);
                }
                TUIConfig.setSelfInfo(v2TIMUserFullInfo);
                TUILogin.notifyUserInfoChanged(v2TIMUserFullInfo);
            }

            @Override // com.tencent.imsdk.v2.V2TIMSDKListener
            public void onUserSigExpired() {
                V2TIMSDKListener v2TIMSDKListener2 = V2TIMSDKListener.this;
                if (v2TIMSDKListener2 != null) {
                    v2TIMSDKListener2.onUserSigExpired();
                }
                TUICore.notifyEvent(TUIConstants.TUILogin.EVENT_LOGIN_STATE_CHANGED, TUIConstants.TUILogin.EVENT_SUB_KEY_USER_SIG_EXPIRED, null);
            }
        });
        TUICore.notifyEvent(TUIConstants.TUILogin.EVENT_IMSDK_INIT_STATE_CHANGED, TUIConstants.TUILogin.EVENT_SUB_KEY_START_INIT, null);
        return V2TIMManager.getInstance().initSDK(context, i2, v2TIMSDKConfig);
    }

    private void internalAddLoginListener(TUILoginListener tUILoginListener) {
        String str = TAG;
        Log.i(str, "addLoginListener listener : " + tUILoginListener);
        if (tUILoginListener == null || this.listenerList.contains(tUILoginListener)) {
            return;
        }
        this.listenerList.add(tUILoginListener);
    }

    private void internalLogin(Context context, int i2, final String str, String str2, final TUICallback tUICallback) {
        int i3 = this.sdkAppId;
        if (i3 != 0 && i2 != i3) {
            logout((TUICallback) null);
        }
        this.appContext = context;
        this.sdkAppId = i2;
        V2TIMManager.getInstance().addIMSDKListener(this.imSdkListener);
        TUICore.notifyEvent(TUIConstants.TUILogin.EVENT_IMSDK_INIT_STATE_CHANGED, TUIConstants.TUILogin.EVENT_SUB_KEY_START_INIT, null);
        V2TIMSDKConfig v2TIMSDKConfig = new V2TIMSDKConfig();
        v2TIMSDKConfig.setLogLevel(3);
        if (V2TIMManager.getInstance().initSDK(context, i2, v2TIMSDKConfig)) {
            this.userId = str;
            this.userSig = str2;
            if (TextUtils.equals(str, V2TIMManager.getInstance().getLoginUser()) && !TextUtils.isEmpty(str)) {
                a.b(tUICallback);
                getUserInfo(str);
                return;
            }
            V2TIMManager.getInstance().login(str, str2, new V2TIMCallback() { // from class: com.tencent.qcloud.tuicore.TUILogin.2
                @Override // com.tencent.imsdk.v2.V2TIMCallback
                public void onError(int i4, String str3) {
                    a.a(tUICallback, i4, ErrorMessageConverter.convertIMError(i4, str3));
                }

                @Override // com.tencent.imsdk.v2.V2TIMCallback
                public void onSuccess() {
                    TUILogin.this.hasLoginSuccess = true;
                    TUILogin.getUserInfo(str);
                    a.b(tUICallback);
                    TUICore.notifyEvent(TUIConstants.TUILogin.EVENT_LOGIN_STATE_CHANGED, TUIConstants.TUILogin.EVENT_SUB_KEY_USER_LOGIN_SUCCESS, null);
                }
            });
            return;
        }
        a.a(tUICallback, -1, "init failed");
    }

    private void internalLogout(final TUICallback tUICallback) {
        TUICore.notifyEvent(TUIConstants.TUILogin.EVENT_IMSDK_INIT_STATE_CHANGED, TUIConstants.TUILogin.EVENT_SUB_KEY_START_UNINIT, null);
        V2TIMManager.getInstance().logout(new V2TIMCallback() { // from class: com.tencent.qcloud.tuicore.TUILogin.3
            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onError(int i2, String str) {
                a.a(tUICallback, i2, str);
            }

            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onSuccess() {
                TUILogin.this.sdkAppId = 0;
                TUILogin.this.userId = null;
                TUILogin.this.userSig = null;
                V2TIMManager.getInstance().unInitSDK();
                TUIConfig.clearSelfInfo();
                a.b(tUICallback);
                TUICore.notifyEvent(TUIConstants.TUILogin.EVENT_LOGIN_STATE_CHANGED, TUIConstants.TUILogin.EVENT_SUB_KEY_USER_LOGOUT_SUCCESS, null);
            }
        });
    }

    private void internalRemoveLoginListener(TUILoginListener tUILoginListener) {
        String str = TAG;
        Log.i(str, "removeLoginListener listener : " + tUILoginListener);
        if (tUILoginListener == null) {
            return;
        }
        this.listenerList.remove(tUILoginListener);
    }

    public static boolean isUserLogined() {
        return getInstance().hasLoginSuccess && V2TIMManager.getInstance().getLoginStatus() == 1;
    }

    public static void login(@NonNull Context context, int i2, String str, String str2, TUICallback tUICallback) {
        getInstance().internalLogin(context, i2, str, str2, tUICallback);
    }

    public static void logout(TUICallback tUICallback) {
        getInstance().internalLogout(tUICallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void notifyUserInfoChanged(V2TIMUserFullInfo v2TIMUserFullInfo) {
        HashMap hashMap = new HashMap();
        hashMap.put(TUIConstants.TUILogin.SELF_ID, v2TIMUserFullInfo.getUserID());
        hashMap.put(TUIConstants.TUILogin.SELF_SIGNATURE, v2TIMUserFullInfo.getSelfSignature());
        hashMap.put(TUIConstants.TUILogin.SELF_NICK_NAME, v2TIMUserFullInfo.getNickName());
        hashMap.put(TUIConstants.TUILogin.SELF_FACE_URL, v2TIMUserFullInfo.getFaceUrl());
        hashMap.put(TUIConstants.TUILogin.SELF_BIRTHDAY, Long.valueOf(v2TIMUserFullInfo.getBirthday()));
        hashMap.put(TUIConstants.TUILogin.SELF_ROLE, Integer.valueOf(v2TIMUserFullInfo.getRole()));
        hashMap.put(TUIConstants.TUILogin.SELF_GENDER, Integer.valueOf(v2TIMUserFullInfo.getGender()));
        hashMap.put(TUIConstants.TUILogin.SELF_LEVEL, Integer.valueOf(v2TIMUserFullInfo.getLevel()));
        hashMap.put(TUIConstants.TUILogin.SELF_ALLOW_TYPE, Integer.valueOf(v2TIMUserFullInfo.getAllowType()));
        TUICore.notifyEvent(TUIConstants.TUILogin.EVENT_LOGIN_STATE_CHANGED, TUIConstants.TUILogin.EVENT_SUB_KEY_USER_INFO_UPDATED, hashMap);
    }

    public static void removeLoginListener(TUILoginListener tUILoginListener) {
        getInstance().internalRemoveLoginListener(tUILoginListener);
    }

    @Deprecated
    public static void unInit() {
        getInstance().sdkAppId = 0;
        TUICore.notifyEvent(TUIConstants.TUILogin.EVENT_IMSDK_INIT_STATE_CHANGED, TUIConstants.TUILogin.EVENT_SUB_KEY_START_UNINIT, null);
        V2TIMManager.getInstance().unInitSDK();
        TUIConfig.clearSelfInfo();
    }

    private TUILogin() {
        this.sdkAppId = 0;
        this.hasLoginSuccess = false;
        this.listenerList = new CopyOnWriteArrayList();
        this.imSdkListener = new V2TIMSDKListener() { // from class: com.tencent.qcloud.tuicore.TUILogin.1
            @Override // com.tencent.imsdk.v2.V2TIMSDKListener
            public void onConnectFailed(int i2, String str) {
                for (TUILoginListener tUILoginListener : TUILogin.this.listenerList) {
                    tUILoginListener.onConnectFailed(i2, str);
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMSDKListener
            public void onConnectSuccess() {
                for (TUILoginListener tUILoginListener : TUILogin.this.listenerList) {
                    tUILoginListener.onConnectSuccess();
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMSDKListener
            public void onConnecting() {
                for (TUILoginListener tUILoginListener : TUILogin.this.listenerList) {
                    tUILoginListener.onConnecting();
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMSDKListener
            public void onKickedOffline() {
                for (TUILoginListener tUILoginListener : TUILogin.this.listenerList) {
                    tUILoginListener.onKickedOffline();
                }
                TUICore.notifyEvent(TUIConstants.TUILogin.EVENT_LOGIN_STATE_CHANGED, TUIConstants.TUILogin.EVENT_SUB_KEY_USER_KICKED_OFFLINE, null);
            }

            @Override // com.tencent.imsdk.v2.V2TIMSDKListener
            public void onSelfInfoUpdated(V2TIMUserFullInfo v2TIMUserFullInfo) {
                TUIConfig.setSelfInfo(v2TIMUserFullInfo);
                TUILogin.notifyUserInfoChanged(v2TIMUserFullInfo);
            }

            @Override // com.tencent.imsdk.v2.V2TIMSDKListener
            public void onUserSigExpired() {
                for (TUILoginListener tUILoginListener : TUILogin.this.listenerList) {
                    tUILoginListener.onUserSigExpired();
                }
                TUICore.notifyEvent(TUIConstants.TUILogin.EVENT_LOGIN_STATE_CHANGED, TUIConstants.TUILogin.EVENT_SUB_KEY_USER_SIG_EXPIRED, null);
            }
        };
    }

    @Deprecated
    public static void login(@NonNull final String str, @NonNull String str2, @Nullable final V2TIMCallback v2TIMCallback) {
        getInstance().userId = str;
        getInstance().userSig = str2;
        if (TextUtils.equals(str, V2TIMManager.getInstance().getLoginUser()) && !TextUtils.isEmpty(str)) {
            if (v2TIMCallback != null) {
                v2TIMCallback.onSuccess();
            }
            getUserInfo(str);
            return;
        }
        V2TIMManager.getInstance().login(str, str2, new V2TIMCallback() { // from class: com.tencent.qcloud.tuicore.TUILogin.5
            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onError(int i2, String str3) {
                V2TIMCallback v2TIMCallback2 = V2TIMCallback.this;
                if (v2TIMCallback2 != null) {
                    v2TIMCallback2.onError(i2, ErrorMessageConverter.convertIMError(i2, str3));
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onSuccess() {
                TUILogin.getInstance().hasLoginSuccess = true;
                V2TIMCallback v2TIMCallback2 = V2TIMCallback.this;
                if (v2TIMCallback2 != null) {
                    v2TIMCallback2.onSuccess();
                }
                TUILogin.getUserInfo(str);
                TUICore.notifyEvent(TUIConstants.TUILogin.EVENT_LOGIN_STATE_CHANGED, TUIConstants.TUILogin.EVENT_SUB_KEY_USER_LOGIN_SUCCESS, null);
            }
        });
    }

    @Deprecated
    public static void logout(@Nullable final V2TIMCallback v2TIMCallback) {
        V2TIMManager.getInstance().logout(new V2TIMCallback() { // from class: com.tencent.qcloud.tuicore.TUILogin.6
            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onError(int i2, String str) {
                V2TIMCallback v2TIMCallback2 = V2TIMCallback.this;
                if (v2TIMCallback2 != null) {
                    v2TIMCallback2.onError(i2, ErrorMessageConverter.convertIMError(i2, str));
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onSuccess() {
                TUILogin.getInstance().userId = null;
                TUILogin.getInstance().userSig = null;
                V2TIMCallback v2TIMCallback2 = V2TIMCallback.this;
                if (v2TIMCallback2 != null) {
                    v2TIMCallback2.onSuccess();
                }
                TUIConfig.clearSelfInfo();
                TUICore.notifyEvent(TUIConstants.TUILogin.EVENT_LOGIN_STATE_CHANGED, TUIConstants.TUILogin.EVENT_SUB_KEY_USER_LOGOUT_SUCCESS, null);
            }
        });
    }
}
