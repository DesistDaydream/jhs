package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import java.util.HashMap;

/* loaded from: classes.dex */
public class de {
    private Boolean a;

    public de(Context context, Activity activity, Boolean bool) {
        this.a = bool;
        a().booleanValue();
    }

    public Boolean a() {
        return this.a;
    }

    public HashMap<String, String> b() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("xyz", "hihihi");
        return hashMap;
    }

    public String c() {
        return null;
    }
}
