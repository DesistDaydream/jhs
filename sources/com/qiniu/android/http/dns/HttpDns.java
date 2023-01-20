package com.qiniu.android.http.dns;

import com.qiniu.android.dns.IResolver;
import com.qiniu.android.dns.dns.DohResolver;
import com.qiniu.android.storage.GlobalConfiguration;

/* loaded from: classes3.dex */
public class HttpDns extends BaseDns implements Dns {
    private IResolver httpIpv4Resolver;
    private IResolver httpIpv6Resolver;

    public HttpDns(int i2) {
        String[] dohIpv4Servers = GlobalConfiguration.getInstance().getDohIpv4Servers();
        if (dohIpv4Servers != null && dohIpv4Servers.length > 0) {
            this.httpIpv4Resolver = new DohResolver(dohIpv4Servers, 1, i2, BaseDns.executor);
        }
        String[] dohIpv6Servers = GlobalConfiguration.getInstance().getDohIpv6Servers();
        if (dohIpv6Servers == null || dohIpv6Servers.length <= 0) {
            return;
        }
        this.httpIpv6Resolver = new DohResolver(dohIpv6Servers, 1, i2, BaseDns.executor);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:(5:37|38|(2:33|34)|(3:19|(3:21|(2:27|28)(1:25)|26)|29)|30)|12|(1:14)|31|33|34|(4:17|19|(0)|29)|30) */
    /* JADX WARN: Removed duplicated region for block: B:30:0x004b  */
    @Override // com.qiniu.android.http.dns.Dns
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<com.qiniu.android.http.dns.IDnsNetworkAddress> lookup(java.lang.String r14) throws java.net.UnknownHostException {
        /*
            r13 = this;
            com.qiniu.android.storage.GlobalConfiguration r0 = com.qiniu.android.storage.GlobalConfiguration.getInstance()
            boolean r0 = r0.dohEnable
            r1 = 0
            if (r0 != 0) goto La
            return r1
        La:
            com.qiniu.android.dns.IResolver r0 = r13.httpIpv4Resolver
            if (r0 != 0) goto L1b
            com.qiniu.android.dns.IResolver r2 = r13.httpIpv6Resolver
            if (r2 == 0) goto L13
            goto L1b
        L13:
            java.net.UnknownHostException r14 = new java.net.UnknownHostException
            java.lang.String r0 = "resolver server is invalid"
            r14.<init>(r0)
            throw r14
        L1b:
            if (r0 == 0) goto L27
            com.qiniu.android.dns.Domain r2 = new com.qiniu.android.dns.Domain     // Catch: java.io.IOException -> L27
            r2.<init>(r14)     // Catch: java.io.IOException -> L27
            com.qiniu.android.dns.Record[] r0 = r0.resolve(r2, r1)     // Catch: java.io.IOException -> L27
            goto L28
        L27:
            r0 = r1
        L28:
            if (r0 == 0) goto L2d
            int r2 = r0.length
            if (r2 != 0) goto L3c
        L2d:
            com.qiniu.android.dns.IResolver r2 = r13.httpIpv6Resolver
            if (r2 == 0) goto L3c
            com.qiniu.android.dns.Domain r3 = new com.qiniu.android.dns.Domain     // Catch: java.io.IOException -> L3b
            r3.<init>(r14)     // Catch: java.io.IOException -> L3b
            com.qiniu.android.dns.Record[] r0 = r2.resolve(r3, r1)     // Catch: java.io.IOException -> L3b
            goto L3c
        L3b:
        L3c:
            if (r0 == 0) goto L8c
            int r2 = r0.length
            if (r2 != 0) goto L42
            goto L8c
        L42:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            int r2 = r0.length
            r3 = 0
        L49:
            if (r3 >= r2) goto L8c
            r4 = r0[r3]
            boolean r5 = r4.isA()
            if (r5 != 0) goto L59
            boolean r5 = r4.isAAAA()
            if (r5 == 0) goto L89
        L59:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "doh:<"
            r5.append(r6)
            java.lang.String r6 = r4.server
            r5.append(r6)
            java.lang.String r6 = ">"
            r5.append(r6)
            java.lang.String r11 = r5.toString()
            com.qiniu.android.http.dns.DnsNetworkAddress r5 = new com.qiniu.android.http.dns.DnsNetworkAddress
            java.lang.String r9 = r4.value
            long r6 = r4.timeStamp
            java.lang.Long r10 = java.lang.Long.valueOf(r6)
            long r6 = r4.timeStamp
            java.lang.Long r12 = java.lang.Long.valueOf(r6)
            r7 = r5
            r8 = r14
            r7.<init>(r8, r9, r10, r11, r12)
            r1.add(r5)
        L89:
            int r3 = r3 + 1
            goto L49
        L8c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiniu.android.http.dns.HttpDns.lookup(java.lang.String):java.util.List");
    }
}
