package com.moor.imkf.lib.utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class MoorNullUtil {
    public static JSONArray checkJsonArrayNull(JSONObject jSONObject, String str) {
        try {
            return jSONObject.getJSONArray(str);
        } catch (JSONException unused) {
            return new JSONArray();
        }
    }

    public static JSONObject checkJsonObjectNull(JSONObject jSONObject, String str) {
        try {
            return jSONObject.getJSONObject(str);
        } catch (JSONException unused) {
            return new JSONObject();
        }
    }

    public static String checkJsonStringNull(JSONObject jSONObject, String str) {
        try {
            return jSONObject.getString(str);
        } catch (JSONException unused) {
            return "";
        }
    }

    public static boolean checkNULL(String str) {
        return (str == null || "".equals(str)) ? false : true;
    }

    public static String checkNull(String str) {
        return (str == null || "".equals(str)) ? "" : str;
    }

    public static Integer checkNull(Integer num) {
        if (num != null) {
            return num;
        }
        return -1;
    }

    public static long checkNull(Long l2) {
        if (l2 != null) {
            return l2.longValue();
        }
        return -1L;
    }
}
