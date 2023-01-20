package bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_new1;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class a {
    private Context a;
    private bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.e b;

    /* renamed from: c  reason: collision with root package name */
    private Map<String, Object> f1185c;

    public a(@NonNull Context context, @NonNull bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.e eVar) {
        this.a = context;
        this.b = eVar;
    }

    public static boolean a(Map<String, Object> map) {
        return map == null || map.isEmpty() || !((map.containsKey("app_version") || map.containsKey(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME)) && map.containsKey("version_code") && map.containsKey("update_version_code"));
    }

    @NonNull
    public bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.e a() {
        return this.b;
    }

    @Nullable
    public Map<String, Object> b() {
        if (this.f1185c == null) {
            this.f1185c = this.b.e();
        }
        return this.f1185c;
    }

    public String c() {
        return this.b.c();
    }

    @Nullable
    public Map<String, Object> d() {
        Map<String, Object> f2 = this.b.f();
        if (f2 == null) {
            f2 = new HashMap<>(4);
        }
        if (a(f2)) {
            try {
                PackageInfo packageInfo = this.a.getPackageManager().getPackageInfo(this.a.getPackageName(), 128);
                f2.put(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, packageInfo.versionName);
                f2.put("version_code", Integer.valueOf(packageInfo.versionCode));
                if (f2.get("update_version_code") == null) {
                    Bundle bundle = packageInfo.applicationInfo.metaData;
                    Object obj = bundle != null ? bundle.get("UPDATE_VERSION_CODE") : null;
                    if (obj == null) {
                        obj = f2.get("version_code");
                    }
                    f2.put("update_version_code", obj);
                }
            } catch (Throwable unused) {
                f2.put(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.a.d(this.a));
                f2.put("version_code", Integer.valueOf(bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.a.c(this.a)));
                if (f2.get("update_version_code") == null) {
                    f2.put("update_version_code", f2.get("version_code"));
                }
            }
        }
        return f2;
    }

    public String e() {
        return bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.a.b(this.a);
    }
}
