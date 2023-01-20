package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.bykvm_19do;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.msdk.adapter.config.TTBaseAdapterConfiguration;
import com.bytedance.msdk.api.v2.GMNetworkRequestInfo;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class l extends d {

    /* renamed from: c  reason: collision with root package name */
    private String f981c;

    /* renamed from: d  reason: collision with root package name */
    private String f982d;

    public l(Context context) {
        super(context, null);
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.a c2 = c();
        if (c2 != null) {
            this.f981c = c2.a();
            this.f982d = c2.b();
        }
    }

    public l(Context context, GMNetworkRequestInfo gMNetworkRequestInfo) {
        super(context, gMNetworkRequestInfo);
        if (gMNetworkRequestInfo != null) {
            this.f981c = gMNetworkRequestInfo.getAppId();
            this.f982d = gMNetworkRequestInfo.getAppKey();
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.bykvm_19do.c
    public String a() {
        return (TextUtils.isEmpty(this.f981c) || TextUtils.isEmpty(this.f982d)) ? "appId为空或appKey为空" : "";
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.bykvm_19do.c
    public String b() {
        return "sigmob";
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.bykvm_19do.c
    public Map<String, Object> d() {
        HashMap hashMap = new HashMap();
        hashMap.put("app_id", this.f981c);
        hashMap.put(TTBaseAdapterConfiguration.APP_KEY_EXTRA_KEY, this.f982d);
        return hashMap;
    }
}
