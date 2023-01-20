package com.bytedance.msdk.api.v2.slot;

import com.bytedance.msdk.api.AdmobNativeAdOptions;
import com.bytedance.msdk.api.v2.slot.paltform.GMAdSlotBaiduOption;
import com.bytedance.msdk.api.v2.slot.paltform.GMAdSlotGDTOption;

/* loaded from: classes.dex */
public class GMAdOptionUtil {
    public static AdmobNativeAdOptions getAdmobNativeAdOptions() {
        AdmobNativeAdOptions admobNativeAdOptions = new AdmobNativeAdOptions();
        admobNativeAdOptions.setAdChoicesPlacement(1).setRequestMultipleImages(true).setReturnUrlsForImageAssets(true);
        return admobNativeAdOptions;
    }

    public static GMAdSlotBaiduOption.Builder getGMAdSlotBaiduOption() {
        return new GMAdSlotBaiduOption.Builder().setShowDialogOnSkip(true).setDownloadAppConfirmPolicy(2).setUseRewardCountdown(true).setCacheVideoOnlyWifi(true);
    }

    public static GMAdSlotGDTOption.Builder getGMAdSlotGDTOption() {
        return new GMAdSlotGDTOption.Builder().setGDTAutoPlayMuted(true).setGDTDetailPageMuted(false).setGDTEnableDetailPage(true).setGDTEnableUserControl(false).setGDTMaxVideoDuration(0).setGDTMinVideoDuration(0).setAutoPlayPolicy(0).setDownAPPConfirmPolicy(0);
    }
}
