package com.xiaomi.push;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

/* loaded from: classes3.dex */
public class dg implements dl {
    private void a(Activity activity, Intent intent) {
        String stringExtra = intent.getStringExtra("awake_info");
        if (!TextUtils.isEmpty(stringExtra)) {
            String b = dc.b(stringExtra);
            if (!TextUtils.isEmpty(b)) {
                dd.a(activity.getApplicationContext(), b, 1007, "play with activity successfully");
                return;
            }
        }
        dd.a(activity.getApplicationContext(), "activity", 1008, "B get incorrect message");
    }

    private void b(Context context, dh dhVar) {
        String a = dhVar.a();
        String b = dhVar.b();
        String d2 = dhVar.d();
        int e2 = dhVar.e();
        if (context == null || TextUtils.isEmpty(a) || TextUtils.isEmpty(b) || TextUtils.isEmpty(d2)) {
            if (TextUtils.isEmpty(d2)) {
                dd.a(context, "activity", 1008, "argument error");
            } else {
                dd.a(context, d2, 1008, "argument error");
            }
        } else if (!com.xiaomi.push.service.ch.b(context, a, b)) {
            dd.a(context, d2, 1003, "B is not ready");
        } else {
            dd.a(context, d2, 1002, "B is ready");
            dd.a(context, d2, 1004, "A is ready");
            Intent intent = new Intent(b);
            intent.setPackage(a);
            intent.putExtra("awake_info", dc.a(d2));
            intent.addFlags(276824064);
            intent.setAction(b);
            if (e2 == 1) {
                try {
                    if (!di.b(context)) {
                        dd.a(context, d2, 1008, "A not in foreground");
                        return;
                    }
                } catch (Exception e3) {
                    com.xiaomi.a.a.a.c.a(e3);
                    dd.a(context, d2, 1008, "A meet a exception when help B's activity");
                    return;
                }
            }
            context.startActivity(intent);
            dd.a(context, d2, 1005, "A is successful");
            dd.a(context, d2, 1006, "The job is finished");
        }
    }

    @Override // com.xiaomi.push.dl
    public void a(Context context, Intent intent, String str) {
        if (context == null || !(context instanceof Activity) || intent == null) {
            dd.a(context, "activity", 1008, "B receive incorrect message");
        } else {
            a((Activity) context, intent);
        }
    }

    @Override // com.xiaomi.push.dl
    public void a(Context context, dh dhVar) {
        if (dhVar != null) {
            b(context, dhVar);
        } else {
            dd.a(context, "activity", 1008, "A receive incorrect message");
        }
    }
}
