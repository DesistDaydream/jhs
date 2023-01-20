package com.tencent.imsdk.manager;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.tencent.imsdk.BaseConstants;
import com.tencent.imsdk.common.IMCallback;
import com.tencent.imsdk.common.IMContext;
import com.tencent.imsdk.common.IMLog;
import com.tencent.imsdk.common.NetworkInfoCenter;
import com.tencent.imsdk.common.SystemUtil;
import com.tencent.imsdk.conversation.ConversationManager;
import com.tencent.imsdk.group.GroupManager;
import com.tencent.imsdk.manager.SDKConfig;
import com.tencent.imsdk.message.MessageCenter;
import com.tencent.imsdk.relationship.RelationshipManager;
import com.tencent.imsdk.relationship.UserInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes3.dex */
public class BaseManager implements NetworkInfoCenter.INetworkChangeListener {
    private static final String TAG = "BaseManager";
    public static final int TUI_COMPONENT_CHAT = 3;
    private static final int TUI_COMPONENT_CHECK_COUNT_LIMIT = 5;
    public static final int TUI_COMPONENT_CONTACT = 4;
    public static final int TUI_COMPONENT_CONVERSATION = 2;
    public static final int TUI_COMPONENT_CORE = 1;
    public static final int TUI_COMPONENT_GROUP = 5;
    public static final int TUI_COMPONENT_OFFLINEPUSH = 7;
    public static final int TUI_COMPONENT_SEARCH = 6;
    private static final int TUI_COMPONENT_STACK_LAYER_LIMIT = 10;
    public static final int TUI_COMPONENT_UNKNOWN = 0;
    private static final int UI_PLATFORM_FLUTTER = 1;
    private static final int UI_PLATFORM_FLUTTER_UIKIT = 2;
    private static final int UI_PLATFORM_TUIKIT = 15;
    private static final int UI_PLATFORM_UNITY = 5;
    private static final int UI_PLATFORM_UNITY_UIKIT = 6;
    private static final int UI_PLATFORM_UNKNOWN = 0;
    private static boolean mLoadLibrarySuccess = false;
    private WeakReference<SDKListener> sdkListenerWeakReference;
    private boolean mInvokeFromTUIKit = false;
    private boolean mInvokeFromTUICore = false;
    public List<Integer> mTUIComponentList = new ArrayList();
    private HashMap<Integer, Integer> mTUIComponentCheckCountMap = new HashMap<>();
    private SDKConfig.NetworkInfo mLastNetworkInfo = new SDKConfig.NetworkInfo();
    private SDKConfig.ProxyInfo mProxyInfo = new SDKConfig.ProxyInfo();
    private String mStringUIPlatform = "";
    private int mNumberUIPlatform = 0;
    private boolean isInit = false;
    private boolean isTestEnvironment = false;
    private boolean isIPv6Prior = false;
    private UserPreference userPreference = new UserPreference();

    /* loaded from: classes3.dex */
    public static class BaseManagerHolder {
        private static final BaseManager baseManager = new BaseManager();

        private BaseManagerHolder() {
        }
    }

    static {
        try {
            mLoadLibrarySuccess = SystemUtil.loadIMLibrary();
        } catch (Exception e2) {
            Log.e(TAG, e2.toString());
        }
    }

    public static BaseManager getInstance() {
        return BaseManagerHolder.baseManager;
    }

    private int getUIPlatform() {
        int i2 = this.mNumberUIPlatform;
        if (i2 != 0) {
            return i2;
        }
        this.mInvokeFromTUIKit = isTUIKit();
        return isFlutter() ? this.mInvokeFromTUIKit ? 2 : 1 : isUnity() ? this.mInvokeFromTUIKit ? 6 : 5 : this.mInvokeFromTUIKit ? 15 : 0;
    }

    private boolean hasTUIChat() {
        try {
            return Class.forName("com.tencent.qcloud.tuikit.tuichat.model.ChatProvider") != null;
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean hasTUIContact() {
        try {
            return Class.forName("com.tencent.qcloud.tuikit.tuicontact.model.ContactProvider") != null;
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean hasTUIConversation() {
        try {
            return Class.forName("com.tencent.qcloud.tuikit.tuiconversation.model.ConversationProvider") != null;
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean hasTUIGroup() {
        try {
            return Class.forName("com.tencent.qcloud.tuikit.tuigroup.model.GroupInfoProvider") != null;
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean hasTUIOfflinePush() {
        try {
            return Class.forName("com.tencent.qcloud.tim.tuiofflinepush.TUIOfflinePushManager") != null;
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean hasTUISearch() {
        try {
            return Class.forName("com.tencent.qcloud.tuikit.tuisearch.model.SearchDataProvider") != null;
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean isFlutter() {
        try {
            return Class.forName("com.qq.qcloud.tencent_im_sdk_plugin.tencent_im_sdk_plugin") != null;
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean isTUICore() {
        try {
            if (Class.forName("com.tencent.qcloud.tuicore.TUICore") != null) {
                return true;
            }
        } catch (ClassNotFoundException unused) {
        }
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (int i2 = 0; i2 < stackTrace.length && i2 <= 15; i2++) {
            if (stackTrace[i2].getClassName().toLowerCase().contains("tuicore")) {
                return true;
            }
        }
        return false;
    }

    private boolean isTUIKit() {
        try {
            if (Class.forName("com.tencent.qcloud.tim.uikit.TUIKit") != null) {
                return true;
            }
        } catch (Exception unused) {
        }
        try {
            if (Class.forName("com.tencent.qcloud.tuicore.TUICore") != null) {
                return true;
            }
        } catch (ClassNotFoundException unused2) {
        }
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (int i2 = 0; i2 < stackTrace.length && i2 <= 15; i2++) {
            String lowerCase = stackTrace[i2].getClassName().toLowerCase();
            if (lowerCase.contains("tuikitimpl") || lowerCase.contains("tuicore")) {
                return true;
            }
        }
        return false;
    }

    private boolean isUnity() {
        try {
            return Class.forName("com.qcloud.tencentimsdk.TencentImSDKPluginUnity") != null;
        } catch (Exception unused) {
            return false;
        }
    }

    private void reportTUIComponentUsage() {
        this.mInvokeFromTUICore = isTUICore();
        this.mTUIComponentCheckCountMap.put(2, 0);
        this.mTUIComponentCheckCountMap.put(3, 0);
        this.mTUIComponentCheckCountMap.put(4, 0);
        this.mTUIComponentCheckCountMap.put(5, 0);
        this.mTUIComponentCheckCountMap.put(6, 0);
        this.mTUIComponentCheckCountMap.put(7, 0);
        if (this.mInvokeFromTUIKit) {
            if (this.mInvokeFromTUICore) {
                this.mTUIComponentList.add(1);
                if (hasTUIConversation()) {
                    this.mTUIComponentList.add(2);
                }
                if (hasTUIChat()) {
                    this.mTUIComponentList.add(3);
                }
                if (hasTUIContact()) {
                    this.mTUIComponentList.add(4);
                }
                if (hasTUIGroup()) {
                    this.mTUIComponentList.add(5);
                }
                if (hasTUISearch()) {
                    this.mTUIComponentList.add(6);
                }
                if (hasTUIOfflinePush()) {
                    this.mTUIComponentList.add(7);
                }
            } else {
                this.mTUIComponentList.add(0);
            }
            nativeReportTUIComponentUsage(this.mTUIComponentList);
        }
    }

    public void checkTUIComponent(int i2) {
        String str;
        if (this.mInvokeFromTUICore && !this.mTUIComponentList.contains(Integer.valueOf(i2)) && this.mTUIComponentCheckCountMap.containsKey(Integer.valueOf(i2))) {
            if (i2 == 2) {
                str = "conversationprovider";
            } else if (i2 == 3) {
                str = "chatprovider";
            } else if (i2 == 5) {
                str = "groupInfoprovider";
            } else if (i2 == 4) {
                str = "contactprovider";
            } else if (i2 == 6) {
                str = "searchdataprovider";
            } else if (i2 != 7) {
                String str2 = TAG;
                IMLog.e(str2, "unknown tui component type:" + i2);
                return;
            } else {
                str = "tuiofflinepushmanager";
            }
            int intValue = this.mTUIComponentCheckCountMap.get(Integer.valueOf(i2)).intValue();
            if (intValue < 5) {
                this.mTUIComponentCheckCountMap.put(Integer.valueOf(i2), Integer.valueOf(intValue + 1));
                StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
                for (int i3 = 0; i3 < stackTrace.length && i3 < 10; i3++) {
                    if (stackTrace[i3].getClassName().toLowerCase().contains(str)) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(Integer.valueOf(i2));
                        nativeReportTUIComponentUsage(arrayList);
                        this.mTUIComponentList.add(Integer.valueOf(i2));
                        return;
                    }
                }
            }
        }
    }

    public void enableSignaling(boolean z) {
        this.userPreference.setEnableSignaling(Boolean.valueOf(z));
        nativeSetUserPreference(this.userPreference);
    }

    public long getClockTickInHz() {
        if (!this.isInit) {
            Log.e(TAG, "sdk not init");
            return 0L;
        }
        return nativeGetClockTickInHz();
    }

    public int getLoginStatus() {
        if (!this.isInit) {
            Log.e(TAG, "sdk not init");
            return 3;
        }
        return nativeGetLoginStatus();
    }

    public String getLoginUser() {
        if (!this.isInit) {
            Log.e(TAG, "sdk not init");
            return null;
        }
        return nativeGetLoginUser();
    }

    public long getServerTime() {
        if (!this.isInit) {
            Log.e(TAG, "sdk not init");
            return 0L;
        }
        return nativeGetServerTime();
    }

    public long getTimeTick() {
        if (!this.isInit) {
            Log.e(TAG, "sdk not init");
            return 0L;
        }
        return nativeGetTimeTick();
    }

    public String getVersion() {
        if (!this.isInit) {
            Log.e(TAG, "sdk not init");
            return null;
        }
        return nativeGetSDKVersion();
    }

    public void initLocalStorage(String str, IMCallback iMCallback) {
        if (this.isInit) {
            nativeInitLocalStorage(str, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public boolean initSDK(Context context, SDKConfig sDKConfig, boolean z, SDKListener sDKListener) {
        if (!mLoadLibrarySuccess) {
            IMLog.e(TAG, "libimsdk.so is not loaded");
            return false;
        } else if (sDKConfig.sdkAppId <= 0) {
            String str = TAG;
            IMLog.e(str, "invalid sdkAppID:" + sDKConfig.sdkAppId);
            return false;
        } else if (context == null) {
            IMLog.e(TAG, "null context");
            return false;
        } else if (this.isInit) {
            IMLog.w(TAG, "Has initSDK");
            return true;
        } else {
            String nativeGetSDKVersion = nativeGetSDKVersion();
            SharedPreferences sharedPreferences = context.getSharedPreferences("BuglySdkInfos", 0);
            if (!sharedPreferences.getString("ebfa608d4d", "").equalsIgnoreCase(nativeGetSDKVersion)) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString("ebfa608d4d", nativeGetSDKVersion);
                edit.apply();
            }
            IMContext.getInstance().init(context.getApplicationContext());
            NetworkInfoCenter.getInstance().init(context.getApplicationContext(), this);
            MessageCenter.getInstance().init();
            GroupManager.getInstance().init();
            ConversationManager.getInstance().init();
            RelationshipManager.getInstance().init();
            sDKConfig.sdkInitPath = SystemUtil.getSDKInitPath();
            sDKConfig.sdkInstanceType = SystemUtil.getInstanceType();
            sDKConfig.isTestEnvironment = this.isTestEnvironment;
            sDKConfig.isIPv6Prior = this.isIPv6Prior;
            sDKConfig.deviceInfo.deviceType = SystemUtil.getDeviceType();
            sDKConfig.deviceInfo.deviceId = SystemUtil.getDeviceID();
            sDKConfig.deviceInfo.deviceBrand = SystemUtil.getInstanceType();
            sDKConfig.deviceInfo.systemVersion = SystemUtil.getSystemVersion();
            sDKConfig.networkInfo.networkType = NetworkInfoCenter.getInstance().getNetworkType();
            sDKConfig.networkInfo.ipType = NetworkInfoCenter.getInstance().getIPType();
            sDKConfig.networkInfo.networkId = NetworkInfoCenter.getInstance().getNetworkID();
            sDKConfig.networkInfo.networkConnected = NetworkInfoCenter.getInstance().isNetworkConnected();
            sDKConfig.proxyInfo = this.mProxyInfo;
            SDKConfig.LogSetting logSetting = sDKConfig.logSetting;
            logSetting.enableConsoleLog = true;
            logSetting.logFilePath = SystemUtil.getSDKLogPath();
            sDKConfig.stringUIPlatform = this.mStringUIPlatform;
            sDKConfig.numberUIPlatform = getUIPlatform();
            this.mLastNetworkInfo = sDKConfig.networkInfo;
            nativeInitSDK(sDKConfig, z, sDKListener);
            this.sdkListenerWeakReference = new WeakReference<>(sDKListener);
            reportTUIComponentUsage();
            this.isInit = true;
            return true;
        }
    }

    public boolean isInited() {
        return this.isInit;
    }

    public void login(String str, String str2, IMCallback iMCallback) {
        if (this.isInit) {
            nativeLogin(str, str2, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public void logout(IMCallback iMCallback) {
        if (this.isInit) {
            nativeLogout(iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(BaseConstants.ERR_SDK_NOT_INITIALIZED, "sdk not init");
        }
    }

    public native long nativeGetClockTickInHz();

    public native int nativeGetLoginStatus();

    public native String nativeGetLoginUser();

    public native String nativeGetSDKVersion();

    public native long nativeGetServerTime();

    public native long nativeGetTimeTick();

    public native void nativeInitLocalStorage(String str, IMCallback iMCallback);

    public native void nativeInitSDK(SDKConfig sDKConfig, boolean z, SDKListener sDKListener);

    public native void nativeLogin(String str, String str2, IMCallback iMCallback);

    public native void nativeLogout(IMCallback iMCallback);

    public native void nativeNotifyNetworkChange(boolean z, int i2, int i3, String str);

    public native void nativeReportAPICall(String str, String str2);

    public native void nativeReportTUIComponentUsage(List<Integer> list);

    public native void nativeSetCustomServerInfo(CustomServerInfo customServerInfo);

    public native void nativeSetUserPreference(UserPreference userPreference);

    public native void nativeUninitSDK();

    public void notifySelfInfoUpdated(UserInfo userInfo) {
        SDKListener sDKListener;
        WeakReference<SDKListener> weakReference = this.sdkListenerWeakReference;
        if (weakReference == null || (sDKListener = weakReference.get()) == null) {
            return;
        }
        sDKListener.onSelfInfoUpdated(userInfo);
    }

    @Override // com.tencent.imsdk.common.NetworkInfoCenter.INetworkChangeListener
    public void onNetworkChange(boolean z, int i2, int i3, String str) {
        SDKConfig.NetworkInfo networkInfo = this.mLastNetworkInfo;
        if (z == networkInfo.networkConnected && i2 == networkInfo.networkType && i3 == networkInfo.ipType && str != null && str.equals(networkInfo.networkId)) {
            Log.w(TAG, "onNetworkChange, networkinfo is same");
            return;
        }
        SDKConfig.NetworkInfo networkInfo2 = this.mLastNetworkInfo;
        networkInfo2.networkConnected = z;
        networkInfo2.networkType = i2;
        networkInfo2.ipType = i3;
        networkInfo2.networkId = str;
        nativeNotifyNetworkChange(z, i2, i3, str);
    }

    public void reportAPICall(String str, String str2) {
        nativeReportAPICall(str, str2);
    }

    public void setCustomServerInfo(CustomServerInfo customServerInfo) {
        nativeSetCustomServerInfo(customServerInfo);
    }

    public void setCustomUIPlatform(String str, int i2) {
        this.mStringUIPlatform = str;
        this.mNumberUIPlatform = i2;
    }

    public void setIPv6Prior(boolean z) {
        this.isIPv6Prior = z;
    }

    public boolean setLibraryPath(String str) {
        boolean loadIMLibrary = SystemUtil.loadIMLibrary(str);
        mLoadLibrarySuccess = loadIMLibrary;
        return loadIMLibrary;
    }

    public void setProxyInfo(SDKConfig.ProxyInfo proxyInfo) {
        this.mProxyInfo = proxyInfo;
    }

    public void setTestEnvironment(boolean z) {
        this.isTestEnvironment = z;
    }

    public void unInitSDK() {
        nativeUninitSDK();
        this.mStringUIPlatform = "";
        this.mNumberUIPlatform = 0;
        this.isInit = false;
        this.isTestEnvironment = false;
        this.isIPv6Prior = false;
        this.mLastNetworkInfo.clean();
        this.mProxyInfo.clean();
        this.mInvokeFromTUIKit = false;
        this.mInvokeFromTUICore = false;
        this.mTUIComponentList.clear();
        this.mTUIComponentCheckCountMap.clear();
    }
}
