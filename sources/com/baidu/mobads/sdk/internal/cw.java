package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.mobads.sdk.api.ArticleInfo;
import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.ExpressResponse;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.XAdNativeResponse;
import com.baidu.mobads.sdk.internal.e;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.api.reward.RewardItem;
import com.huawei.hms.support.api.entity.core.JosStatusCodes;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class cw extends ay {
    private BaiduNativeManager.ExpressAdListener A;
    private e.b B;
    private int C;
    private List<NativeResponse> a;
    private List<ExpressResponse> q;
    private int r;
    private boolean s;
    private String t;
    private String u;
    private int v;
    private int w;
    private RequestParameters x;
    private boolean y;
    private e.a z;

    public cw(Context context, String str, String str2, boolean z, int i2) {
        super(context);
        this.r = JosStatusCodes.RTN_CODE_COMMON_ERROR;
        this.y = false;
        this.C = 0;
        this.u = str;
        this.t = str2;
        this.s = z;
        this.r = i2;
        this.v = 600;
        this.w = 500;
    }

    public void a(e.a aVar) {
        this.z = aVar;
    }

    public void b(Activity activity) {
        JSONObject jSONObject = new JSONObject();
        HashMap hashMap = new HashMap();
        try {
            jSONObject.put("msg", "bindExpressActivity");
            hashMap.put("activity", activity);
        } catch (JSONException e2) {
            bj.a().a(e2);
        }
        a(jSONObject, hashMap);
    }

    @Override // com.baidu.mobads.sdk.internal.ay
    public void b_() {
        e.a aVar = this.z;
        if (aVar != null) {
            aVar.b();
            return;
        }
        BaiduNativeManager.ExpressAdListener expressAdListener = this.A;
        if (expressAdListener != null) {
            expressAdListener.onVideoDownloadSuccess();
        }
    }

    public void c(boolean z) {
        this.y = z;
    }

    @Override // com.baidu.mobads.sdk.internal.ay
    public void c_() {
        e.a aVar = this.z;
        if (aVar != null) {
            aVar.c();
            return;
        }
        BaiduNativeManager.ExpressAdListener expressAdListener = this.A;
        if (expressAdListener != null) {
            expressAdListener.onVideoDownloadFailed();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.ay
    public void d() {
        e.a aVar = this.z;
        if (aVar != null) {
            aVar.a();
            return;
        }
        BaiduNativeManager.ExpressAdListener expressAdListener = this.A;
        if (expressAdListener != null) {
            expressAdListener.onLpClosed();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.ay
    public void e(IOAdEvent iOAdEvent) {
        String message = iOAdEvent.getMessage();
        int i2 = 0;
        if (this.z != null && !TextUtils.isEmpty(message) && this.a != null) {
            while (i2 < this.a.size()) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.a.get(i2);
                if (xAdNativeResponse.getUniqueId().equals(message)) {
                    this.z.a(xAdNativeResponse);
                }
                i2++;
            }
        } else if (this.A == null || TextUtils.isEmpty(message) || this.q == null) {
        } else {
            while (i2 < this.q.size()) {
                bg bgVar = (bg) this.q.get(i2);
                if (TextUtils.equals(message, bgVar.a())) {
                    bgVar.c();
                }
                i2++;
            }
        }
    }

    public String f() {
        return this.t;
    }

    public RequestParameters g() {
        return this.x;
    }

    @Override // com.baidu.mobads.sdk.internal.ay
    public void h(IOAdEvent iOAdEvent) {
        String message = iOAdEvent.getMessage();
        int i2 = 0;
        if (this.z != null && !TextUtils.isEmpty(message) && this.a != null) {
            while (i2 < this.a.size()) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.a.get(i2);
                if (xAdNativeResponse.getUniqueId().equals(message)) {
                    this.z.b(xAdNativeResponse);
                }
                i2++;
            }
        } else if (this.A == null || TextUtils.isEmpty(message) || this.q == null) {
        } else {
            while (i2 < this.q.size()) {
                bg bgVar = (bg) this.q.get(i2);
                if (TextUtils.equals(message, bgVar.a())) {
                    bgVar.b();
                }
                i2++;
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.ay
    public void i(IOAdEvent iOAdEvent) {
        Map<String, Object> data;
        if (this.A == null || iOAdEvent == null || this.q == null || (data = iOAdEvent.getData()) == null) {
            return;
        }
        String str = (String) data.get("uniqueId");
        View view = (View) data.get("expressView");
        int intValue = ((Integer) data.get("viewWidth")).intValue();
        int intValue2 = ((Integer) data.get("viewHeight")).intValue();
        for (int i2 = 0; i2 < this.q.size(); i2++) {
            bg bgVar = (bg) this.q.get(i2);
            if (TextUtils.equals(bgVar.a(), str)) {
                bgVar.a(view, intValue, intValue2);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.ay
    public void j(IOAdEvent iOAdEvent) {
        Map<String, Object> data;
        if (this.A == null || iOAdEvent == null || this.q == null || (data = iOAdEvent.getData()) == null) {
            return;
        }
        String str = (String) data.get("uniqueId");
        View view = (View) data.get("expressView");
        int intValue = ((Integer) data.get("error_code")).intValue();
        String str2 = (String) data.get("error_message");
        for (int i2 = 0; i2 < this.q.size(); i2++) {
            bg bgVar = (bg) this.q.get(i2);
            if (TextUtils.equals(bgVar.a(), str)) {
                bgVar.a(view, str2, intValue);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.ay
    public JSONObject k() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(IAdInterListener.AdReqParam.PROD, this.t);
            this.f1464k.createProdHandler(jSONObject2);
            this.f1464k.setAdContainer(this.f1460g);
            n();
            jSONObject.put(IAdInterListener.AdReqParam.PROD, this.t);
            jSONObject.put(IAdInterListener.AdReqParam.APID, this.u);
            if (cg.a().b()) {
                jSONObject.put(IAdInterListener.AdReqParam.FET, "ANTI,MSSP,VIDEO,NMON,HTML");
            } else {
                jSONObject.put(IAdInterListener.AdReqParam.FET, "ANTI,MSSP,VIDEO,NMON,HTML,CLICK2VIDEO");
            }
            jSONObject.put("n", "1");
            if (!TextUtils.isEmpty(this.o)) {
                jSONObject.put("appid", this.o);
            }
            if ("video".equals(this.t)) {
                jSONObject.put(IAdInterListener.AdReqParam.AD_TYPE, "10");
                jSONObject.put("mimetype", "video/mp4,image/jpg,image/gif,image/png");
                jSONObject.put(IAdInterListener.AdReqParam.FET, "ANTI,HTML,MSSP,VIDEO,NMON");
            } else {
                jSONObject.put(IAdInterListener.AdReqParam.AD_TYPE, "2");
            }
            jSONObject.put(IAdInterListener.AdReqParam.WIDTH, "" + this.v);
            jSONObject.put("h", "" + this.w);
            jSONObject.put("msa", 143);
            jSONObject = j.a(jSONObject, b(this.f1466m));
            jSONObject.put("opt", this.C);
            b(jSONObject);
            return jSONObject;
        } catch (Throwable th) {
            th.printStackTrace();
            return jSONObject;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.ay
    public JSONObject l() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("timeout", this.r);
            jSONObject.put("isCacheVideo", this.s);
            jSONObject.put("cacheVideoOnlyWifi", this.y);
            RequestParameters requestParameters = this.x;
            jSONObject.put("appConfirmPolicy", requestParameters == null ? 1 : requestParameters.getAPPConfirmPolicy());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x006c, code lost:
        if (com.baidu.mobads.sdk.internal.bk.a(r15.f1461h, r7) != false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x00af, code lost:
        if (com.baidu.mobads.sdk.internal.bk.a(r15.f1461h, r7) != false) goto L40;
     */
    /* JADX WARN: Removed duplicated region for block: B:114:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x00de A[SYNTHETIC] */
    @Override // com.baidu.mobads.sdk.internal.ay
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void q() {
        /*
            Method dump skipped, instructions count: 246
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.sdk.internal.cw.q():void");
    }

    public void a(BaiduNativeManager.ExpressAdListener expressAdListener) {
        this.A = expressAdListener;
    }

    @Override // com.baidu.mobads.sdk.internal.ay
    public void c(IOAdEvent iOAdEvent) {
        Map<String, Object> data;
        if (this.A == null || iOAdEvent == null || this.q == null || (data = iOAdEvent.getData()) == null) {
            return;
        }
        String str = (String) data.get("uniqueId");
        String str2 = (String) data.get("type");
        for (int i2 = 0; i2 < this.q.size(); i2++) {
            bg bgVar = (bg) this.q.get(i2);
            if (TextUtils.equals(bgVar.a(), str)) {
                if (TextUtils.equals(TTLogUtil.TAG_EVENT_SHOW, str2)) {
                    bgVar.d();
                } else if (TextUtils.equals("click", str2)) {
                    Object obj = data.get(RewardItem.KEY_REASON);
                    bgVar.a(obj instanceof String ? (String) obj : "");
                } else if (TextUtils.equals("close", str2)) {
                    bgVar.e();
                }
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.ay
    public void f(IOAdEvent iOAdEvent) {
        if (iOAdEvent == null) {
            return;
        }
        Map<String, Object> data = iOAdEvent.getData();
        if (this.z == null || data == null || this.a == null) {
            return;
        }
        String str = (String) data.get(ay.f1458e);
        for (int i2 = 0; i2 < this.a.size(); i2++) {
            XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.a.get(i2);
            if (xAdNativeResponse != null && xAdNativeResponse.getUniqueId().equals(str)) {
                this.z.a(xAdNativeResponse, Integer.parseInt((String) data.get(ay.f1459f)));
            }
        }
    }

    public void a(e.b bVar) {
        this.B = bVar;
    }

    @Override // com.baidu.mobads.sdk.internal.ay
    public void a() {
        IAdInterListener iAdInterListener = this.f1464k;
        if (iAdInterListener == null) {
            this.f1465l = false;
            return;
        }
        this.f1465l = true;
        iAdInterListener.loadAd(k(), l());
    }

    @Override // com.baidu.mobads.sdk.internal.ay
    public void d(String str) {
        if (!TextUtils.isEmpty(str) && this.a != null) {
            for (int i2 = 0; i2 < this.a.size(); i2++) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.a.get(i2);
                if (xAdNativeResponse.getUniqueId().equals(str)) {
                    xAdNativeResponse.onAdUnionClick();
                }
            }
        }
        if (TextUtils.isEmpty(str) || this.q == null) {
            return;
        }
        for (int i3 = 0; i3 < this.q.size(); i3++) {
            bg bgVar = (bg) this.q.get(i3);
            if (TextUtils.equals(str, bgVar.a())) {
                bgVar.f();
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.ay
    public void b(IOAdEvent iOAdEvent) {
        if (this.B == null || iOAdEvent == null || this.a == null) {
            return;
        }
        String message = iOAdEvent.getMessage();
        for (int i2 = 0; i2 < this.a.size(); i2++) {
            XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.a.get(i2);
            if (xAdNativeResponse.getUniqueId().equals(message)) {
                this.B.a(xAdNativeResponse);
            }
        }
    }

    public void a(RequestParameters requestParameters) {
        int width = requestParameters.getWidth();
        int height = requestParameters.getHeight();
        if (width > 0 && height > 0) {
            this.v = width;
            this.w = height;
        }
        this.x = requestParameters;
        a(requestParameters.getExtras());
    }

    @Override // com.baidu.mobads.sdk.internal.ay
    public void e(String str) {
        if (!TextUtils.isEmpty(str) && this.a != null) {
            for (int i2 = 0; i2 < this.a.size(); i2++) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.a.get(i2);
                if (xAdNativeResponse.getUniqueId().equals(str)) {
                    xAdNativeResponse.onADPrivacyClick();
                }
            }
        }
        if (TextUtils.isEmpty(str) || this.q == null) {
            return;
        }
        for (int i3 = 0; i3 < this.q.size(); i3++) {
            bg bgVar = (bg) this.q.get(i3);
            if (TextUtils.equals(str, bgVar.a())) {
                bgVar.g();
            }
        }
    }

    public String h() {
        return this.u;
    }

    @Override // com.baidu.mobads.sdk.internal.ay
    public void b(String str, int i2) {
        e.a aVar = this.z;
        if (aVar != null) {
            aVar.b(i2, str);
        }
        BaiduNativeManager.ExpressAdListener expressAdListener = this.A;
        if (expressAdListener != null) {
            expressAdListener.onNativeFail(i2, str);
        }
    }

    public void a(int i2) {
        this.C = i2;
    }

    public ViewGroup a(a aVar) {
        JSONObject jSONObject = new JSONObject();
        HashMap hashMap = new HashMap();
        try {
            jSONObject.put("msg", "initExpressContainer");
            jSONObject.put("uniqueId", aVar.G());
        } catch (JSONException e2) {
            bj.a().a(e2);
        }
        a(jSONObject, hashMap);
        Object obj = hashMap.get("container");
        if (obj instanceof ViewGroup) {
            return (ViewGroup) obj;
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.internal.ay
    public void b(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.a != null) {
            for (int i2 = 0; i2 < this.a.size(); i2++) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.a.get(i2);
                if (xAdNativeResponse.getUniqueId().equals(str)) {
                    xAdNativeResponse.onAdDownloadWindow(z);
                }
            }
        }
        if (TextUtils.isEmpty(str) || this.q == null) {
            return;
        }
        for (int i3 = 0; i3 < this.q.size(); i3++) {
            bg bgVar = (bg) this.q.get(i3);
            if (TextUtils.equals(str, bgVar.a())) {
                bgVar.b(z);
            }
        }
    }

    public void a(ViewGroup viewGroup, a aVar) {
        JSONObject jSONObject = new JSONObject();
        HashMap hashMap = new HashMap();
        try {
            jSONObject.put("msg", "renderExpressView");
            jSONObject.put("uniqueId", aVar.G());
            hashMap.put("container", viewGroup);
        } catch (JSONException e2) {
            bj.a().a(e2);
        }
        a(jSONObject, hashMap);
    }

    public boolean a(View view, a aVar, int i2) {
        JSONObject jSONObject = new JSONObject();
        HashMap hashMap = new HashMap();
        try {
            jSONObject.put("msg", "switchTheme");
            hashMap.put("view", view);
            hashMap.put("code", Integer.valueOf(i2));
        } catch (JSONException e2) {
            bj.a().a(e2);
        }
        a(jSONObject, hashMap);
        Object obj = hashMap.get("result");
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }

    @Override // com.baidu.mobads.sdk.internal.ay
    public void a(int i2, String str) {
        e.a aVar = this.z;
        if (aVar != null) {
            aVar.a(i2, str);
        }
        BaiduNativeManager.ExpressAdListener expressAdListener = this.A;
        if (expressAdListener != null) {
            expressAdListener.onNoAd(i2, str);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.ay
    public void a(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.a != null) {
            for (int i2 = 0; i2 < this.a.size(); i2++) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.a.get(i2);
                if (xAdNativeResponse.getUniqueId().equals(str)) {
                    xAdNativeResponse.onADPermissionShow(z);
                }
            }
        }
        if (TextUtils.isEmpty(str) || this.q == null) {
            return;
        }
        for (int i3 = 0; i3 < this.q.size(); i3++) {
            bg bgVar = (bg) this.q.get(i3);
            if (TextUtils.equals(str, bgVar.a())) {
                bgVar.a(z);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.ay
    public void a(Map<String, String> map) {
        String[] strArr;
        int length;
        if (map == null || map.isEmpty()) {
            return;
        }
        HashMap hashMap = new HashMap(map);
        HashMap<String, String> hashMap2 = new HashMap<>();
        int i2 = 0;
        for (String str : ArticleInfo.PREDEFINED_KEYS) {
            if (hashMap.containsKey(str)) {
                String str2 = (String) hashMap.remove(str);
                if (!TextUtils.isEmpty(str2) && (length = str2.length() + i2) < 150) {
                    hashMap2.put(str, str2);
                    i2 = length;
                }
            }
        }
        if (!hashMap.isEmpty()) {
            for (String str3 : hashMap.keySet()) {
                if (!TextUtils.isEmpty(str3)) {
                    String str4 = (String) hashMap.get(str3);
                    if (!TextUtils.isEmpty(str4)) {
                        int length2 = i2 + str3.length() + str4.length();
                        if (length2 >= 150) {
                            break;
                        }
                        hashMap2.put("c_" + str3, str4);
                        i2 = length2 + 2;
                    } else {
                        continue;
                    }
                }
            }
        }
        this.f1466m = hashMap2;
    }
}
