package com.baidu.mobads.sdk.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.internal.a;
import com.baidu.mobads.sdk.internal.aq;
import com.baidu.mobads.sdk.internal.bf;
import com.baidu.mobads.sdk.internal.bj;
import com.baidu.mobads.sdk.internal.ch;
import com.baidu.mobads.sdk.internal.ct;
import com.baidu.mobads.sdk.internal.dg;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class SplashAd {
    private static final int BOTTOM_VIEW_ID = 4097;
    public static final String KEY_DISPLAY_DOWNLOADINFO = "displayDownloadInfo";
    public static final String KEY_FETCHAD = "fetchAd";
    public static final String KEY_LOAD_AFTER_CACHE_END = "loadAfterCacheEnd";
    public static final String KEY_POPDIALOG_DOWNLOAD = "use_dialog_frame";
    public static final String KEY_PREFER_FULLSCREEN = "prefer_fullscreen";
    public static final String KEY_SHAKE_LOGO_SIZE = "shake_logo_size";
    public static final String KEY_TIMEOUT = "timeout";
    public static final String KEY_USE_ADAPTIVE_AD = "adaptive_ad";
    private static final int RT_SPLASH_LOAD_AD_TIMEOUT = 4200;
    private String mAdPlaceId;
    private dg mAdProd;
    private String mAppSid;
    private int mBidFloor;
    private Context mContext;
    private Boolean mDisplayClickRegion;
    private boolean mDisplayDownInfo;
    private SplashAdDownloadDialogListener mDownloadDialogListener;
    private boolean mFetchAd;
    private boolean mFetchNotShow;
    private boolean mIsAdaptiveSplashAd;
    private Boolean mLimitRegionClick;
    private SplashAdListener mListener;
    private RequestParameters mParameter;
    private Boolean mPopDialogIfDL;
    private int mShakeLogoSize;
    private int mTimeout;
    private int mTipStyle;
    private ViewGroup mViewParent;

    /* loaded from: classes.dex */
    public interface OnFinishListener {
        void onFinishActivity();
    }

    /* loaded from: classes.dex */
    public interface SplashAdDownloadDialogListener {
        void adDownloadWindowClose();

        void adDownloadWindowShow();

        void onADPermissionClose();

        void onADPermissionShow();

        void onADPrivacyLpClose();

        void onADPrivacyLpShow();
    }

    /* loaded from: classes.dex */
    public interface SplashFocusAdListener {
        void onAdClick();

        void onAdClose();

        void onAdIconShow();

        void onLpClosed();
    }

    public SplashAd(Context context, String str, SplashAdListener splashAdListener) {
        this(context, str, null, splashAdListener);
    }

    private void addZeroPxSurfaceViewAvoidBlink(ViewGroup viewGroup, Context context) {
        try {
            viewGroup.addView(new SurfaceView(context), new RelativeLayout.LayoutParams(0, 0));
        } catch (Exception e2) {
            bj.a().a(e2);
        }
    }

    public void callAdFailed(String str) {
        SplashAdListener splashAdListener = this.mListener;
        if (splashAdListener != null) {
            splashAdListener.onAdFailed(str);
        }
    }

    public static void registerEnterTransition(Activity activity, SplashFocusAdListener splashFocusAdListener) {
        dg.a(activity, (JSONObject) null, splashFocusAdListener);
    }

    private void setAppLogo(Object obj) {
        if (this.mAdProd != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("event_type", "splash_logo");
                HashMap hashMap = new HashMap();
                hashMap.put("appLogo", obj);
                this.mAdProd.a(jSONObject, hashMap);
            } catch (Throwable th) {
                bj.a().d(th);
            }
        }
    }

    private final void setAppLogoData(byte[] bArr) {
        setAppLogo(bArr);
    }

    private final void setAppLogoId(int i2) {
        setAppLogo(Integer.valueOf(i2));
    }

    private final void showWithBottomView(ViewGroup viewGroup, View view) {
        this.mViewParent = viewGroup;
        if (viewGroup == null) {
            SplashAdListener splashAdListener = this.mListener;
            if (splashAdListener != null) {
                splashAdListener.onAdFailed("传入容器不可以为空");
            }
        } else if (this.mIsAdaptiveSplashAd && view == null) {
            SplashAdListener splashAdListener2 = this.mListener;
            if (splashAdListener2 != null) {
                splashAdListener2.onAdFailed("使用自适应开屏广告能力, 需要使用showWithBottomView方法并传入合适尺寸的底部logo");
            }
        } else {
            dg dgVar = this.mAdProd;
            if (dgVar != null) {
                final ch chVar = new ch(this.mContext);
                chVar.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                if (view != null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams.addRule(12);
                    view.setId(4097);
                    chVar.addView(view, layoutParams);
                }
                chVar.a(new ch.a() { // from class: com.baidu.mobads.sdk.api.SplashAd.2
                    {
                        SplashAd.this = this;
                    }

                    @Override // com.baidu.mobads.sdk.internal.ch.a
                    public void onAttachedToWindow() {
                        if (SplashAd.this.mAdProd != null) {
                            SplashAd.this.mAdProd.o();
                        }
                    }

                    @Override // com.baidu.mobads.sdk.internal.ch.a
                    public void onDetachedFromWindow() {
                        if (SplashAd.this.mAdProd != null) {
                            SplashAd.this.mAdProd.p();
                        }
                    }

                    @Override // com.baidu.mobads.sdk.internal.ch.a
                    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
                        return false;
                    }

                    @Override // com.baidu.mobads.sdk.internal.ch.a
                    public void onLayoutComplete(int i2, int i3) {
                        if (!SplashAd.this.mFetchNotShow) {
                            if (SplashAd.this.mAdProd != null) {
                                SplashAd.this.mAdProd.r();
                            }
                            SplashAd.this.callAdFailed("展现失败，请重新load");
                        } else if (SplashAd.this.mAdProd != null) {
                            SplashAd.this.mAdProd.a = false;
                            SplashAd.this.mFetchNotShow = false;
                            SplashAd.this.mAdProd.a(chVar);
                            SplashAd.this.mAdProd.f();
                        } else {
                            SplashAd.this.callAdFailed("展现失败，请检查splashAd参数是否正确");
                        }
                    }

                    @Override // com.baidu.mobads.sdk.internal.ch.a
                    public void onWindowFocusChanged(boolean z) {
                        if (SplashAd.this.mAdProd != null) {
                            SplashAd.this.mAdProd.a(z);
                        }
                    }

                    @Override // com.baidu.mobads.sdk.internal.ch.a
                    public void onWindowVisibilityChanged(int i2) {
                        if (SplashAd.this.mAdProd != null) {
                            SplashAd.this.mAdProd.b(i2);
                        }
                    }
                });
                this.mViewParent.addView(chVar);
                return;
            }
            if (dgVar != null) {
                dgVar.r();
            }
            callAdFailed("展现失败，请检查splashAd参数是否正确");
        }
    }

    public void biddingFail(String str) {
        dg dgVar = this.mAdProd;
        if (dgVar != null) {
            dgVar.a(false, str);
        }
    }

    public void biddingSuccess(String str) {
        dg dgVar = this.mAdProd;
        if (dgVar != null) {
            dgVar.a(true, str);
        }
    }

    public void destroy() {
        dg dgVar = this.mAdProd;
        if (dgVar != null) {
            dgVar.e();
        }
        this.mListener = null;
    }

    public void finishAndJump(Intent intent) {
        finishAndJump(intent, null);
    }

    public String getBiddingToken() {
        dg dgVar = this.mAdProd;
        if (dgVar != null) {
            dgVar.r();
            this.mAdProd = null;
        }
        float e2 = aq.e(this.mContext);
        Rect a = aq.a(this.mContext);
        int width = a.width();
        int height = a.height();
        RequestParameters requestParameters = this.mParameter;
        if (requestParameters != null && requestParameters.isCustomSize()) {
            if (this.mParameter.getWidth() > 0) {
                width = (int) (this.mParameter.getWidth() * e2);
            }
            if (this.mParameter.getHeight() > 0) {
                height = (int) (this.mParameter.getHeight() * e2);
            }
        }
        int i2 = height;
        int i3 = width;
        if (i3 >= 200.0f * e2 && i2 >= e2 * 150.0f) {
            dg dgVar2 = new dg(this.mContext, this.mAdPlaceId, i3, i2, this.mTipStyle, this.mTimeout, this.mDisplayDownInfo, this.mPopDialogIfDL.booleanValue(), this.mDisplayClickRegion.booleanValue(), this.mLimitRegionClick.booleanValue());
            this.mAdProd = dgVar2;
            dgVar2.a(this.mShakeLogoSize);
            this.mAdProd.g(this.mAppSid);
            dg dgVar3 = this.mAdProd;
            dgVar3.p = this.mBidFloor;
            dgVar3.a = true;
            RequestParameters requestParameters2 = this.mParameter;
            if (requestParameters2 != null) {
                dgVar3.a(requestParameters2);
            }
            this.mAdProd.a(this.mListener);
            this.mFetchNotShow = true;
            this.mAdProd.a(this.mDownloadDialogListener);
            return this.mAdProd.m();
        }
        bj.a().c(ct.a().a(bf.SHOW_STANDARD_UNFIT, "开屏显示区域太小,宽度至少200dp,高度至少150dp"));
        SplashAdListener splashAdListener = this.mListener;
        if (splashAdListener != null && (splashAdListener instanceof SplashInteractionListener)) {
            ((SplashInteractionListener) splashAdListener).onAdDismissed();
        }
        return null;
    }

    public String getECPMLevel() {
        a g2;
        dg dgVar = this.mAdProd;
        return (dgVar == null || (g2 = dgVar.g()) == null) ? "" : g2.z();
    }

    public boolean isReady() {
        IAdInterListener iAdInterListener;
        dg dgVar = this.mAdProd;
        if (dgVar == null || (iAdInterListener = dgVar.f1464k) == null) {
            return false;
        }
        return iAdInterListener.isAdReady();
    }

    public final void load() {
        dg dgVar = this.mAdProd;
        if (dgVar != null) {
            dgVar.r();
            this.mAdProd = null;
        }
        float e2 = aq.e(this.mContext);
        Rect a = aq.a(this.mContext);
        int width = a.width();
        int height = a.height();
        RequestParameters requestParameters = this.mParameter;
        if (requestParameters != null && requestParameters.isCustomSize()) {
            if (this.mParameter.getWidth() > 0) {
                width = (int) (this.mParameter.getWidth() * e2);
            }
            if (this.mParameter.getHeight() > 0) {
                height = (int) (this.mParameter.getHeight() * e2);
            }
        }
        int i2 = height;
        int i3 = width;
        if (i3 >= 200.0f * e2 && i2 >= e2 * 150.0f) {
            dg dgVar2 = new dg(this.mContext, this.mAdPlaceId, i3, i2, this.mTipStyle, this.mTimeout, this.mDisplayDownInfo, this.mPopDialogIfDL.booleanValue(), this.mDisplayClickRegion.booleanValue(), this.mLimitRegionClick.booleanValue());
            this.mAdProd = dgVar2;
            dgVar2.a(this.mShakeLogoSize);
            this.mAdProd.g(this.mAppSid);
            dg dgVar3 = this.mAdProd;
            dgVar3.p = this.mBidFloor;
            dgVar3.a = true;
            RequestParameters requestParameters2 = this.mParameter;
            if (requestParameters2 != null) {
                dgVar3.a(requestParameters2);
            }
            this.mAdProd.a(this.mListener);
            this.mFetchNotShow = true;
            this.mAdProd.a(this.mDownloadDialogListener);
            this.mAdProd.a();
            return;
        }
        bj.a().c(ct.a().a(bf.SHOW_STANDARD_UNFIT, "开屏显示区域太小,宽度至少200dp,高度至少150dp"));
        SplashAdListener splashAdListener = this.mListener;
        if (splashAdListener == null || !(splashAdListener instanceof SplashInteractionListener)) {
            return;
        }
        ((SplashInteractionListener) splashAdListener).onAdDismissed();
    }

    public void loadAndShow(ViewGroup viewGroup) {
        if (viewGroup == null) {
            SplashAdListener splashAdListener = this.mListener;
            if (splashAdListener != null) {
                splashAdListener.onAdFailed("传入容器不可以为空");
            }
        } else if (this.mIsAdaptiveSplashAd) {
            SplashAdListener splashAdListener2 = this.mListener;
            if (splashAdListener2 != null) {
                splashAdListener2.onAdFailed("使用自适应开屏广告能力, 需要使用showWithBottomView方法并传入合适尺寸的底部logo");
            }
        } else {
            addZeroPxSurfaceViewAvoidBlink(viewGroup, this.mContext);
            final ch chVar = new ch(this.mContext);
            chVar.a(new ch.a() { // from class: com.baidu.mobads.sdk.api.SplashAd.3
                {
                    SplashAd.this = this;
                }

                @Override // com.baidu.mobads.sdk.internal.ch.a
                public void onAttachedToWindow() {
                    if (SplashAd.this.mAdProd != null) {
                        SplashAd.this.mAdProd.o();
                    }
                }

                @Override // com.baidu.mobads.sdk.internal.ch.a
                public void onDetachedFromWindow() {
                    if (SplashAd.this.mAdProd != null) {
                        SplashAd.this.mAdProd.p();
                    }
                }

                @Override // com.baidu.mobads.sdk.internal.ch.a
                public boolean onKeyDown(int i2, KeyEvent keyEvent) {
                    return false;
                }

                @Override // com.baidu.mobads.sdk.internal.ch.a
                public void onLayoutComplete(int i2, int i3) {
                    if (SplashAd.this.mAdProd != null) {
                        return;
                    }
                    float e2 = aq.e(SplashAd.this.mContext);
                    if (SplashAd.this.mParameter != null && SplashAd.this.mParameter.isCustomSize()) {
                        if (SplashAd.this.mParameter.getWidth() > 0) {
                            i2 = (int) (SplashAd.this.mParameter.getWidth() * e2);
                        }
                        if (SplashAd.this.mParameter.getHeight() > 0) {
                            i3 = (int) (SplashAd.this.mParameter.getHeight() * e2);
                        }
                    }
                    int i4 = i2;
                    int i5 = i3;
                    if (i4 >= 200.0f * e2 && i5 >= e2 * 150.0f) {
                        SplashAd.this.mAdProd = new dg(SplashAd.this.mContext, SplashAd.this.mAdPlaceId, i4, i5, SplashAd.this.mTipStyle, SplashAd.this.mTimeout, SplashAd.this.mDisplayDownInfo, SplashAd.this.mPopDialogIfDL.booleanValue(), SplashAd.this.mDisplayClickRegion.booleanValue(), SplashAd.this.mLimitRegionClick.booleanValue());
                        SplashAd.this.mAdProd.a(chVar);
                        SplashAd.this.mAdProd.a(SplashAd.this.mShakeLogoSize);
                        SplashAd.this.mAdProd.g(SplashAd.this.mAppSid);
                        SplashAd.this.mAdProd.p = SplashAd.this.mBidFloor;
                        SplashAd.this.mAdProd.a(SplashAd.this.mListener);
                        if (SplashAd.this.mParameter != null) {
                            SplashAd.this.mAdProd.a(SplashAd.this.mParameter);
                        }
                        SplashAd.this.mAdProd.a = false;
                        SplashAd.this.mAdProd.a(SplashAd.this.mDownloadDialogListener);
                        SplashAd.this.mAdProd.a();
                        return;
                    }
                    bj.a().c(ct.a().a(bf.SHOW_STANDARD_UNFIT, "开屏显示区域太小,宽度至少200dp,高度至少150dp"));
                    if (SplashAd.this.mListener == null || !(SplashAd.this.mListener instanceof SplashInteractionListener)) {
                        return;
                    }
                    ((SplashInteractionListener) SplashAd.this.mListener).onAdDismissed();
                }

                @Override // com.baidu.mobads.sdk.internal.ch.a
                public void onWindowFocusChanged(boolean z) {
                    if (SplashAd.this.mAdProd != null) {
                        SplashAd.this.mAdProd.a(z);
                    }
                }

                @Override // com.baidu.mobads.sdk.internal.ch.a
                public void onWindowVisibilityChanged(int i2) {
                    if (SplashAd.this.mAdProd != null) {
                        SplashAd.this.mAdProd.b(i2);
                    }
                }
            });
            chVar.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            viewGroup.addView(chVar);
        }
    }

    public void loadBiddingAd(String str) {
        dg dgVar = this.mAdProd;
        if (dgVar != null) {
            dgVar.c(str);
        }
    }

    public void setAppSid(String str) {
        this.mAppSid = str;
    }

    public void setBidFloor(int i2) {
        this.mBidFloor = i2;
    }

    @Deprecated
    public void setBiddingData(String str) {
        dg dgVar = this.mAdProd;
        if (dgVar != null) {
            dgVar.b(str);
        }
    }

    public void setDownloadDialogListener(SplashAdDownloadDialogListener splashAdDownloadDialogListener) {
        this.mDownloadDialogListener = splashAdDownloadDialogListener;
        dg dgVar = this.mAdProd;
        if (dgVar != null) {
            dgVar.a(splashAdDownloadDialogListener);
        }
    }

    public void setListener(SplashAdListener splashAdListener) {
        this.mListener = splashAdListener;
        dg dgVar = this.mAdProd;
        if (dgVar != null) {
            dgVar.a(splashAdListener);
        }
    }

    public final void show(ViewGroup viewGroup) {
        showWithBottomView(viewGroup, null);
    }

    public SplashAd(Context context, String str, RequestParameters requestParameters, SplashAdListener splashAdListener) {
        this.mTipStyle = 4;
        this.mFetchAd = true;
        this.mFetchNotShow = false;
        this.mDisplayDownInfo = true;
        this.mPopDialogIfDL = Boolean.FALSE;
        Boolean bool = Boolean.TRUE;
        this.mLimitRegionClick = bool;
        this.mDisplayClickRegion = bool;
        this.mTimeout = RT_SPLASH_LOAD_AD_TIMEOUT;
        this.mShakeLogoSize = 60;
        this.mIsAdaptiveSplashAd = false;
        this.mBidFloor = -1;
        this.mListener = new SplashInteractionListener() { // from class: com.baidu.mobads.sdk.api.SplashAd.1
            {
                SplashAd.this = this;
            }

            @Override // com.baidu.mobads.sdk.api.SplashAdListener
            public void onADLoaded() {
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onAdCacheFailed() {
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onAdCacheSuccess() {
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onAdClick() {
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onAdDismissed() {
            }

            @Override // com.baidu.mobads.sdk.api.SplashAdListener
            public void onAdFailed(String str2) {
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onAdPresent() {
            }

            @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
            public void onLpClosed() {
            }
        };
        this.mContext = context;
        this.mAdPlaceId = str;
        if (splashAdListener != null) {
            this.mListener = splashAdListener;
        }
        if (TextUtils.isEmpty(str)) {
            this.mListener.onAdFailed("请您输入正确的广告位ID");
            return;
        }
        this.mParameter = requestParameters;
        if (requestParameters == null || requestParameters.getExtras() == null) {
            return;
        }
        String str2 = this.mParameter.getExtras().get(KEY_FETCHAD);
        if (!TextUtils.isEmpty(str2)) {
            this.mFetchAd = Boolean.parseBoolean(str2);
        }
        String str3 = this.mParameter.getExtras().get(KEY_DISPLAY_DOWNLOADINFO);
        if (!TextUtils.isEmpty(str3)) {
            this.mDisplayDownInfo = Boolean.parseBoolean(str3);
        }
        String str4 = this.mParameter.getExtras().get(KEY_POPDIALOG_DOWNLOAD);
        if (!TextUtils.isEmpty(str4)) {
            this.mPopDialogIfDL = Boolean.valueOf(str4);
        }
        String str5 = this.mParameter.getExtras().get(KEY_SHAKE_LOGO_SIZE);
        if (!TextUtils.isEmpty(str5)) {
            this.mShakeLogoSize = Integer.parseInt(str5);
        }
        String str6 = this.mParameter.getExtras().get("timeout");
        if (!TextUtils.isEmpty(str6)) {
            this.mTimeout = Integer.parseInt(str6);
        }
        String str7 = this.mParameter.getExtras().get(KEY_USE_ADAPTIVE_AD);
        if (TextUtils.isEmpty(str7)) {
            return;
        }
        this.mIsAdaptiveSplashAd = Boolean.parseBoolean(str7);
    }

    public static void registerEnterTransition(Activity activity, SplashFocusParams splashFocusParams, SplashFocusAdListener splashFocusAdListener) {
        dg.a(activity, splashFocusParams != null ? splashFocusParams.getFocusParams() : null, splashFocusAdListener);
    }

    public void finishAndJump(Intent intent, OnFinishListener onFinishListener) {
        dg dgVar = this.mAdProd;
        if (dgVar != null) {
            dgVar.a(intent, onFinishListener);
        }
    }

    public static void registerEnterTransition(Activity activity, int i2, int i3, SplashFocusAdListener splashFocusAdListener) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("right_margin", i2);
            jSONObject.put("bottom_margin", i3);
        } catch (JSONException e2) {
            bj.a().a(e2);
        }
        dg.a(activity, jSONObject, splashFocusAdListener);
    }

    @Deprecated
    public static void registerEnterTransition(Activity activity, int i2, int i3, int i4, SplashFocusAdListener splashFocusAdListener) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("right_margin", i2);
            jSONObject.put("bottom_margin", i3);
            jSONObject.put("anim_offset_y", i4);
        } catch (JSONException e2) {
            bj.a().a(e2);
        }
        dg.a(activity, jSONObject, splashFocusAdListener);
    }
}
