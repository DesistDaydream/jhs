package com.qiniu.android.dns.dns;

import com.qiniu.android.dns.Record;
import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.net.IDN;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* loaded from: classes3.dex */
public class DnsResponse extends DnsMessage {
    private int aa;
    private List<Record> additionalArray;
    private List<Record> answerArray;
    private List<Record> authorityArray;
    private int rCode;
    private byte[] recordData;
    private DnsRequest request;
    private String server;
    private int source;
    private long timestamp;

    /* loaded from: classes3.dex */
    public static class RecordName {
        private String name;
        private int skipLength;

        private RecordName() {
        }
    }

    /* loaded from: classes3.dex */
    public static class RecordResource {
        private final int count;
        private final int from;
        private int length;
        private final String name;
        private final List<Record> records;

        /* JADX INFO: Access modifiers changed from: private */
        public void addRecord(Record record) {
            if (record != null) {
                this.records.add(record);
            }
        }

        private RecordResource(String str, int i2, int i3) {
            this.name = str;
            this.count = i2;
            this.from = i3;
            this.length = 0;
            this.records = new ArrayList();
        }
    }

    public DnsResponse(String str, int i2, DnsRequest dnsRequest, byte[] bArr) throws IOException {
        if (bArr != null && bArr.length != 0) {
            this.server = str;
            this.source = i2;
            this.request = dnsRequest;
            this.recordData = bArr;
            this.timestamp = new Date().getTime() / 1000;
            parse();
            return;
        }
        throw new IOException("response data is empty");
    }

    private RecordName getNameFrom(int i2) throws IOException {
        StringBuilder sb = new StringBuilder();
        RecordName recordName = new RecordName();
        int i3 = 128;
        int i4 = i2;
        do {
            int readRecordDataInt8 = readRecordDataInt8(i4);
            int i5 = readRecordDataInt8 & 192;
            if (i5 == 192) {
                if (recordName.skipLength < 1) {
                    recordName.skipLength = (i4 + 2) - i2;
                }
                i4 = readRecordDataInt8(i4 + 1) | ((readRecordDataInt8 & 63) << 8);
            } else if (i5 > 0) {
                return null;
            } else {
                i4++;
                if (readRecordDataInt8 > 0) {
                    if (sb.length() > 0) {
                        sb.append(".");
                    }
                    int i6 = i4 + readRecordDataInt8;
                    sb.append(IDN.toUnicode(new String(Arrays.copyOfRange(this.recordData, i4, i6))));
                    i4 = i6;
                }
            }
            if (readRecordDataInt8 <= 0) {
                break;
            }
            i3--;
        } while (i3 > 0);
        recordName.name = sb.toString();
        if (recordName.skipLength < 1) {
            recordName.skipLength = i4 - i2;
        }
        return recordName;
    }

    private void parse() throws IOException {
        if (this.recordData.length >= 12) {
            parseHeader();
            int parseQuestion = parseQuestion();
            RecordResource recordResource = new RecordResource("answer", readRecordDataInt16(6), parseQuestion);
            parseResourceRecord(recordResource);
            this.answerArray = recordResource.records;
            int i2 = parseQuestion + recordResource.length;
            RecordResource recordResource2 = new RecordResource("authority", readRecordDataInt16(8), i2);
            parseResourceRecord(recordResource2);
            this.authorityArray = recordResource2.records;
            RecordResource recordResource3 = new RecordResource("additional", readRecordDataInt16(10), i2 + recordResource2.length);
            parseResourceRecord(recordResource3);
            this.additionalArray = recordResource3.records;
            return;
        }
        throw new IOException("response data too small");
    }

    private void parseHeader() throws IOException {
        short readRecordDataInt16 = readRecordDataInt16(0);
        this.messageId = readRecordDataInt16;
        if (readRecordDataInt16 == this.request.messageId) {
            int readRecordDataInt8 = readRecordDataInt8(2);
            if ((readRecordDataInt8(2) & 128) != 0) {
                this.opCode = (readRecordDataInt8 >> 3) & 7;
                this.aa = (readRecordDataInt8 >> 2) & 1;
                this.rd = readRecordDataInt8 & 1;
                int readRecordDataInt82 = readRecordDataInt8(3);
                this.ra = (readRecordDataInt82 >> 7) & 1;
                this.rCode = readRecordDataInt82 & 15;
                return;
            }
            throw new IOException("not a response data");
        }
        throw new IOException("question id error");
    }

    private int parseQuestion() throws IOException {
        int i2 = 12;
        for (int readRecordDataInt16 = readRecordDataInt16(4); readRecordDataInt16 > 0; readRecordDataInt16--) {
            RecordName nameFrom = getNameFrom(i2);
            if (nameFrom != null) {
                i2 += nameFrom.skipLength + 4;
            } else {
                throw new IOException("read Question error");
            }
        }
        return i2;
    }

    private void parseResourceRecord(RecordResource recordResource) throws IOException {
        int i2 = recordResource.from;
        for (int i3 = recordResource.count; i3 > 0; i3--) {
            RecordName nameFrom = getNameFrom(i2);
            if (nameFrom != null) {
                int i4 = i2 + nameFrom.skipLength;
                short readRecordDataInt16 = readRecordDataInt16(i4);
                int i5 = i4 + 2;
                short readRecordDataInt162 = readRecordDataInt16(i5);
                int i6 = i5 + 2;
                int readRecordDataInt32 = readRecordDataInt32(i6);
                int i7 = i6 + 4;
                short readRecordDataInt163 = readRecordDataInt16(i7);
                int i8 = i7 + 2;
                String readData = readData(readRecordDataInt16, i8, readRecordDataInt163);
                if (readRecordDataInt162 == 1 && (readRecordDataInt16 == 5 || readRecordDataInt16 == this.request.getRecordType())) {
                    recordResource.addRecord(new Record(readData, readRecordDataInt16, readRecordDataInt32, this.timestamp, this.source, this.server));
                }
                i2 = i8 + readRecordDataInt163;
            } else {
                throw new IOException("read " + recordResource.name + " error");
            }
        }
        recordResource.length = i2 - recordResource.from;
    }

    private String readData(int i2, int i3, int i4) throws IOException {
        if (i2 != 1) {
            if (i2 != 5) {
                if (i2 != 16) {
                    if (i2 == 28 && i4 == 16) {
                        StringBuilder sb = new StringBuilder();
                        int i5 = 0;
                        while (i5 < 16) {
                            sb.append(i5 > 0 ? Constants.COLON_SEPARATOR : "");
                            int i6 = i3 + i5;
                            sb.append(readRecordDataInt8(i6));
                            sb.append(readRecordDataInt8(i6 + 1));
                            i5 += 2;
                        }
                        return sb.toString();
                    }
                } else if (i4 > 0) {
                    int i7 = i4 + i3;
                    byte[] bArr = this.recordData;
                    if (i7 < bArr.length) {
                        return IDN.toUnicode(new String(Arrays.copyOfRange(bArr, i3, i7)));
                    }
                }
            } else if (i4 > 1) {
                return getNameFrom(i3).name;
            }
        } else if (i4 == 4) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(readRecordDataInt8(i3));
            for (int i8 = 1; i8 < 4; i8++) {
                sb2.append(".");
                sb2.append(readRecordDataInt8(i3 + i8));
            }
            return sb2.toString();
        }
        return null;
    }

    private short readRecordDataInt16(int i2) throws IOException {
        int i3 = i2 + 1;
        byte[] bArr = this.recordData;
        if (i3 < bArr.length) {
            return (short) (((bArr[i2] & 255) << 8) + (bArr[i3] & 255));
        }
        throw new IOException("read response data out of range");
    }

    private int readRecordDataInt32(int i2) throws IOException {
        int i3 = i2 + 3;
        byte[] bArr = this.recordData;
        if (i3 < bArr.length) {
            return ((bArr[i2] & 255) << 24) + ((bArr[i2 + 1] & 255) << 16) + ((bArr[i2 + 2] & 255) << 8) + (bArr[i3] & 255);
        }
        throw new IOException("read response data out of range");
    }

    private int readRecordDataInt8(int i2) throws IOException {
        byte[] bArr = this.recordData;
        if (i2 < bArr.length) {
            return bArr[i2] & 255;
        }
        throw new IOException("read response data out of range");
    }

    public int getAA() {
        return this.aa;
    }

    public List<Record> getAdditionalArray() {
        return this.additionalArray;
    }

    public List<Record> getAnswerArray() {
        return this.answerArray;
    }

    public List<Record> getAuthorityArray() {
        return this.authorityArray;
    }

    public int getRCode() {
        return this.rCode;
    }

    public String toString() {
        return String.format(Locale.getDefault(), "{messageId:%d, rd:%d, ra:%d, aa:%d, rCode:%d, server:%s, request:%s, answerArray:%s, authorityArray:%s, additionalArray:%s}", Short.valueOf(this.messageId), Integer.valueOf(this.rd), Integer.valueOf(this.ra), Integer.valueOf(this.aa), Integer.valueOf(this.rCode), this.server, this.request, this.answerArray, this.authorityArray, this.additionalArray);
    }
}
