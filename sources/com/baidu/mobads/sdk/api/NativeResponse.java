package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import com.baidu.mobads.sdk.internal.a;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public interface NativeResponse extends AbstractData {
    public static final int ACTION_TYPE_APP_DOWNLOAD = 2;
    public static final int ACTION_TYPE_DEEP_LINK = 3;
    public static final int ACTION_TYPE_LANDING_PAGE = 1;
    public static final int INFO_FLOW_GROUP_PIC = 35;
    public static final int INFO_FLOW_GROUP_PIC_LOGO = 36;
    public static final int INFO_FLOW_LEFT_PIC = 33;
    public static final int INFO_FLOW_PIC_BOTTOM_TITLE = 28;
    public static final int INFO_FLOW_PIC_LOGO = 30;
    public static final int INFO_FLOW_PIC_TOP_TITLE = 29;
    public static final int INFO_FLOW_RIGHT_PIC = 34;
    public static final int INFO_FLOW_VIDEO_TOP_TITLE = 37;

    /* loaded from: classes.dex */
    public interface AdDislikeListener {
        void onDislikeClick();
    }

    /* loaded from: classes.dex */
    public interface AdDownloadWindowListener extends AdPrivacyListener {
        void adDownloadWindowClose();

        void adDownloadWindowShow();
    }

    /* loaded from: classes.dex */
    public interface AdInteractionListener {
        void onADExposed();

        void onADExposureFailed(int i2);

        void onADStatusChanged();

        void onAdClick();

        void onAdUnionClick();
    }

    /* loaded from: classes.dex */
    public interface AdPrivacyListener {
        void onADPermissionClose();

        void onADPermissionShow();

        void onADPrivacyClick();
    }

    /* loaded from: classes.dex */
    public enum MaterialType {
        NORMAL(PrerollVideoResponse.NORMAL),
        VIDEO("video"),
        HTML(a.f1401f);
        
        private final String value;

        MaterialType(String str) {
            this.value = str;
        }

        public static MaterialType parse(String str) {
            MaterialType[] values;
            for (MaterialType materialType : values()) {
                if (materialType.value.equalsIgnoreCase(str)) {
                    return materialType;
                }
            }
            return null;
        }

        public String getValue() {
            return this.value;
        }
    }

    void biddingFail(String str);

    void biddingSuccess(String str);

    void clearImpressionTaskWhenBack();

    void dislikeClick(DislikeEvent dislikeEvent);

    String getActButtonString();

    int getAdActionType();

    String getAdLogoUrl();

    String getAdMaterialType();

    String getAppPackage();

    String getAppPermissionLink();

    String getAppPrivacyLink();

    long getAppSize();

    String getAppVersion();

    String getBaiduLogoUrl();

    String getBrandName();

    int getContainerHeight();

    int getContainerSizeType();

    int getContainerWidth();

    String getDesc();

    List<DislikeEvent> getDislikeList();

    int getDownloadStatus();

    int getDuration();

    String getECPMLevel();

    Map<String, String> getExtras();

    String getHtmlSnippet();

    String getIconUrl();

    String getImageUrl();

    int getMainPicHeight();

    int getMainPicWidth();

    String getMarketingPendant();

    MaterialType getMaterialType();

    List<String> getMultiPicUrls();

    String getPublisher();

    int getStyleType();

    String getTitle();

    String getVideoUrl();

    WebView getWebView();

    boolean isAdAvailable(Context context);

    boolean isAutoPlay();

    @Deprecated
    boolean isNeedDownloadApp();

    boolean isNonWifiAutoPlay();

    void pauseAppDownload();

    void permissionClick();

    void privacyClick();

    void recordImpression(View view);

    void registerViewForInteraction(View view, List<View> list, List<View> list2, AdInteractionListener adInteractionListener);

    void resumeAppDownload();

    void setAdPrivacyListener(AdPrivacyListener adPrivacyListener);

    void unionLogoClick();
}
