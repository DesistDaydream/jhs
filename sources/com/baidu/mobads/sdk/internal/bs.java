package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.internal.cd;

/* loaded from: classes.dex */
public class bs implements cd.a {
    public final /* synthetic */ bp a;

    public bs(bp bpVar) {
        this.a = bpVar;
    }

    @Override // com.baidu.mobads.sdk.internal.cd.a
    public void a(String str) {
        try {
            this.a.b();
            this.a.a(str);
        } catch (Throwable th) {
            bj.a().a(th);
        }
    }
}
