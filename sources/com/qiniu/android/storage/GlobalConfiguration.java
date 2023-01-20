package com.qiniu.android.storage;

import android.content.Context;
import com.qiniu.android.http.dns.Dns;
import com.qiniu.android.utils.Utils;

/* loaded from: classes3.dex */
public class GlobalConfiguration {
    public static Context appContext;
    public static String[] DefaultUdpDnsIpv4Servers = {"223.5.5.5", "114.114.114.114", "1.1.1.1", "208.67.222.222"};
    public static String[] DefaultUdpDnsIpv6Servers = null;
    public static String[] DefaultDohIpv4Servers = {"https://223.6.6.6/dns-query", "https://8.8.8.8/dns-query"};
    public static String[] DefaultDohIpv6Servers = null;
    private static GlobalConfiguration configuration = new GlobalConfiguration();
    public boolean isDnsOpen = true;
    public int dnsRepreHostNum = 2;
    public int dnsResolveTimeout = 3;
    public int dnsCacheTime = 120;
    public int dnsCacheMaxTTL = 600;
    public Dns dns = null;
    public String dnsCacheDir = Utils.sdkDirectory() + "/dnsCache/";
    public boolean udpDnsEnable = true;
    public String[] udpDnsIpv4Servers = null;
    public String[] udpDnsIpv6Servers = null;
    public boolean dohEnable = true;
    public String[] dohIpv4Servers = null;
    public String[] dohIpv6Servers = null;
    public int globalHostFrozenTime = 10;
    public int partialHostFrozenTime = 300;
    public String[] connectCheckURLStrings = {"https://www.qiniu.com", "https://www.baidu.com", "https://www.google.com"};
    public int connectCheckTimeout = 2;
    public boolean connectCheckEnable = true;

    private GlobalConfiguration() {
    }

    public static GlobalConfiguration getInstance() {
        return configuration;
    }

    public String[] getDohIpv4Servers() {
        String[] strArr = this.dohIpv4Servers;
        return strArr != null ? strArr : DefaultDohIpv4Servers;
    }

    public String[] getDohIpv6Servers() {
        String[] strArr = this.dohIpv6Servers;
        return strArr != null ? strArr : DefaultDohIpv6Servers;
    }

    public String[] getUdpDnsIpv4Servers() {
        String[] strArr = this.udpDnsIpv4Servers;
        return strArr != null ? strArr : DefaultUdpDnsIpv4Servers;
    }

    public String[] getUdpDnsIpv6Servers() {
        String[] strArr = this.udpDnsIpv6Servers;
        return strArr != null ? strArr : DefaultUdpDnsIpv6Servers;
    }
}
