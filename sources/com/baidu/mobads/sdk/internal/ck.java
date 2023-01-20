package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;

/* loaded from: classes.dex */
public class ck implements IOAdEventListener {
    public final /* synthetic */ cj a;

    public ck(cj cjVar) {
        this.a = cjVar;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        if (iOAdEvent != null) {
            this.a.c(iOAdEvent.getData());
        }
    }
}
