package e.j.d.i;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.firebase.FirebaseApp;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.android.tpush.common.MessageKey;

@e.j.a.b.c.m.a
/* loaded from: classes2.dex */
public class b {
    @e.j.a.b.c.m.a
    public static void a(Intent intent) {
        f("_nd", intent);
    }

    @e.j.a.b.c.m.a
    public static void b(Intent intent) {
        f("_nf", intent);
    }

    @e.j.a.b.c.m.a
    public static void c(Intent intent) {
        if (intent != null) {
            if ("1".equals(intent.getStringExtra("google.c.a.tc"))) {
                e.j.d.b.a.a aVar = (e.j.d.b.a.a) FirebaseApp.getInstance().get(e.j.d.b.a.a.class);
                if (Log.isLoggable("FirebaseMessaging", 3)) {
                    Log.d("FirebaseMessaging", "Received event with track-conversion=true. Setting user property and reengagement event");
                }
                if (aVar != null) {
                    String stringExtra = intent.getStringExtra("google.c.a.c_id");
                    aVar.c("fcm", "_ln", stringExtra);
                    Bundle bundle = new Bundle();
                    bundle.putString(MessageKey.MSG_SOURCE, "Firebase");
                    bundle.putString("medium", RemoteMessageConst.NOTIFICATION);
                    bundle.putString("campaign", stringExtra);
                    aVar.b("fcm", "_cmp", bundle);
                } else {
                    Log.w("FirebaseMessaging", "Unable to set user property for conversion tracking:  analytics library is missing");
                }
            } else if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Received event with track-conversion=false. Do not set user property");
            }
        }
        f("_no", intent);
    }

    @e.j.a.b.c.m.a
    public static void d(Intent intent) {
        f("_nr", intent);
    }

    @e.j.a.b.c.m.a
    public static boolean e(Intent intent) {
        if (intent == null || "com.google.firebase.messaging.RECEIVE_DIRECT_BOOT".equals(intent.getAction())) {
            return false;
        }
        return "1".equals(intent.getStringExtra("google.c.a.e"));
    }

    private static void f(String str, Intent intent) {
        Bundle bundle = new Bundle();
        String stringExtra = intent.getStringExtra("google.c.a.c_id");
        if (stringExtra != null) {
            bundle.putString("_nmid", stringExtra);
        }
        String stringExtra2 = intent.getStringExtra("google.c.a.c_l");
        if (stringExtra2 != null) {
            bundle.putString("_nmn", stringExtra2);
        }
        String stringExtra3 = intent.getStringExtra("google.c.a.m_l");
        if (!TextUtils.isEmpty(stringExtra3)) {
            bundle.putString(TTDownloadField.TT_LABEL, stringExtra3);
        }
        String stringExtra4 = intent.getStringExtra("google.c.a.m_c");
        if (!TextUtils.isEmpty(stringExtra4)) {
            bundle.putString("message_channel", stringExtra4);
        }
        String stringExtra5 = intent.getStringExtra("from");
        stringExtra5 = (stringExtra5 == null || !stringExtra5.startsWith("/topics/")) ? null : null;
        if (stringExtra5 != null) {
            bundle.putString("_nt", stringExtra5);
        }
        if (intent.hasExtra("google.c.a.ts")) {
            try {
                bundle.putInt("_nmt", Integer.parseInt(intent.getStringExtra("google.c.a.ts")));
            } catch (NumberFormatException e2) {
                Log.w("FirebaseMessaging", "Error while parsing timestamp in GCM event", e2);
            }
        }
        if (intent.hasExtra("google.c.a.udt")) {
            try {
                bundle.putInt("_ndt", Integer.parseInt(intent.getStringExtra("google.c.a.udt")));
            } catch (NumberFormatException e3) {
                Log.w("FirebaseMessaging", "Error while parsing use_device_time in GCM event", e3);
            }
        }
        if ("_nr".equals(str) || "_nf".equals(str)) {
            bundle.putString("_nmc", (intent.getExtras() == null || !c.j(intent.getExtras())) ? "data" : "display");
        }
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            String valueOf = String.valueOf(bundle);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 22 + String.valueOf(valueOf).length());
            sb.append("Sending event=");
            sb.append(str);
            sb.append(" params=");
            sb.append(valueOf);
            Log.d("FirebaseMessaging", sb.toString());
        }
        e.j.d.b.a.a aVar = (e.j.d.b.a.a) FirebaseApp.getInstance().get(e.j.d.b.a.a.class);
        if (aVar != null) {
            aVar.b("fcm", str, bundle);
        } else {
            Log.w("FirebaseMessaging", "Unable to log event: analytics library is missing");
        }
    }
}
