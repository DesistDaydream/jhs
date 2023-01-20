package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.api.CPUWebAdRequestParam;
import com.baidu.mobads.sdk.api.CpuAdView;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class cj extends ay {
    private HashMap<String, Object> a;
    private int q;
    private RelativeLayout r;
    private CpuAdView.CpuAdViewInternalStatusListener s;

    public cj(Context context, RelativeLayout relativeLayout, String str, int i2, CPUWebAdRequestParam cPUWebAdRequestParam) {
        super(context);
        this.o = str;
        this.r = relativeLayout;
        this.q = i2;
        this.a = (HashMap) cPUWebAdRequestParam.getParameters();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Map<String, Object> map) {
        if (map != null) {
            Object obj = map.get("adInnerPageInterval");
            Object obj2 = map.get("adBottomRefreshInterval");
            Object obj3 = map.get("adFrontChapterInterval");
            Object obj4 = map.get("isShowFeeds");
            Object obj5 = map.get("isAdSwitch");
            Object obj6 = map.get("showCount");
            Object obj7 = map.get("clickCount");
            if (obj != null && obj2 != null) {
                al.a(((Integer) obj).intValue());
                al.b(((Integer) obj2).intValue());
            }
            if ((obj3 instanceof Integer) && (obj4 instanceof Boolean)) {
                al.a(((Integer) obj3).intValue(), ((Boolean) obj4).booleanValue());
            }
            if (obj5 instanceof Integer) {
                al.a(((Integer) obj5).intValue() != 0);
            }
            if ((obj6 instanceof Integer) && (obj7 instanceof Integer)) {
                al.a(((Integer) obj6).intValue(), ((Integer) obj7).intValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        al.b();
    }

    @Override // com.baidu.mobads.sdk.internal.ay
    public void b(String str, int i2) {
        CpuAdView.CpuAdViewInternalStatusListener cpuAdViewInternalStatusListener = this.s;
        if (cpuAdViewInternalStatusListener != null) {
            cpuAdViewInternalStatusListener.loadDataError(str);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.ay
    public void d() {
        CpuAdView.CpuAdViewInternalStatusListener cpuAdViewInternalStatusListener = this.s;
        if (cpuAdViewInternalStatusListener != null) {
            cpuAdViewInternalStatusListener.onExitLp();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.ay
    public void e(IOAdEvent iOAdEvent) {
        Map<String, Object> data = iOAdEvent.getData();
        Boolean bool = (Boolean) data.get("isImpressionFeAd");
        String str = (String) data.get("nums");
        if (this.s != null && bool != null && bool.booleanValue()) {
            this.s.onAdImpression(str);
            return;
        }
        CpuAdView.CpuAdViewInternalStatusListener cpuAdViewInternalStatusListener = this.s;
        if (cpuAdViewInternalStatusListener == null || bool == null) {
            return;
        }
        cpuAdViewInternalStatusListener.onContentImpression(str);
    }

    public Activity f() {
        return al.c();
    }

    public boolean g() {
        return al.d();
    }

    @Override // com.baidu.mobads.sdk.internal.ay
    public void h(IOAdEvent iOAdEvent) {
        Boolean bool = (Boolean) iOAdEvent.getData().get("isClickFeAd");
        if (this.s != null && bool != null && bool.booleanValue()) {
            this.s.onAdClick();
            return;
        }
        CpuAdView.CpuAdViewInternalStatusListener cpuAdViewInternalStatusListener = this.s;
        if (cpuAdViewInternalStatusListener == null || bool == null) {
            return;
        }
        cpuAdViewInternalStatusListener.onContentClick();
    }

    @Override // com.baidu.mobads.sdk.internal.ay
    public void d(IOAdEvent iOAdEvent) {
        if (this.s == null || iOAdEvent == null) {
            return;
        }
        this.s.onLpContentStatus(iOAdEvent.getData());
    }

    @Override // com.baidu.mobads.sdk.internal.ay
    public void a() {
        if (this.f1464k == null) {
            this.f1465l = false;
            return;
        }
        this.f1465l = true;
        JSONObject jSONObject = new JSONObject();
        if (this.f1464k != null) {
            try {
                jSONObject.put("channel", this.q);
                jSONObject.put(IAdInterListener.AdReqParam.PROD, "cpu_h5");
                jSONObject.put("timeout", 10000);
                if (!TextUtils.isEmpty(this.o)) {
                    jSONObject.put("appid", this.o);
                }
                if (this.r != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(IAdInterListener.AdReqParam.PROD, "cpu_h5");
                    this.f1464k.createProdHandler(jSONObject2);
                    this.f1464k.setAdContainer(this.r);
                    n();
                    this.f1464k.addEventListener("Update_fbReader_Setting", new ck(this));
                    this.f1464k.addEventListener("closeInterstitialAd", new cl(this));
                    this.f1464k.addEventListener("feOpenFbReader", new cm(this));
                    JSONObject a = j.a(this.a);
                    a.put("isInitNovelSDK", al.f());
                    this.f1464k.loadAd(jSONObject, a);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, int i3, String str, int i4, int i5, String str2) {
        al.a(i2);
        al.b(i3);
        al.a(new cn(this, i4, i5, str2));
        al.a(this.f1461h, str);
    }

    public void a(CpuAdView.CpuAdViewInternalStatusListener cpuAdViewInternalStatusListener) {
        this.s = cpuAdViewInternalStatusListener;
    }
}
