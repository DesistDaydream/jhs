package com.qiniu.android.dns.dns;

/* loaded from: classes3.dex */
public class DnsMessage {
    public static final int OpCodeIQuery = 1;
    public static final int OpCodeQuery = 0;
    public static final int OpCodeStatus = 2;
    public static final int OpCodeUpdate = 5;
    public short messageId = 0;
    public int opCode = 0;
    public int rd = 1;
    public int ra = 0;

    public int getMessageId() {
        return this.messageId;
    }

    public int getOpCode() {
        return this.opCode;
    }

    public int getRA() {
        return this.ra;
    }

    public int getRD() {
        return this.rd;
    }
}
