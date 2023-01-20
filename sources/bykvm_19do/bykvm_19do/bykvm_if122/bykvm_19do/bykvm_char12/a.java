package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_char12;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.k;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.l;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.m;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.g;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.o;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.t;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.GMAdEcpmInfo;
import com.bytedance.msdk.api.v2.GMAdDislike;
import com.bytedance.msdk.api.v2.GMDislikeCallback;
import com.bytedance.msdk.api.v2.GMNetworkPlatformConst;
import com.bytedance.msdk.api.v2.ad.GMAdAppDownloadListener;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAdAppInfo;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAdListener;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeCustomVideoReporter;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeExpressAdListener;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMViewBinder;
import com.bytedance.msdk.base.TTBaseAd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class a implements GMNativeAd, GMVideoListener, GMAdAppDownloadListener {
    private TTBaseAd a;
    private AdSlot b;

    /* renamed from: c  reason: collision with root package name */
    private GMNativeAdListener f788c;

    /* renamed from: d  reason: collision with root package name */
    private c f789d;

    /* renamed from: e  reason: collision with root package name */
    private GMVideoListener f790e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f791f = false;

    /* renamed from: g  reason: collision with root package name */
    private GMAdAppDownloadListener f792g;

    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_char12.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0034a implements GMNativeExpressAdListener {
        public C0034a() {
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAdListener
        public void onAdClick() {
            if (a.this.f788c != null) {
                a.this.f788c.onAdClick();
            }
            h.a(a.this.a, a.this.b, 0, t.a(a.this.a) ? t.b(Thread.currentThread().getStackTrace()) : null, a.this.a.isClickListenRepeatOnce());
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAdListener
        public void onAdShow() {
            a.this.f791f = true;
            if (a.this.f788c != null) {
                a.this.f788c.onAdShow();
            }
            if (a.this.b != null && a.this.a != null) {
                Logger.d("TTMediationSDK", TTLogUtil.getTagThirdLevelByEvent(a.this.b.getAdUnitId(), TTLogUtil.TAG_EVENT_SHOW_LISTEN) + "adSlotId：" + a.this.a.getAdNetworkSlotId() + "，广告类型：" + e.c.c.a.a.b(a.this.a.getAdNetworkPlatformId()));
                m b = m.b();
                StringBuilder sb = new StringBuilder();
                sb.append(a.this.b.getAdUnitId());
                sb.append("");
                b.a(sb.toString());
                m b2 = m.b();
                b2.j(a.this.b.getAdUnitId() + "");
                k b3 = k.b();
                b3.a(a.this.b.getAdUnitId() + "", a.this.a.getAdNetworkSlotId());
                l b4 = l.b();
                b4.e(a.this.b.getAdUnitId() + "", a.this.a.getAdNetworkSlotId());
            }
            a.this.f789d.a(a.this);
            String b5 = t.a(a.this.a) ? t.b(Thread.currentThread().getStackTrace()) : null;
            boolean isShowListenRepeatOnce = a.this.a.isShowListenRepeatOnce();
            if (!isShowListenRepeatOnce) {
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.b.c().b(a.this.a.getAdType(), a.this.a.getCpm());
            }
            h.b(a.this.a, a.this.b, 0, b5, isShowListenRepeatOnce);
            g.b(a.this.b != null ? a.this.b.getAdUnitId() : "", a.this.a);
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeExpressAdListener
        public void onRenderFail(View view, String str, int i2) {
            if (a.this.f788c instanceof GMNativeExpressAdListener) {
                ((GMNativeExpressAdListener) a.this.f788c).onRenderFail(view, str, i2);
            }
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeExpressAdListener
        public void onRenderSuccess(float f2, float f3) {
            if (a.this.f788c instanceof GMNativeExpressAdListener) {
                ((GMNativeExpressAdListener) a.this.f788c).onRenderSuccess(f2, f3);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements GMNativeAdListener {
        public b() {
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAdListener
        public void onAdClick() {
            if (a.this.f788c != null) {
                a.this.f788c.onAdClick();
            }
            h.a(a.this.a, a.this.b, 0, t.a(a.this.a) ? t.b(Thread.currentThread().getStackTrace()) : null, a.this.a.isClickListenRepeatOnce());
        }

        @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAdListener
        public void onAdShow() {
            a.this.f791f = true;
            if (a.this.f788c != null) {
                a.this.f788c.onAdShow();
            }
            if (a.this.b != null && a.this.a != null) {
                Logger.d("TTMediationSDK", TTLogUtil.getTagThirdLevelByEvent(a.this.b.getAdUnitId(), TTLogUtil.TAG_EVENT_SHOW_LISTEN) + "adSlotId：" + a.this.a.getAdNetworkSlotId() + "，广告类型：" + e.c.c.a.a.b(a.this.a.getAdNetworkPlatformId()));
                m b = m.b();
                StringBuilder sb = new StringBuilder();
                sb.append(a.this.b.getAdUnitId());
                sb.append("");
                b.a(sb.toString());
                m b2 = m.b();
                b2.j(a.this.b.getAdUnitId() + "");
                k b3 = k.b();
                b3.a(a.this.b.getAdUnitId() + "", a.this.a.getAdNetworkSlotId());
                l b4 = l.b();
                b4.e(a.this.b.getAdUnitId() + "", a.this.a.getAdNetworkSlotId());
            }
            a.this.f789d.a(a.this);
            String b5 = t.a(a.this.a) ? t.b(Thread.currentThread().getStackTrace()) : null;
            boolean isShowListenRepeatOnce = a.this.a.isShowListenRepeatOnce();
            if (!isShowListenRepeatOnce) {
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.b.c().b(a.this.a.getAdType(), a.this.a.getCpm());
            }
            h.b(a.this.a, a.this.b, 0, b5, isShowListenRepeatOnce);
            g.b(a.this.b != null ? a.this.b.getAdUnitId() : "", a.this.a);
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void a();

        void a(GMNativeAd gMNativeAd);
    }

    public a(TTBaseAd tTBaseAd, AdSlot adSlot, c cVar) {
        this.a = tTBaseAd;
        this.b = adSlot;
        this.f789d = cVar;
    }

    private void a() {
        TTBaseAd tTBaseAd;
        GMNativeAdListener bVar;
        if (this.a.isExpressAd()) {
            tTBaseAd = this.a;
            bVar = new C0034a();
        } else {
            tTBaseAd = this.a;
            bVar = new b();
        }
        tTBaseAd.setTTNativeAdListener(bVar);
    }

    public void a(TTBaseAd tTBaseAd) {
        if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().t()) {
            h.a(tTBaseAd, this.b, t.a(Thread.currentThread().getStackTrace()), 2);
        }
    }

    public void a(boolean z) {
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd != null) {
            tTBaseAd.setHasShown(z);
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
    public boolean canAdReuse() {
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd != null) {
            return tTBaseAd.canAdReuse();
        }
        return false;
    }

    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
    public void cancelDownload() {
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd != null) {
            tTBaseAd.cancelDownload();
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
    public void destroy() {
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd != null) {
            try {
                tTBaseAd.onDestroy();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
    public void dislikeClick(String str, Map<String, Object> map) {
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd != null) {
            h.a(tTBaseAd, this.b, str);
            this.a.dislikeClick(str, map);
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
    public String getActionText() {
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd != null) {
            return tTBaseAd.getActionText();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
    public int getAdImageMode() {
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd != null) {
            return tTBaseAd.getImageMode();
        }
        return -1;
    }

    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
    @Deprecated
    public View getAdLogoView() {
        return null;
    }

    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
    public int getAdNetworkPlatformId() {
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd != null) {
            return tTBaseAd.getAdNetworkPlatformId();
        }
        return -2;
    }

    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
    public String getAdNetworkPlatformName() {
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd != null) {
            return tTBaseAd.getAdNetWorkName();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
    public String getAdNetworkRitId() {
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd != null) {
            return tTBaseAd.getAdNetworkSlotId();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
    @Nullable
    public GMAdEcpmInfo getBestEcpm() {
        if (this.a != null && bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().p()) {
            return o.a(this.a, false);
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
    public String getDescription() {
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd != null) {
            return tTBaseAd.getAdDescription();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
    public GMAdDislike getDislikeDialog(Activity activity) {
        return getDislikeDialog(activity, null);
    }

    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
    public GMAdDislike getDislikeDialog(Activity activity, Map<String, Object> map) {
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd != null) {
            return tTBaseAd.getDislikeDialog(activity, map);
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
    public int getDownloadStatus() {
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd != null) {
            return tTBaseAd.getDownloadStatus();
        }
        return -1;
    }

    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
    public View getExpressView() {
        h.b(this.b, o.a(this.a));
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd == null || !tTBaseAd.isExpressAd()) {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.a);
            h.a(arrayList, this.b);
            return null;
        }
        c cVar = this.f789d;
        if (cVar != null) {
            cVar.a();
        }
        TTBaseAd tTBaseAd2 = this.a;
        h.a(tTBaseAd2, this.b, tTBaseAd2.isShowRepeatOnce());
        return this.a.getAdView();
    }

    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
    public Map<String, Object> getExtraMsg() {
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd != null) {
            return tTBaseAd.getExtraMsg();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
    @Nullable
    public GMNativeCustomVideoReporter getGMNativeCustomVideoReporter() {
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd != null) {
            return tTBaseAd.getGMNativeCustomVideoReporter();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
    public String getIconUrl() {
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd != null) {
            return tTBaseAd.getIconUrl();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
    public int getImageHeight() {
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd != null) {
            return tTBaseAd.getImageHeight();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
    public List<String> getImageList() {
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd != null) {
            return tTBaseAd.getImages();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
    public String getImageUrl() {
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd != null) {
            return tTBaseAd.getImageUrl();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
    public int getImageWidth() {
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd != null) {
            return tTBaseAd.getImageWidth();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
    public int getInteractionType() {
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd != null) {
            return tTBaseAd.getInteractionType();
        }
        return -1;
    }

    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
    public Map<String, Object> getMediaExtraInfo() {
        TTBaseAd tTBaseAd = this.a;
        return tTBaseAd != null ? tTBaseAd.getMediaExtraInfo() : new HashMap();
    }

    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
    public GMNativeAdAppInfo getNativeAdAppInfo() {
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd == null || !tTBaseAd.hasAppInfo()) {
            return null;
        }
        GMNativeAdAppInfo gMNativeAdAppInfo = new GMNativeAdAppInfo();
        gMNativeAdAppInfo.setAppName(this.a.getAppName());
        gMNativeAdAppInfo.setAuthorName(this.a.getAuthorName());
        gMNativeAdAppInfo.setPackageSizeBytes(this.a.getPackageSizeBytes());
        gMNativeAdAppInfo.setPermissionsUrl(this.a.getPermissionsUrl());
        gMNativeAdAppInfo.setPrivacyAgreement(this.a.getPrivacyAgreement());
        gMNativeAdAppInfo.setVersionName(this.a.getVersionName());
        gMNativeAdAppInfo.setPermissionsMap(this.a.getPermissionsMap());
        gMNativeAdAppInfo.setAppInfoExtra(this.a.getAppInfoExtra());
        return gMNativeAdAppInfo;
    }

    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
    public String getPackageName() {
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd != null) {
            return tTBaseAd.getPackageName();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
    public String getPreEcpm() {
        if (this.a == null || !this.f791f) {
            return null;
        }
        return (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().r() || !(this.a.isServerBiddingAd() || this.a.isClientBiddingAd() || this.a.isMultiBiddingAd())) ? this.a.getNetWorkPlatFormCpm() : GMNetworkPlatformConst.AD_NETWORK_NO_PERMISSION;
    }

    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
    public int getSdkNumType() {
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd != null) {
            return tTBaseAd.getAdNetworkPlatformId();
        }
        return -1;
    }

    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
    @Nullable
    public GMAdEcpmInfo getShowEcpm() {
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd == null || !this.f791f) {
            return null;
        }
        return o.a(tTBaseAd, true);
    }

    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
    public String getSource() {
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd != null) {
            return tTBaseAd.getSource();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
    public double getStarRating() {
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd != null) {
            return tTBaseAd.getStarRating();
        }
        return 0.0d;
    }

    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
    public TTBaseAd getTTBaseAd() {
        return this.a;
    }

    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
    public String getTitle() {
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd != null) {
            return tTBaseAd.getAdTitle();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
    public int getVideoHeight() {
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd != null) {
            return tTBaseAd.getVideoHeight();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
    public String getVideoUrl() {
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd != null) {
            return tTBaseAd.getVideoUrl();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
    public int getVideoWidth() {
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd != null) {
            return tTBaseAd.getVideoWidth();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
    public boolean hasDislike() {
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd != null) {
            return tTBaseAd.hasDislike();
        }
        return false;
    }

    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
    public boolean isExpressAd() {
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd != null) {
            return tTBaseAd.isExpressAd();
        }
        return false;
    }

    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
    public boolean isHasShown() {
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd != null) {
            return tTBaseAd.isHasShown();
        }
        return true;
    }

    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
    public boolean isReady() {
        AdSlot adSlot;
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.a);
        h.a(arrayList, (List<TTBaseAd>) null, (List<TTBaseAd>) null, this.b, o.a(this.a));
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd == null || (adSlot = this.b) == null) {
            return false;
        }
        return tTBaseAd.isReady(adSlot.getAdUnitId());
    }

    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
    public boolean isServerBidding() {
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd != null) {
            return tTBaseAd.isServerBiddingAd();
        }
        return false;
    }

    @Override // com.bytedance.msdk.api.v2.ad.GMAdAppDownloadListener
    public void onDownloadFailed(long j2, long j3, String str, String str2) {
        GMAdAppDownloadListener gMAdAppDownloadListener = this.f792g;
        if (gMAdAppDownloadListener != null) {
            gMAdAppDownloadListener.onDownloadFailed(j2, j3, str, str2);
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.GMAdAppDownloadListener
    public void onDownloadFinished(long j2, String str, String str2) {
        GMAdAppDownloadListener gMAdAppDownloadListener = this.f792g;
        if (gMAdAppDownloadListener != null) {
            gMAdAppDownloadListener.onDownloadFinished(j2, str, str2);
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.GMAdAppDownloadListener
    public void onDownloadPaused(long j2, long j3, String str, String str2) {
        GMAdAppDownloadListener gMAdAppDownloadListener = this.f792g;
        if (gMAdAppDownloadListener != null) {
            gMAdAppDownloadListener.onDownloadPaused(j2, j3, str, str2);
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.GMAdAppDownloadListener
    public void onDownloadProgress(long j2, long j3, int i2, int i3) {
        GMAdAppDownloadListener gMAdAppDownloadListener = this.f792g;
        if (gMAdAppDownloadListener != null) {
            gMAdAppDownloadListener.onDownloadProgress(j2, j3, i2, i3);
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.GMAdAppDownloadListener
    public void onDownloadStarted() {
        GMAdAppDownloadListener gMAdAppDownloadListener = this.f792g;
        if (gMAdAppDownloadListener != null) {
            gMAdAppDownloadListener.onDownloadStarted();
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.GMAdAppDownloadListener
    public void onIdle() {
        GMAdAppDownloadListener gMAdAppDownloadListener = this.f792g;
        if (gMAdAppDownloadListener != null) {
            gMAdAppDownloadListener.onIdle();
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.GMAdAppDownloadListener
    public void onInstalled(String str, String str2) {
        GMAdAppDownloadListener gMAdAppDownloadListener = this.f792g;
        if (gMAdAppDownloadListener != null) {
            gMAdAppDownloadListener.onInstalled(str, str2);
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
    public void onPause() {
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd != null) {
            tTBaseAd.onPause();
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener
    public void onProgressUpdate(long j2, long j3) {
        GMVideoListener gMVideoListener = this.f790e;
        if (gMVideoListener != null) {
            gMVideoListener.onProgressUpdate(j2, j3);
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener
    public void onVideoCompleted() {
        GMVideoListener gMVideoListener = this.f790e;
        if (gMVideoListener != null) {
            gMVideoListener.onVideoCompleted();
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener
    public void onVideoError(AdError adError) {
        h.a(this.a, this.b, (AdError) null, 2, 0, t.a(this.a) ? t.b(Thread.currentThread().getStackTrace()) : null);
        GMVideoListener gMVideoListener = this.f790e;
        if (gMVideoListener != null) {
            gMVideoListener.onVideoError(adError);
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener
    public void onVideoPause() {
        GMVideoListener gMVideoListener = this.f790e;
        if (gMVideoListener != null) {
            gMVideoListener.onVideoPause();
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener
    public void onVideoResume() {
        GMVideoListener gMVideoListener = this.f790e;
        if (gMVideoListener != null) {
            gMVideoListener.onVideoResume();
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMVideoListener
    public void onVideoStart() {
        GMVideoListener gMVideoListener = this.f790e;
        if (gMVideoListener != null) {
            gMVideoListener.onVideoStart();
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
    public void pauseAppDownload() {
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd != null) {
            tTBaseAd.pauseAppDownload();
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
    public void registerView(@NonNull Activity activity, @NonNull ViewGroup viewGroup, @NonNull List<View> list, @Nullable List<View> list2, GMViewBinder gMViewBinder) {
        h.b(this.b, o.a(this.a));
        if (this.a == null) {
            h.a((List<TTBaseAd>) null, this.b);
            return;
        }
        a();
        this.a.registerViewForInteraction(activity, viewGroup, list, list2, null, gMViewBinder);
        c cVar = this.f789d;
        if (cVar != null) {
            cVar.a();
        }
        a(this.a);
        TTBaseAd tTBaseAd = this.a;
        h.a(tTBaseAd, this.b, tTBaseAd.isShowRepeatOnce());
    }

    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
    public void registerView(@NonNull Activity activity, @NonNull ViewGroup viewGroup, @NonNull List<View> list, @Nullable List<View> list2, @Nullable List<View> list3, GMViewBinder gMViewBinder) {
        h.b(this.b, o.a(this.a));
        if (this.a == null) {
            h.a((List<TTBaseAd>) null, this.b);
            return;
        }
        a();
        this.a.registerViewForInteraction(activity, viewGroup, list, list2, list3, gMViewBinder);
        c cVar = this.f789d;
        if (cVar != null) {
            cVar.a();
        }
        a(this.a);
        TTBaseAd tTBaseAd = this.a;
        h.a(tTBaseAd, this.b, tTBaseAd.isShowRepeatOnce());
    }

    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
    public void registerView(@NonNull ViewGroup viewGroup, @NonNull List<View> list, @Nullable List<View> list2, GMViewBinder gMViewBinder) {
        h.b(this.b, o.a(this.a));
        if (this.a == null) {
            h.a((List<TTBaseAd>) null, this.b);
            return;
        }
        a();
        this.a.registerViewForInteraction(viewGroup, list, list2, gMViewBinder);
        c cVar = this.f789d;
        if (cVar != null) {
            cVar.a();
        }
        a(this.a);
        TTBaseAd tTBaseAd = this.a;
        h.a(tTBaseAd, this.b, tTBaseAd.isShowRepeatOnce());
    }

    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
    public void render() {
        if (this.a != null) {
            a();
            this.a.render();
            a(this.a);
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
    public void resume() {
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd != null) {
            tTBaseAd.onResume();
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
    public void resumeAppDownload() {
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd != null) {
            tTBaseAd.resumeAppDownload();
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
    public void setAppDownloadListener(GMAdAppDownloadListener gMAdAppDownloadListener) {
        this.f792g = gMAdAppDownloadListener;
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd != null) {
            tTBaseAd.setTTAdAppDownloadListener(this);
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
    public void setDislikeCallback(Activity activity, GMDislikeCallback gMDislikeCallback) {
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd != null) {
            tTBaseAd.setDislikeCallback(activity, gMDislikeCallback);
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
    public void setNativeAdListener(GMNativeAdListener gMNativeAdListener) {
        this.f788c = gMNativeAdListener;
    }

    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
    public void setUseCustomVideo(boolean z) {
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd != null) {
            tTBaseAd.setUseCustomVideo(z);
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
    public void setVideoListener(GMVideoListener gMVideoListener) {
        this.f790e = gMVideoListener;
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd != null) {
            tTBaseAd.setTTVideoListener(this);
        }
    }

    @Override // com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAd
    public void unregisterView() {
        TTBaseAd tTBaseAd = this.a;
        if (tTBaseAd != null) {
            tTBaseAd.unregisterView();
        }
    }
}
