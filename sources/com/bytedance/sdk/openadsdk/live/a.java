package com.bytedance.sdk.openadsdk.live;

import android.os.Bundle;
import com.bytedance.sdk.openadsdk.TTAdEvent;
import java.io.Serializable;
import java.util.Map;

/* loaded from: classes.dex */
public class a extends com.bytedance.sdk.openadsdk.downloadnew.a implements Serializable {
    private static final a b = new a();
    public static TTAdEvent a = null;

    private a() {
    }

    public static a a() {
        return b;
    }

    public void a(ITTLiveTokenInjectionAuth iTTLiveTokenInjectionAuth) {
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.a, com.bytedance.sdk.openadsdk.TTAdBridge
    public <T> T callMethod(Class<T> cls, int i2, Map<String, Object> map) {
        return (T) super.callMethod(cls, i2, map);
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.a, com.bytedance.sdk.openadsdk.TTAdBridge
    public <T> T getObj(Class<T> cls, int i2, Map<String, Object> map) {
        return (T) super.getObj(cls, i2, map);
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.a, com.bytedance.sdk.openadsdk.TTAdBridge
    public void init(Bundle bundle) {
        super.init(bundle);
    }

    @Override // com.bytedance.sdk.openadsdk.downloadnew.a, com.bytedance.sdk.openadsdk.TTAdBridge
    public void subscribe(TTAdEvent tTAdEvent) {
    }
}
