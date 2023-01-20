package bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_for12;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.annotation.Nullable;
import bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.j;
import bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.i;
import com.ss.android.download.api.constant.BaseConstants;
import com.tencent.android.tpush.XGPushNotificationBuilder;
import com.umeng.analytics.pro.am;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f1179c = {"version_code", "manifest_version_code", "aid", "update_version_code"};
    private Context a;
    private JSONObject b = new JSONObject();

    public b(Context context) {
        this.a = context;
    }

    public static b a(Context context) {
        b bVar = new b(context);
        JSONObject a = bVar.a();
        bVar.a(a);
        bVar.d(a);
        bVar.e(a);
        bVar.g(a);
        bVar.f(a);
        bVar.b(a);
        bVar.c(a);
        return bVar;
    }

    @SuppressLint({"MissingPermission"})
    private void a(JSONObject jSONObject) {
        int i2;
        try {
            ApplicationInfo applicationInfo = this.a.getPackageManager().getPackageInfo(this.a.getPackageName(), 0).applicationInfo;
            if (applicationInfo != null && (i2 = applicationInfo.labelRes) > 0) {
                jSONObject.put(am.s, this.a.getString(i2));
            }
            jSONObject.put("sdk_version", 2010056);
            jSONObject.put("sdk_version_name", "2.1.0-alpha.36");
            jSONObject.put(am.x, "Android");
            jSONObject.put("os_version", c());
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("device_model", Build.MODEL);
            jSONObject.put(am.F, Build.BRAND);
            jSONObject.put(am.H, Build.MANUFACTURER);
            jSONObject.put("cpu_abi", b());
        } catch (Exception unused) {
        }
    }

    private String b() {
        try {
            StringBuilder sb = new StringBuilder();
            if (Build.VERSION.SDK_INT >= 21 && Build.SUPPORTED_ABIS.length > 0) {
                int i2 = 0;
                while (true) {
                    String[] strArr = Build.SUPPORTED_ABIS;
                    if (i2 >= strArr.length) {
                        break;
                    }
                    sb.append(strArr[i2]);
                    if (i2 != strArr.length - 1) {
                        sb.append(", ");
                    }
                    i2++;
                }
            } else {
                sb = new StringBuilder(Build.CPU_ABI);
            }
            return TextUtils.isEmpty(sb.toString()) ? "unknown" : sb.toString();
        } catch (Exception e2) {
            j.b(e2);
            return "unknown";
        }
    }

    private void b(JSONObject jSONObject) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) this.a.getSystemService("phone");
            if (telephonyManager != null) {
                String networkOperatorName = telephonyManager.getNetworkOperatorName();
                if (!TextUtils.isEmpty(networkOperatorName)) {
                    jSONObject.put(am.P, networkOperatorName);
                }
                String networkOperator = telephonyManager.getNetworkOperator();
                if (TextUtils.isEmpty(networkOperator)) {
                    return;
                }
                jSONObject.put("mcc_mnc", networkOperator);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private String c() {
        String str = Build.VERSION.RELEASE;
        if (str.contains(".")) {
            return str;
        }
        return str + ".0";
    }

    private void c(JSONObject jSONObject) {
        Map<String, Object> b;
        Object obj;
        bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_new1.a e2 = i.e();
        if (e2 == null || jSONObject == null || (b = e2.b()) == null) {
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            for (String str : b.keySet()) {
                if (!TextUtils.isEmpty(str) && (obj = b.get(str)) != null) {
                    jSONObject2.put(str, obj);
                }
            }
            jSONObject.put(XGPushNotificationBuilder.CUSTOM_NOTIFICATION_BUILDER_TYPE, jSONObject2);
        } catch (Exception e3) {
            j.b(e3);
        }
    }

    private void d(JSONObject jSONObject) {
        try {
            DisplayMetrics displayMetrics = this.a.getResources().getDisplayMetrics();
            int i2 = displayMetrics.densityDpi;
            String str = i2 != 120 ? i2 != 240 ? i2 != 320 ? "mdpi" : "xhdpi" : "hdpi" : "ldpi";
            jSONObject.put("density_dpi", i2);
            jSONObject.put("display_density", str);
            jSONObject.put("resolution", displayMetrics.heightPixels + "x" + displayMetrics.widthPixels);
        } catch (Exception unused) {
        }
    }

    private void e(JSONObject jSONObject) {
        try {
            String language = this.a.getResources().getConfiguration().locale.getLanguage();
            if (!TextUtils.isEmpty(language)) {
                jSONObject.put(am.N, language);
            }
            String country = Locale.getDefault().getCountry();
            if (!TextUtils.isEmpty(country)) {
                jSONObject.put("region", country);
            }
            int rawOffset = TimeZone.getDefault().getRawOffset() / BaseConstants.Time.HOUR;
            if (rawOffset < -12) {
                rawOffset = -12;
            }
            if (rawOffset > 12) {
                rawOffset = 12;
            }
            jSONObject.put(am.M, rawOffset);
        } catch (Exception unused) {
        }
    }

    private void f(JSONObject jSONObject) {
        try {
            jSONObject.put(am.Q, bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.i.a(this.a));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0040 A[Catch: all -> 0x0052, TryCatch #0 {all -> 0x0052, blocks: (B:3:0x0005, B:6:0x000d, B:16:0x0035, B:18:0x0040, B:19:0x0049, B:7:0x0011, B:10:0x001a, B:12:0x0024, B:13:0x0029, B:15:0x002f), top: B:22:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void g(org.json.JSONObject r4) {
        /*
            r3 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            boolean r1 = bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.c.d()     // Catch: java.lang.Throwable -> L52
            if (r1 == 0) goto L11
            java.lang.String r1 = "MIUI-"
        Ld:
            r0.append(r1)     // Catch: java.lang.Throwable -> L52
            goto L35
        L11:
            boolean r1 = bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.c.b()     // Catch: java.lang.Throwable -> L52
            if (r1 == 0) goto L1a
            java.lang.String r1 = "FLYME-"
            goto Ld
        L1a:
            java.lang.String r1 = bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.c.a()     // Catch: java.lang.Throwable -> L52
            boolean r2 = bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.c.b(r1)     // Catch: java.lang.Throwable -> L52
            if (r2 == 0) goto L29
            java.lang.String r2 = "EMUI-"
            r0.append(r2)     // Catch: java.lang.Throwable -> L52
        L29:
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L52
            if (r2 != 0) goto L35
            r0.append(r1)     // Catch: java.lang.Throwable -> L52
            java.lang.String r1 = "-"
            goto Ld
        L35:
            java.lang.String r1 = android.os.Build.VERSION.INCREMENTAL     // Catch: java.lang.Throwable -> L52
            r0.append(r1)     // Catch: java.lang.Throwable -> L52
            int r1 = r0.length()     // Catch: java.lang.Throwable -> L52
            if (r1 <= 0) goto L49
            java.lang.String r1 = "rom"
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L52
            r4.put(r1, r0)     // Catch: java.lang.Throwable -> L52
        L49:
            java.lang.String r0 = "rom_version"
            java.lang.String r1 = bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.l.i()     // Catch: java.lang.Throwable -> L52
            r4.put(r0, r1)     // Catch: java.lang.Throwable -> L52
        L52:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_for12.b.g(org.json.JSONObject):void");
    }

    public JSONObject a() {
        return this.b;
    }

    public JSONObject a(String str) {
        try {
            this.b.put("device_id", str);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return this.b;
    }

    public JSONObject a(@Nullable Map<String, Object> map) {
        String[] strArr;
        if (map == null) {
            return this.b;
        }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (!this.b.has(entry.getKey())) {
                this.b.put(entry.getKey(), entry.getValue());
            }
        }
        for (String str : f1179c) {
            if (map.containsKey(str)) {
                try {
                    this.b.put(str, Integer.parseInt((String) map.get(str)));
                } catch (Exception unused) {
                    this.b.put(str, map.get(str));
                }
            }
        }
        if (map.containsKey("version_code") && !map.containsKey("manifest_version_code")) {
            this.b.put("manifest_version_code", Integer.parseInt((String) map.get("version_code")));
        }
        if (map.containsKey("iid")) {
            this.b.put("udid", map.get("iid"));
            this.b.remove("iid");
        }
        return this.b;
    }

    public JSONObject b(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                this.b.put("user_id", str);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return this.b;
    }
}
