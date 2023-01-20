package e.j.d.i;

import android.annotation.TargetApi;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import e.j.a.b.c.x.v;
import java.util.Arrays;
import java.util.Iterator;
import java.util.MissingFormatArgumentException;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: classes2.dex */
public final class c {

    /* renamed from: d  reason: collision with root package name */
    private static final AtomicInteger f11276d = new AtomicInteger((int) SystemClock.elapsedRealtime());
    private final Context a;
    private final String b;
    @GuardedBy("this")

    /* renamed from: c  reason: collision with root package name */
    private Bundle f11277c;

    public c(Context context, String str) {
        this.a = context;
        this.b = str;
    }

    private final int a(String str) {
        if (!TextUtils.isEmpty(str)) {
            Resources resources = this.a.getResources();
            int identifier = resources.getIdentifier(str, "drawable", this.b);
            if (identifier != 0 && g(identifier)) {
                return identifier;
            }
            int identifier2 = resources.getIdentifier(str, "mipmap", this.b);
            if (identifier2 != 0 && g(identifier2)) {
                return identifier2;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 61);
            sb.append("Icon resource ");
            sb.append(str);
            sb.append(" not found. Notification will use default icon.");
            Log.w("FirebaseMessaging", sb.toString());
        }
        int i2 = c().getInt("com.google.firebase.messaging.default_notification_icon", 0);
        if (i2 == 0 || !g(i2)) {
            try {
                i2 = h(0).icon;
            } catch (PackageManager.NameNotFoundException e2) {
                String valueOf = String.valueOf(e2);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 35);
                sb2.append("Couldn't get own application info: ");
                sb2.append(valueOf);
                Log.w("FirebaseMessaging", sb2.toString());
            }
        }
        if (i2 == 0 || !g(i2)) {
            return 17301651;
        }
        return i2;
    }

    private final PendingIntent b(int i2, Intent intent) {
        return PendingIntent.getBroadcast(this.a, i2, new Intent("com.google.firebase.MESSAGING_EVENT").setComponent(new ComponentName(this.a, "com.google.firebase.iid.FirebaseInstanceIdReceiver")).putExtra("wrapped_intent", intent), 1073741824);
    }

    private final synchronized Bundle c() {
        Bundle bundle;
        Bundle bundle2 = this.f11277c;
        if (bundle2 != null) {
            return bundle2;
        }
        try {
            ApplicationInfo h2 = h(128);
            if (h2 != null && (bundle = h2.metaData) != null) {
                this.f11277c = bundle;
                return bundle;
            }
        } catch (PackageManager.NameNotFoundException e2) {
            String valueOf = String.valueOf(e2);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 35);
            sb.append("Couldn't get own application info: ");
            sb.append(valueOf);
            Log.w("FirebaseMessaging", sb.toString());
        }
        return Bundle.EMPTY;
    }

    public static String e(Bundle bundle, String str) {
        String string = bundle.getString(str);
        return string == null ? bundle.getString(str.replace("gcm.n.", "gcm.notification.")) : string;
    }

    private static void f(Intent intent, Bundle bundle) {
        for (String str : bundle.keySet()) {
            if (str.startsWith("google.c.a.") || str.equals("from")) {
                intent.putExtra(str, bundle.getString(str));
            }
        }
    }

    @TargetApi(26)
    private final boolean g(int i2) {
        if (Build.VERSION.SDK_INT != 26) {
            return true;
        }
        try {
            if (this.a.getResources().getDrawable(i2, null) instanceof AdaptiveIconDrawable) {
                StringBuilder sb = new StringBuilder(77);
                sb.append("Adaptive icons cannot be used in notifications. Ignoring icon id: ");
                sb.append(i2);
                Log.e("FirebaseMessaging", sb.toString());
                return false;
            }
            return true;
        } catch (Resources.NotFoundException unused) {
            StringBuilder sb2 = new StringBuilder(66);
            sb2.append("Couldn't find resource ");
            sb2.append(i2);
            sb2.append(", treating it as an invalid icon");
            Log.e("FirebaseMessaging", sb2.toString());
            return false;
        }
    }

    private final ApplicationInfo h(int i2) throws PackageManager.NameNotFoundException {
        return this.a.getPackageManager().getApplicationInfo(this.b, i2);
    }

    private final Integer i(String str) {
        if (Build.VERSION.SDK_INT < 21) {
            return null;
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.valueOf(Color.parseColor(str));
            } catch (IllegalArgumentException unused) {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 54);
                sb.append("Color ");
                sb.append(str);
                sb.append(" not valid. Notification will use default color.");
                Log.w("FirebaseMessaging", sb.toString());
            }
        }
        int i2 = c().getInt("com.google.firebase.messaging.default_notification_color", 0);
        if (i2 != 0) {
            try {
                return Integer.valueOf(ContextCompat.getColor(this.a, i2));
            } catch (Resources.NotFoundException unused2) {
                Log.w("FirebaseMessaging", "Cannot find the color resource referenced in AndroidManifest.");
            }
        }
        return null;
    }

    public static boolean j(Bundle bundle) {
        return "1".equals(e(bundle, "gcm.n.e")) || e(bundle, "gcm.n.icon") != null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Object[] k(Bundle bundle, String str) {
        String valueOf = String.valueOf(str);
        String e2 = e(bundle, "_loc_args".length() != 0 ? valueOf.concat("_loc_args") : new String(valueOf));
        if (TextUtils.isEmpty(e2)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(e2);
            int length = jSONArray.length();
            String[] strArr = new String[length];
            for (int i2 = 0; i2 < length; i2++) {
                strArr[i2] = jSONArray.opt(i2);
            }
            return strArr;
        } catch (JSONException unused) {
            String valueOf2 = String.valueOf(str);
            String substring = ("_loc_args".length() != 0 ? valueOf2.concat("_loc_args") : new String(valueOf2)).substring(6);
            StringBuilder sb = new StringBuilder(String.valueOf(substring).length() + 41 + String.valueOf(e2).length());
            sb.append("Malformed ");
            sb.append(substring);
            sb.append(": ");
            sb.append(e2);
            sb.append("  Default value will be used.");
            Log.w("FirebaseMessaging", sb.toString());
            return null;
        }
    }

    public static String l(Bundle bundle) {
        String e2 = e(bundle, "gcm.n.sound2");
        return TextUtils.isEmpty(e2) ? e(bundle, "gcm.n.sound") : e2;
    }

    public static String m(Bundle bundle, String str) {
        String valueOf = String.valueOf(str);
        return e(bundle, "_loc_key".length() != 0 ? valueOf.concat("_loc_key") : new String(valueOf));
    }

    @TargetApi(26)
    private final String n(String str) {
        if (v.n()) {
            int i2 = 0;
            try {
                i2 = h(0).targetSdkVersion;
            } catch (PackageManager.NameNotFoundException unused) {
            }
            if (i2 < 26) {
                return null;
            }
            NotificationManager notificationManager = (NotificationManager) this.a.getSystemService(NotificationManager.class);
            if (!TextUtils.isEmpty(str)) {
                if (notificationManager.getNotificationChannel(str) != null) {
                    return str;
                }
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 122);
                sb.append("Notification Channel requested (");
                sb.append(str);
                sb.append(") has not been created by the app. Manifest configuration, or default, value will be used.");
                Log.w("FirebaseMessaging", sb.toString());
            }
            String string = c().getString("com.google.firebase.messaging.default_notification_channel_id");
            if (!TextUtils.isEmpty(string)) {
                if (notificationManager.getNotificationChannel(string) != null) {
                    return string;
                }
                Log.w("FirebaseMessaging", "Notification Channel set in AndroidManifest.xml has not been created by the app. Default value will be used.");
            } else {
                Log.w("FirebaseMessaging", "Missing Default Notification Channel metadata in AndroidManifest. Default value will be used.");
            }
            if (notificationManager.getNotificationChannel("fcm_fallback_notification_channel") == null) {
                notificationManager.createNotificationChannel(new NotificationChannel("fcm_fallback_notification_channel", this.a.getString(this.a.getResources().getIdentifier("fcm_fallback_notification_channel_label", "string", this.b)), 3));
            }
            return "fcm_fallback_notification_channel";
        }
        return null;
    }

    @Nullable
    public static Uri o(@NonNull Bundle bundle) {
        String e2 = e(bundle, "gcm.n.link_android");
        if (TextUtils.isEmpty(e2)) {
            e2 = e(bundle, "gcm.n.link");
        }
        if (TextUtils.isEmpty(e2)) {
            return null;
        }
        return Uri.parse(e2);
    }

    private final String p(Bundle bundle, String str) {
        String e2 = e(bundle, str);
        return !TextUtils.isEmpty(e2) ? e2 : r(bundle, str);
    }

    @NonNull
    private final CharSequence q(Bundle bundle) {
        String p = p(bundle, "gcm.n.title");
        if (TextUtils.isEmpty(p)) {
            try {
                return h(0).loadLabel(this.a.getPackageManager());
            } catch (PackageManager.NameNotFoundException e2) {
                String valueOf = String.valueOf(e2);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 35);
                sb.append("Couldn't get own application info: ");
                sb.append(valueOf);
                Log.e("FirebaseMessaging", sb.toString());
                return "";
            }
        }
        return p;
    }

    private final String r(Bundle bundle, String str) {
        String m2 = m(bundle, str);
        if (TextUtils.isEmpty(m2)) {
            return null;
        }
        Resources resources = this.a.getResources();
        int identifier = resources.getIdentifier(m2, "string", this.b);
        if (identifier == 0) {
            String valueOf = String.valueOf(str);
            String substring = ("_loc_key".length() != 0 ? valueOf.concat("_loc_key") : new String(valueOf)).substring(6);
            StringBuilder sb = new StringBuilder(String.valueOf(substring).length() + 49 + String.valueOf(str).length());
            sb.append(substring);
            sb.append(" resource not found: ");
            sb.append(str);
            sb.append(" Default value will be used.");
            Log.w("FirebaseMessaging", sb.toString());
            return null;
        }
        Object[] k2 = k(bundle, str);
        if (k2 == null) {
            return resources.getString(identifier);
        }
        try {
            return resources.getString(identifier, k2);
        } catch (MissingFormatArgumentException e2) {
            String arrays = Arrays.toString(k2);
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 58 + String.valueOf(arrays).length());
            sb2.append("Missing format argument for ");
            sb2.append(str);
            sb2.append(": ");
            sb2.append(arrays);
            sb2.append(" Default value will be used.");
            Log.w("FirebaseMessaging", sb2.toString(), e2);
            return null;
        }
    }

    private static boolean s(Bundle bundle) {
        return bundle != null && "1".equals(bundle.getString("google.c.a.e"));
    }

    public final e d(Bundle bundle) {
        Uri defaultUri;
        Intent launchIntentForPackage;
        PendingIntent activity;
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this.a, n(e(bundle, "gcm.n.android_channel_id")));
        builder.setAutoCancel(true);
        builder.setContentTitle(q(bundle));
        String p = p(bundle, "gcm.n.body");
        if (!TextUtils.isEmpty(p)) {
            builder.setContentText(p);
            builder.setStyle(new NotificationCompat.BigTextStyle().bigText(p));
        }
        builder.setSmallIcon(a(e(bundle, "gcm.n.icon")));
        String l2 = l(bundle);
        PendingIntent pendingIntent = null;
        if (TextUtils.isEmpty(l2)) {
            defaultUri = null;
        } else if (!"default".equals(l2) && this.a.getResources().getIdentifier(l2, "raw", this.b) != 0) {
            String str = this.b;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 24 + String.valueOf(l2).length());
            sb.append("android.resource://");
            sb.append(str);
            sb.append("/raw/");
            sb.append(l2);
            defaultUri = Uri.parse(sb.toString());
        } else {
            defaultUri = RingtoneManager.getDefaultUri(2);
        }
        if (defaultUri != null) {
            builder.setSound(defaultUri);
        }
        String e2 = e(bundle, "gcm.n.click_action");
        if (!TextUtils.isEmpty(e2)) {
            launchIntentForPackage = new Intent(e2);
            launchIntentForPackage.setPackage(this.b);
            launchIntentForPackage.setFlags(268435456);
        } else {
            Uri o = o(bundle);
            if (o != null) {
                launchIntentForPackage = new Intent("android.intent.action.VIEW");
                launchIntentForPackage.setPackage(this.b);
                launchIntentForPackage.setData(o);
            } else {
                launchIntentForPackage = this.a.getPackageManager().getLaunchIntentForPackage(this.b);
                if (launchIntentForPackage == null) {
                    Log.w("FirebaseMessaging", "No activity found to launch app");
                }
            }
        }
        if (launchIntentForPackage == null) {
            activity = null;
        } else {
            launchIntentForPackage.addFlags(67108864);
            Bundle bundle2 = new Bundle(bundle);
            Iterator<String> it = bundle2.keySet().iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next != null && next.startsWith("google.c.")) {
                    it.remove();
                }
            }
            launchIntentForPackage.putExtras(bundle2);
            for (String str2 : bundle2.keySet()) {
                if (str2.startsWith("gcm.n.") || str2.startsWith("gcm.notification.")) {
                    launchIntentForPackage.removeExtra(str2);
                }
            }
            Context context = this.a;
            AtomicInteger atomicInteger = f11276d;
            activity = PendingIntent.getActivity(context, atomicInteger.incrementAndGet(), launchIntentForPackage, 1073741824);
            if (s(bundle)) {
                Intent intent = new Intent("com.google.firebase.messaging.NOTIFICATION_OPEN");
                f(intent, bundle);
                intent.putExtra("pending_intent", activity);
                activity = b(atomicInteger.incrementAndGet(), intent);
            }
        }
        builder.setContentIntent(activity);
        if (s(bundle)) {
            Intent intent2 = new Intent("com.google.firebase.messaging.NOTIFICATION_DISMISS");
            f(intent2, bundle);
            pendingIntent = b(f11276d.incrementAndGet(), intent2);
        }
        if (pendingIntent != null) {
            builder.setDeleteIntent(pendingIntent);
        }
        Integer i2 = i(e(bundle, "gcm.n.color"));
        if (i2 != null) {
            builder.setColor(i2.intValue());
        }
        String e3 = e(bundle, "gcm.n.tag");
        if (TextUtils.isEmpty(e3)) {
            long uptimeMillis = SystemClock.uptimeMillis();
            StringBuilder sb2 = new StringBuilder(37);
            sb2.append("FCM-Notification:");
            sb2.append(uptimeMillis);
            e3 = sb2.toString();
        }
        return new e(builder, e3, 0);
    }
}
