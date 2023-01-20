package com.qq.e.ads.splash;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.qq.e.ads.LiteAbstractAD;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.ErrorCode;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.listeners.ADRewardListener;
import com.qq.e.comm.pi.IReward;
import com.qq.e.comm.pi.NSPVI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import java.util.HashMap;

/* loaded from: classes3.dex */
public final class SplashAD extends LiteAbstractAD<NSPVI> implements IReward {

    /* renamed from: g  reason: collision with root package name */
    private volatile ViewGroup f5056g;

    /* renamed from: h  reason: collision with root package name */
    private volatile SplashADListener f5057h;

    /* renamed from: i  reason: collision with root package name */
    private volatile ADRewardListener f5058i;

    /* renamed from: j  reason: collision with root package name */
    private volatile LoadAdParams f5059j;

    /* renamed from: k  reason: collision with root package name */
    private volatile boolean f5060k;

    /* renamed from: l  reason: collision with root package name */
    private volatile boolean f5061l;

    /* renamed from: m  reason: collision with root package name */
    private volatile boolean f5062m;
    private volatile int n;
    private volatile byte[] o;
    private volatile ServerSideVerificationOptions p;
    private int q;

    /* loaded from: classes3.dex */
    public class ADListenerAdapter implements ADListener {
        private ADListenerAdapter() {
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            String str;
            if (SplashAD.this.f5057h == null) {
                GDTLogger.d("SplashADListener == null");
                return;
            }
            int type = aDEvent.getType();
            switch (type) {
                case 100:
                    Long l2 = (Long) aDEvent.getParam(Long.class);
                    if (l2 != null) {
                        SplashAD.this.f5057h.onADLoaded(l2.longValue());
                        return;
                    }
                    return;
                case 101:
                    Integer num = (Integer) aDEvent.getParam(Integer.class);
                    if (num != null) {
                        SplashAD.this.f5057h.onNoAD(AdErrorConvertor.formatErrorCode(num.intValue()));
                        return;
                    }
                    return;
                case 102:
                    SplashAD.this.f5057h.onADPresent();
                    return;
                case 103:
                    SplashAD.this.f5057h.onADExposure();
                    return;
                case 104:
                    if (SplashAD.this.f5058i == null || (str = (String) aDEvent.getParam(String.class)) == null) {
                        return;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("transId", str);
                    SplashAD.this.f5058i.onReward(hashMap);
                    return;
                case 105:
                    SplashAD.this.f5057h.onADClicked();
                    return;
                case 106:
                    SplashAD.this.f5057h.onADDismissed();
                    return;
                default:
                    switch (type) {
                        case 112:
                            Long l3 = (Long) aDEvent.getParam(Long.class);
                            if (l3 != null) {
                                SplashAD.this.f5057h.onADTick(l3.longValue());
                                return;
                            }
                            return;
                        case 113:
                            if (SplashAD.this.f5057h instanceof SplashADZoomOutListener) {
                                ((SplashADZoomOutListener) SplashAD.this.f5057h).onZoomOut();
                                return;
                            }
                            return;
                        case 114:
                            if (SplashAD.this.f5057h instanceof SplashADZoomOutListener) {
                                ((SplashADZoomOutListener) SplashAD.this.f5057h).onZoomOutPlayFinish();
                                return;
                            }
                            return;
                        default:
                            return;
                    }
            }
        }
    }

    public SplashAD(Context context, String str, SplashADListener splashADListener) {
        this(context, str, splashADListener, 0);
    }

    public SplashAD(Context context, String str, SplashADListener splashADListener, int i2) {
        this.f5060k = false;
        this.f5057h = splashADListener;
        this.q = i2;
        a(context, str);
    }

    public SplashAD(Context context, String str, SplashADListener splashADListener, int i2, String str2) {
        this.f5060k = false;
        this.f5057h = splashADListener;
        this.q = i2;
        a(context, str, str2);
    }

    private void e(ViewGroup viewGroup, boolean z) {
        if (viewGroup == null) {
            GDTLogger.e("传入参数有误：传入container参数为空");
            a(ErrorCode.CONSTRUCTOR_PARAM_ERROR);
            return;
        }
        T t = this.a;
        if (t == 0) {
            this.f5062m = z;
            this.f5056g = viewGroup;
            return;
        }
        NSPVI nspvi = (NSPVI) t;
        if (z) {
            nspvi.fetchFullScreenAndShowIn(viewGroup);
        } else {
            nspvi.fetchAndShowIn(viewGroup);
        }
    }

    private void f(boolean z) {
        if (a()) {
            if (!b()) {
                this.f5062m = z;
                this.f5061l = true;
                return;
            }
            T t = this.a;
            if (t == 0) {
                a("fetchAdInner");
                return;
            }
            NSPVI nspvi = (NSPVI) t;
            if (z) {
                nspvi.fetchFullScreenAdOnly();
            } else {
                nspvi.fetchAdOnly();
            }
        }
    }

    private void h(ViewGroup viewGroup, boolean z) {
        if (viewGroup == null) {
            GDTLogger.e("传入参数错误，container参数为空");
            a(ErrorCode.CONSTRUCTOR_PARAM_ERROR);
            return;
        }
        T t = this.a;
        if (t == 0) {
            this.f5056g = viewGroup;
            return;
        }
        NSPVI nspvi = (NSPVI) t;
        if (z) {
            nspvi.showFullScreenAd(viewGroup);
        } else {
            nspvi.showAd(viewGroup);
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    public Object a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getNativeSplashAdView(context, str, str2, str3);
    }

    @Override // com.qq.e.ads.AbstractAD
    public void b(int i2) {
        if (this.f5057h != null) {
            this.f5057h.onNoAD(AdErrorConvertor.formatErrorCode(i2));
        }
    }

    public void fetchAdOnly() {
        f(false);
    }

    public void fetchAndShowIn(ViewGroup viewGroup) {
        e(viewGroup, false);
    }

    public void fetchFullScreenAdOnly() {
        f(true);
    }

    public void fetchFullScreenAndShowIn(ViewGroup viewGroup) {
        e(viewGroup, true);
    }

    public String getAdNetWorkName() {
        T t = this.a;
        if (t != 0) {
            return ((NSPVI) t).getAdNetWorkName();
        }
        a("getAdNetWorkName");
        return null;
    }

    public Bitmap getZoomOutBitmap() {
        T t = this.a;
        if (t != 0) {
            return ((NSPVI) t).getZoomOutBitmap();
        }
        a("getZoomOutBitmap");
        return null;
    }

    public void preLoad() {
        if (a()) {
            if (!b()) {
                this.f5060k = true;
                return;
            }
            T t = this.a;
            if (t != 0) {
                ((NSPVI) t).preload();
            } else {
                a("preLoad");
            }
        }
    }

    @Deprecated
    public void setAdLogoMargin(int i2, int i3) {
    }

    public void setDeveloperLogo(int i2) {
        T t = this.a;
        if (t == 0) {
            this.n = i2;
        } else {
            ((NSPVI) t).setDeveloperLogo(i2);
        }
    }

    public void setDeveloperLogo(byte[] bArr) {
        T t = this.a;
        if (t == 0) {
            this.o = bArr;
        } else {
            ((NSPVI) t).setDeveloperLogo(bArr);
        }
    }

    public void setLoadAdParams(LoadAdParams loadAdParams) {
        T t = this.a;
        if (t != 0) {
            ((NSPVI) t).setLoadAdParams(loadAdParams);
        } else {
            this.f5059j = loadAdParams;
        }
    }

    @Deprecated
    public void setPreloadView(View view) {
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setRewardListener(ADRewardListener aDRewardListener) {
        this.f5058i = aDRewardListener;
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.p = serverSideVerificationOptions;
        T t = this.a;
        if (t != 0) {
            ((NSPVI) t).setServerSideVerificationOptions(serverSideVerificationOptions);
        }
    }

    public void showAd(ViewGroup viewGroup) {
        h(viewGroup, false);
    }

    public void showFullScreenAd(ViewGroup viewGroup) {
        h(viewGroup, true);
    }

    public void zoomOutAnimationFinish() {
        T t = this.a;
        if (t != 0) {
            ((NSPVI) t).zoomOutAnimationFinish();
        } else {
            a("zoomOutAnimationFinish");
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    public void a(Object obj) {
        NSPVI nspvi = (NSPVI) obj;
        if (this.f5059j != null) {
            nspvi.setLoadAdParams(this.f5059j);
        }
        if (this.n != 0) {
            nspvi.setDeveloperLogo(this.n);
        }
        if (this.o != null) {
            nspvi.setDeveloperLogo(this.o);
        }
        nspvi.setFetchDelay(this.q);
        nspvi.setAdListener(new ADListenerAdapter());
        nspvi.setServerSideVerificationOptions(this.p);
        if ((this.f5057h instanceof SplashADZoomOutListener) && ((SplashADZoomOutListener) this.f5057h).isSupportZoomOut()) {
            nspvi.setSupportZoomOut(true);
        }
        if (this.f5056g != null) {
            if (this.f5062m) {
                fetchFullScreenAndShowIn(this.f5056g);
            } else {
                fetchAndShowIn(this.f5056g);
            }
        }
        if (this.f5060k) {
            nspvi.preload();
            this.f5060k = false;
        }
        if (this.f5061l) {
            if (this.f5062m) {
                nspvi.fetchFullScreenAdOnly();
            } else {
                nspvi.fetchAdOnly();
            }
            this.f5061l = false;
        }
    }
}
