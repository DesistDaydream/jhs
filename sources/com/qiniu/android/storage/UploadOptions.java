package com.qiniu.android.storage;

import android.os.Looper;
import com.qiniu.android.utils.AndroidNetwork;
import com.qiniu.android.utils.LogUtil;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class UploadOptions {
    public final UpCancellationSignal cancellationSignal;
    public final boolean checkCrc;
    public final Map<String, String> metaDataParam;
    public final String mimeType;
    public final NetReadyHandler netReadyHandler;
    public final Map<String, String> params;
    public final UpProgressHandler progressHandler;

    public UploadOptions(Map<String, String> map, String str, boolean z, UpProgressHandler upProgressHandler, UpCancellationSignal upCancellationSignal) {
        this(map, str, z, upProgressHandler, upCancellationSignal, null);
    }

    public static UploadOptions defaultOptions() {
        return new UploadOptions(null, null, false, null, null);
    }

    private static Map<String, String> filterMetaDataParam(Map<String, String> map) {
        HashMap hashMap = new HashMap();
        if (map == null) {
            return hashMap;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey().startsWith("x-qn-meta-") && entry.getValue() != null && !entry.getValue().equals("")) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return hashMap;
    }

    private static Map<String, String> filterParam(Map<String, String> map) {
        HashMap hashMap = new HashMap();
        if (map == null) {
            return hashMap;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey().startsWith("x:") && entry.getValue() != null && !entry.getValue().equals("")) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return hashMap;
    }

    private static String mime(String str) {
        return (str == null || str.equals("")) ? "application/octet-stream" : str;
    }

    public UploadOptions(Map<String, String> map, String str, boolean z, UpProgressHandler upProgressHandler, UpCancellationSignal upCancellationSignal, NetReadyHandler netReadyHandler) {
        this(map, null, str, z, upProgressHandler, upCancellationSignal, netReadyHandler);
    }

    public UploadOptions(Map<String, String> map, Map<String, String> map2, String str, boolean z, UpProgressHandler upProgressHandler, UpCancellationSignal upCancellationSignal, NetReadyHandler netReadyHandler) {
        final int i2 = 6;
        try {
            String str2 = map.get("netCheckTime");
            if (str2 != null) {
                i2 = Integer.parseInt(str2);
            }
        } catch (Exception unused) {
        }
        this.params = filterParam(map);
        this.metaDataParam = filterMetaDataParam(map2);
        this.mimeType = mime(str);
        this.checkCrc = z;
        this.progressHandler = upProgressHandler == null ? new UpProgressHandler() { // from class: com.qiniu.android.storage.UploadOptions.1
            @Override // com.qiniu.android.storage.UpProgressHandler
            public void progress(String str3, double d2) {
                LogUtil.d("" + d2);
            }
        } : upProgressHandler;
        this.cancellationSignal = upCancellationSignal == null ? new UpCancellationSignal() { // from class: com.qiniu.android.storage.UploadOptions.2
            @Override // com.qiniu.android.http.CancellationHandler
            public boolean isCancelled() {
                return false;
            }
        } : upCancellationSignal;
        this.netReadyHandler = netReadyHandler == null ? new NetReadyHandler() { // from class: com.qiniu.android.storage.UploadOptions.3
            @Override // com.qiniu.android.storage.NetReadyHandler
            public void waitReady() {
                if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                    return;
                }
                for (int i3 = 0; i3 < i2; i3++) {
                    try {
                        Thread.sleep(500L);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                    if (AndroidNetwork.isNetWorkReady()) {
                        return;
                    }
                }
            }
        } : netReadyHandler;
    }
}
