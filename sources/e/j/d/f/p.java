package e.j.d.f;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.util.Log;
import androidx.collection.SimpleArrayMap;
import com.google.firebase.iid.zzad;
import com.google.firebase.iid.zzd;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.umeng.analytics.pro.d;
import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes2.dex */
public final class p {

    /* renamed from: g  reason: collision with root package name */
    private static int f11247g;

    /* renamed from: h  reason: collision with root package name */
    private static PendingIntent f11248h;
    private final Context b;

    /* renamed from: c  reason: collision with root package name */
    private final j f11249c;

    /* renamed from: e  reason: collision with root package name */
    private Messenger f11251e;

    /* renamed from: f  reason: collision with root package name */
    private zzd f11252f;
    @GuardedBy("responseCallbacks")
    private final SimpleArrayMap<String, e.j.a.b.j.l<Bundle>> a = new SimpleArrayMap<>();

    /* renamed from: d  reason: collision with root package name */
    private Messenger f11250d = new Messenger(new s(this, Looper.getMainLooper()));

    public p(Context context, j jVar) {
        this.b = context;
        this.f11249c = jVar;
    }

    private static synchronized String b() {
        String num;
        synchronized (p.class) {
            int i2 = f11247g;
            f11247g = i2 + 1;
            num = Integer.toString(i2);
        }
        return num;
    }

    private static synchronized void c(Context context, Intent intent) {
        synchronized (p.class) {
            if (f11248h == null) {
                Intent intent2 = new Intent();
                intent2.setPackage("com.google.example.invalidpackage");
                f11248h = PendingIntent.getBroadcast(context, 0, intent2, 0);
            }
            intent.putExtra(PushConstants.EXTRA_APPLICATION_PENDING_INTENT, f11248h);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(Message message) {
        if (message != null) {
            Object obj = message.obj;
            if (obj instanceof Intent) {
                Intent intent = (Intent) obj;
                intent.setExtrasClassLoader(new zzd.a());
                if (intent.hasExtra("google.messenger")) {
                    Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
                    if (parcelableExtra instanceof zzd) {
                        this.f11252f = (zzd) parcelableExtra;
                    }
                    if (parcelableExtra instanceof Messenger) {
                        this.f11251e = (Messenger) parcelableExtra;
                    }
                }
                Intent intent2 = (Intent) message.obj;
                String action = intent2.getAction();
                if (!"com.google.android.c2dm.intent.REGISTRATION".equals(action)) {
                    if (Log.isLoggable("FirebaseInstanceId", 3)) {
                        String valueOf = String.valueOf(action);
                        Log.d("FirebaseInstanceId", valueOf.length() != 0 ? "Unexpected response action: ".concat(valueOf) : new String("Unexpected response action: "));
                        return;
                    }
                    return;
                }
                String stringExtra = intent2.getStringExtra("registration_id");
                if (stringExtra == null) {
                    stringExtra = intent2.getStringExtra(PushConstants.EXTRA_UNREGISTERED);
                }
                if (stringExtra == null) {
                    String stringExtra2 = intent2.getStringExtra(d.O);
                    if (stringExtra2 == null) {
                        String valueOf2 = String.valueOf(intent2.getExtras());
                        StringBuilder sb = new StringBuilder(String.valueOf(valueOf2).length() + 49);
                        sb.append("Unexpected response, no error or registration id ");
                        sb.append(valueOf2);
                        Log.w("FirebaseInstanceId", sb.toString());
                        return;
                    }
                    if (Log.isLoggable("FirebaseInstanceId", 3)) {
                        String valueOf3 = String.valueOf(stringExtra2);
                        Log.d("FirebaseInstanceId", valueOf3.length() != 0 ? "Received InstanceID error ".concat(valueOf3) : new String("Received InstanceID error "));
                    }
                    if (stringExtra2.startsWith(HiAnalyticsConstant.REPORT_VAL_SEPARATOR)) {
                        String[] split = stringExtra2.split("\\|");
                        if (split.length > 2 && "ID".equals(split[1])) {
                            String str = split[2];
                            String str2 = split[3];
                            if (str2.startsWith(Constants.COLON_SEPARATOR)) {
                                str2 = str2.substring(1);
                            }
                            f(str, intent2.putExtra(d.O, str2).getExtras());
                            return;
                        }
                        String valueOf4 = String.valueOf(stringExtra2);
                        Log.w("FirebaseInstanceId", valueOf4.length() != 0 ? "Unexpected structured response ".concat(valueOf4) : new String("Unexpected structured response "));
                        return;
                    }
                    synchronized (this.a) {
                        for (int i2 = 0; i2 < this.a.size(); i2++) {
                            f(this.a.keyAt(i2), intent2.getExtras());
                        }
                    }
                    return;
                }
                Matcher matcher = Pattern.compile("\\|ID\\|([^|]+)\\|:?+(.*)").matcher(stringExtra);
                if (!matcher.matches()) {
                    if (Log.isLoggable("FirebaseInstanceId", 3)) {
                        String valueOf5 = String.valueOf(stringExtra);
                        Log.d("FirebaseInstanceId", valueOf5.length() != 0 ? "Unexpected response string: ".concat(valueOf5) : new String("Unexpected response string: "));
                        return;
                    }
                    return;
                }
                String group = matcher.group(1);
                String group2 = matcher.group(2);
                Bundle extras = intent2.getExtras();
                extras.putString("registration_id", group2);
                f(group, extras);
                return;
            }
        }
        Log.w("FirebaseInstanceId", "Dropping invalid message");
    }

    private final void f(String str, Bundle bundle) {
        synchronized (this.a) {
            e.j.a.b.j.l<Bundle> remove = this.a.remove(str);
            if (remove == null) {
                String valueOf = String.valueOf(str);
                Log.w("FirebaseInstanceId", valueOf.length() != 0 ? "Missing callback for ".concat(valueOf) : new String("Missing callback for "));
                return;
            }
            remove.setResult(bundle);
        }
    }

    private final Bundle g(Bundle bundle) throws IOException {
        Bundle h2 = h(bundle);
        if (h2 == null || !h2.containsKey("google.messenger")) {
            return h2;
        }
        Bundle h3 = h(bundle);
        if (h3 == null || !h3.containsKey("google.messenger")) {
            return h3;
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x00a3, code lost:
        if (r8.f11252f != null) goto L55;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ed A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, e.j.a.b.j.l] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v14, types: [java.util.concurrent.TimeUnit] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00d1 -> B:65:0x00dc). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00d7 -> B:65:0x00dc). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final android.os.Bundle h(android.os.Bundle r9) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 295
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.j.d.f.p.h(android.os.Bundle):android.os.Bundle");
    }

    public final Bundle a(Bundle bundle) throws IOException {
        if (this.f11249c.g() >= 12000000) {
            try {
                return (Bundle) e.j.a.b.j.n.a(v0.e(this.b).f(1, bundle));
            } catch (InterruptedException | ExecutionException e2) {
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    String valueOf = String.valueOf(e2);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 22);
                    sb.append("Error making request: ");
                    sb.append(valueOf);
                    Log.d("FirebaseInstanceId", sb.toString());
                }
                if ((e2.getCause() instanceof zzad) && ((zzad) e2.getCause()).zza() == 4) {
                    return g(bundle);
                }
                return null;
            }
        }
        return g(bundle);
    }
}
