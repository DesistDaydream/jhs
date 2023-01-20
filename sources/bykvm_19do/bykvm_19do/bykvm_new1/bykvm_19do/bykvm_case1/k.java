package bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1;

import android.text.TextUtils;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class k {
    public static String a(String str) {
        Map<String, Object> d2;
        if (bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.i.e() != null && (d2 = bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.i.e().d()) != null) {
            Object obj = d2.get(str);
            if (obj instanceof String) {
                return (String) obj;
            }
        }
        return null;
    }

    public static void a(bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_for12.a aVar, bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_for12.b bVar, bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.c cVar) {
        if (aVar == null || aVar.a() == null || cVar == null) {
            return;
        }
        JSONObject a = aVar.a();
        long optLong = a.optLong("crash_time");
        int b = b(a("aid"));
        String a2 = bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.i.j().a();
        if (optLong <= 0 || b <= 0 || TextUtils.isEmpty(a2) || "0".equals(a2) || TextUtils.isEmpty(cVar.a())) {
            return;
        }
        try {
            String str = "android_" + b + "_" + a2 + "_" + optLong + "_" + cVar;
            if (bVar == null || (a = bVar.a()) != null) {
                a.put("unique_key", str);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static int b(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e2) {
                j.b(e2);
            }
        }
        return 0;
    }
}
