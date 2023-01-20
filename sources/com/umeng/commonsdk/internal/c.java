package com.umeng.commonsdk.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.pro.aa;
import com.umeng.analytics.pro.am;
import com.umeng.analytics.pro.ao;
import com.umeng.analytics.pro.ap;
import com.umeng.analytics.pro.aq;
import com.umeng.analytics.pro.o;
import com.umeng.commonsdk.UMConfigureImpl;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.listener.OnGetOaidListener;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.idtracking.h;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.commonsdk.utils.onMessageSendListener;
import java.io.File;
import java.lang.reflect.Method;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class c implements UMLogDataProtocol {
    public static final String a = "um_policy_grant";
    public static final String b = "preInitInvokedFlag";

    /* renamed from: c */
    public static final String f7402c = "policyGrantInvokedFlag";

    /* renamed from: d */
    public static final String f7403d = "policyGrantResult";

    /* renamed from: f */
    private static int f7404f = 1;

    /* renamed from: g */
    private static final String f7405g = "info";

    /* renamed from: h */
    private static final String f7406h = "stat";

    /* renamed from: i */
    private static Class<?> f7407i = null;

    /* renamed from: j */
    private static Method f7408j = null;

    /* renamed from: k */
    private static Method f7409k = null;

    /* renamed from: l */
    private static Method f7410l = null;

    /* renamed from: m */
    private static boolean f7411m = false;

    /* renamed from: e */
    private Context f7412e;

    static {
        c();
    }

    public c(Context context) {
        if (context != null) {
            this.f7412e = context.getApplicationContext();
        }
    }

    public static String b() {
        Method method;
        Class<?> cls = f7407i;
        if (cls == null || (method = f7408j) == null || f7410l == null) {
            return "";
        }
        try {
            Object invoke = method.invoke(cls, new Object[0]);
            return invoke != null ? (String) f7410l.invoke(invoke, new Object[0]) : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    private static void c() {
        try {
            Class<?> cls = Class.forName("com.umeng.umzid.ZIDManager");
            if (cls != null) {
                f7407i = cls;
                Method declaredMethod = cls.getDeclaredMethod("getInstance", new Class[0]);
                if (declaredMethod != null) {
                    f7408j = declaredMethod;
                }
                Method declaredMethod2 = f7407i.getDeclaredMethod("getZID", Context.class);
                if (declaredMethod2 != null) {
                    f7409k = declaredMethod2;
                }
                Method declaredMethod3 = f7407i.getDeclaredMethod("getSDKVersion", new Class[0]);
                if (declaredMethod3 != null) {
                    f7410l = declaredMethod3;
                }
            }
        } catch (Throwable unused) {
        }
    }

    private void d() {
        ao a2 = ao.a(this.f7412e);
        ap a3 = a2.a(aq.f7039c);
        if (a3 != null) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]二级缓存记录构建成真正信封。");
            try {
                String str = a3.a;
                String str2 = a3.b;
                JSONObject a4 = new com.umeng.commonsdk.statistics.b().a(this.f7412e.getApplicationContext(), new JSONObject(a3.f7035c), new JSONObject(a3.f7036d), a3.f7037e, str2, a3.f7038f);
                if (a4 != null && a4.has("exception")) {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]二级缓存记录构建真正信封 失败。删除二级缓存记录");
                } else {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]二级缓存记录构建真正信封 成功! 删除二级缓存记录。");
                }
                a2.a(aq.f7039c, str);
                a2.b();
            } catch (Throwable unused) {
            }
        }
    }

    private void e() {
        if (!f7411m) {
            if (FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
                f7411m = true;
                a(this.f7412e, new OnGetOaidListener() { // from class: com.umeng.commonsdk.internal.c.4
                    {
                        c.this = this;
                    }

                    @Override // com.umeng.commonsdk.listener.OnGetOaidListener
                    public void onGetOaid(String str) {
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> OAID云控参数更新(不采集->采集)：采集完成");
                        if (!TextUtils.isEmpty(str)) {
                            try {
                                SharedPreferences sharedPreferences = c.this.f7412e.getSharedPreferences(h.a, 0);
                                if (sharedPreferences != null) {
                                    SharedPreferences.Editor edit = sharedPreferences.edit();
                                    edit.putString(h.b, str);
                                    edit.commit();
                                }
                            } catch (Throwable unused) {
                            }
                            UMWorkDispatch.sendEvent(c.this.f7412e, a.w, b.a(c.this.f7412e).a(), null);
                            return;
                        }
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> oaid返回null或者空串，不需要 伪冷启动。");
                    }
                });
            }
        } else if (FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
        } else {
            f7411m = false;
        }
    }

    private void f() {
        if (FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
            f7411m = true;
            UMConfigureImpl.registerInterruptFlag();
            UMConfigureImpl.init(this.f7412e);
            f7404f++;
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 要读取 oaid，需等待读取结果.");
            UMConfigureImpl.registerMessageSendListener(new onMessageSendListener() { // from class: com.umeng.commonsdk.internal.c.5
                {
                    c.this = this;
                }

                @Override // com.umeng.commonsdk.utils.onMessageSendListener
                public void onMessageSend() {
                    if (c.this.f7412e != null) {
                        UMWorkDispatch.sendEvent(c.this.f7412e, a.x, b.a(c.this.f7412e).a(), null);
                    }
                    UMConfigureImpl.removeMessageSendListener(this);
                }
            });
            c(this.f7412e);
        }
    }

    private void g() {
        if (f7404f <= 0) {
            h();
            f(this.f7412e);
        }
    }

    private void h() {
        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 真实构建条件满足，开始构建业务信封。");
        if (UMUtils.isMainProgress(this.f7412e)) {
            g(this.f7412e);
            com.umeng.commonsdk.a.a(this.f7412e);
            Context context = this.f7412e;
            UMWorkDispatch.sendEvent(context, o.a.y, CoreProtocol.getInstance(context), null);
            Context context2 = this.f7412e;
            UMWorkDispatch.sendEvent(context2, a.t, b.a(context2).a(), null);
        }
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public void removeCacheData(Object obj) {
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public JSONObject setupReportData(long j2) {
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:271:0x0258 A[Catch: all -> 0x0441, TryCatch #0 {all -> 0x0441, blocks: (B:219:0x00db, B:223:0x010b, B:229:0x0123, B:231:0x013d, B:233:0x0143, B:234:0x0153, B:236:0x017c, B:239:0x0186, B:241:0x018a, B:243:0x019c, B:255:0x0214, B:257:0x022b, B:259:0x0236, B:262:0x023d, B:264:0x0243, B:266:0x024e, B:271:0x0258, B:273:0x025e, B:274:0x026a, B:275:0x0271), top: B:323:0x007b }] */
    /* JADX WARN: Removed duplicated region for block: B:275:0x0271 A[Catch: all -> 0x0441, TRY_LEAVE, TryCatch #0 {all -> 0x0441, blocks: (B:219:0x00db, B:223:0x010b, B:229:0x0123, B:231:0x013d, B:233:0x0143, B:234:0x0153, B:236:0x017c, B:239:0x0186, B:241:0x018a, B:243:0x019c, B:255:0x0214, B:257:0x022b, B:259:0x0236, B:262:0x023d, B:264:0x0243, B:266:0x024e, B:271:0x0258, B:273:0x025e, B:274:0x026a, B:275:0x0271), top: B:323:0x007b }] */
    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void workEvent(java.lang.Object r13, int r14) {
        /*
            Method dump skipped, instructions count: 1166
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.internal.c.workEvent(java.lang.Object, int):void");
    }

    public String a() {
        Method method;
        Class<?> cls = f7407i;
        if (cls == null || (method = f7408j) == null || f7409k == null) {
            return "";
        }
        try {
            Object invoke = method.invoke(cls, new Object[0]);
            return invoke != null ? (String) f7409k.invoke(invoke, this.f7412e) : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    private void b(Context context) {
        try {
            String imprintProperty = UMEnvelopeBuild.imprintProperty(context, am.f7002g, "");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(com.umeng.commonsdk.statistics.b.a("appkey"), UMGlobalContext.getInstance(context).getAppkey());
            jSONObject.put(com.umeng.commonsdk.statistics.b.a(am.f7002g), imprintProperty);
            JSONObject buildSilentEnvelopeWithExtHeader = UMEnvelopeBuild.buildSilentEnvelopeWithExtHeader(context, jSONObject, null, UMServerURL.SILENT_HEART_BEAT);
            if (buildSilentEnvelopeWithExtHeader != null && buildSilentEnvelopeWithExtHeader.has("exception")) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 构建心跳报文失败.");
            } else {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 构建心跳报文 成功!!!");
            }
        } catch (Throwable unused) {
        }
    }

    private static void g(Context context) {
        File filesDir = context.getFilesDir();
        File file = new File(filesDir.getAbsolutePath() + File.separator + aq.f7048l);
        if (file.exists()) {
            return;
        }
        try {
            file.createNewFile();
        } catch (Throwable unused) {
        }
    }

    private void a(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(com.umeng.commonsdk.statistics.b.a("appkey"), UMGlobalContext.getInstance(context).getAppkey());
            jSONObject.put(com.umeng.commonsdk.statistics.b.a("app_version"), UMGlobalContext.getInstance(context).getAppVersion());
            jSONObject.put(com.umeng.commonsdk.statistics.b.a(am.x), "Android");
            JSONObject buildZeroEnvelopeWithExtHeader = UMEnvelopeBuild.buildZeroEnvelopeWithExtHeader(context, jSONObject, null, UMServerURL.ZCFG_PATH);
            if (buildZeroEnvelopeWithExtHeader != null && buildZeroEnvelopeWithExtHeader.has("exception")) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 构建零号报文失败.");
            } else {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 构建零号报文 成功!!!");
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0035 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void e(android.content.Context r12) {
        /*
            r11 = this;
            if (r12 != 0) goto L3
            return
        L3:
            java.lang.String r0 = "um_rtd_conf"
            java.lang.String r1 = "debugkey"
            java.lang.String r2 = com.umeng.common.b.a(r12, r0, r1)
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 != 0) goto L8c
            java.lang.String r3 = "startTime"
            java.lang.String r3 = com.umeng.common.b.a(r12, r0, r3)
            java.lang.String r4 = "period"
            java.lang.String r4 = com.umeng.common.b.a(r12, r0, r4)
            boolean r5 = android.text.TextUtils.isEmpty(r3)
            r6 = 0
            if (r5 != 0) goto L2e
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch: java.lang.Throwable -> L2e
            long r8 = r3.longValue()     // Catch: java.lang.Throwable -> L2e
            goto L2f
        L2e:
            r8 = r6
        L2f:
            boolean r3 = android.text.TextUtils.isEmpty(r4)
            if (r3 != 0) goto L3e
            java.lang.Long r3 = java.lang.Long.valueOf(r4)     // Catch: java.lang.Throwable -> L3e
            long r3 = r3.longValue()     // Catch: java.lang.Throwable -> L3e
            goto L3f
        L3e:
            r3 = r6
        L3f:
            java.lang.String r5 = "MobclickRT"
            int r10 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r10 == 0) goto L84
            int r10 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r10 != 0) goto L4a
            goto L84
        L4a:
            long r6 = java.lang.System.currentTimeMillis()
            long r6 = r6 - r8
            r8 = 60
            long r3 = r3 * r8
            r8 = 1000(0x3e8, double:4.94E-321)
            long r3 = r3 * r8
            int r8 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r8 <= 0) goto L6d
            java.lang.String r1 = "--->>> [RTD]本地缓存dk值已经超时，清除缓存数据。"
            com.umeng.commonsdk.debug.UMRTLog.i(r5, r1)
            com.umeng.common.b.a(r12, r0)
            boolean r12 = com.umeng.analytics.AnalyticsConfig.isRealTimeDebugMode()
            if (r12 == 0) goto L8c
            com.umeng.analytics.AnalyticsConfig.turnOffRealTimeDebug()
            goto L8c
        L6d:
            java.util.HashMap r12 = new java.util.HashMap
            r12.<init>()
            r12.put(r1, r2)
            boolean r0 = com.umeng.analytics.AnalyticsConfig.isRealTimeDebugMode()
            if (r0 != 0) goto L8c
            java.lang.String r0 = "--->>> [RTD]本地缓存dk值在有效期内，切换到埋点验证模式。"
            com.umeng.commonsdk.debug.UMRTLog.i(r5, r0)
            com.umeng.analytics.AnalyticsConfig.turnOnRealTimeDebug(r12)
            goto L8c
        L84:
            java.lang.String r1 = "--->>> [RTD]本地缓存startTime或者duration值无效，清除缓存数据"
            com.umeng.commonsdk.debug.UMRTLog.i(r5, r1)
            com.umeng.common.b.a(r12, r0)
        L8c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.internal.c.e(android.content.Context):void");
    }

    private static void c(final Context context) {
        new Thread(new Runnable() { // from class: com.umeng.commonsdk.internal.c.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    SharedPreferences sharedPreferences = context.getSharedPreferences(h.a, 0);
                    long currentTimeMillis = System.currentTimeMillis();
                    String a2 = aa.a(context);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (!TextUtils.isEmpty(a2) && sharedPreferences != null) {
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        edit.putString(h.f7504c, (currentTimeMillis2 - currentTimeMillis) + "");
                        edit.commit();
                    }
                    if (sharedPreferences != null) {
                        SharedPreferences.Editor edit2 = sharedPreferences.edit();
                        edit2.putString(h.b, a2);
                        edit2.commit();
                    }
                    UMConfigureImpl.removeInterruptFlag();
                } catch (Throwable unused) {
                }
            }
        }).start();
    }

    private void f(Context context) {
        Object invoke;
        Method declaredMethod;
        Context applicationContext = context.getApplicationContext();
        String appkey = UMUtils.getAppkey(context);
        try {
            Class<?> a2 = a("com.umeng.umzid.ZIDManager");
            Method declaredMethod2 = a2.getDeclaredMethod("getInstance", new Class[0]);
            if (declaredMethod2 == null || (invoke = declaredMethod2.invoke(a2, new Object[0])) == null || (declaredMethod = a2.getDeclaredMethod("init", Context.class, String.class, a("com.umeng.umzid.IZIDCompletionCallback"))) == null) {
                return;
            }
            declaredMethod.invoke(invoke, applicationContext, appkey, null);
        } catch (Throwable unused) {
        }
    }

    private static void a(Context context, final OnGetOaidListener onGetOaidListener) {
        if (context == null) {
            return;
        }
        final Context applicationContext = context.getApplicationContext();
        new Thread(new Runnable() { // from class: com.umeng.commonsdk.internal.c.2
            @Override // java.lang.Runnable
            public void run() {
                String a2 = aa.a(applicationContext);
                OnGetOaidListener onGetOaidListener2 = onGetOaidListener;
                if (onGetOaidListener2 != null) {
                    onGetOaidListener2.onGetOaid(a2);
                }
            }
        }).start();
    }

    private static Class<?> a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    private static void d(final Context context) {
        if (FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
            a(context, new OnGetOaidListener() { // from class: com.umeng.commonsdk.internal.c.3
                @Override // com.umeng.commonsdk.listener.OnGetOaidListener
                public void onGetOaid(String str) {
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    try {
                        SharedPreferences sharedPreferences = context.getSharedPreferences(h.a, 0);
                        if (sharedPreferences == null || sharedPreferences.getString(h.b, "").equalsIgnoreCase(str)) {
                            return;
                        }
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 更新本地缓存OAID");
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        edit.putString(h.b, str);
                        edit.commit();
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }
}
