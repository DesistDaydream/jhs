package com.huawei.agconnect.config.impl;

import android.content.Context;
import com.huawei.agconnect.AGCRoutePolicy;
import com.huawei.agconnect.AGConnectOptions;
import com.huawei.agconnect.JsonProcessingFactory;
import com.huawei.agconnect.core.Service;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class b implements AGConnectOptions {
    private final String a;
    private final Context b;

    /* renamed from: c  reason: collision with root package name */
    private final String f3376c;

    /* renamed from: d  reason: collision with root package name */
    private final AGCRoutePolicy f3377d;

    /* renamed from: e  reason: collision with root package name */
    private final d f3378e;

    /* renamed from: f  reason: collision with root package name */
    private final e f3379f;

    /* renamed from: g  reason: collision with root package name */
    private final Map<String, String> f3380g;

    /* renamed from: h  reason: collision with root package name */
    private final List<Service> f3381h;

    /* renamed from: i  reason: collision with root package name */
    private final Map<String, String> f3382i = new HashMap();

    public b(Context context, String str, AGCRoutePolicy aGCRoutePolicy, InputStream inputStream, Map<String, String> map, List<Service> list, String str2) {
        context = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.b = context;
        str = str == null ? context.getPackageName() : str;
        this.f3376c = str;
        if (inputStream != null) {
            this.f3378e = new h(inputStream, str);
            Utils.closeQuietly(inputStream);
        } else {
            this.f3378e = new k(context, str);
        }
        this.f3379f = new e(this.f3378e);
        AGCRoutePolicy aGCRoutePolicy2 = AGCRoutePolicy.UNKNOWN;
        if (aGCRoutePolicy != aGCRoutePolicy2 && "1.0".equals(this.f3378e.a("/configuration_version", null))) {
            throw new RuntimeException("The file version does not match,please download the latest agconnect-services.json from the AGC website.");
        }
        this.f3377d = (aGCRoutePolicy == null || aGCRoutePolicy == aGCRoutePolicy2) ? Utils.getRoutePolicyFromJson(this.f3378e.a("/region", null), this.f3378e.a("/agcgw/url", null)) : aGCRoutePolicy;
        this.f3380g = Utils.fixKeyPathMap(map);
        this.f3381h = list;
        this.a = str2 == null ? b() : str2;
    }

    private String a(String str) {
        Map<String, JsonProcessingFactory.JsonProcessor> processors = JsonProcessingFactory.getProcessors();
        if (processors.containsKey(str)) {
            if (this.f3382i.containsKey(str)) {
                return this.f3382i.get(str);
            }
            JsonProcessingFactory.JsonProcessor jsonProcessor = processors.get(str);
            if (jsonProcessor == null) {
                return null;
            }
            String processOption = jsonProcessor.processOption(this);
            this.f3382i.put(str, processOption);
            return processOption;
        }
        return null;
    }

    private String b() {
        return String.valueOf(("{packageName='" + this.f3376c + "', routePolicy=" + this.f3377d + ", reader=" + this.f3378e.toString().hashCode() + ", customConfigMap=" + new JSONObject(this.f3380g).toString().hashCode() + '}').hashCode());
    }

    public List<Service> a() {
        return this.f3381h;
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
        return this.b;
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public String getIdentifier() {
        return this.a;
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
        return this.f3376c;
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public AGCRoutePolicy getRoutePolicy() {
        AGCRoutePolicy aGCRoutePolicy = this.f3377d;
        return aGCRoutePolicy == null ? AGCRoutePolicy.UNKNOWN : aGCRoutePolicy;
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public String getString(String str) {
        return getString(str, null);
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public String getString(String str, String str2) {
        if (str == null) {
            return str2;
        }
        String fixPath = Utils.fixPath(str);
        String str3 = this.f3380g.get(fixPath);
        if (str3 != null) {
            return str3;
        }
        String a = a(fixPath);
        if (a != null) {
            return a;
        }
        String a2 = this.f3378e.a(fixPath, str2);
        return e.a(a2) ? this.f3379f.a(a2, str2) : a2;
    }
}
