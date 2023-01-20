package com.baidu.mobads.sdk.internal;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class j {
    public static JSONArray a(double[] dArr) {
        JSONArray jSONArray = null;
        if (dArr == null) {
            return null;
        }
        try {
            JSONArray jSONArray2 = new JSONArray();
            for (double d2 : dArr) {
                try {
                    jSONArray2.put(d2);
                } catch (Exception e2) {
                    e = e2;
                    jSONArray = jSONArray2;
                    bj.a().a(e);
                    return jSONArray;
                }
            }
            return jSONArray2;
        } catch (Exception e3) {
            e = e3;
        }
    }

    public static JSONArray a(List<String[]> list) {
        JSONArray jSONArray = new JSONArray();
        for (int i2 = 0; i2 < list.size(); i2++) {
            try {
                JSONArray jSONArray2 = new JSONArray();
                for (int i3 = 0; i3 < list.get(i2).length; i3++) {
                    jSONArray2.put(list.get(i2)[i3]);
                }
                jSONArray.put(jSONArray2);
            } catch (Exception e2) {
                bj.a().a(e2);
            }
        }
        return jSONArray;
    }

    public static HashMap<String, String> a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.optString(next));
            }
        } catch (Exception unused) {
            bj.a().a("json2HashMap error");
        }
        return hashMap;
    }

    public static JSONObject a(HashMap<String, Object> hashMap) {
        if (hashMap == null || hashMap.isEmpty()) {
            return null;
        }
        try {
            return new JSONObject(hashMap);
        } catch (Exception unused) {
            bj.a().a("hashMap2Json error");
            return null;
        }
    }

    public static JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject2 != null && jSONObject2.length() > 0) {
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                jSONObject.put(next, jSONObject2.opt(next));
            }
        }
        return jSONObject;
    }

    public static Object a(JSONObject jSONObject, String str) {
        return (jSONObject != null && jSONObject.has(str)) ? jSONObject.opt(str) : "";
    }

    @TargetApi(8)
    public static Bitmap a(String str) {
        try {
            byte[] decode = Base64.decode(str, 0);
            return BitmapFactory.decodeByteArray(decode, 0, decode.length);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
