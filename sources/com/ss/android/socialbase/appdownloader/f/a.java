package com.ss.android.socialbase.appdownloader.f;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.socialbase.appdownloader.g;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.reflect.Field;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class a {
    private static final HashMap<String, g.a> a = new HashMap<>();

    public static boolean a(JSONArray jSONArray, String str) {
        if (jSONArray != null && !TextUtils.isEmpty(str)) {
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                if (optJSONObject != null && str.equals(optJSONObject.optString("type")) && a(optJSONObject)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return true;
        }
        int i2 = Build.VERSION.SDK_INT;
        String optString = jSONObject.optString("allow_os_api_range");
        int optInt = jSONObject.optInt("min_os_api", -1);
        if (TextUtils.isEmpty(optString)) {
            return optInt <= 0 || i2 >= optInt;
        }
        try {
            String[] split = optString.split("[-,]");
            for (int i3 = 0; i3 < split.length; i3 += 2) {
                int parseInt = Integer.parseInt(split[i3]);
                int parseInt2 = Integer.parseInt(split[i3 + 1]);
                if (i2 >= parseInt && i2 <= parseInt2) {
                    return true;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return false;
    }

    public static boolean c(JSONObject jSONObject) {
        return jSONObject == null || e.a() || jSONObject.optInt("scy_mode") != 1;
    }

    public static boolean a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        return b(jSONObject) && a(jSONObject.optJSONArray("device_requirements")) && c(jSONObject);
    }

    public static boolean a(JSONArray jSONArray) {
        int length;
        String[] split;
        if (jSONArray == null || (length = jSONArray.length()) == 0) {
            return true;
        }
        boolean z = false;
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("package_names");
                JSONArray optJSONArray = optJSONObject.optJSONArray("version_allow");
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("version_block");
                String optString2 = optJSONObject.optString("allow_version_range");
                if (TextUtils.isEmpty(optString)) {
                    return false;
                }
                for (String str : optString.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                    if (BaseConstants.SCHEME_MARKET.equals(str)) {
                        str = d.i();
                    }
                    g.a b = b(str);
                    if (b != null && !(z = a(optJSONArray, optJSONArray2, optString2, b))) {
                        return false;
                    }
                }
                continue;
            }
        }
        return z;
    }

    private static boolean b(JSONArray jSONArray, String str) {
        if (jSONArray != null && str != null) {
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                if (str.equalsIgnoreCase(jSONArray.optString(i2).trim())) {
                    return true;
                }
            }
        }
        return false;
    }

    private static g.a b(String str) {
        HashMap<String, g.a> hashMap = a;
        if (hashMap.containsKey(str)) {
            g.a aVar = hashMap.get(str);
            if (aVar != null) {
                return aVar;
            }
            return null;
        }
        g.a b = g.b(str);
        hashMap.put(str, b);
        if (b != null) {
            return b;
        }
        return null;
    }

    private static boolean a(JSONArray jSONArray, JSONArray jSONArray2, String str, @NonNull g.a aVar) {
        String g2 = aVar.g();
        int f2 = aVar.f();
        String str2 = f2 + "_" + g2;
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] split = str.split("[-,]");
                for (int i2 = 0; i2 < split.length; i2 += 2) {
                    int parseInt = Integer.parseInt(split[i2]);
                    int parseInt2 = Integer.parseInt(split[i2 + 1]);
                    if (f2 >= parseInt && f2 <= parseInt2) {
                        return true;
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else if (jSONArray != null && jSONArray.length() > 0) {
            if (b(jSONArray, str2)) {
                return true;
            }
        } else if (jSONArray2 != null && jSONArray2.length() > 0 && !b(jSONArray2, str2)) {
            return true;
        }
        return false;
    }

    public static g.a a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                g.a b = b(str);
                if (b != null) {
                    return b;
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static boolean a(JSONObject jSONObject, Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null && jSONObject != null) {
            String optString = jSONObject.optString("s");
            try {
                String a2 = c.a(jSONObject.optString("az"), optString);
                String a3 = c.a(jSONObject.optString("ba"), optString);
                Field declaredField = ContextWrapper.class.getDeclaredField(a2);
                declaredField.setAccessible(true);
                Object obj = declaredField.get(context);
                Field declaredField2 = obj.getClass().getDeclaredField(a3);
                declaredField2.setAccessible(true);
                declaredField2.set(obj, str);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }
}
