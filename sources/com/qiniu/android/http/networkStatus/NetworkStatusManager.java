package com.qiniu.android.http.networkStatus;

import com.qiniu.android.storage.FileRecorder;
import com.qiniu.android.storage.Recorder;
import com.qiniu.android.utils.Utils;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class NetworkStatusManager {
    private static String kNetworkStatusDiskKey = "NetworkStatus:v1.0.0";
    private static NetworkStatusManager networkStatusManager = new NetworkStatusManager();
    private ConcurrentHashMap<String, NetworkStatus> networkStatusInfo;
    private Recorder recorder;
    private boolean hasInit = false;
    private boolean isHandlingNetworkInfoOfDisk = false;
    private final ExecutorService executorService = new ThreadPoolExecutor(1, 2, 120, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());

    /* loaded from: classes3.dex */
    public static class NetworkStatus {
        private int speed;

        /* JADX INFO: Access modifiers changed from: private */
        public static NetworkStatus statusFromJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            NetworkStatus networkStatus = new NetworkStatus();
            try {
                networkStatus.speed = jSONObject.getInt("speed");
            } catch (Exception unused) {
            }
            return networkStatus;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("speed", this.speed);
            } catch (Exception unused) {
            }
            return jSONObject;
        }

        public int getSpeed() {
            return this.speed;
        }

        public void setSpeed(int i2) {
            this.speed = i2;
        }
    }

    private void asyncRecordNetworkStatusInfo() {
        synchronized (this) {
            if (this.isHandlingNetworkInfoOfDisk) {
                return;
            }
            this.isHandlingNetworkInfoOfDisk = true;
            this.executorService.submit(new Runnable() { // from class: com.qiniu.android.http.networkStatus.NetworkStatusManager.1
                @Override // java.lang.Runnable
                public void run() {
                    NetworkStatusManager.this.recordNetworkStatusInfo();
                    NetworkStatusManager.this.isHandlingNetworkInfoOfDisk = false;
                }
            });
        }
    }

    private void asyncRecoverNetworkStatusFromDisk() {
        synchronized (this) {
            if (this.isHandlingNetworkInfoOfDisk) {
                return;
            }
            this.isHandlingNetworkInfoOfDisk = true;
            this.executorService.submit(new Runnable() { // from class: com.qiniu.android.http.networkStatus.NetworkStatusManager.2
                @Override // java.lang.Runnable
                public void run() {
                    NetworkStatusManager.this.recoverNetworkStatusFromDisk();
                    NetworkStatusManager.this.isHandlingNetworkInfoOfDisk = true;
                }
            });
        }
    }

    public static NetworkStatusManager getInstance() {
        networkStatusManager.initData();
        return networkStatusManager;
    }

    public static String getNetworkStatusType(String str, String str2) {
        return Utils.getIpType(str2, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void recordNetworkStatusInfo() {
        setupRecorder();
        if (this.recorder == null || this.networkStatusInfo == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        for (String str : this.networkStatusInfo.keySet()) {
            NetworkStatus networkStatus = this.networkStatusInfo.get(str);
            if (networkStatus != null) {
                try {
                    jSONObject.put(str, networkStatus.toJson());
                } catch (Exception unused) {
                }
            }
        }
        this.recorder.set(kNetworkStatusDiskKey, jSONObject.toString().getBytes());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void recoverNetworkStatusFromDisk() {
        setupRecorder();
        Recorder recorder = this.recorder;
        if (recorder == null || this.networkStatusInfo == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(recorder.get(kNetworkStatusDiskKey)));
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    NetworkStatus statusFromJson = NetworkStatus.statusFromJson(jSONObject.getJSONObject(next));
                    if (statusFromJson != null) {
                        this.networkStatusInfo.put(next, statusFromJson);
                    }
                } catch (JSONException unused) {
                }
            }
        } catch (Exception unused2) {
        }
    }

    private synchronized void setupRecorder() {
        if (this.recorder == null) {
            try {
                this.recorder = new FileRecorder(Utils.sdkDirectory() + "/NetworkInfo");
            } catch (Exception unused) {
            }
        }
    }

    public NetworkStatus getNetworkStatus(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        NetworkStatus networkStatus = this.networkStatusInfo.get(str);
        return networkStatus == null ? new NetworkStatus() : networkStatus;
    }

    public synchronized void initData() {
        if (this.hasInit) {
            return;
        }
        networkStatusManager.networkStatusInfo = new ConcurrentHashMap<>();
        networkStatusManager.asyncRecoverNetworkStatusFromDisk();
    }

    public void updateNetworkStatus(String str, int i2) {
        if (str == null || str.length() == 0) {
            return;
        }
        NetworkStatus networkStatus = this.networkStatusInfo.get(str);
        if (networkStatus == null) {
            networkStatus = new NetworkStatus();
            this.networkStatusInfo.put(str, networkStatus);
        }
        networkStatus.setSpeed(i2);
        asyncRecordNetworkStatusInfo();
    }
}
