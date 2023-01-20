package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.bykvm_19do;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.msdk.api.v2.GMNetworkRequestInfo;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class e extends d {

    /* renamed from: c  reason: collision with root package name */
    private String f975c;

    public e(Context context) {
        super(context, null);
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.a c2 = c();
        if (c2 != null) {
            this.f975c = c2.a();
        }
    }

    public e(Context context, GMNetworkRequestInfo gMNetworkRequestInfo) {
        super(context, gMNetworkRequestInfo);
        if (gMNetworkRequestInfo != null) {
            this.f975c = gMNetworkRequestInfo.getAppId();
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.bykvm_19do.c
    public String a() {
        return TextUtils.isEmpty(this.f975c) ? "appId为空" : "";
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.bykvm_19do.c
    public String b() {
        return "gdt";
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.bykvm_19do.c
    public Map<String, Object> d() {
        HashMap hashMap = new HashMap();
        hashMap.put("app_id", this.f975c);
        return hashMap;
    }
}
