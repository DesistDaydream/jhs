package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PermissionInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: classes3.dex */
public class v {

    /* loaded from: classes3.dex */
    public static class a extends RuntimeException {
        public a(String str) {
            super(str);
        }
    }

    /* loaded from: classes3.dex */
    public static class b {
        public String a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f56a;
        public String b;

        /* renamed from: b  reason: collision with other field name */
        public boolean f57b;

        public b(String str, boolean z, boolean z2, String str2) {
            this.a = str;
            this.f56a = z;
            this.f57b = z2;
            this.b = str2;
        }
    }

    private static ActivityInfo a(PackageManager packageManager, Intent intent, Class<?> cls) {
        for (ResolveInfo resolveInfo : packageManager.queryBroadcastReceivers(intent, 16384)) {
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            if (activityInfo != null && cls.getCanonicalName().equals(activityInfo.name)) {
                return activityInfo;
            }
        }
        return null;
    }

    public static void a(Context context) {
        new Thread(new w(context)).start();
    }

    private static void a(Context context, String str, String str2) {
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        Intent intent = new Intent(str);
        intent.setPackage(packageName);
        boolean z = false;
        for (ResolveInfo resolveInfo : packageManager.queryBroadcastReceivers(intent, 16384)) {
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            if (activityInfo == null || TextUtils.isEmpty(activityInfo.name) || !activityInfo.name.equals(str2)) {
                z = false;
                continue;
            } else {
                z = true;
                continue;
            }
            if (z) {
                break;
            }
        }
        if (!z) {
            throw new a(String.format("<receiver android:name=\"%1$s\" .../> is missing or disabled in AndroidManifest.", str2));
        }
    }

    private static void a(ActivityInfo activityInfo, Boolean[] boolArr) {
        if (boolArr[0].booleanValue() != activityInfo.enabled) {
            throw new a(String.format("<receiver android:name=\"%1$s\" .../> in AndroidManifest had the wrong enabled attribute, which should be android:enabled=%2$b.", activityInfo.name, boolArr[0]));
        }
        if (boolArr[1].booleanValue() != activityInfo.exported) {
            throw new a(String.format("<receiver android:name=\"%1$s\" .../> in AndroidManifest had the wrong exported attribute, which should be android:exported=%2$b.", activityInfo.name, boolArr[1]));
        }
    }

    private static boolean a(PackageInfo packageInfo, String[] strArr) {
        for (ServiceInfo serviceInfo : packageInfo.services) {
            if (a(strArr, serviceInfo.name)) {
                return true;
            }
        }
        return false;
    }

    private static boolean a(String[] strArr, String str) {
        if (strArr != null && str != null) {
            for (String str2 : strArr) {
                if (TextUtils.equals(str2, str)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:44:0x009e A[EDGE_INSN: B:44:0x009e->B:30:0x009e ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x006a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void c(android.content.Context r10) {
        /*
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            java.lang.String r2 = "com.xiaomi.push.service.receivers.PingReceiver"
            android.content.pm.PackageManager r3 = r10.getPackageManager()
            java.lang.String r4 = r10.getPackageName()
            android.content.Intent r5 = new android.content.Intent
            java.lang.String r6 = com.xiaomi.push.service.an.p
            r5.<init>(r6)
            r5.setPackage(r4)
            r6 = 1
            r7 = 0
            java.lang.Class r8 = com.xiaomi.push.jl.a(r10, r2)     // Catch: java.lang.ClassNotFoundException -> L51
            android.content.pm.ActivityInfo r5 = a(r3, r5, r8)     // Catch: java.lang.ClassNotFoundException -> L51
            boolean r8 = com.xiaomi.mipush.sdk.MiPushClient.shouldUseMIUIPush(r10)     // Catch: java.lang.ClassNotFoundException -> L51
            r9 = 2
            if (r8 != 0) goto L45
            if (r5 == 0) goto L35
            java.lang.Boolean[] r2 = new java.lang.Boolean[r9]     // Catch: java.lang.ClassNotFoundException -> L51
            r2[r7] = r1     // Catch: java.lang.ClassNotFoundException -> L51
            r2[r6] = r0     // Catch: java.lang.ClassNotFoundException -> L51
            a(r5, r2)     // Catch: java.lang.ClassNotFoundException -> L51
            goto L55
        L35:
            com.xiaomi.mipush.sdk.v$a r0 = new com.xiaomi.mipush.sdk.v$a     // Catch: java.lang.ClassNotFoundException -> L51
            java.lang.String r1 = "<receiver android:name=\"%1$s\" .../> is missing or disabled in AndroidManifest."
            java.lang.Object[] r5 = new java.lang.Object[r6]     // Catch: java.lang.ClassNotFoundException -> L51
            r5[r7] = r2     // Catch: java.lang.ClassNotFoundException -> L51
            java.lang.String r1 = java.lang.String.format(r1, r5)     // Catch: java.lang.ClassNotFoundException -> L51
            r0.<init>(r1)     // Catch: java.lang.ClassNotFoundException -> L51
            throw r0     // Catch: java.lang.ClassNotFoundException -> L51
        L45:
            if (r5 == 0) goto L55
            java.lang.Boolean[] r2 = new java.lang.Boolean[r9]     // Catch: java.lang.ClassNotFoundException -> L51
            r2[r7] = r1     // Catch: java.lang.ClassNotFoundException -> L51
            r2[r6] = r0     // Catch: java.lang.ClassNotFoundException -> L51
            a(r5, r2)     // Catch: java.lang.ClassNotFoundException -> L51
            goto L55
        L51:
            r0 = move-exception
            com.xiaomi.a.a.a.c.a(r0)
        L55:
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r1 = "com.xiaomi.mipush.RECEIVE_MESSAGE"
            r0.<init>(r1)
            r0.setPackage(r4)
            r1 = 16384(0x4000, float:2.2959E-41)
            java.util.List r0 = r3.queryBroadcastReceivers(r0, r1)
            java.util.Iterator r0 = r0.iterator()
            r1 = 0
        L6a:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L9e
            java.lang.Object r2 = r0.next()
            android.content.pm.ResolveInfo r2 = (android.content.pm.ResolveInfo) r2
            android.content.pm.ActivityInfo r2 = r2.activityInfo
            if (r2 == 0) goto L9b
            java.lang.String r3 = r2.name     // Catch: java.lang.ClassNotFoundException -> L96
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.ClassNotFoundException -> L96
            if (r3 != 0) goto L9b
            java.lang.Class<com.xiaomi.mipush.sdk.PushMessageReceiver> r3 = com.xiaomi.mipush.sdk.PushMessageReceiver.class
            java.lang.String r4 = r2.name     // Catch: java.lang.ClassNotFoundException -> L96
            java.lang.Class r4 = com.xiaomi.push.jl.a(r10, r4)     // Catch: java.lang.ClassNotFoundException -> L96
            boolean r3 = r3.isAssignableFrom(r4)     // Catch: java.lang.ClassNotFoundException -> L96
            if (r3 == 0) goto L9b
            boolean r1 = r2.enabled     // Catch: java.lang.ClassNotFoundException -> L96
            if (r1 == 0) goto L9b
            r1 = 1
            goto L9c
        L96:
            r2 = move-exception
            com.xiaomi.a.a.a.c.a(r2)
            goto L6a
        L9b:
            r1 = 0
        L9c:
            if (r1 == 0) goto L6a
        L9e:
            if (r1 == 0) goto Lc2
            boolean r0 = com.xiaomi.mipush.sdk.MiPushClient.getOpenHmsPush(r10)
            if (r0 == 0) goto Lb4
            java.lang.String r0 = "com.huawei.android.push.intent.RECEIVE"
            java.lang.String r1 = "com.xiaomi.assemble.control.HmsPushReceiver"
            a(r10, r0, r1)
            java.lang.String r0 = "com.huawei.intent.action.PUSH"
            java.lang.String r1 = "com.huawei.hms.support.api.push.PushEventReceiver"
            a(r10, r0, r1)
        Lb4:
            boolean r0 = com.xiaomi.mipush.sdk.MiPushClient.getOpenVIVOPush(r10)
            if (r0 == 0) goto Lc1
            java.lang.String r0 = "com.vivo.pushclient.action.RECEIVE"
            java.lang.String r1 = "com.xiaomi.assemble.control.FTOSPushMessageReceiver"
            a(r10, r0, r1)
        Lc1:
            return
        Lc2:
            com.xiaomi.mipush.sdk.v$a r10 = new com.xiaomi.mipush.sdk.v$a
            java.lang.String r0 = "Receiver: none of the subclasses of PushMessageReceiver is enabled or defined."
            r10.<init>(r0)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.v.c(android.content.Context):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context, PackageInfo packageInfo) {
        boolean z;
        HashSet hashSet = new HashSet();
        String str = context.getPackageName() + ".permission.MIPUSH_RECEIVE";
        hashSet.addAll(Arrays.asList("android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", str, "android.permission.ACCESS_WIFI_STATE", "android.permission.VIBRATE"));
        PermissionInfo[] permissionInfoArr = packageInfo.permissions;
        if (permissionInfoArr != null) {
            for (PermissionInfo permissionInfo : permissionInfoArr) {
                if (str.equals(permissionInfo.name)) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        if (!z) {
            throw new a(String.format("<permission android:name=\"%1$s\" .../> is undefined in AndroidManifest.", str));
        }
        String[] strArr = packageInfo.requestedPermissions;
        if (strArr != null) {
            for (String str2 : strArr) {
                if (!TextUtils.isEmpty(str2) && hashSet.contains(str2)) {
                    hashSet.remove(str2);
                    if (hashSet.isEmpty()) {
                        break;
                    }
                }
            }
        }
        if (!hashSet.isEmpty()) {
            throw new a(String.format("<uses-permission android:name=\"%1$s\"/> is missing in AndroidManifest.", hashSet.iterator().next()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(Context context, PackageInfo packageInfo) {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        hashMap2.put(PushMessageHandler.class.getCanonicalName(), new b(PushMessageHandler.class.getCanonicalName(), true, true, ""));
        hashMap2.put(MessageHandleService.class.getCanonicalName(), new b(MessageHandleService.class.getCanonicalName(), true, false, ""));
        if (!MiPushClient.shouldUseMIUIPush(context) || a(packageInfo, new String[]{"com.xiaomi.push.service.XMJobService", "com.xiaomi.push.service.XMPushService"})) {
            hashMap2.put("com.xiaomi.push.service.XMJobService", new b("com.xiaomi.push.service.XMJobService", true, false, "android.permission.BIND_JOB_SERVICE"));
            hashMap2.put("com.xiaomi.push.service.XMPushService", new b("com.xiaomi.push.service.XMPushService", true, false, ""));
        }
        if (MiPushClient.getOpenFCMPush(context)) {
            hashMap2.put("com.xiaomi.assemble.control.MiFireBaseInstanceIdService", new b("com.xiaomi.assemble.control.MiFireBaseInstanceIdService", true, false, ""));
            hashMap2.put("com.xiaomi.assemble.control.MiFirebaseMessagingService", new b("com.xiaomi.assemble.control.MiFirebaseMessagingService", true, false, ""));
        }
        if (MiPushClient.getOpenOPPOPush(context)) {
            hashMap2.put("com.xiaomi.assemble.control.COSPushMessageService", new b("com.xiaomi.assemble.control.COSPushMessageService", true, true, "com.coloros.mcs.permission.SEND_MCS_MESSAGE"));
        }
        ServiceInfo[] serviceInfoArr = packageInfo.services;
        if (serviceInfoArr != null) {
            for (ServiceInfo serviceInfo : serviceInfoArr) {
                if (!TextUtils.isEmpty(serviceInfo.name) && hashMap2.containsKey(serviceInfo.name)) {
                    b bVar = (b) hashMap2.remove(serviceInfo.name);
                    boolean z = bVar.f56a;
                    boolean z2 = bVar.f57b;
                    String str = bVar.b;
                    if (z != serviceInfo.enabled) {
                        throw new a(String.format("<service android:name=\"%1$s\" .../> in AndroidManifest had the wrong enabled attribute, which should be android:enabled=%2$b.", serviceInfo.name, Boolean.valueOf(z)));
                    }
                    if (z2 != serviceInfo.exported) {
                        throw new a(String.format("<service android:name=\"%1$s\" .../> in AndroidManifest had the wrong exported attribute, which should be android:exported=%2$b.", serviceInfo.name, Boolean.valueOf(z2)));
                    }
                    if (!TextUtils.isEmpty(str) && !TextUtils.equals(str, serviceInfo.permission)) {
                        throw new a(String.format("<service android:name=\"%1$s\" .../> in AndroidManifest had the wrong permission attribute, which should be android:permission=\"%2$s\".", serviceInfo.name, str));
                    }
                    hashMap.put(serviceInfo.name, serviceInfo.processName);
                    if (hashMap2.isEmpty()) {
                        break;
                    }
                }
            }
        }
        if (!hashMap2.isEmpty()) {
            throw new a(String.format("<service android:name=\"%1$s\" .../> is missing or disabled in AndroidManifest.", hashMap2.keySet().iterator().next()));
        }
        if (!TextUtils.equals((CharSequence) hashMap.get(PushMessageHandler.class.getCanonicalName()), (CharSequence) hashMap.get(MessageHandleService.class.getCanonicalName()))) {
            throw new a(String.format("\"%1$s\" and \"%2$s\" must be running in the same process.", PushMessageHandler.class.getCanonicalName(), MessageHandleService.class.getCanonicalName()));
        }
        if (hashMap.containsKey("com.xiaomi.push.service.XMJobService") && hashMap.containsKey("com.xiaomi.push.service.XMPushService") && !TextUtils.equals((CharSequence) hashMap.get("com.xiaomi.push.service.XMJobService"), (CharSequence) hashMap.get("com.xiaomi.push.service.XMPushService"))) {
            throw new a(String.format("\"%1$s\" and \"%2$s\" must be running in the same process.", "com.xiaomi.push.service.XMJobService", "com.xiaomi.push.service.XMPushService"));
        }
    }
}
