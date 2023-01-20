package com.moor.imkf.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import androidx.annotation.NonNull;
import com.moor.imkf.event.KFSocketEvent;
import k.c.a.c;

/* loaded from: classes2.dex */
public class NetWorkReceiver extends BroadcastReceiver {
    private static final String PROC_NET_ROUTE = "/proc/net/route";
    private String mNetworkType;
    private boolean mConnected = false;
    private String mRoutes = "";

    /* loaded from: classes2.dex */
    public static class InstanceHolder {
        private static final NetWorkReceiver INSTANCE = new NetWorkReceiver();

        private InstanceHolder() {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x004a, code lost:
        if (r2 == null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004c, code lost:
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0050, code lost:
        if (r2 == null) goto L14;
     */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0099 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String dumpRoutes() {
        /*
            r11 = this;
            java.lang.String r0 = "\n"
            java.lang.String r1 = ""
            r2 = 0
            java.io.FileReader r3 = new java.io.FileReader     // Catch: java.lang.Throwable -> L43 java.io.IOException -> L4a java.io.FileNotFoundException -> L50
            java.lang.String r4 = "/proc/net/route"
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L43 java.io.IOException -> L4a java.io.FileNotFoundException -> L50
            java.lang.StringBuffer r2 = new java.lang.StringBuffer     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3f java.io.FileNotFoundException -> L41
            r2.<init>()     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3f java.io.FileNotFoundException -> L41
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3f java.io.FileNotFoundException -> L41
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3f java.io.FileNotFoundException -> L41
        L16:
            java.lang.String r5 = r4.readLine()     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3f java.io.FileNotFoundException -> L41
            if (r5 == 0) goto L2f
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3f java.io.FileNotFoundException -> L41
            r6.<init>()     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3f java.io.FileNotFoundException -> L41
            r6.append(r5)     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3f java.io.FileNotFoundException -> L41
            r6.append(r0)     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3f java.io.FileNotFoundException -> L41
            java.lang.String r5 = r6.toString()     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3f java.io.FileNotFoundException -> L41
            r2.append(r5)     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3f java.io.FileNotFoundException -> L41
            goto L16
        L2f:
            java.lang.String r1 = r2.toString()     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3f java.io.FileNotFoundException -> L41
            r4.close()     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3f java.io.FileNotFoundException -> L41
            r3.close()     // Catch: java.io.IOException -> L3a
            goto L53
        L3a:
            goto L53
        L3c:
            r0 = move-exception
            r2 = r3
            goto L44
        L3f:
            r2 = r3
            goto L4a
        L41:
            r2 = r3
            goto L50
        L43:
            r0 = move-exception
        L44:
            if (r2 == 0) goto L49
            r2.close()     // Catch: java.io.IOException -> L49
        L49:
            throw r0
        L4a:
            if (r2 == 0) goto L53
        L4c:
            r2.close()     // Catch: java.io.IOException -> L3a
            goto L53
        L50:
            if (r2 == 0) goto L53
            goto L4c
        L53:
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto La2
            java.lang.String[] r1 = r1.split(r0)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            int r3 = r1.length
            r4 = 0
            r5 = 0
            r6 = 0
        L66:
            if (r5 >= r3) goto L9e
            r7 = r1[r5]
            if (r6 <= 0) goto L93
            java.lang.String r8 = "\t"
            java.lang.String[] r8 = r7.split(r8)
            int r9 = r8.length
            r10 = 8
            if (r9 <= r10) goto L93
            r9 = 7
            r8 = r8[r9]
            java.lang.String r9 = "^[0-9A-F]{8}$"
            boolean r9 = r8.matches(r9)
            if (r9 == 0) goto L93
            r9 = 2
            java.lang.String r8 = r8.substring(r4, r9)
            r9 = 16
            int r8 = java.lang.Integer.parseInt(r8, r9)
            r9 = 192(0xc0, float:2.69E-43)
            if (r8 <= r9) goto L93
            r8 = 0
            goto L94
        L93:
            r8 = 1
        L94:
            if (r8 == 0) goto L99
            r2.add(r7)
        L99:
            int r6 = r6 + 1
            int r5 = r5 + 1
            goto L66
        L9e:
            java.lang.String r1 = android.text.TextUtils.join(r0, r2)
        La2:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moor.imkf.receiver.NetWorkReceiver.dumpRoutes():java.lang.String");
    }

    public static void registerReceiver(@NonNull Context context) {
        context.registerReceiver(InstanceHolder.INSTANCE, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    private void scheduleHeartbeatInterval(NetworkInfo networkInfo) {
        if (networkInfo.getType() != 1 && networkInfo.getType() == 0) {
            networkInfo.getSubtype();
        }
    }

    public static void unRegisterReceiver(@NonNull Context context) {
        context.unregisterReceiver(InstanceHolder.INSTANCE);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String str;
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        System.out.println(activeNetworkInfo);
        boolean z = activeNetworkInfo != null && activeNetworkInfo.isConnected();
        String typeName = z ? activeNetworkInfo.getTypeName() : "null";
        String dumpRoutes = dumpRoutes();
        synchronized (this.mRoutes) {
            str = this.mRoutes;
        }
        if (z == this.mConnected && typeName.equals(this.mNetworkType) && dumpRoutes.equals(str)) {
            return;
        }
        synchronized (this.mRoutes) {
            this.mRoutes = dumpRoutes;
        }
        this.mConnected = z;
        this.mNetworkType = typeName;
        if (z) {
            scheduleHeartbeatInterval(activeNetworkInfo);
            new Handler().postDelayed(new Runnable() { // from class: com.moor.imkf.receiver.NetWorkReceiver.1
                @Override // java.lang.Runnable
                public void run() {
                    c.f().q(KFSocketEvent.NETWORK_OK);
                }
            }, 200L);
            return;
        }
        this.mConnected = false;
        c.f().q(KFSocketEvent.NETWORK_DOWN);
    }
}
