package com.bytedance.sdk.openadsdk.api.plugin;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.AdConfig;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.TTInitializer;
import com.bytedance.sdk.openadsdk.api.plugin.f;
import dalvik.system.DexClassLoader;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class g implements TTInitializer {
    private volatile TTInitializer b;

    /* renamed from: c */
    private static final Map<String, Bundle> f2441c = new ConcurrentHashMap();
    public static ScheduledExecutorService a = Executors.newSingleThreadScheduledExecutor(new b());

    /* loaded from: classes.dex */
    public static class a implements TTAdSdk.InitCallback {
        private TTAdSdk.InitCallback a;

        public a(TTAdSdk.InitCallback initCallback) {
            this.a = initCallback;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
        public void fail(int i2, String str) {
            TTAdSdk.InitCallback initCallback = this.a;
            if (initCallback != null) {
                initCallback.fail(i2, str);
                d.b(i2, str, 0L);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
        public void success() {
            TTAdSdk.InitCallback initCallback = this.a;
            if (initCallback != null) {
                initCallback.success();
            }
            d.a();
        }
    }

    private static TTInitializer b(AdConfig adConfig, e eVar) {
        DexClassLoader a2;
        try {
            eVar.b("call_create_initializer");
            a2 = f.a(TTAppContextHolder.getContext()).a(eVar);
        } catch (Throwable th) {
            if (th instanceof c) {
                c cVar = th;
                d.a(cVar.a(), cVar.getMessage(), 0L);
            } else {
                d.a(6, th.getMessage(), 0L);
            }
            com.bytedance.sdk.openadsdk.api.a.e("TTPluginManager", "Create initializer failed: " + th);
        }
        if (a2 == null) {
            d.a(6, "Load plugin failed", 0L);
            com.bytedance.sdk.openadsdk.api.a.e("TTPluginManager", "Load plugin failed");
            return null;
        }
        Class<?> loadClass = a2.loadClass(TTAdSdk.INITIALIZER_CLASS_NAME);
        eVar.b("get_init_class_cost");
        Bundle bundle = new Bundle();
        bundle.putSerializable(PluginConstants.KEY_PL_UPDATE_LISTENER, new f.b());
        bundle.putBundle(PluginConstants.KEY_PL_CONFIG_INFO, a(f2441c));
        eVar.b("create_bundle_cost");
        Method declaredMethod = loadClass.getDeclaredMethod("getInstance", Bundle.class);
        eVar.b("get_init_method_cost");
        TTInitializer tTInitializer = (TTInitializer) declaredMethod.invoke(null, bundle);
        eVar.b("get_init_instance_cost");
        com.bytedance.sdk.openadsdk.api.a.b("TTPluginManager", "Create initializer success");
        return tTInitializer;
    }

    @Override // com.bytedance.sdk.openadsdk.TTInitializer
    public TTAdManager getAdManager() {
        return com.bytedance.sdk.openadsdk.api.plugin.a.a;
    }

    @Override // com.bytedance.sdk.openadsdk.TTInitializer
    public void init(Context context, AdConfig adConfig, TTAdSdk.InitCallback initCallback) {
        if (Build.VERSION.SDK_INT < 21) {
            initCallback.fail(4201, "Only support >= 5.0");
            return;
        }
        f.a(context).a();
        if (this.b != null) {
            this.b.init(context, adConfig, new a(initCallback));
        } else {
            a(context, adConfig, new a(initCallback), e.a("duration"));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTInitializer
    public boolean isInitSuccess() {
        if (this.b != null) {
            return this.b.isInitSuccess();
        }
        return false;
    }

    public static void a(String str, Bundle bundle) {
        if (TextUtils.isEmpty(str) || bundle == null) {
            return;
        }
        f2441c.put(str, bundle);
    }

    /* loaded from: classes.dex */
    public static class b implements ThreadFactory {
        private final ThreadGroup a;
        private final AtomicInteger b;

        /* renamed from: c */
        private final String f2445c;

        public b() {
            this.b = new AtomicInteger(1);
            this.a = new ThreadGroup("csj_g_pl_init");
            this.f2445c = "csj_pl_init";
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            ThreadGroup threadGroup = this.a;
            Thread thread = new Thread(threadGroup, runnable, this.f2445c + this.b.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 10) {
                thread.setPriority(10);
            }
            return thread;
        }

        public b(String str) {
            this.b = new AtomicInteger(1);
            this.a = new ThreadGroup("csj_g_pl_init");
            this.f2445c = str;
        }
    }

    private void a(final Context context, final AdConfig adConfig, final TTAdSdk.InitCallback initCallback, final e eVar) {
        a.execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.plugin.g.1
            {
                g.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                eVar.b("wait_asyn_cost");
                TTInitializer a2 = g.this.a(adConfig, eVar);
                if (a2 != null) {
                    com.bytedance.sdk.openadsdk.api.plugin.a.a.a(a2.getAdManager());
                    a2.init(context, adConfig, initCallback);
                    a2.getAdManager().register(com.bytedance.sdk.openadsdk.a.b.a());
                    return;
                }
                initCallback.fail(4201, "No initializer");
            }
        });
    }

    public TTInitializer a(AdConfig adConfig, e eVar) {
        if (this.b == null) {
            synchronized (this) {
                if (this.b == null) {
                    d.a(adConfig);
                    com.bytedance.sdk.openadsdk.api.a.b("TTPluginManager", "Create initializer");
                    this.b = b(adConfig, eVar);
                    eVar.a();
                    JSONObject jSONObject = new JSONObject();
                    eVar.a(jSONObject, 20L);
                    try {
                        jSONObject.put("zeus", f.a(TTAppContextHolder.getContext()).b());
                    } catch (JSONException unused) {
                    }
                    adConfig.setExtra("plugin", jSONObject);
                }
            }
        }
        return this.b;
    }

    @Override // com.bytedance.sdk.openadsdk.TTInitializer
    public TTAdManager init(Context context, AdConfig adConfig) {
        throw new RuntimeException("Please use init(Context context, AdConfig config, TTAdSdk.InitCallback callback)!");
    }

    private static final Bundle a(Map<String, Bundle> map) {
        if (map != null && map.size() != 0) {
            Bundle bundle = new Bundle();
            for (Map.Entry<String, Bundle> entry : map.entrySet()) {
                String key = entry.getKey();
                Bundle value = entry.getValue();
                if (!TextUtils.isEmpty(key) && value != null) {
                    bundle.putBundle(key, value);
                }
            }
            return bundle;
        }
        return new Bundle();
    }
}
