package com.heytap.mcssdk.utils;

import android.content.Context;
import android.content.Intent;
import com.heytap.mcssdk.PushService;
import com.heytap.mcssdk.constant.MessageConstant;

/* loaded from: classes2.dex */
public class DataMessageUtil {
    private static final String TYPE = "type";

    public void appArrive(Context context, String str) {
        try {
            Intent intent = new Intent();
            intent.setAction(PushService.getInstance().getReceiveSdkAction(context));
            intent.setPackage(PushService.getInstance().getMcsPackageName(context));
            intent.putExtra(com.heytap.mcssdk.constant.b.f3337e, context.getPackageName());
            intent.putExtra(com.heytap.mcssdk.constant.b.f3335c, str);
            intent.putExtra("type", MessageConstant.CommandId.COMMAND_SEND_INSTANT_ACK);
            context.startService(intent);
        } catch (Exception e2) {
            d.e("statisticMessage--Exception" + e2.getMessage());
        }
    }
}
