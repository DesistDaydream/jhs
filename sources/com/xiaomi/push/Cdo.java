package com.xiaomi.push;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

/* renamed from: com.xiaomi.push.do  reason: invalid class name */
/* loaded from: classes3.dex */
public class Cdo implements dl {
    private void a(Service service, Intent intent) {
        String stringExtra = intent.getStringExtra("awake_info");
        if (!TextUtils.isEmpty(stringExtra)) {
            String b = dc.b(stringExtra);
            if (!TextUtils.isEmpty(b)) {
                dd.a(service.getApplicationContext(), b, 1007, "play with service successfully");
                return;
            }
        }
        dd.a(service.getApplicationContext(), "service", 1008, "B get a incorrect message");
    }

    private void b(Context context, dh dhVar) {
        String a = dhVar.a();
        String b = dhVar.b();
        String d2 = dhVar.d();
        int e2 = dhVar.e();
        if (context == null || TextUtils.isEmpty(a) || TextUtils.isEmpty(b) || TextUtils.isEmpty(d2)) {
            if (TextUtils.isEmpty(d2)) {
                dd.a(context, "service", 1008, "argument error");
            } else {
                dd.a(context, d2, 1008, "argument error");
            }
        } else if (!com.xiaomi.push.service.ch.a(context, a, b)) {
            dd.a(context, d2, 1003, "B is not ready");
        } else {
            dd.a(context, d2, 1002, "B is ready");
            dd.a(context, d2, 1004, "A is ready");
            try {
                Intent intent = new Intent();
                intent.setAction(b);
                intent.setPackage(a);
                intent.putExtra("awake_info", dc.a(d2));
                if (e2 == 1 && !di.b(context)) {
                    dd.a(context, d2, 1008, "A not in foreground");
                } else if (context.startService(intent) == null) {
                    dd.a(context, d2, 1008, "A is fail to help B's service");
                } else {
                    dd.a(context, d2, 1005, "A is successful");
                    dd.a(context, d2, 1006, "The job is finished");
                }
            } catch (Exception e3) {
                com.xiaomi.a.a.a.c.a(e3);
                dd.a(context, d2, 1008, "A meet a exception when help B's service");
            }
        }
    }

    @Override // com.xiaomi.push.dl
    public void a(Context context, Intent intent, String str) {
        if (context == null || !(context instanceof Service)) {
            dd.a(context, "service", 1008, "A receive incorrect message");
        } else {
            a((Service) context, intent);
        }
    }

    @Override // com.xiaomi.push.dl
    public void a(Context context, dh dhVar) {
        if (dhVar != null) {
            b(context, dhVar);
        } else {
            dd.a(context, "service", 1008, "A receive incorrect message");
        }
    }
}
