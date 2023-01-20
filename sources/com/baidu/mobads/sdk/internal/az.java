package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.internal.y;

/* loaded from: classes.dex */
public class az implements y.a {

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ay f1467c;

    public az(ay ayVar) {
        this.f1467c = ayVar;
    }

    @Override // com.baidu.mobads.sdk.internal.y.a
    public void onFailure() {
        this.f1467c.f1462i.a(ay.b, "AbstractProdTemplate,load-dex请求，回调失败");
        this.f1467c.j();
    }

    @Override // com.baidu.mobads.sdk.internal.y.a
    public void onSuccess() {
        this.f1467c.f1462i.a(ay.b, "AbstractProdTemplate,load-dex请求，回调成功");
        this.f1467c.i();
    }
}
