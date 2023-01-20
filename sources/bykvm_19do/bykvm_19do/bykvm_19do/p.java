package bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class p extends e2 {

    /* renamed from: e  reason: collision with root package name */
    private final Context f154e;

    public p(Context context) {
        super(true, false);
        this.f154e = context;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.e2
    public boolean a(JSONObject jSONObject) {
        PackageInfo packageInfo;
        Signature[] signatureArr;
        Signature signature;
        String str = null;
        try {
            packageInfo = this.f154e.getPackageManager().getPackageInfo(this.f154e.getPackageName(), 64);
        } catch (Throwable th) {
            l0.a(th);
            packageInfo = null;
        }
        if (packageInfo != null && (signatureArr = packageInfo.signatures) != null && signatureArr.length > 0 && (signature = signatureArr[0]) != null) {
            str = f0.b(signature.toByteArray());
        }
        if (str != null) {
            jSONObject.put("sig_hash", str);
            return true;
        }
        return true;
    }
}
