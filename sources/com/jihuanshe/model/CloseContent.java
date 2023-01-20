package com.jihuanshe.model;

import e.j.e.r.c;
import h.k2.v.f0;
import h.k2.v.u;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class CloseContent {
    @c("content")
    @e
    private final String content;
    @c("title")
    @e
    private final String title;

    public CloseContent() {
        this(null, null, 3, null);
    }

    public CloseContent(@e String str, @e String str2) {
        this.title = str;
        this.content = str2;
    }

    public static /* synthetic */ CloseContent copy$default(CloseContent closeContent, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = closeContent.title;
        }
        if ((i2 & 2) != 0) {
            str2 = closeContent.content;
        }
        return closeContent.copy(str, str2);
    }

    @e
    public final String component1() {
        return this.title;
    }

    @e
    public final String component2() {
        return this.content;
    }

    @d
    public final CloseContent copy(@e String str, @e String str2) {
        return new CloseContent(str, str2);
    }

    public boolean equals(@e Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CloseContent) {
            CloseContent closeContent = (CloseContent) obj;
            return f0.g(this.title, closeContent.title) && f0.g(this.content, closeContent.content);
        }
        return false;
    }

    @e
    public final String getContent() {
        return this.content;
    }

    @e
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.title;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.content;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    @d
    public String toString() {
        return "CloseContent(title=" + ((Object) this.title) + ", content=" + ((Object) this.content) + ')';
    }

    public /* synthetic */ CloseContent(String str, String str2, int i2, u uVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2);
    }
}
