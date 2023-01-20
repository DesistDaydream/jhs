package com.huawei.hms.framework.network.grs.g;

import android.text.TextUtils;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class i {
    public static String a(String str, String str2) {
        return !str.equals(str2) ? b(str, str2) : str;
    }

    private static String b(String str, String str2) {
        HashSet<String> hashSet = new HashSet();
        if (!TextUtils.isEmpty(str)) {
            JSONArray jSONArray = new JSONObject(str).getJSONArray("services");
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                hashSet.add(jSONArray.getString(i2));
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            JSONArray jSONArray2 = new JSONObject(str2).getJSONArray("services");
            for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                hashSet.add(jSONArray2.getString(i3));
            }
        }
        if (hashSet.isEmpty()) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray3 = new JSONArray();
        for (String str3 : hashSet) {
            jSONArray3.put(str3);
        }
        jSONObject.put("services", jSONArray3);
        return jSONObject.toString();
    }
}
