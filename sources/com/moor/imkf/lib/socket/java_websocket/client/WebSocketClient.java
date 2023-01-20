package com.moor.imkf.lib.socket.java_websocket.client;

import android.os.Build;
import com.moor.imkf.lib.socket.java_websocket.AbstractWebSocket;
import com.moor.imkf.lib.socket.java_websocket.WebSocket;
import com.moor.imkf.lib.socket.java_websocket.WebSocketImpl;
import com.moor.imkf.lib.socket.java_websocket.drafts.Draft;
import com.moor.imkf.lib.socket.java_websocket.drafts.Draft_6455;
import com.moor.imkf.lib.socket.java_websocket.enums.Opcode;
import com.moor.imkf.lib.socket.java_websocket.enums.ReadyState;
import com.moor.imkf.lib.socket.java_websocket.exceptions.InvalidHandshakeException;
import com.moor.imkf.lib.socket.java_websocket.framing.Framedata;
import com.moor.imkf.lib.socket.java_websocket.handshake.HandshakeImpl1Client;
import com.moor.imkf.lib.socket.java_websocket.handshake.Handshakedata;
import com.moor.imkf.lib.socket.java_websocket.handshake.ServerHandshake;
import com.moor.imkf.lib.socket.java_websocket.protocols.IProtocol;
import com.tencent.android.tpns.mqtt.MqttTopic;
import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.URI;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSession;
import k.b.a.a.o.e;

/* loaded from: classes2.dex */
public abstract class WebSocketClient extends AbstractWebSocket implements Runnable, WebSocket {
    private CountDownLatch closeLatch;
    private CountDownLatch connectLatch;
    private Thread connectReadThread;
    private int connectTimeout;
    private DnsResolver dnsResolver;
    private Draft draft;
    private WebSocketImpl engine;
    private Map<String, String> headers;
    private OutputStream ostream;
    private Proxy proxy;
    private Socket socket;
    private SocketFactory socketFactory;
    public URI uri;
    private Thread writeThread;

    /* loaded from: classes2.dex */
    public class WebsocketWriteThread implements Runnable {
        private final WebSocketClient webSocketClient;

        public WebsocketWriteThread(WebSocketClient webSocketClient) {
            WebSocketClient.this = r1;
            this.webSocketClient = webSocketClient;
        }

        private void closeSocket() {
            try {
                if (WebSocketClient.this.socket != null) {
                    WebSocketClient.this.socket.close();
                }
            } catch (IOException e2) {
                WebSocketClient.this.onWebsocketError(this.webSocketClient, e2);
            }
        }

        private void runWriteData() throws IOException {
            while (!Thread.interrupted()) {
                try {
                    ByteBuffer take = WebSocketClient.this.engine.outQueue.take();
                    WebSocketClient.this.ostream.write(take.array(), 0, take.limit());
                    WebSocketClient.this.ostream.flush();
                } catch (InterruptedException unused) {
                    for (ByteBuffer byteBuffer : WebSocketClient.this.engine.outQueue) {
                        WebSocketClient.this.ostream.write(byteBuffer.array(), 0, byteBuffer.limit());
                        WebSocketClient.this.ostream.flush();
                    }
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Thread currentThread = Thread.currentThread();
            currentThread.setName("WebSocketWriteThread-" + Thread.currentThread().getId());
            try {
                try {
                    runWriteData();
                } catch (IOException e2) {
                    WebSocketClient.this.handleIOException(e2);
                }
            } finally {
                closeSocket();
                WebSocketClient.this.writeThread = null;
            }
        }
    }

    public WebSocketClient(URI uri) {
        this(uri, new Draft_6455());
    }

    private int getPort() {
        int port = this.uri.getPort();
        String scheme = this.uri.getScheme();
        if ("wss".equals(scheme)) {
            return port == -1 ? WebSocketImpl.DEFAULT_WSS_PORT : port;
        } else if ("ws".equals(scheme)) {
            if (port == -1) {
                return 80;
            }
            return port;
        } else {
            throw new IllegalArgumentException("unknown scheme: " + scheme);
        }
    }

    public void handleIOException(IOException iOException) {
        if (iOException instanceof SSLException) {
            onError(iOException);
        }
        this.engine.eot();
    }

    private void reset() {
        Thread currentThread = Thread.currentThread();
        if (currentThread != this.writeThread && currentThread != this.connectReadThread) {
            try {
                closeBlocking();
                Thread thread = this.writeThread;
                if (thread != null) {
                    thread.interrupt();
                    this.writeThread = null;
                }
                Thread thread2 = this.connectReadThread;
                if (thread2 != null) {
                    thread2.interrupt();
                    this.connectReadThread = null;
                }
                this.draft.reset();
                Socket socket = this.socket;
                if (socket != null) {
                    socket.close();
                    this.socket = null;
                }
                this.connectLatch = new CountDownLatch(1);
                this.closeLatch = new CountDownLatch(1);
                this.engine = new WebSocketImpl(this, this.draft);
                return;
            } catch (Exception e2) {
                onError(e2);
                this.engine.closeConnection(1006, e2.getMessage());
                return;
            }
        }
        throw new IllegalStateException("You cannot initialize a reconnect out of the websocket thread. Use reconnect in another thread to ensure a successful cleanup.");
    }

    private void sendHandshake() throws InvalidHandshakeException {
        String rawPath = this.uri.getRawPath();
        String rawQuery = this.uri.getRawQuery();
        if (rawPath == null || rawPath.length() == 0) {
            rawPath = MqttTopic.TOPIC_LEVEL_SEPARATOR;
        }
        if (rawQuery != null) {
            rawPath = rawPath + e.a + rawQuery;
        }
        int port = getPort();
        StringBuilder sb = new StringBuilder();
        sb.append(this.uri.getHost());
        sb.append((port == 80 || port == 443) ? "" : Constants.COLON_SEPARATOR + port);
        String sb2 = sb.toString();
        HandshakeImpl1Client handshakeImpl1Client = new HandshakeImpl1Client();
        handshakeImpl1Client.setResourceDescriptor(rawPath);
        handshakeImpl1Client.put("Host", sb2);
        Map<String, String> map = this.headers;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                handshakeImpl1Client.put(entry.getKey(), entry.getValue());
            }
        }
        this.engine.startHandshake(handshakeImpl1Client);
    }

    public void addHeader(String str, String str2) {
        if (this.headers == null) {
            this.headers = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        }
        this.headers.put(str, str2);
    }

    public void clearHeaders() {
        this.headers = null;
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.WebSocket
    public void close() {
        if (this.writeThread != null) {
            this.engine.close(1000);
        }
    }

    public void closeBlocking() throws InterruptedException {
        close();
        this.closeLatch.await();
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.WebSocket
    public void closeConnection(int i2, String str) {
        this.engine.closeConnection(i2, str);
    }

    public void connect() {
        if (this.connectReadThread == null) {
            Thread thread = new Thread(this);
            this.connectReadThread = thread;
            thread.setName("WebSocketConnectReadThread-" + this.connectReadThread.getId());
            this.connectReadThread.start();
            return;
        }
        throw new IllegalStateException("WebSocketClient objects are not reuseable");
    }

    public boolean connectBlocking() throws InterruptedException {
        connect();
        this.connectLatch.await();
        return this.engine.isOpen();
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.WebSocket
    public <T> T getAttachment() {
        return (T) this.engine.getAttachment();
    }

    public WebSocket getConnection() {
        return this.engine;
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.AbstractWebSocket
    public Collection<WebSocket> getConnections() {
        return Collections.singletonList(this.engine);
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.WebSocket
    public Draft getDraft() {
        return this.draft;
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.WebSocketListener
    public InetSocketAddress getLocalSocketAddress(WebSocket webSocket) {
        Socket socket = this.socket;
        if (socket != null) {
            return (InetSocketAddress) socket.getLocalSocketAddress();
        }
        return null;
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.WebSocket
    public IProtocol getProtocol() {
        return this.engine.getProtocol();
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.WebSocket
    public ReadyState getReadyState() {
        return this.engine.getReadyState();
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.WebSocketListener
    public InetSocketAddress getRemoteSocketAddress(WebSocket webSocket) {
        Socket socket = this.socket;
        if (socket != null) {
            return (InetSocketAddress) socket.getRemoteSocketAddress();
        }
        return null;
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.WebSocket
    public String getResourceDescriptor() {
        return this.uri.getPath();
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.WebSocket
    public SSLSession getSSLSession() {
        return this.engine.getSSLSession();
    }

    public Socket getSocket() {
        return this.socket;
    }

    public URI getURI() {
        return this.uri;
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.WebSocket
    public boolean hasBufferedData() {
        return this.engine.hasBufferedData();
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.WebSocket
    public boolean hasSSLSupport() {
        return this.engine.hasSSLSupport();
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.WebSocket
    public boolean isClosed() {
        return this.engine.isClosed();
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.WebSocket
    public boolean isClosing() {
        return this.engine.isClosing();
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.WebSocket
    public boolean isFlushAndClose() {
        return this.engine.isFlushAndClose();
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.WebSocket
    public boolean isOpen() {
        return this.engine.isOpen();
    }

    public abstract void onClose(int i2, String str, boolean z);

    public void onCloseInitiated(int i2, String str) {
    }

    public void onClosing(int i2, String str, boolean z) {
    }

    public abstract void onError(Exception exc);

    public abstract void onMessage(String str);

    public void onMessage(ByteBuffer byteBuffer) {
    }

    public abstract void onOpen(ServerHandshake serverHandshake);

    public void onSetSSLParameters(SSLParameters sSLParameters) {
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                sSLParameters.setEndpointIdentificationAlgorithm("HTTPS");
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.WebSocketListener
    public final void onWebsocketClose(WebSocket webSocket, int i2, String str, boolean z) {
        stopConnectionLostTimer();
        Thread thread = this.writeThread;
        if (thread != null) {
            thread.interrupt();
        }
        onClose(i2, str, z);
        this.connectLatch.countDown();
        this.closeLatch.countDown();
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.WebSocketListener
    public void onWebsocketCloseInitiated(WebSocket webSocket, int i2, String str) {
        onCloseInitiated(i2, str);
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.WebSocketListener
    public void onWebsocketClosing(WebSocket webSocket, int i2, String str, boolean z) {
        onClosing(i2, str, z);
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.WebSocketListener
    public final void onWebsocketError(WebSocket webSocket, Exception exc) {
        onError(exc);
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.WebSocketListener
    public final void onWebsocketMessage(WebSocket webSocket, String str) {
        onMessage(str);
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.WebSocketListener
    public final void onWebsocketOpen(WebSocket webSocket, Handshakedata handshakedata) {
        startConnectionLostTimer();
        onOpen((ServerHandshake) handshakedata);
        this.connectLatch.countDown();
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.WebSocketListener
    public final void onWriteDemand(WebSocket webSocket) {
    }

    public void reconnect() {
        reset();
        connect();
    }

    public boolean reconnectBlocking() throws InterruptedException {
        reset();
        return connectBlocking();
    }

    public String removeHeader(String str) {
        Map<String, String> map = this.headers;
        if (map == null) {
            return null;
        }
        return map.remove(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:73:0x003e A[Catch: InternalError -> 0x00fb, Exception -> 0x012a, TryCatch #4 {Exception -> 0x012a, InternalError -> 0x00fb, blocks: (B:62:0x0001, B:64:0x0007, B:71:0x0024, B:73:0x003e, B:76:0x0059, B:78:0x0067, B:79:0x0086, B:81:0x008c, B:82:0x0098, B:65:0x000e, B:67:0x0012, B:68:0x001d, B:99:0x00f5, B:100:0x00fa), top: B:112:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x008c A[Catch: InternalError -> 0x00fb, Exception -> 0x012a, TryCatch #4 {Exception -> 0x012a, InternalError -> 0x00fb, blocks: (B:62:0x0001, B:64:0x0007, B:71:0x0024, B:73:0x003e, B:76:0x0059, B:78:0x0067, B:79:0x0086, B:81:0x008c, B:82:0x0098, B:65:0x000e, B:67:0x0012, B:68:0x001d, B:99:0x00f5, B:100:0x00fa), top: B:112:0x0001 }] */
    @Override // java.lang.Runnable
    @androidx.annotation.RequiresApi(api = 19)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            Method dump skipped, instructions count: 314
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moor.imkf.lib.socket.java_websocket.client.WebSocketClient.run():void");
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.WebSocket
    public void send(String str) {
        this.engine.send(str);
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.WebSocket
    public void sendFragmentedFrame(Opcode opcode, ByteBuffer byteBuffer, boolean z) {
        this.engine.sendFragmentedFrame(opcode, byteBuffer, z);
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.WebSocket
    public void sendFrame(Framedata framedata) {
        this.engine.sendFrame(framedata);
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.WebSocket
    public void sendPing() {
        this.engine.sendPing();
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.WebSocket
    public <T> void setAttachment(T t) {
        this.engine.setAttachment(t);
    }

    public void setDnsResolver(DnsResolver dnsResolver) {
        this.dnsResolver = dnsResolver;
    }

    public void setProxy(Proxy proxy) {
        if (proxy != null) {
            this.proxy = proxy;
            return;
        }
        throw new IllegalArgumentException();
    }

    @Deprecated
    public void setSocket(Socket socket) {
        if (this.socket == null) {
            this.socket = socket;
            return;
        }
        throw new IllegalStateException("socket has already been set");
    }

    public void setSocketFactory(SocketFactory socketFactory) {
        this.socketFactory = socketFactory;
    }

    public WebSocketClient(URI uri, Draft draft) {
        this(uri, draft, null, 0);
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.WebSocketListener
    public final void onWebsocketMessage(WebSocket webSocket, ByteBuffer byteBuffer) {
        onMessage(byteBuffer);
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.WebSocket
    public void send(byte[] bArr) {
        this.engine.send(bArr);
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.WebSocket
    public void sendFrame(Collection<Framedata> collection) {
        this.engine.sendFrame(collection);
    }

    public WebSocketClient(URI uri, Map<String, String> map) {
        this(uri, new Draft_6455(), map);
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.WebSocket
    public void close(int i2) {
        this.engine.close(i2);
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.WebSocket
    public InetSocketAddress getLocalSocketAddress() {
        return this.engine.getLocalSocketAddress();
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.WebSocket
    public InetSocketAddress getRemoteSocketAddress() {
        return this.engine.getRemoteSocketAddress();
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.WebSocket
    public void send(ByteBuffer byteBuffer) {
        this.engine.send(byteBuffer);
    }

    public WebSocketClient(URI uri, Draft draft, Map<String, String> map) {
        this(uri, draft, map, 0);
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.WebSocket
    public void close(int i2, String str) {
        this.engine.close(i2, str);
    }

    public boolean connectBlocking(long j2, TimeUnit timeUnit) throws InterruptedException {
        connect();
        return this.connectLatch.await(j2, timeUnit) && this.engine.isOpen();
    }

    public WebSocketClient(URI uri, Draft draft, Map<String, String> map, int i2) {
        this.uri = null;
        this.engine = null;
        this.socket = null;
        this.socketFactory = null;
        this.proxy = Proxy.NO_PROXY;
        this.connectLatch = new CountDownLatch(1);
        this.closeLatch = new CountDownLatch(1);
        this.connectTimeout = 0;
        this.dnsResolver = null;
        if (uri == null) {
            throw new IllegalArgumentException();
        }
        if (draft != null) {
            this.uri = uri;
            this.draft = draft;
            this.dnsResolver = new DnsResolver() { // from class: com.moor.imkf.lib.socket.java_websocket.client.WebSocketClient.1
                {
                    WebSocketClient.this = this;
                }

                @Override // com.moor.imkf.lib.socket.java_websocket.client.DnsResolver
                public InetAddress resolve(URI uri2) throws UnknownHostException {
                    return InetAddress.getByName(uri2.getHost());
                }
            };
            if (map != null) {
                TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
                this.headers = treeMap;
                treeMap.putAll(map);
            }
            this.connectTimeout = i2;
            setTcpNoDelay(false);
            setReuseAddr(false);
            this.engine = new WebSocketImpl(this, draft);
            return;
        }
        throw new IllegalArgumentException("null as draft is permitted for `WebSocketServer` only!");
    }
}
