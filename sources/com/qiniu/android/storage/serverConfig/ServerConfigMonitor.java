package com.qiniu.android.storage.serverConfig;

import com.qiniu.android.common.AutoZone;
import com.qiniu.android.http.dns.DnsPrefetcher;
import com.qiniu.android.storage.GlobalConfiguration;
import com.qiniu.android.storage.serverConfig.ServerConfig;
import com.qiniu.android.storage.serverConfig.ServerConfigSynchronizer;
import com.qiniu.android.transaction.TransactionManager;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class ServerConfigMonitor {
    private static final String TransactionKey = "ServerConfig";
    private static ServerConfigMonitor configMonitor = new ServerConfigMonitor();
    private boolean enable = true;
    private ServerConfigCache cache = new ServerConfigCache();

    public static synchronized void endMonitor() {
        synchronized (ServerConfigMonitor.class) {
            TransactionManager transactionManager = TransactionManager.getInstance();
            ArrayList<TransactionManager.Transaction> transactionsForName = transactionManager.transactionsForName(TransactionKey);
            if (transactionsForName != null) {
                for (TransactionManager.Transaction transaction : transactionsForName) {
                    transactionManager.removeTransaction(transaction);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleServerConfig(ServerConfig serverConfig) {
        if (serverConfig == null) {
            return;
        }
        ServerConfig config = this.cache.getConfig();
        ServerConfig.RegionConfig regionConfig = serverConfig.getRegionConfig();
        ServerConfig.RegionConfig regionConfig2 = config != null ? config.getRegionConfig() : null;
        if (regionConfig != null && regionConfig2 != null && regionConfig.getClearId() > regionConfig2.getClearId() && regionConfig.getClearCache()) {
            AutoZone.clearCache();
        }
        ServerConfig.DnsConfig dnsConfig = serverConfig.getDnsConfig();
        if (dnsConfig != null) {
            if (dnsConfig.getEnable() != null) {
                GlobalConfiguration.getInstance().isDnsOpen = dnsConfig.getEnable().booleanValue();
            }
            ServerConfig.DnsConfig dnsConfig2 = config != null ? config.getDnsConfig() : null;
            if (dnsConfig2 != null && dnsConfig.getClearId() > dnsConfig2.getClearId() && dnsConfig.getClearCache()) {
                try {
                    DnsPrefetcher.getInstance().clearDnsCache();
                } catch (Exception unused) {
                }
            }
            ServerConfig.UdpDnsConfig udpDnsConfig = dnsConfig.getUdpDnsConfig();
            if (udpDnsConfig != null) {
                if (udpDnsConfig.getEnable() != null) {
                    GlobalConfiguration.getInstance().udpDnsEnable = udpDnsConfig.getEnable().booleanValue();
                }
                ServerConfig.DnsServer ipv4Server = udpDnsConfig.getIpv4Server();
                if (ipv4Server != null && ipv4Server.getIsOverride()) {
                    GlobalConfiguration.DefaultUdpDnsIpv4Servers = ipv4Server.getServers();
                }
                ServerConfig.DnsServer ipv6Server = udpDnsConfig.getIpv6Server();
                if (ipv6Server != null && ipv6Server.getIsOverride()) {
                    GlobalConfiguration.DefaultUdpDnsIpv6Servers = ipv6Server.getServers();
                }
            }
            ServerConfig.DohDnsConfig dohDnsConfig = dnsConfig.getDohDnsConfig();
            if (dohDnsConfig != null) {
                if (dohDnsConfig.getEnable() != null) {
                    GlobalConfiguration.getInstance().dohEnable = dohDnsConfig.getEnable().booleanValue();
                }
                ServerConfig.DnsServer ipv4Server2 = dohDnsConfig.getIpv4Server();
                if (ipv4Server2 != null && ipv4Server2.getIsOverride()) {
                    GlobalConfiguration.DefaultDohIpv4Servers = ipv4Server2.getServers();
                }
                ServerConfig.DnsServer ipv6Server2 = dohDnsConfig.getIpv6Server();
                if (ipv6Server2 == null || !ipv6Server2.getIsOverride()) {
                    return;
                }
                GlobalConfiguration.DefaultDohIpv6Servers = ipv6Server2.getServers();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleServerUserConfig(ServerUserConfig serverUserConfig) {
        if (serverUserConfig == null || serverUserConfig.getNetworkCheckEnable() == null) {
            return;
        }
        GlobalConfiguration.getInstance().connectCheckEnable = serverUserConfig.getNetworkCheckEnable().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void monitor() {
        if (this.enable) {
            if (this.cache.getConfig() == null) {
                ServerConfig configFromDisk = this.cache.getConfigFromDisk();
                handleServerConfig(configFromDisk);
                this.cache.setConfig(configFromDisk);
            }
            ServerConfig config = this.cache.getConfig();
            if (config == null || !config.isValid()) {
                ServerConfigSynchronizer.getServerConfigFromServer(new ServerConfigSynchronizer.ServerConfigHandler() { // from class: com.qiniu.android.storage.serverConfig.ServerConfigMonitor.2
                    @Override // com.qiniu.android.storage.serverConfig.ServerConfigSynchronizer.ServerConfigHandler
                    public void handle(ServerConfig serverConfig) {
                        if (serverConfig == null) {
                            return;
                        }
                        ServerConfigMonitor.this.handleServerConfig(serverConfig);
                        ServerConfigMonitor.this.cache.setConfig(serverConfig);
                        ServerConfigMonitor.this.cache.saveConfigToDisk(serverConfig);
                    }
                });
            }
            if (this.cache.getUserConfig() == null) {
                ServerUserConfig userConfigFromDisk = this.cache.getUserConfigFromDisk();
                handleServerUserConfig(userConfigFromDisk);
                this.cache.setUserConfig(userConfigFromDisk);
            }
            ServerUserConfig userConfig = this.cache.getUserConfig();
            if (userConfig == null || !userConfig.isValid()) {
                ServerConfigSynchronizer.getServerUserConfigFromServer(new ServerConfigSynchronizer.ServerUserConfigHandler() { // from class: com.qiniu.android.storage.serverConfig.ServerConfigMonitor.3
                    @Override // com.qiniu.android.storage.serverConfig.ServerConfigSynchronizer.ServerUserConfigHandler
                    public void handle(ServerUserConfig serverUserConfig) {
                        if (serverUserConfig == null) {
                            return;
                        }
                        ServerConfigMonitor.this.handleServerUserConfig(serverUserConfig);
                        ServerConfigMonitor.this.cache.setUserConfig(serverUserConfig);
                        ServerConfigMonitor.this.cache.saveUserConfigToDisk(serverUserConfig);
                    }
                });
            }
        }
    }

    public static void removeConfigCache() {
        configMonitor.cache.removeConfigCache();
    }

    public static void setEnable(boolean z) {
        configMonitor.enable = z;
    }

    public static void setServerHosts(String[] strArr) {
        ServerConfigSynchronizer.setHosts(strArr);
    }

    public static void setToken(String str) {
        ServerConfigSynchronizer.setToken(str);
    }

    public static synchronized void startMonitor() {
        synchronized (ServerConfigMonitor.class) {
            if (configMonitor.enable) {
                TransactionManager transactionManager = TransactionManager.getInstance();
                if (transactionManager.existTransactionsForName(TransactionKey)) {
                    return;
                }
                transactionManager.addTransaction(new TransactionManager.Transaction(TransactionKey, 0, 10, new Runnable() { // from class: com.qiniu.android.storage.serverConfig.ServerConfigMonitor.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ServerConfigMonitor.configMonitor.monitor();
                    }
                }));
            }
        }
    }
}
