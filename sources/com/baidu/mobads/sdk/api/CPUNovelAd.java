package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.view.View;
import com.baidu.mobads.sdk.internal.co;

/* loaded from: classes.dex */
public class CPUNovelAd {
    private co mCpuNovelProd;

    /* loaded from: classes.dex */
    public interface CpuNovelListener {
        void onAdClick();

        void onAdImpression();

        void onReadTime(long j2);
    }

    public CPUNovelAd(Context context, String str, CPUWebAdRequestParam cPUWebAdRequestParam, CpuNovelListener cpuNovelListener) {
        co coVar = new co(context, str, cPUWebAdRequestParam);
        this.mCpuNovelProd = coVar;
        coVar.a(cpuNovelListener);
        this.mCpuNovelProd.a();
    }

    public void destory() {
        co coVar = this.mCpuNovelProd;
        if (coVar != null) {
            coVar.x();
        }
    }

    public View getNovelView() {
        return this.mCpuNovelProd.v();
    }
}
