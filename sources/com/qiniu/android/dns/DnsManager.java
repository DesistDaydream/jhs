package com.qiniu.android.dns;

import com.qiniu.android.dns.local.Hosts;
import com.qiniu.android.dns.util.LruCache;
import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public final class DnsManager {
    private final LruCache<String, Record[]> cache;
    private final Hosts hosts;
    private volatile int index;
    private volatile NetworkInfo info;
    public QueryErrorHandler queryErrorHandler;
    private final IResolver[] resolvers;
    private final RecordSorter sorter;

    /* loaded from: classes3.dex */
    public static class DummySorter implements RecordSorter {
        private AtomicInteger pos;

        private DummySorter() {
            this.pos = new AtomicInteger();
        }

        @Override // com.qiniu.android.dns.RecordSorter
        public Record[] sort(Record[] recordArr) {
            return recordArr;
        }
    }

    /* loaded from: classes3.dex */
    public interface QueryErrorHandler {
        void queryError(Exception exc, String str);
    }

    public DnsManager(NetworkInfo networkInfo, IResolver[] iResolverArr) {
        this(networkInfo, iResolverArr, null);
    }

    private void clearCache() {
        synchronized (this.cache) {
            this.cache.clear();
        }
    }

    private static Record[] filterInvalidRecords(Record[] recordArr) {
        String str;
        if (recordArr == null || recordArr.length == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(recordArr.length);
        for (Record record : recordArr) {
            if (record != null && (str = record.value) != null && str.length() > 0 && !record.isExpired()) {
                arrayList.add(record);
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        return (Record[]) arrayList.toArray(new Record[arrayList.size()]);
    }

    public static boolean needHttpDns() {
        try {
            String id = TimeZone.getDefault().getID();
            if (!"Asia/Shanghai".equals(id) && !"Asia/Chongqing".equals(id) && !"Asia/Harbin".equals(id)) {
                if (!"Asia/Urumqi".equals(id)) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:69:0x00c8, code lost:
        if (r1.length != 0) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00cb, code lost:
        r0 = trimCname(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00d0, code lost:
        if (r0.length == 0) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00d2, code lost:
        r1 = r10.cache;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00d4, code lost:
        monitor-enter(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00d5, code lost:
        r10.cache.put(r11.domain, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00dc, code lost:
        monitor-exit(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00dd, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x00e8, code lost:
        throw new java.net.UnknownHostException("no A/AAAA records");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.qiniu.android.dns.Record[] queryRecordInternal(com.qiniu.android.dns.Domain r11) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 278
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiniu.android.dns.DnsManager.queryRecordInternal(com.qiniu.android.dns.Domain):com.qiniu.android.dns.Record[]");
    }

    private static String[] records2Ip(Record[] recordArr) {
        if (recordArr == null || recordArr.length == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(recordArr.length);
        for (Record record : recordArr) {
            arrayList.add(record.value);
        }
        if (arrayList.size() == 0) {
            return null;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    private static Record[] trimCname(Record[] recordArr) {
        ArrayList arrayList = new ArrayList(recordArr.length);
        for (Record record : recordArr) {
            if (record != null && (record.isA() || record.isAAAA())) {
                arrayList.add(record);
            }
        }
        return (Record[]) arrayList.toArray(new Record[arrayList.size()]);
    }

    public static boolean validIP(String str) {
        if (str == null || str.length() < 7 || str.length() > 15 || str.contains(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
            return false;
        }
        try {
            int indexOf = str.indexOf(46);
            if (indexOf == -1 || Integer.parseInt(str.substring(0, indexOf)) <= 255) {
                int i2 = indexOf + 1;
                int indexOf2 = str.indexOf(46, i2);
                if (indexOf2 == -1 || Integer.parseInt(str.substring(i2, indexOf2)) <= 255) {
                    int i3 = indexOf2 + 1;
                    int indexOf3 = str.indexOf(46, i3);
                    if (indexOf3 != -1 && Integer.parseInt(str.substring(i3, indexOf3)) > 255 && Integer.parseInt(str.substring(indexOf3 + 1, str.length() - 1)) > 255) {
                        if (str.charAt(str.length() - 1) != '.') {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            }
            return false;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public void onNetworkChange(NetworkInfo networkInfo) {
        clearCache();
        if (networkInfo == null) {
            networkInfo = NetworkInfo.normal;
        }
        this.info = networkInfo;
        synchronized (this.resolvers) {
            this.index = 0;
        }
    }

    public DnsManager putHosts(String str, Record record, int i2) {
        this.hosts.put(str, new Hosts.Value(new Record(record.value, record.type, record.ttl, record.timeStamp, 1, record.server), i2));
        return this;
    }

    public InetAddress[] queryInetAdress(Domain domain) throws IOException {
        String[] records2Ip = records2Ip(queryRecords(domain));
        if (records2Ip == null || records2Ip.length == 0) {
            return null;
        }
        InetAddress[] inetAddressArr = new InetAddress[records2Ip.length];
        for (int i2 = 0; i2 < records2Ip.length; i2++) {
            inetAddressArr[i2] = InetAddress.getByName(records2Ip[i2]);
        }
        return inetAddressArr;
    }

    public Record[] queryRecords(String str) throws IOException {
        return queryRecords(new Domain(str));
    }

    public DnsManager(NetworkInfo networkInfo, IResolver[] iResolverArr, RecordSorter recordSorter) {
        this.hosts = new Hosts();
        this.info = null;
        this.index = 0;
        this.info = networkInfo == null ? NetworkInfo.normal : networkInfo;
        this.resolvers = (IResolver[]) iResolverArr.clone();
        this.cache = new LruCache<>();
        this.sorter = recordSorter == null ? new DummySorter() : recordSorter;
    }

    public Record[] queryRecords(Domain domain) throws IOException {
        if (domain != null) {
            String str = domain.domain;
            if (str != null && str.trim().length() != 0) {
                return validIP(domain.domain) ? new Record[]{new Record(domain.domain, 1, -1, new Date().getTime(), 0)} : this.sorter.sort(queryRecordInternal(domain));
            }
            throw new IOException("empty domain " + domain.domain);
        }
        throw new IOException("null domain");
    }

    public DnsManager putHosts(String str, int i2, String str2, int i3) {
        putHosts(str, new Record(str2, i2, -1, new Date().getTime() / 1000, 1), i3);
        return this;
    }

    public DnsManager putHosts(String str, int i2, String str2) {
        putHosts(str, i2, str2, 0);
        return this;
    }

    public DnsManager putHosts(String str, String str2) {
        putHosts(str, 1, str2);
        return this;
    }
}
