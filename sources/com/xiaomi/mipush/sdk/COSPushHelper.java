package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;

/* loaded from: classes3.dex */
public class COSPushHelper {
    private static long a = 0;

    /* renamed from: a */
    private static volatile boolean f1a = false;

    public static void convertMessage(Intent intent) {
        i.a(intent);
    }

    public static void doInNetworkChange(Context context) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (getNeedRegister()) {
            long j2 = a;
            if (j2 <= 0 || j2 + 300000 <= elapsedRealtime) {
                a = elapsedRealtime;
                registerCOSAssemblePush(context);
            }
        }
    }

    public static boolean getNeedRegister() {
        return f1a;
    }

    public static boolean hasNetwork(Context context) {
        return i.m97a(context);
    }

    public static void onNotificationMessageCome(Context context, String str) {
    }

    public static void onPassThoughMessageCome(Context context, String str) {
    }

    public static void registerCOSAssemblePush(Context context) {
        AbstractPushManager a2 = f.a(context).a(e.ASSEMBLE_PUSH_COS);
        if (a2 != null) {
            com.xiaomi.a.a.a.c.a("ASSEMBLE_PUSH :  register cos when network change!");
            a2.register();
        }
    }

    public static synchronized void setNeedRegister(boolean z) {
        synchronized (COSPushHelper.class) {
            f1a = z;
        }
    }

    public static void uploadToken(Context context, String str) {
        i.m96a(context, e.ASSEMBLE_PUSH_COS, str);
    }
}
