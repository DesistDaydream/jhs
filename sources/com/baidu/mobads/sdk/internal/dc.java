package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import java.util.HashMap;

/* loaded from: classes.dex */
public class dc {
    private Boolean a;

    public dc(Context context, Activity activity, Boolean bool) {
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
        return "http://211.151.146.65:8080/wlantest/shanghai_sun/mock_ad_server_intersitial_video.json";
    }
}
