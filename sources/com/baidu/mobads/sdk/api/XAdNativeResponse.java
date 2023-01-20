package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.internal.a;
import com.baidu.mobads.sdk.internal.an;
import com.baidu.mobads.sdk.internal.bj;
import com.baidu.mobads.sdk.internal.cg;
import com.baidu.mobads.sdk.internal.cw;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class XAdNativeResponse implements NativeResponse {
    private static final String TAG = "NativeResponse";
    private boolean isDownloadApp;
    private int mAdActionType = 1;
    private NativeResponse.AdDislikeListener mAdDislikeListener;
    private a mAdInstanceInfo;
    private NativeResponse.AdInteractionListener mAdInteractionListener;
    private NativeResponse.AdPrivacyListener mAdPrivacyListener;
    private Context mCxt;
    private cw mFeedsProd;
    private cg mUriUtils;

    /* loaded from: classes.dex */
    public static class DislikeInfo implements DislikeEvent {
        private String dislikeName;
        private int dislikeType;

        private DislikeInfo() {
        }

        @Override // com.baidu.mobads.sdk.api.DislikeEvent
        public String getDislikeName() {
            return this.dislikeName;
        }

        @Override // com.baidu.mobads.sdk.api.DislikeEvent
        public int getDislikeType() {
            return this.dislikeType;
        }
    }

    public XAdNativeResponse(Context context, cw cwVar, a aVar) {
        this.isDownloadApp = false;
        this.mCxt = context;
        this.mAdInstanceInfo = aVar;
        this.mFeedsProd = cwVar;
        if (aVar.p() == 2) {
            this.isDownloadApp = true;
        }
        this.mUriUtils = cg.a();
    }

    private int getActionType() {
        return this.mAdInstanceInfo.p();
    }

    private IAdInterListener getAdInterListener() {
        cw cwVar = this.mFeedsProd;
        if (cwVar != null) {
            return cwVar.f1464k;
        }
        return null;
    }

    private String getProd() {
        cw cwVar = this.mFeedsProd;
        return cwVar != null ? cwVar.f() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void biddingFail(String str) {
        cw cwVar;
        a aVar = this.mAdInstanceInfo;
        if (aVar == null || (cwVar = this.mFeedsProd) == null) {
            return;
        }
        cwVar.a(aVar.G(), false, str);
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void biddingSuccess(String str) {
        cw cwVar;
        a aVar = this.mAdInstanceInfo;
        if (aVar == null || (cwVar = this.mFeedsProd) == null) {
            return;
        }
        cwVar.a(aVar.G(), true, str);
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void clearImpressionTaskWhenBack() {
        cw cwVar = this.mFeedsProd;
        if (cwVar != null) {
            cwVar.p();
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void dislikeClick(DislikeEvent dislikeEvent) {
        a aVar = this.mAdInstanceInfo;
        if (aVar == null || this.mFeedsProd == null || !(dislikeEvent instanceof DislikeInfo)) {
            return;
        }
        JSONObject R = aVar.R();
        try {
            R.put("dislike_type", dislikeEvent.getDislikeType());
            R.put("msg", "dislike_click");
        } catch (Exception unused) {
        }
        this.mFeedsProd.a(R);
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getActButtonString() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            JSONObject R = aVar.R();
            try {
                R.put("msg", "creative_call");
                R.put("creative_type", "cta_get");
            } catch (Exception unused) {
            }
            this.mFeedsProd.a(R);
            return this.mAdInstanceInfo.L();
        }
        return "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public int getAdActionType() {
        return this.mAdActionType;
    }

    public NativeResponse.AdDislikeListener getAdDislikeListener() {
        return this.mAdDislikeListener;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getAdLogoUrl() {
        a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.h() : "https://cpro.baidustatic.com/cpro/logo/sdk/mob-adIcon_2x.png";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getAdMaterialType() {
        a aVar = this.mAdInstanceInfo;
        if (aVar == null) {
            return NativeResponse.MaterialType.NORMAL.getValue();
        }
        if ("video".equals(aVar.x())) {
            return NativeResponse.MaterialType.VIDEO.getValue();
        }
        if (a.f1401f.equals(this.mAdInstanceInfo.x())) {
            return NativeResponse.MaterialType.HTML.getValue();
        }
        return NativeResponse.MaterialType.NORMAL.getValue();
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getAppPackage() {
        a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.m() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getAppPermissionLink() {
        a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.D() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getAppPrivacyLink() {
        a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.C() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public long getAppSize() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.j();
        }
        return 0L;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getAppVersion() {
        a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.A() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getBaiduLogoUrl() {
        a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.i() : "https://cpro.baidustatic.com/cpro/logo/sdk/new-bg-logo.png";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getBrandName() {
        a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.g() : "";
    }

    public List<String> getBtnStyleColors() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.N();
        }
        return null;
    }

    public int getBtnStyleType() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.M();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public int getContainerHeight() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.s();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public int getContainerSizeType() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.t();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public int getContainerWidth() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.r();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getDesc() {
        a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.b() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public List<DislikeEvent> getDislikeList() {
        ArrayList arrayList = new ArrayList();
        if (this.mAdInstanceInfo != null && this.mFeedsProd != null) {
            try {
                HashMap hashMap = new HashMap();
                JSONObject R = this.mAdInstanceInfo.R();
                R.put("msg", "dislike_mapping");
                this.mFeedsProd.a(R, hashMap);
                Object obj = hashMap.get("dislike_data");
                if (obj instanceof Map) {
                    Map map = (Map) obj;
                    for (String str : map.keySet()) {
                        DislikeInfo dislikeInfo = new DislikeInfo();
                        dislikeInfo.dislikeName = str;
                        dislikeInfo.dislikeType = ((Integer) map.get(str)).intValue();
                        arrayList.add(dislikeInfo);
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return arrayList;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public int getDownloadStatus() {
        Context context;
        if (!this.isDownloadApp || (context = this.mCxt) == null) {
            return -1;
        }
        return an.a(context.getApplicationContext()).a(this.mCxt.getApplicationContext(), getAppPackage());
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public int getDuration() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.w();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getECPMLevel() {
        a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.z() : "";
    }

    public JSONObject getExtraParams() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.H();
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public Map<String, String> getExtras() {
        HashMap hashMap = new HashMap();
        cw cwVar = this.mFeedsProd;
        if (cwVar != null) {
            hashMap.put("appsid", cwVar.o);
        }
        return hashMap;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getHtmlSnippet() {
        a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.o() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getIconUrl() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            String c2 = aVar.c();
            return TextUtils.isEmpty(c2) ? this.mAdInstanceInfo.d() : c2;
        }
        return "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getImageUrl() {
        a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.d() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public int getMainPicHeight() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.f();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public int getMainPicWidth() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.e();
        }
        return 0;
    }

    public String getMarketingDesc() {
        a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.J() : "";
    }

    public String getMarketingICONUrl() {
        a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.I() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getMarketingPendant() {
        a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.K() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public NativeResponse.MaterialType getMaterialType() {
        a aVar = this.mAdInstanceInfo;
        if (aVar == null) {
            return NativeResponse.MaterialType.NORMAL;
        }
        if ("video".equals(aVar.x())) {
            return NativeResponse.MaterialType.VIDEO;
        }
        if (a.f1401f.equals(this.mAdInstanceInfo.x())) {
            return NativeResponse.MaterialType.HTML;
        }
        return NativeResponse.MaterialType.NORMAL;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public List<String> getMultiPicUrls() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.F();
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getPublisher() {
        a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.B() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public int getStyleType() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.u();
        }
        return 0;
    }

    public List<String> getThirdTrackers(String str) {
        if (this.mAdInstanceInfo == null) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            JSONObject O = this.mAdInstanceInfo.O();
            if (O != null) {
                Iterator<String> keys = O.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (next.equals(str)) {
                        JSONArray optJSONArray = O.optJSONArray(next);
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            arrayList.add(optJSONArray.optString(i2));
                        }
                    }
                }
            }
            return arrayList;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getTitle() {
        a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.a() : "";
    }

    public String getUniqueId() {
        a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.G() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public String getVideoUrl() {
        a aVar = this.mAdInstanceInfo;
        return aVar != null ? aVar.n() : "";
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public WebView getWebView() {
        cw cwVar = this.mFeedsProd;
        if (cwVar != null) {
            return (WebView) cwVar.v();
        }
        return null;
    }

    public void handleClick(View view) {
        handleClick(view, -1);
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public boolean isAdAvailable(Context context) {
        return this.mAdInstanceInfo != null && System.currentTimeMillis() - this.mAdInstanceInfo.y() <= this.mAdInstanceInfo.E();
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public boolean isAutoPlay() {
        a aVar = this.mAdInstanceInfo;
        return aVar != null && aVar.k() == 1;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public boolean isNeedDownloadApp() {
        return this.isDownloadApp;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public boolean isNonWifiAutoPlay() {
        a aVar = this.mAdInstanceInfo;
        return aVar == null || aVar.l() == 1;
    }

    public int isRegionClick() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.P();
        }
        return 2;
    }

    public int isShowDialog() {
        a aVar = this.mAdInstanceInfo;
        if (aVar != null) {
            return aVar.Q();
        }
        return 2;
    }

    public void onADExposed() {
        NativeResponse.AdInteractionListener adInteractionListener = this.mAdInteractionListener;
        if (adInteractionListener != null) {
            adInteractionListener.onADExposed();
        }
    }

    public void onADExposureFailed(int i2) {
        NativeResponse.AdInteractionListener adInteractionListener = this.mAdInteractionListener;
        if (adInteractionListener != null) {
            adInteractionListener.onADExposureFailed(i2);
        }
    }

    public void onADPermissionShow(boolean z) {
        NativeResponse.AdPrivacyListener adPrivacyListener = this.mAdPrivacyListener;
        if (adPrivacyListener != null) {
            if (z) {
                adPrivacyListener.onADPermissionShow();
            } else {
                adPrivacyListener.onADPermissionClose();
            }
        }
    }

    public void onADPrivacyClick() {
        NativeResponse.AdPrivacyListener adPrivacyListener = this.mAdPrivacyListener;
        if (adPrivacyListener != null) {
            adPrivacyListener.onADPrivacyClick();
        }
    }

    public void onADStatusChanged() {
        NativeResponse.AdInteractionListener adInteractionListener = this.mAdInteractionListener;
        if (adInteractionListener != null) {
            adInteractionListener.onADStatusChanged();
        }
    }

    public void onAdClick() {
        NativeResponse.AdInteractionListener adInteractionListener = this.mAdInteractionListener;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClick();
        }
    }

    public void onAdDownloadWindow(boolean z) {
        NativeResponse.AdPrivacyListener adPrivacyListener = this.mAdPrivacyListener;
        if (adPrivacyListener == null || !(adPrivacyListener instanceof NativeResponse.AdDownloadWindowListener)) {
            return;
        }
        if (z) {
            ((NativeResponse.AdDownloadWindowListener) adPrivacyListener).adDownloadWindowShow();
        } else {
            ((NativeResponse.AdDownloadWindowListener) adPrivacyListener).adDownloadWindowClose();
        }
    }

    public void onAdUnionClick() {
        NativeResponse.AdInteractionListener adInteractionListener = this.mAdInteractionListener;
        if (adInteractionListener != null) {
            adInteractionListener.onAdUnionClick();
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void pauseAppDownload() {
        if (this.mCxt == null || !this.isDownloadApp || this.mFeedsProd == null) {
            return;
        }
        JSONObject R = this.mAdInstanceInfo.R();
        try {
            R.put(PushConstants.URI_PACKAGE_NAME, getAppPackage());
            R.put("msg", "pauseDownload");
        } catch (JSONException unused) {
        }
        an.a(this.mCxt.getApplicationContext()).a(getAppPackage());
        this.mFeedsProd.a(R);
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void permissionClick() {
        a aVar = this.mAdInstanceInfo;
        if (aVar == null || this.mFeedsProd == null) {
            return;
        }
        String D = aVar.D();
        JSONObject R = this.mAdInstanceInfo.R();
        try {
            R.put("permissionUrl", D);
            R.put("msg", "permissionClick");
        } catch (JSONException unused) {
        }
        this.mFeedsProd.a(R);
    }

    public void preloadVideoMaterial() {
        a aVar;
        if (this.mFeedsProd == null || (aVar = this.mAdInstanceInfo) == null) {
            return;
        }
        JSONObject R = aVar.R();
        try {
            R.put("msg", "preloadVideoMaterial");
        } catch (JSONException unused) {
        }
        this.mFeedsProd.a(R);
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void privacyClick() {
        a aVar = this.mAdInstanceInfo;
        if (aVar == null || this.mFeedsProd == null) {
            return;
        }
        String C = aVar.C();
        JSONObject R = this.mAdInstanceInfo.R();
        try {
            R.put("privacy_link", C);
            R.put("msg", "privacyClick");
        } catch (JSONException unused) {
        }
        this.mFeedsProd.a(R);
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void recordImpression(View view) {
        a aVar;
        cw cwVar = this.mFeedsProd;
        if (cwVar == null || (aVar = this.mAdInstanceInfo) == null) {
            return;
        }
        cwVar.a(view, aVar.R());
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void registerViewForInteraction(View view, List<View> list, List<View> list2, NativeResponse.AdInteractionListener adInteractionListener) {
        this.mAdInteractionListener = adInteractionListener;
        if (this.mFeedsProd != null) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("adView", view);
                hashMap.put("clickViews", list);
                hashMap.put("creativeViews", list2);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("msg", "registerViewForInteraction");
                jSONObject.put("uniqueId", getUniqueId());
                jSONObject.put("isDownloadApp", this.isDownloadApp);
                this.mFeedsProd.a(jSONObject, hashMap);
            } catch (Throwable th) {
                bj a = bj.a();
                a.c(TAG, "registerViewForInteraction failed: " + th.getMessage());
            }
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void resumeAppDownload() {
        a aVar;
        if (!this.isDownloadApp || this.mFeedsProd == null || (aVar = this.mAdInstanceInfo) == null) {
            return;
        }
        JSONObject R = aVar.R();
        try {
            R.put("msg", "resumeDownload");
        } catch (JSONException unused) {
        }
        this.mFeedsProd.a(R);
    }

    public void setAdActionType(int i2) {
        this.mAdActionType = i2;
    }

    public void setAdDislikeListener(NativeResponse.AdDislikeListener adDislikeListener) {
        this.mAdDislikeListener = adDislikeListener;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void setAdPrivacyListener(NativeResponse.AdPrivacyListener adPrivacyListener) {
        this.mAdPrivacyListener = adPrivacyListener;
    }

    public void setIsDownloadApp(boolean z) {
        this.isDownloadApp = z;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse
    public void unionLogoClick() {
        cg cgVar;
        if (this.mFeedsProd == null || (cgVar = this.mUriUtils) == null) {
            return;
        }
        String c2 = cgVar.c("http://union.baidu.com/");
        JSONObject R = this.mAdInstanceInfo.R();
        try {
            R.put("unionUrl", c2);
            R.put("msg", "unionLogoClick");
        } catch (Throwable unused) {
        }
        this.mFeedsProd.a(R);
    }

    public void handleClick(View view, int i2) {
        handleClick(view, i2, false);
    }

    public void handleClick(View view, boolean z) {
        handleClick(view, -1, z);
    }

    public void handleClick(View view, int i2, boolean z) {
        a aVar;
        if (this.mFeedsProd == null || (aVar = this.mAdInstanceInfo) == null) {
            return;
        }
        JSONObject R = aVar.R();
        try {
            R.put("progress", i2);
            R.put(SplashAd.KEY_POPDIALOG_DOWNLOAD, z);
            R.put("isDownloadApp", this.isDownloadApp);
        } catch (Throwable unused) {
        }
        this.mFeedsProd.b(view, R);
    }
}
