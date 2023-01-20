package bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.android.tpush.XGPushNotificationBuilder;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class i2 extends e2 {

    /* renamed from: e */
    private final Context f121e;

    /* renamed from: f */
    private final j2 f122f;

    public i2(Context context, j2 j2Var) {
        super(false, false);
        this.f121e = context;
        this.f122f = j2Var;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.e2
    public boolean a(JSONObject jSONObject) {
        jSONObject.put("sdk_version", 336);
        jSONObject.put("sdk_version_name", "3.6.0-rc.10-embed");
        jSONObject.put("channel", this.f122f.C());
        k2.a(jSONObject, "aid", this.f122f.B());
        k2.a(jSONObject, "release_build", this.f122f.S());
        k2.a(jSONObject, "app_region", this.f122f.F());
        k2.a(jSONObject, "app_language", this.f122f.E());
        k2.a(jSONObject, "user_agent", this.f122f.a());
        k2.a(jSONObject, "ab_sdk_version", this.f122f.H());
        k2.a(jSONObject, "ab_version", this.f122f.L());
        k2.a(jSONObject, "aliyun_uuid", this.f122f.t());
        String D = this.f122f.D();
        if (TextUtils.isEmpty(D)) {
            D = g0.a(this.f121e, this.f122f);
        }
        if (!TextUtils.isEmpty(D)) {
            k2.a(jSONObject, "google_aid", D);
        }
        String R = this.f122f.R();
        if (!TextUtils.isEmpty(R)) {
            try {
                jSONObject.put("app_track", new JSONObject(R));
            } catch (Throwable th) {
                l0.a(th);
            }
        }
        String G = this.f122f.G();
        if (G != null && G.length() > 0) {
            jSONObject.put(XGPushNotificationBuilder.CUSTOM_NOTIFICATION_BUILDER_TYPE, new JSONObject(G));
        }
        k2.a(jSONObject, "user_unique_id", this.f122f.I());
        return true;
    }
}
