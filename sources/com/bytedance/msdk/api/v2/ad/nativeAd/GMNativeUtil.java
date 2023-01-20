package com.bytedance.msdk.api.v2.ad.nativeAd;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.msdk.adapter.listener.ITTAdatperCallback;
import com.bytedance.msdk.api.GMAdEcpmInfo;
import com.bytedance.msdk.api.nativeAd.TTNativeAd;
import com.bytedance.msdk.api.v2.GMAdDislike;
import com.bytedance.msdk.api.v2.GMDislikeCallback;
import com.bytedance.msdk.api.v2.ad.GMAdAppDownloadListener;
import com.bytedance.msdk.base.TTBaseAd;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class GMNativeUtil {
    public static List<TTNativeAd> GMsToTTs(List<GMNativeAd> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() != 0) {
            for (GMNativeAd gMNativeAd : list) {
                TTNativeAd a = a(gMNativeAd);
                if (a != null) {
                    arrayList.add(a);
                }
            }
        }
        return arrayList;
    }

    private static TTNativeAd a(final GMNativeAd gMNativeAd) {
        if (gMNativeAd == null) {
            return null;
        }
        return new TTNativeAd() { // from class: com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeUtil.1
            @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
            public boolean canAdReuse() {
                GMNativeAd gMNativeAd2 = GMNativeAd.this;
                if (gMNativeAd2 != null) {
                    return gMNativeAd2.canAdReuse();
                }
                return false;
            }

            @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
            public void cancelDownload() {
                GMNativeAd gMNativeAd2 = GMNativeAd.this;
                if (gMNativeAd2 != null) {
                    gMNativeAd2.cancelDownload();
                }
            }

            @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
            public void destroy() {
                GMNativeAd gMNativeAd2 = GMNativeAd.this;
                if (gMNativeAd2 != null) {
                    gMNativeAd2.destroy();
                }
            }

            @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
            public void dislikeClick(String str, Map<String, Object> map) {
                GMNativeAd gMNativeAd2 = GMNativeAd.this;
                if (gMNativeAd2 != null) {
                    gMNativeAd2.dislikeClick(str, map);
                }
            }

            @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
            @Nullable
            public String getActionText() {
                GMNativeAd gMNativeAd2 = GMNativeAd.this;
                if (gMNativeAd2 != null) {
                    return gMNativeAd2.getActionText();
                }
                return null;
            }

            @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
            public int getAdImageMode() {
                GMNativeAd gMNativeAd2 = GMNativeAd.this;
                if (gMNativeAd2 != null) {
                    return gMNativeAd2.getAdImageMode();
                }
                return 0;
            }

            @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
            @Nullable
            public View getAdLogoView() {
                GMNativeAd gMNativeAd2 = GMNativeAd.this;
                if (gMNativeAd2 != null) {
                    return gMNativeAd2.getAdLogoView();
                }
                return null;
            }

            @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
            public int getAdNetworkPlatformId() {
                GMNativeAd gMNativeAd2 = GMNativeAd.this;
                if (gMNativeAd2 != null) {
                    return gMNativeAd2.getAdNetworkPlatformId();
                }
                return 0;
            }

            @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
            public String getAdNetworkPlatformName() {
                GMNativeAd gMNativeAd2 = GMNativeAd.this;
                if (gMNativeAd2 != null) {
                    return gMNativeAd2.getAdNetworkPlatformName();
                }
                return null;
            }

            @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
            @NonNull
            public String getAdNetworkRitId() {
                GMNativeAd gMNativeAd2 = GMNativeAd.this;
                if (gMNativeAd2 != null) {
                    return gMNativeAd2.getAdNetworkRitId();
                }
                return null;
            }

            @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
            @Nullable
            public GMAdEcpmInfo getBestEcpm() {
                GMNativeAd gMNativeAd2 = GMNativeAd.this;
                if (gMNativeAd2 != null) {
                    return gMNativeAd2.getBestEcpm();
                }
                return null;
            }

            @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
            @Nullable
            public String getDescription() {
                GMNativeAd gMNativeAd2 = GMNativeAd.this;
                if (gMNativeAd2 != null) {
                    return gMNativeAd2.getDescription();
                }
                return null;
            }

            @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
            @Nullable
            public GMAdDislike getDislikeDialog(Activity activity) {
                return getDislikeDialog(activity, null);
            }

            @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
            public GMAdDislike getDislikeDialog(Activity activity, Map<String, Object> map) {
                GMNativeAd gMNativeAd2 = GMNativeAd.this;
                if (gMNativeAd2 != null) {
                    return gMNativeAd2.getDislikeDialog(activity, map);
                }
                return null;
            }

            @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
            public int getDownloadStatus() {
                GMNativeAd gMNativeAd2 = GMNativeAd.this;
                if (gMNativeAd2 != null) {
                    return gMNativeAd2.getDownloadStatus();
                }
                return -1;
            }

            @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
            @Nullable
            public View getExpressView() {
                GMNativeAd gMNativeAd2 = GMNativeAd.this;
                if (gMNativeAd2 != null) {
                    return gMNativeAd2.getExpressView();
                }
                return null;
            }

            @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
            public Map<String, Object> getExtraMsg() {
                GMNativeAd gMNativeAd2 = GMNativeAd.this;
                if (gMNativeAd2 != null) {
                    return gMNativeAd2.getExtraMsg();
                }
                return null;
            }

            @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
            @Nullable
            public GMNativeCustomVideoReporter getGMNativeCustomVideoReporter() {
                GMNativeAd gMNativeAd2 = GMNativeAd.this;
                if (gMNativeAd2 != null) {
                    return gMNativeAd2.getGMNativeCustomVideoReporter();
                }
                return null;
            }

            @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
            @Nullable
            public String getIconUrl() {
                GMNativeAd gMNativeAd2 = GMNativeAd.this;
                if (gMNativeAd2 != null) {
                    return gMNativeAd2.getIconUrl();
                }
                return null;
            }

            @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
            public int getImageHeight() {
                GMNativeAd gMNativeAd2 = GMNativeAd.this;
                if (gMNativeAd2 != null) {
                    return gMNativeAd2.getImageHeight();
                }
                return 0;
            }

            @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
            @Nullable
            public List<String> getImageList() {
                GMNativeAd gMNativeAd2 = GMNativeAd.this;
                if (gMNativeAd2 != null) {
                    return gMNativeAd2.getImageList();
                }
                return null;
            }

            @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
            @Nullable
            public String getImageUrl() {
                GMNativeAd gMNativeAd2 = GMNativeAd.this;
                if (gMNativeAd2 != null) {
                    return gMNativeAd2.getImageUrl();
                }
                return null;
            }

            @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
            public int getImageWidth() {
                GMNativeAd gMNativeAd2 = GMNativeAd.this;
                if (gMNativeAd2 != null) {
                    return gMNativeAd2.getImageWidth();
                }
                return 0;
            }

            @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
            public int getInteractionType() {
                GMNativeAd gMNativeAd2 = GMNativeAd.this;
                if (gMNativeAd2 != null) {
                    return gMNativeAd2.getInteractionType();
                }
                return 0;
            }

            @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
            public Map<String, Object> getMediaExtraInfo() {
                GMNativeAd gMNativeAd2 = GMNativeAd.this;
                if (gMNativeAd2 != null) {
                    return gMNativeAd2.getMediaExtraInfo();
                }
                return null;
            }

            @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
            public GMNativeAdAppInfo getNativeAdAppInfo() {
                GMNativeAd gMNativeAd2 = GMNativeAd.this;
                if (gMNativeAd2 != null) {
                    return gMNativeAd2.getNativeAdAppInfo();
                }
                return null;
            }

            @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
            @Nullable
            public String getPackageName() {
                GMNativeAd gMNativeAd2 = GMNativeAd.this;
                if (gMNativeAd2 != null) {
                    return gMNativeAd2.getPackageName();
                }
                return null;
            }

            @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
            @NonNull
            public String getPreEcpm() {
                GMNativeAd gMNativeAd2 = GMNativeAd.this;
                if (gMNativeAd2 != null) {
                    return gMNativeAd2.getPreEcpm();
                }
                return null;
            }

            @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
            public int getSdkNumType() {
                GMNativeAd gMNativeAd2 = GMNativeAd.this;
                if (gMNativeAd2 != null) {
                    return gMNativeAd2.getSdkNumType();
                }
                return 0;
            }

            @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
            @Nullable
            public GMAdEcpmInfo getShowEcpm() {
                GMNativeAd gMNativeAd2 = GMNativeAd.this;
                if (gMNativeAd2 != null) {
                    return gMNativeAd2.getShowEcpm();
                }
                return null;
            }

            @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
            @Nullable
            public String getSource() {
                GMNativeAd gMNativeAd2 = GMNativeAd.this;
                if (gMNativeAd2 != null) {
                    return gMNativeAd2.getSource();
                }
                return null;
            }

            @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
            public double getStarRating() {
                GMNativeAd gMNativeAd2 = GMNativeAd.this;
                if (gMNativeAd2 != null) {
                    return gMNativeAd2.getStarRating();
                }
                return 0.0d;
            }

            @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
            public TTBaseAd getTTBaseAd() {
                GMNativeAd gMNativeAd2 = GMNativeAd.this;
                if (gMNativeAd2 != null) {
                    return gMNativeAd2.getTTBaseAd();
                }
                return null;
            }

            @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
            @Nullable
            public String getTitle() {
                GMNativeAd gMNativeAd2 = GMNativeAd.this;
                if (gMNativeAd2 != null) {
                    return gMNativeAd2.getTitle();
                }
                return null;
            }

            @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
            public int getVideoHeight() {
                GMNativeAd gMNativeAd2 = GMNativeAd.this;
                if (gMNativeAd2 != null) {
                    return gMNativeAd2.getVideoHeight();
                }
                return 0;
            }

            @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
            public String getVideoUrl() {
                GMNativeAd gMNativeAd2 = GMNativeAd.this;
                if (gMNativeAd2 != null) {
                    return gMNativeAd2.getVideoUrl();
                }
                return null;
            }

            @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
            public int getVideoWidth() {
                GMNativeAd gMNativeAd2 = GMNativeAd.this;
                if (gMNativeAd2 != null) {
                    return gMNativeAd2.getVideoWidth();
                }
                return 0;
            }

            @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
            public boolean hasDislike() {
                GMNativeAd gMNativeAd2 = GMNativeAd.this;
                if (gMNativeAd2 != null) {
                    return gMNativeAd2.hasDislike();
                }
                return false;
            }

            @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
            public boolean isExpressAd() {
                GMNativeAd gMNativeAd2 = GMNativeAd.this;
                if (gMNativeAd2 != null) {
                    return gMNativeAd2.isExpressAd();
                }
                return false;
            }

            @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
            public boolean isHasShown() {
                GMNativeAd gMNativeAd2 = GMNativeAd.this;
                if (gMNativeAd2 != null) {
                    return gMNativeAd2.isHasShown();
                }
                return false;
            }

            @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
            public boolean isReady() {
                GMNativeAd gMNativeAd2 = GMNativeAd.this;
                if (gMNativeAd2 != null) {
                    return gMNativeAd2.isReady();
                }
                return false;
            }

            @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
            public boolean isServerBidding() {
                GMNativeAd gMNativeAd2 = GMNativeAd.this;
                if (gMNativeAd2 != null) {
                    return gMNativeAd2.isServerBidding();
                }
                return false;
            }

            @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
            public void onPause() {
                GMNativeAd gMNativeAd2 = GMNativeAd.this;
                if (gMNativeAd2 != null) {
                    gMNativeAd2.onPause();
                }
            }

            @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
            public void pauseAppDownload() {
                GMNativeAd gMNativeAd2 = GMNativeAd.this;
                if (gMNativeAd2 != null) {
                    gMNativeAd2.pauseAppDownload();
                }
            }

            @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
            public void registerView(@NonNull Activity activity, @NonNull ViewGroup viewGroup, @NonNull List<View> list, @Nullable List<View> list2, GMViewBinder gMViewBinder) {
                GMNativeAd gMNativeAd2 = GMNativeAd.this;
                if (gMNativeAd2 != null) {
                    gMNativeAd2.registerView(activity, viewGroup, list, list2, gMViewBinder);
                }
            }

            @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
            public void registerView(@NonNull Activity activity, @NonNull ViewGroup viewGroup, @NonNull List<View> list, @Nullable List<View> list2, @Nullable List<View> list3, GMViewBinder gMViewBinder) {
                GMNativeAd gMNativeAd2 = GMNativeAd.this;
                if (gMNativeAd2 != null) {
                    gMNativeAd2.registerView(activity, viewGroup, list, list2, list3, gMViewBinder);
                }
            }

            @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
            public void registerView(@NonNull ViewGroup viewGroup, @NonNull List<View> list, @Nullable List<View> list2, GMViewBinder gMViewBinder) {
                GMNativeAd gMNativeAd2 = GMNativeAd.this;
                if (gMNativeAd2 != null) {
                    gMNativeAd2.registerView(viewGroup, list, list2, gMViewBinder);
                }
            }

            @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
            public void render() {
                GMNativeAd gMNativeAd2 = GMNativeAd.this;
                if (gMNativeAd2 != null) {
                    gMNativeAd2.render();
                }
            }

            @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
            public void resume() {
                GMNativeAd gMNativeAd2 = GMNativeAd.this;
                if (gMNativeAd2 != null) {
                    gMNativeAd2.resume();
                }
            }

            @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
            public void resumeAppDownload() {
                GMNativeAd gMNativeAd2 = GMNativeAd.this;
                if (gMNativeAd2 != null) {
                    gMNativeAd2.resumeAppDownload();
                }
            }

            @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
            public void setAppDownloadListener(GMAdAppDownloadListener gMAdAppDownloadListener) {
                setTTAdAppDownloadListener(gMAdAppDownloadListener);
            }

            @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
            public void setDislikeCallback(Activity activity, GMDislikeCallback gMDislikeCallback) {
                GMNativeAd gMNativeAd2 = GMNativeAd.this;
                if (gMNativeAd2 != null) {
                    gMNativeAd2.setDislikeCallback(activity, gMDislikeCallback);
                }
            }

            @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
            public void setNativeAdListener(GMNativeAdListener gMNativeAdListener) {
                setTTNativeAdListener(gMNativeAdListener);
            }

            @Override // com.bytedance.msdk.api.nativeAd.TTNativeAd
            public void setTTAdAppDownloadListener(GMAdAppDownloadListener gMAdAppDownloadListener) {
                GMNativeAd gMNativeAd2 = GMNativeAd.this;
                if (gMNativeAd2 != null) {
                    gMNativeAd2.setAppDownloadListener(gMAdAppDownloadListener);
                }
            }

            @Override // com.bytedance.msdk.api.nativeAd.TTNativeAd
            public void setTTAdatperCallback(ITTAdatperCallback iTTAdatperCallback) {
            }

            @Override // com.bytedance.msdk.api.nativeAd.TTNativeAd
            public void setTTNativeAdListener(GMNativeAdListener gMNativeAdListener) {
                GMNativeAd gMNativeAd2 = GMNativeAd.this;
                if (gMNativeAd2 != null) {
                    gMNativeAd2.setNativeAdListener(gMNativeAdListener);
                }
            }

            @Override // com.bytedance.msdk.api.nativeAd.TTNativeAd
            public void setTTVideoListener(GMVideoListener gMVideoListener) {
                GMNativeAd gMNativeAd2 = GMNativeAd.this;
                if (gMNativeAd2 != null) {
                    gMNativeAd2.setVideoListener(gMVideoListener);
                }
            }

            @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
            public void setUseCustomVideo(boolean z) {
                GMNativeAd gMNativeAd2 = GMNativeAd.this;
                if (gMNativeAd2 != null) {
                    gMNativeAd2.setUseCustomVideo(z);
                }
            }

            @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
            public void setVideoListener(GMVideoListener gMVideoListener) {
                setTTVideoListener(gMVideoListener);
            }

            @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
            public void unregisterView() {
                GMNativeAd gMNativeAd2 = GMNativeAd.this;
                if (gMNativeAd2 != null) {
                    gMNativeAd2.unregisterView();
                }
            }
        };
    }
}
