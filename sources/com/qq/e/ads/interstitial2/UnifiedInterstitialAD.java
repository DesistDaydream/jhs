package com.qq.e.ads.interstitial2;

import android.app.Activity;
import android.content.Context;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.qq.e.ads.LiteAbstractAD;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.listeners.NegativeFeedbackListener;
import com.qq.e.comm.pi.IReward;
import com.qq.e.comm.pi.NFBI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.pi.UIADI;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public class UnifiedInterstitialAD extends LiteAbstractAD<UIADI> implements NFBI, IReward {

    /* renamed from: g  reason: collision with root package name */
    private AtomicInteger f5018g;

    /* renamed from: h  reason: collision with root package name */
    private AtomicInteger f5019h;

    /* renamed from: i  reason: collision with root package name */
    private volatile VideoOption f5020i;

    /* renamed from: j  reason: collision with root package name */
    private volatile int f5021j;

    /* renamed from: k  reason: collision with root package name */
    private volatile int f5022k;

    /* renamed from: l  reason: collision with root package name */
    private volatile LoadAdParams f5023l;

    /* renamed from: m  reason: collision with root package name */
    private UnifiedInterstitialADListener f5024m;
    private ServerSideVerificationOptions n;
    private final ADListenerAdapter o;

    public UnifiedInterstitialAD(Activity activity, String str, UnifiedInterstitialADListener unifiedInterstitialADListener) {
        this(activity, str, unifiedInterstitialADListener, null);
    }

    public UnifiedInterstitialAD(Activity activity, String str, UnifiedInterstitialADListener unifiedInterstitialADListener, Map map) {
        this.f5018g = new AtomicInteger(0);
        this.f5019h = new AtomicInteger(0);
        this.f5024m = unifiedInterstitialADListener;
        this.o = new ADListenerAdapter(unifiedInterstitialADListener);
        a(activity, str);
    }

    public UnifiedInterstitialAD(Activity activity, String str, UnifiedInterstitialADListener unifiedInterstitialADListener, Map map, String str2) {
        this.f5018g = new AtomicInteger(0);
        this.f5019h = new AtomicInteger(0);
        this.f5024m = unifiedInterstitialADListener;
        this.o = new ADListenerAdapter(unifiedInterstitialADListener);
        a(activity, str, str2);
    }

    @Override // com.qq.e.ads.AbstractAD
    public Object a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getUnifiedInterstitialADDelegate((Activity) context, str, str2, str3, this.o);
    }

    @Override // com.qq.e.ads.AbstractAD
    public /* bridge */ /* synthetic */ void a(Object obj) {
        UIADI uiadi = (UIADI) obj;
        c();
    }

    @Override // com.qq.e.ads.AbstractAD
    public void b(int i2) {
        UnifiedInterstitialADListener unifiedInterstitialADListener = this.f5024m;
        if (unifiedInterstitialADListener != null) {
            unifiedInterstitialADListener.onNoAD(AdErrorConvertor.formatErrorCode(i2));
        }
    }

    public void c() {
        setVideoOption(this.f5020i);
        setMinVideoDuration(this.f5021j);
        setMaxVideoDuration(this.f5022k);
        setLoadAdParams(this.f5023l);
        setServerSideVerificationOptions(this.n);
        while (this.f5018g.getAndDecrement() > 0) {
            loadAD();
        }
        while (this.f5019h.getAndDecrement() > 0) {
            loadFullScreenAD();
        }
    }

    public void close() {
        T t = this.a;
        if (t != 0) {
            ((UIADI) t).close();
        }
    }

    public void destroy() {
        T t = this.a;
        if (t != 0) {
            ((UIADI) t).destroy();
        } else {
            a("destroy");
        }
    }

    public String getAdNetWorkName() {
        T t = this.a;
        if (t != 0) {
            return ((UIADI) t).getAdNetWorkName();
        }
        a("getAdNetWorkName");
        return null;
    }

    public int getAdPatternType() {
        T t = this.a;
        if (t != 0) {
            return ((UIADI) t).getAdPatternType();
        }
        a("getAdPatternType");
        return 0;
    }

    public int getVideoDuration() {
        T t = this.a;
        if (t != 0) {
            return ((UIADI) t).getVideoDuration();
        }
        a("getVideoDuration");
        return 0;
    }

    public void loadAD() {
        if (a()) {
            if (!b()) {
                this.f5018g.incrementAndGet();
                return;
            }
            T t = this.a;
            if (t != 0) {
                ((UIADI) t).loadAd();
            } else {
                a("loadAD");
            }
        }
    }

    public void loadFullScreenAD() {
        if (a()) {
            if (!b()) {
                this.f5019h.incrementAndGet();
                return;
            }
            T t = this.a;
            if (t != 0) {
                ((UIADI) t).loadFullScreenAD();
            } else {
                a("loadFullScreenAD");
            }
        }
    }

    public void setLoadAdParams(LoadAdParams loadAdParams) {
        this.f5023l = loadAdParams;
        T t = this.a;
        if (t != 0) {
            ((UIADI) t).setLoadAdParams(this.f5023l);
        }
    }

    public void setMaxVideoDuration(int i2) {
        this.f5022k = i2;
        if (this.f5022k > 0 && this.f5021j > this.f5022k) {
            GDTLogger.e("maxVideoDuration 设置值非法，不得小于minVideoDuration");
        }
        T t = this.a;
        if (t != 0) {
            ((UIADI) t).setMaxVideoDuration(i2);
        }
    }

    public void setMediaListener(UnifiedInterstitialMediaListener unifiedInterstitialMediaListener) {
        this.o.setMediaListener(unifiedInterstitialMediaListener);
    }

    public void setMinVideoDuration(int i2) {
        this.f5021j = i2;
        if (this.f5022k > 0 && this.f5021j > this.f5022k) {
            GDTLogger.e("minVideoDuration 设置值非法，不得大于maxVideoDuration");
        }
        T t = this.a;
        if (t != 0) {
            ((UIADI) t).setMinVideoDuration(i2);
        }
    }

    @Override // com.qq.e.comm.pi.NFBI
    public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
        this.o.setNegativeFeedbackListener(negativeFeedbackListener);
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setRewardListener(com.qq.e.comm.listeners.ADRewardListener aDRewardListener) {
        this.o.setAdRewardListener(aDRewardListener);
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.n = serverSideVerificationOptions;
        T t = this.a;
        if (t != 0) {
            ((UIADI) t).setServerSideVerificationOptions(serverSideVerificationOptions);
        }
    }

    public void setVideoOption(VideoOption videoOption) {
        this.f5020i = videoOption;
        T t = this.a;
        if (t != 0) {
            ((UIADI) t).setVideoOption(videoOption);
        }
    }

    public void show() {
        T t = this.a;
        if (t != 0) {
            ((UIADI) t).show();
        } else {
            a(TTLogUtil.TAG_EVENT_SHOW);
        }
    }

    public void show(Activity activity) {
        T t = this.a;
        if (t != 0) {
            ((UIADI) t).show(activity);
        } else {
            a(TTLogUtil.TAG_EVENT_SHOW);
        }
    }

    public void showAsPopupWindow() {
        T t = this.a;
        if (t != 0) {
            ((UIADI) t).showAsPopupWindow();
        } else {
            a("showAsPopupWindow");
        }
    }

    public void showAsPopupWindow(Activity activity) {
        T t = this.a;
        if (t != 0) {
            ((UIADI) t).showAsPopupWindow(activity);
        } else {
            a("showAsPopupWindow");
        }
    }

    public void showFullScreenAD(Activity activity) {
        T t = this.a;
        if (t != 0) {
            ((UIADI) t).showFullScreenAD(activity);
        } else {
            a("showFullScreenAD");
        }
    }
}
