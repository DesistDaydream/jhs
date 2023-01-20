package bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.umeng.analytics.pro.am;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class m extends e2 {

    /* renamed from: e  reason: collision with root package name */
    private final Context f149e;

    /* renamed from: f  reason: collision with root package name */
    private final j2 f150f;

    public m(Context context, j2 j2Var) {
        super(false, false);
        this.f149e = context;
        this.f150f = j2Var;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.e2
    public boolean a(JSONObject jSONObject) {
        int i2;
        ApplicationInfo applicationInfo;
        int i3;
        String packageName = this.f149e.getPackageName();
        PackageInfo packageInfo = null;
        if (TextUtils.isEmpty(this.f150f.q())) {
            jSONObject.put("package", packageName);
        } else {
            if (l0.a) {
                l0.a("has zijie pkg", null);
            }
            jSONObject.put("package", this.f150f.q());
            jSONObject.put("real_package_name", packageName);
        }
        try {
            packageInfo = this.f149e.getPackageManager().getPackageInfo(packageName, 0);
        } catch (Throwable unused) {
        }
        if (packageInfo != null) {
            try {
                i2 = packageInfo.versionCode;
            } catch (Throwable th) {
                l0.a(th);
                return false;
            }
        } else {
            i2 = 0;
        }
        jSONObject.put("app_version", !TextUtils.isEmpty(this.f150f.g()) ? this.f150f.g() : packageInfo != null ? packageInfo.versionName : "");
        if (TextUtils.isEmpty(this.f150f.l())) {
            jSONObject.put("app_version_minor", "");
        } else {
            jSONObject.put("app_version_minor", this.f150f.l());
        }
        if (this.f150f.d() != 0) {
            jSONObject.put("version_code", this.f150f.d());
        } else {
            jSONObject.put("version_code", i2);
        }
        if (this.f150f.e() != 0) {
            jSONObject.put("update_version_code", this.f150f.e());
        } else {
            jSONObject.put("update_version_code", i2);
        }
        if (this.f150f.f() != 0) {
            i2 = this.f150f.f();
        }
        jSONObject.put("manifest_version_code", i2);
        if (!TextUtils.isEmpty(this.f150f.c())) {
            jSONObject.put("app_name", this.f150f.c());
        }
        if (!TextUtils.isEmpty(this.f150f.h())) {
            jSONObject.put("tweaked_channel", this.f150f.h());
        }
        if (packageInfo != null && (applicationInfo = packageInfo.applicationInfo) != null && (i3 = applicationInfo.labelRes) > 0) {
            jSONObject.put(am.s, this.f149e.getString(i3));
        }
        return true;
    }
}
