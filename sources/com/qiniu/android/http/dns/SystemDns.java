package com.qiniu.android.http.dns;

import com.qiniu.android.storage.GlobalConfiguration;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class SystemDns extends BaseDns implements Dns {
    public SystemDns() {
    }

    @Override // com.qiniu.android.http.dns.Dns
    public List<IDnsNetworkAddress> lookup(String str) throws UnknownHostException {
        long time = new Date().getTime() / 1000;
        long j2 = GlobalConfiguration.getInstance().dnsCacheTime;
        ArrayList arrayList = new ArrayList();
        for (InetAddress inetAddress : lookupInetAddress(str)) {
            arrayList.add(new DnsNetworkAddress(inetAddress.getHostName(), inetAddress.getHostAddress(), Long.valueOf(j2), DnsSource.System, Long.valueOf(time)));
        }
        return arrayList;
    }

    public List<InetAddress> lookupInetAddress(final String str) throws UnknownHostException {
        if (str != null) {
            try {
                return (List) BaseDns.executor.submit(new Callable<List<InetAddress>>() { // from class: com.qiniu.android.http.dns.SystemDns.1
                    @Override // java.util.concurrent.Callable
                    public List<InetAddress> call() throws Exception {
                        return Arrays.asList(InetAddress.getAllByName(str));
                    }
                }).get(this.timeout, TimeUnit.SECONDS);
            } catch (Exception e2) {
                UnknownHostException unknownHostException = new UnknownHostException("dns broken when lookup of " + str);
                unknownHostException.initCause(e2);
                throw unknownHostException;
            }
        }
        throw new UnknownHostException("hostname is null");
    }

    public SystemDns(int i2) {
        this.timeout = i2;
    }
}
