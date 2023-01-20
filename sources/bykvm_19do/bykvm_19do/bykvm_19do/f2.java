package bykvm_19do.bykvm_19do.bykvm_19do;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.umeng.analytics.pro.am;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class f2 extends e2 {

    /* renamed from: e  reason: collision with root package name */
    private final Context f106e;

    /* renamed from: f  reason: collision with root package name */
    private final j2 f107f;

    public f2(Context context, j2 j2Var) {
        super(true, false);
        this.f106e = context;
        this.f107f = j2Var;
    }

    private static String a(Context context) {
        String str = null;
        if (context == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 26 && context.getApplicationInfo().targetSdkVersion >= 26) {
            try {
                str = Build.getSerial();
            } catch (Throwable unused) {
            }
        }
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, "unknown")) {
            str = Build.SERIAL;
        }
        return (TextUtils.isEmpty(str) || TextUtils.equals(str, "unknown")) ? "" : str;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.e2
    @SuppressLint({"MissingPermission"})
    public boolean a(JSONObject jSONObject) {
        jSONObject.put(am.x, "Android");
        jSONObject.put("os_version", Build.VERSION.RELEASE);
        jSONObject.put("os_api", Build.VERSION.SDK_INT);
        jSONObject.put("device_model", Build.MODEL);
        jSONObject.put(am.F, Build.BRAND);
        jSONObject.put(am.H, Build.MANUFACTURER);
        jSONObject.put("cpu_abi", Build.CPU_ABI);
        jSONObject.put("build_serial", this.f107f.o() ? a(this.f106e) : this.f107f.n());
        return true;
    }
}
