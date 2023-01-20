package com.qiniu.android.dns.dns;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.IDN;

/* loaded from: classes3.dex */
public class DnsRequest extends DnsMessage {
    private final String host;
    private final int recordType;

    public DnsRequest(short s, int i2, String str) {
        this(s, 0, 1, i2, str);
    }

    public String getHost() {
        return this.host;
    }

    public int getRecordType() {
        return this.recordType;
    }

    public byte[] toDnsQuestionData() throws IOException {
        String[] split;
        String str = this.host;
        if (str != null && str.length() != 0) {
            int i2 = this.opCode;
            if (i2 != 0 && i2 != 1 && i2 != 2 && i2 != 5) {
                throw new IOException("opCode is not valid");
            }
            int i3 = this.rd;
            if (i3 != 0 && i3 != 1) {
                throw new IOException("rd is not valid");
            }
            int i4 = this.recordType;
            if (i4 != 1 && i4 != 28 && i4 != 5 && i4 != 16) {
                throw new IOException("recordType is not valid");
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            dataOutputStream.writeShort(this.messageId);
            dataOutputStream.writeByte((this.opCode << 3) + this.rd);
            dataOutputStream.writeByte(0);
            dataOutputStream.writeByte(0);
            dataOutputStream.writeByte(1);
            dataOutputStream.writeByte(0);
            dataOutputStream.writeByte(0);
            dataOutputStream.writeByte(0);
            dataOutputStream.writeByte(0);
            dataOutputStream.writeByte(0);
            dataOutputStream.writeByte(0);
            for (String str2 : this.host.split("[.。．｡]")) {
                if (str2.length() <= 63) {
                    byte[] bytes = IDN.toASCII(str2).getBytes();
                    dataOutputStream.write(bytes.length);
                    dataOutputStream.write(bytes, 0, bytes.length);
                } else {
                    throw new IOException("host part is too long");
                }
            }
            dataOutputStream.writeByte(0);
            dataOutputStream.writeByte(0);
            dataOutputStream.writeByte(this.recordType);
            dataOutputStream.writeByte(0);
            dataOutputStream.writeByte(1);
            return byteArrayOutputStream.toByteArray();
        }
        throw new IOException("host can not empty");
    }

    public DnsRequest(short s, int i2, int i3, int i4, String str) {
        this.messageId = s;
        this.opCode = i2;
        this.rd = i3;
        this.recordType = i4;
        this.host = str;
    }
}
