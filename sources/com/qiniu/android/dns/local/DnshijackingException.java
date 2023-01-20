package com.qiniu.android.dns.local;

import com.qiniu.android.dns.DnsException;

/* loaded from: classes3.dex */
public class DnshijackingException extends DnsException {
    public DnshijackingException(String str, String str2) {
        super(str, "has hijacked by " + str2);
    }

    public DnshijackingException(String str, String str2, int i2) {
        super(str, "has hijacked by " + str2 + " ttl " + i2);
    }
}
