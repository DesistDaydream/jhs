package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import com.huawei.hms.push.constant.RemoteMessageConst;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class cm implements IOAdEventListener {
    public final /* synthetic */ cj a;

    public cm(cj cjVar) {
        this.a = cjVar;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        if (iOAdEvent != null) {
            try {
                if (iOAdEvent.getData() != null) {
                    Object obj = iOAdEvent.getData().get("intervalpages");
                    Object obj2 = iOAdEvent.getData().get("bannerseconds");
                    Object obj3 = iOAdEvent.getData().get("novelrouter");
                    Object obj4 = iOAdEvent.getData().get("entry");
                    Object obj5 = iOAdEvent.getData().get(RemoteMessageConst.Notification.CHANNEL_ID);
                    Object obj6 = iOAdEvent.getData().get("contentId");
                    if (obj3 != null) {
                        int intValue = obj != null ? ((Integer) obj).intValue() : 6;
                        int intValue2 = obj2 != null ? ((Integer) obj2).intValue() : 10;
                        int intValue3 = obj4 != null ? ((Integer) obj4).intValue() : 0;
                        int intValue4 = obj5 != null ? ((Integer) obj5).intValue() : 1022;
                        String str = obj6 != null ? (String) obj6 : null;
                        JSONObject jSONObject = new JSONObject();
                        if (al.f()) {
                            jSONObject.put("status", "0");
                        } else {
                            jSONObject.put("status", "1");
                        }
                        this.a.a(jSONObject);
                        this.a.a(intValue, intValue2, (String) obj3, intValue3, intValue4, str);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
