package com.jihuanshe.model;

import java.util.List;
import k.e.a.d;

/* loaded from: classes2.dex */
public final class ImageErrorInfo {
    @d
    private final String content;
    @d
    private final List<String> images;
    @d
    private final String reason;

    public ImageErrorInfo(@d String str, @d String str2, @d List<String> list) {
        this.reason = str;
        this.content = str2;
        this.images = list;
    }

    @d
    public final String getContent() {
        return this.content;
    }

    @d
    public final List<String> getImages() {
        return this.images;
    }

    @d
    public final String getReason() {
        return this.reason;
    }
}
