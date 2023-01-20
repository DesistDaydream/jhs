package com.umeng.umzid;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.am;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ZIDManager {

    /* renamed from: c  reason: collision with root package name */
    public static ZIDManager f7634c;
    public boolean a = false;
    public boolean b = false;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public final /* synthetic */ Context a;
        public final /* synthetic */ IZIDCompletionCallback b;

        public a(Context context, IZIDCompletionCallback iZIDCompletionCallback) {
            this.a = context;
            this.b = iZIDCompletionCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            String a = ZIDManager.a(ZIDManager.this, this.a);
            if (TextUtils.isEmpty(a)) {
                IZIDCompletionCallback iZIDCompletionCallback = this.b;
                if (iZIDCompletionCallback != null) {
                    iZIDCompletionCallback.onFailure("1002", "获取zid失败");
                    return;
                }
                return;
            }
            IZIDCompletionCallback iZIDCompletionCallback2 = this.b;
            if (iZIDCompletionCallback2 != null) {
                iZIDCompletionCallback2.onSuccess(a);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public final /* synthetic */ Context a;

        public b(Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            ZIDManager.this.a(this.a);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public final /* synthetic */ Context a;

        public c(Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            ZIDManager.a(ZIDManager.this, this.a);
        }
    }

    public static /* synthetic */ String a(ZIDManager zIDManager, Context context) {
        String str = null;
        if (!zIDManager.a) {
            zIDManager.a = true;
            JSONObject jSONObject = new JSONObject();
            try {
                String id = Spy.getID();
                jSONObject.put(am.aD, id);
                String b2 = d.b(context);
                jSONObject.put(am.A, b2);
                String c2 = d.c(context);
                jSONObject.put("o", c2);
                zIDManager.a(context, jSONObject);
                String a2 = com.umeng.umzid.a.a("https://utoken.umeng.com/api/postZdata/v4", jSONObject.toString());
                if (!TextUtils.isEmpty(a2)) {
                    JSONObject jSONObject2 = new JSONObject(a2);
                    if (Boolean.valueOf(jSONObject2.optBoolean("suc")).booleanValue()) {
                        d.f(context, id);
                        d.a(context, b2);
                        d.b(context, c2);
                        str = jSONObject2.optString("aaid");
                        if (!TextUtils.isEmpty(str)) {
                            d.e(context, str);
                        }
                        String string = jSONObject2.getString("uabc");
                        if (!TextUtils.isEmpty(string)) {
                            d.d(context, string);
                        }
                        String string2 = jSONObject2.getString("resetToken");
                        if (!TextUtils.isEmpty(string2)) {
                            d.c(context, string2);
                        }
                    }
                }
            } catch (Throwable unused) {
            }
            zIDManager.a = false;
        }
        return str;
    }

    public static synchronized ZIDManager getInstance() {
        ZIDManager zIDManager;
        synchronized (ZIDManager.class) {
            if (f7634c == null) {
                f7634c = new ZIDManager();
            }
            zIDManager = f7634c;
        }
        return zIDManager;
    }

    public static String getSDKVersion() {
        return "1.6.0";
    }

    public synchronized String getZID(Context context) {
        if (context == null) {
            return "";
        }
        Context applicationContext = context.getApplicationContext();
        String a2 = d.a(applicationContext);
        if (TextUtils.isEmpty(a2)) {
            com.umeng.umzid.c.a(new c(applicationContext));
            return "";
        }
        return a2;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x006d A[Catch: all -> 0x009c, TryCatch #1 {, blocks: (B:5:0x0005, B:8:0x000e, B:11:0x0016, B:14:0x001f, B:17:0x0027, B:19:0x002d, B:21:0x0033, B:23:0x0039, B:24:0x0042, B:26:0x0048, B:29:0x004f, B:31:0x0059, B:33:0x0065, B:35:0x006d, B:36:0x0075, B:38:0x007b, B:43:0x008d, B:32:0x005d), top: B:51:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007b A[Catch: all -> 0x009c, TRY_LEAVE, TryCatch #1 {, blocks: (B:5:0x0005, B:8:0x000e, B:11:0x0016, B:14:0x001f, B:17:0x0027, B:19:0x002d, B:21:0x0033, B:23:0x0039, B:24:0x0042, B:26:0x0048, B:29:0x004f, B:31:0x0059, B:33:0x0065, B:35:0x006d, B:36:0x0075, B:38:0x007b, B:43:0x008d, B:32:0x005d), top: B:51:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void init(android.content.Context r4, java.lang.String r5, com.umeng.umzid.IZIDCompletionCallback r6) {
        /*
            r3 = this;
            monitor-enter(r3)
            if (r4 != 0) goto Le
            if (r6 == 0) goto Lc
            java.lang.String r4 = "1001"
            java.lang.String r5 = "传入参数Context为null"
            r6.onFailure(r4, r5)     // Catch: java.lang.Throwable -> L9c
        Lc:
            monitor-exit(r3)
            return
        Le:
            boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L9c
            if (r0 == 0) goto L1f
            if (r6 == 0) goto L1d
            java.lang.String r4 = "1003"
            java.lang.String r5 = "传入参数appkey为空"
            r6.onFailure(r4, r5)     // Catch: java.lang.Throwable -> L9c
        L1d:
            monitor-exit(r3)
            return
        L1f:
            android.content.Context r0 = r4.getApplicationContext()     // Catch: java.lang.Throwable -> L9c
            if (r0 == 0) goto L42
            if (r5 == 0) goto L42
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L9c
            if (r1 != 0) goto L42
            android.content.SharedPreferences r1 = com.umeng.umzid.a.a(r0)     // Catch: java.lang.Throwable -> L9c
            if (r1 == 0) goto L42
            android.content.SharedPreferences$Editor r1 = r1.edit()     // Catch: java.lang.Throwable -> L9c
            if (r1 == 0) goto L42
            java.lang.String r2 = "appkey"
            android.content.SharedPreferences$Editor r5 = r1.putString(r2, r5)     // Catch: java.lang.Throwable -> L9c
            r5.commit()     // Catch: java.lang.Throwable -> L9c
        L42:
            java.lang.String r5 = com.umeng.umzid.d.a(r0)     // Catch: java.lang.Throwable -> L9c
            if (r5 == 0) goto L5d
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L9c
            if (r1 == 0) goto L4f
            goto L5d
        L4f:
            com.umeng.umzid.ZIDManager$b r1 = new com.umeng.umzid.ZIDManager$b     // Catch: java.lang.Throwable -> L9c
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L9c
            com.umeng.umzid.c.a(r1)     // Catch: java.lang.Throwable -> L9c
            if (r6 == 0) goto L65
            r6.onSuccess(r5)     // Catch: java.lang.Throwable -> L9c
            goto L65
        L5d:
            com.umeng.umzid.ZIDManager$a r5 = new com.umeng.umzid.ZIDManager$a     // Catch: java.lang.Throwable -> L9c
            r5.<init>(r0, r6)     // Catch: java.lang.Throwable -> L9c
            com.umeng.umzid.c.a(r5)     // Catch: java.lang.Throwable -> L9c
        L65:
            java.lang.String r5 = ""
            android.content.SharedPreferences r6 = com.umeng.umzid.a.a(r4)     // Catch: java.lang.Throwable -> L9c
            if (r6 == 0) goto L75
            java.lang.String r5 = "uuid"
            java.lang.String r0 = ""
            java.lang.String r5 = r6.getString(r5, r0)     // Catch: java.lang.Throwable -> L9c
        L75:
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L9c
            if (r5 == 0) goto L9a
            java.lang.String r5 = ""
            android.content.SharedPreferences r4 = com.umeng.umzid.a.a(r4)     // Catch: java.lang.Throwable -> L9c
            java.util.UUID r6 = java.util.UUID.randomUUID()     // Catch: java.lang.Throwable -> L9c
            java.lang.String r5 = r6.toString()     // Catch: java.lang.Throwable -> L8a
            goto L8b
        L8a:
        L8b:
            if (r4 == 0) goto L9a
            android.content.SharedPreferences$Editor r4 = r4.edit()     // Catch: java.lang.Throwable -> L9c
            java.lang.String r6 = "uuid"
            android.content.SharedPreferences$Editor r4 = r4.putString(r6, r5)     // Catch: java.lang.Throwable -> L9c
            r4.commit()     // Catch: java.lang.Throwable -> L9c
        L9a:
            monitor-exit(r3)
            return
        L9c:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.umzid.ZIDManager.init(android.content.Context, java.lang.String, com.umeng.umzid.IZIDCompletionCallback):void");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(39:1|(2:2|3)|(2:8|(36:12|13|(5:102|103|(2:110|111)|105|(33:107|16|17|18|(2:23|(28:27|28|29|30|31|32|(3:83|84|(5:86|87|(2:90|88)|91|92))|34|(1:36)(1:82)|37|(1:39)(1:81)|40|41|42|43|44|45|46|47|48|49|(1:53)|54|55|56|(2:61|(2:65|66))|68|69))|100|28|29|30|31|32|(0)|34|(0)(0)|37|(0)(0)|40|41|42|43|44|45|46|47|48|49|(2:51|53)|54|55|56|(4:58|59|61|(3:63|65|66))|68|69))|15|16|17|18|(4:20|21|23|(29:25|27|28|29|30|31|32|(0)|34|(0)(0)|37|(0)(0)|40|41|42|43|44|45|46|47|48|49|(0)|54|55|56|(0)|68|69))|100|28|29|30|31|32|(0)|34|(0)(0)|37|(0)(0)|40|41|42|43|44|45|46|47|48|49|(0)|54|55|56|(0)|68|69))|115|13|(0)|15|16|17|18|(0)|100|28|29|30|31|32|(0)|34|(0)(0)|37|(0)(0)|40|41|42|43|44|45|46|47|48|49|(0)|54|55|56|(0)|68|69) */
    /* JADX WARN: Can't wrap try/catch for region: R(40:1|2|3|(2:8|(36:12|13|(5:102|103|(2:110|111)|105|(33:107|16|17|18|(2:23|(28:27|28|29|30|31|32|(3:83|84|(5:86|87|(2:90|88)|91|92))|34|(1:36)(1:82)|37|(1:39)(1:81)|40|41|42|43|44|45|46|47|48|49|(1:53)|54|55|56|(2:61|(2:65|66))|68|69))|100|28|29|30|31|32|(0)|34|(0)(0)|37|(0)(0)|40|41|42|43|44|45|46|47|48|49|(2:51|53)|54|55|56|(4:58|59|61|(3:63|65|66))|68|69))|15|16|17|18|(4:20|21|23|(29:25|27|28|29|30|31|32|(0)|34|(0)(0)|37|(0)(0)|40|41|42|43|44|45|46|47|48|49|(0)|54|55|56|(0)|68|69))|100|28|29|30|31|32|(0)|34|(0)(0)|37|(0)(0)|40|41|42|43|44|45|46|47|48|49|(0)|54|55|56|(0)|68|69))|115|13|(0)|15|16|17|18|(0)|100|28|29|30|31|32|(0)|34|(0)(0)|37|(0)(0)|40|41|42|43|44|45|46|47|48|49|(0)|54|55|56|(0)|68|69) */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x010c, code lost:
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0156, code lost:
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0157, code lost:
        r5.printStackTrace();
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0179, code lost:
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x017a, code lost:
        r5.printStackTrace();
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0192, code lost:
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0193, code lost:
        r5.printStackTrace();
        r5 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:107:0x00d5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0048 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01b5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final org.json.JSONObject a(android.content.Context r10, org.json.JSONObject r11) {
        /*
            Method dump skipped, instructions count: 477
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.umzid.ZIDManager.a(android.content.Context, org.json.JSONObject):org.json.JSONObject");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0034 A[ADDED_TO_REGION, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0061 A[Catch: all -> 0x0138, TryCatch #1 {all -> 0x0138, blocks: (B:24:0x0043, B:26:0x0049, B:28:0x0051, B:30:0x0061, B:32:0x0067, B:34:0x0073, B:36:0x0079, B:38:0x0089, B:40:0x008f, B:42:0x009b, B:44:0x00a1, B:46:0x00bb, B:48:0x00c1, B:50:0x00c7, B:53:0x00ce, B:55:0x00d4, B:56:0x00d8, B:58:0x00de, B:60:0x00e5, B:62:0x00f3, B:64:0x0108, B:66:0x011b, B:67:0x011e, B:69:0x0128, B:70:0x012b, B:72:0x0135), top: B:78:0x0043 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0089 A[Catch: all -> 0x0138, TryCatch #1 {all -> 0x0138, blocks: (B:24:0x0043, B:26:0x0049, B:28:0x0051, B:30:0x0061, B:32:0x0067, B:34:0x0073, B:36:0x0079, B:38:0x0089, B:40:0x008f, B:42:0x009b, B:44:0x00a1, B:46:0x00bb, B:48:0x00c1, B:50:0x00c7, B:53:0x00ce, B:55:0x00d4, B:56:0x00d8, B:58:0x00de, B:60:0x00e5, B:62:0x00f3, B:64:0x0108, B:66:0x011b, B:67:0x011e, B:69:0x0128, B:70:0x012b, B:72:0x0135), top: B:78:0x0043 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00bb A[Catch: all -> 0x0138, TryCatch #1 {all -> 0x0138, blocks: (B:24:0x0043, B:26:0x0049, B:28:0x0051, B:30:0x0061, B:32:0x0067, B:34:0x0073, B:36:0x0079, B:38:0x0089, B:40:0x008f, B:42:0x009b, B:44:0x00a1, B:46:0x00bb, B:48:0x00c1, B:50:0x00c7, B:53:0x00ce, B:55:0x00d4, B:56:0x00d8, B:58:0x00de, B:60:0x00e5, B:62:0x00f3, B:64:0x0108, B:66:0x011b, B:67:0x011e, B:69:0x0128, B:70:0x012b, B:72:0x0135), top: B:78:0x0043 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00ce A[Catch: all -> 0x0138, TRY_ENTER, TryCatch #1 {all -> 0x0138, blocks: (B:24:0x0043, B:26:0x0049, B:28:0x0051, B:30:0x0061, B:32:0x0067, B:34:0x0073, B:36:0x0079, B:38:0x0089, B:40:0x008f, B:42:0x009b, B:44:0x00a1, B:46:0x00bb, B:48:0x00c1, B:50:0x00c7, B:53:0x00ce, B:55:0x00d4, B:56:0x00d8, B:58:0x00de, B:60:0x00e5, B:62:0x00f3, B:64:0x0108, B:66:0x011b, B:67:0x011e, B:69:0x0128, B:70:0x012b, B:72:0x0135), top: B:78:0x0043 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00de A[Catch: all -> 0x0138, TRY_LEAVE, TryCatch #1 {all -> 0x0138, blocks: (B:24:0x0043, B:26:0x0049, B:28:0x0051, B:30:0x0061, B:32:0x0067, B:34:0x0073, B:36:0x0079, B:38:0x0089, B:40:0x008f, B:42:0x009b, B:44:0x00a1, B:46:0x00bb, B:48:0x00c1, B:50:0x00c7, B:53:0x00ce, B:55:0x00d4, B:56:0x00d8, B:58:0x00de, B:60:0x00e5, B:62:0x00f3, B:64:0x0108, B:66:0x011b, B:67:0x011e, B:69:0x0128, B:70:0x012b, B:72:0x0135), top: B:78:0x0043 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00f3 A[Catch: all -> 0x0138, TryCatch #1 {all -> 0x0138, blocks: (B:24:0x0043, B:26:0x0049, B:28:0x0051, B:30:0x0061, B:32:0x0067, B:34:0x0073, B:36:0x0079, B:38:0x0089, B:40:0x008f, B:42:0x009b, B:44:0x00a1, B:46:0x00bb, B:48:0x00c1, B:50:0x00c7, B:53:0x00ce, B:55:0x00d4, B:56:0x00d8, B:58:0x00de, B:60:0x00e5, B:62:0x00f3, B:64:0x0108, B:66:0x011b, B:67:0x011e, B:69:0x0128, B:70:0x012b, B:72:0x0135), top: B:78:0x0043 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0043 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String a(android.content.Context r13) {
        /*
            Method dump skipped, instructions count: 315
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.umzid.ZIDManager.a(android.content.Context):java.lang.String");
    }
}
