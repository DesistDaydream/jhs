package bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class c2 extends e2 {

    /* renamed from: e  reason: collision with root package name */
    private final j2 f100e;

    public c2(Context context, j2 j2Var) {
        super(true, false);
        this.f100e = j2Var;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.e2
    public boolean a(JSONObject jSONObject) {
        if (!TextUtils.isEmpty(this.f100e.i())) {
            jSONObject.put("ab_client", this.f100e.i());
        }
        if (!TextUtils.isEmpty(this.f100e.L())) {
            if (l0.a) {
                l0.a("init config has abversion:" + this.f100e.L(), null);
            }
            jSONObject.put("ab_version", this.f100e.L());
        }
        if (!TextUtils.isEmpty(this.f100e.j())) {
            jSONObject.put("ab_group", this.f100e.j());
        }
        if (TextUtils.isEmpty(this.f100e.k())) {
            return true;
        }
        jSONObject.put("ab_feature", this.f100e.k());
        return true;
    }
}
