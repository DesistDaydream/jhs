package e.j.d.h;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.ContextCompat;
import com.google.firebase.DataCollectionDefaultChange;
import e.j.d.e.c;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: e  reason: collision with root package name */
    private static final String f11270e = "com.google.firebase.common.prefs:";
    @VisibleForTesting

    /* renamed from: f  reason: collision with root package name */
    public static final String f11271f = "firebase_data_collection_default_enabled";
    private final Context a;
    private final SharedPreferences b;

    /* renamed from: c  reason: collision with root package name */
    private final c f11272c;

    /* renamed from: d  reason: collision with root package name */
    private final AtomicBoolean f11273d = new AtomicBoolean(c());

    public a(Context context, String str, c cVar) {
        this.a = a(context);
        this.b = context.getSharedPreferences(f11270e + str, 0);
        this.f11272c = cVar;
    }

    private static Context a(Context context) {
        return (Build.VERSION.SDK_INT < 24 || ContextCompat.isDeviceProtectedStorage(context)) ? context : ContextCompat.createDeviceProtectedStorageContext(context);
    }

    private boolean c() {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        if (this.b.contains(f11271f)) {
            return this.b.getBoolean(f11271f, true);
        }
        try {
            PackageManager packageManager = this.a.getPackageManager();
            if (packageManager != null && (applicationInfo = packageManager.getApplicationInfo(this.a.getPackageName(), 128)) != null && (bundle = applicationInfo.metaData) != null && bundle.containsKey(f11271f)) {
                return applicationInfo.metaData.getBoolean(f11271f);
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return true;
    }

    public boolean b() {
        return this.f11273d.get();
    }

    public void d(boolean z) {
        if (this.f11273d.compareAndSet(!z, z)) {
            this.b.edit().putBoolean(f11271f, z).apply();
            this.f11272c.c(new e.j.d.e.a<>(DataCollectionDefaultChange.class, new DataCollectionDefaultChange(z)));
        }
    }
}
