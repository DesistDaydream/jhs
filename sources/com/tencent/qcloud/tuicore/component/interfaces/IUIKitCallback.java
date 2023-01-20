package com.tencent.qcloud.tuicore.component.interfaces;

/* loaded from: classes3.dex */
public abstract class IUIKitCallback<T> {
    public abstract void onError(String str, int i2, String str2);

    public void onProgress(Object obj) {
    }

    public abstract void onSuccess(T t);
}
