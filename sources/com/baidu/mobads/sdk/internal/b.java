package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class b {
    private int a = 0;
    private List<a> b = new ArrayList();

    public static b a(String str) {
        b bVar = new b();
        if (TextUtils.isEmpty(str)) {
            return bVar;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            bVar.a = jSONObject.optInt("n", 0);
            bVar.b = a.a(jSONObject.optJSONArray(com.umeng.analytics.pro.am.aw));
            return bVar;
        } catch (Throwable th) {
            th.printStackTrace();
            return bVar;
        }
    }

    public List<a> a() {
        return this.b;
    }
}
