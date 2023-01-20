package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.android.tpns.mqtt.MqttTopic;

/* loaded from: classes3.dex */
public class dn implements dl {
    private void a(Context context, String str) {
        try {
            if (!TextUtils.isEmpty(str) && context != null) {
                String[] split = str.split(MqttTopic.TOPIC_LEVEL_SEPARATOR);
                if (split.length > 0 && !TextUtils.isEmpty(split[split.length - 1])) {
                    String str2 = split[split.length - 1];
                    if (TextUtils.isEmpty(str2)) {
                        dd.a(context, com.umeng.analytics.pro.d.M, 1008, "B get a incorrect message");
                        return;
                    }
                    String decode = Uri.decode(str2);
                    if (TextUtils.isEmpty(decode)) {
                        dd.a(context, com.umeng.analytics.pro.d.M, 1008, "B get a incorrect message");
                        return;
                    }
                    String b = dc.b(decode);
                    if (!TextUtils.isEmpty(b)) {
                        dd.a(context, b, 1007, "play with provider successfully");
                        return;
                    }
                }
            }
            dd.a(context, com.umeng.analytics.pro.d.M, 1008, "B get a incorrect message");
        } catch (Exception e2) {
            dd.a(context, com.umeng.analytics.pro.d.M, 1008, "B meet a exception" + e2.getMessage());
        }
    }

    private void b(Context context, dh dhVar) {
        String b = dhVar.b();
        String d2 = dhVar.d();
        int e2 = dhVar.e();
        if (context == null || TextUtils.isEmpty(b) || TextUtils.isEmpty(d2)) {
            if (TextUtils.isEmpty(d2)) {
                dd.a(context, com.umeng.analytics.pro.d.M, 1008, "argument error");
            } else {
                dd.a(context, d2, 1008, "argument error");
            }
        } else if (!com.xiaomi.push.service.ch.b(context, b)) {
            dd.a(context, d2, 1003, "B is not ready");
        } else {
            dd.a(context, d2, 1002, "B is ready");
            dd.a(context, d2, 1004, "A is ready");
            String a = dc.a(d2);
            try {
                if (TextUtils.isEmpty(a)) {
                    dd.a(context, d2, 1008, "info is empty");
                } else if (e2 == 1 && !di.b(context)) {
                    dd.a(context, d2, 1008, "A not in foreground");
                } else {
                    String type = context.getContentResolver().getType(dc.a(b, a));
                    if (TextUtils.isEmpty(type) || !com.baidu.mobads.sdk.internal.bp.o.equals(type)) {
                        dd.a(context, d2, 1008, "A is fail to help B's provider");
                        return;
                    }
                    dd.a(context, d2, 1005, "A is successful");
                    dd.a(context, d2, 1006, "The job is finished");
                }
            } catch (Exception e3) {
                com.xiaomi.a.a.a.c.a(e3);
                dd.a(context, d2, 1008, "A meet a exception when help B's provider");
            }
        }
    }

    @Override // com.xiaomi.push.dl
    public void a(Context context, Intent intent, String str) {
        a(context, str);
    }

    @Override // com.xiaomi.push.dl
    public void a(Context context, dh dhVar) {
        if (dhVar != null) {
            b(context, dhVar);
        } else {
            dd.a(context, com.umeng.analytics.pro.d.M, 1008, "A receive incorrect message");
        }
    }
}
