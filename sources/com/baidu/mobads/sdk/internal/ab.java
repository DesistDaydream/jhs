package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.XAdNativeResponse;
import com.baidu.mobads.sdk.internal.e;
import java.util.List;

/* loaded from: classes.dex */
public class ab implements e.a {
    private BaiduNativeManager.FeedAdListener a;

    public ab(BaiduNativeManager.FeedAdListener feedAdListener) {
        this.a = feedAdListener;
    }

    @Override // com.baidu.mobads.sdk.internal.e.a
    public void a(List<NativeResponse> list) {
        BaiduNativeManager.FeedAdListener feedAdListener = this.a;
        if (feedAdListener != null) {
            feedAdListener.onNativeLoad(list);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.e.a
    public void b(int i2, String str) {
        BaiduNativeManager.FeedAdListener feedAdListener = this.a;
        if (feedAdListener != null) {
            feedAdListener.onNativeFail(i2, str);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.e.a
    public void c() {
        BaiduNativeManager.FeedAdListener feedAdListener = this.a;
        if (feedAdListener != null) {
            feedAdListener.onVideoDownloadFailed();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.e.a
    public void a(int i2, String str) {
        BaiduNativeManager.FeedAdListener feedAdListener = this.a;
        if (feedAdListener != null) {
            feedAdListener.onNoAd(i2, str);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.e.a
    public void b(NativeResponse nativeResponse) {
        BaiduNativeManager.FeedAdListener feedAdListener = this.a;
        if (feedAdListener != null && (feedAdListener instanceof BaiduNativeManager.PortraitVideoAdListener)) {
            ((BaiduNativeManager.PortraitVideoAdListener) feedAdListener).onAdClick();
        } else if (nativeResponse instanceof XAdNativeResponse) {
            ((XAdNativeResponse) nativeResponse).onAdClick();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.e.a
    public void a(NativeResponse nativeResponse) {
        if (nativeResponse instanceof XAdNativeResponse) {
            ((XAdNativeResponse) nativeResponse).onADExposed();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.e.a
    public void a(NativeResponse nativeResponse, int i2) {
        if (nativeResponse instanceof XAdNativeResponse) {
            ((XAdNativeResponse) nativeResponse).onADExposureFailed(i2);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.e.a
    public void b() {
        BaiduNativeManager.FeedAdListener feedAdListener = this.a;
        if (feedAdListener != null) {
            feedAdListener.onVideoDownloadSuccess();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.e.a
    public void a() {
        BaiduNativeManager.FeedAdListener feedAdListener = this.a;
        if (feedAdListener != null) {
            feedAdListener.onLpClosed();
        }
    }
}
