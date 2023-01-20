package com.qq.e.ads;

import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.comm.pi.ADI;
import com.qq.e.comm.util.AdError;

/* loaded from: classes3.dex */
public abstract class NativeAbstractAD<T extends ADI> extends AbstractAD<T> {

    /* renamed from: f  reason: collision with root package name */
    private DownAPPConfirmPolicy f4979f;

    /* loaded from: classes3.dex */
    public interface BasicADListener {
        void onNoAD(AdError adError);
    }

    public void a(T t) {
        DownAPPConfirmPolicy downAPPConfirmPolicy = this.f4979f;
        if (downAPPConfirmPolicy != null) {
            setDownAPPConfirmPolicy(downAPPConfirmPolicy);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qq.e.ads.AbstractAD
    public /* bridge */ /* synthetic */ void a(Object obj) {
        a((NativeAbstractAD<T>) ((ADI) obj));
    }

    public void setDownAPPConfirmPolicy(DownAPPConfirmPolicy downAPPConfirmPolicy) {
        this.f4979f = downAPPConfirmPolicy;
        T t = this.a;
        if (t == 0 || downAPPConfirmPolicy == null) {
            return;
        }
        ((ADI) t).setDownAPPConfirmPolicy(downAPPConfirmPolicy);
    }
}
