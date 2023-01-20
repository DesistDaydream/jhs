package com.moor.imkf.lib.socket.websocket;

import android.text.TextUtils;
import com.moor.imkf.lib.socket.java_websocket.WebSocket;
import com.moor.imkf.lib.socket.java_websocket.client.WebSocketClient;
import com.moor.imkf.lib.socket.java_websocket.drafts.Draft;
import com.moor.imkf.lib.socket.java_websocket.drafts.Draft_6455;
import com.moor.imkf.lib.socket.java_websocket.exceptions.WebsocketNotConnectedException;
import com.moor.imkf.lib.socket.java_websocket.framing.Framedata;
import com.moor.imkf.lib.socket.java_websocket.handshake.ServerHandshake;
import com.moor.imkf.lib.socket.websocket.request.Request;
import com.moor.imkf.lib.socket.websocket.response.Response;
import com.moor.imkf.lib.socket.websocket.response.ResponseFactory;
import com.moor.imkf.lib.utils.MoorLogUtils;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.Map;

/* loaded from: classes2.dex */
public class WebSocketWrapper {
    private static final String TAG = "WSWrapper";
    private WebSocketSetting mSetting;
    private SocketWrapperListener mSocketListener;
    private WebSocketClient mWebSocket;
    private int connectStatus = 0;
    private boolean needClose = false;
    private boolean destroyed = false;

    /* loaded from: classes2.dex */
    public class MyWebSocketClient extends WebSocketClient {
        public MyWebSocketClient(URI uri) {
            super(uri);
        }

        @Override // com.moor.imkf.lib.socket.java_websocket.client.WebSocketClient
        public void onClose(int i2, String str, boolean z) {
            WebSocketWrapper.this.onWSCallbackClose(i2, str, z);
        }

        @Override // com.moor.imkf.lib.socket.java_websocket.client.WebSocketClient
        public void onError(Exception exc) {
            WebSocketWrapper.this.onWSCallbackError(exc);
        }

        @Override // com.moor.imkf.lib.socket.java_websocket.client.WebSocketClient
        public void onMessage(String str) {
            WebSocketWrapper.this.onWSCallbackMessage(str);
        }

        @Override // com.moor.imkf.lib.socket.java_websocket.client.WebSocketClient
        public void onOpen(ServerHandshake serverHandshake) {
            WebSocketWrapper.this.onWSCallbackOpen(serverHandshake);
        }

        @Override // com.moor.imkf.lib.socket.java_websocket.WebSocketAdapter, com.moor.imkf.lib.socket.java_websocket.WebSocketListener
        public void onWebsocketPing(WebSocket webSocket, Framedata framedata) {
            super.onWebsocketPing(webSocket, framedata);
            WebSocketWrapper.this.onWSCallbackWebsocketPing(framedata);
        }

        @Override // com.moor.imkf.lib.socket.java_websocket.WebSocketAdapter, com.moor.imkf.lib.socket.java_websocket.WebSocketListener
        public void onWebsocketPong(WebSocket webSocket, Framedata framedata) {
            super.onWebsocketPong(webSocket, framedata);
            WebSocketWrapper.this.onWSCallbackWebsocketPong(framedata);
        }

        @Override // com.moor.imkf.lib.socket.java_websocket.client.WebSocketClient
        public void onMessage(ByteBuffer byteBuffer) {
            WebSocketWrapper.this.onWSCallbackMessage(byteBuffer);
        }

        public MyWebSocketClient(URI uri, Draft draft) {
            super(uri, draft);
        }

        public MyWebSocketClient(URI uri, Map<String, String> map) {
            super(uri, map);
        }

        public MyWebSocketClient(URI uri, Draft draft, Map<String, String> map) {
            super(uri, draft, map);
        }

        public MyWebSocketClient(URI uri, Draft draft, Map<String, String> map, int i2) {
            super(uri, draft, map, i2);
        }
    }

    public WebSocketWrapper(WebSocketSetting webSocketSetting, SocketWrapperListener socketWrapperListener) {
        this.mSetting = webSocketSetting;
        this.mSocketListener = socketWrapperListener;
    }

    private void checkDestroy() {
        if (this.destroyed) {
            try {
                WebSocketClient webSocketClient = this.mWebSocket;
                if (webSocketClient != null && !webSocketClient.isClosed()) {
                    this.mWebSocket.close();
                }
                releaseResource();
                this.connectStatus = 0;
            } catch (Throwable th) {
                MoorLogUtils.d(TAG, "checkDestroy(WebSocketClient)", th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onWSCallbackClose(int i2, String str, boolean z) {
        this.connectStatus = 0;
        MoorLogUtils.d(TAG, String.format("WebSocket closed!code=%s,reason:%s,remote:%s", Integer.valueOf(i2), str, Boolean.valueOf(z)));
        SocketWrapperListener socketWrapperListener = this.mSocketListener;
        if (socketWrapperListener != null) {
            socketWrapperListener.onDisconnect();
        }
        checkDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onWSCallbackError(Exception exc) {
        if (this.destroyed) {
            checkDestroy();
        } else {
            MoorLogUtils.d(TAG, "WebSocketClient#onError(Exception)", exc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onWSCallbackMessage(String str) {
        if (this.destroyed) {
            checkDestroy();
            return;
        }
        this.connectStatus = 2;
        if (this.mSocketListener != null) {
            Response<String> createTextResponse = ResponseFactory.createTextResponse();
            createTextResponse.setResponseData(str);
            this.mSocketListener.onMessage(createTextResponse);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onWSCallbackOpen(ServerHandshake serverHandshake) {
        if (this.destroyed) {
            checkDestroy();
            return;
        }
        this.connectStatus = 2;
        MoorLogUtils.d(TAG, "WebSocket connect success");
        if (this.needClose) {
            disConnect();
            return;
        }
        SocketWrapperListener socketWrapperListener = this.mSocketListener;
        if (socketWrapperListener != null) {
            socketWrapperListener.onConnected();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onWSCallbackWebsocketPing(Framedata framedata) {
        if (this.destroyed) {
            checkDestroy();
            return;
        }
        this.connectStatus = 2;
        if (this.mSocketListener != null) {
            Response<Framedata> createPingResponse = ResponseFactory.createPingResponse();
            createPingResponse.setResponseData(framedata);
            MoorLogUtils.d(TAG, "WebSocket received ping:" + createPingResponse.toString());
            this.mSocketListener.onMessage(createPingResponse);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onWSCallbackWebsocketPong(Framedata framedata) {
        if (this.destroyed) {
            checkDestroy();
            return;
        }
        this.connectStatus = 2;
        if (this.mSocketListener != null) {
            Response<Framedata> createPongResponse = ResponseFactory.createPongResponse();
            createPongResponse.setResponseData(framedata);
            MoorLogUtils.d(TAG, "WebSocket received pong:" + createPongResponse.toString());
            this.mSocketListener.onMessage(createPongResponse);
        }
    }

    private void releaseResource() {
        if (this.mSocketListener != null) {
            this.mSocketListener = null;
        }
    }

    public void connect() {
        if (this.destroyed) {
            return;
        }
        this.needClose = false;
        if (this.connectStatus == 0) {
            this.connectStatus = 1;
            try {
                if (this.mWebSocket == null) {
                    if (!TextUtils.isEmpty(this.mSetting.getConnectUrl())) {
                        Draft draft = this.mSetting.getDraft();
                        if (draft == null) {
                            draft = new Draft_6455();
                        }
                        Draft draft2 = draft;
                        int connectTimeout = this.mSetting.getConnectTimeout();
                        this.mWebSocket = new MyWebSocketClient(new URI(this.mSetting.getConnectUrl()), draft2, this.mSetting.getHttpHeaders(), connectTimeout <= 0 ? 0 : connectTimeout);
                        MoorLogUtils.d(TAG, "WebSocket start connect...");
                        if (this.mSetting.getProxy() != null) {
                            this.mWebSocket.setProxy(this.mSetting.getProxy());
                        }
                        this.mWebSocket.connect();
                        this.mWebSocket.setConnectionLostTimeout(this.mSetting.getConnectionLostTimeout());
                        if (this.needClose) {
                            disConnect();
                        }
                        checkDestroy();
                        return;
                    }
                    throw new RuntimeException("WebSocket connect url is empty!");
                }
                MoorLogUtils.d(TAG, "WebSocket reconnecting...");
                this.mWebSocket.reconnect();
                if (this.needClose) {
                    disConnect();
                }
                checkDestroy();
            } catch (Throwable th) {
                this.connectStatus = 0;
                MoorLogUtils.d(TAG, "WebSocket connect failed:", th);
                SocketWrapperListener socketWrapperListener = this.mSocketListener;
                if (socketWrapperListener != null) {
                    socketWrapperListener.onConnectFailed(th);
                }
            }
        }
    }

    public void destroy() {
        this.destroyed = true;
        disConnect();
        if (this.connectStatus == 0) {
            this.mWebSocket = null;
        }
        releaseResource();
    }

    public void disConnect() {
        this.needClose = true;
        if (this.connectStatus == 2) {
            MoorLogUtils.d(TAG, "WebSocket disconnecting...");
            WebSocketClient webSocketClient = this.mWebSocket;
            if (webSocketClient != null) {
                webSocketClient.close();
            }
            MoorLogUtils.d(TAG, "WebSocket disconnected");
        }
    }

    public int getConnectState() {
        return this.connectStatus;
    }

    public void reconnect() {
        this.needClose = false;
        if (this.connectStatus == 0) {
            connect();
        }
    }

    public void send(Request request) {
        WebSocketClient webSocketClient = this.mWebSocket;
        if (webSocketClient == null) {
            return;
        }
        if (request == null) {
            MoorLogUtils.d(TAG, "send data is null!");
        } else if (this.connectStatus == 2) {
            try {
                try {
                    request.send(webSocketClient);
                    MoorLogUtils.d(TAG, "send success:" + request.toString());
                } catch (WebsocketNotConnectedException e2) {
                    this.connectStatus = 0;
                    MoorLogUtils.d(TAG, "ws is disconnected, send failed:" + request.toString(), e2);
                    SocketWrapperListener socketWrapperListener = this.mSocketListener;
                    if (socketWrapperListener != null) {
                        socketWrapperListener.onSendDataError(request, 0, e2);
                        this.mSocketListener.onDisconnect();
                    }
                } catch (Throwable th) {
                    this.connectStatus = 0;
                    MoorLogUtils.d(TAG, "Exception,send failed:" + request.toString(), th);
                    SocketWrapperListener socketWrapperListener2 = this.mSocketListener;
                    if (socketWrapperListener2 != null) {
                        socketWrapperListener2.onSendDataError(request, 1, th);
                    }
                }
            } finally {
                request.release();
            }
        } else {
            MoorLogUtils.d(TAG, "WebSocket not connect,send failed:" + request.toString());
            SocketWrapperListener socketWrapperListener3 = this.mSocketListener;
            if (socketWrapperListener3 != null) {
                socketWrapperListener3.onSendDataError(request, 0, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onWSCallbackMessage(ByteBuffer byteBuffer) {
        if (this.destroyed) {
            checkDestroy();
            return;
        }
        this.connectStatus = 2;
        if (this.mSocketListener != null) {
            Response<ByteBuffer> createByteBufferResponse = ResponseFactory.createByteBufferResponse();
            createByteBufferResponse.setResponseData(byteBuffer);
            MoorLogUtils.d(TAG, "WebSocket received message:" + createByteBufferResponse.toString());
            this.mSocketListener.onMessage(createByteBufferResponse);
        }
    }
}
