package com.tencent.android.tpush.data;

import java.io.Serializable;

/* loaded from: classes3.dex */
public class CachedMessageIntent implements Serializable {
    private static final long serialVersionUID = 1724218633838690967L;
    public long msgId;
    public String pkgName = "";
    public String intent = "";

    public boolean equals(Object obj) {
        if (obj instanceof CachedMessageIntent) {
            CachedMessageIntent cachedMessageIntent = (CachedMessageIntent) obj;
            return cachedMessageIntent.pkgName.equals(this.pkgName) && cachedMessageIntent.msgId == this.msgId;
        }
        return super.equals(obj);
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return "CachedMessageIntent [pkgName=" + this.pkgName + ", msgId=" + this.msgId + "]";
    }
}
