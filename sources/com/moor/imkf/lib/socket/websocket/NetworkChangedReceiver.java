package com.moor.imkf.lib.socket.websocket;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.moor.imkf.lib.socket.websocket.util.PermissionUtil;
import com.moor.imkf.lib.utils.MoorLogUtils;
import java.util.Map;

/* loaded from: classes2.dex */
public class NetworkChangedReceiver extends BroadcastReceiver {
    private static final String TAG = "WSNetworkReceiver";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction()) || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return;
        }
        try {
            if (!PermissionUtil.checkPermission(context, "android.permission.ACCESS_NETWORK_STATE") || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return;
            }
            if (activeNetworkInfo.isConnected()) {
                if (activeNetworkInfo.getType() == 1) {
                    MoorLogUtils.d(TAG, "网络连接发生变化，当前WiFi连接可用，正在尝试重连。");
                } else if (activeNetworkInfo.getType() == 0) {
                    MoorLogUtils.d(TAG, "网络连接发生变化，当前移动连接可用，正在尝试重连。");
                }
                if (WebSocketHandler.getDefault() != null && WebSocketHandler.getDefault().getSetting().reconnectWithNetworkChanged()) {
                    WebSocketHandler.getDefault().reconnect();
                }
                if (WebSocketHandler.getAllWebSocket().isEmpty()) {
                    return;
                }
                Map<String, WebSocketManager> allWebSocket = WebSocketHandler.getAllWebSocket();
                for (String str : allWebSocket.keySet()) {
                    WebSocketManager webSocketManager = allWebSocket.get(str);
                    if (webSocketManager != null && webSocketManager.getSetting().reconnectWithNetworkChanged()) {
                        webSocketManager.reconnect();
                    }
                }
                return;
            }
            MoorLogUtils.d(TAG, "当前没有可用网络");
        } catch (Exception e2) {
            MoorLogUtils.d(TAG, "网络状态获取错误", e2);
        }
    }
}
