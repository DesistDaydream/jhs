package bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.UUID;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class h2 extends e2 {

    /* renamed from: e  reason: collision with root package name */
    private final Context f120e;

    public h2(Context context) {
        super(false, false);
        this.f120e = context;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.e2
    public boolean a(JSONObject jSONObject) {
        SharedPreferences sharedPreferences = this.f120e.getSharedPreferences("snssdk_openudid", 0);
        String string = sharedPreferences.getString("clientudid", null);
        if (!k2.a(string)) {
            try {
                string = a("clientudid.dat", UUID.randomUUID().toString());
            } catch (Exception unused) {
            }
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString("clientudid", string);
            edit.apply();
        }
        jSONObject.put("clientudid", string);
        return true;
    }
}
