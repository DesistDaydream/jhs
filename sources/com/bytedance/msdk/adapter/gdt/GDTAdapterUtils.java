package com.bytedance.msdk.adapter.gdt;

import android.content.Context;
import com.bytedance.msdk.api.GDTExtraOption;
import com.bytedance.msdk.api.v2.GMAdConstant;
import com.bytedance.msdk.api.v2.slot.paltform.GMAdSlotGDTOption;
import com.qq.e.ads.cfg.VideoOption;

/* loaded from: classes.dex */
public class GDTAdapterUtils {
    public static final double CPM_DEFLAUT_VALUE = 0.0d;

    /* renamed from: com.bytedance.msdk.adapter.gdt.GDTAdapterUtils$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[GMAdConstant.BiddingLossReason.values().length];
            a = iArr;
            try {
                iArr[GMAdConstant.BiddingLossReason.LOW_PRICE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[GMAdConstant.BiddingLossReason.TIME_OUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[GMAdConstant.BiddingLossReason.NO_AD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[GMAdConstant.BiddingLossReason.OTHER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static int dp2px(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int getBiddingLossReason(GMAdConstant.BiddingLossReason biddingLossReason) {
        if (biddingLossReason == null) {
            return 10001;
        }
        try {
            int i2 = AnonymousClass1.a[biddingLossReason.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    return i2 != 3 ? 10001 : 2;
                }
                return 101;
            }
            return 1;
        } catch (Throwable th) {
            th.printStackTrace();
            return 10001;
        }
    }

    public static VideoOption getGMVideoOption(GMAdSlotGDTOption gMAdSlotGDTOption) {
        VideoOption.Builder builder = new VideoOption.Builder();
        if (gMAdSlotGDTOption != null) {
            builder.setAutoPlayPolicy(gMAdSlotGDTOption.getGDTAutoPlayPolicy());
            builder.setAutoPlayMuted(gMAdSlotGDTOption.isGDTAutoPlayMuted());
            builder.setDetailPageMuted(gMAdSlotGDTOption.isGDTDetailPageMuted());
            builder.setEnableDetailPage(gMAdSlotGDTOption.isGDTEnableDetailPage());
            builder.setEnableUserControl(gMAdSlotGDTOption.isGDTEnableUserControl());
        }
        return builder.build();
    }

    public static VideoOption getVideoOption(GDTExtraOption gDTExtraOption) {
        VideoOption.Builder builder = new VideoOption.Builder();
        if (gDTExtraOption != null) {
            builder.setAutoPlayPolicy(gDTExtraOption.getGDTAutoPlayPolicy());
            builder.setAutoPlayMuted(gDTExtraOption.isGDTAutoPlayMuted());
            builder.setDetailPageMuted(gDTExtraOption.isGDTDetailPageMuted());
            builder.setEnableDetailPage(gDTExtraOption.isGDTEnableDetailPage());
            builder.setEnableUserControl(gDTExtraOption.isGDTEnableUserControl());
        }
        return builder.build();
    }
}
