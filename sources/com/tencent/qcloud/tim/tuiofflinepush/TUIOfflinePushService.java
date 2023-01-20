package com.tencent.qcloud.tim.tuiofflinepush;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.imsdk.v2.V2TIMConversationListener;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.qcloud.tim.tuiofflinepush.utils.TUIOfflinePushLog;
import com.tencent.qcloud.tuicore.ServiceInitializer;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuicore.TUICore;
import com.tencent.qcloud.tuicore.interfaces.ITUINotification;
import com.tencent.qcloud.tuicore.interfaces.ITUIService;
import e.j.a.b.c.r.v;
import java.util.Map;

/* loaded from: classes3.dex */
public class TUIOfflinePushService extends ServiceInitializer implements ITUINotification, ITUIService {
    public static final String TAG = TUIOfflinePushService.class.getSimpleName();
    public static Context appContext;
    public String userId;

    private static Object getBuildConfigValue(String str) {
        try {
            String packageName = appContext.getPackageName();
            return Class.forName(packageName + ".BuildConfig").getField(str).get(null);
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
            return v.b;
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
            return v.b;
        } catch (NoSuchFieldException e4) {
            e4.printStackTrace();
            return v.b;
        } catch (NullPointerException e5) {
            e5.printStackTrace();
            return v.b;
        } catch (Exception e6) {
            e6.printStackTrace();
            return v.b;
        }
    }

    private void initActivityLifecycle() {
        Context context = appContext;
        if (context instanceof Application) {
            ((Application) context).registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.tencent.qcloud.tim.tuiofflinepush.TUIOfflinePushService.1
                private boolean isChangingConfiguration;
                private int foregroundActivities = 0;
                private final V2TIMConversationListener unreadListener = new V2TIMConversationListener() { // from class: com.tencent.qcloud.tim.tuiofflinepush.TUIOfflinePushService.1.1
                    @Override // com.tencent.imsdk.v2.V2TIMConversationListener
                    public void onTotalUnreadMessageCountChanged(long j2) {
                        TUIOfflinePushManager.getInstance().updateBadge(TUIOfflinePushService.appContext, (int) j2);
                    }
                };

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityCreated(Activity activity, Bundle bundle) {
                    String str = TUIOfflinePushService.TAG;
                    TUIOfflinePushLog.i(str, "onActivityCreated bundle: " + bundle);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPaused(Activity activity) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityResumed(Activity activity) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStarted(Activity activity) {
                    int i2 = this.foregroundActivities + 1;
                    this.foregroundActivities = i2;
                    if (i2 == 1 && !this.isChangingConfiguration) {
                        TUIOfflinePushLog.i(TUIOfflinePushService.TAG, "application enter foreground");
                        V2TIMManager.getConversationManager().removeConversationListener(this.unreadListener);
                    }
                    this.isChangingConfiguration = false;
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStopped(Activity activity) {
                    int i2 = this.foregroundActivities - 1;
                    this.foregroundActivities = i2;
                    if (i2 == 0) {
                        TUIOfflinePushLog.i(TUIOfflinePushService.TAG, "application enter background");
                        V2TIMManager.getConversationManager().addConversationListener(this.unreadListener);
                    }
                    this.isChangingConfiguration = activity.isChangingConfigurations();
                }
            });
        }
    }

    private void initFlavor() {
        TUIOfflinePushManager.getInstance().setInternationalFlavor(TextUtils.equals("international", (String) getBuildConfigValue("FLAVOR")));
    }

    private void initListener() {
        TUICore.registerService("TUIOfflinePushService", this);
        TUICore.registerEvent(TUIConstants.TUILogin.EVENT_LOGIN_STATE_CHANGED, TUIConstants.TUILogin.EVENT_SUB_KEY_USER_KICKED_OFFLINE, this);
        TUICore.registerEvent(TUIConstants.TUILogin.EVENT_LOGIN_STATE_CHANGED, TUIConstants.TUILogin.EVENT_SUB_KEY_USER_SIG_EXPIRED, this);
        TUICore.registerEvent(TUIConstants.TUILogin.EVENT_LOGIN_STATE_CHANGED, TUIConstants.TUILogin.EVENT_SUB_KEY_USER_LOGIN_SUCCESS, this);
        TUICore.registerEvent(TUIConstants.TUILogin.EVENT_LOGIN_STATE_CHANGED, TUIConstants.TUILogin.EVENT_SUB_KEY_USER_LOGOUT_SUCCESS, this);
    }

    @Override // com.tencent.qcloud.tuicore.ServiceInitializer
    public void init(Context context) {
        appContext = context;
        this.userId = V2TIMManager.getInstance().getLoginUser();
        initListener();
        initActivityLifecycle();
        initFlavor();
    }

    public void logined() {
        TUIOfflinePushManager.getInstance().registerPush(appContext, this.userId);
    }

    public void logout() {
        TUIOfflinePushManager.getInstance().unRegisterPush(appContext, this.userId);
    }

    @Override // com.tencent.qcloud.tuicore.interfaces.ITUIService
    public Object onCall(String str, Map<String, Object> map) {
        String str2 = TAG;
        TUIOfflinePushLog.d(str2, "onCall method = " + str);
        if (TextUtils.equals(TUIConstants.TUIOfflinePush.METHOD_UNREGISTER_PUSH, str)) {
            logout();
            return null;
        }
        return null;
    }

    @Override // com.tencent.qcloud.tuicore.interfaces.ITUINotification
    public void onNotifyEvent(String str, String str2, Map<String, Object> map) {
        String str3 = TAG;
        TUIOfflinePushLog.d(str3, "onNotifyEvent key = " + str + "subKey = " + str2);
        if (TUIConstants.TUILogin.EVENT_LOGIN_STATE_CHANGED.equals(str)) {
            if (!TUIConstants.TUILogin.EVENT_SUB_KEY_USER_KICKED_OFFLINE.equals(str2) && !TUIConstants.TUILogin.EVENT_SUB_KEY_USER_SIG_EXPIRED.equals(str2) && !TUIConstants.TUILogin.EVENT_SUB_KEY_USER_LOGOUT_SUCCESS.equals(str2)) {
                if (TUIConstants.TUILogin.EVENT_SUB_KEY_USER_LOGIN_SUCCESS.equals(str2)) {
                    logined();
                    return;
                }
                return;
            }
            logout();
        }
    }
}
