package com.qiniu.android.dns.local;

import com.qiniu.android.dns.Domain;
import com.qiniu.android.dns.IResolver;
import com.qiniu.android.dns.NetworkInfo;
import com.qiniu.android.dns.Record;
import com.qiniu.android.dns.dns.DnsUdpResolver;
import java.io.IOException;

/* loaded from: classes3.dex */
public final class HijackingDetectWrapper implements IResolver {
    private final DnsUdpResolver resolver;

    public HijackingDetectWrapper(DnsUdpResolver dnsUdpResolver) {
        this.resolver = dnsUdpResolver;
    }

    @Override // com.qiniu.android.dns.IResolver
    public Record[] resolve(Domain domain, NetworkInfo networkInfo) throws IOException {
        boolean z;
        Record[] resolve = this.resolver.resolve(domain, networkInfo);
        if (domain.hasCname) {
            String str = null;
            int length = resolve.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    z = false;
                    break;
                }
                Record record = resolve[i2];
                if (record.isCname()) {
                    str = record.server;
                    z = true;
                    break;
                }
                i2++;
            }
            if (!z) {
                throw new DnshijackingException(domain.domain, str);
            }
        }
        if (domain.maxTtl != 0) {
            for (Record record2 : resolve) {
                if (!record2.isCname() && record2.ttl > domain.maxTtl) {
                    throw new DnshijackingException(domain.domain, record2.server, record2.ttl);
                }
            }
        }
        return resolve;
    }
}
