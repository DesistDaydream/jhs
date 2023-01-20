package bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.umeng.analytics.pro.am;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class r extends e2 {

    /* renamed from: e */
    private final Context f156e;

    /* renamed from: f */
    private final j2 f157f;

    public r(Context context, j2 j2Var) {
        super(true, false);
        this.f156e = context;
        this.f157f = j2Var;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.e2
    public boolean a(JSONObject jSONObject) {
        TelephonyManager telephonyManager = (TelephonyManager) this.f156e.getSystemService("phone");
        if (telephonyManager != null) {
            try {
                k2.a(jSONObject, am.P, telephonyManager.getNetworkOperatorName());
                k2.a(jSONObject, "mcc_mnc", telephonyManager.getNetworkOperator());
                k2.a(jSONObject, "udid", this.f157f.o() ? i0.a(telephonyManager) : this.f157f.m());
                return true;
            } catch (Exception e2) {
                l0.a(e2);
                return false;
            }
        }
        return false;
    }
}
