package com.tencent.android.tpush.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* loaded from: classes3.dex */
public class BroadcastAgent {
    private static String a(Context context) {
        return context.getPackageName() + Constants.RECEIVER_PERMISSION_SUFFIX;
    }

    public static void registerReceiver(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        try {
            context.getApplicationContext().registerReceiver(broadcastReceiver, intentFilter, a(context), null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void sendBroadcast(Context context, Intent intent) {
        try {
            context.sendBroadcast(intent, a(context));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void unregisterReceiver(Context context, BroadcastReceiver broadcastReceiver) {
        try {
            context.getApplicationContext().unregisterReceiver(broadcastReceiver);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
