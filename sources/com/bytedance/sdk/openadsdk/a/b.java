package com.bytedance.sdk.openadsdk.a;

import android.app.Application;
import android.os.Bundle;
import com.bytedance.sdk.openadsdk.TTAdBridge;
import com.bytedance.sdk.openadsdk.TTAdEvent;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.a.a;
import java.util.Map;

/* loaded from: classes.dex */
public class b implements TTAdBridge {
    private static volatile b a;
    private a b = new a();

    private b() {
    }

    public static final b a() {
        if (a == null) {
            synchronized (b.class) {
                if (a == null) {
                    a = new b();
                }
            }
        }
        return a;
    }

    public Application.ActivityLifecycleCallbacks b() {
        return this.b;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdBridge
    public String call(int i2, Bundle bundle) {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdBridge
    public <T> T callMethod(Class<T> cls, int i2, Map<String, Object> map) {
        if (i2 != 2) {
            if (i2 != 3) {
                return null;
            }
            return (T) TTAppContextHolder.getContext();
        }
        return (T) this.b.a();
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdBridge
    public <T> T getObj(Class<T> cls) {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdBridge
    public <T> T getObj(Class<T> cls, int i2, Map<String, Object> map) {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdBridge
    public void init(Bundle bundle) {
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdBridge
    public void removeObj(Object obj) {
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdBridge
    public void setObj(Object obj) {
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdBridge
    public void subscribe(final TTAdEvent tTAdEvent) {
        this.b.a(new a.InterfaceC0086a() { // from class: com.bytedance.sdk.openadsdk.a.b.1
            @Override // com.bytedance.sdk.openadsdk.a.a.InterfaceC0086a
            public void a() {
                tTAdEvent.onEvent(0, null);
            }

            @Override // com.bytedance.sdk.openadsdk.a.a.InterfaceC0086a
            public void b() {
                tTAdEvent.onEvent(1, null);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdBridge
    public void unsubscribe(TTAdEvent tTAdEvent) {
    }
}
