package com.google.firebase.iid;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Parcelable;
import android.util.Base64;
import android.util.Log;
import androidx.legacy.content.WakefulBroadcastReceiver;
import e.j.a.b.c.r.d0;
import e.j.a.b.c.x.v;
import e.j.d.f.c0;
import e.j.d.f.r;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes2.dex */
public final class FirebaseInstanceIdReceiver extends WakefulBroadcastReceiver {
    @GuardedBy("FirebaseInstanceIdReceiver.class")
    private static c0 a;

    @d0
    @SuppressLint({"InlinedApi"})
    public static int a(BroadcastReceiver broadcastReceiver, Context context, Intent intent) {
        boolean z = v.n() && context.getApplicationInfo().targetSdkVersion >= 26;
        boolean z2 = (intent.getFlags() & 268435456) != 0;
        if (z && !z2) {
            return d(broadcastReceiver, context, intent);
        }
        int a2 = r.b().a(context, intent);
        if (v.n() && a2 == 402) {
            d(broadcastReceiver, context, intent);
            return 403;
        }
        return a2;
    }

    private static synchronized c0 b(Context context, String str) {
        c0 c0Var;
        synchronized (FirebaseInstanceIdReceiver.class) {
            if (a == null) {
                a = new c0(context, str);
            }
            c0Var = a;
        }
        return c0Var;
    }

    private final void c(Context context, Intent intent) {
        int a2;
        intent.setComponent(null);
        intent.setPackage(context.getPackageName());
        if (Build.VERSION.SDK_INT <= 18) {
            intent.removeCategory(context.getPackageName());
        }
        if ("google.com/iid".equals(intent.getStringExtra("from"))) {
            String stringExtra = intent.getStringExtra("CMD");
            if (stringExtra != null) {
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    String valueOf = String.valueOf(intent.getExtras());
                    StringBuilder sb = new StringBuilder(String.valueOf(stringExtra).length() + 21 + String.valueOf(valueOf).length());
                    sb.append("Received command: ");
                    sb.append(stringExtra);
                    sb.append(" - ");
                    sb.append(valueOf);
                    Log.d("FirebaseInstanceId", sb.toString());
                }
                if (!"RST".equals(stringExtra) && !"RST_FULL".equals(stringExtra)) {
                    if ("SYNC".equals(stringExtra)) {
                        FirebaseInstanceId.e().F();
                    }
                } else {
                    FirebaseInstanceId.e().D();
                }
            }
            a2 = -1;
        } else {
            String stringExtra2 = intent.getStringExtra("gcm.rawData64");
            if (stringExtra2 != null) {
                intent.putExtra("rawData", Base64.decode(stringExtra2, 0));
                intent.removeExtra("gcm.rawData64");
            }
            a2 = a(this, context, intent);
        }
        if (isOrderedBroadcast()) {
            setResultCode(a2);
        }
    }

    private static int d(BroadcastReceiver broadcastReceiver, Context context, Intent intent) {
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "Binding to service");
        }
        if (broadcastReceiver.isOrderedBroadcast()) {
            broadcastReceiver.setResultCode(-1);
        }
        b(context, "com.google.firebase.MESSAGING_EVENT").b(intent, broadcastReceiver.goAsync());
        return -1;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        Parcelable parcelableExtra = intent.getParcelableExtra("wrapped_intent");
        Intent intent2 = parcelableExtra instanceof Intent ? (Intent) parcelableExtra : null;
        if (intent2 != null) {
            c(context, intent2);
        } else {
            c(context, intent);
        }
    }
}
