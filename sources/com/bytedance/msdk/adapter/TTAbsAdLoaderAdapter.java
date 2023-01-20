package com.bytedance.msdk.adapter;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.c;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.d;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.h;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.i;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.f0;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.g0;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.t;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.y;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.UIUtils;
import com.bytedance.msdk.api.v2.ad.custom.base.GMCustomAd;
import com.bytedance.msdk.api.v2.slot.GMAdSlotBase;
import com.bytedance.msdk.base.TTBaseAd;
import e.c.c.a.a;
import e.c.c.a.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class TTAbsAdLoaderAdapter {

    /* renamed from: c  reason: collision with root package name */
    private AdapterLoaderListener f1745c;

    /* renamed from: d  reason: collision with root package name */
    private j f1746d;

    /* renamed from: e  reason: collision with root package name */
    private String f1747e;

    /* renamed from: f  reason: collision with root package name */
    private int f1748f;

    /* renamed from: g  reason: collision with root package name */
    private int f1749g;

    /* renamed from: h  reason: collision with root package name */
    private double f1750h;

    /* renamed from: i  reason: collision with root package name */
    private String f1751i;

    /* renamed from: j  reason: collision with root package name */
    private String f1752j;

    /* renamed from: k  reason: collision with root package name */
    private long f1753k;

    /* renamed from: l  reason: collision with root package name */
    private long f1754l;

    /* renamed from: m  reason: collision with root package name */
    private int f1755m;
    public AdSlot mAdSlot;
    public GMAdSlotBase mGMAdSlotBase;
    public i mTTExtraModel;
    public String mWaterfallAbTestParam;
    private int n;
    private int o;
    private h p;
    private int q;
    private int r;
    private String s;
    private boolean t;
    private int u;
    private int v;
    private boolean w;
    private int x;
    private boolean a = false;
    private boolean b = false;
    private volatile long y = -1;

    /* loaded from: classes.dex */
    public interface AdapterLoaderListener {
        void onAdFailed(AdError adError, d dVar);

        void onAdLoaded(TTBaseAd tTBaseAd, d dVar);

        void onAdLoaded(List<TTBaseAd> list, d dVar);

        void onAdVideoCache();
    }

    /* loaded from: classes.dex */
    public class CallBackRunnable implements Runnable {
        private String a;
        private TTBaseAd b;

        /* renamed from: c  reason: collision with root package name */
        private List<TTBaseAd> f1757c;

        /* renamed from: d  reason: collision with root package name */
        private AdError f1758d;

        /* renamed from: e  reason: collision with root package name */
        private String f1759e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f1760f;

        public CallBackRunnable(String str, TTBaseAd tTBaseAd, List<TTBaseAd> list, AdError adError, String str2, boolean z) {
            this.a = str;
            this.b = tTBaseAd;
            this.f1757c = list;
            this.f1758d = adError;
            this.f1759e = str2;
            this.f1760f = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            TTBaseAd tTBaseAd;
            String str;
            String str2;
            StringBuilder sb;
            String str3;
            if (TTAbsAdLoaderAdapter.this.f1745c != null) {
                d dVar = new d();
                dVar.a(TTAbsAdLoaderAdapter.this.mAdSlot.getAdType()).e(TTAbsAdLoaderAdapter.this.u).b(TTAbsAdLoaderAdapter.this.r).c(TTAbsAdLoaderAdapter.this.f1748f).d(TTAbsAdLoaderAdapter.this.f1749g).a(TTAbsAdLoaderAdapter.this.getAdNetWorkName()).c(TTAbsAdLoaderAdapter.this.getCustomAdNetWorkName()).b(TTAbsAdLoaderAdapter.this.s);
                TTBaseAd tTBaseAd2 = null;
                if ("adload_ads".equals(this.a) || "adload_ad".equals(this.a)) {
                    if ("adload_ads".equals(this.a)) {
                        List<TTBaseAd> list = this.f1757c;
                        int size = list != null ? list.size() : 0;
                        List<TTBaseAd> list2 = this.f1757c;
                        if (list2 != null && list2.size() > 0) {
                            r3 = AdError.ERROR_CODE_AD_LOAD_SUCCESS;
                        }
                        for (TTBaseAd tTBaseAd3 : this.f1757c) {
                            if (tTBaseAd3 != null) {
                                TTAbsAdLoaderAdapter.this.q(tTBaseAd3);
                                if (tTBaseAd2 == null) {
                                    tTBaseAd2 = tTBaseAd3;
                                }
                            }
                        }
                        if (TTAbsAdLoaderAdapter.this.isClientBidding() || TTAbsAdLoaderAdapter.this.isMultiBidding() || TTAbsAdLoaderAdapter.this.isServerBidding()) {
                            for (TTBaseAd tTBaseAd4 : this.f1757c) {
                                if (tTBaseAd4 != null) {
                                    TTAbsAdLoaderAdapter.this.h(r3, tTBaseAd4, 1, this.f1759e);
                                }
                            }
                        } else {
                            TTAbsAdLoaderAdapter.this.h(r3, tTBaseAd2, size, this.f1759e);
                        }
                        if (TTAbsAdLoaderAdapter.this.f1745c != null) {
                            TTAbsAdLoaderAdapter.this.f1745c.onAdLoaded(this.f1757c, dVar);
                        }
                        if (!TTAbsAdLoaderAdapter.this.isServerBidding() || f0.b(this.f1757c)) {
                            return;
                        }
                        tTBaseAd = this.f1757c.get(0);
                    } else {
                        TTBaseAd tTBaseAd5 = this.b;
                        r3 = tTBaseAd5 != null ? AdError.ERROR_CODE_AD_LOAD_SUCCESS : 20001;
                        TTAbsAdLoaderAdapter.this.q(tTBaseAd5);
                        TTAbsAdLoaderAdapter.this.h(r3, this.b, 1, this.f1759e);
                        if (TTAbsAdLoaderAdapter.this.f1745c != null) {
                            TTAbsAdLoaderAdapter.this.f1745c.onAdLoaded(this.b, dVar);
                        }
                        if (!TTAbsAdLoaderAdapter.this.isServerBidding()) {
                            return;
                        }
                        tTBaseAd = this.b;
                    }
                    TTAbsAdLoaderAdapter tTAbsAdLoaderAdapter = TTAbsAdLoaderAdapter.this;
                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(tTBaseAd, tTAbsAdLoaderAdapter.mAdSlot, tTAbsAdLoaderAdapter.f1746d, TTAbsAdLoaderAdapter.this.f1754l);
                } else if (!"failed".equals(this.a)) {
                    if ("ad_video_cache".equals(this.a)) {
                        if (this.b == null || !(TTAbsAdLoaderAdapter.this.v == 10 || TTAbsAdLoaderAdapter.this.v == 8 || TTAbsAdLoaderAdapter.this.v == 7)) {
                            Logger.d("TTMediationSDK", TTLogUtil.getTagThirdLevelByEvent(TTAbsAdLoaderAdapter.this.f1747e, TTLogUtil.TAG_EVENT_FILL) + "onAdVideoCache-----ttAd=" + this.b);
                            return;
                        }
                        TTAbsAdLoaderAdapter.this.q(this.b);
                        AdError adError = this.f1758d;
                        if (adError != null && adError.code == 30010 && TTAbsAdLoaderAdapter.this.n()) {
                            ThreadHelper.postDelayOnMSDKThread(new Runnable() { // from class: com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter.CallBackRunnable.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    CallBackRunnable.this.b.setCacheSuccess(true);
                                    CallBackRunnable callBackRunnable = CallBackRunnable.this;
                                    TTAbsAdLoaderAdapter.this.k(callBackRunnable.b);
                                    if (TTAbsAdLoaderAdapter.this.isServerBidding()) {
                                        TTBaseAd tTBaseAd6 = CallBackRunnable.this.b;
                                        TTAbsAdLoaderAdapter tTAbsAdLoaderAdapter2 = TTAbsAdLoaderAdapter.this;
                                        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(tTBaseAd6, tTAbsAdLoaderAdapter2.mAdSlot, tTAbsAdLoaderAdapter2.f1746d);
                                    }
                                    if (TTAbsAdLoaderAdapter.this.f1745c != null) {
                                        TTAbsAdLoaderAdapter.this.f1745c.onAdVideoCache();
                                    }
                                }
                            }, 1000L);
                            return;
                        }
                        this.b.setCacheSuccess(true);
                        TTAbsAdLoaderAdapter.this.k(this.b);
                        if (TTAbsAdLoaderAdapter.this.isServerBidding()) {
                            TTBaseAd tTBaseAd6 = this.b;
                            TTAbsAdLoaderAdapter tTAbsAdLoaderAdapter2 = TTAbsAdLoaderAdapter.this;
                            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(tTBaseAd6, tTAbsAdLoaderAdapter2.mAdSlot, tTAbsAdLoaderAdapter2.f1746d);
                        }
                        if (TTAbsAdLoaderAdapter.this.f1745c != null) {
                            TTAbsAdLoaderAdapter.this.f1745c.onAdVideoCache();
                        }
                    }
                } else {
                    TTBaseAd tTBaseAd7 = this.b;
                    if (tTBaseAd7 != null) {
                        String valueOf = String.valueOf(tTBaseAd7.getCpm());
                        str2 = this.b.getLevelTag();
                        str = valueOf;
                    } else {
                        str = null;
                        str2 = null;
                    }
                    if (TTAbsAdLoaderAdapter.this.r == 2 || !this.f1760f) {
                        AdError adError2 = this.f1758d;
                        TTAbsAdLoaderAdapter tTAbsAdLoaderAdapter3 = TTAbsAdLoaderAdapter.this;
                        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(adError2, tTAbsAdLoaderAdapter3.mAdSlot, tTAbsAdLoaderAdapter3.f1746d, TTAbsAdLoaderAdapter.this.f1755m, TTAbsAdLoaderAdapter.this.n, TTAbsAdLoaderAdapter.this.o, TTAbsAdLoaderAdapter.this.getSdkVersion(), TTAbsAdLoaderAdapter.this.f1754l);
                    } else {
                        AdError adError3 = this.f1758d;
                        TTAbsAdLoaderAdapter tTAbsAdLoaderAdapter4 = TTAbsAdLoaderAdapter.this;
                        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(adError3, tTAbsAdLoaderAdapter4.mAdSlot, tTAbsAdLoaderAdapter4.f1746d, TTAbsAdLoaderAdapter.this.f1755m, TTAbsAdLoaderAdapter.this.n, TTAbsAdLoaderAdapter.this.o, TTAbsAdLoaderAdapter.this.getSdkVersion(), TTAbsAdLoaderAdapter.this.f1754l, str, str2, this.f1759e);
                    }
                    if (this.f1758d != null) {
                        if (b.f9966c) {
                            sb = new StringBuilder();
                            sb.append(TTLogUtil.getTagThirdLevelByEvent(TTAbsAdLoaderAdapter.this.f1747e, TTLogUtil.TAG_EVENT_FILL_FAIL));
                            sb.append("AdNetWorkName[");
                            sb.append(TTAbsAdLoaderAdapter.this.getAllAdNetWorkName());
                            sb.append("] AdUnitId[");
                            sb.append(TTAbsAdLoaderAdapter.this.s);
                            sb.append("] AdType[");
                            TTAbsAdLoaderAdapter tTAbsAdLoaderAdapter5 = TTAbsAdLoaderAdapter.this;
                            sb.append(tTAbsAdLoaderAdapter5.e(tTAbsAdLoaderAdapter5.mAdSlot, tTAbsAdLoaderAdapter5.getAdNetWorkName(), a.d(TTAbsAdLoaderAdapter.this.mAdSlot.getAdType(), TTAbsAdLoaderAdapter.this.u, TTAbsAdLoaderAdapter.this.f1746d, TTAbsAdLoaderAdapter.this.mAdSlot.getAdStyleType())));
                            sb.append("] 请求失败 (loadSort=");
                            sb.append(TTAbsAdLoaderAdapter.this.f1748f);
                            sb.append(",showSort=");
                            sb.append(TTAbsAdLoaderAdapter.this.f1749g);
                            str3 = "),error=";
                        } else {
                            sb = new StringBuilder();
                            sb.append(TTLogUtil.getTagThirdLevelByEvent(TTAbsAdLoaderAdapter.this.f1747e, TTLogUtil.TAG_EVENT_FILL_FAIL));
                            sb.append("AdNetWorkName[");
                            sb.append(TTAbsAdLoaderAdapter.this.getAllAdNetWorkName());
                            sb.append("] AdType[");
                            TTAbsAdLoaderAdapter tTAbsAdLoaderAdapter6 = TTAbsAdLoaderAdapter.this;
                            sb.append(tTAbsAdLoaderAdapter6.e(tTAbsAdLoaderAdapter6.mAdSlot, tTAbsAdLoaderAdapter6.getAdNetWorkName(), a.d(TTAbsAdLoaderAdapter.this.mAdSlot.getAdType(), TTAbsAdLoaderAdapter.this.u, TTAbsAdLoaderAdapter.this.f1746d, TTAbsAdLoaderAdapter.this.mAdSlot.getAdStyleType())));
                            str3 = "] 请求失败 error=";
                        }
                        sb.append(str3);
                        sb.append(this.f1758d.thirdSdkErrorCode);
                        sb.append(",msg=");
                        sb.append(this.f1758d.thirdSdkErrorMessage);
                        Logger.e("TTMediationSDK", sb.toString());
                        if (TTAbsAdLoaderAdapter.this.f1746d != null) {
                            String str4 = this.f1758d.thirdSdkErrorCode + "";
                            String f2 = TTAbsAdLoaderAdapter.this.f(this.f1758d.thirdSdkErrorMessage);
                            Logger.e("TTMediationSDK", "errorCode = " + str4 + " errorCodeList = " + f2);
                            c a = c.a();
                            String e2 = TTAbsAdLoaderAdapter.this.f1746d.e();
                            String d2 = TTAbsAdLoaderAdapter.this.f1746d.d();
                            TTAbsAdLoaderAdapter tTAbsAdLoaderAdapter7 = TTAbsAdLoaderAdapter.this;
                            a.a(e2, d2, tTAbsAdLoaderAdapter7.g(tTAbsAdLoaderAdapter7.f1746d.e(), str4, f2));
                        }
                    }
                    if (TTAbsAdLoaderAdapter.this.f1745c != null) {
                        TTAbsAdLoaderAdapter.this.f1745c.onAdFailed(this.f1758d, dVar);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String e(AdSlot adSlot, String str, String str2) {
        return adSlot == null ? "" : str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String f(String str) {
        ArrayList<String> arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        char[] charArray = str.toCharArray();
        int i2 = 0;
        while (true) {
            if (i2 >= charArray.length) {
                break;
            }
            char c2 = charArray[i2];
            if (c2 >= '0' && c2 <= '9') {
                sb.append(c2);
                if (i2 == charArray.length - 1) {
                    arrayList.add(sb.toString());
                    break;
                }
            } else if (sb.length() > 0) {
                arrayList.add(sb.toString());
                sb.delete(0, sb.length());
            }
            if (arrayList.size() > 0) {
                return (String) arrayList.get(0);
            }
            i2++;
        }
        StringBuilder sb2 = new StringBuilder();
        for (String str2 : arrayList) {
            sb2.append(str2);
            sb2.append("_");
        }
        if (sb2.length() > 0) {
            sb2.delete(sb2.length() - 1, sb2.length());
        }
        return sb2.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String g(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str3) && str.equals("gdt")) {
            return str2 + "_" + str3;
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i2, TTBaseAd tTBaseAd, int i3, String str) {
        StringBuilder sb;
        String str2;
        String str3 = i2 == 20000 ? AdError.AD_LOAD_SUCCESS_MSG : AdError.ERROR_MEDIA_REQUEST_SUCCESS_NO_ADS_MSG;
        boolean z = this.t;
        if (this.r != 2 && tTBaseAd != null) {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(tTBaseAd, i2, str3, this.f1754l, this.mAdSlot, this.f1755m, i3, z ? 1 : 0, str, this.y != -1 ? SystemClock.elapsedRealtime() - this.y : -1L);
        }
        if (b.f9966c) {
            sb = new StringBuilder();
            sb.append(TTLogUtil.getTagThirdLevelByEvent(this.f1747e, TTLogUtil.TAG_EVENT_FILL));
            sb.append("AdNetWorkName[");
            sb.append(getAllAdNetWorkName());
            sb.append("] AdUnitId[");
            sb.append(this.s);
            sb.append("] AdType[");
            sb.append(e(this.mAdSlot, getAdNetWorkName(), a.d(this.mAdSlot.getAdType(), this.u, this.f1746d, this.mAdSlot.getAdStyleType())));
            sb.append("] 请求成功 (loadSort=");
            sb.append(this.f1748f);
            sb.append(",showSort=");
            sb.append(this.f1749g);
            str2 = ")";
        } else {
            sb = new StringBuilder();
            sb.append(TTLogUtil.getTagThirdLevelByEvent(this.f1747e, TTLogUtil.TAG_EVENT_FILL));
            sb.append("AdNetWorkName[");
            sb.append(getAllAdNetWorkName());
            sb.append("] AdType[");
            sb.append(e(this.mAdSlot, getAdNetWorkName(), a.d(this.mAdSlot.getAdType(), this.u, this.f1746d, this.mAdSlot.getAdStyleType())));
            str2 = "] 请求成功";
        }
        sb.append(str2);
        Logger.i("TTMediationSDK", sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(TTBaseAd tTBaseAd) {
        StringBuilder sb;
        String str;
        if (this.r != 2 && tTBaseAd != null) {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(this.mAdSlot, tTBaseAd, this.f1746d);
        }
        if (b.f9966c) {
            sb = new StringBuilder();
            sb.append(TTLogUtil.getTagThirdLevelByEvent(this.f1747e, TTLogUtil.TAG_EVENT_FILL));
            sb.append("AdNetWorkName[");
            sb.append(getAllAdNetWorkName());
            sb.append("] AdUnitId[");
            sb.append(this.s);
            sb.append("] AdType[");
            sb.append(a.d(this.mAdSlot.getAdType(), this.u, this.f1746d, this.mAdSlot.getAdStyleType()));
            sb.append("] 视频缓存成功 (loadSort=");
            sb.append(this.f1748f);
            sb.append(",showSort=");
            sb.append(this.f1749g);
            str = ")";
        } else {
            sb = new StringBuilder();
            sb.append(TTLogUtil.getTagThirdLevelByEvent(this.f1747e, TTLogUtil.TAG_EVENT_FILL));
            sb.append("AdNetWorkName[");
            sb.append(getAllAdNetWorkName());
            sb.append("] AdType[");
            sb.append(a.d(this.mAdSlot.getAdType(), this.u, this.f1746d, this.mAdSlot.getAdStyleType()));
            str = "] 视频缓存成功 ";
        }
        sb.append(str);
        Logger.i("TTMediationSDK", sb.toString());
    }

    private final void l(TTBaseAd tTBaseAd, AdError adError, boolean z) {
        this.b = true;
        if (this.a) {
            return;
        }
        this.a = true;
        this.f1754l = System.currentTimeMillis() - this.f1753k;
        m("failed", tTBaseAd, null, adError, z);
    }

    private void m(String str, TTBaseAd tTBaseAd, List<TTBaseAd> list, AdError adError, boolean z) {
        ThreadHelper.runOnMSDKThread(new CallBackRunnable(str, tTBaseAd, list, adError, t.a(this.f1746d) ? t.b(Thread.currentThread().getStackTrace()) : null, z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean n() {
        return bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().I() && (y.e(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d()) || y.f(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(TTBaseAd tTBaseAd) {
        j jVar;
        if (tTBaseAd == null) {
            return;
        }
        int i2 = this.r;
        if (i2 == 0 || i2 == 100) {
            double d2 = this.f1750h;
            if (d2 != 0.0d) {
                tTBaseAd.setCpm(d2);
            }
        }
        if (isServerBidding() && (jVar = this.f1746d) != null) {
            tTBaseAd.setServerBiddingShowCpm(jVar.w());
            tTBaseAd.setServerBiddingLoadCpm(this.f1746d.v());
            if (this.f1746d.x() != null) {
                tTBaseAd.setAid(this.f1746d.x().c());
                tTBaseAd.setAdExtra(this.f1746d.x().a());
                tTBaseAd.setWinCallback(this.f1746d.x().j());
                tTBaseAd.setFailCallback(this.f1746d.x().e());
                tTBaseAd.setPricingType(this.f1746d.x().h());
            }
        }
        tTBaseAd.setAdNetworkSlotType(this.r);
        tTBaseAd.setLoadSort(this.f1748f);
        tTBaseAd.setShowSort(this.f1749g);
        tTBaseAd.setSdkVersion(getSdkVersion());
        j jVar2 = this.f1746d;
        tTBaseAd.setAdNetWorkName(jVar2 != null ? jVar2.e() : getAdNetWorkName());
        j jVar3 = this.f1746d;
        tTBaseAd.setCustomAdNetWorkName(jVar3 != null ? jVar3.h() : null);
        tTBaseAd.setExchangeRate(this.f1752j);
        tTBaseAd.setAdNetworkSlotId(this.s);
        tTBaseAd.setRit(this.f1747e);
        tTBaseAd.putEventParam("waterfall_abtest", this.mWaterfallAbTestParam);
        tTBaseAd.setSdkNum(a.a(getAdNetWorkName()));
        tTBaseAd.setMediationRitReqTypeFromRealReq(this.n);
        tTBaseAd.setMediationRitReqTypeSrcFromRealReq(this.o);
        tTBaseAd.setLinkIdFromRealReq(this.f1751i);
        tTBaseAd.setMediationRitReqType(this.n);
        tTBaseAd.setMediationRitReqTypeSrc(this.o);
        j jVar4 = this.f1746d;
        tTBaseAd.setOriginType(jVar4 != null ? jVar4.s() : -1);
        tTBaseAd.setSubAdType(this.u);
        tTBaseAd.setAdType(this.v);
        g0.a(tTBaseAd, this.f1746d, this.mAdSlot, false);
        i iVar = this.mTTExtraModel;
        if (iVar != null) {
            int i3 = iVar.b;
            tTBaseAd.putEventParam("if_test", Integer.valueOf(i3 == 1 ? i3 : 0));
            tTBaseAd.putEventParam("server_bidding_extra", this.mTTExtraModel.a);
        }
        h hVar = this.p;
        if (hVar == null || hVar.d() == null) {
            return;
        }
        tTBaseAd.putExtraMsg("extra_data_and_no_parse", this.p.d());
    }

    public abstract void destroy();

    public final int getAdLoadCount() {
        return this.q;
    }

    public abstract String getAdNetWorkName();

    public final String getAdSlotId() {
        return this.s;
    }

    public String getAdapterRit() {
        return this.f1747e;
    }

    public final String getAdm() {
        h hVar;
        if (isServerBidding() && (hVar = this.p) != null) {
            return hVar.b();
        }
        return null;
    }

    public String getAllAdNetWorkName() {
        if (this.f1746d == null || !bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().g(this.f1746d.e())) {
            return getAdNetWorkName();
        }
        return this.f1746d.h() + "_" + this.f1746d.e();
    }

    public String getBiddingToken(Context context, String str, GMAdSlotBase gMAdSlotBase) {
        return null;
    }

    public String getClientReqId() {
        String str = !TextUtils.isEmpty(this.f1751i) ? this.f1751i : null;
        if (TextUtils.isEmpty(this.s)) {
            return str;
        }
        return (str + "_") + this.s;
    }

    public String getCustomAdNetWorkName() {
        if (this.f1746d == null || !bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().g(this.f1746d.e())) {
            return null;
        }
        return this.f1746d.h();
    }

    public final Object getExtraDataNoParse() {
        h hVar;
        if (isServerBidding() && (hVar = this.p) != null) {
            return hVar.d();
        }
        return null;
    }

    public int getIfTest() {
        i iVar = this.mTTExtraModel;
        if (iVar != null) {
            return iVar.b;
        }
        return 0;
    }

    public int getReqBiddingType() {
        return this.r;
    }

    public abstract String getSdkVersion();

    public boolean hasNotifyFail() {
        return this.b;
    }

    public boolean hasNotifySuccess() {
        return this.a;
    }

    public boolean isClientBidding() {
        return this.r == 1;
    }

    public boolean isMultiBidding() {
        return this.r == 3;
    }

    public boolean isServerBidding() {
        return this.r == 2;
    }

    public abstract void loadAd(Context context, Map<String, Object> map);

    public final void loadAdInter(@NonNull final Context context, @NonNull j jVar, @NonNull final Map<String, Object> map, @NonNull AdSlot adSlot, i iVar, int i2, GMAdSlotBase gMAdSlotBase) {
        this.a = false;
        this.b = false;
        this.f1746d = jVar;
        this.f1747e = adSlot.getAdUnitId();
        this.q = adSlot.getAdCount();
        this.f1751i = adSlot.getLinkedId();
        this.v = adSlot.getAdType();
        this.u = jVar.z();
        this.f1748f = jVar.p();
        this.f1749g = jVar.y();
        this.s = jVar.d();
        this.p = jVar.x();
        this.f1752j = jVar.j();
        this.mAdSlot = adSlot;
        this.mTTExtraModel = iVar;
        this.r = jVar.f();
        this.mWaterfallAbTestParam = jVar.A();
        this.f1755m = i2;
        this.mGMAdSlotBase = gMAdSlotBase;
        Object obj = map.get("key_mediation_rit_req_type");
        this.n = obj != null ? ((Integer) obj).intValue() : 1;
        Object obj2 = map.get("key_mediation_rit_req_type_src");
        this.o = obj2 != null ? ((Integer) obj2).intValue() : 1;
        Object obj3 = map.get("key_is_from_developer_req");
        this.w = obj3 != null && ((Boolean) obj3).booleanValue();
        Object obj4 = map.get("key_requestwfb_ms");
        long longValue = obj4 instanceof Long ? ((Long) obj4).longValue() : -1L;
        Object obj5 = map.get("const_is_custom");
        boolean z = obj5 != null && ((Boolean) obj5).booleanValue();
        if (jVar != null && !jVar.G()) {
            this.x = this.n == 4 ? 3 : 0;
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(jVar, adSlot, getSdkVersion(), this.w, this.x, i2, this.n, this.o, (AdError) null, longValue);
        }
        this.f1750h = (isServerBidding() || isClientBidding() || isMultiBidding()) ? 0.0d : jVar.i();
        this.f1753k = System.currentTimeMillis();
        if (jVar != null && !z) {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_19do.a.a().e(jVar.d(), getSdkVersion());
        }
        if (jVar != null && (TextUtils.equals("mintegral", jVar.e()) || TextUtils.equals("baidu", jVar.e()) || TextUtils.equals("admob", jVar.e()))) {
            ThreadHelper.runOnUiThread(new Runnable() { // from class: com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        TTAbsAdLoaderAdapter.this.loadAd(context, map);
                    } catch (Throwable unused) {
                        TTAbsAdLoaderAdapter.this.notifyAdFailed(new AdError("主线程ADN请求广告崩溃"));
                    }
                }
            });
            return;
        }
        try {
            loadAd(context, map);
        } catch (Throwable unused) {
            notifyAdFailed(new AdError("子线程ADN请求广告崩溃"));
        }
    }

    public final void nativeDislikeClick(TTBaseAd tTBaseAd, String str, Map<String, Object> map) {
        if (tTBaseAd == null || tTBaseAd.getAdType() != 5) {
            return;
        }
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(tTBaseAd, this.mAdSlot, str);
    }

    public final void notifyAdFailed(AdError adError) {
        l(null, adError, true);
    }

    public final void notifyAdLoaded(GMCustomAd gMCustomAd) {
        notifyAdLoaded(gMCustomAd.getTTBaseAd());
    }

    public final void notifyAdLoaded(TTBaseAd tTBaseAd) {
        int i2;
        if (this.y == -1) {
            this.y = SystemClock.elapsedRealtime();
        }
        if (tTBaseAd != null) {
            tTBaseAd.setAdNetworkSlotType(this.r);
            tTBaseAd.setExchangeRate(this.f1752j);
            tTBaseAd.setFillTime(SystemClock.elapsedRealtime());
            g0.a(tTBaseAd, this.f1746d, this.mAdSlot, true);
            AdSlot adSlot = this.mAdSlot;
            if (adSlot != null && ((i2 = this.r) == 1 || i2 == 3)) {
                double bidFloor = adSlot.getBidFloor();
                if (bidFloor > 0.0d && bidFloor > tTBaseAd.getCpm()) {
                    l(tTBaseAd, new AdError(AdError.ERROR_CODE_BIDDING_PRICE_LOW, AdError.getMessage(AdError.ERROR_CODE_BIDDING_PRICE_LOW)), true);
                    return;
                }
            }
        }
        if (this.a) {
            return;
        }
        this.a = true;
        this.f1754l = System.currentTimeMillis() - this.f1753k;
        m("adload_ad", tTBaseAd, null, null, true);
        j jVar = this.f1746d;
        if (jVar != null && jVar.t() == 10 && this.u == 1) {
            notifyAdVideoCache(tTBaseAd, (AdError) null);
        }
    }

    public final void notifyAdLoaded(List<TTBaseAd> list) {
        int i2;
        if (this.y == -1) {
            this.y = SystemClock.elapsedRealtime();
        }
        if (list != null) {
            for (TTBaseAd tTBaseAd : list) {
                if (tTBaseAd != null) {
                    tTBaseAd.setFillTime(SystemClock.elapsedRealtime());
                }
            }
        }
        List<TTBaseAd> arrayList = new ArrayList<>();
        if (!f0.a(list)) {
            arrayList.addAll(list);
        }
        if (!f0.b(list)) {
            int i3 = this.r;
            int i4 = 3;
            if (i3 == 1 || i3 == 3) {
                Iterator<TTBaseAd> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    TTBaseAd next = it.next();
                    next.setAdNetworkSlotType(this.r);
                    next.setExchangeRate(this.f1752j);
                    g0.a(next, this.f1746d, this.mAdSlot, true);
                    AdSlot adSlot = this.mAdSlot;
                    if (adSlot != null && ((i2 = this.r) == 1 || i2 == i4)) {
                        double bidFloor = adSlot.getBidFloor();
                        if (bidFloor > 0.0d && bidFloor > next.getCpm()) {
                            arrayList.remove(next);
                            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(new AdError(AdError.ERROR_CODE_BIDDING_PRICE_LOW, AdError.getMessage(AdError.ERROR_CODE_BIDDING_PRICE_LOW)), this.mAdSlot, this.f1746d, this.f1755m, this.n, this.o, getSdkVersion(), this.f1754l, String.valueOf(next.getCpm()), next.getLevelTag(), t.a(this.f1746d) ? t.b(Thread.currentThread().getStackTrace()) : null);
                            i4 = 3;
                        }
                    }
                }
                if (arrayList.size() <= 0) {
                    l(null, new AdError(AdError.ERROR_CODE_BIDDING_PRICE_LOW, AdError.getMessage(AdError.ERROR_CODE_BIDDING_PRICE_LOW)), false);
                    return;
                }
            }
        }
        if (this.a) {
            return;
        }
        this.a = true;
        this.f1754l = System.currentTimeMillis() - this.f1753k;
        m("adload_ads", null, arrayList, null, true);
    }

    public final void notifyAdLoadedCustom(List<? extends GMCustomAd> list) {
        if (list != null) {
            ArrayList arrayList = new ArrayList(list.size());
            for (GMCustomAd gMCustomAd : list) {
                arrayList.add(gMCustomAd.getTTBaseAd());
            }
            notifyAdLoaded(arrayList);
        }
    }

    public final void notifyAdVideoCache(GMCustomAd gMCustomAd, AdError adError) {
        notifyAdVideoCache(gMCustomAd.getTTBaseAd(), adError);
    }

    public final void notifyAdVideoCache(TTBaseAd tTBaseAd, AdError adError) {
        if (this.b) {
            return;
        }
        m("ad_video_cache", tTBaseAd, null, adError, true);
    }

    public void removeFromParent(View view) {
        UIUtils.removeFromParent(view);
    }

    public final void setAdapterListener(AdapterLoaderListener adapterLoaderListener) {
        this.f1745c = adapterLoaderListener;
    }

    public void setTotalTimedOut(boolean z) {
        this.t = z;
    }
}
