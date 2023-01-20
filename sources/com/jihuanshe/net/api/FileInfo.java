package com.jihuanshe.net.api;

import android.net.Uri;
import androidx.annotation.Keep;
import e.j.e.r.c;
import h.k2.v.f0;
import h.k2.v.u;
import k.e.a.d;
import k.e.a.e;

@Keep
/* loaded from: classes2.dex */
public final class FileInfo {
    @c("filename")
    @e
    private final String filename;
    @e
    private final String showPath;
    @e
    private final Uri uri;
    @c("url")
    @e
    private final String url;

    public FileInfo() {
        this(null, null, null, null, 15, null);
    }

    public FileInfo(@e String str, @e String str2, @e Uri uri, @e String str3) {
        this.filename = str;
        this.url = str2;
        this.uri = uri;
        this.showPath = str3;
    }

    public static /* synthetic */ FileInfo copy$default(FileInfo fileInfo, String str, String str2, Uri uri, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = fileInfo.filename;
        }
        if ((i2 & 2) != 0) {
            str2 = fileInfo.url;
        }
        if ((i2 & 4) != 0) {
            uri = fileInfo.uri;
        }
        if ((i2 & 8) != 0) {
            str3 = fileInfo.showPath;
        }
        return fileInfo.copy(str, str2, uri, str3);
    }

    @e
    public final String component1() {
        return this.filename;
    }

    @e
    public final String component2() {
        return this.url;
    }

    @e
    public final Uri component3() {
        return this.uri;
    }

    @e
    public final String component4() {
        return this.showPath;
    }

    @d
    public final FileInfo copy(@e String str, @e String str2, @e Uri uri, @e String str3) {
        return new FileInfo(str, str2, uri, str3);
    }

    public boolean equals(@e Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FileInfo) {
            FileInfo fileInfo = (FileInfo) obj;
            return f0.g(this.filename, fileInfo.filename) && f0.g(this.url, fileInfo.url) && f0.g(this.uri, fileInfo.uri) && f0.g(this.showPath, fileInfo.showPath);
        }
        return false;
    }

    @e
    public final String getFilename() {
        return this.filename;
    }

    @e
    public final String getShowPath() {
        return this.showPath;
    }

    @e
    public final Uri getUri() {
        return this.uri;
    }

    @e
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        String str = this.filename;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.url;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Uri uri = this.uri;
        int hashCode3 = (hashCode2 + (uri == null ? 0 : uri.hashCode())) * 31;
        String str3 = this.showPath;
        return hashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    @d
    public String toString() {
        return "FileInfo(filename=" + ((Object) this.filename) + ", url=" + ((Object) this.url) + ", uri=" + this.uri + ", showPath=" + ((Object) this.showPath) + ')';
    }

    public /* synthetic */ FileInfo(String str, String str2, Uri uri, String str3, int i2, u uVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : uri, (i2 & 8) != 0 ? null : str3);
    }
}
