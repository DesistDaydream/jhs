package com.qiniu.android.dns;

import java.util.Date;
import java.util.Locale;

/* loaded from: classes3.dex */
public final class Record {
    public static final int TTL_Forever = -1;
    public static final int TTL_MIN_SECONDS = 600;
    public static final int TYPE_A = 1;
    public static final int TYPE_AAAA = 28;
    public static final int TYPE_CNAME = 5;
    public static final int TYPE_TXT = 16;
    public final String server;
    public final int source;
    public final long timeStamp;
    public final int ttl;
    public final int type;
    public final String value;

    /* loaded from: classes3.dex */
    public static class Source {
        public static final int Custom = 1;
        public static final int DnspodEnterprise = 2;
        public static final int Doh = 5;
        public static final int System = 3;
        public static final int Udp = 4;
        public static final int Unknown = 0;
    }

    public Record(String str, int i2, int i3) {
        this.value = str;
        this.type = i2;
        this.ttl = i3;
        this.timeStamp = new Date().getTime() / 1000;
        this.source = 0;
        this.server = null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Record)) {
            return false;
        }
        Record record = (Record) obj;
        return this.value.equals(record.value) && this.type == record.type && this.ttl == record.ttl && this.timeStamp == record.timeStamp;
    }

    public boolean isA() {
        return this.type == 1;
    }

    public boolean isAAAA() {
        return this.type == 28;
    }

    public boolean isCname() {
        return this.type == 5;
    }

    public boolean isExpired() {
        return isExpired(System.currentTimeMillis() / 1000);
    }

    public String toString() {
        return String.format(Locale.getDefault(), "{type:%s, value:%s, source:%s, server:%s, timestamp:%d, ttl:%d}", Integer.valueOf(this.type), this.value, Integer.valueOf(this.source), this.server, Long.valueOf(this.timeStamp), Integer.valueOf(this.ttl));
    }

    public boolean isExpired(long j2) {
        int i2 = this.ttl;
        return i2 != -1 && this.timeStamp + ((long) i2) < j2;
    }

    public Record(String str, int i2, int i3, long j2, int i4) {
        this.value = str;
        this.type = i2;
        this.ttl = Math.max(i3, 600);
        this.timeStamp = j2;
        this.source = i4;
        this.server = null;
    }

    public Record(String str, int i2, int i3, long j2, int i4, String str2) {
        this.value = str;
        this.type = i2;
        this.ttl = i3 < 600 ? 600 : i3;
        this.timeStamp = j2;
        this.source = i4;
        this.server = str2;
    }
}
