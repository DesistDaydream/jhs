package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;

/* loaded from: classes.dex */
public class m implements IOAdEventListener {
    public final /* synthetic */ l a;

    public m(l lVar) {
        this.a = lVar;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        ay.a(new n(this, iOAdEvent));
    }
}
