package com.heytap.mcssdk.d;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.heytap.mcssdk.constant.c;
import com.heytap.msp.push.mode.BaseMode;
import com.heytap.msp.push.mode.DataMessage;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class b extends c {
    @Override // com.heytap.mcssdk.d.d
    public BaseMode a(Context context, int i2, Intent intent) {
        if (4103 == i2 || 4098 == i2 || 4108 == i2) {
            BaseMode a = a(intent, i2);
            com.heytap.mcssdk.f.a.a(context, c.a.b, (DataMessage) a);
            return a;
        }
        return null;
    }

    @Override // com.heytap.mcssdk.d.c
    public BaseMode a(Intent intent, int i2) {
        try {
            DataMessage dataMessage = new DataMessage();
            dataMessage.setMessageID(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.f3335c)));
            dataMessage.setTaskID(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.f3336d)));
            dataMessage.setGlobalId(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.f3340h)));
            dataMessage.setAppPackage(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.f3337e)));
            dataMessage.setTitle(com.heytap.mcssdk.utils.b.d(intent.getStringExtra("title")));
            dataMessage.setContent(com.heytap.mcssdk.utils.b.d(intent.getStringExtra("content")));
            dataMessage.setDescription(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.f3341i)));
            String d2 = com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.f3342j));
            int i3 = 0;
            dataMessage.setNotifyID(TextUtils.isEmpty(d2) ? 0 : Integer.parseInt(d2));
            dataMessage.setMiniProgramPkg(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.w)));
            dataMessage.setMessageType(i2);
            dataMessage.setEventId(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.f3343k)));
            dataMessage.setStatisticsExtra(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.f3344l)));
            String d3 = com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.f3345m));
            dataMessage.setDataExtra(d3);
            String a = a(d3);
            if (!TextUtils.isEmpty(a)) {
                i3 = Integer.parseInt(a);
            }
            dataMessage.setMsgCommand(i3);
            dataMessage.setBalanceTime(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.n)));
            dataMessage.setStartDate(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.s)));
            dataMessage.setEndDate(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.t)));
            dataMessage.setTimeRanges(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.o)));
            dataMessage.setRule(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.p)));
            dataMessage.setForcedDelivery(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.q)));
            dataMessage.setDistinctContent(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.r)));
            dataMessage.setAppId(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.u)));
            return dataMessage;
        } catch (Exception e2) {
            com.heytap.mcssdk.utils.d.b("OnHandleIntent--" + e2.getMessage());
            return null;
        }
    }

    public String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return new JSONObject(str).optString(com.heytap.mcssdk.constant.b.v);
        } catch (JSONException e2) {
            com.heytap.mcssdk.utils.d.b(e2.getMessage());
            return "";
        }
    }
}
