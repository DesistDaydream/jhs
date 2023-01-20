package com.tencent.imsdk.manager;

import com.tencent.imsdk.common.SystemUtil;

/* loaded from: classes3.dex */
public class SDKConfig {
    public long sdkAppId = 0;
    public String sdkInitPath = "";
    public long sdkInstanceType = 0;
    public boolean isTestEnvironment = false;
    public boolean isIPv6Prior = false;
    public String stringUIPlatform = "";
    public int numberUIPlatform = 0;
    public DeviceInfo deviceInfo = new DeviceInfo();
    public NetworkInfo networkInfo = new NetworkInfo();
    public ProxyInfo proxyInfo = new ProxyInfo();
    public LogSetting logSetting = new LogSetting();

    /* loaded from: classes3.dex */
    public static class DeviceInfo {
        public String deviceId = "";
        public String deviceType = "";
        public long deviceBrand = 0;
        public String systemVersion = "";

        public static float onGetAppCpuUsage() {
            return 0.0f;
        }

        public static int onGetAppMemUsage() {
            return 0;
        }

        public static float onGetSysCpuUsage() {
            return 0.0f;
        }
    }

    /* loaded from: classes3.dex */
    public static class LogSetting {
        public boolean enableConsoleLog = true;
        public int logLevel = 0;
        public String logFilePath = "";
    }

    /* loaded from: classes3.dex */
    public static class NetworkInfo {
        public int networkType = 0;
        public int ipType = 1;
        public String networkId = "";
        public boolean networkConnected = false;

        public void clean() {
            this.networkType = 0;
            this.ipType = 1;
            this.networkId = "";
            this.networkConnected = false;
        }
    }

    /* loaded from: classes3.dex */
    public static class ProxyInfo {
        public int proxyType = 0;
        public String proxyHost = "";
        public int proxyPort = 0;
        public String proxyUsername = "";
        public String proxyPassword = "";

        public void clean() {
            this.proxyType = 0;
            this.proxyHost = "";
            this.proxyPort = 0;
            this.proxyUsername = "";
            this.proxyPassword = "";
        }
    }

    public static float getAppCpuUsage() {
        return SystemUtil.getAppCpuUsage();
    }

    public static float getAppMemoryUsage() {
        return SystemUtil.getAppMemory();
    }

    public static float getSysCpuUsage() {
        return SystemUtil.getSysCpuUsage();
    }
}
