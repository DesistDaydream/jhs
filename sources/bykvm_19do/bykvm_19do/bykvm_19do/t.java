package bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.Context;
import android.text.TextUtils;
import com.effective.android.panel.Constants;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.tencent.android.tpns.mqtt.MqttTopic;
import com.umeng.analytics.pro.am;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class t {
    private static final String[] a = {"ab_version", am.F, am.N, "os_api", "resolution", "google_aid", "build_serial", am.P, "install_id", "package", "app_version", "device_model", "udid", "density_dpi", "aliyun_uuid", "mcc_mnc", "sim_region", "ab_client", "ab_group", "ab_feature", "device_id", "openudid", "clientudid", "aid"};
    private static final String[] b = {"ab_version", am.F, am.N, "os_api", "resolution", "google_aid", "build_serial", am.P, "iid", "app_name", NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, am.ai, "uuid", "dpi", "aliyun_uuid", "mcc_mnc", "sim_region", "ab_client", "ab_group", "ab_feature", "device_id", "openudid", "clientudid", "aid"};

    public static String a(Context context, JSONObject jSONObject, String str, boolean z, b bVar) {
        HashMap<String, String> a2;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        HashMap hashMap = new HashMap(a.length + 10);
        int i2 = 0;
        while (true) {
            String[] strArr = a;
            if (i2 >= strArr.length) {
                break;
            }
            String optString = jSONObject.optString(strArr[i2], null);
            if (!TextUtils.isEmpty(optString)) {
                hashMap.put(b[i2], optString);
            }
            i2++;
        }
        if (bVar != null) {
            try {
                a2 = bVar.a(context);
            } catch (Exception e2) {
                l0.a(e2);
            }
        } else {
            a2 = null;
        }
        if (m0.b(context) && a2 != null) {
            hashMap.putAll(a2);
        }
        try {
            HashMap<String, String> a3 = a.i() == null ? null : a.i().a();
            if (a3 != null) {
                hashMap.putAll(a3);
            }
        } catch (Exception e3) {
            l0.a(e3);
        }
        if (a.f65f.size() > 0) {
            hashMap.putAll(a.f65f);
        }
        if (z) {
            hashMap.put("ssmix", am.av);
        }
        String b2 = h0.b(context);
        if (!TextUtils.isEmpty(b2)) {
            hashMap.put("ac", b2);
        }
        String str2 = (String) a.a("tweaked_channel", "");
        if (TextUtils.isEmpty(str2)) {
            str2 = (String) a.a("channel", "");
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("channel", str2);
        }
        String optString2 = jSONObject.optString("os_version", null);
        if (optString2 != null && optString2.length() > 10) {
            optString2 = optString2.substring(0, 10);
        }
        hashMap.put("os_version", optString2);
        hashMap.put("_rticket", String.valueOf(System.currentTimeMillis()));
        hashMap.put("device_platform", Constants.ANDROID);
        int intValue = ((Integer) a.a("version_code", -1)).intValue();
        if (intValue != -1) {
            hashMap.put("version_code", String.valueOf(intValue));
        }
        int intValue2 = ((Integer) a.a("manifest_version_code", -1)).intValue();
        if (intValue2 != -1) {
            hashMap.put("manifest_version_code", String.valueOf(intValue2));
        }
        int intValue3 = ((Integer) a.a("update_version_code", -1)).intValue();
        if (intValue3 != -1) {
            hashMap.put("update_version_code", String.valueOf(intValue3));
        }
        String a4 = s0.a(jSONObject.optJSONObject("oaid"));
        if (!TextUtils.isEmpty(a4)) {
            hashMap.put("oaid", a4);
        }
        String optString3 = jSONObject.optString("cdid");
        if (!TextUtils.isEmpty(optString3)) {
            hashMap.put("cdid", optString3);
        }
        if (!str.endsWith(MqttTopic.TOPIC_LEVEL_SEPARATOR)) {
            str = str + MqttTopic.TOPIC_LEVEL_SEPARATOR;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        char c2 = k.b.a.a.o.e.a;
        if (str.indexOf(63) >= 0) {
            c2 = h.t2.y.f15690c;
        }
        sb.append(c2);
        return m0.a(sb.toString(), hashMap, "UTF-8");
    }

    public static String[] a(v1 v1Var, Context context, JSONObject jSONObject) {
        String[] d2 = v1Var.f().d();
        String[] strArr = new String[d2.length];
        String str = a.h() ? "?tt_data=a" : "?";
        for (int i2 = 0; i2 < d2.length; i2++) {
            strArr[i2] = a(context, jSONObject, d2[i2] + str, true, a.j());
            strArr[i2] = s.a(strArr[i2], s.f159d);
        }
        return strArr;
    }
}
