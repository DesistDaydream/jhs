package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108;

import android.os.SystemClock;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.e;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.c0;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.l0;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.q;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.v2.GMConfigCallback;
import com.bytedance.msdk.api.v2.GMSettingConfigCallback;
import com.umeng.analytics.pro.am;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class d implements bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.a {
    private int B;
    private String C;
    private String a;
    private long b;

    /* renamed from: c */
    private long f879c;

    /* renamed from: d */
    private String f880d;

    /* renamed from: e */
    private String f881e;

    /* renamed from: f */
    private String f882f;

    /* renamed from: g */
    private String f883g;

    /* renamed from: h */
    private int f884h;

    /* renamed from: i */
    private String f885i;

    /* renamed from: j */
    private String f886j;

    /* renamed from: k */
    private int f887k;
    private long o;
    private long p;
    private int w;
    private JSONObject z;

    /* renamed from: l */
    private String f888l = null;

    /* renamed from: m */
    private int f889m = 0;
    private String n = "log-api.pangolin-sdk-toutiao.com/service/2/app_log/";
    private List<GMSettingConfigCallback> q = new CopyOnWriteArrayList();
    private Map<String, Boolean> r = new HashMap();
    private final AtomicBoolean s = new AtomicBoolean(false);
    private int t = 0;
    private Map<String, String> u = new ConcurrentHashMap();
    private Map<String, List<String>> v = new ConcurrentHashMap();
    private Map<String, e> x = new ConcurrentHashMap();
    private int y = 0;
    private final List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.d> A = new CopyOnWriteArrayList();

    /* loaded from: classes.dex */
    public class a implements bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_int108.b {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ boolean b;

        /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.d$a$a */
        /* loaded from: classes.dex */
        public class C0041a implements GMConfigCallback {
            public C0041a(a aVar) {
            }

            @Override // com.bytedance.msdk.api.v2.GMConfigCallback
            public void onConfigLoadFail(AdError adError) {
            }

            @Override // com.bytedance.msdk.api.v2.GMConfigCallback
            public void onConfigLoaded(List<String> list) {
                Logger.d("TMe", "初始化更新pangle配置成功");
            }
        }

        public a(boolean z, boolean z2) {
            d.this = r1;
            this.a = z;
            this.b = z2;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_int108.b
        public void a() {
            Logger.e("TTMediationSDK_SDK_Init", "MSDK init finish.........hasConfig:" + this.a);
            if (this.a) {
                if (!d.this.s.get()) {
                    d.this.s.set(true);
                    int c2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.a.c();
                    long elapsedRealtime = SystemClock.elapsedRealtime() - bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.d.h();
                    if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.e.d()) {
                        Logger.d("TMe", "-----==---- 正常上报sdk_init_end");
                        h.a(elapsedRealtime, c2, this.b ? 1 : 0, -1L);
                    } else {
                        Logger.d("TMe", "-----==---- 延时上报sdk_init_end");
                        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.e.a(elapsedRealtime, c2, this.b ? 1 : 0);
                    }
                    d.this.V();
                    Logger.d("TTMediationSDK", "sdk init end, duration: " + elapsedRealtime + ", initAdnCount: " + c2 + ", isFromLocalConfig: " + this.b);
                }
                c.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f()).a(new C0041a(this));
                d.this.W();
                if (this.b) {
                    return;
                }
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.b.c();
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.a.i();
            }
        }
    }

    public static String K() {
        return "tt_sdk_adn_init_settings_" + bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().b();
    }

    public static String L() {
        return "tt_sdk_app_common_settings_" + bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().b();
    }

    public static String M() {
        return "tt_sdk_rit_settings_" + bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().b();
    }

    public static c0 N() {
        return c0.a(K(), bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d());
    }

    public static c0 O() {
        return c0.a(L(), bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d());
    }

    public static String P() {
        return "tt_sdk_settings_" + bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().b();
    }

    public static c0 Q() {
        return c0.a(M(), bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d());
    }

    public static c0 R() {
        return c0.a(P(), bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d());
    }

    public static c0 S() {
        return c0.a(T(), bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d());
    }

    public static String T() {
        return "tt_sdk_splash_settings_" + bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().b();
    }

    private boolean U() {
        Boolean bool = this.r.get("active_control");
        return bool == null || !bool.booleanValue();
    }

    public void V() {
        if (this.A.size() > 0) {
            synchronized (this.A) {
                for (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.d dVar : this.A) {
                    dVar.callback();
                }
                this.A.clear();
            }
        }
    }

    public void W() {
        if (y()) {
            synchronized (this.q) {
                for (GMSettingConfigCallback gMSettingConfigCallback : this.q) {
                    gMSettingConfigCallback.configLoad();
                }
                this.q.clear();
            }
        }
    }

    private String a(JSONArray jSONArray) {
        JSONArray optJSONArray;
        if (jSONArray != null) {
            ConcurrentHashMap<String, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.b> concurrentHashMap = new ConcurrentHashMap<>();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                if (optJSONObject != null && (optJSONArray = optJSONObject.optJSONArray("break_request_error_code")) != null) {
                    ArrayList arrayList = new ArrayList();
                    for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                        arrayList.add(optJSONArray.optString(i3));
                    }
                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.b bVar = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.b();
                    bVar.a(optJSONObject.optLong("break_request_duration"));
                    bVar.a(arrayList);
                    concurrentHashMap.put(optJSONObject.optString("adn_name"), bVar);
                }
            }
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.c.a().a(concurrentHashMap);
            return jSONArray.toString();
        }
        char c2 = 31;
        while (true) {
            switch (c2) {
                case 29:
                    return null;
                case 30:
                case 31:
                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.c.a().a(null);
                    c2 = 29;
                default:
                    c2 = 29;
            }
        }
    }

    private void b(JSONObject jSONObject) {
        this.u.clear();
        this.t = 0;
        if (jSONObject == null) {
            return;
        }
        this.t = jSONObject.optInt("if_sample", 0);
        JSONObject optJSONObject = jSONObject.optJSONObject("call_stack_path");
        if (optJSONObject != null) {
            try {
                Iterator<String> keys = optJSONObject.keys();
                if (keys != null) {
                    while (keys.hasNext()) {
                        String next = keys.next();
                        String optString = optJSONObject.optString(next);
                        if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(optString)) {
                            this.u.put(next, optString);
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    private void c(JSONObject jSONObject) {
        this.v.clear();
        if (jSONObject != null) {
            try {
                Iterator<String> keys = jSONObject.keys();
                if (keys != null) {
                    while (keys.hasNext()) {
                        String next = keys.next();
                        JSONArray optJSONArray = jSONObject.optJSONArray(next);
                        ArrayList arrayList = new ArrayList();
                        if (optJSONArray != null) {
                            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                                if (optJSONArray.get(i2) != null) {
                                    arrayList.add(optJSONArray.get(i2).toString());
                                }
                            }
                        }
                        if (!TextUtils.isEmpty(next) && !arrayList.isEmpty()) {
                            this.v.put(next, arrayList);
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    private String d(JSONObject jSONObject) {
        if (jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                this.x.put(next, e.a(next, jSONObject.optJSONObject(next)));
            }
            return jSONObject.toString();
        }
        return null;
    }

    private String e(JSONObject jSONObject) {
        Boolean bool = Boolean.TRUE;
        this.r.clear();
        if (jSONObject != null) {
            try {
                if (jSONObject.optBoolean("ad_event_control")) {
                    this.r.put("ad_event_control", bool);
                }
                if (jSONObject.optBoolean("type_banner_control")) {
                    this.r.put("type_banner_control", bool);
                }
                if (jSONObject.optBoolean("type_interaction_control")) {
                    this.r.put("type_interaction_control", bool);
                }
                if (jSONObject.optBoolean("type_interactionfull_control")) {
                    this.r.put("type_interactionfull_control", bool);
                }
                if (jSONObject.optBoolean("type_splash_control")) {
                    this.r.put("type_splash_control", bool);
                }
                if (jSONObject.optBoolean("type_feed_control")) {
                    this.r.put("type_feed_control", bool);
                }
                if (jSONObject.optBoolean("type_reward_control")) {
                    this.r.put("type_reward_control", bool);
                }
                if (jSONObject.optBoolean("type_full_control")) {
                    this.r.put("type_full_control", bool);
                }
                if (jSONObject.optBoolean("type_native_control")) {
                    this.r.put("type_native_control", bool);
                }
                return jSONObject.toString();
            } catch (Exception unused) {
            }
        }
        return null;
    }

    private String f(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f887k = jSONObject.optInt("fetch_ad_type", 0);
            return jSONObject.toString();
        }
        return null;
    }

    public boolean A() {
        if (U()) {
            Boolean bool = this.r.get("type_full_control");
            return bool == null || !bool.booleanValue();
        }
        return false;
    }

    public boolean B() {
        if (U()) {
            Boolean bool = this.r.get("type_interaction_control");
            return bool == null || !bool.booleanValue();
        }
        return false;
    }

    public boolean C() {
        if (U()) {
            Boolean bool = this.r.get("type_interactionfull_control");
            return bool == null || !bool.booleanValue();
        }
        return false;
    }

    public boolean D() {
        if (U()) {
            Boolean bool = this.r.get("type_native_control");
            return bool == null || !bool.booleanValue();
        }
        return false;
    }

    public boolean E() {
        return this.f889m == 1;
    }

    public boolean F() {
        if (U()) {
            Boolean bool = this.r.get("type_reward_control");
            return bool == null || !bool.booleanValue();
        }
        return false;
    }

    public boolean G() {
        if (U()) {
            Boolean bool = this.r.get("type_splash_control");
            return bool == null || !bool.booleanValue();
        }
        return false;
    }

    public boolean H() {
        return this.w == 1;
    }

    public boolean I() {
        return this.f887k == 1;
    }

    public boolean J() {
        return this.B == 1;
    }

    public bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.a a(String str) {
        return bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_19do.a.r().a(str);
    }

    public List<String> a(List<String> list) {
        if (list != null && list.size() > 0) {
            if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_19do.a.r().g()) {
                return list;
            }
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_19do.a.r().b(str) == null) {
                    arrayList.add(str);
                }
            }
            if (arrayList.size() > 0) {
                return arrayList;
            }
        }
        return null;
    }

    public void a() {
        R().a();
        this.a = null;
    }

    public void a(int i2) {
        this.w = i2;
    }

    public void a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.d dVar) {
        if (dVar == null || !u()) {
            this.A.add(dVar);
        } else {
            dVar.callback();
        }
    }

    public void a(GMSettingConfigCallback gMSettingConfigCallback) {
        if (gMSettingConfigCallback == null) {
            return;
        }
        if (y()) {
            gMSettingConfigCallback.configLoad();
            return;
        }
        synchronized (this.q) {
            if (!this.q.contains(gMSettingConfigCallback)) {
                this.q.add(gMSettingConfigCallback);
            }
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.a
    public void a(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.optInt("state_code") != 30004) {
            return;
        }
        c0 R = R();
        this.b = jSONObject.optLong("max_age");
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = this.b;
        this.f879c = currentTimeMillis + j2;
        R.b("max_age", j2);
        R.b("max_expire_time", this.f879c);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.a
    public void a(JSONObject jSONObject, boolean z) {
        boolean z2;
        String b;
        String b2;
        String b3;
        if (jSONObject == null) {
            return;
        }
        try {
            this.a = jSONObject.optString("etag");
            this.b = jSONObject.optLong("max_age");
            this.f879c = System.currentTimeMillis() + this.b;
            this.f880d = jSONObject.optString("ab_version");
            this.f881e = jSONObject.optString("ab_params");
            this.f882f = jSONObject.optString(am.O);
            this.f883g = jSONObject.optString("transparent_params");
            this.w = jSONObject.optInt("if_test");
            this.f884h = jSONObject.optInt("if_get_detail_return");
            this.f885i = jSONObject.optString("ecpm_precision_level");
            this.f886j = jSONObject.optString("fetch_primerit_level");
            String optString = jSONObject.optString("url");
            this.f888l = jSONObject.optString("app_abtest");
            this.f889m = jSONObject.optInt("innerLog", 0);
            this.n = jSONObject.optString("app_log_url", "log-api.pangolin-sdk-toutiao.com/service/2/app_log/");
            this.o = jSONObject.optLong("break_request_times", 0L);
            this.p = jSONObject.optLong("break_request_hold_time", com.heytap.mcssdk.constant.a.q);
            this.B = jSONObject.optInt("ex_info", 0);
            this.C = jSONObject.optString("ex_");
            this.y = jSONObject.optInt("if_enable_label", 0);
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.a.b().a(this.o, this.p);
            JSONObject optJSONObject = jSONObject.optJSONObject("supervisor_feature");
            if (optJSONObject != null) {
                q.a(true);
                q.a(optJSONObject);
            } else {
                q.a(false);
            }
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_19do.a.r().a(jSONObject.optJSONObject("app_common_config"));
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_19do.a.r().b(jSONObject.optJSONObject("adn_init_conf"));
            String a2 = a(jSONObject.optJSONArray("adn_control_conf"));
            String f2 = f(jSONObject.optJSONObject("poor_network_config"));
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_19do.a.r().a(jSONObject.optJSONArray("rit_conf"));
            String e2 = e(jSONObject.optJSONObject("module_disable_control"));
            JSONObject optJSONObject2 = jSONObject.optJSONObject("call_stack_conf");
            b(optJSONObject2);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("custom_adn_feature");
            c(optJSONObject3);
            JSONObject optJSONObject4 = jSONObject.optJSONObject("label_outputs");
            this.z = optJSONObject4;
            String d2 = d(optJSONObject4);
            c0 R = R();
            R.b("etag", this.a);
            R.b("max_age", this.b);
            R.b("max_expire_time", this.f879c);
            R.b("ab_version", this.f880d);
            R.b("ab_params", this.f881e);
            R.b(am.O, this.f882f);
            R.b("transparent_params", this.f883g);
            R.b("if_test", this.w);
            R.b("network_permission", this.f884h);
            R.b("ecpm_precision_level", this.f885i);
            R.b("fetch_primerit_level", this.f886j);
            R.b("app_abtest", this.f888l);
            R.b("module_control", e2);
            R.b("tt_app_log_url", this.n);
            R.b("break_request_times", this.o);
            R.b("break_request_hold_time", this.p);
            R.b("ex_info", this.B);
            R.b("if_enable_label", this.y);
            R.b("key_supervisor_feature", optJSONObject != null ? optJSONObject.toString() : "");
            if (optJSONObject2 != null) {
                R.b("call_stack", optJSONObject2.toString());
            } else {
                R.b("call_stack", "");
            }
            if (optJSONObject3 != null) {
                R.b("custom_adn_feature", optJSONObject3.toString());
            } else {
                R.b("custom_adn_feature", "");
            }
            if (optString == null || TextUtils.isEmpty(optString)) {
                R.f("server_dist_host");
            } else {
                String b4 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.a.b(optString, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.b.a());
                if (b4 != null) {
                    R.b("server_dist_host", b4);
                }
            }
            if (a2 != null && (b3 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.a.b(a2, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.b.a())) != null) {
                R.b("adn_control_conf", b3);
            }
            if (f2 != null) {
                R.b("network_conf", f2);
            }
            if (!TextUtils.isEmpty(d2) && (b2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.a.b(d2, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.b.a())) != null) {
                R.b("label_outputs", b2);
            }
            if (!TextUtils.isEmpty(this.C) && (b = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.a.b(this.C, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.b.a())) != null) {
                R.b("ex_", b);
            }
            R.b("is_config_from_assert", z);
            R.b("has_config_in_sp", true);
            z2 = false;
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                z2 = false;
            } catch (Throwable th2) {
                b(false);
                throw th2;
            }
        }
        b(z2);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.a
    public void a(boolean z) {
        c0 R;
        JSONObject c2;
        JSONObject jSONObject;
        int optInt;
        String str;
        try {
            R = R();
        } catch (Throwable unused) {
            if (z) {
                return;
            }
        }
        if (!R.a("has_config_in_sp") && (c2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().c()) != null) {
            int optInt2 = c2.optInt("cypher", -1);
            if (optInt2 == 2) {
                String a2 = l0.a(c2.optString("message"));
                if (!TextUtils.isEmpty(a2)) {
                    jSONObject = new JSONObject(a2);
                    c2 = jSONObject;
                }
                optInt = c2.optInt("state_code");
                String optString = c2.optString("message");
                if (optInt == 20000 || c2 == null || TextUtils.isEmpty(c2.toString())) {
                    str = " 解密错误或者解析错误：stateCode=" + optInt + "，msg=" + optString;
                } else {
                    c2.optJSONObject("adn_init_conf");
                    if (c2.optString("app_id").equals(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().b())) {
                        a(c2, true);
                        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().a((JSONObject) null);
                        if (z) {
                            return;
                        }
                        b(true);
                    }
                    str = "本地配置appid或appkey非法";
                }
                Logger.i("TTMediationSDK", str);
            } else {
                if (optInt2 == 1) {
                    String a3 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.a.a(c2.optString("message"), bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.b.a());
                    if (!TextUtils.isEmpty(a3)) {
                        Logger.d("TTMediationSDK", "setting data : " + a3.toString());
                        jSONObject = new JSONObject(a3);
                        c2 = jSONObject;
                    }
                } else if (optInt2 == 0) {
                    c2 = new JSONObject(c2.optString("message"));
                }
                optInt = c2.optInt("state_code");
                String optString2 = c2.optString("message");
                if (optInt == 20000) {
                }
                str = " 解密错误或者解析错误：stateCode=" + optInt + "，msg=" + optString2;
                Logger.i("TTMediationSDK", str);
            }
        }
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().a((JSONObject) null);
        this.a = R.d("etag");
        this.b = R.c("max_age");
        this.f879c = R.c("max_expire_time");
        this.f880d = R.d("ab_version");
        this.f881e = R.d("ab_params");
        this.f882f = R.d(am.O);
        this.f883g = R.d("transparent_params");
        this.w = R.b("if_test");
        this.f884h = R.b("network_permission");
        this.f885i = R.d("ecpm_precision_level");
        this.f886j = R.d("fetch_primerit_level");
        this.n = R.a("tt_app_log_url", "log-api.pangolin-sdk-toutiao.com/service/2/app_log/");
        this.o = R.a("break_request_times", 0L);
        this.p = R.a("break_request_hold_time", com.heytap.mcssdk.constant.a.q);
        this.B = R.a("ex_info", 0);
        this.y = R.a("if_enable_label", 0);
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.a.b().a(this.o, this.p);
        if (!TextUtils.isEmpty(R.d("app_abtest"))) {
            this.f888l = R.d("app_abtest");
        }
        String d2 = R.d("network_conf");
        if (!TextUtils.isEmpty(d2)) {
            f(new JSONObject(d2));
        }
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_for12.a.j().h();
        String d3 = R.d("adn_control_conf");
        if (!TextUtils.isEmpty(d3)) {
            if (!d3.startsWith("[") && !d3.startsWith("{")) {
                d3 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.a.a(d3, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.b.a());
            }
            a(new JSONArray(d3));
        }
        String d4 = R.d("module_control");
        if (!TextUtils.isEmpty(d4)) {
            e(new JSONObject(d4));
        }
        boolean a4 = R.a("all_active_control");
        if (a4) {
            this.r.put("active_control", Boolean.valueOf(a4));
        }
        String d5 = R.d("call_stack");
        if (!TextUtils.isEmpty(d5)) {
            b(new JSONObject(d5));
        }
        String d6 = R.d("custom_adn_feature");
        if (!TextUtils.isEmpty(d6)) {
            c(new JSONObject(d6));
        }
        String d7 = R.d("key_supervisor_feature");
        if (TextUtils.isEmpty(d7)) {
            q.a(false);
        } else {
            q.a(true);
            q.a(new JSONObject(d7));
        }
        String d8 = R.d("label_outputs");
        if (!TextUtils.isEmpty(d8)) {
            if (!d8.startsWith("[") && !d8.startsWith("{")) {
                d8 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.a.a(d8, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.b.a());
            }
            if (!TextUtils.isEmpty(d8)) {
                JSONObject jSONObject2 = new JSONObject(d8);
                this.z = jSONObject2;
                d(jSONObject2);
            }
        }
        String d9 = R.d("ex_");
        if (!TextUtils.isEmpty(d9) && !d9.startsWith("[") && !d9.startsWith("{")) {
            this.C = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.a.a(d9, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.b.a());
        }
        if (z) {
            return;
        }
        b(true);
    }

    public boolean a(String str, int i2) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c b;
        return !TextUtils.isEmpty(str) && (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_19do.a.r().g() || (b = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_19do.a.r().b(str)) == null || b.s() == i2);
    }

    public boolean a(String str, String str2) {
        List<j> B;
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c b = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_19do.a.r().b(str);
        if (b != null && (B = b.B()) != null) {
            for (j jVar : B) {
                if (jVar != null && TextUtils.equals(jVar.d(), str2)) {
                    return jVar.C();
                }
            }
        }
        return false;
    }

    public bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.a b(String str) {
        return bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_19do.a.r().a(str);
    }

    public void b(GMSettingConfigCallback gMSettingConfigCallback) {
        if (gMSettingConfigCallback == null) {
            return;
        }
        synchronized (this.q) {
            if (this.q.contains(gMSettingConfigCallback)) {
                this.q.remove(gMSettingConfigCallback);
            }
        }
    }

    public void b(boolean z) {
        new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.a().a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d(), new a(x(), z));
    }

    public boolean b() {
        return this.y == 1;
    }

    public boolean b(List<String> list) {
        if (list == null || list.size() <= 0) {
            return false;
        }
        for (String str : list) {
            if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_19do.a.r().b(str) == null) {
                return false;
            }
        }
        return true;
    }

    public bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c c(String str) {
        return bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_19do.a.r().b(str);
    }

    public String c() {
        return this.f888l;
    }

    public long d(String str) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c c2 = c(str);
        if (c2 != null) {
            return c2.d();
        }
        return 3000L;
    }

    public String d() {
        return this.n;
    }

    public Map<String, String> e() {
        return this.u;
    }

    public boolean e(String str) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c b;
        Map<Integer, List<j>> A;
        return bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_19do.a.r().g() || !(TextUtils.isEmpty(str) || (b = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_19do.a.r().b(str)) == null || (A = b.A()) == null || A.size() == 0);
    }

    public String f() {
        return this.f882f;
    }

    public boolean f(String str) {
        return (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_19do.a.r().e() || bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_19do.a.r().g() || bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_19do.a.r().b(str) == null) ? false : true;
    }

    public Map<String, List<String>> g() {
        return this.v;
    }

    public boolean g(String str) {
        return bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_19do.a.r().d(str);
    }

    public String h() {
        if (this.a == null) {
            this.a = R().d("etag");
        }
        return this.a;
    }

    public void h(String str) {
        try {
            c0 R = R();
            if ("2".equals(str)) {
                this.r.put("active_control", Boolean.TRUE);
                R.b("all_active_control", true);
            } else {
                this.r.put("active_control", Boolean.FALSE);
                R.b("all_active_control", false);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public int i() {
        return bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_19do.a.r().b();
    }

    public int j() {
        return bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_19do.a.r().f();
    }

    public String k() {
        return this.C;
    }

    public int l() {
        return this.w;
    }

    public Map<String, e> m() {
        return this.x;
    }

    public long n() {
        return bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_19do.a.r().c();
    }

    public String o() {
        return this.f883g;
    }

    public boolean p() {
        return Integer.valueOf(this.f885i).intValue() > 0;
    }

    public boolean q() {
        return "1".equals(this.f886j);
    }

    public boolean r() {
        return this.f884h >= 1;
    }

    public boolean s() {
        try {
            return Integer.valueOf(this.f885i).intValue() > 1;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean t() {
        return this.t == 1;
    }

    public boolean u() {
        return this.s.get();
    }

    public boolean v() {
        if (U()) {
            Boolean bool = this.r.get("ad_event_control");
            return bool == null || !bool.booleanValue();
        }
        return false;
    }

    public boolean w() {
        if (U()) {
            Boolean bool = this.r.get("type_banner_control");
            return bool == null || !bool.booleanValue();
        }
        return false;
    }

    public boolean x() {
        return (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_19do.a.r().g() || bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_19do.a.r().e()) ? false : true;
    }

    public boolean y() {
        return !bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_19do.a.r().g() && u();
    }

    public boolean z() {
        if (U()) {
            Boolean bool = this.r.get("type_feed_control");
            return bool == null || !bool.booleanValue();
        }
        return false;
    }
}
