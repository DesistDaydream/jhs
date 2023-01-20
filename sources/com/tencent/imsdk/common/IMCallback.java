package com.tencent.imsdk.common;

import com.tencent.imsdk.v2.V2TIMCallback;
import com.tencent.imsdk.v2.V2TIMCompleteCallback;
import com.tencent.imsdk.v2.V2TIMValueCallback;

/* loaded from: classes3.dex */
public abstract class IMCallback<T> {
    public V2TIMCallback callback;
    public V2TIMCompleteCallback<T> completeCallback;
    public V2TIMValueCallback<T> valueCallback;

    public IMCallback(V2TIMCallback v2TIMCallback) {
        this.callback = v2TIMCallback;
    }

    public void fail(final int i2, final String str) {
        IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.common.IMCallback.2
            @Override // java.lang.Runnable
            public void run() {
                IMCallback iMCallback = IMCallback.this;
                V2TIMCallback v2TIMCallback = iMCallback.callback;
                if (v2TIMCallback != null) {
                    v2TIMCallback.onError(i2, str);
                    return;
                }
                V2TIMValueCallback<T> v2TIMValueCallback = iMCallback.valueCallback;
                if (v2TIMValueCallback != null) {
                    v2TIMValueCallback.onError(i2, str);
                }
            }
        });
    }

    public void success(final T t) {
        IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.common.IMCallback.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                IMCallback iMCallback = IMCallback.this;
                V2TIMCallback v2TIMCallback = iMCallback.callback;
                if (v2TIMCallback != null) {
                    v2TIMCallback.onSuccess();
                    return;
                }
                V2TIMValueCallback<T> v2TIMValueCallback = iMCallback.valueCallback;
                if (v2TIMValueCallback != 0) {
                    v2TIMValueCallback.onSuccess(t);
                    return;
                }
                V2TIMCompleteCallback<T> v2TIMCompleteCallback = iMCallback.completeCallback;
                if (v2TIMCompleteCallback != 0) {
                    v2TIMCompleteCallback.onComplete(0, "", t);
                }
            }
        });
    }

    public void fail(final int i2, final String str, final T t) {
        IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.common.IMCallback.3
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                IMCallback iMCallback = IMCallback.this;
                V2TIMCallback v2TIMCallback = iMCallback.callback;
                if (v2TIMCallback != null) {
                    v2TIMCallback.onError(i2, str);
                    return;
                }
                V2TIMValueCallback<T> v2TIMValueCallback = iMCallback.valueCallback;
                if (v2TIMValueCallback != null) {
                    v2TIMValueCallback.onError(i2, str);
                    return;
                }
                V2TIMCompleteCallback<T> v2TIMCompleteCallback = iMCallback.completeCallback;
                if (v2TIMCompleteCallback != 0) {
                    v2TIMCompleteCallback.onComplete(i2, str, t);
                }
            }
        });
    }

    public IMCallback(V2TIMValueCallback<T> v2TIMValueCallback) {
        this.valueCallback = v2TIMValueCallback;
    }

    public IMCallback(V2TIMCompleteCallback<T> v2TIMCompleteCallback) {
        this.completeCallback = v2TIMCompleteCallback;
    }
}
