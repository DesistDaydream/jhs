package com.tencent.android.tpush.stat.b;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.dataacquisition.CustomDeviceInfos;
import java.util.Random;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class e {
    public static String a(Context context) {
        String a = d.a(context, "xg.mta.ui", "");
        if (TextUtils.isEmpty(a)) {
            a = CustomDeviceInfos.getFacilityIdentity(context);
        }
        if (TextUtils.isEmpty(a)) {
            a = Integer.toString(new Random().nextInt(Integer.MAX_VALUE));
        }
        d.b(context, "xg.mta.ui", a);
        return a;
    }

    public static Context b(Context context) {
        return (context == null || context.getApplicationContext() == null) ? context : context.getApplicationContext();
    }

    public static void a(JSONObject jSONObject, String str, String str2) {
        if (str2 != null) {
            try {
                if (str2.length() > 0) {
                    jSONObject.put(str, str2);
                }
            } catch (Throwable th) {
                TLogger.e("XgStat", "jsonPut error", th);
            }
        }
    }
}
