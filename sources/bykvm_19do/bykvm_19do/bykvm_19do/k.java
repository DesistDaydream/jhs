package bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.Context;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class k extends e2 {

    /* renamed from: e  reason: collision with root package name */
    private final Context f138e;

    /* renamed from: f  reason: collision with root package name */
    private final j2 f139f;

    public k(Context context, j2 j2Var) {
        super(true, false);
        this.f138e = context;
        this.f139f = j2Var;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.e2
    public boolean a(JSONObject jSONObject) {
        Map<String, String> a = s0.a(this.f138e, this.f139f.w());
        if (a != null) {
            jSONObject.put("oaid", new JSONObject(a));
            return true;
        }
        return false;
    }
}
