package com.bytedance.msdk.api.v2.ad.custom.nativeAd;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.v2.GMAdConstant;
import com.bytedance.msdk.api.v2.ad.custom.GMCustomAdError;
import com.bytedance.msdk.api.v2.ad.custom.GMCustomTTBaseAd;
import com.bytedance.msdk.api.v2.ad.custom.base.GMCustomBaseAdapter;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeCustomVideoReporter;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeExpressAdListener;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMViewBinder;
import java.util.List;

/* loaded from: classes.dex */
public abstract class GMCustomNativeAd extends GMCustomBaseNativeAd implements IGMCustomNativeEvent {
    private volatile boolean t = false;
    private int u = 0;
    private int v = 0;
    private boolean w = false;
    private Activity x;
    private List<View> y;

    /* JADX INFO: Access modifiers changed from: private */
    public GMAdConstant.AdIsReadyStatus a() {
        return isReadyStatus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, GMViewBinder gMViewBinder) {
        try {
            this.x = activity;
            this.w = true;
            this.y = list3;
            registerViewForInteraction(viewGroup, list, list2, gMViewBinder);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g() {
        try {
            this.x = null;
            onDestroy();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h() {
        try {
            onPause();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j() {
        try {
            onResume();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.nativeAd.IGMCustomNativeEvent
    public void callNativeAdClick() {
        if (this.t) {
            checkClick(new GMCustomBaseAdapter.CheckCallback() { // from class: com.bytedance.msdk.api.v2.ad.custom.nativeAd.GMCustomNativeAd.8
                @Override // com.bytedance.msdk.api.v2.ad.custom.base.GMCustomBaseAdapter.CheckCallback
                public void callback() {
                    if (GMCustomNativeAd.this.a == null || GMCustomNativeAd.this.a.getGMNativeAdListener() == null) {
                        return;
                    }
                    GMCustomNativeAd.this.a.getGMNativeAdListener().onAdClick();
                }
            });
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.nativeAd.IGMCustomNativeEvent
    public void callNativeAdShow() {
        checkShow(new GMCustomBaseAdapter.CheckCallback() { // from class: com.bytedance.msdk.api.v2.ad.custom.nativeAd.GMCustomNativeAd.9
            @Override // com.bytedance.msdk.api.v2.ad.custom.base.GMCustomBaseAdapter.CheckCallback
            public void callback() {
                if (GMCustomNativeAd.this.a == null || GMCustomNativeAd.this.a.getGMNativeAdListener() == null) {
                    return;
                }
                GMCustomNativeAd.this.t = true;
                GMCustomNativeAd.this.a.getGMNativeAdListener().onAdShow();
            }
        });
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.nativeAd.IGMCustomNativeEvent
    public void callNativeDislikeCancel() {
        GMCustomTTBaseAd gMCustomTTBaseAd = this.a;
        if (gMCustomTTBaseAd == null || gMCustomTTBaseAd.getDislikeCallback() == null) {
            return;
        }
        this.a.getDislikeCallback().onCancel();
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.nativeAd.IGMCustomNativeEvent
    public void callNativeDislikeRefuse() {
        GMCustomTTBaseAd gMCustomTTBaseAd = this.a;
        if (gMCustomTTBaseAd == null || gMCustomTTBaseAd.getDislikeCallback() == null) {
            return;
        }
        this.a.getDislikeCallback().onRefuse();
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.nativeAd.IGMCustomNativeEvent
    public void callNativeDislikeSelected(int i2, String str) {
        GMCustomTTBaseAd gMCustomTTBaseAd = this.a;
        if (gMCustomTTBaseAd == null || gMCustomTTBaseAd.getDislikeCallback() == null) {
            return;
        }
        this.a.nativeDislikeClick(str);
        this.a.getDislikeCallback().onSelected(i2, str);
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.nativeAd.IGMCustomNativeEvent
    public void callNativeDislikeShow() {
        GMCustomTTBaseAd gMCustomTTBaseAd = this.a;
        if (gMCustomTTBaseAd == null || gMCustomTTBaseAd.getDislikeCallback() == null) {
            return;
        }
        this.a.getDislikeCallback().onShow();
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.nativeAd.IGMCustomNativeEvent
    public void callNativeOnDownloadActive(long j2, long j3, String str, String str2) {
        GMCustomTTBaseAd gMCustomTTBaseAd = this.a;
        if (gMCustomTTBaseAd == null || gMCustomTTBaseAd.getGMAdAppDownloadListener() == null) {
            return;
        }
        this.a.getGMAdAppDownloadListener().onDownloadProgress(j2, j3, -1, 1);
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.nativeAd.IGMCustomNativeEvent
    public void callNativeOnDownloadFailed(long j2, long j3, String str, String str2) {
        GMCustomTTBaseAd gMCustomTTBaseAd = this.a;
        if (gMCustomTTBaseAd == null || gMCustomTTBaseAd.getGMAdAppDownloadListener() == null) {
            return;
        }
        this.a.getGMAdAppDownloadListener().onDownloadFailed(j2, j3, str, str2);
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.nativeAd.IGMCustomNativeEvent
    public void callNativeOnDownloadFinished(long j2, String str, String str2) {
        GMCustomTTBaseAd gMCustomTTBaseAd = this.a;
        if (gMCustomTTBaseAd == null || gMCustomTTBaseAd.getGMAdAppDownloadListener() == null) {
            return;
        }
        this.a.getGMAdAppDownloadListener().onDownloadFinished(j2, str, str2);
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.nativeAd.IGMCustomNativeEvent
    public void callNativeOnDownloadPaused(long j2, long j3, String str, String str2) {
        GMCustomTTBaseAd gMCustomTTBaseAd = this.a;
        if (gMCustomTTBaseAd == null || gMCustomTTBaseAd.getGMAdAppDownloadListener() == null) {
            return;
        }
        this.a.getGMAdAppDownloadListener().onDownloadPaused(j2, j3, str, str2);
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.nativeAd.IGMCustomNativeEvent
    public void callNativeOnIdle() {
        GMCustomTTBaseAd gMCustomTTBaseAd = this.a;
        if (gMCustomTTBaseAd == null || gMCustomTTBaseAd.getGMAdAppDownloadListener() == null) {
            return;
        }
        this.a.getGMAdAppDownloadListener().onIdle();
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.nativeAd.IGMCustomNativeEvent
    public void callNativeOnInstalled(String str, String str2) {
        GMCustomTTBaseAd gMCustomTTBaseAd = this.a;
        if (gMCustomTTBaseAd == null || gMCustomTTBaseAd.getGMAdAppDownloadListener() == null) {
            return;
        }
        this.a.getGMAdAppDownloadListener().onInstalled(str, str2);
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.nativeAd.IGMCustomNativeEvent
    public void callNativeRenderFail(View view, String str, int i2) {
        GMCustomTTBaseAd gMCustomTTBaseAd = this.a;
        if (gMCustomTTBaseAd == null || gMCustomTTBaseAd.getGMNativeAdListener() == null) {
            return;
        }
        try {
            ((GMNativeExpressAdListener) this.a.getGMNativeAdListener()).onRenderFail(view, str, i2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.nativeAd.IGMCustomNativeEvent
    public void callNativeRenderSuccess(float f2, float f3) {
        GMCustomTTBaseAd gMCustomTTBaseAd = this.a;
        if (gMCustomTTBaseAd == null || gMCustomTTBaseAd.getGMNativeAdListener() == null) {
            return;
        }
        try {
            ((GMNativeExpressAdListener) this.a.getGMNativeAdListener()).onRenderSuccess(f2, f3);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.nativeAd.IGMCustomNativeEvent
    public void callNativeVideoCompleted() {
        GMCustomTTBaseAd gMCustomTTBaseAd = this.a;
        if (gMCustomTTBaseAd == null || gMCustomTTBaseAd.getGMVideoListener() == null) {
            return;
        }
        this.a.getGMVideoListener().onVideoCompleted();
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.nativeAd.IGMCustomNativeEvent
    public void callNativeVideoError(GMCustomAdError gMCustomAdError) {
        GMCustomTTBaseAd gMCustomTTBaseAd = this.a;
        if (gMCustomTTBaseAd == null || gMCustomTTBaseAd.getGMVideoListener() == null) {
            return;
        }
        this.a.getGMVideoListener().onVideoError(new AdError(AdError.ERROR_CODE_CUSTOM_NATIVE_VIDEO_SHOW_ERROR, AdError.getMessage(AdError.ERROR_CODE_CUSTOM_NATIVE_VIDEO_SHOW_ERROR), gMCustomAdError == null ? -1 : gMCustomAdError.getCode(), gMCustomAdError == null ? "" : gMCustomAdError.getMessage()));
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.nativeAd.IGMCustomNativeEvent
    public void callNativeVideoPause() {
        GMCustomTTBaseAd gMCustomTTBaseAd = this.a;
        if (gMCustomTTBaseAd == null || gMCustomTTBaseAd.getGMVideoListener() == null) {
            return;
        }
        this.a.getGMVideoListener().onVideoPause();
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.nativeAd.IGMCustomNativeEvent
    public void callNativeVideoProgressUpdate(long j2, long j3) {
        GMCustomTTBaseAd gMCustomTTBaseAd = this.a;
        if (gMCustomTTBaseAd == null || gMCustomTTBaseAd.getGMVideoListener() == null) {
            return;
        }
        this.a.getGMVideoListener().onProgressUpdate(j2, j3);
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.nativeAd.IGMCustomNativeEvent
    public void callNativeVideoResume() {
        GMCustomTTBaseAd gMCustomTTBaseAd = this.a;
        if (gMCustomTTBaseAd == null || gMCustomTTBaseAd.getGMVideoListener() == null) {
            return;
        }
        this.a.getGMVideoListener().onVideoResume();
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.nativeAd.IGMCustomNativeEvent
    public void callNativeVideoStart() {
        GMCustomTTBaseAd gMCustomTTBaseAd = this.a;
        if (gMCustomTTBaseAd == null || gMCustomTTBaseAd.getGMVideoListener() == null) {
            return;
        }
        this.a.getGMVideoListener().onVideoStart();
    }

    public void cancelDownload() {
    }

    public final void checkClick(GMCustomBaseAdapter.CheckCallback checkCallback) {
        int i2 = this.v;
        if (i2 >= 60) {
            Logger.e("TTMediationSDK", "自定义Adapter click方法回调次数需要小于60次");
            return;
        }
        this.v = i2 + 1;
        if (checkCallback != null) {
            checkCallback.callback();
        }
    }

    public final void checkShow(GMCustomBaseAdapter.CheckCallback checkCallback) {
        String str;
        if (this.w) {
            int i2 = this.u;
            if (i2 < 2) {
                this.u = i2 + 1;
                if (checkCallback != null) {
                    checkCallback.callback();
                    return;
                }
                return;
            }
            str = "自定义Adapter show方法回调次数需要小于2次";
        } else {
            str = "自定义Adapter show方法回调必须由GroMore触发show时才会生效";
        }
        Logger.e("TTMediationSDK", str);
    }

    @Nullable
    public Activity getActivity() {
        return this.x;
    }

    public List<View> getDirectDownloadViews() {
        return this.y;
    }

    public int getDownloadStatus() {
        return -1;
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.nativeAd.GMCustomBaseNativeAd
    public View getExpressView() {
        return null;
    }

    public final View getExpressViewInner() {
        try {
            return getExpressView();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public GMNativeCustomVideoReporter getGMNativeCustomVideoReporter() {
        return null;
    }

    public final GMNativeCustomVideoReporter getGMNativeCustomVideoReporterInner() {
        try {
            return getGMNativeCustomVideoReporter();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.base.GMCustomAd
    public GMCustomTTBaseAd getTTBaseAd() {
        this.a.setTitle(getTitle());
        this.a.setAdDescription(getDescription());
        this.a.setIconUrl(getIconUrl());
        this.a.setImageUrl(getImageUrl());
        this.a.setImageWidth(getImageWidth());
        this.a.setImageHeight(getImageHeight());
        this.a.setVideoWidth(getVideoWidth());
        this.a.setVideoHeight(getVideoHeight());
        this.a.setActionText(getActionText());
        this.a.setPackageName(getPackageName());
        this.a.setRating(getStarRating());
        this.a.setImages(getImageList());
        this.a.setSource(getSource());
        this.a.setImageMode(getAdImageMode());
        this.a.setInteractionType(getInteractionType());
        if (getNativeAdAppInfo() != null) {
            this.a.setAppName(getNativeAdAppInfo().getAppName());
            this.a.setAuthorName(getNativeAdAppInfo().getAuthorName());
            this.a.setPackageSizeBytes(getNativeAdAppInfo().getPackageSizeBytes());
            this.a.setPermissionsUrl(getNativeAdAppInfo().getPermissionsUrl());
            this.a.setPrivacyAgreement(getNativeAdAppInfo().getPrivacyAgreement());
            this.a.setVersionName(getNativeAdAppInfo().getVersionName());
        }
        this.a.setCustomNativeConvert(new IGMCustomNativeConvert() { // from class: com.bytedance.msdk.api.v2.ad.custom.nativeAd.GMCustomNativeAd.1
            @Override // com.bytedance.msdk.api.v2.ad.custom.nativeAd.IGMCustomNativeConvert
            public void registerViewForInteractionInner(@Nullable Activity activity, @NonNull ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, GMViewBinder gMViewBinder) {
                GMCustomNativeAd.this.b(activity, viewGroup, list, list2, list3, gMViewBinder);
            }

            @Override // com.bytedance.msdk.api.v2.ad.custom.nativeAd.IGMCustomNativeConvert
            public void unregisterViewInner() {
                GMCustomNativeAd.this.unregisterViewInner();
            }
        });
        this.a.setCustomNativeExpressConvert(new IGMCustomNativeExpressConvert() { // from class: com.bytedance.msdk.api.v2.ad.custom.nativeAd.GMCustomNativeAd.2
            @Override // com.bytedance.msdk.api.v2.ad.custom.nativeAd.IGMCustomNativeExpressConvert
            public View getExpressViewInner() {
                return GMCustomNativeAd.this.getExpressViewInner();
            }

            @Override // com.bytedance.msdk.api.v2.ad.custom.nativeAd.IGMCustomNativeExpressConvert
            public void renderInner() {
                GMCustomNativeAd.this.renderInner();
            }
        });
        this.a.setCustomNativeLifecycleConvert(new IGMCustomNativeLifecycleConvert() { // from class: com.bytedance.msdk.api.v2.ad.custom.nativeAd.GMCustomNativeAd.3
            @Override // com.bytedance.msdk.api.v2.ad.custom.nativeAd.IGMCustomNativeLifecycleConvert
            public void onDestroyInner() {
                GMCustomNativeAd.this.g();
            }

            @Override // com.bytedance.msdk.api.v2.ad.custom.nativeAd.IGMCustomNativeLifecycleConvert
            public void onPauseInner() {
                GMCustomNativeAd.this.h();
            }

            @Override // com.bytedance.msdk.api.v2.ad.custom.nativeAd.IGMCustomNativeLifecycleConvert
            public void onResumeInner() {
                GMCustomNativeAd.this.j();
            }
        });
        this.a.setIGMCustomNativeDislikeConvert(new IGMCustomNativeDislikeConvert() { // from class: com.bytedance.msdk.api.v2.ad.custom.nativeAd.GMCustomNativeAd.4
            @Override // com.bytedance.msdk.api.v2.ad.custom.nativeAd.IGMCustomNativeDislikeConvert
            public boolean hasDislike() {
                return GMCustomNativeAd.this.hasDislike();
            }
        });
        if (getBiddingPrice() > 0.0d) {
            this.a.setCpm(getBiddingPrice());
        }
        this.a.setIGMCustomNativeIsReadyStatusConvert(new IGMCustomNativeIsReadyStatusConvert() { // from class: com.bytedance.msdk.api.v2.ad.custom.nativeAd.GMCustomNativeAd.5
            @Override // com.bytedance.msdk.api.v2.ad.custom.nativeAd.IGMCustomNativeIsReadyStatusConvert
            public GMAdConstant.AdIsReadyStatus isReadyStatus() {
                return GMCustomNativeAd.this.a();
            }
        });
        this.a.setCustomNativeCustomizeVideoConvert(new IGMCustomNativeCustomizeVideoConvert() { // from class: com.bytedance.msdk.api.v2.ad.custom.nativeAd.GMCustomNativeAd.6
            @Override // com.bytedance.msdk.api.v2.ad.custom.nativeAd.IGMCustomNativeCustomizeVideoConvert
            public GMNativeCustomVideoReporter getGMNativeCustomVideoReporter() {
                return GMCustomNativeAd.this.getGMNativeCustomVideoReporterInner();
            }

            @Override // com.bytedance.msdk.api.v2.ad.custom.nativeAd.IGMCustomNativeCustomizeVideoConvert
            public String getVideoUrl() {
                return GMCustomNativeAd.this.getVideoUrlInner();
            }
        });
        this.a.setCustomNativeDownloadStatusControllerConvert(new IGMCustomNativeDownloadStatusControllerConvert() { // from class: com.bytedance.msdk.api.v2.ad.custom.nativeAd.GMCustomNativeAd.7
            @Override // com.bytedance.msdk.api.v2.ad.custom.nativeAd.IGMCustomNativeDownloadStatusControllerConvert
            public void cancelDownload() {
                GMCustomNativeAd.this.cancelDownload();
            }

            @Override // com.bytedance.msdk.api.v2.ad.custom.nativeAd.IGMCustomNativeDownloadStatusControllerConvert
            public int getDownloadStatus() {
                return GMCustomNativeAd.this.getDownloadStatus();
            }

            @Override // com.bytedance.msdk.api.v2.ad.custom.nativeAd.IGMCustomNativeDownloadStatusControllerConvert
            public void pauseAppDownload() {
                GMCustomNativeAd.this.pauseAppDownload();
            }

            @Override // com.bytedance.msdk.api.v2.ad.custom.nativeAd.IGMCustomNativeDownloadStatusControllerConvert
            public void resumeAppDownload() {
                GMCustomNativeAd.this.resumeAppDownload();
            }
        });
        return this.a;
    }

    public boolean hasDislike() {
        return false;
    }

    public GMAdConstant.AdIsReadyStatus isReadyStatus() {
        return GMAdConstant.AdIsReadyStatus.ADN_NO_READY_API;
    }

    public final void nativeDislikeClick(String str) {
        GMCustomTTBaseAd gMCustomTTBaseAd = this.a;
        if (gMCustomTTBaseAd != null) {
            gMCustomTTBaseAd.nativeDislikeClick(str);
        }
    }

    public void onDestroy() {
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void pauseAppDownload() {
    }

    public void registerViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, GMViewBinder gMViewBinder) {
    }

    public void render() {
    }

    public final void renderInner() {
        try {
            this.w = true;
            render();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void resumeAppDownload() {
    }

    public void unregisterView() {
    }

    public final void unregisterViewInner() {
        try {
            unregisterView();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
