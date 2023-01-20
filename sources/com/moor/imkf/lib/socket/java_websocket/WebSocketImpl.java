package com.moor.imkf.lib.socket.java_websocket;

import androidx.annotation.RequiresApi;
import com.moor.imkf.lib.socket.java_websocket.drafts.Draft;
import com.moor.imkf.lib.socket.java_websocket.drafts.Draft_6455;
import com.moor.imkf.lib.socket.java_websocket.enums.CloseHandshakeType;
import com.moor.imkf.lib.socket.java_websocket.enums.HandshakeState;
import com.moor.imkf.lib.socket.java_websocket.enums.Opcode;
import com.moor.imkf.lib.socket.java_websocket.enums.ReadyState;
import com.moor.imkf.lib.socket.java_websocket.enums.Role;
import com.moor.imkf.lib.socket.java_websocket.exceptions.IncompleteHandshakeException;
import com.moor.imkf.lib.socket.java_websocket.exceptions.InvalidDataException;
import com.moor.imkf.lib.socket.java_websocket.exceptions.InvalidHandshakeException;
import com.moor.imkf.lib.socket.java_websocket.exceptions.LimitExceededException;
import com.moor.imkf.lib.socket.java_websocket.exceptions.WebsocketNotConnectedException;
import com.moor.imkf.lib.socket.java_websocket.framing.CloseFrame;
import com.moor.imkf.lib.socket.java_websocket.framing.Framedata;
import com.moor.imkf.lib.socket.java_websocket.framing.PingFrame;
import com.moor.imkf.lib.socket.java_websocket.handshake.ClientHandshake;
import com.moor.imkf.lib.socket.java_websocket.handshake.ClientHandshakeBuilder;
import com.moor.imkf.lib.socket.java_websocket.handshake.Handshakedata;
import com.moor.imkf.lib.socket.java_websocket.handshake.ServerHandshake;
import com.moor.imkf.lib.socket.java_websocket.interfaces.ISSLChannel;
import com.moor.imkf.lib.socket.java_websocket.logger.Logger;
import com.moor.imkf.lib.socket.java_websocket.logger.LoggerFactory;
import com.moor.imkf.lib.socket.java_websocket.protocols.IProtocol;
import com.moor.imkf.lib.socket.java_websocket.server.WebSocketServer;
import com.moor.imkf.lib.socket.java_websocket.util.Charsetfunctions;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import javax.net.ssl.SSLSession;

/* loaded from: classes2.dex */
public class WebSocketImpl implements WebSocket {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int DEFAULT_PORT = 80;
    public static final int DEFAULT_WSS_PORT = 443;
    public static final int RCVBUF = 16384;
    private Object attachment;
    private ByteChannel channel;
    private Integer closecode;
    private Boolean closedremotely;
    private String closemessage;
    private Draft draft;
    private boolean flushandclosestate;
    private ClientHandshake handshakerequest;
    public final BlockingQueue<ByteBuffer> inQueue;
    private SelectionKey key;
    private List<Draft> knownDrafts;
    private long lastPong;
    private final Logger log;
    public final BlockingQueue<ByteBuffer> outQueue;
    private volatile ReadyState readyState;
    private String resourceDescriptor;
    private Role role;
    private final Object synchronizeWriteObject;
    private ByteBuffer tmpHandshakeBytes;
    private WebSocketServer.WebSocketWorker workerThread;
    private final WebSocketListener wsl;

    public WebSocketImpl(WebSocketListener webSocketListener, List<Draft> list) {
        this(webSocketListener, (Draft) null);
        this.role = Role.SERVER;
        if (list != null && !list.isEmpty()) {
            this.knownDrafts = list;
            return;
        }
        ArrayList arrayList = new ArrayList();
        this.knownDrafts = arrayList;
        arrayList.add(new Draft_6455());
    }

    private void closeConnectionDueToInternalServerError(RuntimeException runtimeException) {
        write(generateHttpResponseDueToError(500));
        flushAndClose(-1, runtimeException.getMessage(), false);
    }

    private void closeConnectionDueToWrongHandshake(InvalidDataException invalidDataException) {
        write(generateHttpResponseDueToError(404));
        flushAndClose(invalidDataException.getCloseCode(), invalidDataException.getMessage(), false);
    }

    private void decodeFrames(ByteBuffer byteBuffer) {
        try {
            for (Framedata framedata : this.draft.translateFrame(byteBuffer)) {
                this.log.trace("matched frame: {}", framedata);
                this.draft.processFrame(this, framedata);
            }
        } catch (LimitExceededException e2) {
            if (e2.getLimit() == Integer.MAX_VALUE) {
                this.log.error("Closing due to invalid size of frame", e2);
                this.wsl.onWebsocketError(this, e2);
            }
            close(e2);
        } catch (InvalidDataException e3) {
            this.log.error("Closing due to invalid data in frame", e3);
            this.wsl.onWebsocketError(this, e3);
            close(e3);
        }
    }

    @RequiresApi(api = 19)
    private boolean decodeHandshake(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2;
        Role role;
        Handshakedata translateHandshake;
        if (this.tmpHandshakeBytes.capacity() == 0) {
            byteBuffer2 = byteBuffer;
        } else {
            if (this.tmpHandshakeBytes.remaining() < byteBuffer.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(this.tmpHandshakeBytes.capacity() + byteBuffer.remaining());
                this.tmpHandshakeBytes.flip();
                allocate.put(this.tmpHandshakeBytes);
                this.tmpHandshakeBytes = allocate;
            }
            this.tmpHandshakeBytes.put(byteBuffer);
            this.tmpHandshakeBytes.flip();
            byteBuffer2 = this.tmpHandshakeBytes;
        }
        byteBuffer2.mark();
        try {
            try {
                role = this.role;
            } catch (InvalidHandshakeException e2) {
                this.log.trace("Closing due to invalid handshake", e2);
                close(e2);
            }
        } catch (IncompleteHandshakeException e3) {
            if (this.tmpHandshakeBytes.capacity() == 0) {
                byteBuffer2.reset();
                int preferredSize = e3.getPreferredSize();
                if (preferredSize == 0) {
                    preferredSize = byteBuffer2.capacity() + 16;
                }
                ByteBuffer allocate2 = ByteBuffer.allocate(preferredSize);
                this.tmpHandshakeBytes = allocate2;
                allocate2.put(byteBuffer);
            } else {
                ByteBuffer byteBuffer3 = this.tmpHandshakeBytes;
                byteBuffer3.position(byteBuffer3.limit());
                ByteBuffer byteBuffer4 = this.tmpHandshakeBytes;
                byteBuffer4.limit(byteBuffer4.capacity());
            }
        }
        if (role == Role.SERVER) {
            Draft draft = this.draft;
            if (draft == null) {
                for (Draft draft2 : this.knownDrafts) {
                    Draft copyInstance = draft2.copyInstance();
                    try {
                        copyInstance.setParseMode(this.role);
                        byteBuffer2.reset();
                        translateHandshake = copyInstance.translateHandshake(byteBuffer2);
                    } catch (InvalidHandshakeException unused) {
                    }
                    if (!(translateHandshake instanceof ClientHandshake)) {
                        this.log.trace("Closing due to wrong handshake");
                        closeConnectionDueToWrongHandshake(new InvalidDataException(1002, "wrong http function"));
                        return false;
                    }
                    ClientHandshake clientHandshake = (ClientHandshake) translateHandshake;
                    if (copyInstance.acceptHandshakeAsServer(clientHandshake) == HandshakeState.MATCHED) {
                        this.resourceDescriptor = clientHandshake.getResourceDescriptor();
                        try {
                            write(copyInstance.createHandshake(copyInstance.postProcessHandshakeResponseAsServer(clientHandshake, this.wsl.onWebsocketHandshakeReceivedAsServer(this, copyInstance, clientHandshake))));
                            this.draft = copyInstance;
                            open(clientHandshake);
                            return true;
                        } catch (InvalidDataException e4) {
                            this.log.trace("Closing due to wrong handshake. Possible handshake rejection", e4);
                            closeConnectionDueToWrongHandshake(e4);
                            return false;
                        } catch (RuntimeException e5) {
                            this.log.error("Closing due to internal server error", e5);
                            this.wsl.onWebsocketError(this, e5);
                            closeConnectionDueToInternalServerError(e5);
                            return false;
                        }
                    }
                }
                if (this.draft == null) {
                    this.log.trace("Closing due to protocol error: no draft matches");
                    closeConnectionDueToWrongHandshake(new InvalidDataException(1002, "no draft matches"));
                }
                return false;
            }
            Handshakedata translateHandshake2 = draft.translateHandshake(byteBuffer2);
            if (!(translateHandshake2 instanceof ClientHandshake)) {
                this.log.trace("Closing due to protocol error: wrong http function");
                flushAndClose(1002, "wrong http function", false);
                return false;
            }
            ClientHandshake clientHandshake2 = (ClientHandshake) translateHandshake2;
            if (this.draft.acceptHandshakeAsServer(clientHandshake2) == HandshakeState.MATCHED) {
                open(clientHandshake2);
                return true;
            }
            this.log.trace("Closing due to protocol error: the handshake did finally not match");
            close(1002, "the handshake did finally not match");
            return false;
        }
        if (role == Role.CLIENT) {
            this.draft.setParseMode(role);
            Handshakedata translateHandshake3 = this.draft.translateHandshake(byteBuffer2);
            if (!(translateHandshake3 instanceof ServerHandshake)) {
                this.log.trace("Closing due to protocol error: wrong http function");
                flushAndClose(1002, "wrong http function", false);
                return false;
            }
            ServerHandshake serverHandshake = (ServerHandshake) translateHandshake3;
            if (this.draft.acceptHandshakeAsClient(this.handshakerequest, serverHandshake) == HandshakeState.MATCHED) {
                try {
                    this.wsl.onWebsocketHandshakeReceivedAsClient(this, this.handshakerequest, serverHandshake);
                    open(serverHandshake);
                    return true;
                } catch (InvalidDataException e6) {
                    this.log.trace("Closing due to invalid data exception. Possible handshake rejection", e6);
                    flushAndClose(e6.getCloseCode(), e6.getMessage(), false);
                    return false;
                } catch (RuntimeException e7) {
                    this.log.error("Closing since client was never connected", e7);
                    this.wsl.onWebsocketError(this, e7);
                    flushAndClose(-1, e7.getMessage(), false);
                    return false;
                }
            }
            this.log.trace("Closing due to protocol error: draft {} refuses handshake", this.draft);
            close(1002, "draft " + this.draft + " refuses handshake");
        }
        return false;
    }

    @RequiresApi(api = 19)
    private ByteBuffer generateHttpResponseDueToError(int i2) {
        String str = i2 != 404 ? "500 Internal Server Error" : "404 WebSocket Upgrade Failure";
        return ByteBuffer.wrap(Charsetfunctions.asciiBytes("HTTP/1.1 " + str + "\r\nContent-Type: text/html\r\nServer: TooTallNate Java-WebSocket\r\nContent-Length: " + (str.length() + 48) + "\r\n\r\n<html><head></head><body><h1>" + str + "</h1></body></html>"));
    }

    private void open(Handshakedata handshakedata) {
        this.log.trace("open using draft: {}", this.draft);
        this.readyState = ReadyState.OPEN;
        try {
            this.wsl.onWebsocketOpen(this, handshakedata);
        } catch (RuntimeException e2) {
            this.wsl.onWebsocketError(this, e2);
        }
    }

    private void write(ByteBuffer byteBuffer) {
        this.log.trace("write({}): {}", Integer.valueOf(byteBuffer.remaining()), byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array()));
        this.outQueue.add(byteBuffer);
        this.wsl.onWriteDemand(this);
    }

    public synchronized void close(int i2, String str, boolean z) {
        ReadyState readyState = this.readyState;
        ReadyState readyState2 = ReadyState.CLOSING;
        if (readyState == readyState2 || this.readyState == ReadyState.CLOSED) {
            return;
        }
        if (this.readyState == ReadyState.OPEN) {
            if (i2 == 1006) {
                this.readyState = readyState2;
                flushAndClose(i2, str, false);
                return;
            }
            if (this.draft.getCloseHandshakeType() != CloseHandshakeType.NONE) {
                if (!z) {
                    try {
                        try {
                            this.wsl.onWebsocketCloseInitiated(this, i2, str);
                        } catch (InvalidDataException e2) {
                            this.log.error("generated frame is invalid", e2);
                            this.wsl.onWebsocketError(this, e2);
                            flushAndClose(1006, "generated frame is invalid", false);
                        }
                    } catch (RuntimeException e3) {
                        this.wsl.onWebsocketError(this, e3);
                    }
                }
                if (isOpen()) {
                    CloseFrame closeFrame = new CloseFrame();
                    closeFrame.setReason(str);
                    closeFrame.setCode(i2);
                    closeFrame.isValid();
                    sendFrame(closeFrame);
                }
            }
            flushAndClose(i2, str, z);
        } else if (i2 == -3) {
            flushAndClose(-3, str, true);
        } else if (i2 == 1002) {
            flushAndClose(i2, str, z);
        } else {
            flushAndClose(-1, str, false);
        }
        this.readyState = ReadyState.CLOSING;
        this.tmpHandshakeBytes = null;
    }

    public synchronized void closeConnection(int i2, String str, boolean z) {
        if (this.readyState == ReadyState.CLOSED) {
            return;
        }
        if (this.readyState == ReadyState.OPEN && i2 == 1006) {
            this.readyState = ReadyState.CLOSING;
        }
        SelectionKey selectionKey = this.key;
        if (selectionKey != null) {
            selectionKey.cancel();
        }
        ByteChannel byteChannel = this.channel;
        if (byteChannel != null) {
            try {
                byteChannel.close();
            } catch (IOException e2) {
                if (e2.getMessage() != null && e2.getMessage().equals("Broken pipe")) {
                    this.log.trace("Caught IOException: Broken pipe during closeConnection()", e2);
                } else {
                    this.log.error("Exception during channel.close()", e2);
                    this.wsl.onWebsocketError(this, e2);
                }
            }
        }
        try {
            this.wsl.onWebsocketClose(this, i2, str, z);
        } catch (RuntimeException e3) {
            this.wsl.onWebsocketError(this, e3);
        }
        Draft draft = this.draft;
        if (draft != null) {
            draft.reset();
        }
        this.handshakerequest = null;
        this.readyState = ReadyState.CLOSED;
    }

    @RequiresApi(api = 19)
    public void decode(ByteBuffer byteBuffer) {
        this.log.trace("process({}): ({})", Integer.valueOf(byteBuffer.remaining()), byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array(), byteBuffer.position(), byteBuffer.remaining()));
        if (this.readyState != ReadyState.NOT_YET_CONNECTED) {
            if (this.readyState == ReadyState.OPEN) {
                decodeFrames(byteBuffer);
            }
        } else if (!decodeHandshake(byteBuffer) || isClosing() || isClosed()) {
        } else {
            if (byteBuffer.hasRemaining()) {
                decodeFrames(byteBuffer);
            } else if (this.tmpHandshakeBytes.hasRemaining()) {
                decodeFrames(this.tmpHandshakeBytes);
            }
        }
    }

    public void eot() {
        if (this.readyState == ReadyState.NOT_YET_CONNECTED) {
            closeConnection(-1, true);
        } else if (this.flushandclosestate) {
            closeConnection(this.closecode.intValue(), this.closemessage, this.closedremotely.booleanValue());
        } else if (this.draft.getCloseHandshakeType() == CloseHandshakeType.NONE) {
            closeConnection(1000, true);
        } else if (this.draft.getCloseHandshakeType() == CloseHandshakeType.ONEWAY) {
            if (this.role == Role.SERVER) {
                closeConnection(1006, true);
            } else {
                closeConnection(1000, true);
            }
        } else {
            closeConnection(1006, true);
        }
    }

    public synchronized void flushAndClose(int i2, String str, boolean z) {
        if (this.flushandclosestate) {
            return;
        }
        this.closecode = Integer.valueOf(i2);
        this.closemessage = str;
        this.closedremotely = Boolean.valueOf(z);
        this.flushandclosestate = true;
        this.wsl.onWriteDemand(this);
        try {
            this.wsl.onWebsocketClosing(this, i2, str, z);
        } catch (RuntimeException e2) {
            this.log.error("Exception in onWebsocketClosing", e2);
            this.wsl.onWebsocketError(this, e2);
        }
        Draft draft = this.draft;
        if (draft != null) {
            draft.reset();
        }
        this.handshakerequest = null;
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.WebSocket
    public <T> T getAttachment() {
        return (T) this.attachment;
    }

    public ByteChannel getChannel() {
        return this.channel;
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.WebSocket
    public Draft getDraft() {
        return this.draft;
    }

    public long getLastPong() {
        return this.lastPong;
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.WebSocket
    public InetSocketAddress getLocalSocketAddress() {
        return this.wsl.getLocalSocketAddress(this);
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.WebSocket
    public IProtocol getProtocol() {
        Draft draft = this.draft;
        if (draft == null) {
            return null;
        }
        if (draft instanceof Draft_6455) {
            return ((Draft_6455) draft).getProtocol();
        }
        throw new IllegalArgumentException("This draft does not support Sec-WebSocket-Protocol");
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.WebSocket
    public ReadyState getReadyState() {
        return this.readyState;
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.WebSocket
    public InetSocketAddress getRemoteSocketAddress() {
        return this.wsl.getRemoteSocketAddress(this);
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.WebSocket
    public String getResourceDescriptor() {
        return this.resourceDescriptor;
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.WebSocket
    public SSLSession getSSLSession() {
        if (hasSSLSupport()) {
            return ((ISSLChannel) this.channel).getSSLEngine().getSession();
        }
        throw new IllegalArgumentException("This websocket uses ws instead of wss. No SSLSession available.");
    }

    public SelectionKey getSelectionKey() {
        return this.key;
    }

    public WebSocketListener getWebSocketListener() {
        return this.wsl;
    }

    public WebSocketServer.WebSocketWorker getWorkerThread() {
        return this.workerThread;
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.WebSocket
    public boolean hasBufferedData() {
        return !this.outQueue.isEmpty();
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.WebSocket
    public boolean hasSSLSupport() {
        return this.channel instanceof ISSLChannel;
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.WebSocket
    public boolean isClosed() {
        return this.readyState == ReadyState.CLOSED;
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.WebSocket
    public boolean isClosing() {
        return this.readyState == ReadyState.CLOSING;
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.WebSocket
    public boolean isFlushAndClose() {
        return this.flushandclosestate;
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.WebSocket
    public boolean isOpen() {
        return this.readyState == ReadyState.OPEN;
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.WebSocket
    public void send(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
        send(this.draft.createFrames(str, this.role == Role.CLIENT));
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.WebSocket
    public void sendFragmentedFrame(Opcode opcode, ByteBuffer byteBuffer, boolean z) {
        send(this.draft.continuousFrame(opcode, byteBuffer, z));
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.WebSocket
    public void sendFrame(Collection<Framedata> collection) {
        send(collection);
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.WebSocket
    public void sendPing() throws NullPointerException {
        PingFrame onPreparePing = this.wsl.onPreparePing(this);
        Objects.requireNonNull(onPreparePing, "onPreparePing(WebSocket) returned null. PingFrame to sent can't be null.");
        sendFrame(onPreparePing);
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.WebSocket
    public <T> void setAttachment(T t) {
        this.attachment = t;
    }

    public void setChannel(ByteChannel byteChannel) {
        this.channel = byteChannel;
    }

    public void setSelectionKey(SelectionKey selectionKey) {
        this.key = selectionKey;
    }

    public void setWorkerThread(WebSocketServer.WebSocketWorker webSocketWorker) {
        this.workerThread = webSocketWorker;
    }

    public void startHandshake(ClientHandshakeBuilder clientHandshakeBuilder) throws InvalidHandshakeException {
        this.handshakerequest = this.draft.postProcessHandshakeRequestAsClient(clientHandshakeBuilder);
        this.resourceDescriptor = clientHandshakeBuilder.getResourceDescriptor();
        try {
            this.wsl.onWebsocketHandshakeSentAsClient(this, this.handshakerequest);
            write(this.draft.createHandshake(this.handshakerequest));
        } catch (InvalidDataException unused) {
            throw new InvalidHandshakeException("Handshake data rejected by client.");
        } catch (RuntimeException e2) {
            this.log.error("Exception in startHandshake", e2);
            this.wsl.onWebsocketError(this, e2);
            throw new InvalidHandshakeException("rejected because of " + e2);
        }
    }

    public String toString() {
        return super.toString();
    }

    public void updateLastPong() {
        this.lastPong = System.nanoTime();
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.WebSocket
    public void sendFrame(Framedata framedata) {
        send(Collections.singletonList(framedata));
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.WebSocket
    public void send(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
        send(this.draft.createFrames(byteBuffer, this.role == Role.CLIENT));
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.WebSocket
    public void send(byte[] bArr) {
        send(ByteBuffer.wrap(bArr));
    }

    private void send(Collection<Framedata> collection) {
        if (!isOpen()) {
            throw new WebsocketNotConnectedException();
        }
        if (collection != null) {
            ArrayList arrayList = new ArrayList();
            for (Framedata framedata : collection) {
                this.log.trace("send frame: {}", framedata);
                arrayList.add(this.draft.createBinaryFrame(framedata));
            }
            write(arrayList);
            return;
        }
        throw new IllegalArgumentException();
    }

    private void write(List<ByteBuffer> list) {
        synchronized (this.synchronizeWriteObject) {
            for (ByteBuffer byteBuffer : list) {
                write(byteBuffer);
            }
        }
    }

    public WebSocketImpl(WebSocketListener webSocketListener, Draft draft) {
        this.log = LoggerFactory.getLogger(WebSocketImpl.class);
        this.flushandclosestate = false;
        this.readyState = ReadyState.NOT_YET_CONNECTED;
        this.draft = null;
        this.tmpHandshakeBytes = ByteBuffer.allocate(0);
        this.handshakerequest = null;
        this.closemessage = null;
        this.closecode = null;
        this.closedremotely = null;
        this.resourceDescriptor = null;
        this.lastPong = System.nanoTime();
        this.synchronizeWriteObject = new Object();
        if (webSocketListener != null && (draft != null || this.role != Role.SERVER)) {
            this.outQueue = new LinkedBlockingQueue();
            this.inQueue = new LinkedBlockingQueue();
            this.wsl = webSocketListener;
            this.role = Role.CLIENT;
            if (draft != null) {
                this.draft = draft.copyInstance();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("parameters must not be null");
    }

    public void closeConnection(int i2, boolean z) {
        closeConnection(i2, "", z);
    }

    public void closeConnection() {
        if (this.closedremotely != null) {
            closeConnection(this.closecode.intValue(), this.closemessage, this.closedremotely.booleanValue());
            return;
        }
        throw new IllegalStateException("this method must be used in conjunction with flushAndClose");
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.WebSocket
    public void closeConnection(int i2, String str) {
        closeConnection(i2, str, false);
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.WebSocket
    public void close(int i2, String str) {
        close(i2, str, false);
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.WebSocket
    public void close(int i2) {
        close(i2, "", false);
    }

    public void close(InvalidDataException invalidDataException) {
        close(invalidDataException.getCloseCode(), invalidDataException.getMessage(), false);
    }

    @Override // com.moor.imkf.lib.socket.java_websocket.WebSocket
    public void close() {
        close(1000);
    }
}
