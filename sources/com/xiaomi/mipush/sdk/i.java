package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.xiaomi.push.hn;
import com.xiaomi.push.jj;
import com.xiaomi.push.jl;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class i {
    private static HashMap<String, String> a = new HashMap<>();

    public static int a() {
        Integer num = (Integer) com.xiaomi.push.am.a("com.xiaomi.assemble.control.AssembleConstants", "ASSEMBLE_VERSION_CODE");
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    private static int a(Context context, e eVar, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        String a2 = a(eVar);
        String string = sharedPreferences.getString(a2, "");
        String m82c = b.m74a(context).m82c();
        String string2 = sharedPreferences.getString("last_check_token", "");
        if (TextUtils.isEmpty(a2)) {
            com.xiaomi.a.a.a.c.a("ASSEMBLE_PUSH : can not find the key of token used in sp file");
            return 0;
        } else if (TextUtils.isEmpty(string)) {
            return 1;
        } else {
            if (string.equals(str)) {
                if (TextUtils.equals(m82c, string2)) {
                    if (m99a(eVar)) {
                        if (a() != sharedPreferences.getInt(b(eVar), 0)) {
                            return 4;
                        }
                    }
                    return 0;
                }
                return 3;
            }
            return 2;
        }
    }

    public static MiPushMessage a(String str) {
        MiPushMessage miPushMessage = new MiPushMessage();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("messageId")) {
                    miPushMessage.setMessageId(jSONObject.getString("messageId"));
                }
                if (jSONObject.has(com.heytap.mcssdk.constant.b.f3341i)) {
                    miPushMessage.setDescription(jSONObject.getString(com.heytap.mcssdk.constant.b.f3341i));
                }
                if (jSONObject.has("title")) {
                    miPushMessage.setTitle(jSONObject.getString("title"));
                }
                if (jSONObject.has("content")) {
                    miPushMessage.setContent(jSONObject.getString("content"));
                }
                if (jSONObject.has("passThrough")) {
                    miPushMessage.setPassThrough(jSONObject.getInt("passThrough"));
                }
                if (jSONObject.has("notifyType")) {
                    miPushMessage.setNotifyType(jSONObject.getInt("notifyType"));
                }
                if (jSONObject.has("messageType")) {
                    miPushMessage.setMessageType(jSONObject.getInt("messageType"));
                }
                if (jSONObject.has(PushConstants.SUB_ALIAS_STATUS_NAME)) {
                    miPushMessage.setAlias(jSONObject.getString(PushConstants.SUB_ALIAS_STATUS_NAME));
                }
                if (jSONObject.has("topic")) {
                    miPushMessage.setTopic(jSONObject.getString("topic"));
                }
                if (jSONObject.has("user_account")) {
                    miPushMessage.setUserAccount(jSONObject.getString("user_account"));
                }
                if (jSONObject.has(RemoteMessageConst.Notification.NOTIFY_ID)) {
                    miPushMessage.setNotifyId(jSONObject.getInt(RemoteMessageConst.Notification.NOTIFY_ID));
                }
                if (jSONObject.has("category")) {
                    miPushMessage.setCategory(jSONObject.getString("category"));
                }
                if (jSONObject.has("isNotified")) {
                    miPushMessage.setNotified(jSONObject.getBoolean("isNotified"));
                }
                if (jSONObject.has("extra")) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("extra");
                    Iterator<String> keys = jSONObject2.keys();
                    HashMap hashMap = new HashMap();
                    while (keys != null && keys.hasNext()) {
                        String next = keys.next();
                        hashMap.put(next, jSONObject2.getString(next));
                    }
                    if (hashMap.size() > 0) {
                        miPushMessage.setExtra(hashMap);
                    }
                }
            } catch (Exception e2) {
                com.xiaomi.a.a.a.c.d(e2.toString());
            }
        }
        return miPushMessage;
    }

    public static PushMessageReceiver a(Context context) {
        ResolveInfo resolveInfo;
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.setPackage(context.getPackageName());
        try {
            List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 32);
            if (queryBroadcastReceivers != null) {
                Iterator<ResolveInfo> it = queryBroadcastReceivers.iterator();
                while (it.hasNext()) {
                    resolveInfo = it.next();
                    ActivityInfo activityInfo = resolveInfo.activityInfo;
                    if (activityInfo != null && activityInfo.packageName.equals(context.getPackageName())) {
                        break;
                    }
                }
            }
            resolveInfo = null;
            if (resolveInfo != null) {
                return (PushMessageReceiver) jl.a(context, resolveInfo.activityInfo.name).newInstance();
            }
            return null;
        } catch (Exception e2) {
            com.xiaomi.a.a.a.c.d(e2.toString());
            return null;
        }
    }

    public static String a(Context context, e eVar) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        String a2 = a(eVar);
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        return sharedPreferences.getString(a2, "");
    }

    public static synchronized String a(Context context, String str) {
        String str2;
        synchronized (i.class) {
            str2 = a.get(str);
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
        }
        return str2;
    }

    public static String a(e eVar) {
        int i2 = k.a[eVar.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        return null;
                    }
                    return "ftos_push_token";
                }
                return "cos_push_token";
            }
            return "fcm_push_token_v2";
        }
        return "hms_push_token";
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0058, code lost:
        if (r12 != 0) goto L15;
     */
    /* renamed from: a  reason: collision with other method in class */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.HashMap<java.lang.String, java.lang.String> m93a(android.content.Context r11, com.xiaomi.mipush.sdk.e r12) {
        /*
            Method dump skipped, instructions count: 309
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.i.m93a(android.content.Context, com.xiaomi.mipush.sdk.e):java.util.HashMap");
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m94a(Context context) {
        boolean z = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        String a2 = a(e.ASSEMBLE_PUSH_HUAWEI);
        String a3 = a(e.ASSEMBLE_PUSH_FCM);
        if (!TextUtils.isEmpty(sharedPreferences.getString(a2, "")) && TextUtils.isEmpty(sharedPreferences.getString(a3, ""))) {
            z = true;
        }
        if (z) {
            ao.a(context).a(2, a2);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m95a(Context context, e eVar) {
        String a2 = a(eVar);
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        jj.a(context.getSharedPreferences("mipush_extra", 0).edit().putString(a2, ""));
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m96a(Context context, e eVar, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int a2 = a(context, eVar, str);
        if (a2 == 0) {
            com.xiaomi.a.a.a.c.a("ASSEMBLE_PUSH : do not need to send token");
            return;
        }
        com.xiaomi.a.a.a.c.a("ASSEMBLE_PUSH : send token upload, check:" + a2);
        a(eVar, str);
        au a3 = l.a(eVar);
        if (a3 == null) {
            return;
        }
        ao.a(context).a((String) null, a3, eVar);
    }

    public static void a(Intent intent) {
        Bundle extras;
        if (intent == null || (extras = intent.getExtras()) == null || !extras.containsKey("pushMsg")) {
            return;
        }
        intent.putExtra(PushMessageHelper.KEY_MESSAGE, a(extras.getString("pushMsg")));
    }

    private static synchronized void a(e eVar, String str) {
        synchronized (i.class) {
            String a2 = a(eVar);
            if (TextUtils.isEmpty(a2)) {
                com.xiaomi.a.a.a.c.a("ASSEMBLE_PUSH : can not find the key of token used in sp file");
            } else if (TextUtils.isEmpty(str)) {
                com.xiaomi.a.a.a.c.a("ASSEMBLE_PUSH : token is null");
            } else {
                a.put(a2, str);
            }
        }
    }

    public static void a(String str, int i2) {
        MiTinyDataClient.upload("hms_push_error", str, 1L, "error code = " + i2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m97a(Context context) {
        if (context == null) {
            return false;
        }
        return com.xiaomi.push.al.c(context);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m98a(Context context, e eVar) {
        if (l.m101a(eVar) != null) {
            return com.xiaomi.push.service.ad.a(context).a(l.m101a(eVar).a(), true);
        }
        return false;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m99a(e eVar) {
        return eVar == e.ASSEMBLE_PUSH_FTOS || eVar == e.ASSEMBLE_PUSH_FCM;
    }

    public static boolean a(hn hnVar, e eVar) {
        if (hnVar == null || hnVar.m() == null || hnVar.m().s() == null) {
            return false;
        }
        return (eVar == e.ASSEMBLE_PUSH_FCM ? e.j.d.i.a.b : "").equalsIgnoreCase(hnVar.m().s().get("assemble_push_type"));
    }

    public static byte[] a(Context context, hn hnVar, e eVar) {
        if (a(hnVar, eVar)) {
            return com.xiaomi.push.aq.c(a(context, eVar));
        }
        return null;
    }

    public static String b(e eVar) {
        return a(eVar) + "_version";
    }

    public static void b(Context context) {
        f.a(context).register();
    }

    public static void b(Context context, e eVar, String str) {
        com.xiaomi.push.m.a(context).a(new j(str, context, eVar));
    }

    public static String c(e eVar) {
        int i2 = k.a[eVar.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        return null;
                    }
                    return "ftos_push_error";
                }
                return "cos_push_error";
            }
            return "fcm_push_error";
        }
        return "hms_push_error";
    }

    public static void c(Context context) {
        f.a(context).unregister();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void d(Context context, e eVar, String str) {
        synchronized (i.class) {
            String a2 = a(eVar);
            if (TextUtils.isEmpty(a2)) {
                com.xiaomi.a.a.a.c.a("ASSEMBLE_PUSH : can not find the key of token used in sp file");
                return;
            }
            SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.putString(a2, str).putString("last_check_token", b.m74a(context).m82c());
            if (m99a(eVar)) {
                edit.putInt(b(eVar), a());
            }
            jj.a(edit);
            com.xiaomi.a.a.a.c.a("ASSEMBLE_PUSH : update sp file success!  " + str);
        }
    }
}
