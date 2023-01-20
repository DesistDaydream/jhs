package com.qiniu.android.dns.dns;

import com.qiniu.android.dns.Domain;
import com.qiniu.android.dns.IResolver;
import com.qiniu.android.dns.NetworkInfo;
import com.qiniu.android.dns.Record;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public abstract class DnsResolver implements IResolver {
    private final ExecutorService executorService;
    private final int recordType;
    private final String[] servers;
    public final int timeout;
    private static ScheduledExecutorService timeoutExecutorService = Executors.newSingleThreadScheduledExecutor();
    private static ExecutorService defaultExecutorService = new ThreadPoolExecutor(0, 4, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());

    public DnsResolver(String str) {
        this(str, 1, 10);
    }

    private DnsResponse lookupHost(String str) throws IOException {
        return request(str, this.recordType);
    }

    private DnsResponse request(final String str, final int i2) throws IOException {
        String[] strArr = this.servers;
        if (strArr != null && strArr.length != 0) {
            if (str != null && str.length() != 0) {
                String[] strArr2 = this.servers;
                DnsResponse dnsResponse = null;
                if (strArr2.length != 1 && this.executorService != null) {
                    final DnsResponse[] dnsResponseArr = {null};
                    final IOException[] iOExceptionArr = {null};
                    final int[] iArr = {0};
                    final Object obj = new Object();
                    timeoutExecutorService.schedule(new Callable<Object>() { // from class: com.qiniu.android.dns.dns.DnsResolver.1
                        @Override // java.util.concurrent.Callable
                        public Object call() throws Exception {
                            synchronized (obj) {
                                obj.notify();
                                IOException[] iOExceptionArr2 = iOExceptionArr;
                                iOExceptionArr2[0] = new IOException("resolver timeout for server:" + DnsResolver.this.servers.toString() + " host:" + str);
                            }
                            return null;
                        }
                    }, this.timeout, TimeUnit.SECONDS);
                    String[] strArr3 = this.servers;
                    int length = strArr3.length;
                    int i3 = 0;
                    while (i3 < length) {
                        final String str2 = strArr3[i3];
                        this.executorService.submit(new Runnable() { // from class: com.qiniu.android.dns.dns.DnsResolver.2
                            @Override // java.lang.Runnable
                            public void run() {
                                synchronized (obj) {
                                    try {
                                        dnsResponseArr[0] = DnsResolver.this.request(str2, str, i2);
                                    } catch (Exception e2) {
                                        e2.printStackTrace();
                                        iOExceptionArr[0] = new IOException(e2);
                                    }
                                    int[] iArr2 = iArr;
                                    iArr2[0] = iArr2[0] + 1;
                                    if (iArr2[0] == DnsResolver.this.servers.length || dnsResponseArr[0] != null) {
                                        obj.notify();
                                    }
                                }
                            }
                        });
                        i3++;
                        length = length;
                        strArr3 = strArr3;
                    }
                    synchronized (obj) {
                        try {
                            obj.wait();
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                        }
                    }
                    if (iOExceptionArr[0] == null) {
                        return dnsResponseArr[0];
                    }
                    throw iOExceptionArr[0];
                }
                for (String str3 : strArr2) {
                    dnsResponse = request(str3, str, i2);
                    if (dnsResponse != null) {
                        break;
                    }
                }
                return dnsResponse;
            }
            throw new IOException("host can not empty");
        }
        throw new IOException("server can not empty");
    }

    public abstract DnsResponse request(String str, String str2, int i2) throws IOException;

    @Override // com.qiniu.android.dns.IResolver
    public Record[] resolve(Domain domain, NetworkInfo networkInfo) throws IOException {
        DnsResponse lookupHost = lookupHost(domain.domain);
        if (lookupHost != null) {
            List<Record> answerArray = lookupHost.getAnswerArray();
            if (answerArray == null || answerArray.size() == 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Record record : answerArray) {
                if (record.isA() || record.isCname() || record.isAAAA()) {
                    arrayList.add(record);
                }
            }
            return (Record[]) arrayList.toArray(new Record[0]);
        }
        throw new IOException("response is null");
    }

    public DnsResolver(String str, int i2) {
        this(str, 1, i2);
    }

    public DnsResolver(String str, int i2, int i3) {
        this(str == null ? null : new String[]{str}, i2, i3, null);
    }

    public DnsResolver(String[] strArr, int i2, int i3) {
        this(strArr, i2, i3, (strArr == null || strArr.length <= 0) ? null : defaultExecutorService);
    }

    public DnsResolver(String[] strArr, int i2, int i3, ExecutorService executorService) {
        this.recordType = i2;
        this.timeout = i3 <= 0 ? 10 : i3;
        this.servers = strArr;
        this.executorService = executorService;
    }
}
