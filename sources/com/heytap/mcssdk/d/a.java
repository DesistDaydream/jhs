package com.heytap.mcssdk.d;

import android.content.Context;
import android.content.Intent;
import com.heytap.msp.push.mode.BaseMode;

/* loaded from: classes2.dex */
public class a extends c {
    @Override // com.heytap.mcssdk.d.d
    public BaseMode a(Context context, int i2, Intent intent) {
        if (4105 == i2) {
            return a(intent, i2);
        }
        return null;
    }

    @Override // com.heytap.mcssdk.d.c
    public BaseMode a(Intent intent, int i2) {
        try {
            com.heytap.mcssdk.c.b bVar = new com.heytap.mcssdk.c.b();
            bVar.a(Integer.parseInt(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.y))));
            bVar.b(Integer.parseInt(com.heytap.mcssdk.utils.b.d(intent.getStringExtra("code"))));
            bVar.e(com.heytap.mcssdk.utils.b.d(intent.getStringExtra("content")));
            bVar.a(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.z)));
            bVar.b(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.A)));
            bVar.f(com.heytap.mcssdk.utils.b.d(intent.getStringExtra(com.heytap.mcssdk.constant.b.f3337e)));
            com.heytap.mcssdk.utils.d.b("OnHandleIntent-message:" + bVar.toString());
            return bVar;
        } catch (Exception e2) {
            com.heytap.mcssdk.utils.d.b("OnHandleIntent--" + e2.getMessage());
            return null;
        }
    }
}
