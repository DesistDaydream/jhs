package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.ac;
import com.baidu.mobads.sdk.internal.bf;
import com.baidu.mobads.sdk.internal.bj;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class NativeCPUManager {
    private static final String TAG = "NativeCPUManager";
    private CPUAdListener mCPUAdListener;
    private ac mCPUAdProd;
    private Context mContext;
    private int mPageSize = 10;
    private HashMap<String, Object> mParams = new HashMap<>();

    /* loaded from: classes.dex */
    public interface CPUAdListener {
        void onAdError(String str, int i2);

        void onAdLoaded(List<IBasicCPUData> list);

        void onDisLikeAdClick(int i2, String str);

        void onExitLp();

        void onLpCustomEventCallBack(HashMap<String, Object> hashMap, DataPostBackListener dataPostBackListener);

        void onVideoDownloadFailed();

        void onVideoDownloadSuccess();
    }

    /* loaded from: classes.dex */
    public interface DataPostBackListener {
        void postback(JSONObject jSONObject);
    }

    public NativeCPUManager(Context context, String str, CPUAdListener cPUAdListener) {
        this.mCPUAdProd = null;
        if (context != null && !TextUtils.isEmpty(str)) {
            this.mCPUAdListener = cPUAdListener;
            this.mContext = context;
            ac acVar = new ac(context, str, this);
            this.mCPUAdProd = acVar;
            acVar.a(cPUAdListener);
            return;
        }
        bj.a().c(TAG, "Init params error!");
        if (cPUAdListener != null) {
            cPUAdListener.onAdError("Input params error.", bf.INTERFACE_USE_PROBLEM.b());
        }
    }

    public void loadAd(int i2, int i3, boolean z) {
        loadAd(i2, new int[]{i3}, z);
    }

    public void openAppActivity(String str) {
        ac acVar = this.mCPUAdProd;
        if (acVar != null) {
            acVar.a(str);
            this.mCPUAdProd.a();
        }
    }

    public void setPageSize(int i2) {
        if (i2 > 0 && i2 <= 20) {
            this.mPageSize = i2;
        } else {
            bj.a().c(TAG, "Input page size is wrong which should be in (0,20]!");
        }
    }

    public void setRequestParameter(CPUAdRequest cPUAdRequest) {
        if (cPUAdRequest == null || cPUAdRequest.getExtras() == null) {
            return;
        }
        this.mParams = cPUAdRequest.getExtras();
    }

    public void setRequestTimeoutMillis(int i2) {
        ac acVar = this.mCPUAdProd;
        if (acVar != null) {
            acVar.a(i2);
        }
    }

    private void loadAd(int i2, int[] iArr, boolean z) {
        if (i2 > 0 && iArr != null) {
            ac acVar = this.mCPUAdProd;
            if (acVar != null) {
                acVar.a(i2, this.mPageSize, iArr, z, this.mParams);
                this.mCPUAdProd.f();
                this.mCPUAdProd.a();
                return;
            }
            return;
        }
        bj.a().c(TAG, "LoadAd with terrible params!");
    }
}
