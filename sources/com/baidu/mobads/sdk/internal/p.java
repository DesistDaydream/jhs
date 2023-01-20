package com.baidu.mobads.sdk.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import com.baidu.mobads.sdk.api.CustomNotification;
import com.baidu.mobads.sdk.api.ICommonModuleObj;
import com.huawei.hms.push.constant.RemoteMessageConst;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class p implements ICommonModuleObj {
    private static volatile p a;
    private CustomNotification b = new CustomNotification();

    private p() {
    }

    public static p a() {
        if (a == null) {
            synchronized (p.class) {
                if (a == null) {
                    a = new p();
                }
            }
        }
        return a;
    }

    @Override // com.baidu.mobads.sdk.api.ICommonModuleObj
    public Object createModuleObj(String str, JSONObject jSONObject) {
        if (!ICommonModuleObj.KEY_NOTIFICATION.equals(str) || jSONObject == null) {
            return null;
        }
        return this.b.getCustomNotification((Context) jSONObject.opt("context"), jSONObject.optString(RemoteMessageConst.Notification.CHANNEL_ID), jSONObject.optString(RemoteMessageConst.Notification.TICKER), (Bitmap) jSONObject.opt("icon"), jSONObject.optString("title"), jSONObject.optString("content"), jSONObject.optString("status"), jSONObject.optBoolean(RemoteMessageConst.Notification.AUTO_CANCEL), jSONObject.optInt("progress"), jSONObject.optInt("smallIcon"), jSONObject.optString("action"), (PendingIntent) jSONObject.opt(e.j.a.b.c.r.e.F));
    }
}
