package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.bykvm_19do;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.msdk.adapter.config.TTBaseAdapterConfiguration;
import com.bytedance.msdk.api.v2.GMNetworkRequestInfo;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class h extends d {

    /* renamed from: c  reason: collision with root package name */
    private String f978c;

    /* renamed from: d  reason: collision with root package name */
    private String f979d;

    public h(Context context) {
        super(context, null);
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.a c2 = c();
        if (c2 != null) {
            this.f978c = c2.a();
            this.f979d = c2.b();
        }
    }

    public h(Context context, GMNetworkRequestInfo gMNetworkRequestInfo) {
        super(context, gMNetworkRequestInfo);
        if (gMNetworkRequestInfo != null) {
            this.f978c = gMNetworkRequestInfo.getAppId();
            this.f979d = gMNetworkRequestInfo.getAppKey();
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.bykvm_19do.c
    public String a() {
        return (TextUtils.isEmpty(this.f978c) || TextUtils.isEmpty(this.f979d)) ? "appId为空或appKey为空" : "";
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.bykvm_19do.c
    public String b() {
        return "mintegral";
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.bykvm_19do.c
    public Map<String, Object> d() {
        HashMap hashMap = new HashMap();
        hashMap.put("app_id", this.f978c);
        hashMap.put(TTBaseAdapterConfiguration.APP_KEY_EXTRA_KEY, this.f979d);
        return hashMap;
    }
}
