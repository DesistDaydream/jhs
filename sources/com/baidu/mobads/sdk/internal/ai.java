package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.XAdNativeResponse;
import com.baidu.mobads.sdk.internal.e;

/* loaded from: classes.dex */
public class ai implements e.b {
    @Override // com.baidu.mobads.sdk.internal.e.b
    public void a(NativeResponse nativeResponse) {
        if (nativeResponse instanceof XAdNativeResponse) {
            ((XAdNativeResponse) nativeResponse).onADStatusChanged();
        }
    }
}
