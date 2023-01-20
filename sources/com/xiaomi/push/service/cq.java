package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.qcloud.tuikit.tuichat.ui.view.input.TIMMentionEditText;
import com.xiaomi.push.fc;
import com.xiaomi.push.ii;
import com.xiaomi.push.jg;

/* loaded from: classes3.dex */
public class cq {
    private static cp a;
    private static a b;

    /* loaded from: classes3.dex */
    public interface a {
        void a();
    }

    public static synchronized cp a(Context context) {
        synchronized (cq.class) {
            cp cpVar = a;
            if (cpVar != null) {
                return cpVar;
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_account", 0);
            String string = sharedPreferences.getString("uuid", null);
            String string2 = sharedPreferences.getString("token", null);
            String string3 = sharedPreferences.getString("security", null);
            String string4 = sharedPreferences.getString("app_id", null);
            String string5 = sharedPreferences.getString("app_token", null);
            String string6 = sharedPreferences.getString("package_name", null);
            String string7 = sharedPreferences.getString("device_id", null);
            int i2 = sharedPreferences.getInt("env_type", 1);
            if (!TextUtils.isEmpty(string7) && ii.a(string7)) {
                string7 = ii.i(context);
                sharedPreferences.edit().putString("device_id", string7).commit();
            }
            if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2) || TextUtils.isEmpty(string3)) {
                return null;
            }
            String i3 = ii.i(context);
            if (!"com.xiaomi.xmsf".equals(context.getPackageName()) && !TextUtils.isEmpty(i3) && !TextUtils.isEmpty(string7) && !string7.equals(i3)) {
                com.xiaomi.a.a.a.c.a("read_phone_state permission changes.");
            }
            cp cpVar2 = new cp(string, string2, string3, string4, string5, string6, i2);
            a = cpVar2;
            return cpVar2;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(37:3|4|(2:8|(34:10|11|(1:13)|14|(1:16)(1:119)|17|(1:19)(1:118)|20|(1:22)(1:117)|23|24|25|26|(1:28)(1:113)|29|(6:31|(1:33)|34|(1:38)|39|(1:41))|42|(1:44)|45|(6:48|49|50|52|53|46)|57|58|(11:63|64|(1:66)|67|68|(2:72|(4:74|75|76|(7:78|(1:80)|81|82|83|84|85)(6:88|89|(1:93)|94|95|96)))|107|(2:91|93)|94|95|96)|112|64|(0)|67|68|(3:70|72|(0))|107|(0)|94|95|96))|120|11|(0)|14|(0)(0)|17|(0)(0)|20|(0)(0)|23|24|25|26|(0)(0)|29|(0)|42|(0)|45|(1:46)|57|58|(12:60|63|64|(0)|67|68|(0)|107|(0)|94|95|96)|112|64|(0)|67|68|(0)|107|(0)|94|95|96) */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0093, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0094, code lost:
        com.xiaomi.a.a.a.c.a(r0);
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0215, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0217, code lost:
        com.xiaomi.a.a.a.c.d("device registration request failed. " + r0);
        r0 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0319 A[Catch: all -> 0x032e, TryCatch #6 {, blocks: (B:4:0x0005, B:6:0x001a, B:8:0x0022, B:10:0x0038, B:12:0x0044, B:14:0x0055, B:15:0x005a, B:19:0x0066, B:23:0x0072, B:27:0x007e, B:28:0x0088, B:34:0x009c, B:36:0x00a5, B:38:0x00cd, B:40:0x00d9, B:41:0x00ec, B:43:0x00f6, B:45:0x00fc, B:46:0x0110, B:48:0x0116, B:49:0x011b, B:51:0x013e, B:52:0x0147, B:53:0x017e, B:55:0x0184, B:56:0x018b, B:59:0x019a, B:60:0x01cb, B:62:0x01eb, B:65:0x01f2, B:67:0x0209, B:70:0x0210, B:74:0x0217, B:76:0x022e, B:78:0x0234, B:99:0x02eb, B:100:0x02fc, B:106:0x0319, B:108:0x031f, B:109:0x0327, B:103:0x0303, B:31:0x0094), top: B:121:0x0005, inners: #1, #4, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x023e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0055 A[Catch: all -> 0x032e, TryCatch #6 {, blocks: (B:4:0x0005, B:6:0x001a, B:8:0x0022, B:10:0x0038, B:12:0x0044, B:14:0x0055, B:15:0x005a, B:19:0x0066, B:23:0x0072, B:27:0x007e, B:28:0x0088, B:34:0x009c, B:36:0x00a5, B:38:0x00cd, B:40:0x00d9, B:41:0x00ec, B:43:0x00f6, B:45:0x00fc, B:46:0x0110, B:48:0x0116, B:49:0x011b, B:51:0x013e, B:52:0x0147, B:53:0x017e, B:55:0x0184, B:56:0x018b, B:59:0x019a, B:60:0x01cb, B:62:0x01eb, B:65:0x01f2, B:67:0x0209, B:70:0x0210, B:74:0x0217, B:76:0x022e, B:78:0x0234, B:99:0x02eb, B:100:0x02fc, B:106:0x0319, B:108:0x031f, B:109:0x0327, B:103:0x0303, B:31:0x0094), top: B:121:0x0005, inners: #1, #4, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009c A[Catch: all -> 0x032e, TryCatch #6 {, blocks: (B:4:0x0005, B:6:0x001a, B:8:0x0022, B:10:0x0038, B:12:0x0044, B:14:0x0055, B:15:0x005a, B:19:0x0066, B:23:0x0072, B:27:0x007e, B:28:0x0088, B:34:0x009c, B:36:0x00a5, B:38:0x00cd, B:40:0x00d9, B:41:0x00ec, B:43:0x00f6, B:45:0x00fc, B:46:0x0110, B:48:0x0116, B:49:0x011b, B:51:0x013e, B:52:0x0147, B:53:0x017e, B:55:0x0184, B:56:0x018b, B:59:0x019a, B:60:0x01cb, B:62:0x01eb, B:65:0x01f2, B:67:0x0209, B:70:0x0210, B:74:0x0217, B:76:0x022e, B:78:0x0234, B:99:0x02eb, B:100:0x02fc, B:106:0x0319, B:108:0x031f, B:109:0x0327, B:103:0x0303, B:31:0x0094), top: B:121:0x0005, inners: #1, #4, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00cd A[Catch: all -> 0x032e, TryCatch #6 {, blocks: (B:4:0x0005, B:6:0x001a, B:8:0x0022, B:10:0x0038, B:12:0x0044, B:14:0x0055, B:15:0x005a, B:19:0x0066, B:23:0x0072, B:27:0x007e, B:28:0x0088, B:34:0x009c, B:36:0x00a5, B:38:0x00cd, B:40:0x00d9, B:41:0x00ec, B:43:0x00f6, B:45:0x00fc, B:46:0x0110, B:48:0x0116, B:49:0x011b, B:51:0x013e, B:52:0x0147, B:53:0x017e, B:55:0x0184, B:56:0x018b, B:59:0x019a, B:60:0x01cb, B:62:0x01eb, B:65:0x01f2, B:67:0x0209, B:70:0x0210, B:74:0x0217, B:76:0x022e, B:78:0x0234, B:99:0x02eb, B:100:0x02fc, B:106:0x0319, B:108:0x031f, B:109:0x0327, B:103:0x0303, B:31:0x0094), top: B:121:0x0005, inners: #1, #4, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x013e A[Catch: all -> 0x032e, TryCatch #6 {, blocks: (B:4:0x0005, B:6:0x001a, B:8:0x0022, B:10:0x0038, B:12:0x0044, B:14:0x0055, B:15:0x005a, B:19:0x0066, B:23:0x0072, B:27:0x007e, B:28:0x0088, B:34:0x009c, B:36:0x00a5, B:38:0x00cd, B:40:0x00d9, B:41:0x00ec, B:43:0x00f6, B:45:0x00fc, B:46:0x0110, B:48:0x0116, B:49:0x011b, B:51:0x013e, B:52:0x0147, B:53:0x017e, B:55:0x0184, B:56:0x018b, B:59:0x019a, B:60:0x01cb, B:62:0x01eb, B:65:0x01f2, B:67:0x0209, B:70:0x0210, B:74:0x0217, B:76:0x022e, B:78:0x0234, B:99:0x02eb, B:100:0x02fc, B:106:0x0319, B:108:0x031f, B:109:0x0327, B:103:0x0303, B:31:0x0094), top: B:121:0x0005, inners: #1, #4, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0184 A[Catch: all -> 0x032e, TRY_LEAVE, TryCatch #6 {, blocks: (B:4:0x0005, B:6:0x001a, B:8:0x0022, B:10:0x0038, B:12:0x0044, B:14:0x0055, B:15:0x005a, B:19:0x0066, B:23:0x0072, B:27:0x007e, B:28:0x0088, B:34:0x009c, B:36:0x00a5, B:38:0x00cd, B:40:0x00d9, B:41:0x00ec, B:43:0x00f6, B:45:0x00fc, B:46:0x0110, B:48:0x0116, B:49:0x011b, B:51:0x013e, B:52:0x0147, B:53:0x017e, B:55:0x0184, B:56:0x018b, B:59:0x019a, B:60:0x01cb, B:62:0x01eb, B:65:0x01f2, B:67:0x0209, B:70:0x0210, B:74:0x0217, B:76:0x022e, B:78:0x0234, B:99:0x02eb, B:100:0x02fc, B:106:0x0319, B:108:0x031f, B:109:0x0327, B:103:0x0303, B:31:0x0094), top: B:121:0x0005, inners: #1, #4, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x022e A[Catch: all -> 0x032e, TryCatch #6 {, blocks: (B:4:0x0005, B:6:0x001a, B:8:0x0022, B:10:0x0038, B:12:0x0044, B:14:0x0055, B:15:0x005a, B:19:0x0066, B:23:0x0072, B:27:0x007e, B:28:0x0088, B:34:0x009c, B:36:0x00a5, B:38:0x00cd, B:40:0x00d9, B:41:0x00ec, B:43:0x00f6, B:45:0x00fc, B:46:0x0110, B:48:0x0116, B:49:0x011b, B:51:0x013e, B:52:0x0147, B:53:0x017e, B:55:0x0184, B:56:0x018b, B:59:0x019a, B:60:0x01cb, B:62:0x01eb, B:65:0x01f2, B:67:0x0209, B:70:0x0210, B:74:0x0217, B:76:0x022e, B:78:0x0234, B:99:0x02eb, B:100:0x02fc, B:106:0x0319, B:108:0x031f, B:109:0x0327, B:103:0x0303, B:31:0x0094), top: B:121:0x0005, inners: #1, #4, #5 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized com.xiaomi.push.service.cp a(android.content.Context r17, java.lang.String r18, java.lang.String r19, java.lang.String r20) {
        /*
            Method dump skipped, instructions count: 817
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.cq.a(android.content.Context, java.lang.String, java.lang.String, java.lang.String):com.xiaomi.push.service.cp");
    }

    private static String a(Context context, boolean z) {
        StringBuilder sb;
        String str;
        String a2 = b.a(context).a();
        String str2 = z ? "/pass/v2/register/encrypt" : "/pass/v2/register";
        if (com.xiaomi.push.f.b()) {
            sb = new StringBuilder();
            sb.append("http://");
            sb.append(fc.b);
            str = ":9085";
        } else if (jg.China.name().equals(a2)) {
            sb = new StringBuilder();
            str = "https://cn.register.xmpush.xiaomi.com";
        } else if (jg.Global.name().equals(a2)) {
            sb = new StringBuilder();
            str = "https://register.xmpush.global.xiaomi.com";
        } else if (jg.Europe.name().equals(a2)) {
            sb = new StringBuilder();
            str = "https://fr.register.xmpush.global.xiaomi.com";
        } else if (jg.Russia.name().equals(a2)) {
            sb = new StringBuilder();
            str = "https://ru.register.xmpush.global.xiaomi.com";
        } else if (jg.India.name().equals(a2)) {
            sb = new StringBuilder();
            str = "https://idmb.register.xmpush.global.xiaomi.com";
        } else {
            sb = new StringBuilder();
            sb.append("https://");
            str = com.xiaomi.push.f.a() ? "sandbox.xmpush.xiaomi.com" : "register.xmpush.xiaomi.com";
        }
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    public static void a() {
        a aVar = b;
        if (aVar != null) {
            aVar.a();
        }
    }

    private static void a(Context context, int i2) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_account", 0).edit();
        edit.putInt("enc_req_fail_count", i2);
        edit.commit();
    }

    public static void a(Context context, cp cpVar) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_account", 0).edit();
        edit.putString("uuid", cpVar.a);
        edit.putString("security", cpVar.f9167c);
        edit.putString("token", cpVar.b);
        edit.putString("app_id", cpVar.f9168d);
        edit.putString("package_name", cpVar.f9170f);
        edit.putString("app_token", cpVar.f9169e);
        edit.putString("device_id", ii.i(context));
        edit.putInt("env_type", cpVar.f9171g);
        edit.commit();
        a();
    }

    public static void a(a aVar) {
        b = aVar;
    }

    public static void b(Context context) {
        context.getSharedPreferences("mipush_account", 0).edit().clear().commit();
        a = null;
        a();
    }

    public static String c(Context context) {
        cp a2 = a(context);
        if (a2 != null && !TextUtils.isEmpty(a2.a)) {
            String[] split = a2.a.split(TIMMentionEditText.TIM_MENTION_TAG);
            if (split.length > 0) {
                return split[0];
            }
        }
        return null;
    }

    private static boolean d(Context context) {
        return context.getPackageName().equals("com.xiaomi.xmsf");
    }

    private static int e(Context context) {
        return context.getSharedPreferences("mipush_account", 0).getInt("enc_req_fail_count", 0);
    }
}
