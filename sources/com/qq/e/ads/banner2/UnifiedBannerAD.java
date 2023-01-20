package com.qq.e.ads.banner2;

import android.app.Activity;
import android.content.Context;
import com.qq.e.ads.LiteAbstractAD;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.listeners.ADRewardListener;
import com.qq.e.comm.listeners.NegativeFeedbackListener;
import com.qq.e.comm.pi.IReward;
import com.qq.e.comm.pi.NFBI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.pi.UBVI;
import com.qq.e.comm.util.AdErrorConvertor;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public class UnifiedBannerAD extends LiteAbstractAD<UBVI> implements NFBI, IReward {

    /* renamed from: g  reason: collision with root package name */
    private UnifiedBannerADListener f4981g;

    /* renamed from: h  reason: collision with root package name */
    private DownAPPConfirmPolicy f4982h;

    /* renamed from: i  reason: collision with root package name */
    private AtomicInteger f4983i;

    /* renamed from: j  reason: collision with root package name */
    private int f4984j;

    /* renamed from: k  reason: collision with root package name */
    private LoadAdParams f4985k;

    /* renamed from: l  reason: collision with root package name */
    private UnifiedBannerView f4986l;

    /* renamed from: m  reason: collision with root package name */
    private final ADListenerAdapter f4987m;
    private volatile ServerSideVerificationOptions n;

    public UnifiedBannerAD(Activity activity, UnifiedBannerView unifiedBannerView, String str, UnifiedBannerADListener unifiedBannerADListener) {
        this(unifiedBannerView, unifiedBannerADListener);
        a(activity, str);
    }

    public UnifiedBannerAD(Activity activity, UnifiedBannerView unifiedBannerView, String str, String str2, UnifiedBannerADListener unifiedBannerADListener) {
        this(unifiedBannerView, unifiedBannerADListener);
        a(activity, str, str2);
    }

    private UnifiedBannerAD(UnifiedBannerView unifiedBannerView, UnifiedBannerADListener unifiedBannerADListener) {
        this.f4983i = new AtomicInteger(0);
        this.f4984j = 30;
        this.f4985k = null;
        this.f4981g = unifiedBannerADListener;
        this.f4986l = unifiedBannerView;
        this.f4987m = new ADListenerAdapter(unifiedBannerADListener);
    }

    @Override // com.qq.e.ads.AbstractAD
    public Object a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getUnifiedBannerViewDelegate(this.f4986l, (Activity) context, str, str2, str3, this.f4987m);
    }

    @Override // com.qq.e.ads.AbstractAD
    public void b(int i2) {
        UnifiedBannerADListener unifiedBannerADListener = this.f4981g;
        if (unifiedBannerADListener != null) {
            unifiedBannerADListener.onNoAD(AdErrorConvertor.formatErrorCode(i2));
        }
    }

    public void d(DownAPPConfirmPolicy downAPPConfirmPolicy) {
        T t;
        this.f4982h = downAPPConfirmPolicy;
        if (downAPPConfirmPolicy == null || (t = this.a) == 0) {
            return;
        }
        ((UBVI) t).setDownAPPConfirmPolicy(downAPPConfirmPolicy);
    }

    public void destroy() {
        T t = this.a;
        if (t != 0) {
            ((UBVI) t).destroy();
        } else {
            a("destroy");
        }
    }

    public void e(int i2) {
        this.f4984j = i2;
        T t = this.a;
        if (t != 0) {
            ((UBVI) t).setRefresh(i2);
        }
    }

    public String getAdNetWorkName() {
        T t = this.a;
        if (t != 0) {
            return ((UBVI) t).getAdNetWorkName();
        }
        a("getAdNetWorkName");
        return null;
    }

    public void loadAD() {
        if (a()) {
            if (!b()) {
                this.f4983i.incrementAndGet();
                return;
            }
            T t = this.a;
            if (t != 0) {
                ((UBVI) t).fetchAd();
            } else {
                a("loadAD");
            }
        }
    }

    public void onWindowFocusChanged(boolean z) {
        T t = this.a;
        if (t != 0) {
            ((UBVI) t).onWindowFocusChanged(z);
        }
    }

    public void setLoadAdParams(LoadAdParams loadAdParams) {
        this.f4985k = loadAdParams;
        T t = this.a;
        if (t != 0) {
            ((UBVI) t).setLoadAdParams(loadAdParams);
        }
    }

    @Override // com.qq.e.comm.pi.NFBI
    public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
        this.f4987m.setNegativeFeedbackListener(negativeFeedbackListener);
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setRewardListener(ADRewardListener aDRewardListener) {
        this.f4987m.setAdRewardListener(aDRewardListener);
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.n = serverSideVerificationOptions;
        T t = this.a;
        if (t != 0) {
            ((UBVI) t).setServerSideVerificationOptions(serverSideVerificationOptions);
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    public void a(Object obj) {
        UBVI ubvi = (UBVI) obj;
        DownAPPConfirmPolicy downAPPConfirmPolicy = this.f4982h;
        if (downAPPConfirmPolicy != null) {
            this.f4982h = downAPPConfirmPolicy;
            T t = this.a;
            if (t != 0) {
                ((UBVI) t).setDownAPPConfirmPolicy(downAPPConfirmPolicy);
            }
        }
        int i2 = this.f4984j;
        this.f4984j = i2;
        T t2 = this.a;
        if (t2 != 0) {
            ((UBVI) t2).setRefresh(i2);
        }
        LoadAdParams loadAdParams = this.f4985k;
        this.f4985k = loadAdParams;
        T t3 = this.a;
        if (t3 != 0) {
            ((UBVI) t3).setLoadAdParams(loadAdParams);
        }
        ubvi.setServerSideVerificationOptions(this.n);
        while (this.f4983i.getAndDecrement() > 0) {
            loadAD();
        }
    }
}
