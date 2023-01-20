package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.baidu.mobads.sdk.internal.bp;

/* loaded from: classes.dex */
public class aa implements bp.c {
    public final /* synthetic */ y a;

    public aa(y yVar) {
        this.a = yVar;
    }

    @Override // com.baidu.mobads.sdk.internal.bp.c
    public void a(boolean z) {
        IXAdContainerFactory iXAdContainerFactory;
        if (z) {
            try {
                bp bpVar = f.a;
                if (bpVar != null) {
                    this.a.b = bpVar.i();
                    iXAdContainerFactory = this.a.b;
                    if (iXAdContainerFactory != null) {
                        this.a.k();
                        return;
                    }
                }
            } catch (Exception unused) {
                this.a.a("加载dex异常");
                return;
            }
        }
        f.a = null;
        this.a.a("加载dex失败");
    }
}
