package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.internal.by;

/* loaded from: classes.dex */
public class bm implements by.a {
    public final /* synthetic */ bl a;

    public bm(bl blVar) {
        this.a = blVar;
    }

    @Override // com.baidu.mobads.sdk.internal.by.a
    public void a(bn bnVar) {
        this.a.a(bp.f1532k, bnVar, "download apk successfully, downloader exit");
        bl unused = bl.f1508h = null;
    }

    @Override // com.baidu.mobads.sdk.internal.by.a
    public void b(bn bnVar) {
        this.a.a(bp.f1533l, bnVar, "downloadApk failed");
    }
}
