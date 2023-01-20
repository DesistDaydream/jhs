package e.j.d.f;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.Base64;
import android.util.Log;
import com.google.firebase.FirebaseApp;
import com.umeng.analytics.pro.cb;
import com.xiaomi.mipush.sdk.Constants;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes2.dex */
public final class j {
    private final Context a;
    @GuardedBy("this")
    private String b;
    @GuardedBy("this")

    /* renamed from: c  reason: collision with root package name */
    private String f11236c;
    @GuardedBy("this")

    /* renamed from: d  reason: collision with root package name */
    private int f11237d;
    @GuardedBy("this")

    /* renamed from: e  reason: collision with root package name */
    private int f11238e = 0;

    public j(Context context) {
        this.a = context;
    }

    private final PackageInfo b(String str) {
        try {
            return this.a.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e2) {
            String valueOf = String.valueOf(e2);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 23);
            sb.append("Failed to find package ");
            sb.append(valueOf);
            Log.w("FirebaseInstanceId", sb.toString());
            return null;
        }
    }

    public static String c(FirebaseApp firebaseApp) {
        String gcmSenderId = firebaseApp.getOptions().getGcmSenderId();
        if (gcmSenderId != null) {
            return gcmSenderId;
        }
        String applicationId = firebaseApp.getOptions().getApplicationId();
        if (applicationId.startsWith("1:")) {
            String[] split = applicationId.split(Constants.COLON_SEPARATOR);
            if (split.length < 2) {
                return null;
            }
            String str = split[1];
            if (str.isEmpty()) {
                return null;
            }
            return str;
        }
        return applicationId;
    }

    public static String d(PublicKey publicKey) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(publicKey.getEncoded());
            digest[0] = (byte) ((digest[0] & cb.f7124m) + 112);
            return Base64.encodeToString(digest, 0, 8, 11);
        } catch (NoSuchAlgorithmException unused) {
            Log.w("FirebaseInstanceId", "Unexpected error, device missing required algorithms");
            return null;
        }
    }

    private final synchronized void h() {
        PackageInfo b = b(this.a.getPackageName());
        if (b != null) {
            this.b = Integer.toString(b.versionCode);
            this.f11236c = b.versionName;
        }
    }

    public final synchronized int a() {
        int i2 = this.f11238e;
        if (i2 != 0) {
            return i2;
        }
        PackageManager packageManager = this.a.getPackageManager();
        if (packageManager.checkPermission("com.google.android.c2dm.permission.SEND", "com.google.android.gms") == -1) {
            Log.e("FirebaseInstanceId", "Google Play services missing or without correct permission.");
            return 0;
        }
        if (!e.j.a.b.c.x.v.n()) {
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gms");
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
            if (queryIntentServices != null && queryIntentServices.size() > 0) {
                this.f11238e = 1;
                return 1;
            }
        }
        Intent intent2 = new Intent("com.google.iid.TOKEN_REQUEST");
        intent2.setPackage("com.google.android.gms");
        List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent2, 0);
        if (queryBroadcastReceivers != null && queryBroadcastReceivers.size() > 0) {
            this.f11238e = 2;
            return 2;
        }
        Log.w("FirebaseInstanceId", "Failed to resolve IID implementation package, falling back");
        if (e.j.a.b.c.x.v.n()) {
            this.f11238e = 2;
        } else {
            this.f11238e = 1;
        }
        return this.f11238e;
    }

    public final synchronized String e() {
        if (this.b == null) {
            h();
        }
        return this.b;
    }

    public final synchronized String f() {
        if (this.f11236c == null) {
            h();
        }
        return this.f11236c;
    }

    public final synchronized int g() {
        PackageInfo b;
        if (this.f11237d == 0 && (b = b("com.google.android.gms")) != null) {
            this.f11237d = b.versionCode;
        }
        return this.f11237d;
    }
}
