package com.huawei.agconnect.config.impl;

import android.util.Log;
import com.tencent.android.tpns.mqtt.MqttTopic;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class h implements d {
    private final JSONObject a;

    public h(InputStream inputStream) {
        this.a = a(inputStream);
    }

    public h(InputStream inputStream, String str) {
        this.a = a(inputStream);
        a(str);
    }

    private JSONObject a(InputStream inputStream) {
        String str;
        if (inputStream != null) {
            try {
                return new JSONObject(Utils.toString(inputStream, "UTF-8"));
            } catch (IOException unused) {
                str = "IOException when reading the 'Config' from InputStream.";
                Log.e("InputStreamReader", str);
                return new JSONObject();
            } catch (JSONException unused2) {
                str = "JSONException when reading the 'Config' from InputStream.";
                Log.e("InputStreamReader", str);
                return new JSONObject();
            }
        }
        return new JSONObject();
    }

    private void a(String str) {
        try {
            JSONObject b = b(str);
            if (b == null) {
                return;
            }
            String a = a("/configuration_version", "");
            BigDecimal bigDecimal = new BigDecimal("0.0");
            try {
                bigDecimal = BigDecimal.valueOf(Double.parseDouble(a));
            } catch (NumberFormatException unused) {
                Log.d("InputStreamReader", "configuration_version to double error");
            }
            if (bigDecimal.compareTo(new BigDecimal("2.0")) == 0) {
                this.a.getJSONObject("client").put("app_id", b.getString("app_id"));
            } else if (bigDecimal.compareTo(new BigDecimal("3.0")) >= 0) {
                Iterator<String> keys = b.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (!"package_name".equals(next)) {
                        a(next, b.get(next), this.a);
                    }
                }
            }
        } catch (JSONException unused2) {
            Log.d("InputStreamReader", "JSONException when reading the 'appInfos' from InputStream.");
        }
    }

    private void a(String str, Object obj, JSONObject jSONObject) throws JSONException {
        if (str == null || obj == null || jSONObject == null) {
            return;
        }
        if (!(obj instanceof JSONObject)) {
            jSONObject.put(str, obj);
            return;
        }
        JSONObject jSONObject2 = (JSONObject) obj;
        Iterator<String> keys = jSONObject2.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            a(next, jSONObject2.get(next), jSONObject.getJSONObject(str));
        }
    }

    private JSONObject b(String str) throws JSONException {
        JSONArray jSONArray = this.a.getJSONArray("appInfos");
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i2);
            if (jSONObject.getString("package_name").equals(str)) {
                return jSONObject;
            }
        }
        return null;
    }

    @Override // com.huawei.agconnect.config.impl.d
    public String a(String str, String str2) {
        if (str.endsWith(MqttTopic.TOPIC_LEVEL_SEPARATOR)) {
            return str2;
        }
        String[] split = str.split(MqttTopic.TOPIC_LEVEL_SEPARATOR);
        try {
            JSONObject jSONObject = this.a;
            for (int i2 = 1; i2 < split.length; i2++) {
                if (i2 == split.length - 1) {
                    str = jSONObject.get(split[i2]).toString();
                    return str;
                }
                jSONObject = jSONObject.getJSONObject(split[i2]);
            }
        } catch (JSONException unused) {
            Log.w("InputStreamReader", "JSONException when reading 'path': " + str);
        }
        return str2;
    }

    public String toString() {
        return "InputStreamReader{config=" + this.a.toString().hashCode() + '}';
    }
}
