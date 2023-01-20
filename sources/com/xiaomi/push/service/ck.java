package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.qcloud.tuikit.tuichat.ui.view.input.TIMMentionEditText;
import com.xiaomi.push.fi;
import com.xiaomi.push.gg;
import com.xiaomi.push.gn;
import com.xiaomi.push.gu;
import com.xiaomi.push.gv;
import com.xiaomi.push.jc;
import com.xiaomi.push.jg;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ck {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: m */
    private static volatile ck f9140m;
    private final SharedPreferences a;

    /* renamed from: h */
    private long f9146h;

    /* renamed from: i */
    private final boolean f9147i;

    /* renamed from: j */
    private final boolean f9148j;

    /* renamed from: l */
    private final Context f9150l;
    private final AtomicInteger b = new AtomicInteger(0);

    /* renamed from: c */
    private String f9141c = null;

    /* renamed from: d */
    private volatile boolean f9142d = false;

    /* renamed from: e */
    private String f9143e = null;

    /* renamed from: f */
    private final AtomicInteger f9144f = new AtomicInteger(0);

    /* renamed from: g */
    private final AtomicInteger f9145g = new AtomicInteger(0);

    /* renamed from: k */
    private int f9149k = -1;

    /* loaded from: classes3.dex */
    public static class a {
        public static String a() {
            return "support_wifi_digest";
        }

        public static String a(String str) {
            return String.format("HB_%s", str);
        }

        public static String b() {
            return "record_support_wifi_digest_reported";
        }

        public static String b(String str) {
            return String.format("HB_dead_time_%s", str);
        }

        public static String c() {
            return "record_hb_count_start";
        }

        public static String d() {
            return "record_short_hb_count";
        }

        public static String e() {
            return "record_long_hb_count";
        }

        public static String f() {
            return "record_hb_change";
        }

        public static String g() {
            return "record_mobile_ptc";
        }

        public static String h() {
            return "record_wifi_ptc";
        }

        public static String i() {
            return "record_ptc_start";
        }

        public static String j() {
            return "keep_short_hb_effective_time";
        }
    }

    private ck(Context context) {
        this.f9150l = context;
        this.f9148j = jc.a(context);
        this.f9147i = ad.a(context).a(gv.IntelligentHeartbeatSwitchBoolean.a(), true);
        SharedPreferences sharedPreferences = context.getSharedPreferences("hb_record", 0);
        this.a = sharedPreferences;
        long currentTimeMillis = System.currentTimeMillis();
        if (sharedPreferences.getLong(a.c(), -1L) == -1) {
            sharedPreferences.edit().putLong(a.c(), currentTimeMillis).apply();
        }
        long j2 = sharedPreferences.getLong(a.i(), -1L);
        this.f9146h = j2;
        if (j2 == -1) {
            this.f9146h = currentTimeMillis;
            sharedPreferences.edit().putLong(a.i(), currentTimeMillis).apply();
        }
    }

    public static ck a(Context context) {
        if (f9140m == null) {
            synchronized (ck.class) {
                if (f9140m == null) {
                    f9140m = new ck(context);
                }
            }
        }
        return f9140m;
    }

    private void a(String str, String str2, Map<String, String> map) {
        gu guVar = new gu();
        guVar.d(str);
        guVar.c("hb_name");
        guVar.a("hb_channel");
        guVar.a(1L);
        guVar.b(str2);
        guVar.c(false);
        guVar.b(System.currentTimeMillis());
        guVar.g(this.f9150l.getPackageName());
        guVar.e("com.xiaomi.xmsf");
        if (map == null) {
            map = new HashMap<>();
        }
        String str3 = null;
        cp a2 = cq.a(this.f9150l);
        if (a2 != null && !TextUtils.isEmpty(a2.a)) {
            String[] split = a2.a.split(TIMMentionEditText.TIM_MENTION_TAG);
            if (split.length > 0) {
                str3 = split[0];
            }
        }
        map.put("uuid", str3);
        map.put(com.baidu.mobads.sdk.internal.bc.f1474i, Build.MODEL);
        Context context = this.f9150l;
        map.put("avc", String.valueOf(gg.b(context, context.getPackageName())));
        map.put("pvc", String.valueOf(40091));
        map.put("cvc", String.valueOf(48));
        guVar.a(map);
        gn a3 = gn.a(this.f9150l);
        if (a3 != null) {
            a3.a(guVar, this.f9150l.getPackageName());
        }
    }

    private void a(boolean z) {
        if (n()) {
            int incrementAndGet = (z ? this.f9144f : this.f9145g).incrementAndGet();
            Object[] objArr = new Object[2];
            objArr[0] = z ? "short" : "long";
            objArr[1] = Integer.valueOf(incrementAndGet);
            com.xiaomi.a.a.a.c.b(String.format("[HB] %s ping interval count: %s", objArr));
            if (incrementAndGet >= 5) {
                String d2 = z ? a.d() : a.e();
                int i2 = this.a.getInt(d2, 0) + incrementAndGet;
                this.a.edit().putInt(d2, i2).apply();
                Object[] objArr2 = new Object[2];
                objArr2[0] = z ? "short" : "long";
                objArr2[1] = Integer.valueOf(i2);
                com.xiaomi.a.a.a.c.a(String.format("[HB] accumulate %s hb count(%s) and write to file. ", objArr2));
                (z ? this.f9144f : this.f9145g).set(0);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b(java.lang.String r10) {
        /*
            r9 = this;
            java.lang.String r0 = "WIFI-ID-UNKNOWN"
            boolean r0 = r0.equals(r10)
            if (r0 == 0) goto L16
            java.lang.String r10 = r9.f9141c
            if (r10 == 0) goto L15
            java.lang.String r0 = "W-"
            boolean r10 = r10.startsWith(r0)
            if (r10 == 0) goto L15
            goto L18
        L15:
            r10 = 0
        L16:
            r9.f9141c = r10
        L18:
            android.content.SharedPreferences r10 = r9.a
            java.lang.String r0 = r9.f9141c
            java.lang.String r0 = com.xiaomi.push.service.ck.a.a(r0)
            r1 = -1
            int r10 = r10.getInt(r0, r1)
            android.content.SharedPreferences r0 = r9.a
            java.lang.String r2 = r9.f9141c
            java.lang.String r2 = com.xiaomi.push.service.ck.a.b(r2)
            r3 = -1
            long r5 = r0.getLong(r2, r3)
            long r7 = java.lang.System.currentTimeMillis()
            if (r10 == r1) goto L75
            int r10 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r10 != 0) goto L56
            android.content.SharedPreferences r10 = r9.a
            android.content.SharedPreferences$Editor r10 = r10.edit()
            java.lang.String r0 = r9.f9141c
            java.lang.String r0 = com.xiaomi.push.service.ck.a.b(r0)
            long r2 = r9.j()
            long r7 = r7 + r2
            android.content.SharedPreferences$Editor r10 = r10.putLong(r0, r7)
        L52:
            r10.apply()
            goto L75
        L56:
            int r10 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r10 <= 0) goto L75
            android.content.SharedPreferences r10 = r9.a
            android.content.SharedPreferences$Editor r10 = r10.edit()
            java.lang.String r0 = r9.f9141c
            java.lang.String r0 = com.xiaomi.push.service.ck.a.a(r0)
            android.content.SharedPreferences$Editor r10 = r10.remove(r0)
            java.lang.String r0 = r9.f9141c
            java.lang.String r0 = com.xiaomi.push.service.ck.a.b(r0)
            android.content.SharedPreferences$Editor r10 = r10.remove(r0)
            goto L52
        L75:
            java.util.concurrent.atomic.AtomicInteger r10 = r9.b
            r0 = 0
            r10.getAndSet(r0)
            java.lang.String r10 = r9.f9141c
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            r2 = 1
            if (r10 != 0) goto L8e
            int r10 = r9.i()
            if (r10 == r1) goto L8b
            goto L8e
        L8b:
            r9.f9142d = r2
            goto L90
        L8e:
            r9.f9142d = r0
        L90:
            r10 = 2
            java.lang.Object[] r10 = new java.lang.Object[r10]
            java.lang.String r1 = r9.f9141c
            r10[r0] = r1
            boolean r0 = r9.f9142d
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r10[r2] = r0
            java.lang.String r0 = "[HB] network changed, netid:%s, %s"
            java.lang.String r10 = java.lang.String.format(r0, r10)
            com.xiaomi.a.a.a.c.a(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.ck.b(java.lang.String):void");
    }

    private void c(String str) {
        if (d(str)) {
            this.a.edit().putInt(a.a(str), 235000).apply();
            this.a.edit().putLong(a.b(this.f9141c), System.currentTimeMillis() + j()).apply();
        }
    }

    private boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("W-") || str.startsWith("M-");
    }

    private void e(String str) {
        String str2;
        String str3;
        if (n() && !TextUtils.isEmpty(str)) {
            if (str.startsWith("W-")) {
                str2 = ExifInterface.LONGITUDE_WEST;
            } else if (!str.startsWith("M-")) {
                return;
            } else {
                str2 = "M";
            }
            String valueOf = String.valueOf(235000);
            String valueOf2 = String.valueOf(System.currentTimeMillis() / 1000);
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(":::");
            sb.append(str2);
            sb.append(":::");
            sb.append(valueOf);
            sb.append(":::");
            sb.append(valueOf2);
            String string = this.a.getString(a.f(), null);
            if (TextUtils.isEmpty(string)) {
                str3 = sb.toString();
            } else {
                str3 = string + "###" + sb.toString();
            }
            this.a.edit().putString(a.f(), str3).apply();
        }
    }

    private long f() {
        return this.a.getLong(a.j(), -1L);
    }

    private boolean g() {
        return this.b.get() >= Math.max(ad.a(this.f9150l).a(gv.IntelligentHeartbeatNATCountInt.a(), 5), 3);
    }

    private boolean h() {
        return (TextUtils.isEmpty(this.f9141c) || !this.f9141c.startsWith("M-") || ad.a(this.f9150l).a(gv.IntelligentHeartbeatUseInMobileNetworkBoolean.a(), false)) ? false : true;
    }

    private int i() {
        if (TextUtils.isEmpty(this.f9141c)) {
            return -1;
        }
        try {
            return this.a.getInt(a.a(this.f9141c), -1);
        } catch (Throwable unused) {
            return -1;
        }
    }

    private long j() {
        return ad.a(this.f9150l).a(gv.ShortHeartbeatEffectivePeriodMsLong.a(), 777600000L);
    }

    private void k() {
        if (this.a.getBoolean(a.a(), false)) {
            return;
        }
        this.a.edit().putBoolean(a.a(), true).apply();
    }

    private void l() {
        int i2 = this.f9149k;
        String h2 = i2 != 0 ? i2 != 1 ? null : a.h() : a.g();
        if (TextUtils.isEmpty(h2)) {
            return;
        }
        if (this.a.getLong(a.i(), -1L) == -1) {
            this.f9146h = System.currentTimeMillis();
            this.a.edit().putLong(a.i(), this.f9146h).apply();
        }
        this.a.edit().putInt(h2, this.a.getInt(h2, 0) + 1).apply();
    }

    private void m() {
        int i2;
        String[] split;
        String[] split2;
        if (n()) {
            String string = this.a.getString(a.f(), null);
            char c2 = 1;
            char c3 = 0;
            if (!TextUtils.isEmpty(string) && (split = string.split("###")) != null) {
                int i3 = 0;
                while (i3 < split.length) {
                    if (!TextUtils.isEmpty(split[i3]) && (split2 = split[i3].split(":::")) != null && split2.length >= 4) {
                        String str = split2[c3];
                        String str2 = split2[c2];
                        String str3 = split2[2];
                        String str4 = split2[3];
                        HashMap hashMap = new HashMap();
                        hashMap.put("event", "change");
                        hashMap.put(com.baidu.mobads.sdk.internal.bc.f1474i, Build.MODEL);
                        hashMap.put(HiAnalyticsConstant.BI_KEY_NET_TYPE, str2);
                        hashMap.put("net_name", str);
                        hashMap.put(com.umeng.analytics.pro.am.aU, str3);
                        hashMap.put("timestamp", str4);
                        a("category_hb_change", null, hashMap);
                        com.xiaomi.a.a.a.c.a("[HB] report hb changed events.");
                    }
                    i3++;
                    c2 = 1;
                    c3 = 0;
                }
                this.a.edit().remove(a.f()).apply();
            }
            if (this.a.getBoolean(a.a(), false) && !this.a.getBoolean(a.b(), false)) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("event", "support");
                hashMap2.put(com.baidu.mobads.sdk.internal.bc.f1474i, Build.MODEL);
                hashMap2.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
                a("category_hb_change", null, hashMap2);
                com.xiaomi.a.a.a.c.a("[HB] report support wifi digest events.");
                this.a.edit().putBoolean(a.b(), true).apply();
            }
            if (p()) {
                int i4 = this.a.getInt(a.d(), 0);
                int i5 = this.a.getInt(a.e(), 0);
                if (i4 > 0 || i5 > 0) {
                    long j2 = this.a.getLong(a.c(), -1L);
                    String valueOf = String.valueOf(235000);
                    String valueOf2 = String.valueOf(j2);
                    String valueOf3 = String.valueOf(System.currentTimeMillis());
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(com.umeng.analytics.pro.am.aU, valueOf);
                        jSONObject.put("c_short", String.valueOf(i4));
                        jSONObject.put("c_long", String.valueOf(i5));
                        jSONObject.put("count", String.valueOf(i4 + i5));
                        jSONObject.put(com.umeng.analytics.pro.d.p, valueOf2);
                        jSONObject.put(com.umeng.analytics.pro.d.q, valueOf3);
                        String jSONObject2 = jSONObject.toString();
                        HashMap hashMap3 = new HashMap();
                        hashMap3.put("event", "long_and_short_hb_count");
                        a("category_hb_count", jSONObject2, hashMap3);
                        com.xiaomi.a.a.a.c.a("[HB] report short/long hb count events.");
                    } catch (Throwable unused) {
                    }
                }
                this.a.edit().putInt(a.d(), 0).putInt(a.e(), 0).putLong(a.c(), System.currentTimeMillis()).apply();
            }
            if (q()) {
                String valueOf4 = String.valueOf(this.f9146h);
                String valueOf5 = String.valueOf(System.currentTimeMillis());
                int i6 = this.a.getInt(a.g(), 0);
                if (i6 > 0) {
                    try {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put(HiAnalyticsConstant.BI_KEY_NET_TYPE, "M");
                        jSONObject3.put("ptc", i6);
                        jSONObject3.put(com.umeng.analytics.pro.d.p, valueOf4);
                        jSONObject3.put(com.umeng.analytics.pro.d.q, valueOf5);
                        String jSONObject4 = jSONObject3.toString();
                        HashMap hashMap4 = new HashMap();
                        hashMap4.put("event", "ptc_event");
                        a("category_lc_ptc", jSONObject4, hashMap4);
                        com.xiaomi.a.a.a.c.a("[HB] report ping timeout count events of mobile network.");
                        this.a.edit().putInt(a.g(), 0).apply();
                    } catch (Throwable unused2) {
                        i2 = 0;
                        this.a.edit().putInt(a.g(), 0).apply();
                    }
                }
                i2 = 0;
                int i7 = this.a.getInt(a.h(), i2);
                if (i7 > 0) {
                    try {
                        JSONObject jSONObject5 = new JSONObject();
                        jSONObject5.put(HiAnalyticsConstant.BI_KEY_NET_TYPE, ExifInterface.LONGITUDE_WEST);
                        jSONObject5.put("ptc", i7);
                        jSONObject5.put(com.umeng.analytics.pro.d.p, valueOf4);
                        jSONObject5.put(com.umeng.analytics.pro.d.q, valueOf5);
                        String jSONObject6 = jSONObject5.toString();
                        HashMap hashMap5 = new HashMap();
                        hashMap5.put("event", "ptc_event");
                        a("category_lc_ptc", jSONObject6, hashMap5);
                        com.xiaomi.a.a.a.c.a("[HB] report ping timeout count events of wifi network.");
                    } catch (Throwable unused3) {
                    }
                    this.a.edit().putInt(a.h(), 0).apply();
                }
                this.f9146h = System.currentTimeMillis();
                this.a.edit().putLong(a.i(), this.f9146h).apply();
            }
        }
    }

    private boolean n() {
        return o() && ad.a(this.f9150l).a(gv.IntelligentHeartbeatDataCollectSwitchBoolean.a(), true) && jg.China.name().equals(b.a(this.f9150l).a());
    }

    private boolean o() {
        return this.f9148j && (this.f9147i || ((f() > System.currentTimeMillis() ? 1 : (f() == System.currentTimeMillis() ? 0 : -1)) >= 0));
    }

    private boolean p() {
        long j2 = this.a.getLong(a.c(), -1L);
        if (j2 == -1) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        return j2 > currentTimeMillis || currentTimeMillis - j2 >= 259200000;
    }

    private boolean q() {
        if (this.f9146h == -1) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = this.f9146h;
        return j2 > currentTimeMillis || currentTimeMillis - j2 >= 259200000;
    }

    public void a() {
    }

    public void a(int i2) {
        this.a.edit().putLong(a.j(), System.currentTimeMillis() + (i2 * 1000)).apply();
    }

    public synchronized void a(NetworkInfo networkInfo) {
        if (o()) {
            String str = null;
            if (networkInfo == null) {
                b(null);
            } else if (networkInfo.getType() == 0) {
                String subtypeName = networkInfo.getSubtypeName();
                if (!TextUtils.isEmpty(subtypeName) && !GrsBaseInfo.CountryCodeSource.UNKNOWN.equalsIgnoreCase(subtypeName)) {
                    str = "M-" + subtypeName;
                }
                b(str);
                this.f9149k = 0;
            } else {
                if (networkInfo.getType() != 1 && networkInfo.getType() != 6) {
                    b(null);
                }
                b("WIFI-ID-UNKNOWN");
                this.f9149k = 1;
            }
            this.f9149k = -1;
        }
    }

    public synchronized void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            k();
        }
        if (o() && !TextUtils.isEmpty(str)) {
            b("W-" + str);
        }
    }

    public void b() {
        if (o()) {
            l();
            if (this.f9142d && !TextUtils.isEmpty(this.f9141c) && this.f9141c.equals(this.f9143e)) {
                this.b.getAndIncrement();
                com.xiaomi.a.a.a.c.a("[HB] ping timeout count:" + this.b);
                if (g()) {
                    com.xiaomi.a.a.a.c.a("[HB] change hb interval for net:" + this.f9141c);
                    c(this.f9141c);
                    this.f9142d = false;
                    this.b.getAndSet(0);
                    e(this.f9141c);
                }
            }
        }
    }

    public void c() {
        if (o()) {
            this.f9143e = this.f9141c;
        }
    }

    public void d() {
        if (o()) {
            m();
            if (this.f9142d) {
                this.b.getAndSet(0);
            }
        }
    }

    public long e() {
        int i2;
        long c2 = fi.c();
        if (this.f9148j && !h() && ((ad.a(this.f9150l).a(gv.IntelligentHeartbeatSwitchBoolean.a(), true) || f() >= System.currentTimeMillis()) && (i2 = i()) != -1)) {
            c2 = i2;
        }
        if (!TextUtils.isEmpty(this.f9141c) && !"WIFI-ID-UNKNOWN".equals(this.f9141c) && this.f9149k == 1) {
            a(c2 < 300000);
        }
        com.xiaomi.a.a.a.c.a("[HB] ping interval:" + c2);
        return c2;
    }
}
