package com.qiniu.android.http.dns;

import com.qiniu.android.common.Config;
import com.qiniu.android.common.Zone;
import com.qiniu.android.common.ZoneInfo;
import com.qiniu.android.common.ZonesInfo;
import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.http.metrics.UploadRegionRequestMetrics;
import com.qiniu.android.storage.GlobalConfiguration;
import com.qiniu.android.storage.UpToken;
import com.qiniu.android.utils.AndroidNetwork;
import com.qiniu.android.utils.Utils;
import com.qiniu.android.utils.Wait;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public class DnsPrefetcher {
    private static final DnsPrefetcher dnsPrefetcher = new DnsPrefetcher();
    private Dns customDns;
    private DnsCacheFile diskCache;
    public String lastPrefetchErrorMessage;
    private boolean isPrefetching = false;
    private DnsCacheInfo dnsCacheInfo = null;
    private HashSet<String> prefetchHosts = new HashSet<>();
    private ConcurrentHashMap<String, List<IDnsNetworkAddress>> addressDictionary = new ConcurrentHashMap<>();
    private SystemDns systemDns = new SystemDns(GlobalConfiguration.getInstance().dnsResolveTimeout);

    private DnsPrefetcher() {
    }

    private void endPreFetch() {
        setPrefetching(false);
    }

    private String[] getCacheHosts() {
        return (String[]) this.prefetchHosts.toArray(new String[0]);
    }

    private String[] getCurrentZoneHosts(Zone zone, UpToken upToken) {
        ArrayList<ZoneInfo> arrayList;
        List<String> list;
        if (zone == null || upToken == null) {
            return null;
        }
        final Wait wait = new Wait();
        zone.preQuery(upToken, new Zone.QueryHandler() { // from class: com.qiniu.android.http.dns.DnsPrefetcher.1
            @Override // com.qiniu.android.common.Zone.QueryHandler
            public void complete(int i2, ResponseInfo responseInfo, UploadRegionRequestMetrics uploadRegionRequestMetrics) {
                wait.stopWait();
            }
        });
        wait.startWait();
        ZonesInfo zonesInfo = zone.getZonesInfo(upToken);
        ArrayList arrayList2 = new ArrayList();
        if (zonesInfo != null && (arrayList = zonesInfo.zonesInfo) != null && arrayList.size() > 0) {
            Iterator<ZoneInfo> it = zonesInfo.zonesInfo.iterator();
            while (it.hasNext()) {
                ZoneInfo next = it.next();
                if (next != null && (list = next.allHosts) != null) {
                    arrayList2.addAll(list);
                }
            }
        }
        return (String[]) arrayList2.toArray(new String[0]);
    }

    private synchronized Dns getCustomDns() {
        if (this.customDns == null) {
            this.customDns = GlobalConfiguration.getInstance().dns;
        }
        return this.customDns;
    }

    private synchronized DnsCacheFile getDiskCache() {
        if (this.diskCache == null) {
            try {
                this.diskCache = new DnsCacheFile(GlobalConfiguration.getInstance().dnsCacheDir);
            } catch (Exception unused) {
                this.diskCache = null;
            }
        }
        return this.diskCache;
    }

    private synchronized DnsCacheInfo getDnsCacheInfo() {
        return this.dnsCacheInfo;
    }

    public static DnsPrefetcher getInstance() {
        return dnsPrefetcher;
    }

    private String[] getLocalPreHost() {
        return new String[]{Config.upLogURL};
    }

    private void invalidNetworkAddressOfHost(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        this.addressDictionary.remove(str);
    }

    private boolean preFetchHost(String str, Dns dns) throws UnknownHostException {
        if (str == null || str.length() == 0) {
            return false;
        }
        List<IDnsNetworkAddress> list = this.addressDictionary.get(str);
        if (list == null || list.size() <= 0 || ((DnsNetworkAddress) list.get(0)).needRefresh()) {
            boolean z = dns == getCustomDns();
            UnknownHostException unknownHostException = null;
            ArrayList arrayList = new ArrayList();
            try {
                List<IDnsNetworkAddress> lookup = dns.lookup(str);
                if (lookup != null && lookup.size() > 0) {
                    for (IDnsNetworkAddress iDnsNetworkAddress : lookup) {
                        arrayList.add(new DnsNetworkAddress(iDnsNetworkAddress.getHostValue(), iDnsNetworkAddress.getIpValue(), Long.valueOf(iDnsNetworkAddress.getTtlValue() != null ? iDnsNetworkAddress.getTtlValue().longValue() : GlobalConfiguration.getInstance().dnsCacheTime), z ? DnsSource.Custom : iDnsNetworkAddress.getSourceValue(), iDnsNetworkAddress.getTimestampValue()));
                    }
                }
            } catch (UnknownHostException e2) {
                unknownHostException = e2;
            }
            if (arrayList.size() > 0) {
                this.addressDictionary.put(str, arrayList);
                return true;
            } else if (unknownHostException == null) {
                return false;
            } else {
                throw unknownHostException;
            }
        }
        return true;
    }

    private void preFetchHosts(String[] strArr) {
        String[] preFetchHosts;
        String[] preFetchHosts2;
        int i2 = GlobalConfiguration.getInstance().dnsResolveTimeout;
        String[] preFetchHosts3 = preFetchHosts(strArr, getCustomDns());
        if (preFetchHosts3 == null || preFetchHosts3.length == 0 || (preFetchHosts = preFetchHosts(preFetchHosts3, this.systemDns)) == null || preFetchHosts.length == 0 || (preFetchHosts2 = preFetchHosts(preFetchHosts, new HttpDns(i2))) == null || preFetchHosts2.length == 0) {
            return;
        }
        preFetchHosts(preFetchHosts2, new UdpDns(i2));
        recorderDnsCache();
    }

    private synchronized boolean prepareToPreFetch() {
        if (isDnsOpen()) {
            if (isPrefetching()) {
                return false;
            }
            String hostIP = AndroidNetwork.getHostIP();
            if (hostIP == null || getDnsCacheInfo() == null || !hostIP.equals(getDnsCacheInfo().getLocalIp())) {
                clearMemoryCache();
            }
            setPrefetching(true);
            return true;
        }
        return false;
    }

    private boolean recorderDnsCache() {
        DnsCacheFile diskCache = getDiskCache();
        if (diskCache == null) {
            return false;
        }
        String str = Utils.currentTimestamp() + "";
        String hostIP = AndroidNetwork.getHostIP();
        if (hostIP == null) {
            return false;
        }
        DnsCacheInfo dnsCacheInfo = new DnsCacheInfo(str, hostIP, this.addressDictionary);
        setDnsCacheInfo(dnsCacheInfo);
        byte[] jsonData = dnsCacheInfo.toJsonData();
        if (jsonData == null) {
            return false;
        }
        diskCache.set(dnsCacheInfo.cacheKey(), jsonData);
        return true;
    }

    private boolean recoverDnsCache(byte[] bArr) {
        DnsCacheInfo createDnsCacheInfoByData = DnsCacheInfo.createDnsCacheInfoByData(bArr);
        if (createDnsCacheInfoByData != null && createDnsCacheInfoByData.getInfo() != null && createDnsCacheInfoByData.getInfo().size() != 0) {
            this.addressDictionary.putAll(createDnsCacheInfoByData.getInfo());
            createDnsCacheInfoByData.setInfo(this.addressDictionary);
            setDnsCacheInfo(createDnsCacheInfoByData);
        }
        return false;
    }

    private synchronized void setDnsCacheInfo(DnsCacheInfo dnsCacheInfo) {
        this.dnsCacheInfo = dnsCacheInfo;
    }

    private synchronized void setPrefetching(boolean z) {
        this.isPrefetching = z;
    }

    public boolean addPreFetchHosts(String[] strArr) {
        boolean z;
        if (strArr == null) {
            return false;
        }
        synchronized (this) {
            int size = this.prefetchHosts.size();
            this.prefetchHosts.addAll(Arrays.asList(strArr));
            z = this.prefetchHosts.size() <= size;
        }
        if (z) {
            return false;
        }
        checkWhetherCachedDnsValid();
        return true;
    }

    public boolean checkAndPrefetchDnsIfNeed(Zone zone, UpToken upToken) {
        return addPreFetchHosts(getCurrentZoneHosts(zone, upToken));
    }

    public void checkWhetherCachedDnsValid() {
        String[] cacheHosts;
        if (prepareToPreFetch()) {
            synchronized (this) {
                cacheHosts = getCacheHosts();
            }
            preFetchHosts(cacheHosts);
            endPreFetch();
        }
    }

    public void clearDiskCache() throws IOException {
        DnsCacheFile diskCache = getDiskCache();
        if (diskCache == null) {
            return;
        }
        diskCache.clearCache();
    }

    public void clearDnsCache() throws IOException {
        clearMemoryCache();
        clearDiskCache();
    }

    public void clearMemoryCache() {
        this.addressDictionary.clear();
    }

    public List<IDnsNetworkAddress> getInetAddressByHost(String str) {
        List<IDnsNetworkAddress> list;
        if (isDnsOpen() && (list = this.addressDictionary.get(str)) != null && list.size() > 0 && ((DnsNetworkAddress) list.get(0)).isValid()) {
            return list;
        }
        return null;
    }

    public void invalidNetworkAddress(IDnsNetworkAddress iDnsNetworkAddress) {
        String hostValue;
        List<IDnsNetworkAddress> list;
        if (iDnsNetworkAddress == null || iDnsNetworkAddress.getHostValue() == null || (list = this.addressDictionary.get((hostValue = iDnsNetworkAddress.getHostValue()))) == null || list.size() == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (IDnsNetworkAddress iDnsNetworkAddress2 : list) {
            if (!iDnsNetworkAddress2.getIpValue().equals(iDnsNetworkAddress2.getIpValue())) {
                arrayList.add(iDnsNetworkAddress2);
            }
        }
        this.addressDictionary.put(hostValue, arrayList);
    }

    public boolean isDnsOpen() {
        return GlobalConfiguration.getInstance().isDnsOpen;
    }

    public synchronized boolean isPrefetching() {
        return this.isPrefetching;
    }

    public void localFetch() {
        addPreFetchHosts(getLocalPreHost());
    }

    public String lookupBySafeDns(String str) throws UnknownHostException {
        List<IDnsNetworkAddress> inetAddressByHost;
        List<IDnsNetworkAddress> inetAddressByHost2;
        if (str != null && str.length() != 0) {
            invalidNetworkAddressOfHost(str);
            int i2 = GlobalConfiguration.getInstance().dnsResolveTimeout;
            String[] preFetchHosts = preFetchHosts(new String[]{str}, getCustomDns());
            if ((preFetchHosts == null || preFetchHosts.length == 0) && (inetAddressByHost = getInetAddressByHost(str)) != null && inetAddressByHost.size() > 0) {
                return inetAddressByHost.get(0).getSourceValue();
            }
            String[] preFetchHosts2 = preFetchHosts(preFetchHosts, new HttpDns(i2));
            if ((preFetchHosts2 == null || preFetchHosts2.length == 0) && (inetAddressByHost2 = getInetAddressByHost(str)) != null && inetAddressByHost2.size() > 0) {
                return inetAddressByHost2.get(0).getSourceValue();
            }
        }
        return null;
    }

    public boolean recoverCache() {
        byte[] bArr;
        DnsCacheFile diskCache = getDiskCache();
        if (diskCache == null) {
            return false;
        }
        String hostIP = AndroidNetwork.getHostIP();
        if (hostIP == null || hostIP.length() == 0 || (bArr = diskCache.get(hostIP)) == null) {
            return true;
        }
        return recoverDnsCache(bArr);
    }

    private String[] preFetchHosts(String[] strArr, Dns dns) {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        if (dns == null) {
            return strArr;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            boolean z = false;
            for (int i2 = 0; i2 < GlobalConfiguration.getInstance().dnsRepreHostNum; i2++) {
                try {
                    z = preFetchHost(str, dns);
                } catch (UnknownHostException e2) {
                    this.lastPrefetchErrorMessage = e2.toString();
                }
                if (z) {
                    break;
                }
            }
            if (!z) {
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }
}
