package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_for12;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.os.Build;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.k;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.l;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.m;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.d;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_19do.b;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.c0;
import com.bytedance.msdk.adapter.config.DefaultAdapterClasses;
import com.bytedance.msdk.adapter.config.ITTAdapterConfiguration;
import com.bytedance.msdk.adapter.config.TTBaseAdapterConfiguration;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a implements b {

    /* renamed from: h  reason: collision with root package name */
    private static volatile a f1000h;
    private Map<String, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.a> b = new ConcurrentHashMap();

    /* renamed from: c  reason: collision with root package name */
    private Map<String, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.a> f1001c = new ConcurrentHashMap();

    /* renamed from: d  reason: collision with root package name */
    private Map<String, c> f1002d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    private int f1003e = 100;

    /* renamed from: f  reason: collision with root package name */
    private int f1004f = 0;

    /* renamed from: g  reason: collision with root package name */
    private long f1005g = 120000;
    private c0 a = d.R();

    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_for12.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0049a implements Runnable {
        public final /* synthetic */ c a;

        public RunnableC0049a(a aVar, c cVar) {
            this.a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar = this.a;
            if (cVar == null || cVar.q() == null) {
                return;
            }
            if (this.a.H()) {
                if (m.b().a(this.a.g())) {
                    m.b().b(this.a.g());
                }
                if (m.b().a(this.a.f())) {
                    m.b().b(this.a.f());
                }
            } else {
                m b = m.b();
                b.e(this.a.q() + "");
                m b2 = m.b();
                b2.d(this.a.q() + "");
            }
            for (j jVar : this.a.B()) {
                if (jVar.D()) {
                    if (l.b().a(jVar.o())) {
                        l.b().b(jVar.o());
                    }
                    if (k.b().a(jVar.n())) {
                        k.b().b(jVar.n());
                    }
                } else {
                    l b3 = l.b();
                    b3.b(this.a.q() + "", jVar.d());
                    k b4 = k.b();
                    b4.c(this.a.q() + "", jVar.d());
                }
            }
        }
    }

    private a() {
    }

    private static List<String> a(Context context) {
        String str;
        List<ProviderInfo> queryContentProviders = context.getPackageManager().queryContentProviders(context.getApplicationInfo().processName, context.getApplicationInfo().uid, 131072);
        if (queryContentProviders == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        context.getPackageName();
        for (ProviderInfo providerInfo : queryContentProviders) {
            String str2 = providerInfo.name;
            str2.hashCode();
            char c2 = 65535;
            switch (str2.hashCode()) {
                case -2132028139:
                    if (str2.equals("com.baidu.mobads.sdk.api.BdFileProvider")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -1630533804:
                    if (str2.equals("com.mbridge.msdk.foundation.tools.MBFileProvider")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -1097984862:
                    if (str2.equals("com.sigmob.sdk.SigmobFileProvider")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 8917003:
                    if (str2.equals("com.tencent.klevin.utils.FileProvider")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 405711305:
                    if (str2.equals("com.google.android.gms.ads.MobileAdsInitProvider")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 787345346:
                    if (str2.equals("com.bykv.vk.openvk.TTFileProvider")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 980611709:
                    if (str2.equals("com.kwad.sdk.api.proxy.app.AdSdkFileProvider")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case 1010345138:
                    if (str2.equals("com.bytedance.sdk.openadsdk.TTFileProvider")) {
                        c2 = 7;
                        break;
                    }
                    break;
                case 1011081416:
                    if (str2.equals("com.unity")) {
                        c2 = '\b';
                        break;
                    }
                    break;
                case 1719438508:
                    if (str2.equals("com.qq.e.comm.GDTFileProvider")) {
                        c2 = '\t';
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    str = "baidu";
                    break;
                case 1:
                    str = "mintegral";
                    break;
                case 2:
                    str = "sigmob";
                    break;
                case 3:
                    str = "klevin";
                    break;
                case 4:
                    str = "admob";
                    break;
                case 5:
                    str = "pangle_custom";
                    break;
                case 6:
                    str = "ks";
                    break;
                case 7:
                    str = "pangle";
                    break;
                case '\b':
                    str = "unity";
                    break;
                case '\t':
                    str = "gdt";
                    break;
            }
            arrayList.add(str);
        }
        return arrayList;
    }

    private void a(c cVar) {
        ThreadHelper.runOnThreadPool(new RunnableC0049a(this, cVar));
    }

    private String b(JSONArray jSONArray) {
        if (jSONArray != null) {
            this.f1002d.clear();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                try {
                    c b = c.b(jSONArray.getJSONObject(i2));
                    if (b != null) {
                        this.f1002d.put(b.q(), b);
                        a(b);
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            return jSONArray.toString();
        }
        return null;
    }

    private String c(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject2 != null) {
            i();
            Iterator<String> keys = jSONObject.keys();
            if (keys != null) {
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONObject optJSONObject = jSONObject2.optJSONObject(next);
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("app_id");
                        String optString2 = optJSONObject.optString(TTBaseAdapterConfiguration.APP_KEY_EXTRA_KEY);
                        String optString3 = optJSONObject.optString("custom_type");
                        if (TextUtils.equals(optString3, "1")) {
                            this.f1001c.put(next, new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.a(next, optString, optString2, optJSONObject.optString("init_class_name"), optJSONObject.optString("banner_class_name"), optJSONObject.optString("interstitial_class_name"), optJSONObject.optString("reward_class_name"), optJSONObject.optString("full_video_class_name"), optJSONObject.optString("splash_class_name"), optJSONObject.optString("feed_class_name"), optJSONObject.optString("draw_class_name"), optString3));
                        } else {
                            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.a aVar = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.a(optString, optString2);
                            if (TextUtils.equals(next, "pangle") && bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().z()) {
                                this.b.put("pangle_custom", aVar);
                            }
                            this.b.put(next, aVar);
                        }
                    }
                    jSONObject2 = jSONObject;
                }
            }
            return jSONObject.toString();
        }
        return null;
    }

    private void i() {
        this.b.clear();
        this.f1001c.clear();
    }

    public static a j() {
        if (f1000h == null) {
            synchronized (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.b.class) {
                if (f1000h == null) {
                    f1000h = new a();
                }
            }
        }
        return f1000h;
    }

    private void k() throws JSONException {
        String d2 = this.a.d("adn_init_conf");
        if (TextUtils.isEmpty(d2)) {
            return;
        }
        if (!d2.startsWith("[") && !d2.startsWith("{")) {
            d2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.a.a(d2, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.b.a());
        }
        c(new JSONObject(d2));
    }

    private void l() throws JSONException {
        String d2 = this.a.d("tt_app_common_config");
        if (!TextUtils.isEmpty(d2)) {
            JSONObject jSONObject = new JSONObject(d2);
            int optInt = jSONObject.optInt("event_batch_size", 100);
            this.f1003e = optInt;
            if (optInt <= 0 || optInt > 1000) {
                this.f1003e = 100;
            }
            this.f1004f = jSONObject.optInt("event_send_type", 0);
            long optLong = jSONObject.optLong("event_routine_interval", 120000L);
            this.f1005g = optLong;
            if (optLong < com.heytap.mcssdk.constant.a.q || optLong > 300000) {
                this.f1005g = 120000L;
            }
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.b.d().a(jSONObject.optInt("pre_fetch_count", 20));
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.c.a(jSONObject.optInt("if_use_new_loglib", 0));
        }
        Logger.e("TTSETTING", "load--mEventBatchSize=" + this.f1003e + ",mEventSendType=" + this.f1004f + ", routineInterval=" + this.f1005g);
    }

    private void m() throws JSONException {
        String d2 = this.a.d("rit_conf");
        if (TextUtils.isEmpty(d2)) {
            return;
        }
        if (!d2.startsWith("[") && !d2.startsWith("{")) {
            d2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.a.a(d2, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.b.a());
        }
        b(new JSONArray(d2));
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.e
    public bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.a a(String str) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.a aVar = this.b.get(str);
        return aVar != null ? aVar : this.f1001c.get(str);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.e
    public List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.a> a() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.a> entry : this.f1001c.entrySet()) {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.a value = entry.getValue();
            if (value != null && value.d()) {
                arrayList.add(value);
            }
        }
        return arrayList;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.g
    public void a(JSONArray jSONArray) {
        String b;
        String b2 = b(jSONArray);
        if (b2 == null || (b = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.a.b(b2, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.b.a())) == null) {
            return;
        }
        this.a.b("rit_conf", b);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.f
    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("event_batch_size", 100);
            this.f1003e = optInt;
            if (optInt <= 0 || optInt > 1000) {
                this.f1003e = 100;
            }
            this.f1004f = jSONObject.optInt("event_send_type", 0);
            long optLong = jSONObject.optLong("event_routine_interval", 120000L);
            this.f1005g = optLong;
            if (optLong < com.heytap.mcssdk.constant.a.q || optLong > 300000) {
                this.f1005g = 120000L;
            }
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.b.d().a(jSONObject.optInt("pre_fetch_count", 20));
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.c.a(jSONObject.optInt("if_use_new_loglib", 0));
            Logger.e("TTSETTING", "save--mEventBatchSize=" + this.f1003e + ",mEventSendType=" + this.f1004f + ", routineInterval=" + this.f1005g);
            this.a.b("tt_app_common_config", jSONObject.toString());
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.f
    public int b() {
        return this.f1003e;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.g
    public c b(String str) {
        return this.f1002d.get(str);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.e
    public void b(JSONObject jSONObject) {
        String b;
        String c2 = c(jSONObject);
        if (c2 == null || (b = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.a.b(c2, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.b.a())) == null) {
            return;
        }
        this.a.b("adn_init_conf", b);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.f
    public long c() {
        return this.f1005g;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.e
    public void d() {
        Map<String, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.a> map;
        List<String> a;
        Context d2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d();
        if (d2 == null || (map = this.b) == null) {
            return;
        }
        int i2 = d2.getApplicationInfo().targetSdkVersion;
        Logger.i("TTMediationSDK_SDK_Init", "------------------ GroMore 接入信息 start ---------------------");
        Logger.d("TTMediationSDK_SDK_Init", "当前接入的GroMore SDK版本是：3.7.0.2");
        if ((Build.VERSION.SDK_INT >= 24 || i2 >= 24) && (a = a(d2)) != null) {
            Iterator<String> it = map.keySet().iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!"unity".equals(next) && !"pangle_custom".equals(next)) {
                    if ("pangle".equals(next) && bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().z()) {
                        next = "pangle_custom";
                    }
                    if (a.contains(next)) {
                        Logger.i("TTMediationSDK_SDK_Init", "已按要求接入三方广告sdk【" + next + "】");
                    } else {
                        Logger.e("TTMediationSDK_SDK_Init", "未按要求接入三方广告sdk【" + next + "】，请检查接入配置");
                    }
                }
            }
        }
        Logger.i("TTMediationSDK_SDK_Init", "------------------ GroMore 接入信息 end ---------------------");
        Logger.i("TTMediationSDK_SDK_Init", "------------------ GroMore 版本信息 start ---------------------");
        Map<String, ITTAdapterConfiguration> e2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.a.e();
        Map<String, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.a> map2 = this.b;
        if (e2 != null && map2 != null) {
            for (String str : map2.keySet()) {
                try {
                    if (!"pangle_custom".equals(str) && !TextUtils.isEmpty(str)) {
                        ITTAdapterConfiguration iTTAdapterConfiguration = e2.get(DefaultAdapterClasses.getClassNameByAdnName(str));
                        if (iTTAdapterConfiguration != null) {
                            iTTAdapterConfiguration.checkVersion();
                        } else {
                            Logger.e("TTMediationSDK_InitChecker", "没有引入" + str + "Adapter,请检查相关引入情况");
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
        Logger.i("TTMediationSDK_SDK_Init", "------------------ GroMore 版本信息 end ---------------------");
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.e
    public boolean e() {
        return this.b.isEmpty() && this.f1001c.isEmpty();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.f
    public int f() {
        return this.f1004f;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.g
    public boolean g() {
        return this.f1002d.isEmpty();
    }

    public void h() throws JSONException {
        k();
        m();
        l();
    }
}
