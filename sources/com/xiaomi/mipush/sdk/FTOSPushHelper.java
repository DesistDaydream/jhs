package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import java.util.Map;

/* loaded from: classes3.dex */
public class FTOSPushHelper {
    private static long a = 0;

    /* renamed from: a */
    private static volatile boolean f2a = false;

    private static void a(Context context) {
        AbstractPushManager a2 = f.a(context).a(e.ASSEMBLE_PUSH_FTOS);
        if (a2 != null) {
            com.xiaomi.a.a.a.c.a("ASSEMBLE_PUSH :  register fun touch os when network change!");
            a2.register();
        }
    }

    public static void doInNetworkChange(Context context) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (getNeedRegister()) {
            long j2 = a;
            if (j2 <= 0 || j2 + 300000 <= elapsedRealtime) {
                a = elapsedRealtime;
                a(context);
            }
        }
    }

    public static boolean getNeedRegister() {
        return f2a;
    }

    public static boolean hasNetwork(Context context) {
        return i.m97a(context);
    }

    public static void notifyFTOSNotificationClicked(Context context, Map<String, String> map) {
        PushMessageReceiver a2;
        if (map == null || !map.containsKey("pushMsg")) {
            return;
        }
        String str = map.get("pushMsg");
        if (TextUtils.isEmpty(str) || (a2 = i.a(context)) == null) {
            return;
        }
        MiPushMessage a3 = i.a(str);
        if (a3.getExtra().containsKey("notify_effect")) {
            return;
        }
        a2.onNotificationMessageClicked(context, a3);
    }

    public static void setNeedRegister(boolean z) {
        f2a = z;
    }

    public static void uploadToken(Context context, String str) {
        i.m96a(context, e.ASSEMBLE_PUSH_FTOS, str);
    }
}
