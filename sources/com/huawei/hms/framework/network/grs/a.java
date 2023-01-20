package com.huawei.hms.framework.network.grs;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.g.h;
import com.huawei.hms.framework.network.grs.local.model.CountryCodeBean;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: e */
    private static final String f3445e = "a";
    private final GrsBaseInfo a;
    private com.huawei.hms.framework.network.grs.e.a b;

    /* renamed from: c */
    private h f3446c;

    /* renamed from: d */
    private com.huawei.hms.framework.network.grs.e.c f3447d;

    /* renamed from: com.huawei.hms.framework.network.grs.a$a */
    /* loaded from: classes2.dex */
    public static class C0095a implements com.huawei.hms.framework.network.grs.b {
        public String a;
        public Map<String, String> b;

        /* renamed from: c */
        public IQueryUrlsCallBack f3448c;

        /* renamed from: d */
        public Context f3449d;

        /* renamed from: e */
        public GrsBaseInfo f3450e;

        /* renamed from: f */
        public com.huawei.hms.framework.network.grs.e.a f3451f;

        public C0095a(String str, Map<String, String> map, IQueryUrlsCallBack iQueryUrlsCallBack, Context context, GrsBaseInfo grsBaseInfo, com.huawei.hms.framework.network.grs.e.a aVar) {
            this.a = str;
            this.b = map;
            this.f3448c = iQueryUrlsCallBack;
            this.f3449d = context;
            this.f3450e = grsBaseInfo;
            this.f3451f = aVar;
        }

        @Override // com.huawei.hms.framework.network.grs.b
        public void a() {
            Map<String, String> map = this.b;
            if (map != null && !map.isEmpty()) {
                Logger.i(a.f3445e, "get expired cache localUrls");
                this.f3448c.onCallBackSuccess(this.b);
            } else if (this.b != null) {
                this.f3448c.onCallBackFail(-3);
            } else {
                Logger.i(a.f3445e, "access local config for return a domain.");
                this.f3448c.onCallBackSuccess(com.huawei.hms.framework.network.grs.f.b.a(this.f3449d.getPackageName(), this.f3450e).a(this.f3449d, this.f3451f, this.f3450e, this.a, true));
            }
        }

        @Override // com.huawei.hms.framework.network.grs.b
        public void a(com.huawei.hms.framework.network.grs.g.d dVar) {
            Map<String, String> a = a.a(dVar.j(), this.a);
            if (a.isEmpty()) {
                Map<String, String> map = this.b;
                if (map != null && !map.isEmpty()) {
                    Logger.i(a.f3445e, "get expired cache localUrls");
                    this.f3448c.onCallBackSuccess(this.b);
                    return;
                } else if (this.b != null) {
                    this.f3448c.onCallBackFail(-5);
                    return;
                } else {
                    Logger.i(a.f3445e, "access local config for return a domain.");
                    a = com.huawei.hms.framework.network.grs.f.b.a(this.f3449d.getPackageName(), this.f3450e).a(this.f3449d, this.f3451f, this.f3450e, this.a, true);
                }
            } else {
                Logger.i(a.f3445e, "get url is from remote server");
            }
            this.f3448c.onCallBackSuccess(a);
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements com.huawei.hms.framework.network.grs.b {
        public String a;
        public String b;

        /* renamed from: c */
        public IQueryUrlCallBack f3452c;

        /* renamed from: d */
        public String f3453d;

        /* renamed from: e */
        public Context f3454e;

        /* renamed from: f */
        public GrsBaseInfo f3455f;

        /* renamed from: g */
        public com.huawei.hms.framework.network.grs.e.a f3456g;

        public b(String str, String str2, IQueryUrlCallBack iQueryUrlCallBack, String str3, Context context, GrsBaseInfo grsBaseInfo, com.huawei.hms.framework.network.grs.e.a aVar) {
            this.a = str;
            this.b = str2;
            this.f3452c = iQueryUrlCallBack;
            this.f3453d = str3;
            this.f3454e = context;
            this.f3455f = grsBaseInfo;
            this.f3456g = aVar;
        }

        @Override // com.huawei.hms.framework.network.grs.b
        public void a() {
            if (!TextUtils.isEmpty(this.f3453d)) {
                Logger.i(a.f3445e, "get expired cache localUrl");
                this.f3452c.onCallBackSuccess(this.f3453d);
            } else if (!TextUtils.isEmpty(this.f3453d)) {
                this.f3452c.onCallBackFail(-3);
            } else {
                Logger.i(a.f3445e, "access local config for return a domain.");
                this.f3452c.onCallBackSuccess(com.huawei.hms.framework.network.grs.f.b.a(this.f3454e.getPackageName(), this.f3455f).a(this.f3454e, this.f3456g, this.f3455f, this.a, this.b, true));
            }
        }

        @Override // com.huawei.hms.framework.network.grs.b
        public void a(com.huawei.hms.framework.network.grs.g.d dVar) {
            String a;
            IQueryUrlCallBack iQueryUrlCallBack;
            Map<String, String> a2 = a.a(dVar.j(), this.a);
            if (a2.containsKey(this.b)) {
                Logger.i(a.f3445e, "get url is from remote server");
                iQueryUrlCallBack = this.f3452c;
                a = a2.get(this.b);
            } else if (!TextUtils.isEmpty(this.f3453d)) {
                Logger.i(a.f3445e, "get expired cache localUrl");
                this.f3452c.onCallBackSuccess(this.f3453d);
                return;
            } else if (!TextUtils.isEmpty(this.f3453d)) {
                this.f3452c.onCallBackFail(-5);
                return;
            } else {
                Logger.i(a.f3445e, "access local config for return a domain.");
                a = com.huawei.hms.framework.network.grs.f.b.a(this.f3454e.getPackageName(), this.f3455f).a(this.f3454e, this.f3456g, this.f3455f, this.a, this.b, true);
                iQueryUrlCallBack = this.f3452c;
            }
            iQueryUrlCallBack.onCallBackSuccess(a);
        }
    }

    public a(GrsBaseInfo grsBaseInfo, com.huawei.hms.framework.network.grs.e.a aVar, h hVar, com.huawei.hms.framework.network.grs.e.c cVar) {
        this.a = grsBaseInfo;
        this.b = aVar;
        this.f3446c = hVar;
        this.f3447d = cVar;
    }

    public static CountryCodeBean a(Context context, boolean z) {
        return new CountryCodeBean(context, z);
    }

    public static Map<String, Map<String, String>> a(String str) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(16);
        if (TextUtils.isEmpty(str)) {
            Logger.v(f3445e, "isSpExpire jsonValue is null.");
            return concurrentHashMap;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                if (!TextUtils.isEmpty(next)) {
                    concurrentHashMap.put(next, a(jSONObject2));
                }
            }
            return concurrentHashMap;
        } catch (JSONException e2) {
            Logger.w(f3445e, "getServicesUrlsMap occur a JSONException: %s", StringUtils.anonymizeMessage(e2.getMessage()));
            return concurrentHashMap;
        }
    }

    private Map<String, String> a(String str, com.huawei.hms.framework.network.grs.e.b bVar, Context context) {
        Map<String, String> a = this.b.a(this.a, str, bVar, context);
        if (a == null || a.isEmpty()) {
            Map<String, String> a2 = com.huawei.hms.framework.network.grs.f.b.a(context.getPackageName(), this.a).a(context, this.b, this.a, str, false);
            return a2 != null ? a2 : new HashMap();
        }
        com.huawei.hms.framework.network.grs.f.b.a(context, this.a);
        return a;
    }

    public static Map<String, String> a(String str, String str2) {
        HashMap hashMap = new HashMap();
        if (TextUtils.isEmpty(str)) {
            Logger.w(f3445e, "isSpExpire jsonValue from server is null.");
            return hashMap;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = jSONObject.has(str2) ? jSONObject.getJSONObject(str2) : null;
            if (jSONObject2 == null) {
                Logger.w(f3445e, "getServiceNameUrls: paser null from server json data by {%s}.", str2);
                return hashMap;
            }
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject2.get(next).toString());
            }
            return hashMap;
        } catch (JSONException e2) {
            Logger.w(f3445e, "Method{getServiceNameUrls} query url from SP occur an JSONException: %s", StringUtils.anonymizeMessage(e2.getMessage()));
            return hashMap;
        }
    }

    public static Map<String, String> a(JSONObject jSONObject) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(16);
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                String obj = jSONObject.get(next).toString();
                if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(obj)) {
                    concurrentHashMap.put(next, obj);
                }
            }
            return concurrentHashMap;
        } catch (JSONException e2) {
            Logger.w(f3445e, "getServiceUrls occur a JSONException: %s", StringUtils.anonymizeMessage(e2.getMessage()));
            return concurrentHashMap;
        }
    }

    public String a(Context context, String str) {
        com.huawei.hms.framework.network.grs.g.d a = this.f3446c.a(new com.huawei.hms.framework.network.grs.g.k.c(this.a, context), str, this.f3447d);
        return a == null ? "" : a.m() ? this.b.a().a(this.a.getGrsParasKey(true, true, context), "") : a.j();
    }

    public String a(String str, String str2, Context context) {
        com.huawei.hms.framework.network.grs.e.b bVar = new com.huawei.hms.framework.network.grs.e.b();
        String str3 = a(str, bVar, context).get(str2);
        if (bVar.a() && !TextUtils.isEmpty(str3)) {
            Logger.i(f3445e, "get unexpired cache localUrl: %s", StringUtils.anonymizeMessage(str3));
            com.huawei.hms.framework.network.grs.f.b.a(context, this.a);
            return str3;
        }
        String str4 = a(a(context, str), str).get(str2);
        if (!TextUtils.isEmpty(str4)) {
            Logger.i(f3445e, "get url is from remote server");
            com.huawei.hms.framework.network.grs.f.b.a(context, this.a);
            return str4;
        }
        if (TextUtils.isEmpty(str3)) {
            Logger.i(f3445e, "access local config for return a domain.");
            str3 = com.huawei.hms.framework.network.grs.f.b.a(context.getPackageName(), this.a).a(context, this.b, this.a, str, str2, true);
        } else {
            Logger.i(f3445e, "get expired cache localUrl");
        }
        Logger.i(f3445e, "synGetGrsUrl: %s", StringUtils.anonymizeMessage(str3));
        return str3;
    }

    public Map<String, String> a(String str, Context context) {
        com.huawei.hms.framework.network.grs.e.b bVar = new com.huawei.hms.framework.network.grs.e.b();
        Map<String, String> a = a(str, bVar, context);
        if (bVar.a() && !a.isEmpty()) {
            Logger.i(f3445e, "get unexpired cache localUrls: %s", StringUtils.anonymizeMessage(new JSONObject(a).toString()));
            com.huawei.hms.framework.network.grs.f.b.a(context, this.a);
            return a;
        }
        Map<String, String> a2 = a(a(context, str), str);
        if (!a2.isEmpty()) {
            Logger.i(f3445e, "get url is from remote server");
            com.huawei.hms.framework.network.grs.f.b.a(context, this.a);
            return a2;
        }
        if (a.isEmpty()) {
            Logger.i(f3445e, "access local config for return a domain.");
            a = com.huawei.hms.framework.network.grs.f.b.a(context.getPackageName(), this.a).a(context, this.b, this.a, str, true);
        } else {
            Logger.i(f3445e, "get expired cache localUrls");
        }
        String str2 = f3445e;
        Object[] objArr = new Object[1];
        objArr[0] = StringUtils.anonymizeMessage(a != null ? new JSONObject(a).toString() : "");
        Logger.i(str2, "synGetGrsUrls: %s", objArr);
        return a;
    }

    public void a(String str, IQueryUrlsCallBack iQueryUrlsCallBack, Context context) {
        com.huawei.hms.framework.network.grs.e.b bVar = new com.huawei.hms.framework.network.grs.e.b();
        Map<String, String> a = a(str, bVar, context);
        if (!bVar.a()) {
            this.f3446c.a(new com.huawei.hms.framework.network.grs.g.k.c(this.a, context), new C0095a(str, a, iQueryUrlsCallBack, context, this.a, this.b), str, this.f3447d);
            return;
        }
        String str2 = f3445e;
        Logger.i(str2, "get unexpired cache localUrls");
        if (a.isEmpty()) {
            iQueryUrlsCallBack.onCallBackFail(-5);
            return;
        }
        com.huawei.hms.framework.network.grs.f.b.a(context, this.a);
        Logger.i(str2, "ayncGetGrsUrls: %s", StringUtils.anonymizeMessage(new JSONObject(a).toString()));
        iQueryUrlsCallBack.onCallBackSuccess(a);
    }

    public void a(String str, String str2, IQueryUrlCallBack iQueryUrlCallBack, Context context) {
        com.huawei.hms.framework.network.grs.e.b bVar = new com.huawei.hms.framework.network.grs.e.b();
        String str3 = a(str, bVar, context).get(str2);
        if (!bVar.a()) {
            this.f3446c.a(new com.huawei.hms.framework.network.grs.g.k.c(this.a, context), new b(str, str2, iQueryUrlCallBack, str3, context, this.a, this.b), str, this.f3447d);
            return;
        }
        String str4 = f3445e;
        Logger.i(str4, "get unexpired cache localUrl");
        if (TextUtils.isEmpty(str3)) {
            iQueryUrlCallBack.onCallBackFail(-5);
            return;
        }
        com.huawei.hms.framework.network.grs.f.b.a(context, this.a);
        Logger.i(str4, "ayncGetGrsUrl: %s", StringUtils.anonymizeMessage(str3));
        iQueryUrlCallBack.onCallBackSuccess(str3);
    }
}
