package com.qiniu.android.http.dns;

import com.qiniu.android.dns.DnsManager;
import com.qiniu.android.storage.GlobalConfiguration;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.List;

@Deprecated
/* loaded from: classes3.dex */
public class HappyDns implements Dns {
    private DnsQueryErrorHandler errorHandler;
    private SystemDns systemDns = new SystemDns(GlobalConfiguration.getInstance().dnsResolveTimeout);
    private Dns customDns = GlobalConfiguration.getInstance().dns;

    /* loaded from: classes3.dex */
    public interface DnsQueryErrorHandler extends DnsManager.QueryErrorHandler {
    }

    private void handleDnsError(IOException iOException, String str) {
        DnsQueryErrorHandler dnsQueryErrorHandler = this.errorHandler;
        if (dnsQueryErrorHandler != null) {
            dnsQueryErrorHandler.queryError(iOException, str);
        }
    }

    @Override // com.qiniu.android.http.dns.Dns
    public List<IDnsNetworkAddress> lookup(String str) throws UnknownHostException {
        int i2 = GlobalConfiguration.getInstance().dnsResolveTimeout;
        Dns dns = this.customDns;
        List<IDnsNetworkAddress> list = null;
        if (dns != null) {
            try {
                list = dns.lookup(str);
            } catch (IOException e2) {
                handleDnsError(e2, str);
            }
            if (list != null && list.size() > 0) {
                return list;
            }
        }
        try {
            list = this.systemDns.lookup(str);
        } catch (IOException e3) {
            handleDnsError(e3, str);
        }
        if (list == null || list.size() <= 0) {
            try {
                list = new HttpDns(i2).lookup(str);
            } catch (IOException e4) {
                handleDnsError(e4, str);
            }
            if (list == null || list.size() <= 0) {
                try {
                    return new UdpDns(i2).lookup(str);
                } catch (IOException e5) {
                    handleDnsError(e5, str);
                    return list;
                }
            }
            return list;
        }
        return list;
    }

    public void setQueryErrorHandler(DnsQueryErrorHandler dnsQueryErrorHandler) {
        this.errorHandler = dnsQueryErrorHandler;
    }
}
