package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;

/* loaded from: classes.dex */
public class cp implements IOAdEventListener {
    public final /* synthetic */ co a;

    public cp(co coVar) {
        this.a = coVar;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        if (iOAdEvent != null) {
            this.a.c(iOAdEvent.getData());
        }
    }
}
