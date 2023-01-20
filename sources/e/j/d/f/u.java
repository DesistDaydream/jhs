package e.j.d.f;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.collection.ArrayMap;
import androidx.core.content.ContextCompat;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.zzs;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/* loaded from: classes2.dex */
public final class u {
    private final SharedPreferences a;
    private final Context b;

    /* renamed from: c  reason: collision with root package name */
    private final r0 f11258c;
    @GuardedBy("this")

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, t0> f11259d;

    public u(Context context) {
        this(context, new r0());
    }

    public static String c(String str, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 3 + String.valueOf(str2).length());
        sb.append(str);
        sb.append("|S|");
        sb.append(str2);
        return sb.toString();
    }

    private static String i(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 4 + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb.append(str);
        sb.append("|T|");
        sb.append(str2);
        sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        sb.append(str3);
        return sb.toString();
    }

    private final synchronized boolean k() {
        return this.a.getAll().isEmpty();
    }

    public final synchronized t a(String str, String str2, String str3) {
        return t.a(this.a.getString(i(str, str2, str3), null));
    }

    public final synchronized String b() {
        return this.a.getString("topic_operation_queue", "");
    }

    public final synchronized void d(String str) {
        this.a.edit().putString("topic_operation_queue", str).apply();
    }

    public final synchronized void e(String str, String str2, String str3, String str4, String str5) {
        String c2 = t.c(str4, str5, System.currentTimeMillis());
        if (c2 == null) {
            return;
        }
        SharedPreferences.Editor edit = this.a.edit();
        edit.putString(i(str, str2, str3), c2);
        edit.commit();
    }

    public final synchronized t0 f(String str) {
        t0 m2;
        t0 t0Var = this.f11259d.get(str);
        if (t0Var != null) {
            return t0Var;
        }
        try {
            m2 = this.f11258c.a(this.b, str);
        } catch (zzs unused) {
            Log.w("FirebaseInstanceId", "Stored data is corrupt, generating new identity");
            FirebaseInstanceId.e().D();
            m2 = this.f11258c.m(this.b, str);
        }
        this.f11259d.put(str, m2);
        return m2;
    }

    public final synchronized void g() {
        this.f11259d.clear();
        r0.g(this.b);
        this.a.edit().clear().commit();
    }

    public final synchronized void h(String str, String str2, String str3) {
        String i2 = i(str, str2, str3);
        SharedPreferences.Editor edit = this.a.edit();
        edit.remove(i2);
        edit.commit();
    }

    public final synchronized void j(String str) {
        String concat = String.valueOf(str).concat("|T|");
        SharedPreferences.Editor edit = this.a.edit();
        for (String str2 : this.a.getAll().keySet()) {
            if (str2.startsWith(concat)) {
                edit.remove(str2);
            }
        }
        edit.commit();
    }

    private u(Context context, r0 r0Var) {
        this.f11259d = new ArrayMap();
        this.b = context;
        this.a = context.getSharedPreferences("com.google.android.gms.appid", 0);
        this.f11258c = r0Var;
        File file = new File(ContextCompat.getNoBackupFilesDir(context), "com.google.android.gms.appid-no-backup");
        if (file.exists()) {
            return;
        }
        try {
            if (!file.createNewFile() || k()) {
                return;
            }
            Log.i("FirebaseInstanceId", "App restored, clearing state");
            g();
            FirebaseInstanceId.e().D();
        } catch (IOException e2) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf = String.valueOf(e2.getMessage());
                Log.d("FirebaseInstanceId", valueOf.length() != 0 ? "Error creating file in no backup dir: ".concat(valueOf) : new String("Error creating file in no backup dir: "));
            }
        }
    }
}
