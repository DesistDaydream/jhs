package cn.thinkingdata.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import d.a.a.o.n;

/* loaded from: classes.dex */
public class TDReceiver extends BroadcastReceiver {
    private static volatile TDReceiver a;

    public static synchronized TDReceiver a() {
        TDReceiver tDReceiver;
        synchronized (TDReceiver.class) {
            if (a == null) {
                synchronized (TDReceiver.class) {
                    if (a == null) {
                        a = new TDReceiver();
                    }
                }
            }
            tDReceiver = a;
        }
        return tDReceiver;
    }

    public static void b(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        String D = n.D(context);
        String str = "cn.thinkingdata.receiver";
        if (D.length() != 0) {
            str = D + ".cn.thinkingdata.receiver";
        }
        intentFilter.addAction(str);
        context.registerReceiver(a(), intentFilter);
    }

    /* JADX WARN: Removed duplicated region for block: B:101:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0144  */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onReceive(android.content.Context r11, android.content.Intent r12) {
        /*
            Method dump skipped, instructions count: 378
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.thinkingdata.android.TDReceiver.onReceive(android.content.Context, android.content.Intent):void");
    }
}
