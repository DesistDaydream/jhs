package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.internal.ab;
import com.baidu.mobads.sdk.internal.ai;
import com.baidu.mobads.sdk.internal.cw;
import com.baidu.mobads.sdk.internal.e;
import java.util.List;

/* loaded from: classes.dex */
public class BaiduNativeManager {
    private static final int FEED_TIMEOUT = 8000;
    private static final String TAG = "BaiduNativeManager";
    private boolean isCacheVideo;
    private boolean isCacheVideoOnlyWifi;
    private final String mAdPlacementId;
    private String mAppSid;
    private int mBidFloor;
    private final Context mContext;
    private RequestParameters mRequestParameters;
    private int mTimeoutMillis;

    /* loaded from: classes.dex */
    public interface ExpressAdListener {
        void onLpClosed();

        void onNativeFail(int i2, String str);

        void onNativeLoad(List<ExpressResponse> list);

        void onNoAd(int i2, String str);

        void onVideoDownloadFailed();

        void onVideoDownloadSuccess();
    }

    /* loaded from: classes.dex */
    public interface FeedAdListener {
        void onLpClosed();

        void onNativeFail(int i2, String str);

        void onNativeLoad(List<NativeResponse> list);

        void onNoAd(int i2, String str);

        void onVideoDownloadFailed();

        void onVideoDownloadSuccess();
    }

    /* loaded from: classes.dex */
    public interface PortraitVideoAdListener extends FeedAdListener {
        void onAdClick();
    }

    public BaiduNativeManager(Context context, String str) {
        this(context, str, 8000);
    }

    private void loadBiddingAd(String str, String str2, FeedAdListener feedAdListener, ExpressAdListener expressAdListener) {
        cw cwVar = new cw(this.mContext, this.mAdPlacementId, str, this.isCacheVideo, this.mTimeoutMillis);
        if (!TextUtils.isEmpty(this.mAppSid)) {
            cwVar.g(this.mAppSid);
        }
        cwVar.p = this.mBidFloor;
        cwVar.c(this.isCacheVideoOnlyWifi);
        if (feedAdListener != null) {
            cwVar.a(new ab(feedAdListener));
        } else if (expressAdListener != null) {
            cwVar.a(expressAdListener);
            cwVar.a(1);
        }
        cwVar.a(new ai());
        RequestParameters requestParameters = this.mRequestParameters;
        if (requestParameters == null) {
            requestParameters = new RequestParameters.Builder().build();
        }
        cwVar.a(requestParameters);
        cwVar.m();
        cwVar.c(str2);
    }

    public String getExpressFeedBiddingToken(RequestParameters requestParameters) {
        cw cwVar = new cw(this.mContext, this.mAdPlacementId, IAdInterListener.AdProdType.PRODUCT_FEEDS, this.isCacheVideo, this.mTimeoutMillis);
        cwVar.a(1);
        if (requestParameters == null) {
            requestParameters = new RequestParameters.Builder().build();
        }
        if (!TextUtils.isEmpty(this.mAppSid)) {
            cwVar.g(this.mAppSid);
        }
        cwVar.p = this.mBidFloor;
        cwVar.a(requestParameters);
        this.mRequestParameters = requestParameters;
        return cwVar.m();
    }

    public String getFeedBiddingToken(RequestParameters requestParameters) {
        cw cwVar = new cw(this.mContext, this.mAdPlacementId, IAdInterListener.AdProdType.PRODUCT_FEEDS, this.isCacheVideo, this.mTimeoutMillis);
        if (requestParameters == null) {
            requestParameters = new RequestParameters.Builder().build();
        }
        if (!TextUtils.isEmpty(this.mAppSid)) {
            cwVar.g(this.mAppSid);
        }
        cwVar.p = this.mBidFloor;
        cwVar.a(requestParameters);
        this.mRequestParameters = requestParameters;
        return cwVar.m();
    }

    public String getPortraitVideoBiddingToken(RequestParameters requestParameters) {
        cw cwVar = new cw(this.mContext, this.mAdPlacementId, IAdInterListener.AdProdType.PRODUCT_PORTRAITVIDEO, this.isCacheVideo, this.mTimeoutMillis);
        if (requestParameters == null) {
            requestParameters = new RequestParameters.Builder().build();
        }
        if (!TextUtils.isEmpty(this.mAppSid)) {
            cwVar.g(this.mAppSid);
        }
        cwVar.p = this.mBidFloor;
        cwVar.a(requestParameters);
        this.mRequestParameters = requestParameters;
        return cwVar.m();
    }

    public void loadBidAdForExpress(String str, ExpressAdListener expressAdListener) {
        loadBiddingAd(IAdInterListener.AdProdType.PRODUCT_FEEDS, str, null, expressAdListener);
    }

    public void loadBidAdForFeed(String str, FeedAdListener feedAdListener) {
        loadBiddingAd(IAdInterListener.AdProdType.PRODUCT_FEEDS, str, feedAdListener, null);
    }

    public void loadBidAdForPortraitVideo(String str, PortraitVideoAdListener portraitVideoAdListener) {
        loadBiddingAd(IAdInterListener.AdProdType.PRODUCT_PORTRAITVIDEO, str, portraitVideoAdListener, null);
    }

    public void loadContentAd(RequestParameters requestParameters, FeedAdListener feedAdListener) {
        e eVar = new e(this.mContext, new ab(feedAdListener), new cw(this.mContext, this.mAdPlacementId, "content", this.isCacheVideo, this.mTimeoutMillis));
        if (!TextUtils.isEmpty(this.mAppSid)) {
            eVar.b(this.mAppSid);
        }
        eVar.a(this.mBidFloor);
        eVar.a(this.isCacheVideoOnlyWifi);
        eVar.a(new ai());
        eVar.b(requestParameters);
    }

    public void loadExpressAd(RequestParameters requestParameters, ExpressAdListener expressAdListener) {
        e eVar = new e(this.mContext, this.mAdPlacementId, expressAdListener, this.isCacheVideo, this.mTimeoutMillis);
        if (!TextUtils.isEmpty(this.mAppSid)) {
            eVar.b(this.mAppSid);
        }
        eVar.a(this.mBidFloor);
        eVar.a(this.isCacheVideoOnlyWifi);
        eVar.a(new ai());
        eVar.b(requestParameters);
    }

    public void loadFeedAd(RequestParameters requestParameters, FeedAdListener feedAdListener) {
        e eVar = new e(this.mContext, this.mAdPlacementId, new ab(feedAdListener), this.isCacheVideo, this.mTimeoutMillis);
        if (!TextUtils.isEmpty(this.mAppSid)) {
            eVar.b(this.mAppSid);
        }
        eVar.a(this.mBidFloor);
        eVar.a(this.isCacheVideoOnlyWifi);
        eVar.a(new ai());
        eVar.b(requestParameters);
    }

    public void loadInsiteAd(RequestParameters requestParameters, FeedAdListener feedAdListener) {
        e eVar = new e(this.mContext, new ab(feedAdListener), new cw(this.mContext, this.mAdPlacementId, IAdInterListener.AdProdType.PRODUCT_INSITE, this.isCacheVideo, this.mTimeoutMillis));
        if (!TextUtils.isEmpty(this.mAppSid)) {
            eVar.b(this.mAppSid);
        }
        eVar.a(this.mBidFloor);
        eVar.a(this.isCacheVideoOnlyWifi);
        eVar.a(new ai());
        eVar.b(requestParameters);
    }

    public void loadPortraitVideoAd(RequestParameters requestParameters, PortraitVideoAdListener portraitVideoAdListener) {
        loadPortraitVideoAd(requestParameters, (FeedAdListener) portraitVideoAdListener);
    }

    public void loadPrerollVideo(RequestParameters requestParameters, FeedAdListener feedAdListener) {
        e eVar = new e(this.mContext, this.mAdPlacementId, new ab(feedAdListener), this.isCacheVideo, 8000, IAdInterListener.AdProdType.PRODUCT_PREROLL);
        if (!TextUtils.isEmpty(this.mAppSid)) {
            eVar.b(this.mAppSid);
        }
        eVar.a(this.mBidFloor);
        eVar.b(requestParameters);
    }

    public void setAppSid(String str) {
        this.mAppSid = str;
    }

    public void setBidFloor(int i2) {
        this.mBidFloor = i2;
    }

    public void setCacheVideoOnlyWifi(boolean z) {
        this.isCacheVideoOnlyWifi = z;
    }

    @Deprecated
    public void setExpressFeedBiddingData(RequestParameters requestParameters, String str, ExpressAdListener expressAdListener) {
        e eVar = new e(this.mContext, this.mAdPlacementId, expressAdListener, this.isCacheVideo, this.mTimeoutMillis);
        if (!TextUtils.isEmpty(this.mAppSid)) {
            eVar.b(this.mAppSid);
        }
        eVar.a(this.mBidFloor);
        eVar.a(this.isCacheVideoOnlyWifi);
        eVar.a(new ai());
        eVar.a(requestParameters);
        eVar.a(str);
    }

    @Deprecated
    public void setFeedBiddingData(RequestParameters requestParameters, String str, FeedAdListener feedAdListener) {
        e eVar = new e(this.mContext, this.mAdPlacementId, new ab(feedAdListener), this.isCacheVideo, this.mTimeoutMillis);
        if (!TextUtils.isEmpty(this.mAppSid)) {
            eVar.b(this.mAppSid);
        }
        eVar.a(this.mBidFloor);
        eVar.a(this.isCacheVideoOnlyWifi);
        eVar.a(new ai());
        eVar.a(requestParameters);
        eVar.a(str);
    }

    @Deprecated
    public void setPortraitVideoBiddingData(RequestParameters requestParameters, String str, PortraitVideoAdListener portraitVideoAdListener) {
        e eVar = new e(this.mContext, new ab(portraitVideoAdListener), new cw(this.mContext, this.mAdPlacementId, IAdInterListener.AdProdType.PRODUCT_PORTRAITVIDEO, this.isCacheVideo, this.mTimeoutMillis));
        if (!TextUtils.isEmpty(this.mAppSid)) {
            eVar.b(this.mAppSid);
        }
        eVar.a(this.mBidFloor);
        eVar.a(this.isCacheVideoOnlyWifi);
        eVar.a(new ai());
        eVar.a(requestParameters);
        eVar.a(str);
    }

    public BaiduNativeManager(Context context, String str, int i2) {
        this(context, str, true, i2);
    }

    public void loadBidAdForPortraitVideo(String str, FeedAdListener feedAdListener) {
        loadBiddingAd(IAdInterListener.AdProdType.PRODUCT_PORTRAITVIDEO, str, feedAdListener, null);
    }

    public void loadPortraitVideoAd(RequestParameters requestParameters, FeedAdListener feedAdListener) {
        e eVar = new e(this.mContext, new ab(feedAdListener), new cw(this.mContext, this.mAdPlacementId, IAdInterListener.AdProdType.PRODUCT_PORTRAITVIDEO, this.isCacheVideo, this.mTimeoutMillis));
        if (!TextUtils.isEmpty(this.mAppSid)) {
            eVar.b(this.mAppSid);
        }
        eVar.a(this.mBidFloor);
        eVar.a(this.isCacheVideoOnlyWifi);
        eVar.a(new ai());
        eVar.b(requestParameters);
    }

    public BaiduNativeManager(Context context, String str, boolean z) {
        this(context, str, z, 8000);
    }

    public BaiduNativeManager(Context context, String str, boolean z, int i2) {
        this.isCacheVideo = true;
        this.mTimeoutMillis = 8000;
        this.isCacheVideoOnlyWifi = false;
        this.mBidFloor = -1;
        this.mContext = context;
        this.mAdPlacementId = str;
        this.isCacheVideo = z;
        this.mTimeoutMillis = i2;
    }
}
