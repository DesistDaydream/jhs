package com.bytedance.msdk.base;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_19do.a;
import com.bytedance.ad.sdk.ad_mediation_sdk.R;
import com.bytedance.msdk.adapter.listener.ITTAdatperCallback;
import com.bytedance.msdk.api.TTAdConstant;
import com.bytedance.msdk.api.format.TTNativeAdView;
import com.bytedance.msdk.api.v2.GMAdConstant;
import com.bytedance.msdk.api.v2.GMAdDislike;
import com.bytedance.msdk.api.v2.GMDislikeCallback;
import com.bytedance.msdk.api.v2.GMNetworkPlatformConst;
import com.bytedance.msdk.api.v2.ad.GMAdAppDownloadListener;
import com.bytedance.msdk.api.v2.ad.custom.GMCustomTTBaseAd;
import com.bytedance.msdk.api.v2.ad.draw.GMDrawAdListener;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAdListener;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeCustomVideoReporter;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMViewBinder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class TTBaseAd implements Comparable<TTBaseAd> {
    private Map<String, Object> appInfoExtra;
    private String appName;
    private String authorName;
    private String errorMsg;
    private long fillTime;
    private boolean isUseCustomVideo;
    private String levelTag;
    private String linkIdFromRealReq;
    private String mActionText;
    private String mAdExtra;
    private String mAdNetWorkName;
    private String mAdNetworkSlotId;
    private int mAdNetworkSlotType;
    private int mAdType;
    private String mAid;
    private int mAppSize;
    private boolean mCacheSuccess;
    private double mCpm;
    private String mCustomAdNetWorkName;
    private String mDescription;
    private String mFailCallback;
    public GMDrawAdListener mGMDrawAdListener;
    private volatile boolean mHasShown;
    private String mIconUrl;
    private int mImageHeight;
    private int mImageMode;
    private String mImageUrl;
    private int mImageWidth;
    private int mInteractionType;
    private boolean mIsAppDownload;
    private boolean mIsExpressAd;
    private int mLoadSort;
    private String mPackageName;
    private int mPricingType;
    private double mRating;
    private String mRit;
    private int mSdkNum;
    private String mSdkVersion;
    private double mServerBiddingLoadCpm;
    private double mServerBiddingShowCpm;
    private int mShowSort;
    private String mSource;
    private String mStore;
    private int mSubAdType;
    public GMAdAppDownloadListener mTTAdAppDownloadListener;
    public ITTAdatperCallback mTTAdatperCallback;
    public ITTAdatperCallback mTTAdatperRewardPlayAgainCallback;
    public GMNativeAdListener mTTNativeAdListener;
    public GMVideoListener mTTVideoListener;
    private String mTitle;
    private int mVideoHeight;
    private int mVideoWidth;
    private String mWinCallback;
    private int originType;
    private long packageSizeBytes;
    private Map<String, String> permissionsMap;
    private String permissionsUrl;
    private String privacyAgreement;
    private String versionName;
    private List<String> mImages = new ArrayList();
    private int mediationRitReqType = 1;
    private int mediationRitReqTypeSrc = 1;
    private int mediationRitReqTypeFromRealReq = 1;
    private int mediationRitReqTypeSrcFromRealReq = 1;
    private volatile boolean isShowRepeat = false;
    private volatile boolean isShowListenRepeat = false;
    private volatile boolean isClickListenRepeat = false;
    private volatile boolean isClickListenRepeatPlayAgain = false;
    private String mExchangeRate = "1";
    private Map<String, Object> extraMsg = new HashMap();
    private Map<String, Object> eventMap = new HashMap();

    private void removeSelfAddView(@NonNull ViewGroup viewGroup) {
        try {
            TTNativeAdView tTNativeAdView = (TTNativeAdView) viewGroup;
            if (tTNativeAdView.getChildCount() == 0) {
                return;
            }
            int i2 = 0;
            if (getAdNetworkPlatformId() != 3 && (tTNativeAdView.getChildAt(0) instanceof ViewGroup)) {
                ViewGroup viewGroup2 = (ViewGroup) tTNativeAdView.getChildAt(0);
                if ("tt_gdt_developer_view_root".equals(viewGroup2.getTag(R.id.tt_mediation_gdt_developer_view_root_tag_key))) {
                    tTNativeAdView.removeView(viewGroup2);
                    int i3 = 0;
                    while (i3 < viewGroup2.getChildCount()) {
                        View childAt = viewGroup2.getChildAt(i3);
                        if (childAt != null) {
                            Object tag = childAt.getTag(R.id.tt_mediation_gdt_developer_view_tag_key);
                            if ((tag instanceof String) && tag.equals("tt_gdt_developer_view")) {
                                viewGroup2.removeView(childAt);
                                tTNativeAdView.addView(childAt, childAt.getLayoutParams());
                            }
                        }
                        i3++;
                    }
                }
            }
            if (getAdNetworkPlatformId() == 2 || !(tTNativeAdView.getChildAt(0) instanceof ViewGroup)) {
                return;
            }
            ViewGroup viewGroup3 = (ViewGroup) tTNativeAdView.getChildAt(0);
            if ("tt_admob_native_view_root_tag".equals(viewGroup3.getTag(R.id.tt_mediation_admob_developer_view_root_tag_key))) {
                tTNativeAdView.removeView(viewGroup3);
                while (i2 < viewGroup3.getChildCount()) {
                    View childAt2 = viewGroup3.getChildAt(i2);
                    if (childAt2 != null) {
                        Object tag2 = childAt2.getTag(R.id.tt_mediation_admob_developer_view_tag_key);
                        if ((tag2 instanceof String) && tag2.equals("tt_admob_native_view_tag")) {
                            viewGroup3.removeView(childAt2);
                            tTNativeAdView.addView(childAt2, childAt2.getLayoutParams());
                        }
                    }
                    i2++;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean adnHasAdVideoCachedApi() {
        return false;
    }

    public void bidLoseNotify(Map<String, Object> map) {
    }

    public void bidWinNotify(Map<String, Object> map) {
    }

    public boolean canAdReuse() {
        int i2 = this.mAdNetworkSlotType;
        return i2 == 0 || i2 == 100;
    }

    public void cancelDownload() {
    }

    public void clearLogoView(View view) {
        if (view != null) {
            view.setVisibility(0);
            if (view instanceof ViewGroup) {
                ((ViewGroup) view).removeAllViews();
            } else if (view instanceof ImageView) {
                ((ImageView) view).setImageResource(R.color.tt_mediation_transparent);
            }
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(TTBaseAd tTBaseAd) {
        if (tTBaseAd != null && this.mLoadSort <= tTBaseAd.getLoadSort()) {
            if (this.mLoadSort < tTBaseAd.getLoadSort()) {
                return -1;
            }
            if (this.mShowSort <= tTBaseAd.getShowSort()) {
                return this.mShowSort < tTBaseAd.getShowSort() ? -1 : 0;
            }
        }
        return 1;
    }

    public void dislikeClick(String str, Map<String, Object> map) {
    }

    public String getActionText() {
        return this.mActionText;
    }

    public String getAdDescription() {
        return this.mDescription;
    }

    public String getAdExtra() {
        return this.mAdExtra;
    }

    public long getAdId() {
        return 0L;
    }

    @Deprecated
    public View getAdLogoView() {
        return null;
    }

    public String getAdNetWorkName() {
        return this.mAdNetWorkName;
    }

    public int getAdNetworkPlatformId() {
        return this.mSdkNum;
    }

    public String getAdNetworkSlotId() {
        return this.mAdNetworkSlotId;
    }

    public int getAdNetworkSlotType() {
        return this.mAdNetworkSlotType;
    }

    public String getAdTitle() {
        return this.mTitle;
    }

    public int getAdType() {
        return this.mAdType;
    }

    public View getAdView() {
        return null;
    }

    public String getAid() {
        return this.mAid;
    }

    public Map<String, Object> getAppInfoExtra() {
        return this.appInfoExtra;
    }

    public String getAppName() {
        return this.appName;
    }

    public int getAppSize() {
        return this.mAppSize;
    }

    public String getAuthorName() {
        return this.authorName;
    }

    public double getBiddingCpmWithOutExchangeRate() {
        if (isServerBiddingAd()) {
            if (getServerBiddingShowCpm() < 0.0d) {
                return 0.0d;
            }
            return getServerBiddingShowCpm();
        }
        return this.mCpm;
    }

    public double getCpm() {
        try {
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
        }
        if (isServerBiddingAd()) {
            if (getServerBiddingShowCpm() < 0.0d) {
                return 0.0d;
            }
            return getServerBiddingShowCpm();
        }
        if (isClientBiddingAd() || isMultiBiddingAd()) {
            return this.mCpm * Double.valueOf(this.mExchangeRate).doubleValue();
        }
        return this.mCpm;
    }

    public long getCreativeId() {
        return 0L;
    }

    public String getCustomAdNetWorkName() {
        return this.mCustomAdNetWorkName;
    }

    public GMAdDislike getDislikeDialog(Activity activity, Map<String, Object> map) {
        return null;
    }

    public int getDownloadStatus() {
        return -1;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public Map<String, Object> getEventMap() {
        return this.eventMap;
    }

    public String getExchangeRate() {
        return this.mExchangeRate;
    }

    public final Map<String, Object> getExtraMsg() {
        return this.extraMsg;
    }

    public String getFailCallback() {
        return this.mFailCallback;
    }

    public final long getFillTime() {
        return this.fillTime;
    }

    public GMNativeCustomVideoReporter getGMNativeCustomVideoReporter() {
        return null;
    }

    public String getIconUrl() {
        return this.mIconUrl;
    }

    public int getImageHeight() {
        return this.mImageHeight;
    }

    public int getImageMode() {
        return this.mImageMode;
    }

    public String getImageUrl() {
        return this.mImageUrl;
    }

    public int getImageWidth() {
        return this.mImageWidth;
    }

    public List<String> getImages() {
        return this.mImages;
    }

    public int getInteractionType() {
        return this.mInteractionType;
    }

    public boolean getIsAppDownload() {
        return this.mIsAppDownload;
    }

    public String getLevelTag() {
        return this.levelTag;
    }

    public int getLoadSort() {
        return this.mLoadSort;
    }

    public Map<String, Object> getMediaExtraInfo() {
        return new HashMap();
    }

    public int getMediationRitReqType(String str) {
        return TextUtils.equals(str, this.linkIdFromRealReq) ? this.mediationRitReqTypeFromRealReq : this.mediationRitReqType;
    }

    public int getMediationRitReqTypeSrc(String str) {
        return TextUtils.equals(str, this.linkIdFromRealReq) ? this.mediationRitReqTypeSrcFromRealReq : this.mediationRitReqTypeSrc;
    }

    public int[] getMinWindowSize() {
        return null;
    }

    public String getMultiCpm() {
        double cpm;
        if (!isServerBiddingAd()) {
            cpm = getCpm();
        } else if (getServerBiddingLoadCpm() < 0.0d) {
            return GMNetworkPlatformConst.AD_NETWORK_NO_PRICE;
        } else {
            cpm = getServerBiddingLoadCpm();
        }
        return String.valueOf(cpm);
    }

    public String getNetWorkPlatFormCpm() {
        double cpm;
        if (!isServerBiddingAd()) {
            cpm = getCpm();
        } else if (getServerBiddingShowCpm() < 0.0d) {
            return GMNetworkPlatformConst.AD_NETWORK_NO_PRICE;
        } else {
            cpm = getServerBiddingShowCpm();
        }
        return String.valueOf(cpm);
    }

    public int getOriginType() {
        return this.originType;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public long getPackageSizeBytes() {
        return this.packageSizeBytes;
    }

    public Map<String, String> getPermissionsMap() {
        return this.permissionsMap;
    }

    public String getPermissionsUrl() {
        return this.permissionsUrl;
    }

    public int getPricingType() {
        return this.mPricingType;
    }

    public String getPrivacyAgreement() {
        return this.privacyAgreement;
    }

    public String getReqId() {
        return null;
    }

    @Deprecated
    public int getSdkNum() {
        return this.mSdkNum;
    }

    public String getSdkVersion() {
        return this.mSdkVersion;
    }

    public double getServerBiddingLoadCpm() {
        return this.mServerBiddingLoadCpm;
    }

    public double getServerBiddingShowCpm() {
        return this.mServerBiddingShowCpm;
    }

    public int getShowSort() {
        return this.mShowSort;
    }

    public String getSource() {
        return this.mSource;
    }

    public Bitmap getSplashBitMap() {
        return null;
    }

    public double getStarRating() {
        return this.mRating;
    }

    public String getStore() {
        return this.mStore;
    }

    public int getSubAdType() {
        return this.mSubAdType;
    }

    public String getVersionName() {
        return this.versionName;
    }

    public int getVideoHeight() {
        return this.mVideoHeight;
    }

    public String getVideoUrl() {
        return null;
    }

    public int getVideoWidth() {
        return this.mVideoWidth;
    }

    public String getWinCallback() {
        return this.mWinCallback;
    }

    public boolean hasAppInfo() {
        Map<String, String> map;
        return (TextUtils.isEmpty(this.appName) && TextUtils.isEmpty(this.authorName) && this.packageSizeBytes <= 0 && TextUtils.isEmpty(this.permissionsUrl) && ((map = this.permissionsMap) == null || map.size() <= 0) && TextUtils.isEmpty(this.privacyAgreement) && TextUtils.isEmpty(this.versionName)) ? false : true;
    }

    public abstract boolean hasDestroyed();

    public boolean hasDislike() {
        return false;
    }

    public boolean isAdnPreload() {
        return false;
    }

    public boolean isCacheSuccess() {
        return this.mCacheSuccess;
    }

    public boolean isClickListenRepeatOnce() {
        if (this.isClickListenRepeat) {
            return true;
        }
        this.isClickListenRepeat = true;
        return false;
    }

    public boolean isClickListenRepeatPlayAgainOnce() {
        if (this.isClickListenRepeatPlayAgain) {
            return true;
        }
        this.isClickListenRepeatPlayAgain = true;
        return false;
    }

    public boolean isClientBiddingAd() {
        return this.mAdNetworkSlotType == 1;
    }

    public boolean isCustomAd() {
        return this instanceof GMCustomTTBaseAd;
    }

    public boolean isExpressAd() {
        return this.mIsExpressAd;
    }

    public boolean isHasShown() {
        return this.mHasShown;
    }

    public boolean isMultiBiddingAd() {
        return this.mAdNetworkSlotType == 3;
    }

    public boolean isNormalAd() {
        return this.mAdNetworkSlotType == 0;
    }

    public boolean isPAd() {
        return this.mAdNetworkSlotType == 100;
    }

    public final boolean isReady(String str) {
        GMAdConstant.AdIsReadyStatus isReadyStatus = isReadyStatus();
        return isReadyStatus == GMAdConstant.AdIsReadyStatus.ADN_NO_READY_API ? true ^ a.a().a(str, this) : isReadyStatus == GMAdConstant.AdIsReadyStatus.AD_IS_READY;
    }

    public GMAdConstant.AdIsReadyStatus isReadyStatus() {
        return GMAdConstant.AdIsReadyStatus.ADN_NO_READY_API;
    }

    public boolean isServerBiddingAd() {
        return this.mAdNetworkSlotType == 2;
    }

    public boolean isShowListenRepeatOnce() {
        if (this.isShowListenRepeat) {
            return true;
        }
        this.isShowListenRepeat = true;
        return false;
    }

    public boolean isShowRepeatOnce() {
        if (this.isShowRepeat) {
            return true;
        }
        this.isShowRepeat = true;
        return false;
    }

    public boolean isUseCustomVideo() {
        return this.isUseCustomVideo;
    }

    public void onDestroy() {
        this.mTTNativeAdListener = null;
        this.mTTVideoListener = null;
        this.mTTAdAppDownloadListener = null;
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void pauseAppDownload() {
    }

    public void putEventParam(String str, Object obj) {
        if (TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        this.eventMap.put(str, obj);
    }

    public void putEventParams(Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        this.eventMap.putAll(map);
    }

    public void putExtraMsg(String str, Object obj) {
        if (TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        this.extraMsg.put(str, obj);
    }

    public void putExtraMsg(Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        this.extraMsg.putAll(map);
    }

    public void registerViewForInteraction(@NonNull Activity activity, @NonNull ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, GMViewBinder gMViewBinder) {
        if (list3 != null) {
            if (list2 == null) {
                list2 = new ArrayList();
            }
            list2.addAll(list3);
        }
        registerViewForInteraction(viewGroup, list, list2, gMViewBinder);
    }

    public void registerViewForInteraction(@NonNull ViewGroup viewGroup, List<View> list, List<View> list2, GMViewBinder gMViewBinder) {
        if (viewGroup instanceof TTNativeAdView) {
            removeSelfAddView(viewGroup);
            View findViewById = viewGroup.findViewById(R.id.tt_mediation_mtg_ad_choice);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
            if (gMViewBinder != null) {
                clearLogoView(viewGroup.findViewById(gMViewBinder.logoLayoutId));
            }
        }
    }

    public void removeSelfFromParent(View view) {
        if (view != null) {
            try {
                ViewParent parent = view.getParent();
                if (parent == null || !(parent instanceof ViewGroup)) {
                    return;
                }
                ((ViewGroup) parent).removeView(view);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void render() {
    }

    public void resumeAppDownload() {
    }

    public void setActionText(String str) {
        this.mActionText = str;
    }

    public void setAdDescription(String str) {
        this.mDescription = str;
    }

    public void setAdExtra(String str) {
        this.mAdExtra = str;
    }

    public void setAdNetWorkName(String str) {
        this.mAdNetWorkName = str;
    }

    public void setAdNetworkSlotId(String str) {
        this.mAdNetworkSlotId = str;
    }

    public void setAdNetworkSlotType(int i2) {
        this.mAdNetworkSlotType = i2;
    }

    public void setAdType(int i2) {
        this.mAdType = i2;
    }

    public void setAid(String str) {
        this.mAid = str;
    }

    public void setAppInfoExtra(Map<String, Object> map) {
        this.appInfoExtra = map;
    }

    public void setAppName(String str) {
        this.appName = str;
    }

    public void setAppSize(int i2) {
        this.mAppSize = i2;
    }

    public void setAuthorName(String str) {
        this.authorName = str;
    }

    public void setCacheSuccess(boolean z) {
        this.mCacheSuccess = z;
    }

    public void setCpm(double d2) {
        this.mCpm = d2;
    }

    public void setCustomAdNetWorkName(String str) {
        this.mCustomAdNetWorkName = str;
    }

    public void setDislikeCallback(Activity activity, GMDislikeCallback gMDislikeCallback) {
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public void setExchangeRate(String str) {
        this.mExchangeRate = str;
    }

    public void setExpressAd(boolean z) {
        this.mIsExpressAd = z;
    }

    public void setFailCallback(String str) {
        this.mFailCallback = str;
    }

    public final void setFillTime(long j2) {
        if (this.fillTime == 0) {
            this.fillTime = j2;
        }
    }

    public void setGMDrawAdListener(GMDrawAdListener gMDrawAdListener) {
        this.mGMDrawAdListener = gMDrawAdListener;
    }

    public void setHasShown(boolean z) {
        this.mHasShown = z;
    }

    public void setIconUrl(String str) {
        this.mIconUrl = str;
    }

    public void setImageHeight(int i2) {
        this.mImageHeight = i2;
    }

    public void setImageMode(int i2) {
        this.mImageMode = i2;
    }

    public void setImageUrl(String str) {
        this.mImageUrl = str;
    }

    public void setImageWidth(int i2) {
        this.mImageWidth = i2;
    }

    public void setImages(List<String> list) {
        if (list != null) {
            this.mImages.addAll(list);
        }
    }

    public void setInteractionType(int i2) {
        this.mInteractionType = i2;
    }

    public void setIsAppDownload(boolean z) {
        this.mIsAppDownload = z;
    }

    public void setLevelTag(String str) {
        this.levelTag = str;
    }

    public void setLinkIdFromRealReq(String str) {
        this.linkIdFromRealReq = str;
    }

    public void setLoadSort(int i2) {
        this.mLoadSort = i2;
    }

    public void setMediationRitReqType(int i2) {
        this.mediationRitReqType = i2;
    }

    public void setMediationRitReqTypeFromRealReq(int i2) {
        this.mediationRitReqTypeFromRealReq = i2;
    }

    public void setMediationRitReqTypeSrc(int i2) {
        this.mediationRitReqTypeSrc = i2;
    }

    public void setMediationRitReqTypeSrcFromRealReq(int i2) {
        this.mediationRitReqTypeSrcFromRealReq = i2;
    }

    public void setOriginType(int i2) {
        this.originType = i2;
    }

    public void setPackageName(String str) {
        this.mPackageName = str;
    }

    public void setPackageSizeBytes(long j2) {
        this.packageSizeBytes = j2;
    }

    public void setPermissionsMap(Map<String, String> map) {
        this.permissionsMap = map;
    }

    public void setPermissionsUrl(String str) {
        this.permissionsUrl = str;
    }

    public void setPricingType(int i2) {
        this.mPricingType = i2;
    }

    public void setPrivacyAgreement(String str) {
        this.privacyAgreement = str;
    }

    public void setRating(double d2) {
        this.mRating = d2;
    }

    public void setRit(String str) {
        this.mRit = str;
    }

    public void setSdkNum(int i2) {
        this.mSdkNum = i2;
    }

    public void setSdkVersion(String str) {
        this.mSdkVersion = str;
    }

    public void setServerBiddingLoadCpm(double d2) {
        this.mServerBiddingLoadCpm = d2;
    }

    public void setServerBiddingShowCpm(double d2) {
        this.mServerBiddingShowCpm = d2;
    }

    public void setShowSort(int i2) {
        this.mShowSort = i2;
    }

    public void setSource(String str) {
        this.mSource = str;
    }

    public void setStore(String str) {
        this.mStore = str;
    }

    public void setSubAdType(int i2) {
        this.mSubAdType = i2;
    }

    public void setTTAdAppDownloadListener(GMAdAppDownloadListener gMAdAppDownloadListener) {
        this.mTTAdAppDownloadListener = gMAdAppDownloadListener;
    }

    public void setTTAdatperCallback(ITTAdatperCallback iTTAdatperCallback) {
        this.mTTAdatperCallback = iTTAdatperCallback;
    }

    public void setTTAdatperRewardPlayAgainCallback(ITTAdatperCallback iTTAdatperCallback) {
        this.mTTAdatperRewardPlayAgainCallback = iTTAdatperCallback;
    }

    public void setTTNativeAdListener(GMNativeAdListener gMNativeAdListener) {
        this.mTTNativeAdListener = gMNativeAdListener;
    }

    public void setTTVideoListener(GMVideoListener gMVideoListener) {
        this.mTTVideoListener = gMVideoListener;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public void setUseCustomVideo(boolean z) {
        this.isUseCustomVideo = z;
    }

    public void setVersionName(String str) {
        this.versionName = str;
    }

    public void setVideoHeight(int i2) {
        this.mVideoHeight = i2;
    }

    public void setVideoWidth(int i2) {
        this.mVideoWidth = i2;
    }

    public void setWinCallback(String str) {
        this.mWinCallback = str;
    }

    public void showAd(Activity activity, Map<TTAdConstant.GroMoreExtraKey, Object> map) {
    }

    public void showMinWindow(Rect rect, ITTAdatperCallback iTTAdatperCallback) {
    }

    public void showSplashAd(ViewGroup viewGroup) {
    }

    public void showSplashCardView(ViewGroup viewGroup, Activity activity) {
    }

    public void showSplashClickEyeView(ViewGroup viewGroup) {
    }

    public void splashMinWindowAnimationFinish() {
    }

    public void unregisterView() {
    }
}
