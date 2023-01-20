package cn.thinkingdata.android.utils;

import android.text.TextUtils;
import h.k2.v.n;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class g {
    private static final Pattern a = Pattern.compile("^[a-zA-Z][a-zA-Z\\d_]{0,49}$", 2);
    private static final ArrayList<String> b = new a();

    /* loaded from: classes.dex */
    public static class a extends ArrayList {
        public a() {
            add("#bundle_id");
            add("#duration");
        }
    }

    public static boolean a(String str) {
        return str == null || !a.matcher(str).matches();
    }

    public static boolean b(JSONObject jSONObject) {
        if (jSONObject == null || !TDLog.mEnableLog) {
            return true;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (TextUtils.isEmpty(next)) {
                TDLog.d("ThinkingAnalytics.PropertyUtils", "Empty property name is not allowed.");
            }
            if (!a.matcher(next).matches() && !b.contains(next)) {
                TDLog.d("ThinkingAnalytics.PropertyUtils", "Property name[" + next + "] is not valid. The property KEY must be string that starts with English letter, and contains letter, number, and '_'. The max length of the property KEY is 50. ");
            }
            try {
                Object obj = jSONObject.get(next);
                if (!(obj instanceof String) && !(obj instanceof Number) && !(obj instanceof Boolean) && !(obj instanceof Date) && !(obj instanceof JSONArray) && !(obj instanceof JSONObject)) {
                    TDLog.d("ThinkingAnalytics.PropertyUtils", "Property value must be type String, Number, Boolean, Date, JSONObject or JSONArray");
                }
                if (obj instanceof Number) {
                    double doubleValue = ((Number) obj).doubleValue();
                    if (doubleValue > 9.999999999999998E12d || doubleValue < -9.999999999999998E12d) {
                        TDLog.d("ThinkingAnalytics.PropertyUtils", "The number value [" + obj + "] is invalid.");
                    }
                }
            } catch (JSONException e2) {
                TDLog.d("ThinkingAnalytics.PropertyUtils", "Unexpected parameters." + e2);
                return false;
            }
        }
        return true;
    }

    public static byte[] c(String str, int i2) {
        int i3;
        int i4;
        byte[] bytes = str.getBytes("UTF-8");
        if (bytes.length <= i2) {
            return bytes;
        }
        if ((bytes[i2] & n.a) == 0) {
            return Arrays.copyOf(bytes, i2);
        }
        int i5 = 0;
        while (true) {
            i3 = i2 - i5;
            i4 = i3 - 1;
            if ((bytes[i4] & n.a) <= 0 || (bytes[i4] & 64) != 0) {
                break;
            }
            i5++;
        }
        return (bytes[i4] & n.a) > 0 ? Arrays.copyOf(bytes, i4) : Arrays.copyOf(bytes, i3);
    }
}
