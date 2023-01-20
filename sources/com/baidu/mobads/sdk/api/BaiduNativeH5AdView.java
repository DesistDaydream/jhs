package com.baidu.mobads.sdk.api;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.internal.ap;
import com.baidu.mobads.sdk.internal.cv;

/* loaded from: classes.dex */
public class BaiduNativeH5AdView extends RelativeLayout {
    private BaiduNativeAdPlacement mAdPlacement;
    private cv mAdProd;
    private BaiduNativeH5EventListner mAdViewListener;
    private RequestParameters mRequestParameters;

    /* loaded from: classes.dex */
    public interface BaiduNativeH5EventListner {
        void onAdClick();

        void onAdDataLoaded();

        void onAdFail(String str);

        void onAdShow();
    }

    public BaiduNativeH5AdView(Context context, int i2) {
        super(context);
        this.mAdViewListener = null;
        initView(context, i2);
    }

    private void cancel() {
    }

    @SuppressLint({"NewApi"})
    private void initView(Context context, int i2) {
        if (i2 != 0) {
            setBackgroundResource(i2);
        }
    }

    private void onDetach() {
        cancel();
        cv cvVar = this.mAdProd;
        if (cvVar != null) {
            cvVar.e();
        }
    }

    public BaiduNativeAdPlacement getAdPlacement() {
        return this.mAdPlacement;
    }

    public boolean isAdDataLoaded() {
        cv cvVar = this.mAdProd;
        if (cvVar != null) {
            return cvVar.g();
        }
        return false;
    }

    public void makeRequest(RequestParameters requestParameters) {
        if (requestParameters == null) {
            requestParameters = new RequestParameters.Builder().build();
        }
        this.mRequestParameters = requestParameters;
        if (this.mAdProd != null) {
            onDetach();
        }
        cv cvVar = new cv(getContext(), IAdInterListener.AdProdType.PRODUCT_FEEDS, this);
        this.mAdProd = cvVar;
        cvVar.a(requestParameters);
        this.mAdProd.a(this.mAdPlacement);
        this.mAdProd.a(this.mAdPlacement.getSessionId());
        this.mAdProd.c(this.mAdPlacement.getPosistionId());
        this.mAdProd.d(this.mAdPlacement.getSequenceId());
        BaiduNativeH5EventListner baiduNativeH5EventListner = this.mAdViewListener;
        if (baiduNativeH5EventListner != null) {
            this.mAdProd.a(baiduNativeH5EventListner);
        }
        BaiduNativeAdPlacement baiduNativeAdPlacement = this.mAdPlacement;
        if (baiduNativeAdPlacement != null) {
            if (baiduNativeAdPlacement.hasValidResponse()) {
                if (this.mAdProd.f()) {
                    return;
                }
            } else {
                this.mAdProd.c(false);
                if (this.mAdPlacement.getRequestStarted()) {
                    return;
                }
                this.mAdPlacement.setRequestStarted(true);
            }
        }
        this.mAdProd.a();
    }

    public void recordImpression() {
        BaiduNativeAdPlacement baiduNativeAdPlacement = this.mAdPlacement;
        if (baiduNativeAdPlacement == null || baiduNativeAdPlacement.getResponse() == null || this.mAdPlacement.isWinSended()) {
            return;
        }
        this.mAdProd.a(this, this.mAdPlacement.getResponse().R());
    }

    public void setAdPlacement(BaiduNativeAdPlacement baiduNativeAdPlacement) {
        this.mAdPlacement = baiduNativeAdPlacement;
    }

    public void setAdPlacementData(Object obj) {
        BaiduNativeAdPlacement baiduNativeAdPlacement = new BaiduNativeAdPlacement();
        baiduNativeAdPlacement.setApId((String) ap.a(obj, "getApId", new Class[0], new Object[0]));
        String str = (String) ap.a(obj, "getAppSid", new Class[0], new Object[0]);
        this.mAdPlacement = baiduNativeAdPlacement;
    }

    public void setEventListener(BaiduNativeH5EventListner baiduNativeH5EventListner) {
        this.mAdViewListener = baiduNativeH5EventListner;
    }

    public BaiduNativeH5AdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mAdViewListener = null;
        initView(context, 0);
    }

    public BaiduNativeH5AdView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mAdViewListener = null;
        initView(context, 0);
    }
}
