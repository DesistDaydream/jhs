package com.tencent.android.tpush.inappmessage;

import android.content.Context;
import android.content.Intent;
import com.tencent.android.tpush.common.MessageKey;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.protocol.j;
import com.tencent.android.tpush.stat.ServiceStat;
import com.tencent.tpns.baseapi.base.util.Util;

/* loaded from: classes3.dex */
public class g {
    private static Context a;

    /* loaded from: classes3.dex */
    public static class a {
        public static g a = new g();
    }

    public static g a(Context context) {
        if (a == null) {
            a = context.getApplicationContext();
        }
        return a.a;
    }

    private void b(j jVar) {
        Intent intent = new Intent();
        intent.putExtra("group_id", jVar.r);
        intent.putExtra("msgId", jVar.a);
        intent.putExtra("type", jVar.f6320f);
        intent.putExtra("pushChannel", 100);
        intent.putExtra(MessageKey.MSG_SERVER_TIME, jVar.f6325k);
        intent.putExtra(MessageKey.MSG_TARGET_TYPE, jVar.t);
        intent.putExtra(MessageKey.MSG_SOURCE, jVar.u);
        intent.putExtra("timestamps", jVar.f6322h);
        ServiceStat.appReportServiceReceived(com.tencent.android.tpush.service.b.e(), intent);
    }

    public void a(j jVar) {
        try {
            String str = jVar.y;
            if (!Util.isNullOrEmptyString(str) && a != null) {
                b(jVar);
                Intent intent = new Intent();
                intent.setClass(a, InAppMessageActivity.class);
                intent.putExtra("inAppMsg", str);
                intent.putExtra("group_id", jVar.r);
                intent.putExtra("msgId", jVar.a);
                intent.putExtra("type", jVar.f6320f);
                intent.putExtra("pushChannel", jVar.f6327m);
                intent.putExtra(MessageKey.MSG_SERVER_TIME, jVar.f6325k);
                intent.putExtra(MessageKey.MSG_TARGET_TYPE, jVar.t);
                intent.putExtra(MessageKey.MSG_SOURCE, jVar.u);
                intent.putExtra("timestamps", jVar.f6322h);
                intent.putExtra(MessageKey.MSG_INAPP_PORTECT_TAG, Rijndael.encrypt("" + (System.currentTimeMillis() - 1000)));
                intent.addFlags(268435456);
                a.startActivity(intent);
            }
        } catch (Throwable th) {
            TLogger.e("InAppMessageManager", "InAppMsg parseInAppMsgConfig :" + th.toString());
        }
    }
}
