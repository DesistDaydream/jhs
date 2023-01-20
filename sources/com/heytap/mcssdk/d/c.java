package com.heytap.mcssdk.d;

import android.content.Context;
import android.content.Intent;
import com.heytap.mcssdk.PushService;
import com.heytap.msp.push.mode.BaseMode;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class c implements d {
    public static List<BaseMode> a(Context context, Intent intent) {
        BaseMode a;
        if (intent == null) {
            return null;
        }
        int i2 = 4096;
        try {
            i2 = Integer.parseInt(com.heytap.mcssdk.utils.b.d(intent.getStringExtra("type")));
        } catch (Exception e2) {
            com.heytap.mcssdk.utils.d.e("MessageParser--getMessageByIntent--Exception:" + e2.getMessage());
        }
        com.heytap.mcssdk.utils.d.b("MessageParser--getMessageByIntent--type:" + i2);
        ArrayList arrayList = new ArrayList();
        for (d dVar : PushService.getInstance().getParsers()) {
            if (dVar != null && (a = dVar.a(context, i2, intent)) != null) {
                arrayList.add(a);
            }
        }
        return arrayList;
    }

    public abstract BaseMode a(Intent intent, int i2);
}
