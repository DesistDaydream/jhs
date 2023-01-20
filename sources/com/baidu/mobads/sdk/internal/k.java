package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import com.baidu.mobads.sdk.api.CpuChannelResponse;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class k {
    private int a;
    private String b;

    public static List<CpuChannelResponse> a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                try {
                    k a = a(jSONArray.getJSONObject(i2));
                    if (a != null) {
                        arrayList.add(new CpuChannelResponse(a));
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        return arrayList;
    }

    public String b() {
        return this.b;
    }

    private static k a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        int optInt = jSONObject.optInt("id", -1);
        String optString = jSONObject.optString("name", "");
        if (optInt == -1 || TextUtils.isEmpty(optString)) {
            return null;
        }
        k kVar = new k();
        kVar.a = optInt;
        kVar.b = optString;
        return kVar;
    }

    public int a() {
        return this.a;
    }
}
