package bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.Context;
import android.telephony.TelephonyManager;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class q extends e2 {

    /* renamed from: e  reason: collision with root package name */
    private final Context f155e;

    public q(Context context) {
        super(true, false);
        this.f155e = context;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.e2
    public boolean a(JSONObject jSONObject) {
        k2.a(jSONObject, "sim_region", ((TelephonyManager) this.f155e.getSystemService("phone")).getSimCountryIso());
        return true;
    }
}
