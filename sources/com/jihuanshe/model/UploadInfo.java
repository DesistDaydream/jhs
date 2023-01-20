package com.jihuanshe.model;

import e.j.e.r.c;
import h.k2.v.u;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class UploadInfo {
    @c("url")
    @e
    private final String showPath;
    @c("token")
    @e
    private final String token;
    @c("file_path")
    @e
    private final String url;

    public UploadInfo() {
        this(null, null, null, 7, null);
    }

    public UploadInfo(@e String str, @e String str2, @e String str3) {
        this.token = str;
        this.url = str2;
        this.showPath = str3;
    }

    @e
    public final String getShowPath() {
        return this.showPath;
    }

    @e
    public final String getToken() {
        return this.token;
    }

    @e
    public final String getUrl() {
        return this.url;
    }

    public /* synthetic */ UploadInfo(String str, String str2, String str3, int i2, u uVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3);
    }
}
