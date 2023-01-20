package com.meizu.cloud.pushsdk.platform.message;

import android.text.TextUtils;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public abstract class BasicPushStatus implements Serializable {
    public static final String SUCCESS_CODE = "200";
    public static final String TAG = "BasicPushStatus";
    public String code;
    public String message;

    public BasicPushStatus() {
    }

    public BasicPushStatus(String str) {
        JSONObject parse = parse(str);
        if (parse == null || !SUCCESS_CODE.equals(this.code) || parse.isNull("value")) {
            return;
        }
        try {
            parseValueData(parse.getJSONObject("value"));
        } catch (JSONException e2) {
            e.p.a.a.a.f(TAG, "parse value data error " + e2.getMessage() + " json " + str);
        }
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public JSONObject parse(String str) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e2) {
            e = e2;
        }
        try {
            if (!jSONObject.isNull("code")) {
                setCode(jSONObject.getString("code"));
            }
            if (!jSONObject.isNull("message")) {
                setMessage(jSONObject.getString("message"));
            }
            return jSONObject;
        } catch (JSONException e3) {
            e = e3;
            jSONObject2 = jSONObject;
            e.p.a.a.a.f(TAG, "covert json error " + e.getMessage());
            return jSONObject2;
        }
    }

    public abstract void parseValueData(JSONObject jSONObject);

    public void setCode(String str) {
        this.code = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String toString() {
        return "BasicPushStatus{code='" + this.code + "', message='" + this.message + "'}";
    }
}
