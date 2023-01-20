package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.os.Build;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.c0;
import com.bytedance.msdk.adapter.config.DefaultAdapterClasses;
import com.bytedance.msdk.adapter.config.ITTAdapterConfiguration;
import com.bytedance.msdk.adapter.util.Logger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a implements e {
    private Map<String, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.a> b = new ConcurrentHashMap();
    private c0 a = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.d.N();

    private List<String> a(Context context) {
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

    private void a(JSONObject jSONObject) {
        this.b.clear();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            JSONObject optJSONObject = jSONObject.optJSONObject(next);
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.a a = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.a.a(next, optJSONObject);
            if (optJSONObject != null && a != null) {
                if (TextUtils.equals(next, "pangle") && bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().z()) {
                    this.b.put("pangle_custom", a);
                } else {
                    this.b.put(next, a);
                }
            }
        }
    }

    private Set<String> b() {
        HashSet hashSet = new HashSet();
        if (this.b.size() != 0) {
            for (Map.Entry<String, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.a> entry : this.b.entrySet()) {
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.a value = entry.getValue();
                if (value != null && !value.d()) {
                    hashSet.add(entry.getKey());
                }
            }
        }
        return hashSet;
    }

    private void c() {
        String a = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.a.a(this.a.d("adn_init_config"), bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.b.a());
        if (a == null || TextUtils.isEmpty(a)) {
            return;
        }
        try {
            a(new JSONObject(a));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.e
    public bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.a a(String str) {
        if (this.b.size() == 0) {
            c();
        }
        return this.b.get(str);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.e
    public List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.a> a() {
        if (this.b.size() == 0) {
            c();
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.a> entry : this.b.entrySet()) {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.a value = entry.getValue();
            if (value != null && value.d()) {
                arrayList.add(value);
            }
        }
        return arrayList;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.e
    public void b(JSONObject jSONObject) {
        if (jSONObject != null) {
            a(jSONObject);
            String b = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.a.b(jSONObject.toString(), bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.b.a());
            if (b != null && !TextUtils.isEmpty(b)) {
                this.a.b("adn_init_config", b);
            }
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_for12.a.j().b(jSONObject);
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.e
    public void d() {
        List<String> a;
        synchronized (this) {
            Context d2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d();
            if (d2 != null) {
                Set<String> b = b();
                if (b.size() != 0) {
                    int i2 = d2.getApplicationInfo().targetSdkVersion;
                    Logger.i("TTMediationSDK_SDK_Init", "------------------ GroMore 接入信息 start ---------------------");
                    Logger.d("TTMediationSDK_SDK_Init", "当前接入的GroMore SDK版本是：3.7.0.2");
                    if ((Build.VERSION.SDK_INT >= 24 || i2 >= 24) && (a = a(d2)) != null) {
                        Iterator<String> it = b.iterator();
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
                    if (e2 != null) {
                        for (String str : b) {
                            if (!"pangle_custom".equals(str) && !TextUtils.isEmpty(str)) {
                                ITTAdapterConfiguration iTTAdapterConfiguration = e2.get(DefaultAdapterClasses.getClassNameByAdnName(str));
                                if (iTTAdapterConfiguration != null) {
                                    iTTAdapterConfiguration.checkVersion();
                                } else {
                                    Logger.e("TTMediationSDK_InitChecker", "没有引入" + str + "Adapter,请检查相关引入情况");
                                }
                            }
                        }
                    }
                    Logger.i("TTMediationSDK_SDK_Init", "------------------ GroMore 版本信息 end ---------------------");
                }
            }
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.e
    public boolean e() {
        if (this.b.size() == 0) {
            c();
        }
        return this.b.isEmpty();
    }
}
