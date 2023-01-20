package com.bytedance.msdk.api.v2.ad.custom.draw;

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
import com.bytedance.msdk.api.v2.ad.custom.nativeAd.GMCustomBaseNativeAd;
import com.bytedance.msdk.api.v2.ad.custom.nativeAd.IGMCustomNativeConvert;
import com.bytedance.msdk.api.v2.ad.custom.nativeAd.IGMCustomNativeCustomizeVideoConvert;
import com.bytedance.msdk.api.v2.ad.custom.nativeAd.IGMCustomNativeDislikeConvert;
import com.bytedance.msdk.api.v2.ad.custom.nativeAd.IGMCustomNativeExpressConvert;
import com.bytedance.msdk.api.v2.ad.custom.nativeAd.IGMCustomNativeIsReadyStatusConvert;
import com.bytedance.msdk.api.v2.ad.custom.nativeAd.IGMCustomNativeLifecycleConvert;
import com.bytedance.msdk.api.v2.ad.draw.GMDrawCustomVideoReporter;
import com.bytedance.msdk.api.v2.ad.draw.GMDrawExpressAdListener;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeCustomVideoReporter;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMViewBinder;
import java.util.List;

/* loaded from: classes.dex */
public abstract class GMCustomDrawAd extends GMCustomBaseNativeAd implements IGMCustomDrawEvent {
    private volatile boolean t = false;
    private int u = 0;
    private int v = 0;
    private boolean w = false;
    private List<View> x;

    /* JADX INFO: Access modifiers changed from: private */
    public final void a() {
        try {
            onDestroy();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, GMViewBinder gMViewBinder) {
        try {
            this.w = true;
            this.x = list3;
            registerViewForInteraction(activity, viewGroup, list, list2, gMViewBinder);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g() {
        try {
            onPause();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h() {
        try {
            onResume();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.draw.IGMCustomDrawEvent
    public void callDrawAdClick() {
        if (this.t) {
            checkClick(new GMCustomBaseAdapter.CheckCallback() { // from class: com.bytedance.msdk.api.v2.ad.custom.draw.GMCustomDrawAd.7
                @Override // com.bytedance.msdk.api.v2.ad.custom.base.GMCustomBaseAdapter.CheckCallback
                public void callback() {
                    if (GMCustomDrawAd.this.a == null || GMCustomDrawAd.this.a.getGMDrawAdListener() == null) {
                        return;
                    }
                    GMCustomDrawAd.this.a.getGMDrawAdListener().onAdClick();
                }
            });
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.draw.IGMCustomDrawEvent
    public void callDrawAdShow() {
        checkShow(new GMCustomBaseAdapter.CheckCallback() { // from class: com.bytedance.msdk.api.v2.ad.custom.draw.GMCustomDrawAd.8
            @Override // com.bytedance.msdk.api.v2.ad.custom.base.GMCustomBaseAdapter.CheckCallback
            public void callback() {
                if (GMCustomDrawAd.this.a == null || GMCustomDrawAd.this.a.getGMDrawAdListener() == null) {
                    return;
                }
                GMCustomDrawAd.this.t = true;
                GMCustomDrawAd.this.a.getGMDrawAdListener().onAdShow();
            }
        });
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.draw.IGMCustomDrawEvent
    public void callDrawDislikeCancel() {
        GMCustomTTBaseAd gMCustomTTBaseAd = this.a;
        if (gMCustomTTBaseAd == null || gMCustomTTBaseAd.getDislikeCallback() == null) {
            return;
        }
        this.a.getDislikeCallback().onCancel();
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.draw.IGMCustomDrawEvent
    public void callDrawDislikeRefuse() {
        GMCustomTTBaseAd gMCustomTTBaseAd = this.a;
        if (gMCustomTTBaseAd == null || gMCustomTTBaseAd.getDislikeCallback() == null) {
            return;
        }
        this.a.getDislikeCallback().onRefuse();
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.draw.IGMCustomDrawEvent
    public void callDrawDislikeSelected(int i2, String str) {
        GMCustomTTBaseAd gMCustomTTBaseAd = this.a;
        if (gMCustomTTBaseAd == null || gMCustomTTBaseAd.getDislikeCallback() == null) {
            return;
        }
        this.a.getDislikeCallback().onSelected(i2, str);
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.draw.IGMCustomDrawEvent
    public void callDrawDislikeShow() {
        GMCustomTTBaseAd gMCustomTTBaseAd = this.a;
        if (gMCustomTTBaseAd == null || gMCustomTTBaseAd.getDislikeCallback() == null) {
            return;
        }
        this.a.getDislikeCallback().onShow();
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.draw.IGMCustomDrawEvent
    public void callDrawRenderFail(View view, String str, int i2) {
        GMCustomTTBaseAd gMCustomTTBaseAd = this.a;
        if (gMCustomTTBaseAd == null || gMCustomTTBaseAd.getGMDrawAdListener() == null) {
            return;
        }
        try {
            ((GMDrawExpressAdListener) this.a.getGMDrawAdListener()).onRenderFail(view, str, i2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.draw.IGMCustomDrawEvent
    public void callDrawRenderSuccess(float f2, float f3) {
        GMCustomTTBaseAd gMCustomTTBaseAd = this.a;
        if (gMCustomTTBaseAd == null || gMCustomTTBaseAd.getGMDrawAdListener() == null) {
            return;
        }
        try {
            ((GMDrawExpressAdListener) this.a.getGMDrawAdListener()).onRenderSuccess(f2, f3);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.draw.IGMCustomDrawEvent
    public void callDrawVideoCompleted() {
        GMCustomTTBaseAd gMCustomTTBaseAd = this.a;
        if (gMCustomTTBaseAd == null || gMCustomTTBaseAd.getGMVideoListener() == null) {
            return;
        }
        this.a.getGMVideoListener().onVideoCompleted();
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.draw.IGMCustomDrawEvent
    public void callDrawVideoError(GMCustomAdError gMCustomAdError) {
        GMCustomTTBaseAd gMCustomTTBaseAd = this.a;
        if (gMCustomTTBaseAd == null || gMCustomTTBaseAd.getGMVideoListener() == null) {
            return;
        }
        this.a.getGMVideoListener().onVideoError(new AdError(AdError.ERROR_CODE_CUSTOM_NATIVE_VIDEO_SHOW_ERROR, AdError.getMessage(AdError.ERROR_CODE_CUSTOM_NATIVE_VIDEO_SHOW_ERROR), gMCustomAdError == null ? -1 : gMCustomAdError.getCode(), gMCustomAdError == null ? "" : gMCustomAdError.getMessage()));
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.draw.IGMCustomDrawEvent
    public void callDrawVideoPause() {
        GMCustomTTBaseAd gMCustomTTBaseAd = this.a;
        if (gMCustomTTBaseAd == null || gMCustomTTBaseAd.getGMVideoListener() == null) {
            return;
        }
        this.a.getGMVideoListener().onVideoPause();
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.draw.IGMCustomDrawEvent
    public void callDrawVideoProgressUpdate(long j2, long j3) {
        GMCustomTTBaseAd gMCustomTTBaseAd = this.a;
        if (gMCustomTTBaseAd == null || gMCustomTTBaseAd.getGMVideoListener() == null) {
            return;
        }
        this.a.getGMVideoListener().onProgressUpdate(j2, j3);
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.draw.IGMCustomDrawEvent
    public void callDrawVideoResume() {
        GMCustomTTBaseAd gMCustomTTBaseAd = this.a;
        if (gMCustomTTBaseAd == null || gMCustomTTBaseAd.getGMVideoListener() == null) {
            return;
        }
        this.a.getGMVideoListener().onVideoResume();
    }

    @Override // com.bytedance.msdk.api.v2.ad.custom.draw.IGMCustomDrawEvent
    public void callDrawVideoStart() {
        GMCustomTTBaseAd gMCustomTTBaseAd = this.a;
        if (gMCustomTTBaseAd == null || gMCustomTTBaseAd.getGMVideoListener() == null) {
            return;
        }
        this.a.getGMVideoListener().onVideoStart();
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

    public List<View> getDirectDownloadViews() {
        return this.x;
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

    public GMDrawCustomVideoReporter getGMDrawCustomVideoReporter() {
        return null;
    }

    public final GMDrawCustomVideoReporter getGMDrawCustomVideoReporterInner() {
        try {
            return getGMDrawCustomVideoReporter();
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
        this.a.setCustomNativeConvert(new IGMCustomNativeConvert() { // from class: com.bytedance.msdk.api.v2.ad.custom.draw.GMCustomDrawAd.1
            @Override // com.bytedance.msdk.api.v2.ad.custom.nativeAd.IGMCustomNativeConvert
            public void registerViewForInteractionInner(@Nullable Activity activity, @NonNull ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, GMViewBinder gMViewBinder) {
                GMCustomDrawAd.this.b(activity, viewGroup, list, list2, list3, gMViewBinder);
            }

            @Override // com.bytedance.msdk.api.v2.ad.custom.nativeAd.IGMCustomNativeConvert
            public void unregisterViewInner() {
                GMCustomDrawAd.this.unregisterViewInner();
            }
        });
        this.a.setCustomNativeExpressConvert(new IGMCustomNativeExpressConvert() { // from class: com.bytedance.msdk.api.v2.ad.custom.draw.GMCustomDrawAd.2
            @Override // com.bytedance.msdk.api.v2.ad.custom.nativeAd.IGMCustomNativeExpressConvert
            public View getExpressViewInner() {
                return GMCustomDrawAd.this.getExpressViewInner();
            }

            @Override // com.bytedance.msdk.api.v2.ad.custom.nativeAd.IGMCustomNativeExpressConvert
            public void renderInner() {
                GMCustomDrawAd.this.renderInner();
            }
        });
        this.a.setCustomNativeLifecycleConvert(new IGMCustomNativeLifecycleConvert() { // from class: com.bytedance.msdk.api.v2.ad.custom.draw.GMCustomDrawAd.3
            @Override // com.bytedance.msdk.api.v2.ad.custom.nativeAd.IGMCustomNativeLifecycleConvert
            public void onDestroyInner() {
                GMCustomDrawAd.this.a();
            }

            @Override // com.bytedance.msdk.api.v2.ad.custom.nativeAd.IGMCustomNativeLifecycleConvert
            public void onPauseInner() {
                GMCustomDrawAd.this.g();
            }

            @Override // com.bytedance.msdk.api.v2.ad.custom.nativeAd.IGMCustomNativeLifecycleConvert
            public void onResumeInner() {
                GMCustomDrawAd.this.h();
            }
        });
        this.a.setIGMCustomNativeDislikeConvert(new IGMCustomNativeDislikeConvert() { // from class: com.bytedance.msdk.api.v2.ad.custom.draw.GMCustomDrawAd.4
            @Override // com.bytedance.msdk.api.v2.ad.custom.nativeAd.IGMCustomNativeDislikeConvert
            public boolean hasDislike() {
                return GMCustomDrawAd.this.hasDislike();
            }
        });
        if (getBiddingPrice() > 0.0d) {
            this.a.setCpm(getBiddingPrice());
        }
        this.a.setCustomNativeCustomizeVideoConvert(new IGMCustomNativeCustomizeVideoConvert() { // from class: com.bytedance.msdk.api.v2.ad.custom.draw.GMCustomDrawAd.5
            @Override // com.bytedance.msdk.api.v2.ad.custom.nativeAd.IGMCustomNativeCustomizeVideoConvert
            public GMNativeCustomVideoReporter getGMNativeCustomVideoReporter() {
                return GMCustomDrawAd.this.getGMDrawCustomVideoReporterInner();
            }

            @Override // com.bytedance.msdk.api.v2.ad.custom.nativeAd.IGMCustomNativeCustomizeVideoConvert
            public String getVideoUrl() {
                return GMCustomDrawAd.this.getVideoUrlInner();
            }
        });
        this.a.setIGMCustomNativeIsReadyStatusConvert(new IGMCustomNativeIsReadyStatusConvert() { // from class: com.bytedance.msdk.api.v2.ad.custom.draw.GMCustomDrawAd.6
            @Override // com.bytedance.msdk.api.v2.ad.custom.nativeAd.IGMCustomNativeIsReadyStatusConvert
            public GMAdConstant.AdIsReadyStatus isReadyStatus() {
                return GMCustomDrawAd.this.isReadyStatus();
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

    public void onDestroy() {
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void registerViewForInteraction(@Nullable Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, GMViewBinder gMViewBinder) {
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
