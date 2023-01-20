package com.baidu.mobads.sdk.api;

import android.content.Context;
import com.baidu.mobads.sdk.internal.bj;
import com.baidu.mobads.sdk.internal.df;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class RewardVideoAd {
    public static final int DOWNLOAD_APP_CONFIRM_NEVER = 3;
    public static final int DOWNLOAD_APP_CONFIRM_ONLY_MOBILE = 1;
    private static final String TAG = "RewardVideoAd";
    private df mAdProd;
    private final Context mContext;

    /* loaded from: classes.dex */
    public interface RewardVideoAdListener extends ScreenVideoAdListener {
        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdClick();

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdClose(float f2);

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdFailed(String str);

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdLoaded();

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdShow();

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdSkip(float f2);

        void onRewardVerify(boolean z);

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onVideoDownloadFailed();

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onVideoDownloadSuccess();

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void playCompletion();
    }

    public RewardVideoAd(Context context, String str, RewardVideoAdListener rewardVideoAdListener) {
        this(context, str, rewardVideoAdListener, false);
    }

    public void biddingFail(String str) {
        df dfVar = this.mAdProd;
        if (dfVar != null) {
            dfVar.a(false, str);
        }
    }

    public void biddingSuccess(String str) {
        df dfVar = this.mAdProd;
        if (dfVar != null) {
            dfVar.a(true, str);
        }
    }

    public String getBiddingToken() {
        df dfVar = this.mAdProd;
        if (dfVar != null) {
            return dfVar.m();
        }
        return null;
    }

    public String getECPMLevel() {
        df dfVar = this.mAdProd;
        return dfVar != null ? dfVar.h() : "";
    }

    public boolean isReady() {
        df dfVar = this.mAdProd;
        if (dfVar != null) {
            return dfVar.g();
        }
        return false;
    }

    public synchronized void load() {
        df dfVar = this.mAdProd;
        if (dfVar != null) {
            dfVar.a();
        }
    }

    public void loadBiddingAd(String str) {
        df dfVar = this.mAdProd;
        if (dfVar != null) {
            dfVar.c(str);
        }
    }

    public void setAppSid(String str) {
        df dfVar = this.mAdProd;
        if (dfVar != null) {
            dfVar.g(str);
        }
    }

    public void setBidFloor(int i2) {
        df dfVar = this.mAdProd;
        if (dfVar != null) {
            dfVar.p = i2;
        }
    }

    @Deprecated
    public void setBiddingData(String str) {
        df dfVar = this.mAdProd;
        if (dfVar != null) {
            dfVar.b(str);
        }
    }

    public void setDownloadAppConfirmPolicy(int i2) {
        df dfVar = this.mAdProd;
        if (dfVar != null) {
            dfVar.a(i2);
        }
    }

    public void setExtraInfo(String str) {
        df dfVar = this.mAdProd;
        if (dfVar != null) {
            dfVar.i(str);
        }
    }

    public void setShowDialogOnSkip(boolean z) {
        if (this.mAdProd != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("showDialogOnSkip", z);
                this.mAdProd.a(jSONObject);
            } catch (Throwable th) {
                bj.a().c(th);
            }
        }
    }

    public void setUseRewardCountdown(boolean z) {
        if (this.mAdProd != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("useRewardCountdown", z);
                this.mAdProd.a(jSONObject);
            } catch (Throwable th) {
                bj.a().c(th);
            }
        }
    }

    public void setUserId(String str) {
        df dfVar = this.mAdProd;
        if (dfVar != null) {
            dfVar.a(str);
        }
    }

    public synchronized void show() {
        df dfVar = this.mAdProd;
        if (dfVar != null) {
            dfVar.f();
        }
    }

    public RewardVideoAd(Context context, String str, RewardVideoAdListener rewardVideoAdListener, boolean z) {
        this.mContext = context;
        df dfVar = new df(context, str, z);
        this.mAdProd = dfVar;
        dfVar.a(rewardVideoAdListener);
    }
}
