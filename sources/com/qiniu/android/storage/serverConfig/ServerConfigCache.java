package com.qiniu.android.storage.serverConfig;

import com.qiniu.android.storage.FileRecorder;
import com.qiniu.android.storage.Recorder;
import com.qiniu.android.utils.Utils;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ServerConfigCache {
    private static String kServerConfigDiskKey = "ServerConfig:v1.0.0";
    private static String kServerUserConfigDiskKey = "ServerUserConfig:v1.0.0";
    private ServerConfig config;
    private Recorder recorder;
    private ServerUserConfig userConfig;

    private void setupRecorder() {
        if (this.recorder == null) {
            try {
                this.recorder = new FileRecorder(Utils.sdkDirectory() + "/ServerConfig");
            } catch (Exception unused) {
            }
        }
    }

    public synchronized ServerConfig getConfig() {
        return this.config;
    }

    public ServerConfig getConfigFromDisk() {
        byte[] bArr;
        synchronized (this) {
            setupRecorder();
            bArr = this.recorder.get(kServerConfigDiskKey);
        }
        if (bArr == null) {
            return null;
        }
        try {
            return new ServerConfig(new JSONObject(new String(bArr)));
        } catch (Exception unused) {
            synchronized (this) {
                this.recorder.del(kServerConfigDiskKey);
                return null;
            }
        }
    }

    public synchronized ServerUserConfig getUserConfig() {
        return this.userConfig;
    }

    public ServerUserConfig getUserConfigFromDisk() {
        byte[] bArr;
        synchronized (this) {
            setupRecorder();
            bArr = this.recorder.get(kServerUserConfigDiskKey);
        }
        if (bArr == null) {
            return null;
        }
        try {
            return new ServerUserConfig(new JSONObject(new String(bArr)));
        } catch (Exception unused) {
            synchronized (this) {
                this.recorder.del(kServerUserConfigDiskKey);
                return null;
            }
        }
    }

    public synchronized void removeConfigCache() {
        setupRecorder();
        setConfig(null);
        setUserConfig(null);
        this.recorder.del(kServerConfigDiskKey);
        this.recorder.del(kServerUserConfigDiskKey);
    }

    public void saveConfigToDisk(ServerConfig serverConfig) {
        if (serverConfig == null || serverConfig.getInfo() == null) {
            return;
        }
        synchronized (this) {
            setupRecorder();
            this.recorder.set(kServerConfigDiskKey, serverConfig.getInfo().toString().getBytes());
        }
    }

    public void saveUserConfigToDisk(ServerUserConfig serverUserConfig) {
        if (serverUserConfig == null || serverUserConfig.getInfo() == null) {
            return;
        }
        synchronized (this) {
            setupRecorder();
            this.recorder.set(kServerUserConfigDiskKey, serverUserConfig.getInfo().toString().getBytes());
        }
    }

    public synchronized void setConfig(ServerConfig serverConfig) {
        this.config = serverConfig;
    }

    public synchronized void setUserConfig(ServerUserConfig serverUserConfig) {
        this.userConfig = serverUserConfig;
    }
}
