package com.qiniu.android.http.networkStatus;

import com.qiniu.android.http.request.IUploadServer;

/* loaded from: classes3.dex */
public class UploadServerNetworkStatus {
    public static IUploadServer getBetterNetworkServer(IUploadServer iUploadServer, IUploadServer iUploadServer2) {
        return isServerNetworkBetter(iUploadServer, iUploadServer2) ? iUploadServer : iUploadServer2;
    }

    public static boolean isServerNetworkBetter(IUploadServer iUploadServer, IUploadServer iUploadServer2) {
        if (iUploadServer == null) {
            return false;
        }
        if (iUploadServer2 == null) {
            return true;
        }
        String networkStatusType = NetworkStatusManager.getNetworkStatusType(iUploadServer.getHost(), iUploadServer.getIp());
        String networkStatusType2 = NetworkStatusManager.getNetworkStatusType(iUploadServer2.getHost(), iUploadServer2.getIp());
        if (networkStatusType == null) {
            return false;
        }
        if (networkStatusType2 == null) {
            return true;
        }
        return NetworkStatusManager.getInstance().getNetworkStatus(networkStatusType2).getSpeed() < NetworkStatusManager.getInstance().getNetworkStatus(networkStatusType).getSpeed();
    }
}
