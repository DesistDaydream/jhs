package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.internal.al;

/* loaded from: classes.dex */
public class bw implements al.a {
    public final /* synthetic */ bp a;

    public bw(bp bpVar) {
        this.a = bpVar;
    }

    @Override // com.baidu.mobads.sdk.internal.al.a
    public void a() {
        boolean z;
        z = this.a.A;
        if (z) {
            this.a.A = false;
            this.a.a(false, "remote update Network access failed");
        }
    }
}
