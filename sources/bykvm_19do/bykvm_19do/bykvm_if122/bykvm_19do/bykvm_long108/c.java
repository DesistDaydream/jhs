package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.d0;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.e;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.g;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.l0;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.m;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.v;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.x;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.y;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.z;
import com.bytedance.msdk.adapter.config.DefaultAdapterClasses;
import com.bytedance.msdk.adapter.config.ITTAdapterConfiguration;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import com.bytedance.msdk.adapter.util.WeakHandler;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.UserInfoForSegment;
import com.bytedance.msdk.api.v2.GMConfigCallback;
import com.bytedance.msdk.api.v2.GMConfigUserInfoForSegment;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.tencent.android.tpush.XGServerInfo;
import com.umeng.analytics.pro.am;
import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class c implements WeakHandler.IHandler {

    /* renamed from: i */
    private static volatile boolean f864i;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: j */
    private static volatile c f865j;
    private final bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.a a;
    private final Context b;

    /* renamed from: f */
    private final WeakHandler f869f;

    /* renamed from: c */
    private final AtomicInteger f866c = new AtomicInteger(0);

    /* renamed from: d */
    private final AtomicBoolean f867d = new AtomicBoolean(false);

    /* renamed from: e */
    private final AtomicBoolean f868e = new AtomicBoolean(false);

    /* renamed from: g */
    private final AtomicBoolean f870g = new AtomicBoolean(false);

    /* renamed from: h */
    private int f871h = -1;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public final /* synthetic */ GMConfigCallback a;
        public final /* synthetic */ AdError b;

        public a(c cVar, GMConfigCallback gMConfigCallback, AdError adError) {
            this.a = gMConfigCallback;
            this.b = adError;
        }

        @Override // java.lang.Runnable
        public void run() {
            GMConfigCallback gMConfigCallback = this.a;
            if (gMConfigCallback != null) {
                gMConfigCallback.onConfigLoadFail(this.b);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public final /* synthetic */ GMConfigCallback a;
        public final /* synthetic */ List b;

        public b(c cVar, GMConfigCallback gMConfigCallback, List list) {
            this.a = gMConfigCallback;
            this.b = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.onConfigLoaded(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().a(this.b));
        }
    }

    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.c$c */
    /* loaded from: classes.dex */
    public class C0040c extends bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a {
        public final /* synthetic */ int[] a;
        public final /* synthetic */ int[] b;

        /* renamed from: c */
        public final /* synthetic */ long f872c;

        /* renamed from: d */
        public final /* synthetic */ boolean f873d;

        /* renamed from: e */
        public final /* synthetic */ int f874e;

        /* renamed from: f */
        public final /* synthetic */ JSONObject f875f;

        /* renamed from: g */
        public final /* synthetic */ GMConfigCallback f876g;

        /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.c$c$a */
        /* loaded from: classes.dex */
        public class a implements Runnable {
            public final /* synthetic */ bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.b a;

            public a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.b bVar) {
                C0040c.this = r1;
                this.a = bVar;
            }

            /* JADX WARN: Removed duplicated region for block: B:119:0x0119 A[Catch: all -> 0x0224, TryCatch #5 {all -> 0x0224, blocks: (B:89:0x0014, B:91:0x0025, B:93:0x0044, B:96:0x006d, B:112:0x00e2, B:114:0x00fe, B:116:0x0104, B:117:0x010b, B:119:0x0119, B:122:0x0123, B:126:0x0170, B:128:0x018a, B:130:0x0194, B:132:0x01a6, B:139:0x01f1, B:103:0x009e, B:110:0x00d7, B:98:0x007b, B:105:0x00b0), top: B:164:0x0014 }] */
            /* JADX WARN: Removed duplicated region for block: B:122:0x0123 A[Catch: all -> 0x0224, TryCatch #5 {all -> 0x0224, blocks: (B:89:0x0014, B:91:0x0025, B:93:0x0044, B:96:0x006d, B:112:0x00e2, B:114:0x00fe, B:116:0x0104, B:117:0x010b, B:119:0x0119, B:122:0x0123, B:126:0x0170, B:128:0x018a, B:130:0x0194, B:132:0x01a6, B:139:0x01f1, B:103:0x009e, B:110:0x00d7, B:98:0x007b, B:105:0x00b0), top: B:164:0x0014 }] */
            /* JADX WARN: Removed duplicated region for block: B:127:0x0188  */
            /* JADX WARN: Removed duplicated region for block: B:153:0x029c  */
            /* JADX WARN: Removed duplicated region for block: B:154:0x029e  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() {
                /*
                    Method dump skipped, instructions count: 679
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.c.C0040c.a.run():void");
            }
        }

        /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.c$c$b */
        /* loaded from: classes.dex */
        public class b implements Runnable {
            public final /* synthetic */ IOException a;

            public b(IOException iOException) {
                C0040c.this = r1;
                this.a = iOException;
            }

            @Override // java.lang.Runnable
            public void run() {
                Logger.e("SdkSettingsHelper", "----网络错误，服务器无响应，稍后会尝试重新拉取配置----，setting request failed..." + this.a.getMessage());
                try {
                    C0040c c0040c = C0040c.this;
                    c.this.a(c0040c.f876g, new AdError(-2, AdError.getMessage(-2)), C0040c.this.f874e);
                    Logger.e("SdkSettingsHelper", "----网络错误，重新拉取配置失败----，>>>>> retryLoadSettingData");
                } catch (Throwable unused) {
                }
                c.this.f867d.set(false);
                C0040c c0040c2 = C0040c.this;
                int[] iArr = c0040c2.b;
                iArr[0] = 0;
                int[] iArr2 = c0040c2.a;
                iArr2[0] = -2;
                int i2 = iArr[0];
                int i3 = iArr2[0];
                long currentTimeMillis = System.currentTimeMillis();
                C0040c c0040c3 = C0040c.this;
                h.a(i2, i3, currentTimeMillis - c0040c3.f872c, c0040c3.f873d, c0040c3.f874e == 0, c0040c3.f875f, -1L);
            }
        }

        public C0040c(int[] iArr, int[] iArr2, long j2, boolean z, int i2, JSONObject jSONObject, GMConfigCallback gMConfigCallback) {
            c.this = r1;
            this.a = iArr;
            this.b = iArr2;
            this.f872c = j2;
            this.f873d = z;
            this.f874e = i2;
            this.f875f = jSONObject;
            this.f876g = gMConfigCallback;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a
        public void a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.b bVar, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.b bVar2) {
            ThreadHelper.runOnMSDKThread(new a(bVar2));
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a
        public void a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.b bVar, IOException iOException) {
            ThreadHelper.runOnMSDKThread(new b(iOException));
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        private final GMConfigCallback a;
        private int b;

        public d(GMConfigCallback gMConfigCallback, int i2) {
            c.this = r1;
            this.b = 1;
            this.a = gMConfigCallback;
            this.b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!y.a(c.this.b)) {
                try {
                    c.this.a.a(false);
                    return;
                } catch (Throwable unused) {
                    return;
                }
            }
            c.this.f867d.set(true);
            boolean x = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().x();
            if (!c.f864i) {
                boolean unused2 = c.f864i = true;
                h.a(x);
            }
            c.this.a(x, this.a, this.b);
        }
    }

    private c(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.a aVar) {
        this.a = aVar == null ? bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f() : aVar;
        this.b = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d();
        this.f869f = new WeakHandler(Looper.getMainLooper(), this);
    }

    public static c a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.a aVar) {
        if (f865j == null) {
            synchronized (c.class) {
                if (f865j == null) {
                    f865j = new c(aVar);
                }
            }
        }
        return f865j;
    }

    private String a(JSONObject jSONObject) {
        JSONObject a2 = l0.a(jSONObject);
        if (a2 != null) {
            return a2.toString();
        }
        return null;
    }

    public Map<String, String> a(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (String str : map.keySet()) {
            if (!TextUtils.isEmpty(str)) {
                hashMap.put(str.toLowerCase(), map.get(str));
            }
        }
        return hashMap;
    }

    private void a(GMConfigCallback gMConfigCallback, AdError adError) {
        ThreadHelper.runOnUiThread(new a(this, gMConfigCallback, adError));
    }

    public void a(GMConfigCallback gMConfigCallback, AdError adError, int i2) throws Throwable {
        long j2;
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.d.R().f("server_dist_host");
        a(gMConfigCallback, adError);
        Logger.e("SdkSettingsHelper", "setting 配置拉取失败，尝试再次拉取... mLoadingSuccess:" + this.f868e.get() + " mRetryCount:" + (this.f866c.get() + 1));
        this.f867d.set(false);
        if (this.f868e.get()) {
            this.f870g.set(false);
            this.f869f.removeCallbacksAndMessages(null);
        } else if (this.f866c.get() > 3) {
            Logger.e("SdkSettingsHelper", "setting 最多尝试四次拉取... ");
        } else {
            this.f870g.set(true);
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = this.f866c.get();
            obtain.arg2 = i2;
            int i3 = this.f866c.get();
            if (i3 < 3) {
                long j3 = 1;
                for (int i4 = 0; i4 <= i3; i4++) {
                    j3 *= 3;
                }
                j2 = j3 * 1000;
            } else {
                j2 = 120000;
            }
            this.f866c.incrementAndGet();
            this.f869f.removeCallbacksAndMessages(null);
            this.f869f.sendMessageDelayed(obtain, j2);
            Logger.i("SdkSettingsHelper", "setting 重试次数:" + (i3 + 1) + "  重试间隔：" + j2);
        }
    }

    public void a(boolean z, GMConfigCallback gMConfigCallback, int i2) {
        int[] iArr = new int[1];
        long currentTimeMillis = System.currentTimeMillis();
        Map<String, JSONObject> a2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.b.c().a(i2);
        JSONObject jSONObject = a2.get("event_label_value_root");
        JSONObject jSONObject2 = a2.get("config_req_label_value_root");
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.c c2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.b.b().a().c();
        c2.b(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c.g());
        String q = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().q();
        if (!TextUtils.isEmpty(q)) {
            c2.a("X-Tt-Env", q);
            c2.a("x-use-ppe", "1");
        }
        c2.a("User-Agent", e.c.c.a.b.b);
        c2.c(a(b(jSONObject2)));
        c2.a(new C0040c(iArr, new int[]{0}, currentTimeMillis, z, i2, jSONObject, gMConfigCallback));
    }

    private JSONObject b(JSONObject jSONObject) {
        for (char c2 = 'W'; c2 > 5; c2 = 65497) {
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("ts", System.currentTimeMillis());
            jSONObject2.put("media_sdk_version", "3.7.0.2");
            jSONObject2.put("app_id", bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().b());
            jSONObject2.put("package_name", l0.a());
            jSONObject2.put("app_version", l0.e());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("android_id", v.a(this.b));
            jSONObject3.put("imei", v.e(this.b));
            jSONObject3.put(Constants.EXTRA_KEY_IMEI_MD5, x.a(v.e(this.b)));
            jSONObject3.put("oaid", z.a());
            jSONObject3.put("gaid", g.c().a());
            jSONObject3.put("applog_did", v.d(this.b));
            jSONObject3.put("publisher_did", bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().t());
            jSONObject3.put("conn_type", y.b(this.b));
            jSONObject3.put(am.x, 1);
            jSONObject3.put("os_version", String.valueOf(Build.VERSION.RELEASE));
            jSONObject3.put("vendor", Build.MANUFACTURER);
            jSONObject3.put("device_model", Build.MODEL);
            jSONObject3.put("mcc", d0.b());
            jSONObject3.put("mnc", d0.c());
            jSONObject3.put("time_zone", TimeZone.getDefault().getDisplayName(false, 0));
            jSONObject3.put(XGServerInfo.TAG_IP, m.a());
            jSONObject3.put("locale_language", m.b());
            jSONObject3.put("total_space", "" + m.h());
            jSONObject3.put("carrier_name", d0.a());
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 17) {
                jSONObject3.put(am.J, Settings.Global.getString(this.b.getContentResolver(), am.J));
            } else {
                jSONObject3.put(am.J, "");
            }
            jSONObject3.put("pb", "");
            Formatter format = new Formatter().format("%.6f", Double.valueOf((System.currentTimeMillis() - SystemClock.elapsedRealtime()) / 1000.0d));
            jSONObject3.put("boot", "" + format.toString());
            jSONObject3.put("device_city", "");
            jSONObject3.put("country_code", bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().f());
            jSONObject3.put("total_mem", "" + m.g());
            jSONObject3.put(am.ai, Build.MODEL);
            jSONObject3.put(am.N, Locale.getDefault().getLanguage());
            jSONObject3.put("android_os_version_int", i2);
            jSONObject2.put("device", jSONObject3);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("init_time", bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().e());
            jSONObject2.put(PushConstants.EXTRA_APPLICATION_PENDING_INTENT, jSONObject4);
            jSONObject2.put("grouping_params", g());
            JSONObject f2 = f();
            if (f2 != null) {
                jSONObject2.put("user_defined_grouping_params", f2);
            }
            if (!bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().y()) {
                jSONObject2.put("etag", bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().h());
            }
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.d b2 = e.b(this.b);
            if (b2 != null) {
                jSONObject2.put("latitude", b2.a);
                jSONObject2.put("longitude", b2.b);
            }
            jSONObject2.put("adn_version_list", e());
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.b.c().a(jSONObject2, jSONObject);
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.b.c().a(jSONObject2);
            List<String> r = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().r();
            if (r != null && r.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (String str : r) {
                    jSONArray.put(str);
                }
                jSONObject2.put("primerit_list", jSONArray);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jSONObject2;
    }

    public void c(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (!jSONObject.optBoolean("remote_log_enabled")) {
                    return;
                }
                Logger.openDebugMode();
            } catch (Throwable unused) {
            }
        }
    }

    private boolean c() {
        long a2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.d.R().a("max_expire_time", 0L);
        if (this.f868e.get() && System.currentTimeMillis() > a2) {
            Logger.i("SdkSettingsHelper", "setting 缓存过期，再次发起请求...");
            this.f868e.set(false);
            a();
        }
        return System.currentTimeMillis() > a2;
    }

    private static List<String> d() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("pangle");
        arrayList.add("gdt");
        arrayList.add("admob");
        arrayList.add("unity");
        arrayList.add("baidu");
        arrayList.add("sigmob");
        arrayList.add("mintegral");
        arrayList.add("ks");
        arrayList.add("klevin");
        return arrayList;
    }

    private JSONObject e() {
        JSONObject jSONObject = new JSONObject();
        Map<String, ITTAdapterConfiguration> e2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.a.e();
        List<String> d2 = d();
        if (e2 != null && d2 != null) {
            for (String str : d2) {
                ITTAdapterConfiguration iTTAdapterConfiguration = e2.get(DefaultAdapterClasses.getClassNameByAdnName(str));
                if (iTTAdapterConfiguration != null) {
                    try {
                        jSONObject.put(str, iTTAdapterConfiguration.getNetworkSdkVersion());
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                    }
                }
            }
        }
        return jSONObject;
    }

    public static JSONObject f() {
        Map<String, String> customInfos;
        JSONObject jSONObject = new JSONObject();
        GMConfigUserInfoForSegment f2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().f();
        if (f2 != null) {
            Map<String, String> customInfos2 = f2.getCustomInfos();
            if (customInfos2 != null) {
                try {
                    for (String str : customInfos2.keySet()) {
                        jSONObject.put(str, customInfos2.get(str));
                    }
                    return jSONObject;
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    return null;
                }
            }
        } else {
            UserInfoForSegment u = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().u();
            if (u != null && (customInfos = u.getCustomInfos()) != null) {
                try {
                    for (String str2 : customInfos.keySet()) {
                        jSONObject.put(str2, customInfos.get(str2));
                    }
                    return jSONObject;
                } catch (Exception e3) {
                    e = e3;
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return null;
    }

    public static JSONObject g() {
        JSONObject jSONObject = new JSONObject();
        GMConfigUserInfoForSegment f2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().f();
        try {
            if (f2 != null) {
                jSONObject.put("user_id", f2 != null ? f2.getUserId() : "");
                jSONObject.put("channel", f2 != null ? f2.getChannel() : "");
                jSONObject.put("sub_channel", f2 != null ? f2.getSubChannel() : "");
                jSONObject.put("age", f2 != null ? f2.getAge() : 0);
                jSONObject.put("gender", f2 != null ? f2.getGender() : "");
                jSONObject.put("user_value_group", f2 != null ? f2.getUserValueGroup() : "");
            } else {
                UserInfoForSegment u = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().u();
                jSONObject.put("user_id", u != null ? u.getUserId() : "");
                jSONObject.put("channel", u != null ? u.getChannel() : "");
                jSONObject.put("sub_channel", u != null ? u.getSubChannel() : "");
                jSONObject.put("age", u != null ? u.getAge() : 0);
                jSONObject.put("gender", u != null ? u.getGender() : "");
                jSONObject.put("user_value_group", u != null ? u.getUserValueGroup() : "");
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public c a() {
        Logger.e("SdkSettingsHelper", "setting resetRetryCount...");
        this.f866c.set(0);
        this.f870g.set(false);
        WeakHandler weakHandler = this.f869f;
        if (weakHandler != null) {
            weakHandler.removeCallbacksAndMessages(null);
        }
        return this;
    }

    public void a(int i2) {
        try {
            if (this.f867d.get()) {
                this.f871h = i2;
                Logger.i("SdkSettingsHelper", "setting 正在加载，无需再次发起请求...");
            } else {
                ThreadHelper.runOnThreadPool(new d(null, i2));
            }
        } catch (Throwable th) {
            Logger.d("SdkSettingsHelper", "load sdk settings error: ", th);
        }
    }

    public void a(GMConfigCallback gMConfigCallback) {
        if (this.f871h == 2) {
            this.f871h = -1;
            a(2);
        }
        if (gMConfigCallback != null) {
            ThreadHelper.runOnUiThread(new b(this, gMConfigCallback, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().r()));
        }
    }

    public void a(List<String> list, GMConfigCallback gMConfigCallback) {
        AdError adError;
        d dVar;
        if (gMConfigCallback == null) {
            return;
        }
        try {
            if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().q()) {
                if (list != null && list.size() > 0) {
                    if (!this.f867d.get()) {
                        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().a(list);
                        if (!bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().b(list)) {
                            dVar = new d(gMConfigCallback, 1);
                        } else if (!c()) {
                            Logger.d("SdkSettingsHelper", "本地配置未过期，直接回调成功");
                            gMConfigCallback.onConfigLoaded(null);
                            return;
                        } else {
                            dVar = new d(gMConfigCallback, 1);
                        }
                        ThreadHelper.runOnThreadPool(dVar);
                        return;
                    }
                    Logger.i("SdkSettingsHelper", "setting 正在加载，无需再次发起请求...");
                    adError = new AdError(AdError.ERROR_CODE_CONFIG_IS_ALREADY_LOADING, AdError.getMessage(AdError.ERROR_CODE_CONFIG_IS_ALREADY_LOADING));
                }
                adError = new AdError(AdError.ERROR_CODE_INPUT_PARAMS_ERROR, AdError.getMessage(AdError.ERROR_CODE_INPUT_PARAMS_ERROR));
            } else {
                adError = new AdError(AdError.ERROR_CODE_NO_PERMISSION, AdError.getMessage(AdError.ERROR_CODE_NO_PERMISSION));
            }
            gMConfigCallback.onConfigLoadFail(adError);
        } catch (Throwable th) {
            Logger.d("SdkSettingsHelper", "load sdk settings error: ", th);
        }
    }

    public void b(int i2) {
        String str;
        v.d(this.b);
        try {
            if (!c()) {
                str = "setting 缓存未过期，无需再次发起请求...";
            } else if (!this.f867d.get()) {
                ThreadHelper.runOnThreadPool(new d(null, i2));
            } else {
                str = "setting 正在加载，无需再次发起请求...";
            }
            Logger.i("SdkSettingsHelper", str);
        } catch (Throwable th) {
            Logger.d("SdkSettingsHelper", "load sdk settings error: ", th);
        }
    }

    public void c(int i2) {
        if (this.f870g.get()) {
            Logger.e("SdkSettingsHelper", "setting 正在尝试拉取配置中...");
            return;
        }
        Logger.e("SdkSettingsHelper", "setting 尝试拉取配置...");
        a();
        b(i2);
    }

    @Override // com.bytedance.msdk.adapter.util.WeakHandler.IHandler
    public void handleMsg(Message message) {
        if (message.what != 1) {
            return;
        }
        int i2 = message.arg1;
        int i3 = message.arg2;
        if (i2 == 3) {
            this.f870g.set(false);
        }
        Logger.e("SdkSettingsHelper", "setting 发起尝试拉取配置请求... mLoadingSuccess:" + this.f868e.get() + "tryCount:" + (i2 + 1));
        try {
            if (this.f868e.get()) {
                return;
            }
            b(i3);
        } catch (Throwable unused) {
        }
    }
}
