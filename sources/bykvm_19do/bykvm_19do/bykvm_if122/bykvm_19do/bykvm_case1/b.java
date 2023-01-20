package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1;

import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.k;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.s;
import com.bytedance.msdk.api.AdSlot;
import java.util.List;

/* loaded from: classes.dex */
public class b {
    private String a;
    private int b;

    /* renamed from: e  reason: collision with root package name */
    private int f739e;

    /* renamed from: f  reason: collision with root package name */
    private String f740f;

    /* renamed from: g  reason: collision with root package name */
    private String f741g;

    /* renamed from: h  reason: collision with root package name */
    private String f742h;

    /* renamed from: i  reason: collision with root package name */
    private int f743i;

    /* renamed from: c  reason: collision with root package name */
    private int f737c = 1;

    /* renamed from: d  reason: collision with root package name */
    private int f738d = 0;
    public int ifTest = 0;

    public static AdSlot getShallowCopy(AdSlot adSlot) {
        if (adSlot == null) {
            return null;
        }
        AdSlot.Builder builder = new AdSlot.Builder();
        builder.setImageAdSize(adSlot.getImgAcceptedWidth(), adSlot.getImgAcceptedHeight()).setSupportDeepLink(adSlot.isSupportDeepLink()).setAdCount(adSlot.getAdCount()).setRewardName(adSlot.getRewardName()).setRewardAmount(adSlot.getRewardAmount()).setMediaExtra(adSlot.getMediaExtra()).setCustomData(adSlot.getCustomData()).setUserID(adSlot.getUserID()).setOrientation(adSlot.getOrientation()).setAdType(adSlot.getAdType()).setTTVideoOption(adSlot.getTTVideoOption()).setTTRequestExtraParams(adSlot.getReuestParam()).setAdStyleType(adSlot.getAdStyleType()).setBannerSize(adSlot.getBannerSize()).setAdmobNativeAdOptions(adSlot.getAdmobNativeAdOptions()).setGdtNativeAdLogoParams(adSlot.getGdtNativeAdLogoParams()).setSplashButtonType(adSlot.getSplashButtonType()).setDownloadType(adSlot.getDownloadType()).setBidNotify(adSlot.isBidNotify()).setForceLoadBottom(adSlot.isForceLoadBottom()).setTestSlotId(adSlot.getTestSlotId()).setV2Request(adSlot.isV2Request());
        AdSlot build = builder.build();
        List<String> a = k.a();
        k.b(a, "mAdWidth");
        k.b(a, "mAdHeight");
        k.b(a, "mSupportDeepLink");
        k.b(a, "mAdCount");
        k.b(a, "mRewardName");
        k.b(a, "mRewardAmount");
        k.b(a, "mMediaExtra");
        k.b(a, "mCustomData");
        k.b(a, "mUserID");
        k.b(a, "mOrientation");
        k.b(a, "mAdType");
        k.b(a, "mTTVideoOption");
        k.b(a, "mRequestParams");
        k.b(a, "mAdStyleType");
        k.b(a, "mBannerSize");
        k.b(a, "mAdmobNativeAdOptions");
        k.b(a, "gdtNativeAdLogoParams");
        k.b(a, "mSplashButtonType");
        k.b(a, "mDownloadType");
        k.b(a, "mBidNotify");
        k.b(a, "mForceLoadBottom");
        k.b(a, "mTestSlotId");
        k.b(a, "mV2Request");
        build.setAdUnitId(adSlot.getAdUnitId());
        k.b(a, "mAdUnitId");
        build.setVersion(adSlot.getVersion());
        k.b(a, "version");
        build.setWaterfallId(adSlot.getWaterfallId());
        k.b(a, "waterfallId");
        build.setAdloadSeq(adSlot.getAdloadSeq());
        k.b(a, "mAdloadSeq");
        build.setLinkedId(adSlot.getLinkedId());
        k.b(a, "mLinkedId");
        build.setSegmentId(adSlot.getSegmentId());
        k.b(a, "segmentId");
        build.setSegmentVersion(adSlot.getSegmentVersion());
        k.b(a, "segmentVersion");
        build.setReqType(adSlot.getReqType());
        k.b(a, "reqType");
        build.setmWaterfallExtra(adSlot.getmWaterfallExtra());
        k.b(a, "mWaterfallExtra");
        build.setTransparentParams(adSlot.getTransparentParams());
        k.b(a, "mTransparentParams");
        build.setIfTest(adSlot.getIfTest());
        k.b(a, "ifTest");
        build.setBidFloor(adSlot.getBidFloor());
        k.b(a, "mBidFloor");
        build.setParalleType(adSlot.getParalleType());
        k.b(a, "mParalleType");
        build.setReqParallelNum(adSlot.getReqParallelNum());
        k.b(a, "mReqParallelNum");
        build.setSplashShakeButton(adSlot.getSplashShakeButton());
        k.b(a, "mSplashShakeButton");
        build.setNetWorkNum("network_ad_num_" + adSlot.getNetWorkNum());
        k.b(a, "mNetWorkNum");
        build.setScenarioId(adSlot.getScenarioId());
        k.b(a, "mScenarioId");
        k.a(a, "AdSlot");
        return build;
    }

    public int getAdloadSeq() {
        return this.b;
    }

    public int getIfTest() {
        return this.ifTest;
    }

    public String getLinkedId() {
        return this.a;
    }

    public int getNetWorkNum() {
        return this.f743i;
    }

    public int getPrimeRitReqType() {
        return this.f737c;
    }

    public int getReqType() {
        return this.f738d;
    }

    public int getSegmentId() {
        return this.f739e;
    }

    public String getSegmentVersion() {
        return this.f740f;
    }

    public String getTransparentParams() {
        return this.f741g;
    }

    public String getmWaterfallExtra() {
        return this.f742h;
    }

    public void setAdloadSeq(int i2) {
        this.b = i2;
    }

    public void setIfTest(int i2) {
        this.ifTest = i2;
    }

    public void setLinkedId(String str) {
        this.a = str;
    }

    public void setNetWorkNum(String str) {
        this.f743i = s.a(str);
    }

    public void setPrimeRitReqType(int i2) {
        this.f737c = i2;
    }

    public void setReqType(int i2) {
        this.f738d = i2;
    }

    public void setSegmentId(int i2) {
        this.f739e = i2;
    }

    public void setSegmentVersion(String str) {
        this.f740f = str;
    }

    public void setTransparentParams(String str) {
        this.f741g = str;
    }

    public void setmWaterfallExtra(String str) {
        this.f742h = str;
    }
}
