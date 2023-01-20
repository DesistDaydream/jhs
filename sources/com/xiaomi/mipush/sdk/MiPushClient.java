package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.xiaomi.mipush.sdk.MiTinyDataClient;
import com.xiaomi.push.ch;
import com.xiaomi.push.cr;
import com.xiaomi.push.cs;
import com.xiaomi.push.dq;
import com.xiaomi.push.dr;
import com.xiaomi.push.ds;
import com.xiaomi.push.ec;
import com.xiaomi.push.gg;
import com.xiaomi.push.gq;
import com.xiaomi.push.gu;
import com.xiaomi.push.gv;
import com.xiaomi.push.ha;
import com.xiaomi.push.hd;
import com.xiaomi.push.he;
import com.xiaomi.push.hl;
import com.xiaomi.push.hq;
import com.xiaomi.push.hr;
import com.xiaomi.push.hv;
import com.xiaomi.push.hx;
import com.xiaomi.push.hz;
import com.xiaomi.push.ii;
import com.xiaomi.push.jc;
import com.xiaomi.push.jd;
import com.xiaomi.push.je;
import com.xiaomi.push.jj;
import com.xiaomi.push.jl;
import com.xiaomi.push.service.ad;
import com.xiaomi.push.service.receivers.NetworkStatusReceiver;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

/* loaded from: classes3.dex */
public abstract class MiPushClient {
    public static final String COMMAND_REGISTER = "register";
    public static final String COMMAND_SET_ACCEPT_TIME = "accept-time";
    public static final String COMMAND_SET_ACCOUNT = "set-account";
    public static final String COMMAND_SET_ALIAS = "set-alias";
    public static final String COMMAND_SUBSCRIBE_TOPIC = "subscribe-topic";
    public static final String COMMAND_UNREGISTER = "unregister";
    public static final String COMMAND_UNSET_ACCOUNT = "unset-account";
    public static final String COMMAND_UNSET_ALIAS = "unset-alias";
    public static final String COMMAND_UNSUBSCRIBE_TOPIC = "unsubscibe-topic";
    public static final String PREF_EXTRA = "mipush_extra";
    private static Context sContext;
    private static long sCurMsgId = System.currentTimeMillis();

    /* loaded from: classes3.dex */
    public static class CodeResult {
        private long resultCode = -1;

        public long getResultCode() {
            return this.resultCode;
        }

        public void setResultCode(long j2) {
            this.resultCode = j2;
        }
    }

    /* loaded from: classes3.dex */
    public interface ICallbackResult<R> {
        void onResult(R r);
    }

    @Deprecated
    /* loaded from: classes3.dex */
    public static abstract class MiPushClientCallback {
        private String category;

        public String getCategory() {
            return this.category;
        }

        public void onCommandResult(String str, long j2, String str2, List<String> list) {
        }

        public void onInitializeResult(long j2, String str, String str2) {
        }

        public void onReceiveMessage(MiPushMessage miPushMessage) {
        }

        public void onReceiveMessage(String str, String str2, String str3, boolean z) {
        }

        public void onSubscribeResult(long j2, String str, String str2) {
        }

        public void onUnsubscribeResult(long j2, String str, String str2) {
        }

        public void setCategory(String str) {
            this.category = str;
        }
    }

    /* loaded from: classes3.dex */
    public static class TokenResult {
        private String token = null;
        private long resultCode = -1;

        public long getResultCode() {
            return this.resultCode;
        }

        public String getToken() {
            return this.token;
        }

        public void setResultCode(long j2) {
            this.resultCode = j2;
        }

        public void setToken(String str) {
            this.token = str;
        }
    }

    /* loaded from: classes3.dex */
    public interface UPSRegisterCallBack extends ICallbackResult<TokenResult> {
    }

    /* loaded from: classes3.dex */
    public interface UPSTurnCallBack extends ICallbackResult<CodeResult> {
    }

    /* loaded from: classes3.dex */
    public interface UPSUnRegisterCallBack extends ICallbackResult<TokenResult> {
    }

    private static boolean acceptTimeSet(Context context, String str, String str2) {
        String acceptTime = getAcceptTime(context);
        return TextUtils.equals(acceptTime, str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2);
    }

    public static long accountSetTime(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        return sharedPreferences.getLong("account_" + str, -1L);
    }

    public static synchronized void addAcceptTime(Context context, String str, String str2) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.putString("accept_time", str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2);
            jj.a(edit);
        }
    }

    public static synchronized void addAccount(Context context, String str) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.putLong("account_" + str, System.currentTimeMillis()).commit();
        }
    }

    public static synchronized void addAlias(Context context, String str) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.putLong("alias_" + str, System.currentTimeMillis()).commit();
        }
    }

    private static void addPullNotificationTime(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        edit.putLong("last_pull_notification", System.currentTimeMillis());
        jj.a(edit);
    }

    private static void addRegRequestTime(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        edit.putLong("last_reg_request", System.currentTimeMillis());
        jj.a(edit);
    }

    public static synchronized void addTopic(Context context, String str) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.putLong("topic_" + str, System.currentTimeMillis()).commit();
        }
    }

    public static long aliasSetTime(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        return sharedPreferences.getLong("alias_" + str, -1L);
    }

    public static void awakeApps(final Context context, final String[] strArr) {
        com.xiaomi.push.m.a(context).a(new Runnable() { // from class: com.xiaomi.mipush.sdk.MiPushClient.4
            @Override // java.lang.Runnable
            public void run() {
                String[] strArr2;
                PackageInfo packageInfo;
                try {
                    for (String str : strArr) {
                        if (!TextUtils.isEmpty(str) && (packageInfo = context.getPackageManager().getPackageInfo(str, 4)) != null) {
                            MiPushClient.awakePushServiceByPackageInfo(context, packageInfo);
                        }
                    }
                } catch (Throwable th) {
                    com.xiaomi.a.a.a.c.a(th);
                }
            }
        });
    }

    public static void awakePushServiceByPackageInfo(Context context, PackageInfo packageInfo) {
        ServiceInfo[] serviceInfoArr = packageInfo.services;
        if (serviceInfoArr != null) {
            for (ServiceInfo serviceInfo : serviceInfoArr) {
                if (serviceInfo.exported && serviceInfo.enabled && "com.xiaomi.mipush.sdk.PushMessageHandler".equals(serviceInfo.name) && !context.getPackageName().equals(serviceInfo.packageName)) {
                    try {
                        Thread.sleep(((long) ((Math.random() * 2.0d) + 1.0d)) * 1000);
                        Intent intent = new Intent();
                        intent.setClassName(serviceInfo.packageName, serviceInfo.name);
                        intent.setAction("com.xiaomi.mipush.sdk.WAKEUP");
                        intent.putExtra("waker_pkgname", context.getPackageName());
                        PushMessageHandler.a(context, intent);
                        return;
                    } catch (Throwable unused) {
                        return;
                    }
                }
            }
        }
    }

    private static void checkNotNull(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw new IllegalArgumentException("param " + str + " is not nullable");
    }

    public static void clearExtras(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        edit.clear();
        edit.commit();
    }

    private static void clearExtrasForInitialize(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        Iterator<String> it = getAllAlias(context).iterator();
        while (it.hasNext()) {
            edit.remove("alias_" + it.next());
        }
        Iterator<String> it2 = getAllUserAccount(context).iterator();
        while (it2.hasNext()) {
            edit.remove("account_" + it2.next());
        }
        Iterator<String> it3 = getAllTopic(context).iterator();
        while (it3.hasNext()) {
            edit.remove("topic_" + it3.next());
        }
        edit.remove("accept_time");
        edit.commit();
    }

    public static void clearLocalNotificationType(Context context) {
        ao.a(context).f();
    }

    public static void clearNotification(Context context) {
        ao.a(context).a(-1);
    }

    public static void clearNotification(Context context, int i2) {
        ao.a(context).a(i2);
    }

    public static void clearNotification(Context context, String str, String str2) {
        ao.a(context).a(str, str2);
    }

    public static void disablePush(Context context) {
        ao.a(context).a(true);
    }

    public static void enablePush(Context context) {
        ao.a(context).a(false);
    }

    public static String getAcceptTime(Context context) {
        return context.getSharedPreferences("mipush_extra", 0).getString("accept_time", "00:00-23:59");
    }

    public static List<String> getAllAlias(Context context) {
        ArrayList arrayList = new ArrayList();
        for (String str : context.getSharedPreferences("mipush_extra", 0).getAll().keySet()) {
            if (str.startsWith("alias_")) {
                arrayList.add(str.substring(6));
            }
        }
        return arrayList;
    }

    public static List<String> getAllTopic(Context context) {
        ArrayList arrayList = new ArrayList();
        for (String str : context.getSharedPreferences("mipush_extra", 0).getAll().keySet()) {
            if (str.startsWith("topic_") && !str.contains("**ALL**")) {
                arrayList.add(str.substring(6));
            }
        }
        return arrayList;
    }

    public static List<String> getAllUserAccount(Context context) {
        ArrayList arrayList = new ArrayList();
        for (String str : context.getSharedPreferences("mipush_extra", 0).getAll().keySet()) {
            if (str.startsWith("account_")) {
                arrayList.add(str.substring(8));
            }
        }
        return arrayList;
    }

    public static String getAppRegion(Context context) {
        if (b.m74a(context).m83c()) {
            return b.m74a(context).f();
        }
        return null;
    }

    private static boolean getDefaultSwitch() {
        return jc.b();
    }

    public static boolean getOpenFCMPush(Context context) {
        checkNotNull(context, "context");
        return f.a(context).b(e.ASSEMBLE_PUSH_FCM);
    }

    public static boolean getOpenHmsPush(Context context) {
        checkNotNull(context, "context");
        return f.a(context).b(e.ASSEMBLE_PUSH_HUAWEI);
    }

    public static boolean getOpenOPPOPush(Context context) {
        checkNotNull(context, "context");
        return f.a(context).b(e.ASSEMBLE_PUSH_COS);
    }

    public static boolean getOpenVIVOPush(Context context) {
        return f.a(context).b(e.ASSEMBLE_PUSH_FTOS);
    }

    public static String getRegId(Context context) {
        if (b.m74a(context).m83c()) {
            return b.m74a(context).m82c();
        }
        return null;
    }

    private static void initEventPerfLogic(final Context context) {
        ds.a(new ds.a() { // from class: com.xiaomi.mipush.sdk.MiPushClient.5
            @Override // com.xiaomi.push.ds.a
            public void uploader(Context context2, gu guVar) {
                MiTinyDataClient.upload(context2, guVar);
            }
        });
        com.xiaomi.b.a.a c2 = ds.c(context);
        com.xiaomi.b.b.b.a(context).a("4_9_1");
        com.xiaomi.b.b.a.a(context, c2, new dq(context), new dr(context));
        a.a(context);
        t.a(context, c2);
        com.xiaomi.push.service.ad.a(context).a(new ad.a(100, "perf event job update") { // from class: com.xiaomi.mipush.sdk.MiPushClient.6
            @Override // com.xiaomi.push.service.ad.a
            public void onCallback() {
                ds.b(context);
            }
        });
    }

    @Deprecated
    public static void initialize(Context context, String str, String str2, MiPushClientCallback miPushClientCallback) {
        initialize(context, str, str2, miPushClientCallback, null, null);
    }

    public static void initialize(Context context, String str, String str2, MiPushClientCallback miPushClientCallback, String str3, ICallbackResult iCallbackResult) {
        try {
            com.xiaomi.a.a.a.c.a(context.getApplicationContext());
            com.xiaomi.a.a.a.c.f("sdk_version = 4_9_1");
            com.xiaomi.push.ac.a(context).c();
            ch.a(context);
            if (miPushClientCallback != null) {
                PushMessageHandler.a(miPushClientCallback);
            }
            if (iCallbackResult != null) {
                PushMessageHandler.a(iCallbackResult);
            }
            if (jl.b(sContext)) {
                v.a(sContext);
            }
            boolean z = b.m74a(sContext).a() != Constants.a();
            if (!z && !shouldSendRegRequest(sContext)) {
                ao.a(sContext).m65a();
                com.xiaomi.a.a.a.c.a("Could not send  register message within 5s repeatly .");
                return;
            }
            if (z || !b.m74a(sContext).a(str, str2) || b.m74a(sContext).m86f()) {
                String a = com.xiaomi.push.ar.a(6);
                b.m74a(sContext).m76a();
                b.m74a(sContext).a(Constants.a());
                b.m74a(sContext).a(str, str2, a);
                MiTinyDataClient.a.a().b(MiTinyDataClient.PENDING_REASON_APPID);
                clearExtras(sContext);
                clearNotification(context);
                hr hrVar = new hr();
                hrVar.a(com.xiaomi.push.service.ag.b());
                hrVar.b(str);
                hrVar.e(str2);
                hrVar.d(sContext.getPackageName());
                hrVar.f(a);
                Context context2 = sContext;
                hrVar.c(gg.a(context2, context2.getPackageName()));
                Context context3 = sContext;
                hrVar.b(gg.b(context3, context3.getPackageName()));
                hrVar.h("4_9_1");
                hrVar.a(40091);
                hrVar.a(he.Init);
                if (!TextUtils.isEmpty(str3)) {
                    hrVar.g(str3);
                }
                if (!jc.g()) {
                    String e2 = ii.e(sContext);
                    if (!TextUtils.isEmpty(e2)) {
                        hrVar.i(com.xiaomi.push.ar.a(e2) + Constants.ACCEPT_TIME_SEPARATOR_SP + ii.h(sContext));
                    }
                }
                int a2 = ii.a();
                if (a2 >= 0) {
                    hrVar.c(a2);
                }
                ao.a(sContext).a(hrVar, z);
                sContext.getSharedPreferences("mipush_extra", 4).getBoolean("mipush_registed", true);
            } else {
                if (1 == PushMessageHelper.getPushMode(sContext)) {
                    checkNotNull(miPushClientCallback, "callback");
                    miPushClientCallback.onInitializeResult(0L, null, b.m74a(sContext).m82c());
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(b.m74a(sContext).m82c());
                    PushMessageHelper.sendCommandMessageBroadcast(sContext, PushMessageHelper.generateCommandMessage(ec.COMMAND_REGISTER.f8488k, arrayList, 0L, null, null, null));
                }
                ao.a(sContext).m65a();
                if (b.m74a(sContext).m78a()) {
                    hq hqVar = new hq();
                    hqVar.b(b.m74a(sContext).m75a());
                    hqVar.c(ha.ClientInfoUpdate.ah);
                    hqVar.a(com.xiaomi.push.service.ag.a());
                    HashMap hashMap = new HashMap();
                    hqVar.f8869h = hashMap;
                    Context context4 = sContext;
                    hashMap.put("app_version", gg.a(context4, context4.getPackageName()));
                    Map<String, String> map = hqVar.f8869h;
                    Context context5 = sContext;
                    map.put(Constants.EXTRA_KEY_APP_VERSION_CODE, Integer.toString(gg.b(context5, context5.getPackageName())));
                    hqVar.f8869h.put("push_sdk_vn", "4_9_1");
                    hqVar.f8869h.put("push_sdk_vc", Integer.toString(40091));
                    String e3 = b.m74a(sContext).e();
                    if (!TextUtils.isEmpty(e3)) {
                        hqVar.f8869h.put("deviceid", e3);
                    }
                    ao.a(sContext).a((ao) hqVar, gq.Notification, false, (hd) null);
                }
                if (!jd.a(sContext, "update_devId", false)) {
                    updateImeiOrOaid();
                    jd.b(sContext, "update_devId", true);
                }
                if (shouldUseMIUIPush(sContext) && shouldPullNotification(sContext)) {
                    hq hqVar2 = new hq();
                    hqVar2.b(b.m74a(sContext).m75a());
                    hqVar2.c(ha.PullOfflineMessage.ah);
                    hqVar2.a(com.xiaomi.push.service.ag.a());
                    hqVar2.a(false);
                    ao.a(sContext).a((ao) hqVar2, gq.Notification, false, (hd) null, false);
                    addPullNotificationTime(sContext);
                }
            }
            addRegRequestTime(sContext);
            scheduleOcVersionCheckJob();
            scheduleDataCollectionJobs(sContext);
            initEventPerfLogic(sContext);
            av.a(sContext);
            if (!sContext.getPackageName().equals("com.xiaomi.xmsf")) {
                if (Logger.getUserLogger() != null) {
                    Logger.setLogger(sContext, Logger.getUserLogger());
                }
                com.xiaomi.a.a.a.c.a(2);
            }
            operateSyncAction(context);
        } catch (Throwable th) {
            com.xiaomi.a.a.a.c.a(th);
        }
    }

    private static void operateSyncAction(Context context) {
        if ("syncing".equals(af.a(sContext).a(au.DISABLE_PUSH))) {
            disablePush(sContext);
        }
        if ("syncing".equals(af.a(sContext).a(au.ENABLE_PUSH))) {
            enablePush(sContext);
        }
        if ("syncing".equals(af.a(sContext).a(au.UPLOAD_HUAWEI_TOKEN))) {
            syncAssemblePushToken(sContext);
        }
        if ("syncing".equals(af.a(sContext).a(au.UPLOAD_FCM_TOKEN))) {
            syncAssembleFCMPushToken(sContext);
        }
        if ("syncing".equals(af.a(sContext).a(au.UPLOAD_COS_TOKEN))) {
            syncAssembleCOSPushToken(context);
        }
        if ("syncing".equals(af.a(sContext).a(au.UPLOAD_FTOS_TOKEN))) {
            syncAssembleFTOSPushToken(context);
        }
    }

    public static void pausePush(Context context, String str) {
        setAcceptTime(context, 0, 0, 0, 0, str);
    }

    public static void reInitialize(Context context, he heVar) {
        com.xiaomi.a.a.a.c.f("re-register reason: " + heVar);
        String a = com.xiaomi.push.ar.a(6);
        String m75a = b.m74a(context).m75a();
        String b = b.m74a(context).b();
        b.m74a(context).m76a();
        clearExtrasForInitialize(context);
        clearNotification(context);
        b.m74a(context).a(Constants.a());
        b.m74a(context).a(m75a, b, a);
        hr hrVar = new hr();
        hrVar.a(com.xiaomi.push.service.ag.b());
        hrVar.b(m75a);
        hrVar.e(b);
        hrVar.f(a);
        hrVar.d(context.getPackageName());
        hrVar.c(gg.a(context, context.getPackageName()));
        hrVar.b(gg.b(context, context.getPackageName()));
        hrVar.h("4_9_1");
        hrVar.a(40091);
        hrVar.a(heVar);
        int a2 = ii.a();
        if (a2 >= 0) {
            hrVar.c(a2);
        }
        ao.a(context).a(hrVar, false);
    }

    @Deprecated
    public static void registerCrashHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
    }

    private static void registerNetworkReceiver(Context context) {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            intentFilter.addCategory("android.intent.category.DEFAULT");
            je.a(context.getApplicationContext(), new NetworkStatusReceiver(null), intentFilter);
            je.a(context, NetworkStatusReceiver.class);
        } catch (Throwable th) {
            com.xiaomi.a.a.a.c.a("dynamic register network status receiver failed:" + th);
        }
    }

    public static void registerPush(Context context, String str, String str2) {
        registerPush(context, str, str2, new PushConfiguration());
    }

    public static void registerPush(Context context, String str, String str2, PushConfiguration pushConfiguration) {
        registerPush(context, str, str2, pushConfiguration, null, null);
    }

    private static void registerPush(Context context, final String str, final String str2, PushConfiguration pushConfiguration, final String str3, final ICallbackResult iCallbackResult) {
        checkNotNull(context, "context");
        checkNotNull(str, com.heytap.mcssdk.constant.b.u);
        checkNotNull(str2, "appToken");
        Context applicationContext = context.getApplicationContext();
        sContext = applicationContext;
        if (applicationContext == null) {
            sContext = context;
        }
        Context context2 = sContext;
        jl.a(context2);
        if (!NetworkStatusReceiver.a()) {
            registerNetworkReceiver(sContext);
        }
        f.a(sContext).a(pushConfiguration);
        com.xiaomi.push.m.a(context2).a(new Runnable() { // from class: com.xiaomi.mipush.sdk.MiPushClient.1
            @Override // java.lang.Runnable
            public void run() {
                MiPushClient.initialize(MiPushClient.sContext, str, str2, null, str3, iCallbackResult);
            }
        });
    }

    public static void registerPush(Context context, String str, String str2, String str3) {
        registerPush(context, str, str2, new PushConfiguration(), str3, null);
    }

    public static void registerToken(Context context, String str, String str2, String str3, UPSRegisterCallBack uPSRegisterCallBack) {
        registerPush(context, str, str2, new PushConfiguration(), null, uPSRegisterCallBack);
    }

    public static synchronized void removeAcceptTime(Context context) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.remove("accept_time");
            jj.a(edit);
        }
    }

    public static synchronized void removeAccount(Context context, String str) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.remove("account_" + str).commit();
        }
    }

    public static synchronized void removeAlias(Context context, String str) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.remove("alias_" + str).commit();
        }
    }

    public static synchronized void removeAllAccounts(Context context) {
        synchronized (MiPushClient.class) {
            for (String str : getAllUserAccount(context)) {
                removeAccount(context, str);
            }
        }
    }

    public static synchronized void removeAllAliases(Context context) {
        synchronized (MiPushClient.class) {
            for (String str : getAllAlias(context)) {
                removeAlias(context, str);
            }
        }
    }

    public static synchronized void removeAllTopics(Context context) {
        synchronized (MiPushClient.class) {
            for (String str : getAllTopic(context)) {
                removeTopic(context, str);
            }
        }
    }

    public static synchronized void removeTopic(Context context, String str) {
        synchronized (MiPushClient.class) {
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.remove("topic_" + str).commit();
        }
    }

    public static void removeWindow(Context context) {
        ao.a(context).m73e();
    }

    public static void reportAppRunInBackground(Context context, boolean z) {
        if (b.m74a(context).m81b()) {
            ha haVar = z ? ha.APP_SLEEP : ha.APP_WAKEUP;
            hq hqVar = new hq();
            hqVar.b(b.m74a(context).m75a());
            hqVar.c(haVar.ah);
            hqVar.d(context.getPackageName());
            hqVar.a(com.xiaomi.push.service.ag.a());
            hqVar.a(false);
            ao.a(context).a((ao) hqVar, gq.Notification, false, (hd) null, false);
        }
    }

    public static void reportIgnoreRegMessageClicked(Context context, String str, hd hdVar, String str2, String str3) {
        hq hqVar = new hq();
        if (TextUtils.isEmpty(str3)) {
            com.xiaomi.a.a.a.c.d("do not report clicked message");
            return;
        }
        hqVar.b(str3);
        hqVar.c("bar:click");
        hqVar.a(str);
        hqVar.a(false);
        ao.a(context).a(hqVar, gq.Notification, false, true, hdVar, true, str2, str3);
    }

    public static void reportMessageClicked(Context context, MiPushMessage miPushMessage) {
        hd hdVar = new hd();
        hdVar.a(miPushMessage.getMessageId());
        hdVar.b(miPushMessage.getTopic());
        hdVar.d(miPushMessage.getDescription());
        hdVar.c(miPushMessage.getTitle());
        hdVar.c(miPushMessage.getNotifyId());
        hdVar.a(miPushMessage.getNotifyType());
        hdVar.b(miPushMessage.getPassThrough());
        hdVar.a(miPushMessage.getExtra());
        reportMessageClicked(context, miPushMessage.getMessageId(), hdVar, null);
    }

    @Deprecated
    public static void reportMessageClicked(Context context, String str) {
        reportMessageClicked(context, str, null, null);
    }

    public static void reportMessageClicked(Context context, String str, hd hdVar, String str2) {
        hq hqVar = new hq();
        if (TextUtils.isEmpty(str2)) {
            if (!b.m74a(context).m81b()) {
                com.xiaomi.a.a.a.c.d("do not report clicked message");
                return;
            }
            str2 = b.m74a(context).m75a();
        }
        hqVar.b(str2);
        hqVar.c("bar:click");
        hqVar.a(str);
        hqVar.a(false);
        ao.a(context).a((ao) hqVar, gq.Notification, false, hdVar);
    }

    public static void resumePush(Context context, String str) {
        setAcceptTime(context, 0, 0, 23, 59, str);
    }

    private static void scheduleDataCollectionJobs(Context context) {
        if (com.xiaomi.push.service.ad.a(sContext).a(gv.DataCollectionSwitch.a(), getDefaultSwitch())) {
            cr.a().a(new r(context));
            com.xiaomi.push.m.a(sContext).a(new Runnable() { // from class: com.xiaomi.mipush.sdk.MiPushClient.2
                @Override // java.lang.Runnable
                public void run() {
                    cs.a(MiPushClient.sContext);
                }
            }, 10);
        }
    }

    private static void scheduleOcVersionCheckJob() {
        com.xiaomi.push.m.a(sContext).a(new ae(sContext), com.xiaomi.push.service.ad.a(sContext).a(gv.OcVersionCheckFrequency.a(), RemoteMessageConst.DEFAULT_TTL), 5);
    }

    public static void setAcceptTime(Context context, int i2, int i3, int i4, int i5, String str) {
        if (i2 < 0 || i2 >= 24 || i4 < 0 || i4 >= 24 || i3 < 0 || i3 >= 60 || i5 < 0 || i5 >= 60) {
            throw new IllegalArgumentException("the input parameter is not valid.");
        }
        long rawOffset = ((TimeZone.getTimeZone("GMT+08").getRawOffset() - TimeZone.getDefault().getRawOffset()) / 1000) / 60;
        long j2 = ((((i2 * 60) + i3) + rawOffset) + 1440) % 1440;
        long j3 = ((((i4 * 60) + i5) + rawOffset) + 1440) % 1440;
        ArrayList arrayList = new ArrayList();
        arrayList.add(String.format("%1$02d:%2$02d", Long.valueOf(j2 / 60), Long.valueOf(j2 % 60)));
        arrayList.add(String.format("%1$02d:%2$02d", Long.valueOf(j3 / 60), Long.valueOf(j3 % 60)));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(String.format("%1$02d:%2$02d", Integer.valueOf(i2), Integer.valueOf(i3)));
        arrayList2.add(String.format("%1$02d:%2$02d", Integer.valueOf(i4), Integer.valueOf(i5)));
        if (!acceptTimeSet(context, (String) arrayList.get(0), (String) arrayList.get(1))) {
            setCommand(context, ec.COMMAND_SET_ACCEPT_TIME.f8488k, arrayList, str);
        } else if (1 == PushMessageHelper.getPushMode(context)) {
            PushMessageHandler.a(context, str, ec.COMMAND_SET_ACCEPT_TIME.f8488k, 0L, null, arrayList2);
        } else {
            PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(ec.COMMAND_SET_ACCEPT_TIME.f8488k, arrayList2, 0L, null, null, null));
        }
    }

    public static void setAlias(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        setCommand(context, ec.COMMAND_SET_ALIAS.f8488k, str, str2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x0031, code lost:
        if (1 == com.xiaomi.mipush.sdk.PushMessageHelper.getPushMode(r12)) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0033, code lost:
        com.xiaomi.mipush.sdk.PushMessageHandler.a(r12, r15, r13, 0, null, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x003e, code lost:
        com.xiaomi.mipush.sdk.PushMessageHelper.sendCommandMessageBroadcast(r12, com.xiaomi.mipush.sdk.PushMessageHelper.generateCommandMessage(r0.f8488k, r6, 0, null, r15, null));
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00a9, code lost:
        if (1 == com.xiaomi.mipush.sdk.PushMessageHelper.getPushMode(r12)) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:?, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void setCommand(android.content.Context r12, java.lang.String r13, java.lang.String r14, java.lang.String r15) {
        /*
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            boolean r0 = android.text.TextUtils.isEmpty(r14)
            if (r0 != 0) goto Le
            r6.add(r14)
        Le:
            com.xiaomi.push.ec r0 = com.xiaomi.push.ec.COMMAND_SET_ALIAS
            java.lang.String r1 = r0.f8488k
            boolean r1 = r1.equalsIgnoreCase(r13)
            r2 = 1
            if (r1 == 0) goto L50
            long r3 = java.lang.System.currentTimeMillis()
            long r7 = aliasSetTime(r12, r14)
            long r3 = r3 - r7
            long r3 = java.lang.Math.abs(r3)
            r7 = 86400000(0x5265c00, double:4.2687272E-316)
            int r1 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r1 >= 0) goto L50
            int r14 = com.xiaomi.mipush.sdk.PushMessageHelper.getPushMode(r12)
            if (r2 != r14) goto L3e
        L33:
            r3 = 0
            r5 = 0
            r0 = r12
            r1 = r15
            r2 = r13
            com.xiaomi.mipush.sdk.PushMessageHandler.a(r0, r1, r2, r3, r5, r6)
            goto Lc9
        L3e:
            java.lang.String r0 = r0.f8488k
            r2 = 0
            r4 = 0
            r13 = 0
            r1 = r6
            r5 = r15
            r6 = r13
            com.xiaomi.mipush.sdk.MiPushCommandMessage r13 = com.xiaomi.mipush.sdk.PushMessageHelper.generateCommandMessage(r0, r1, r2, r4, r5, r6)
            com.xiaomi.mipush.sdk.PushMessageHelper.sendCommandMessageBroadcast(r12, r13)
            goto Lc9
        L50:
            com.xiaomi.push.ec r0 = com.xiaomi.push.ec.COMMAND_UNSET_ALIAS
            java.lang.String r0 = r0.f8488k
            boolean r0 = r0.equalsIgnoreCase(r13)
            java.lang.String r1 = " is unseted"
            r3 = 3
            r4 = 0
            if (r0 == 0) goto L87
            long r7 = aliasSetTime(r12, r14)
            int r0 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r0 >= 0) goto L87
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "Don't cancel alias for "
        L6e:
            r12.append(r13)
            java.lang.String r13 = r6.toString()
            java.lang.String r13 = com.xiaomi.push.ar.a(r13, r3)
            r12.append(r13)
            r12.append(r1)
            java.lang.String r12 = r12.toString()
            com.xiaomi.a.a.a.c.a(r12)
            goto Lc9
        L87:
            com.xiaomi.push.ec r0 = com.xiaomi.push.ec.COMMAND_SET_ACCOUNT
            java.lang.String r7 = r0.f8488k
            boolean r7 = r7.equalsIgnoreCase(r13)
            if (r7 == 0) goto Lac
            long r7 = java.lang.System.currentTimeMillis()
            long r9 = accountSetTime(r12, r14)
            long r7 = r7 - r9
            long r7 = java.lang.Math.abs(r7)
            r9 = 3600000(0x36ee80, double:1.7786363E-317)
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 >= 0) goto Lac
            int r14 = com.xiaomi.mipush.sdk.PushMessageHelper.getPushMode(r12)
            if (r2 != r14) goto L3e
            goto L33
        Lac:
            com.xiaomi.push.ec r0 = com.xiaomi.push.ec.COMMAND_UNSET_ACCOUNT
            java.lang.String r0 = r0.f8488k
            boolean r0 = r0.equalsIgnoreCase(r13)
            if (r0 == 0) goto Lc6
            long r7 = accountSetTime(r12, r14)
            int r14 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r14 >= 0) goto Lc6
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "Don't cancel account for "
            goto L6e
        Lc6:
            setCommand(r12, r13, r6, r15)
        Lc9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.MiPushClient.setCommand(android.content.Context, java.lang.String, java.lang.String, java.lang.String):void");
    }

    public static void setCommand(Context context, String str, ArrayList<String> arrayList, String str2) {
        if (TextUtils.isEmpty(b.m74a(context).m75a())) {
            return;
        }
        hl hlVar = new hl();
        String a = com.xiaomi.push.service.ag.a();
        hlVar.a(a);
        hlVar.b(b.m74a(context).m75a());
        hlVar.c(str);
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            hlVar.d(it.next());
        }
        hlVar.f(str2);
        hlVar.e(context.getPackageName());
        com.xiaomi.a.a.a.c.f("cmd:" + str + ", " + a);
        ao.a(context).a((ao) hlVar, gq.Command, (hd) null);
    }

    public static void setLocalNotificationType(Context context, int i2) {
        ao.a(context).b(i2 & (-1));
    }

    public static void setUserAccount(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        setCommand(context, ec.COMMAND_SET_ACCOUNT.f8488k, str, str2);
    }

    private static boolean shouldPullNotification(Context context) {
        return Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_pull_notification", -1L)) > 300000;
    }

    private static boolean shouldSendRegRequest(Context context) {
        return Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_reg_request", -1L)) > 5000;
    }

    public static boolean shouldUseMIUIPush(Context context) {
        return ao.a(context).m67a();
    }

    public static void subscribe(Context context, String str, String str2) {
        if (TextUtils.isEmpty(b.m74a(context).m75a()) || TextUtils.isEmpty(str)) {
            return;
        }
        if (Math.abs(System.currentTimeMillis() - topicSubscribedTime(context, str)) <= 86400000) {
            if (1 == PushMessageHelper.getPushMode(context)) {
                PushMessageHandler.a(context, str2, 0L, null, str);
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(ec.COMMAND_SUBSCRIBE_TOPIC.f8488k, arrayList, 0L, null, null, null));
            return;
        }
        hv hvVar = new hv();
        String a = com.xiaomi.push.service.ag.a();
        hvVar.a(a);
        hvVar.b(b.m74a(context).m75a());
        hvVar.c(str);
        hvVar.d(context.getPackageName());
        hvVar.e(str2);
        com.xiaomi.a.a.a.c.f("cmd:" + ec.COMMAND_SUBSCRIBE_TOPIC + ", " + a);
        ao.a(context).a((ao) hvVar, gq.Subscription, (hd) null);
    }

    public static void syncAssembleCOSPushToken(Context context) {
        ao.a(context).a((String) null, au.UPLOAD_COS_TOKEN, e.ASSEMBLE_PUSH_COS);
    }

    public static void syncAssembleFCMPushToken(Context context) {
        ao.a(context).a((String) null, au.UPLOAD_FCM_TOKEN, e.ASSEMBLE_PUSH_FCM);
    }

    public static void syncAssembleFTOSPushToken(Context context) {
        ao.a(context).a((String) null, au.UPLOAD_FTOS_TOKEN, e.ASSEMBLE_PUSH_FTOS);
    }

    public static void syncAssemblePushToken(Context context) {
        ao.a(context).a((String) null, au.UPLOAD_HUAWEI_TOKEN, e.ASSEMBLE_PUSH_HUAWEI);
    }

    public static long topicSubscribedTime(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        return sharedPreferences.getLong("topic_" + str, -1L);
    }

    public static void turnOffPush(Context context, UPSTurnCallBack uPSTurnCallBack) {
        disablePush(context);
        if (uPSTurnCallBack != null) {
            CodeResult codeResult = new CodeResult();
            codeResult.setResultCode(0L);
            codeResult.getResultCode();
            uPSTurnCallBack.onResult(codeResult);
        }
    }

    public static void turnOnPush(Context context, UPSTurnCallBack uPSTurnCallBack) {
        enablePush(context);
        if (uPSTurnCallBack != null) {
            CodeResult codeResult = new CodeResult();
            codeResult.setResultCode(0L);
            codeResult.getResultCode();
            uPSTurnCallBack.onResult(codeResult);
        }
    }

    public static void unRegisterToken(Context context, UPSUnRegisterCallBack uPSUnRegisterCallBack) {
        unregisterPush(context);
        if (uPSUnRegisterCallBack != null) {
            TokenResult tokenResult = new TokenResult();
            tokenResult.setToken(null);
            tokenResult.getToken();
            tokenResult.setResultCode(0L);
            tokenResult.getResultCode();
            uPSUnRegisterCallBack.onResult(tokenResult);
        }
    }

    public static void unregisterPush(Context context) {
        i.c(context);
        com.xiaomi.push.service.ad.a(context).a();
        if (b.m74a(context).m81b()) {
            hx hxVar = new hx();
            hxVar.a(com.xiaomi.push.service.ag.a());
            hxVar.b(b.m74a(context).m75a());
            hxVar.c(b.m74a(context).m82c());
            hxVar.e(b.m74a(context).b());
            hxVar.d(context.getPackageName());
            ao.a(context).a(hxVar);
            PushMessageHandler.a();
            PushMessageHandler.b();
            b.m74a(context).m80b();
            clearLocalNotificationType(context);
            clearNotification(context);
            clearExtras(context);
        }
    }

    public static void unsetAlias(Context context, String str, String str2) {
        setCommand(context, ec.COMMAND_UNSET_ALIAS.f8488k, str, str2);
    }

    public static void unsetUserAccount(Context context, String str, String str2) {
        setCommand(context, ec.COMMAND_UNSET_ACCOUNT.f8488k, str, str2);
    }

    public static void unsubscribe(Context context, String str, String str2) {
        if (b.m74a(context).m81b()) {
            if (topicSubscribedTime(context, str) < 0) {
                com.xiaomi.a.a.a.c.a("Don't cancel subscribe for " + str + " is unsubscribed");
                return;
            }
            hz hzVar = new hz();
            String a = com.xiaomi.push.service.ag.a();
            hzVar.a(a);
            hzVar.b(b.m74a(context).m75a());
            hzVar.c(str);
            hzVar.d(context.getPackageName());
            hzVar.e(str2);
            com.xiaomi.a.a.a.c.f("cmd:" + ec.COMMAND_UNSUBSCRIBE_TOPIC + ", " + a);
            ao.a(context).a((ao) hzVar, gq.UnSubscription, (hd) null);
        }
    }

    private static void updateImeiOrOaid() {
        new Thread(new Runnable() { // from class: com.xiaomi.mipush.sdk.MiPushClient.3
            @Override // java.lang.Runnable
            public void run() {
                String d2;
                if (jc.g()) {
                    return;
                }
                if (ii.d(MiPushClient.sContext) != null || com.xiaomi.push.ac.a(MiPushClient.sContext).a()) {
                    hq hqVar = new hq();
                    hqVar.b(b.m74a(MiPushClient.sContext).m75a());
                    hqVar.c(ha.ClientInfoUpdate.ah);
                    hqVar.a(com.xiaomi.push.service.ag.a());
                    hqVar.a(new HashMap());
                    String str = "";
                    if (!TextUtils.isEmpty(ii.d(MiPushClient.sContext))) {
                        str = "" + com.xiaomi.push.ar.a(d2);
                    }
                    String f2 = ii.f(MiPushClient.sContext);
                    if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(f2)) {
                        str = str + Constants.ACCEPT_TIME_SEPARATOR_SP + f2;
                    }
                    if (!TextUtils.isEmpty(str)) {
                        hqVar.k().put(Constants.EXTRA_KEY_IMEI_MD5, str);
                    }
                    com.xiaomi.push.ac.a(MiPushClient.sContext).a(hqVar.k());
                    int a = ii.a();
                    if (a >= 0) {
                        hqVar.k().put("space_id", Integer.toString(a));
                    }
                    ao.a(MiPushClient.sContext).a((ao) hqVar, gq.Notification, false, (hd) null);
                }
            }
        }).start();
    }
}
