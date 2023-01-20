package com.xiaomi.push;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

/* loaded from: classes3.dex */
public class dp implements dl {
    private void a(Service service, Intent intent) {
        if ("com.xiaomi.mipush.sdk.WAKEUP".equals(intent.getAction())) {
            String stringExtra = intent.getStringExtra("waker_pkgname");
            String stringExtra2 = intent.getStringExtra("awake_info");
            if (TextUtils.isEmpty(stringExtra)) {
                dd.a(service.getApplicationContext(), "service", 1007, "old version message");
            } else if (TextUtils.isEmpty(stringExtra2)) {
                dd.a(service.getApplicationContext(), stringExtra, 1007, "play with service ");
            } else {
                String b = dc.b(stringExtra2);
                boolean isEmpty = TextUtils.isEmpty(b);
                Context applicationContext = service.getApplicationContext();
                if (isEmpty) {
                    dd.a(applicationContext, "service", 1008, "B get a incorrect message");
                } else {
                    dd.a(applicationContext, b, 1007, "old version message ");
                }
            }
        }
    }

    private void a(Context context, String str, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            if (TextUtils.isEmpty(str3)) {
                dd.a(context, "service", 1008, "argument error");
            } else {
                dd.a(context, str3, 1008, "argument error");
            }
        } else if (!com.xiaomi.push.service.ch.a(context, str)) {
            dd.a(context, str3, 1003, "B is not ready");
        } else {
            dd.a(context, str3, 1002, "B is ready");
            dd.a(context, str3, 1004, "A is ready");
            try {
                Intent intent = new Intent();
                intent.setClassName(str, str2);
                intent.setAction("com.xiaomi.mipush.sdk.WAKEUP");
                intent.putExtra("waker_pkgname", context.getPackageName());
                intent.putExtra("awake_info", dc.a(str3));
                if (context.startService(intent) == null) {
                    dd.a(context, str3, 1008, "A is fail to help B's service");
                    return;
                }
                dd.a(context, str3, 1005, "A is successful");
                dd.a(context, str3, 1006, "The job is finished");
            } catch (Exception e2) {
                com.xiaomi.a.a.a.c.a(e2);
                dd.a(context, str3, 1008, "A meet a exception when help B's service");
            }
        }
    }

    @Override // com.xiaomi.push.dl
    public void a(Context context, Intent intent, String str) {
        if (context == null || !(context instanceof Service)) {
            return;
        }
        a((Service) context, intent);
    }

    @Override // com.xiaomi.push.dl
    public void a(Context context, dh dhVar) {
        if (dhVar != null) {
            a(context, dhVar.a(), dhVar.c(), dhVar.d());
        }
    }
}
