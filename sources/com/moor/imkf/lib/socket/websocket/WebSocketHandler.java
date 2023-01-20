package com.moor.imkf.lib.socket.websocket;

import android.content.Context;
import android.content.IntentFilter;
import com.moor.imkf.lib.socket.websocket.dispatcher.ResponseProcessEngine;
import com.moor.imkf.lib.socket.websocket.util.PermissionUtil;
import com.moor.imkf.lib.utils.MoorLogUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class WebSocketHandler {
    private static final String TAG = "WebSocketHandler";
    private static final Object WS_MAP_BLOCK = new HashMap();
    private static WebSocketManager defaultWebSocket;
    private static Map<String, WebSocketManager> mWebSocketMap;
    private static ResponseProcessEngine responseProcessEngine;
    private static WebSocketEngine webSocketEngine;

    private static void checkEngineNullAndInit() {
        if (webSocketEngine == null || responseProcessEngine == null) {
            synchronized (WebSocketHandler.class) {
                if (webSocketEngine == null) {
                    webSocketEngine = new WebSocketEngine();
                }
                if (responseProcessEngine == null) {
                    responseProcessEngine = new ResponseProcessEngine();
                }
            }
        }
    }

    private static void checkWebSocketMapNullAndInit() {
        if (mWebSocketMap == null) {
            synchronized (WS_MAP_BLOCK) {
                if (mWebSocketMap == null) {
                    mWebSocketMap = new HashMap();
                }
            }
        }
    }

    public static Map<String, WebSocketManager> getAllWebSocket() {
        checkWebSocketMapNullAndInit();
        return mWebSocketMap;
    }

    public static WebSocketManager getDefault() {
        return defaultWebSocket;
    }

    public static WebSocketManager getWebSocket(String str) {
        checkWebSocketMapNullAndInit();
        if (mWebSocketMap.containsKey(str)) {
            return mWebSocketMap.get(str);
        }
        return null;
    }

    public static WebSocketManager init(WebSocketSetting webSocketSetting) {
        if (defaultWebSocket == null) {
            synchronized (WebSocketHandler.class) {
                if (webSocketEngine == null) {
                    webSocketEngine = new WebSocketEngine();
                }
                if (responseProcessEngine == null) {
                    responseProcessEngine = new ResponseProcessEngine();
                }
                if (defaultWebSocket == null) {
                    defaultWebSocket = new WebSocketManager(webSocketSetting, webSocketEngine, responseProcessEngine);
                }
            }
        } else {
            MoorLogUtils.d(TAG, "Default WebSocketManager exists!do not start again!");
        }
        return defaultWebSocket;
    }

    public static WebSocketManager initGeneralWebSocket(String str, WebSocketSetting webSocketSetting) {
        checkEngineNullAndInit();
        checkWebSocketMapNullAndInit();
        synchronized (WS_MAP_BLOCK) {
            if (mWebSocketMap.containsKey(str)) {
                MoorLogUtils.d(TAG, "WebSocketManager exists!do not start again!");
                return mWebSocketMap.get(str);
            }
            WebSocketManager webSocketManager = new WebSocketManager(webSocketSetting, webSocketEngine, responseProcessEngine);
            mWebSocketMap.put(str, webSocketManager);
            return webSocketManager;
        }
    }

    public static void registerNetworkChangedReceiver(Context context) {
        if (PermissionUtil.checkPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
            try {
                NetworkChangedReceiver networkChangedReceiver = new NetworkChangedReceiver();
                context.unregisterReceiver(networkChangedReceiver);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                context.registerReceiver(networkChangedReceiver, intentFilter);
                return;
            } catch (Exception e2) {
                MoorLogUtils.d(TAG, "网络监听广播注册失败：", e2);
                return;
            }
        }
        MoorLogUtils.d(TAG, "未获取到网络状态权限，广播监听器无法注册");
    }

    public static WebSocketManager removeWebSocket(String str) {
        checkWebSocketMapNullAndInit();
        if (mWebSocketMap.containsKey(str)) {
            WebSocketManager webSocketManager = mWebSocketMap.get(str);
            synchronized (WS_MAP_BLOCK) {
                mWebSocketMap.remove(str);
            }
            return webSocketManager;
        }
        return null;
    }

    public static void setNull() {
        defaultWebSocket = null;
    }
}
