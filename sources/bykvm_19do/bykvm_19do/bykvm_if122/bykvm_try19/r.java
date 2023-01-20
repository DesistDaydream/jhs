package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.effective.android.panel.Constants;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.umeng.analytics.pro.am;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes.dex */
public class r {

    /* loaded from: classes.dex */
    public static final class a implements bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.e {
        public final /* synthetic */ Context a;

        public a(Context context) {
            this.a = context;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.e
        public String a() {
            return bykvm_19do.bykvm_19do.bykvm_19do.a.m();
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.e
        public List<String> b() {
            return null;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.e
        public String c() {
            return v.d(this.a);
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.e
        public String d() {
            return null;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.e
        public Map<String, Object> e() {
            HashMap hashMap = new HashMap();
            hashMap.put("host_appid", bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().b());
            hashMap.put("sdk_version", "3.7.0.2");
            hashMap.put(PluginConstants.KEY_PLUGIN_VERSION, "3.7.0.2");
            hashMap.put("channel", "gromore");
            return hashMap;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.e
        public Map<String, Object> f() {
            HashMap hashMap = new HashMap();
            String c2 = p.c();
            if (TextUtils.isEmpty(c2)) {
                c2 = v.d(this.a);
            }
            if (!TextUtils.isEmpty(c2)) {
                hashMap.put("device_id", c2);
            }
            hashMap.put("ac", y.d(this.a));
            hashMap.put("aid", "299838");
            hashMap.put("app_name", "gromore");
            String e2 = l0.e();
            if (!TextUtils.isEmpty(e2)) {
                hashMap.put("app_version", e2);
            }
            String d2 = l0.d();
            if (!TextUtils.isEmpty(d2)) {
                hashMap.put("version_code", d2);
                hashMap.put("update_version_code", d2);
            }
            hashMap.put(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, "3.7.0.2");
            hashMap.put("device_platform", Constants.ANDROID);
            hashMap.put(am.x, "Android");
            String str = Build.MODEL;
            hashMap.put(am.ai, str);
            hashMap.put("device_mode", str);
            hashMap.put("rom", b0.k());
            hashMap.put("cpu_abi", Build.CPU_ABI);
            hashMap.put(am.F, Build.BRAND);
            hashMap.put("channel", "gromore");
            hashMap.put(am.N, Locale.getDefault().getLanguage());
            hashMap.put("os_api", String.valueOf(Build.VERSION.SDK_INT));
            try {
                String str2 = Build.VERSION.RELEASE;
                if (str2 != null && str2.length() > 10) {
                    str2 = str2.substring(0, 10);
                }
                hashMap.put("os_version", str2);
            } catch (Exception unused) {
            }
            hashMap.put("openudid", v.a(this.a));
            hashMap.put("dpi", String.valueOf(this.a.getResources().getDisplayMetrics().density));
            hashMap.put("resolution", this.a.getResources().getDisplayMetrics().widthPixels + "*" + this.a.getResources().getDisplayMetrics().heightPixels);
            return hashMap;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.e
        public Map<String, Integer> g() {
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.g {
        /* JADX WARN: Removed duplicated region for block: B:13:0x002b A[Catch: all -> 0x0041, TryCatch #0 {all -> 0x0041, blocks: (B:3:0x0002, B:5:0x0015, B:7:0x001d, B:13:0x002b, B:15:0x0035), top: B:19:0x0002 }] */
        /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
        @Override // bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.g
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean a(java.lang.Throwable r4, java.lang.Thread r5) {
            /*
                r3 = this;
                r5 = 0
                r0 = 1
                java.io.StringWriter r1 = new java.io.StringWriter     // Catch: java.lang.Throwable -> L41
                r1.<init>()     // Catch: java.lang.Throwable -> L41
                java.io.PrintWriter r2 = new java.io.PrintWriter     // Catch: java.lang.Throwable -> L41
                r2.<init>(r1)     // Catch: java.lang.Throwable -> L41
                r4.printStackTrace(r2)     // Catch: java.lang.Throwable -> L41
                java.lang.String r4 = r1.toString()     // Catch: java.lang.Throwable -> L41
                if (r4 == 0) goto L41
                java.lang.String r1 = "com.bytedance.msdk"
                boolean r1 = r4.contains(r1)     // Catch: java.lang.Throwable -> L41
                if (r1 != 0) goto L28
                java.lang.String r1 = "bykvm"
                boolean r4 = r4.contains(r1)     // Catch: java.lang.Throwable -> L41
                if (r4 == 0) goto L26
                goto L28
            L26:
                r4 = 0
                goto L29
            L28:
                r4 = 1
            L29:
                if (r4 == 0) goto L41
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.r$c r4 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.r.c.b()     // Catch: java.lang.Throwable -> L41
                java.util.Map r4 = r4.a()     // Catch: java.lang.Throwable -> L41
                if (r4 == 0) goto L40
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.r$c r4 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.r.c.b()     // Catch: java.lang.Throwable -> L41
                java.util.Map r4 = r4.a()     // Catch: java.lang.Throwable -> L41
                bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.h.a(r4)     // Catch: java.lang.Throwable -> L41
            L40:
                r5 = 1
            L41:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.r.b.a(java.lang.Throwable, java.lang.Thread):boolean");
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        private static String b = "ad_style";

        /* renamed from: c  reason: collision with root package name */
        private static String f1029c = "ad_id";

        /* renamed from: d  reason: collision with root package name */
        private static String f1030d = "rit";

        /* renamed from: e  reason: collision with root package name */
        private static String f1031e = "request_id";

        /* renamed from: f  reason: collision with root package name */
        private static String f1032f = "ad_slot_type";

        /* renamed from: g  reason: collision with root package name */
        private static String f1033g = "net_type";

        /* renamed from: h  reason: collision with root package name */
        private static String f1034h = "low_memory";

        /* renamed from: i  reason: collision with root package name */
        private static String f1035i = "total_max_memory_rate";

        /* renamed from: j  reason: collision with root package name */
        private static String f1036j = "category";

        /* renamed from: k  reason: collision with root package name */
        private static String f1037k = "commit_hash";

        /* renamed from: l  reason: collision with root package name */
        private static String f1038l = "branch";

        /* renamed from: m  reason: collision with root package name */
        private static String f1039m = "plugin_version";
        private static volatile c n;
        private Map<String, String> a;

        private c() {
            HashMap hashMap = new HashMap();
            this.a = hashMap;
            hashMap.put(b, "default");
            this.a.put(f1029c, "default");
            this.a.put(f1030d, "default");
            this.a.put(f1031e, "default");
            this.a.put(f1032f, "default");
            this.a.put(f1033g, "default");
            this.a.put(f1034h, "default");
            this.a.put(f1035i, "default");
            this.a.put(f1036j, "main");
            this.a.put(f1037k, "a21d781");
            this.a.put(f1038l, "");
            this.a.put(f1039m, "3.7.0.2");
        }

        public static c b() {
            if (n == null) {
                synchronized (c.class) {
                    if (n == null) {
                        n = new c();
                    }
                }
            }
            return n;
        }

        public Map<String, String> a() {
            return this.a;
        }
    }

    public static void a(Context context) {
        b(context);
    }

    private static void b(Context context) {
        bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.h.a(context, new a(context), true, false);
        bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.h.a(new b());
    }
}
