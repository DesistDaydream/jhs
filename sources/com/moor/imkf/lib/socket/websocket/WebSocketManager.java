package com.moor.imkf.lib.socket.websocket;

import android.text.TextUtils;
import com.moor.imkf.lib.socket.java_websocket.framing.Framedata;
import com.moor.imkf.lib.socket.java_websocket.framing.PingFrame;
import com.moor.imkf.lib.socket.websocket.ReconnectManager;
import com.moor.imkf.lib.socket.websocket.dispatcher.MainThreadResponseDelivery;
import com.moor.imkf.lib.socket.websocket.dispatcher.ResponseDelivery;
import com.moor.imkf.lib.socket.websocket.dispatcher.ResponseProcessEngine;
import com.moor.imkf.lib.socket.websocket.request.Request;
import com.moor.imkf.lib.socket.websocket.request.RequestFactory;
import com.moor.imkf.lib.socket.websocket.response.ErrorResponse;
import com.moor.imkf.lib.socket.websocket.response.Response;
import com.moor.imkf.lib.socket.websocket.response.ResponseFactory;
import com.moor.imkf.lib.utils.MoorLogUtils;
import java.nio.ByteBuffer;
import java.util.Collection;

/* loaded from: classes2.dex */
public class WebSocketManager {
    private static final String TAG = "WebSocketManager";
    private boolean destroyed = false;
    private boolean disconnect = false;
    private ResponseDelivery mDelivery;
    private ReconnectManager mReconnectManager;
    private ResponseProcessEngine mResponseProcessEngine;
    private WebSocketSetting mSetting;
    private SocketWrapperListener mSocketWrapperListener;
    private WebSocketWrapper mWebSocket;
    private WebSocketEngine mWebSocketEngine;

    public WebSocketManager(WebSocketSetting webSocketSetting, WebSocketEngine webSocketEngine, ResponseProcessEngine responseProcessEngine) {
        this.mSetting = webSocketSetting;
        this.mWebSocketEngine = webSocketEngine;
        this.mResponseProcessEngine = responseProcessEngine;
        ResponseDelivery responseDelivery = webSocketSetting.getResponseDelivery();
        this.mDelivery = responseDelivery;
        if (responseDelivery == null) {
            this.mDelivery = new MainThreadResponseDelivery();
        }
        SocketWrapperListener socketWrapperListener = getSocketWrapperListener();
        this.mSocketWrapperListener = socketWrapperListener;
        if (this.mWebSocket == null) {
            this.mWebSocket = new WebSocketWrapper(this.mSetting, socketWrapperListener);
        }
        start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ReconnectManager getDefaultReconnectManager() {
        return new DefaultReconnectManager(this, new ReconnectManager.OnConnectListener() { // from class: com.moor.imkf.lib.socket.websocket.WebSocketManager.1
            @Override // com.moor.imkf.lib.socket.websocket.ReconnectManager.OnConnectListener
            public void onConnected() {
                MoorLogUtils.dTag(WebSocketManager.TAG, "重连成功");
            }

            @Override // com.moor.imkf.lib.socket.websocket.ReconnectManager.OnConnectListener
            public void onDisconnect() {
                MoorLogUtils.dTag(WebSocketManager.TAG, "重连失败");
                WebSocketManager.this.mSetting.getResponseDispatcher().onDisconnect(WebSocketManager.this.mDelivery);
            }
        });
    }

    private SocketWrapperListener getSocketWrapperListener() {
        return new SocketWrapperListener() { // from class: com.moor.imkf.lib.socket.websocket.WebSocketManager.2
            @Override // com.moor.imkf.lib.socket.websocket.SocketWrapperListener
            public void onConnectFailed(Throwable th) {
                if (WebSocketManager.this.mReconnectManager != null && WebSocketManager.this.mReconnectManager.reconnecting()) {
                    WebSocketManager.this.mReconnectManager.onConnectError(th);
                }
                WebSocketManager.this.mSetting.getResponseDispatcher().onConnectFailed(th, WebSocketManager.this.mDelivery);
            }

            @Override // com.moor.imkf.lib.socket.websocket.SocketWrapperListener
            public void onConnected() {
                if (WebSocketManager.this.mReconnectManager != null) {
                    WebSocketManager.this.mReconnectManager.onConnected();
                }
                WebSocketManager.this.mSetting.getResponseDispatcher().onConnected(WebSocketManager.this.mDelivery);
            }

            @Override // com.moor.imkf.lib.socket.websocket.SocketWrapperListener
            public void onDisconnect() {
                WebSocketManager.this.mSetting.getResponseDispatcher().onDisconnect(WebSocketManager.this.mDelivery);
                if (WebSocketManager.this.mReconnectManager == null || !WebSocketManager.this.mReconnectManager.reconnecting()) {
                    if (WebSocketManager.this.disconnect) {
                        return;
                    }
                    if (WebSocketManager.this.mReconnectManager == null) {
                        WebSocketManager webSocketManager = WebSocketManager.this;
                        webSocketManager.mReconnectManager = webSocketManager.getDefaultReconnectManager();
                    }
                    WebSocketManager.this.mReconnectManager.onConnectError(null);
                    WebSocketManager.this.mReconnectManager.startReconnect();
                } else if (WebSocketManager.this.disconnect) {
                    WebSocketManager.this.mSetting.getResponseDispatcher().onDisconnect(WebSocketManager.this.mDelivery);
                } else {
                    WebSocketManager.this.mReconnectManager.onConnectError(null);
                }
            }

            @Override // com.moor.imkf.lib.socket.websocket.SocketWrapperListener
            public void onMessage(Response response) {
                if (!WebSocketManager.this.mSetting.processDataOnBackground()) {
                    response.onResponse(WebSocketManager.this.mSetting.getResponseDispatcher(), WebSocketManager.this.mDelivery);
                } else {
                    WebSocketManager.this.mResponseProcessEngine.onMessageReceive(response, WebSocketManager.this.mSetting.getResponseDispatcher(), WebSocketManager.this.mDelivery);
                }
            }

            @Override // com.moor.imkf.lib.socket.websocket.SocketWrapperListener
            public void onSendDataError(Request request, int i2, Throwable th) {
                ErrorResponse createErrorResponse = ResponseFactory.createErrorResponse();
                createErrorResponse.init(request, i2, th);
                if (!WebSocketManager.this.mSetting.processDataOnBackground()) {
                    WebSocketManager.this.mSetting.getResponseDispatcher().onSendDataError(createErrorResponse, WebSocketManager.this.mDelivery);
                } else {
                    WebSocketManager.this.mResponseProcessEngine.onSendDataError(createErrorResponse, WebSocketManager.this.mSetting.getResponseDispatcher(), WebSocketManager.this.mDelivery);
                }
                if (WebSocketManager.this.disconnect || i2 != 0) {
                    return;
                }
                MoorLogUtils.dTag(WebSocketManager.TAG, "数据发送失败，网络未连接，开始重连。。。");
                WebSocketManager.this.reconnect();
            }
        };
    }

    private void sendRequest(Request request) {
        if (this.destroyed) {
            MoorLogUtils.dTag(TAG, "This WebSocketManager is destroyed!");
        } else {
            this.mWebSocketEngine.sendRequest(this.mWebSocket, request, this.mSocketWrapperListener);
        }
    }

    public WebSocketManager addListener(SocketListener socketListener) {
        this.mDelivery.addListener(socketListener);
        return this;
    }

    public void destroy() {
        this.destroyed = true;
        WebSocketWrapper webSocketWrapper = this.mWebSocket;
        if (webSocketWrapper != null) {
            this.mWebSocketEngine.destroyWebSocket(webSocketWrapper);
            this.mWebSocketEngine = null;
            this.mWebSocket = null;
        }
        ResponseDelivery responseDelivery = this.mDelivery;
        if (responseDelivery != null) {
            if (!responseDelivery.isEmpty()) {
                this.mDelivery.clear();
            }
            this.mDelivery = null;
        }
        ReconnectManager reconnectManager = this.mReconnectManager;
        if (reconnectManager != null) {
            if (reconnectManager.reconnecting()) {
                this.mReconnectManager.stopReconnect();
            }
            this.mReconnectManager = null;
        }
    }

    public WebSocketManager disConnect() {
        this.disconnect = true;
        if (this.destroyed) {
            MoorLogUtils.dTag(TAG, "This WebSocketManager is destroyed!");
            return this;
        }
        if (this.mWebSocket.getConnectState() != 0) {
            this.mWebSocketEngine.disConnect(this.mWebSocket, this.mSocketWrapperListener);
        }
        return this;
    }

    public WebSocketSetting getSetting() {
        return this.mSetting;
    }

    public boolean isConnect() {
        WebSocketWrapper webSocketWrapper = this.mWebSocket;
        return webSocketWrapper != null && webSocketWrapper.getConnectState() == 2;
    }

    public WebSocketManager reconnect() {
        this.disconnect = false;
        if (this.mReconnectManager == null) {
            this.mReconnectManager = getDefaultReconnectManager();
        }
        if (!this.mReconnectManager.reconnecting()) {
            this.mReconnectManager.startReconnect();
        }
        return this;
    }

    public void reconnectOnce() {
        if (this.destroyed) {
            MoorLogUtils.dTag(TAG, "This WebSocketManager is destroyed!");
        } else if (this.mWebSocket.getConnectState() == 0) {
            this.mWebSocketEngine.connect(this.mWebSocket, this.mSocketWrapperListener);
        } else {
            ReconnectManager reconnectManager = this.mReconnectManager;
            if (reconnectManager != null) {
                reconnectManager.onConnected();
            }
            MoorLogUtils.dTag(TAG, "WebSocket 已连接，请勿重试。");
        }
    }

    public WebSocketManager removeListener(SocketListener socketListener) {
        this.mDelivery.removeListener(socketListener);
        return this;
    }

    public void send(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Request<String> createStringRequest = RequestFactory.createStringRequest();
        createStringRequest.setRequestData(str);
        sendRequest(createStringRequest);
    }

    public void sendFrame(Framedata framedata) {
        if (framedata == null) {
            return;
        }
        Request<Framedata> createFrameDataRequest = RequestFactory.createFrameDataRequest();
        createFrameDataRequest.setRequestData(framedata);
        sendRequest(createFrameDataRequest);
    }

    public void sendPing() {
        sendRequest(RequestFactory.createPingRequest());
    }

    public void sendPong() {
        sendRequest(RequestFactory.createPongRequest());
    }

    public void setReconnectManager(ReconnectManager reconnectManager) {
        this.mReconnectManager = reconnectManager;
    }

    public WebSocketManager start() {
        if (this.mWebSocket == null) {
            this.mWebSocket = new WebSocketWrapper(this.mSetting, this.mSocketWrapperListener);
        }
        if (this.mWebSocket.getConnectState() == 0) {
            reconnect();
        }
        return this;
    }

    public void sendPong(PingFrame pingFrame) {
        if (pingFrame == null) {
            return;
        }
        Request<PingFrame> createPongRequest = RequestFactory.createPongRequest();
        createPongRequest.setRequestData(pingFrame);
        sendRequest(createPongRequest);
    }

    public void sendFrame(Collection<Framedata> collection) {
        if (collection == null) {
            return;
        }
        Request<Collection<Framedata>> createCollectionFrameRequest = RequestFactory.createCollectionFrameRequest();
        createCollectionFrameRequest.setRequestData(collection);
        sendRequest(createCollectionFrameRequest);
    }

    public void send(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return;
        }
        Request<byte[]> createByteArrayRequest = RequestFactory.createByteArrayRequest();
        createByteArrayRequest.setRequestData(bArr);
        sendRequest(createByteArrayRequest);
    }

    public WebSocketManager reconnect(WebSocketSetting webSocketSetting) {
        this.disconnect = false;
        if (this.destroyed) {
            MoorLogUtils.dTag(TAG, "This WebSocketManager is destroyed!");
            return this;
        }
        this.mSetting = webSocketSetting;
        WebSocketWrapper webSocketWrapper = this.mWebSocket;
        if (webSocketWrapper != null) {
            webSocketWrapper.destroy();
            this.mWebSocket = null;
        }
        start();
        return this;
    }

    public void send(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return;
        }
        Request<ByteBuffer> createByteBufferRequest = RequestFactory.createByteBufferRequest();
        createByteBufferRequest.setRequestData(byteBuffer);
        sendRequest(createByteBufferRequest);
    }
}
