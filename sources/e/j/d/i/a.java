package e.j.d.i;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.google.firebase.FirebaseApp;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.RemoteMessage;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class a {
    public static final String b = "FCM";

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f11274c = Pattern.compile("[a-zA-Z0-9-_.~%]{1,900}");

    /* renamed from: d  reason: collision with root package name */
    private static a f11275d;
    private final FirebaseInstanceId a;

    private a(FirebaseInstanceId firebaseInstanceId) {
        this.a = firebaseInstanceId;
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (f11275d == null) {
                f11275d = new a(FirebaseInstanceId.e());
            }
            aVar = f11275d;
        }
        return aVar;
    }

    public boolean b() {
        return this.a.G();
    }

    public void c(RemoteMessage remoteMessage) {
        if (!TextUtils.isEmpty(remoteMessage.getTo())) {
            Context applicationContext = FirebaseApp.getInstance().getApplicationContext();
            Intent intent = new Intent("com.google.android.gcm.intent.SEND");
            Intent intent2 = new Intent();
            intent2.setPackage("com.google.example.invalidpackage");
            intent.putExtra(PushConstants.EXTRA_APPLICATION_PENDING_INTENT, PendingIntent.getBroadcast(applicationContext, 0, intent2, 0));
            intent.setPackage("com.google.android.gms");
            intent.putExtras(remoteMessage.zza);
            applicationContext.sendOrderedBroadcast(intent, "com.google.android.gtalkservice.permission.GTALK_SERVICE");
            return;
        }
        throw new IllegalArgumentException("Missing 'to'");
    }

    public void d(boolean z) {
        this.a.y(z);
    }

    public e.j.a.b.j.k<Void> e(String str) {
        if (str != null && str.startsWith("/topics/")) {
            Log.w("FirebaseMessaging", "Format /topics/topic-name is deprecated. Only 'topic-name' should be used in subscribeToTopic.");
            str = str.substring(8);
        }
        if (str != null && f11274c.matcher(str).matches()) {
            FirebaseInstanceId firebaseInstanceId = this.a;
            String valueOf = String.valueOf(str);
            return firebaseInstanceId.i(valueOf.length() != 0 ? "S!".concat(valueOf) : new String("S!"));
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 78);
        sb.append("Invalid topic name: ");
        sb.append(str);
        sb.append(" does not match the allowed format [a-zA-Z0-9-_.~%]{1,900}");
        throw new IllegalArgumentException(sb.toString());
    }

    public e.j.a.b.j.k<Void> f(String str) {
        if (str != null && str.startsWith("/topics/")) {
            Log.w("FirebaseMessaging", "Format /topics/topic-name is deprecated. Only 'topic-name' should be used in unsubscribeFromTopic.");
            str = str.substring(8);
        }
        if (str != null && f11274c.matcher(str).matches()) {
            FirebaseInstanceId firebaseInstanceId = this.a;
            String valueOf = String.valueOf(str);
            return firebaseInstanceId.i(valueOf.length() != 0 ? "U!".concat(valueOf) : new String("U!"));
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 78);
        sb.append("Invalid topic name: ");
        sb.append(str);
        sb.append(" does not match the allowed format [a-zA-Z0-9-_.~%]{1,900}");
        throw new IllegalArgumentException(sb.toString());
    }
}
