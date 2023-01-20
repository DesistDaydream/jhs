package com.huawei.agconnect.config.impl;

import android.content.Context;
import android.util.Log;
import com.huawei.agconnect.AGCRoutePolicy;
import com.huawei.agconnect.JsonProcessingFactory;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.agconnect.config.LazyInputStream;
import com.moor.imkf.lib.jsoup.nodes.Attributes;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes2.dex */
public class c extends AGConnectServicesConfig {
    private final Context a;
    private final String b;

    /* renamed from: c  reason: collision with root package name */
    private LazyInputStream f3383c;

    /* renamed from: d  reason: collision with root package name */
    private volatile d f3384d;

    /* renamed from: e  reason: collision with root package name */
    private final Object f3385e = new Object();

    /* renamed from: f  reason: collision with root package name */
    private AGCRoutePolicy f3386f = AGCRoutePolicy.UNKNOWN;

    /* renamed from: g  reason: collision with root package name */
    private final Map<String, String> f3387g = new HashMap();

    /* renamed from: h  reason: collision with root package name */
    private volatile e f3388h;

    public c(Context context, String str) {
        this.a = context;
        this.b = str;
    }

    private static LazyInputStream a(Context context, final InputStream inputStream) {
        return new LazyInputStream(context) { // from class: com.huawei.agconnect.config.impl.c.1
            @Override // com.huawei.agconnect.config.LazyInputStream
            public InputStream get(Context context2) {
                return inputStream;
            }
        };
    }

    private static String a(String str) {
        int i2 = 0;
        if (str.length() > 0) {
            while (str.charAt(i2) == '/') {
                i2++;
            }
        }
        return Attributes.InternalPrefix + str.substring(i2);
    }

    private void a() {
        if (this.f3384d == null) {
            synchronized (this.f3385e) {
                if (this.f3384d == null) {
                    LazyInputStream lazyInputStream = this.f3383c;
                    if (lazyInputStream != null) {
                        this.f3384d = new h(lazyInputStream.loadInputStream());
                        this.f3383c.close();
                        this.f3383c = null;
                    } else {
                        this.f3384d = new k(this.a, this.b);
                    }
                    this.f3388h = new e(this.f3384d);
                }
                b();
            }
        }
    }

    private String b(String str) {
        JsonProcessingFactory.JsonProcessor jsonProcessor;
        Map<String, JsonProcessingFactory.JsonProcessor> processors = JsonProcessingFactory.getProcessors();
        if (processors.containsKey(str) && (jsonProcessor = processors.get(str)) != null) {
            return jsonProcessor.processOption(this);
        }
        return null;
    }

    private void b() {
        if (this.f3386f == AGCRoutePolicy.UNKNOWN) {
            if (this.f3384d != null) {
                this.f3386f = Utils.getRoutePolicyFromJson(this.f3384d.a("/region", null), this.f3384d.a("/agcgw/url", null));
            } else {
                Log.w("AGConnectServiceConfig", "get route fail , config not ready");
            }
        }
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public boolean getBoolean(String str) {
        return getBoolean(str, false);
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public boolean getBoolean(String str, boolean z) {
        return Boolean.parseBoolean(getString(str, String.valueOf(z)));
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public Context getContext() {
        return this.a;
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public String getIdentifier() {
        return Utils.DEFAULT_NAME;
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public int getInt(String str) {
        return getInt(str, 0);
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public int getInt(String str, int i2) {
        try {
            return Integer.parseInt(getString(str, String.valueOf(i2)));
        } catch (NumberFormatException unused) {
            return i2;
        }
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public String getPackageName() {
        return this.b;
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public AGCRoutePolicy getRoutePolicy() {
        if (this.f3386f == null) {
            this.f3386f = AGCRoutePolicy.UNKNOWN;
        }
        AGCRoutePolicy aGCRoutePolicy = this.f3386f;
        AGCRoutePolicy aGCRoutePolicy2 = AGCRoutePolicy.UNKNOWN;
        if (aGCRoutePolicy == aGCRoutePolicy2 && this.f3384d == null) {
            a();
        }
        AGCRoutePolicy aGCRoutePolicy3 = this.f3386f;
        return aGCRoutePolicy3 == null ? aGCRoutePolicy2 : aGCRoutePolicy3;
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public String getString(String str) {
        return getString(str, null);
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public String getString(String str, String str2) {
        Objects.requireNonNull(str, "path must not be null.");
        if (this.f3384d == null) {
            a();
        }
        String a = a(str);
        String str3 = this.f3387g.get(a);
        if (str3 != null) {
            return str3;
        }
        String b = b(a);
        if (b != null) {
            return b;
        }
        String a2 = this.f3384d.a(a, str2);
        return e.a(a2) ? this.f3388h.a(a2, str2) : a2;
    }

    @Override // com.huawei.agconnect.config.AGConnectServicesConfig
    public void overlayWith(LazyInputStream lazyInputStream) {
        this.f3383c = lazyInputStream;
    }

    @Override // com.huawei.agconnect.config.AGConnectServicesConfig
    public void overlayWith(InputStream inputStream) {
        overlayWith(a(this.a, inputStream));
    }

    @Override // com.huawei.agconnect.config.AGConnectServicesConfig
    public void setParam(String str, String str2) {
        this.f3387g.put(Utils.fixPath(str), str2);
    }

    @Override // com.huawei.agconnect.config.AGConnectServicesConfig
    public void setRoutePolicy(AGCRoutePolicy aGCRoutePolicy) {
        this.f3386f = aGCRoutePolicy;
    }
}
