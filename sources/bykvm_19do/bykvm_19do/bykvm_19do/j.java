package bykvm_19do.bykvm_19do.bykvm_19do;

import android.annotation.SuppressLint;
import android.content.Context;
import com.umeng.analytics.pro.am;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class j extends e2 {

    /* renamed from: e */
    private final Context f123e;

    public j(Context context) {
        super(true, true);
        this.f123e = context;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.e2
    @SuppressLint({"MissingPermission"})
    public boolean a(JSONObject jSONObject) {
        k2.a(jSONObject, am.Q, h0.b(this.f123e));
        return true;
    }
}
