package com.huawei.hms.aaid.plugin;

import android.content.Context;
import com.huawei.hms.common.ApiException;
import e.k.b.a.k;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public interface PushProxy {
    void deleteAllToken(Context context) throws ApiException;

    void deleteToken(Context context, String str, String str2) throws ApiException;

    JSONObject getPlatform();

    String getProxyType();

    void getToken(Context context, String str, String str2) throws ApiException;

    k<Void> subscribe(Context context, String str, String str2);

    k<Void> turnOff(Context context, String str);

    k<Void> turnOn(Context context, String str);

    k<Void> unsubscribe(Context context, String str, String str2);
}
