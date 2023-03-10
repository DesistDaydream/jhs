package com.qq.e.ads.hybrid;

import android.content.Context;
import com.qq.e.ads.AbstractAD;
import com.qq.e.comm.constants.ErrorCode;
import com.qq.e.comm.pi.HADI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class HybridAD extends AbstractAD<HADI> implements HADI {

    /* renamed from: f  reason: collision with root package name */
    private HybridADListener f5005f;

    /* renamed from: g  reason: collision with root package name */
    private CountDownLatch f5006g = new CountDownLatch(1);

    /* renamed from: h  reason: collision with root package name */
    private HybridADSetting f5007h;

    public HybridAD(Context context, HybridADSetting hybridADSetting, HybridADListener hybridADListener) {
        this.f5007h = hybridADSetting;
        this.f5005f = hybridADListener;
        a(context, "NO_POS_ID");
    }

    public HADI a(POFactory pOFactory) {
        return pOFactory.getHybridAD(this.f5007h, this.f5005f);
    }

    @Override // com.qq.e.ads.AbstractAD
    public /* bridge */ /* synthetic */ HADI a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return a(pOFactory);
    }

    @Override // com.qq.e.ads.AbstractAD
    public /* bridge */ /* synthetic */ void a(HADI hadi) {
        c();
    }

    @Override // com.qq.e.ads.AbstractAD
    public void b(int i2) {
        HybridADListener hybridADListener = this.f5005f;
        if (hybridADListener != null) {
            hybridADListener.onError(AdErrorConvertor.formatErrorCode(i2));
        }
        this.f5006g.countDown();
    }

    public void c() {
        this.f5006g.countDown();
    }

    @Override // com.qq.e.comm.pi.HADI
    public void loadUrl(final String str) {
        if (a()) {
            if (!b()) {
                new Thread(new Runnable() { // from class: com.qq.e.ads.hybrid.HybridAD.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            HybridAD.this.f5006g.await(30L, TimeUnit.SECONDS);
                            if (!HybridAD.this.b() || HybridAD.this.a == null) {
                                GDTLogger.e("?????????????????????????????????????????????");
                                HybridAD.this.a((int) ErrorCode.INIT_ERROR);
                            } else {
                                ((HADI) HybridAD.this.a).loadUrl(str);
                            }
                        } catch (InterruptedException unused) {
                            GDTLogger.e("?????????????????????????????????????????????");
                            HybridAD.this.a((int) ErrorCode.INIT_ERROR);
                        }
                    }
                }).start();
                return;
            }
            T t = this.a;
            if (t != 0) {
                ((HADI) t).loadUrl(str);
            } else {
                a("loadUrl");
            }
        }
    }
}
