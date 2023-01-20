package com.tencent.tpns.baseapi.core.b;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.effective.android.panel.Constants;
import com.tencent.tpns.baseapi.XGApiConfig;
import com.tencent.tpns.baseapi.base.DNSResolver;
import com.tencent.tpns.baseapi.base.PushPreferences;
import com.tencent.tpns.baseapi.base.device.GUIDInfo;
import com.tencent.tpns.baseapi.base.device.GuidInfoManager;
import com.tencent.tpns.baseapi.base.logger.TBaseLogger;
import com.tencent.tpns.baseapi.base.util.CloudManager;
import com.tencent.tpns.baseapi.base.util.ErrCode;
import com.tencent.tpns.baseapi.base.util.Logger;
import com.tencent.tpns.baseapi.base.util.Util;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class a {
    private static boolean a = false;
    private static String b = null;

    /* renamed from: c */
    private static boolean f6886c = false;

    /* renamed from: d */
    private static String f6887d = null;

    /* renamed from: e */
    private static String f6888e = null;

    /* renamed from: f */
    private static long f6889f = 0;

    /* renamed from: g */
    private static boolean f6890g = false;

    /* renamed from: h */
    private static long f6891h = 0;

    /* renamed from: i */
    private static boolean f6892i = false;

    public static long d(Context context) {
        return PushPreferences.getLong(context.getApplicationContext(), "XG_GUID_GUID", 0L);
    }

    public static String e(Context context) {
        return PushPreferences.getString(context.getApplicationContext(), "XG_GUID_MQTT_SERVER", null);
    }

    public static synchronized String f(Context context) {
        String str;
        synchronized (a.class) {
            if (f6887d == null) {
                f6887d = PushPreferences.getString(context.getApplicationContext(), "XG_LAST_RESOLVED_GUID_SERVER_IP", "");
                Logger.i("GuidInfoManagerImpl", "getLastResolvedGuidServerIP | lastGuidServerIp is null, get from Shar");
            }
            Logger.i("GuidInfoManagerImpl", "getLastResolvedGuidServerIP | lastGuidServerIp : " + f6887d);
            str = f6887d;
        }
        return str;
    }

    public static synchronized String g(Context context) {
        String str;
        synchronized (a.class) {
            if (f6888e == null) {
                Logger.i("GuidInfoManagerImpl", "MqttServerAddr null, get from Shar");
                f6888e = PushPreferences.getString(context.getApplicationContext(), "XG_GUID_MQTT_SERVER_DEFAULT_ADDRESS", "");
            }
            Logger.i("GuidInfoManagerImpl", "Get mqttServerIP: " + f6888e);
            str = f6888e;
        }
        return str;
    }

    public static String h(Context context) {
        return PushPreferences.getString(context.getApplicationContext(), "XG_GUID_MQTT_USERNAME", null);
    }

    public static String i(Context context) {
        return PushPreferences.getString(context.getApplicationContext(), "XG_GUID_MQTT_PASSWORD", null);
    }

    public static long j(Context context) {
        return PushPreferences.getLong(context.getApplicationContext(), "XG_GUID_EXPIRED_SECONDS", 43200L);
    }

    public static long k(Context context) {
        return PushPreferences.getLong(context.getApplicationContext(), "XG_GUID_LAST_REFRESH_TIME", 0L);
    }

    public static boolean l(Context context) {
        long k2 = k(context.getApplicationContext());
        if (!f6890g) {
            f6890g = true;
            if (XGApiConfig.getAccessId(context) != PushPreferences.getLong(context, "XG_GUID_LAST_ACCESSID", 0L)) {
                Logger.d("GuidInfoManagerImpl", "New AccessId need to refresh token");
                p(context);
                return true;
            }
        }
        long currentTimeMillis = (System.currentTimeMillis() - k2) / 1000;
        Logger.i("GuidInfoManagerImpl", "GuidInfo gapSeconds = " + currentTimeMillis + ", compare to " + j(context.getApplicationContext()));
        return currentTimeMillis > j(context.getApplicationContext());
    }

    public static long m(Context context) {
        if (f6891h == 0) {
            Logger.i("GuidInfoManagerImpl", "MqttServerLastRefreshTime null, get from Shar");
            f6891h = PushPreferences.getLong(context.getApplicationContext(), "XG_GUID_MQTT_SERVER_LAST_REFRESH_TIME", 0L);
        }
        Logger.i("GuidInfoManagerImpl", "Get mqttServerLastRefreshTime: " + f6891h);
        return f6891h;
    }

    public static boolean n(Context context) {
        Logger.d("GuidInfoManagerImpl", "Check MqttServer expired?");
        long currentTimeMillis = (System.currentTimeMillis() - m(context)) / 1000;
        Logger.i("GuidInfoManagerImpl", "MqttServerAddr gapSeconds = " + currentTimeMillis + ", 1800");
        return currentTimeMillis > 1800;
    }

    public static void o(Context context) {
        TBaseLogger.ii("GuidInfoManagerImpl", "Force expired guidInfo, let its refreshTime 0");
        PushPreferences.putLong(context, "XG_GUID_LAST_REFRESH_TIME", 0L);
    }

    public static void p(Context context) {
        a();
        Logger.d("GuidInfoManagerImpl", "clearGuidInfo");
        b(context, "", "");
        ContentValues contentValues = new ContentValues();
        contentValues.put("XG_GUID_TOKEN", "");
        contentValues.put("XG_GUID_TOKEN_LIST", (String) null);
        contentValues.put("XG_GUID_MQTT_SERVER", "");
        contentValues.put("XG_GUID_MQTT_USERNAME", "");
        contentValues.put("XG_GUID_MQTT_PASSWORD", "");
        contentValues.put("XG_GUID_EXPIRED_SECONDS", (Integer) 172800);
        contentValues.put("XG_GUID_LAST_REFRESH_TIME", (Long) 0L);
        contentValues.put("XG_GUID_SERVER_PENALTY_TIME", (Long) 0L);
        contentValues.put("XG_GUID_SERVER_ABANDON_PENALTY_TIME", (Long) 0L);
        ContentValues reset = CloudManager.getInstance(context).reset();
        if (reset != null) {
            contentValues.putAll(reset);
        }
        PushPreferences.putContentValues(context, contentValues);
    }

    public static boolean q(Context context) {
        if (!f6892i) {
            f6892i = true;
            if (u(context)) {
                PushPreferences.putLong(context, "XG_GUID_SERVER_PENALTY_TIME", 0L);
                return false;
            }
        }
        return PushPreferences.getLong(context, "XG_GUID_SERVER_PENALTY_TIME", 0L) > System.currentTimeMillis();
    }

    public static int r(Context context) {
        if (PushPreferences.getLong(context, "XG_GUID_SERVER_ABANDON_PENALTY_TIME", 0L) <= System.currentTimeMillis()) {
            PushPreferences.putLong(context, "XG_GUID_SERVER_ABANDON_PENALTY_TIME", 0L);
            return 0;
        }
        return PushPreferences.getInt(context.getApplicationContext(), "XG_GUID_SERVER_ABANDON_RATE", 0);
    }

    public static int s(Context context) {
        return PushPreferences.getInt(context.getApplicationContext(), "XG_GUID_SERVER_ENCRYPT_LEVEL", 0);
    }

    private static Pair<String, String> t(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("tpush.vip.service.shareprefs", 0);
        String string = sharedPreferences.getString(a("XG_GUID_TOKEN"), null);
        String string2 = sharedPreferences.getString(a("XG_GUID_TOKEN_LIST"), null);
        if (string == null) {
            string = b(context);
        }
        if (string2 == null) {
            string2 = c(context);
        }
        return new Pair<>(string, string2);
    }

    private static boolean u(Context context) {
        long j2 = PushPreferences.getLong(context, "XG_GUID_LAST_APP_VERSION_CODE", 0L);
        long curVersionCode = Util.getCurVersionCode(context);
        if (j2 != curVersionCode) {
            PushPreferences.putLong(context, "XG_GUID_LAST_APP_VERSION_CODE", curVersionCode);
            if (curVersionCode > j2) {
                Logger.i("GuidInfoManagerImpl", "App is Update");
                return true;
            }
            return false;
        }
        return false;
    }

    public static GUIDInfo a(Context context, boolean z, String str) {
        Logger.d("GuidInfoManagerImpl", "getFinalMqttServerAddrAndGuidInfo");
        if (z) {
            GUIDInfo gUIDInfo = new GUIDInfo();
            try {
                JSONObject jSONObject = new JSONObject(str);
                jSONObject.put(MiPushClient.COMMAND_REGISTER, 1);
                jSONObject.put("from", 1);
                gUIDInfo = a(context, 0, jSONObject);
                if (!gUIDInfo.isError()) {
                    String hostToIp = DNSResolver.hostToIp(gUIDInfo.mqttServer, gUIDInfo.mqttPortList);
                    if (!Util.isNullOrEmptyString(hostToIp)) {
                        Logger.i("GuidInfoManagerImpl", "Get MqttServer: " + gUIDInfo.mqttServer + ", save address: " + hostToIp);
                        c(context, hostToIp);
                        a(context, System.currentTimeMillis());
                    }
                    gUIDInfo.mqttServerIP = hostToIp;
                }
            } catch (Throwable unused) {
                gUIDInfo.errCode = ErrCode.INNER_ERROR_JSON;
            }
            return gUIDInfo;
        }
        return a(context);
    }

    private static JSONObject b(Context context, long j2) {
        JSONObject jSONObject = new JSONObject();
        long accessId = XGApiConfig.getAccessId(context);
        String accessKey = XGApiConfig.getAccessKey(context);
        long currentTimeMillis = System.currentTimeMillis();
        jSONObject.put("accessId", accessId);
        jSONObject.put("accessKey", accessKey);
        jSONObject.put("deviceType", 0);
        jSONObject.put(com.heytap.mcssdk.constant.b.C, "1.3.5.0");
        jSONObject.put("seq", j2);
        jSONObject.put("cloudVersion", CloudManager.getInstance(context).getCloudVersion());
        b bVar = new b();
        bVar.a = Util.getCurAppVersion(context);
        bVar.f6893c = Constants.ANDROID;
        bVar.f6894d = context.getPackageName();
        bVar.f6895e = Build.VERSION.RELEASE;
        if (!Util.isNullOrEmptyString(bVar.a)) {
            jSONObject.put("appVersion", bVar.a);
        }
        if (!Util.isNullOrEmptyString(bVar.f6894d)) {
            jSONObject.put("appPkgName", bVar.f6894d);
        }
        jSONObject.put("deviceInfo", bVar.a());
        jSONObject.put("protocolVersion", 2);
        jSONObject.put("timestamp", currentTimeMillis);
        return jSONObject;
    }

    public static String c(Context context) {
        try {
            return PushPreferences.getString(context.getApplicationContext(), "XG_GUID_TOKEN_LIST", null);
        } catch (Throwable th) {
            Logger.e("GuidInfoManagerImpl", "getGuid Throwable: ", th);
            return "";
        }
    }

    private static String d(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return "";
        }
        String lastResolvedGuidServerIP = GuidInfoManager.getLastResolvedGuidServerIP(context);
        if (TextUtils.isEmpty(lastResolvedGuidServerIP)) {
            return str;
        }
        String a2 = a(str, lastResolvedGuidServerIP);
        Logger.d("GuidInfoManagerImpl", "replaceGuidHostWithLastResolvedIP | lastResolvedIp : " + lastResolvedGuidServerIP + "; guidServerAddr : " + str + "; ipAddr : " + a2);
        return a2;
    }

    public static synchronized void c(Context context, String str) {
        synchronized (a.class) {
            if (Util.isNullOrEmptyString(str)) {
                return;
            }
            Logger.i("GuidInfoManagerImpl", "Save mqttServerIP: " + str);
            if (!str.equals(f6888e)) {
                f6888e = str;
                PushPreferences.putString(context.getApplicationContext(), "XG_GUID_MQTT_SERVER_DEFAULT_ADDRESS", str);
            }
        }
    }

    public static GUIDInfo a(Context context) {
        GUIDInfo guidInfoFromShar;
        GUIDInfo gUIDInfo = new GUIDInfo();
        if (q(context)) {
            Logger.e("GuidInfoManagerImpl", "getFinalMqttServerAddrAndGuidInfo: Resources have been destroyed");
            gUIDInfo.errCode = ErrCode.GUID_INFO_SERVER_DESTROY;
            return gUIDInfo;
        } else if (l(context)) {
            Logger.ii("GuidInfoManagerImpl", "Guid expired, request for new one.");
            GUIDInfo a2 = a(context, 0, (JSONObject) null);
            if (a2.isError()) {
                if (a2.errCode == 10030006) {
                    Logger.d("GuidInfoManagerImpl", "Get guidServer error GUID_SERVER_DESTROY, directly return");
                    return a2;
                }
                Logger.i("GuidInfoManagerImpl", "Get guidServer error, guid == null;");
                GUIDInfo guidInfoFromShar2 = GUIDInfo.getGuidInfoFromShar(context);
                if (!guidInfoFromShar2.isError()) {
                    a2 = guidInfoFromShar2;
                }
                a2.mqttServerIP = g(context);
                return a2;
            }
            String hostToIp = DNSResolver.hostToIp(a2.mqttServer, a2.mqttPortList);
            if (Util.isNullOrEmptyString(hostToIp)) {
                hostToIp = g(context);
                Logger.i("GuidInfoManagerImpl", "MqttServer domain resolver failed, get from shar: " + hostToIp);
            } else {
                Logger.i("GuidInfoManagerImpl", "Get MqttServer: " + a2.mqttServer + ", save address: " + hostToIp);
                c(context, hostToIp);
                a(context, System.currentTimeMillis());
            }
            a2.mqttServerIP = hostToIp;
            return a2;
        } else {
            Logger.i("GuidInfoManagerImpl", "GuidInfo not expired. Check mqttServer");
            String g2 = g(context);
            if (n(context)) {
                Logger.i("GuidInfoManagerImpl", "Mqtt expired. Last MqttServer address: " + g2);
                guidInfoFromShar = GUIDInfo.getGuidInfoFromShar(context);
                if (!Util.isNullOrEmptyString(guidInfoFromShar.mqttServer)) {
                    String hostToIp2 = DNSResolver.hostToIp(guidInfoFromShar.mqttServer, guidInfoFromShar.mqttPortList);
                    if (Util.isNullOrEmptyString(hostToIp2)) {
                        guidInfoFromShar.mqttServerIP = g2;
                        return guidInfoFromShar;
                    }
                    if (g2 != null) {
                        int lastIndexOf = g2.lastIndexOf(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                        int lastIndexOf2 = hostToIp2.lastIndexOf(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                        if (!(lastIndexOf > 0 ? g2.substring(0, lastIndexOf) : g2).equals(lastIndexOf2 > 0 ? hostToIp2.substring(0, lastIndexOf2) : hostToIp2)) {
                            Logger.w("GuidInfoManagerImpl", "MqttServerAddr changed, request guidServer for new one.");
                            GUIDInfo a3 = a(context, 1, (JSONObject) null);
                            if (GuidInfoManager.isServerDestroy(context)) {
                                Logger.e("GuidInfoManagerImpl", "Resources have been destroyed");
                                guidInfoFromShar.errCode = ErrCode.GUID_INFO_SERVER_DESTROY;
                                return guidInfoFromShar;
                            } else if (a3 != null && !a3.isError()) {
                                if (!Util.isNullOrEmptyString(a3.mqttServer)) {
                                    String hostToIp3 = DNSResolver.hostToIp(a3.mqttServer, a3.mqttPortList);
                                    if (!Util.isNullOrEmptyString(hostToIp3)) {
                                        Logger.i("GuidInfoManagerImpl", "Get MqttServer: " + a3.mqttServer + ", save address: " + hostToIp3);
                                        c(context, hostToIp3);
                                        a(context, System.currentTimeMillis());
                                        g2 = hostToIp3;
                                    }
                                    guidInfoFromShar = a3;
                                } else {
                                    Logger.e("GuidInfoManagerImpl", "get new server guid error");
                                }
                                hostToIp2 = g2;
                            } else {
                                Logger.i("GuidInfoManagerImpl", "Get new server guid error, get guid and finalMqttServerAddr from Shar");
                                guidInfoFromShar.mqttServerIP = g2;
                                return guidInfoFromShar;
                            }
                        }
                    }
                    g2 = hostToIp2;
                } else {
                    Logger.e("GuidInfoManagerImpl", "get local GUIDInfo guid error");
                }
            } else {
                Logger.i("GuidInfoManagerImpl", "MqttServer not expired.");
                guidInfoFromShar = GUIDInfo.getGuidInfoFromShar(context);
            }
            Logger.i("GuidInfoManagerImpl", "Guid status: " + guidInfoFromShar);
            if (guidInfoFromShar != null && !guidInfoFromShar.isError()) {
                guidInfoFromShar.mqttServerIP = g2;
            }
            return guidInfoFromShar;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0021 A[Catch: all -> 0x006d, LOOP:0: B:37:0x001b->B:39:0x0021, LOOP_END, TryCatch #0 {all -> 0x006d, blocks: (B:31:0x0002, B:34:0x0009, B:36:0x0014, B:37:0x001b, B:39:0x0021, B:40:0x002b, B:42:0x0031, B:43:0x0034, B:44:0x0037, B:46:0x003f, B:47:0x0049, B:35:0x000f), top: B:52:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0031 A[Catch: all -> 0x006d, TryCatch #0 {all -> 0x006d, blocks: (B:31:0x0002, B:34:0x0009, B:36:0x0014, B:37:0x001b, B:39:0x0021, B:40:0x002b, B:42:0x0031, B:43:0x0034, B:44:0x0037, B:46:0x003f, B:47:0x0049, B:35:0x000f), top: B:52:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x003f A[Catch: all -> 0x006d, LOOP:1: B:44:0x0037->B:46:0x003f, LOOP_END, TryCatch #0 {all -> 0x006d, blocks: (B:31:0x0002, B:34:0x0009, B:36:0x0014, B:37:0x001b, B:39:0x0021, B:40:0x002b, B:42:0x0031, B:43:0x0034, B:44:0x0037, B:46:0x003f, B:47:0x0049, B:35:0x000f), top: B:52:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String b(java.lang.String r4, java.lang.String r5) {
        /*
            if (r5 == 0) goto Lf
            boolean r0 = r5.isEmpty()     // Catch: java.lang.Throwable -> L6d
            if (r0 == 0) goto L9
            goto Lf
        L9:
            org.json.JSONArray r0 = new org.json.JSONArray     // Catch: java.lang.Throwable -> L6d
            r0.<init>(r5)     // Catch: java.lang.Throwable -> L6d
            goto L14
        Lf:
            org.json.JSONArray r0 = new org.json.JSONArray     // Catch: java.lang.Throwable -> L6d
            r0.<init>()     // Catch: java.lang.Throwable -> L6d
        L14:
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L6d
            r5.<init>()     // Catch: java.lang.Throwable -> L6d
            r1 = 0
            r2 = 0
        L1b:
            int r3 = r0.length()     // Catch: java.lang.Throwable -> L6d
            if (r2 >= r3) goto L2b
            java.lang.String r3 = r0.getString(r2)     // Catch: java.lang.Throwable -> L6d
            r5.add(r3)     // Catch: java.lang.Throwable -> L6d
            int r2 = r2 + 1
            goto L1b
        L2b:
            boolean r0 = r5.contains(r4)     // Catch: java.lang.Throwable -> L6d
            if (r0 == 0) goto L34
            r5.remove(r4)     // Catch: java.lang.Throwable -> L6d
        L34:
            r5.add(r1, r4)     // Catch: java.lang.Throwable -> L6d
        L37:
            int r4 = r5.size()     // Catch: java.lang.Throwable -> L6d
            r0 = 10
            if (r4 <= r0) goto L49
            int r4 = r5.size()     // Catch: java.lang.Throwable -> L6d
            int r4 = r4 + (-1)
            r5.remove(r4)     // Catch: java.lang.Throwable -> L6d
            goto L37
        L49:
            org.json.JSONArray r4 = new org.json.JSONArray     // Catch: java.lang.Throwable -> L6d
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L6d
            java.lang.String r5 = "GuidInfoManagerImpl"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6d
            r0.<init>()     // Catch: java.lang.Throwable -> L6d
            java.lang.String r1 = "Update tokenList: "
            r0.append(r1)     // Catch: java.lang.Throwable -> L6d
            java.lang.String r1 = r4.toString()     // Catch: java.lang.Throwable -> L6d
            r0.append(r1)     // Catch: java.lang.Throwable -> L6d
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L6d
            com.tencent.tpns.baseapi.base.util.Logger.i(r5, r0)     // Catch: java.lang.Throwable -> L6d
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L6d
            return r4
        L6d:
            r4 = move-exception
            r4.printStackTrace()
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tpns.baseapi.core.b.a.b(java.lang.String, java.lang.String):java.lang.String");
    }

    private static void b(Context context, String str, String str2) {
        SharedPreferences.Editor edit = context.getSharedPreferences("tpush.vip.service.shareprefs", 0).edit();
        edit.putString(a("XG_GUID_TOKEN"), str);
        edit.putString(a("XG_GUID_TOKEN_LIST"), str2);
        edit.commit();
    }

    public static String b(Context context) {
        try {
            if (TextUtils.isEmpty(b)) {
                b = PushPreferences.getString(context.getApplicationContext(), "XG_GUID_TOKEN", null);
            }
            return b;
        } catch (Throwable th) {
            Logger.e("GuidInfoManagerImpl", "getToken Throwable: ", th);
            return "";
        }
    }

    public static synchronized void b(Context context, String str) {
        synchronized (a.class) {
            if (Util.isNullOrEmptyString(str)) {
                return;
            }
            Logger.i("GuidInfoManagerImpl", "setLastResolvedGuidServerIP | lastGuidServerIp : " + f6887d + "; newGuidServerIp : " + str);
            if (!str.equalsIgnoreCase(f6887d)) {
                f6887d = str;
                PushPreferences.putString(context.getApplicationContext(), "XG_LAST_RESOLVED_GUID_SERVER_IP", str);
            }
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:292:0x0383
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public static com.tencent.tpns.baseapi.base.device.GUIDInfo a(android.content.Context r27, int r28, org.json.JSONObject r29) {
        /*
            Method dump skipped, instructions count: 981
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tpns.baseapi.core.b.a.a(android.content.Context, int, org.json.JSONObject):com.tencent.tpns.baseapi.base.device.GUIDInfo");
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0021 A[Catch: all -> 0x005f, LOOP:0: B:32:0x001b->B:34:0x0021, LOOP_END, TryCatch #0 {all -> 0x005f, blocks: (B:26:0x0002, B:29:0x0009, B:31:0x0014, B:32:0x001b, B:34:0x0021, B:35:0x002b, B:37:0x0031, B:38:0x003b, B:30:0x000f), top: B:42:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0031 A[Catch: all -> 0x005f, LOOP:1: B:35:0x002b->B:37:0x0031, LOOP_END, TryCatch #0 {all -> 0x005f, blocks: (B:26:0x0002, B:29:0x0009, B:31:0x0014, B:32:0x001b, B:34:0x0021, B:35:0x002b, B:37:0x0031, B:38:0x003b, B:30:0x000f), top: B:42:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String a(org.json.JSONArray r4, java.lang.String r5) {
        /*
            if (r5 == 0) goto Lf
            boolean r0 = r5.isEmpty()     // Catch: java.lang.Throwable -> L5f
            if (r0 == 0) goto L9
            goto Lf
        L9:
            org.json.JSONArray r0 = new org.json.JSONArray     // Catch: java.lang.Throwable -> L5f
            r0.<init>(r5)     // Catch: java.lang.Throwable -> L5f
            goto L14
        Lf:
            org.json.JSONArray r0 = new org.json.JSONArray     // Catch: java.lang.Throwable -> L5f
            r0.<init>()     // Catch: java.lang.Throwable -> L5f
        L14:
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L5f
            r5.<init>()     // Catch: java.lang.Throwable -> L5f
            r1 = 0
            r2 = 0
        L1b:
            int r3 = r0.length()     // Catch: java.lang.Throwable -> L5f
            if (r2 >= r3) goto L2b
            java.lang.String r3 = r0.getString(r2)     // Catch: java.lang.Throwable -> L5f
            r5.add(r3)     // Catch: java.lang.Throwable -> L5f
            int r2 = r2 + 1
            goto L1b
        L2b:
            int r0 = r4.length()     // Catch: java.lang.Throwable -> L5f
            if (r1 >= r0) goto L3b
            java.lang.String r0 = r4.getString(r1)     // Catch: java.lang.Throwable -> L5f
            r5.remove(r0)     // Catch: java.lang.Throwable -> L5f
            int r1 = r1 + 1
            goto L2b
        L3b:
            org.json.JSONArray r4 = new org.json.JSONArray     // Catch: java.lang.Throwable -> L5f
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L5f
            java.lang.String r5 = "GuidInfoManagerImpl"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5f
            r0.<init>()     // Catch: java.lang.Throwable -> L5f
            java.lang.String r1 = "Update tokenList: "
            r0.append(r1)     // Catch: java.lang.Throwable -> L5f
            java.lang.String r1 = r4.toString()     // Catch: java.lang.Throwable -> L5f
            r0.append(r1)     // Catch: java.lang.Throwable -> L5f
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L5f
            com.tencent.tpns.baseapi.base.util.Logger.i(r5, r0)     // Catch: java.lang.Throwable -> L5f
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L5f
            return r4
        L5f:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tpns.baseapi.core.b.a.a(org.json.JSONArray, java.lang.String):java.lang.String");
    }

    public static void a() {
        b = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0075 A[Catch: all -> 0x007e, UnknownHostException -> 0x0084, TryCatch #2 {UnknownHostException -> 0x0084, all -> 0x007e, blocks: (B:39:0x001d, B:42:0x0030, B:46:0x0053, B:48:0x0075, B:49:0x0078, B:45:0x004f), top: B:64:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(android.content.Context r9, java.lang.String r10) {
        /*
            java.lang.String r0 = ""
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "getGuidServerIPAddress | XGConfig guidServerHostAddr : "
            r1.append(r2)
            r1.append(r10)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "GuidInfoManagerImpl"
            com.tencent.tpns.baseapi.base.util.Logger.d(r2, r1)
            if (r9 != 0) goto L1b
            return r10
        L1b:
            r1 = 0
            r3 = 0
            java.net.URL r4 = new java.net.URL     // Catch: java.lang.Throwable -> L7e java.net.UnknownHostException -> L84
            r4.<init>(r10)     // Catch: java.lang.Throwable -> L7e java.net.UnknownHostException -> L84
            java.lang.String r4 = r4.getHost()     // Catch: java.lang.Throwable -> L7e java.net.UnknownHostException -> L84
            java.net.InetAddress r4 = java.net.InetAddress.getByName(r4)     // Catch: java.lang.Throwable -> L7e java.net.UnknownHostException -> L84
            boolean r5 = r4 instanceof java.net.Inet6Address     // Catch: java.lang.Throwable -> L7e java.net.UnknownHostException -> L84
            if (r5 == 0) goto L4d
            if (r4 == 0) goto L4b
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7e java.net.UnknownHostException -> L84
            r5.<init>()     // Catch: java.lang.Throwable -> L7e java.net.UnknownHostException -> L84
            java.lang.String r6 = "["
            r5.append(r6)     // Catch: java.lang.Throwable -> L7e java.net.UnknownHostException -> L84
            java.lang.String r4 = r4.getHostAddress()     // Catch: java.lang.Throwable -> L7e java.net.UnknownHostException -> L84
            r5.append(r4)     // Catch: java.lang.Throwable -> L7e java.net.UnknownHostException -> L84
            java.lang.String r4 = "]"
            r5.append(r4)     // Catch: java.lang.Throwable -> L7e java.net.UnknownHostException -> L84
            java.lang.String r4 = r5.toString()     // Catch: java.lang.Throwable -> L7e java.net.UnknownHostException -> L84
            goto L53
        L4b:
            r4 = r0
            goto L53
        L4d:
            if (r4 == 0) goto L4b
            java.lang.String r4 = r4.getHostAddress()     // Catch: java.lang.Throwable -> L7e java.net.UnknownHostException -> L84
        L53:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7e java.net.UnknownHostException -> L84
            r5.<init>()     // Catch: java.lang.Throwable -> L7e java.net.UnknownHostException -> L84
            java.lang.String r6 = "getGuidServerIPAddress | update lastResolvedGuidServerIP , guidServerIPAddr : "
            r5.append(r6)     // Catch: java.lang.Throwable -> L7e java.net.UnknownHostException -> L84
            r5.append(r0)     // Catch: java.lang.Throwable -> L7e java.net.UnknownHostException -> L84
            java.lang.String r6 = "; guidServerIp : "
            r5.append(r6)     // Catch: java.lang.Throwable -> L7e java.net.UnknownHostException -> L84
            r5.append(r4)     // Catch: java.lang.Throwable -> L7e java.net.UnknownHostException -> L84
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L7e java.net.UnknownHostException -> L84
            com.tencent.tpns.baseapi.base.util.Logger.d(r2, r5)     // Catch: java.lang.Throwable -> L7e java.net.UnknownHostException -> L84
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> L7e java.net.UnknownHostException -> L84
            if (r5 != 0) goto L78
            com.tencent.tpns.baseapi.base.device.GuidInfoManager.setLastResolvedGuidServerIP(r9, r4)     // Catch: java.lang.Throwable -> L7e java.net.UnknownHostException -> L84
        L78:
            java.lang.String r0 = a(r10, r4)     // Catch: java.lang.Throwable -> L7e java.net.UnknownHostException -> L84
            r4 = 0
            goto L89
        L7e:
            r1 = move-exception
            r3 = -505(0xfffffffffffffe07, float:NaN)
            r4 = -505(0xfffffffffffffe07, float:NaN)
            goto L89
        L84:
            r1 = move-exception
            r3 = -506(0xfffffffffffffe06, float:NaN)
            r4 = -506(0xfffffffffffffe06, float:NaN)
        L89:
            if (r1 == 0) goto Ld7
            java.lang.String r0 = d(r9, r10)
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r3 = "getGuidServerAddress | exception "
            r10.append(r3)
            java.lang.String r3 = r1.toString()
            r10.append(r3)
            java.lang.String r10 = r10.toString()
            com.tencent.tpns.baseapi.base.logger.TBaseLogger.ee(r2, r10, r1)
            boolean r10 = com.tencent.tpns.baseapi.core.b.a.f6886c
            if (r10 != 0) goto Ld7
            boolean r10 = com.tencent.tpns.baseapi.base.util.NetworkUtil.isNetworkConnected(r9)
            if (r10 == 0) goto Ld2
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r3 = "GUID DNS Throw Error: "
            r10.append(r3)
            java.lang.String r1 = r1.getMessage()
            r10.append(r1)
            java.lang.String r5 = r10.toString()
            r6 = 0
            java.lang.String r8 = ""
            r3 = r9
            com.tencent.tpns.baseapi.base.util.StatHelper.reportErrCode(r3, r4, r5, r6, r8)
            r9 = 1
            com.tencent.tpns.baseapi.core.b.a.f6886c = r9
            goto Ld7
        Ld2:
            java.lang.String r9 = "getGuidServerAddress Throw Error: network unavailable"
            com.tencent.tpns.baseapi.base.util.Logger.w(r2, r9)
        Ld7:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "getGuidServerIPAddress | result guidServerIPAddress : "
            r9.append(r10)
            r9.append(r0)
            java.lang.String r9 = r9.toString()
            com.tencent.tpns.baseapi.base.util.Logger.d(r2, r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tpns.baseapi.core.b.a.a(android.content.Context, java.lang.String):java.lang.String");
    }

    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return str;
        }
        try {
            Matcher matcher = Pattern.compile("(?<=//|)((\\w|-)+\\.)+(\\w|-)+(:\\d*)?").matcher(str);
            String group = matcher.find() ? matcher.group() : "";
            str = str.replace(group, str2);
            Logger.d("GuidInfoManagerImpl", "replaceHostWithIp | host : " + group + "; ipAddr : " + str);
            return str;
        } catch (Throwable th) {
            TBaseLogger.ee("GuidInfoManagerImpl", "replaceHostWithIp exception ", th);
            return str;
        }
    }

    public static void a(Context context, long j2) {
        Logger.i("GuidInfoManagerImpl", "Last time: " + f6891h + ", this time: " + j2);
        if (f6891h != j2) {
            Logger.i("GuidInfoManagerImpl", "Save mqttServerLastRefreshTime: " + j2);
            f6891h = j2;
            PushPreferences.putLong(context.getApplicationContext(), "XG_GUID_MQTT_SERVER_LAST_REFRESH_TIME", j2);
        }
    }

    public static void a(Context context, String str, String str2) {
        long currentTimeMillis = System.currentTimeMillis();
        PushPreferences.putString(context, "XG_GUID_TOKEN", str2);
        PushPreferences.putString(context, "XG_GUID_MQTT_SERVER", str);
        PushPreferences.putString(context, "XG_GUID_MQTT_USERNAME", "c34c9f3c514aa3560c38f74407f1a5bb");
        PushPreferences.putString(context, "XG_GUID_MQTT_PASSWORD", "9d8afb2ae393e47e7f3bbd254ed8c72e");
        PushPreferences.putLong(context, "XG_GUID_EXPIRED_SECONDS", 172800L);
        PushPreferences.putLong(context, "XG_GUID_LAST_REFRESH_TIME", currentTimeMillis);
    }

    private static String a(String str) {
        return Util.getKey(str);
    }
}
