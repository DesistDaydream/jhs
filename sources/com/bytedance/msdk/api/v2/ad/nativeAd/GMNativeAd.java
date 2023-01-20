package com.bytedance.msdk.api.v2.ad.nativeAd;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.msdk.api.GMAdEcpmInfo;
import com.bytedance.msdk.api.v2.GMAdDislike;
import com.bytedance.msdk.api.v2.GMDislikeCallback;
import com.bytedance.msdk.api.v2.ad.GMAdAppDownloadListener;
import com.bytedance.msdk.base.TTBaseAd;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public interface GMNativeAd {
    @Deprecated
    boolean canAdReuse();

    void cancelDownload();

    void destroy();

    void dislikeClick(String str, Map<String, Object> map);

    @Nullable
    String getActionText();

    int getAdImageMode();

    @Nullable
    @Deprecated
    View getAdLogoView();

    @Deprecated
    int getAdNetworkPlatformId();

    String getAdNetworkPlatformName();

    @Nullable
    @Deprecated
    String getAdNetworkRitId();

    @Nullable
    GMAdEcpmInfo getBestEcpm();

    @Nullable
    String getDescription();

    @Nullable
    GMAdDislike getDislikeDialog(Activity activity);

    GMAdDislike getDislikeDialog(Activity activity, Map<String, Object> map);

    int getDownloadStatus();

    @Nullable
    View getExpressView();

    Map<String, Object> getExtraMsg();

    @Nullable
    GMNativeCustomVideoReporter getGMNativeCustomVideoReporter();

    @Nullable
    String getIconUrl();

    int getImageHeight();

    @Nullable
    List<String> getImageList();

    @Nullable
    String getImageUrl();

    int getImageWidth();

    int getInteractionType();

    Map<String, Object> getMediaExtraInfo();

    GMNativeAdAppInfo getNativeAdAppInfo();

    @Nullable
    String getPackageName();

    @Nullable
    @Deprecated
    String getPreEcpm();

    @Deprecated
    int getSdkNumType();

    @Nullable
    GMAdEcpmInfo getShowEcpm();

    @Nullable
    String getSource();

    double getStarRating();

    @Deprecated
    TTBaseAd getTTBaseAd();

    @Nullable
    String getTitle();

    int getVideoHeight();

    String getVideoUrl();

    int getVideoWidth();

    boolean hasDislike();

    boolean isExpressAd();

    boolean isHasShown();

    boolean isReady();

    boolean isServerBidding();

    void onPause();

    void pauseAppDownload();

    void registerView(@NonNull Activity activity, @NonNull ViewGroup viewGroup, @NonNull List<View> list, @Nullable List<View> list2, GMViewBinder gMViewBinder);

    void registerView(@NonNull Activity activity, @NonNull ViewGroup viewGroup, @NonNull List<View> list, @Nullable List<View> list2, @Nullable List<View> list3, GMViewBinder gMViewBinder);

    @Deprecated
    void registerView(@NonNull ViewGroup viewGroup, @NonNull List<View> list, @Nullable List<View> list2, GMViewBinder gMViewBinder);

    void render();

    void resume();

    void resumeAppDownload();

    void setAppDownloadListener(GMAdAppDownloadListener gMAdAppDownloadListener);

    void setDislikeCallback(Activity activity, GMDislikeCallback gMDislikeCallback);

    void setNativeAdListener(GMNativeAdListener gMNativeAdListener);

    void setUseCustomVideo(boolean z);

    void setVideoListener(GMVideoListener gMVideoListener);

    void unregisterView();
}
