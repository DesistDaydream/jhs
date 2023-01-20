package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;

/* loaded from: classes.dex */
public class ad implements IOAdEventListener {
    public final /* synthetic */ ac a;

    public ad(ac acVar) {
        this.a = acVar;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        if (iOAdEvent != null) {
            this.a.c(iOAdEvent.getData());
        }
    }
}
