package com.bytedance.msdk.api.v2.ad;

import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.BaiduExtraOptions;
import com.bytedance.msdk.api.GDTExtraOption;
import com.bytedance.msdk.api.TTVideoOption;
import com.bytedance.msdk.api.v2.slot.GMAdSlotBanner;
import com.bytedance.msdk.api.v2.slot.GMAdSlotBase;
import com.bytedance.msdk.api.v2.slot.GMAdSlotDraw;
import com.bytedance.msdk.api.v2.slot.GMAdSlotFullVideo;
import com.bytedance.msdk.api.v2.slot.GMAdSlotInterstitial;
import com.bytedance.msdk.api.v2.slot.GMAdSlotInterstitialFull;
import com.bytedance.msdk.api.v2.slot.GMAdSlotNative;
import com.bytedance.msdk.api.v2.slot.GMAdSlotRewardVideo;
import com.bytedance.msdk.api.v2.slot.GMAdSlotSplash;
import com.bytedance.msdk.api.v2.slot.paltform.GMAdSlotGDTOption;
import java.util.Map;

/* loaded from: classes.dex */
public class AdUtils {
    private static AdSlot.Builder a(GMAdSlotBase gMAdSlotBase) {
        if (gMAdSlotBase != null) {
            AdSlot.Builder builder = new AdSlot.Builder();
            builder.setBidNotify(gMAdSlotBase.isBidNotify());
            builder.setTestSlotId(gMAdSlotBase.getTestSlotId());
            builder.setTTVideoOption(gMAdSlotBase.createTTVideoOption(gMAdSlotBase instanceof GMAdSlotSplash ? ((GMAdSlotSplash) gMAdSlotBase).isSplashPreLoad() : false));
            builder.setTTRequestExtraParams(gMAdSlotBase.getTTRequestExtraParams());
            builder.setDownloadType(gMAdSlotBase.getDownloadType());
            builder.setV2Request(true);
            return builder;
        }
        return null;
    }

    public static AdSlot convertGMAdSlotBase2AdSlot(GMAdSlotBase gMAdSlotBase) {
        AdSlot build;
        int i2;
        AdSlot.Builder a = a(gMAdSlotBase);
        if (gMAdSlotBase instanceof GMAdSlotRewardVideo) {
            GMAdSlotRewardVideo gMAdSlotRewardVideo = (GMAdSlotRewardVideo) gMAdSlotBase;
            a.setRewardName(gMAdSlotRewardVideo.getRewardName());
            a.setRewardAmount(gMAdSlotRewardVideo.getRewardAmount());
            a.setCustomData(gMAdSlotRewardVideo.getCustomData());
            a.setUserID(gMAdSlotRewardVideo.getUserID());
            a.setOrientation(gMAdSlotRewardVideo.getOrientation());
            build = a.build();
            i2 = 7;
        } else if (gMAdSlotBase instanceof GMAdSlotFullVideo) {
            GMAdSlotFullVideo gMAdSlotFullVideo = (GMAdSlotFullVideo) gMAdSlotBase;
            a.setUserID(gMAdSlotFullVideo.getUserID());
            a.setOrientation(gMAdSlotFullVideo.getOrientation());
            a.setRewardName(gMAdSlotFullVideo.getRewardName());
            a.setRewardAmount(gMAdSlotFullVideo.getRewardAmount());
            a.setCustomData(gMAdSlotFullVideo.getCustomData());
            build = a.build();
            i2 = 8;
        } else if (!(gMAdSlotBase instanceof GMAdSlotInterstitialFull)) {
            if (gMAdSlotBase instanceof GMAdSlotSplash) {
                GMAdSlotSplash gMAdSlotSplash = (GMAdSlotSplash) gMAdSlotBase;
                a.setImageAdSize(gMAdSlotSplash.getWidth(), gMAdSlotSplash.getHeight());
                a.setUserID(gMAdSlotSplash.getUserID());
                a.setSplashButtonType(gMAdSlotSplash.getSplashButtonType());
                a.setForceLoadBottom(gMAdSlotSplash.isForceLoadBottom());
                a.setSplashShakeButton(gMAdSlotSplash.getSplashShakeButton());
                build = a.build();
                build.setAdType(3);
            } else if (gMAdSlotBase instanceof GMAdSlotNative) {
                GMAdSlotNative gMAdSlotNative = (GMAdSlotNative) gMAdSlotBase;
                a.setImageAdSize(gMAdSlotNative.getWidth(), gMAdSlotNative.getHeight());
                a.setAdCount(gMAdSlotNative.getAdCount());
                a.setAdStyleType(gMAdSlotNative.getAdStyleType());
                a.setAdmobNativeAdOptions(gMAdSlotNative.getAdmobNativeAdOptions());
                a.setUserID(gMAdSlotNative.getUserID());
                GMAdSlotGDTOption gMAdSlotGDTOption = gMAdSlotNative.getGMAdSlotGDTOption();
                if (gMAdSlotGDTOption != null) {
                    a.setGdtNativeAdLogoParams(gMAdSlotGDTOption.getNativeAdLogoParams());
                }
                build = a.build();
                build.setAdType(5);
                if (build.getAdCount() <= 3) {
                    if (build.getAdCount() >= 1) {
                        return build;
                    }
                }
                build.setAdCount(3);
                return build;
            } else if (gMAdSlotBase instanceof GMAdSlotDraw) {
                GMAdSlotDraw gMAdSlotDraw = (GMAdSlotDraw) gMAdSlotBase;
                a.setImageAdSize(gMAdSlotDraw.getWidth(), gMAdSlotDraw.getHeight());
                a.setAdCount(gMAdSlotDraw.getAdCount());
                build = a.build();
                build.setAdType(9);
                if (build.getAdCount() <= 3) {
                    if (build.getAdCount() >= 1) {
                        return build;
                    }
                }
                build.setAdCount(3);
                return build;
            } else if (gMAdSlotBase instanceof GMAdSlotBanner) {
                GMAdSlotBanner gMAdSlotBanner = (GMAdSlotBanner) gMAdSlotBase;
                a.setImageAdSize(gMAdSlotBanner.getWidth(), gMAdSlotBanner.getHeight());
                a.setBannerSize(gMAdSlotBanner.getBannerSize());
                build = a.build();
                build.setAdType(1);
            } else if (!(gMAdSlotBase instanceof GMAdSlotInterstitial)) {
                return a.build();
            } else {
                GMAdSlotInterstitial gMAdSlotInterstitial = (GMAdSlotInterstitial) gMAdSlotBase;
                a.setImageAdSize(gMAdSlotInterstitial.getWidth(), gMAdSlotInterstitial.getHeight());
                build = a.build();
                i2 = 2;
            }
            build.setAdCount(1);
            return build;
        } else {
            GMAdSlotInterstitialFull gMAdSlotInterstitialFull = (GMAdSlotInterstitialFull) gMAdSlotBase;
            a.setImageAdSize(gMAdSlotInterstitialFull.getWidth(), gMAdSlotInterstitialFull.getHeight());
            a.setUserID(gMAdSlotInterstitialFull.getUserID());
            a.setOrientation(gMAdSlotInterstitialFull.getOrientation());
            a.setRewardName(gMAdSlotInterstitialFull.getRewardName());
            a.setRewardAmount(gMAdSlotInterstitialFull.getRewardAmount());
            a.setCustomData(gMAdSlotInterstitialFull.getCustomData());
            build = a.build();
            i2 = 10;
        }
        build.setAdType(i2);
        build.setAdCount(1);
        return build;
    }

    public static GMAdSlotBase covertAdSlot2GMAdSlotBase(AdSlot adSlot) {
        int adType = adSlot.getAdType();
        if (adType != 1) {
            if (adType != 2) {
                if (adType != 3) {
                    if (adType != 5) {
                        if (adType != 10) {
                            if (adType != 7) {
                                if (adType != 8) {
                                    return null;
                                }
                                return getAdSlotFullVideo(adSlot);
                            }
                            return getAdSlotRewardVideo(adSlot);
                        }
                        return getAdSlotInterstitialFull(adSlot);
                    }
                    return getAdSlotNative(adSlot);
                }
                return getAdSlotSplash(adSlot);
            }
            return getAdSlotInterstitial(adSlot);
        }
        return getAdSlotBanner(adSlot);
    }

    public static GMAdSlotBanner getAdSlotBanner(AdSlot adSlot) {
        if (adSlot != null) {
            GMAdSlotBanner.Builder downloadType = new GMAdSlotBanner.Builder().setBidNotify(adSlot.isBidNotify()).setTestSlotId(adSlot.getTestSlotId()).setDownloadType(adSlot.getDownloadType());
            for (Map.Entry<String, Object> entry : adSlot.getReuestParam().getExtraObject().entrySet()) {
                downloadType.setExtraObject(entry.getKey(), entry.getValue());
            }
            TTVideoOption tTVideoOption = adSlot.getTTVideoOption();
            if (tTVideoOption != null) {
                downloadType.setMuted(tTVideoOption.isMuted());
                downloadType.setVolume(tTVideoOption.getAdmobAppVolume());
                downloadType.setUseSurfaceView(tTVideoOption.useSurfaceView());
                GDTExtraOption gDTExtraOption = tTVideoOption.getGDTExtraOption();
                if (gDTExtraOption != null) {
                    downloadType.setGMAdSlotGDTOption(gDTExtraOption.getGMGDTExtraOption().build());
                }
                BaiduExtraOptions baiduExtraOption = tTVideoOption.getBaiduExtraOption();
                if (baiduExtraOption != null) {
                    downloadType.setGMAdSlotBaiduOption(baiduExtraOption.getGMBaiduExtra());
                }
            }
            downloadType.setImageAdSize(adSlot.getImgAcceptedWidth(), adSlot.getImgAcceptedHeight());
            downloadType.setBannerSize(adSlot.getBannerSize());
            downloadType.setUserID(adSlot.getUserID());
            return downloadType.build();
        }
        return null;
    }

    public static GMAdSlotFullVideo getAdSlotFullVideo(AdSlot adSlot) {
        if (adSlot != null) {
            GMAdSlotFullVideo.Builder downloadType = new GMAdSlotFullVideo.Builder().setBidNotify(adSlot.isBidNotify()).setTestSlotId(adSlot.getTestSlotId()).setDownloadType(adSlot.getDownloadType());
            for (Map.Entry<String, Object> entry : adSlot.getReuestParam().getExtraObject().entrySet()) {
                downloadType.setExtraObject(entry.getKey(), entry.getValue());
            }
            TTVideoOption tTVideoOption = adSlot.getTTVideoOption();
            if (tTVideoOption != null) {
                downloadType.setMuted(tTVideoOption.isMuted());
                downloadType.setVolume(tTVideoOption.getAdmobAppVolume());
                downloadType.setUseSurfaceView(tTVideoOption.useSurfaceView());
                GDTExtraOption gDTExtraOption = tTVideoOption.getGDTExtraOption();
                if (gDTExtraOption != null) {
                    downloadType.setGMAdSlotGDTOption(gDTExtraOption.getGMGDTExtraOption().build());
                }
                BaiduExtraOptions baiduExtraOption = tTVideoOption.getBaiduExtraOption();
                if (baiduExtraOption != null) {
                    downloadType.setGMAdSlotBaiduOption(baiduExtraOption.getGMBaiduExtra());
                }
            }
            if (adSlot.getOrientation() == 2) {
                downloadType.setOrientation(2);
            } else {
                downloadType.setOrientation(1);
            }
            downloadType.setUserID(adSlot.getUserID());
            downloadType.setCustomData(adSlot.getCustomData());
            downloadType.setRewardAmount(adSlot.getRewardAmount());
            downloadType.setRewardName(adSlot.getRewardName());
            return downloadType.build();
        }
        return null;
    }

    public static GMAdSlotInterstitial getAdSlotInterstitial(AdSlot adSlot) {
        if (adSlot != null) {
            GMAdSlotInterstitial.Builder downloadType = new GMAdSlotInterstitial.Builder().setBidNotify(adSlot.isBidNotify()).setTestSlotId(adSlot.getTestSlotId()).setDownloadType(adSlot.getDownloadType());
            for (Map.Entry<String, Object> entry : adSlot.getReuestParam().getExtraObject().entrySet()) {
                downloadType.setExtraObject(entry.getKey(), entry.getValue());
            }
            TTVideoOption tTVideoOption = adSlot.getTTVideoOption();
            if (tTVideoOption != null) {
                downloadType.setMuted(tTVideoOption.isMuted());
                downloadType.setVolume(tTVideoOption.getAdmobAppVolume());
                downloadType.setUseSurfaceView(tTVideoOption.useSurfaceView());
                GDTExtraOption gDTExtraOption = tTVideoOption.getGDTExtraOption();
                if (gDTExtraOption != null) {
                    downloadType.setGMAdSlotGDTOption(gDTExtraOption.getGMGDTExtraOption().build());
                }
                BaiduExtraOptions baiduExtraOption = tTVideoOption.getBaiduExtraOption();
                if (baiduExtraOption != null) {
                    downloadType.setGMAdSlotBaiduOption(baiduExtraOption.getGMBaiduExtra());
                }
            }
            downloadType.setImageAdSize(adSlot.getImgAcceptedWidth(), adSlot.getImgAcceptedHeight());
            return downloadType.build();
        }
        return null;
    }

    public static GMAdSlotInterstitialFull getAdSlotInterstitialFull(AdSlot adSlot) {
        if (adSlot != null) {
            GMAdSlotInterstitialFull.Builder downloadType = new GMAdSlotInterstitialFull.Builder().setBidNotify(adSlot.isBidNotify()).setTestSlotId(adSlot.getTestSlotId()).setDownloadType(adSlot.getDownloadType());
            for (Map.Entry<String, Object> entry : adSlot.getReuestParam().getExtraObject().entrySet()) {
                downloadType.setExtraObject(entry.getKey(), entry.getValue());
            }
            TTVideoOption tTVideoOption = adSlot.getTTVideoOption();
            if (tTVideoOption != null) {
                downloadType.setMuted(tTVideoOption.isMuted());
                downloadType.setVolume(tTVideoOption.getAdmobAppVolume());
                downloadType.setUseSurfaceView(tTVideoOption.useSurfaceView());
                GDTExtraOption gDTExtraOption = tTVideoOption.getGDTExtraOption();
                if (gDTExtraOption != null) {
                    downloadType.setGMAdSlotGDTOption(gDTExtraOption.getGMGDTExtraOption().build());
                }
                BaiduExtraOptions baiduExtraOption = tTVideoOption.getBaiduExtraOption();
                if (baiduExtraOption != null) {
                    downloadType.setGMAdSlotBaiduOption(baiduExtraOption.getGMBaiduExtra());
                }
            }
            if (adSlot.getOrientation() == 2) {
                downloadType.setOrientation(2);
            } else {
                downloadType.setOrientation(1);
            }
            downloadType.setImageAdSize(adSlot.getImgAcceptedWidth(), adSlot.getImgAcceptedHeight());
            downloadType.setUserID(adSlot.getUserID());
            downloadType.setCustomData(adSlot.getCustomData());
            downloadType.setRewardAmount(adSlot.getRewardAmount());
            downloadType.setRewardName(adSlot.getRewardName());
            return downloadType.build();
        }
        return null;
    }

    public static GMAdSlotNative getAdSlotNative(AdSlot adSlot) {
        if (adSlot != null) {
            GMAdSlotNative.Builder downloadType = new GMAdSlotNative.Builder().setBidNotify(adSlot.isBidNotify()).setTestSlotId(adSlot.getTestSlotId()).setDownloadType(adSlot.getDownloadType());
            for (Map.Entry<String, Object> entry : adSlot.getReuestParam().getExtraObject().entrySet()) {
                downloadType.setExtraObject(entry.getKey(), entry.getValue());
            }
            TTVideoOption tTVideoOption = adSlot.getTTVideoOption();
            if (tTVideoOption != null) {
                downloadType.setMuted(tTVideoOption.isMuted());
                downloadType.setVolume(tTVideoOption.getAdmobAppVolume());
                downloadType.setUseSurfaceView(tTVideoOption.useSurfaceView());
                GDTExtraOption gDTExtraOption = tTVideoOption.getGDTExtraOption();
                if (gDTExtraOption != null) {
                    GMAdSlotGDTOption.Builder gMGDTExtraOption = gDTExtraOption.getGMGDTExtraOption();
                    gMGDTExtraOption.setNativeAdLogoParams(adSlot.getGdtNativeAdLogoParams());
                    downloadType.setGMAdSlotGDTOption(gMGDTExtraOption.build());
                }
                BaiduExtraOptions baiduExtraOption = tTVideoOption.getBaiduExtraOption();
                if (baiduExtraOption != null) {
                    downloadType.setGMAdSlotBaiduOption(baiduExtraOption.getGMBaiduExtra());
                }
            }
            downloadType.setImageAdSize(adSlot.getImgAcceptedWidth(), adSlot.getImgAcceptedHeight());
            downloadType.setAdCount(adSlot.getAdCount());
            downloadType.setAdStyleType(adSlot.getAdStyleType());
            downloadType.setAdmobNativeAdOptions(adSlot.getAdmobNativeAdOptions());
            downloadType.setUserID(adSlot.getUserID());
            return downloadType.build();
        }
        return null;
    }

    public static GMAdSlotRewardVideo getAdSlotRewardVideo(AdSlot adSlot) {
        if (adSlot != null) {
            GMAdSlotRewardVideo.Builder downloadType = new GMAdSlotRewardVideo.Builder().setBidNotify(adSlot.isBidNotify()).setTestSlotId(adSlot.getTestSlotId()).setDownloadType(adSlot.getDownloadType());
            for (Map.Entry<String, Object> entry : adSlot.getReuestParam().getExtraObject().entrySet()) {
                downloadType.setExtraObject(entry.getKey(), entry.getValue());
            }
            TTVideoOption tTVideoOption = adSlot.getTTVideoOption();
            if (tTVideoOption != null) {
                downloadType.setMuted(tTVideoOption.isMuted());
                downloadType.setVolume(tTVideoOption.getAdmobAppVolume());
                downloadType.setUseSurfaceView(tTVideoOption.useSurfaceView());
                GDTExtraOption gDTExtraOption = tTVideoOption.getGDTExtraOption();
                if (gDTExtraOption != null) {
                    downloadType.setGMAdSlotGDTOption(gDTExtraOption.getGMGDTExtraOption().build());
                }
                BaiduExtraOptions baiduExtraOption = tTVideoOption.getBaiduExtraOption();
                if (baiduExtraOption != null) {
                    downloadType.setGMAdSlotBaiduOption(baiduExtraOption.getGMBaiduExtra());
                }
            }
            if (adSlot.getOrientation() == 2) {
                downloadType.setOrientation(2);
            } else {
                downloadType.setOrientation(1);
            }
            downloadType.setUserID(adSlot.getUserID());
            downloadType.setCustomData(adSlot.getCustomData());
            downloadType.setRewardAmount(adSlot.getRewardAmount());
            downloadType.setRewardName(adSlot.getRewardName());
            return downloadType.build();
        }
        return null;
    }

    public static GMAdSlotSplash getAdSlotSplash(AdSlot adSlot) {
        if (adSlot != null) {
            GMAdSlotSplash.Builder forceLoadBottom = new GMAdSlotSplash.Builder().setSplashButtonType(adSlot.getSplashButtonType()).setImageAdSize(adSlot.getImgAcceptedWidth(), adSlot.getImgAcceptedHeight()).setUserID(adSlot.getUserID()).setBidNotify(adSlot.isBidNotify()).setTestSlotId(adSlot.getTestSlotId()).setDownloadType(adSlot.getDownloadType()).setSplashShakeButton(adSlot.getSplashShakeButton()).setForceLoadBottom(adSlot.isForceLoadBottom());
            for (Map.Entry<String, Object> entry : adSlot.getReuestParam().getExtraObject().entrySet()) {
                forceLoadBottom.setExtraObject(entry.getKey(), entry.getValue());
            }
            TTVideoOption tTVideoOption = adSlot.getTTVideoOption();
            if (tTVideoOption != null) {
                forceLoadBottom.setMuted(tTVideoOption.isMuted());
                forceLoadBottom.setVolume(tTVideoOption.getAdmobAppVolume());
                forceLoadBottom.setUseSurfaceView(tTVideoOption.useSurfaceView());
                GDTExtraOption gDTExtraOption = tTVideoOption.getGDTExtraOption();
                if (gDTExtraOption != null) {
                    forceLoadBottom.setGMAdSlotGDTOption(gDTExtraOption.getGMGDTExtraOption().build());
                    forceLoadBottom.setSplashPreLoad(gDTExtraOption.isSplashPreLoad());
                }
                BaiduExtraOptions baiduExtraOption = tTVideoOption.getBaiduExtraOption();
                if (baiduExtraOption != null) {
                    forceLoadBottom.setGMAdSlotBaiduOption(baiduExtraOption.getGMBaiduExtra());
                }
            }
            return forceLoadBottom.build();
        }
        return null;
    }
}
