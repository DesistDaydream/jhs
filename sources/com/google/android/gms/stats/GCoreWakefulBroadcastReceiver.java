package com.google.android.gms.stats;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.legacy.content.WakefulBroadcastReceiver;
import e.j.a.b.c.m.a;
import e.j.a.b.c.r.d0;
import e.j.a.b.c.w.d;

@a
@d0
/* loaded from: classes2.dex */
public abstract class GCoreWakefulBroadcastReceiver extends WakefulBroadcastReceiver {
    private static String a = "GCoreWakefulBroadcastReceiver";

    @a
    @SuppressLint({"UnwrappedWakefulBroadcastReceiver"})
    public static boolean a(Context context, Intent intent) {
        if (intent == null) {
            return false;
        }
        if (context != null) {
            d.a().f(context, intent);
        } else {
            String str = a;
            String valueOf = String.valueOf(intent.toUri(0));
            Log.w(str, valueOf.length() != 0 ? "context shouldn't be null. intent: ".concat(valueOf) : new String("context shouldn't be null. intent: "));
        }
        return WakefulBroadcastReceiver.completeWakefulIntent(intent);
    }
}
