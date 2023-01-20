package bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class g2 extends e2 {

    /* renamed from: e  reason: collision with root package name */
    private final j2 f108e;

    public g2(Context context, j2 j2Var) {
        super(true, false);
        this.f108e = j2Var;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.e2
    public boolean a(JSONObject jSONObject) {
        String a = s0.a(this.f108e.w());
        if (TextUtils.isEmpty(a)) {
            return false;
        }
        jSONObject.put("cdid", a);
        return true;
    }
}
