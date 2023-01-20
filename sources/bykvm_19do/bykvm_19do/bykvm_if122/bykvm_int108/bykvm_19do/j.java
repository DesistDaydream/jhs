package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.bykvm_19do;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.msdk.adapter.config.TTBaseAdapterConfiguration;
import com.bytedance.msdk.api.v2.GMNetworkRequestInfo;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class j extends d {

    /* renamed from: c  reason: collision with root package name */
    public String f980c;

    public j(Context context) {
        super(context, null);
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.a c2 = c();
        if (c2 != null) {
            this.f980c = c2.a();
        }
        if (TextUtils.isEmpty(this.f980c)) {
            this.f980c = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().b();
        }
    }

    public j(Context context, GMNetworkRequestInfo gMNetworkRequestInfo) {
        super(context, gMNetworkRequestInfo);
        if (gMNetworkRequestInfo != null) {
            this.f980c = gMNetworkRequestInfo.getAppId();
        }
    }

    public static j a(Context context) {
        return bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().z() ? new k(context) : new i(context);
    }

    public static j a(Context context, GMNetworkRequestInfo gMNetworkRequestInfo) {
        return bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().z() ? new k(context, gMNetworkRequestInfo) : new i(context, gMNetworkRequestInfo);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.bykvm_19do.c
    public String a() {
        return TextUtils.isEmpty(this.f980c) ? "appId为空" : "";
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.bykvm_19do.c
    public Map<String, Object> d() {
        HashMap hashMap = new HashMap();
        hashMap.put("app_id", this.f980c);
        hashMap.put(TTBaseAdapterConfiguration.PANGLE_IS_PANGLE_USE_TEXTURE_VIEW, Boolean.valueOf(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().D()));
        hashMap.put(TTBaseAdapterConfiguration.PANGLE_APP_NAME, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().i());
        hashMap.put(TTBaseAdapterConfiguration.PANGLE_IS_PANGLE_PAID, Boolean.valueOf(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().C()));
        hashMap.put(TTBaseAdapterConfiguration.PANGLE_TITLE_BAR_THEME, Integer.valueOf(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().o()));
        hashMap.put(TTBaseAdapterConfiguration.PANGLE_IS_PANGLE_ALLOW_SHOW_NOTIFY, Boolean.valueOf(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().A()));
        hashMap.put(TTBaseAdapterConfiguration.PANGLE_IS_PANGLE_ALLOW_SHOW_PAGE_WHEN_SCREEN_LOCK, Boolean.valueOf(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().B()));
        hashMap.put(TTBaseAdapterConfiguration.PANGLE_DIRECT_DOWNLOAD_NETWORKTYPE, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().p());
        hashMap.put(TTBaseAdapterConfiguration.PANGLE_NEED_CLEAR_TASK_RESET, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().m());
        hashMap.put(TTBaseAdapterConfiguration.PANGLE_KEYWORDS, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().l());
        hashMap.put(TTBaseAdapterConfiguration.PANGLE_PLUGIN_UPDATE_CONFIG, Integer.valueOf(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().n()));
        return hashMap;
    }
}
