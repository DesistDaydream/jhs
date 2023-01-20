package com.xiaomi.push;

import java.io.IOException;

/* loaded from: classes3.dex */
public class cd extends IOException {
    public cd(String str) {
        super(str);
    }

    public static cd a() {
        return new cd("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }

    public static cd b() {
        return new cd("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public static cd c() {
        return new cd("CodedInputStream encountered a malformed varint.");
    }

    public static cd d() {
        return new cd("Protocol message contained an invalid tag (zero).");
    }

    public static cd e() {
        return new cd("Protocol message end-group tag did not match expected tag.");
    }

    public static cd f() {
        return new cd("Protocol message tag had invalid wire type.");
    }

    public static cd g() {
        return new cd("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    public static cd h() {
        return new cd("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }
}
