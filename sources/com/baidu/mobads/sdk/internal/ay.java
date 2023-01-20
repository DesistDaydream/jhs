package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.baidu.mobads.sdk.internal.a.b;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import org.json.JSONObject;

/* loaded from: classes.dex */
public abstract class ay extends Observable {
    private static final String a = "b_f";
    public static final String b = "XAbstractProdTemplate";

    /* renamed from: c  reason: collision with root package name */
    public static final String f1456c = "error_message";

    /* renamed from: d  reason: collision with root package name */
    public static final String f1457d = "error_code";

    /* renamed from: e  reason: collision with root package name */
    public static final String f1458e = "instanceInfo";

    /* renamed from: f  reason: collision with root package name */
    public static final String f1459f = "showState";

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f1460g;

    /* renamed from: h  reason: collision with root package name */
    public Context f1461h;

    /* renamed from: m  reason: collision with root package name */
    public HashMap<String, String> f1466m;
    public String n;
    public String o;

    /* renamed from: i  reason: collision with root package name */
    public bj f1462i = bj.a();

    /* renamed from: k  reason: collision with root package name */
    public IAdInterListener f1464k = null;

    /* renamed from: l  reason: collision with root package name */
    public boolean f1465l = true;
    public int p = -1;

    /* renamed from: j  reason: collision with root package name */
    public IOAdEventListener f1463j = new a();

    /* loaded from: classes.dex */
    public class a implements IOAdEventListener {
        public a() {
        }

        private String a(IOAdEvent iOAdEvent) {
            Map<String, Object> data;
            Object obj;
            if (iOAdEvent != null) {
                String message = iOAdEvent.getMessage();
                return (!TextUtils.isEmpty(message) || (data = iOAdEvent.getData()) == null || (obj = data.get("msg")) == null || !(obj instanceof String)) ? message : (String) obj;
            }
            return null;
        }

        @Override // com.baidu.mobads.sdk.api.IOAdEventListener
        public void run(IOAdEvent iOAdEvent) {
            ay.a(new bb(this, iOAdEvent));
        }
    }

    public ay(Context context) {
        this.f1461h = context;
        y.a().a(this.f1461h, new az(this));
    }

    public abstract void a();

    public void a(View view, JSONObject jSONObject) {
        IAdInterListener iAdInterListener = this.f1464k;
        if (iAdInterListener != null) {
            iAdInterListener.onAdTaskProcess(view, a(IAdInterListener.AdCommandType.AD_IMPRESSION, jSONObject));
        }
    }

    public void a(IOAdEvent iOAdEvent) {
    }

    public void a(String str, boolean z) {
    }

    public void b(View view, JSONObject jSONObject) {
        IAdInterListener iAdInterListener = this.f1464k;
        if (iAdInterListener != null) {
            iAdInterListener.onAdTaskProcess(view, a(IAdInterListener.AdCommandType.AD_CLICK, jSONObject));
        }
    }

    public void b(IOAdEvent iOAdEvent) {
    }

    public void b(String str, boolean z) {
    }

    public void b(boolean z) {
    }

    public void b_() {
    }

    public void c(IOAdEvent iOAdEvent) {
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            b("bidding id is empty", 2);
        }
        if (this.f1464k != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("bid_id", str);
            a("load_bidding_ad", (Map<String, Object>) hashMap);
            return;
        }
        b("Initialization doesn't finish yet.", 1);
    }

    public void c_() {
    }

    public void d() {
    }

    public void d(IOAdEvent iOAdEvent) {
    }

    public void d(String str) {
    }

    public void e() {
        IAdInterListener iAdInterListener = this.f1464k;
        if (iAdInterListener != null) {
            iAdInterListener.destroyAd();
        }
    }

    public void e(IOAdEvent iOAdEvent) {
    }

    public void e(String str) {
    }

    public void f(IOAdEvent iOAdEvent) {
    }

    public void f(String str) {
    }

    public void g(IOAdEvent iOAdEvent) {
        r();
    }

    public String h(String str) {
        IXAdContainerFactory c2;
        y a2 = y.a();
        if (a2 != null && (c2 = a2.c()) != null) {
            Object remoteParam = c2.getRemoteParam(str, new Object[0]);
            if (remoteParam instanceof String) {
                return (String) remoteParam;
            }
        }
        return null;
    }

    public void h(IOAdEvent iOAdEvent) {
    }

    public void i() {
        this.f1464k = (IAdInterListener) ap.a(v.f1626k, bi.a(this.f1461h), new Class[]{Context.class}, this.f1461h);
        if (this.f1465l) {
            return;
        }
        a();
    }

    public void i(IOAdEvent iOAdEvent) {
    }

    public void j() {
        b("SDK未初始化", 1);
    }

    public void j(IOAdEvent iOAdEvent) {
    }

    public JSONObject k() {
        return new JSONObject();
    }

    public JSONObject l() {
        return new JSONObject();
    }

    public String m() {
        JSONObject k2 = k();
        JSONObject l2 = l();
        HashMap hashMap = new HashMap();
        hashMap.put("param_info", k2);
        hashMap.put("ad_buss_param", l2);
        a("get_request_token", (Map<String, Object>) hashMap);
        Object obj = hashMap.get("request_token");
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public void n() {
        IAdInterListener iAdInterListener = this.f1464k;
        if (iAdInterListener != null) {
            iAdInterListener.addEventListener(com.baidu.mobads.sdk.internal.a.b.f1411e, new b.a());
            this.f1464k.addEventListener(v.F, this.f1463j);
            this.f1464k.addEventListener(v.H, this.f1463j);
            this.f1464k.addEventListener(v.J, this.f1463j);
            this.f1464k.addEventListener(v.K, this.f1463j);
            this.f1464k.addEventListener(v.U, this.f1463j);
            this.f1464k.addEventListener(v.p, this.f1463j);
            this.f1464k.addEventListener(v.V, this.f1463j);
            this.f1464k.addEventListener(v.q, this.f1463j);
            this.f1464k.addEventListener(v.L, this.f1463j);
            this.f1464k.addEventListener(v.M, this.f1463j);
            this.f1464k.addEventListener(v.I, this.f1463j);
            this.f1464k.addEventListener(v.B, this.f1463j);
            this.f1464k.addEventListener(v.aa, this.f1463j);
            this.f1464k.addEventListener(v.ab, this.f1463j);
            this.f1464k.addEventListener(v.Y, this.f1463j);
            this.f1464k.addEventListener(v.T, this.f1463j);
            this.f1464k.addEventListener(v.ac, this.f1463j);
            this.f1464k.addEventListener(v.ad, this.f1463j);
            this.f1464k.addEventListener(v.ae, this.f1463j);
            this.f1464k.addEventListener(v.af, this.f1463j);
            this.f1464k.addEventListener(v.ag, this.f1463j);
            this.f1464k.addEventListener(v.ah, this.f1463j);
            this.f1464k.addEventListener(v.Z, this.f1463j);
            this.f1464k.addEventListener(v.W, this.f1463j);
            this.f1464k.addEventListener(v.ai, this.f1463j);
            this.f1464k.addEventListener(v.aj, this.f1463j);
        }
    }

    public void o() {
        IAdInterListener iAdInterListener = this.f1464k;
        if (iAdInterListener != null) {
            iAdInterListener.onAttachedToWindow();
        }
    }

    public void p() {
        IAdInterListener iAdInterListener = this.f1464k;
        if (iAdInterListener != null) {
            iAdInterListener.onDetachedFromWindow();
        }
    }

    public void q() {
    }

    public void r() {
        IAdInterListener iAdInterListener = this.f1464k;
        if (iAdInterListener != null) {
            iAdInterListener.removeAllListeners();
        }
    }

    public void s() {
    }

    public void t() {
    }

    public void u() {
    }

    public View v() {
        IAdInterListener iAdInterListener = this.f1464k;
        if (iAdInterListener != null) {
            return iAdInterListener.getAdContainerView();
        }
        return null;
    }

    public void g(String str) {
        this.o = str;
    }

    public void a(Activity activity) {
        if (this.f1464k != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("setActivity", activity);
            this.f1464k.onAdTaskProcess(a(IAdInterListener.AdCommandType.CHANGE_ACTIVITY, new JSONObject()), hashMap);
        }
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            b("bidding data is empty", 2);
        }
        if (this.f1464k != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("bidding_data", str);
            a("load_bidding_data", (Map<String, Object>) hashMap);
            return;
        }
        b("Initialization doesn't finish yet.", 1);
    }

    public void a(JSONObject jSONObject) {
        IAdInterListener iAdInterListener = this.f1464k;
        if (iAdInterListener != null) {
            iAdInterListener.onAdTaskProcess(a(IAdInterListener.AdCommandType.HANDLE_EVENT, jSONObject));
        }
    }

    public void b(int i2) {
        IAdInterListener iAdInterListener = this.f1464k;
        if (iAdInterListener != null) {
            iAdInterListener.onWindowVisibilityChanged(i2);
        }
    }

    public void a(JSONObject jSONObject, Map<String, Object> map) {
        IAdInterListener iAdInterListener = this.f1464k;
        if (iAdInterListener != null) {
            iAdInterListener.onAdTaskProcess(a(IAdInterListener.AdCommandType.HANDLE_EVENT, jSONObject), map);
        }
    }

    public void b(String str, int i2) {
        r();
    }

    public void a(String str, Map<String, Object> map) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("event_type", "server_bidding");
            jSONObject.put("msg", str);
            IAdInterListener iAdInterListener = this.f1464k;
            if (iAdInterListener != null) {
                iAdInterListener.onAdTaskProcess(a(IAdInterListener.AdCommandType.HANDLE_EVENT, jSONObject), map);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public JSONObject b(Map<String, String> map) {
        if (map != null) {
            if (!map.isEmpty()) {
                try {
                } catch (Exception unused) {
                    return null;
                }
            }
            return new JSONObject(map);
        }
        return null;
    }

    public void b(JSONObject jSONObject) {
        int i2 = this.p;
        if (i2 < 0 || jSONObject == null) {
            return;
        }
        try {
            jSONObject.put(a, i2);
        } catch (Throwable th) {
            this.f1462i.a(th);
        }
    }

    public void a(String str, boolean z, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("uniqueId", str);
            jSONObject.put("result", z);
            jSONObject.put("replacement", str2);
            IAdInterListener iAdInterListener = this.f1464k;
            if (iAdInterListener != null) {
                iAdInterListener.onAdTaskProcess(a("onBiddingResult", jSONObject), (Map<String, Object>) null);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void a(String str, HashMap<String, Object> hashMap) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("event_type", str);
            IAdInterListener iAdInterListener = this.f1464k;
            if (iAdInterListener != null) {
                iAdInterListener.onAdTaskProcess(a(IAdInterListener.AdCommandType.NOVEL_EVENT, jSONObject), hashMap);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(boolean z) {
        IAdInterListener iAdInterListener = this.f1464k;
        if (iAdInterListener != null) {
            iAdInterListener.onWindowFocusChanged(z);
        }
    }

    public boolean a(int i2, KeyEvent keyEvent) {
        IAdInterListener iAdInterListener = this.f1464k;
        if (iAdInterListener != null) {
            return iAdInterListener.onKeyDown(i2, keyEvent);
        }
        return false;
    }

    public void a(int i2, String str) {
        r();
    }

    public static void a(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                runnable.run();
            } else {
                new Handler(Looper.getMainLooper()).post(new ba(runnable));
            }
        } catch (Exception unused) {
        }
    }

    public void a(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        this.f1466m = (HashMap) map;
    }

    private String a(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return "bdsdk://" + str + "?jsonObj=" + Uri.encode(jSONObject.toString());
    }
}
