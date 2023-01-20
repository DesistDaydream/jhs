package com.tencent.android.tpush;

import android.app.Notification;
import android.content.Context;
import android.util.Pair;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class XGBasicPushNotificationBuilder extends XGPushNotificationBuilder {
    @Override // com.tencent.android.tpush.XGPushNotificationBuilder
    public void a(JSONObject jSONObject) {
    }

    @Override // com.tencent.android.tpush.XGPushNotificationBuilder
    public void b(JSONObject jSONObject) {
    }

    @Override // com.tencent.android.tpush.XGPushNotificationBuilder
    public Pair<Notification, Object> buildNotification(Context context) {
        return a(context);
    }

    @Override // com.tencent.android.tpush.XGPushNotificationBuilder
    public String getType() {
        return "basic";
    }
}
